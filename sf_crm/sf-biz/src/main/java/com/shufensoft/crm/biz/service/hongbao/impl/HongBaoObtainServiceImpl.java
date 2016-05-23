package com.shufensoft.crm.biz.service.hongbao.impl;


import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.hongbao.HongBaoObtainDao;
import com.shufensoft.crm.biz.dao.defined.pointMall.PointExchangeDetailDao;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.dao.generation.point.PointExchangeMapper;
import com.shufensoft.crm.biz.domain.defined.hongbao.HBPoolDO;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeDetailDo;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.ruleEngine.HBRuleEngine;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/14  
 */
@Service(value = "hongBaoObtainService")
public class HongBaoObtainServiceImpl implements HongBaoObtainService {

    /**
     * logger
     */
    public static final Logger logger = Logger.getLogger(HongBaoObtainServiceImpl.class);

    @Autowired
    private HBObtainMapper hbObtainMapper;

    @Autowired
    private HongBaoObtainDao hongBaoObtainDao;

    @Autowired
    private PointExchangeDetailDao pointExchangeDetailDao;

    @Autowired
    private PointExchangeMapper pointExchangeMapper;

    @Autowired
    private HongbaoService hongbaoService;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    @Autowired
    private JdTradeService jdTradeService;

    @Autowired
    private UserService userService;

    @Autowired
    private HBObtainMapper hBObtainMapper;

    @Autowired
    private HBPoolMapper hBPoolMapper;


    /**
     * 默认分页为40条
     */
    protected int pageSize = 40;

    /**
     * @param userId
     * @param pointAmount 1. 用户每次点击积分兑换都要到point_exchange表中查询没有兑换的红包记录, 如果已过时或者已领用完, 把状态设置为过期和已领完
     *                    如果没有过时, 记录下红包活动ID和消耗的积分
     *                    2. 查询所有能兑换的红包(客户可用积分减去历史能兑换但没有兑换的红包消耗的积分),
     *                    如果遇到新增加的积分兑换红包活动, 就新增这个红包兑换记录到point_exchange
     */
    @Override
    @Transactional
    public boolean fixExchangeHongbao(Long userId, Long pointAmount,Long  sellerId) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sellerId", sellerId);
        params.put("userId", userId);
        Set<Long> poolIds = new HashSet<Long>();
        Long expendPoint = 0L;                           //查询用户参加的所有积分兑换红包活动
        List<PointExchangeDetailDo> pointExchangeDetailDos = pointExchangeDetailDao.findNotFinishPointExchangeHongbao(params);
        PointExchange pointExchange = null;
        for (PointExchangeDetailDo pdo : pointExchangeDetailDos) {
            if (DaoConstant.PointExchangeStatus.WAIT_EXCHANGE.equals(pdo.getStatus())) {
                if (pdo.getNumber() <= pdo.getObtainedNum()) {     //已经领完
                    pointExchange = new PointExchange();
                    pointExchange.setId(pdo.getPointExchangeId());
                    pointExchange.setStatus("over");
                    pointExchangeMapper.updateByPrimaryKeySelective(pointExchange);
                } else if (pdo.getEndDate().before(new Date())) {    //已过期
                    pointExchange = new PointExchange();
                    pointExchange.setId(pdo.getPointExchangeId());
                    pointExchange.setStatus("expire");
                    pointExchangeMapper.updateByPrimaryKeySelective(pointExchange);
                } else {
                    expendPoint += pdo.getPoint();
                }
            }
            poolIds.add(pdo.getPoolId());   //记录红包活动ID
        }
        //根据当前可用积分找到能兑换的最大红包金额 hongbao_obtain
        HBPoolDO hbPoolDO = new HBPoolDO();
        hbPoolDO.setSellerId(sellerId);
        hbPoolDO.setType(DaoConstant.HongBaoType.POINT_EXCHANGE);
        List<HBPool> hbPools = hongbaoService.findValidHbPoolBySellerId(hbPoolDO,sellerId);
        Long usePoint = pointAmount - expendPoint;     //可用积分
        for (HBPool pool : hbPools) {
            if (!poolIds.contains(pool.getPoolId())) {     //没有记录到point_exchange中, 有新增的积分兑换红包活动
                Rule rule = RuleCache.get(String.valueOf(pool.getPoolId()), RuleType.HB_POOL.getCode(),sellerId);
                List<RuleExpression> ruleExpressions = rule.getRuleExpressions();
                for (RuleExpression ruleExpression : ruleExpressions) {
                    Long amount = null;                 // 最大能兑换多少元红包  分为单位
                    if ("pointPerYuan".equals(ruleExpression.getFact_attribute())) {                     //针对不规则红包
                        String pointsPerOneYuan = ruleExpression.getExpectation_value();
                        if (StringUtils.isNotBlank(pointsPerOneYuan)) {
                            Long ppy = Long.parseLong(pointsPerOneYuan);   // 1元红包消耗的积分
                            amount = (usePoint / ppy) * 100;
                            Map<String, Object> param1 = new HashMap<String, Object>();
                            param1.put("poolId", pool.getPoolId());
                            param1.put("amount", amount);
                            List<HBObtain> hbObtains = hongBaoObtainDao.findHBObtain(param1);
                            if (!CollectionUtils.isEmpty(hbObtains)) {
                                HBObtain hbObtain = hbObtains.get(CommonUtil.getRandomCode(0, hbObtains.size() - 1));   //随机返回一个hbObtain
                                bindUser(hbObtain, userId,sellerId);
                                PointExchange pe = new PointExchange();
                                pe.setSellerId(sellerId);
                                pe.setUserId(userId);
                                BigDecimal a = CommonUtil.longDivide(hbObtain.getAmount(), 100L);
                                BigDecimal b = new BigDecimal(String.valueOf(ppy));
                                Long payPoint = a.multiply(b).longValue();          //新积分兑换红包活动 消耗的积分, 此处截取小数点后数字取整
                                pe.setPointAmount(payPoint);
                                pe.setExchangePresentAmount(hbObtain.getAmount());      //绑定红包的金额
                                pe.setExchangeId(hbObtain.getHongbaoObtainId());
                                pe.setExchangeMethod(DaoConstant.PointExchangeMethod.HONGBAO);
                                pe.setStatus(DaoConstant.PointExchangeStatus.WAIT_EXCHANGE);
                                pointExchangeMapper.insert(pe);
                                usePoint -= payPoint;                 //所能用的积分越来越少.
                            }
                        }
                    } else if ("pointPerHB".equals(ruleExpression.getFact_attribute())) {                  //针对规则红包
                        String pointPerHB = ruleExpression.getExpectation_value();
                        if (StringUtils.isNotBlank(pointPerHB)) {
                            Long perHbPoint = Long.parseLong(pointPerHB);
                            if (usePoint >= perHbPoint) {
                                HBObtainExample hbObtainExample = new HBObtainExample();
                                hbObtainExample.createCriteria().andPoolIdEqualTo(pool.getPoolId());
                                List<HBObtain> hbObtains = hbObtainMapper.selectByExample(hbObtainExample);
                                if (!CollectionUtils.isEmpty(hbObtains)) {
                                    HBObtain hbObtain = hbObtains.get(CommonUtil.getRandomCode(0, hbObtains.size() - 1));   //随机返回一个hbObtain
                                    bindUser(hbObtain, userId,sellerId);
                                    PointExchange pe = new PointExchange();
                                    pe.setSellerId(sellerId);
                                    pe.setUserId(userId);
                                    pe.setPointAmount(perHbPoint);
                                    pe.setExchangeId(hbObtain.getHongbaoObtainId());
                                    pe.setExchangePresentAmount(hbObtain.getAmount());
                                    pe.setExchangeMethod(DaoConstant.PointExchangeMethod.HONGBAO);
                                    pe.setStatus(DaoConstant.PointExchangeStatus.WAIT_EXCHANGE);
                                    pointExchangeMapper.insert(pe);
                                    usePoint -= perHbPoint;                 //所能用的积分越来越少.
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 绑定积分兑换红包, 调红包引擎实现
     *
     * @param userId
     * @param pointAmount
     */
    @Override
    public boolean bindUserAndHongBao(Long sellerId, Long userId, Long pointAmount) {

        HBPoolDO hbPoolDO = new HBPoolDO();
        hbPoolDO.setSellerId(sellerId);
        hbPoolDO.setType(DaoConstant.HongBaoType.POINT_EXCHANGE);
        List<HBPool> hbPools = hongbaoService.findValidHbPoolBySellerId(hbPoolDO,sellerId);

        for (HBPool pool : hbPools) {
            User user = userService.findUserBySellerIdAndUserId(sellerId, userId);
            RuleContext ruleContext = new RuleContext(pool.getPoolId(), RuleType.HB_POOL.getCode(), "pointExchangeBound",pointAmount+"",sellerId);
            UserVO userVO=new UserVO();
            BeanCopierUtils.copyProperties(user,userVO);
            ruleContext.addFactObj(User.class.getName(), user);
            ruleContext.addFactObj(UserVO.class.getName(), userVO);
            HBRuleEngine hbRuleEngine = new HBRuleEngine(ruleContext);
            hbRuleEngine.start();
        }

        return false;
    }


    @Override
    @Transactional
    public void fixPraiseHongbao(UserVO userVO, Long hbPoolId,Long  sellerId) {

        Rule rule = RuleCache.get(hbPoolId + "", RuleType.HB_POOL.getCode(),sellerId);
        AssertsUtil.notNull(rule, "rule");

        List<RuleExpression> ruleExpressions = rule.getRuleExpressions();

        /**
         * 每个快递单号限领次数,好评字数
         */
        String limitPostTime = "";
        long withWordLimit = 0;

        for (RuleExpression ruleExpression : ruleExpressions) {
            if ("perPostTimeCount".equals(ruleExpression.getFact_attribute())) {
                limitPostTime = ruleExpression.getExpectation_value();
            } else if ("maxContentLength".equals(ruleExpression.getFact_attribute())) {
                String withWordLimitTemp = ruleExpression.getExpectation_value();
                withWordLimit = Long.valueOf(withWordLimitTemp);
            }
        }

        /**
         * 获取淘宝天猫好评订单信息
         */
        if (userVO.getUserIdTb() != null &&StringUtils.isNotBlank(userVO.getTaoBaoGoodCommentCount()) ) {

            OrderTaoBaoDO orderTaoBaoDO = new OrderTaoBaoDO();
            orderTaoBaoDO.setStartDate(userVO.getStartDate());
            orderTaoBaoDO.setEndDate(userVO.getEndDate());
            orderTaoBaoDO.setResult("good");
            orderTaoBaoDO.setIsLimitPostTime(limitPostTime);
            orderTaoBaoDO.setUserIdTb(userVO.getUserIdTb());
            orderTaoBaoDO.setGroupByClause("invoice_no");
            orderTaoBaoDO.setSellerId(sellerId);
            List<OrderTaoBaoDO> orderTaoBaoDOs = taoBaoTradeService.selectOrderTaoBaoWithComment(orderTaoBaoDO);

            for (OrderTaoBaoDO orderTaoBaoDOTemp : orderTaoBaoDOs) {

                if (orderTaoBaoDOTemp.getContentLength() > withWordLimit) {
                    bindUser(hbPoolId, userVO.getUserId(), orderTaoBaoDOTemp.getInvoiceNo(),sellerId);
                }

            }

        }

        /**
         * 获取京东好评订单信息
         */
        if (userVO.getUserIdJd() != null &&StringUtils.isNotBlank(userVO.getJdGoodCommentCount())) {

            OrderJDDO orderJDDO = new OrderJDDO();
            orderJDDO.setStartDate(userVO.getStartDate());
            orderJDDO.setEndDate(userVO.getEndDate());
            orderJDDO.setScore(5);
            orderJDDO.setGroupByClause("waybill");
            orderJDDO.setUserIdJd(userVO.getUserIdJd());
            orderJDDO.setIsLimitPostTime(limitPostTime);
            orderJDDO.setSellerId(sellerId);
            List<OrderJDDO> orderJDs = jdTradeService.selectOrderJDWithComment(orderJDDO);

            for (OrderJDDO orderJDDOTemp : orderJDs) {

                if (orderJDDOTemp.getContentLength() > withWordLimit) {
                    bindUser(hbPoolId, userVO.getUserId(), orderJDDOTemp.getWaybill(),sellerId);
                }

            }

        }
    }

    /**
     * 红包领用表绑定用户
     *
     * @param hbObtain
     * @param userId
     */
    @Override
    @Transactional
    public int bindUser(HBObtain hbObtain, Long userId,Long  sellerId) {
        AssertsUtil.check(hbObtain != null, "hbObtain is null");
        AssertsUtil.check(userId != null, "userId is null");
        HBObtain hbObtain1 = new HBObtain();
        hbObtain1.setId(hbObtain.getId());
        hbObtain1.setUserId(userId);
        hbObtain1.setObtainDatatime(new Date());
        hbObtain1.setSellerId(sellerId);
        int result = hbObtainMapper.updateByPrimaryKeySelective(hbObtain1);
        return result;
    }

    /**
     * 红包领用表绑定用户
     *
     * @param hbPoolId
     * @param userId
     * @param postNumber 快递单号
     */
    @Transactional
    public void bindUser(Long hbPoolId, Long userId, String postNumber,Long  sellerId) {

        AssertsUtil.notNull(hbPoolId, "hbPoolId");
        AssertsUtil.notNull(userId, "userId");
        AssertsUtil.notNull(postNumber, "postNumber");

        HBObtainExample hbObtainExample = new HBObtainExample();
        hbObtainExample.createCriteria().andPoolIdEqualTo(hbPoolId).andSellerIdEqualTo(sellerId);
        List<HBObtain> hbObtains = hbObtainMapper.selectByExample(hbObtainExample);
        Random rd = new Random();
        if (!CollectionUtils.isEmpty(hbObtains)) {
            HBObtain hbObtain = hbObtains.get(rd.nextInt(hbObtains.size()));//随机取得其中一条记录
            hbObtain.setUserId(userId);//设置领取人
            hbObtain.setObtainDatatime(new Date());
            hbObtain.setObtainPostNumber(postNumber);
            hbObtain.setSellerId(sellerId);

            try {
                hbObtainMapper.updateByPrimaryKey(hbObtain);//更新红包领用记录表
            } catch (Exception e) {
                throw new ServiceException("更新红包领用表失败,异常回滚!");
            }

        }
    }


    /**
     * @param obtainId
     */
    @Override
    public HBObtain findHBObtainByObtainId(Long obtainId,Long  sellerId) {
        HBObtainExample example = new HBObtainExample();
        example.createCriteria().andHongbaoObtainIdEqualTo(obtainId).andSellerIdEqualTo(sellerId);
        List<HBObtain> hbObtains = hbObtainMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(hbObtains)) {
            return hbObtains.get(0);
        }
        return null;
    }








}
