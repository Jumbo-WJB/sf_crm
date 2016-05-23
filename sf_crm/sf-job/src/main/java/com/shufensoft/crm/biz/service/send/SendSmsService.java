package com.shufensoft.crm.biz.service.send;


import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/9 17:55  
 */
@DataSourceSwitch
public interface SendSmsService {


    /**
     * 接收短信订信息
     * @param type
     */
    public void receiveSmsMo(String sellerId,String type);


    /**
     * 接收并保存短信状态报告
     */
    public void receiveSmsStatusReport(String sellerId,String type);

    /**
     * 执行发送短信
     *
     * @return 0:成功，-1：失败
     */
    public int sendSms(String sellerId);

    /**
     * 发送邮件
     * @return
     */
    public int sendEmail(String sellerId);


    /**
     * 接收报告
     */
    public void receiveEmailReport(Long sellerId,Date startDate, Date endDate);


    /**
     * 根据短信报告结果更新短信明细
     */
    public void smsCheckAccount(String sellerId);

    /**
     * 检测处理过期短信套餐
     */
    public void checkSmsExpired(String sellerId);

}
