package com.shufensoft.crm.biz.service.cvm;

import com.shufensoft.crm.biz.dao.generation.trade.OrderJDMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeYZMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserJDMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserYZMapper;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.biz.service.dataindex.PlatformEnum;
import net.sourceforge.jeval.EvaluationException;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *  计算客户价值
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-10 15:15  
 */
@Service
public class CvmService {

    private static final Logger logger = Logger.getLogger(CvmService.class);

    @Autowired
    private TradeTaoBaoMapper tradeTaoBaoMapper;

    @Autowired
    private UserTaoBaoMapper userTaoBaoMapper;

    @Autowired
    private UserJDMapper userJDMapper;

    @Autowired
    private OrderJDMapper orderJDMapper;

    @Autowired
    private UserYZMapper userYZMapper;

    @Autowired
    private TradeYZMapper tradeYZMapper;




    /**
     * 计算客户价值tb
     *
     * @param tbUserId
     * @param sellerId
     */
    public double calCvm4Tb(long tbUserId, long sellerId, long shopId) throws EvaluationException {

        UserTaoBaoExample userTaoBaoExample = new UserTaoBaoExample();
        userTaoBaoExample.createCriteria().andUserIdTbEqualTo(tbUserId).andSellerIdEqualTo(sellerId)
                .andShopIdEqualTo(shopId);
        List<UserTaoBao> tbUsers = userTaoBaoMapper.selectByExample(userTaoBaoExample);
        if(tbUsers == null || tbUsers.size() != 1) {
            return -1d;
        }

        UserTaoBao tbUser = tbUsers.get(0);
        String buyerNick = tbUser.getBuyerNick();
        if(StringUtils.isEmpty(buyerNick)) {
            return -1d;
        }

        // 取得指标：最近一次购买时间，购买天数，购买金额
        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        tradeTaoBaoExample.createCriteria().andBuyerNickEqualTo(buyerNick);
        List<TradeTaoBao> tbTrades = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

        int lastDayInterval = getLastDayInterval(tbTrades, PlatformEnum.TB);
        int buyDayCount = getBuyDayCount(tbTrades, PlatformEnum.TB);
        double sumAmount = getPaidAmount(tbTrades, PlatformEnum.TB);

        return cal(lastDayInterval, buyDayCount, sumAmount);

    }

    /**
     * 计算客户价值jd
     *
     * @param jdUserId
     * @param sellerId
     */
    public double calCvm4Jd(long jdUserId, long sellerId,long shopId) throws EvaluationException {

        UserJDExample userJDExample = new UserJDExample();
        userJDExample.createCriteria().andUserIdJdEqualTo(jdUserId).andSellerIdEqualTo(sellerId)
                .andShopIdEqualTo(shopId);
        List<UserJD> jdUsers = userJDMapper.selectByExample(userJDExample);
        if(jdUsers == null || jdUsers.size() != 1) {
            return -1d;
        }

        UserJD jdUser = jdUsers.get(0);
        String pin = jdUser.getPin();
        if(StringUtils.isEmpty(pin)) {
            return -1d;
        }

        // 取得指标：最近一次购买时间，购买天数，购买金额
        OrderJDExample orderJDExample = new OrderJDExample();
        orderJDExample.createCriteria().andPinEqualTo(pin);
        List<OrderJD> jdTrades = orderJDMapper.selectByExample(orderJDExample);

        int lastDayInterval = getLastDayInterval(jdTrades, PlatformEnum.JD);
        int buyDayCount = getBuyDayCount(jdTrades, PlatformEnum.JD);
        double sumAmount = getPaidAmount(jdTrades, PlatformEnum.JD);

        return cal(lastDayInterval, buyDayCount, sumAmount);
    }

    /**
     * 计算客户价值jd
     *
     * @param yzUserId
     * @param sellerId
     */
    public double calCvm4Yz(long yzUserId, long sellerId, long shopId)throws EvaluationException {

        UserYZExample userYZExample = new UserYZExample();
        userYZExample.createCriteria().andUserIdYzEqualTo(yzUserId).andSellerIdEqualTo(sellerId)
                .andShopIdEqualTo(shopId);

        List<UserYZ> yzUsers = userYZMapper.selectByExample(userYZExample);
        if(yzUsers == null || yzUsers.size() != 1) {
            return -1d;
        }

        UserYZ yzUser = yzUsers.get(0);
        String buyerNick = yzUser.getBuyerNick();
        if(StringUtils.isEmpty(buyerNick)) {
            return -1d;
        }

        // 取得指标：最近一次购买时间，购买天数，购买金额
        TradeYZExample tradeYZExample = new TradeYZExample();
        tradeYZExample.createCriteria().andBuyerNickEqualTo(buyerNick);
        List<TradeYZ> yzTrades = tradeYZMapper.selectByExample(tradeYZExample);

        int lastDayInterval = getLastDayInterval(yzTrades, PlatformEnum.YZ);
        int buyDayCount = getBuyDayCount(yzTrades, PlatformEnum.YZ);
        double sumAmount = getPaidAmount(yzTrades, PlatformEnum.YZ);

        return cal(lastDayInterval, buyDayCount, sumAmount);

    }


    private double cal(int lastDayInterval, double buyDayCount, double sumAmount) throws EvaluationException {
        // 计算最近一次购买天数指标
        double valueLastDay = 0d;
        if(lastDayInterval > 0) {
            CvmDimComputor cvmDimComputor = new CvmDimComputor(CvmConstants.LASTDAY_NAME, CvmDimTypeEnum.GLOBAL,
                    CvmConstants.LASTDAY_EXPRESSION, CvmConstants.LASTDAY_COEFFICIENT);
            valueLastDay = cvmDimComputor.compute((double) lastDayInterval);
        }

        // 计算购买天数指标
        CvmDimComputor cvmDimComputor = new CvmDimComputor(CvmConstants.TRADECNT_NAME, CvmDimTypeEnum.GLOBAL,
                CvmConstants.TRADECNT_EXPRESSION, CvmConstants.TRADECNT_COEFFICIENT);
        double valueTradeCnt = cvmDimComputor.compute(buyDayCount);

        // 计算购买金额指标
        cvmDimComputor = new CvmDimComputor(CvmConstants.TRADEAMOUNT_NAME, CvmDimTypeEnum.GLOBAL,
                CvmConstants.TRADEAMOUNT_EXPRESSION, CvmConstants.TRADEAMOUNT_COEFFICIENT);
        double valueTradeAmount = cvmDimComputor.compute((double) sumAmount);

        double result = (valueLastDay + valueTradeCnt + valueTradeAmount) / (CvmConstants.LASTDAY_COEFFICIENT
                    + CvmConstants.TRADECNT_COEFFICIENT + CvmConstants.TRADEAMOUNT_COEFFICIENT);

        if (logger.isInfoEnabled()) {
            logger.info("valueLastDay: " + valueLastDay + ", valueTradeCnt: " + valueTradeCnt
                    + ", valueTradeAmount: " + valueTradeAmount);
        }

        return result;
    }

    /**
     * 计算购买天数，即有多少天有购买，以付款时间为准
     *
     * @param tradeList
     * @param platformEnum
     * @return
     */
    private int getBuyDayCount(List tradeList, PlatformEnum platformEnum) {
        List<String> listDate = new ArrayList<String>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        if(PlatformEnum.TB.equals(platformEnum)) {
            for (Object obj : tradeList) {
                TradeTaoBao trade = (TradeTaoBao) obj;
                Date payTime = trade.getPayTime();
                if (payTime != null) {
                    String strPayTime = formatter.format(payTime);

                    boolean hasSameDay = false;
                    for (String str : listDate) {
                        if (str.equalsIgnoreCase(strPayTime)) {
                            hasSameDay = true;
                            break;
                        }
                    }

                    if (!hasSameDay) {
                        listDate.add(strPayTime);
                    }
                }
            }
        }

        if(PlatformEnum.JD.equals(platformEnum)) {
            for (Object obj : tradeList) {
                OrderJD orderJd = (OrderJD) obj;
                Date payTime = orderJd.getPaymentConfirmTime();
                if (payTime != null && payTime.getTime() > 0) {
                    String strPayTime = formatter.format(payTime);

                    boolean hasSameDay = false;
                    for (String str : listDate) {
                        if (str.equalsIgnoreCase(strPayTime)) {
                            hasSameDay = true;
                            break;
                        }
                    }

                    if (!hasSameDay) {
                        listDate.add(strPayTime);
                    }
                }
            }
        }


        if(PlatformEnum.YZ.equals(platformEnum)) {
            for (Object obj : tradeList) {
                TradeYZ trade = (TradeYZ) obj;
                Date payTime = trade.getPayTime();
                if (payTime != null) {
                    String strPayTime = formatter.format(payTime);

                    boolean hasSameDay = false;
                    for (String str : listDate) {
                        if (str.equalsIgnoreCase(strPayTime)) {
                            hasSameDay = true;
                            break;
                        }
                    }

                    if (!hasSameDay) {
                        listDate.add(strPayTime);
                    }
                }
            }
        }

        return listDate.size();
    }

    /**
     * 计算最近一次成交天数，从1天始，即当天算为1
     *
     * @param tradeList
     * @param platformEnum
     * @return
     */
    private int getLastDayInterval(List tradeList, PlatformEnum platformEnum) {
        if(CollectionUtils.isEmpty(tradeList)) {
            return -1;
        }

        Date maxDate = null;
        if(PlatformEnum.TB.equals(platformEnum)) {
            for (Object trade : tradeList) {
                TradeTaoBao tradeTb = (TradeTaoBao) trade;
                if (tradeTb.getPayTime() == null) {
                    // 过滤未付款订单
                    continue;
                }

                Date payDate = tradeTb.getPayTime();
                if (maxDate == null || maxDate.before(payDate)) {
                    maxDate = payDate;
                }
            }
        }

        if(PlatformEnum.JD.equals(platformEnum)) {
            for (Object trade : tradeList) {
                OrderJD orderJd = (OrderJD) trade;
                if (orderJd.getPaymentConfirmTime() == null || orderJd.getPaymentConfirmTime().getTime() < 0) {
                    // 过滤未付款订单
                    continue;
                }

                Date payDate = orderJd.getPaymentConfirmTime();
                if (maxDate == null || maxDate.before(payDate)) {
                    maxDate = payDate;
                }
            }
        }

        if(PlatformEnum.YZ.equals(platformEnum)) {
            for (Object trade : tradeList) {
                TradeYZ tradeYZ = (TradeYZ) trade;
                if (tradeYZ.getPayTime() == null || tradeYZ.getPayTime().getTime() < 0) {
                    // 过滤未付款订单
                    continue;
                }

                Date payDate = tradeYZ.getPayTime();
                if (maxDate == null || maxDate.before(payDate)) {
                    maxDate = payDate;
                }
            }
        }

        if(maxDate == null) {
            return -1;
        } else {
            return (int) (System.currentTimeMillis() - maxDate.getTime()) / 1000 / 60 / 60 / 24 + 1;
        }
    }

    /**
     * 计算付款总金额
     *
     * @param tradeList
     * @param platformEnum
     * @return
     */
    private double getPaidAmount(List tradeList, PlatformEnum platformEnum) {
        if(CollectionUtils.isEmpty(tradeList)) {
            return 0d;
        }

        double sumAmount = 0.0d;
        if(PlatformEnum.TB.equals(platformEnum)) {
            for (Object object : tradeList) {
                TradeTaoBao trade = (TradeTaoBao) object;
                if (trade.getPayTime() == null) {
                    // 过滤未付款订单
                    continue;
                }

                sumAmount += trade.getPayment().doubleValue();
            }
        }

        if(PlatformEnum.JD.equals(platformEnum)) {
            for (Object object : tradeList) {
                OrderJD orderJD = (OrderJD) object;
                if (orderJD.getPaymentConfirmTime() == null || orderJD.getPaymentConfirmTime().getTime() < 0) {
                    // 过滤未付款订单
                    continue;
                }

                sumAmount += orderJD.getOrderPayment().doubleValue();
            }
        }

        if(PlatformEnum.YZ.equals(platformEnum)) {
            for (Object object : tradeList) {
                TradeYZ trade = (TradeYZ) object;
                if (trade.getPayTime() == null) {
                    // 过滤未付款订单
                    continue;
                }

                sumAmount += trade.getPayment().doubleValue();
            }
        }

        return sumAmount;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        long x = DateUtils.getFragmentInDays(formatter.parse("20110101"), Calendar.YEAR);
        System.out.println(formatter.format(new Date()));
    }

}
