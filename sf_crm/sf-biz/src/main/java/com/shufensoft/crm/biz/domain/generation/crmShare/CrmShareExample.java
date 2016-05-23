package com.shufensoft.crm.biz.domain.generation.crmShare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrmShareExample {
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

    public CrmShareExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void addGmtCreatedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("gmt_created");
    }

    public void addMaxGmtCreatedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(gmt_created)");
    }

    public void addMinGmtCreatedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(gmt_created)");
    }

    public void addAvgGmtCreatedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(gmt_created)");
    }

    public void addGmtModifiedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("gmt_modified");
    }

    public void addMaxGmtModifiedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(gmt_modified)");
    }

    public void addMinGmtModifiedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(gmt_modified)");
    }

    public void addAvgGmtModifiedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(gmt_modified)");
    }

    public void addCreatedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("created_by");
    }

    public void addMaxCreatedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(created_by)");
    }

    public void addMinCreatedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(created_by)");
    }

    public void addAvgCreatedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(created_by)");
    }

    public void addModifiedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("modified_by");
    }

    public void addMaxModifiedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(modified_by)");
    }

    public void addMinModifiedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(modified_by)");
    }

    public void addAvgModifiedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(modified_by)");
    }

    public void addIsDeletedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("is_deleted");
    }

    public void addMaxIsDeletedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(is_deleted)");
    }

    public void addMinIsDeletedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(is_deleted)");
    }

    public void addAvgIsDeletedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(is_deleted)");
    }

    public void addCrmShareIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("crm_share_id");
    }

    public void addMaxCrmShareIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(crm_share_id)");
    }

    public void addMinCrmShareIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(crm_share_id)");
    }

    public void addAvgCrmShareIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(crm_share_id)");
    }

    public void addSellerIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("seller_id");
    }

    public void addMaxSellerIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(seller_id)");
    }

    public void addMinSellerIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(seller_id)");
    }

    public void addAvgSellerIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(seller_id)");
    }

    public void addSponsorUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("sponsor_user_id");
    }

    public void addMaxSponsorUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(sponsor_user_id)");
    }

    public void addMinSponsorUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(sponsor_user_id)");
    }

    public void addAvgSponsorUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(sponsor_user_id)");
    }

    public void addReceiveUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("receive_user_id");
    }

    public void addMaxReceiveUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(receive_user_id)");
    }

    public void addMinReceiveUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(receive_user_id)");
    }

    public void addAvgReceiveUserIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(receive_user_id)");
    }

    public void addReceiveTimeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("receive_time");
    }

    public void addMaxReceiveTimeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(receive_time)");
    }

    public void addMinReceiveTimeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(receive_time)");
    }

    public void addAvgReceiveTimeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(receive_time)");
    }

    public void addTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("type");
    }

    public void addMaxTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(type)");
    }

    public void addMinTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(type)");
    }

    public void addAvgTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(type)");
    }

    public void addAmountQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("amount");
    }

    public void addMaxAmountQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(amount)");
    }

    public void addMinAmountQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(amount)");
    }

    public void addAvgAmountQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(amount)");
    }

    public void addBizIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("biz_id");
    }

    public void addMaxBizIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(biz_id)");
    }

    public void addMinBizIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(biz_id)");
    }

    public void addAvgBizIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(biz_id)");
    }

    public void addBizNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("biz_name");
    }

    public void addMaxBizNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(biz_name)");
    }

    public void addMinBizNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(biz_name)");
    }

    public void addAvgBizNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(biz_name)");
    }

    public void addShareBizTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("share_biz_type");
    }

    public void addMaxShareBizTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max(share_biz_type)");
    }

    public void addMinShareBizTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min(share_biz_type)");
    }

    public void addAvgShareBizTypeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("avg(share_biz_type)");
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

        public Criteria andCrmShareIdIsNull() {
            addCriterion("crm_share_id is null");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdIsNotNull() {
            addCriterion("crm_share_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdEqualTo(Long value) {
            addCriterion("crm_share_id =", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdNotEqualTo(Long value) {
            addCriterion("crm_share_id <>", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdGreaterThan(Long value) {
            addCriterion("crm_share_id >", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("crm_share_id >=", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdLessThan(Long value) {
            addCriterion("crm_share_id <", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdLessThanOrEqualTo(Long value) {
            addCriterion("crm_share_id <=", value, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdIn(List<Long> values) {
            addCriterion("crm_share_id in", values, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdNotIn(List<Long> values) {
            addCriterion("crm_share_id not in", values, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdBetween(Long value1, Long value2) {
            addCriterion("crm_share_id between", value1, value2, "crmShareId");
            return (Criteria) this;
        }

        public Criteria andCrmShareIdNotBetween(Long value1, Long value2) {
            addCriterion("crm_share_id not between", value1, value2, "crmShareId");
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

        public Criteria andSponsorUserIdIsNull() {
            addCriterion("sponsor_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdIsNotNull() {
            addCriterion("sponsor_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdEqualTo(Long value) {
            addCriterion("sponsor_user_id =", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdNotEqualTo(Long value) {
            addCriterion("sponsor_user_id <>", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdGreaterThan(Long value) {
            addCriterion("sponsor_user_id >", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sponsor_user_id >=", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdLessThan(Long value) {
            addCriterion("sponsor_user_id <", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdLessThanOrEqualTo(Long value) {
            addCriterion("sponsor_user_id <=", value, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdIn(List<Long> values) {
            addCriterion("sponsor_user_id in", values, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdNotIn(List<Long> values) {
            addCriterion("sponsor_user_id not in", values, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdBetween(Long value1, Long value2) {
            addCriterion("sponsor_user_id between", value1, value2, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorUserIdNotBetween(Long value1, Long value2) {
            addCriterion("sponsor_user_id not between", value1, value2, "sponsorUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNull() {
            addCriterion("receive_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNotNull() {
            addCriterion("receive_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdEqualTo(Long value) {
            addCriterion("receive_user_id =", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotEqualTo(Long value) {
            addCriterion("receive_user_id <>", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThan(Long value) {
            addCriterion("receive_user_id >", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_user_id >=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThan(Long value) {
            addCriterion("receive_user_id <", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThanOrEqualTo(Long value) {
            addCriterion("receive_user_id <=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIn(List<Long> values) {
            addCriterion("receive_user_id in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotIn(List<Long> values) {
            addCriterion("receive_user_id not in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdBetween(Long value1, Long value2) {
            addCriterion("receive_user_id between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotBetween(Long value1, Long value2) {
            addCriterion("receive_user_id not between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
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

        public Criteria andBizIdIsNull() {
            addCriterion("biz_id is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("biz_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(Long value) {
            addCriterion("biz_id =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(Long value) {
            addCriterion("biz_id <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(Long value) {
            addCriterion("biz_id >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("biz_id >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(Long value) {
            addCriterion("biz_id <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(Long value) {
            addCriterion("biz_id <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<Long> values) {
            addCriterion("biz_id in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<Long> values) {
            addCriterion("biz_id not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(Long value1, Long value2) {
            addCriterion("biz_id between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(Long value1, Long value2) {
            addCriterion("biz_id not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizNameIsNull() {
            addCriterion("biz_name is null");
            return (Criteria) this;
        }

        public Criteria andBizNameIsNotNull() {
            addCriterion("biz_name is not null");
            return (Criteria) this;
        }

        public Criteria andBizNameEqualTo(String value) {
            addCriterion("biz_name =", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotEqualTo(String value) {
            addCriterion("biz_name <>", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameGreaterThan(String value) {
            addCriterion("biz_name >", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameGreaterThanOrEqualTo(String value) {
            addCriterion("biz_name >=", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLessThan(String value) {
            addCriterion("biz_name <", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLessThanOrEqualTo(String value) {
            addCriterion("biz_name <=", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLike(String value) {
            addCriterion("biz_name like", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotLike(String value) {
            addCriterion("biz_name not like", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameIn(List<String> values) {
            addCriterion("biz_name in", values, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotIn(List<String> values) {
            addCriterion("biz_name not in", values, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameBetween(String value1, String value2) {
            addCriterion("biz_name between", value1, value2, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotBetween(String value1, String value2) {
            addCriterion("biz_name not between", value1, value2, "bizName");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeIsNull() {
            addCriterion("share_biz_type is null");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeIsNotNull() {
            addCriterion("share_biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeEqualTo(String value) {
            addCriterion("share_biz_type =", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeNotEqualTo(String value) {
            addCriterion("share_biz_type <>", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeGreaterThan(String value) {
            addCriterion("share_biz_type >", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("share_biz_type >=", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeLessThan(String value) {
            addCriterion("share_biz_type <", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeLessThanOrEqualTo(String value) {
            addCriterion("share_biz_type <=", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeLike(String value) {
            addCriterion("share_biz_type like", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeNotLike(String value) {
            addCriterion("share_biz_type not like", value, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeIn(List<String> values) {
            addCriterion("share_biz_type in", values, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeNotIn(List<String> values) {
            addCriterion("share_biz_type not in", values, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeBetween(String value1, String value2) {
            addCriterion("share_biz_type between", value1, value2, "shareBizType");
            return (Criteria) this;
        }

        public Criteria andShareBizTypeNotBetween(String value1, String value2) {
            addCriterion("share_biz_type not between", value1, value2, "shareBizType");
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