package com.shufensoft.crm.constant;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/17  
 */
public class WebConstant {

    /**
     * 关键字匹配类型
     */
    public interface scope {

        /**
         * 隐性授权
         */
        public static final String SNSAPI_BASE = "snsapi_base";

        /**
         * 显性授权
         */
        public static final String SNSAPI_USERINFO = "snsapi_userinfo";

    }


    /**
     * 客户购买类型
     */
    public interface CustomPurchaseType {

        /**
         * 潜在购买
         */
        public static final String POTENTIAL_PURCHASE = "POTENTIAL_PURCHASE";

        /**
         * 成功购买
         */
        public static final String SUCCESS_PURCHASE = "SUCCESS_PURCHASE";

    }

}
