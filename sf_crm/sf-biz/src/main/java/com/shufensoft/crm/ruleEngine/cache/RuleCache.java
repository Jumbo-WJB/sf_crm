package com.shufensoft.crm.ruleEngine.cache;


import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.ruleConfig.RuleConfigService;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                规则缓存
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/26  
 */
public class RuleCache {

    private static String RULE_CACHE = "RULE_CACHE";

    private static RuleConfigService ruleConfigService;

    private static HongbaoService hongbaoService;

    static {
        ruleConfigService = (RuleConfigService) SpringContextUtil.getBean("ruleConfigService");
        hongbaoService = (HongbaoService) SpringContextUtil.getBean("hongbaoService");
    }


    public static void put(String key, Rule rule) {

        ArrayList<Rule> rules = (ArrayList<Rule>) RedisCache.get(RULE_CACHE);

        if (CollectionUtils.isEmpty(rules)) {
            rules = new ArrayList<Rule>();
        }
        rules.add(rule);
        RedisCache.put(RULE_CACHE, rules);
        RedisCache.put(RULE_CACHE + "_" + key, rule);

    }

    public static Rule get(String ruleObjId, String ruleType,Long  sellerId) {

        Rule rule;

        RuleType ruleTypeEnum = RuleType.getEnumByCode(ruleType);
        if (ruleTypeEnum == null) {
            throw new RuleEngineException("ruleCache.get error,errorMsg : this ruleType is not exist");
        }
        if (!StringUtils.isBlank(ruleObjId)) {
            rule = (Rule)RedisCache.get(RULE_CACHE + "_" + ruleObjId + "_" + ruleType);
        } else {
            rule = (Rule)RedisCache.get(RULE_CACHE + "_" + ruleType);
        }

        if (rule == null) {

            /**
             * 读取规则配置
             */
            RuleConfig ruleConfig = new RuleConfig();
            if (RuleType.HB_POOL.getCode().equals(ruleType) || RuleType.HB_PRAISE.getCode().equals(ruleType)) {//当规则类型是红包活动
                HBPoolVO hbPoolVO = hongbaoService.getHBPoolVOByPoolId(Long.valueOf(ruleObjId),sellerId);
                Long ruleConfigId = hbPoolVO.getRuleConfigId();//获取规则id
                ruleConfig = ruleConfigService.getRuleConfigVOById(ruleConfigId);//读取配置规则
            } else if (RuleType.HB_CASH.getCode().equals(ruleType)) {
                RuleConfig ruleConfig1 = new RuleConfig();
                ruleConfig1.setType(RuleType.HB_CASH.getCode());
                ruleConfig = ruleConfigService.getRuleConfigByCondition(ruleConfig1,sellerId);
            }

            /**
             * ruleConfig转化为rule,保存到缓存中
             */

            String value = ruleConfig.getValue();//获取规则配置的value值
            try {
                rule = (Rule) JSONUtils.parseToObject(value, Rule.class);//获取规则表达式//获取规则表达式
            } catch (Exception e) {
                throw new RuleEngineException("规则表达式转换出错!");
            }
            rule.setRuleId(ruleConfig.getId());//设置规则id
            rule.setRuleName(ruleConfig.getName());//设置规则名称
            rule.setRuleType(ruleConfig.getType());//设置规则类型
            rule.setRuleObjId(ruleObjId);

            /**
             * 保存规则到缓存中
             */
            if (!StringUtils.isBlank(ruleObjId)) {
                RedisCache.put(ruleObjId + "_" + ruleType, rule);
            } else
                RedisCache.put(ruleType, rule);//保存规则到缓存中

        }

        return rule;

    }


    /**
     * 刷所有商家的引擎缓存
     */
    public static void reloadAll() {

        /**
         * 读取规则配置
         */
        List<Rule> rules = (List<Rule>) RedisCache.get(RULE_CACHE);

        if (CollectionUtils.isEmpty(rules)) {
            return;
        }

        for (Rule rule : rules) {

            /**
             * ruleConfig转化为rule,保存到缓存中
             */
            if(rule.getRuleId()==null){
                continue;
            }

            RuleConfig ruleConfig = ruleConfigService.getRuleConfigVOById(rule.getRuleId());

            String value = ruleConfig.getValue();

            Rule ruleTmp;

            try {
                ruleTmp = (Rule) JSONUtils.parseToObject(value, Rule.class);
            } catch (Exception e) {
                throw new RuleEngineException("规则表达式转换出错!");
            }

            ruleTmp.setRuleId(ruleConfig.getId());
            ruleTmp.setRuleName(ruleConfig.getName());
            ruleTmp.setRuleType(ruleConfig.getType());
            ruleTmp.setRuleObjId(rule.getRuleObjId());

            /**
             * 保存规则到缓存中
             */
            if (StringUtils.isNotBlank(ruleTmp.getRuleObjId())) {
                RedisCache.put(ruleTmp.getRuleObjId() + "_" + ruleTmp.getRuleType(), ruleTmp);
            } else {
                RedisCache.put(ruleTmp.getRuleType(), ruleTmp);
            }
        }

    }

}
