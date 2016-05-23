package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 14:07  
 */
public class DiTotalPurchaseAmount extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diTotalPurchaseAmount";
        this.description = "累计购买金额";
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
                }
            }
        }

        List<OrderJD> orderJDList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJDList)) {
            for (OrderJD orderJd : orderJDList) {
                if (orderJd.getPaymentConfirmTime() != null && orderJd.getPaymentConfirmTime().getTime() > 0) {
                    if (totalPurchaseAmount == null) {
                        totalPurchaseAmount = orderJd.getOrderPayment().doubleValue();
                    } else {
                        totalPurchaseAmount += orderJd.getOrderPayment().doubleValue();
                    }
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
                }
            }
        }

        if(totalPurchaseAmount == null) {
            return new DataIndexResult(-1L);
        } else {
            return new DataIndexResult((long) (totalPurchaseAmount * 100));
        }
    }

}
