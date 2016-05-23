package com.shufensoft.crm.ruleEngine.exeception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 规则异常基类
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/26  
 */
public class RuleEngineException extends RuntimeException {

    public RuleEngineException() {
        super();
    }

    public RuleEngineException(String message) {
        super(" service execute error,errorMsg:"+message);
    }

    public RuleEngineException(String ruleEngineClassName, String method, String message) {

        super(" ruleEngine["+ruleEngineClassName+"] "+(method==null?"":method)+" execute error,errorMsg:"+message);
    }

    public RuleEngineException(String ruleEngineClassName, String method, Throwable cause) {

        super(" ruleEngine["+ruleEngineClassName+"] "+(method==null?"":method)+" execute error",cause);
    }

    public RuleEngineException(String ruleEngineClassName, String method, String message, Throwable cause) {

        super(" ruleEngine["+ruleEngineClassName+"] "+(method==null?"":method)+" execute error,errorMsg:"+message,cause);

    }

    public RuleEngineException(Throwable cause) {
        super(cause);
    }
}
