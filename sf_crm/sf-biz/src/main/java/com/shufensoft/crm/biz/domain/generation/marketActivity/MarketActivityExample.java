package com.shufensoft.crm.biz.domain.generation.marketActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketActivityExample {
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

    public MarketActivityExample() {
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

    public void addSumActivityIdQueryColumn() {
        this.queryColumns.add(" sum(activity_id) sum_activity_id");
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

    public void addTargetQueryColumn() {
        this.queryColumns.add("target");
    }

    public void addMaxTargetQueryColumn() {
        this.queryColumns.add("max(target) max_target");
    }

    public void addMinTargetQueryColumn() {
        this.queryColumns.add("min(target) min_target");
    }

    public void addAvgTargetQueryColumn() {
        this.queryColumns.add(" avg(target) avg_target");
    }

    public void addCountTargetQueryColumn() {
        this.queryColumns.add(" count(target) count_target");
    }

    public void addSumTargetQueryColumn() {
        this.queryColumns.add(" sum(target) sum_target");
    }

    public void addTypeQueryColumn() {
        this.queryColumns.add("type");
    }

    public void addMaxTypeQueryColumn() {
        this.queryColumns.add("max(type) max_type");
    }

    public void addMinTypeQueryColumn() {
        this.queryColumns.add("min(type) min_type");
    }

    public void addAvgTypeQueryColumn() {
        this.queryColumns.add(" avg(type) avg_type");
    }

    public void addCountTypeQueryColumn() {
        this.queryColumns.add(" count(type) count_type");
    }

    public void addSumTypeQueryColumn() {
        this.queryColumns.add(" sum(type) sum_type");
    }

    public void addContentTypeQueryColumn() {
        this.queryColumns.add("content_type");
    }

    public void addMaxContentTypeQueryColumn() {
        this.queryColumns.add("max(content_type) max_content_type");
    }

    public void addMinContentTypeQueryColumn() {
        this.queryColumns.add("min(content_type) min_content_type");
    }

    public void addAvgContentTypeQueryColumn() {
        this.queryColumns.add(" avg(content_type) avg_content_type");
    }

    public void addCountContentTypeQueryColumn() {
        this.queryColumns.add(" count(content_type) count_content_type");
    }

    public void addSumContentTypeQueryColumn() {
        this.queryColumns.add(" sum(content_type) sum_content_type");
    }

    public void addContentQueryColumn() {
        this.queryColumns.add("content");
    }

    public void addMaxContentQueryColumn() {
        this.queryColumns.add("max(content) max_content");
    }

    public void addMinContentQueryColumn() {
        this.queryColumns.add("min(content) min_content");
    }

    public void addAvgContentQueryColumn() {
        this.queryColumns.add(" avg(content) avg_content");
    }

    public void addCountContentQueryColumn() {
        this.queryColumns.add(" count(content) count_content");
    }

    public void addSumContentQueryColumn() {
        this.queryColumns.add(" sum(content) sum_content");
    }

    public void addUrlQueryColumn() {
        this.queryColumns.add("url");
    }

    public void addMaxUrlQueryColumn() {
        this.queryColumns.add("max(url) max_url");
    }

    public void addMinUrlQueryColumn() {
        this.queryColumns.add("min(url) min_url");
    }

    public void addAvgUrlQueryColumn() {
        this.queryColumns.add(" avg(url) avg_url");
    }

    public void addCountUrlQueryColumn() {
        this.queryColumns.add(" count(url) count_url");
    }

    public void addSumUrlQueryColumn() {
        this.queryColumns.add(" sum(url) sum_url");
    }

    public void addEmailTypeQueryColumn() {
        this.queryColumns.add("email_type");
    }

    public void addMaxEmailTypeQueryColumn() {
        this.queryColumns.add("max(email_type) max_email_type");
    }

    public void addMinEmailTypeQueryColumn() {
        this.queryColumns.add("min(email_type) min_email_type");
    }

    public void addAvgEmailTypeQueryColumn() {
        this.queryColumns.add(" avg(email_type) avg_email_type");
    }

    public void addCountEmailTypeQueryColumn() {
        this.queryColumns.add(" count(email_type) count_email_type");
    }

    public void addSumEmailTypeQueryColumn() {
        this.queryColumns.add(" sum(email_type) sum_email_type");
    }

    public void addWxMediaIdQueryColumn() {
        this.queryColumns.add("wx_media_id");
    }

    public void addMaxWxMediaIdQueryColumn() {
        this.queryColumns.add("max(wx_media_id) max_wx_media_id");
    }

    public void addMinWxMediaIdQueryColumn() {
        this.queryColumns.add("min(wx_media_id) min_wx_media_id");
    }

    public void addAvgWxMediaIdQueryColumn() {
        this.queryColumns.add(" avg(wx_media_id) avg_wx_media_id");
    }

    public void addCountWxMediaIdQueryColumn() {
        this.queryColumns.add(" count(wx_media_id) count_wx_media_id");
    }

    public void addSumWxMediaIdQueryColumn() {
        this.queryColumns.add(" sum(wx_media_id) sum_wx_media_id");
    }

    public void addWxSourceTypeQueryColumn() {
        this.queryColumns.add("wx_source_Type");
    }

    public void addMaxWxSourceTypeQueryColumn() {
        this.queryColumns.add("max(wx_source_Type) max_wx_source_Type");
    }

    public void addMinWxSourceTypeQueryColumn() {
        this.queryColumns.add("min(wx_source_Type) min_wx_source_Type");
    }

    public void addAvgWxSourceTypeQueryColumn() {
        this.queryColumns.add(" avg(wx_source_Type) avg_wx_source_Type");
    }

    public void addCountWxSourceTypeQueryColumn() {
        this.queryColumns.add(" count(wx_source_Type) count_wx_source_Type");
    }

    public void addSumWxSourceTypeQueryColumn() {
        this.queryColumns.add(" sum(wx_source_Type) sum_wx_source_Type");
    }

    public void addWxPersonCountQueryColumn() {
        this.queryColumns.add("wx_person_Count");
    }

    public void addMaxWxPersonCountQueryColumn() {
        this.queryColumns.add("max(wx_person_Count) max_wx_person_Count");
    }

    public void addMinWxPersonCountQueryColumn() {
        this.queryColumns.add("min(wx_person_Count) min_wx_person_Count");
    }

    public void addAvgWxPersonCountQueryColumn() {
        this.queryColumns.add(" avg(wx_person_Count) avg_wx_person_Count");
    }

    public void addCountWxPersonCountQueryColumn() {
        this.queryColumns.add(" count(wx_person_Count) count_wx_person_Count");
    }

    public void addSumWxPersonCountQueryColumn() {
        this.queryColumns.add(" sum(wx_person_Count) sum_wx_person_Count");
    }

    public void addFeedbackNumberQueryColumn() {
        this.queryColumns.add("feedback_number");
    }

    public void addMaxFeedbackNumberQueryColumn() {
        this.queryColumns.add("max(feedback_number) max_feedback_number");
    }

    public void addMinFeedbackNumberQueryColumn() {
        this.queryColumns.add("min(feedback_number) min_feedback_number");
    }

    public void addAvgFeedbackNumberQueryColumn() {
        this.queryColumns.add(" avg(feedback_number) avg_feedback_number");
    }

    public void addCountFeedbackNumberQueryColumn() {
        this.queryColumns.add(" count(feedback_number) count_feedback_number");
    }

    public void addSumFeedbackNumberQueryColumn() {
        this.queryColumns.add(" sum(feedback_number) sum_feedback_number");
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

    public void addExecuteTimeQueryColumn() {
        this.queryColumns.add("execute_time");
    }

    public void addMaxExecuteTimeQueryColumn() {
        this.queryColumns.add("max(execute_time) max_execute_time");
    }

    public void addMinExecuteTimeQueryColumn() {
        this.queryColumns.add("min(execute_time) min_execute_time");
    }

    public void addAvgExecuteTimeQueryColumn() {
        this.queryColumns.add(" avg(execute_time) avg_execute_time");
    }

    public void addCountExecuteTimeQueryColumn() {
        this.queryColumns.add(" count(execute_time) count_execute_time");
    }

    public void addSumExecuteTimeQueryColumn() {
        this.queryColumns.add(" sum(execute_time) sum_execute_time");
    }

    public void addExecuteTypeQueryColumn() {
        this.queryColumns.add("execute_type");
    }

    public void addMaxExecuteTypeQueryColumn() {
        this.queryColumns.add("max(execute_type) max_execute_type");
    }

    public void addMinExecuteTypeQueryColumn() {
        this.queryColumns.add("min(execute_type) min_execute_type");
    }

    public void addAvgExecuteTypeQueryColumn() {
        this.queryColumns.add(" avg(execute_type) avg_execute_type");
    }

    public void addCountExecuteTypeQueryColumn() {
        this.queryColumns.add(" count(execute_type) count_execute_type");
    }

    public void addSumExecuteTypeQueryColumn() {
        this.queryColumns.add(" sum(execute_type) sum_execute_type");
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

        public Criteria andTargetIsNull() {
            addCriterion("target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("target like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("target not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andEmailTypeIsNull() {
            addCriterion("email_type is null");
            return (Criteria) this;
        }

        public Criteria andEmailTypeIsNotNull() {
            addCriterion("email_type is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTypeEqualTo(String value) {
            addCriterion("email_type =", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotEqualTo(String value) {
            addCriterion("email_type <>", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeGreaterThan(String value) {
            addCriterion("email_type >", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeGreaterThanOrEqualTo(String value) {
            addCriterion("email_type >=", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLessThan(String value) {
            addCriterion("email_type <", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLessThanOrEqualTo(String value) {
            addCriterion("email_type <=", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeLike(String value) {
            addCriterion("email_type like", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotLike(String value) {
            addCriterion("email_type not like", value, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeIn(List<String> values) {
            addCriterion("email_type in", values, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotIn(List<String> values) {
            addCriterion("email_type not in", values, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeBetween(String value1, String value2) {
            addCriterion("email_type between", value1, value2, "emailType");
            return (Criteria) this;
        }

        public Criteria andEmailTypeNotBetween(String value1, String value2) {
            addCriterion("email_type not between", value1, value2, "emailType");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdIsNull() {
            addCriterion("wx_media_id is null");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdIsNotNull() {
            addCriterion("wx_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdEqualTo(String value) {
            addCriterion("wx_media_id =", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdNotEqualTo(String value) {
            addCriterion("wx_media_id <>", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdGreaterThan(String value) {
            addCriterion("wx_media_id >", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_media_id >=", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdLessThan(String value) {
            addCriterion("wx_media_id <", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdLessThanOrEqualTo(String value) {
            addCriterion("wx_media_id <=", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdLike(String value) {
            addCriterion("wx_media_id like", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdNotLike(String value) {
            addCriterion("wx_media_id not like", value, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdIn(List<String> values) {
            addCriterion("wx_media_id in", values, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdNotIn(List<String> values) {
            addCriterion("wx_media_id not in", values, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdBetween(String value1, String value2) {
            addCriterion("wx_media_id between", value1, value2, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxMediaIdNotBetween(String value1, String value2) {
            addCriterion("wx_media_id not between", value1, value2, "wxMediaId");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeIsNull() {
            addCriterion("wx_source_Type is null");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeIsNotNull() {
            addCriterion("wx_source_Type is not null");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeEqualTo(String value) {
            addCriterion("wx_source_Type =", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeNotEqualTo(String value) {
            addCriterion("wx_source_Type <>", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeGreaterThan(String value) {
            addCriterion("wx_source_Type >", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_source_Type >=", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeLessThan(String value) {
            addCriterion("wx_source_Type <", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("wx_source_Type <=", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeLike(String value) {
            addCriterion("wx_source_Type like", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeNotLike(String value) {
            addCriterion("wx_source_Type not like", value, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeIn(List<String> values) {
            addCriterion("wx_source_Type in", values, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeNotIn(List<String> values) {
            addCriterion("wx_source_Type not in", values, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeBetween(String value1, String value2) {
            addCriterion("wx_source_Type between", value1, value2, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxSourceTypeNotBetween(String value1, String value2) {
            addCriterion("wx_source_Type not between", value1, value2, "wxSourceType");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountIsNull() {
            addCriterion("wx_person_Count is null");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountIsNotNull() {
            addCriterion("wx_person_Count is not null");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountEqualTo(Integer value) {
            addCriterion("wx_person_Count =", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountNotEqualTo(Integer value) {
            addCriterion("wx_person_Count <>", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountGreaterThan(Integer value) {
            addCriterion("wx_person_Count >", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wx_person_Count >=", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountLessThan(Integer value) {
            addCriterion("wx_person_Count <", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("wx_person_Count <=", value, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountIn(List<Integer> values) {
            addCriterion("wx_person_Count in", values, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountNotIn(List<Integer> values) {
            addCriterion("wx_person_Count not in", values, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("wx_person_Count between", value1, value2, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andWxPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wx_person_Count not between", value1, value2, "wxPersonCount");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberIsNull() {
            addCriterion("feedback_number is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberIsNotNull() {
            addCriterion("feedback_number is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberEqualTo(Integer value) {
            addCriterion("feedback_number =", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberNotEqualTo(Integer value) {
            addCriterion("feedback_number <>", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberGreaterThan(Integer value) {
            addCriterion("feedback_number >", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_number >=", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberLessThan(Integer value) {
            addCriterion("feedback_number <", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_number <=", value, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberIn(List<Integer> values) {
            addCriterion("feedback_number in", values, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberNotIn(List<Integer> values) {
            addCriterion("feedback_number not in", values, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberBetween(Integer value1, Integer value2) {
            addCriterion("feedback_number between", value1, value2, "feedbackNumber");
            return (Criteria) this;
        }

        public Criteria andFeedbackNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_number not between", value1, value2, "feedbackNumber");
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

        public Criteria andExecuteTimeIsNull() {
            addCriterion("execute_time is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNotNull() {
            addCriterion("execute_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeEqualTo(Date value) {
            addCriterion("execute_time =", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotEqualTo(Date value) {
            addCriterion("execute_time <>", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThan(Date value) {
            addCriterion("execute_time >", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("execute_time >=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThan(Date value) {
            addCriterion("execute_time <", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("execute_time <=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIn(List<Date> values) {
            addCriterion("execute_time in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotIn(List<Date> values) {
            addCriterion("execute_time not in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("execute_time between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("execute_time not between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIsNull() {
            addCriterion("execute_type is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIsNotNull() {
            addCriterion("execute_type is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeEqualTo(String value) {
            addCriterion("execute_type =", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotEqualTo(String value) {
            addCriterion("execute_type <>", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeGreaterThan(String value) {
            addCriterion("execute_type >", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("execute_type >=", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeLessThan(String value) {
            addCriterion("execute_type <", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeLessThanOrEqualTo(String value) {
            addCriterion("execute_type <=", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeLike(String value) {
            addCriterion("execute_type like", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotLike(String value) {
            addCriterion("execute_type not like", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIn(List<String> values) {
            addCriterion("execute_type in", values, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotIn(List<String> values) {
            addCriterion("execute_type not in", values, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeBetween(String value1, String value2) {
            addCriterion("execute_type between", value1, value2, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotBetween(String value1, String value2) {
            addCriterion("execute_type not between", value1, value2, "executeType");
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