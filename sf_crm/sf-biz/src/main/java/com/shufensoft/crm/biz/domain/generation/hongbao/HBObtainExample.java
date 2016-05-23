package com.shufensoft.crm.biz.domain.generation.hongbao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HBObtainExample {
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

    public HBObtainExample() {
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

    public void addHongbaoObtainIdQueryColumn() {
        this.queryColumns.add("hongbao_obtain_id");
    }

    public void addMaxHongbaoObtainIdQueryColumn() {
        this.queryColumns.add("max(hongbao_obtain_id) max_hongbao_obtain_id");
    }

    public void addMinHongbaoObtainIdQueryColumn() {
        this.queryColumns.add("min(hongbao_obtain_id) min_hongbao_obtain_id");
    }

    public void addAvgHongbaoObtainIdQueryColumn() {
        this.queryColumns.add(" avg(hongbao_obtain_id) avg_hongbao_obtain_id");
    }

    public void addCountHongbaoObtainIdQueryColumn() {
        this.queryColumns.add(" count(hongbao_obtain_id) count_hongbao_obtain_id");
    }

    public void addCountDistinctHongbaoObtainIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT hongbao_obtain_id) count_distinct_hongbao_obtain_id");
    }

    public void addSumHongbaoObtainIdQueryColumn() {
        this.queryColumns.add(" sum(hongbao_obtain_id) sum_hongbao_obtain_id");
    }

    public void addUserIdQueryColumn() {
        this.queryColumns.add("user_id");
    }

    public void addMaxUserIdQueryColumn() {
        this.queryColumns.add("max(user_id) max_user_id");
    }

    public void addMinUserIdQueryColumn() {
        this.queryColumns.add("min(user_id) min_user_id");
    }

    public void addAvgUserIdQueryColumn() {
        this.queryColumns.add(" avg(user_id) avg_user_id");
    }

    public void addCountUserIdQueryColumn() {
        this.queryColumns.add(" count(user_id) count_user_id");
    }

    public void addCountDistinctUserIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_id) count_distinct_user_id");
    }

    public void addSumUserIdQueryColumn() {
        this.queryColumns.add(" sum(user_id) sum_user_id");
    }

    public void addAmountQueryColumn() {
        this.queryColumns.add("amount");
    }

    public void addMaxAmountQueryColumn() {
        this.queryColumns.add("max(amount) max_amount");
    }

    public void addMinAmountQueryColumn() {
        this.queryColumns.add("min(amount) min_amount");
    }

    public void addAvgAmountQueryColumn() {
        this.queryColumns.add(" avg(amount) avg_amount");
    }

    public void addCountAmountQueryColumn() {
        this.queryColumns.add(" count(amount) count_amount");
    }

    public void addCountDistinctAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT amount) count_distinct_amount");
    }

    public void addSumAmountQueryColumn() {
        this.queryColumns.add(" sum(amount) sum_amount");
    }

    public void addOpenIdQueryColumn() {
        this.queryColumns.add("open_id");
    }

    public void addMaxOpenIdQueryColumn() {
        this.queryColumns.add("max(open_id) max_open_id");
    }

    public void addMinOpenIdQueryColumn() {
        this.queryColumns.add("min(open_id) min_open_id");
    }

    public void addAvgOpenIdQueryColumn() {
        this.queryColumns.add(" avg(open_id) avg_open_id");
    }

    public void addCountOpenIdQueryColumn() {
        this.queryColumns.add(" count(open_id) count_open_id");
    }

    public void addCountDistinctOpenIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT open_id) count_distinct_open_id");
    }

    public void addSumOpenIdQueryColumn() {
        this.queryColumns.add(" sum(open_id) sum_open_id");
    }

    public void addHongbaoTypeQueryColumn() {
        this.queryColumns.add("hongbao_type");
    }

    public void addMaxHongbaoTypeQueryColumn() {
        this.queryColumns.add("max(hongbao_type) max_hongbao_type");
    }

    public void addMinHongbaoTypeQueryColumn() {
        this.queryColumns.add("min(hongbao_type) min_hongbao_type");
    }

    public void addAvgHongbaoTypeQueryColumn() {
        this.queryColumns.add(" avg(hongbao_type) avg_hongbao_type");
    }

    public void addCountHongbaoTypeQueryColumn() {
        this.queryColumns.add(" count(hongbao_type) count_hongbao_type");
    }

    public void addCountDistinctHongbaoTypeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT hongbao_type) count_distinct_hongbao_type");
    }

    public void addSumHongbaoTypeQueryColumn() {
        this.queryColumns.add(" sum(hongbao_type) sum_hongbao_type");
    }

    public void addPoolIdQueryColumn() {
        this.queryColumns.add("pool_id");
    }

    public void addMaxPoolIdQueryColumn() {
        this.queryColumns.add("max(pool_id) max_pool_id");
    }

    public void addMinPoolIdQueryColumn() {
        this.queryColumns.add("min(pool_id) min_pool_id");
    }

    public void addAvgPoolIdQueryColumn() {
        this.queryColumns.add(" avg(pool_id) avg_pool_id");
    }

    public void addCountPoolIdQueryColumn() {
        this.queryColumns.add(" count(pool_id) count_pool_id");
    }

    public void addCountDistinctPoolIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT pool_id) count_distinct_pool_id");
    }

    public void addSumPoolIdQueryColumn() {
        this.queryColumns.add(" sum(pool_id) sum_pool_id");
    }

    public void addPoolNameQueryColumn() {
        this.queryColumns.add("pool_name");
    }

    public void addMaxPoolNameQueryColumn() {
        this.queryColumns.add("max(pool_name) max_pool_name");
    }

    public void addMinPoolNameQueryColumn() {
        this.queryColumns.add("min(pool_name) min_pool_name");
    }

    public void addAvgPoolNameQueryColumn() {
        this.queryColumns.add(" avg(pool_name) avg_pool_name");
    }

    public void addCountPoolNameQueryColumn() {
        this.queryColumns.add(" count(pool_name) count_pool_name");
    }

    public void addCountDistinctPoolNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT pool_name) count_distinct_pool_name");
    }

    public void addSumPoolNameQueryColumn() {
        this.queryColumns.add(" sum(pool_name) sum_pool_name");
    }

    public void addObtainDatatimeQueryColumn() {
        this.queryColumns.add("obtain_datatime");
    }

    public void addMaxObtainDatatimeQueryColumn() {
        this.queryColumns.add("max(obtain_datatime) max_obtain_datatime");
    }

    public void addMinObtainDatatimeQueryColumn() {
        this.queryColumns.add("min(obtain_datatime) min_obtain_datatime");
    }

    public void addAvgObtainDatatimeQueryColumn() {
        this.queryColumns.add(" avg(obtain_datatime) avg_obtain_datatime");
    }

    public void addCountObtainDatatimeQueryColumn() {
        this.queryColumns.add(" count(obtain_datatime) count_obtain_datatime");
    }

    public void addCountDistinctObtainDatatimeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT obtain_datatime) count_distinct_obtain_datatime");
    }

    public void addSumObtainDatatimeQueryColumn() {
        this.queryColumns.add(" sum(obtain_datatime) sum_obtain_datatime");
    }

    public void addAmountRangeQueryColumn() {
        this.queryColumns.add("amount_range");
    }

    public void addMaxAmountRangeQueryColumn() {
        this.queryColumns.add("max(amount_range) max_amount_range");
    }

    public void addMinAmountRangeQueryColumn() {
        this.queryColumns.add("min(amount_range) min_amount_range");
    }

    public void addAvgAmountRangeQueryColumn() {
        this.queryColumns.add(" avg(amount_range) avg_amount_range");
    }

    public void addCountAmountRangeQueryColumn() {
        this.queryColumns.add(" count(amount_range) count_amount_range");
    }

    public void addCountDistinctAmountRangeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT amount_range) count_distinct_amount_range");
    }

    public void addSumAmountRangeQueryColumn() {
        this.queryColumns.add(" sum(amount_range) sum_amount_range");
    }

    public void addObtainPostNumberQueryColumn() {
        this.queryColumns.add("obtain_post_number");
    }

    public void addMaxObtainPostNumberQueryColumn() {
        this.queryColumns.add("max(obtain_post_number) max_obtain_post_number");
    }

    public void addMinObtainPostNumberQueryColumn() {
        this.queryColumns.add("min(obtain_post_number) min_obtain_post_number");
    }

    public void addAvgObtainPostNumberQueryColumn() {
        this.queryColumns.add(" avg(obtain_post_number) avg_obtain_post_number");
    }

    public void addCountObtainPostNumberQueryColumn() {
        this.queryColumns.add(" count(obtain_post_number) count_obtain_post_number");
    }

    public void addCountDistinctObtainPostNumberQueryColumn() {
        this.queryColumns.add(" count( DISTINCT obtain_post_number) count_distinct_obtain_post_number");
    }

    public void addSumObtainPostNumberQueryColumn() {
        this.queryColumns.add(" sum(obtain_post_number) sum_obtain_post_number");
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

    public void addCountDistinctStatusQueryColumn() {
        this.queryColumns.add(" count( DISTINCT status) count_distinct_status");
    }

    public void addSumStatusQueryColumn() {
        this.queryColumns.add(" sum(status) sum_status");
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

        public Criteria andHongbaoObtainIdIsNull() {
            addCriterion("hongbao_obtain_id is null");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdIsNotNull() {
            addCriterion("hongbao_obtain_id is not null");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdEqualTo(Long value) {
            addCriterion("hongbao_obtain_id =", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdNotEqualTo(Long value) {
            addCriterion("hongbao_obtain_id <>", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdGreaterThan(Long value) {
            addCriterion("hongbao_obtain_id >", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hongbao_obtain_id >=", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdLessThan(Long value) {
            addCriterion("hongbao_obtain_id <", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdLessThanOrEqualTo(Long value) {
            addCriterion("hongbao_obtain_id <=", value, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdIn(List<Long> values) {
            addCriterion("hongbao_obtain_id in", values, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdNotIn(List<Long> values) {
            addCriterion("hongbao_obtain_id not in", values, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdBetween(Long value1, Long value2) {
            addCriterion("hongbao_obtain_id between", value1, value2, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andHongbaoObtainIdNotBetween(Long value1, Long value2) {
            addCriterion("hongbao_obtain_id not between", value1, value2, "hongbaoObtainId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeIsNull() {
            addCriterion("hongbao_type is null");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeIsNotNull() {
            addCriterion("hongbao_type is not null");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeEqualTo(String value) {
            addCriterion("hongbao_type =", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeNotEqualTo(String value) {
            addCriterion("hongbao_type <>", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeGreaterThan(String value) {
            addCriterion("hongbao_type >", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hongbao_type >=", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeLessThan(String value) {
            addCriterion("hongbao_type <", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeLessThanOrEqualTo(String value) {
            addCriterion("hongbao_type <=", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeLike(String value) {
            addCriterion("hongbao_type like", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeNotLike(String value) {
            addCriterion("hongbao_type not like", value, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeIn(List<String> values) {
            addCriterion("hongbao_type in", values, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeNotIn(List<String> values) {
            addCriterion("hongbao_type not in", values, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeBetween(String value1, String value2) {
            addCriterion("hongbao_type between", value1, value2, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andHongbaoTypeNotBetween(String value1, String value2) {
            addCriterion("hongbao_type not between", value1, value2, "hongbaoType");
            return (Criteria) this;
        }

        public Criteria andPoolIdIsNull() {
            addCriterion("pool_id is null");
            return (Criteria) this;
        }

        public Criteria andPoolIdIsNotNull() {
            addCriterion("pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoolIdEqualTo(Long value) {
            addCriterion("pool_id =", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotEqualTo(Long value) {
            addCriterion("pool_id <>", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdGreaterThan(Long value) {
            addCriterion("pool_id >", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pool_id >=", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdLessThan(Long value) {
            addCriterion("pool_id <", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("pool_id <=", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdIn(List<Long> values) {
            addCriterion("pool_id in", values, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotIn(List<Long> values) {
            addCriterion("pool_id not in", values, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdBetween(Long value1, Long value2) {
            addCriterion("pool_id between", value1, value2, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("pool_id not between", value1, value2, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolNameIsNull() {
            addCriterion("pool_name is null");
            return (Criteria) this;
        }

        public Criteria andPoolNameIsNotNull() {
            addCriterion("pool_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoolNameEqualTo(String value) {
            addCriterion("pool_name =", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotEqualTo(String value) {
            addCriterion("pool_name <>", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameGreaterThan(String value) {
            addCriterion("pool_name >", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("pool_name >=", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLessThan(String value) {
            addCriterion("pool_name <", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLessThanOrEqualTo(String value) {
            addCriterion("pool_name <=", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLike(String value) {
            addCriterion("pool_name like", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotLike(String value) {
            addCriterion("pool_name not like", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameIn(List<String> values) {
            addCriterion("pool_name in", values, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotIn(List<String> values) {
            addCriterion("pool_name not in", values, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameBetween(String value1, String value2) {
            addCriterion("pool_name between", value1, value2, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotBetween(String value1, String value2) {
            addCriterion("pool_name not between", value1, value2, "poolName");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeIsNull() {
            addCriterion("obtain_datatime is null");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeIsNotNull() {
            addCriterion("obtain_datatime is not null");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeEqualTo(Date value) {
            addCriterion("obtain_datatime =", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeNotEqualTo(Date value) {
            addCriterion("obtain_datatime <>", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeGreaterThan(Date value) {
            addCriterion("obtain_datatime >", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("obtain_datatime >=", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeLessThan(Date value) {
            addCriterion("obtain_datatime <", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeLessThanOrEqualTo(Date value) {
            addCriterion("obtain_datatime <=", value, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeIn(List<Date> values) {
            addCriterion("obtain_datatime in", values, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeNotIn(List<Date> values) {
            addCriterion("obtain_datatime not in", values, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeBetween(Date value1, Date value2) {
            addCriterion("obtain_datatime between", value1, value2, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andObtainDatatimeNotBetween(Date value1, Date value2) {
            addCriterion("obtain_datatime not between", value1, value2, "obtainDatatime");
            return (Criteria) this;
        }

        public Criteria andAmountRangeIsNull() {
            addCriterion("amount_range is null");
            return (Criteria) this;
        }

        public Criteria andAmountRangeIsNotNull() {
            addCriterion("amount_range is not null");
            return (Criteria) this;
        }

        public Criteria andAmountRangeEqualTo(String value) {
            addCriterion("amount_range =", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeNotEqualTo(String value) {
            addCriterion("amount_range <>", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeGreaterThan(String value) {
            addCriterion("amount_range >", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeGreaterThanOrEqualTo(String value) {
            addCriterion("amount_range >=", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeLessThan(String value) {
            addCriterion("amount_range <", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeLessThanOrEqualTo(String value) {
            addCriterion("amount_range <=", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeLike(String value) {
            addCriterion("amount_range like", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeNotLike(String value) {
            addCriterion("amount_range not like", value, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeIn(List<String> values) {
            addCriterion("amount_range in", values, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeNotIn(List<String> values) {
            addCriterion("amount_range not in", values, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeBetween(String value1, String value2) {
            addCriterion("amount_range between", value1, value2, "amountRange");
            return (Criteria) this;
        }

        public Criteria andAmountRangeNotBetween(String value1, String value2) {
            addCriterion("amount_range not between", value1, value2, "amountRange");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberIsNull() {
            addCriterion("obtain_post_number is null");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberIsNotNull() {
            addCriterion("obtain_post_number is not null");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberEqualTo(String value) {
            addCriterion("obtain_post_number =", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberNotEqualTo(String value) {
            addCriterion("obtain_post_number <>", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberGreaterThan(String value) {
            addCriterion("obtain_post_number >", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_post_number >=", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberLessThan(String value) {
            addCriterion("obtain_post_number <", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberLessThanOrEqualTo(String value) {
            addCriterion("obtain_post_number <=", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberLike(String value) {
            addCriterion("obtain_post_number like", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberNotLike(String value) {
            addCriterion("obtain_post_number not like", value, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberIn(List<String> values) {
            addCriterion("obtain_post_number in", values, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberNotIn(List<String> values) {
            addCriterion("obtain_post_number not in", values, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberBetween(String value1, String value2) {
            addCriterion("obtain_post_number between", value1, value2, "obtainPostNumber");
            return (Criteria) this;
        }

        public Criteria andObtainPostNumberNotBetween(String value1, String value2) {
            addCriterion("obtain_post_number not between", value1, value2, "obtainPostNumber");
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