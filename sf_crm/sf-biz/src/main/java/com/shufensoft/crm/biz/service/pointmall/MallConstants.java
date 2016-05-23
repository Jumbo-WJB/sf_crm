package com.shufensoft.crm.biz.service.pointmall;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-04 21:27  
 */
public class MallConstants {

    public interface GoodsStatus {
        public static final String ONSALE = "onsale";
        public static final String INSTOCK = "instock";
    }

    public interface TradeStatus {
        public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";    //等待买家付款
        public static final String WAIT_SELLER_SEND_GOODS = "WAIT_SELLER_SEND_GOODS";   //等待商家发货
        public static final String WAIT_BUYER_CONFIRM_GOODS = "WAIT_BUYER_CONFIRM_GOODS";  //等待买家确认收货
        public static final String TRADE_FINISHED = "TRADE_FINISHED";                      //交易完成
        public static final String TRADE_CLOSED = "TRADE_CLOSED";                         //交易关闭
        public static final String TRADE_CLOSED_BY_SELLER = "TRADE_CLOSED_BY_SELLER";    //商家关闭交易
    }

    public interface ExchangeMethod {
        public static final String POINTMALL_BUY = "POINTMALL_BUY";
    }

    public interface ExchangeType{
        public static final String HONG_BAO = "hongbao";
        public static final String HB = "HB";
        public static final String LW = "lw";
    }
    //商城订单类型
    public interface MallTradeType{
        public final static String SHAKE_FETCH = "shake_fetch";
        public final static String BIRTHDAY_FETCH = "birthday_fetch";
        public final static String DEFAULT_FETCH = "default_fetch";


    }


}
