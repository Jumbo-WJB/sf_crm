package com.shufensoft.crm.ruleEngine.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 规则表达式
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/19  
 */
@Data
public class RuleExpression implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8098452976629871712L;


    /**
     * 事实对象属性
     */
    private String fact_attribute;

    /**
     * 事实对象类名
     */
    private String fact_obj;

    /**
     * 运算符
     */
    private String operator;

    /**
     * 是否初始化表达式对应的结果(红包活动含有1-3金额的红包200个)
     */
    private Boolean initFlag;

    /**
     * 规则目标值
     */
    private String expectation_value;

    /**
     * 事实值
     */
    private String fact_value;

    /**
     * 条件不满足提醒
     */
    private String condition_remind;

    /**
     * 是否走规则引擎
     */
    private Boolean isRuleEngine;

}
