package com.shufensoft.crm.biz.service.market;


import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/9/14 下午9:28  
 */
@DataSourceSwitch
public interface MarkBizService {

    /**
     * 更新营销明细状态
     *
     * @param activityId
     */
    public void updateMarketRecords(Long sellerId, Long activityId, String mobile, String status);


    /**
     * 营销活动的邮件打开率
     *
     * @param sellerId   商户ID
     * @param type       类型
     * @param activityId 营销活动ID
     * @return
     */
    public float sendEmailOpenRate(Long sellerId, String type, Long activityId);

    /**
     * 商户邮件总打开率
     *
     * @param sellerId 商户ID
     * @param type     类型
     * @return
     */
    public float sendEmailOpenRate(Long sellerId, String type);


    /**
     * 营销活动发送成功率
     *
     * @param sellerId   商户ID
     * @param type       发送类型
     * @param activityId 营销ID
     * @return
     */
    public float sendSucRate(Long sellerId, String type, Long activityId);

    /**
     * 商户发送总成功率
     *
     * @param sellerId 商户ID
     * @param type     发送类型
     * @return
     */
    public float sendSucRate(Long sellerId, String type);


    /**
     * 处理邮件内容
     *
     * @param content
     * @return
     */
    public String handleMailContent(String content);

    /**
     * 更新营销明细状态
     *
     * @param activityId
     */
    public void updateMailMarketRecords(Long sellerId, Long activityId, String email, String type, String status);
}
