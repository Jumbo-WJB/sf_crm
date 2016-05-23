package com.shufensoft.crm.common.api.enums;

import org.apache.commons.lang.StringUtils;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 口袋通Api枚举
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/14 17:29  
 */
public enum KdtApiEnums {

    /**
     * 查询卖家的交易列表
     */
    TRADES_SOLD_GET("kdt.trades.sold.get","查询卖家的交易列表"),

    /**
     * 物流流转信息查询
     */
    LOGISTICS_TRACE_SEARCH("kdt.logistics.trace.search","物流流转信息查询"),

    /**
     * 根据微信粉丝用户的 openid 或 user_id 获取用户信息
     */
    USER_WEIXIN_FOLLOWER_GET("kdt.users.weixin.follower.get","根据微信粉丝用户的 openid 或 user_id 获取用户信息");

    /**
     * 成员变量
     */
    private String code;
    private String value;

    private KdtApiEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static KdtApiEnums getEnumByCode(String code) {
        KdtApiEnums[] values = KdtApiEnums.values();
        for (KdtApiEnums operate : values) {
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
