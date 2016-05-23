package com.shufensoft.crm.ruleEngine.infoUnit.binding;

import lombok.Data;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                信息元服务绑定类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/3  
 */
@Data
public class InfoUnitServiceBinding {

    /**
     * 信息元class(即实际对象class)
     */
    private  Class<?> factObjectClass;

    /**
     * 信息元对象对应属性名
     */
    private String factAttributeName;

    /**
     * 信息元服务class
     */
    private Class<?> infoUnitServiceClass;

    /**
     * 信息元服务方法名
     */
    private String serviceMethodName;

    public InfoUnitServiceBinding() {
    }

    public InfoUnitServiceBinding(Class<?> infoUnitServiceClass,String serviceMethodName,Class<?> factObjectClass,String factAttributeName){

        this.infoUnitServiceClass = infoUnitServiceClass;
        this.serviceMethodName = serviceMethodName;
        this.factObjectClass = factObjectClass;
        this.factAttributeName = factAttributeName;

    }

}
