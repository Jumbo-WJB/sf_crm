package com.shufensoft.crm.ruleEngine.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 规则对象
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/19  
 */
@Data
public class Rule implements Serializable{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8098452976629871710L;

    /**
     * 规则名称
     */
    private String RuleName;

    /**
     * 规则id
     */
    private Long RuleId;

    /**
     * 规则对象id
     */
    private String RuleObjId;

    /**
     * 规则表达式
     */
    private List<RuleExpression> ruleExpressions;

    /**
     * 规则类型
     */
    private String ruleType;

}
