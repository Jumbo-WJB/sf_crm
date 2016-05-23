package com.shufensoft.crm.biz.service.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.service.send.vo.SellerPackageCountVO;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/2 19:26  
 */
@DataSourceSwitch
public interface SendService {

    /**
     * 发送及时邮件
     *
     * @param sellerId     商户ID
     * @param saleType     营销类型
     * @param subject      邮件标题
     * @param content      邮件内容
     * @param targetNumber 邮件目标地址
     * @return 0:成功,-1:失败
     */
    public String sendEmail(String sellerId, String saleType, String subject, String content, String targetNumber);

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
    public String sendSms(String sellerId, String saleType, String type, String mobile, String smsContent, String isFatigue);

    /**
     * 发送短信验证码
     *
     * @param sellerId   商户ID
     * @param mobile     手机号码
     * @param smsContent 短信内容
     * @return -1:失败,0:成功
     */
    public String sendSmsVerifyCode(String sellerId, String mobile, String smsContent);

    /**
     * 短信发送
     *
     * @param smsVO 短信信息
     * @return 0成功,-1失败
     */
    public String smsSend(SmsVO smsVO);


    /**
     * 可用短信数量查询
     *
     * @param sellerID 商户ID
     * @param type     sms\mail
     * @return 返回短信可用数量
     */
    public SellerPackageCount querySellerPackageCountBySellerID(String sellerID, String type);


    /**
     * 查询商家的短信及邮件信息统计
     *
     * @param sellerId 商户ID
     * @param type     类型，SMS：短信，MAIL:邮件
     * @return
     */
    public SellerPackageCountVO querySellerSendCount(String sellerId, String type);


}
