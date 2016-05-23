package com.shufensoft.crm.biz.constant;

/**
 *   
 *  @ProjectName: sf-web  
 *  @Description:
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
public class DaoConstant {

    /**
     * 删除状态常量
     */
    public interface IsDeleted {
        public static final String TRUE = "1";
        public static final String FALSE = "0";
    }


    /**
     * 更新or保存
     */
    public interface InsertOrUpdate {

        public static final int INSERT = 1;
        public static final int UPDATE = 0;
    }

    /**
     * 删除状态常量
     */
    public interface TrueOrFalse {
        public static final String TRUE = "true";
        public static final String FALSE = "false";
    }

    /**
     * 消息回复类型
     */
    public interface ReplyType {
        public static final String INTELLIGENCE = "intelligence";
        public static final String ARTIFICIAL = "artificial";
    }


    /**
     * 状态常量
     */
    public interface Status {
        public static final String VALID = "y";
        public static final String INVALID = "n";
    }

    /**
     * 是否验证 对应字段 user.is_verify
     */
    public interface IsVerify {
        public static final String YES = "1";
        public static final String NO = "0";
    }

    public interface YN {
        public static final String YES = "y";
        public static final String NO = "n";
    }


    /**
     * 互动入口
     */
    public interface IteractionEntry {

        /**
         * 链接
         */
        public static final String LINK = "link";

        /**
         * 摇一摇
         */
        public static final String SHAKE = "shake";

        /**
         * 互动来源
         */
        public static final String KEY_WORD = "key_word";

    }


    /**
     * 积分兑换方式
     */
    public interface PointExchangeMethod {

        /**
         * 红包
         */
        public static final String HONGBAO = "hongbao";

        /**
         * 商品
         */
        public static final String GOODS = "goods";

    }

    /**
     * 积分获取方式
     */
    public interface PointObtainMethod {

        /**
         * 签到
         */
        public static final String SIGN_IN = "sign_in";


        /**
         * 赠送
         */
        public static final String GIVE = "give";

        /**
         * 分享
         */
        public static final String SHARE = "share";

        /**
         * 摇一摇
         */
        public static final String SHAKE = "shake";

        /**
         * 生日
         */
        public static final String BIRTHDAY = "birthday";

        /**
         * 关注
         */
        public static final String SUBSCRIBE = "subscribe";

        /**
         * 购物
         */
        public static final String SHOPPING = "shopping";


    }

    /**
     * 积分兑换
     */
    public interface PointExchangeStatus {

        /**
         * 成功
         */
        public static final String SUCCESS = "success";

        /**
         * 失败
         */
        public static final String FAIL = "fail";

        /**
         * 积分兑换红包
         */
        public static final String WAIT_EXCHANGE = "wait_exchange";

        /**
         * 过期
         */
        public static final String EXPIRE = "expire";

        /**
         * 兑换完
         */
        public static final String OVER = "over";


    }

    public interface ShakeBizType {

        /**
         * 摇一摇摇积分
         */
        public static final String SHAKE_POINT = "point";

        /**
         * 摇一摇摇红包
         */
        public static final String SHAKE_HB = "hongbao";

        /**
         * 摇一摇礼物
         */
        public static final String SHAKE_GIFT = "gift";
    }

    /**
     * 摇一摇领取状态
     */
    public interface ShakeObtainStatus {
        /**
         * 待领取
         */
        public static final String TO_RECEIVE = "toReceive";

        /**
         * 已领取
         */
        public static final String RECEIVED = "received";

        /**
         * 已过期
         */
        public static final String EXPIRED = "expired";
    }

    /**
     * 红包状态
     */
    public interface HBStatus {

        /**
         * 待领取
         */
        public static final String TO_RECEIVE = "toReceive";

        /**
         * 已领取
         */
        public static final String RECEIVED = "received";

    }

    /**
     * 红包活动状态
     */
    public interface HBPoolStatus {

        /**
         * 未领取
         */
        public static final String UN_RECEIVE = "unReceive";

        /**
         * 领取中
         */
        public static final String RECEIVING = "receiving";

        /**
         * 已结束
         */
        public static final String DONE = "done";

        /**
         * 使用中
         */
        public static final String USING = "using";
    }

    /**
     * 红包类型
     */
    public interface HongBaoType {

        /**
         * 普通红包
         */
        public static final String COMMON = "common";

        /**
         * 好评红包
         */
        public static final String PRAISE = "praise";

        /**
         * 积分兑换红包
         */
        public static final String POINT_EXCHANGE = "point_exchange";

        /**
         * 摇一摇
         */
        public static final String SHAKE = "shake";


        /**
         * 生日
         */
        public static final String BIRTHDAY = "birthday";


    }


    /**
     * 微信是否关注
     */
    public interface WxSubscribe {
        public static final String YES = "1";
        public static final String NO = "0";
    }

    /**
     * 用来来源
     */
    public interface UserSource {
        public static final String TB = "TB";
        public static final String TMALL = "TMALL";
        public static final String JD = "JD";
        public static final String YZ = "YZ";
        public static final String WX = "WX";
    }

    /**
     * 接入方式
     */
    public interface AccessType {

        /**
         * 通用
         */
        public static final String GENERAL = "general";

        /**
         * 卖家自研
         */
        public static final String SELF_DEVELOPMENT = "self_development";

        /**
         * 浏览器插件
         */
        public static final String PLUGIN = "plugin";

    }

    /**
     * 订单来源
     */
    public interface TradeSource extends UserSource {

    }

    /**
     * 店铺类型
     */
    public interface ShopType extends UserSource {

    }

    public interface TfDigit {
        public static final String T = "1";
        public static final String F = "0";
    }

    /**
     * 关键字匹配类型
     */
    public interface MatchType {

        /**
         * 模糊匹配
         */
        public static final String VAGUE_MATCH = "0";

        /**
         * 精确匹配
         */
        public static final String PRECISE_MATCH = "1";
    }

    /**
     * 关键字匹配业务类型
     */
    public interface KeyWordBizType {

        /**
         * 积分兑换红包
         */
        public static final String POINT_EXCHANGE_HB = "point_exchange_hb";

        /**
         * 积分兑换商品
         */
        public static final String POINT_EXCHANGE_GOODS = "point_exchange_goods";

        /**
         * 快递查询
         */
        public static final String EXPRESS_QUERY = "express_query";

        /**
         * 普通红包领取
         */
        public static final String RECEIVE_COMMON_HB = "receive_common_hb";

        /**
         * 好评返红包
         */
        public static final String PRAISE_RECEIVE_HB = "praise_receive_hb";

        /**
         * 分享送红包
         */
        public static final String SHARE_RECEIVE_HB = "share_receive_hb";

        /**
         * 签到
         */
        public static final String SIGN_IN = "sign_in";

        /**
         * 用户验证
         */
        public static final String USER_VALIDATE = "user_validate";

        /**
         * 积分查询
         */
        public static final String POINT_QUERY = "point_query";

        /**
         * 摇一摇
         */
        public static final String SHAKE = "shake";

        /**
         * 生日
         */
        public static final String BIRTHDAY = "birthday";

        /**
         * 引导语
         */
        public static final String GUIDE = "guide";


    }

    /**
     * 微信消息发送类型
     */
    public interface UserWXMessageSendType {

        /**
         * 客户发送
         */
        public static final String FROM_CUSTOM = "from_custom";

        /**
         * 卖家发送
         */
        public static final String FROM_SELLER = "from_seller";

    }

    /**
     * 礼物来源
     */
    public interface GiftSource {
        /**
         * 摇一摇礼物
         */
        public static final String SHAKE = "shake";
        /**
         * 生日礼物
         */
        public static final String BIRTHDAY = "birthday";
    }

    /**
     * 活动类型
     */
    public interface ActivityType {

        /**
         * 红包
         */
        public static final String ACTIVITY_HONGBAO = "activity_hongbao";

        /**
         * 生日
         */
        public static final String ACTIVITY_BIRTHDAY = "activity_birthday";

        /**
         * 摇一摇活动
         * */
        public static final String ACTIVITY_SHAKE = "activity_shake";
        /**
         * 购物红包活动
         * */
        public static final String ACTIVITY_SHOPPING_HONGBAO = "activity_shopping_hongbao";

    }

    /**
     * 后台生日配置
     */
    public interface BirthdayConfig {
        /**
         * 生日红包
         */
        public static final String BIRTHDAY_HONGBAO = "birthday_red_packet";

        /**
         * 生日礼物
         */
        public static final String BIRTHDAY_GIFTS = "birthday_gifts";

        /**
         * 生日积分
         */
        public static final String BIRTHDAY_POINTS = "birthday_points";

        /**
         * 生日折扣
         */
        public static final String BIRTHDAY_DISCOUNT = "birthday_discount";

        /**
         * 自动选择客户
         */
        public static final String SEND_AUTO = "auto";

        /**
         * 手动选择客户
         */
        public static final String SEND_MANUAL = "manual";

        /**
         * 生日活动状态: 未开始
         */
        public static final String ACTIVITY_UNSTART = "unstart";

        /**
         * 生日活动状态: 开始
         */
        public static final String ACTIVITY_START = "start";

        /**
         * 生日活动状态: 停止
         */
        public static final String ACTIVITY_STOP = "stop";

        /**
         * 生日活动状态: 结束
         */
        public static final String ACTIVITY_OVER = "over";

    }

    /**
     * 快递业务
     */
    public interface Express {
        /**
         * 京东自己的物流
         */
        public static final String LOGISTICS_NAME_JD = "京东快递";

    }

    /**
     * 短信发送通道
     */
    public interface SmsSend {

        /**
         * 通知类
         */
        public static final String SEND_NOTIFY = "notify";

        /**
         * 营销类
         */
        public static final String SEND_SALE = "sale";
    }

    /**
     * 短信疲劳标识
     */
    public interface SmsFatigueFlag {

        /**
         * 需要疲劳处理
         */
        public static final String IS_FATIGUE = "1";

        /**
         * 不需要疲劳处理
         */
        public static final String IS_NOT_FATIGUE = "0";
    }

    /**
     * 短信营销类型
     */
    public interface SmsSaleType {

        /**
         * 红包提现提醒
         */
        public static final String HONGBAO_CASH = "hongbao_cash";

        /**
         * 生日提醒
         */
        public static final String SMS_BIRTHDAY = "sms_birthday";

        /**
         * token刷新提醒
         */
        public static final String SMS_TOKEN_REFRESH = "sms_token_refresh";

        /**
         * 短信验证码
         */
        public static final String SMS_VERIFY = "sms_verify";

        /**
         * 营销目的
         */
        public static final String SALE = "sale";

        /**
         * 增粉目的
         */
        public static final String INCREASE_FANS = "increase_fans";

        /**
         * 传播目的
         */
        public static final String SPREAD = "spread";

        /**
         * 其他
         */
        public static final String OTHER = "other";

        /**
         * 测试一下
         */
        public static final String Test = "test";

        /**
         * 短信验证
         */
        public static final String VERIFY = "verify";

    }


    /**
     * 积分帐户更新方式
     */
    public interface PointUpdateMethod {

        /**
         * 积分兑换
         */
        public static final String EXCHANGE = "exchange";

        /**
         * 积分消费，只减积分余额
         */
        public static final String DEDUCT = "DEDUCT";

        /**
         * 积分兑换
         */
        public static final String OBTAIN = "OBTAIN";

    }

    /**
     * 营销发送状态
     */
    public interface MarketSendStatus {

        /**
         * 发送成功
         */
        public static final String SUCCESS = "send_success";

        /**
         * 发送失败
         */
        public static final String FAILED = "send_failed";

        /**
         * 发送疲劳
         */
        public static final String FATIGUE = "send_fatigue";

        /**
         * 用户退订
         */
        public static final String TD = "send_td";

        /**
         * 发送取消
         */
        public static final String CANCEL = "send_cancel";

        /**
         * 待发送
         */
        public static final String TOSEND = "to_send";

        /**
         * 邮件打开
         */
        public static final String ISOPEND = "send_open";

        /**
         * 邮件未打开
         */
        public static final String UNOPEND = "send_unopen";

        /**
         * 发送帐户余额不足
         */
        public static final String ACCOUNT_ARREARS = "account_arrears";


    }

    /**
     * 营销发送状态
     */
    public interface MarketStatusType {

        /**
         * 是否成功状态
         */
        public static final String ISSUCCESS = "isSuccess";

        /**
         * 是否打开状态
         */
        public static final String ISOPEN = "isOpen";

        /**
         * 是否回弹
         */
        public static final String ISBACK = "isBack";

    }

    /**
     * 点赞入口来源
     */
    public interface DZEntryType {
        /**
         * 红包领取排行榜
         */
        public static final String HONGBAO_EXCHANGE_RANK = "hongbao_receive_rank";
        /**
         * 积分兑换排行榜
         */
        public static final String POINT_EXCHANGE_RANK = "point_exchange_rank";
    }

    /**
     * 微信多媒体文件格式
     */
    public interface WxMediaType{

        /**图片*/
        public static  final String IMAGE = "image";

        /**语音*/
        public static  final String VOICE = "voice";

        /**视频*/
        public static  final String VIDEO = "video";

        /**缩略图*/
        public static  final String THUMB = "thumb";
    }

    public interface ActivityStatus {

        /**
         * 开启
         */
        public static final String ACTIVITY_START = "start";

        /**
         * 暂停
         */
        public static final String ACTIVITY_STOP = "stop";

        /**
         * 进行中
         * */
        public static final String ACTIVITY_PROGRESSING = "progressing";
        /**
         * 结束
         * */
        public static final String ACTIVITY_END = "end";

    }

}
