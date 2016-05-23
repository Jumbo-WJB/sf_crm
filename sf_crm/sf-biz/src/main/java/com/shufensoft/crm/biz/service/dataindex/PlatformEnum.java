package com.shufensoft.crm.biz.service.dataindex;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-28 16:32  
 */
public enum PlatformEnum {

    TB("trade"), JD("jingdong"), YZ("youzan"), WX("weixin"), ALL("all");

    private String value;

    private PlatformEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public boolean equals(PlatformEnum platformEnum) {
        if(this.value.equals(platformEnum.toString())) {
                return true;
        } else {
            return false;
        }
    }

}
