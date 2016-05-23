package com.shufensoft.crm.biz.service.cvm;

/**
 *   客户价值模型维度类型枚举类
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-14 11:39  
 */
public final class CvmDimTypeEnum {

    public static CvmDimTypeEnum GLOBAL = new CvmDimTypeEnum("global");

    public static CvmDimTypeEnum TRADE = new CvmDimTypeEnum("trade");

    private String type = null;

    private CvmDimTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean equals(CvmDimTypeEnum cvmDimTypeEnum) {
        if(this.type.equalsIgnoreCase(cvmDimTypeEnum.getType())) {
            return true;
        } else {
            return false;
        }
    }

    public CvmDimTypeEnum valueOf(String type) {
        if(GLOBAL.getType().equalsIgnoreCase(type)) {
            return GLOBAL;
        }
        if(TRADE.getType().equalsIgnoreCase(type)) {
            return TRADE;
        }

        return null;
    }

}
