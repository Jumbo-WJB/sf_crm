package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 11:37  
 */
public class DiLastPurchaseAmount extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diLastPurchaseAmount";
        this.description = "最近一次购买金额";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        Double lastPurchaseAmount = null;
        Date lastPurchaseTime = null;

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
                if (tradeTaoBao.getPayment() != null) {
                    Double payment = tradeTaoBao.getPayment().doubleValue();
                    Date payTime = tradeTaoBao.getPayTime();

                    if (payTime != null && (lastPurchaseTime == null || lastPurchaseTime.before(payTime))) {
                        lastPurchaseAmount = payment;
                        lastPurchaseTime = payTime;
                    }
                }
            }
        }

        List<OrderJD> orderJdList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJdList)) {
            for (OrderJD orderJd : orderJdList) {
                Date paymentConfirmTime = orderJd.getPaymentConfirmTime();
                if (paymentConfirmTime != null && paymentConfirmTime.getTime() > 0) {
                    Double payment = orderJd.getOrderPayment().doubleValue();

                    if (paymentConfirmTime != null && (lastPurchaseTime == null
                            || lastPurchaseTime.before(paymentConfirmTime))) {
                        lastPurchaseAmount = payment;
                        lastPurchaseTime = paymentConfirmTime;
                    }
                }
            }
        }

        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {
            for (TradeYZ tradeYZ : tradeYZList) {
                if (tradeYZ.getPayment() != null) {
                    Double payment = tradeYZ.getPayment().doubleValue();
                    Date payTime = tradeYZ.getPayTime();

                    if (payTime != null && (lastPurchaseTime == null || lastPurchaseTime.before(payTime))) {
                        lastPurchaseAmount = payment;
                        lastPurchaseTime = payTime;
                    }
                }
            }
        }

        if(lastPurchaseAmount == null) {
            return new DataIndexResult(-1L);
        } else {
            return new DataIndexResult((long) (lastPurchaseAmount * 100));
        }
    }

    public static void main(String[] args) {
        Double payment = 1.1234;
        System.out.println((long) (payment * 100));
    }

}
