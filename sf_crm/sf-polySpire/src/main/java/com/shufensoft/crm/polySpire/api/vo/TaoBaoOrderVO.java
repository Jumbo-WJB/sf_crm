package com.shufensoft.crm.polySpire.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/1  
 */
@Data
public class TaoBaoOrderVO {


    /** 交易ID */
    private Long tid;

    /** 子订单编号 */
    private Long oid;

    /** 套餐的值。 */
    private String itemMealName;

    /** 卖家昵称 */
    private String sellerNick;

    /** 买家昵称 */
    private String buyerNick;

    /** 退款状态 */
    private String refundStatus;

    /** 商家外部编码(可与商家外部系统对接)。 */
    private String outerIid;

    /** 订单快照URL */
    private String snapshotUrl;

    /** 订单快照详细信息 */
    private String snapshot;

    /** 订单超时到期时间。格式:yyyy-MM-dd HH:mm:ss */
    private Date timeoutActionTime;

    /** 买家是否已评价。 */
    private String buyerRate;

    /** 交易商品对应的类目ID */
    private Long cid;

    /** 订单状态（请关注此状态，如果为TRADE_CLOSED_BY_TAOBAO状态，则不要对此订单进行发货，切记啊！） */
    private String status;

    /** 商品标题 */
    private String title;

    /** 商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分 */
    private BigDecimal price;

    /** 商品数字ID */
    private Long numIid;

    /** 套餐ID */
    private Long itemMealId;

    /** 商品的最小库存单位Sku的id.可以通过taobao.item.sku.get获取详细的Sku信息 */
    private String skuId;

    /** 购买数量。取值范围:大于零的整数 */
    private Integer num;

    /** 外部网店自己定义的Sku编号 */
    private String outerSkuId;

    /** 子订单来源如jhs(聚划算)、trade(淘宝)、wap(无线) */
    private String orderFrom;

    /** 应付金额 */
    private BigDecimal totalFee;

    /** 子订单实付金额。 */
    private BigDecimal payment;

    /** 子订单级订单优惠金额。 */
    private BigDecimal discountFee;

    /** 手工调整金额. */
    private BigDecimal adjustFee;

    /** 订单修改时间 */
    private Date modified;

    /** SKU的值。 */
    private String skuPropertiesName;

    /** 最近退款ID */
    private Long refundId;

    /** 是否超卖 */
    private String isOversold;

    /** 子订单的交易结束时间 */
    private Date endTime;

    /** 子订单发货时间 */
    private String consignTime;

    /** 子订单的运送方式 */
    private String shippingType;

    /** 捆绑的子订单号， */
    private Long bindOid;

    /** 子订单发货的快递公司名称 */
    private String logisticsCompany;

    /** 子订单所在包裹的运单号 */
    private String invoiceNo;

    /** 表示订单交易是否含有对应的代销采购单。 */
    private String isDaixiao;

    /** 分摊之后的实付金额 */
    private BigDecimal divideOrderFee;

    /** 优惠分摊 */
    private String partMjzDiscount;

    /** 发货的仓库编码 */
    private String storeCode;

}
