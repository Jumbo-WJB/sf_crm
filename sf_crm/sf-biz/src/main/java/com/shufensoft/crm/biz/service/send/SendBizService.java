package com.shufensoft.crm.biz.service.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.send.SendDetail;
import com.shufensoft.crm.biz.domain.generation.send.SendPlan;

import java.util.List;

/**
 *  @ProjectName: sf_crm  
 *  @Description: 短信相关公用服务类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/24 0:44  
 */
public interface SendBizService {


    /**
     * 根据商户ID获取商户短信统计信息
     *
     * @return 商户套餐统计信息
     */

    public SellerPackageCount getSellerPackageCount(String sellerID, String sendType);


    /**
     * 发送帐户检查，是否允许
     *
     * @param sellerId   商户ID
     * @param type       类型，短信、邮件
     * @param sendAmount 发送量
     * @return
     */
    public boolean sendAccountCheck(String sellerId, String type, int sendAmount);


    /**
     * 根据商户ID和用户手机号码判断是不是短信疲劳
     *
     * @param smsDetail 短信明细信息
     * @param saleType
     * @return true/false
     */
    public boolean isFatigueSms(SendDetail smsDetail, String saleType);

    /**
     * 根据seqId 任务ID
     *
     * @param seqId 任务ID
     * @return 发送明细
     */
    public List<SendDetail> getSendDetailBySeqId(String seqId);

    /**
     * 更新商户套餐统计信息
     *
     * @param sellerID 商户ID
     * @param type     类型
     * @param count    数量
     * @param doFlag   动作
     * @return 执行条数
     */
    public int updateSellerPackageCount(String sellerID, String type, int count, String doFlag);

    /**
     * 更新短信明细状态
     *
     * @param smsDetailList
     */
    public void updateSmsDetailStatus(List<SendDetail> smsDetailList, String status);


    /**
     * 根据SEQID更新计划ID
     *
     * @param seqId    商户ID
     * @param sendPlan 发送计划
     * @return
     */
    public int updateSendPlanInfo(String seqId, SendPlan sendPlan);

    /**
     * 更新短信明细状态信息
     *
     * @param mobile
     * @param seqId
     * @param status
     * @return
     */
    public int updateSmsDetailStatus(String mobile, String seqId, String status);

    /**
     * 更新短信明细状态
     *
     * @param smsDetail 短信明细
     * @param status    状态
     * @return 更新成功数量
     */
    public int updateSmsDetailStatus(SendDetail smsDetail, String status);

    public int updatePackageDetailRemainTry(String mobile, String seqId);


    /**
     * 更新订购套餐退费，乐观锁机制，支持并发重试。
     *
     * @param smsOrderId 订购ID
     * @param count      使用数据
     * @param doFlag     动作：消费/退费
     * @return
     */
    public int updatePackageDetailRemainTry(Long smsOrderId, String type, int count, String doFlag);

    /**
     * 更新短信订购套餐计费信息,乐观锁机制
     *
     * @param packageID 订购ID
     * @param count     使用数
     * @param doFlag    动作：消费/退费
     * @return 失败：-1，成功：1
     */
    public int updatePackageDetailRemain(Long packageID, String type, int count, String doFlag);


    /**
     * 根据seqId查询任务计划
     *
     * @param sellerId 商户ID
     * @param seqId    任务ID
     * @return
     */
    public SendPlan getSendPlanBySeqId(String sellerId, String seqId);


    /**
     * 根据activityId查询任务计划
     *
     * @param sellerId   商户ID
     * @param activityId 营销ID
     * @return
     */
    public SendPlan getSendPlanByActivityId(String sellerId, String activityId);


}
