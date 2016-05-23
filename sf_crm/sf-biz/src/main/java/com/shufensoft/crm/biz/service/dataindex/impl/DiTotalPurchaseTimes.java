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
 *  @date 2015-06-14 11:53  
 */
public class DiTotalPurchaseTimes extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diTotalPurchaseTimes";
        this.description = "累计购买次数";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {
        int totalPurchaseTimes = 0;

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            totalPurchaseTimes += tradeTaoBaoList.size();
        }

        List<OrderJD> orderJDList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJDList)) {
            totalPurchaseTimes += orderJDList.size();
        }


        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {
            totalPurchaseTimes += tradeYZList.size();
        }

        return new DataIndexResult(totalPurchaseTimes);
    }

}
