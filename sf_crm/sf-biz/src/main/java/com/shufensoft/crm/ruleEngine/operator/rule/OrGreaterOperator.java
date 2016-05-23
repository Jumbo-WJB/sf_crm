package com.shufensoft.crm.ruleEngine.operator.rule;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleOperator;
import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>  或大于运算器 传入的值以|分开,只要一个实际值大于期望值即成立</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/8/7  
 */
public class OrGreaterOperator extends RuleOperator {

    public OrGreaterOperator(){

        /**初始化运算符号*/
        this.setOperationalCharacter(OperationalCharacter.ORGREATER.getCode());
    }


    @Override
    public boolean operate(String factValue, String expectationValue) {

        if(StringUtils.isBlank(factValue)||StringUtils.isBlank(expectationValue)){
            return false;
        }

        String[] strArray=factValue.split("\\|");

        for(String  str:strArray){
            if(Long.valueOf(str)>Long.valueOf(expectationValue)){
                return true;
            }
        }

        return false;
    }

}
