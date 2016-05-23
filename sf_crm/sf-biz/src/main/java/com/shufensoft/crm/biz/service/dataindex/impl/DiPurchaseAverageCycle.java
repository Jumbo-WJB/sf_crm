package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 14:07  
 */
public class DiPurchaseAverageCycle extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diPurchaseAverageCycle";
        this.description = "平均购买周期";
        this.dataList = Arrays.asList(DataTypeEnum.TRADE_TB, DataTypeEnum.TRADE_JD);
        this.platformList = Arrays.asList(PlatformEnum.TB, PlatformEnum.JD);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {
        return new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {
        List<Date> dateList = new ArrayList<Date>();

        List<TradeTaoBao> tradeTaoBaoList = rawData.getTradeTaoBaoList();
        if(!CollectionUtils.isEmpty(tradeTaoBaoList)) {
            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
                dateList.add(tradeTaoBao.getCreated());
            }
        }

        List<OrderJD> orderJDList = rawData.getOrderJdList();
        if(!CollectionUtils.isEmpty(orderJDList)) {
            for (OrderJD orderJd : orderJDList) {
                dateList.add(orderJd.getOrderStartTime());
            }
        }

        List<TradeYZ> tradeYZList = rawData.getTradeYZList();
        if(!CollectionUtils.isEmpty(tradeYZList)) {
            for (TradeYZ tradeYZ : tradeYZList) {
                dateList.add(tradeYZ.getCreated());
            }
        }

        if(dateList.size() < 2) {
            return new DataIndexResult(-1d);
        }

        Collections.sort(dateList);

        int countDays = 0;
        int sumInterval = 0;

        Date date1 = dateList.get(0);
        for(int i=1; i<dateList.size(); i++) {
            Date date2 = dateList.get(i);
            if(isSameDay(date1, date2)) {
                continue;
            }

            sumInterval += (int) getIntervalDays(date1, date2);
            date1 = date2;
            countDays++;
        }

        if(countDays == 0) {
            return new DataIndexResult(-1d);
        } else {
            return new DataIndexResult(((double) sumInterval) / countDays);
        }
    }

    private static boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strDate1 = formatter.format(date1);
        String strDate2 = formatter.format(date2);
        return strDate1.equals(strDate2);
    }

    private static long getIntervalDays(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        long longDate1 = calendar.getTimeInMillis();

        calendar.setTime(date2);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        long longDate2 = calendar.getTimeInMillis();

        return (longDate2 - longDate1) / (1000*3600*24);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(formatter.parse("20150101 23:11:11"));
        dateList.add(formatter.parse("20150201 21:11:11"));
        dateList.add(formatter.parse("20150301 23:01:11"));
        dateList.add(formatter.parse("20140301 23:01:11"));

        Collections.sort(dateList);

        int countDays = 0;
        int sumInterval = 0;

        Date date1 = dateList.get(0);
        for(int i=1; i<dateList.size(); i++) {
            Date date2 = dateList.get(i);
            if(isSameDay(date1, date2)) {
                continue;
            }

            sumInterval += (int) getIntervalDays(date1, date2);
            date1 = date2;
            countDays++;
        }

        System.out.println(sumInterval + " : " + countDays);
    }

}
