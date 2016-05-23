package com.shufensoft.crm.biz.service.dataindex;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-27 21:34  
 */
public enum DataTypeEnum {

    TRADE_TB("trade_tb"), ORDER_TB("order_tb"), COMMENT_TB("comment_tb"), RECEIVER_TB("receiver_tb"), GOODS_TB("goods_tb"),
    TRADE_JD("trade_jd"), ORDER_JD("order_jd"), COMMENT_JD("comment_jd"), RECEIVER_JD("receiver_jd"), GOODS_JD("goods_jd"),
    USER("user"), USER_ACCOUNT("user_account"), INTERACTION("interaction");

    private String value;

    private DataTypeEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public boolean equals(DataTypeEnum dataTypeEnum) {
        if(this.value.equals(dataTypeEnum.toString())) {
            return true;
        } else {
            return false;
        }
    }

}
