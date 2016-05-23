package com.shufensoft.crm.common.api.client;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.request.order.OrderSearchRequest;
import com.jd.open.api.sdk.request.seller.SellerVenderInfoGetRequest;
import com.jd.open.api.sdk.response.order.OrderSearchResponse;
import com.jd.open.api.sdk.response.seller.SellerVenderInfoGetResponse;
import com.shufensoft.crm.common.utils.DateUtil;

import java.util.Date;

/**
 * Created by lin on 2015/6/13.
 * 京东接口调用客户端
 */
public class JDClient {

    public final static String wait_seller_stock_out = "WAIT_SELLER_STOCK_OUT";               //等待出库
    public final static String send_to_distribution_cener = "SEND_TO_DISTRIBUTION_CENER";    //发往配送中心
    public final static String distribution_center_received = "DISTRIBUTION_CENTER_RECEIVED"; //配送中心已收货
    public final static String wait_goods_receive_confirm = "WAIT_GOODS_RECEIVE_CONFIRM";     //等待收货确认
    public final static String receipts_confirm = "RECEIPTS_CONFIRM";                         //收款完成，服务完成
    public final static String wait_seller_delivery = "WAIT_SELLER_DELIVERY";                 //等待发货
    public final static String finished_l = "FINISHED_L";                                      //完成
    public final static String trade_canceled = "TRADE_CANCELED";                             //取消
    public final static String locked = "LOCKED";                                            //已锁定

    /**
     * 京东接口api
     */
    private final static String JD_BASE_URI = "https://api.jd.com/routerjson";

    /**
     * 通过京东SDK获取所有订单信息
     */
    public OrderSearchResponse getOrderJDBySearch(String appKey, String appSecret, String accessToken,
                                                  Date startDate, Date endDate, int page, int pageSize) throws Exception {
        JdClient client = new DefaultJdClient(JD_BASE_URI, accessToken, appKey, appSecret);
        OrderSearchRequest request = new OrderSearchRequest();
        request.setStartDate(DateUtil.getDateToString(startDate));
        request.setEndDate(DateUtil.getDateToString(endDate));
        request.setOrderState(getAllOrderState());
        request.setPage(String.valueOf(page));
        request.setPageSize(String.valueOf(pageSize));
        request.setOptionalFields(getResultFields());
        request.setSortType("12");     //排序方式，默认升序，1为降序，其它数字都是升序
        request.setDateType("0");     //查询时间类型，0为按修改时间查询， 1为按订单创建时间查询，默认0
        OrderSearchResponse response = client.execute(request);
        return response;
    }

    /**
     * 所有订单状态中间用,相隔
     */
    private String getAllOrderState() {
        StringBuffer sb = new StringBuffer();
        sb.append(wait_seller_stock_out).append(",");
        //sb.append(send_to_distribution_cener).append(",");
        //sb.append(distribution_center_received).append(",");
        sb.append(wait_goods_receive_confirm).append(",");
        //sb.append(receipts_confirm).append(",");
        sb.append(finished_l).append(",");
        sb.append(trade_canceled).append(",");
        sb.append(locked);
        return sb.toString();
    }

    /**
     * 组装返回字段列表，orderInfo结构体中的所有字段，中间用,隔开
     * 这里返回所有字段
     */
    private String getResultFields() {
        StringBuffer sb = new StringBuffer();
        sb.append("order_id").append(",");
        sb.append("order_source").append(",");
        sb.append("vender_id").append(",");
        sb.append("pay_type").append(",");
        sb.append("order_total_price").append(",");
        sb.append("order_seller_price").append(",");
        sb.append("order_payment").append(",");
        sb.append("freight_price").append(",");
        sb.append("seller_discount").append(",");
        sb.append("order_state").append(",");
        sb.append("order_state_remark").append(",");
        sb.append("delivery_type").append(",");
        sb.append("invoice_info").append(",");
        sb.append("order_remark").append(",");
        sb.append("order_start_time").append(",");
        sb.append("order_end_time").append(",");
        sb.append("modified").append(",");
        sb.append("consignee_info").append(",");
        sb.append("item_info_list").append(",");
        sb.append("coupon_detail_list").append(",");
        sb.append("vender_remark").append(",");
        sb.append("balance_used").append(",");
        sb.append("payment_confirm_time").append(",");
        sb.append("waybill").append(",");
        sb.append("logistics_id").append(",");
        sb.append("vat_invoice_info").append(",");
        sb.append("parent_order_id").append(",");
        sb.append("pin").append(",");
        sb.append("return_order").append(",");
        sb.append("order_type").append(",");
        sb.append("store_order");
        return sb.toString();
    }

    /**
     * 通过京东SDK获取商家基本信息
     */
    public SellerVenderInfoGetResponse getSellerVenderInfoGetResponse(String accessToken, String appKey, String appSecret) throws Exception {
        JdClient client = new DefaultJdClient(JD_BASE_URI, accessToken, appKey, appSecret);
        SellerVenderInfoGetRequest request = new SellerVenderInfoGetRequest();
        SellerVenderInfoGetResponse response = client.execute(request);
        return response;
    }


}
