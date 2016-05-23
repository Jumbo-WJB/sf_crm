package com.shufensoft.crm.biz.domain.generation.trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderYZExample {
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

    public OrderYZExample() {
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

    public void addSkuUniqueCodeQueryColumn() {
        this.queryColumns.add("sku_unique_code");
    }

    public void addMaxSkuUniqueCodeQueryColumn() {
        this.queryColumns.add("max(sku_unique_code) max_sku_unique_code");
    }

    public void addMinSkuUniqueCodeQueryColumn() {
        this.queryColumns.add("min(sku_unique_code) min_sku_unique_code");
    }

    public void addAvgSkuUniqueCodeQueryColumn() {
        this.queryColumns.add(" avg(sku_unique_code) avg_sku_unique_code");
    }

    public void addCountSkuUniqueCodeQueryColumn() {
        this.queryColumns.add(" count(sku_unique_code) count_sku_unique_code");
    }

    public void addSumSkuUniqueCodeQueryColumn() {
        this.queryColumns.add(" sum(sku_unique_code) sum_sku_unique_code");
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

    public void addUserIdYzQueryColumn() {
        this.queryColumns.add("user_id_yz");
    }

    public void addMaxUserIdYzQueryColumn() {
        this.queryColumns.add("max(user_id_yz) max_user_id_yz");
    }

    public void addMinUserIdYzQueryColumn() {
        this.queryColumns.add("min(user_id_yz) min_user_id_yz");
    }

    public void addAvgUserIdYzQueryColumn() {
        this.queryColumns.add(" avg(user_id_yz) avg_user_id_yz");
    }

    public void addCountUserIdYzQueryColumn() {
        this.queryColumns.add(" count(user_id_yz) count_user_id_yz");
    }

    public void addSumUserIdYzQueryColumn() {
        this.queryColumns.add(" sum(user_id_yz) sum_user_id_yz");
    }

    public void addOuterItemIdQueryColumn() {
        this.queryColumns.add("outer_item_id");
    }

    public void addMaxOuterItemIdQueryColumn() {
        this.queryColumns.add("max(outer_item_id) max_outer_item_id");
    }

    public void addMinOuterItemIdQueryColumn() {
        this.queryColumns.add("min(outer_item_id) min_outer_item_id");
    }

    public void addAvgOuterItemIdQueryColumn() {
        this.queryColumns.add(" avg(outer_item_id) avg_outer_item_id");
    }

    public void addCountOuterItemIdQueryColumn() {
        this.queryColumns.add(" count(outer_item_id) count_outer_item_id");
    }

    public void addSumOuterItemIdQueryColumn() {
        this.queryColumns.add(" sum(outer_item_id) sum_outer_item_id");
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

    public void addItemTypeQueryColumn() {
        this.queryColumns.add("item_type");
    }

    public void addMaxItemTypeQueryColumn() {
        this.queryColumns.add("max(item_type) max_item_type");
    }

    public void addMinItemTypeQueryColumn() {
        this.queryColumns.add("min(item_type) min_item_type");
    }

    public void addAvgItemTypeQueryColumn() {
        this.queryColumns.add(" avg(item_type) avg_item_type");
    }

    public void addCountItemTypeQueryColumn() {
        this.queryColumns.add(" count(item_type) count_item_type");
    }

    public void addSumItemTypeQueryColumn() {
        this.queryColumns.add(" sum(item_type) sum_item_type");
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
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

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeIsNull() {
            addCriterion("sku_unique_code is null");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeIsNotNull() {
            addCriterion("sku_unique_code is not null");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeEqualTo(String value) {
            addCriterion("sku_unique_code =", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeNotEqualTo(String value) {
            addCriterion("sku_unique_code <>", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeGreaterThan(String value) {
            addCriterion("sku_unique_code >", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sku_unique_code >=", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeLessThan(String value) {
            addCriterion("sku_unique_code <", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeLessThanOrEqualTo(String value) {
            addCriterion("sku_unique_code <=", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeLike(String value) {
            addCriterion("sku_unique_code like", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeNotLike(String value) {
            addCriterion("sku_unique_code not like", value, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeIn(List<String> values) {
            addCriterion("sku_unique_code in", values, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeNotIn(List<String> values) {
            addCriterion("sku_unique_code not in", values, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeBetween(String value1, String value2) {
            addCriterion("sku_unique_code between", value1, value2, "skuUniqueCode");
            return (Criteria) this;
        }

        public Criteria andSkuUniqueCodeNotBetween(String value1, String value2) {
            addCriterion("sku_unique_code not between", value1, value2, "skuUniqueCode");
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

        public Criteria andUserIdYzIsNull() {
            addCriterion("user_id_yz is null");
            return (Criteria) this;
        }

        public Criteria andUserIdYzIsNotNull() {
            addCriterion("user_id_yz is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdYzEqualTo(Long value) {
            addCriterion("user_id_yz =", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotEqualTo(Long value) {
            addCriterion("user_id_yz <>", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzGreaterThan(Long value) {
            addCriterion("user_id_yz >", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_yz >=", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzLessThan(Long value) {
            addCriterion("user_id_yz <", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzLessThanOrEqualTo(Long value) {
            addCriterion("user_id_yz <=", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzIn(List<Long> values) {
            addCriterion("user_id_yz in", values, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotIn(List<Long> values) {
            addCriterion("user_id_yz not in", values, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzBetween(Long value1, Long value2) {
            addCriterion("user_id_yz between", value1, value2, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotBetween(Long value1, Long value2) {
            addCriterion("user_id_yz not between", value1, value2, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdIsNull() {
            addCriterion("outer_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdIsNotNull() {
            addCriterion("outer_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdEqualTo(String value) {
            addCriterion("outer_item_id =", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdNotEqualTo(String value) {
            addCriterion("outer_item_id <>", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdGreaterThan(String value) {
            addCriterion("outer_item_id >", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("outer_item_id >=", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdLessThan(String value) {
            addCriterion("outer_item_id <", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdLessThanOrEqualTo(String value) {
            addCriterion("outer_item_id <=", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdLike(String value) {
            addCriterion("outer_item_id like", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdNotLike(String value) {
            addCriterion("outer_item_id not like", value, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdIn(List<String> values) {
            addCriterion("outer_item_id in", values, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdNotIn(List<String> values) {
            addCriterion("outer_item_id not in", values, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdBetween(String value1, String value2) {
            addCriterion("outer_item_id between", value1, value2, "outerItemId");
            return (Criteria) this;
        }

        public Criteria andOuterItemIdNotBetween(String value1, String value2) {
            addCriterion("outer_item_id not between", value1, value2, "outerItemId");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Integer value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Integer value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Integer value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Integer value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Integer> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Integer> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Integer value1, Integer value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
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