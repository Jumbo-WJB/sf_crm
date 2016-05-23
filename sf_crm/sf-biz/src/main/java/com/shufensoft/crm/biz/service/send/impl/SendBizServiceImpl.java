package com.shufensoft.crm.biz.service.send.impl;

import com.shufensoft.crm.biz.constant.SmsConstant;
import com.shufensoft.crm.biz.dao.generation.seller.SellerPackageCountMapper;
import com.shufensoft.crm.biz.dao.generation.seller.SellerPackageDetailMapper;
import com.shufensoft.crm.biz.dao.generation.send.SendDetailMapper;
import com.shufensoft.crm.biz.dao.generation.send.SendPlanMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCountExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetail;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetailExample;
import com.shufensoft.crm.biz.domain.generation.send.SendDetail;
import com.shufensoft.crm.biz.domain.generation.send.SendDetailExample;
import com.shufensoft.crm.biz.domain.generation.send.SendPlan;
import com.shufensoft.crm.biz.domain.generation.send.SendPlanExample;
import com.shufensoft.crm.biz.service.send.SendBizService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @ProjectName: sf_crm  
 *  @Description: 短信相关公用服务类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/24 0:44  
 */
@Service(value = "sendBizService")
public class SendBizServiceImpl implements SendBizService {

    /**
     * logger
     */
    public static final Logger logger = Logger.getLogger(SendBizServiceImpl.class);


    @Autowired
    private SellerPackageDetailMapper sellerPackageDetailMapper;

    @Autowired
    private SellerPackageCountMapper sellerPackageCountMapper;

    @Autowired
    private SendPlanMapper sendPlanMapper;

    @Autowired
    private SendDetailMapper sendDetailMapper;


    /**
     * 根据商户ID获取商户短信统计信息
     *
     * @return 商户套餐统计信息
     */

    public SellerPackageCount getSellerPackageCount(String sellerID, String sendType) {
        SellerPackageCountExample sellerPackageCountExample = new SellerPackageCountExample();
        sellerPackageCountExample.createCriteria().andSellerIdEqualTo(sellerID).andSellerPackageTypeEqualTo(sendType);
        List<SellerPackageCount> sellerPackageCounts = sellerPackageCountMapper.selectByExample(sellerPackageCountExample);
        if (sellerPackageCounts == null || sellerPackageCounts.isEmpty()) {
            return null;
        }
        return sellerPackageCounts.get(0);
    }


    /**
     * 更新商户套餐统计信息
     *
     * @param sellerID 商户ID
     * @param type     类型
     * @param count    数量
     * @param doFlag   动作
     * @return 执行条数
     */
    public int updateSellerPackageCount(String sellerID, String type, int count, String doFlag) {

        int upNum = 0;  // 数据库更新返回数

        int reTryNum = 1;  // 重试次数
        int doNum = 0;  // 执行计数
        do {
            SellerPackageCount sellerPackageCount = getSellerPackageCount(sellerID, type);
            if (sellerPackageCount == null) {
                logger.info("商户ID:" + sellerID + "未获取到统计信息。");
                return upNum;
            }
            SellerPackageCountExample sellerPackageCountExample = new SellerPackageCountExample();
            SellerPackageCountExample.Criteria criteria = sellerPackageCountExample.createCriteria();
            criteria.andSellerIdEqualTo(sellerID);
            criteria.andSellerPackageTypeEqualTo(type);
            criteria.andSellerPackageVersionEqualTo(sellerPackageCount.getSellerPackageVersion());

            SellerPackageCount sellerPackageCountInfo = new SellerPackageCount();


            if (SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT.equals(doFlag)) {

                sellerPackageCountInfo.setSellerPackageVersionExpression("seller_package_version + 1");
                sellerPackageCountInfo.setSellerPackageUsedExpression("seller_package_used +" + count);
                sellerPackageCountInfo.setSellerPackageRemainExpression("seller_package_remain -" + count);
            } else if (SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK.equals(doFlag)) {
                sellerPackageCountInfo.setSellerPackageVersionExpression("seller_package_version + 1");
                sellerPackageCountInfo.setSellerPackageUsedExpression("seller_package_used -" + count);
                sellerPackageCountInfo.setSellerPackageRemainExpression("seller_package_remain +" + count);
            } else if (SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_EXPIRED.equals(doFlag)) {
                sellerPackageCountInfo.setSellerPackageVersionExpression("seller_package_version + 1");
                sellerPackageCountInfo.setSellerPackageExpiredExpression("seller_package_expired +" + count);
                sellerPackageCountInfo.setSellerPackageRemainExpression("seller_package_remain -" + count);
            } else {
                // 参数不正确
                return -1;
            }

            // 执行短信统计信息消费更新
            upNum = sellerPackageCountMapper.updateByExampleSelective(sellerPackageCountInfo, sellerPackageCountExample);

            // 更新成功
            if (1 == upNum) {
                logger.info("商户ID：" + sellerID + ",更新成功。");

                if (0 < doNum) {
                    logger.info("商户ID：" + sellerID + "并发重试" + doNum + "次成功。");
                }
                break;
            }
            doNum++;
        } while (doNum <= reTryNum);

        return upNum;
    }


    /**
     * 根据商户ID和用户手机号码判断是不是短信疲劳
     *
     * @param smsDetail 短信明细信息
     * @param saleType
     * @return true/false
     */
    public boolean isFatigueSms(SendDetail smsDetail, String saleType) {

        try {

            SendDetailExample sendDetailExample = new SendDetailExample();
            SendDetailExample.Criteria criteria = sendDetailExample.createCriteria();
            criteria.andUserSendAddressEqualTo(smsDetail.getUserSendAddress());
            criteria.andSellerIdEqualTo(smsDetail.getSellerId());
            criteria.andSaleTypeEqualTo(saleType);
            criteria.andIdNotEqualTo(smsDetail.getId());
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.getExpiredDay(-7));
            criteria.andStatusEqualTo(SmsConstant.SMS_SEND_STATUS_SUCCESS);
            //criteria.andSendPriorityLessThan("5");
            List<SendDetail> sendDetailList = sendDetailMapper.selectByExample(sendDetailExample);
            if (null != sendDetailList && !sendDetailList.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            logger.error("SendSmsService.isFatigueSms():查询用户疲劳情况时异常。", e);
        }
        return false;
    }


    /**
     * 根据seqId 任务ID
     *
     * @param seqId 任务ID
     * @return 发送明细
     */
    public List<SendDetail> getSendDetailBySeqId(String seqId) {
        SendDetailExample sendDetailExample = new SendDetailExample();
        SendDetailExample.Criteria criteria = sendDetailExample.createCriteria();
        criteria.andSeqIdEqualTo(seqId);

        return sendDetailMapper.selectByExample(sendDetailExample);

    }

    /**
     * 根据seqId查询任务计划
     *
     * @param sellerId 商户ID
     * @param seqId    任务ID
     * @return
     */
    public SendPlan getSendPlanBySeqId(String sellerId, String seqId) {
        SendPlanExample sendPlanExample = new SendPlanExample();
        SendPlanExample.Criteria criteria = sendPlanExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andSeqIdEqualTo(seqId);
        List<SendPlan> sendPlanList = sendPlanMapper.selectByExample(sendPlanExample);
        if (sendPlanList == null || sendPlanList.isEmpty()) {
            return null;
        }

        return sendPlanList.get(0);
    }

    /**
     * 根据activityId查询任务计划
     * @param sellerId 商户ID
     * @param activityId 营销ID
     * @return
     */
    public SendPlan getSendPlanByActivityId(String sellerId, String activityId) {
        SendPlanExample sendPlanExample = new SendPlanExample();
        SendPlanExample.Criteria criteria = sendPlanExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andActivityIdEqualTo(activityId);
        List<SendPlan> sendPlanList = sendPlanMapper.selectByExample(sendPlanExample);
        if (sendPlanList == null || sendPlanList.isEmpty()) {
            return null;
        }

        return sendPlanList.get(0);
    }


    /**
     * 更新短信明细状态
     *
     * @param smsDetailList
     */
    public void updateSmsDetailStatus(List<SendDetail> smsDetailList, String status) {
        for (SendDetail smsDetail : smsDetailList) {
            updateSmsDetailStatus(smsDetail, status);
        }
    }


    /**
     * 根据SEQID更新计划ID
     *
     * @param seqId
     * @param sendPlan
     * @return
     */
    public int updateSendPlanInfo(String seqId, SendPlan sendPlan) {

        AssertsUtil.notNull(sendPlan, "sendPlan is null");

        SendPlanExample sendPlanExample = new SendPlanExample();
        sendPlanExample.createCriteria().andSeqIdEqualTo(seqId);

        return sendPlanMapper.updateByExampleSelective(sendPlan, sendPlanExample);
    }

    /**
     * 更新短信明细状态信息
     *
     * @param mobile
     * @param seqId
     * @param status
     * @return
     */
    public int updateSmsDetailStatus(String mobile, String seqId, String status) {
        int code = -1;
        try {
            SendDetailExample smsDetailExample = new SendDetailExample();
            SendDetailExample.Criteria criteria = smsDetailExample.createCriteria();
            criteria.andUserSendAddressEqualTo(mobile);
            criteria.andSeqIdEqualTo(seqId);
            SendDetail smsDetailUpd = new SendDetail();
            smsDetailUpd.setStatus(status);
            code = sendDetailMapper.updateByExampleSelective(smsDetailUpd, smsDetailExample);
            if (code == 1) {

                logger.info("updateSmsDetailStatus successful");
            }

        } catch (Exception e) {
            logger.error("updateSmsDetailStatus failed", e);
        }
        return code;
    }

    /**
     * 更新短信明细状态
     *
     * @param smsDetail 短信明细
     * @param status    状态
     * @return 更新成功数量
     */
    public int updateSmsDetailStatus(SendDetail smsDetail, String status) {
        SendDetailExample smsDetailExample = new SendDetailExample();
        SendDetailExample.Criteria criteria = smsDetailExample.createCriteria();
        criteria.andUserSendAddressEqualTo(smsDetail.getUserSendAddress());
        criteria.andSeqIdEqualTo(smsDetail.getSeqId());
        SendDetail smsDetailUpd = new SendDetail();
        smsDetailUpd.setStatus(status);
        return sendDetailMapper.updateByExampleSelective(smsDetailUpd, smsDetailExample);
    }


    public int updatePackageDetailRemainTry(String mobile, String seqId) {

        int code = -1;
        SendDetailExample sendDetailExample = new SendDetailExample();
        sendDetailExample.createCriteria().andSeqIdEqualTo(seqId).andUserSendAddressEqualTo(mobile);
        List<SendDetail> sendDetailList = sendDetailMapper.selectByExample(sendDetailExample);
        if (sendDetailList != null && !sendDetailList.isEmpty()) {
            code = updatePackageDetailRemainTry(Long.valueOf(sendDetailList.get(0).getPackageId()), "SMS", 1, SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK);
        }
        return code;
    }


    /**
     * 更新订购套餐退费，乐观锁机制，支持并发重试。
     *
     * @param smsOrderId 订购ID
     * @param count      使用数据
     * @param doFlag     动作：消费/退费
     * @return
     */
    public int updatePackageDetailRemainTry(Long smsOrderId, String type, int count, String doFlag) {

        int upNum = 0;
        int reTryNum = 2;  // 重试次数
        int doNum = 0;  // 执行计数
        do {
            upNum = updatePackageDetailRemain(smsOrderId, type, count, doFlag);
            if (1 == upNum) {
                if (0 < doNum) {
                    logger.info("订购ID：" + smsOrderId + "并发重试" + doNum + "次成功。");
                }
                break;
            }
            doNum++;

        } while (doNum <= reTryNum);

        return upNum;
    }


    /**
     * 更新短信订购套餐计费信息,乐观锁机制
     *
     * @param packageID 订购ID
     * @param count     使用数
     * @param doFlag    动作：消费/退费
     * @return 失败：-1，成功：1
     */
    public int updatePackageDetailRemain(Long packageID, String type, int count, String doFlag) {
        // 根据订购ID查询短信订购套餐
        SellerPackageDetailExample sellerpackageDetailExample = new SellerPackageDetailExample();

        sellerpackageDetailExample.createCriteria().andPackageTypeEqualTo(type).andIdEqualTo(packageID);
        List<SellerPackageDetail> packageDetailList = sellerPackageDetailMapper.selectByExample(sellerpackageDetailExample);
        if (packageDetailList == null || packageDetailList.isEmpty()) {
            logger.info("SmsBizService.updatePackageDetailRemain()更新消费套餐计费时，未找到订购ID为" + packageID + "记录。");
            return -1;
        }

        int reCount = 0;
        // 更新短信订购套餐计费，乐观锁机制。
        SellerPackageDetail sellerPackageDetail = new SellerPackageDetail();
        if (SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT.equals(doFlag)) {
            sellerPackageDetail.setPackageRemainExpression("package_remain -" + count);
        } else if (SmsConstant.SMS_UPDATE_SMSCOUNT_DOFLAG_BACK.equals(doFlag)) {
            sellerPackageDetail.setPackageRemainExpression("package_remain +" + count);
        } else {
            logger.info("SmsBizService.updatePackageDetailRemain()方法doFlag参数不正确.");
            return -1;
        }
        sellerPackageDetail.setPackageVersionExpression("package_version +" + 1);

        SellerPackageDetailExample updateSellerPackageDetailExample = new SellerPackageDetailExample();
        updateSellerPackageDetailExample.createCriteria().andIdEqualTo(packageID).andPackageVersionEqualTo(packageDetailList.get(0).getPackageVersion());


        reCount = sellerPackageDetailMapper.updateByExampleSelective(sellerPackageDetail, updateSellerPackageDetailExample);
        if (0 == reCount) {
            logger.info("SmsBizService.updatePackageDetailRemain()消费订购表更新失败。");
            return -1;
        }
        logger.info("SmsBizService.updatePackageDetailRemain()消费订购表更新成功。");
        return reCount;

    }

    /**
     * 发送帐户检查，是否允许
     *
     * @param sellerId   商户ID
     * @param type       类型，短信、邮件
     * @param sendAmount 发送量
     * @return
     */
    public boolean sendAccountCheck(String sellerId, String type, int sendAmount) {

        SellerPackageCount sellerPackageCount = getSellerPackageCount(sellerId, type);

        if (sellerPackageCount != null) {

            if (sellerPackageCount.getSellerPackageRemain() < sendAmount) {
                return false;
            }
        }

        return true;

    }


}
