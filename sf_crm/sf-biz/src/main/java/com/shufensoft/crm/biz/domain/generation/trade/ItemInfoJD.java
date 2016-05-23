package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ItemInfoJD {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 商家id */
    private Long sellerId;

    /** 店铺id */
    private Long shopId;

    /** 对应user_jd表user_id_jd */
    private Long userIdJd;

    /** 元京东内部商品ID（极端情况下不保证返回，建议从商品接口获取   */
    private String wareId;

    /** 订单ID */
    private String orderId;

    /** 京东内部SKU的ID  */
    private String skuId;

    /** SKU外部ID（极端情况下不保证返回，建议从商品接口获取）  */
    private String outerSkuId;

    /** 商品的名称+SKU规格  */
    private String skuName;

    /** SKU的京东价  */
    private String jdPrice;

    /** 赠送积分  */
    private Integer giftPoint;

    /** 数量  */
    private Integer itemTotal;

    /** 商品货号（极端情况下不保证返回，建议从商品接口获取） */
    private String productNo;

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

    /** userIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdJdExpression;

    /** 与 max(userIdJd) 映射**/
    private Long maxUserIdJd;

    /** 与 min(userIdJd) 映射**/
    private Long minUserIdJd;

    /** 与 avg(userIdJd) 映射**/
    private Long avgUserIdJd;

    /** 与 count(userIdJd) 映射**/
    private Long countUserIdJd;

    /** 与 sum(userIdJd) 映射**/
    private Long sumUserIdJd;

    /** wareId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wareIdExpression;

    /** 与 max(wareId) 映射**/
    private Long maxWareId;

    /** 与 min(wareId) 映射**/
    private Long minWareId;

    /** 与 avg(wareId) 映射**/
    private Long avgWareId;

    /** 与 count(wareId) 映射**/
    private Long countWareId;

    /** 与 sum(wareId) 映射**/
    private String sumWareId;

    /** orderId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderIdExpression;

    /** 与 max(orderId) 映射**/
    private Long maxOrderId;

    /** 与 min(orderId) 映射**/
    private Long minOrderId;

    /** 与 avg(orderId) 映射**/
    private Long avgOrderId;

    /** 与 count(orderId) 映射**/
    private Long countOrderId;

    /** 与 sum(orderId) 映射**/
    private String sumOrderId;

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

    /** skuName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuNameExpression;

    /** 与 max(skuName) 映射**/
    private Long maxSkuName;

    /** 与 min(skuName) 映射**/
    private Long minSkuName;

    /** 与 avg(skuName) 映射**/
    private Long avgSkuName;

    /** 与 count(skuName) 映射**/
    private Long countSkuName;

    /** 与 sum(skuName) 映射**/
    private String sumSkuName;

    /** jdPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdPriceExpression;

    /** 与 max(jdPrice) 映射**/
    private Long maxJdPrice;

    /** 与 min(jdPrice) 映射**/
    private Long minJdPrice;

    /** 与 avg(jdPrice) 映射**/
    private Long avgJdPrice;

    /** 与 count(jdPrice) 映射**/
    private Long countJdPrice;

    /** 与 sum(jdPrice) 映射**/
    private String sumJdPrice;

    /** giftPoint属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String giftPointExpression;

    /** 与 max(giftPoint) 映射**/
    private Long maxGiftPoint;

    /** 与 min(giftPoint) 映射**/
    private Long minGiftPoint;

    /** 与 avg(giftPoint) 映射**/
    private Long avgGiftPoint;

    /** 与 count(giftPoint) 映射**/
    private Long countGiftPoint;

    /** 与 sum(giftPoint) 映射**/
    private Integer sumGiftPoint;

    /** itemTotal属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemTotalExpression;

    /** 与 max(itemTotal) 映射**/
    private Long maxItemTotal;

    /** 与 min(itemTotal) 映射**/
    private Long minItemTotal;

    /** 与 avg(itemTotal) 映射**/
    private Long avgItemTotal;

    /** 与 count(itemTotal) 映射**/
    private Long countItemTotal;

    /** 与 sum(itemTotal) 映射**/
    private Integer sumItemTotal;

    /** productNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String productNoExpression;

    /** 与 max(productNo) 映射**/
    private Long maxProductNo;

    /** 与 min(productNo) 映射**/
    private Long minProductNo;

    /** 与 avg(productNo) 映射**/
    private Long avgProductNo;

    /** 与 count(productNo) 映射**/
    private Long countProductNo;

    /** 与 sum(productNo) 映射**/
    private String sumProductNo;
}