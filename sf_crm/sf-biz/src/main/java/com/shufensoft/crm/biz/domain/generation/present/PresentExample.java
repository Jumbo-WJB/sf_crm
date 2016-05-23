package com.shufensoft.crm.biz.domain.generation.present;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PresentExample {
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

    public PresentExample() {
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

    public void addSumIsDeletedQueryColumn() {
        this.queryColumns.add(" sum(is_deleted) sum_is_deleted");
    }

    public void addPresentIdQueryColumn() {
        this.queryColumns.add("present_id");
    }

    public void addMaxPresentIdQueryColumn() {
        this.queryColumns.add("max(present_id) max_present_id");
    }

    public void addMinPresentIdQueryColumn() {
        this.queryColumns.add("min(present_id) min_present_id");
    }

    public void addAvgPresentIdQueryColumn() {
        this.queryColumns.add(" avg(present_id) avg_present_id");
    }

    public void addCountPresentIdQueryColumn() {
        this.queryColumns.add(" count(present_id) count_present_id");
    }

    public void addSumPresentIdQueryColumn() {
        this.queryColumns.add(" sum(present_id) sum_present_id");
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

    public void addSumUserIdQueryColumn() {
        this.queryColumns.add(" sum(user_id) sum_user_id");
    }

    public void addBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add("birthday_acivity_id");
    }

    public void addMaxBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add("max(birthday_acivity_id) max_birthday_acivity_id");
    }

    public void addMinBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add("min(birthday_acivity_id) min_birthday_acivity_id");
    }

    public void addAvgBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add(" avg(birthday_acivity_id) avg_birthday_acivity_id");
    }

    public void addCountBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add(" count(birthday_acivity_id) count_birthday_acivity_id");
    }

    public void addSumBirthdayAcivityIdQueryColumn() {
        this.queryColumns.add(" sum(birthday_acivity_id) sum_birthday_acivity_id");
    }

    public void addPresentTypeQueryColumn() {
        this.queryColumns.add("present_type");
    }

    public void addMaxPresentTypeQueryColumn() {
        this.queryColumns.add("max(present_type) max_present_type");
    }

    public void addMinPresentTypeQueryColumn() {
        this.queryColumns.add("min(present_type) min_present_type");
    }

    public void addAvgPresentTypeQueryColumn() {
        this.queryColumns.add(" avg(present_type) avg_present_type");
    }

    public void addCountPresentTypeQueryColumn() {
        this.queryColumns.add(" count(present_type) count_present_type");
    }

    public void addSumPresentTypeQueryColumn() {
        this.queryColumns.add(" sum(present_type) sum_present_type");
    }

    public void addPresentNameQueryColumn() {
        this.queryColumns.add("present_name");
    }

    public void addMaxPresentNameQueryColumn() {
        this.queryColumns.add("max(present_name) max_present_name");
    }

    public void addMinPresentNameQueryColumn() {
        this.queryColumns.add("min(present_name) min_present_name");
    }

    public void addAvgPresentNameQueryColumn() {
        this.queryColumns.add(" avg(present_name) avg_present_name");
    }

    public void addCountPresentNameQueryColumn() {
        this.queryColumns.add(" count(present_name) count_present_name");
    }

    public void addSumPresentNameQueryColumn() {
        this.queryColumns.add(" sum(present_name) sum_present_name");
    }

    public void addPresentSourceQueryColumn() {
        this.queryColumns.add("present_source");
    }

    public void addMaxPresentSourceQueryColumn() {
        this.queryColumns.add("max(present_source) max_present_source");
    }

    public void addMinPresentSourceQueryColumn() {
        this.queryColumns.add("min(present_source) min_present_source");
    }

    public void addAvgPresentSourceQueryColumn() {
        this.queryColumns.add(" avg(present_source) avg_present_source");
    }

    public void addCountPresentSourceQueryColumn() {
        this.queryColumns.add(" count(present_source) count_present_source");
    }

    public void addSumPresentSourceQueryColumn() {
        this.queryColumns.add(" sum(present_source) sum_present_source");
    }

    public void addDiscountQueryColumn() {
        this.queryColumns.add("discount");
    }

    public void addMaxDiscountQueryColumn() {
        this.queryColumns.add("max(discount) max_discount");
    }

    public void addMinDiscountQueryColumn() {
        this.queryColumns.add("min(discount) min_discount");
    }

    public void addAvgDiscountQueryColumn() {
        this.queryColumns.add(" avg(discount) avg_discount");
    }

    public void addCountDiscountQueryColumn() {
        this.queryColumns.add(" count(discount) count_discount");
    }

    public void addSumDiscountQueryColumn() {
        this.queryColumns.add(" sum(discount) sum_discount");
    }

    public void addPresentPasswordQueryColumn() {
        this.queryColumns.add("present_password");
    }

    public void addMaxPresentPasswordQueryColumn() {
        this.queryColumns.add("max(present_password) max_present_password");
    }

    public void addMinPresentPasswordQueryColumn() {
        this.queryColumns.add("min(present_password) min_present_password");
    }

    public void addAvgPresentPasswordQueryColumn() {
        this.queryColumns.add(" avg(present_password) avg_present_password");
    }

    public void addCountPresentPasswordQueryColumn() {
        this.queryColumns.add(" count(present_password) count_present_password");
    }

    public void addSumPresentPasswordQueryColumn() {
        this.queryColumns.add(" sum(present_password) sum_present_password");
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

    public void addSumGoodsIdQueryColumn() {
        this.queryColumns.add(" sum(goods_id) sum_goods_id");
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

    public void addSumHbPoolIdQueryColumn() {
        this.queryColumns.add(" sum(hb_pool_id) sum_hb_pool_id");
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

    public void addSumAmountQueryColumn() {
        this.queryColumns.add(" sum(amount) sum_amount");
    }

    public void addIsReceiveQueryColumn() {
        this.queryColumns.add("is_receive");
    }

    public void addMaxIsReceiveQueryColumn() {
        this.queryColumns.add("max(is_receive) max_is_receive");
    }

    public void addMinIsReceiveQueryColumn() {
        this.queryColumns.add("min(is_receive) min_is_receive");
    }

    public void addAvgIsReceiveQueryColumn() {
        this.queryColumns.add(" avg(is_receive) avg_is_receive");
    }

    public void addCountIsReceiveQueryColumn() {
        this.queryColumns.add(" count(is_receive) count_is_receive");
    }

    public void addSumIsReceiveQueryColumn() {
        this.queryColumns.add(" sum(is_receive) sum_is_receive");
    }

    public void addExpireDateQueryColumn() {
        this.queryColumns.add("expire_date");
    }

    public void addMaxExpireDateQueryColumn() {
        this.queryColumns.add("max(expire_date) max_expire_date");
    }

    public void addMinExpireDateQueryColumn() {
        this.queryColumns.add("min(expire_date) min_expire_date");
    }

    public void addAvgExpireDateQueryColumn() {
        this.queryColumns.add(" avg(expire_date) avg_expire_date");
    }

    public void addCountExpireDateQueryColumn() {
        this.queryColumns.add(" count(expire_date) count_expire_date");
    }

    public void addSumExpireDateQueryColumn() {
        this.queryColumns.add(" sum(expire_date) sum_expire_date");
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

        public Criteria andPresentIdIsNull() {
            addCriterion("present_id is null");
            return (Criteria) this;
        }

        public Criteria andPresentIdIsNotNull() {
            addCriterion("present_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresentIdEqualTo(Long value) {
            addCriterion("present_id =", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotEqualTo(Long value) {
            addCriterion("present_id <>", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThan(Long value) {
            addCriterion("present_id >", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("present_id >=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThan(Long value) {
            addCriterion("present_id <", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdLessThanOrEqualTo(Long value) {
            addCriterion("present_id <=", value, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdIn(List<Long> values) {
            addCriterion("present_id in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotIn(List<Long> values) {
            addCriterion("present_id not in", values, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdBetween(Long value1, Long value2) {
            addCriterion("present_id between", value1, value2, "presentId");
            return (Criteria) this;
        }

        public Criteria andPresentIdNotBetween(Long value1, Long value2) {
            addCriterion("present_id not between", value1, value2, "presentId");
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

        public Criteria andBirthdayAcivityIdIsNull() {
            addCriterion("birthday_acivity_id is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdIsNotNull() {
            addCriterion("birthday_acivity_id is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdEqualTo(Long value) {
            addCriterion("birthday_acivity_id =", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdNotEqualTo(Long value) {
            addCriterion("birthday_acivity_id <>", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdGreaterThan(Long value) {
            addCriterion("birthday_acivity_id >", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("birthday_acivity_id >=", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdLessThan(Long value) {
            addCriterion("birthday_acivity_id <", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdLessThanOrEqualTo(Long value) {
            addCriterion("birthday_acivity_id <=", value, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdIn(List<Long> values) {
            addCriterion("birthday_acivity_id in", values, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdNotIn(List<Long> values) {
            addCriterion("birthday_acivity_id not in", values, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdBetween(Long value1, Long value2) {
            addCriterion("birthday_acivity_id between", value1, value2, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayAcivityIdNotBetween(Long value1, Long value2) {
            addCriterion("birthday_acivity_id not between", value1, value2, "birthdayAcivityId");
            return (Criteria) this;
        }

        public Criteria andPresentTypeIsNull() {
            addCriterion("present_type is null");
            return (Criteria) this;
        }

        public Criteria andPresentTypeIsNotNull() {
            addCriterion("present_type is not null");
            return (Criteria) this;
        }

        public Criteria andPresentTypeEqualTo(String value) {
            addCriterion("present_type =", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotEqualTo(String value) {
            addCriterion("present_type <>", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeGreaterThan(String value) {
            addCriterion("present_type >", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("present_type >=", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLessThan(String value) {
            addCriterion("present_type <", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLessThanOrEqualTo(String value) {
            addCriterion("present_type <=", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeLike(String value) {
            addCriterion("present_type like", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotLike(String value) {
            addCriterion("present_type not like", value, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeIn(List<String> values) {
            addCriterion("present_type in", values, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotIn(List<String> values) {
            addCriterion("present_type not in", values, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeBetween(String value1, String value2) {
            addCriterion("present_type between", value1, value2, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentTypeNotBetween(String value1, String value2) {
            addCriterion("present_type not between", value1, value2, "presentType");
            return (Criteria) this;
        }

        public Criteria andPresentNameIsNull() {
            addCriterion("present_name is null");
            return (Criteria) this;
        }

        public Criteria andPresentNameIsNotNull() {
            addCriterion("present_name is not null");
            return (Criteria) this;
        }

        public Criteria andPresentNameEqualTo(String value) {
            addCriterion("present_name =", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameNotEqualTo(String value) {
            addCriterion("present_name <>", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameGreaterThan(String value) {
            addCriterion("present_name >", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameGreaterThanOrEqualTo(String value) {
            addCriterion("present_name >=", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameLessThan(String value) {
            addCriterion("present_name <", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameLessThanOrEqualTo(String value) {
            addCriterion("present_name <=", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameLike(String value) {
            addCriterion("present_name like", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameNotLike(String value) {
            addCriterion("present_name not like", value, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameIn(List<String> values) {
            addCriterion("present_name in", values, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameNotIn(List<String> values) {
            addCriterion("present_name not in", values, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameBetween(String value1, String value2) {
            addCriterion("present_name between", value1, value2, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentNameNotBetween(String value1, String value2) {
            addCriterion("present_name not between", value1, value2, "presentName");
            return (Criteria) this;
        }

        public Criteria andPresentSourceIsNull() {
            addCriterion("present_source is null");
            return (Criteria) this;
        }

        public Criteria andPresentSourceIsNotNull() {
            addCriterion("present_source is not null");
            return (Criteria) this;
        }

        public Criteria andPresentSourceEqualTo(String value) {
            addCriterion("present_source =", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceNotEqualTo(String value) {
            addCriterion("present_source <>", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceGreaterThan(String value) {
            addCriterion("present_source >", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceGreaterThanOrEqualTo(String value) {
            addCriterion("present_source >=", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceLessThan(String value) {
            addCriterion("present_source <", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceLessThanOrEqualTo(String value) {
            addCriterion("present_source <=", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceLike(String value) {
            addCriterion("present_source like", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceNotLike(String value) {
            addCriterion("present_source not like", value, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceIn(List<String> values) {
            addCriterion("present_source in", values, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceNotIn(List<String> values) {
            addCriterion("present_source not in", values, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceBetween(String value1, String value2) {
            addCriterion("present_source between", value1, value2, "presentSource");
            return (Criteria) this;
        }

        public Criteria andPresentSourceNotBetween(String value1, String value2) {
            addCriterion("present_source not between", value1, value2, "presentSource");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordIsNull() {
            addCriterion("present_password is null");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordIsNotNull() {
            addCriterion("present_password is not null");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordEqualTo(String value) {
            addCriterion("present_password =", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordNotEqualTo(String value) {
            addCriterion("present_password <>", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordGreaterThan(String value) {
            addCriterion("present_password >", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("present_password >=", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordLessThan(String value) {
            addCriterion("present_password <", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordLessThanOrEqualTo(String value) {
            addCriterion("present_password <=", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordLike(String value) {
            addCriterion("present_password like", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordNotLike(String value) {
            addCriterion("present_password not like", value, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordIn(List<String> values) {
            addCriterion("present_password in", values, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordNotIn(List<String> values) {
            addCriterion("present_password not in", values, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordBetween(String value1, String value2) {
            addCriterion("present_password between", value1, value2, "presentPassword");
            return (Criteria) this;
        }

        public Criteria andPresentPasswordNotBetween(String value1, String value2) {
            addCriterion("present_password not between", value1, value2, "presentPassword");
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

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andHbPoolIdEqualTo(Long value) {
            addCriterion("hb_pool_id =", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotEqualTo(Long value) {
            addCriterion("hb_pool_id <>", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThan(Long value) {
            addCriterion("hb_pool_id >", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hb_pool_id >=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThan(Long value) {
            addCriterion("hb_pool_id <", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("hb_pool_id <=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIn(List<Long> values) {
            addCriterion("hb_pool_id in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotIn(List<Long> values) {
            addCriterion("hb_pool_id not in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdBetween(Long value1, Long value2) {
            addCriterion("hb_pool_id between", value1, value2, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("hb_pool_id not between", value1, value2, "hbPoolId");
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

        public Criteria andIsReceiveIsNull() {
            addCriterion("is_receive is null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveIsNotNull() {
            addCriterion("is_receive is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceiveEqualTo(Boolean value) {
            addCriterion("is_receive =", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveNotEqualTo(Boolean value) {
            addCriterion("is_receive <>", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveGreaterThan(Boolean value) {
            addCriterion("is_receive >", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_receive >=", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveLessThan(Boolean value) {
            addCriterion("is_receive <", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_receive <=", value, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveIn(List<Boolean> values) {
            addCriterion("is_receive in", values, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveNotIn(List<Boolean> values) {
            addCriterion("is_receive not in", values, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive between", value1, value2, "isReceive");
            return (Criteria) this;
        }

        public Criteria andIsReceiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_receive not between", value1, value2, "isReceive");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("expire_date is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterion("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterion("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterion("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterion("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Date> values) {
            addCriterion("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterion("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterion("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("expire_date not between", value1, value2, "expireDate");
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