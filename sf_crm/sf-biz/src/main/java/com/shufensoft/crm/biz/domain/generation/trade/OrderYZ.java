package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Domain
@Data
@ToString
public class OrderYZ {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 商品数字编号 */
    private Long numIid;

    /**  */
    private Long oid;

    /** 订单ID */
    private String tid;

    /** Sku的ID */
    private Long skuId;

    /** Sku的唯一编码，该编码可用来判断所属商品，并保证商品唯一性。 */
    private String skuUniqueCode;

    /** 商品购买数量 */
    private Integer num;

    /** 商家编码（商家为Sku设置的外部编号） */
    private String outerSkuId;

    /** 应user_yz表user_id_yz */
    private Long userIdYz;

    /** 商品货号（商家为商品设置的外部编号） */
    private String outerItemId;

    /** 商品标题 */
    private String title;

    /** 卖家昵称 */
    private String sellerNick;

    /** 商品价格。 */
    private String price;

    /** 应付金额（商品价格乘以数量的总金额） */
    private BigDecimal totalFee;

    /** 交易明细内的优惠金额。 */
    private BigDecimal discountFee;

    /** 实付金额 */
    private BigDecimal payment;

    /** SKU的值，即：商品的规格。如：机身颜色:黑色;手机套餐:官方标配 */
    private String skuPropertiesName;

    /** 商品类型。 */
    private Integer itemType;

    /**  */
    private Long sellerId;

    /** 店铺Id */
    private Long shopId;

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
    private String sumTid;

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
    private Long sumSkuId;

    /** skuUniqueCode属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuUniqueCodeExpression;

    /** 与 max(skuUniqueCode) 映射**/
    private Long maxSkuUniqueCode;

    /** 与 min(skuUniqueCode) 映射**/
    private Long minSkuUniqueCode;

    /** 与 avg(skuUniqueCode) 映射**/
    private Long avgSkuUniqueCode;

    /** 与 count(skuUniqueCode) 映射**/
    private Long countSkuUniqueCode;

    /** 与 sum(skuUniqueCode) 映射**/
    private String sumSkuUniqueCode;

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

    /** userIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdYzExpression;

    /** 与 max(userIdYz) 映射**/
    private Long maxUserIdYz;

    /** 与 min(userIdYz) 映射**/
    private Long minUserIdYz;

    /** 与 avg(userIdYz) 映射**/
    private Long avgUserIdYz;

    /** 与 count(userIdYz) 映射**/
    private Long countUserIdYz;

    /** 与 sum(userIdYz) 映射**/
    private Long sumUserIdYz;

    /** outerItemId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerItemIdExpression;

    /** 与 max(outerItemId) 映射**/
    private Long maxOuterItemId;

    /** 与 min(outerItemId) 映射**/
    private Long minOuterItemId;

    /** 与 avg(outerItemId) 映射**/
    private Long avgOuterItemId;

    /** 与 count(outerItemId) 映射**/
    private Long countOuterItemId;

    /** 与 sum(outerItemId) 映射**/
    private String sumOuterItemId;

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
    private String sumPrice;

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

    /** itemType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemTypeExpression;

    /** 与 max(itemType) 映射**/
    private Long maxItemType;

    /** 与 min(itemType) 映射**/
    private Long minItemType;

    /** 与 avg(itemType) 映射**/
    private Long avgItemType;

    /** 与 count(itemType) 映射**/
    private Long countItemType;

    /** 与 sum(itemType) 映射**/
    private Integer sumItemType;

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

    /**交易明细中的买家留言列表**/
    private List<BuyerMessageYZ> buyerMessages;
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
}