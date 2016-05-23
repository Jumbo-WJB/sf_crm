package com.shufensoft.crm.biz.service.hongbao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.hongbao.HBPoolDAO;
import com.shufensoft.crm.biz.dao.defined.hongbao.HongBaoObtainDao;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBCashMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.dao.generation.recordsActivity.ActivityRecordsMapper;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.domain.defined.hongbao.HBObtainDO;
import com.shufensoft.crm.biz.domain.defined.hongbao.HBPoolDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.*;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecords;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.exception.UserRemindException;
import com.shufensoft.crm.biz.service.birthday.BirthdayService;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.pointmall.face.IClientService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.vo.*;
import com.shufensoft.crm.common.api.helper.WXHelper;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.enums.HBObtainStatus;
import com.shufensoft.crm.ruleEngine.HBRuleEngine;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 红包服务类
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/4/15 23:15  
 */
@Service(value = "hongbaoService")
public class HongbaoServiceImpl implements HongbaoService {

    @Autowired
    HBPoolMapper hBPoolMapper;

    @Autowired
    HBObtainMapper hBObtainMapper;

    @Autowired
    UserAccountMapper userAccountMapper;

    @Autowired
    RuleConfigMapper ruleConfigMapper;

    @Autowired
    HBPoolDAO hbPoolDAO;

    @Autowired
    UserMapper userMapper;

    @Autowired
    HBCashMapper hbCashMapper;

    @Autowired
    HongBaoObtainDao hongBaoObtainDao;

    @Autowired
    ActivityRecordsMapper activityRecordsMapper;

    @Autowired
    private BirthdayService birthdayService;

    @Autowired
    private RockService rockService;

    @Autowired
    private IClientService iClientService;

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(HongbaoService.class);

    /**
     * 分页查询红包活动列表
     *
     * @should @return
     */

    public PageInfo queryHBPools(HBPoolVO hbPoolVO, Integer pageNum, Integer length, String sortContent, Long sellerId) {

        HBPoolExample hbPoolExample = new HBPoolExample();
        HBPoolExample.Criteria criteria = hbPoolExample.createCriteria();

        if (!StringUtils.isBlank(hbPoolVO.getName())) {//当名字不为空
            criteria.andNameLike("%" + hbPoolVO.getName() + "%");
        }
        if (!StringUtils.isBlank(hbPoolVO.getType())) {//当红包类别不为空
            criteria.andTypeEqualTo(hbPoolVO.getType());
        }
        if (hbPoolVO.getStartDate() != null) {//创建时间大于等于开始时间
            criteria.andGmtCreatedGreaterThanOrEqualTo(hbPoolVO.getStartDate());
        }
        if (hbPoolVO.getEndDate() != null) {//创建时间小于等于结束时间
            criteria.andGmtCreatedLessThanOrEqualTo(hbPoolVO.getEndDate());
        }

        if (StringUtils.isNotEmpty(hbPoolVO.getStates())) {
            criteria.andStatesEqualTo(hbPoolVO.getStates());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        if (!StringUtils.isBlank(sortContent)) {//排序信息
            hbPoolExample.setOrderByClause(sortContent);
        } else {
            hbPoolExample.setOrderByClause(" gmt_modified desc ");
        }

        if (pageNum != null && length != null)
            PageHelper.startPage(pageNum, length);

        //紧跟着的第一个select方法会被分页
        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);

        //用PageInfo对结果进行包装
        return new PageInfo(hbPools);
    }

    /**
     * 根据查询条件获取红包列表
     *
     * @param hbPoolVO
     * @return
     */
    public List<HBPool> getHbPoolLis(HBPoolVO hbPoolVO, Long sellerId) {

        HBPoolExample hbPoolExample = new HBPoolExample();
        HBPoolExample.Criteria criteria = hbPoolExample.createCriteria();

        if (hbPoolVO.getId() != null) {
            criteria.andIdEqualTo(hbPoolVO.getId());
        }

        if (hbPoolVO.getPoolId() != null) {
            criteria.andPoolIdEqualTo(hbPoolVO.getPoolId());
        }

        if (!StringUtils.isBlank(hbPoolVO.getName())) {//当名字不为空
            criteria.andNameLike("%" + hbPoolVO.getName() + "%");
        }

        if (!StringUtils.isBlank(hbPoolVO.getType())) {//当红包类别不为空
            criteria.andTypeEqualTo(hbPoolVO.getType());
        }

        if (hbPoolVO.getStartDate() != null) {//创建时间大于等于开始时间
            criteria.andGmtCreatedGreaterThanOrEqualTo(hbPoolVO.getStartDate());
        }

        if (hbPoolVO.getEndDate() != null) {//创建时间小于等于结束时间
            criteria.andGmtCreatedLessThanOrEqualTo(hbPoolVO.getEndDate());
        }

        if (hbPoolVO.getBirthdayDate() != null) {
            criteria.andStartDateLessThanOrEqualTo(hbPoolVO.getBirthdayDate());
            criteria.andEndDateGreaterThanOrEqualTo(hbPoolVO.getBirthdayDate());
        }

        if (StringUtils.isNotBlank(hbPoolVO.getIsDeleted())) {
            criteria.andIsDeletedEqualTo(hbPoolVO.getIsDeleted());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);

        return hbPools;
    }

    /**
     * 分页查询红包领取明细
     *
     * @return
     */
    public PageInfo queryHBObtains(HBObtainVO hbObtainVO, Integer pageNum, Integer length, Long sellerId) {

        HBObtainExample hbObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hbObtainExample.createCriteria();

        if (hbObtainVO.getPoolId() != null) {//当红包活动id不为空
            criteria.andPoolIdEqualTo(hbObtainVO.getPoolId());
        }

        if (hbObtainVO.getUserId() != null) {//当用户id不为空
            criteria.andUserIdEqualTo(hbObtainVO.getUserId());
        }

        if (hbObtainVO.getStatus() != null) {//当红包状态不为空的时候
            criteria.andStatusEqualTo(hbObtainVO.getStatus());
        }

        if (hbObtainVO.getStartDate() != null) {//领取时间大于等于开始时间
            criteria.andObtainDatatimeGreaterThanOrEqualTo(hbObtainVO.getStartDate());
        }

        if (hbObtainVO.getEndDate() != null) {//领取时间小于等于结束时间
            criteria.andObtainDatatimeLessThanOrEqualTo(hbObtainVO.getEndDate());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        PageHelper.startPage(pageNum, length);
        List<HBObtain> hbObtains = hBObtainMapper.selectByExample(hbObtainExample);

        return new PageInfo(hbObtains);
    }


    public PageInfo getHBObtainWithUser(HBObtainVO hbObtainVO, Integer pageNum, Integer length, String sortContent, Long sellerId) {

        HBObtainDO hbObtainDO = new HBObtainDO();
        BeanCopierUtils.copyProperties(hbObtainVO, hbObtainDO);

        if (sellerId != null) {
            hbObtainDO.setSellerId(sellerId);
        }

        if (StringUtils.isNotBlank(sortContent)) {
            hbObtainDO.setOrderByClause(sortContent);
        } else {
            hbObtainDO.setOrderByClause(" gmt_modified desc ");
        }

        PageHelper.startPage(pageNum, length);
        List<HBObtainDO> hbObtainDOs = hongBaoObtainDao.getHBObtainWithUser(hbObtainDO);

        return new PageInfo(hbObtainDOs);

    }

    /**
     * 查询红包领取明细列表
     *
     * @return
     */
    public List<HBObtain> queryHBObtainList(HBObtainVO hbObtainVO, Long sellerId) {

        HBObtainExample hbObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hbObtainExample.createCriteria();

        if (hbObtainVO.getPoolId() != null) {//当红包活动id不为空
            criteria.andPoolIdEqualTo(hbObtainVO.getPoolId());
        }

        if (hbObtainVO.getUserId() != null) {//当用户id不为空
            criteria.andUserIdEqualTo(hbObtainVO.getUserId());
        }

        if (hbObtainVO.getId() != null) {
            criteria.andIdEqualTo(hbObtainVO.getId());
        }

        if (hbObtainVO.getHongbaoObtainId() != null) {
            criteria.andHongbaoObtainIdEqualTo(hbObtainVO.getHongbaoObtainId());
        }

        if (hbObtainVO.getStatus() != null) {
            criteria.andStatusEqualTo(hbObtainVO.getStatus());
        }

        if (hbObtainVO.getStartDate() != null) {//领取时间大于等于开始时间
            criteria.andObtainDatatimeGreaterThanOrEqualTo(hbObtainVO.getStartDate());
        }

        if (hbObtainVO.getEndDate() != null) {//领取时间小于等于结束时间
            criteria.andObtainDatatimeLessThanOrEqualTo(hbObtainVO.getEndDate());
        }

        hbObtainExample.setOrderByClause(" gmt_modified desc ");

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        List<HBObtain> hbObtains = hBObtainMapper.selectByExample(hbObtainExample);

        return hbObtains;
    }

    /**
     * 查询红包提现列表
     *
     * @param hbCashVO
     * @return
     */
    public List<HBCash> queryHBCashList(HBCashVO hbCashVO, Long sellerId) {

        HBCashExample hbCashExample = new HBCashExample();
        HBCashExample.Criteria criteria = hbCashExample.createCriteria();

        if (hbCashVO.getUserId() != null) {//当红包提现用户id不为空的时候
            criteria.andUserIdEqualTo(hbCashVO.getUserId());
        }

        if (hbCashVO.getStartDate() != null) {//提现时间大于等于开始时间
            criteria.andObtainDateGreaterThanOrEqualTo(hbCashVO.getStartDate());
        }

        if (hbCashVO.getEndDate() != null) {//提现时间小于等于开始时间
            criteria.andObtainDateLessThanOrEqualTo(hbCashVO.getEndDate());
        }

        if (hbCashVO.getAmount() != null) {//当提现金额不为空的时候
            criteria.andAmountEqualTo(hbCashVO.getAmount());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        List<HBCash> hbCashs = hbCashMapper.selectByExample(hbCashExample);
        return hbCashs;
    }

    /**
     * 分页查询红包账户明细
     *
     * @return
     */
    public PageInfo queryHBAccounts(UserAccountVO userAccountVO, Integer pageNum, Integer length, Long sellerId) {

        UserAccountExample userAccountExample = new UserAccountExample();
        UserAccountExample.Criteria criteria = userAccountExample.createCriteria();

        if (userAccountVO.getStartDate() != null) {
            criteria.andHbcashDateGreaterThanOrEqualTo(userAccountVO.getStartDate());
        }
        if (userAccountVO.getEndDate() != null) {
            criteria.andHbcashDateLessThanOrEqualTo(userAccountVO.getEndDate());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        PageHelper.startPage(pageNum, length);
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);

        return new PageInfo(userAccounts);
    }


    /**
     * 根据id删除红包活动
     *
     * @param id
     */
    public void deleteHbPoolById(long id) {
        hBPoolMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取红包活动详细信息
     *
     * @param id
     */
    public HBPoolVO getHBPoolVOById(long id, Long sellerId) {

        HBPoolExample hbPoolExample = new HBPoolExample();
        hbPoolExample.createCriteria().andIdEqualTo(id);

        if (sellerId != null) {
            hbPoolExample.createCriteria().andSellerIdEqualTo(sellerId);
        }

        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);
        HBPoolVO hbPoolVO = new HBPoolVO();

        if (!CollectionUtils.isEmpty(hbPools)) {
            HBPool hbPool = hbPools.get(0);
            BeanCopierUtils.copyProperties(hbPool, hbPoolVO);
        }

        return hbPoolVO;
    }


    /**
     * 根据pool_id获取红包活动详细信息
     *
     * @param poolId
     */
    public HBPoolVO getHBPoolVOByPoolId(long poolId, Long sellerId) {

        HBPoolExample hbPoolExample = new HBPoolExample();
        hbPoolExample.createCriteria().andPoolIdEqualTo(poolId);

        if (sellerId != null) {
            hbPoolExample.createCriteria().andSellerIdEqualTo(sellerId);
        }

        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);

        HBPoolVO hbPoolVO = new HBPoolVO();
        if (!CollectionUtils.isEmpty(hbPools)) {
            HBPool hbPool = hbPools.get(0);
            BeanCopierUtils.copyProperties(hbPool, hbPoolVO);
        }

        return hbPoolVO;

    }

    /**
     * 创建红包活动
     *
     * @param hbPoolVO
     */
    @Transactional
    public HBPoolVO createHBPool(HBPoolVO hbPoolVO) {

        /**
         * 创建红包活动
         */
        HBPool hbPool = new HBPool();
        BeanCopierUtils.copyProperties(hbPoolVO, hbPool);

        try {
            hBPoolMapper.insert(hbPool);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServiceException("创建红包活动失败,异常回滚!");
        }

        Long hbPoolId = hbPool.getPoolId();//获取创建后的红包活动id
        /**
         *保存红包活动规则
         */
        RuleConfig ruleConfig = new RuleConfig();//新建规则配置对象
        ruleConfig.setValue(hbPoolVO.getRuleExpression());

        if ("prise".equals(hbPoolVO.getType())) {
            ruleConfig.setType(RuleType.HB_PRAISE.getCode());//设置类型为好评返规则
        } else
            ruleConfig.setType(RuleType.HB_POOL.getCode());//设置类型为红包活动规则

        ruleConfig.setDescText(hbPoolVO.getName() + "红包活动规则");//设置红包活动规则描述
        ruleConfig.setName(hbPoolId + "_" + RuleType.HB_POOL.getCode());//name设置为bizId+ruleType

        try {
            int count = ruleConfigMapper.insert(ruleConfig);
        } catch (Exception e) {
            throw new ServiceException("创建红包活动规则失败,异常回滚!");
        }

        /**
         * 更新红包活动
         */
        hbPool.setRuleConfigId(ruleConfig.getId());
        hBPoolMapper.updateByPrimaryKey(hbPool);
        hbPoolVO.setId(hbPool.getId());//设置红包活动id
        hbPoolVO.setPoolId(hbPool.getPoolId());
        hbPoolVO.setRuleConfig(ruleConfig);//设置红包活动规则配置
        return hbPoolVO;
    }

    /**
     * 更新红包活动
     *
     * @param hbPoolVO
     */
    @Transactional
    public HBPoolVO updateHBPool(HBPoolVO hbPoolVO, Long sellerId) {

        HBPool hbPool = new HBPool();
        BeanCopierUtils.copyProperties(hbPoolVO, hbPool);

        try {
            hBPoolMapper.updateByPrimaryKeySelective(hbPool);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServiceException("更新红包活动失败,异常回滚!");
        }

        HBPoolExample hbPoolExample = new HBPoolExample();
        hbPoolExample.createCriteria().andIdEqualTo(hbPool.getId()).andSellerIdEqualTo(sellerId);
        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);
        HBPool hbPool1 = hbPools.get(0);

        Long ruleConfigId = hbPool1.getRuleConfigId();
        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        ruleConfigExample.createCriteria().andIdEqualTo(ruleConfigId).andSellerIdEqualTo(sellerId);
        List<RuleConfig> ruleConfigs = ruleConfigMapper.selectByExample(ruleConfigExample);
        RuleConfig ruleConfig = ruleConfigs.get(0);
        ruleConfig.setValue(hbPoolVO.getRuleExpression());

        try {
            ruleConfigMapper.updateByPrimaryKey(ruleConfig);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServiceException("更新红包活动规则失败,异常回滚!");
        }
        hbPoolVO.setPoolId(hbPool1.getPoolId());
        hbPoolVO.setRuleConfig(ruleConfig);
        return hbPoolVO;
    }

    @Override
    public void updateHBPoolBySelective(HBPoolVO hbPoolVO) {

        HBPool hbPool = new HBPool();
        BeanCopierUtils.copyProperties(hbPoolVO, hbPool);

        try {
            hBPoolMapper.updateByPrimaryKeySelective(hbPool);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServiceException("更新红包活动失败,异常回滚!");
        }

    }


    /**
     * 领取红包,返回红包领用id
     *
     * @param hbPoolId
     * @param userId
     */
    @Transactional
    public Long receiveHongBao(Long hbPoolId, Long userId, String ammount, Long sellerId, String businessType) {
        Long result = receiveCommonHongBao(hbPoolId, userId, ammount, sellerId);

        if ("shake".equals(businessType)) {
            HBObtain hbObtain = getHbObtainByObtainId(sellerId, userId, hbPoolId);
            if (hbObtain != null) {
                String rockId = rockService.getRockIdByHbPollId(sellerId, hbPoolId);
                rockService.insertShakeObtain(sellerId, userId, DaoConstant.ShakeBizType.SHAKE_HB, Long.valueOf(rockId), hbObtain.getHongbaoObtainId(), DaoConstant.ShakeObtainStatus.TO_RECEIVE);
            }

        }
        return result;

    }

    public Long receiveCommonHongBao(Long hbPoolId, Long userId, String ammount, Long sellerId) {
        try {

            /**
             *
             * 并发情况下，判断红包活动的红包是否领完,用乐观锁
             */
            HBPoolExample hbPoolExample = new HBPoolExample();
            hbPoolExample.createCriteria().andPoolIdEqualTo(hbPoolId).andSellerIdEqualTo(sellerId);

            HBPool hbPool = new HBPool();
            hbPool.setNumberObtainExpression("number_obtain +" + 1);

            int count = hbPoolDAO.updateByNumberExampleSelective(hbPool, hbPoolExample);

            if (0 == count) {
                logger.info("HongbaoSevcieImpl.receiveHongBao()红包活动表更新失败");
                throw new UserRemindException("红包已领完!");
            }

            logger.info("HongbaoSevcieImpl.receiveHongBao()红包活动表更新成功");

            /**
             * 查询红包领取记录
             */
            HBObtain hbObtain = new HBObtain();
            HBObtainExample hBObtainExample = new HBObtainExample();
            HBObtainExample.Criteria criteria = hBObtainExample.createCriteria();
            Random rd = new Random();
            criteria.andPoolIdEqualTo(hbPoolId).andStatusEqualTo(HBObtainStatus.TORECEIVE.getCode()).andIsDeletedEqualTo("0").andSellerIdEqualTo(sellerId);

            if (StringUtils.isNotBlank(ammount)) {
                criteria.andAmountEqualTo(Long.valueOf(ammount));
            }

            List<HBObtain> hbObtains = hBObtainMapper.selectByExample(hBObtainExample);

            if (CollectionUtils.isEmpty(hbObtains)) {
                throw new UserRemindException("红包已领完!");
            }


            hbObtain = hbObtains.get(rd.nextInt(hbObtains.size()));

            hbObtain.setUserId(userId);

            try {
                hBObtainMapper.updateByPrimaryKey(hbObtain);//更新红包领用记录表
            } catch (Exception e) {
                throw new ServiceException("更新红包领用表失败,异常回滚!");
            }


            return hbObtain.getHongbaoObtainId();

        } catch (UserRemindException e) {

            throw new UserRemindException(e);

        } catch (Exception e) {

            throw new ServiceException(e);
        }

    }

    /**
     * 拆没有其它特殊业务处理的红包,如普通红包,好评返红包
     * (有特殊业务处理的红包如:生日红包需要处理礼物表,积分兑换红包需要处理积分兑换表)
     *
     * @param hbObtainId
     * @param userId
     * @param hbPoolId
     * @return
     */
    @Transactional
    public Long dismantleOtherHongBao(Long hbObtainId, Long userId, Long hbPoolId, String businessType, Long sellerId) {

        Long result = dismantleHongBao(hbObtainId, userId, hbPoolId, sellerId);

        if ("birthday".equals(businessType)) {
            birthdayService.updateStateAboutHb(sellerId, userId, hbPoolId);
        }

        if ("shake".equals(businessType)) {
            rockService.updateShakeObtain(sellerId, hbObtainId, "hongbao", "现金" + CommonUtil.longDivide(result, Long.valueOf(100)) + "元");
        }

        if ("point_exchange".equals(businessType)) {
            iClientService.updateAfterPointExchangeHongBaoSuccess(sellerId, userId, hbObtainId, DaoConstant.PointExchangeStatus.SUCCESS);
        }

        return result;
    }

    public Long dismantleHongBao(Long hbObtainId, Long userId, Long hbPoolId, Long sellerId) {

        try {

            AssertsUtil.notNull(hbObtainId, "hbObtainId");
            AssertsUtil.notNull(userId, "userId");

            /**
             * 更新红包领用表,用户表
             */
            HBObtainExample hbObtainExample = new HBObtainExample();
            hbObtainExample.createCriteria().andUserIdEqualTo(userId).andHongbaoObtainIdEqualTo(hbObtainId).andSellerIdEqualTo(sellerId);

            List<HBObtain> hbObtains = hBObtainMapper.selectByExample(hbObtainExample);

            if (CollectionUtils.isEmpty(hbObtains)) {

                throw new UserRemindException("您的红包已经过期!");
            }

            HBObtain hbObtain = hbObtains.get(0);
            hbObtain.setObtainDatatime(new Date());
            hbObtain.setStatus(HBObtainStatus.RECEIVED.getCode());//设置状态为已处理

            try {
                hBObtainMapper.updateByPrimaryKeySelective(hbObtain);//更新红包领用记录表
            } catch (Exception e) {
                throw new ServiceException("更新红包领用表失败,异常回滚!");
            }

            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
            List<User> users = userMapper.selectByExample(userExample);

            if (!CollectionUtils.isEmpty(users)) {

                try {
                    User user = users.get(0);
                    user.setIsReceivedHb("1");
                    userMapper.updateByPrimaryKey(user);
                } catch (Exception e) {
                    throw new ServiceException("更新用户信息失败,异常回滚!");
                }

            }

            Long ammount = hbObtain.getAmount();
            String hongbaoType = hbObtain.getHongbaoType();

            UserAccountExample userAccountExample = new UserAccountExample();
            userAccountExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
            List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);

            /**
             *保存更新用户账户表,乐观锁控制
             */
            UserAccount userAccountTemp = new UserAccount();
            userAccountTemp.setSellerId(Long.valueOf(sellerId));
            userAccountTemp.setUserId(userId);

            if (!CollectionUtils.isEmpty(userAccounts)) {

                UserAccount userAccount = userAccounts.get(0);//获取用户账户
                UserAccountExample userAccountExampleTemp = new UserAccountExample();
                userAccountExampleTemp.createCriteria().andUserAccountVersionEqualTo(userAccount.getUserAccountVersion()).andAccountIdEqualTo(userAccount.getAccountId());

                userAccountTemp.setAccountId(userAccount.getAccountId());
                userAccountTemp.setHbobtainAmountExpression("hbobtain_amount +" + ammount);//设置账户领取金额
                userAccountTemp.setHongbaoAmountExpression("hongbao_amount +" + ammount);//设置账户剩余金额
                userAccountTemp.setHbtotalNumberExpression("hbtotal_number +" + 1);
                userAccountTemp.setUserAccountVersionExpression("user_account_version +" + 1);

                if (DaoConstant.HongBaoType.PRAISE.equals(hongbaoType)) {
                    userAccountTemp.setHongbaoPraiseAmountExpression("hongbao_praise_amount +" + ammount);
                }

                int countTemp = userAccountMapper.updateByExampleSelective(userAccountTemp, userAccountExampleTemp);

                if (0 == countTemp) {
                    logger.error("HongbaoSevcieImpl.receiveHongBao()用户账户表更新失败");
                    throw new UserRemindException("红包已经领取,不能再领!");
                }

                logger.info("HongbaoSevcieImpl.receiveHongBao()用户账户表更新成功");

            } else {

                try {

                    userAccountTemp.setHbobtainAmount(ammount);
                    userAccountTemp.setHongbaoAmount(ammount);
                    userAccountTemp.setHbobtainAmount(Long.valueOf(1));

                    if (DaoConstant.HongBaoType.PRAISE.equals(hongbaoType)) {
                        userAccountTemp.setHongbaoPraiseAmount(ammount);
                    }

                    userAccountMapper.insertSelective(userAccountTemp);
                } catch (Exception e) {

                    logger.error("HongbaoSevcieImpl.receiveHongBao()用户账户表插入失败");
                    throw new ServiceException("插入用户账户信息失败,异常回滚!");
                }

            }

            /**
             * 统计红包活动剩余未领取红包数量
             */
            HBPoolVO hbPoolVO = getHBPoolVOByPoolId(hbPoolId, sellerId);

            hbPoolVO.setObtainAmount(hbPoolVO.getObtainAmount() + ammount);//设置红包领取金额
//            hbPoolVO.setNumberObtain(hbPoolVO.getNumberObtain()+1);
            updateHBPoolBySelective(hbPoolVO);//更新红包活动信息

            /**
             * 保存活动记录信息
             */
            ActivityRecords ar = new ActivityRecords();
            ar.setActivityId(hbPoolId);
            ar.setActivityName(hbPoolVO.getName());
            ar.setUserId(userId);
            ar.setSellerId(sellerId);
            ar.setActivityType(DaoConstant.ActivityType.ACTIVITY_HONGBAO);
            activityRecordsMapper.insertSelective(ar);

            return ammount;

        } catch (UserRemindException e) {

            throw new UserRemindException(e);

        } catch (Exception e) {

            throw new ServiceException(e);
        }

    }

    /**
     * 用户红包提现
     *
     * @param user                用户
     * @param hbCurrentCashAmount 红包提现金额
     * @param actionType          操作类型 unLimit:不限制提现金额 limit:限制提现金额
     */
    @Transactional
    public void cashHongBao(User user, Long hbCurrentCashAmount, String actionType, Long sellerId) {

        try {

            /**
             * 更新用户账户表,乐观锁
             */
            UserAccountExample userAccountExample = new UserAccountExample();
            userAccountExample.createCriteria().andUserIdEqualTo(user.getUserId()).andSellerIdEqualTo(sellerId);
            List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);

            if (!CollectionUtils.isEmpty(userAccounts)) {

                UserAccount userAccount = userAccounts.get(0);
                UserAccountExample userAccountExampleTemp = new UserAccountExample();
                UserAccountExample.Criteria criteria = userAccountExampleTemp.createCriteria();
                criteria.andUserAccountVersionEqualTo(userAccount.getUserAccountVersion()).andAccountIdEqualTo(userAccount.getAccountId()).andSellerIdEqualTo(sellerId);

                if ("unLimit".equals(actionType)) {
                    criteria.andHongbaoPraiseAmountGreaterThanOrEqualTo(hbCurrentCashAmount);
                } else
                    criteria.andHongbaoAmountGreaterThanOrEqualTo(hbCurrentCashAmount + userAccount.getHongbaoPraiseAmount());

                UserAccount userAccountTemp = new UserAccount();
                userAccountTemp.setHbcashAmountExpression("hbcash_amount +" + hbCurrentCashAmount);
                userAccountTemp.setHongbaoAmountExpression("hongbao_amount -" + hbCurrentCashAmount);
                userAccountTemp.setHbcashDate(new Date());
                userAccountTemp.setUserAccountVersionExpression("user_account_version +" + 1);
                int countTemp = userAccountMapper.updateByExampleSelective(userAccountTemp, userAccountExampleTemp);

                if (0 == countTemp) {
                    logger.info("HongbaoSevcieImpl.cashHongBao()用户账户表更新失败");
                    throw new UserRemindException("红包已经提现,不能再提现!");
                }

                logger.info("HongbaoSevcieImpl.cashHongBao()用户账户表更新成功");

            }

            try {

                HBCash hbCash = new HBCash();
                hbCash.setUserId(user.getUserId());
                hbCash.setObtainDate(new Date());
                hbCash.setAmount(hbCurrentCashAmount);
                hbCashMapper.insertSelective(hbCash);

            } catch (Exception e) {

                logger.error("HongbaoSevcieImpl.cashHongBao()插入用户提现表失败");
                throw new ServiceException("插入用户提现表失败,异常回滚!");
            }

            /**
             * 执行红包提现业务,调用企业向微信用户付款接口
             */
            Map<String, String> params = new HashMap<String, String>();

            params.put("partner_trade_no", WXHelper.createMchId(user.getUserId().toString()));
            params.put("openid", user.getWxOpenid());
            params.put("amount", hbCurrentCashAmount.toString());

            try {
                WXAdapter.enterpriseTransfers(params, String.valueOf(sellerId));
            } catch (Exception e) {
                logger.error(e.getMessage());
                throw new ServiceException("微信企业付款失败,异常回滚!");
            }

        } catch (UserRemindException e) {

            throw new UserRemindException(e);

        } catch (Exception e) {

            throw new ServiceException(e);

        }
    }


    /**
     * 插入红包领用记录表
     *
     * @param hbObtain
     * @return
     */
    public int insertObtain(HBObtain hbObtain) {

        int count = hBObtainMapper.insertSelective(hbObtain);

        if (1 != count) {
            throw new ServiceException("插入红包领用失败,异常回滚!");
        }

        return count;
    }

    /**
     * 初始化红包活动规则结果
     *
     * @param hbPoolId   红包活动id
     * @param ruleConfig 规则表达式
     */
    public boolean initHBRuleResult(Long hbPoolId, RuleConfig ruleConfig, Long sellerId) {

        RuleContext ruleContext = new RuleContext(ruleConfig, hbPoolId, ruleConfig.getType(), sellerId);
        HBRuleEngine hbRuleEngine = new HBRuleEngine(ruleContext);//新建红包活动规则引擎

        hbRuleEngine.initRuleResult();//调用初始化结果

        return true;
    }

    /**
     * 更新红包活动规则结果
     *
     * @param hbPoolId   红包活动id
     * @param ruleConfig 规则表达式
     */
    public boolean updateHBRuleResult(Long hbPoolId, RuleConfig ruleConfig, Long sellerId) {

        /**
         * 删除原有的红包活动领用记录
         */
        HBObtainExample hbObtainExample = new HBObtainExample();
        hbObtainExample.createCriteria().andPoolIdEqualTo(hbPoolId).andSellerIdEqualTo(sellerId);
        hBObtainMapper.deleteByExample(hbObtainExample);

        /**
         * 删除原先缓存中的值,重新调用红包活动规则引擎
         */
        RuleCache.put(hbPoolId + "_" + ruleConfig.getType(), new Rule());
        RuleContext ruleContext = new RuleContext(ruleConfig, hbPoolId, ruleConfig.getType(), sellerId);
        HBRuleEngine hbRuleEngine = new HBRuleEngine(ruleContext);//新建红包活动规则引擎
        hbRuleEngine.initRuleResult();//调用初始化结果

        return true;
    }

    /**
     * 获取用户提现1块钱的次数
     *
     * @param userVO
     * @return
     */
    public Integer getCachCountOneAmmount(UserVO userVO, Long sellerId) {

        HBCashVO hbCashVO = new HBCashVO();
        hbCashVO.setUserId(userVO.getUserId());
        hbCashVO.setAmount(Long.valueOf(100));//金额分为单位
        List<HBCash> hbCashList = queryHBCashList(hbCashVO, sellerId);

        if (org.springframework.util.CollectionUtils.isEmpty(hbCashList)) {
            return 0;
        }

        return hbCashList.size();
    }

    @Override
    public HBPool getHbPoolSum(HBPool hbPool, Long sellerId) {

        HBPoolExample hbPoolExample = new HBPoolExample();

        if (hbPool.getId() != null) {
            hbPoolExample.createCriteria().andIdEqualTo(hbPool.getId());
        }

        if (hbPool.getPoolId() != null) {
            hbPoolExample.createCriteria().andPoolIdEqualTo(hbPool.getPoolId());
        }

        if (sellerId != null) {
            hbPoolExample.createCriteria().andSellerIdEqualTo(sellerId);
        }

        hbPoolExample.setDefinedQueryColumns(true);
        hbPoolExample.addSumNumberObtainQueryColumn();
        hbPoolExample.addSumTotalAmountQueryColumn();
        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);

        return hbPools.isEmpty() ? new HBPool() : hbPools.get(0);
    }

    @Override
    public HBPool getHbPoolSumByVO(HBPoolVO hbPoolVO, Long sellerId) {


        HBPoolExample hbPoolExample = new HBPoolExample();
        HBPoolExample.Criteria criteria = hbPoolExample.createCriteria();

        if (!StringUtils.isBlank(hbPoolVO.getName())) {//当名字不为空
            criteria.andNameLike("%" + hbPoolVO.getName() + "%");
        }
        if (!StringUtils.isBlank(hbPoolVO.getType())) {//当红包类别不为空
            criteria.andTypeEqualTo(hbPoolVO.getType());
        }
        if (hbPoolVO.getStartDate() != null) {//创建时间大于等于开始时间
            criteria.andGmtCreatedGreaterThanOrEqualTo(hbPoolVO.getStartDate());
        }
        if (hbPoolVO.getEndDate() != null) {//创建时间小于等于结束时间
            criteria.andGmtCreatedLessThanOrEqualTo(hbPoolVO.getEndDate());
        }
        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        hbPoolExample.setDefinedQueryColumns(true);

        hbPoolExample.addSumTotalAmountQueryColumn();
        hbPoolExample.addSumObtainAmountQueryColumn();
        hbPoolExample.addSumNumberQueryColumn();
        hbPoolExample.addSumNumberObtainQueryColumn();
        List<HBPool> hbPools = hBPoolMapper.selectByExample(hbPoolExample);

        return hbPools.isEmpty() ? new HBPool() : hbPools.get(0);
    }

    @Override
    public int getObtianHbPraseCount(Long sellerId) {

        HBObtainExample hBObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hBObtainExample.createCriteria();
        criteria.andObtainPostNumberIsNotNull().andSellerIdEqualTo(sellerId);

        return hBObtainMapper.countByExample(hBObtainExample);
    }

    @Override
    public int countHongbaoObtain(HBObtainVO hbObtainVO, Long sellerId) {

        HBObtainExample hBObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hBObtainExample.createCriteria();

        if (hbObtainVO.getStartDate() != null) {
            criteria.andObtainDatatimeGreaterThanOrEqualTo(hbObtainVO.getStartDate());
        }

        if (hbObtainVO.getEndDate() != null) {
            criteria.andObtainDatatimeLessThanOrEqualTo(hbObtainVO.getEndDate());
        }

        if (hbObtainVO.getUserId() != null) {
            criteria.andUserIdEqualTo(hbObtainVO.getUserId());
        }

        if (StringUtils.isNotBlank(hbObtainVO.getStatus())) {
            criteria.andStatusEqualTo(hbObtainVO.getStatus());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        return hBObtainMapper.countByExample(hBObtainExample);
    }

    @Override
    public int countHongbaoCash(HBCashVO hbCashVO, Long sellerId) {

        HBCashExample hbCashExample = new HBCashExample();
        HBCashExample.Criteria criteria = hbCashExample.createCriteria();

        if (hbCashVO.getStartDate() != null) {
            criteria.andObtainDateGreaterThanOrEqualTo(hbCashVO.getStartDate());
        }

        if (hbCashVO.getEndDate() != null) {
            criteria.andObtainDateLessThanOrEqualTo(hbCashVO.getEndDate());
        }

        if (hbCashVO.getUserId() != null) {
            criteria.andUserIdEqualTo(hbCashVO.getUserId());
        }

        if (sellerId != null) {
            criteria.andSellerIdEqualTo(sellerId);
        }

        return hbCashMapper.countByExample(hbCashExample);
    }

    /**
     * 查找商家有效红包活动
     * 1. 在有效期内
     * 2. 没有领完
     *
     * @param hbPoolDO
     */
    @Override
    public List<HBPool> findValidHbPoolBySellerId(HBPoolDO hbPoolDO, Long sellerId) {

        if (sellerId != null) {
            hbPoolDO.setSellerId(sellerId);
        }
        return hbPoolDAO.findValidHbPoolBySellerId(hbPoolDO);
    }


    @Transactional
    public void updateHbObtainAndPool(Long sellerId, HBObtain hbObtain) {

        long hbPoolId = hbObtain.getPoolId();

        hBObtainMapper.updateByPrimaryKey(hbObtain);

        HBPool hbPool = new HBPool();
        hbPool.setNumberObtainExpression("  number_obtain -1");
        HBPoolExample hbPoolExample = new HBPoolExample();
        hbPoolExample.createCriteria().andPoolIdEqualTo(hbPoolId).andSellerIdEqualTo(sellerId);
        hBPoolMapper.updateByExampleSelective(hbPool, hbPoolExample);

    }


    /**
     * 根据用户和红包池ID查询红包占用记录信息
     *
     * @param sellerId 商户ID
     * @param hbPoolId 红包池ID
     * @return
     */
    public HBObtain getHbObtainByObtainId(Long sellerId, Long userId, Long hbPoolId) {

        HBObtainExample hbObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hbObtainExample.createCriteria();
        criteria.andPoolIdEqualTo(hbPoolId);
        criteria.andUserIdEqualTo(userId);
        criteria.andSellerIdEqualTo(sellerId);
        List<HBObtain> hbObtainList = hBObtainMapper.selectByExample(hbObtainExample);
        if (CollectionUtils.isEmpty(hbObtainList)) {
            return null;
        }

        return hbObtainList.get(0);

    }


}
