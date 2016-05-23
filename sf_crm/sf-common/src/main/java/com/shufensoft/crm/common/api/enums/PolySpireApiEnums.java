package com.shufensoft.crm.common.api.enums;

import org.apache.commons.lang.StringUtils;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 聚石塔api
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/14 17:29  
 */
public enum PolySpireApiEnums {

    /**
     * 查询卖家的交易列表
     */
    TRADES_FULLINFO_GET("/trade/fullInfo","查询淘宝交易信息");

    // 成员变量
    private String code;
    private String value;

    private PolySpireApiEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static PolySpireApiEnums getEnumByCode(String code) {
        PolySpireApiEnums[] values = PolySpireApiEnums.values();
        for (PolySpireApiEnums operate : values) {
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
