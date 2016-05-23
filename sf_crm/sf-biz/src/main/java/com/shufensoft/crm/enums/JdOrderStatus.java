package com.shufensoft.crm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * Created by lin on 2015/6/15.
 */
public enum JdOrderStatus {

    WAIT_SELLER_STOCK_OUT("wait_seller_stock_out","等待出库"),
    SEND_TO_DISTRIBUTION_CENER("send_to_distribution_cener","发往配送中心"),
    DISTRIBUTION_CENTER_RECEIVED("distribution_center_received","配送中心已收货"),
    WAIT_GOODS_RECEIVE_CONFIRM("wait_goods_receive_confirm","等待确认收货"),
    RECEIPTS_CONFIRM("receipts_confirm","收款完成，服务完成"),
    WAIT_SELLER_DELIVERY("wait_seller_delivery","等待发货"),
    FINISHED_L("finished_l","完成"),
    TRADE_CANCELED("trade_canceled","取消"),
    LOCKED("locked","(删除)锁定");

    private String key;
    private String value;

    private JdOrderStatus(String key, String value){
        this.key = key;
        this.value = value;
    }

    /**
     * 通过value 获取 key
     * */
    public static String getKeyFromValue(String value){
        if(StringUtils.isBlank(value)){
            return null;
        }
        JdOrderStatus[] arr = JdOrderStatus.values();
        for(JdOrderStatus status : arr){
            String key = status.getKey();
            String val = status.getValue();
            if(value.equals(val)){
                return key;
            }
        }
        return null;
    }

    /**
     * 通过key 获取 value
     * */
    public static String getValueFromKey(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        JdOrderStatus[] arr = JdOrderStatus.values();
        for(JdOrderStatus status : arr){
            String ke = status.getKey();
            String val = status.getValue();
            if(key.equals(ke)){
                return val;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args){
        System.out.println(JdOrderStatus.getKeyFromValue("等待出库"));
        System.out.println(JdOrderStatus.getValueFromKey("wait_seller_stock_out"));
    }



}
