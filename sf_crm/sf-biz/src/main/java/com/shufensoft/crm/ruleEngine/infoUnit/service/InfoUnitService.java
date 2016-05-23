package com.shufensoft.crm.ruleEngine.infoUnit.service;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 信息元服务父类
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/3  
 */
public class InfoUnitService {

    protected Long ruleObjId;

    protected Long sellerId;

    protected String actionValue;

    public void setRuleObjId(Long ruleObjId) {
        this.ruleObjId = ruleObjId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

}
