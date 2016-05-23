package com.shufensoft.crm.ruleEngine.enums;

import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 规则类型
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/19  
 */
public enum RuleType {

    /**
     * 红包活动规则
     */
    HB_POOL("HB_POOL", "红包活动规则"),

    /**
     * 红包活动提现规则
     */
    HB_CASH("HB_CASH", "红包活动提现规则"),

    /**
     * 好评红包规则
     */
    HB_PRAISE("HB_PRAISE", "好评红包规则"),

    /**
     * 积分自定义规则
     */
    INTEGRAL_CONFIG_CUSTOM("INTEGRAL_CONFIG_CUSTOM","积分自定义规则"),

    /**
     * 积分系统默认规则
     */
    INTEGRAL_CONFIG_SYS("INTEGRAL_CONFIG_SYS","积分系统默认规则"),;



    // 成员变量
    private String code;
    private String value;

    private RuleType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static RuleType getEnumByCode(String code) {
        RuleType[] values = RuleType.values();
        for (RuleType operate : values) {
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
