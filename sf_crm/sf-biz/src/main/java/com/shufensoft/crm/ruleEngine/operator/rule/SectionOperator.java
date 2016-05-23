package com.shufensoft.crm.ruleEngine.operator.rule;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleOperator;
import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 区间运算符
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/28 14:28  
 */
public class SectionOperator extends RuleOperator{


      public  SectionOperator(){
          /**初始化运算符号*/
          setOperationalCharacter(OperationalCharacter.SECTION.getCode());
      }

    @Override
    public boolean operate(String factValue, String expectationValue) {
        if(StringUtils.isBlank(factValue)){
            return false;
        }
        if(StringUtils.isBlank(expectationValue)){
            return false;
        }
        String[] strs=expectationValue.split(",");//以-号形式隔开
         if(strs.length>=2){
           String  valStart=  strs[0];//开始值
           String  valEnd= strs[1];//结束值
           if(!StringUtils.isBlank(valStart)&&StringUtils.isBlank(valEnd)) {//当开始值不为空,结束值为空
              if(factValue.compareTo(valStart)>=0)
                  return true;
               else
                  return false;
           }else  if(StringUtils.isBlank(valStart)&&!StringUtils.isBlank(valEnd)){//当开始值为空,结束值不为空
             if(factValue.compareTo(valEnd)<=0)
                 return true;
              else
                 return false;
          }else if(!StringUtils.isBlank(valStart)&&!StringUtils.isBlank(valEnd) ){//当开始值和结束值都不为空
               if(factValue.compareTo(valStart)>=0&&factValue.compareTo(valEnd)<=0)
                   return true;
               else
                   return  false;
           }
           }
        return  false ;
    }

}
