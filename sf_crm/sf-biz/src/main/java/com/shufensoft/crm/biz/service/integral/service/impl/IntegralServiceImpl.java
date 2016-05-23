package com.shufensoft.crm.biz.service.integral.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.dao.generation.system.LstOfValMapper;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.domain.generation.system.LstOfValExample;
import com.shufensoft.crm.biz.service.integral.service.IntegralService;
import com.shufensoft.crm.biz.service.integral.vo.IntegralConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInPointConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInVO;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/22 下午3:06  
 */
@Service
public class IntegralServiceImpl implements IntegralService {

    /**
     * logger
     */
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IntegralServiceImpl.class);

    @Autowired
    private RuleConfigMapper ruleConfigMapper;

    @Autowired
    private LstOfValMapper lstOfValMapper;


    public IntegralConfigVO queryIntegralConfig(String sellerID, String name) {

        IntegralConfigVO integralConfigVO = new IntegralConfigVO();

        try {
            RuleConfigExample ruleConfigExample = new RuleConfigExample();
            RuleConfigExample.Criteria criteria = ruleConfigExample.createCriteria();

            criteria.andSellerIdEqualTo(Long.valueOf(sellerID));
            criteria.andTypeEqualTo("INTEGRAL_CONFIG");

            if (StringUtils.isNotEmpty(name)) {
                criteria.andNameEqualTo(name);
            }


            List<RuleConfig> ruleConfigList = ruleConfigMapper.selectByExample(ruleConfigExample);

            if (ruleConfigList != null && !ruleConfigList.isEmpty()) {
                integralConfigVO.setSellerId(sellerID);
                integralConfigVO.setConfigType(ruleConfigList.get(0).getType());
                integralConfigVO.setConfigName(ruleConfigList.get(0).getName());
                josnConvertIntegral(ruleConfigList.get(0).getValue(), integralConfigVO);
            } else {
                if ("SYS".equals(name)) {
                    LstOfValExample lstOfValExample = new LstOfValExample();
                    LstOfValExample.Criteria criteriaLs = lstOfValExample.createCriteria();
                    criteriaLs.andTypeEqualTo("INTEGRAL_CONFIG");
                    //criteriaLs.andNameEqualTo("SYS");
                    List<LstOfVal> lstOfVals = lstOfValMapper.selectByExample(lstOfValExample);
                    if (lstOfVals != null && !lstOfVals.isEmpty()) {

                        integralConfigVO.setSellerId(sellerID);
                        integralConfigVO.setConfigType("INTEGRAL_CONFIG");
                        integralConfigVO.setConfigName("SYS");
                        josnConvertIntegral(lstOfVals.get(0).getValue(), integralConfigVO);
                    }

                }
            }
        } catch (Exception e) {
            logger.error("queryIntegralConfig error.", e);
        }


        return integralConfigVO;
    }


    public RuleConfig getRuleConfig(String type) {
        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        RuleConfigExample.Criteria criteria = ruleConfigExample.createCriteria();
        criteria.andTypeEqualTo(type);

        List<RuleConfig> ruleConfigList = ruleConfigMapper.selectByExample(ruleConfigExample);
        if (ruleConfigList != null && !ruleConfigList.isEmpty()) {
            return ruleConfigList.get(0);
        }
        return null;
    }


    public void saveIntegralConfig(IntegralConfigVO integralConfigVO) {

        RuleConfig ruleConfig = getRuleConfig(integralConfigVO.getConfigType());

        String value = integralConvertJosn(integralConfigVO);
        Long sellerId = Long.valueOf(integralConfigVO.getSellerId());
        if (ruleConfig != null) {
            if ("SYS".equals(integralConfigVO.getConfigName())) {
                ruleConfig.setName("SYS");
                ruleConfig.setValue(value);
                ruleConfigMapper.updateByPrimaryKey(ruleConfig);
            } else {
                ruleConfig.setName("CUSTOM");
                ruleConfig.setValue(value);
                ruleConfigMapper.updateByPrimaryKey(ruleConfig);
            }
        } else {
            ruleConfig = new RuleConfig();
            ruleConfig.setSellerId(sellerId);
            ruleConfig.setValue(value);
            ruleConfig.setName(integralConfigVO.getConfigName());
            ruleConfig.setType("INTEGRAL_CONFIG");
            ruleConfig.setDescText("积分规则");
            ruleConfigMapper.insert(ruleConfig);
        }
    }


    /**
     * 保存签到积分配置
     *
     * @param signInPointConfigVO
     */
    public void saveSignRule(SignInPointConfigVO signInPointConfigVO) {

        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        RuleConfigExample.Criteria criteria = ruleConfigExample.createCriteria();
        criteria.andTypeEqualTo("INTEGRAL_SIGN_IN_CONFIG");
        criteria.andNameEqualTo("SIGN_IN");
        criteria.andSellerIdEqualTo(signInPointConfigVO.getSellerId());

        List<RuleConfig> ruleConfigList = ruleConfigMapper.selectByExample(ruleConfigExample);
        String signInJson = JSONUtils.toJSONStr(signInPointConfigVO.getSignInVOList());
        if (null == ruleConfigList || ruleConfigList.isEmpty()) {
            RuleConfig ruleConfig = new RuleConfig();
            ruleConfig.setSellerId(signInPointConfigVO.getSellerId());
            ruleConfig.setType("INTEGRAL_SIGN_IN_CONFIG");
            ruleConfig.setName("SIGN_IN");
            ruleConfig.setValue(signInJson);
            ruleConfig.setDescText("签到积分规则");
            ruleConfigMapper.insert(ruleConfig);
        } else {
            RuleConfig ruleConfig = ruleConfigList.get(0);
            ruleConfig.setSellerId(signInPointConfigVO.getSellerId());
            ruleConfig.setValue(signInJson);
            ruleConfigMapper.updateByPrimaryKey(ruleConfig);
        }
    }

    /**
     * 查询商户签到积分配置
     *
     * @param sellerId
     * @return
     */
    public SignInPointConfigVO querySignInPointRule(Long sellerId) {
        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        RuleConfigExample.Criteria criteria = ruleConfigExample.createCriteria();
        criteria.andTypeEqualTo("INTEGRAL_SIGN_IN_CONFIG");
        criteria.andNameEqualTo("SIGN_IN");
        criteria.andSellerIdEqualTo(sellerId);

        List<RuleConfig> ruleConfigList = ruleConfigMapper.selectByExample(ruleConfigExample);
        SignInPointConfigVO signInPointConfigVO = new SignInPointConfigVO();
        signInPointConfigVO.setSellerId(sellerId);
        if (ruleConfigList != null && !ruleConfigList.isEmpty()) {
            String ruleValue = ruleConfigList.get(0).getValue();
            List<SignInVO> signInVOList = (List<SignInVO>) JSONUtils.parseToList(ruleValue, SignInVO.class);
            signInPointConfigVO.setSignInVOList(signInVOList);
        }
        return signInPointConfigVO;
    }


    /**
     * 查询商户的积分规则
     *
     * @param sellerId 商户ID
     * @return
     */
    public IntegralConfigVO queryPointRule(Long sellerId) {
        // 查询规则
        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        RuleConfigExample.Criteria criteria = ruleConfigExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andTypeEqualTo("INTEGRAL_CONFIG");
        List<RuleConfig> ruleConfigList = ruleConfigMapper.selectByExample(ruleConfigExample);
        IntegralConfigVO integralConfigVO = new IntegralConfigVO();
        if (ruleConfigList != null && !ruleConfigList.isEmpty()) {
            String rule = ruleConfigList.get(0).getValue();
            josnConvertIntegral(rule, integralConfigVO);
        }
        return integralConfigVO;

    }

    /**
     * @param integralJson
     * @param integralConfigVO
     */
    public void josnConvertIntegral(String integralJson, IntegralConfigVO integralConfigVO) {
        JSONObject jsonObject = JSONUtils.parseToJSONObejct(integralJson, JSONObject.class);
        Map map = (Map) JSONUtils.parseToObject(jsonObject, Map.class);

        if (map != null) {
            integralConfigVO.setConertMoney((String) map.get("convertMoney"));
            integralConfigVO.setGroupIntegral((String) map.get("groupIntegral"));
            integralConfigVO.setSpreadIntegral((String) map.get("spreadIntegral"));
            integralConfigVO.setAttentionIntegral((String) map.get("attentionIntegral"));

            String jsonBuyIntegral = (String) map.get("buyIntegralJson");


            List<String> list = (List<String>) JSONUtils.parseToList(jsonBuyIntegral, String.class);
            integralConfigVO.setBuyIntegralList(list);

        }
    }


    private String integralConvertJosn(IntegralConfigVO integralConfigVO) {
        Map integralMap = new HashMap();
        integralMap.put("convertMoney", integralConfigVO.getConertMoney());
        integralMap.put("groupIntegral", integralConfigVO.getGroupIntegral());
        integralMap.put("attentionIntegral", integralConfigVO.getAttentionIntegral());
        integralMap.put("spreadIntegral", integralConfigVO.getSpreadIntegral());

        List<String> buyIntegralList = integralConfigVO.getBuyIntegralList();
        if (buyIntegralList != null && !buyIntegralList.isEmpty()) {
            String buyIntegralJson = JSONUtils.toJSONStr(buyIntegralList);
            integralMap.put("buyIntegralJson", buyIntegralJson);
        }

        JSONObject jsonObject = (JSONObject) JSONUtils.toJSON(integralMap);
        return jsonObject.toJSONString();
    }

    public static void main(String[] agrs) {

        IntegralConfigVO integralConfigVO = new IntegralConfigVO();
        integralConfigVO.setAttentionIntegral("10");
        integralConfigVO.setSpreadIntegral("20");
        integralConfigVO.setGroupIntegral("50");
        integralConfigVO.setConertMoney("10");
        IntegralServiceImpl integralService = new IntegralServiceImpl();
        integralService.saveIntegralConfig(integralConfigVO);

    }


}
