package com.shufensoft.crm.biz.domain.generation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBoundExample {
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

    public UserBoundExample() {
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

    public void addBoundIdQueryColumn() {
        this.queryColumns.add("bound_id");
    }

    public void addMaxBoundIdQueryColumn() {
        this.queryColumns.add("max(bound_id) max_bound_id");
    }

    public void addMinBoundIdQueryColumn() {
        this.queryColumns.add("min(bound_id) min_bound_id");
    }

    public void addAvgBoundIdQueryColumn() {
        this.queryColumns.add(" avg(bound_id) avg_bound_id");
    }

    public void addCountBoundIdQueryColumn() {
        this.queryColumns.add(" count(bound_id) count_bound_id");
    }

    public void addSumBoundIdQueryColumn() {
        this.queryColumns.add(" sum(bound_id) sum_bound_id");
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

    public void addReceiverIdTbQueryColumn() {
        this.queryColumns.add("receiver_id_tb");
    }

    public void addMaxReceiverIdTbQueryColumn() {
        this.queryColumns.add("max(receiver_id_tb) max_receiver_id_tb");
    }

    public void addMinReceiverIdTbQueryColumn() {
        this.queryColumns.add("min(receiver_id_tb) min_receiver_id_tb");
    }

    public void addAvgReceiverIdTbQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_tb) avg_receiver_id_tb");
    }

    public void addCountReceiverIdTbQueryColumn() {
        this.queryColumns.add(" count(receiver_id_tb) count_receiver_id_tb");
    }

    public void addSumReceiverIdTbQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_tb) sum_receiver_id_tb");
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

    public void addReceiverIdYzQueryColumn() {
        this.queryColumns.add("receiver_id_yz");
    }

    public void addMaxReceiverIdYzQueryColumn() {
        this.queryColumns.add("max(receiver_id_yz) max_receiver_id_yz");
    }

    public void addMinReceiverIdYzQueryColumn() {
        this.queryColumns.add("min(receiver_id_yz) min_receiver_id_yz");
    }

    public void addAvgReceiverIdYzQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_yz) avg_receiver_id_yz");
    }

    public void addCountReceiverIdYzQueryColumn() {
        this.queryColumns.add(" count(receiver_id_yz) count_receiver_id_yz");
    }

    public void addSumReceiverIdYzQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_yz) sum_receiver_id_yz");
    }

    public void addMobileQueryColumn() {
        this.queryColumns.add("mobile");
    }

    public void addMaxMobileQueryColumn() {
        this.queryColumns.add("max(mobile) max_mobile");
    }

    public void addMinMobileQueryColumn() {
        this.queryColumns.add("min(mobile) min_mobile");
    }

    public void addAvgMobileQueryColumn() {
        this.queryColumns.add(" avg(mobile) avg_mobile");
    }

    public void addCountMobileQueryColumn() {
        this.queryColumns.add(" count(mobile) count_mobile");
    }

    public void addSumMobileQueryColumn() {
        this.queryColumns.add(" sum(mobile) sum_mobile");
    }

    public void addTbIdQueryColumn() {
        this.queryColumns.add("tb_id");
    }

    public void addMaxTbIdQueryColumn() {
        this.queryColumns.add("max(tb_id) max_tb_id");
    }

    public void addMinTbIdQueryColumn() {
        this.queryColumns.add("min(tb_id) min_tb_id");
    }

    public void addAvgTbIdQueryColumn() {
        this.queryColumns.add(" avg(tb_id) avg_tb_id");
    }

    public void addCountTbIdQueryColumn() {
        this.queryColumns.add(" count(tb_id) count_tb_id");
    }

    public void addSumTbIdQueryColumn() {
        this.queryColumns.add(" sum(tb_id) sum_tb_id");
    }

    public void addJdIdQueryColumn() {
        this.queryColumns.add("jd_id");
    }

    public void addMaxJdIdQueryColumn() {
        this.queryColumns.add("max(jd_id) max_jd_id");
    }

    public void addMinJdIdQueryColumn() {
        this.queryColumns.add("min(jd_id) min_jd_id");
    }

    public void addAvgJdIdQueryColumn() {
        this.queryColumns.add(" avg(jd_id) avg_jd_id");
    }

    public void addCountJdIdQueryColumn() {
        this.queryColumns.add(" count(jd_id) count_jd_id");
    }

    public void addSumJdIdQueryColumn() {
        this.queryColumns.add(" sum(jd_id) sum_jd_id");
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

        public Criteria andBoundIdIsNull() {
            addCriterion("bound_id is null");
            return (Criteria) this;
        }

        public Criteria andBoundIdIsNotNull() {
            addCriterion("bound_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoundIdEqualTo(Long value) {
            addCriterion("bound_id =", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdNotEqualTo(Long value) {
            addCriterion("bound_id <>", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdGreaterThan(Long value) {
            addCriterion("bound_id >", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bound_id >=", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdLessThan(Long value) {
            addCriterion("bound_id <", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdLessThanOrEqualTo(Long value) {
            addCriterion("bound_id <=", value, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdIn(List<Long> values) {
            addCriterion("bound_id in", values, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdNotIn(List<Long> values) {
            addCriterion("bound_id not in", values, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdBetween(Long value1, Long value2) {
            addCriterion("bound_id between", value1, value2, "boundId");
            return (Criteria) this;
        }

        public Criteria andBoundIdNotBetween(Long value1, Long value2) {
            addCriterion("bound_id not between", value1, value2, "boundId");
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

        public Criteria andReceiverIdTbIsNull() {
            addCriterion("receiver_id_tb is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbIsNotNull() {
            addCriterion("receiver_id_tb is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbEqualTo(Long value) {
            addCriterion("receiver_id_tb =", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotEqualTo(Long value) {
            addCriterion("receiver_id_tb <>", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbGreaterThan(Long value) {
            addCriterion("receiver_id_tb >", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_tb >=", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbLessThan(Long value) {
            addCriterion("receiver_id_tb <", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_tb <=", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbIn(List<Long> values) {
            addCriterion("receiver_id_tb in", values, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotIn(List<Long> values) {
            addCriterion("receiver_id_tb not in", values, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbBetween(Long value1, Long value2) {
            addCriterion("receiver_id_tb between", value1, value2, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_tb not between", value1, value2, "receiverIdTb");
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

        public Criteria andReceiverIdYzIsNull() {
            addCriterion("receiver_id_yz is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzIsNotNull() {
            addCriterion("receiver_id_yz is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzEqualTo(Long value) {
            addCriterion("receiver_id_yz =", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotEqualTo(Long value) {
            addCriterion("receiver_id_yz <>", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzGreaterThan(Long value) {
            addCriterion("receiver_id_yz >", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_yz >=", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzLessThan(Long value) {
            addCriterion("receiver_id_yz <", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_yz <=", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzIn(List<Long> values) {
            addCriterion("receiver_id_yz in", values, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotIn(List<Long> values) {
            addCriterion("receiver_id_yz not in", values, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzBetween(Long value1, Long value2) {
            addCriterion("receiver_id_yz between", value1, value2, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_yz not between", value1, value2, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTbIdIsNull() {
            addCriterion("tb_id is null");
            return (Criteria) this;
        }

        public Criteria andTbIdIsNotNull() {
            addCriterion("tb_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbIdEqualTo(String value) {
            addCriterion("tb_id =", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotEqualTo(String value) {
            addCriterion("tb_id <>", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdGreaterThan(String value) {
            addCriterion("tb_id >", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdGreaterThanOrEqualTo(String value) {
            addCriterion("tb_id >=", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdLessThan(String value) {
            addCriterion("tb_id <", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdLessThanOrEqualTo(String value) {
            addCriterion("tb_id <=", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdLike(String value) {
            addCriterion("tb_id like", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotLike(String value) {
            addCriterion("tb_id not like", value, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdIn(List<String> values) {
            addCriterion("tb_id in", values, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotIn(List<String> values) {
            addCriterion("tb_id not in", values, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdBetween(String value1, String value2) {
            addCriterion("tb_id between", value1, value2, "tbId");
            return (Criteria) this;
        }

        public Criteria andTbIdNotBetween(String value1, String value2) {
            addCriterion("tb_id not between", value1, value2, "tbId");
            return (Criteria) this;
        }

        public Criteria andJdIdIsNull() {
            addCriterion("jd_id is null");
            return (Criteria) this;
        }

        public Criteria andJdIdIsNotNull() {
            addCriterion("jd_id is not null");
            return (Criteria) this;
        }

        public Criteria andJdIdEqualTo(String value) {
            addCriterion("jd_id =", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdNotEqualTo(String value) {
            addCriterion("jd_id <>", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdGreaterThan(String value) {
            addCriterion("jd_id >", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdGreaterThanOrEqualTo(String value) {
            addCriterion("jd_id >=", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdLessThan(String value) {
            addCriterion("jd_id <", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdLessThanOrEqualTo(String value) {
            addCriterion("jd_id <=", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdLike(String value) {
            addCriterion("jd_id like", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdNotLike(String value) {
            addCriterion("jd_id not like", value, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdIn(List<String> values) {
            addCriterion("jd_id in", values, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdNotIn(List<String> values) {
            addCriterion("jd_id not in", values, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdBetween(String value1, String value2) {
            addCriterion("jd_id between", value1, value2, "jdId");
            return (Criteria) this;
        }

        public Criteria andJdIdNotBetween(String value1, String value2) {
            addCriterion("jd_id not between", value1, value2, "jdId");
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