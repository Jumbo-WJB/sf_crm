package com.shufensoft.crm.biz.constant;

/**
 *   
 *  @ProjectName: sf_crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/23 16:50  
 */
public class SmsConstant {


    /**
     * 短信发送状态-待发送
     */
    public static final String SMS_SEND_STATUS_TOSEND = "TO_SEND";
    /**
     * 短信发送状态-成功
     */
    public static final String SMS_SEND_STATUS_SUCCESS = "SEND_SUCCESS";

    /**
     * 发送完成
     */
    public static final String SEND_STATUS_COMPLETE = "SEND_COMPLETE";

    /**
     * 发送停止
     */
    public static final String SEND_STOP = "SEND_STOP";

    /**
     * 发送暂停
     */
    public static final String SEND_START = "SEND_START";

    /**
     * 短信退订
     */
    public static final String SMS_SEND_STATUS_TD = "TD";

    /**
     * 短信疲劳
     */
    public static final String SMS_SEND_STATUS_FATIGUE = "FATIGUE";

    /**
     * 短信发送状态-失败
     */
    public static final String SMS_SEND_STATUS_FAILED = "SEND_FAILED";



    /**
     * 短信报告失败
     */
    public static final String SMS_REPORT_STATUS_FALIED = "REPORT_FALIED";

    //public static final String SMS_REPORT_

    /**
     * 更新短信统计动作-消费
     */
    public static final String SMS_UPDATE_SMSCOUNT_DOFLAG_DEDUCT = "DEDUCT";

    /**
     * 更新短信统计动作-回退
     */
    public static final String SMS_UPDATE_SMSCOUNT_DOFLAG_BACK = "BACK";

    /**
     * 更新短信统计动作-过期
     */
    public static final String SMS_UPDATE_SMSCOUNT_DOFLAG_EXPIRED = "EXPIRED";

    /**
     * 发送返回码
     */
    public static final String ACCOUNT_ARREARS_CODE = "-2";

    /**
     * 发送成功返回码
     */
    public static final String SEND_SUCCESS_CODE = "0";

    /**
     * 发送失败返回码
     */
    public static final String SEND_FAILED_CODE = "-1";
}
