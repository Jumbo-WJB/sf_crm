package com.shufensoft.crm.biz.domain.generation.send;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendPlanExample {
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

    public SendPlanExample() {
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

    public void addCampaignidQueryColumn() {
        this.queryColumns.add("campaignId");
    }

    public void addMaxCampaignidQueryColumn() {
        this.queryColumns.add("max(campaignId) max_campaignId");
    }

    public void addMinCampaignidQueryColumn() {
        this.queryColumns.add("min(campaignId) min_campaignId");
    }

    public void addAvgCampaignidQueryColumn() {
        this.queryColumns.add(" avg(campaignId) avg_campaignId");
    }

    public void addCountCampaignidQueryColumn() {
        this.queryColumns.add(" count(campaignId) count_campaignId");
    }

    public void addSumCampaignidQueryColumn() {
        this.queryColumns.add(" sum(campaignId) sum_campaignId");
    }

    public void addSaleTypeQueryColumn() {
        this.queryColumns.add("sale_type");
    }

    public void addMaxSaleTypeQueryColumn() {
        this.queryColumns.add("max(sale_type) max_sale_type");
    }

    public void addMinSaleTypeQueryColumn() {
        this.queryColumns.add("min(sale_type) min_sale_type");
    }

    public void addAvgSaleTypeQueryColumn() {
        this.queryColumns.add(" avg(sale_type) avg_sale_type");
    }

    public void addCountSaleTypeQueryColumn() {
        this.queryColumns.add(" count(sale_type) count_sale_type");
    }

    public void addSumSaleTypeQueryColumn() {
        this.queryColumns.add(" sum(sale_type) sum_sale_type");
    }

    public void addSendTypeQueryColumn() {
        this.queryColumns.add("send_type");
    }

    public void addMaxSendTypeQueryColumn() {
        this.queryColumns.add("max(send_type) max_send_type");
    }

    public void addMinSendTypeQueryColumn() {
        this.queryColumns.add("min(send_type) min_send_type");
    }

    public void addAvgSendTypeQueryColumn() {
        this.queryColumns.add(" avg(send_type) avg_send_type");
    }

    public void addCountSendTypeQueryColumn() {
        this.queryColumns.add(" count(send_type) count_send_type");
    }

    public void addSumSendTypeQueryColumn() {
        this.queryColumns.add(" sum(send_type) sum_send_type");
    }

    public void addStatusQueryColumn() {
        this.queryColumns.add("STATUS");
    }

    public void addMaxStatusQueryColumn() {
        this.queryColumns.add("max(STATUS) max_STATUS");
    }

    public void addMinStatusQueryColumn() {
        this.queryColumns.add("min(STATUS) min_STATUS");
    }

    public void addAvgStatusQueryColumn() {
        this.queryColumns.add(" avg(STATUS) avg_STATUS");
    }

    public void addCountStatusQueryColumn() {
        this.queryColumns.add(" count(STATUS) count_STATUS");
    }

    public void addSumStatusQueryColumn() {
        this.queryColumns.add(" sum(STATUS) sum_STATUS");
    }

    public void addFlagQueryColumn() {
        this.queryColumns.add("flag");
    }

    public void addMaxFlagQueryColumn() {
        this.queryColumns.add("max(flag) max_flag");
    }

    public void addMinFlagQueryColumn() {
        this.queryColumns.add("min(flag) min_flag");
    }

    public void addAvgFlagQueryColumn() {
        this.queryColumns.add(" avg(flag) avg_flag");
    }

    public void addCountFlagQueryColumn() {
        this.queryColumns.add(" count(flag) count_flag");
    }

    public void addSumFlagQueryColumn() {
        this.queryColumns.add(" sum(flag) sum_flag");
    }

    public void addSendTimeQueryColumn() {
        this.queryColumns.add("send_time");
    }

    public void addMaxSendTimeQueryColumn() {
        this.queryColumns.add("max(send_time) max_send_time");
    }

    public void addMinSendTimeQueryColumn() {
        this.queryColumns.add("min(send_time) min_send_time");
    }

    public void addAvgSendTimeQueryColumn() {
        this.queryColumns.add(" avg(send_time) avg_send_time");
    }

    public void addCountSendTimeQueryColumn() {
        this.queryColumns.add(" count(send_time) count_send_time");
    }

    public void addSumSendTimeQueryColumn() {
        this.queryColumns.add(" sum(send_time) sum_send_time");
    }

    public void addCreateTimeQueryColumn() {
        this.queryColumns.add("create_time");
    }

    public void addMaxCreateTimeQueryColumn() {
        this.queryColumns.add("max(create_time) max_create_time");
    }

    public void addMinCreateTimeQueryColumn() {
        this.queryColumns.add("min(create_time) min_create_time");
    }

    public void addAvgCreateTimeQueryColumn() {
        this.queryColumns.add(" avg(create_time) avg_create_time");
    }

    public void addCountCreateTimeQueryColumn() {
        this.queryColumns.add(" count(create_time) count_create_time");
    }

    public void addSumCreateTimeQueryColumn() {
        this.queryColumns.add(" sum(create_time) sum_create_time");
    }

    public void addSendTitleQueryColumn() {
        this.queryColumns.add("send_title");
    }

    public void addMaxSendTitleQueryColumn() {
        this.queryColumns.add("max(send_title) max_send_title");
    }

    public void addMinSendTitleQueryColumn() {
        this.queryColumns.add("min(send_title) min_send_title");
    }

    public void addAvgSendTitleQueryColumn() {
        this.queryColumns.add(" avg(send_title) avg_send_title");
    }

    public void addCountSendTitleQueryColumn() {
        this.queryColumns.add(" count(send_title) count_send_title");
    }

    public void addSumSendTitleQueryColumn() {
        this.queryColumns.add(" sum(send_title) sum_send_title");
    }

    public void addSendContentQueryColumn() {
        this.queryColumns.add("send_content");
    }

    public void addMaxSendContentQueryColumn() {
        this.queryColumns.add("max(send_content) max_send_content");
    }

    public void addMinSendContentQueryColumn() {
        this.queryColumns.add("min(send_content) min_send_content");
    }

    public void addAvgSendContentQueryColumn() {
        this.queryColumns.add(" avg(send_content) avg_send_content");
    }

    public void addCountSendContentQueryColumn() {
        this.queryColumns.add(" count(send_content) count_send_content");
    }

    public void addSumSendContentQueryColumn() {
        this.queryColumns.add(" sum(send_content) sum_send_content");
    }

    public void addSendFromQueryColumn() {
        this.queryColumns.add("send_from");
    }

    public void addMaxSendFromQueryColumn() {
        this.queryColumns.add("max(send_from) max_send_from");
    }

    public void addMinSendFromQueryColumn() {
        this.queryColumns.add("min(send_from) min_send_from");
    }

    public void addAvgSendFromQueryColumn() {
        this.queryColumns.add(" avg(send_from) avg_send_from");
    }

    public void addCountSendFromQueryColumn() {
        this.queryColumns.add(" count(send_from) count_send_from");
    }

    public void addSumSendFromQueryColumn() {
        this.queryColumns.add(" sum(send_from) sum_send_from");
    }

    public void addSendFromnameQueryColumn() {
        this.queryColumns.add("send_fromName");
    }

    public void addMaxSendFromnameQueryColumn() {
        this.queryColumns.add("max(send_fromName) max_send_fromName");
    }

    public void addMinSendFromnameQueryColumn() {
        this.queryColumns.add("min(send_fromName) min_send_fromName");
    }

    public void addAvgSendFromnameQueryColumn() {
        this.queryColumns.add(" avg(send_fromName) avg_send_fromName");
    }

    public void addCountSendFromnameQueryColumn() {
        this.queryColumns.add(" count(send_fromName) count_send_fromName");
    }

    public void addSumSendFromnameQueryColumn() {
        this.queryColumns.add(" sum(send_fromName) sum_send_fromName");
    }

    public void addSendPriorityQueryColumn() {
        this.queryColumns.add("send_priority");
    }

    public void addMaxSendPriorityQueryColumn() {
        this.queryColumns.add("max(send_priority) max_send_priority");
    }

    public void addMinSendPriorityQueryColumn() {
        this.queryColumns.add("min(send_priority) min_send_priority");
    }

    public void addAvgSendPriorityQueryColumn() {
        this.queryColumns.add(" avg(send_priority) avg_send_priority");
    }

    public void addCountSendPriorityQueryColumn() {
        this.queryColumns.add(" count(send_priority) count_send_priority");
    }

    public void addSumSendPriorityQueryColumn() {
        this.queryColumns.add(" sum(send_priority) sum_send_priority");
    }

    public void addSmsPassageQueryColumn() {
        this.queryColumns.add("sms_passage");
    }

    public void addMaxSmsPassageQueryColumn() {
        this.queryColumns.add("max(sms_passage) max_sms_passage");
    }

    public void addMinSmsPassageQueryColumn() {
        this.queryColumns.add("min(sms_passage) min_sms_passage");
    }

    public void addAvgSmsPassageQueryColumn() {
        this.queryColumns.add(" avg(sms_passage) avg_sms_passage");
    }

    public void addCountSmsPassageQueryColumn() {
        this.queryColumns.add(" count(sms_passage) count_sms_passage");
    }

    public void addSumSmsPassageQueryColumn() {
        this.queryColumns.add(" sum(sms_passage) sum_sms_passage");
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

    public void addFatigueQueryColumn() {
        this.queryColumns.add("fatigue");
    }

    public void addMaxFatigueQueryColumn() {
        this.queryColumns.add("max(fatigue) max_fatigue");
    }

    public void addMinFatigueQueryColumn() {
        this.queryColumns.add("min(fatigue) min_fatigue");
    }

    public void addAvgFatigueQueryColumn() {
        this.queryColumns.add(" avg(fatigue) avg_fatigue");
    }

    public void addCountFatigueQueryColumn() {
        this.queryColumns.add(" count(fatigue) count_fatigue");
    }

    public void addSumFatigueQueryColumn() {
        this.queryColumns.add(" sum(fatigue) sum_fatigue");
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

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
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

        public Criteria andCampaignidIsNull() {
            addCriterion("campaignId is null");
            return (Criteria) this;
        }

        public Criteria andCampaignidIsNotNull() {
            addCriterion("campaignId is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignidEqualTo(String value) {
            addCriterion("campaignId =", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidNotEqualTo(String value) {
            addCriterion("campaignId <>", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidGreaterThan(String value) {
            addCriterion("campaignId >", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidGreaterThanOrEqualTo(String value) {
            addCriterion("campaignId >=", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidLessThan(String value) {
            addCriterion("campaignId <", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidLessThanOrEqualTo(String value) {
            addCriterion("campaignId <=", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidLike(String value) {
            addCriterion("campaignId like", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidNotLike(String value) {
            addCriterion("campaignId not like", value, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidIn(List<String> values) {
            addCriterion("campaignId in", values, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidNotIn(List<String> values) {
            addCriterion("campaignId not in", values, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidBetween(String value1, String value2) {
            addCriterion("campaignId between", value1, value2, "campaignid");
            return (Criteria) this;
        }

        public Criteria andCampaignidNotBetween(String value1, String value2) {
            addCriterion("campaignId not between", value1, value2, "campaignid");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNull() {
            addCriterion("sale_type is null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIsNotNull() {
            addCriterion("sale_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTypeEqualTo(String value) {
            addCriterion("sale_type =", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotEqualTo(String value) {
            addCriterion("sale_type <>", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThan(String value) {
            addCriterion("sale_type >", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sale_type >=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThan(String value) {
            addCriterion("sale_type <", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLessThanOrEqualTo(String value) {
            addCriterion("sale_type <=", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeLike(String value) {
            addCriterion("sale_type like", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotLike(String value) {
            addCriterion("sale_type not like", value, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeIn(List<String> values) {
            addCriterion("sale_type in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotIn(List<String> values) {
            addCriterion("sale_type not in", values, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeBetween(String value1, String value2) {
            addCriterion("sale_type between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andSaleTypeNotBetween(String value1, String value2) {
            addCriterion("sale_type not between", value1, value2, "saleType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(String value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(String value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(String value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(String value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(String value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(String value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLike(String value) {
            addCriterion("send_type like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotLike(String value) {
            addCriterion("send_type not like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<String> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<String> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(String value1, String value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(String value1, String value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSendTitleIsNull() {
            addCriterion("send_title is null");
            return (Criteria) this;
        }

        public Criteria andSendTitleIsNotNull() {
            addCriterion("send_title is not null");
            return (Criteria) this;
        }

        public Criteria andSendTitleEqualTo(String value) {
            addCriterion("send_title =", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleNotEqualTo(String value) {
            addCriterion("send_title <>", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleGreaterThan(String value) {
            addCriterion("send_title >", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleGreaterThanOrEqualTo(String value) {
            addCriterion("send_title >=", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleLessThan(String value) {
            addCriterion("send_title <", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleLessThanOrEqualTo(String value) {
            addCriterion("send_title <=", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleLike(String value) {
            addCriterion("send_title like", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleNotLike(String value) {
            addCriterion("send_title not like", value, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleIn(List<String> values) {
            addCriterion("send_title in", values, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleNotIn(List<String> values) {
            addCriterion("send_title not in", values, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleBetween(String value1, String value2) {
            addCriterion("send_title between", value1, value2, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendTitleNotBetween(String value1, String value2) {
            addCriterion("send_title not between", value1, value2, "sendTitle");
            return (Criteria) this;
        }

        public Criteria andSendContentIsNull() {
            addCriterion("send_content is null");
            return (Criteria) this;
        }

        public Criteria andSendContentIsNotNull() {
            addCriterion("send_content is not null");
            return (Criteria) this;
        }

        public Criteria andSendContentEqualTo(String value) {
            addCriterion("send_content =", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentNotEqualTo(String value) {
            addCriterion("send_content <>", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentGreaterThan(String value) {
            addCriterion("send_content >", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentGreaterThanOrEqualTo(String value) {
            addCriterion("send_content >=", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentLessThan(String value) {
            addCriterion("send_content <", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentLessThanOrEqualTo(String value) {
            addCriterion("send_content <=", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentLike(String value) {
            addCriterion("send_content like", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentNotLike(String value) {
            addCriterion("send_content not like", value, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentIn(List<String> values) {
            addCriterion("send_content in", values, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentNotIn(List<String> values) {
            addCriterion("send_content not in", values, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentBetween(String value1, String value2) {
            addCriterion("send_content between", value1, value2, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendContentNotBetween(String value1, String value2) {
            addCriterion("send_content not between", value1, value2, "sendContent");
            return (Criteria) this;
        }

        public Criteria andSendFromIsNull() {
            addCriterion("send_from is null");
            return (Criteria) this;
        }

        public Criteria andSendFromIsNotNull() {
            addCriterion("send_from is not null");
            return (Criteria) this;
        }

        public Criteria andSendFromEqualTo(String value) {
            addCriterion("send_from =", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotEqualTo(String value) {
            addCriterion("send_from <>", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromGreaterThan(String value) {
            addCriterion("send_from >", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromGreaterThanOrEqualTo(String value) {
            addCriterion("send_from >=", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromLessThan(String value) {
            addCriterion("send_from <", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromLessThanOrEqualTo(String value) {
            addCriterion("send_from <=", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromLike(String value) {
            addCriterion("send_from like", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotLike(String value) {
            addCriterion("send_from not like", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromIn(List<String> values) {
            addCriterion("send_from in", values, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotIn(List<String> values) {
            addCriterion("send_from not in", values, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromBetween(String value1, String value2) {
            addCriterion("send_from between", value1, value2, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotBetween(String value1, String value2) {
            addCriterion("send_from not between", value1, value2, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromnameIsNull() {
            addCriterion("send_fromName is null");
            return (Criteria) this;
        }

        public Criteria andSendFromnameIsNotNull() {
            addCriterion("send_fromName is not null");
            return (Criteria) this;
        }

        public Criteria andSendFromnameEqualTo(String value) {
            addCriterion("send_fromName =", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameNotEqualTo(String value) {
            addCriterion("send_fromName <>", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameGreaterThan(String value) {
            addCriterion("send_fromName >", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameGreaterThanOrEqualTo(String value) {
            addCriterion("send_fromName >=", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameLessThan(String value) {
            addCriterion("send_fromName <", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameLessThanOrEqualTo(String value) {
            addCriterion("send_fromName <=", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameLike(String value) {
            addCriterion("send_fromName like", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameNotLike(String value) {
            addCriterion("send_fromName not like", value, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameIn(List<String> values) {
            addCriterion("send_fromName in", values, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameNotIn(List<String> values) {
            addCriterion("send_fromName not in", values, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameBetween(String value1, String value2) {
            addCriterion("send_fromName between", value1, value2, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendFromnameNotBetween(String value1, String value2) {
            addCriterion("send_fromName not between", value1, value2, "sendFromname");
            return (Criteria) this;
        }

        public Criteria andSendPriorityIsNull() {
            addCriterion("send_priority is null");
            return (Criteria) this;
        }

        public Criteria andSendPriorityIsNotNull() {
            addCriterion("send_priority is not null");
            return (Criteria) this;
        }

        public Criteria andSendPriorityEqualTo(String value) {
            addCriterion("send_priority =", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityNotEqualTo(String value) {
            addCriterion("send_priority <>", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityGreaterThan(String value) {
            addCriterion("send_priority >", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("send_priority >=", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityLessThan(String value) {
            addCriterion("send_priority <", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityLessThanOrEqualTo(String value) {
            addCriterion("send_priority <=", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityLike(String value) {
            addCriterion("send_priority like", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityNotLike(String value) {
            addCriterion("send_priority not like", value, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityIn(List<String> values) {
            addCriterion("send_priority in", values, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityNotIn(List<String> values) {
            addCriterion("send_priority not in", values, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityBetween(String value1, String value2) {
            addCriterion("send_priority between", value1, value2, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSendPriorityNotBetween(String value1, String value2) {
            addCriterion("send_priority not between", value1, value2, "sendPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPassageIsNull() {
            addCriterion("sms_passage is null");
            return (Criteria) this;
        }

        public Criteria andSmsPassageIsNotNull() {
            addCriterion("sms_passage is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPassageEqualTo(String value) {
            addCriterion("sms_passage =", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageNotEqualTo(String value) {
            addCriterion("sms_passage <>", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageGreaterThan(String value) {
            addCriterion("sms_passage >", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageGreaterThanOrEqualTo(String value) {
            addCriterion("sms_passage >=", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageLessThan(String value) {
            addCriterion("sms_passage <", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageLessThanOrEqualTo(String value) {
            addCriterion("sms_passage <=", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageLike(String value) {
            addCriterion("sms_passage like", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageNotLike(String value) {
            addCriterion("sms_passage not like", value, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageIn(List<String> values) {
            addCriterion("sms_passage in", values, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageNotIn(List<String> values) {
            addCriterion("sms_passage not in", values, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageBetween(String value1, String value2) {
            addCriterion("sms_passage between", value1, value2, "smsPassage");
            return (Criteria) this;
        }

        public Criteria andSmsPassageNotBetween(String value1, String value2) {
            addCriterion("sms_passage not between", value1, value2, "smsPassage");
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

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andFatigueIsNull() {
            addCriterion("fatigue is null");
            return (Criteria) this;
        }

        public Criteria andFatigueIsNotNull() {
            addCriterion("fatigue is not null");
            return (Criteria) this;
        }

        public Criteria andFatigueEqualTo(String value) {
            addCriterion("fatigue =", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueNotEqualTo(String value) {
            addCriterion("fatigue <>", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueGreaterThan(String value) {
            addCriterion("fatigue >", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueGreaterThanOrEqualTo(String value) {
            addCriterion("fatigue >=", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueLessThan(String value) {
            addCriterion("fatigue <", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueLessThanOrEqualTo(String value) {
            addCriterion("fatigue <=", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueLike(String value) {
            addCriterion("fatigue like", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueNotLike(String value) {
            addCriterion("fatigue not like", value, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueIn(List<String> values) {
            addCriterion("fatigue in", values, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueNotIn(List<String> values) {
            addCriterion("fatigue not in", values, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueBetween(String value1, String value2) {
            addCriterion("fatigue between", value1, value2, "fatigue");
            return (Criteria) this;
        }

        public Criteria andFatigueNotBetween(String value1, String value2) {
            addCriterion("fatigue not between", value1, value2, "fatigue");
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