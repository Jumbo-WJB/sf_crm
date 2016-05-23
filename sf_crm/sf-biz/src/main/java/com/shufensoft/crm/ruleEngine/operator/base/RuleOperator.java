package com.shufensoft.crm.ruleEngine.operator.base;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 规则表达式运算器
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/23  
 */
@Data
public abstract  class RuleOperator{

    /**
     * 运算符号
     */
    protected String operationalCharacter;

    /**
     * 运算
     * @param factValue
     * @param expectationValue
     * @return
     */
    public abstract boolean operate(String factValue, String expectationValue);

}
