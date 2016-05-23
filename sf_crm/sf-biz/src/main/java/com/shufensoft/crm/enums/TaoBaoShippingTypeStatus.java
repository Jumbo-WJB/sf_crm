package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @desc 物流方式
 * @company shufensoft
 * @date 2015/5/6
 * @author litu
 * @version 1.0
 */
public enum TaoBaoShippingTypeStatus {

    /**
     * 没有创建支付宝交易
     */
    FREE("free", "卖家包邮"),

    /**
     * 平邮
     */
    POST("post", "平邮"),

    /**
     * 快递
     */
    EXPRESS("express", "快递"),

    /**
     * EMS
     */
    EMS("ems", "EMS"),

    /**
     * 虚拟发货
     */
    VIRTUAL("virtual", "虚拟发货"),

    /**
     * 次日必达
     */
    TWENTY_FIVE("25", "次日必达"),

    /**
     * 预约配送
     */
    TWENTY_SIX("26", "预约配送");


    // 成员变量
    private String code;
    private String value;

    private TaoBaoShippingTypeStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static TaoBaoShippingTypeStatus getEnumByCode(String code) {
        TaoBaoShippingTypeStatus[] values = TaoBaoShippingTypeStatus.values();
        for (TaoBaoShippingTypeStatus operate : values) {
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
    public static TaoBaoShippingTypeStatus getEnumByValue(String value) {
        TaoBaoShippingTypeStatus[] values = TaoBaoShippingTypeStatus.values();
        for (TaoBaoShippingTypeStatus operate : values) {
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
