package com.shufensoft.crm.biz.service.market;



/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/8/12 下午9:21  
 */
public interface MarketService {

    /**
     * 发送待发送状态下的短信
     */
    public void marketActivitySendSms(Long sellerId);

    /**
     * 发送待发送状态下的邮件
     */
    public void marketActivitySendEmail(Long sellerId);

    /**
     * 更新营销表的状态。
     * @param sellerId
     * @param activityId
     * @param status
     */
    public void updateMarketActivity(Long sellerId,Long activityId,String status);




}
