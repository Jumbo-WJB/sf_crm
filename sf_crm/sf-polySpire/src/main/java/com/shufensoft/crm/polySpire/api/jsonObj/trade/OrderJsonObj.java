package com.shufensoft.crm.polySpire.api.jsonObj.trade;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/3  
 */
@Data
public class OrderJsonObj {

    /**  */
    private Long tid;

    /**  */
    private Long oid;

    /**  */
    private String item_meal_name;

    /**  */
    private String seller_nick;

    /**  */
    private String buyer_nick;

    /**  */
    private String refund_status;

    /**  */
    private String outer_iid;

    /**  */
    private String snapshot_url;

    /**  */
    private String snapshot;

    /**  */
    private Date timeout_action_time;

    /**  */
    private String buyer_rate;

    /**  */
    private Long cid;

    /**  */
    private String status;

    /**  */
    private String title;

    /**  */
    private BigDecimal price;

    /**  */
    private Long num_iid;

    /**  */
    private Long item_meal_id;

    /**  */
    private String sku_id;

    /**  */
    private Integer num;

    /**  */
    private String outer_sku_id;

    /**  */
    private String order_from;

    /**  */
    private BigDecimal total_fee;

    /**  */
    private BigDecimal payment;

    /**  */
    private BigDecimal discount_fee;

    /**  */
    private BigDecimal adjust_fee;

    /**  */
    private Date modified;

    /**  */
    private String sku_properties_name;

    /**  */
    private Long refund_id;

    /**  */
    private String is_oversold;

    /**  */
    private String is_service_order;

    /**  */
    private Date end_time;

    /**  */
    private String consign_time;

    /**  */
    private String shipping_type;

    /**  */
    private Long bind_oid;

    /**  */
    private String logistics_company;

    /**  */
    private String invoice_no;

    /**  */
    private String is_daixiao;

    /**  */
    private BigDecimal divide_order_fee;

    /**  */
    private String part_mjz_discount;

    /**  */
    private String store_code;

}
