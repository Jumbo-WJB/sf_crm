package com.shufensoft.crm.ruleEngine.result;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  规则执行返回结果
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/14  
 */
@Data
public class EngineResult {

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;


    private Object result;

    /**
     * 返回码
     */
    public static interface ErrorCode{

        public static final String SYS_ERROR = "-1";

        /**
         * 不满足规则条件，比如红包已领完，活动已经结束，以及不满足其他的一些条件
         */
        public static final String RULE_VERIFY_ERROR = "-101";


        public static final String SUCCESS = "0";

    }
}
