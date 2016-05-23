package com.shufensoft.crm.biz.service.send.impl;

import com.reasonablespread.service.Campaign;
import com.reasonablespread.service.DoubleOptIn;
import com.reasonablespread.service.Subscriber;
import com.shufensoft.crm.biz.adapter.EmailAdapter;
import com.shufensoft.crm.biz.adapter.SmsAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.constant.SmsConstant;
import com.shufensoft.crm.biz.dao.generation.seller.SellerPackageCountMapper;
import com.shufensoft.crm.biz.dao.generation.seller.SellerPackageDetailMapper;
import com.shufensoft.crm.biz.dao.generation.send.SendDetailMapper;
import com.shufensoft.crm.biz.dao.generation.send.SendPlanMapper;
import com.shufensoft.crm.biz.domain.generation.email.SubscribersReslutInfo;
import com.shufensoft.crm.biz.domain.generation.seller.*;
import com.shufensoft.crm.biz.domain.generation.send.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.market.MarkBizService;
import com.shufensoft.crm.biz.service.send.SendBizService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SellerPackageCountVO;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateConvertUtils;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 *  
 *  @ProjectName: sf-parent  
 *  @Description: 短信服务类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/9 17:55  
 */
@Service(value = "sendService")
public class SendServiceImpl implements SendService {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(SendService.class);

    /**
     * 发送任务Mapper
     */
    @Autowired
    private SendPlanMapper sendPlanMapper;

    /**
     * 发送明细Mapper
     */
    @Autowired
    private SendDetailMapper sendDetailMapper;

    /**
     * 发送公共服务
     */
    @Autowired
    private SendBizService sendBizService;

    /**
     * 商户套餐信息Mapper
     */
    @Autowired
    private SellerPackageDetailMapper sellerPackageDetailMapper;

    /**
     * 商户套餐统计Maooer
     */
    @Autowired
    private SellerPackageCountMapper sellerPackageCountMapper;


    @Autowired
    private MarkBizService markBizService;


    /**
     * 发送及时邮件
     *
     * @param sellerId     商户ID
     * @param saleType     营销类型
     * @param subject      邮件标题
     * @param content      邮件内容
     * @param targetNumber 邮件目标地址
     * @return 0:成功,-1:失败,-2:余额不足
     */
    @Override
    @Transactional
    public String sendEmail(String sellerId, String saleType, String subject, String content, String targetNumber) {

        String reCode = "-1";

        String seqId = "";

        String status = SmsConstant.SMS_SEND_STATUS_FAILED;
        try {

            if (!sendBizService.sendAccountCheck(sellerId, "MAIL", 1)) {
                return "-2";
            }

            SmsVO smsVO = new SmsVO();
            smsVO.setSellerId(String.valueOf(sellerId));
            smsVO.setSaleType(saleType);

            smsVO.setSaleTitle(subject);
            smsVO.setSendType("MAIL");
            smsVO.setSendTime(new Date());
            smsVO.setContent(content);
            smsVO.setSubject(subject);

            SellerConfigInfo sellerConfig = SellerConfigCache.get(String.valueOf(sellerId));

            smsVO.setSign(sellerConfig.getEmailSign());
            smsVO.setFrom(sellerConfig.getEmail());
            smsVO.setFromName(sellerConfig.getEmailFromName());
            List<String> targetNumberList = new ArrayList<String>();
            targetNumberList.add(targetNumber);
            smsVO.setTargetNumberList(targetNumberList);
            seqId = doSmsSend(smsVO);

            Campaign campaign = new Campaign();
            campaign.setContent(content);
            campaign.setSubject(subject);

            // 暂写死，应取商户配置表，注：在配置时应调用添加发送人邮箱的接口
            campaign.setFromEmail(sellerConfig.getEmail());
            campaign.setFrom(sellerConfig.getEmailFromName());
            campaign.setSchedule(Calendar.getInstance());
            campaign.setCampaignName(seqId);

            SendDetailExample sendDetailExample = new SendDetailExample();
            sendDetailExample.createCriteria().andSeqIdEqualTo(seqId);
            List<SendDetail> sendDetailList = sendDetailMapper.selectByExample(sendDetailExample);


            int code = EmailAdapter.createCampaign(campaign, seqId, -1);

            if (-1 == code) {

                if (sendDetailList != null && !sendDetailList.isEmpty()) {
                    for (SendDetail sendDetail : sendDetailList) {
                        sendDetail.setStatus(SmsConstant.SMS_SEND_STATUS_FAILED);
                        sendDetailMapper.updateByPrimaryKey(sendDetail);
                        // 套餐退费
                        int packageCount = sendBizService.updatePackageDetailRemainTry(Long.valueOf(sendDetail.getPackageId()), smsVO.getSendType(), 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                        if (1 != packageCount) {
                            throw new ServiceException("套餐退费失败，回退");
                        }
                    }
                }

                // 商户统计退费更新
                int sellerPackageCount = sendBizService.updateSellerPackageCount(sellerId, smsVO.getSendType(), 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                if (1 != sellerPackageCount) {
                    throw new ServiceException("套餐退费失败，回退");
                }
            } else {

                reCode = "0";

                sendBizService.updateSmsDetailStatus(sendDetailList, SmsConstant.SMS_SEND_STATUS_SUCCESS);

                SendPlan sendPlan = new SendPlan();
                sendPlan.setCampaignid(String.valueOf(code));

                sendBizService.updateSendPlanInfo(seqId, sendPlan);

                status = SmsConstant.SEND_STATUS_COMPLETE;
            }


        } catch (Exception e) {
            logger.error("SendService.sendEmail() is error.", e);

        }

        // 更新短信任务表中状态
        updateSendPlanStatus(sellerId, seqId, status);

        DatasourceHelper.setDatasource(sellerId);

        return reCode;
    }

    /**
     * 发送及时短信
     *
     * @param sellerId   商户ID
     * @param saleType   营销类型
     * @param type       发送类型，营销:sale、通知:notify
     * @param mobile     手机号码
     * @param smsContent 短信内容
     * @param isFatigue  是否需要疲劳校验 1：需要 0：不需要
     * @return 0:成功,-1失败,-2:余额不足,-3:发送疲劳
     */
    @Override
    @Transactional
    public String sendSms(String sellerId, String saleType, String type, String mobile, String smsContent, String isFatigue) {

        String reCode = "-1";

        String status = SmsConstant.SMS_SEND_STATUS_FAILED;

        String seqId = "";
        try {

            if (!sendBizService.sendAccountCheck(sellerId, "SMS", 1)) {
                return "-2";
            }


            SmsVO smsVO = new SmsVO();

            smsVO.setSellerId(sellerId);

            smsVO.setSmsPriority("5");
            smsVO.setSendType("SMS");
            smsVO.setFatigue(isFatigue);


            List<String> mobileList = new ArrayList<String>();
            mobileList.add(mobile);
            smsVO.setSaleTitle(saleType);
            smsVO.setSaleType(saleType);
            smsVO.setPassage(type);
            smsVO.setContent(smsContent);
            smsVO.setTargetNumberList(mobileList);
            seqId = doSmsSend(smsVO);

            SmsSend smsSend = new SmsSend();
            smsSend.setSmsContent(smsVO.getContent());
            smsSend.setSmsPriority(Integer.valueOf(smsVO.getSmsPriority()));
            smsSend.setUserPhone(smsVO.getTargetNumberList());
            smsSend.setSeqId(Long.valueOf(seqId));
            smsSend.setPassage(smsVO.getPassage());
            smsSend.setSmsSerial(smsVO.getSmsSerial());


            if ("1".equals(smsVO.getFatigue())) {
                List<SendDetail> sendDetailList = sendBizService.getSendDetailBySeqId(seqId);

                for (SendDetail sendDetail : sendDetailList) {

                    // 过滤短信疲劳手机号
                    if (sendBizService.isFatigueSms(sendDetail, smsVO.getSaleType())) {

                        sendBizService.updateSmsDetailStatus(sendDetail, SmsConstant.SMS_SEND_STATUS_FATIGUE);

                        // 套餐退费
                        int reCount = sendBizService.updatePackageDetailRemainTry(Long.valueOf(sendDetail.getPackageId()), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);

                        if (1 != reCount) {
                            throw new ServiceException("更新消费套餐失败，异常回退。");
                        }

                        // 商户统计退费更新
                        sendBizService.updateSellerPackageCount(sellerId, "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);


                        if (StringUtils.isNotEmpty(sendDetail.getActivityId())) {

                            DatasourceHelper.setDatasource(sellerId);

                            // 暂时没有业务分离，此处暂时由这里更新营销状诚
                            markBizService.updateMarketRecords(Long.valueOf(sellerId), Long.valueOf(sendDetail.getActivityId()), sendDetail.getUserSendAddress(), SmsConstant.SMS_SEND_STATUS_FATIGUE);
                        }
                        return "-3";
                    }
                }

            }


            int code = SmsAdapter.smsSend(smsSend);

            if (0 == code) {

                // 更新状态为已发送
                int smsDetailCode = sendBizService.updateSmsDetailStatus(smsVO.getTargetNumberList().get(0), seqId, SmsConstant.SMS_SEND_STATUS_SUCCESS);
                if (1 != smsDetailCode) {
                    throw new ServiceException("更新短信明细信息异常，回退事务。");
                }


                reCode = "0";

                status = SmsConstant.SEND_STATUS_COMPLETE;


                logger.info("seqId:" + seqId + "成功向" + smsVO.getTargetNumberList().get(0) + "发送一条验证码。");

            } else {

                logger.info("seqId:" + seqId + " sendSmsVerifyCode error, reCode is " + reCode);

                //3.TODO 根据调用API的返回结果，如果失败进行退费
                // 更新状态失败
                int smsDetailCode = sendBizService.updateSmsDetailStatus(smsVO.getTargetNumberList().get(0), seqId, SmsConstant.SMS_SEND_STATUS_FAILED);

                if (1 != smsDetailCode) {
                    throw new ServiceException("更新短信明细信息异常，回退事务。");
                }

                // TODO 回退商户短信套餐信息。
                try {
                    sendBizService.updatePackageDetailRemainTry(smsVO.getTargetNumberList().get(0), seqId);
                } catch (Exception e) {
                    throw new ServiceException("更新商户信息异常，回退事务。");
                }

                // 回退商户短信统计信息
                int smscount = sendBizService.updateSellerPackageCount(sellerId, "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                if (0 == smscount) {
                    throw new ServiceException("更新失败，回退事务。");
                }
            }


        } catch (Exception e) {

            logger.error("SendService.tdStrsendSms() is error.");
        }

        // 更新短信任务表中状态
        updateSendPlanStatus(sellerId, seqId, status);

        DatasourceHelper.setDatasource(sellerId);

        return reCode;
    }

    /**
     * 发送短信验证码
     *
     * @param sellerId   商户ID
     * @param mobile     手机号码
     * @param smsContent 短信内容
     * @return -1:失败,0:成功
     * @smsSign 签名
     */
    @Override
    public String sendSmsVerifyCode(String sellerId, String mobile, String smsContent) {

        return sendSms(sellerId, DaoConstant.SmsSaleType.SMS_VERIFY, DaoConstant.SmsSend.SEND_NOTIFY, mobile, smsContent, DaoConstant.SmsFatigueFlag.IS_NOT_FATIGUE);

    }

    /**
     * 异步发送信息，创建任务及明细
     *
     * @param smsVO 短信信息
     * @return 成功：1
     */
    @Override
    public String smsSend(SmsVO smsVO) {

        AssertsUtil.notNull(smsVO, "smsVO");

        String code = "-1";

        // 非及时处理，异步
        smsVO.setSmsPriority("4");


        try {

            // 判断帐户余额是否满足发送条件
            if (!sendBizService.sendAccountCheck(smsVO.getSellerId(), smsVO.getSendType(), smsVO.getTargetNumberList().size())) {

                return "-2";
            }

            return doSmsSend(smsVO);
        } catch (Exception e) {
            logger.error("发送异步短信失败。");
        }

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return code;
    }

    /**
     * 发送短信息，创建任务及明细
     *
     * @param smsVO 短信信息
     * @return 成功：1
     */

    @Transactional
    private String doSmsSend(SmsVO smsVO) {
        AssertsUtil.notNull(smsVO.getSellerId(), "sellerId");
        AssertsUtil.notNull(smsVO.getSendType(), "sendType");


        if ("SMS".equals(smsVO.getSendType())) {


            SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(smsVO.getSellerId());

            if (DaoConstant.SmsSend.SEND_NOTIFY.equals(smsVO.getPassage())) {
                smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
                smsVO.setSign(sellerConfigInfo.getSmsNotifySign());
            } else {
                smsVO.setPassage(DaoConstant.SmsSend.SEND_SALE);
                smsVO.setSign(sellerConfigInfo.getSmsSaleSign());

            }

            smsVO.setSmsSerial(sellerConfigInfo.getSmsSerial());


            // 短信内容校验
            if (!verifySmsCount(smsVO)) {
                logger.info("SendService.smsSend():短信内容超出最大长度。");
                throw new ServiceException("短信内容超出最大长度。");
            }

        } else {


            smsVO.setContent(markBizService.handleMailContent(smsVO.getContent()));
        }


        // 1、TODO 查询商户短信订购信息,优先使用快过期的短信包\

        List<SellerPackageDetail> sellerPackageDetailList = getPackageDetailBySellerIDAndType(smsVO.getSellerId(), smsVO.getSendType());
        if (sellerPackageDetailList == null || sellerPackageDetailList.isEmpty()) {
            logger.info("SendService.smsSend()：未找到商户" + smsVO.getSellerId() + "的可用套餐");
            return "-1";
        }


        String seqID = "-1";
        // 2、TODO 创建发送任务
        try {
            seqID = inserSendPlan(smsVO);
        } catch (Exception e) {
            logger.info("SendService.smsSend():创建发送任务" + seqID + "失败。");
            throw new ServiceException("创建发送任务异常,异常回退.");
        }

        String code;
        if (!"SMS".equals(smsVO.getSendType())) {
            code = EmailAdapter.createSubscription(seqID, "MAIL_SEQ");
            // 邮件需要先创建用户列表，此列表ID为流水号
            if (!"0".equals(code)) {
                throw new ServiceException("邮件创建计划列表失败，回退。");
            }
        }

        // 获取所有待发的用户手机号码
        List<String> targetNumberList = smsVO.getTargetNumberList();

        // 目标号码去重处理
        HashSet<String> targetNumberSet = new HashSet<String>(targetNumberList);

        // 获取短信套餐index数
        int smsOrderSize = sellerPackageDetailList.size();
        int smsOrderIndex = 0;

        // 取第一个可用套餐中的信息
        SellerPackageDetail packageDetail = sellerPackageDetailList.get(smsOrderIndex);
        int reMain = packageDetail.getPackageRemain();

        int smsCount = 0;  // 短信使用数


        List<Subscriber> subscriberList = null;
        if ("MAIL".equals(smsVO.getSendType())) {
            subscriberList = new ArrayList<Subscriber>();
        }

        // 根据待发送的手机号生成发送明细
        for (String smsUserPhone : targetNumberSet) {

            if (StringUtils.isNotEmpty(smsUserPhone)) {

                // 消耗套餐封装

                // 如果当前套餐已用完，更新当前套餐计费，获取下一个套餐。
                if (reMain == 0) {

                    // 更新订购表中计费余额
                    int exeSmsPackeCount = sendBizService.updatePackageDetailRemain(packageDetail.getId(), smsVO.getSendType(), smsCount, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT);
                    if (1 != exeSmsPackeCount) {
                        logger.info("SendService.smsSend():更新商户短信订购信息失败.");
                        throw new ServiceException("由于套餐正在更改，操作失败，请稍后重试.");
                    }
                    // 更新商户消费的短信统计信息
                    int exeSmsCount = sendBizService.updateSellerPackageCount(smsVO.getSellerId(), smsVO.getSendType(), smsCount, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT);

                    if (1 != exeSmsCount) {
                        logger.info("SendService.smsSend():更新商户短信统计信息失败.");
                        throw new ServiceException("由于套餐正在更改，操作失败，请稍后重试.");
                    }
                    // 如果还有未用的套餐，则取下一个套餐
                    if (++smsOrderIndex < smsOrderSize) {
                        packageDetail = sellerPackageDetailList.get(smsOrderIndex);
                        reMain = packageDetail.getPackageRemain();
                    }
                    smsCount = 0;
                }
                // 3  TODO  创建短信明细
                reMain--;
                smsCount++;

                // 插入短信明细
                try {

                    insertSendSmsDetail(smsVO, packageDetail.getId(), smsUserPhone, seqID);
                } catch (Exception e) {
                    throw new ServiceException("插入短信明细表失败，异常回退.");
                }

                if ("MAIL".equals(smsVO.getSendType())) {
                    Subscriber subscriber = new Subscriber();
                    subscriber.setEmail(smsUserPhone);
                    subscriber.setDate1(Calendar.getInstance());
                    subscriber.setDate2(Calendar.getInstance());
                    subscriberList.add(subscriber);
                    subscriber = null;
                }
            }

        }

        if ("MAIL".equals(smsVO.getSendType())) {
            try {
                SubscribersReslutInfo subscribersReslutInfo = EmailAdapter.addSubscribersByInfo(subscriberList, seqID, DoubleOptIn.Off);
                if (!"0".equals(subscribersReslutInfo.getCode())) {
                    // 报错的处理 待确认
                }
            } catch (Exception e) {
                throw new ServiceException("添加邮件联系人列表失败，回退.");
            }

        }

        // 4、TODO  更新计费信息
        // 更新商户短信订购套餐计费
        int smsExeOrderCount = sendBizService.updatePackageDetailRemain(packageDetail.getId(), smsVO.getSendType(), smsCount, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT);
        if (1 != smsExeOrderCount) {
            logger.info("SendService.smsSend():更新商户短信订购信息失败.");
            throw new ServiceException("更新商户短信套餐表失败,异常回退.");
        }

        // 更新商户的消费短信统计信息
        int smsExeCount = sendBizService.updateSellerPackageCount(smsVO.getSellerId(), smsVO.getSendType(), smsCount, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT);
        if (1 != smsExeCount) {
            logger.info("SendService.smsSend():更新商户短信统计信息失败.");
            throw new ServiceException("更新商户短信统计表失败,异常回退.");
        }

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return seqID;
    }


    public String inserSendPlan(SmsVO smsVO) {

        String seqId = "-1";
        try {


            if ("SMS".equals(smsVO.getSendType())) {
                seqId = insertSmsSendPlan(smsVO);
            } else {
                seqId = insertEmailSendPlan(smsVO);
            }

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return seqId;
    }

    public String insertEmailSendPlan(SmsVO emailVO) {


        // 发送任务流水，日期+商户ID 例：201505232106220001
        String seqID = "M" + DateConvertUtils.dateToStrSerial(new Date());


        SendPlan sendPlan = new SendPlan();
        sendPlan.setSeqId(seqID);
        sendPlan.setSaleType(emailVO.getSaleType());
        sendPlan.setStatus(SmsConstant.SMS_SEND_STATUS_TOSEND);
        sendPlan.setSendContent(emailVO.getContent());
        sendPlan.setSellerId(emailVO.getSellerId());
        sendPlan.setSendTitle(emailVO.getSubject());
        sendPlan.setSendFrom(emailVO.getFrom());
        sendPlan.setSendFromname(emailVO.getFromName());
        sendPlan.setSendType(emailVO.getSendType());
        sendPlan.setFlag("0");
        sendPlan.setCreateTime(new Date());

        SendPlan sendPlanInfo = null;

        if (emailVO.getActivityId() != null) {
            sendPlan.setActivityId(String.valueOf(emailVO.getActivityId()));

            sendPlanInfo = sendBizService.getSendPlanByActivityId(emailVO.getSellerId(), String.valueOf(emailVO.getActivityId()));

        }

        if (sendPlanInfo == null) {

            sendPlanMapper.insertSelective(sendPlan);
        } else {
            seqID = sendPlanInfo.getSeqId();
        }


        logger.info("插入任务流水为" + seqID + "的短信任务");
        DatasourceHelper.setDatasource(emailVO.getSellerId());

        return seqID;
    }


    /**
     * 生成短信发送任务
     *
     * @param smsVO 短信内容信息
     */
    private String insertSmsSendPlan(SmsVO smsVO) {


        String serial = "";

        if (StringUtils.isNotEmpty(smsVO.getSmsSerial())) {
            serial = smsVO.getSmsSerial();
        }


        // 发送任务流水，日期+商户ID 例：201505232106220001
        String seqID = DateConvertUtils.dateToStrSerial(new Date()) + serial;


        SendPlan smsPlan = new SendPlan();
        BeanCopierUtils.copyProperties(smsVO, smsPlan);
        smsPlan.setSeqId(seqID);
        smsPlan.setSaleType(smsVO.getSaleType());
        smsPlan.setSmsPassage(smsVO.getPassage());
        smsPlan.setStatus(SmsConstant.SMS_SEND_STATUS_TOSEND);
        smsPlan.setCreateTime(new Date());
        smsPlan.setSendContent(smsVO.getContent());
        smsPlan.setSendTitle(smsVO.getSubject());
        smsPlan.setSendPriority(smsVO.getSmsPriority());
        smsPlan.setFatigue(smsVO.getFatigue());

        SendPlan sendPlan = null;
        if (smsVO.getActivityId() != null) {
            smsPlan.setActivityId(String.valueOf(smsVO.getActivityId()));

            sendPlan = sendBizService.getSendPlanByActivityId(smsVO.getSellerId(), String.valueOf(smsVO.getActivityId()));

        }

        if (sendPlan == null) {

            sendPlanMapper.insertSelective(smsPlan);
        } else {
            seqID = sendPlan.getSeqId();
        }


        logger.info("插入任务流水为" + seqID + "的短信任务");

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return seqID;
    }

    /**
     * 插入短信明细
     *
     * @param smsVO     短信信息
     * @param packageID 商户短信套餐
     * @param userPhone 用户手机号码
     */
    private int insertSendSmsDetail(SmsVO smsVO, Long packageID, String userPhone, String seqID) {

        SendDetail smsDetail = new SendDetail();
        smsDetail.setSeqId(seqID);
        smsDetail.setStatus(SmsConstant.SMS_SEND_STATUS_TOSEND); // 初始为待发送状态
        smsDetail.setSellerId(smsVO.getSellerId());
        smsDetail.setSendTime(smsVO.getSendTime());  // 定时发送时间，为空则为即时发送
        smsDetail.setPackageId(String.valueOf(packageID));
        smsDetail.setUserSendAddress(userPhone);
        smsDetail.setSaleType(smsVO.getSaleType());

        if (smsVO.getActivityId() != null) {
            // 因目前没有做短信报告接口，暂时插入营销ID，后期短信独立分离。
            smsDetail.setActivityId(String.valueOf(smsVO.getActivityId()));
        }

        int count = sendDetailMapper.insert(smsDetail);
        logger.info("插入短信明细" + count + "条。");

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return count;
    }


    /**
     * 根据商户ID获取其下所有未过期的订购套餐,优先快过期时间排序。
     *
     * @param sellerID 商户ID
     * @return 套餐信息
     */
    private List<SellerPackageDetail> getPackageDetailBySellerIDAndType(String sellerID, String type) {
        SellerPackageDetailExample sellerPackageDetailExample = new SellerPackageDetailExample();
        SellerPackageDetailExample.Criteria criteria = sellerPackageDetailExample.createCriteria();
        criteria.andExpiredTimeGreaterThanOrEqualTo(new Date());
        criteria.andSellerIdEqualTo(sellerID);
        criteria.andPackageTypeEqualTo(type);
        sellerPackageDetailExample.setOrderByClause("expired_time");
        List<SellerPackageDetail> packageDetails = sellerPackageDetailMapper.selectByExample(sellerPackageDetailExample);
        DatasourceHelper.setDatasource(sellerID);
        return packageDetails;
    }

    /**
     * 获取商户短信统计信息
     *
     * @param sellerID 商户ID
     * @return 商户短信统计信息
     */
    @Override
    public SellerPackageCount querySellerPackageCountBySellerID(String sellerID, String type) {

        SellerPackageCount sellerPackageCount = null;
        SellerPackageCountExample sellerPackageCountExample = new SellerPackageCountExample();
        SellerPackageCountExample.Criteria criteria = sellerPackageCountExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerID);
        if ("sms".equals(type)) {
            criteria.andSellerPackageTypeEqualTo("SMS");
        } else if ("mail".equals(type)) {
            criteria.andSellerPackageTypeEqualTo("MAIL");
        } else {
            throw new ServiceException("type is error.");
        }

        List<SellerPackageCount> sellerPackageCountList = sellerPackageCountMapper.selectByExample(sellerPackageCountExample);
        if (sellerPackageCountList != null && !sellerPackageCountList.isEmpty()) {
            sellerPackageCount = sellerPackageCountList.get(0);
        }

        DatasourceHelper.setDatasource(sellerID);

        return sellerPackageCount;
    }


    /**
     * 查询商家的短信及邮件信息统计
     *
     * @param sellerId 商户ID
     * @param type     类型，SMS：短信，MAIL:邮件
     * @return
     */
    public SellerPackageCountVO querySellerSendCount(String sellerId, String type) {
        SellerPackageCountExample sellerPackageCountExample = new SellerPackageCountExample();
        SellerPackageCountExample.Criteria criteria = sellerPackageCountExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andSellerPackageTypeEqualTo(type);
        List<SellerPackageCount> sellerPackageCountList = sellerPackageCountMapper.selectByExample(sellerPackageCountExample);

        SellerPackageCountVO sellerPackageCountVO = new SellerPackageCountVO();
        if (sellerPackageCountList != null && !sellerPackageCountList.isEmpty()) {
            BeanCopierUtils.copyProperties(sellerPackageCountList.get(0), sellerPackageCountVO);
        }

        float sucRate = 0;

        float mailOpenRate = 0;

        DatasourceHelper.setDatasource(sellerId);
        if ("SMS".equals(type)) {

            sucRate = markBizService.sendSucRate(Long.valueOf(sellerId), "sms");
        } else if ("MAIL".equals(type)) {
            sucRate = markBizService.sendSucRate(Long.valueOf(sellerId), "email");

            mailOpenRate = markBizService.sendEmailOpenRate(Long.valueOf(sellerId), "email");
        }

        sellerPackageCountVO.setEmailOpenRate(mailOpenRate);

        sellerPackageCountVO.setSendSucRate(sucRate);

        DatasourceHelper.setDatasource(sellerId);

        return sellerPackageCountVO;
    }


    /**
     * 是否符合发送条件。
     * 1、校验短信长度，全文内容不能超过70.
     * 2、敏感关建字检验，暂未实现。
     *
     * @param smsVO 短信发送信息
     * @return true：通过,false：未通过。
     */
    public boolean verifySmsCount(SmsVO smsVO) {

        String tdStr = "";

        // 如果是营销通道，后面要加上TD提示
        if (DaoConstant.SmsSend.SEND_SALE.equals(smsVO.getPassage())) {
            tdStr = " 回复TD退订";
        }

        smsVO.setContent("【" + smsVO.getSign() + "】" + smsVO.getContent() + tdStr);
        String smsContent = smsVO.getContent().trim();
        if (70 < smsContent.length()) {
            logger.info("SendService.verifySmsCount(): 内容长度为" + smsContent.length());
            return false;
        }

        DatasourceHelper.setDatasource(smsVO.getSellerId());

        return true;
    }


//    /**
//     * 删除发送计划
//     *
//     * @param seqId 计划ID
//     * @return
//     */
//    public int deleteSendPlan(String seqId) {
//
//        AssertsUtil.notNull(seqId, "seqId");
//
//        SendPlanExample sendPlanExample = new SendPlanExample();
//        sendPlanExample.createCriteria().andSeqIdEqualTo(seqId);
//
//        return sendPlanMapper.deleteByExample(sendPlanExample);
//
//    }


//    /**
//     * 启用发送计划
//     *
//     * @param seqId 发送计划ID
//     * @return 1：成功，非1：失败
//     */
//    public int startSendPlan(String seqId) {
//
//        AssertsUtil.notNull(seqId, "seqId");
//
//        return updateSendPlanStatus(seqId, SmsConstant.SEND_START);
//    }

//    /**
//     * 停止发送计划
//     *
//     * @param seqId 发送计划ID
//     * @return 1：成功，非1：失败
//     */
//    public int stopSendPlan(String seqId) {
//
//        AssertsUtil.notNull(seqId, "seqId");
//
//        return updateSendPlanStatus(seqId, SmsConstant.SEND_STOP);
//
//    }


//    /**
//     * 更改营销发送计划信息
//     *
//     * @param seqId       发送计划ID
//     * @param sendTitle   发送标题
//     * @param saleType    营销类型
//     * @param sendContent 发送内容
//     * @param sendTime    发送时间
//     * @return 1：成功，非1失败。
//     */
//    public int updateSendPlan(String seqId, String sendTitle, String saleType, String sendContent, Date sendTime) {
//
//        AssertsUtil.notNull(seqId, "seqId");
//
//        int code = -1;
//
//        SendPlan sendPlan = new SendPlan();
//
//
//        sendPlan.setSendTitle(sendTitle);
//        sendPlan.setSaleType(saleType);
//        sendPlan.setSendContent(sendContent);
//        sendPlan.setSendTime(sendTime);
//
//        SendPlanExample sendPlanExample = new SendPlanExample();
//        sendPlanExample.createCriteria().andSeqIdEqualTo(seqId);
//
//        try {
//            code = sendPlanMapper.updateByExample(sendPlan, sendPlanExample);
//        } catch (Exception e) {
//
//            logger.error("SendService updateSendPlan is error.", e);
//        }
//
//        return code;
//
//    }


    /**
     * 根据任务ID更新发送计划状态
     *
     * @param seqId  任务ID
     * @param status 状态
     * @return
     */
    private int updateSendPlanStatus(String sellerId, String seqId, String status) {

        AssertsUtil.notNull(seqId, "seqId");

        int code = -1;

        SendPlan sendPlan = new SendPlan();
        sendPlan.setStatus(status);

        SendPlanExample sendPlanExample = new SendPlanExample();
        sendPlanExample.createCriteria().andSeqIdEqualTo(seqId).andSellerIdEqualTo(sellerId);

        try {
            code = sendPlanMapper.updateByExampleSelective(sendPlan, sendPlanExample);
        } catch (Exception e) {

            logger.error("SendService updateSendPlan is error.", e);
        }

        DatasourceHelper.setDatasource(sellerId);

        return code;
    }


}
