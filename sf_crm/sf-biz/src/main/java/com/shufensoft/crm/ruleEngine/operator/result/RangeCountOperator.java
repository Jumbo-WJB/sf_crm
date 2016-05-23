package com.shufensoft.crm.ruleEngine.operator.result;

import com.shufensoft.crm.ruleEngine.enums.OperationalCharacter;
import com.shufensoft.crm.ruleEngine.operator.base.RuleResultInitOperator;

import java.math.BigDecimal;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 随机/数量运算符
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/6 13:25  
 */
public class RangeCountOperator  extends RuleResultInitOperator {

    public  RangeCountOperator(){
        /**初始化运算符号*/
        this.setOperationalCharacter(OperationalCharacter.RANGECOUNT.getCode());
    }
    @Override
    /**
     * expectationValue   1-2/10,3-5/8 例:金额为1-2的10个,金额为3-5的8个
     */
    public List<Object> operate( String expectationValue) {
        List<Object> list =new ArrayList<Object>();
        String[] expectationValues= expectationValue.split(",");
        for(String  expectationValueNew:expectationValues){
            String[]  str=  expectationValueNew.split("/");
            String  ammount=str[0];//金额
            int   number=Long.valueOf(str[1]).intValue();//数量
            /**
             * 根据数量循环构建map,key:随机区间 value:具体的结果值
             */
            Random random=new Random();
                for(int i=0;i<number;i++){
                    BigDecimal  bigDecimal=new BigDecimal(0);
                    Map<String,Object> mp=new HashMap<String,Object>();
                    String[] amm=ammount.split("-");
                    int  value= random.nextInt(Integer.valueOf(amm[1])-Integer.valueOf(amm[0])+1)+Integer.valueOf(amm[0]);
                    mp.put("ammout_range",ammount);
                    mp.put("value",Long.valueOf(value));
                    list.add(mp);
                }
        }
        return  list;
    }

}
