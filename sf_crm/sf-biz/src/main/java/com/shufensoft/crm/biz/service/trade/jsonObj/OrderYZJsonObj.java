package com.shufensoft.crm.biz.service.trade.jsonObj;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/8  
 */
@Data
@ToString
public class OrderYZJsonObj {


    /** 商品数字编号 */
    private Long num_iid;

    /**  */
    private Long oid;

    /** 订单ID */
    private String tid;

    /** Sku的ID */
    private Long sku_id;

    /** Sku的唯一编码，该编码可用来判断所属商品，并保证商品唯一性。 */
    private String sku_unique_code;

    /** 商品购买数量 */
    private Integer num;

    /** 商家编码（商家为Sku设置的外部编号） */
    private String outer_sku_id;

    /** 应user_yz表user_id_yz */
    private Long user_id_yz;

    /** 商品货号（商家为商品设置的外部编号） */
    private String outer_item_id;

    /** 商品标题 */
    private String title;

    /** 卖家昵称 */
    private String seller_nick;

    /** 商品价格。 */
    private String price;

    /** 应付金额（商品价格乘以数量的总金额） */
    private BigDecimal total_fee;

    /** 交易明细内的优惠金额。 */
    private BigDecimal discount_fee;

    /** 实付金额 */
    private BigDecimal payment;

    /** SKU的值，即：商品的规格。如：机身颜色:黑色;手机套餐:官方标配 */
    private String sku_properties_name;

    /** 商品类型。 */
    private Integer item_type;

    /** 交易明细中的买家留言列表 */

    private List<BuyerMessage> buyer_messages;
}
