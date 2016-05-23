package com.shufensoft.crm.common.utils;

import org.junit.Test;

import java.math.BigDecimal;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/25  
 */
public class CommonUtilTest {

    @Test
    public void testLongDivide(){

        Long p1 = 1234567L;
        Long p2 = 100L;

        BigDecimal result = CommonUtil.longDivide(887L,100L);
        System.out.println(result.toString());

        BigDecimal temp = new BigDecimal(String.valueOf(50));
        BigDecimal bb = result.multiply(temp);
        System.out.println(bb.longValue());

    }
}
