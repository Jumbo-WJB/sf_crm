package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @desc 淘宝交易状态
 * @company shufensoft
 * @date 2015/5/6
 * @author litu
 * @version 1.0
 */
public enum TaoBaoOrderStatus {

    /**
     * 没有创建支付宝交易
     */
    TRADE_NO_CREATE_PAY("TRADE_NO_CREATE_PAY", "没有创建支付宝交易"),

    /**
     * 等待买家付款
     */
    WAIT_BUYER_PAY("WAIT_BUYER_PAY", "等待买家付款"),

    /**
     * 卖家部分发货
     */
    SELLER_CONSIGNED_PART("SELLER_CONSIGNED_PART", "卖家部分发货"),

    /**
     * 等待卖家发货
     */
    WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS", "等待卖家发货"),

    /**
     * 交易成功
     */
    TRADE_BUYER_SIGNED("TRADE_BUYER_SIGNED", "交易成功"),

    /**
     * 交易自动关闭
     */
    TRADE_CLOSED("TRADE_CLOSED", "交易自动关闭"),

    /**
     * 卖家或买家主动关闭交易
     */
    TRADE_CLOSED_BY_TAOBAO("TRADE_CLOSED_BY_TAOBAO", "交易关闭"),

    /**
     * 国际信用卡支付付款确认中
     */
    PAY_PENDING("PAY_PENDING", "国际信用卡支付付款确认中"),

    /**
     * 0元购合约中
     */
    WAIT_PRE_AUTH_CONFIRM("WAIT_PRE_AUTH_CONFIRM", "0元购合约中");


    // 成员变量
    private String code;
    private String value;

    private TaoBaoOrderStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static TaoBaoOrderStatus getEnumByCode(String code) {
        TaoBaoOrderStatus[] values = TaoBaoOrderStatus.values();
        for (TaoBaoOrderStatus operate : values) {
            if (StringUtils.equals(operate.getCode(), code)) {
                return operate;
            }
        }
        return null;
    }

    /**
     * 根据业务值获得业务code
     *
     * @param value 业务值
     * @return 业务类型
     */
    public static TaoBaoOrderStatus getEnumByValue(String value) {
        TaoBaoOrderStatus[] values = TaoBaoOrderStatus.values();
        for (TaoBaoOrderStatus operate : values) {
            if (StringUtils.equals(operate.getValue(), value)) {
                return operate;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
