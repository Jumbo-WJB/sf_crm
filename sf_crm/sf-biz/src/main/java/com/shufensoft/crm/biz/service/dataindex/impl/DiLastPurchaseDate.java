package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *  数据指标：最近一次购买时间
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-28 10:58  
 */
public class DiLastPurchaseDate extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diLastPurchaseDate";
        this.description = "最近一次购买时间";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {
        Date lastPurchaseDate = null;

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
                if (tradeTaoBao.getPayTime() != null) {
                    if (lastPurchaseDate == null || lastPurchaseDate.before(tradeTaoBao.getPayTime())) {
                        lastPurchaseDate = tradeTaoBao.getPayTime();
                    }
                }
            }
        }

        List<OrderJD> orderJdList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJdList)) {
            for (OrderJD orderJd : orderJdList) {
                Date paymentConfirmTime = orderJd.getPaymentConfirmTime();
                if (paymentConfirmTime != null && paymentConfirmTime.getTime() > 0) {
                    if (lastPurchaseDate == null || paymentConfirmTime.after(lastPurchaseDate)) {
                        lastPurchaseDate = paymentConfirmTime;
                    }
                }
            }
        }

        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {
            for (TradeYZ tradeYZ : tradeYZList) {
                if (tradeYZ.getPayTime() != null) {
                    if (lastPurchaseDate == null || lastPurchaseDate.before(tradeYZ.getPayTime())) {
                        lastPurchaseDate = tradeYZ.getPayTime();
                    }
                }
            }
        }

        return new DataIndexResult(lastPurchaseDate);
    }

    public static void main(String[] args) throws ParseException {
        String str = "0001-01-01 00:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.parse(str).getTime());
    }

}
