package com.shufensoft.crm.biz.service.pointmall.vo;

import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-07 15:41  
 */
@ToString
public class ShippingVo {

    // 快递类型
    private String type;

    // 快递公司
    private String company;

    // 运单号
    private String id;

    private long fee = 0L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }
}
