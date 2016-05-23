package com.shufensoft.crm.web.controller.hongbao;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.integral.service.IntegralService;
import com.shufensoft.crm.biz.service.ruleConfig.RuleConfigService;
import com.shufensoft.crm.biz.vo.HBObtainVO;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.biz.vo.UserAccountVO;
import com.shufensoft.crm.common.runner.BizRunner;
import com.shufensoft.crm.common.runner.executor.BizExecutor;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.enums.HBPoolStatus;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @version 1.0
 * @desc 红包
 * @company shufensoft
 * @date 2015/5/6.
 */
@Controller
public class HongbaoController extends BaseController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(HongbaoController.class);

    @Autowired
    private HongbaoService hongbaoService;

    @Autowired
    private RuleConfigService ruleConfigService;

    @Autowired
    private IntegralService integralService;


    @RequestMapping(value = "/hbPool/list")
    @ResponseBody
    public ModelAndView hbPoolList(ModelMap modelMap) {
        return new ModelAndView("/hongbao/hbPoolList", modelMap);
    }

    @RequestMapping(value = "/hbObtain/list")
    @ResponseBody
    public ModelAndView hbObtainList(ModelMap modelMap) {
        return new ModelAndView("/hongbao/hbObtainList", modelMap);
    }

    @RequestMapping(value = "/hbAccount/list")
    @ResponseBody
    public ModelAndView hbAccountList(ModelMap modelMap) {

        return new ModelAndView("/hongbao/hbAccountList", modelMap);

    }


    /**
     * 分页获取红包活动列表
     *
     * @param hbPoolVO
     * @param pageNum     分页起始页
     * @param length      分页长度
     * @param sortContent 排序信息
     * @return
     */
    @RequestMapping("/hbPool/datas")
    public
    @ResponseBody
    Map<String, Object> datas(HBPoolVO hbPoolVO, Integer pageNum, Integer length, String sortContent,HttpSession httpSession) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId=getSellerId(httpSession);

        PageInfo pageInfo = hongbaoService.queryHBPools(hbPoolVO, pageNum, length, sortContent,sellerId);
        HBPool hbPool = hongbaoService.getHbPoolSumByVO(hbPoolVO,sellerId);

        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
            datas.put("hbPool", hbPool);
        }

        return datas;
    }

    /**
     * 分页获取红包领取列表
     *
     * @param hbObtainVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping("/hbObtain/datas")
    public
    @ResponseBody
    Map<String, Object> datas1(HBObtainVO hbObtainVO, Integer pageNum, Integer length, String sortContent,HttpSession httpSession) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 0;
        }

        Long sellerId=getSellerId(httpSession);

        PageInfo pageInfo = hongbaoService.getHBObtainWithUser(hbObtainVO, pageNum, length, sortContent,sellerId);

        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }

        return datas;
    }

    /**
     * 分页获取账户明细列表
     *
     * @param userAccountVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping("/hbAccount/datas")
    public
    @ResponseBody
    Map<String, Object> datas2(UserAccountVO userAccountVO, Integer pageNum, Integer length,HttpSession httpSession) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 0;
        }

        Long sellerId=getSellerId(httpSession);

        PageInfo pageInfo = hongbaoService.queryHBAccounts(userAccountVO, pageNum, length,sellerId);
        Map<String, Object> datas = Maps.newHashMap();

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }

        return datas;
    }


    /**
     * 添加红包活动
     *
     * @param result
     * @param httpSession
     * @return
     */
    @RequestMapping("/hbPool/add")
    @PreventDuplicateSubmission(needValidateToken = true)
    public
    @ResponseBody
    Map<String, Object> add(@Valid HBPoolVO hbPoolVO, BindingResult result, HttpSession httpSession) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

         final Long sellerId=getSellerId(httpSession);

        try {
            /**
             * 创建红包活动
             */
            hbPoolVO.setNumberObtain(Long.valueOf(0));
            hbPoolVO.setSellerId(Long.valueOf(sellerId));
            hbPoolVO.setObtainAmount(Long.valueOf(0));
            hbPoolVO.setRuleConfigId(Long.valueOf(0));
            hbPoolVO.setStates(HBPoolStatus.UNBOUNDED.getCode());//设置红包活动状态为待关联

            final String sellerIdTemp = sellerId+"";
            final HBPoolVO hbPoolVO1 = hongbaoService.createHBPool(hbPoolVO);//创建红包活动,保存红包活动规则
            final SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId+"");
            new BizRunner(new BizExecutor() {
                @Override
                public Boolean execute() {
                    DBContextHolder.setDataSourceKey(String.valueOf(sellerConfigInfo.getDatasourceId()));
                    return hongbaoService.initHBRuleResult(hbPoolVO1.getPoolId(), hbPoolVO1.getRuleConfig(),sellerId);
                }
            }).start();

        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "新建红包活动成功!");

        return returnMap;
    }

    /**
     * 更新红包活动
     *
     * @param hbPoolVO
     * @param result
     * @param httpSession
     * @return
     */
    @RequestMapping("/hbPool/update")
    public
    @ResponseBody
    Map<String, String> update(@Valid HBPoolVO hbPoolVO, BindingResult result, HttpSession httpSession) {

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        Long sellerId=getSellerId(httpSession);

        if (result.hasErrors()) {
            returnMap.put(ERROR_CODE_KEY, getError(result));
            return returnMap;
        }

        //单独校验id
        if (hbPoolVO.getId() == null) {
            returnMap.put(ERROR_CODE_KEY, "非法红包活动id");
            return returnMap;
        }

        try {
            final String sellerIdTemp =sellerId+"";
            final HBPoolVO hbPoolVO1 = hongbaoService.updateHBPool(hbPoolVO,sellerId);
            final Long sellerId1 =sellerId;
            final SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId+"");
            new BizRunner(new BizExecutor() {
                @Override
                public Boolean execute() {
                    DBContextHolder.setDataSourceKey(String.valueOf(sellerConfigInfo.getDatasourceId()));
                    return hongbaoService.updateHBRuleResult(hbPoolVO1.getPoolId(), hbPoolVO1.getRuleConfig(),sellerId1);
                }
            }).start();

        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "更新红包活动成功!");

        return returnMap;
    }

    @RequestMapping(value = "/hongbao/detail")
    public Object detail(String hbPoolId, ModelMap modelMap,HttpSession httpSession) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        Long sellerId=getSellerId(httpSession);

        if (!StringUtils.isNumeric(hbPoolId)) {
            returnMap.put(ERROR_MESSAGE_KEY, "后台用户id非法!");
        }

        HBPoolVO hbPoolVO = hongbaoService.getHBPoolVOById(Integer.valueOf(hbPoolId),sellerId);//获取红包活动详细信息

        Rule rule = new Rule();
        rule = RuleCache.get(hbPoolVO.getPoolId() + "", RuleType.HB_POOL.getCode(),Long.valueOf(sellerId));//获取缓存中的规则配置
        RuleConfig ruleConfig = new RuleConfig();

        if (rule == null || rule.getRuleExpressions().isEmpty()) {//当缓存中没有数据时，从数据库中取得

            Long ruleConfigId = hbPoolVO.getRuleConfigId();//获取规则id
            ruleConfig = ruleConfigService.getRuleConfigVOById(ruleConfigId);//读取配置规则
            String value = ruleConfig.getValue();//获取规则配置的value值

            try {
                rule = (Rule) JSONUtils.parseToObject(value, Rule.class);//获取规则表达式
            } catch (Exception e) {
                throw new RuleEngineException("规则表达式转换出错!");
            }

            rule.setRuleId(ruleConfig.getId());//设置规则id
            rule.setRuleName(ruleConfig.getName());//设置规则名称
            rule.setRuleType(ruleConfig.getType());//设置规则类型

        }

        hbPoolVO.setRule(rule);
        modelMap.put("hbPoolVO", hbPoolVO);
        return hbPoolVO;
    }

    /**
     * 删除红包活动
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/hbPool/delete")
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
                hongbaoService.deleteHbPoolById(Integer.valueOf(id));//删除红包活动
            }

        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "删除成功!");

        return returnMap;
    }


    /**
     * 验证生日时间是否有冲突
     *
     * @param hbPool
     * @return
     */
    @RequestMapping(value = "/hbPool/birthdayDateVerify")
    public
    @ResponseBody
    Map<String, Object> birthdayDateVerify(HBPoolVO hbPool,HttpSession httpSession) {

        Long sellerId=getSellerId(httpSession);

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        List<HBPool> hbPools = hongbaoService.getHbPoolLis(hbPool,sellerId);

        if (CollectionUtils.isEmpty(hbPools)) {
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            return returnMap;
        }

        return returnMap;
    }

}
