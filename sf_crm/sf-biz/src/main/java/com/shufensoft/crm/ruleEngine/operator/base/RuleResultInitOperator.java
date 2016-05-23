package com.shufensoft.crm.ruleEngine.operator.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 规则结果初始化运算器
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/23  
 */
public abstract  class RuleResultInitOperator {

    /**
     * 运算符号
     */
    @Setter   @Getter
    protected String operationalCharacter;

    /**
     *
     * @param expectationValue
     * @return
     */
    public abstract List<Object> operate( String expectationValue);

}
