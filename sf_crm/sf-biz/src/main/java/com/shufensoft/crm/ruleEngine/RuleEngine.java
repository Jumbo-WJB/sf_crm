package com.shufensoft.crm.ruleEngine;

import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import com.shufensoft.crm.ruleEngine.infoUnit.binding.InfoUnitServiceBinding;
import com.shufensoft.crm.ruleEngine.infoUnit.service.InfoUnitService;
import com.shufensoft.crm.ruleEngine.operator.base.RuleOperator;
import com.shufensoft.crm.ruleEngine.operator.base.RuleResultInitOperator;
import com.shufensoft.crm.ruleEngine.operator.result.EqualCountOperator;
import com.shufensoft.crm.ruleEngine.operator.result.RangeCountOperator;
import com.shufensoft.crm.ruleEngine.operator.rule.EqualOperator;
import com.shufensoft.crm.ruleEngine.operator.rule.OrGreaterOperator;
import com.shufensoft.crm.ruleEngine.operator.rule.SectionOperator;
import com.shufensoft.crm.ruleEngine.result.EngineResult;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 规则引擎
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/19  
 */
public abstract class RuleEngine {



    private static final Logger logger = Logger.getLogger(RuleEngine.class);

    /**
     * 规则上下文
     */
    @Setter
    @Getter
    protected RuleContext ruleContext;


    /**
     * 信息元服务绑定
     */
    private static List<InfoUnitServiceBinding> infoUnitServiceBindings;

    /**
     * 运算器
     */
    private static List<RuleOperator> ruleOperators;


    /**
     * 规则结果初始化运算器
     */
    private static List<RuleResultInitOperator> ruleResultInitOperators;

    static {

        /**
         *  规则结果初始化运算器
         */
        List<RuleResultInitOperator> ruleResultInitOperators = new ArrayList<RuleResultInitOperator>();
        ruleResultInitOperators.add(new EqualCountOperator());//添加等于/数量运算符
        ruleResultInitOperators.add(new RangeCountOperator());//添加随机/数量运算符
        setRuleOperatorsOperators(ruleResultInitOperators);

        /**
         * 运算器初始化
         */
        List<RuleOperator> operators = new ArrayList<RuleOperator>();
        operators.add(new EqualOperator());//添加等于运算符
        operators.add(new SectionOperator());//添加区间运算符
     //   operators.add(new OrEqualOperator());
        operators.add(new OrGreaterOperator());
        setOperators(operators);

    }


    protected static void setOperators(List<RuleOperator> operatorList) {
        ruleOperators = operatorList;
    }

    protected static void setRuleOperatorsOperators(List<RuleResultInitOperator> ruleOperatorList) {
        ruleResultInitOperators = ruleOperatorList;
    }

    protected static void setInfoUnitServiceBindings(List<InfoUnitServiceBinding> infoUnitServiceBindingsList) {
        infoUnitServiceBindings = infoUnitServiceBindingsList;
    }

    /**
     * 执行初始化规则结果
     */
    public abstract void initRuleResultExecute(List<Object> initRuleResultList);


    /**
     * 执行规则业务操作
     */
    public abstract EngineResult execute();


    /**
     * 初始化结果
     */
    public void initRuleResult() {
        //初始化规则,保存规则到缓存中
        initRule();
        //执行初始化规则结果运算器，返回业务结果
        List<Object> initRuleResultList = initRuleResultList();
        //执行业务初始化
        initRuleResultExecute(initRuleResultList);
    }

    /**
     * 初始化规则
     */
    public void initRule() {

        if (ruleContext == null) {
            throw new RuleEngineException("RuleEngine", "initRule", "ruleContext is null");
        }

        RuleConfig ruleConfig = ruleContext.getRuleConfig();//获取规则配置
        if (ruleConfig == null) {
            throw new RuleEngineException("RuleEngine", "initRule", "ruleConfig is null");
        }

        /**
         * ruleConfig转化为rule,保存到缓存中
         */
        Rule ruleTemp = new Rule();
        String value = ruleConfig.getValue();

        try {
            ruleTemp = (Rule) JSONUtils.parseToObject(value, Rule.class);
        } catch (Exception e) {
            throw new RuleEngineException("规则表达式转换出错!");
        }

        ruleTemp.setRuleId(ruleConfig.getId());
        ruleTemp.setRuleName(ruleConfig.getName());
        ruleTemp.setRuleType(ruleConfig.getType());
        ruleTemp.setRuleObjId(ruleContext.getRuleObjId() + "");

        if (ruleContext.getRuleObjId() != null) {

            RuleCache.put(ruleContext.getRuleObjId() + "_" + ruleContext.getRuleType(), ruleTemp);
        } else

            RuleCache.put(ruleContext.getRuleType(), ruleTemp);

    }

    /**
     * 执行初始化规则结果运算器，返回业务结果
     */
    public List<Object> initRuleResultList() {
        List<Object> list = new ArrayList<Object>();
        if (ruleContext == null) {
            throw new RuleEngineException("RuleEngine", "operate", "ruleContext is null");
        }

        if (CollectionUtils.isEmpty(ruleResultInitOperators)) {
            throw new RuleEngineException("RuleEngine", "operate", "ruleResultInitOperators is null");
        }

        if (CollectionUtils.isEmpty(ruleContext.getRule().getRuleExpressions())) {
            throw new RuleEngineException("RuleEngine", "operate", "rule.RuleExpressions is null");
        }

        for (RuleExpression expression : ruleContext.getRule().getRuleExpressions()) {
            RuleResultInitOperator ruleResultInitOperator = getRuleResultInitOperator(expression.getOperator());
            if (ruleResultInitOperator != null) {
                List<Object> objects = ruleResultInitOperator.operate(expression.getExpectation_value());//获取运算返回结果
                if (!objects.isEmpty()) {
                    list.addAll(objects);
                }
            }
        }
        return list;
    }


    /**
     * 引擎运行
     */
    public EngineResult start() {

        EngineResult engineResult = null;
        try {

        //    initFactObjs(); //初始化实际对象
        //    initExpression(); //初始化表达式
            engineResult = operate();
            if (EngineResult.ErrorCode.SUCCESS.equals(engineResult.getErrorCode())) { //是否满足规则
                return execute(); //执行业务操作
            }

            return engineResult;

        }catch (Exception e){

            engineResult.setErrorCode(EngineResult.ErrorCode.SYS_ERROR);
            engineResult.setErrorMessage(e.getMessage()==null?e.toString():e.getMessage());

        }

        return engineResult;
    }

    /**
     * 初始化实际对象
     */
    private void initFactObjs() {

        Map<String, Object> factObjectMap = ruleContext.getFactObjects();

        if (CollectionUtils.isEmpty(factObjectMap)) {
            throw new RuleEngineException("RuleEngine", "initFactObjs", "factObjectMap is null");
        }
        if (CollectionUtils.isEmpty(infoUnitServiceBindings)) {
            throw new RuleEngineException("RuleEngine", "initFactObjs", "infoUnitServiceBindings is null");
        }

        if ( ruleContext.getRule()==null) {
            throw new RuleEngineException("RuleEngine", "initFactObjs", "rule is null");
        }

        for (RuleExpression expression : ruleContext.getRule().getRuleExpressions()) {
            InfoUnitServiceBinding infoUnitServiceBinding = getRuleFactAttribute(expression.getFact_attribute());
            if (infoUnitServiceBinding != null) {
                //1.获取实际对象
               Object object = factObjectMap.get(infoUnitServiceBinding.getFactObjectClass().getName());
                try {
                    //2.设置规则对象ID
                    InfoUnitService infoUnitService = (InfoUnitService) infoUnitServiceBinding.getInfoUnitServiceClass().newInstance();
                    infoUnitService.setRuleObjId(ruleContext.getRuleObjId());
                    infoUnitService.setSellerId(ruleContext.getSellerId());
                    if( StringUtils.isNotBlank(ruleContext.getActionValue())){
                        infoUnitService.setActionValue(ruleContext.getActionValue());
                    }
                    //3.通过反射调信息元服务(实际对象作为参数)
                    Object factValue = MethodUtils.invokeMethod(infoUnitService, infoUnitServiceBinding.getServiceMethodName(), object);
                    //4.将返回值设置到实际对象中
                    MethodUtils.invokeMethod(object, "set" + StringUtils.capitalize(infoUnitServiceBinding.getFactAttributeName()), factValue);
                    expression.setFact_value(String.valueOf(factValue));
                } catch (Exception e) {
                    throw new RuleEngineException("RuleEngine", "initFactObjs", e);
                }
            }
        }
    }

    /**
     * 初始化表达式
     */
    private void initExpression() {

        Rule rule = ruleContext.getRule();
        if (rule != null) {
            List<RuleExpression> ruleExpressions = rule.getRuleExpressions();
            if (!CollectionUtils.isEmpty(ruleExpressions)) {
            for (RuleExpression ruleExpression : ruleExpressions) {
                    Object obj = ruleContext.getFactObj(ruleExpression.getFact_obj());//获取实际对象
                    if (obj != null) {
                        try {
                            Object factValue = MethodUtils.invokeMethod(obj, "get"
                                    + StringUtils.capitalize(ruleExpression.getFact_attribute()), null);//获取对应属性值
                            ruleExpression.setFact_value(String.valueOf(factValue)); //将对应的属性值初始化到表达式中
                        } catch (Exception e) {
                            throw new RuleEngineException("RuleEngine", "initExpression", e);
                        }
                    }
                }
            }
            ruleContext.setRule(rule);
        }
    }

    /**
     * 执行规则运算
     */
    public EngineResult operate() {

        EngineResult engineResult = new EngineResult();
        engineResult.setErrorCode(EngineResult.ErrorCode.SYS_ERROR);

        try {

            initFactObjs(); //初始化实际对象
            initExpression(); //初始化表达式

        }catch (Exception e){

            engineResult.setErrorMessage(e.getMessage()==null?e.toString():e.getMessage());

            return engineResult;
        }

        if (ruleContext == null) {
            engineResult.setErrorMessage("ruleContext is null");
            logger.error("ruleContext is null");
            return engineResult;
        }

        if (ruleContext.getRule() == null) {
            engineResult.setErrorCode(EngineResult.ErrorCode.SUCCESS);
        }

        if (CollectionUtils.isEmpty(ruleOperators)) {
            engineResult.setErrorMessage("ruleOperators is null");
            logger.error("ruleOperators is null");
            return engineResult;
        }

        if (CollectionUtils.isEmpty(ruleContext.getRule().getRuleExpressions())) {
            engineResult.setErrorMessage("ule.RuleExpressions is null");
            logger.error("ule.RuleExpressions is null");
            return engineResult;
        }

        for (RuleExpression expression : ruleContext.getRule().getRuleExpressions()) {

            RuleOperator ruleOperator = getRuleOperator(expression.getOperator());
            if (ruleOperator == null||(expression.getIsRuleEngine()!=null&&!expression.getIsRuleEngine())) {
                continue;
            }

            if (ruleOperator.operate(expression.getFact_value(), expression.getExpectation_value()) == false) {
                engineResult.setErrorCode(EngineResult.ErrorCode.RULE_VERIFY_ERROR);
                engineResult.setErrorMessage(expression.getCondition_remind());
                return engineResult;
            }
        }

        engineResult.setErrorCode(EngineResult.ErrorCode.SUCCESS);
        return engineResult;

    }

    /**
     * 获取规则结果初始化运算器
     *
     * @param operationalCharacter 运算符
     * @return
     */
    private RuleResultInitOperator getRuleResultInitOperator(String operationalCharacter) {

        if (CollectionUtils.isEmpty(ruleResultInitOperators)) {
            return null;
        }

        for (RuleResultInitOperator ruleResultInitOperator : ruleResultInitOperators) {
            if (ruleResultInitOperator.getOperationalCharacter().equals(operationalCharacter)) {
                return ruleResultInitOperator;
            }
        }
        return null;
    }


    /**
     * 获取规则表达式运算器
     *
     * @param operationalCharacter 运算符
     * @return
     */
    private RuleOperator getRuleOperator(String operationalCharacter) {

        if (CollectionUtils.isEmpty(ruleOperators)) {
            return null;
        }

        for (RuleOperator ruleOperator : ruleOperators) {

            if (ruleOperator.getOperationalCharacter().equals(operationalCharacter)) {
                return ruleOperator;
            }
        }
        return null;
    }


    /**
     * 通过表达式关键字获取对应的信息元服务
     *
     * @param factAttribute 关键字
     * @return
     */
    private InfoUnitServiceBinding getRuleFactAttribute(String factAttribute) {

        if (CollectionUtils.isEmpty(infoUnitServiceBindings)) {
            return null;
        }

        for (InfoUnitServiceBinding infoUnitServiceBinding : infoUnitServiceBindings) {

            if (infoUnitServiceBinding.getFactAttributeName().equals(factAttribute)) {
                return infoUnitServiceBinding;
            }
        }
        return null;
    }
}
