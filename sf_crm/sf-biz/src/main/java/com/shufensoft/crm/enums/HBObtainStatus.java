package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @desc 红包领用状态
 * @company shufensoft
 * @date 2015/5/6
 * @author chenyogn
 * @version 1.0
 */
public enum HBObtainStatus {

    /**
     * 待领取
     */
    TORECEIVE("toReceive", "待领取"),

    /**
     * 已领取
     */
    RECEIVED("received", "已领取");


    // 成员变量
    private String code;
    private String value;

    private HBObtainStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static HBObtainStatus getEnumByCode(String code) {
        HBObtainStatus[] values = HBObtainStatus.values();
        for (HBObtainStatus operate : values) {
            if (StringUtils.equals(operate.getCode(), code)) {
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
