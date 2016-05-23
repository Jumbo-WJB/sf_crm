package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Domain
@Data
@ToString
public class OrderJD {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 订单ID */
    private String orderId;

    /** 店铺Id */
    private Long shopId;

    /** 订单来源 */
    private String orderSource;

    /** 对应user_jd表user_id_jd */
    private Long userIdJd;

    /** 收件人Id */
    private Long receiverIdJd;

    /** 商家id */
    private String venderId;

    /** 支付方式（1货到付款 2邮局汇款 3自提 4在线支付 5公司转账 6银行转账） */
    private String payType;

    /** 	订单总金额 */
    private BigDecimal orderTotalPrice;

    /** 	订单货款金额（订单总金额-商家优惠金额） */
    private BigDecimal orderSellerPrice;

    /** 用户应付金额 */
    private BigDecimal orderPayment;

    /** 商品的运费 */
    private BigDecimal freightPrice;

    /** 商家优惠金额 */
    private BigDecimal sellerDiscount;

    /** 订单状态（英文） */
    private String orderState;

    /** 	订单状态说明（中文） */
    private String orderStateRemark;

    /** 送货（日期）类型（1-只工作日送货(双休日、假日不用送) ENGINE=InnoDB DEFAULT CHARSET=utf8;2-只双休日、假日送货(工作日不用送) ENGINE=InnoDB DEFAULT CHARSET=utf8;3-工作日、双休日与假日均可送货;其他值-返回‘任意时间’） */
    private String deliveryType;

    /** 发票信息 返回‘不需要开具发票’时无需开具发票；其它返回值请正常开具发票 */
    private String invoiceInfo;

    /** 买家下单时订单备注 */
    private String orderRemark;

    /** 	下单时间 */
    private Date orderStartTime;

    /** 结单时间 如返回信息为0001-01-01 00:00:00或1970-01-01 00:00:00等特殊值，可认为此订单为未完成状态。 */
    private Date orderEndTime;

    /** 商家订单备注（不大于500字符）可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String venderRemark;

    /** 余额支付金额 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private BigDecimal balanceUsed;

    /** 是否已经拉过评价 */
    private Boolean pullComment;

    /** 即买家的账号信息 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String pin;

    /** 售后订单标记 0:不是换货订单 1返修发货直接赔偿客服补件 2售后调货 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String returnOrder;

    /** 付款确认时间 如果没有付款时间 默认返回0001-01-01 00:00:00 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private Date paymentConfirmTime;

    /** 运单号，当物流公司是厂家自送时运单号可为空，不同物流公司的运单号用|分隔，如果同一物流公司有多个运单号，则用英文逗号分隔 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String waybill;

    /** 物流公司 */
    private String logisticsName;

    /** 物流公司ID，多个物流公司以|分隔 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String logisticsId;

    /** 订单更新时间 */
    private Date modified;

    /** 父订单号 可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String parentOrderId;

    /** 订单类型（22 SOP；23 LBP ；25 SOPL）可选字段，需要在输入参数optional_fields中写入才能返回 */
    private String orderType;

    /** 京仓订单.如果是京仓订单，结果返回文字“京仓订单”；否则返回结果为空值“” */
    private String storeOrder;

    /** 是否是excel导入 */
    private String isExcelImport;

    /** 商家id */
    private Long sellerId;

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

    /** orderSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderSourceExpression;

    /** 与 max(orderSource) 映射**/
    private Long maxOrderSource;

    /** 与 min(orderSource) 映射**/
    private Long minOrderSource;

    /** 与 avg(orderSource) 映射**/
    private Long avgOrderSource;

    /** 与 count(orderSource) 映射**/
    private Long countOrderSource;

    /** 与 sum(orderSource) 映射**/
    private String sumOrderSource;

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

    /** receiverIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdJdExpression;

    /** 与 max(receiverIdJd) 映射**/
    private Long maxReceiverIdJd;

    /** 与 min(receiverIdJd) 映射**/
    private Long minReceiverIdJd;

    /** 与 avg(receiverIdJd) 映射**/
    private Long avgReceiverIdJd;

    /** 与 count(receiverIdJd) 映射**/
    private Long countReceiverIdJd;

    /** 与 sum(receiverIdJd) 映射**/
    private Long sumReceiverIdJd;

    /** venderId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String venderIdExpression;

    /** 与 max(venderId) 映射**/
    private Long maxVenderId;

    /** 与 min(venderId) 映射**/
    private Long minVenderId;

    /** 与 avg(venderId) 映射**/
    private Long avgVenderId;

    /** 与 count(venderId) 映射**/
    private Long countVenderId;

    /** 与 sum(venderId) 映射**/
    private String sumVenderId;

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

    /** orderTotalPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderTotalPriceExpression;

    /** 与 max(orderTotalPrice) 映射**/
    private Long maxOrderTotalPrice;

    /** 与 min(orderTotalPrice) 映射**/
    private Long minOrderTotalPrice;

    /** 与 avg(orderTotalPrice) 映射**/
    private Long avgOrderTotalPrice;

    /** 与 count(orderTotalPrice) 映射**/
    private Long countOrderTotalPrice;

    /** 与 sum(orderTotalPrice) 映射**/
    private BigDecimal sumOrderTotalPrice;

    /** orderSellerPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderSellerPriceExpression;

    /** 与 max(orderSellerPrice) 映射**/
    private Long maxOrderSellerPrice;

    /** 与 min(orderSellerPrice) 映射**/
    private Long minOrderSellerPrice;

    /** 与 avg(orderSellerPrice) 映射**/
    private Long avgOrderSellerPrice;

    /** 与 count(orderSellerPrice) 映射**/
    private Long countOrderSellerPrice;

    /** 与 sum(orderSellerPrice) 映射**/
    private BigDecimal sumOrderSellerPrice;

    /** orderPayment属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderPaymentExpression;

    /** 与 max(orderPayment) 映射**/
    private Long maxOrderPayment;

    /** 与 min(orderPayment) 映射**/
    private Long minOrderPayment;

    /** 与 avg(orderPayment) 映射**/
    private Long avgOrderPayment;

    /** 与 count(orderPayment) 映射**/
    private Long countOrderPayment;

    /** 与 sum(orderPayment) 映射**/
    private BigDecimal sumOrderPayment;

    /** freightPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String freightPriceExpression;

    /** 与 max(freightPrice) 映射**/
    private Long maxFreightPrice;

    /** 与 min(freightPrice) 映射**/
    private Long minFreightPrice;

    /** 与 avg(freightPrice) 映射**/
    private Long avgFreightPrice;

    /** 与 count(freightPrice) 映射**/
    private Long countFreightPrice;

    /** 与 sum(freightPrice) 映射**/
    private BigDecimal sumFreightPrice;

    /** sellerDiscount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerDiscountExpression;

    /** 与 max(sellerDiscount) 映射**/
    private Long maxSellerDiscount;

    /** 与 min(sellerDiscount) 映射**/
    private Long minSellerDiscount;

    /** 与 avg(sellerDiscount) 映射**/
    private Long avgSellerDiscount;

    /** 与 count(sellerDiscount) 映射**/
    private Long countSellerDiscount;

    /** 与 sum(sellerDiscount) 映射**/
    private BigDecimal sumSellerDiscount;

    /** orderState属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderStateExpression;

    /** 与 max(orderState) 映射**/
    private Long maxOrderState;

    /** 与 min(orderState) 映射**/
    private Long minOrderState;

    /** 与 avg(orderState) 映射**/
    private Long avgOrderState;

    /** 与 count(orderState) 映射**/
    private Long countOrderState;

    /** 与 sum(orderState) 映射**/
    private String sumOrderState;

    /** orderStateRemark属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderStateRemarkExpression;

    /** 与 max(orderStateRemark) 映射**/
    private Long maxOrderStateRemark;

    /** 与 min(orderStateRemark) 映射**/
    private Long minOrderStateRemark;

    /** 与 avg(orderStateRemark) 映射**/
    private Long avgOrderStateRemark;

    /** 与 count(orderStateRemark) 映射**/
    private Long countOrderStateRemark;

    /** 与 sum(orderStateRemark) 映射**/
    private String sumOrderStateRemark;

    /** deliveryType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String deliveryTypeExpression;

    /** 与 max(deliveryType) 映射**/
    private Long maxDeliveryType;

    /** 与 min(deliveryType) 映射**/
    private Long minDeliveryType;

    /** 与 avg(deliveryType) 映射**/
    private Long avgDeliveryType;

    /** 与 count(deliveryType) 映射**/
    private Long countDeliveryType;

    /** 与 sum(deliveryType) 映射**/
    private String sumDeliveryType;

    /** invoiceInfo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String invoiceInfoExpression;

    /** 与 max(invoiceInfo) 映射**/
    private Long maxInvoiceInfo;

    /** 与 min(invoiceInfo) 映射**/
    private Long minInvoiceInfo;

    /** 与 avg(invoiceInfo) 映射**/
    private Long avgInvoiceInfo;

    /** 与 count(invoiceInfo) 映射**/
    private Long countInvoiceInfo;

    /** 与 sum(invoiceInfo) 映射**/
    private String sumInvoiceInfo;

    /** orderRemark属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderRemarkExpression;

    /** 与 max(orderRemark) 映射**/
    private Long maxOrderRemark;

    /** 与 min(orderRemark) 映射**/
    private Long minOrderRemark;

    /** 与 avg(orderRemark) 映射**/
    private Long avgOrderRemark;

    /** 与 count(orderRemark) 映射**/
    private Long countOrderRemark;

    /** 与 sum(orderRemark) 映射**/
    private String sumOrderRemark;

    /** orderStartTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderStartTimeExpression;

    /** 与 max(orderStartTime) 映射**/
    private Long maxOrderStartTime;

    /** 与 min(orderStartTime) 映射**/
    private Long minOrderStartTime;

    /** 与 avg(orderStartTime) 映射**/
    private Long avgOrderStartTime;

    /** 与 count(orderStartTime) 映射**/
    private Long countOrderStartTime;

    /** 与 sum(orderStartTime) 映射**/
    private Date sumOrderStartTime;

    /** orderEndTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderEndTimeExpression;

    /** 与 max(orderEndTime) 映射**/
    private Long maxOrderEndTime;

    /** 与 min(orderEndTime) 映射**/
    private Long minOrderEndTime;

    /** 与 avg(orderEndTime) 映射**/
    private Long avgOrderEndTime;

    /** 与 count(orderEndTime) 映射**/
    private Long countOrderEndTime;

    /** 与 sum(orderEndTime) 映射**/
    private Date sumOrderEndTime;

    /** venderRemark属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String venderRemarkExpression;

    /** 与 max(venderRemark) 映射**/
    private Long maxVenderRemark;

    /** 与 min(venderRemark) 映射**/
    private Long minVenderRemark;

    /** 与 avg(venderRemark) 映射**/
    private Long avgVenderRemark;

    /** 与 count(venderRemark) 映射**/
    private Long countVenderRemark;

    /** 与 sum(venderRemark) 映射**/
    private String sumVenderRemark;

    /** balanceUsed属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String balanceUsedExpression;

    /** 与 max(balanceUsed) 映射**/
    private Long maxBalanceUsed;

    /** 与 min(balanceUsed) 映射**/
    private Long minBalanceUsed;

    /** 与 avg(balanceUsed) 映射**/
    private Long avgBalanceUsed;

    /** 与 count(balanceUsed) 映射**/
    private Long countBalanceUsed;

    /** 与 sum(balanceUsed) 映射**/
    private BigDecimal sumBalanceUsed;

    /** pullComment属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pullCommentExpression;

    /** 与 max(pullComment) 映射**/
    private Long maxPullComment;

    /** 与 min(pullComment) 映射**/
    private Long minPullComment;

    /** 与 avg(pullComment) 映射**/
    private Long avgPullComment;

    /** 与 count(pullComment) 映射**/
    private Long countPullComment;

    /** 与 sum(pullComment) 映射**/
    private Boolean sumPullComment;

    /** pin属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pinExpression;

    /** 与 max(pin) 映射**/
    private Long maxPin;

    /** 与 min(pin) 映射**/
    private Long minPin;

    /** 与 avg(pin) 映射**/
    private Long avgPin;

    /** 与 count(pin) 映射**/
    private Long countPin;

    /** 与 sum(pin) 映射**/
    private String sumPin;

    /** returnOrder属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String returnOrderExpression;

    /** 与 max(returnOrder) 映射**/
    private Long maxReturnOrder;

    /** 与 min(returnOrder) 映射**/
    private Long minReturnOrder;

    /** 与 avg(returnOrder) 映射**/
    private Long avgReturnOrder;

    /** 与 count(returnOrder) 映射**/
    private Long countReturnOrder;

    /** 与 sum(returnOrder) 映射**/
    private String sumReturnOrder;

    /** paymentConfirmTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String paymentConfirmTimeExpression;

    /** 与 max(paymentConfirmTime) 映射**/
    private Long maxPaymentConfirmTime;

    /** 与 min(paymentConfirmTime) 映射**/
    private Long minPaymentConfirmTime;

    /** 与 avg(paymentConfirmTime) 映射**/
    private Long avgPaymentConfirmTime;

    /** 与 count(paymentConfirmTime) 映射**/
    private Long countPaymentConfirmTime;

    /** 与 sum(paymentConfirmTime) 映射**/
    private Date sumPaymentConfirmTime;

    /** waybill属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String waybillExpression;

    /** 与 max(waybill) 映射**/
    private Long maxWaybill;

    /** 与 min(waybill) 映射**/
    private Long minWaybill;

    /** 与 avg(waybill) 映射**/
    private Long avgWaybill;

    /** 与 count(waybill) 映射**/
    private Long countWaybill;

    /** 与 sum(waybill) 映射**/
    private String sumWaybill;

    /** logisticsName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String logisticsNameExpression;

    /** 与 max(logisticsName) 映射**/
    private Long maxLogisticsName;

    /** 与 min(logisticsName) 映射**/
    private Long minLogisticsName;

    /** 与 avg(logisticsName) 映射**/
    private Long avgLogisticsName;

    /** 与 count(logisticsName) 映射**/
    private Long countLogisticsName;

    /** 与 sum(logisticsName) 映射**/
    private String sumLogisticsName;

    /** logisticsId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String logisticsIdExpression;

    /** 与 max(logisticsId) 映射**/
    private Long maxLogisticsId;

    /** 与 min(logisticsId) 映射**/
    private Long minLogisticsId;

    /** 与 avg(logisticsId) 映射**/
    private Long avgLogisticsId;

    /** 与 count(logisticsId) 映射**/
    private Long countLogisticsId;

    /** 与 sum(logisticsId) 映射**/
    private String sumLogisticsId;

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

    /** parentOrderId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String parentOrderIdExpression;

    /** 与 max(parentOrderId) 映射**/
    private Long maxParentOrderId;

    /** 与 min(parentOrderId) 映射**/
    private Long minParentOrderId;

    /** 与 avg(parentOrderId) 映射**/
    private Long avgParentOrderId;

    /** 与 count(parentOrderId) 映射**/
    private Long countParentOrderId;

    /** 与 sum(parentOrderId) 映射**/
    private String sumParentOrderId;

    /** orderType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderTypeExpression;

    /** 与 max(orderType) 映射**/
    private Long maxOrderType;

    /** 与 min(orderType) 映射**/
    private Long minOrderType;

    /** 与 avg(orderType) 映射**/
    private Long avgOrderType;

    /** 与 count(orderType) 映射**/
    private Long countOrderType;

    /** 与 sum(orderType) 映射**/
    private String sumOrderType;

    /** storeOrder属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String storeOrderExpression;

    /** 与 max(storeOrder) 映射**/
    private Long maxStoreOrder;

    /** 与 min(storeOrder) 映射**/
    private Long minStoreOrder;

    /** 与 avg(storeOrder) 映射**/
    private Long avgStoreOrder;

    /** 与 count(storeOrder) 映射**/
    private Long countStoreOrder;

    /** 与 sum(storeOrder) 映射**/
    private String sumStoreOrder;

    /** isExcelImport属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isExcelImportExpression;

    /** 与 max(isExcelImport) 映射**/
    private Long maxIsExcelImport;

    /** 与 min(isExcelImport) 映射**/
    private Long minIsExcelImport;

    /** 与 avg(isExcelImport) 映射**/
    private Long avgIsExcelImport;

    /** 与 count(isExcelImport) 映射**/
    private Long countIsExcelImport;

    /** 与 sum(isExcelImport) 映射**/
    private String sumIsExcelImport;

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

    private List<ItemInfoJD> itemInfoJDList;

    private ReceiverJD receiverJD;
}