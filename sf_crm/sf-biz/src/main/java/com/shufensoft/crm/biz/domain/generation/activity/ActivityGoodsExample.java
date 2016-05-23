package com.shufensoft.crm.biz.domain.generation.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityGoodsExample {
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

    public ActivityGoodsExample() {
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

    public void addCountDistinctIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT id) count_distinct_id");
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

    public void addCountDistinctGmtCreatedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT gmt_created) count_distinct_gmt_created");
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

    public void addCountDistinctGmtModifiedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT gmt_modified) count_distinct_gmt_modified");
    }

    public void addSumGmtModifiedQueryColumn() {
        this.queryColumns.add(" sum(gmt_modified) sum_gmt_modified");
    }

    public void addCreatedByQueryColumn() {
        this.queryColumns.add("created_by");
    }

    public void addMaxCreatedByQueryColumn() {
        this.queryColumns.add("max(created_by) max_created_by");
    }

    public void addMinCreatedByQueryColumn() {
        this.queryColumns.add("min(created_by) min_created_by");
    }

    public void addAvgCreatedByQueryColumn() {
        this.queryColumns.add(" avg(created_by) avg_created_by");
    }

    public void addCountCreatedByQueryColumn() {
        this.queryColumns.add(" count(created_by) count_created_by");
    }

    public void addCountDistinctCreatedByQueryColumn() {
        this.queryColumns.add(" count( DISTINCT created_by) count_distinct_created_by");
    }

    public void addSumCreatedByQueryColumn() {
        this.queryColumns.add(" sum(created_by) sum_created_by");
    }

    public void addModifiedByQueryColumn() {
        this.queryColumns.add("modified_by");
    }

    public void addMaxModifiedByQueryColumn() {
        this.queryColumns.add("max(modified_by) max_modified_by");
    }

    public void addMinModifiedByQueryColumn() {
        this.queryColumns.add("min(modified_by) min_modified_by");
    }

    public void addAvgModifiedByQueryColumn() {
        this.queryColumns.add(" avg(modified_by) avg_modified_by");
    }

    public void addCountModifiedByQueryColumn() {
        this.queryColumns.add(" count(modified_by) count_modified_by");
    }

    public void addCountDistinctModifiedByQueryColumn() {
        this.queryColumns.add(" count( DISTINCT modified_by) count_distinct_modified_by");
    }

    public void addSumModifiedByQueryColumn() {
        this.queryColumns.add(" sum(modified_by) sum_modified_by");
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

    public void addCountDistinctIsDeletedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT is_deleted) count_distinct_is_deleted");
    }

    public void addSumIsDeletedQueryColumn() {
        this.queryColumns.add(" sum(is_deleted) sum_is_deleted");
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

    public void addCountDistinctSellerIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT seller_id) count_distinct_seller_id");
    }

    public void addSumSellerIdQueryColumn() {
        this.queryColumns.add(" sum(seller_id) sum_seller_id");
    }

    public void addActivityIdQueryColumn() {
        this.queryColumns.add("activity_id");
    }

    public void addMaxActivityIdQueryColumn() {
        this.queryColumns.add("max(activity_id) max_activity_id");
    }

    public void addMinActivityIdQueryColumn() {
        this.queryColumns.add("min(activity_id) min_activity_id");
    }

    public void addAvgActivityIdQueryColumn() {
        this.queryColumns.add(" avg(activity_id) avg_activity_id");
    }

    public void addCountActivityIdQueryColumn() {
        this.queryColumns.add(" count(activity_id) count_activity_id");
    }

    public void addCountDistinctActivityIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT activity_id) count_distinct_activity_id");
    }

    public void addSumActivityIdQueryColumn() {
        this.queryColumns.add(" sum(activity_id) sum_activity_id");
    }

    public void addActivityGoodsIdQueryColumn() {
        this.queryColumns.add("activity_goods_id");
    }

    public void addMaxActivityGoodsIdQueryColumn() {
        this.queryColumns.add("max(activity_goods_id) max_activity_goods_id");
    }

    public void addMinActivityGoodsIdQueryColumn() {
        this.queryColumns.add("min(activity_goods_id) min_activity_goods_id");
    }

    public void addAvgActivityGoodsIdQueryColumn() {
        this.queryColumns.add(" avg(activity_goods_id) avg_activity_goods_id");
    }

    public void addCountActivityGoodsIdQueryColumn() {
        this.queryColumns.add(" count(activity_goods_id) count_activity_goods_id");
    }

    public void addCountDistinctActivityGoodsIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT activity_goods_id) count_distinct_activity_goods_id");
    }

    public void addSumActivityGoodsIdQueryColumn() {
        this.queryColumns.add(" sum(activity_goods_id) sum_activity_goods_id");
    }

    public void addGoodsIdQueryColumn() {
        this.queryColumns.add("goods_id");
    }

    public void addMaxGoodsIdQueryColumn() {
        this.queryColumns.add("max(goods_id) max_goods_id");
    }

    public void addMinGoodsIdQueryColumn() {
        this.queryColumns.add("min(goods_id) min_goods_id");
    }

    public void addAvgGoodsIdQueryColumn() {
        this.queryColumns.add(" avg(goods_id) avg_goods_id");
    }

    public void addCountGoodsIdQueryColumn() {
        this.queryColumns.add(" count(goods_id) count_goods_id");
    }

    public void addCountDistinctGoodsIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_id) count_distinct_goods_id");
    }

    public void addSumGoodsIdQueryColumn() {
        this.queryColumns.add(" sum(goods_id) sum_goods_id");
    }

    public void addGoodsNameQueryColumn() {
        this.queryColumns.add("goods_name");
    }

    public void addMaxGoodsNameQueryColumn() {
        this.queryColumns.add("max(goods_name) max_goods_name");
    }

    public void addMinGoodsNameQueryColumn() {
        this.queryColumns.add("min(goods_name) min_goods_name");
    }

    public void addAvgGoodsNameQueryColumn() {
        this.queryColumns.add(" avg(goods_name) avg_goods_name");
    }

    public void addCountGoodsNameQueryColumn() {
        this.queryColumns.add(" count(goods_name) count_goods_name");
    }

    public void addCountDistinctGoodsNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_name) count_distinct_goods_name");
    }

    public void addSumGoodsNameQueryColumn() {
        this.queryColumns.add(" sum(goods_name) sum_goods_name");
    }

    public void addGoodsUrlQueryColumn() {
        this.queryColumns.add("goods_url");
    }

    public void addMaxGoodsUrlQueryColumn() {
        this.queryColumns.add("max(goods_url) max_goods_url");
    }

    public void addMinGoodsUrlQueryColumn() {
        this.queryColumns.add("min(goods_url) min_goods_url");
    }

    public void addAvgGoodsUrlQueryColumn() {
        this.queryColumns.add(" avg(goods_url) avg_goods_url");
    }

    public void addCountGoodsUrlQueryColumn() {
        this.queryColumns.add(" count(goods_url) count_goods_url");
    }

    public void addCountDistinctGoodsUrlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_url) count_distinct_goods_url");
    }

    public void addSumGoodsUrlQueryColumn() {
        this.queryColumns.add(" sum(goods_url) sum_goods_url");
    }

    public void addGoodsLinkQueryColumn() {
        this.queryColumns.add("goods_link");
    }

    public void addMaxGoodsLinkQueryColumn() {
        this.queryColumns.add("max(goods_link) max_goods_link");
    }

    public void addMinGoodsLinkQueryColumn() {
        this.queryColumns.add("min(goods_link) min_goods_link");
    }

    public void addAvgGoodsLinkQueryColumn() {
        this.queryColumns.add(" avg(goods_link) avg_goods_link");
    }

    public void addCountGoodsLinkQueryColumn() {
        this.queryColumns.add(" count(goods_link) count_goods_link");
    }

    public void addCountDistinctGoodsLinkQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_link) count_distinct_goods_link");
    }

    public void addSumGoodsLinkQueryColumn() {
        this.queryColumns.add(" sum(goods_link) sum_goods_link");
    }

    public void addGoodsPriceQueryColumn() {
        this.queryColumns.add("goods_price");
    }

    public void addMaxGoodsPriceQueryColumn() {
        this.queryColumns.add("max(goods_price) max_goods_price");
    }

    public void addMinGoodsPriceQueryColumn() {
        this.queryColumns.add("min(goods_price) min_goods_price");
    }

    public void addAvgGoodsPriceQueryColumn() {
        this.queryColumns.add(" avg(goods_price) avg_goods_price");
    }

    public void addCountGoodsPriceQueryColumn() {
        this.queryColumns.add(" count(goods_price) count_goods_price");
    }

    public void addCountDistinctGoodsPriceQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_price) count_distinct_goods_price");
    }

    public void addSumGoodsPriceQueryColumn() {
        this.queryColumns.add(" sum(goods_price) sum_goods_price");
    }

    public void addGoodsQuantityQueryColumn() {
        this.queryColumns.add("goods_quantity");
    }

    public void addMaxGoodsQuantityQueryColumn() {
        this.queryColumns.add("max(goods_quantity) max_goods_quantity");
    }

    public void addMinGoodsQuantityQueryColumn() {
        this.queryColumns.add("min(goods_quantity) min_goods_quantity");
    }

    public void addAvgGoodsQuantityQueryColumn() {
        this.queryColumns.add(" avg(goods_quantity) avg_goods_quantity");
    }

    public void addCountGoodsQuantityQueryColumn() {
        this.queryColumns.add(" count(goods_quantity) count_goods_quantity");
    }

    public void addCountDistinctGoodsQuantityQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_quantity) count_distinct_goods_quantity");
    }

    public void addSumGoodsQuantityQueryColumn() {
        this.queryColumns.add(" sum(goods_quantity) sum_goods_quantity");
    }

    public void addGoodsSourceQueryColumn() {
        this.queryColumns.add("goods_source");
    }

    public void addMaxGoodsSourceQueryColumn() {
        this.queryColumns.add("max(goods_source) max_goods_source");
    }

    public void addMinGoodsSourceQueryColumn() {
        this.queryColumns.add("min(goods_source) min_goods_source");
    }

    public void addAvgGoodsSourceQueryColumn() {
        this.queryColumns.add(" avg(goods_source) avg_goods_source");
    }

    public void addCountGoodsSourceQueryColumn() {
        this.queryColumns.add(" count(goods_source) count_goods_source");
    }

    public void addCountDistinctGoodsSourceQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_source) count_distinct_goods_source");
    }

    public void addSumGoodsSourceQueryColumn() {
        this.queryColumns.add(" sum(goods_source) sum_goods_source");
    }

    public void addShopNameQueryColumn() {
        this.queryColumns.add("shop_name");
    }

    public void addMaxShopNameQueryColumn() {
        this.queryColumns.add("max(shop_name) max_shop_name");
    }

    public void addMinShopNameQueryColumn() {
        this.queryColumns.add("min(shop_name) min_shop_name");
    }

    public void addAvgShopNameQueryColumn() {
        this.queryColumns.add(" avg(shop_name) avg_shop_name");
    }

    public void addCountShopNameQueryColumn() {
        this.queryColumns.add(" count(shop_name) count_shop_name");
    }

    public void addCountDistinctShopNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT shop_name) count_distinct_shop_name");
    }

    public void addSumShopNameQueryColumn() {
        this.queryColumns.add(" sum(shop_name) sum_shop_name");
    }

    public void addCashbackTypeQueryColumn() {
        this.queryColumns.add("cashback_type");
    }

    public void addMaxCashbackTypeQueryColumn() {
        this.queryColumns.add("max(cashback_type) max_cashback_type");
    }

    public void addMinCashbackTypeQueryColumn() {
        this.queryColumns.add("min(cashback_type) min_cashback_type");
    }

    public void addAvgCashbackTypeQueryColumn() {
        this.queryColumns.add(" avg(cashback_type) avg_cashback_type");
    }

    public void addCountCashbackTypeQueryColumn() {
        this.queryColumns.add(" count(cashback_type) count_cashback_type");
    }

    public void addCountDistinctCashbackTypeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT cashback_type) count_distinct_cashback_type");
    }

    public void addSumCashbackTypeQueryColumn() {
        this.queryColumns.add(" sum(cashback_type) sum_cashback_type");
    }

    public void addHbPoolIdQueryColumn() {
        this.queryColumns.add("hb_pool_id");
    }

    public void addMaxHbPoolIdQueryColumn() {
        this.queryColumns.add("max(hb_pool_id) max_hb_pool_id");
    }

    public void addMinHbPoolIdQueryColumn() {
        this.queryColumns.add("min(hb_pool_id) min_hb_pool_id");
    }

    public void addAvgHbPoolIdQueryColumn() {
        this.queryColumns.add(" avg(hb_pool_id) avg_hb_pool_id");
    }

    public void addCountHbPoolIdQueryColumn() {
        this.queryColumns.add(" count(hb_pool_id) count_hb_pool_id");
    }

    public void addCountDistinctHbPoolIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT hb_pool_id) count_distinct_hb_pool_id");
    }

    public void addSumHbPoolIdQueryColumn() {
        this.queryColumns.add(" sum(hb_pool_id) sum_hb_pool_id");
    }

    public void addHbcashAmountQueryColumn() {
        this.queryColumns.add("hbcash_amount");
    }

    public void addMaxHbcashAmountQueryColumn() {
        this.queryColumns.add("max(hbcash_amount) max_hbcash_amount");
    }

    public void addMinHbcashAmountQueryColumn() {
        this.queryColumns.add("min(hbcash_amount) min_hbcash_amount");
    }

    public void addAvgHbcashAmountQueryColumn() {
        this.queryColumns.add(" avg(hbcash_amount) avg_hbcash_amount");
    }

    public void addCountHbcashAmountQueryColumn() {
        this.queryColumns.add(" count(hbcash_amount) count_hbcash_amount");
    }

    public void addCountDistinctHbcashAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT hbcash_amount) count_distinct_hbcash_amount");
    }

    public void addSumHbcashAmountQueryColumn() {
        this.queryColumns.add(" sum(hbcash_amount) sum_hbcash_amount");
    }

    public void addApplyRangeQueryColumn() {
        this.queryColumns.add("apply_range");
    }

    public void addMaxApplyRangeQueryColumn() {
        this.queryColumns.add("max(apply_range) max_apply_range");
    }

    public void addMinApplyRangeQueryColumn() {
        this.queryColumns.add("min(apply_range) min_apply_range");
    }

    public void addAvgApplyRangeQueryColumn() {
        this.queryColumns.add(" avg(apply_range) avg_apply_range");
    }

    public void addCountApplyRangeQueryColumn() {
        this.queryColumns.add(" count(apply_range) count_apply_range");
    }

    public void addCountDistinctApplyRangeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT apply_range) count_distinct_apply_range");
    }

    public void addSumApplyRangeQueryColumn() {
        this.queryColumns.add(" sum(apply_range) sum_apply_range");
    }

    public void addReleaseTimeQueryColumn() {
        this.queryColumns.add("release_time");
    }

    public void addMaxReleaseTimeQueryColumn() {
        this.queryColumns.add("max(release_time) max_release_time");
    }

    public void addMinReleaseTimeQueryColumn() {
        this.queryColumns.add("min(release_time) min_release_time");
    }

    public void addAvgReleaseTimeQueryColumn() {
        this.queryColumns.add(" avg(release_time) avg_release_time");
    }

    public void addCountReleaseTimeQueryColumn() {
        this.queryColumns.add(" count(release_time) count_release_time");
    }

    public void addCountDistinctReleaseTimeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT release_time) count_distinct_release_time");
    }

    public void addSumReleaseTimeQueryColumn() {
        this.queryColumns.add(" sum(release_time) sum_release_time");
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

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNull() {
            addCriterion("modified_by is null");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNotNull() {
            addCriterion("modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedByEqualTo(String value) {
            addCriterion("modified_by =", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotEqualTo(String value) {
            addCriterion("modified_by <>", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThan(String value) {
            addCriterion("modified_by >", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThanOrEqualTo(String value) {
            addCriterion("modified_by >=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThan(String value) {
            addCriterion("modified_by <", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThanOrEqualTo(String value) {
            addCriterion("modified_by <=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLike(String value) {
            addCriterion("modified_by like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotLike(String value) {
            addCriterion("modified_by not like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIn(List<String> values) {
            addCriterion("modified_by in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotIn(List<String> values) {
            addCriterion("modified_by not in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByBetween(String value1, String value2) {
            addCriterion("modified_by between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotBetween(String value1, String value2) {
            addCriterion("modified_by not between", value1, value2, "modifiedBy");
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdIsNull() {
            addCriterion("activity_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdIsNotNull() {
            addCriterion("activity_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdEqualTo(Long value) {
            addCriterion("activity_goods_id =", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdNotEqualTo(Long value) {
            addCriterion("activity_goods_id <>", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdGreaterThan(Long value) {
            addCriterion("activity_goods_id >", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_goods_id >=", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdLessThan(Long value) {
            addCriterion("activity_goods_id <", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_goods_id <=", value, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdIn(List<Long> values) {
            addCriterion("activity_goods_id in", values, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdNotIn(List<Long> values) {
            addCriterion("activity_goods_id not in", values, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdBetween(Long value1, Long value2) {
            addCriterion("activity_goods_id between", value1, value2, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andActivityGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_goods_id not between", value1, value2, "activityGoodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIsNull() {
            addCriterion("goods_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIsNotNull() {
            addCriterion("goods_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlEqualTo(String value) {
            addCriterion("goods_url =", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotEqualTo(String value) {
            addCriterion("goods_url <>", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThan(String value) {
            addCriterion("goods_url >", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_url >=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThan(String value) {
            addCriterion("goods_url <", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_url <=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLike(String value) {
            addCriterion("goods_url like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotLike(String value) {
            addCriterion("goods_url not like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIn(List<String> values) {
            addCriterion("goods_url in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotIn(List<String> values) {
            addCriterion("goods_url not in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlBetween(String value1, String value2) {
            addCriterion("goods_url between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotBetween(String value1, String value2) {
            addCriterion("goods_url not between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkIsNull() {
            addCriterion("goods_link is null");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkIsNotNull() {
            addCriterion("goods_link is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkEqualTo(String value) {
            addCriterion("goods_link =", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkNotEqualTo(String value) {
            addCriterion("goods_link <>", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkGreaterThan(String value) {
            addCriterion("goods_link >", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkGreaterThanOrEqualTo(String value) {
            addCriterion("goods_link >=", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkLessThan(String value) {
            addCriterion("goods_link <", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkLessThanOrEqualTo(String value) {
            addCriterion("goods_link <=", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkLike(String value) {
            addCriterion("goods_link like", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkNotLike(String value) {
            addCriterion("goods_link not like", value, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkIn(List<String> values) {
            addCriterion("goods_link in", values, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkNotIn(List<String> values) {
            addCriterion("goods_link not in", values, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkBetween(String value1, String value2) {
            addCriterion("goods_link between", value1, value2, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsLinkNotBetween(String value1, String value2) {
            addCriterion("goods_link not between", value1, value2, "goodsLink");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Integer value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Integer value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Integer value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Integer value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Integer> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Integer> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIsNull() {
            addCriterion("goods_quantity is null");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIsNotNull() {
            addCriterion("goods_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityEqualTo(Integer value) {
            addCriterion("goods_quantity =", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotEqualTo(Integer value) {
            addCriterion("goods_quantity <>", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityGreaterThan(Integer value) {
            addCriterion("goods_quantity >", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_quantity >=", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityLessThan(Integer value) {
            addCriterion("goods_quantity <", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("goods_quantity <=", value, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityIn(List<Integer> values) {
            addCriterion("goods_quantity in", values, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotIn(List<Integer> values) {
            addCriterion("goods_quantity not in", values, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityBetween(Integer value1, Integer value2) {
            addCriterion("goods_quantity between", value1, value2, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_quantity not between", value1, value2, "goodsQuantity");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceIsNull() {
            addCriterion("goods_source is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceIsNotNull() {
            addCriterion("goods_source is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceEqualTo(String value) {
            addCriterion("goods_source =", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotEqualTo(String value) {
            addCriterion("goods_source <>", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceGreaterThan(String value) {
            addCriterion("goods_source >", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_source >=", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLessThan(String value) {
            addCriterion("goods_source <", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLessThanOrEqualTo(String value) {
            addCriterion("goods_source <=", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLike(String value) {
            addCriterion("goods_source like", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotLike(String value) {
            addCriterion("goods_source not like", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceIn(List<String> values) {
            addCriterion("goods_source in", values, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotIn(List<String> values) {
            addCriterion("goods_source not in", values, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceBetween(String value1, String value2) {
            addCriterion("goods_source between", value1, value2, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotBetween(String value1, String value2) {
            addCriterion("goods_source not between", value1, value2, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeIsNull() {
            addCriterion("cashback_type is null");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeIsNotNull() {
            addCriterion("cashback_type is not null");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeEqualTo(String value) {
            addCriterion("cashback_type =", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeNotEqualTo(String value) {
            addCriterion("cashback_type <>", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeGreaterThan(String value) {
            addCriterion("cashback_type >", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cashback_type >=", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeLessThan(String value) {
            addCriterion("cashback_type <", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeLessThanOrEqualTo(String value) {
            addCriterion("cashback_type <=", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeLike(String value) {
            addCriterion("cashback_type like", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeNotLike(String value) {
            addCriterion("cashback_type not like", value, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeIn(List<String> values) {
            addCriterion("cashback_type in", values, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeNotIn(List<String> values) {
            addCriterion("cashback_type not in", values, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeBetween(String value1, String value2) {
            addCriterion("cashback_type between", value1, value2, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andCashbackTypeNotBetween(String value1, String value2) {
            addCriterion("cashback_type not between", value1, value2, "cashbackType");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIsNull() {
            addCriterion("hb_pool_id is null");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIsNotNull() {
            addCriterion("hb_pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdEqualTo(String value) {
            addCriterion("hb_pool_id =", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotEqualTo(String value) {
            addCriterion("hb_pool_id <>", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThan(String value) {
            addCriterion("hb_pool_id >", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThanOrEqualTo(String value) {
            addCriterion("hb_pool_id >=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThan(String value) {
            addCriterion("hb_pool_id <", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThanOrEqualTo(String value) {
            addCriterion("hb_pool_id <=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLike(String value) {
            addCriterion("hb_pool_id like", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotLike(String value) {
            addCriterion("hb_pool_id not like", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIn(List<String> values) {
            addCriterion("hb_pool_id in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotIn(List<String> values) {
            addCriterion("hb_pool_id not in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdBetween(String value1, String value2) {
            addCriterion("hb_pool_id between", value1, value2, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotBetween(String value1, String value2) {
            addCriterion("hb_pool_id not between", value1, value2, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIsNull() {
            addCriterion("hbcash_amount is null");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIsNotNull() {
            addCriterion("hbcash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountEqualTo(Integer value) {
            addCriterion("hbcash_amount =", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotEqualTo(Integer value) {
            addCriterion("hbcash_amount <>", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountGreaterThan(Integer value) {
            addCriterion("hbcash_amount >", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hbcash_amount >=", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountLessThan(Integer value) {
            addCriterion("hbcash_amount <", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountLessThanOrEqualTo(Integer value) {
            addCriterion("hbcash_amount <=", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIn(List<Integer> values) {
            addCriterion("hbcash_amount in", values, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotIn(List<Integer> values) {
            addCriterion("hbcash_amount not in", values, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountBetween(Integer value1, Integer value2) {
            addCriterion("hbcash_amount between", value1, value2, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("hbcash_amount not between", value1, value2, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andApplyRangeIsNull() {
            addCriterion("apply_range is null");
            return (Criteria) this;
        }

        public Criteria andApplyRangeIsNotNull() {
            addCriterion("apply_range is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRangeEqualTo(String value) {
            addCriterion("apply_range =", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeNotEqualTo(String value) {
            addCriterion("apply_range <>", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeGreaterThan(String value) {
            addCriterion("apply_range >", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeGreaterThanOrEqualTo(String value) {
            addCriterion("apply_range >=", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeLessThan(String value) {
            addCriterion("apply_range <", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeLessThanOrEqualTo(String value) {
            addCriterion("apply_range <=", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeLike(String value) {
            addCriterion("apply_range like", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeNotLike(String value) {
            addCriterion("apply_range not like", value, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeIn(List<String> values) {
            addCriterion("apply_range in", values, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeNotIn(List<String> values) {
            addCriterion("apply_range not in", values, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeBetween(String value1, String value2) {
            addCriterion("apply_range between", value1, value2, "applyRange");
            return (Criteria) this;
        }

        public Criteria andApplyRangeNotBetween(String value1, String value2) {
            addCriterion("apply_range not between", value1, value2, "applyRange");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Integer value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Integer value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Integer value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Integer value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Integer> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Integer> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Integer value1, Integer value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
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