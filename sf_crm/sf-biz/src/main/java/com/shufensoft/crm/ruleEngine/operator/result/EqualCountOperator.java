package com.shufensoft.crm.ruleEngine.operator.result;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleResultInitOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 等于/数量运算符
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/6 15:05  
 */
public class EqualCountOperator  extends RuleResultInitOperator {

    public  EqualCountOperator(){
        /**初始化运算符号*/
        this.setOperationalCharacter(OperationalCharacter.EQUALCOUNT.getCode());
    }
    @Override
    /**
     * expectationValue  期望值 例:2/10,3/8  金额为2的10个,金额为3的8个
     */
    public List<Object> operate( String expectationValue) {
         List<Object> list =new ArrayList<Object>();
         String[] expectationValues= expectationValue.split(",");
         for(String  expectationValueNew:expectationValues){
             String[]  str=expectationValueNew.split("/");
             String  ammout=str[0];//金额
              int     number=Long.valueOf(str[1]).intValue();//数量
              Long   ammoutValue=Long.valueOf(ammout);
                 //根据数量循环构建map,key:金额 value:金额
                 for(int i=0;i<number;i++){
                     Map<String,Object> mp=new HashMap<String,Object>();
                     mp.put("ammout_range",ammout);
                     mp.put("value",ammoutValue);
                     list.add(mp);
                 }
         }
        return list;
    }
}
