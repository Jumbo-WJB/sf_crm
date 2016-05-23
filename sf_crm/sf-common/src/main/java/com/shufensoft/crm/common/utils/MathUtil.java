package com.shufensoft.crm.common.utils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-17 20:23  
 */
public class MathUtil {

    public static final boolean isNotPositive(Long number) {
        if(number == null || number <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static final boolean isPositive(Long number) {
        if(number == null || number <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
