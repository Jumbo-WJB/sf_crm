package com.shufensoft.crm.ruleEngine.operator.rule;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleOperator;
import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 多值分布运算器
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/11 21:18  
 */
public class MultiValueOperator extends RuleOperator {


    public MultiValueOperator(){

        /**初始化运算符号*/
        this.setOperationalCharacter(OperationalCharacter.MULTIVALUE.getCode());
    }

    @Override
    public boolean operate(String factValue, String expectationValue) {
        if(StringUtils.isBlank(factValue)){
            return false;
        }
       String[] strArray=expectationValue.split(",");
       if(strArray.length>0){
           if(factValue.compareTo(strArray[0])<0){
               return   false;
           }
       }
        return true;
    }

}
