package com.shufensoft.crm.web.controller.ruleConfig;

import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.service.ruleConfig.RuleConfigService;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/18 21:37  
 */
@Controller
public class RuleConfigController extends BaseController {
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(RuleConfigController.class);

    @Resource(name = "ruleConfigService")
    private RuleConfigService ruleConfigService;


    /**
     * 红包提现规则配置
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ruleConfig/hbCash")
    @ResponseBody
    public ModelAndView hbCashPageList(ModelMap modelMap) {
        return new ModelAndView("/ruleConfig/hbCash", modelMap);
    }


    /**
     * 好评返红包规则配置
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ruleConfig/hbPraise")
    @ResponseBody
    public ModelAndView hbPraisePageList(ModelMap modelMap) {
        return new ModelAndView("/ruleConfig/hbPraise", modelMap);
    }


    /**
     * 保存更新红包提现配置规则
     *
     * @param result
     * @param session
     * @return
     */
    @RequestMapping("/ruleConfig/hbCash/saveOrUpdate")
    //  @PreventDuplicateSubmission(needValidateToken = true)
    public
    @ResponseBody
    Map<String, Object> saveOrUpdate1(@Valid RuleConfig ruleConfig, BindingResult result, HttpSession session) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        Long sellerId = getSellerId(session);
        if (result.hasErrors()) {
            returnMap.put(ERROR_CODE_KEY, getError(result));
            return returnMap;
        }
        try {
            ruleConfig.setType(RuleType.HB_CASH.getCode());//设置类型为红包提现规则
            ruleConfig.setDescText("红包提现规则");//设置红包活动规则描述
            ruleConfig.setName(RuleType.HB_CASH.getCode());//name设置为ruleType
            if (ruleConfig.getId() == null) {
                ruleConfigService.createHbCashRuleConfig(ruleConfig, sellerId);
            } else
                ruleConfigService.updateHbCashRuleConfig(ruleConfig, sellerId);
        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }
        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "新建配置规则成功!");
        return returnMap;
    }


    /**
     * 更新配置规则
     *
     * @param ruleConfig
     * @param result
     * @param session
     * @return
     */
    @RequestMapping("/ruleConfig/update")
    public
    @ResponseBody
    Map<String, String> update(@Valid RuleConfig ruleConfig, BindingResult result, HttpSession session) {

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        if (result.hasErrors()) {
            returnMap.put(ERROR_CODE_KEY, getError(result));
            return returnMap;
        }
        //单独校验id
        if (ruleConfig.getId() == null) {
            returnMap.put(ERROR_CODE_KEY, "非法配置规则id");
            return returnMap;
        }
        try {
            //ruleConfigService.updateRuleConfig(ruleConfig);
        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }
        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "更新配置规则成功!");
        return returnMap;

    }

    /**
     * 获取配置规则详细信息
     *
     * @param ruleConfigId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ruleConfig/detail")
    public Object detail(String ruleConfigId, ModelMap modelMap, HttpSession httpSession) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        Long sellerId = getSellerId(httpSession);
        if (!StringUtils.isNumeric(ruleConfigId)) {
            returnMap.put(ERROR_MESSAGE_KEY, "后台用户id非法!");
        }
        RuleConfig ruleConfig = new RuleConfig();
        ruleConfig.setType(RuleType.HB_CASH.getCode());
        ruleConfig = ruleConfigService.getRuleConfigByCondition(ruleConfig, sellerId);
        Rule rule = new Rule();
        try {
            rule = (Rule) JSONUtils.parseToObject(ruleConfig.getValue(), Rule.class);//获取规则表达式
        } catch (Exception e) {
            throw new RuleEngineException("规则表达式转换出错!");
        }
        rule.setRuleId(ruleConfig.getId());
        modelMap.put("rule", rule);
        return rule;
    }


    /**
     * 根据id删除配置规则
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/ruleConfig/delete")
    public
    @ResponseBody
    Map<String, Object> delete(@RequestBody String[] ids) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        for (String id : ids) {
            if (!StringUtils.isNumeric(id)) {
                returnMap.put(ERROR_MESSAGE_KEY, "后台用户id非法!");
                return returnMap;
            } else {
                ruleConfigService.deleteRuleConfigById(Integer.valueOf(id));
            }
        }
        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "删除成功!");
        return returnMap;
    }


}
