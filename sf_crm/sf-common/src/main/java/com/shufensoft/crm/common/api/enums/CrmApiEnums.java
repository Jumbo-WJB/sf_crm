package com.shufensoft.crm.common.api.enums;

import org.apache.commons.lang.StringUtils;

/**
 *  @ProjectName: sf-crm  
 *  @Description: CRM api
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/14 17:29  
 */
public enum CrmApiEnums {

    /**
     * 增加淘宝评价信息到crm
     */
    CRM_TAOBAO_COMMENT_ADD("/taobaoComment/add","增加淘宝评价信息到crm");

    // 成员变量
    private String code;
    private String value;

    private CrmApiEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static CrmApiEnums getEnumByCode(String code) {
        CrmApiEnums[] values = CrmApiEnums.values();
        for (CrmApiEnums operate : values) {
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
