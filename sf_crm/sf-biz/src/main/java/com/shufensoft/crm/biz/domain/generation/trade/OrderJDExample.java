package com.shufensoft.crm.biz.domain.generation.trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderJDExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /** 在查询中增加for update 
     * 目前用来支持对查询记录加锁
     **/
    protected boolean forUpdate;

    /** 是否自定义设置查询字段 */
    protected boolean definedQueryColumns;

    /** 设置查询字段 */
    protected List<String> queryColumns;

    public OrderJDExample() {
        oredCriteria = new ArrayList<Criteria>();
        queryColumns = new ArrayList<String>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        forUpdate = false;
        definedQueryColumns = false;
        queryColumns.clear();
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setDefinedQueryColumns(boolean definedQueryColumns) {
        this.definedQueryColumns = definedQueryColumns;
    }

    public boolean isDefinedQueryColumns() {
        return definedQueryColumns;
    }

    public void addIdQueryColumn() {
        this.queryColumns.add("id");
    }

    public void addMaxIdQueryColumn() {
        this.queryColumns.add("max(id) max_id");
    }

    public void addMinIdQueryColumn() {
        this.queryColumns.add("min(id) min_id");
    }

    public void addAvgIdQueryColumn() {
        this.queryColumns.add(" avg(id) avg_id");
    }

    public void addCountIdQueryColumn() {
        this.queryColumns.add(" count(id) count_id");
    }

    public void addSumIdQueryColumn() {
        this.queryColumns.add(" sum(id) sum_id");
    }

    public void addGmtCreatedQueryColumn() {
        this.queryColumns.add("gmt_created");
    }

    public void addMaxGmtCreatedQueryColumn() {
        this.queryColumns.add("max(gmt_created) max_gmt_created");
    }

    public void addMinGmtCreatedQueryColumn() {
        this.queryColumns.add("min(gmt_created) min_gmt_created");
    }

    public void addAvgGmtCreatedQueryColumn() {
        this.queryColumns.add(" avg(gmt_created) avg_gmt_created");
    }

    public void addCountGmtCreatedQueryColumn() {
        this.queryColumns.add(" count(gmt_created) count_gmt_created");
    }

    public void addSumGmtCreatedQueryColumn() {
        this.queryColumns.add(" sum(gmt_created) sum_gmt_created");
    }

    public void addGmtModifiedQueryColumn() {
        this.queryColumns.add("gmt_modified");
    }

    public void addMaxGmtModifiedQueryColumn() {
        this.queryColumns.add("max(gmt_modified) max_gmt_modified");
    }

    public void addMinGmtModifiedQueryColumn() {
        this.queryColumns.add("min(gmt_modified) min_gmt_modified");
    }

    public void addAvgGmtModifiedQueryColumn() {
        this.queryColumns.add(" avg(gmt_modified) avg_gmt_modified");
    }

    public void addCountGmtModifiedQueryColumn() {
        this.queryColumns.add(" count(gmt_modified) count_gmt_modified");
    }

    public void addSumGmtModifiedQueryColumn() {
        this.queryColumns.add(" sum(gmt_modified) sum_gmt_modified");
    }

    public void addIsDeletedQueryColumn() {
        this.queryColumns.add("is_deleted");
    }

    public void addMaxIsDeletedQueryColumn() {
        this.queryColumns.add("max(is_deleted) max_is_deleted");
    }

    public void addMinIsDeletedQueryColumn() {
        this.queryColumns.add("min(is_deleted) min_is_deleted");
    }

    public void addAvgIsDeletedQueryColumn() {
        this.queryColumns.add(" avg(is_deleted) avg_is_deleted");
    }

    public void addCountIsDeletedQueryColumn() {
        this.queryColumns.add(" count(is_deleted) count_is_deleted");
    }

    public void addSumIsDeletedQueryColumn() {
        this.queryColumns.add(" sum(is_deleted) sum_is_deleted");
    }

    public void addOrderIdQueryColumn() {
        this.queryColumns.add("order_id");
    }

    public void addMaxOrderIdQueryColumn() {
        this.queryColumns.add("max(order_id) max_order_id");
    }

    public void addMinOrderIdQueryColumn() {
        this.queryColumns.add("min(order_id) min_order_id");
    }

    public void addAvgOrderIdQueryColumn() {
        this.queryColumns.add(" avg(order_id) avg_order_id");
    }

    public void addCountOrderIdQueryColumn() {
        this.queryColumns.add(" count(order_id) count_order_id");
    }

    public void addSumOrderIdQueryColumn() {
        this.queryColumns.add(" sum(order_id) sum_order_id");
    }

    public void addShopIdQueryColumn() {
        this.queryColumns.add("shop_id");
    }

    public void addMaxShopIdQueryColumn() {
        this.queryColumns.add("max(shop_id) max_shop_id");
    }

    public void addMinShopIdQueryColumn() {
        this.queryColumns.add("min(shop_id) min_shop_id");
    }

    public void addAvgShopIdQueryColumn() {
        this.queryColumns.add(" avg(shop_id) avg_shop_id");
    }

    public void addCountShopIdQueryColumn() {
        this.queryColumns.add(" count(shop_id) count_shop_id");
    }

    public void addSumShopIdQueryColumn() {
        this.queryColumns.add(" sum(shop_id) sum_shop_id");
    }

    public void addOrderSourceQueryColumn() {
        this.queryColumns.add("order_source");
    }

    public void addMaxOrderSourceQueryColumn() {
        this.queryColumns.add("max(order_source) max_order_source");
    }

    public void addMinOrderSourceQueryColumn() {
        this.queryColumns.add("min(order_source) min_order_source");
    }

    public void addAvgOrderSourceQueryColumn() {
        this.queryColumns.add(" avg(order_source) avg_order_source");
    }

    public void addCountOrderSourceQueryColumn() {
        this.queryColumns.add(" count(order_source) count_order_source");
    }

    public void addSumOrderSourceQueryColumn() {
        this.queryColumns.add(" sum(order_source) sum_order_source");
    }

    public void addUserIdJdQueryColumn() {
        this.queryColumns.add("user_id_jd");
    }

    public void addMaxUserIdJdQueryColumn() {
        this.queryColumns.add("max(user_id_jd) max_user_id_jd");
    }

    public void addMinUserIdJdQueryColumn() {
        this.queryColumns.add("min(user_id_jd) min_user_id_jd");
    }

    public void addAvgUserIdJdQueryColumn() {
        this.queryColumns.add(" avg(user_id_jd) avg_user_id_jd");
    }

    public void addCountUserIdJdQueryColumn() {
        this.queryColumns.add(" count(user_id_jd) count_user_id_jd");
    }

    public void addSumUserIdJdQueryColumn() {
        this.queryColumns.add(" sum(user_id_jd) sum_user_id_jd");
    }

    public void addReceiverIdJdQueryColumn() {
        this.queryColumns.add("receiver_id_jd");
    }

    public void addMaxReceiverIdJdQueryColumn() {
        this.queryColumns.add("max(receiver_id_jd) max_receiver_id_jd");
    }

    public void addMinReceiverIdJdQueryColumn() {
        this.queryColumns.add("min(receiver_id_jd) min_receiver_id_jd");
    }

    public void addAvgReceiverIdJdQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_jd) avg_receiver_id_jd");
    }

    public void addCountReceiverIdJdQueryColumn() {
        this.queryColumns.add(" count(receiver_id_jd) count_receiver_id_jd");
    }

    public void addSumReceiverIdJdQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_jd) sum_receiver_id_jd");
    }

    public void addVenderIdQueryColumn() {
        this.queryColumns.add("vender_id");
    }

    public void addMaxVenderIdQueryColumn() {
        this.queryColumns.add("max(vender_id) max_vender_id");
    }

    public void addMinVenderIdQueryColumn() {
        this.queryColumns.add("min(vender_id) min_vender_id");
    }

    public void addAvgVenderIdQueryColumn() {
        this.queryColumns.add(" avg(vender_id) avg_vender_id");
    }

    public void addCountVenderIdQueryColumn() {
        this.queryColumns.add(" count(vender_id) count_vender_id");
    }

    public void addSumVenderIdQueryColumn() {
        this.queryColumns.add(" sum(vender_id) sum_vender_id");
    }

    public void addPayTypeQueryColumn() {
        this.queryColumns.add("pay_type");
    }

    public void addMaxPayTypeQueryColumn() {
        this.queryColumns.add("max(pay_type) max_pay_type");
    }

    public void addMinPayTypeQueryColumn() {
        this.queryColumns.add("min(pay_type) min_pay_type");
    }

    public void addAvgPayTypeQueryColumn() {
        this.queryColumns.add(" avg(pay_type) avg_pay_type");
    }

    public void addCountPayTypeQueryColumn() {
        this.queryColumns.add(" count(pay_type) count_pay_type");
    }

    public void addSumPayTypeQueryColumn() {
        this.queryColumns.add(" sum(pay_type) sum_pay_type");
    }

    public void addOrderTotalPriceQueryColumn() {
        this.queryColumns.add("order_total_price");
    }

    public void addMaxOrderTotalPriceQueryColumn() {
        this.queryColumns.add("max(order_total_price) max_order_total_price");
    }

    public void addMinOrderTotalPriceQueryColumn() {
        this.queryColumns.add("min(order_total_price) min_order_total_price");
    }

    public void addAvgOrderTotalPriceQueryColumn() {
        this.queryColumns.add(" avg(order_total_price) avg_order_total_price");
    }

    public void addCountOrderTotalPriceQueryColumn() {
        this.queryColumns.add(" count(order_total_price) count_order_total_price");
    }

    public void addSumOrderTotalPriceQueryColumn() {
        this.queryColumns.add(" sum(order_total_price) sum_order_total_price");
    }

    public void addOrderSellerPriceQueryColumn() {
        this.queryColumns.add("order_seller_price");
    }

    public void addMaxOrderSellerPriceQueryColumn() {
        this.queryColumns.add("max(order_seller_price) max_order_seller_price");
    }

    public void addMinOrderSellerPriceQueryColumn() {
        this.queryColumns.add("min(order_seller_price) min_order_seller_price");
    }

    public void addAvgOrderSellerPriceQueryColumn() {
        this.queryColumns.add(" avg(order_seller_price) avg_order_seller_price");
    }

    public void addCountOrderSellerPriceQueryColumn() {
        this.queryColumns.add(" count(order_seller_price) count_order_seller_price");
    }

    public void addSumOrderSellerPriceQueryColumn() {
        this.queryColumns.add(" sum(order_seller_price) sum_order_seller_price");
    }

    public void addOrderPaymentQueryColumn() {
        this.queryColumns.add("order_payment");
    }

    public void addMaxOrderPaymentQueryColumn() {
        this.queryColumns.add("max(order_payment) max_order_payment");
    }

    public void addMinOrderPaymentQueryColumn() {
        this.queryColumns.add("min(order_payment) min_order_payment");
    }

    public void addAvgOrderPaymentQueryColumn() {
        this.queryColumns.add(" avg(order_payment) avg_order_payment");
    }

    public void addCountOrderPaymentQueryColumn() {
        this.queryColumns.add(" count(order_payment) count_order_payment");
    }

    public void addSumOrderPaymentQueryColumn() {
        this.queryColumns.add(" sum(order_payment) sum_order_payment");
    }

    public void addFreightPriceQueryColumn() {
        this.queryColumns.add("freight_price");
    }

    public void addMaxFreightPriceQueryColumn() {
        this.queryColumns.add("max(freight_price) max_freight_price");
    }

    public void addMinFreightPriceQueryColumn() {
        this.queryColumns.add("min(freight_price) min_freight_price");
    }

    public void addAvgFreightPriceQueryColumn() {
        this.queryColumns.add(" avg(freight_price) avg_freight_price");
    }

    public void addCountFreightPriceQueryColumn() {
        this.queryColumns.add(" count(freight_price) count_freight_price");
    }

    public void addSumFreightPriceQueryColumn() {
        this.queryColumns.add(" sum(freight_price) sum_freight_price");
    }

    public void addSellerDiscountQueryColumn() {
        this.queryColumns.add("seller_discount");
    }

    public void addMaxSellerDiscountQueryColumn() {
        this.queryColumns.add("max(seller_discount) max_seller_discount");
    }

    public void addMinSellerDiscountQueryColumn() {
        this.queryColumns.add("min(seller_discount) min_seller_discount");
    }

    public void addAvgSellerDiscountQueryColumn() {
        this.queryColumns.add(" avg(seller_discount) avg_seller_discount");
    }

    public void addCountSellerDiscountQueryColumn() {
        this.queryColumns.add(" count(seller_discount) count_seller_discount");
    }

    public void addSumSellerDiscountQueryColumn() {
        this.queryColumns.add(" sum(seller_discount) sum_seller_discount");
    }

    public void addOrderStateQueryColumn() {
        this.queryColumns.add("order_state");
    }

    public void addMaxOrderStateQueryColumn() {
        this.queryColumns.add("max(order_state) max_order_state");
    }

    public void addMinOrderStateQueryColumn() {
        this.queryColumns.add("min(order_state) min_order_state");
    }

    public void addAvgOrderStateQueryColumn() {
        this.queryColumns.add(" avg(order_state) avg_order_state");
    }

    public void addCountOrderStateQueryColumn() {
        this.queryColumns.add(" count(order_state) count_order_state");
    }

    public void addSumOrderStateQueryColumn() {
        this.queryColumns.add(" sum(order_state) sum_order_state");
    }

    public void addOrderStateRemarkQueryColumn() {
        this.queryColumns.add("order_state_remark");
    }

    public void addMaxOrderStateRemarkQueryColumn() {
        this.queryColumns.add("max(order_state_remark) max_order_state_remark");
    }

    public void addMinOrderStateRemarkQueryColumn() {
        this.queryColumns.add("min(order_state_remark) min_order_state_remark");
    }

    public void addAvgOrderStateRemarkQueryColumn() {
        this.queryColumns.add(" avg(order_state_remark) avg_order_state_remark");
    }

    public void addCountOrderStateRemarkQueryColumn() {
        this.queryColumns.add(" count(order_state_remark) count_order_state_remark");
    }

    public void addSumOrderStateRemarkQueryColumn() {
        this.queryColumns.add(" sum(order_state_remark) sum_order_state_remark");
    }

    public void addDeliveryTypeQueryColumn() {
        this.queryColumns.add("delivery_type");
    }

    public void addMaxDeliveryTypeQueryColumn() {
        this.queryColumns.add("max(delivery_type) max_delivery_type");
    }

    public void addMinDeliveryTypeQueryColumn() {
        this.queryColumns.add("min(delivery_type) min_delivery_type");
    }

    public void addAvgDeliveryTypeQueryColumn() {
        this.queryColumns.add(" avg(delivery_type) avg_delivery_type");
    }

    public void addCountDeliveryTypeQueryColumn() {
        this.queryColumns.add(" count(delivery_type) count_delivery_type");
    }

    public void addSumDeliveryTypeQueryColumn() {
        this.queryColumns.add(" sum(delivery_type) sum_delivery_type");
    }

    public void addInvoiceInfoQueryColumn() {
        this.queryColumns.add("invoice_info");
    }

    public void addMaxInvoiceInfoQueryColumn() {
        this.queryColumns.add("max(invoice_info) max_invoice_info");
    }

    public void addMinInvoiceInfoQueryColumn() {
        this.queryColumns.add("min(invoice_info) min_invoice_info");
    }

    public void addAvgInvoiceInfoQueryColumn() {
        this.queryColumns.add(" avg(invoice_info) avg_invoice_info");
    }

    public void addCountInvoiceInfoQueryColumn() {
        this.queryColumns.add(" count(invoice_info) count_invoice_info");
    }

    public void addSumInvoiceInfoQueryColumn() {
        this.queryColumns.add(" sum(invoice_info) sum_invoice_info");
    }

    public void addOrderRemarkQueryColumn() {
        this.queryColumns.add("order_remark");
    }

    public void addMaxOrderRemarkQueryColumn() {
        this.queryColumns.add("max(order_remark) max_order_remark");
    }

    public void addMinOrderRemarkQueryColumn() {
        this.queryColumns.add("min(order_remark) min_order_remark");
    }

    public void addAvgOrderRemarkQueryColumn() {
        this.queryColumns.add(" avg(order_remark) avg_order_remark");
    }

    public void addCountOrderRemarkQueryColumn() {
        this.queryColumns.add(" count(order_remark) count_order_remark");
    }

    public void addSumOrderRemarkQueryColumn() {
        this.queryColumns.add(" sum(order_remark) sum_order_remark");
    }

    public void addOrderStartTimeQueryColumn() {
        this.queryColumns.add("order_start_time");
    }

    public void addMaxOrderStartTimeQueryColumn() {
        this.queryColumns.add("max(order_start_time) max_order_start_time");
    }

    public void addMinOrderStartTimeQueryColumn() {
        this.queryColumns.add("min(order_start_time) min_order_start_time");
    }

    public void addAvgOrderStartTimeQueryColumn() {
        this.queryColumns.add(" avg(order_start_time) avg_order_start_time");
    }

    public void addCountOrderStartTimeQueryColumn() {
        this.queryColumns.add(" count(order_start_time) count_order_start_time");
    }

    public void addSumOrderStartTimeQueryColumn() {
        this.queryColumns.add(" sum(order_start_time) sum_order_start_time");
    }

    public void addOrderEndTimeQueryColumn() {
        this.queryColumns.add("order_end_time");
    }

    public void addMaxOrderEndTimeQueryColumn() {
        this.queryColumns.add("max(order_end_time) max_order_end_time");
    }

    public void addMinOrderEndTimeQueryColumn() {
        this.queryColumns.add("min(order_end_time) min_order_end_time");
    }

    public void addAvgOrderEndTimeQueryColumn() {
        this.queryColumns.add(" avg(order_end_time) avg_order_end_time");
    }

    public void addCountOrderEndTimeQueryColumn() {
        this.queryColumns.add(" count(order_end_time) count_order_end_time");
    }

    public void addSumOrderEndTimeQueryColumn() {
        this.queryColumns.add(" sum(order_end_time) sum_order_end_time");
    }

    public void addVenderRemarkQueryColumn() {
        this.queryColumns.add("vender_remark");
    }

    public void addMaxVenderRemarkQueryColumn() {
        this.queryColumns.add("max(vender_remark) max_vender_remark");
    }

    public void addMinVenderRemarkQueryColumn() {
        this.queryColumns.add("min(vender_remark) min_vender_remark");
    }

    public void addAvgVenderRemarkQueryColumn() {
        this.queryColumns.add(" avg(vender_remark) avg_vender_remark");
    }

    public void addCountVenderRemarkQueryColumn() {
        this.queryColumns.add(" count(vender_remark) count_vender_remark");
    }

    public void addSumVenderRemarkQueryColumn() {
        this.queryColumns.add(" sum(vender_remark) sum_vender_remark");
    }

    public void addBalanceUsedQueryColumn() {
        this.queryColumns.add("balance_used");
    }

    public void addMaxBalanceUsedQueryColumn() {
        this.queryColumns.add("max(balance_used) max_balance_used");
    }

    public void addMinBalanceUsedQueryColumn() {
        this.queryColumns.add("min(balance_used) min_balance_used");
    }

    public void addAvgBalanceUsedQueryColumn() {
        this.queryColumns.add(" avg(balance_used) avg_balance_used");
    }

    public void addCountBalanceUsedQueryColumn() {
        this.queryColumns.add(" count(balance_used) count_balance_used");
    }

    public void addSumBalanceUsedQueryColumn() {
        this.queryColumns.add(" sum(balance_used) sum_balance_used");
    }

    public void addPullCommentQueryColumn() {
        this.queryColumns.add("pull_comment");
    }

    public void addMaxPullCommentQueryColumn() {
        this.queryColumns.add("max(pull_comment) max_pull_comment");
    }

    public void addMinPullCommentQueryColumn() {
        this.queryColumns.add("min(pull_comment) min_pull_comment");
    }

    public void addAvgPullCommentQueryColumn() {
        this.queryColumns.add(" avg(pull_comment) avg_pull_comment");
    }

    public void addCountPullCommentQueryColumn() {
        this.queryColumns.add(" count(pull_comment) count_pull_comment");
    }

    public void addSumPullCommentQueryColumn() {
        this.queryColumns.add(" sum(pull_comment) sum_pull_comment");
    }

    public void addPinQueryColumn() {
        this.queryColumns.add("pin");
    }

    public void addMaxPinQueryColumn() {
        this.queryColumns.add("max(pin) max_pin");
    }

    public void addMinPinQueryColumn() {
        this.queryColumns.add("min(pin) min_pin");
    }

    public void addAvgPinQueryColumn() {
        this.queryColumns.add(" avg(pin) avg_pin");
    }

    public void addCountPinQueryColumn() {
        this.queryColumns.add(" count(pin) count_pin");
    }

    public void addSumPinQueryColumn() {
        this.queryColumns.add(" sum(pin) sum_pin");
    }

    public void addReturnOrderQueryColumn() {
        this.queryColumns.add("return_order");
    }

    public void addMaxReturnOrderQueryColumn() {
        this.queryColumns.add("max(return_order) max_return_order");
    }

    public void addMinReturnOrderQueryColumn() {
        this.queryColumns.add("min(return_order) min_return_order");
    }

    public void addAvgReturnOrderQueryColumn() {
        this.queryColumns.add(" avg(return_order) avg_return_order");
    }

    public void addCountReturnOrderQueryColumn() {
        this.queryColumns.add(" count(return_order) count_return_order");
    }

    public void addSumReturnOrderQueryColumn() {
        this.queryColumns.add(" sum(return_order) sum_return_order");
    }

    public void addPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add("payment_confirm_time");
    }

    public void addMaxPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add("max(payment_confirm_time) max_payment_confirm_time");
    }

    public void addMinPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add("min(payment_confirm_time) min_payment_confirm_time");
    }

    public void addAvgPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add(" avg(payment_confirm_time) avg_payment_confirm_time");
    }

    public void addCountPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add(" count(payment_confirm_time) count_payment_confirm_time");
    }

    public void addSumPaymentConfirmTimeQueryColumn() {
        this.queryColumns.add(" sum(payment_confirm_time) sum_payment_confirm_time");
    }

    public void addWaybillQueryColumn() {
        this.queryColumns.add("waybill");
    }

    public void addMaxWaybillQueryColumn() {
        this.queryColumns.add("max(waybill) max_waybill");
    }

    public void addMinWaybillQueryColumn() {
        this.queryColumns.add("min(waybill) min_waybill");
    }

    public void addAvgWaybillQueryColumn() {
        this.queryColumns.add(" avg(waybill) avg_waybill");
    }

    public void addCountWaybillQueryColumn() {
        this.queryColumns.add(" count(waybill) count_waybill");
    }

    public void addSumWaybillQueryColumn() {
        this.queryColumns.add(" sum(waybill) sum_waybill");
    }

    public void addLogisticsNameQueryColumn() {
        this.queryColumns.add("logistics_name");
    }

    public void addMaxLogisticsNameQueryColumn() {
        this.queryColumns.add("max(logistics_name) max_logistics_name");
    }

    public void addMinLogisticsNameQueryColumn() {
        this.queryColumns.add("min(logistics_name) min_logistics_name");
    }

    public void addAvgLogisticsNameQueryColumn() {
        this.queryColumns.add(" avg(logistics_name) avg_logistics_name");
    }

    public void addCountLogisticsNameQueryColumn() {
        this.queryColumns.add(" count(logistics_name) count_logistics_name");
    }

    public void addSumLogisticsNameQueryColumn() {
        this.queryColumns.add(" sum(logistics_name) sum_logistics_name");
    }

    public void addLogisticsIdQueryColumn() {
        this.queryColumns.add("logistics_id");
    }

    public void addMaxLogisticsIdQueryColumn() {
        this.queryColumns.add("max(logistics_id) max_logistics_id");
    }

    public void addMinLogisticsIdQueryColumn() {
        this.queryColumns.add("min(logistics_id) min_logistics_id");
    }

    public void addAvgLogisticsIdQueryColumn() {
        this.queryColumns.add(" avg(logistics_id) avg_logistics_id");
    }

    public void addCountLogisticsIdQueryColumn() {
        this.queryColumns.add(" count(logistics_id) count_logistics_id");
    }

    public void addSumLogisticsIdQueryColumn() {
        this.queryColumns.add(" sum(logistics_id) sum_logistics_id");
    }

    public void addModifiedQueryColumn() {
        this.queryColumns.add("modified");
    }

    public void addMaxModifiedQueryColumn() {
        this.queryColumns.add("max(modified) max_modified");
    }

    public void addMinModifiedQueryColumn() {
        this.queryColumns.add("min(modified) min_modified");
    }

    public void addAvgModifiedQueryColumn() {
        this.queryColumns.add(" avg(modified) avg_modified");
    }

    public void addCountModifiedQueryColumn() {
        this.queryColumns.add(" count(modified) count_modified");
    }

    public void addSumModifiedQueryColumn() {
        this.queryColumns.add(" sum(modified) sum_modified");
    }

    public void addParentOrderIdQueryColumn() {
        this.queryColumns.add("parent_order_id");
    }

    public void addMaxParentOrderIdQueryColumn() {
        this.queryColumns.add("max(parent_order_id) max_parent_order_id");
    }

    public void addMinParentOrderIdQueryColumn() {
        this.queryColumns.add("min(parent_order_id) min_parent_order_id");
    }

    public void addAvgParentOrderIdQueryColumn() {
        this.queryColumns.add(" avg(parent_order_id) avg_parent_order_id");
    }

    public void addCountParentOrderIdQueryColumn() {
        this.queryColumns.add(" count(parent_order_id) count_parent_order_id");
    }

    public void addSumParentOrderIdQueryColumn() {
        this.queryColumns.add(" sum(parent_order_id) sum_parent_order_id");
    }

    public void addOrderTypeQueryColumn() {
        this.queryColumns.add("order_type");
    }

    public void addMaxOrderTypeQueryColumn() {
        this.queryColumns.add("max(order_type) max_order_type");
    }

    public void addMinOrderTypeQueryColumn() {
        this.queryColumns.add("min(order_type) min_order_type");
    }

    public void addAvgOrderTypeQueryColumn() {
        this.queryColumns.add(" avg(order_type) avg_order_type");
    }

    public void addCountOrderTypeQueryColumn() {
        this.queryColumns.add(" count(order_type) count_order_type");
    }

    public void addSumOrderTypeQueryColumn() {
        this.queryColumns.add(" sum(order_type) sum_order_type");
    }

    public void addStoreOrderQueryColumn() {
        this.queryColumns.add("store_order");
    }

    public void addMaxStoreOrderQueryColumn() {
        this.queryColumns.add("max(store_order) max_store_order");
    }

    public void addMinStoreOrderQueryColumn() {
        this.queryColumns.add("min(store_order) min_store_order");
    }

    public void addAvgStoreOrderQueryColumn() {
        this.queryColumns.add(" avg(store_order) avg_store_order");
    }

    public void addCountStoreOrderQueryColumn() {
        this.queryColumns.add(" count(store_order) count_store_order");
    }

    public void addSumStoreOrderQueryColumn() {
        this.queryColumns.add(" sum(store_order) sum_store_order");
    }

    public void addIsExcelImportQueryColumn() {
        this.queryColumns.add("is_excel_import");
    }

    public void addMaxIsExcelImportQueryColumn() {
        this.queryColumns.add("max(is_excel_import) max_is_excel_import");
    }

    public void addMinIsExcelImportQueryColumn() {
        this.queryColumns.add("min(is_excel_import) min_is_excel_import");
    }

    public void addAvgIsExcelImportQueryColumn() {
        this.queryColumns.add(" avg(is_excel_import) avg_is_excel_import");
    }

    public void addCountIsExcelImportQueryColumn() {
        this.queryColumns.add(" count(is_excel_import) count_is_excel_import");
    }

    public void addSumIsExcelImportQueryColumn() {
        this.queryColumns.add(" sum(is_excel_import) sum_is_excel_import");
    }

    public void addSellerIdQueryColumn() {
        this.queryColumns.add("seller_id");
    }

    public void addMaxSellerIdQueryColumn() {
        this.queryColumns.add("max(seller_id) max_seller_id");
    }

    public void addMinSellerIdQueryColumn() {
        this.queryColumns.add("min(seller_id) min_seller_id");
    }

    public void addAvgSellerIdQueryColumn() {
        this.queryColumns.add(" avg(seller_id) avg_seller_id");
    }

    public void addCountSellerIdQueryColumn() {
        this.queryColumns.add(" count(seller_id) count_seller_id");
    }

    public void addSumSellerIdQueryColumn() {
        this.queryColumns.add(" sum(seller_id) sum_seller_id");
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceEqualTo(String value) {
            addCriterion("order_source =", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotEqualTo(String value) {
            addCriterion("order_source <>", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThan(String value) {
            addCriterion("order_source >", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(String value) {
            addCriterion("order_source >=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThan(String value) {
            addCriterion("order_source <", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThanOrEqualTo(String value) {
            addCriterion("order_source <=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLike(String value) {
            addCriterion("order_source like", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotLike(String value) {
            addCriterion("order_source not like", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIn(List<String> values) {
            addCriterion("order_source in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotIn(List<String> values) {
            addCriterion("order_source not in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceBetween(String value1, String value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotBetween(String value1, String value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andUserIdJdIsNull() {
            addCriterion("user_id_jd is null");
            return (Criteria) this;
        }

        public Criteria andUserIdJdIsNotNull() {
            addCriterion("user_id_jd is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdJdEqualTo(Long value) {
            addCriterion("user_id_jd =", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotEqualTo(Long value) {
            addCriterion("user_id_jd <>", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdGreaterThan(Long value) {
            addCriterion("user_id_jd >", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_jd >=", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdLessThan(Long value) {
            addCriterion("user_id_jd <", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdLessThanOrEqualTo(Long value) {
            addCriterion("user_id_jd <=", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdIn(List<Long> values) {
            addCriterion("user_id_jd in", values, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotIn(List<Long> values) {
            addCriterion("user_id_jd not in", values, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdBetween(Long value1, Long value2) {
            addCriterion("user_id_jd between", value1, value2, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotBetween(Long value1, Long value2) {
            addCriterion("user_id_jd not between", value1, value2, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdIsNull() {
            addCriterion("receiver_id_jd is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdIsNotNull() {
            addCriterion("receiver_id_jd is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdEqualTo(Long value) {
            addCriterion("receiver_id_jd =", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotEqualTo(Long value) {
            addCriterion("receiver_id_jd <>", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdGreaterThan(Long value) {
            addCriterion("receiver_id_jd >", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_jd >=", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdLessThan(Long value) {
            addCriterion("receiver_id_jd <", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_jd <=", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdIn(List<Long> values) {
            addCriterion("receiver_id_jd in", values, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotIn(List<Long> values) {
            addCriterion("receiver_id_jd not in", values, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdBetween(Long value1, Long value2) {
            addCriterion("receiver_id_jd between", value1, value2, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_jd not between", value1, value2, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andVenderIdIsNull() {
            addCriterion("vender_id is null");
            return (Criteria) this;
        }

        public Criteria andVenderIdIsNotNull() {
            addCriterion("vender_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenderIdEqualTo(String value) {
            addCriterion("vender_id =", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotEqualTo(String value) {
            addCriterion("vender_id <>", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdGreaterThan(String value) {
            addCriterion("vender_id >", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdGreaterThanOrEqualTo(String value) {
            addCriterion("vender_id >=", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdLessThan(String value) {
            addCriterion("vender_id <", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdLessThanOrEqualTo(String value) {
            addCriterion("vender_id <=", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdLike(String value) {
            addCriterion("vender_id like", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotLike(String value) {
            addCriterion("vender_id not like", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdIn(List<String> values) {
            addCriterion("vender_id in", values, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotIn(List<String> values) {
            addCriterion("vender_id not in", values, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdBetween(String value1, String value2) {
            addCriterion("vender_id between", value1, value2, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotBetween(String value1, String value2) {
            addCriterion("vender_id not between", value1, value2, "venderId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIsNull() {
            addCriterion("order_total_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIsNotNull() {
            addCriterion("order_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceEqualTo(BigDecimal value) {
            addCriterion("order_total_price =", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_total_price <>", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("order_total_price >", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_price >=", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceLessThan(BigDecimal value) {
            addCriterion("order_total_price <", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_total_price <=", value, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceIn(List<BigDecimal> values) {
            addCriterion("order_total_price in", values, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_total_price not in", values, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_price between", value1, value2, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_total_price not between", value1, value2, "orderTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceIsNull() {
            addCriterion("order_seller_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceIsNotNull() {
            addCriterion("order_seller_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceEqualTo(BigDecimal value) {
            addCriterion("order_seller_price =", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_seller_price <>", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceGreaterThan(BigDecimal value) {
            addCriterion("order_seller_price >", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_seller_price >=", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceLessThan(BigDecimal value) {
            addCriterion("order_seller_price <", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_seller_price <=", value, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceIn(List<BigDecimal> values) {
            addCriterion("order_seller_price in", values, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_seller_price not in", values, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_seller_price between", value1, value2, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSellerPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_seller_price not between", value1, value2, "orderSellerPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentIsNull() {
            addCriterion("order_payment is null");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentIsNotNull() {
            addCriterion("order_payment is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentEqualTo(BigDecimal value) {
            addCriterion("order_payment =", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentNotEqualTo(BigDecimal value) {
            addCriterion("order_payment <>", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentGreaterThan(BigDecimal value) {
            addCriterion("order_payment >", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_payment >=", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentLessThan(BigDecimal value) {
            addCriterion("order_payment <", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_payment <=", value, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentIn(List<BigDecimal> values) {
            addCriterion("order_payment in", values, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentNotIn(List<BigDecimal> values) {
            addCriterion("order_payment not in", values, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_payment between", value1, value2, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andOrderPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_payment not between", value1, value2, "orderPayment");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIsNull() {
            addCriterion("freight_price is null");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIsNotNull() {
            addCriterion("freight_price is not null");
            return (Criteria) this;
        }

        public Criteria andFreightPriceEqualTo(BigDecimal value) {
            addCriterion("freight_price =", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotEqualTo(BigDecimal value) {
            addCriterion("freight_price <>", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceGreaterThan(BigDecimal value) {
            addCriterion("freight_price >", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_price >=", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceLessThan(BigDecimal value) {
            addCriterion("freight_price <", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_price <=", value, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceIn(List<BigDecimal> values) {
            addCriterion("freight_price in", values, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotIn(List<BigDecimal> values) {
            addCriterion("freight_price not in", values, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_price between", value1, value2, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andFreightPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_price not between", value1, value2, "freightPrice");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountIsNull() {
            addCriterion("seller_discount is null");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountIsNotNull() {
            addCriterion("seller_discount is not null");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountEqualTo(BigDecimal value) {
            addCriterion("seller_discount =", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountNotEqualTo(BigDecimal value) {
            addCriterion("seller_discount <>", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountGreaterThan(BigDecimal value) {
            addCriterion("seller_discount >", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seller_discount >=", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountLessThan(BigDecimal value) {
            addCriterion("seller_discount <", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seller_discount <=", value, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountIn(List<BigDecimal> values) {
            addCriterion("seller_discount in", values, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountNotIn(List<BigDecimal> values) {
            addCriterion("seller_discount not in", values, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seller_discount between", value1, value2, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andSellerDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seller_discount not between", value1, value2, "sellerDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("order_state like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("order_state not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkIsNull() {
            addCriterion("order_state_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkIsNotNull() {
            addCriterion("order_state_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkEqualTo(String value) {
            addCriterion("order_state_remark =", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkNotEqualTo(String value) {
            addCriterion("order_state_remark <>", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkGreaterThan(String value) {
            addCriterion("order_state_remark >", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_state_remark >=", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkLessThan(String value) {
            addCriterion("order_state_remark <", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_state_remark <=", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkLike(String value) {
            addCriterion("order_state_remark like", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkNotLike(String value) {
            addCriterion("order_state_remark not like", value, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkIn(List<String> values) {
            addCriterion("order_state_remark in", values, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkNotIn(List<String> values) {
            addCriterion("order_state_remark not in", values, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkBetween(String value1, String value2) {
            addCriterion("order_state_remark between", value1, value2, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStateRemarkNotBetween(String value1, String value2) {
            addCriterion("order_state_remark not between", value1, value2, "orderStateRemark");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("delivery_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("delivery_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(String value) {
            addCriterion("delivery_type =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(String value) {
            addCriterion("delivery_type <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(String value) {
            addCriterion("delivery_type >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_type >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(String value) {
            addCriterion("delivery_type <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(String value) {
            addCriterion("delivery_type <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLike(String value) {
            addCriterion("delivery_type like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotLike(String value) {
            addCriterion("delivery_type not like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<String> values) {
            addCriterion("delivery_type in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<String> values) {
            addCriterion("delivery_type not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(String value1, String value2) {
            addCriterion("delivery_type between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(String value1, String value2) {
            addCriterion("delivery_type not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoIsNull() {
            addCriterion("invoice_info is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoIsNotNull() {
            addCriterion("invoice_info is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoEqualTo(String value) {
            addCriterion("invoice_info =", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotEqualTo(String value) {
            addCriterion("invoice_info <>", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoGreaterThan(String value) {
            addCriterion("invoice_info >", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_info >=", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLessThan(String value) {
            addCriterion("invoice_info <", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLessThanOrEqualTo(String value) {
            addCriterion("invoice_info <=", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLike(String value) {
            addCriterion("invoice_info like", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotLike(String value) {
            addCriterion("invoice_info not like", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoIn(List<String> values) {
            addCriterion("invoice_info in", values, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotIn(List<String> values) {
            addCriterion("invoice_info not in", values, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoBetween(String value1, String value2) {
            addCriterion("invoice_info between", value1, value2, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotBetween(String value1, String value2) {
            addCriterion("invoice_info not between", value1, value2, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNull() {
            addCriterion("order_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIsNotNull() {
            addCriterion("order_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkEqualTo(String value) {
            addCriterion("order_remark =", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotEqualTo(String value) {
            addCriterion("order_remark <>", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThan(String value) {
            addCriterion("order_remark >", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_remark >=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThan(String value) {
            addCriterion("order_remark <", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_remark <=", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkLike(String value) {
            addCriterion("order_remark like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotLike(String value) {
            addCriterion("order_remark not like", value, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkIn(List<String> values) {
            addCriterion("order_remark in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotIn(List<String> values) {
            addCriterion("order_remark not in", values, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkBetween(String value1, String value2) {
            addCriterion("order_remark between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderRemarkNotBetween(String value1, String value2) {
            addCriterion("order_remark not between", value1, value2, "orderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeIsNull() {
            addCriterion("order_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeIsNotNull() {
            addCriterion("order_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeEqualTo(Date value) {
            addCriterion("order_start_time =", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeNotEqualTo(Date value) {
            addCriterion("order_start_time <>", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeGreaterThan(Date value) {
            addCriterion("order_start_time >", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_start_time >=", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeLessThan(Date value) {
            addCriterion("order_start_time <", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_start_time <=", value, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeIn(List<Date> values) {
            addCriterion("order_start_time in", values, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeNotIn(List<Date> values) {
            addCriterion("order_start_time not in", values, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeBetween(Date value1, Date value2) {
            addCriterion("order_start_time between", value1, value2, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_start_time not between", value1, value2, "orderStartTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIsNull() {
            addCriterion("order_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIsNotNull() {
            addCriterion("order_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeEqualTo(Date value) {
            addCriterion("order_end_time =", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotEqualTo(Date value) {
            addCriterion("order_end_time <>", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeGreaterThan(Date value) {
            addCriterion("order_end_time >", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_end_time >=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeLessThan(Date value) {
            addCriterion("order_end_time <", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_end_time <=", value, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeIn(List<Date> values) {
            addCriterion("order_end_time in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotIn(List<Date> values) {
            addCriterion("order_end_time not in", values, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeBetween(Date value1, Date value2) {
            addCriterion("order_end_time between", value1, value2, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andOrderEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_end_time not between", value1, value2, "orderEndTime");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNull() {
            addCriterion("vender_remark is null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNotNull() {
            addCriterion("vender_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkEqualTo(String value) {
            addCriterion("vender_remark =", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotEqualTo(String value) {
            addCriterion("vender_remark <>", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThan(String value) {
            addCriterion("vender_remark >", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("vender_remark >=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThan(String value) {
            addCriterion("vender_remark <", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThanOrEqualTo(String value) {
            addCriterion("vender_remark <=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLike(String value) {
            addCriterion("vender_remark like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotLike(String value) {
            addCriterion("vender_remark not like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIn(List<String> values) {
            addCriterion("vender_remark in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotIn(List<String> values) {
            addCriterion("vender_remark not in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkBetween(String value1, String value2) {
            addCriterion("vender_remark between", value1, value2, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotBetween(String value1, String value2) {
            addCriterion("vender_remark not between", value1, value2, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedIsNull() {
            addCriterion("balance_used is null");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedIsNotNull() {
            addCriterion("balance_used is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedEqualTo(BigDecimal value) {
            addCriterion("balance_used =", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedNotEqualTo(BigDecimal value) {
            addCriterion("balance_used <>", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedGreaterThan(BigDecimal value) {
            addCriterion("balance_used >", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_used >=", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedLessThan(BigDecimal value) {
            addCriterion("balance_used <", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_used <=", value, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedIn(List<BigDecimal> values) {
            addCriterion("balance_used in", values, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedNotIn(List<BigDecimal> values) {
            addCriterion("balance_used not in", values, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_used between", value1, value2, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_used not between", value1, value2, "balanceUsed");
            return (Criteria) this;
        }

        public Criteria andPullCommentIsNull() {
            addCriterion("pull_comment is null");
            return (Criteria) this;
        }

        public Criteria andPullCommentIsNotNull() {
            addCriterion("pull_comment is not null");
            return (Criteria) this;
        }

        public Criteria andPullCommentEqualTo(Boolean value) {
            addCriterion("pull_comment =", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentNotEqualTo(Boolean value) {
            addCriterion("pull_comment <>", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentGreaterThan(Boolean value) {
            addCriterion("pull_comment >", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pull_comment >=", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentLessThan(Boolean value) {
            addCriterion("pull_comment <", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("pull_comment <=", value, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentIn(List<Boolean> values) {
            addCriterion("pull_comment in", values, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentNotIn(List<Boolean> values) {
            addCriterion("pull_comment not in", values, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("pull_comment between", value1, value2, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPullCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pull_comment not between", value1, value2, "pullComment");
            return (Criteria) this;
        }

        public Criteria andPinIsNull() {
            addCriterion("pin is null");
            return (Criteria) this;
        }

        public Criteria andPinIsNotNull() {
            addCriterion("pin is not null");
            return (Criteria) this;
        }

        public Criteria andPinEqualTo(String value) {
            addCriterion("pin =", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotEqualTo(String value) {
            addCriterion("pin <>", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThan(String value) {
            addCriterion("pin >", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThanOrEqualTo(String value) {
            addCriterion("pin >=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThan(String value) {
            addCriterion("pin <", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThanOrEqualTo(String value) {
            addCriterion("pin <=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLike(String value) {
            addCriterion("pin like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotLike(String value) {
            addCriterion("pin not like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinIn(List<String> values) {
            addCriterion("pin in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotIn(List<String> values) {
            addCriterion("pin not in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinBetween(String value1, String value2) {
            addCriterion("pin between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotBetween(String value1, String value2) {
            addCriterion("pin not between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andReturnOrderIsNull() {
            addCriterion("return_order is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderIsNotNull() {
            addCriterion("return_order is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderEqualTo(String value) {
            addCriterion("return_order =", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderNotEqualTo(String value) {
            addCriterion("return_order <>", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderGreaterThan(String value) {
            addCriterion("return_order >", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderGreaterThanOrEqualTo(String value) {
            addCriterion("return_order >=", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderLessThan(String value) {
            addCriterion("return_order <", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderLessThanOrEqualTo(String value) {
            addCriterion("return_order <=", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderLike(String value) {
            addCriterion("return_order like", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderNotLike(String value) {
            addCriterion("return_order not like", value, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderIn(List<String> values) {
            addCriterion("return_order in", values, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderNotIn(List<String> values) {
            addCriterion("return_order not in", values, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderBetween(String value1, String value2) {
            addCriterion("return_order between", value1, value2, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andReturnOrderNotBetween(String value1, String value2) {
            addCriterion("return_order not between", value1, value2, "returnOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeIsNull() {
            addCriterion("payment_confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeIsNotNull() {
            addCriterion("payment_confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeEqualTo(Date value) {
            addCriterion("payment_confirm_time =", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeNotEqualTo(Date value) {
            addCriterion("payment_confirm_time <>", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeGreaterThan(Date value) {
            addCriterion("payment_confirm_time >", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_confirm_time >=", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeLessThan(Date value) {
            addCriterion("payment_confirm_time <", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_confirm_time <=", value, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeIn(List<Date> values) {
            addCriterion("payment_confirm_time in", values, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeNotIn(List<Date> values) {
            addCriterion("payment_confirm_time not in", values, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeBetween(Date value1, Date value2) {
            addCriterion("payment_confirm_time between", value1, value2, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andPaymentConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_confirm_time not between", value1, value2, "paymentConfirmTime");
            return (Criteria) this;
        }

        public Criteria andWaybillIsNull() {
            addCriterion("waybill is null");
            return (Criteria) this;
        }

        public Criteria andWaybillIsNotNull() {
            addCriterion("waybill is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillEqualTo(String value) {
            addCriterion("waybill =", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotEqualTo(String value) {
            addCriterion("waybill <>", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillGreaterThan(String value) {
            addCriterion("waybill >", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillGreaterThanOrEqualTo(String value) {
            addCriterion("waybill >=", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLessThan(String value) {
            addCriterion("waybill <", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLessThanOrEqualTo(String value) {
            addCriterion("waybill <=", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillLike(String value) {
            addCriterion("waybill like", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotLike(String value) {
            addCriterion("waybill not like", value, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillIn(List<String> values) {
            addCriterion("waybill in", values, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotIn(List<String> values) {
            addCriterion("waybill not in", values, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillBetween(String value1, String value2) {
            addCriterion("waybill between", value1, value2, "waybill");
            return (Criteria) this;
        }

        public Criteria andWaybillNotBetween(String value1, String value2) {
            addCriterion("waybill not between", value1, value2, "waybill");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIsNull() {
            addCriterion("logistics_name is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIsNotNull() {
            addCriterion("logistics_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameEqualTo(String value) {
            addCriterion("logistics_name =", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotEqualTo(String value) {
            addCriterion("logistics_name <>", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThan(String value) {
            addCriterion("logistics_name >", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_name >=", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThan(String value) {
            addCriterion("logistics_name <", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_name <=", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLike(String value) {
            addCriterion("logistics_name like", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotLike(String value) {
            addCriterion("logistics_name not like", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIn(List<String> values) {
            addCriterion("logistics_name in", values, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotIn(List<String> values) {
            addCriterion("logistics_name not in", values, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameBetween(String value1, String value2) {
            addCriterion("logistics_name between", value1, value2, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotBetween(String value1, String value2) {
            addCriterion("logistics_name not between", value1, value2, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(String value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(String value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(String value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(String value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(String value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLike(String value) {
            addCriterion("logistics_id like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotLike(String value) {
            addCriterion("logistics_id not like", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<String> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<String> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(String value1, String value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(String value1, String value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNull() {
            addCriterion("parent_order_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNotNull() {
            addCriterion("parent_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdEqualTo(String value) {
            addCriterion("parent_order_id =", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotEqualTo(String value) {
            addCriterion("parent_order_id <>", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThan(String value) {
            addCriterion("parent_order_id >", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_order_id >=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThan(String value) {
            addCriterion("parent_order_id <", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThanOrEqualTo(String value) {
            addCriterion("parent_order_id <=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLike(String value) {
            addCriterion("parent_order_id like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotLike(String value) {
            addCriterion("parent_order_id not like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIn(List<String> values) {
            addCriterion("parent_order_id in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotIn(List<String> values) {
            addCriterion("parent_order_id not in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdBetween(String value1, String value2) {
            addCriterion("parent_order_id between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotBetween(String value1, String value2) {
            addCriterion("parent_order_id not between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIsNull() {
            addCriterion("store_order is null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIsNotNull() {
            addCriterion("store_order is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOrderEqualTo(String value) {
            addCriterion("store_order =", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotEqualTo(String value) {
            addCriterion("store_order <>", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderGreaterThan(String value) {
            addCriterion("store_order >", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderGreaterThanOrEqualTo(String value) {
            addCriterion("store_order >=", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderLessThan(String value) {
            addCriterion("store_order <", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderLessThanOrEqualTo(String value) {
            addCriterion("store_order <=", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderLike(String value) {
            addCriterion("store_order like", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotLike(String value) {
            addCriterion("store_order not like", value, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderIn(List<String> values) {
            addCriterion("store_order in", values, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotIn(List<String> values) {
            addCriterion("store_order not in", values, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderBetween(String value1, String value2) {
            addCriterion("store_order between", value1, value2, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andStoreOrderNotBetween(String value1, String value2) {
            addCriterion("store_order not between", value1, value2, "storeOrder");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIsNull() {
            addCriterion("is_excel_import is null");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIsNotNull() {
            addCriterion("is_excel_import is not null");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportEqualTo(String value) {
            addCriterion("is_excel_import =", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotEqualTo(String value) {
            addCriterion("is_excel_import <>", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportGreaterThan(String value) {
            addCriterion("is_excel_import >", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportGreaterThanOrEqualTo(String value) {
            addCriterion("is_excel_import >=", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLessThan(String value) {
            addCriterion("is_excel_import <", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLessThanOrEqualTo(String value) {
            addCriterion("is_excel_import <=", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLike(String value) {
            addCriterion("is_excel_import like", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotLike(String value) {
            addCriterion("is_excel_import not like", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIn(List<String> values) {
            addCriterion("is_excel_import in", values, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotIn(List<String> values) {
            addCriterion("is_excel_import not in", values, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportBetween(String value1, String value2) {
            addCriterion("is_excel_import between", value1, value2, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotBetween(String value1, String value2) {
            addCriterion("is_excel_import not between", value1, value2, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(Long value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(Long value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<Long> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}