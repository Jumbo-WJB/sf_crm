package com.shufensoft.crm.ruleEngine.enums;

import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  运算符号
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/26  
 */
public enum OperationalCharacter {

    /**
     * 等号运算符
     */
    EQUAL("=", "等号运算符"),

    /**
     * 或等于运算符
     */
    OREQUAL("|=", "或等于运算符"),


    /**
     * 或大于运算符
     */
    ORGREATER("|>", "或大于运算符"),

    /**
     * 区间运算符
     */
    SECTION("[]","区间运算符"),


    /**
     * 随机数/数量运算符
     */
     RANGECOUNT("R[]/","随机/数量运算符"),


    /**
     * 相等/数量运算符
     */
    EQUALCOUNT("=/","等于/数量运算符"),


    /**
     * 多值分布运算符
     */
    MULTIVALUE("{}","等于/数量运算符");

    // 成员变量
    private String code;
    private String value;

    private OperationalCharacter(String code, String value) {
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
