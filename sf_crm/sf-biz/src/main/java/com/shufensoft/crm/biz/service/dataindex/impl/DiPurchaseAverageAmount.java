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
 *  @date 2015-06-14 20:17  
 */
public class DiPurchaseAverageAmount extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diPurchaseAverageAmount";
        this.description = "平均购买金额";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {
        Double totalPurchaseAmount = null;
        int tradeCnt = 0;

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
                if (tradeTaoBao.getPayment() != null) {
                    Double payment = tradeTaoBao.getPayment().doubleValue();

                    if (totalPurchaseAmount == null) {
                        totalPurchaseAmount = payment;
                    } else {
                        totalPurchaseAmount += payment;
                    }

                    tradeCnt++;
                }
            }
        }

        List<OrderJD> orderJDList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJDList)) {
            for (OrderJD orderJd : orderJDList) {
                Date paymentConfirmTime = orderJd.getPaymentConfirmTime();
                if (paymentConfirmTime != null && paymentConfirmTime.getTime() > 0) {
                    Double payment = orderJd.getOrderPayment().doubleValue();

                    if (totalPurchaseAmount == null) {
                        totalPurchaseAmount = payment;
                    } else {
                        totalPurchaseAmount += payment;
                    }

                    tradeCnt++;
                }
            }
        }

        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {
            for (TradeYZ tradeYZ : tradeYZList) {
                if (tradeYZ.getPayment() != null) {
                    Double payment = tradeYZ.getPayment().doubleValue();

                    if (totalPurchaseAmount == null) {
                        totalPurchaseAmount = payment;
                    } else {
                        totalPurchaseAmount += payment;
                    }

                    tradeCnt++;
                }
            }
        }

        if(tradeCnt == 0) {
            return new DataIndexResult(-1L);
        } else {
            return new DataIndexResult(((long) (totalPurchaseAmount * 100)) / tradeCnt);
        }
    }

}
