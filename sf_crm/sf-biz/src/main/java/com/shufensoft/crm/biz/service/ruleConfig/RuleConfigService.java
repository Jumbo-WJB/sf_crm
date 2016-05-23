package com.shufensoft.crm.biz.service.ruleConfig;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.vo.RuleConfigVO;
import com.shufensoft.crm.ruleEngine.HBCashEngine;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/18 21:09  
 */
@Service
public class RuleConfigService {

    @Autowired
    RuleConfigMapper ruleConfigMapper;


    /**
     * logger
     */
    public static final Logger logger = Logger.getLogger(RuleConfigService.class);

    /**
     * 分页查询配置规则
     * @param ruleConfigVO
     * @param start
     * @param length
     * @return
     */
    public PageInfo queryHBPools(RuleConfigVO ruleConfigVO,  Integer start,Integer length,Long  sellerId) {
        RuleConfigExample ruleConfigExample=new RuleConfigExample();
        RuleConfigExample.Criteria criteria= ruleConfigExample.createCriteria();
        if(ruleConfigVO.getName()!=null){
            criteria.andNameEqualTo(ruleConfigVO.getName());
        }
        if(!StringUtils.isBlank(ruleConfigVO.getDescText())){//当规则配置名称
            criteria.andDescTextEqualTo(ruleConfigVO.getDescText());
        }
        if(sellerId!=null){
            criteria.andSellerIdEqualTo(sellerId);
        }

        PageHelper.startPage(start, length);
        //紧跟着的第一个select方法会被分页
        List<RuleConfig> ruleConfigS= ruleConfigMapper.selectByExample(ruleConfigExample);
        //用PageInfo对结果进行包装
        return new PageInfo(ruleConfigS);
    }

    /**
     * 根据id删除配置规则
     *
     * @param id
     */
    public void deleteRuleConfigById(long id) {
        ruleConfigMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取配置规则
     *
     * @param id
     */
    public RuleConfig getRuleConfigVOById(long id) {
        RuleConfig ruleConfig=ruleConfigMapper.selectByPrimaryKey(id);
        return ruleConfig;
    }

    /**
     * 查找所有的引擎配置
     */
    public List<RuleConfig> getAllRuleConfigVO(Long  sellerId) {

        RuleConfigExample ruleConfigExample=new RuleConfigExample();
        ruleConfigExample.createCriteria().andSellerIdEqualTo(sellerId);

        List<RuleConfig> ruleConfigs = ruleConfigMapper.selectByExample(ruleConfigExample);
        return ruleConfigs;
    }


    /**
     * 根据查询条件来获取配置规则
     * @param ruleConfig
     * @return
     */
    public   RuleConfig getRuleConfigByCondition(RuleConfig ruleConfig,Long  sellerId){
        RuleConfigExample ruleConfigExample=new RuleConfigExample();
        RuleConfigExample.Criteria criteria= ruleConfigExample.createCriteria();
        if(ruleConfig.getSellerId()!=null){
            criteria.andSellerIdEqualTo(ruleConfig.getSellerId());
        }
        if(ruleConfig.getId()!=null){
            criteria.andIdEqualTo(ruleConfig.getId());
        }
        if(!StringUtils.isBlank(ruleConfig.getName())){//当规则的名称不为空的时候
          criteria.andNameEqualTo(ruleConfig.getName());
        }
        if(!StringUtils.isBlank(ruleConfig.getType())){//当规则的类型不为空的时候
            criteria.andTypeEqualTo(ruleConfig.getType());
        }
        if(sellerId!=null){
            criteria.andSellerIdEqualTo(sellerId);
        }
        List<RuleConfig> ruleConfigs= ruleConfigMapper.selectByExample(ruleConfigExample);
        return  ruleConfigs.isEmpty()?new RuleConfig():ruleConfigs.get(0);
    }

    /**
     * 创建红包提现规则
     *
     * @param
     */
    public RuleConfig createHbCashRuleConfig(RuleConfig ruleConfig,Long  sellerId) {
        try{
            ruleConfigMapper.insert(ruleConfig);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException("创建提现规则失败,异常回滚!");
        }
        RuleContext ruleContext=new RuleContext(ruleConfig, RuleType.HB_CASH.getCode(),sellerId);
        HBCashEngine  hbCashEngine=new HBCashEngine(ruleContext);//新建红包活动规则引擎
        hbCashEngine.initRule();//调用初始化结果
        return ruleConfig;
    }





    /**
     * 更新红包提现规则
     *
     * @param ruleConfig
     */
    public void updateHbCashRuleConfig(RuleConfig ruleConfig,Long  sellerId) {
       try{
           ruleConfigMapper.updateByPrimaryKeySelective(ruleConfig);
       }catch (Exception e){
           logger.error(e.getMessage());
           throw new ServiceException("更新提现规则失败,异常回滚!");
       }
        /**
         * 删除原先缓存中的值,重新调用红包活动提现规则引擎
         */
        RuleCache.put(RuleType.HB_CASH.getCode(), new Rule());
        RuleContext   ruleContext=new RuleContext(ruleConfig, RuleType.HB_CASH.getCode(),sellerId);
        HBCashEngine  hbCashEngine=new HBCashEngine(ruleContext);//新建红包活动规则引擎
        hbCashEngine.initRule();//调用初始化结果
       }

}
