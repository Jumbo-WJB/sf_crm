package com.shufensoft.crm.biz.domain.generation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInteractionStatisticExample {
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

    public UserInteractionStatisticExample() {
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

    public void addBizIdQueryColumn() {
        this.queryColumns.add("biz_id");
    }

    public void addMaxBizIdQueryColumn() {
        this.queryColumns.add("max(biz_id) max_biz_id");
    }

    public void addMinBizIdQueryColumn() {
        this.queryColumns.add("min(biz_id) min_biz_id");
    }

    public void addAvgBizIdQueryColumn() {
        this.queryColumns.add(" avg(biz_id) avg_biz_id");
    }

    public void addCountBizIdQueryColumn() {
        this.queryColumns.add(" count(biz_id) count_biz_id");
    }

    public void addSumBizIdQueryColumn() {
        this.queryColumns.add(" sum(biz_id) sum_biz_id");
    }

    public void addDimTypeQueryColumn() {
        this.queryColumns.add("dim_type");
    }

    public void addMaxDimTypeQueryColumn() {
        this.queryColumns.add("max(dim_type) max_dim_type");
    }

    public void addMinDimTypeQueryColumn() {
        this.queryColumns.add("min(dim_type) min_dim_type");
    }

    public void addAvgDimTypeQueryColumn() {
        this.queryColumns.add(" avg(dim_type) avg_dim_type");
    }

    public void addCountDimTypeQueryColumn() {
        this.queryColumns.add(" count(dim_type) count_dim_type");
    }

    public void addSumDimTypeQueryColumn() {
        this.queryColumns.add(" sum(dim_type) sum_dim_type");
    }

    public void addFirstInteractionTimeQueryColumn() {
        this.queryColumns.add("first_interaction_time");
    }

    public void addMaxFirstInteractionTimeQueryColumn() {
        this.queryColumns.add("max(first_interaction_time) max_first_interaction_time");
    }

    public void addMinFirstInteractionTimeQueryColumn() {
        this.queryColumns.add("min(first_interaction_time) min_first_interaction_time");
    }

    public void addAvgFirstInteractionTimeQueryColumn() {
        this.queryColumns.add(" avg(first_interaction_time) avg_first_interaction_time");
    }

    public void addCountFirstInteractionTimeQueryColumn() {
        this.queryColumns.add(" count(first_interaction_time) count_first_interaction_time");
    }

    public void addSumFirstInteractionTimeQueryColumn() {
        this.queryColumns.add(" sum(first_interaction_time) sum_first_interaction_time");
    }

    public void addLastInteractionTimeQueryColumn() {
        this.queryColumns.add("last_interaction_time");
    }

    public void addMaxLastInteractionTimeQueryColumn() {
        this.queryColumns.add("max(last_interaction_time) max_last_interaction_time");
    }

    public void addMinLastInteractionTimeQueryColumn() {
        this.queryColumns.add("min(last_interaction_time) min_last_interaction_time");
    }

    public void addAvgLastInteractionTimeQueryColumn() {
        this.queryColumns.add(" avg(last_interaction_time) avg_last_interaction_time");
    }

    public void addCountLastInteractionTimeQueryColumn() {
        this.queryColumns.add(" count(last_interaction_time) count_last_interaction_time");
    }

    public void addSumLastInteractionTimeQueryColumn() {
        this.queryColumns.add(" sum(last_interaction_time) sum_last_interaction_time");
    }

    public void addInteractionTypeQueryColumn() {
        this.queryColumns.add("interaction_type");
    }

    public void addMaxInteractionTypeQueryColumn() {
        this.queryColumns.add("max(interaction_type) max_interaction_type");
    }

    public void addMinInteractionTypeQueryColumn() {
        this.queryColumns.add("min(interaction_type) min_interaction_type");
    }

    public void addAvgInteractionTypeQueryColumn() {
        this.queryColumns.add(" avg(interaction_type) avg_interaction_type");
    }

    public void addCountInteractionTypeQueryColumn() {
        this.queryColumns.add(" count(interaction_type) count_interaction_type");
    }

    public void addSumInteractionTypeQueryColumn() {
        this.queryColumns.add(" sum(interaction_type) sum_interaction_type");
    }

    public void addInteractionEntryQueryColumn() {
        this.queryColumns.add("interaction_entry");
    }

    public void addMaxInteractionEntryQueryColumn() {
        this.queryColumns.add("max(interaction_entry) max_interaction_entry");
    }

    public void addMinInteractionEntryQueryColumn() {
        this.queryColumns.add("min(interaction_entry) min_interaction_entry");
    }

    public void addAvgInteractionEntryQueryColumn() {
        this.queryColumns.add(" avg(interaction_entry) avg_interaction_entry");
    }

    public void addCountInteractionEntryQueryColumn() {
        this.queryColumns.add(" count(interaction_entry) count_interaction_entry");
    }

    public void addSumInteractionEntryQueryColumn() {
        this.queryColumns.add(" sum(interaction_entry) sum_interaction_entry");
    }

    public void addInteractionStatQueryColumn() {
        this.queryColumns.add("interaction_stat");
    }

    public void addMaxInteractionStatQueryColumn() {
        this.queryColumns.add("max(interaction_stat) max_interaction_stat");
    }

    public void addMinInteractionStatQueryColumn() {
        this.queryColumns.add("min(interaction_stat) min_interaction_stat");
    }

    public void addAvgInteractionStatQueryColumn() {
        this.queryColumns.add(" avg(interaction_stat) avg_interaction_stat");
    }

    public void addCountInteractionStatQueryColumn() {
        this.queryColumns.add(" count(interaction_stat) count_interaction_stat");
    }

    public void addSumInteractionStatQueryColumn() {
        this.queryColumns.add(" sum(interaction_stat) sum_interaction_stat");
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

        public Criteria andDimTypeIsNull() {
            addCriterion("dim_type is null");
            return (Criteria) this;
        }

        public Criteria andDimTypeIsNotNull() {
            addCriterion("dim_type is not null");
            return (Criteria) this;
        }

        public Criteria andDimTypeEqualTo(String value) {
            addCriterion("dim_type =", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeNotEqualTo(String value) {
            addCriterion("dim_type <>", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeGreaterThan(String value) {
            addCriterion("dim_type >", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dim_type >=", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeLessThan(String value) {
            addCriterion("dim_type <", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeLessThanOrEqualTo(String value) {
            addCriterion("dim_type <=", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeLike(String value) {
            addCriterion("dim_type like", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeNotLike(String value) {
            addCriterion("dim_type not like", value, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeIn(List<String> values) {
            addCriterion("dim_type in", values, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeNotIn(List<String> values) {
            addCriterion("dim_type not in", values, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeBetween(String value1, String value2) {
            addCriterion("dim_type between", value1, value2, "dimType");
            return (Criteria) this;
        }

        public Criteria andDimTypeNotBetween(String value1, String value2) {
            addCriterion("dim_type not between", value1, value2, "dimType");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeIsNull() {
            addCriterion("first_interaction_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeIsNotNull() {
            addCriterion("first_interaction_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeEqualTo(Date value) {
            addCriterion("first_interaction_time =", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeNotEqualTo(Date value) {
            addCriterion("first_interaction_time <>", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeGreaterThan(Date value) {
            addCriterion("first_interaction_time >", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("first_interaction_time >=", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeLessThan(Date value) {
            addCriterion("first_interaction_time <", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeLessThanOrEqualTo(Date value) {
            addCriterion("first_interaction_time <=", value, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeIn(List<Date> values) {
            addCriterion("first_interaction_time in", values, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeNotIn(List<Date> values) {
            addCriterion("first_interaction_time not in", values, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeBetween(Date value1, Date value2) {
            addCriterion("first_interaction_time between", value1, value2, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andFirstInteractionTimeNotBetween(Date value1, Date value2) {
            addCriterion("first_interaction_time not between", value1, value2, "firstInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeIsNull() {
            addCriterion("last_interaction_time is null");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeIsNotNull() {
            addCriterion("last_interaction_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeEqualTo(Date value) {
            addCriterion("last_interaction_time =", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeNotEqualTo(Date value) {
            addCriterion("last_interaction_time <>", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeGreaterThan(Date value) {
            addCriterion("last_interaction_time >", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_interaction_time >=", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeLessThan(Date value) {
            addCriterion("last_interaction_time <", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_interaction_time <=", value, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeIn(List<Date> values) {
            addCriterion("last_interaction_time in", values, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeNotIn(List<Date> values) {
            addCriterion("last_interaction_time not in", values, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeBetween(Date value1, Date value2) {
            addCriterion("last_interaction_time between", value1, value2, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andLastInteractionTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_interaction_time not between", value1, value2, "lastInteractionTime");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeIsNull() {
            addCriterion("interaction_type is null");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeIsNotNull() {
            addCriterion("interaction_type is not null");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeEqualTo(String value) {
            addCriterion("interaction_type =", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeNotEqualTo(String value) {
            addCriterion("interaction_type <>", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeGreaterThan(String value) {
            addCriterion("interaction_type >", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("interaction_type >=", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeLessThan(String value) {
            addCriterion("interaction_type <", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeLessThanOrEqualTo(String value) {
            addCriterion("interaction_type <=", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeLike(String value) {
            addCriterion("interaction_type like", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeNotLike(String value) {
            addCriterion("interaction_type not like", value, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeIn(List<String> values) {
            addCriterion("interaction_type in", values, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeNotIn(List<String> values) {
            addCriterion("interaction_type not in", values, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeBetween(String value1, String value2) {
            addCriterion("interaction_type between", value1, value2, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionTypeNotBetween(String value1, String value2) {
            addCriterion("interaction_type not between", value1, value2, "interactionType");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryIsNull() {
            addCriterion("interaction_entry is null");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryIsNotNull() {
            addCriterion("interaction_entry is not null");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryEqualTo(String value) {
            addCriterion("interaction_entry =", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryNotEqualTo(String value) {
            addCriterion("interaction_entry <>", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryGreaterThan(String value) {
            addCriterion("interaction_entry >", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryGreaterThanOrEqualTo(String value) {
            addCriterion("interaction_entry >=", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryLessThan(String value) {
            addCriterion("interaction_entry <", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryLessThanOrEqualTo(String value) {
            addCriterion("interaction_entry <=", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryLike(String value) {
            addCriterion("interaction_entry like", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryNotLike(String value) {
            addCriterion("interaction_entry not like", value, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryIn(List<String> values) {
            addCriterion("interaction_entry in", values, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryNotIn(List<String> values) {
            addCriterion("interaction_entry not in", values, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryBetween(String value1, String value2) {
            addCriterion("interaction_entry between", value1, value2, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionEntryNotBetween(String value1, String value2) {
            addCriterion("interaction_entry not between", value1, value2, "interactionEntry");
            return (Criteria) this;
        }

        public Criteria andInteractionStatIsNull() {
            addCriterion("interaction_stat is null");
            return (Criteria) this;
        }

        public Criteria andInteractionStatIsNotNull() {
            addCriterion("interaction_stat is not null");
            return (Criteria) this;
        }

        public Criteria andInteractionStatEqualTo(String value) {
            addCriterion("interaction_stat =", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatNotEqualTo(String value) {
            addCriterion("interaction_stat <>", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatGreaterThan(String value) {
            addCriterion("interaction_stat >", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatGreaterThanOrEqualTo(String value) {
            addCriterion("interaction_stat >=", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatLessThan(String value) {
            addCriterion("interaction_stat <", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatLessThanOrEqualTo(String value) {
            addCriterion("interaction_stat <=", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatLike(String value) {
            addCriterion("interaction_stat like", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatNotLike(String value) {
            addCriterion("interaction_stat not like", value, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatIn(List<String> values) {
            addCriterion("interaction_stat in", values, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatNotIn(List<String> values) {
            addCriterion("interaction_stat not in", values, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatBetween(String value1, String value2) {
            addCriterion("interaction_stat between", value1, value2, "interactionStat");
            return (Criteria) this;
        }

        public Criteria andInteractionStatNotBetween(String value1, String value2) {
            addCriterion("interaction_stat not between", value1, value2, "interactionStat");
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