package com.shufensoft.crm.web.controller.wechat.constant;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  微信相关常量
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/4  
 */
public class WXConstant {

    /**
     * 微信消息类型
     */
    public interface  WXMessageType{

        /**
         * 文本
         */
        public static final String TEXT = "text";

        /**
         * 事件
         */
        public static final String EVENT = "event";

    }

    /**
     * 微信事件
     */
    public interface  WXEvent{

        /**
         * 关注
         */
        public static final String SUBSCRIBE = "subscribe";

        /**
         * 取消关注
         */
        public static final String UN_SUBSCRIBE= "unsubscribe";

    }

    /**
     * 微信消息类型
     */
    public interface  WXMeassgeType{

        /**
         * 文本
         */
        public static final String TEXT = "text";

        /**
         * 图片
         */
        public static final String IMAGE= "image";

        /**
         * 语音
         */
        public static final String VOICE= "voice";

        /**
         * 小视屏
         */
        public static final String SHORTVIDEO= "shortvideo";


        /**
         * 视屏
         */
        public static final String VIDEO= "video";

        /**
         * 地理位置
         */
        public static final String LOCATION= "location";

        /**
         * 链接
         */
        public static final String LINK= "link";

        /**
         * 图文
         */
        public static final String NEWS= "news";

    }

}
