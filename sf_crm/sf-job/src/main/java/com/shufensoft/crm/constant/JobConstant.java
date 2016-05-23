package com.shufensoft.crm.constant;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/9  
 */
public class JobConstant {

    /**
     * job名称
     */
    public interface  JobName{

        /**
         * 淘宝交易数据同步job
         */
        public static final String TAOBAO_TRADE_SYNC_JOB = "TaoBaoTradeSyncJob";

        /**
         * 京东交易数据同步job
         */
        public static final String JD_ORDER_SYNC_JOB = "OrderJDSyncJob";


        /**
         * 淘宝交易数据同步job
         */
        public static final String TAOBAO_TRADE_TO_BUYPOINT_JOB = "TaoBaoTradeCreateBuyPoint";

        /**
         * 京东交易数据同步job
         */
        public static final String JD_ORDER_TO_BUYPOINT_JOB = "JdOrderCreateBuyPoint";

        /**
         * 有赞交易数据同步job
         */
        public static final String YZ_TRADE_TO_BUYPOINT_JOB = "YzTradeCreateBuyPoint";


        public static final String SHAKE_POINT_EXPIRE = "ShakeExpireJob";

        /**
         * 短信发送JOB
         */
        public static final String SMS_SEND_JOB = "SmsSendJob";

        /**
         * 邮件发送JOB
         */
        public static final String EMAIL_SEND_JOB = "EmailSendJob";

        /**
         * 邮件报告接收JOB
         */
        public static final String EMAIL_RECEIVE_JOB = "EmailReceiveJob";

        /**
         * 短信接收JOB
         */
        public static final String SMS_RECEIVE_JOB = "SmsReceiveJob";

        /**
         * 短信对帐JOB
         */
        public static final String SMS_CHECK_ACCOUNT_JOB = "SmsCheckAccountJob";

        /**
         * 零点JOB，检测营销套餐的过期处理
         */
        public static final String ZERO_TIME_JOB = "Zero_Time_Job";

        public static final String HBCASH_JOB = "HbCashJob";

        public static final String HBRETURN_JOB = "HbReturnJob";

        public static final String HBUSERBOUND_JOB = "HbuserBound_Job";

        public static final String BUY_POINT_JOB = "BuyPointJob";

        /**
         * 有赞交易数据同步job
         */
        public static final String YOUZAN_TRADE_SYNC_JOB = "YouZanTradeSyncJob";

        /**
         * 微信用户数据同步job
         */
        public static final String WX_USER_SYNC_JOB = "WXUserSyncJob";

        /**
         * 京东评价数据同步
         */
        public static final String JD_COMMENT_SYNC_JOB= "JDCommentSyncJob";

        /**
         * 用户生日提醒job
         */
        public static final String USER_BIRTHDAY_REMIND_JOB= "UserBirthdayRemindJob";

        /**
         * AccessToken 刷新job
         */
        public static final String TOKEN_REFRESH_JOB = "tokenRefreshJob";

        public static final String MARKET_SEND_JOB = "marketSendJob";

        public static final String DATA_IMPORT_JOB = "dataImportJob";
        /**
         * 各购物渠道用户数据计算job：如淘宝、天猫、京东等
         */
        public static final String CHANNEL_USER_DATA_ANALYSIS_JOB = "ChannelUserDataAnalysisJob";

        /**
         * 微信用户数据价值计算job
         */
        public static final String WX_USER_DATA_ANALYSIS_JOB = "WxUserDataAnalysisJob";


    }

}
