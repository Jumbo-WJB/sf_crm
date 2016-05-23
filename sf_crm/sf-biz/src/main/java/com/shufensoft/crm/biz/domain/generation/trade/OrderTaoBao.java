package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Domain
@Data
@ToString
public class OrderTaoBao {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 交易ID */
    private Long tid;

    /** 子订单编号 */
    private Long oid;

    /**  */
    private Long sellerId;

    /** 店铺Id */
    private Long shopId;

    /** 关联user_taobao表user_id_tb */
    private Long userIdTb;

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

    /** 快递公司的拼音码 */
    private String simpleName;

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

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String idExpression;

    /** 与 max(id) 映射**/
    private Long maxId;

    /** 与 min(id) 映射**/
    private Long minId;

    /** 与 avg(id) 映射**/
    private Long avgId;

    /** 与 count(id) 映射**/
    private Long countId;

    /** 与 sum(id) 映射**/
    private Long sumId;

    /** gmtCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtCreatedExpression;

    /** 与 max(gmtCreated) 映射**/
    private Long maxGmtCreated;

    /** 与 min(gmtCreated) 映射**/
    private Long minGmtCreated;

    /** 与 avg(gmtCreated) 映射**/
    private Long avgGmtCreated;

    /** 与 count(gmtCreated) 映射**/
    private Long countGmtCreated;

    /** 与 sum(gmtCreated) 映射**/
    private Date sumGmtCreated;

    /** gmtModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtModifiedExpression;

    /** 与 max(gmtModified) 映射**/
    private Long maxGmtModified;

    /** 与 min(gmtModified) 映射**/
    private Long minGmtModified;

    /** 与 avg(gmtModified) 映射**/
    private Long avgGmtModified;

    /** 与 count(gmtModified) 映射**/
    private Long countGmtModified;

    /** 与 sum(gmtModified) 映射**/
    private Date sumGmtModified;

    /** isDeleted属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDeletedExpression;

    /** 与 max(isDeleted) 映射**/
    private Long maxIsDeleted;

    /** 与 min(isDeleted) 映射**/
    private Long minIsDeleted;

    /** 与 avg(isDeleted) 映射**/
    private Long avgIsDeleted;

    /** 与 count(isDeleted) 映射**/
    private Long countIsDeleted;

    /** 与 sum(isDeleted) 映射**/
    private String sumIsDeleted;

    /** tid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tidExpression;

    /** 与 max(tid) 映射**/
    private Long maxTid;

    /** 与 min(tid) 映射**/
    private Long minTid;

    /** 与 avg(tid) 映射**/
    private Long avgTid;

    /** 与 count(tid) 映射**/
    private Long countTid;

    /** 与 sum(tid) 映射**/
    private Long sumTid;

    /** oid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String oidExpression;

    /** 与 max(oid) 映射**/
    private Long maxOid;

    /** 与 min(oid) 映射**/
    private Long minOid;

    /** 与 avg(oid) 映射**/
    private Long avgOid;

    /** 与 count(oid) 映射**/
    private Long countOid;

    /** 与 sum(oid) 映射**/
    private Long sumOid;

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** 与 max(sellerId) 映射**/
    private Long maxSellerId;

    /** 与 min(sellerId) 映射**/
    private Long minSellerId;

    /** 与 avg(sellerId) 映射**/
    private Long avgSellerId;

    /** 与 count(sellerId) 映射**/
    private Long countSellerId;

    /** 与 sum(sellerId) 映射**/
    private Long sumSellerId;

    /** shopId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopIdExpression;

    /** 与 max(shopId) 映射**/
    private Long maxShopId;

    /** 与 min(shopId) 映射**/
    private Long minShopId;

    /** 与 avg(shopId) 映射**/
    private Long avgShopId;

    /** 与 count(shopId) 映射**/
    private Long countShopId;

    /** 与 sum(shopId) 映射**/
    private Long sumShopId;

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

    /** itemMealName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemMealNameExpression;

    /** 与 max(itemMealName) 映射**/
    private Long maxItemMealName;

    /** 与 min(itemMealName) 映射**/
    private Long minItemMealName;

    /** 与 avg(itemMealName) 映射**/
    private Long avgItemMealName;

    /** 与 count(itemMealName) 映射**/
    private Long countItemMealName;

    /** 与 sum(itemMealName) 映射**/
    private String sumItemMealName;

    /** sellerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerNickExpression;

    /** 与 max(sellerNick) 映射**/
    private Long maxSellerNick;

    /** 与 min(sellerNick) 映射**/
    private Long minSellerNick;

    /** 与 avg(sellerNick) 映射**/
    private Long avgSellerNick;

    /** 与 count(sellerNick) 映射**/
    private Long countSellerNick;

    /** 与 sum(sellerNick) 映射**/
    private String sumSellerNick;

    /** buyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerNickExpression;

    /** 与 max(buyerNick) 映射**/
    private Long maxBuyerNick;

    /** 与 min(buyerNick) 映射**/
    private Long minBuyerNick;

    /** 与 avg(buyerNick) 映射**/
    private Long avgBuyerNick;

    /** 与 count(buyerNick) 映射**/
    private Long countBuyerNick;

    /** 与 sum(buyerNick) 映射**/
    private String sumBuyerNick;

    /** refundStatus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String refundStatusExpression;

    /** 与 max(refundStatus) 映射**/
    private Long maxRefundStatus;

    /** 与 min(refundStatus) 映射**/
    private Long minRefundStatus;

    /** 与 avg(refundStatus) 映射**/
    private Long avgRefundStatus;

    /** 与 count(refundStatus) 映射**/
    private Long countRefundStatus;

    /** 与 sum(refundStatus) 映射**/
    private String sumRefundStatus;

    /** outerIid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerIidExpression;

    /** 与 max(outerIid) 映射**/
    private Long maxOuterIid;

    /** 与 min(outerIid) 映射**/
    private Long minOuterIid;

    /** 与 avg(outerIid) 映射**/
    private Long avgOuterIid;

    /** 与 count(outerIid) 映射**/
    private Long countOuterIid;

    /** 与 sum(outerIid) 映射**/
    private String sumOuterIid;

    /** snapshotUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String snapshotUrlExpression;

    /** 与 max(snapshotUrl) 映射**/
    private Long maxSnapshotUrl;

    /** 与 min(snapshotUrl) 映射**/
    private Long minSnapshotUrl;

    /** 与 avg(snapshotUrl) 映射**/
    private Long avgSnapshotUrl;

    /** 与 count(snapshotUrl) 映射**/
    private Long countSnapshotUrl;

    /** 与 sum(snapshotUrl) 映射**/
    private String sumSnapshotUrl;

    /** snapshot属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String snapshotExpression;

    /** 与 max(snapshot) 映射**/
    private Long maxSnapshot;

    /** 与 min(snapshot) 映射**/
    private Long minSnapshot;

    /** 与 avg(snapshot) 映射**/
    private Long avgSnapshot;

    /** 与 count(snapshot) 映射**/
    private Long countSnapshot;

    /** 与 sum(snapshot) 映射**/
    private String sumSnapshot;

    /** timeoutActionTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String timeoutActionTimeExpression;

    /** 与 max(timeoutActionTime) 映射**/
    private Long maxTimeoutActionTime;

    /** 与 min(timeoutActionTime) 映射**/
    private Long minTimeoutActionTime;

    /** 与 avg(timeoutActionTime) 映射**/
    private Long avgTimeoutActionTime;

    /** 与 count(timeoutActionTime) 映射**/
    private Long countTimeoutActionTime;

    /** 与 sum(timeoutActionTime) 映射**/
    private Date sumTimeoutActionTime;

    /** buyerRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerRateExpression;

    /** 与 max(buyerRate) 映射**/
    private Long maxBuyerRate;

    /** 与 min(buyerRate) 映射**/
    private Long minBuyerRate;

    /** 与 avg(buyerRate) 映射**/
    private Long avgBuyerRate;

    /** 与 count(buyerRate) 映射**/
    private Long countBuyerRate;

    /** 与 sum(buyerRate) 映射**/
    private String sumBuyerRate;

    /** cid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String cidExpression;

    /** 与 max(cid) 映射**/
    private Long maxCid;

    /** 与 min(cid) 映射**/
    private Long minCid;

    /** 与 avg(cid) 映射**/
    private Long avgCid;

    /** 与 count(cid) 映射**/
    private Long countCid;

    /** 与 sum(cid) 映射**/
    private Long sumCid;

    /** status属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statusExpression;

    /** 与 max(status) 映射**/
    private Long maxStatus;

    /** 与 min(status) 映射**/
    private Long minStatus;

    /** 与 avg(status) 映射**/
    private Long avgStatus;

    /** 与 count(status) 映射**/
    private Long countStatus;

    /** 与 sum(status) 映射**/
    private String sumStatus;

    /** title属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String titleExpression;

    /** 与 max(title) 映射**/
    private Long maxTitle;

    /** 与 min(title) 映射**/
    private Long minTitle;

    /** 与 avg(title) 映射**/
    private Long avgTitle;

    /** 与 count(title) 映射**/
    private Long countTitle;

    /** 与 sum(title) 映射**/
    private String sumTitle;

    /** price属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String priceExpression;

    /** 与 max(price) 映射**/
    private Long maxPrice;

    /** 与 min(price) 映射**/
    private Long minPrice;

    /** 与 avg(price) 映射**/
    private Long avgPrice;

    /** 与 count(price) 映射**/
    private Long countPrice;

    /** 与 sum(price) 映射**/
    private BigDecimal sumPrice;

    /** numIid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numIidExpression;

    /** 与 max(numIid) 映射**/
    private Long maxNumIid;

    /** 与 min(numIid) 映射**/
    private Long minNumIid;

    /** 与 avg(numIid) 映射**/
    private Long avgNumIid;

    /** 与 count(numIid) 映射**/
    private Long countNumIid;

    /** 与 sum(numIid) 映射**/
    private Long sumNumIid;

    /** itemMealId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemMealIdExpression;

    /** 与 max(itemMealId) 映射**/
    private Long maxItemMealId;

    /** 与 min(itemMealId) 映射**/
    private Long minItemMealId;

    /** 与 avg(itemMealId) 映射**/
    private Long avgItemMealId;

    /** 与 count(itemMealId) 映射**/
    private Long countItemMealId;

    /** 与 sum(itemMealId) 映射**/
    private Long sumItemMealId;

    /** skuId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuIdExpression;

    /** 与 max(skuId) 映射**/
    private Long maxSkuId;

    /** 与 min(skuId) 映射**/
    private Long minSkuId;

    /** 与 avg(skuId) 映射**/
    private Long avgSkuId;

    /** 与 count(skuId) 映射**/
    private Long countSkuId;

    /** 与 sum(skuId) 映射**/
    private String sumSkuId;

    /** num属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numExpression;

    /** 与 max(num) 映射**/
    private Long maxNum;

    /** 与 min(num) 映射**/
    private Long minNum;

    /** 与 avg(num) 映射**/
    private Long avgNum;

    /** 与 count(num) 映射**/
    private Long countNum;

    /** 与 sum(num) 映射**/
    private Integer sumNum;

    /** outerSkuId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerSkuIdExpression;

    /** 与 max(outerSkuId) 映射**/
    private Long maxOuterSkuId;

    /** 与 min(outerSkuId) 映射**/
    private Long minOuterSkuId;

    /** 与 avg(outerSkuId) 映射**/
    private Long avgOuterSkuId;

    /** 与 count(outerSkuId) 映射**/
    private Long countOuterSkuId;

    /** 与 sum(outerSkuId) 映射**/
    private String sumOuterSkuId;

    /** orderFrom属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderFromExpression;

    /** 与 max(orderFrom) 映射**/
    private Long maxOrderFrom;

    /** 与 min(orderFrom) 映射**/
    private Long minOrderFrom;

    /** 与 avg(orderFrom) 映射**/
    private Long avgOrderFrom;

    /** 与 count(orderFrom) 映射**/
    private Long countOrderFrom;

    /** 与 sum(orderFrom) 映射**/
    private String sumOrderFrom;

    /** totalFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String totalFeeExpression;

    /** 与 max(totalFee) 映射**/
    private Long maxTotalFee;

    /** 与 min(totalFee) 映射**/
    private Long minTotalFee;

    /** 与 avg(totalFee) 映射**/
    private Long avgTotalFee;

    /** 与 count(totalFee) 映射**/
    private Long countTotalFee;

    /** 与 sum(totalFee) 映射**/
    private BigDecimal sumTotalFee;

    /** payment属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String paymentExpression;

    /** 与 max(payment) 映射**/
    private Long maxPayment;

    /** 与 min(payment) 映射**/
    private Long minPayment;

    /** 与 avg(payment) 映射**/
    private Long avgPayment;

    /** 与 count(payment) 映射**/
    private Long countPayment;

    /** 与 sum(payment) 映射**/
    private BigDecimal sumPayment;

    /** discountFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String discountFeeExpression;

    /** 与 max(discountFee) 映射**/
    private Long maxDiscountFee;

    /** 与 min(discountFee) 映射**/
    private Long minDiscountFee;

    /** 与 avg(discountFee) 映射**/
    private Long avgDiscountFee;

    /** 与 count(discountFee) 映射**/
    private Long countDiscountFee;

    /** 与 sum(discountFee) 映射**/
    private BigDecimal sumDiscountFee;

    /** adjustFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String adjustFeeExpression;

    /** 与 max(adjustFee) 映射**/
    private Long maxAdjustFee;

    /** 与 min(adjustFee) 映射**/
    private Long minAdjustFee;

    /** 与 avg(adjustFee) 映射**/
    private Long avgAdjustFee;

    /** 与 count(adjustFee) 映射**/
    private Long countAdjustFee;

    /** 与 sum(adjustFee) 映射**/
    private BigDecimal sumAdjustFee;

    /** modified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedExpression;

    /** 与 max(modified) 映射**/
    private Long maxModified;

    /** 与 min(modified) 映射**/
    private Long minModified;

    /** 与 avg(modified) 映射**/
    private Long avgModified;

    /** 与 count(modified) 映射**/
    private Long countModified;

    /** 与 sum(modified) 映射**/
    private Date sumModified;

    /** skuPropertiesName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuPropertiesNameExpression;

    /** 与 max(skuPropertiesName) 映射**/
    private Long maxSkuPropertiesName;

    /** 与 min(skuPropertiesName) 映射**/
    private Long minSkuPropertiesName;

    /** 与 avg(skuPropertiesName) 映射**/
    private Long avgSkuPropertiesName;

    /** 与 count(skuPropertiesName) 映射**/
    private Long countSkuPropertiesName;

    /** 与 sum(skuPropertiesName) 映射**/
    private String sumSkuPropertiesName;

    /** refundId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String refundIdExpression;

    /** 与 max(refundId) 映射**/
    private Long maxRefundId;

    /** 与 min(refundId) 映射**/
    private Long minRefundId;

    /** 与 avg(refundId) 映射**/
    private Long avgRefundId;

    /** 与 count(refundId) 映射**/
    private Long countRefundId;

    /** 与 sum(refundId) 映射**/
    private Long sumRefundId;

    /** isOversold属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isOversoldExpression;

    /** 与 max(isOversold) 映射**/
    private Long maxIsOversold;

    /** 与 min(isOversold) 映射**/
    private Long minIsOversold;

    /** 与 avg(isOversold) 映射**/
    private Long avgIsOversold;

    /** 与 count(isOversold) 映射**/
    private Long countIsOversold;

    /** 与 sum(isOversold) 映射**/
    private String sumIsOversold;

    /** endTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endTimeExpression;

    /** 与 max(endTime) 映射**/
    private Long maxEndTime;

    /** 与 min(endTime) 映射**/
    private Long minEndTime;

    /** 与 avg(endTime) 映射**/
    private Long avgEndTime;

    /** 与 count(endTime) 映射**/
    private Long countEndTime;

    /** 与 sum(endTime) 映射**/
    private Date sumEndTime;

    /** consignTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String consignTimeExpression;

    /** 与 max(consignTime) 映射**/
    private Long maxConsignTime;

    /** 与 min(consignTime) 映射**/
    private Long minConsignTime;

    /** 与 avg(consignTime) 映射**/
    private Long avgConsignTime;

    /** 与 count(consignTime) 映射**/
    private Long countConsignTime;

    /** 与 sum(consignTime) 映射**/
    private String sumConsignTime;

    /** shippingType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shippingTypeExpression;

    /** 与 max(shippingType) 映射**/
    private Long maxShippingType;

    /** 与 min(shippingType) 映射**/
    private Long minShippingType;

    /** 与 avg(shippingType) 映射**/
    private Long avgShippingType;

    /** 与 count(shippingType) 映射**/
    private Long countShippingType;

    /** 与 sum(shippingType) 映射**/
    private String sumShippingType;

    /** bindOid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String bindOidExpression;

    /** 与 max(bindOid) 映射**/
    private Long maxBindOid;

    /** 与 min(bindOid) 映射**/
    private Long minBindOid;

    /** 与 avg(bindOid) 映射**/
    private Long avgBindOid;

    /** 与 count(bindOid) 映射**/
    private Long countBindOid;

    /** 与 sum(bindOid) 映射**/
    private Long sumBindOid;

    /** logisticsCompany属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String logisticsCompanyExpression;

    /** 与 max(logisticsCompany) 映射**/
    private Long maxLogisticsCompany;

    /** 与 min(logisticsCompany) 映射**/
    private Long minLogisticsCompany;

    /** 与 avg(logisticsCompany) 映射**/
    private Long avgLogisticsCompany;

    /** 与 count(logisticsCompany) 映射**/
    private Long countLogisticsCompany;

    /** 与 sum(logisticsCompany) 映射**/
    private String sumLogisticsCompany;

    /** simpleName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String simpleNameExpression;

    /** 与 max(simpleName) 映射**/
    private Long maxSimpleName;

    /** 与 min(simpleName) 映射**/
    private Long minSimpleName;

    /** 与 avg(simpleName) 映射**/
    private Long avgSimpleName;

    /** 与 count(simpleName) 映射**/
    private Long countSimpleName;

    /** 与 sum(simpleName) 映射**/
    private String sumSimpleName;

    /** invoiceNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String invoiceNoExpression;

    /** 与 max(invoiceNo) 映射**/
    private Long maxInvoiceNo;

    /** 与 min(invoiceNo) 映射**/
    private Long minInvoiceNo;

    /** 与 avg(invoiceNo) 映射**/
    private Long avgInvoiceNo;

    /** 与 count(invoiceNo) 映射**/
    private Long countInvoiceNo;

    /** 与 sum(invoiceNo) 映射**/
    private String sumInvoiceNo;

    /** isDaixiao属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDaixiaoExpression;

    /** 与 max(isDaixiao) 映射**/
    private Long maxIsDaixiao;

    /** 与 min(isDaixiao) 映射**/
    private Long minIsDaixiao;

    /** 与 avg(isDaixiao) 映射**/
    private Long avgIsDaixiao;

    /** 与 count(isDaixiao) 映射**/
    private Long countIsDaixiao;

    /** 与 sum(isDaixiao) 映射**/
    private String sumIsDaixiao;

    /** divideOrderFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String divideOrderFeeExpression;

    /** 与 max(divideOrderFee) 映射**/
    private Long maxDivideOrderFee;

    /** 与 min(divideOrderFee) 映射**/
    private Long minDivideOrderFee;

    /** 与 avg(divideOrderFee) 映射**/
    private Long avgDivideOrderFee;

    /** 与 count(divideOrderFee) 映射**/
    private Long countDivideOrderFee;

    /** 与 sum(divideOrderFee) 映射**/
    private BigDecimal sumDivideOrderFee;

    /** partMjzDiscount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String partMjzDiscountExpression;

    /** 与 max(partMjzDiscount) 映射**/
    private Long maxPartMjzDiscount;

    /** 与 min(partMjzDiscount) 映射**/
    private Long minPartMjzDiscount;

    /** 与 avg(partMjzDiscount) 映射**/
    private Long avgPartMjzDiscount;

    /** 与 count(partMjzDiscount) 映射**/
    private Long countPartMjzDiscount;

    /** 与 sum(partMjzDiscount) 映射**/
    private String sumPartMjzDiscount;

    /** storeCode属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String storeCodeExpression;

    /** 与 max(storeCode) 映射**/
    private Long maxStoreCode;

    /** 与 min(storeCode) 映射**/
    private Long minStoreCode;

    /** 与 avg(storeCode) 映射**/
    private Long avgStoreCode;

    /** 与 count(storeCode) 映射**/
    private Long countStoreCode;

    /** 与 sum(storeCode) 映射**/
    private String sumStoreCode;
}