package com.shufensoft.crm.ruleEngine.infoUnit.service;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.pointMall.PointExchangeDetailDao;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeDetailDo;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBCash;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.vo.*;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 红包信息元服务
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/3  
 */
@Service
public class HBInfoUnitService extends InfoUnitService {


    private static HongbaoService hongbaoService;

    private static UserAccountService userAccountService;

    private static TaoBaoTradeService taoBaoTradeService;

    private static JdTradeService jdTradeService;

    private static  PointExchangeDetailDao pointExchangeDetailDao;


    static {
        hongbaoService = (HongbaoService) SpringContextUtil.getBean("hongbaoService");
        userAccountService = (UserAccountService) SpringContextUtil.getBean("userAccountService");
        taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");
        jdTradeService = (JdTradeService) SpringContextUtil.getBean("jdTradeService");
        pointExchangeDetailDao=(PointExchangeDetailDao)SpringContextUtil.getBean("pointExchangeDetailDao");
    }

    /**
     * 获取红包活动用户领取红包数
     *
     * @param userVO
     * @return
     */
    public Integer getUserHBObtainTime(UserVO userVO) {
        HBObtainVO hbObtainVO = new HBObtainVO();
        hbObtainVO.setUserId(userVO.getUserId());
        hbObtainVO.setPoolId(ruleObjId);
        hbObtainVO.setStatus(DaoConstant.HBStatus.RECEIVED);
        List<HBObtain> hbObtainList = hongbaoService.queryHBObtainList(hbObtainVO, sellerId);
        if (CollectionUtils.isEmpty(hbObtainList)||StringUtils.isNotBlank(actionValue)) {
            return 0;
        }
        return hbObtainList.size();
    }

    /**
     * 获取用户每月提现次数
     *
     * @param userVO
     * @return
     */
    public Integer getCachCountPerMonth(UserVO userVO) {
        HBCashVO hbCashVO = new HBCashVO();
        Date startTime = DateUtil.getCurrentMonthStartTime();
        Date endTime = DateUtil.getCurrentMonthEndTime();
        hbCashVO.setUserId(userVO.getUserId());
        hbCashVO.setStartDate(startTime);
        hbCashVO.setEndDate(endTime);
        List<HBCash> hbCashList = hongbaoService.queryHBCashList(hbCashVO, sellerId);
        if (CollectionUtils.isEmpty(hbCashList)) {
            return 0;
        }
        return hbCashList.size();
    }

    /**
     * 获取当前用户提现金额
     * <p>当用户有自己填写提现金额先取该提现金额,否则取用户账务金额</p>
     *
     * @param userVO
     * @return
     */
    public Long getHbCurrentCashAmount(UserVO userVO) {
        if (userVO.getHbCurrentCashAmount() != null) {
            return userVO.getHbCurrentCashAmount();
        }
        UserAccountVO userAccountVO = new UserAccountVO();
        userAccountVO.setUserId(userVO.getUserId());
        List<UserAccount> userAccounts = userAccountService.queryHBAccountList(userAccountVO, sellerId);
        if (!CollectionUtils.isEmpty(userAccounts)) {
            return userAccounts.get(0).getHongbaoAmount();
        }
        return Long.valueOf(0);
    }

    /**
     * 同个快递单号评价内容最大长度
     *
     * @param userVO
     * @return
     */
    public String getMaxContentLength(UserVO userVO) {

        String maxContentLength = "";
        /**
         * 获取淘宝天猫同个快递单号的好评最大长度
         */
        if (userVO.getUserIdTb() != null &&  StringUtils.isNotBlank(userVO.getTaoBaoGoodCommentCount())) {
            List<OrderTaoBaoDO> orderTaoBaoDOs = getOrderTaoBaoDOs(userVO, new OrderTaoBaoDO());
            for (OrderTaoBaoDO orderTaoBaoDO1 : orderTaoBaoDOs) {
                maxContentLength += orderTaoBaoDO1.getContentLength() + "|";
            }
        }

        /**
         * 获取京东同个快递单号的好评最大长度
         */
        if (userVO.getUserIdJd() != null && StringUtils.isNotBlank( userVO.getJdGoodCommentCount() )) {
            List<OrderJDDO> orderJDs = getOrderJDDOs(userVO, new OrderJDDO());
            for (OrderJDDO orderJDDO1 : orderJDs) {
                maxContentLength += orderJDDO1.getContentLength() + "|";
            }
        }

        return maxContentLength;
    }


    /**
     * 获取淘宝天猫、京东好评订单数
     *
     * @param userVO
     * @return
     */
    public String getTaobaoOrJdCommentCount(UserVO userVO) {

        int countCommentTaoBao = 0;
        if (userVO.getUserIdTb() != null&& StringUtils.isNotBlank(userVO.getTaoBaoGoodCommentCount())) {
            CommentTaoBaoVO commentTaoBaoVO = new CommentTaoBaoVO();
            commentTaoBaoVO.setStartDate(userVO.getStartDate());
            commentTaoBaoVO.setEndDate(userVO.getEndDate());
            commentTaoBaoVO.setUserIdTb(userVO.getUserIdTb());
            commentTaoBaoVO.setResult("good");
            commentTaoBaoVO.setSellerId(sellerId);
            countCommentTaoBao = taoBaoTradeService.countCommnetTaoBao(commentTaoBaoVO);
        }

        int countCommentOrderJD = 0;
        if (userVO.getUserIdJd() != null&& StringUtils.isNotBlank(userVO.getJdGoodCommentCount())) {
            CommentJDVO commentJDVO = new CommentJDVO();
            commentJDVO.setStartDate(userVO.getStartDate());
            commentJDVO.setEndDate(userVO.getEndDate());
            commentJDVO.setUserIdJd(userVO.getUserIdJd());
            commentJDVO.setScore(5);
            commentJDVO.setSellerId(sellerId);
            countCommentOrderJD = jdTradeService.countCommnetJD(commentJDVO);
        }

        return countCommentTaoBao+"|"+countCommentOrderJD;
    }

    /**
     * 获取同个快递单号的领取次数
     *
     * @param userVO
     * @return
     */
    public String getPerPostTimeCount(UserVO userVO) {

        /**
         * 获取淘宝天猫同个快递单号的领取次数
         */
        int taoBaoPerPostTimeCount = 0;
        if (userVO.getUserIdTb() != null && StringUtils.isNotBlank(userVO.getTaoBaoGoodCommentCount() )) {
            OrderTaoBaoDO orderTaoBaoDO = new OrderTaoBaoDO();
            orderTaoBaoDO.setIsLimitPostTime("limitPostTime");
            List<OrderTaoBaoDO> orderTaoBaoDOs = getOrderTaoBaoDOs(userVO, orderTaoBaoDO);
            taoBaoPerPostTimeCount = orderTaoBaoDOs.size();
        }

        /**
         * 获取京东同个快递单号的领取次数
         */
        int jdPerPostTimeCount = 0;
        if (userVO.getUserIdJd() != null && StringUtils.isNotBlank(userVO.getJdGoodCommentCount())) {
            OrderJDDO orderJDDO = new OrderJDDO();
            orderJDDO.setIsLimitPostTime("limitPostTime");
            List<OrderJDDO> orderJDDOs = getOrderJDDOs(userVO, orderJDDO);
            jdPerPostTimeCount = orderJDDOs.size();
        }

        return taoBaoPerPostTimeCount + "|" + jdPerPostTimeCount;
    }


    public List<OrderTaoBaoDO> getOrderTaoBaoDOs(UserVO userVO, OrderTaoBaoDO orderTaoBaoDO) {
        orderTaoBaoDO.setStartDate(userVO.getStartDate());
        orderTaoBaoDO.setStartDate(userVO.getEndDate());
        orderTaoBaoDO.setResult("goods");
        orderTaoBaoDO.setGroupByClause("invoice_no");
        orderTaoBaoDO.setUserIdTb(userVO.getUserIdTb());
        orderTaoBaoDO.setSellerId(sellerId);
        List<OrderTaoBaoDO> orderTaoBaoDOs = taoBaoTradeService.selectOrderTaoBaoWithComment(orderTaoBaoDO);
        return orderTaoBaoDOs;
    }


    public List<OrderJDDO> getOrderJDDOs(UserVO userVO, OrderJDDO orderJDDO) {
        orderJDDO.setStartDate(userVO.getStartDate());
        orderJDDO.setEndDate(userVO.getEndDate());
        orderJDDO.setScore(5);
        orderJDDO.setGroupByClause("waybill");
        orderJDDO.setUserIdJd(userVO.getUserIdJd());
        orderJDDO.setSellerId(sellerId);
        List<OrderJDDO> orderJDs = jdTradeService.selectOrderJDWithComment(orderJDDO);
        return orderJDs;
    }


    /**
     * 当前积分是否可兑换红包
     *
     * @param userVO
     * @return
     */
    public String getAvailablePointAmount(UserVO userVO) {

        UserAccount userAccount = userAccountService.findUserAccountByUserId(sellerId, userVO.getUserId());
        long pointAmount = userAccount.getPointAmount();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sellerId", sellerId);
        params.put("userId", userVO.getUserId());
        Set<Long> poolIds = new HashSet<Long>();
        Long expendPoint = 0L;                           //查询用户参加的所有积分兑换红包活动
        List<PointExchangeDetailDo> pointExchangeDetailDos = pointExchangeDetailDao.findNotFinishPointExchangeHongbao(params);
        PointExchange pointExchange = null;

        for (PointExchangeDetailDo pdo : pointExchangeDetailDos) {
            if (DaoConstant.PointExchangeStatus.WAIT_EXCHANGE.equals(pdo.getStatus())) {
                if (pdo.getNumber() <= pdo.getObtainedNum() || pdo.getEndDate().before(new Date())) {//已经领完或已过期
                    continue;
                } else {
                    expendPoint += pdo.getPoint();
                }
            }
        }
        Long usePoint = pointAmount - expendPoint;     //可用积分

        if (StringUtils.isNotBlank(actionValue) && usePoint < 0) {
            return "fail";
        }

        return "success";
    }

}
