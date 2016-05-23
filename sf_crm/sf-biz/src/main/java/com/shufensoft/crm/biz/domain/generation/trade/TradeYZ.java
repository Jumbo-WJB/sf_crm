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
public class TradeYZ {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 订单ID */
    private String tid;

    /**  */
    private Long sellerId;

    /** 店铺id */
    private Long shopId;

    /** 有赞用户id（内部系统定义） */
    private Long userIdYz;

    /** 收件人Id */
    private Long receiverIdYz;

    /** 商品购买数量 */
    private Integer num;

    /** 所有商品编号 */
    private String numIid;

    /** 商品主图片缩略图地址 */
    private String picThumbPath;

    /** 商品主图片地址 */
    private String picPath;

    /** 商品价格 */
    private BigDecimal price;

    /** 订单标题 */
    private String title;

    /** 交易类型交易类型。取值范围：FIXED （一口价）GIFT （送礼）PRESENT （赠品领取）COD （货到付款）QRCODE（扫码商家二维码直接支付的交易） */
    private String type;

    /** 微信粉丝ID */
    private Long weixinUserId;

    /** 买家类型，取值范围：0 为未知，1 为微信粉丝，2 为微博粉丝 */
    private Integer buyerType;

    /**  买家ID */
    private Long buyerId;

    /** 买家昵称 */
    private String buyerNick;

    /**  买家购买附言 */
    private String buyerMessage;

    /**  卖家备注星标，取值范围 1、2、3、4、5；如果为0，表示没有备注星标 */
    private Integer sellerFlag;

    /**  卖家对该交易的备注 */
    private String tradeMemo;

    /**  收货人的所在城市 */
    private String receiverCity;

    /**  收货人的所在地区 */
    private String receiverDistrict;

    /**  收货姓名 */
    private String receiverName;

    /**  收货人所在省 */
    private String receiverState;

    /** 收货人的详细地址 */
    private String receiverAddress;

    /** 收货人邮编 */
    private String receiverZip;

    /** 收货人手机 */
    private String receiverMobile;

    /** 交易维持状态 */
    private Integer feedback;

    /** 外部交易编号。比如，如果支付方式是微信支付，就是财付通的交易单号 */
    private String outerTid;

    /** 交易状态 */
    private String status;

    /** 创建交易时的物流方式。取值范围：express（快递），fetch（到店自提） */
    private String shippingType;

    /** 运费。单位：元，精确到分 */
    private BigDecimal postFee;

    /** 商品应付金额（商品价格乘以数量的总金额）。单位：元，精确到分 */
    private BigDecimal totalFee;

    /** 交易优惠金额（不包含交易明细中的优惠金额）。单位：元，精确到分 */
    private BigDecimal discountFee;

    /** 卖家手工调整订单金额 */
    private BigDecimal adjustFee;

    /** 实付金额。单位：元，精确到分 */
    private BigDecimal payment;

    /** 交易创建时间 */
    private Date created;

    /** 交易更新时间 */
    private Date updateTime;

    /** 买家付款时间 */
    private Date payTime;

    /** 支付类型 */
    private String payType;

    /** 发货时间 */
    private Date consignTime;

    /** 买家签收时间 */
    private Date signTime;

    /** 父交易ID */
    private String parentTid;

    /** 下单区域 */
    private String buyerArea;

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
    private String sumTid;

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

    /** receiverIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdYzExpression;

    /** 与 max(receiverIdYz) 映射**/
    private Long maxReceiverIdYz;

    /** 与 min(receiverIdYz) 映射**/
    private Long minReceiverIdYz;

    /** 与 avg(receiverIdYz) 映射**/
    private Long avgReceiverIdYz;

    /** 与 count(receiverIdYz) 映射**/
    private Long countReceiverIdYz;

    /** 与 sum(receiverIdYz) 映射**/
    private Long sumReceiverIdYz;

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
    private String sumNumIid;

    /** picThumbPath属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String picThumbPathExpression;

    /** 与 max(picThumbPath) 映射**/
    private Long maxPicThumbPath;

    /** 与 min(picThumbPath) 映射**/
    private Long minPicThumbPath;

    /** 与 avg(picThumbPath) 映射**/
    private Long avgPicThumbPath;

    /** 与 count(picThumbPath) 映射**/
    private Long countPicThumbPath;

    /** 与 sum(picThumbPath) 映射**/
    private String sumPicThumbPath;

    /** picPath属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String picPathExpression;

    /** 与 max(picPath) 映射**/
    private Long maxPicPath;

    /** 与 min(picPath) 映射**/
    private Long minPicPath;

    /** 与 avg(picPath) 映射**/
    private Long avgPicPath;

    /** 与 count(picPath) 映射**/
    private Long countPicPath;

    /** 与 sum(picPath) 映射**/
    private String sumPicPath;

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

    /** type属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String typeExpression;

    /** 与 max(type) 映射**/
    private Long maxType;

    /** 与 min(type) 映射**/
    private Long minType;

    /** 与 avg(type) 映射**/
    private Long avgType;

    /** 与 count(type) 映射**/
    private Long countType;

    /** 与 sum(type) 映射**/
    private String sumType;

    /** weixinUserId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String weixinUserIdExpression;

    /** 与 max(weixinUserId) 映射**/
    private Long maxWeixinUserId;

    /** 与 min(weixinUserId) 映射**/
    private Long minWeixinUserId;

    /** 与 avg(weixinUserId) 映射**/
    private Long avgWeixinUserId;

    /** 与 count(weixinUserId) 映射**/
    private Long countWeixinUserId;

    /** 与 sum(weixinUserId) 映射**/
    private Long sumWeixinUserId;

    /** buyerType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerTypeExpression;

    /** 与 max(buyerType) 映射**/
    private Long maxBuyerType;

    /** 与 min(buyerType) 映射**/
    private Long minBuyerType;

    /** 与 avg(buyerType) 映射**/
    private Long avgBuyerType;

    /** 与 count(buyerType) 映射**/
    private Long countBuyerType;

    /** 与 sum(buyerType) 映射**/
    private Integer sumBuyerType;

    /** buyerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerIdExpression;

    /** 与 max(buyerId) 映射**/
    private Long maxBuyerId;

    /** 与 min(buyerId) 映射**/
    private Long minBuyerId;

    /** 与 avg(buyerId) 映射**/
    private Long avgBuyerId;

    /** 与 count(buyerId) 映射**/
    private Long countBuyerId;

    /** 与 sum(buyerId) 映射**/
    private Long sumBuyerId;

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

    /** buyerMessage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerMessageExpression;

    /** 与 max(buyerMessage) 映射**/
    private Long maxBuyerMessage;

    /** 与 min(buyerMessage) 映射**/
    private Long minBuyerMessage;

    /** 与 avg(buyerMessage) 映射**/
    private Long avgBuyerMessage;

    /** 与 count(buyerMessage) 映射**/
    private Long countBuyerMessage;

    /** 与 sum(buyerMessage) 映射**/
    private String sumBuyerMessage;

    /** sellerFlag属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerFlagExpression;

    /** 与 max(sellerFlag) 映射**/
    private Long maxSellerFlag;

    /** 与 min(sellerFlag) 映射**/
    private Long minSellerFlag;

    /** 与 avg(sellerFlag) 映射**/
    private Long avgSellerFlag;

    /** 与 count(sellerFlag) 映射**/
    private Long countSellerFlag;

    /** 与 sum(sellerFlag) 映射**/
    private Integer sumSellerFlag;

    /** tradeMemo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tradeMemoExpression;

    /** 与 max(tradeMemo) 映射**/
    private Long maxTradeMemo;

    /** 与 min(tradeMemo) 映射**/
    private Long minTradeMemo;

    /** 与 avg(tradeMemo) 映射**/
    private Long avgTradeMemo;

    /** 与 count(tradeMemo) 映射**/
    private Long countTradeMemo;

    /** 与 sum(tradeMemo) 映射**/
    private String sumTradeMemo;

    /** receiverCity属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverCityExpression;

    /** 与 max(receiverCity) 映射**/
    private Long maxReceiverCity;

    /** 与 min(receiverCity) 映射**/
    private Long minReceiverCity;

    /** 与 avg(receiverCity) 映射**/
    private Long avgReceiverCity;

    /** 与 count(receiverCity) 映射**/
    private Long countReceiverCity;

    /** 与 sum(receiverCity) 映射**/
    private String sumReceiverCity;

    /** receiverDistrict属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverDistrictExpression;

    /** 与 max(receiverDistrict) 映射**/
    private Long maxReceiverDistrict;

    /** 与 min(receiverDistrict) 映射**/
    private Long minReceiverDistrict;

    /** 与 avg(receiverDistrict) 映射**/
    private Long avgReceiverDistrict;

    /** 与 count(receiverDistrict) 映射**/
    private Long countReceiverDistrict;

    /** 与 sum(receiverDistrict) 映射**/
    private String sumReceiverDistrict;

    /** receiverName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverNameExpression;

    /** 与 max(receiverName) 映射**/
    private Long maxReceiverName;

    /** 与 min(receiverName) 映射**/
    private Long minReceiverName;

    /** 与 avg(receiverName) 映射**/
    private Long avgReceiverName;

    /** 与 count(receiverName) 映射**/
    private Long countReceiverName;

    /** 与 sum(receiverName) 映射**/
    private String sumReceiverName;

    /** receiverState属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverStateExpression;

    /** 与 max(receiverState) 映射**/
    private Long maxReceiverState;

    /** 与 min(receiverState) 映射**/
    private Long minReceiverState;

    /** 与 avg(receiverState) 映射**/
    private Long avgReceiverState;

    /** 与 count(receiverState) 映射**/
    private Long countReceiverState;

    /** 与 sum(receiverState) 映射**/
    private String sumReceiverState;

    /** receiverAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverAddressExpression;

    /** 与 max(receiverAddress) 映射**/
    private Long maxReceiverAddress;

    /** 与 min(receiverAddress) 映射**/
    private Long minReceiverAddress;

    /** 与 avg(receiverAddress) 映射**/
    private Long avgReceiverAddress;

    /** 与 count(receiverAddress) 映射**/
    private Long countReceiverAddress;

    /** 与 sum(receiverAddress) 映射**/
    private String sumReceiverAddress;

    /** receiverZip属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverZipExpression;

    /** 与 max(receiverZip) 映射**/
    private Long maxReceiverZip;

    /** 与 min(receiverZip) 映射**/
    private Long minReceiverZip;

    /** 与 avg(receiverZip) 映射**/
    private Long avgReceiverZip;

    /** 与 count(receiverZip) 映射**/
    private Long countReceiverZip;

    /** 与 sum(receiverZip) 映射**/
    private String sumReceiverZip;

    /** receiverMobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverMobileExpression;

    /** 与 max(receiverMobile) 映射**/
    private Long maxReceiverMobile;

    /** 与 min(receiverMobile) 映射**/
    private Long minReceiverMobile;

    /** 与 avg(receiverMobile) 映射**/
    private Long avgReceiverMobile;

    /** 与 count(receiverMobile) 映射**/
    private Long countReceiverMobile;

    /** 与 sum(receiverMobile) 映射**/
    private String sumReceiverMobile;

    /** feedback属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String feedbackExpression;

    /** 与 max(feedback) 映射**/
    private Long maxFeedback;

    /** 与 min(feedback) 映射**/
    private Long minFeedback;

    /** 与 avg(feedback) 映射**/
    private Long avgFeedback;

    /** 与 count(feedback) 映射**/
    private Long countFeedback;

    /** 与 sum(feedback) 映射**/
    private Integer sumFeedback;

    /** outerTid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerTidExpression;

    /** 与 max(outerTid) 映射**/
    private Long maxOuterTid;

    /** 与 min(outerTid) 映射**/
    private Long minOuterTid;

    /** 与 avg(outerTid) 映射**/
    private Long avgOuterTid;

    /** 与 count(outerTid) 映射**/
    private Long countOuterTid;

    /** 与 sum(outerTid) 映射**/
    private String sumOuterTid;

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

    /** postFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String postFeeExpression;

    /** 与 max(postFee) 映射**/
    private Long maxPostFee;

    /** 与 min(postFee) 映射**/
    private Long minPostFee;

    /** 与 avg(postFee) 映射**/
    private Long avgPostFee;

    /** 与 count(postFee) 映射**/
    private Long countPostFee;

    /** 与 sum(postFee) 映射**/
    private BigDecimal sumPostFee;

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

    /** created属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdExpression;

    /** 与 max(created) 映射**/
    private Long maxCreated;

    /** 与 min(created) 映射**/
    private Long minCreated;

    /** 与 avg(created) 映射**/
    private Long avgCreated;

    /** 与 count(created) 映射**/
    private Long countCreated;

    /** 与 sum(created) 映射**/
    private Date sumCreated;

    /** updateTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String updateTimeExpression;

    /** 与 max(updateTime) 映射**/
    private Long maxUpdateTime;

    /** 与 min(updateTime) 映射**/
    private Long minUpdateTime;

    /** 与 avg(updateTime) 映射**/
    private Long avgUpdateTime;

    /** 与 count(updateTime) 映射**/
    private Long countUpdateTime;

    /** 与 sum(updateTime) 映射**/
    private Date sumUpdateTime;

    /** payTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String payTimeExpression;

    /** 与 max(payTime) 映射**/
    private Long maxPayTime;

    /** 与 min(payTime) 映射**/
    private Long minPayTime;

    /** 与 avg(payTime) 映射**/
    private Long avgPayTime;

    /** 与 count(payTime) 映射**/
    private Long countPayTime;

    /** 与 sum(payTime) 映射**/
    private Date sumPayTime;

    /** payType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String payTypeExpression;

    /** 与 max(payType) 映射**/
    private Long maxPayType;

    /** 与 min(payType) 映射**/
    private Long minPayType;

    /** 与 avg(payType) 映射**/
    private Long avgPayType;

    /** 与 count(payType) 映射**/
    private Long countPayType;

    /** 与 sum(payType) 映射**/
    private String sumPayType;

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
    private Date sumConsignTime;

    /** signTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String signTimeExpression;

    /** 与 max(signTime) 映射**/
    private Long maxSignTime;

    /** 与 min(signTime) 映射**/
    private Long minSignTime;

    /** 与 avg(signTime) 映射**/
    private Long avgSignTime;

    /** 与 count(signTime) 映射**/
    private Long countSignTime;

    /** 与 sum(signTime) 映射**/
    private Date sumSignTime;

    /** parentTid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String parentTidExpression;

    /** 与 max(parentTid) 映射**/
    private Long maxParentTid;

    /** 与 min(parentTid) 映射**/
    private Long minParentTid;

    /** 与 avg(parentTid) 映射**/
    private Long avgParentTid;

    /** 与 count(parentTid) 映射**/
    private Long countParentTid;

    /** 与 sum(parentTid) 映射**/
    private String sumParentTid;

    /** buyerArea属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerAreaExpression;

    /** 与 max(buyerArea) 映射**/
    private Long maxBuyerArea;

    /** 与 min(buyerArea) 映射**/
    private Long minBuyerArea;

    /** 与 avg(buyerArea) 映射**/
    private Long avgBuyerArea;

    /** 与 count(buyerArea) 映射**/
    private Long countBuyerArea;

    /** 与 sum(buyerArea) 映射**/
    private String sumBuyerArea;

    private List<OrderYZ> orders;

}