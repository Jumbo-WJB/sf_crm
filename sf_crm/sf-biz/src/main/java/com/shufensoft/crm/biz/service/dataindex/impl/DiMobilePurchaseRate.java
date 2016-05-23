package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 14:12  
 */
public class DiMobilePurchaseRate extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diMobilePurchaseRate";
        this.description = "手机购买率";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {
        int mobileTradeCnt = 0, tradeCnt = 0;

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
                tradeCnt++;

                String tradeFrom = tradeTaoBao.getTradeFrom();
                tradeFrom = tradeFrom.toUpperCase();
                if (StringUtils.isNotEmpty(tradeFrom)) {
                    if (tradeFrom.indexOf("WAP") != -1) {
                        mobileTradeCnt++;
                    }
                }
            }
        }

        List<OrderJD> orderJDList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJDList)) {
            for (OrderJD orderJd : orderJDList) {
                tradeCnt++;

                String orderSource = orderJd.getOrderSource();
                if (StringUtils.isNotEmpty(orderSource)) {
                    if (orderSource.indexOf("移动") != -1 || orderSource.indexOf("微信") != -1) {
                        mobileTradeCnt++;
                    }
                }
            }
        }

        /**
         * 有赞手机购买率统计(有赞的订单都来自手机端)
         */
        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {

            tradeCnt = tradeCnt + tradeYZList.size();
            mobileTradeCnt = mobileTradeCnt + tradeYZList.size();

        }

        Double result = 0d;
        if(tradeCnt > 0) {
            result = mobileTradeCnt * 1d / tradeCnt;
        }

        return new DataIndexResult(result);
    }

    public static void main(String[] args) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#");
        String result = df.format(2.123456);
        System.out.println(result);
    }

}
