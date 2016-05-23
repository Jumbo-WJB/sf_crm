package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p> 业务图片文件夹</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/4  
 */
public enum BizImgDirEnums {
    /**
     * 手机前端首页图片文件夹
     */
    MEMBER_DIR("mobile_index_dir","mobileIndex/");

    private String code;
    private String value;

    private BizImgDirEnums(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static BizImgDirEnums getEnumByCode(String code) {
        BizImgDirEnums[] values = BizImgDirEnums.values();
        for (BizImgDirEnums operate : values) {
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
