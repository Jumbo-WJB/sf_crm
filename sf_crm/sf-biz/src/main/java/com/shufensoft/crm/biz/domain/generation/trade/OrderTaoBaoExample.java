package com.shufensoft.crm.biz.domain.generation.trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTaoBaoExample {
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

    public OrderTaoBaoExample() {
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

    public void addTidQueryColumn() {
        this.queryColumns.add("tid");
    }

    public void addMaxTidQueryColumn() {
        this.queryColumns.add("max(tid) max_tid");
    }

    public void addMinTidQueryColumn() {
        this.queryColumns.add("min(tid) min_tid");
    }

    public void addAvgTidQueryColumn() {
        this.queryColumns.add(" avg(tid) avg_tid");
    }

    public void addCountTidQueryColumn() {
        this.queryColumns.add(" count(tid) count_tid");
    }

    public void addSumTidQueryColumn() {
        this.queryColumns.add(" sum(tid) sum_tid");
    }

    public void addOidQueryColumn() {
        this.queryColumns.add("oid");
    }

    public void addMaxOidQueryColumn() {
        this.queryColumns.add("max(oid) max_oid");
    }

    public void addMinOidQueryColumn() {
        this.queryColumns.add("min(oid) min_oid");
    }

    public void addAvgOidQueryColumn() {
        this.queryColumns.add(" avg(oid) avg_oid");
    }

    public void addCountOidQueryColumn() {
        this.queryColumns.add(" count(oid) count_oid");
    }

    public void addSumOidQueryColumn() {
        this.queryColumns.add(" sum(oid) sum_oid");
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

    public void addUserIdTbQueryColumn() {
        this.queryColumns.add("user_id_tb");
    }

    public void addMaxUserIdTbQueryColumn() {
        this.queryColumns.add("max(user_id_tb) max_user_id_tb");
    }

    public void addMinUserIdTbQueryColumn() {
        this.queryColumns.add("min(user_id_tb) min_user_id_tb");
    }

    public void addAvgUserIdTbQueryColumn() {
        this.queryColumns.add(" avg(user_id_tb) avg_user_id_tb");
    }

    public void addCountUserIdTbQueryColumn() {
        this.queryColumns.add(" count(user_id_tb) count_user_id_tb");
    }

    public void addSumUserIdTbQueryColumn() {
        this.queryColumns.add(" sum(user_id_tb) sum_user_id_tb");
    }

    public void addItemMealNameQueryColumn() {
        this.queryColumns.add("item_meal_name");
    }

    public void addMaxItemMealNameQueryColumn() {
        this.queryColumns.add("max(item_meal_name) max_item_meal_name");
    }

    public void addMinItemMealNameQueryColumn() {
        this.queryColumns.add("min(item_meal_name) min_item_meal_name");
    }

    public void addAvgItemMealNameQueryColumn() {
        this.queryColumns.add(" avg(item_meal_name) avg_item_meal_name");
    }

    public void addCountItemMealNameQueryColumn() {
        this.queryColumns.add(" count(item_meal_name) count_item_meal_name");
    }

    public void addSumItemMealNameQueryColumn() {
        this.queryColumns.add(" sum(item_meal_name) sum_item_meal_name");
    }

    public void addSellerNickQueryColumn() {
        this.queryColumns.add("seller_nick");
    }

    public void addMaxSellerNickQueryColumn() {
        this.queryColumns.add("max(seller_nick) max_seller_nick");
    }

    public void addMinSellerNickQueryColumn() {
        this.queryColumns.add("min(seller_nick) min_seller_nick");
    }

    public void addAvgSellerNickQueryColumn() {
        this.queryColumns.add(" avg(seller_nick) avg_seller_nick");
    }

    public void addCountSellerNickQueryColumn() {
        this.queryColumns.add(" count(seller_nick) count_seller_nick");
    }

    public void addSumSellerNickQueryColumn() {
        this.queryColumns.add(" sum(seller_nick) sum_seller_nick");
    }

    public void addBuyerNickQueryColumn() {
        this.queryColumns.add("buyer_nick");
    }

    public void addMaxBuyerNickQueryColumn() {
        this.queryColumns.add("max(buyer_nick) max_buyer_nick");
    }

    public void addMinBuyerNickQueryColumn() {
        this.queryColumns.add("min(buyer_nick) min_buyer_nick");
    }

    public void addAvgBuyerNickQueryColumn() {
        this.queryColumns.add(" avg(buyer_nick) avg_buyer_nick");
    }

    public void addCountBuyerNickQueryColumn() {
        this.queryColumns.add(" count(buyer_nick) count_buyer_nick");
    }

    public void addSumBuyerNickQueryColumn() {
        this.queryColumns.add(" sum(buyer_nick) sum_buyer_nick");
    }

    public void addRefundStatusQueryColumn() {
        this.queryColumns.add("refund_status");
    }

    public void addMaxRefundStatusQueryColumn() {
        this.queryColumns.add("max(refund_status) max_refund_status");
    }

    public void addMinRefundStatusQueryColumn() {
        this.queryColumns.add("min(refund_status) min_refund_status");
    }

    public void addAvgRefundStatusQueryColumn() {
        this.queryColumns.add(" avg(refund_status) avg_refund_status");
    }

    public void addCountRefundStatusQueryColumn() {
        this.queryColumns.add(" count(refund_status) count_refund_status");
    }

    public void addSumRefundStatusQueryColumn() {
        this.queryColumns.add(" sum(refund_status) sum_refund_status");
    }

    public void addOuterIidQueryColumn() {
        this.queryColumns.add("outer_iid");
    }

    public void addMaxOuterIidQueryColumn() {
        this.queryColumns.add("max(outer_iid) max_outer_iid");
    }

    public void addMinOuterIidQueryColumn() {
        this.queryColumns.add("min(outer_iid) min_outer_iid");
    }

    public void addAvgOuterIidQueryColumn() {
        this.queryColumns.add(" avg(outer_iid) avg_outer_iid");
    }

    public void addCountOuterIidQueryColumn() {
        this.queryColumns.add(" count(outer_iid) count_outer_iid");
    }

    public void addSumOuterIidQueryColumn() {
        this.queryColumns.add(" sum(outer_iid) sum_outer_iid");
    }

    public void addSnapshotUrlQueryColumn() {
        this.queryColumns.add("snapshot_url");
    }

    public void addMaxSnapshotUrlQueryColumn() {
        this.queryColumns.add("max(snapshot_url) max_snapshot_url");
    }

    public void addMinSnapshotUrlQueryColumn() {
        this.queryColumns.add("min(snapshot_url) min_snapshot_url");
    }

    public void addAvgSnapshotUrlQueryColumn() {
        this.queryColumns.add(" avg(snapshot_url) avg_snapshot_url");
    }

    public void addCountSnapshotUrlQueryColumn() {
        this.queryColumns.add(" count(snapshot_url) count_snapshot_url");
    }

    public void addSumSnapshotUrlQueryColumn() {
        this.queryColumns.add(" sum(snapshot_url) sum_snapshot_url");
    }

    public void addSnapshotQueryColumn() {
        this.queryColumns.add("snapshot");
    }

    public void addMaxSnapshotQueryColumn() {
        this.queryColumns.add("max(snapshot) max_snapshot");
    }

    public void addMinSnapshotQueryColumn() {
        this.queryColumns.add("min(snapshot) min_snapshot");
    }

    public void addAvgSnapshotQueryColumn() {
        this.queryColumns.add(" avg(snapshot) avg_snapshot");
    }

    public void addCountSnapshotQueryColumn() {
        this.queryColumns.add(" count(snapshot) count_snapshot");
    }

    public void addSumSnapshotQueryColumn() {
        this.queryColumns.add(" sum(snapshot) sum_snapshot");
    }

    public void addTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("timeout_action_time");
    }

    public void addMaxTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("max(timeout_action_time) max_timeout_action_time");
    }

    public void addMinTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("min(timeout_action_time) min_timeout_action_time");
    }

    public void addAvgTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" avg(timeout_action_time) avg_timeout_action_time");
    }

    public void addCountTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" count(timeout_action_time) count_timeout_action_time");
    }

    public void addSumTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" sum(timeout_action_time) sum_timeout_action_time");
    }

    public void addBuyerRateQueryColumn() {
        this.queryColumns.add("buyer_rate");
    }

    public void addMaxBuyerRateQueryColumn() {
        this.queryColumns.add("max(buyer_rate) max_buyer_rate");
    }

    public void addMinBuyerRateQueryColumn() {
        this.queryColumns.add("min(buyer_rate) min_buyer_rate");
    }

    public void addAvgBuyerRateQueryColumn() {
        this.queryColumns.add(" avg(buyer_rate) avg_buyer_rate");
    }

    public void addCountBuyerRateQueryColumn() {
        this.queryColumns.add(" count(buyer_rate) count_buyer_rate");
    }

    public void addSumBuyerRateQueryColumn() {
        this.queryColumns.add(" sum(buyer_rate) sum_buyer_rate");
    }

    public void addCidQueryColumn() {
        this.queryColumns.add("cid");
    }

    public void addMaxCidQueryColumn() {
        this.queryColumns.add("max(cid) max_cid");
    }

    public void addMinCidQueryColumn() {
        this.queryColumns.add("min(cid) min_cid");
    }

    public void addAvgCidQueryColumn() {
        this.queryColumns.add(" avg(cid) avg_cid");
    }

    public void addCountCidQueryColumn() {
        this.queryColumns.add(" count(cid) count_cid");
    }

    public void addSumCidQueryColumn() {
        this.queryColumns.add(" sum(cid) sum_cid");
    }

    public void addStatusQueryColumn() {
        this.queryColumns.add("status");
    }

    public void addMaxStatusQueryColumn() {
        this.queryColumns.add("max(status) max_status");
    }

    public void addMinStatusQueryColumn() {
        this.queryColumns.add("min(status) min_status");
    }

    public void addAvgStatusQueryColumn() {
        this.queryColumns.add(" avg(status) avg_status");
    }

    public void addCountStatusQueryColumn() {
        this.queryColumns.add(" count(status) count_status");
    }

    public void addSumStatusQueryColumn() {
        this.queryColumns.add(" sum(status) sum_status");
    }

    public void addTitleQueryColumn() {
        this.queryColumns.add("title");
    }

    public void addMaxTitleQueryColumn() {
        this.queryColumns.add("max(title) max_title");
    }

    public void addMinTitleQueryColumn() {
        this.queryColumns.add("min(title) min_title");
    }

    public void addAvgTitleQueryColumn() {
        this.queryColumns.add(" avg(title) avg_title");
    }

    public void addCountTitleQueryColumn() {
        this.queryColumns.add(" count(title) count_title");
    }

    public void addSumTitleQueryColumn() {
        this.queryColumns.add(" sum(title) sum_title");
    }

    public void addPriceQueryColumn() {
        this.queryColumns.add("price");
    }

    public void addMaxPriceQueryColumn() {
        this.queryColumns.add("max(price) max_price");
    }

    public void addMinPriceQueryColumn() {
        this.queryColumns.add("min(price) min_price");
    }

    public void addAvgPriceQueryColumn() {
        this.queryColumns.add(" avg(price) avg_price");
    }

    public void addCountPriceQueryColumn() {
        this.queryColumns.add(" count(price) count_price");
    }

    public void addSumPriceQueryColumn() {
        this.queryColumns.add(" sum(price) sum_price");
    }

    public void addNumIidQueryColumn() {
        this.queryColumns.add("num_iid");
    }

    public void addMaxNumIidQueryColumn() {
        this.queryColumns.add("max(num_iid) max_num_iid");
    }

    public void addMinNumIidQueryColumn() {
        this.queryColumns.add("min(num_iid) min_num_iid");
    }

    public void addAvgNumIidQueryColumn() {
        this.queryColumns.add(" avg(num_iid) avg_num_iid");
    }

    public void addCountNumIidQueryColumn() {
        this.queryColumns.add(" count(num_iid) count_num_iid");
    }

    public void addSumNumIidQueryColumn() {
        this.queryColumns.add(" sum(num_iid) sum_num_iid");
    }

    public void addItemMealIdQueryColumn() {
        this.queryColumns.add("item_meal_id");
    }

    public void addMaxItemMealIdQueryColumn() {
        this.queryColumns.add("max(item_meal_id) max_item_meal_id");
    }

    public void addMinItemMealIdQueryColumn() {
        this.queryColumns.add("min(item_meal_id) min_item_meal_id");
    }

    public void addAvgItemMealIdQueryColumn() {
        this.queryColumns.add(" avg(item_meal_id) avg_item_meal_id");
    }

    public void addCountItemMealIdQueryColumn() {
        this.queryColumns.add(" count(item_meal_id) count_item_meal_id");
    }

    public void addSumItemMealIdQueryColumn() {
        this.queryColumns.add(" sum(item_meal_id) sum_item_meal_id");
    }

    public void addSkuIdQueryColumn() {
        this.queryColumns.add("sku_id");
    }

    public void addMaxSkuIdQueryColumn() {
        this.queryColumns.add("max(sku_id) max_sku_id");
    }

    public void addMinSkuIdQueryColumn() {
        this.queryColumns.add("min(sku_id) min_sku_id");
    }

    public void addAvgSkuIdQueryColumn() {
        this.queryColumns.add(" avg(sku_id) avg_sku_id");
    }

    public void addCountSkuIdQueryColumn() {
        this.queryColumns.add(" count(sku_id) count_sku_id");
    }

    public void addSumSkuIdQueryColumn() {
        this.queryColumns.add(" sum(sku_id) sum_sku_id");
    }

    public void addNumQueryColumn() {
        this.queryColumns.add("num");
    }

    public void addMaxNumQueryColumn() {
        this.queryColumns.add("max(num) max_num");
    }

    public void addMinNumQueryColumn() {
        this.queryColumns.add("min(num) min_num");
    }

    public void addAvgNumQueryColumn() {
        this.queryColumns.add(" avg(num) avg_num");
    }

    public void addCountNumQueryColumn() {
        this.queryColumns.add(" count(num) count_num");
    }

    public void addSumNumQueryColumn() {
        this.queryColumns.add(" sum(num) sum_num");
    }

    public void addOuterSkuIdQueryColumn() {
        this.queryColumns.add("outer_sku_id");
    }

    public void addMaxOuterSkuIdQueryColumn() {
        this.queryColumns.add("max(outer_sku_id) max_outer_sku_id");
    }

    public void addMinOuterSkuIdQueryColumn() {
        this.queryColumns.add("min(outer_sku_id) min_outer_sku_id");
    }

    public void addAvgOuterSkuIdQueryColumn() {
        this.queryColumns.add(" avg(outer_sku_id) avg_outer_sku_id");
    }

    public void addCountOuterSkuIdQueryColumn() {
        this.queryColumns.add(" count(outer_sku_id) count_outer_sku_id");
    }

    public void addSumOuterSkuIdQueryColumn() {
        this.queryColumns.add(" sum(outer_sku_id) sum_outer_sku_id");
    }

    public void addOrderFromQueryColumn() {
        this.queryColumns.add("order_from");
    }

    public void addMaxOrderFromQueryColumn() {
        this.queryColumns.add("max(order_from) max_order_from");
    }

    public void addMinOrderFromQueryColumn() {
        this.queryColumns.add("min(order_from) min_order_from");
    }

    public void addAvgOrderFromQueryColumn() {
        this.queryColumns.add(" avg(order_from) avg_order_from");
    }

    public void addCountOrderFromQueryColumn() {
        this.queryColumns.add(" count(order_from) count_order_from");
    }

    public void addSumOrderFromQueryColumn() {
        this.queryColumns.add(" sum(order_from) sum_order_from");
    }

    public void addTotalFeeQueryColumn() {
        this.queryColumns.add("total_fee");
    }

    public void addMaxTotalFeeQueryColumn() {
        this.queryColumns.add("max(total_fee) max_total_fee");
    }

    public void addMinTotalFeeQueryColumn() {
        this.queryColumns.add("min(total_fee) min_total_fee");
    }

    public void addAvgTotalFeeQueryColumn() {
        this.queryColumns.add(" avg(total_fee) avg_total_fee");
    }

    public void addCountTotalFeeQueryColumn() {
        this.queryColumns.add(" count(total_fee) count_total_fee");
    }

    public void addSumTotalFeeQueryColumn() {
        this.queryColumns.add(" sum(total_fee) sum_total_fee");
    }

    public void addPaymentQueryColumn() {
        this.queryColumns.add("payment");
    }

    public void addMaxPaymentQueryColumn() {
        this.queryColumns.add("max(payment) max_payment");
    }

    public void addMinPaymentQueryColumn() {
        this.queryColumns.add("min(payment) min_payment");
    }

    public void addAvgPaymentQueryColumn() {
        this.queryColumns.add(" avg(payment) avg_payment");
    }

    public void addCountPaymentQueryColumn() {
        this.queryColumns.add(" count(payment) count_payment");
    }

    public void addSumPaymentQueryColumn() {
        this.queryColumns.add(" sum(payment) sum_payment");
    }

    public void addDiscountFeeQueryColumn() {
        this.queryColumns.add("discount_fee");
    }

    public void addMaxDiscountFeeQueryColumn() {
        this.queryColumns.add("max(discount_fee) max_discount_fee");
    }

    public void addMinDiscountFeeQueryColumn() {
        this.queryColumns.add("min(discount_fee) min_discount_fee");
    }

    public void addAvgDiscountFeeQueryColumn() {
        this.queryColumns.add(" avg(discount_fee) avg_discount_fee");
    }

    public void addCountDiscountFeeQueryColumn() {
        this.queryColumns.add(" count(discount_fee) count_discount_fee");
    }

    public void addSumDiscountFeeQueryColumn() {
        this.queryColumns.add(" sum(discount_fee) sum_discount_fee");
    }

    public void addAdjustFeeQueryColumn() {
        this.queryColumns.add("adjust_fee");
    }

    public void addMaxAdjustFeeQueryColumn() {
        this.queryColumns.add("max(adjust_fee) max_adjust_fee");
    }

    public void addMinAdjustFeeQueryColumn() {
        this.queryColumns.add("min(adjust_fee) min_adjust_fee");
    }

    public void addAvgAdjustFeeQueryColumn() {
        this.queryColumns.add(" avg(adjust_fee) avg_adjust_fee");
    }

    public void addCountAdjustFeeQueryColumn() {
        this.queryColumns.add(" count(adjust_fee) count_adjust_fee");
    }

    public void addSumAdjustFeeQueryColumn() {
        this.queryColumns.add(" sum(adjust_fee) sum_adjust_fee");
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

    public void addSkuPropertiesNameQueryColumn() {
        this.queryColumns.add("sku_properties_name");
    }

    public void addMaxSkuPropertiesNameQueryColumn() {
        this.queryColumns.add("max(sku_properties_name) max_sku_properties_name");
    }

    public void addMinSkuPropertiesNameQueryColumn() {
        this.queryColumns.add("min(sku_properties_name) min_sku_properties_name");
    }

    public void addAvgSkuPropertiesNameQueryColumn() {
        this.queryColumns.add(" avg(sku_properties_name) avg_sku_properties_name");
    }

    public void addCountSkuPropertiesNameQueryColumn() {
        this.queryColumns.add(" count(sku_properties_name) count_sku_properties_name");
    }

    public void addSumSkuPropertiesNameQueryColumn() {
        this.queryColumns.add(" sum(sku_properties_name) sum_sku_properties_name");
    }

    public void addRefundIdQueryColumn() {
        this.queryColumns.add("refund_id");
    }

    public void addMaxRefundIdQueryColumn() {
        this.queryColumns.add("max(refund_id) max_refund_id");
    }

    public void addMinRefundIdQueryColumn() {
        this.queryColumns.add("min(refund_id) min_refund_id");
    }

    public void addAvgRefundIdQueryColumn() {
        this.queryColumns.add(" avg(refund_id) avg_refund_id");
    }

    public void addCountRefundIdQueryColumn() {
        this.queryColumns.add(" count(refund_id) count_refund_id");
    }

    public void addSumRefundIdQueryColumn() {
        this.queryColumns.add(" sum(refund_id) sum_refund_id");
    }

    public void addIsOversoldQueryColumn() {
        this.queryColumns.add("is_oversold");
    }

    public void addMaxIsOversoldQueryColumn() {
        this.queryColumns.add("max(is_oversold) max_is_oversold");
    }

    public void addMinIsOversoldQueryColumn() {
        this.queryColumns.add("min(is_oversold) min_is_oversold");
    }

    public void addAvgIsOversoldQueryColumn() {
        this.queryColumns.add(" avg(is_oversold) avg_is_oversold");
    }

    public void addCountIsOversoldQueryColumn() {
        this.queryColumns.add(" count(is_oversold) count_is_oversold");
    }

    public void addSumIsOversoldQueryColumn() {
        this.queryColumns.add(" sum(is_oversold) sum_is_oversold");
    }

    public void addEndTimeQueryColumn() {
        this.queryColumns.add("end_time");
    }

    public void addMaxEndTimeQueryColumn() {
        this.queryColumns.add("max(end_time) max_end_time");
    }

    public void addMinEndTimeQueryColumn() {
        this.queryColumns.add("min(end_time) min_end_time");
    }

    public void addAvgEndTimeQueryColumn() {
        this.queryColumns.add(" avg(end_time) avg_end_time");
    }

    public void addCountEndTimeQueryColumn() {
        this.queryColumns.add(" count(end_time) count_end_time");
    }

    public void addSumEndTimeQueryColumn() {
        this.queryColumns.add(" sum(end_time) sum_end_time");
    }

    public void addConsignTimeQueryColumn() {
        this.queryColumns.add("consign_time");
    }

    public void addMaxConsignTimeQueryColumn() {
        this.queryColumns.add("max(consign_time) max_consign_time");
    }

    public void addMinConsignTimeQueryColumn() {
        this.queryColumns.add("min(consign_time) min_consign_time");
    }

    public void addAvgConsignTimeQueryColumn() {
        this.queryColumns.add(" avg(consign_time) avg_consign_time");
    }

    public void addCountConsignTimeQueryColumn() {
        this.queryColumns.add(" count(consign_time) count_consign_time");
    }

    public void addSumConsignTimeQueryColumn() {
        this.queryColumns.add(" sum(consign_time) sum_consign_time");
    }

    public void addShippingTypeQueryColumn() {
        this.queryColumns.add("shipping_type");
    }

    public void addMaxShippingTypeQueryColumn() {
        this.queryColumns.add("max(shipping_type) max_shipping_type");
    }

    public void addMinShippingTypeQueryColumn() {
        this.queryColumns.add("min(shipping_type) min_shipping_type");
    }

    public void addAvgShippingTypeQueryColumn() {
        this.queryColumns.add(" avg(shipping_type) avg_shipping_type");
    }

    public void addCountShippingTypeQueryColumn() {
        this.queryColumns.add(" count(shipping_type) count_shipping_type");
    }

    public void addSumShippingTypeQueryColumn() {
        this.queryColumns.add(" sum(shipping_type) sum_shipping_type");
    }

    public void addBindOidQueryColumn() {
        this.queryColumns.add("bind_oid");
    }

    public void addMaxBindOidQueryColumn() {
        this.queryColumns.add("max(bind_oid) max_bind_oid");
    }

    public void addMinBindOidQueryColumn() {
        this.queryColumns.add("min(bind_oid) min_bind_oid");
    }

    public void addAvgBindOidQueryColumn() {
        this.queryColumns.add(" avg(bind_oid) avg_bind_oid");
    }

    public void addCountBindOidQueryColumn() {
        this.queryColumns.add(" count(bind_oid) count_bind_oid");
    }

    public void addSumBindOidQueryColumn() {
        this.queryColumns.add(" sum(bind_oid) sum_bind_oid");
    }

    public void addLogisticsCompanyQueryColumn() {
        this.queryColumns.add("logistics_company");
    }

    public void addMaxLogisticsCompanyQueryColumn() {
        this.queryColumns.add("max(logistics_company) max_logistics_company");
    }

    public void addMinLogisticsCompanyQueryColumn() {
        this.queryColumns.add("min(logistics_company) min_logistics_company");
    }

    public void addAvgLogisticsCompanyQueryColumn() {
        this.queryColumns.add(" avg(logistics_company) avg_logistics_company");
    }

    public void addCountLogisticsCompanyQueryColumn() {
        this.queryColumns.add(" count(logistics_company) count_logistics_company");
    }

    public void addSumLogisticsCompanyQueryColumn() {
        this.queryColumns.add(" sum(logistics_company) sum_logistics_company");
    }

    public void addSimpleNameQueryColumn() {
        this.queryColumns.add("simple_name");
    }

    public void addMaxSimpleNameQueryColumn() {
        this.queryColumns.add("max(simple_name) max_simple_name");
    }

    public void addMinSimpleNameQueryColumn() {
        this.queryColumns.add("min(simple_name) min_simple_name");
    }

    public void addAvgSimpleNameQueryColumn() {
        this.queryColumns.add(" avg(simple_name) avg_simple_name");
    }

    public void addCountSimpleNameQueryColumn() {
        this.queryColumns.add(" count(simple_name) count_simple_name");
    }

    public void addSumSimpleNameQueryColumn() {
        this.queryColumns.add(" sum(simple_name) sum_simple_name");
    }

    public void addInvoiceNoQueryColumn() {
        this.queryColumns.add("invoice_no");
    }

    public void addMaxInvoiceNoQueryColumn() {
        this.queryColumns.add("max(invoice_no) max_invoice_no");
    }

    public void addMinInvoiceNoQueryColumn() {
        this.queryColumns.add("min(invoice_no) min_invoice_no");
    }

    public void addAvgInvoiceNoQueryColumn() {
        this.queryColumns.add(" avg(invoice_no) avg_invoice_no");
    }

    public void addCountInvoiceNoQueryColumn() {
        this.queryColumns.add(" count(invoice_no) count_invoice_no");
    }

    public void addSumInvoiceNoQueryColumn() {
        this.queryColumns.add(" sum(invoice_no) sum_invoice_no");
    }

    public void addIsDaixiaoQueryColumn() {
        this.queryColumns.add("is_daixiao");
    }

    public void addMaxIsDaixiaoQueryColumn() {
        this.queryColumns.add("max(is_daixiao) max_is_daixiao");
    }

    public void addMinIsDaixiaoQueryColumn() {
        this.queryColumns.add("min(is_daixiao) min_is_daixiao");
    }

    public void addAvgIsDaixiaoQueryColumn() {
        this.queryColumns.add(" avg(is_daixiao) avg_is_daixiao");
    }

    public void addCountIsDaixiaoQueryColumn() {
        this.queryColumns.add(" count(is_daixiao) count_is_daixiao");
    }

    public void addSumIsDaixiaoQueryColumn() {
        this.queryColumns.add(" sum(is_daixiao) sum_is_daixiao");
    }

    public void addDivideOrderFeeQueryColumn() {
        this.queryColumns.add("divide_order_fee");
    }

    public void addMaxDivideOrderFeeQueryColumn() {
        this.queryColumns.add("max(divide_order_fee) max_divide_order_fee");
    }

    public void addMinDivideOrderFeeQueryColumn() {
        this.queryColumns.add("min(divide_order_fee) min_divide_order_fee");
    }

    public void addAvgDivideOrderFeeQueryColumn() {
        this.queryColumns.add(" avg(divide_order_fee) avg_divide_order_fee");
    }

    public void addCountDivideOrderFeeQueryColumn() {
        this.queryColumns.add(" count(divide_order_fee) count_divide_order_fee");
    }

    public void addSumDivideOrderFeeQueryColumn() {
        this.queryColumns.add(" sum(divide_order_fee) sum_divide_order_fee");
    }

    public void addPartMjzDiscountQueryColumn() {
        this.queryColumns.add("part_mjz_discount");
    }

    public void addMaxPartMjzDiscountQueryColumn() {
        this.queryColumns.add("max(part_mjz_discount) max_part_mjz_discount");
    }

    public void addMinPartMjzDiscountQueryColumn() {
        this.queryColumns.add("min(part_mjz_discount) min_part_mjz_discount");
    }

    public void addAvgPartMjzDiscountQueryColumn() {
        this.queryColumns.add(" avg(part_mjz_discount) avg_part_mjz_discount");
    }

    public void addCountPartMjzDiscountQueryColumn() {
        this.queryColumns.add(" count(part_mjz_discount) count_part_mjz_discount");
    }

    public void addSumPartMjzDiscountQueryColumn() {
        this.queryColumns.add(" sum(part_mjz_discount) sum_part_mjz_discount");
    }

    public void addStoreCodeQueryColumn() {
        this.queryColumns.add("store_code");
    }

    public void addMaxStoreCodeQueryColumn() {
        this.queryColumns.add("max(store_code) max_store_code");
    }

    public void addMinStoreCodeQueryColumn() {
        this.queryColumns.add("min(store_code) min_store_code");
    }

    public void addAvgStoreCodeQueryColumn() {
        this.queryColumns.add(" avg(store_code) avg_store_code");
    }

    public void addCountStoreCodeQueryColumn() {
        this.queryColumns.add(" count(store_code) count_store_code");
    }

    public void addSumStoreCodeQueryColumn() {
        this.queryColumns.add(" sum(store_code) sum_store_code");
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
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

        public Criteria andUserIdTbIsNull() {
            addCriterion("user_id_tb is null");
            return (Criteria) this;
        }

        public Criteria andUserIdTbIsNotNull() {
            addCriterion("user_id_tb is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdTbEqualTo(Long value) {
            addCriterion("user_id_tb =", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotEqualTo(Long value) {
            addCriterion("user_id_tb <>", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbGreaterThan(Long value) {
            addCriterion("user_id_tb >", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_tb >=", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbLessThan(Long value) {
            addCriterion("user_id_tb <", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbLessThanOrEqualTo(Long value) {
            addCriterion("user_id_tb <=", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbIn(List<Long> values) {
            addCriterion("user_id_tb in", values, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotIn(List<Long> values) {
            addCriterion("user_id_tb not in", values, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbBetween(Long value1, Long value2) {
            addCriterion("user_id_tb between", value1, value2, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotBetween(Long value1, Long value2) {
            addCriterion("user_id_tb not between", value1, value2, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andItemMealNameIsNull() {
            addCriterion("item_meal_name is null");
            return (Criteria) this;
        }

        public Criteria andItemMealNameIsNotNull() {
            addCriterion("item_meal_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemMealNameEqualTo(String value) {
            addCriterion("item_meal_name =", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameNotEqualTo(String value) {
            addCriterion("item_meal_name <>", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameGreaterThan(String value) {
            addCriterion("item_meal_name >", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_meal_name >=", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameLessThan(String value) {
            addCriterion("item_meal_name <", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameLessThanOrEqualTo(String value) {
            addCriterion("item_meal_name <=", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameLike(String value) {
            addCriterion("item_meal_name like", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameNotLike(String value) {
            addCriterion("item_meal_name not like", value, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameIn(List<String> values) {
            addCriterion("item_meal_name in", values, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameNotIn(List<String> values) {
            addCriterion("item_meal_name not in", values, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameBetween(String value1, String value2) {
            addCriterion("item_meal_name between", value1, value2, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andItemMealNameNotBetween(String value1, String value2) {
            addCriterion("item_meal_name not between", value1, value2, "itemMealName");
            return (Criteria) this;
        }

        public Criteria andSellerNickIsNull() {
            addCriterion("seller_nick is null");
            return (Criteria) this;
        }

        public Criteria andSellerNickIsNotNull() {
            addCriterion("seller_nick is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNickEqualTo(String value) {
            addCriterion("seller_nick =", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotEqualTo(String value) {
            addCriterion("seller_nick <>", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThan(String value) {
            addCriterion("seller_nick >", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThanOrEqualTo(String value) {
            addCriterion("seller_nick >=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThan(String value) {
            addCriterion("seller_nick <", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThanOrEqualTo(String value) {
            addCriterion("seller_nick <=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLike(String value) {
            addCriterion("seller_nick like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotLike(String value) {
            addCriterion("seller_nick not like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickIn(List<String> values) {
            addCriterion("seller_nick in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotIn(List<String> values) {
            addCriterion("seller_nick not in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickBetween(String value1, String value2) {
            addCriterion("seller_nick between", value1, value2, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotBetween(String value1, String value2) {
            addCriterion("seller_nick not between", value1, value2, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNull() {
            addCriterion("buyer_nick is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNotNull() {
            addCriterion("buyer_nick is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickEqualTo(String value) {
            addCriterion("buyer_nick =", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotEqualTo(String value) {
            addCriterion("buyer_nick <>", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThan(String value) {
            addCriterion("buyer_nick >", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_nick >=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThan(String value) {
            addCriterion("buyer_nick <", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("buyer_nick <=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLike(String value) {
            addCriterion("buyer_nick like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotLike(String value) {
            addCriterion("buyer_nick not like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIn(List<String> values) {
            addCriterion("buyer_nick in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotIn(List<String> values) {
            addCriterion("buyer_nick not in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickBetween(String value1, String value2) {
            addCriterion("buyer_nick between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotBetween(String value1, String value2) {
            addCriterion("buyer_nick not between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(String value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(String value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(String value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(String value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(String value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(String value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLike(String value) {
            addCriterion("refund_status like", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotLike(String value) {
            addCriterion("refund_status not like", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<String> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<String> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(String value1, String value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(String value1, String value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andOuterIidIsNull() {
            addCriterion("outer_iid is null");
            return (Criteria) this;
        }

        public Criteria andOuterIidIsNotNull() {
            addCriterion("outer_iid is not null");
            return (Criteria) this;
        }

        public Criteria andOuterIidEqualTo(String value) {
            addCriterion("outer_iid =", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidNotEqualTo(String value) {
            addCriterion("outer_iid <>", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidGreaterThan(String value) {
            addCriterion("outer_iid >", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidGreaterThanOrEqualTo(String value) {
            addCriterion("outer_iid >=", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidLessThan(String value) {
            addCriterion("outer_iid <", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidLessThanOrEqualTo(String value) {
            addCriterion("outer_iid <=", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidLike(String value) {
            addCriterion("outer_iid like", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidNotLike(String value) {
            addCriterion("outer_iid not like", value, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidIn(List<String> values) {
            addCriterion("outer_iid in", values, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidNotIn(List<String> values) {
            addCriterion("outer_iid not in", values, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidBetween(String value1, String value2) {
            addCriterion("outer_iid between", value1, value2, "outerIid");
            return (Criteria) this;
        }

        public Criteria andOuterIidNotBetween(String value1, String value2) {
            addCriterion("outer_iid not between", value1, value2, "outerIid");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlIsNull() {
            addCriterion("snapshot_url is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlIsNotNull() {
            addCriterion("snapshot_url is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlEqualTo(String value) {
            addCriterion("snapshot_url =", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlNotEqualTo(String value) {
            addCriterion("snapshot_url <>", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlGreaterThan(String value) {
            addCriterion("snapshot_url >", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlGreaterThanOrEqualTo(String value) {
            addCriterion("snapshot_url >=", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlLessThan(String value) {
            addCriterion("snapshot_url <", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlLessThanOrEqualTo(String value) {
            addCriterion("snapshot_url <=", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlLike(String value) {
            addCriterion("snapshot_url like", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlNotLike(String value) {
            addCriterion("snapshot_url not like", value, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlIn(List<String> values) {
            addCriterion("snapshot_url in", values, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlNotIn(List<String> values) {
            addCriterion("snapshot_url not in", values, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlBetween(String value1, String value2) {
            addCriterion("snapshot_url between", value1, value2, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotUrlNotBetween(String value1, String value2) {
            addCriterion("snapshot_url not between", value1, value2, "snapshotUrl");
            return (Criteria) this;
        }

        public Criteria andSnapshotIsNull() {
            addCriterion("snapshot is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIsNotNull() {
            addCriterion("snapshot is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotEqualTo(String value) {
            addCriterion("snapshot =", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotNotEqualTo(String value) {
            addCriterion("snapshot <>", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotGreaterThan(String value) {
            addCriterion("snapshot >", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotGreaterThanOrEqualTo(String value) {
            addCriterion("snapshot >=", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotLessThan(String value) {
            addCriterion("snapshot <", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotLessThanOrEqualTo(String value) {
            addCriterion("snapshot <=", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotLike(String value) {
            addCriterion("snapshot like", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotNotLike(String value) {
            addCriterion("snapshot not like", value, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotIn(List<String> values) {
            addCriterion("snapshot in", values, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotNotIn(List<String> values) {
            addCriterion("snapshot not in", values, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotBetween(String value1, String value2) {
            addCriterion("snapshot between", value1, value2, "snapshot");
            return (Criteria) this;
        }

        public Criteria andSnapshotNotBetween(String value1, String value2) {
            addCriterion("snapshot not between", value1, value2, "snapshot");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIsNull() {
            addCriterion("timeout_action_time is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIsNotNull() {
            addCriterion("timeout_action_time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeEqualTo(Date value) {
            addCriterion("timeout_action_time =", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotEqualTo(Date value) {
            addCriterion("timeout_action_time <>", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeGreaterThan(Date value) {
            addCriterion("timeout_action_time >", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("timeout_action_time >=", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeLessThan(Date value) {
            addCriterion("timeout_action_time <", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeLessThanOrEqualTo(Date value) {
            addCriterion("timeout_action_time <=", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIn(List<Date> values) {
            addCriterion("timeout_action_time in", values, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotIn(List<Date> values) {
            addCriterion("timeout_action_time not in", values, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeBetween(Date value1, Date value2) {
            addCriterion("timeout_action_time between", value1, value2, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotBetween(Date value1, Date value2) {
            addCriterion("timeout_action_time not between", value1, value2, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andBuyerRateIsNull() {
            addCriterion("buyer_rate is null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateIsNotNull() {
            addCriterion("buyer_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateEqualTo(String value) {
            addCriterion("buyer_rate =", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotEqualTo(String value) {
            addCriterion("buyer_rate <>", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateGreaterThan(String value) {
            addCriterion("buyer_rate >", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_rate >=", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLessThan(String value) {
            addCriterion("buyer_rate <", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLessThanOrEqualTo(String value) {
            addCriterion("buyer_rate <=", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLike(String value) {
            addCriterion("buyer_rate like", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotLike(String value) {
            addCriterion("buyer_rate not like", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateIn(List<String> values) {
            addCriterion("buyer_rate in", values, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotIn(List<String> values) {
            addCriterion("buyer_rate not in", values, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateBetween(String value1, String value2) {
            addCriterion("buyer_rate between", value1, value2, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotBetween(String value1, String value2) {
            addCriterion("buyer_rate not between", value1, value2, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Long value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Long value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Long value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Long> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNull() {
            addCriterion("num_iid is null");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNotNull() {
            addCriterion("num_iid is not null");
            return (Criteria) this;
        }

        public Criteria andNumIidEqualTo(Long value) {
            addCriterion("num_iid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(Long value) {
            addCriterion("num_iid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(Long value) {
            addCriterion("num_iid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            addCriterion("num_iid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(Long value) {
            addCriterion("num_iid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(Long value) {
            addCriterion("num_iid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<Long> values) {
            addCriterion("num_iid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<Long> values) {
            addCriterion("num_iid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(Long value1, Long value2) {
            addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(Long value1, Long value2) {
            addCriterion("num_iid not between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andItemMealIdIsNull() {
            addCriterion("item_meal_id is null");
            return (Criteria) this;
        }

        public Criteria andItemMealIdIsNotNull() {
            addCriterion("item_meal_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemMealIdEqualTo(Long value) {
            addCriterion("item_meal_id =", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdNotEqualTo(Long value) {
            addCriterion("item_meal_id <>", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdGreaterThan(Long value) {
            addCriterion("item_meal_id >", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_meal_id >=", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdLessThan(Long value) {
            addCriterion("item_meal_id <", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdLessThanOrEqualTo(Long value) {
            addCriterion("item_meal_id <=", value, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdIn(List<Long> values) {
            addCriterion("item_meal_id in", values, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdNotIn(List<Long> values) {
            addCriterion("item_meal_id not in", values, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdBetween(Long value1, Long value2) {
            addCriterion("item_meal_id between", value1, value2, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andItemMealIdNotBetween(Long value1, Long value2) {
            addCriterion("item_meal_id not between", value1, value2, "itemMealId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("sku_id like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("sku_id not like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<String> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<String> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNull() {
            addCriterion("outer_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNotNull() {
            addCriterion("outer_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdEqualTo(String value) {
            addCriterion("outer_sku_id =", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotEqualTo(String value) {
            addCriterion("outer_sku_id <>", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThan(String value) {
            addCriterion("outer_sku_id >", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("outer_sku_id >=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThan(String value) {
            addCriterion("outer_sku_id <", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThanOrEqualTo(String value) {
            addCriterion("outer_sku_id <=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLike(String value) {
            addCriterion("outer_sku_id like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotLike(String value) {
            addCriterion("outer_sku_id not like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIn(List<String> values) {
            addCriterion("outer_sku_id in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotIn(List<String> values) {
            addCriterion("outer_sku_id not in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdBetween(String value1, String value2) {
            addCriterion("outer_sku_id between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotBetween(String value1, String value2) {
            addCriterion("outer_sku_id not between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNull() {
            addCriterion("order_from is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromIsNotNull() {
            addCriterion("order_from is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromEqualTo(String value) {
            addCriterion("order_from =", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotEqualTo(String value) {
            addCriterion("order_from <>", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThan(String value) {
            addCriterion("order_from >", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromGreaterThanOrEqualTo(String value) {
            addCriterion("order_from >=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThan(String value) {
            addCriterion("order_from <", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLessThanOrEqualTo(String value) {
            addCriterion("order_from <=", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromLike(String value) {
            addCriterion("order_from like", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotLike(String value) {
            addCriterion("order_from not like", value, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromIn(List<String> values) {
            addCriterion("order_from in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotIn(List<String> values) {
            addCriterion("order_from not in", values, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromBetween(String value1, String value2) {
            addCriterion("order_from between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andOrderFromNotBetween(String value1, String value2) {
            addCriterion("order_from not between", value1, value2, "orderFrom");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(BigDecimal value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(BigDecimal value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(BigDecimal value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(BigDecimal value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<BigDecimal> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<BigDecimal> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNull() {
            addCriterion("discount_fee is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNotNull() {
            addCriterion("discount_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeEqualTo(BigDecimal value) {
            addCriterion("discount_fee =", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotEqualTo(BigDecimal value) {
            addCriterion("discount_fee <>", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThan(BigDecimal value) {
            addCriterion("discount_fee >", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee >=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThan(BigDecimal value) {
            addCriterion("discount_fee <", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee <=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIn(List<BigDecimal> values) {
            addCriterion("discount_fee in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotIn(List<BigDecimal> values) {
            addCriterion("discount_fee not in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee not between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNull() {
            addCriterion("adjust_fee is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("adjust_fee is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(BigDecimal value) {
            addCriterion("adjust_fee =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(BigDecimal value) {
            addCriterion("adjust_fee <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(BigDecimal value) {
            addCriterion("adjust_fee >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_fee >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(BigDecimal value) {
            addCriterion("adjust_fee <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_fee <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<BigDecimal> values) {
            addCriterion("adjust_fee in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<BigDecimal> values) {
            addCriterion("adjust_fee not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_fee between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_fee not between", value1, value2, "adjustFee");
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

        public Criteria andSkuPropertiesNameIsNull() {
            addCriterion("sku_properties_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameIsNotNull() {
            addCriterion("sku_properties_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameEqualTo(String value) {
            addCriterion("sku_properties_name =", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotEqualTo(String value) {
            addCriterion("sku_properties_name <>", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameGreaterThan(String value) {
            addCriterion("sku_properties_name >", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_properties_name >=", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLessThan(String value) {
            addCriterion("sku_properties_name <", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLessThanOrEqualTo(String value) {
            addCriterion("sku_properties_name <=", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameLike(String value) {
            addCriterion("sku_properties_name like", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotLike(String value) {
            addCriterion("sku_properties_name not like", value, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameIn(List<String> values) {
            addCriterion("sku_properties_name in", values, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotIn(List<String> values) {
            addCriterion("sku_properties_name not in", values, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameBetween(String value1, String value2) {
            addCriterion("sku_properties_name between", value1, value2, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andSkuPropertiesNameNotBetween(String value1, String value2) {
            addCriterion("sku_properties_name not between", value1, value2, "skuPropertiesName");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNull() {
            addCriterion("refund_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundIdIsNotNull() {
            addCriterion("refund_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundIdEqualTo(Long value) {
            addCriterion("refund_id =", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            addCriterion("refund_id <>", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            addCriterion("refund_id >", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_id >=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThan(Long value) {
            addCriterion("refund_id <", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            addCriterion("refund_id <=", value, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdIn(List<Long> values) {
            addCriterion("refund_id in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            addCriterion("refund_id not in", values, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria) this;
        }

        public Criteria andIsOversoldIsNull() {
            addCriterion("is_oversold is null");
            return (Criteria) this;
        }

        public Criteria andIsOversoldIsNotNull() {
            addCriterion("is_oversold is not null");
            return (Criteria) this;
        }

        public Criteria andIsOversoldEqualTo(String value) {
            addCriterion("is_oversold =", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldNotEqualTo(String value) {
            addCriterion("is_oversold <>", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldGreaterThan(String value) {
            addCriterion("is_oversold >", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldGreaterThanOrEqualTo(String value) {
            addCriterion("is_oversold >=", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldLessThan(String value) {
            addCriterion("is_oversold <", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldLessThanOrEqualTo(String value) {
            addCriterion("is_oversold <=", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldLike(String value) {
            addCriterion("is_oversold like", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldNotLike(String value) {
            addCriterion("is_oversold not like", value, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldIn(List<String> values) {
            addCriterion("is_oversold in", values, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldNotIn(List<String> values) {
            addCriterion("is_oversold not in", values, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldBetween(String value1, String value2) {
            addCriterion("is_oversold between", value1, value2, "isOversold");
            return (Criteria) this;
        }

        public Criteria andIsOversoldNotBetween(String value1, String value2) {
            addCriterion("is_oversold not between", value1, value2, "isOversold");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIsNull() {
            addCriterion("consign_time is null");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIsNotNull() {
            addCriterion("consign_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsignTimeEqualTo(String value) {
            addCriterion("consign_time =", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotEqualTo(String value) {
            addCriterion("consign_time <>", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeGreaterThan(String value) {
            addCriterion("consign_time >", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("consign_time >=", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeLessThan(String value) {
            addCriterion("consign_time <", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeLessThanOrEqualTo(String value) {
            addCriterion("consign_time <=", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeLike(String value) {
            addCriterion("consign_time like", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotLike(String value) {
            addCriterion("consign_time not like", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIn(List<String> values) {
            addCriterion("consign_time in", values, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotIn(List<String> values) {
            addCriterion("consign_time not in", values, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeBetween(String value1, String value2) {
            addCriterion("consign_time between", value1, value2, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotBetween(String value1, String value2) {
            addCriterion("consign_time not between", value1, value2, "consignTime");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIsNull() {
            addCriterion("shipping_type is null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIsNotNull() {
            addCriterion("shipping_type is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeEqualTo(String value) {
            addCriterion("shipping_type =", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotEqualTo(String value) {
            addCriterion("shipping_type <>", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThan(String value) {
            addCriterion("shipping_type >", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_type >=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThan(String value) {
            addCriterion("shipping_type <", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThanOrEqualTo(String value) {
            addCriterion("shipping_type <=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLike(String value) {
            addCriterion("shipping_type like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotLike(String value) {
            addCriterion("shipping_type not like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIn(List<String> values) {
            addCriterion("shipping_type in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotIn(List<String> values) {
            addCriterion("shipping_type not in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeBetween(String value1, String value2) {
            addCriterion("shipping_type between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotBetween(String value1, String value2) {
            addCriterion("shipping_type not between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andBindOidIsNull() {
            addCriterion("bind_oid is null");
            return (Criteria) this;
        }

        public Criteria andBindOidIsNotNull() {
            addCriterion("bind_oid is not null");
            return (Criteria) this;
        }

        public Criteria andBindOidEqualTo(Long value) {
            addCriterion("bind_oid =", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidNotEqualTo(Long value) {
            addCriterion("bind_oid <>", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidGreaterThan(Long value) {
            addCriterion("bind_oid >", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidGreaterThanOrEqualTo(Long value) {
            addCriterion("bind_oid >=", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidLessThan(Long value) {
            addCriterion("bind_oid <", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidLessThanOrEqualTo(Long value) {
            addCriterion("bind_oid <=", value, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidIn(List<Long> values) {
            addCriterion("bind_oid in", values, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidNotIn(List<Long> values) {
            addCriterion("bind_oid not in", values, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidBetween(Long value1, Long value2) {
            addCriterion("bind_oid between", value1, value2, "bindOid");
            return (Criteria) this;
        }

        public Criteria andBindOidNotBetween(Long value1, Long value2) {
            addCriterion("bind_oid not between", value1, value2, "bindOid");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIsNull() {
            addCriterion("logistics_company is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIsNotNull() {
            addCriterion("logistics_company is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyEqualTo(String value) {
            addCriterion("logistics_company =", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotEqualTo(String value) {
            addCriterion("logistics_company <>", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThan(String value) {
            addCriterion("logistics_company >", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_company >=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThan(String value) {
            addCriterion("logistics_company <", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThanOrEqualTo(String value) {
            addCriterion("logistics_company <=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLike(String value) {
            addCriterion("logistics_company like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotLike(String value) {
            addCriterion("logistics_company not like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIn(List<String> values) {
            addCriterion("logistics_company in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotIn(List<String> values) {
            addCriterion("logistics_company not in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyBetween(String value1, String value2) {
            addCriterion("logistics_company between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotBetween(String value1, String value2) {
            addCriterion("logistics_company not between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIsNull() {
            addCriterion("simple_name is null");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIsNotNull() {
            addCriterion("simple_name is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleNameEqualTo(String value) {
            addCriterion("simple_name =", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotEqualTo(String value) {
            addCriterion("simple_name <>", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameGreaterThan(String value) {
            addCriterion("simple_name >", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameGreaterThanOrEqualTo(String value) {
            addCriterion("simple_name >=", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLessThan(String value) {
            addCriterion("simple_name <", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLessThanOrEqualTo(String value) {
            addCriterion("simple_name <=", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameLike(String value) {
            addCriterion("simple_name like", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotLike(String value) {
            addCriterion("simple_name not like", value, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameIn(List<String> values) {
            addCriterion("simple_name in", values, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotIn(List<String> values) {
            addCriterion("simple_name not in", values, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameBetween(String value1, String value2) {
            addCriterion("simple_name between", value1, value2, "simpleName");
            return (Criteria) this;
        }

        public Criteria andSimpleNameNotBetween(String value1, String value2) {
            addCriterion("simple_name not between", value1, value2, "simpleName");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNull() {
            addCriterion("invoice_no is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("invoice_no is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(String value) {
            addCriterion("invoice_no =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(String value) {
            addCriterion("invoice_no <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(String value) {
            addCriterion("invoice_no >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_no >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(String value) {
            addCriterion("invoice_no <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(String value) {
            addCriterion("invoice_no <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLike(String value) {
            addCriterion("invoice_no like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotLike(String value) {
            addCriterion("invoice_no not like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<String> values) {
            addCriterion("invoice_no in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<String> values) {
            addCriterion("invoice_no not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(String value1, String value2) {
            addCriterion("invoice_no between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(String value1, String value2) {
            addCriterion("invoice_no not between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoIsNull() {
            addCriterion("is_daixiao is null");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoIsNotNull() {
            addCriterion("is_daixiao is not null");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoEqualTo(String value) {
            addCriterion("is_daixiao =", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoNotEqualTo(String value) {
            addCriterion("is_daixiao <>", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoGreaterThan(String value) {
            addCriterion("is_daixiao >", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoGreaterThanOrEqualTo(String value) {
            addCriterion("is_daixiao >=", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoLessThan(String value) {
            addCriterion("is_daixiao <", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoLessThanOrEqualTo(String value) {
            addCriterion("is_daixiao <=", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoLike(String value) {
            addCriterion("is_daixiao like", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoNotLike(String value) {
            addCriterion("is_daixiao not like", value, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoIn(List<String> values) {
            addCriterion("is_daixiao in", values, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoNotIn(List<String> values) {
            addCriterion("is_daixiao not in", values, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoBetween(String value1, String value2) {
            addCriterion("is_daixiao between", value1, value2, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andIsDaixiaoNotBetween(String value1, String value2) {
            addCriterion("is_daixiao not between", value1, value2, "isDaixiao");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeIsNull() {
            addCriterion("divide_order_fee is null");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeIsNotNull() {
            addCriterion("divide_order_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeEqualTo(BigDecimal value) {
            addCriterion("divide_order_fee =", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeNotEqualTo(BigDecimal value) {
            addCriterion("divide_order_fee <>", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeGreaterThan(BigDecimal value) {
            addCriterion("divide_order_fee >", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_order_fee >=", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeLessThan(BigDecimal value) {
            addCriterion("divide_order_fee <", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_order_fee <=", value, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeIn(List<BigDecimal> values) {
            addCriterion("divide_order_fee in", values, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeNotIn(List<BigDecimal> values) {
            addCriterion("divide_order_fee not in", values, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_order_fee between", value1, value2, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andDivideOrderFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_order_fee not between", value1, value2, "divideOrderFee");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountIsNull() {
            addCriterion("part_mjz_discount is null");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountIsNotNull() {
            addCriterion("part_mjz_discount is not null");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountEqualTo(String value) {
            addCriterion("part_mjz_discount =", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountNotEqualTo(String value) {
            addCriterion("part_mjz_discount <>", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountGreaterThan(String value) {
            addCriterion("part_mjz_discount >", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("part_mjz_discount >=", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountLessThan(String value) {
            addCriterion("part_mjz_discount <", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountLessThanOrEqualTo(String value) {
            addCriterion("part_mjz_discount <=", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountLike(String value) {
            addCriterion("part_mjz_discount like", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountNotLike(String value) {
            addCriterion("part_mjz_discount not like", value, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountIn(List<String> values) {
            addCriterion("part_mjz_discount in", values, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountNotIn(List<String> values) {
            addCriterion("part_mjz_discount not in", values, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountBetween(String value1, String value2) {
            addCriterion("part_mjz_discount between", value1, value2, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andPartMjzDiscountNotBetween(String value1, String value2) {
            addCriterion("part_mjz_discount not between", value1, value2, "partMjzDiscount");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIsNull() {
            addCriterion("store_code is null");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIsNotNull() {
            addCriterion("store_code is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCodeEqualTo(String value) {
            addCriterion("store_code =", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotEqualTo(String value) {
            addCriterion("store_code <>", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeGreaterThan(String value) {
            addCriterion("store_code >", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeGreaterThanOrEqualTo(String value) {
            addCriterion("store_code >=", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLessThan(String value) {
            addCriterion("store_code <", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLessThanOrEqualTo(String value) {
            addCriterion("store_code <=", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeLike(String value) {
            addCriterion("store_code like", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotLike(String value) {
            addCriterion("store_code not like", value, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeIn(List<String> values) {
            addCriterion("store_code in", values, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotIn(List<String> values) {
            addCriterion("store_code not in", values, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeBetween(String value1, String value2) {
            addCriterion("store_code between", value1, value2, "storeCode");
            return (Criteria) this;
        }

        public Criteria andStoreCodeNotBetween(String value1, String value2) {
            addCriterion("store_code not between", value1, value2, "storeCode");
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