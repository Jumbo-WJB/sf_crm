package com.shufensoft.crm.biz.domain.generation.send;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailStatusReportExample {
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

    public MailStatusReportExample() {
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

    public void addSeqIdQueryColumn() {
        this.queryColumns.add("seq_id");
    }

    public void addMaxSeqIdQueryColumn() {
        this.queryColumns.add("max(seq_id) max_seq_id");
    }

    public void addMinSeqIdQueryColumn() {
        this.queryColumns.add("min(seq_id) min_seq_id");
    }

    public void addAvgSeqIdQueryColumn() {
        this.queryColumns.add(" avg(seq_id) avg_seq_id");
    }

    public void addCountSeqIdQueryColumn() {
        this.queryColumns.add(" count(seq_id) count_seq_id");
    }

    public void addSumSeqIdQueryColumn() {
        this.queryColumns.add(" sum(seq_id) sum_seq_id");
    }

    public void addEmailAddressQueryColumn() {
        this.queryColumns.add("email_address");
    }

    public void addMaxEmailAddressQueryColumn() {
        this.queryColumns.add("max(email_address) max_email_address");
    }

    public void addMinEmailAddressQueryColumn() {
        this.queryColumns.add("min(email_address) min_email_address");
    }

    public void addAvgEmailAddressQueryColumn() {
        this.queryColumns.add(" avg(email_address) avg_email_address");
    }

    public void addCountEmailAddressQueryColumn() {
        this.queryColumns.add(" count(email_address) count_email_address");
    }

    public void addSumEmailAddressQueryColumn() {
        this.queryColumns.add(" sum(email_address) sum_email_address");
    }

    public void addIsSuccessQueryColumn() {
        this.queryColumns.add("is_success");
    }

    public void addMaxIsSuccessQueryColumn() {
        this.queryColumns.add("max(is_success) max_is_success");
    }

    public void addMinIsSuccessQueryColumn() {
        this.queryColumns.add("min(is_success) min_is_success");
    }

    public void addAvgIsSuccessQueryColumn() {
        this.queryColumns.add(" avg(is_success) avg_is_success");
    }

    public void addCountIsSuccessQueryColumn() {
        this.queryColumns.add(" count(is_success) count_is_success");
    }

    public void addSumIsSuccessQueryColumn() {
        this.queryColumns.add(" sum(is_success) sum_is_success");
    }

    public void addIsBackQueryColumn() {
        this.queryColumns.add("is_back");
    }

    public void addMaxIsBackQueryColumn() {
        this.queryColumns.add("max(is_back) max_is_back");
    }

    public void addMinIsBackQueryColumn() {
        this.queryColumns.add("min(is_back) min_is_back");
    }

    public void addAvgIsBackQueryColumn() {
        this.queryColumns.add(" avg(is_back) avg_is_back");
    }

    public void addCountIsBackQueryColumn() {
        this.queryColumns.add(" count(is_back) count_is_back");
    }

    public void addSumIsBackQueryColumn() {
        this.queryColumns.add(" sum(is_back) sum_is_back");
    }

    public void addIsOpenQueryColumn() {
        this.queryColumns.add("is_open");
    }

    public void addMaxIsOpenQueryColumn() {
        this.queryColumns.add("max(is_open) max_is_open");
    }

    public void addMinIsOpenQueryColumn() {
        this.queryColumns.add("min(is_open) min_is_open");
    }

    public void addAvgIsOpenQueryColumn() {
        this.queryColumns.add(" avg(is_open) avg_is_open");
    }

    public void addCountIsOpenQueryColumn() {
        this.queryColumns.add(" count(is_open) count_is_open");
    }

    public void addSumIsOpenQueryColumn() {
        this.queryColumns.add(" sum(is_open) sum_is_open");
    }

    public void addIsUnsubscribeQueryColumn() {
        this.queryColumns.add("is_unsubscribe");
    }

    public void addMaxIsUnsubscribeQueryColumn() {
        this.queryColumns.add("max(is_unsubscribe) max_is_unsubscribe");
    }

    public void addMinIsUnsubscribeQueryColumn() {
        this.queryColumns.add("min(is_unsubscribe) min_is_unsubscribe");
    }

    public void addAvgIsUnsubscribeQueryColumn() {
        this.queryColumns.add(" avg(is_unsubscribe) avg_is_unsubscribe");
    }

    public void addCountIsUnsubscribeQueryColumn() {
        this.queryColumns.add(" count(is_unsubscribe) count_is_unsubscribe");
    }

    public void addSumIsUnsubscribeQueryColumn() {
        this.queryColumns.add(" sum(is_unsubscribe) sum_is_unsubscribe");
    }

    public void addIsComplaintsQueryColumn() {
        this.queryColumns.add("is_complaints");
    }

    public void addMaxIsComplaintsQueryColumn() {
        this.queryColumns.add("max(is_complaints) max_is_complaints");
    }

    public void addMinIsComplaintsQueryColumn() {
        this.queryColumns.add("min(is_complaints) min_is_complaints");
    }

    public void addAvgIsComplaintsQueryColumn() {
        this.queryColumns.add(" avg(is_complaints) avg_is_complaints");
    }

    public void addCountIsComplaintsQueryColumn() {
        this.queryColumns.add(" count(is_complaints) count_is_complaints");
    }

    public void addSumIsComplaintsQueryColumn() {
        this.queryColumns.add(" sum(is_complaints) sum_is_complaints");
    }

    public void addSubmitDataQueryColumn() {
        this.queryColumns.add("submit_data");
    }

    public void addMaxSubmitDataQueryColumn() {
        this.queryColumns.add("max(submit_data) max_submit_data");
    }

    public void addMinSubmitDataQueryColumn() {
        this.queryColumns.add("min(submit_data) min_submit_data");
    }

    public void addAvgSubmitDataQueryColumn() {
        this.queryColumns.add(" avg(submit_data) avg_submit_data");
    }

    public void addCountSubmitDataQueryColumn() {
        this.queryColumns.add(" count(submit_data) count_submit_data");
    }

    public void addSumSubmitDataQueryColumn() {
        this.queryColumns.add(" sum(submit_data) sum_submit_data");
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

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(String value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(String value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(String value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(String value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(String value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLike(String value) {
            addCriterion("seq_id like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotLike(String value) {
            addCriterion("seq_id not like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<String> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<String> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(String value1, String value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(String value1, String value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNull() {
            addCriterion("email_address is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNotNull() {
            addCriterion("email_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressEqualTo(String value) {
            addCriterion("email_address =", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotEqualTo(String value) {
            addCriterion("email_address <>", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThan(String value) {
            addCriterion("email_address >", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("email_address >=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThan(String value) {
            addCriterion("email_address <", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("email_address <=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLike(String value) {
            addCriterion("email_address like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotLike(String value) {
            addCriterion("email_address not like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIn(List<String> values) {
            addCriterion("email_address in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotIn(List<String> values) {
            addCriterion("email_address not in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressBetween(String value1, String value2) {
            addCriterion("email_address between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotBetween(String value1, String value2) {
            addCriterion("email_address not between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIsNull() {
            addCriterion("is_success is null");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIsNotNull() {
            addCriterion("is_success is not null");
            return (Criteria) this;
        }

        public Criteria andIsSuccessEqualTo(String value) {
            addCriterion("is_success =", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotEqualTo(String value) {
            addCriterion("is_success <>", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessGreaterThan(String value) {
            addCriterion("is_success >", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessGreaterThanOrEqualTo(String value) {
            addCriterion("is_success >=", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessLessThan(String value) {
            addCriterion("is_success <", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessLessThanOrEqualTo(String value) {
            addCriterion("is_success <=", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessLike(String value) {
            addCriterion("is_success like", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotLike(String value) {
            addCriterion("is_success not like", value, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessIn(List<String> values) {
            addCriterion("is_success in", values, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotIn(List<String> values) {
            addCriterion("is_success not in", values, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessBetween(String value1, String value2) {
            addCriterion("is_success between", value1, value2, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsSuccessNotBetween(String value1, String value2) {
            addCriterion("is_success not between", value1, value2, "isSuccess");
            return (Criteria) this;
        }

        public Criteria andIsBackIsNull() {
            addCriterion("is_back is null");
            return (Criteria) this;
        }

        public Criteria andIsBackIsNotNull() {
            addCriterion("is_back is not null");
            return (Criteria) this;
        }

        public Criteria andIsBackEqualTo(String value) {
            addCriterion("is_back =", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackNotEqualTo(String value) {
            addCriterion("is_back <>", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackGreaterThan(String value) {
            addCriterion("is_back >", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackGreaterThanOrEqualTo(String value) {
            addCriterion("is_back >=", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackLessThan(String value) {
            addCriterion("is_back <", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackLessThanOrEqualTo(String value) {
            addCriterion("is_back <=", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackLike(String value) {
            addCriterion("is_back like", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackNotLike(String value) {
            addCriterion("is_back not like", value, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackIn(List<String> values) {
            addCriterion("is_back in", values, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackNotIn(List<String> values) {
            addCriterion("is_back not in", values, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackBetween(String value1, String value2) {
            addCriterion("is_back between", value1, value2, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsBackNotBetween(String value1, String value2) {
            addCriterion("is_back not between", value1, value2, "isBack");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(String value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(String value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(String value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(String value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(String value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(String value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLike(String value) {
            addCriterion("is_open like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotLike(String value) {
            addCriterion("is_open not like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<String> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<String> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(String value1, String value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(String value1, String value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeIsNull() {
            addCriterion("is_unsubscribe is null");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeIsNotNull() {
            addCriterion("is_unsubscribe is not null");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeEqualTo(String value) {
            addCriterion("is_unsubscribe =", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeNotEqualTo(String value) {
            addCriterion("is_unsubscribe <>", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeGreaterThan(String value) {
            addCriterion("is_unsubscribe >", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeGreaterThanOrEqualTo(String value) {
            addCriterion("is_unsubscribe >=", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeLessThan(String value) {
            addCriterion("is_unsubscribe <", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeLessThanOrEqualTo(String value) {
            addCriterion("is_unsubscribe <=", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeLike(String value) {
            addCriterion("is_unsubscribe like", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeNotLike(String value) {
            addCriterion("is_unsubscribe not like", value, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeIn(List<String> values) {
            addCriterion("is_unsubscribe in", values, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeNotIn(List<String> values) {
            addCriterion("is_unsubscribe not in", values, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeBetween(String value1, String value2) {
            addCriterion("is_unsubscribe between", value1, value2, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsUnsubscribeNotBetween(String value1, String value2) {
            addCriterion("is_unsubscribe not between", value1, value2, "isUnsubscribe");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsIsNull() {
            addCriterion("is_complaints is null");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsIsNotNull() {
            addCriterion("is_complaints is not null");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsEqualTo(String value) {
            addCriterion("is_complaints =", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsNotEqualTo(String value) {
            addCriterion("is_complaints <>", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsGreaterThan(String value) {
            addCriterion("is_complaints >", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsGreaterThanOrEqualTo(String value) {
            addCriterion("is_complaints >=", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsLessThan(String value) {
            addCriterion("is_complaints <", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsLessThanOrEqualTo(String value) {
            addCriterion("is_complaints <=", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsLike(String value) {
            addCriterion("is_complaints like", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsNotLike(String value) {
            addCriterion("is_complaints not like", value, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsIn(List<String> values) {
            addCriterion("is_complaints in", values, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsNotIn(List<String> values) {
            addCriterion("is_complaints not in", values, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsBetween(String value1, String value2) {
            addCriterion("is_complaints between", value1, value2, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andIsComplaintsNotBetween(String value1, String value2) {
            addCriterion("is_complaints not between", value1, value2, "isComplaints");
            return (Criteria) this;
        }

        public Criteria andSubmitDataIsNull() {
            addCriterion("submit_data is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDataIsNotNull() {
            addCriterion("submit_data is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDataEqualTo(Date value) {
            addCriterion("submit_data =", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataNotEqualTo(Date value) {
            addCriterion("submit_data <>", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataGreaterThan(Date value) {
            addCriterion("submit_data >", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_data >=", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataLessThan(Date value) {
            addCriterion("submit_data <", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataLessThanOrEqualTo(Date value) {
            addCriterion("submit_data <=", value, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataIn(List<Date> values) {
            addCriterion("submit_data in", values, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataNotIn(List<Date> values) {
            addCriterion("submit_data not in", values, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataBetween(Date value1, Date value2) {
            addCriterion("submit_data between", value1, value2, "submitData");
            return (Criteria) this;
        }

        public Criteria andSubmitDataNotBetween(Date value1, Date value2) {
            addCriterion("submit_data not between", value1, value2, "submitData");
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