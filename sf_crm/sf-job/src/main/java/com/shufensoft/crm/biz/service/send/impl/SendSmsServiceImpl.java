package com.shufensoft.crm.biz.service.send.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reasonablespread.service.Campaign;
import com.shufensoft.crm.biz.adapter.EmailAdapter;
import com.shufensoft.crm.biz.adapter.SmsAdapter;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.constant.SmsConstant;
import com.shufensoft.crm.biz.dao.generation.seller.SellerPackageDetailMapper;
import com.shufensoft.crm.biz.dao.generation.send.*;
import com.shufensoft.crm.biz.domain.generation.email.CampaignOpens;
import com.shufensoft.crm.biz.domain.generation.email.CampaignSentstInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetail;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetailExample;
import com.shufensoft.crm.biz.domain.generation.send.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.market.MarkBizService;
import com.shufensoft.crm.biz.service.send.SendBizService;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.common.sms.emay.cn.b2m.eucp.sdkhttp.Mo;
import com.shufensoft.crm.common.sms.emay.cn.b2m.eucp.sdkhttp.StatusReport;
import com.shufensoft.crm.common.utils.DateConvertUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf_crm  
 *  @Description: 短信发送相关实现类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/6/7 16:51  
 */
@Service(value = "sendSmsService")
public class SendSmsServiceImpl implements SendSmsService {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(SendSmsServiceImpl.class);
    /**
     * 短信发送计划Mapper
     */
    @Autowired
    private SendPlanMapper sendPlanMapper;

    /**
     * 短信明细Mapper
     */
    @Autowired
    private SendDetailMapper sendDetailMapper;

    /**
     * 短信状态报告Mapper
     */
    @Autowired
    private SmsStatusReportMapper smsStatusReportMapper;

    /**
     * 短信退订Mapper
     */
    @Autowired
    private SendUserUnsubscribeMapper sendUserUnsubscribeMapper;

    /**
     * 商户套餐Mapper
     */
    @Autowired
    private SellerPackageDetailMapper sellerPackageDetailMapper;

    /**
     * 邮件状态报告Mapper
     */
    @Autowired
    private MailStatusReportMapper mailStatusReportMapper;

    /**
     * 短信公共服务类
     */
    @Autowired
    private SendBizService sendBizService;

    @Autowired
    private MarkBizService markBizService;


    public void receiveEmailReport(Long sellerId, Date startDate, Date endDate) {

        SendPlanExample sendPlanExample = new SendPlanExample();
        SendPlanExample.Criteria criteria = sendPlanExample.createCriteria();
        criteria.andGmtCreatedBetween(DateUtil.getExpiredDay(-7), new Date());
        criteria.andFlagEqualTo("0");
        criteria.andCampaignidIsNotNull();
        criteria.andSendTypeEqualTo("MAIL");
        criteria.andSellerIdEqualTo(String.valueOf(sellerId));

        List<SendPlan> sendPlanList = sendPlanMapper.selectByExample(sendPlanExample);

        for (SendPlan sendPlan : sendPlanList) {

            /**
             * 接收并保存发送状态
             */
            try {

                List<CampaignSentstInfo> campaignSentstInfoList = EmailAdapter.getCampaignSents(Integer.valueOf(sendPlan.getCampaignid()), startDate, endDate);

                if (campaignSentstInfoList != null && !campaignSentstInfoList.isEmpty()) {
                    saveEmailReport(sellerId, campaignSentstInfoList, sendPlan.getSeqId(), "isSuccess");
                }


            } catch (Exception e) {

                logger.error("receiveEmailReport campaignSentst error.", e);
            }


            /**
             * 接收并保存回退状态
             */
            try {

                List<CampaignSentstInfo> campaignSentstInfoList = EmailAdapter.getCampaignBounces(Integer.valueOf(sendPlan.getCampaignid()), startDate, endDate);
                if (campaignSentstInfoList != null && !campaignSentstInfoList.isEmpty()) {
                    saveEmailReport(sellerId, campaignSentstInfoList, sendPlan.getSeqId(), "isBack");
                }

            } catch (Exception e) {
                logger.error("receiveEmailReport campaignBounces error.", e);
            }

            /**
             * 接收并保存打开报告
             */
            try {
                List<CampaignOpens> campaignOpensList = EmailAdapter.getCampaignOpens(Integer.valueOf(sendPlan.getCampaignid()), startDate, endDate);
                if (campaignOpensList != null && !campaignOpensList.isEmpty()) {
                    saveEmailOpenReport(sellerId, campaignOpensList, sendPlan.getSeqId(), sendPlan.getActivityId());
                }
            } catch (Exception e) {
                logger.error("receiveEmailReport campaignBounces error.", e);
            }
        }


        DatasourceHelper.setDatasource(String.valueOf(sellerId));
    }


    /**
     * 保存邮件打开记录
     *
     * @param campaignOpenList
     * @param seqId
     */
    private void saveEmailOpenReport(Long sellerId, List<CampaignOpens> campaignOpenList, String seqId, String activityId) {

        for (CampaignOpens campaignOpens : campaignOpenList) {

            MailStatusReportExample mailStatusReportExample = new MailStatusReportExample();
            MailStatusReportExample.Criteria criteriaMail = mailStatusReportExample.createCriteria();
            criteriaMail.andSeqIdEqualTo(seqId);
            criteriaMail.andEmailAddressEqualTo(campaignOpens.getSubscriber_email());
            criteriaMail.andSellerIdEqualTo(sellerId);


            List<MailStatusReport> mailStatusReportList = mailStatusReportMapper.selectByExample(mailStatusReportExample);

            if (mailStatusReportList != null && !mailStatusReportList.isEmpty()) {

                MailStatusReport mailStatusReportUp = mailStatusReportList.get(0);

                mailStatusReportUp.setIsOpen("true");

                mailStatusReportMapper.updateByPrimaryKey(mailStatusReportUp);
            } else {
                MailStatusReport mailStatusReport = new MailStatusReport();

                mailStatusReport.setIsOpen("true");
                mailStatusReport.setEmailAddress(campaignOpens.getSubscriber_email());
                mailStatusReport.setSeqId(seqId);
                mailStatusReport.setStatus("0");
                mailStatusReportMapper.insert(mailStatusReport);
            }

            DatasourceHelper.setDatasource(String.valueOf(sellerId));

            // 暂时没有业务分离，此处暂时由这里更新营销状态
            markBizService.updateMailMarketRecords(sellerId, Long.valueOf(activityId), campaignOpens.getSubscriber_email(), DaoConstant.MarketStatusType.ISOPEN, DaoConstant.MarketSendStatus.ISOPEND);

        }
    }


    /**
     * 保存邮件状态报告
     *
     * @param campaignSentstInfoList
     * @param seqId
     * @param type
     */
    private void saveEmailReport(Long sellerId, List<CampaignSentstInfo> campaignSentstInfoList, String seqId, String type) {
        for (CampaignSentstInfo campaignSentstInfo : campaignSentstInfoList) {

            // 如果接收到不成功，将明细表中的状态更新为失败。
            if (!"true".equals(campaignSentstInfo.getIsSuccess())) {
                updateSendDetail(sellerId, seqId, campaignSentstInfo.getSubscriber_email());
            }

            MailStatusReportExample mailStatusReportExample = new MailStatusReportExample();
            MailStatusReportExample.Criteria criteriaMail = mailStatusReportExample.createCriteria();
            criteriaMail.andSeqIdEqualTo(seqId);
            criteriaMail.andEmailAddressEqualTo(campaignSentstInfo.getSubscriber_email());
            criteriaMail.andSellerIdEqualTo(sellerId);

            List<MailStatusReport> mailStatusReportList = mailStatusReportMapper.selectByExample(mailStatusReportExample);

            if (mailStatusReportList != null && !mailStatusReportList.isEmpty()) {
                MailStatusReport mailStatusReportUp = mailStatusReportList.get(0);
                if ("isSuccess".equals(type)) {
                    mailStatusReportUp.setIsSuccess(campaignSentstInfo.getIsSuccess());
                } else if ("isBack".equals(type)) {
                    mailStatusReportUp.setIsBack(campaignSentstInfo.getIsSuccess());
                } else {
                    //
                }

                mailStatusReportMapper.updateByPrimaryKey(mailStatusReportUp);
            } else {
                MailStatusReport mailStatusReport = new MailStatusReport();

                if ("isSuccess".equals(type)) {
                    mailStatusReport.setIsSuccess(campaignSentstInfo.getIsSuccess());
                } else if ("isBack".equals(type)) {
                    mailStatusReport.setIsBack(campaignSentstInfo.getIsSuccess());
                } else {
                    //
                }
                mailStatusReport.setEmailAddress(campaignSentstInfo.getSubscriber_email());
                mailStatusReport.setSeqId(seqId);
                mailStatusReport.setStatus("0");
                mailStatusReportMapper.insert(mailStatusReport);
            }

        }

        DatasourceHelper.setDatasource(String.valueOf(sellerId));
    }

    private int updateSendDetail(Long sellerId, String seqId, String email) {
        try {
            SendDetailExample sendDetailExample = new SendDetailExample();
            SendDetailExample.Criteria criteria = sendDetailExample.createCriteria();
            criteria.andSeqIdEqualTo(seqId);
            criteria.andUserSendAddressEqualTo(email);
            criteria.andSellerIdEqualTo(String.valueOf(sellerId));

            SendDetail sendDetail = new SendDetail();
            sendDetail.setStatus(SmsConstant.SMS_REPORT_STATUS_FALIED);
            return sendDetailMapper.updateByExample(sendDetail, sendDetailExample);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        DatasourceHelper.setDatasource(String.valueOf(sellerId));

        return -1;
    }


    /**
     * 接收短信订信息
     */
    public void receiveSmsMo(String sellerId, String type) {

        List<Mo> smsMoList = SmsAdapter.getMO(type);
        pringMoLog(smsMoList);
        if (smsMoList != null && !smsMoList.isEmpty()) {
            for (Mo mo : smsMoList) {
                if ("TD".equals(mo.getSmsContent())) {
                    SendUserUnsubscribe smsUserUnsubscribe = new SendUserUnsubscribe();
                    smsUserUnsubscribe.setAddSerial(mo.getAddSerial());
                    smsUserUnsubscribe.setAddSerialRev(mo.getAddSerialRev());


                    // sellerID应根据扩展码从商户的配置表中获取。
                    smsUserUnsubscribe.setSellerId(mo.getAddSerial());
                    smsUserUnsubscribe.setChannelNumber(mo.getChannelnumber());
                    smsUserUnsubscribe.setUserSendAddress(mo.getMobileNumber());
                    smsUserUnsubscribe.setSentTime(mo.getSentTime());
                    smsUserUnsubscribe.setSmsContent(mo.getSmsContent());
                    try {
                        sendUserUnsubscribeMapper.insert(smsUserUnsubscribe);
                    } catch (Exception e) {
                        logger.error("SendSmsService.receiveSmsMo():插入" + mo.getMobileNumber() + "的短信退订信息失败。", e);
                    }

                }
            }
        }

        DatasourceHelper.setDatasource(sellerId);

    }


    /**
     * 打印接收的用户上行短信内容
     *
     * @param smsMoList
     */
    private void pringMoLog(List<Mo> smsMoList) {
        if (smsMoList != null && !smsMoList.isEmpty()) {
            for (Mo mo : smsMoList) {
                logger.info("接收短信上行内容，用户手机：" + mo.getMobileNumber() + ",短信内容：" + mo.getSmsContent() + "发送时间：" + mo.getSentTime() + ",扩展号码：" + mo.getAddSerialRev());
            }
        }

    }


    /**
     * 接收并保存短信状态报告
     */
    public void receiveSmsStatusReport(String sellerId, String type) {

        // 1.TODO 调用获取短信状态报告API，取到报告告结果
        List<StatusReport> statuReportList = SmsAdapter.getSmsStatusReport(type);
        printReportLog(statuReportList);
        // statuReportLis 日志
        // 暂时写死,应从报告取出的SEQ_ID截取出seller_id

        if (statuReportList != null && !statuReportList.isEmpty()) {

            for (StatusReport statusReport : statuReportList) {
                SmsStatusReport smsStatusReport = new SmsStatusReport();
                smsStatusReport.setErrorCode(statusReport.getErrorCode());
                smsStatusReport.setSeqId(String.valueOf(statusReport.getSeqID()));
                smsStatusReport.setMobile(statusReport.getMobile());
                smsStatusReport.setMemo(statusReport.getMemo());
                smsStatusReport.setReceiveData(new Date());
                smsStatusReport.setServiceCodeAdd(statusReport.getServiceCodeAdd());
                smsStatusReport.setSubmitData(DateUtil.strDateToDate(statusReport.getSubmitDate()));
                smsStatusReport.setReportStatus(String.valueOf(statusReport.getReportStatus()));
                // 初始为0：未平帐状态
                smsStatusReport.setStatus("0");
                int count = smsStatusReportMapper.insert(smsStatusReport);
                logger.info("insert report " + count);
            }
            logger.info("insert report" + statuReportList.size());

        }

        DatasourceHelper.setDatasource(sellerId);
    }


    private void printReportLog(List<StatusReport> statuReportList) {
        if (statuReportList != null && !statuReportList.isEmpty()) {

            for (StatusReport statusReport : statuReportList) {
                logger.info("接口返回报告内容为:" + statusReport.getSeqID() + ":" + statusReport.getMobile() + "," + statusReport.getReportStatus());
            }
        }
    }


    /**
     * 发送邮件
     *
     * @param emailPlanSend
     */
    @Transactional
    public void sendEmail(SendPlan emailPlanSend) {


        Campaign campaign = new Campaign();
        campaign.setContent(emailPlanSend.getSendContent());
        campaign.setSubject(emailPlanSend.getSendTitle());
        // 暂写死，应取商户配置表，注：在配置时应调用添加发送人邮箱的接口
        campaign.setFromEmail(emailPlanSend.getSendFrom());
        campaign.setFrom(emailPlanSend.getSendFromname());
        campaign.setSchedule(Calendar.getInstance());
        campaign.setCampaignName(emailPlanSend.getSeqId());

        SendDetailExample sendDetailExample = new SendDetailExample();
        sendDetailExample.createCriteria().andSeqIdEqualTo(emailPlanSend.getSeqId());
        List<SendDetail> sendDetailList = sendDetailMapper.selectByExample(sendDetailExample);

        int code = 1;
        //int code = EmailAdapter.createCampaign(campaign, emailPlanSend.getSeqId(), -1);

        if (-1 == code) {

            if (sendDetailList != null && !sendDetailList.isEmpty()) {
                for (SendDetail sendDetail : sendDetailList) {
                    sendDetail.setStatus(SmsConstant.SMS_SEND_STATUS_FAILED);
                    sendDetailMapper.updateByPrimaryKey(sendDetail);
                    // 套餐退费
                    int packageCount = sendBizService.updatePackageDetailRemainTry(Long.valueOf(sendDetail.getPackageId()), emailPlanSend.getSendType(), 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                    if (1 != packageCount) {
                        throw new ServiceException("套餐退费失败，回退");
                    }
                }
            }

            // 商户统计退费更新
            int sellerPackageCount = sendBizService.updateSellerPackageCount(emailPlanSend.getSellerId(), emailPlanSend.getSendType(), 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
            if (1 != sellerPackageCount) {
                throw new ServiceException("套餐退费失败，回退");
            }
        } else {

            updateSmsDetailStatus(emailPlanSend.getSellerId(), sendDetailList, SmsConstant.SMS_SEND_STATUS_SUCCESS);
            updateSendPlanInfo(emailPlanSend, code);
        }

        // 更新短信任务表中状态
        updateSmsPlanStatus(emailPlanSend, SmsConstant.SEND_STATUS_COMPLETE);

        DatasourceHelper.setDatasource(emailPlanSend.getSellerId());
    }


    /**
     * 发送邮件
     *
     * @return 0：成功，-1：失败
     */
    public int sendEmail(String sellerId) {
        int result = -1;
        List<SendPlan> sendPlanList = getSendPlan(sellerId, "MAIL");
        if (sendPlanList != null && !sendPlanList.isEmpty()) {
            for (SendPlan emailPlanSend : sendPlanList) {
                try {
                    sendEmail(emailPlanSend);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    // 更新短信任务表中状态
                    updateSmsPlanStatus(emailPlanSend, SmsConstant.SMS_SEND_STATUS_FAILED);
                }
            }
            result = 0;
        }

        DatasourceHelper.setDatasource(sellerId);

        return result;
    }


    private List<SendPlan> getSendPlan(String sellerId, String type) {
        SendPlanExample sendPlanExample = new SendPlanExample();
        SendPlanExample.Criteria criteria = sendPlanExample.createCriteria();
        criteria.andStatusEqualTo(SmsConstant.SMS_SEND_STATUS_TOSEND);
        criteria.andSendTypeEqualTo(type);
        criteria.andSellerIdEqualTo(sellerId);
        if ("SMS".equals(type)) {
            criteria.andSendPriorityLessThan("5");  // 级别小于5的为非及时短信
        }
        List<SendPlan> sendPlanList = sendPlanMapper.selectByExample(sendPlanExample);

        DatasourceHelper.setDatasource(sellerId);
        return sendPlanList;
    }

    /**
     * 执行发送短信
     *
     * @return 0:成功，-1：失败
     */

    public int sendSms(String sellerId) {
        int result = -1;
        //1.TODO 查询发送任务表中状态为待发送的计划，进入队列。

        List<SendPlan> smsPlanList = getSendPlan(sellerId, "SMS");
        if (smsPlanList != null && !smsPlanList.isEmpty()) {
            int pageNum = 1;
            int pageSize = 200;
            for (SendPlan smsPlanSend : smsPlanList) {
                try {

                    sendSms(smsPlanSend, pageNum, pageSize);
                    result = 0;
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }

        }

        DatasourceHelper.setDatasource(sellerId);

        return result;
    }


    /**
     * 处理
     *
     * @param smsPlanSend
     * @param smsDetail
     * @param doSmsDetailList
     * @param phoneList
     * @return
     */
    private boolean sendHandle(String sellerId, SendPlan smsPlanSend, SendDetail smsDetail, List<SendDetail> doSmsDetailList, List<String> phoneList) {
        // 过滤TD的手机号并记录状态为退订。
        if (isSmsUnsubscribeBySellerAndUserMobile(smsPlanSend.getSellerId(), smsDetail.getUserSendAddress())) {

            updateSmsDetailStatus(sellerId, smsDetail, SmsConstant.SMS_SEND_STATUS_TD);

            // 套餐退费
            sendBizService.updatePackageDetailRemainTry(Long.valueOf(smsDetail.getPackageId()), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);

            // 商户统计退费更新
            sendBizService.updateSellerPackageCount(smsPlanSend.getSellerId(), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);

            DatasourceHelper.setDatasource(smsPlanSend.getSellerId());

            // 暂时没有业务分离，此处暂时由这里更新营销状诚
            markBizService.updateMarketRecords(Long.valueOf(smsPlanSend.getSellerId()), Long.valueOf(smsDetail.getActivityId()), smsDetail.getUserSendAddress(), DaoConstant.MarketSendStatus.TD);

            return true;
        }

        if (StringUtils.isNotEmpty(smsPlanSend.getFatigue()) && "1".equals(smsPlanSend.getFatigue())) {

            // 过滤短信疲劳手机号
            if (sendBizService.isFatigueSms(smsDetail, smsPlanSend.getSaleType())) {
                updateSmsDetailStatus(smsPlanSend.getSellerId(), smsDetail, SmsConstant.SMS_SEND_STATUS_FATIGUE);

                // 套餐退费
                int reCount = sendBizService.updatePackageDetailRemainTry(Long.valueOf(smsDetail.getPackageId()), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                if (1 != reCount) {
                    throw new ServiceException("更新消费套餐失败，异常回退。");
                }
                // 商户统计退费更新
                sendBizService.updateSellerPackageCount(smsPlanSend.getSellerId(), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);

                if (StringUtils.isNotEmpty(smsDetail.getActivityId())) {

                    DatasourceHelper.setDatasource(smsPlanSend.getSellerId());

                    // 暂时没有业务分离，此处暂时由这里更新营销状诚
                    markBizService.updateMarketRecords(Long.valueOf(smsPlanSend.getSellerId()), Long.valueOf(smsDetail.getActivityId()), smsDetail.getUserSendAddress(), DaoConstant.MarketSendStatus.FATIGUE);
                }


                return true;
            }
        }


        doSmsDetailList.add(smsDetail);   // 过滤后需要计费的明细
        phoneList.add(smsDetail.getUserSendAddress()); // 过滤后需要发送的手机号

        return false;


    }

    /**
     * 发送短信
     *
     * @param smsPlanSend 短信计划
     * @param pageNum     当前页数
     * @param pageSize    每页条数
     */
    @Transactional
    private void sendSms(SendPlan smsPlanSend, int pageNum, int pageSize) {

        String status = SmsConstant.SEND_STATUS_COMPLETE;

        // 每200条为一次发送
        int pages = 1;
        while (pageNum <= pages) {
            PageInfo pageInfo = getSmsDetailPageInfo(smsPlanSend.getSellerId(), smsPlanSend.getSeqId(), pageNum, pageSize);
            pages = pageInfo.getPages();
            pageInfo.setPageNum(pageNum);
            List<SendDetail> smsDetailList = pageInfo.getList();

            List<String> phoneList = new ArrayList<String>();
            List<SendDetail> doSmsDetailList = new ArrayList<SendDetail>();

            if (smsDetailList != null && !smsDetailList.isEmpty()) {

                for (SendDetail smsDetail : smsDetailList) {

                    if (sendHandle(smsPlanSend.getSellerId(), smsPlanSend, smsDetail, doSmsDetailList, phoneList)) {
                        continue;
                    }

                }

                if (phoneList != null && !phoneList.isEmpty()) {
                    SmsSend smsSend = new SmsSend();
                    smsSend.setSeqId(Long.valueOf(smsPlanSend.getSeqId()));
                    if (null != smsPlanSend.getSendTime() && !"".equals(smsPlanSend.getSendTime())) {
                        smsSend.setSendTime(DateConvertUtils.dateToStrSerial(smsPlanSend.getSendTime()));
                    }
                    smsSend.setSmsContent(smsPlanSend.getSendContent());
                    if (StringUtils.isNotEmpty(smsPlanSend.getSendPriority())) {
                        smsSend.setSmsPriority(Integer.valueOf(smsPlanSend.getSendPriority()));
                    } else {
                        smsSend.setSmsPriority(5);
                    }


                    if (DaoConstant.SmsSend.SEND_NOTIFY.equals(smsPlanSend.getSmsPassage())) {
                        smsSend.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
                    }

                    smsSend.setUserPhone(phoneList);

                    String smsSerial = smsPlanSend.getSeqId().substring(14);

                    smsSend.setSmsSerial(smsSerial);


                    //2.TODO 根据待发送的计划查询该计划下的明细，调用发送短信API。
                    // 发送短信
                    int code = SmsAdapter.smsSend(smsSend);

                    if (0 == code) {

                        // 更新状态为已发送
                        updateSmsDetailStatus(smsPlanSend.getSellerId(), doSmsDetailList, SmsConstant.SMS_SEND_STATUS_SUCCESS);


                    } else {

                        //3.TODO 根据调用API的返回结果，如果失败进行退费
                        // 更新状态失败
                        updateSmsDetailStatus(smsPlanSend.getSellerId(), doSmsDetailList, SmsConstant.SMS_SEND_STATUS_FAILED);

                        // TODO 回退商户短信套餐信息。
                        try {
                            updateBackSmsOrder(smsPlanSend.getSellerId(), doSmsDetailList);
                        } catch (Exception e) {
                            throw new ServiceException("更新商户信息异常，回退事务。");
                        }

                        // 回退商户短信统计信息
                        int smscount = sendBizService.updateSellerPackageCount(smsPlanSend.getSellerId(), "SMS", smsDetailList.size(), SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
                        if (0 == smscount) {
                            throw new ServiceException("更新失败，回退事务。");
                        }

                        status = SmsConstant.SMS_SEND_STATUS_FAILED;


                    }
                }

            } else {

                throw new ServiceException("未查到该发送计划内的发送明细，异常回退。");
            }
            pageNum++;

        }

        // 更新短信任务表中状态
        updateSmsPlanStatus(smsPlanSend, status);


        DatasourceHelper.setDatasource(smsPlanSend.getSellerId());


    }


    /**
     * 根据短信明细回退商户的套餐计费。
     *
     * @param smsDetailList 短信明细
     */

    private void updateBackSmsOrder(String sellerId, List<SendDetail> smsDetailList) {
        for (SendDetail smsDetail : smsDetailList) {
            int count = sendBizService.updatePackageDetailRemainTry(Long.valueOf(smsDetail.getPackageId()), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
            if (0 == count) {
                throw new ServiceException("更新修改，异常回退。");
            }
        }

        DatasourceHelper.setDatasource(sellerId);
    }

    /**
     * 根据短信报告结果更新短信明细
     */
    public void smsCheckAccount(String sellerId) {

        // 查询出短信报告表中未平帐的记录
        SmsStatusReportExample smsStatusReportExample = new SmsStatusReportExample();
        smsStatusReportExample.createCriteria().andStatusEqualTo("0");
        List<SmsStatusReport> smsStatusReportList = smsStatusReportMapper.selectByExample(smsStatusReportExample);
        if (smsStatusReportList != null && !smsStatusReportList.isEmpty()) {
            for (SmsStatusReport smsStatusReport : smsStatusReportList) {
                if (!"0".equals(smsStatusReport.getReportStatus())) {
                    SendDetail smsDetail = new SendDetail();
                    smsDetail.setSeqId(smsStatusReport.getSeqId());
                    smsDetail.setUserSendAddress(smsStatusReport.getMobile());
                    int count = updateSmsDetailStatus(sellerId, smsDetail, SmsConstant.SMS_REPORT_STATUS_FALIED);
                    logger.info("SendSmsService.smsCheckAccount():更新短信明细" + count + "条。");
                }

                smsStatusReport.setStatus("1");

                int reportCount = smsStatusReportMapper.updateByPrimaryKeySelective(smsStatusReport);
                logger.info("smsCheckAccount():更新报告表信息" + reportCount + "条。");
            }
        }

        DatasourceHelper.setDatasource(sellerId);

    }

    /**
     * 检测过期商户套餐交更新商户统计信息
     */
    @Override
    @Transactional
    public void checkSmsExpired(String sellerId) {
        SellerPackageDetailExample packageDetailExample = new SellerPackageDetailExample();
        SellerPackageDetailExample.Criteria criteria = packageDetailExample.createCriteria();
        criteria.andExpiredFlagEqualTo("0");
        criteria.andExpiredTimeLessThan(new Date());
        criteria.andSellerIdEqualTo(sellerId);

        List<SellerPackageDetail> packageDetailList = sellerPackageDetailMapper.selectByExample(packageDetailExample);
        if (packageDetailList != null && !packageDetailList.isEmpty()) {
            for (SellerPackageDetail packageDetail : packageDetailList) {
                int count = sendBizService.updateSellerPackageCount(packageDetail.getSellerId(), "SMS", packageDetail.getPackageRemain(), SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_EXPIRED);
                if (1 != count) {
                    throw new ServiceException("更新商户套餐统计表异常回退。");
                }
                packageDetail.setExpiredFlag("1");
                int packageCount = sellerPackageDetailMapper.updateByPrimaryKey(packageDetail);
                if (1 != packageCount) {
                    throw new ServiceException("更新商户套餐订购表异常回退。");
                }
            }
        }

        DatasourceHelper.setDatasource(sellerId);

    }


    /**
     * 根据商户ID和手机号码判断是否为退订手机号
     *
     * @param sellerId   商户ID
     * @param userMobile 手机号
     * @return true/false
     */
    private boolean isSmsUnsubscribeBySellerAndUserMobile(String sellerId, String userMobile) {
        try {
            SendUserUnsubscribeExample smsUserUnsubscribeExample = new SendUserUnsubscribeExample();
            SendUserUnsubscribeExample.Criteria criteria = smsUserUnsubscribeExample.createCriteria();
            criteria.andSellerIdEqualTo(sellerId);
            criteria.andUserSendAddressEqualTo(userMobile);
            criteria.andSmsContentEqualTo(SmsConstant.SMS_SEND_STATUS_TD);
            List<SendUserUnsubscribe> smsUserUnsubscribeList = sendUserUnsubscribeMapper.selectByExample(smsUserUnsubscribeExample);
            if (smsUserUnsubscribeList == null || smsUserUnsubscribeList.isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            logger.error("SmsSendService.isSmsUnsubscribeBySellerAndUserMobile():查询用户是否为退订短信用户时异常。", e);
        }

        DatasourceHelper.setDatasource(sellerId);

        return true;
    }


    /**
     * 更新邮件活动ID到发送任务信息
     *
     * @param smsPlanSend
     */
    private void updateSendPlanInfo(SendPlan smsPlanSend, int campaignId) {
        smsPlanSend.setCampaignid(String.valueOf(campaignId));
        sendPlanMapper.updateByPrimaryKey(smsPlanSend);

        DatasourceHelper.setDatasource(smsPlanSend.getSellerId());
    }

    /**
     * 更新短信任务表状态(已查出的任务信息)
     *
     * @param smsPlanSend 短信任务信息
     * @param status      状态
     */
    private void updateSmsPlanStatus(SendPlan smsPlanSend, String status) {
        smsPlanSend.setStatus(status);
        sendPlanMapper.updateByPrimaryKey(smsPlanSend);

        DatasourceHelper.setDatasource(smsPlanSend.getSellerId());
    }

    /**
     * 更新短信明细状态
     *
     * @param smsDetailList
     */
    private void updateSmsDetailStatus(String sellerId, List<SendDetail> smsDetailList, String status) {
        for (SendDetail smsDetail : smsDetailList) {
            updateSmsDetailStatus(sellerId, smsDetail, status);
        }

        DatasourceHelper.setDatasource(sellerId);
    }


    /**
     * 更新短信明细状态
     *
     * @param smsDetail 短信明细
     * @param status    状态
     * @return 更新成功数量
     */
    private int updateSmsDetailStatus(String sellerId, SendDetail smsDetail, String status) {
        SendDetailExample smsDetailExample = new SendDetailExample();
        SendDetailExample.Criteria criteria = smsDetailExample.createCriteria();
        criteria.andUserSendAddressEqualTo(smsDetail.getUserSendAddress());
        criteria.andSeqIdEqualTo(smsDetail.getSeqId());
        criteria.andSellerIdEqualTo(sellerId);
        SendDetail smsDetailUpd = new SendDetail();
        smsDetailUpd.setStatus(status);
        int code = sendDetailMapper.updateByExampleSelective(smsDetailUpd, smsDetailExample);

        DatasourceHelper.setDatasource(sellerId);
        return code;
    }


    /**
     * 获取分页结果信息
     *
     * @param smsPlanSeqId 短信发送任务ID
     * @param pageNum      当前页数
     * @param pageSize     每页条数
     * @return 分页结果
     */
    private PageInfo getSmsDetailPageInfo(String sellerId, String smsPlanSeqId, int pageNum, int pageSize) {
        SendDetailExample smsDetailExample = new SendDetailExample();
        smsDetailExample.createCriteria().andSeqIdEqualTo(smsPlanSeqId).andSellerIdEqualTo(sellerId);

        PageHelper.startPage(pageNum, pageSize, true);
        List<SendDetail> smsDetailList = sendDetailMapper.selectByExample(smsDetailExample);

        DatasourceHelper.setDatasource(sellerId);

        return new PageInfo(smsDetailList);
    }
}
