package com.shufensoft.crm.biz.service.cvm;

import net.sourceforge.jeval.EvaluationException;

/**
 *  CVM常量类
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-15 20:02  
 */
public class CvmConstants {

    /**
     * 维度常量：最近一次购买天数
     */
    public final static String LASTDAY_NAME = "最近一次购买天数";
    public final static String LASTDAY_EXPRESSION = "96.595 * pow(#{E}, -0.002 * #{param1})";
    public final static double LASTDAY_COEFFICIENT = 1.0d;

    /**
     * 维度常量：购买次数
     */
    public final static String TRADECNT_NAME = "购买天数";
    // param1 > 10时，返回9.15
//    public final static String TRADECNT_EXPRESSION = "ifThenElse('#{param1} > 10`100`" +
//            "-0.0768 * pow(#{param1},4) + 2.0401 * pow(#{param1},3) - 19.725 * pow(#{param1},2) " +
//            "+ 84.567 * #{param1} - 46.25')";
    public final static String TRADECNT_EXPRESSION = "kv('#{param1}" +
            "^1`20^2`60^3`80^4`85^5`90^6`93^7`96^8`98^9`99^10`100')";
    public final static double TRADECNT_COEFFICIENT = 1.0d;

    /**
     * 维度常量：购买金额
     */
    public final static String TRADEAMOUNT_NAME = "购买次数";
    // param1 > 1000时，都返回60
    public final static String TRADEAMOUNT_EXPRESSION = "ifThenElse('#{param1} > 1000`100`" +
            "0.1 * #{param1}')";
    public final static double TRADEAMOUNT_COEFFICIENT = 1.0d;

    /**
     * 维度常量：评价
     */
    public final static String COMMENT_NAME = "评价";
    // param1 > 1000时，都返回60
    public final static String COMMENT_EXPRESSION = "comment('#{param1}')";
    public final static double COMMENT_COEFFICIENT = 1.0d;

    public static void main(String[] args) throws EvaluationException {
        CvmDimComputor cvmDimComputor = new CvmDimComputor(CvmConstants.COMMENT_NAME, CvmDimTypeEnum.GLOBAL,
                CvmConstants.COMMENT_EXPRESSION, CvmConstants.COMMENT_COEFFICIENT);
        double tradecnt = cvmDimComputor.compute("abcde^defg");
        System.out.println(tradecnt);
    }

}
