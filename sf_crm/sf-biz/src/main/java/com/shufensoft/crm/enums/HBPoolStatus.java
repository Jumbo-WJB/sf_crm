package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @desc 红包活动状态
 * @company shufensoft
 * @date 2015/5/6
 * @author chenyogn
 * @version 1.0
 */
public enum HBPoolStatus {

    /**
     * 未关联
     */
    UNBOUNDED("unBounded", "未关联"),

    /**
     * 待领取
     */
    UNRECEIVED("unReceived", "待领取"),

    /**
     * 领取中
     */
    RECEIVING("receiving", "领取中"),

    /**
     * 结束
     */
    DONE("done", "结束");


    // 成员变量
    private String code;
    private String value;

    private HBPoolStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static HBPoolStatus getEnumByCode(String code) {
        HBPoolStatus[] values = HBPoolStatus.values();
        for (HBPoolStatus operate : values) {
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
