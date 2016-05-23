package com.shufensoft.crm.ruleEngine.operator.rule;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleOperator;
import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 "="号运算器
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/23  
 */
public class EqualOperator extends RuleOperator {

    public EqualOperator(){

        /**初始化运算符号*/
        this.setOperationalCharacter(OperationalCharacter.EQUAL.getCode());
    }

    @Override
    public boolean operate(String factValue, String expectationValue) {

        if(StringUtils.isBlank(factValue)){
             return false;
        }

        return factValue.equals(expectationValue);
    }

}
