package com.shufensoft.crm.biz.domain.generation.point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PointObtainExample {
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

    public PointObtainExample() {
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

    public void addTransfererIdQueryColumn() {
        this.queryColumns.add("transferer_id");
    }

    public void addMaxTransfererIdQueryColumn() {
        this.queryColumns.add("max(transferer_id) max_transferer_id");
    }

    public void addMinTransfererIdQueryColumn() {
        this.queryColumns.add("min(transferer_id) min_transferer_id");
    }

    public void addAvgTransfererIdQueryColumn() {
        this.queryColumns.add(" avg(transferer_id) avg_transferer_id");
    }

    public void addCountTransfererIdQueryColumn() {
        this.queryColumns.add(" count(transferer_id) count_transferer_id");
    }

    public void addSumTransfererIdQueryColumn() {
        this.queryColumns.add(" sum(transferer_id) sum_transferer_id");
    }

    public void addGmtTransferQueryColumn() {
        this.queryColumns.add("gmt_transfer");
    }

    public void addMaxGmtTransferQueryColumn() {
        this.queryColumns.add("max(gmt_transfer) max_gmt_transfer");
    }

    public void addMinGmtTransferQueryColumn() {
        this.queryColumns.add("min(gmt_transfer) min_gmt_transfer");
    }

    public void addAvgGmtTransferQueryColumn() {
        this.queryColumns.add(" avg(gmt_transfer) avg_gmt_transfer");
    }

    public void addCountGmtTransferQueryColumn() {
        this.queryColumns.add(" count(gmt_transfer) count_gmt_transfer");
    }

    public void addSumGmtTransferQueryColumn() {
        this.queryColumns.add(" sum(gmt_transfer) sum_gmt_transfer");
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

    public void addAmountConsumedQueryColumn() {
        this.queryColumns.add("amount_consumed");
    }

    public void addMaxAmountConsumedQueryColumn() {
        this.queryColumns.add("max(amount_consumed) max_amount_consumed");
    }

    public void addMinAmountConsumedQueryColumn() {
        this.queryColumns.add("min(amount_consumed) min_amount_consumed");
    }

    public void addAvgAmountConsumedQueryColumn() {
        this.queryColumns.add(" avg(amount_consumed) avg_amount_consumed");
    }

    public void addCountAmountConsumedQueryColumn() {
        this.queryColumns.add(" count(amount_consumed) count_amount_consumed");
    }

    public void addSumAmountConsumedQueryColumn() {
        this.queryColumns.add(" sum(amount_consumed) sum_amount_consumed");
    }

    public void addGmtExpiredQueryColumn() {
        this.queryColumns.add("gmt_expired");
    }

    public void addMaxGmtExpiredQueryColumn() {
        this.queryColumns.add("max(gmt_expired) max_gmt_expired");
    }

    public void addMinGmtExpiredQueryColumn() {
        this.queryColumns.add("min(gmt_expired) min_gmt_expired");
    }

    public void addAvgGmtExpiredQueryColumn() {
        this.queryColumns.add(" avg(gmt_expired) avg_gmt_expired");
    }

    public void addCountGmtExpiredQueryColumn() {
        this.queryColumns.add(" count(gmt_expired) count_gmt_expired");
    }

    public void addSumGmtExpiredQueryColumn() {
        this.queryColumns.add(" sum(gmt_expired) sum_gmt_expired");
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

    public void addObtainMethodQueryColumn() {
        this.queryColumns.add("obtain_method");
    }

    public void addMaxObtainMethodQueryColumn() {
        this.queryColumns.add("max(obtain_method) max_obtain_method");
    }

    public void addMinObtainMethodQueryColumn() {
        this.queryColumns.add("min(obtain_method) min_obtain_method");
    }

    public void addAvgObtainMethodQueryColumn() {
        this.queryColumns.add(" avg(obtain_method) avg_obtain_method");
    }

    public void addCountObtainMethodQueryColumn() {
        this.queryColumns.add(" count(obtain_method) count_obtain_method");
    }

    public void addSumObtainMethodQueryColumn() {
        this.queryColumns.add(" sum(obtain_method) sum_obtain_method");
    }

    public void addObtainMethodIdQueryColumn() {
        this.queryColumns.add("obtain_method_id");
    }

    public void addMaxObtainMethodIdQueryColumn() {
        this.queryColumns.add("max(obtain_method_id) max_obtain_method_id");
    }

    public void addMinObtainMethodIdQueryColumn() {
        this.queryColumns.add("min(obtain_method_id) min_obtain_method_id");
    }

    public void addAvgObtainMethodIdQueryColumn() {
        this.queryColumns.add(" avg(obtain_method_id) avg_obtain_method_id");
    }

    public void addCountObtainMethodIdQueryColumn() {
        this.queryColumns.add(" count(obtain_method_id) count_obtain_method_id");
    }

    public void addSumObtainMethodIdQueryColumn() {
        this.queryColumns.add(" sum(obtain_method_id) sum_obtain_method_id");
    }

    public void addPointObtainVersionQueryColumn() {
        this.queryColumns.add("point_obtain_version");
    }

    public void addMaxPointObtainVersionQueryColumn() {
        this.queryColumns.add("max(point_obtain_version) max_point_obtain_version");
    }

    public void addMinPointObtainVersionQueryColumn() {
        this.queryColumns.add("min(point_obtain_version) min_point_obtain_version");
    }

    public void addAvgPointObtainVersionQueryColumn() {
        this.queryColumns.add(" avg(point_obtain_version) avg_point_obtain_version");
    }

    public void addCountPointObtainVersionQueryColumn() {
        this.queryColumns.add(" count(point_obtain_version) count_point_obtain_version");
    }

    public void addSumPointObtainVersionQueryColumn() {
        this.queryColumns.add(" sum(point_obtain_version) sum_point_obtain_version");
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

        public Criteria andTransfererIdIsNull() {
            addCriterion("transferer_id is null");
            return (Criteria) this;
        }

        public Criteria andTransfererIdIsNotNull() {
            addCriterion("transferer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransfererIdEqualTo(Long value) {
            addCriterion("transferer_id =", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdNotEqualTo(Long value) {
            addCriterion("transferer_id <>", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdGreaterThan(Long value) {
            addCriterion("transferer_id >", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transferer_id >=", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdLessThan(Long value) {
            addCriterion("transferer_id <", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdLessThanOrEqualTo(Long value) {
            addCriterion("transferer_id <=", value, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdIn(List<Long> values) {
            addCriterion("transferer_id in", values, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdNotIn(List<Long> values) {
            addCriterion("transferer_id not in", values, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdBetween(Long value1, Long value2) {
            addCriterion("transferer_id between", value1, value2, "transfererId");
            return (Criteria) this;
        }

        public Criteria andTransfererIdNotBetween(Long value1, Long value2) {
            addCriterion("transferer_id not between", value1, value2, "transfererId");
            return (Criteria) this;
        }

        public Criteria andGmtTransferIsNull() {
            addCriterion("gmt_transfer is null");
            return (Criteria) this;
        }

        public Criteria andGmtTransferIsNotNull() {
            addCriterion("gmt_transfer is not null");
            return (Criteria) this;
        }

        public Criteria andGmtTransferEqualTo(Date value) {
            addCriterion("gmt_transfer =", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferNotEqualTo(Date value) {
            addCriterion("gmt_transfer <>", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferGreaterThan(Date value) {
            addCriterion("gmt_transfer >", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_transfer >=", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferLessThan(Date value) {
            addCriterion("gmt_transfer <", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferLessThanOrEqualTo(Date value) {
            addCriterion("gmt_transfer <=", value, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferIn(List<Date> values) {
            addCriterion("gmt_transfer in", values, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferNotIn(List<Date> values) {
            addCriterion("gmt_transfer not in", values, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferBetween(Date value1, Date value2) {
            addCriterion("gmt_transfer between", value1, value2, "gmtTransfer");
            return (Criteria) this;
        }

        public Criteria andGmtTransferNotBetween(Date value1, Date value2) {
            addCriterion("gmt_transfer not between", value1, value2, "gmtTransfer");
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

        public Criteria andAmountConsumedIsNull() {
            addCriterion("amount_consumed is null");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedIsNotNull() {
            addCriterion("amount_consumed is not null");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedEqualTo(Long value) {
            addCriterion("amount_consumed =", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedNotEqualTo(Long value) {
            addCriterion("amount_consumed <>", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedGreaterThan(Long value) {
            addCriterion("amount_consumed >", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedGreaterThanOrEqualTo(Long value) {
            addCriterion("amount_consumed >=", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedLessThan(Long value) {
            addCriterion("amount_consumed <", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedLessThanOrEqualTo(Long value) {
            addCriterion("amount_consumed <=", value, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedIn(List<Long> values) {
            addCriterion("amount_consumed in", values, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedNotIn(List<Long> values) {
            addCriterion("amount_consumed not in", values, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedBetween(Long value1, Long value2) {
            addCriterion("amount_consumed between", value1, value2, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andAmountConsumedNotBetween(Long value1, Long value2) {
            addCriterion("amount_consumed not between", value1, value2, "amountConsumed");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIsNull() {
            addCriterion("gmt_expired is null");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIsNotNull() {
            addCriterion("gmt_expired is not null");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredEqualTo(Date value) {
            addCriterion("gmt_expired =", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotEqualTo(Date value) {
            addCriterion("gmt_expired <>", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredGreaterThan(Date value) {
            addCriterion("gmt_expired >", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_expired >=", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredLessThan(Date value) {
            addCriterion("gmt_expired <", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredLessThanOrEqualTo(Date value) {
            addCriterion("gmt_expired <=", value, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredIn(List<Date> values) {
            addCriterion("gmt_expired in", values, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotIn(List<Date> values) {
            addCriterion("gmt_expired not in", values, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredBetween(Date value1, Date value2) {
            addCriterion("gmt_expired between", value1, value2, "gmtExpired");
            return (Criteria) this;
        }

        public Criteria andGmtExpiredNotBetween(Date value1, Date value2) {
            addCriterion("gmt_expired not between", value1, value2, "gmtExpired");
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

        public Criteria andObtainMethodIsNull() {
            addCriterion("obtain_method is null");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIsNotNull() {
            addCriterion("obtain_method is not null");
            return (Criteria) this;
        }

        public Criteria andObtainMethodEqualTo(String value) {
            addCriterion("obtain_method =", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodNotEqualTo(String value) {
            addCriterion("obtain_method <>", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodGreaterThan(String value) {
            addCriterion("obtain_method >", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_method >=", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodLessThan(String value) {
            addCriterion("obtain_method <", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodLessThanOrEqualTo(String value) {
            addCriterion("obtain_method <=", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodLike(String value) {
            addCriterion("obtain_method like", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodNotLike(String value) {
            addCriterion("obtain_method not like", value, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIn(List<String> values) {
            addCriterion("obtain_method in", values, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodNotIn(List<String> values) {
            addCriterion("obtain_method not in", values, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodBetween(String value1, String value2) {
            addCriterion("obtain_method between", value1, value2, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodNotBetween(String value1, String value2) {
            addCriterion("obtain_method not between", value1, value2, "obtainMethod");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdIsNull() {
            addCriterion("obtain_method_id is null");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdIsNotNull() {
            addCriterion("obtain_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdEqualTo(Long value) {
            addCriterion("obtain_method_id =", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdNotEqualTo(Long value) {
            addCriterion("obtain_method_id <>", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdGreaterThan(Long value) {
            addCriterion("obtain_method_id >", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdGreaterThanOrEqualTo(Long value) {
            addCriterion("obtain_method_id >=", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdLessThan(Long value) {
            addCriterion("obtain_method_id <", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdLessThanOrEqualTo(Long value) {
            addCriterion("obtain_method_id <=", value, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdIn(List<Long> values) {
            addCriterion("obtain_method_id in", values, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdNotIn(List<Long> values) {
            addCriterion("obtain_method_id not in", values, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdBetween(Long value1, Long value2) {
            addCriterion("obtain_method_id between", value1, value2, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andObtainMethodIdNotBetween(Long value1, Long value2) {
            addCriterion("obtain_method_id not between", value1, value2, "obtainMethodId");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionIsNull() {
            addCriterion("point_obtain_version is null");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionIsNotNull() {
            addCriterion("point_obtain_version is not null");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionEqualTo(Long value) {
            addCriterion("point_obtain_version =", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionNotEqualTo(Long value) {
            addCriterion("point_obtain_version <>", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionGreaterThan(Long value) {
            addCriterion("point_obtain_version >", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("point_obtain_version >=", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionLessThan(Long value) {
            addCriterion("point_obtain_version <", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionLessThanOrEqualTo(Long value) {
            addCriterion("point_obtain_version <=", value, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionIn(List<Long> values) {
            addCriterion("point_obtain_version in", values, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionNotIn(List<Long> values) {
            addCriterion("point_obtain_version not in", values, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionBetween(Long value1, Long value2) {
            addCriterion("point_obtain_version between", value1, value2, "pointObtainVersion");
            return (Criteria) this;
        }

        public Criteria andPointObtainVersionNotBetween(Long value1, Long value2) {
            addCriterion("point_obtain_version not between", value1, value2, "pointObtainVersion");
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