package com.shufensoft.crm.ruleEngine.context;

import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.infoUnit.system.RuleDate;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                规则上下文
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/26  
 */

public class RuleContext {


    public RuleContext(){

    }

    public RuleContext(RuleConfig ruleConfig,Long ruleObjId,Long  sellerId){
       this.ruleConfig = ruleConfig;
       this.ruleObjId = ruleObjId;
       this.sellerId = sellerId;
    }

    public RuleContext(RuleConfig ruleConfig,String ruleType,String actionType,Long  sellerId){
        this.ruleConfig = ruleConfig;
        this.ruleType = ruleType;
        this.actionType=actionType;
        this.sellerId = sellerId;
    }


    public RuleContext(RuleConfig ruleConfig, String ruleType,String actionType,String actionValue,Long  sellerId){
        this.ruleConfig = ruleConfig;
        this.ruleType = ruleType;
        this.actionType=actionType;
        this.actionValue=actionValue;
        this.sellerId = sellerId;
    }

    public RuleContext(RuleConfig ruleConfig,String ruleType,Long  sellerId){
        this.ruleConfig = ruleConfig;
        this.ruleType = ruleType;
        this.sellerId = sellerId;
    }

    public RuleContext(Long ruleObjId, String ruleType,Long  sellerId){
        this.ruleObjId = ruleObjId;
        this.ruleType = ruleType;
        this.sellerId = sellerId;
    }

    public RuleContext(Long ruleObjId, String ruleType,String actionType,String actionValue,Long  sellerId){
        this.ruleObjId = ruleObjId;
        this.ruleType = ruleType;
        this.actionType=actionType;
        this.actionValue=actionValue;
        this.sellerId = sellerId;
    }

    public RuleContext(Long ruleActionId, String ruleType,String actionType,Long  sellerId){
        this.ruleActionId = ruleActionId;
        this.ruleType = ruleType;
        this.actionType=actionType;
        this.sellerId = sellerId;
    }


    public RuleContext(Long ruleObjId,Long ruleActionId, String ruleType,String actionType,String  businessType,Long  sellerId){
        this.ruleObjId=ruleObjId;
        this.ruleActionId = ruleActionId;
        this.ruleType = ruleType;
        this.actionType=actionType;
        this.businessType=businessType;
        this.sellerId = sellerId;
    }


    public RuleContext(RuleConfig ruleConfig,Long ruleObjId, String ruleType,Long  sellerId){
        this.ruleConfig=ruleConfig;
        this.ruleObjId = ruleObjId;
        this.ruleType = ruleType;
        this.sellerId = sellerId;
    }

    public RuleContext(RuleConfig ruleConfig,Long ruleObjId, String ruleType,String actionType,Long  sellerId){
        this.ruleConfig=ruleConfig;
        this.ruleObjId = ruleObjId;
        this.ruleType = ruleType;
        this.actionType = ruleType;
        this.sellerId = sellerId;
    }

    public RuleContext(RuleConfig ruleConfig,Long ruleObjId, String ruleType,String businessType,String actionValue,Long  sellerId){
        this.ruleConfig=ruleConfig;
        this.ruleObjId = ruleObjId;
        this.ruleType = ruleType;
        this.businessType=businessType;
        this.actionValue=actionValue;
        this.sellerId = sellerId;
    }


    /**
     * 规则配置
     */
    @Setter @Getter
    private RuleConfig ruleConfig;

    /**
     * 规则业务对象id
     */
    @Setter @Getter
    private Long ruleObjId;

    /**
     * 规则类型
     */
    @Setter @Getter
    private String ruleType;

    /**
     * 规则业务执行对象id
     */
    @Setter @Getter
    private Long ruleActionId;

    /**
     * 初始化后的规则
     */
    @Setter @Getter
    private Rule rule;

    /**
     * 规则操作类型
     */
    @Setter @Getter
    private String  actionType;

    /**
     * 规则操作值
     */
    @Setter @Getter
    private String  actionValue;

    /**
     * 业务类型
     */
    @Setter @Getter
    private String  businessType;


    /**
     * 事实对象
     */
    @Getter
    private Map<String,Object> factObjects;

    /**
     * 商户Id
     */
    @Setter
    @Getter
    protected Long   sellerId;

    /**
     * 增加实际对象
     */
    public void addFactObj(String className,Object factObject){
        if(factObjects == null){
            this.factObjects = new HashMap<String, Object>();
            //初始化部分实际对象
            this.factObjects.put(RuleDate.class.getName(),new RuleDate());
        }
        this.factObjects.put(className, factObject);
    }

    /**
     * 设置规则类型
     * @param ruleType
     */
    public void setRuleType(String ruleType) {

        if (this.ruleConfig == null) {
            this.ruleConfig = new RuleConfig();
        }

        this.ruleConfig.setType(ruleType);
    }

    /**
     * 获取规则
     * @return
     */
    public Rule getRule(){

        if(rule == null || CollectionUtils.isEmpty(rule.getRuleExpressions())){

            if(ruleObjId == null && StringUtils.isBlank(ruleType)){
                  return null;
            }
            return RuleCache.get(String.valueOf(ruleObjId),ruleType,sellerId);
        }

        return rule;
    }


    /**
     * 获取实际对象
     * @param cls
     * @return
     */
    public Object getFactObj(Class<?> cls){

        if(CollectionUtils.isEmpty(factObjects)){

            return null;
        }
        return factObjects.get(cls.getName());
    }

    /**
     * 获取实际对象
     * @param className 类全名(包名.类名)
     * @return
     */
    public Object getFactObj(String className){

        if(CollectionUtils.isEmpty(factObjects)){

            return null;
        }

        return factObjects.get(className);
    }



}
