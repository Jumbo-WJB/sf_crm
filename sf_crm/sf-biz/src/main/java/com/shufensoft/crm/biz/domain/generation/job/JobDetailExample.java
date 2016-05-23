package com.shufensoft.crm.biz.domain.generation.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobDetailExample {
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

    public JobDetailExample() {
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

    public void addShopIdQueryColumn() {
        this.queryColumns.add("shop_id");
    }

    public void addMaxShopIdQueryColumn() {
        this.queryColumns.add("max(shop_id) max_shop_id");
    }

    public void addMinShopIdQueryColumn() {
        this.queryColumns.add("min(shop_id) min_shop_id");
    }

    public void addAvgShopIdQueryColumn() {
        this.queryColumns.add(" avg(shop_id) avg_shop_id");
    }

    public void addCountShopIdQueryColumn() {
        this.queryColumns.add(" count(shop_id) count_shop_id");
    }

    public void addSumShopIdQueryColumn() {
        this.queryColumns.add(" sum(shop_id) sum_shop_id");
    }

    public void addJobNameQueryColumn() {
        this.queryColumns.add("job_name");
    }

    public void addMaxJobNameQueryColumn() {
        this.queryColumns.add("max(job_name) max_job_name");
    }

    public void addMinJobNameQueryColumn() {
        this.queryColumns.add("min(job_name) min_job_name");
    }

    public void addAvgJobNameQueryColumn() {
        this.queryColumns.add(" avg(job_name) avg_job_name");
    }

    public void addCountJobNameQueryColumn() {
        this.queryColumns.add(" count(job_name) count_job_name");
    }

    public void addSumJobNameQueryColumn() {
        this.queryColumns.add(" sum(job_name) sum_job_name");
    }

    public void addJobDemoQueryColumn() {
        this.queryColumns.add("job_demo");
    }

    public void addMaxJobDemoQueryColumn() {
        this.queryColumns.add("max(job_demo) max_job_demo");
    }

    public void addMinJobDemoQueryColumn() {
        this.queryColumns.add("min(job_demo) min_job_demo");
    }

    public void addAvgJobDemoQueryColumn() {
        this.queryColumns.add(" avg(job_demo) avg_job_demo");
    }

    public void addCountJobDemoQueryColumn() {
        this.queryColumns.add(" count(job_demo) count_job_demo");
    }

    public void addSumJobDemoQueryColumn() {
        this.queryColumns.add(" sum(job_demo) sum_job_demo");
    }

    public void addEndSyncDataTimeQueryColumn() {
        this.queryColumns.add("end_sync_data_time");
    }

    public void addMaxEndSyncDataTimeQueryColumn() {
        this.queryColumns.add("max(end_sync_data_time) max_end_sync_data_time");
    }

    public void addMinEndSyncDataTimeQueryColumn() {
        this.queryColumns.add("min(end_sync_data_time) min_end_sync_data_time");
    }

    public void addAvgEndSyncDataTimeQueryColumn() {
        this.queryColumns.add(" avg(end_sync_data_time) avg_end_sync_data_time");
    }

    public void addCountEndSyncDataTimeQueryColumn() {
        this.queryColumns.add(" count(end_sync_data_time) count_end_sync_data_time");
    }

    public void addSumEndSyncDataTimeQueryColumn() {
        this.queryColumns.add(" sum(end_sync_data_time) sum_end_sync_data_time");
    }

    public void addSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add("sync_data_interval_time");
    }

    public void addMaxSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add("max(sync_data_interval_time) max_sync_data_interval_time");
    }

    public void addMinSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add("min(sync_data_interval_time) min_sync_data_interval_time");
    }

    public void addAvgSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add(" avg(sync_data_interval_time) avg_sync_data_interval_time");
    }

    public void addCountSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add(" count(sync_data_interval_time) count_sync_data_interval_time");
    }

    public void addSumSyncDataIntervalTimeQueryColumn() {
        this.queryColumns.add(" sum(sync_data_interval_time) sum_sync_data_interval_time");
    }

    public void addSyncFlagIdQueryColumn() {
        this.queryColumns.add("sync_flag_id");
    }

    public void addMaxSyncFlagIdQueryColumn() {
        this.queryColumns.add("max(sync_flag_id) max_sync_flag_id");
    }

    public void addMinSyncFlagIdQueryColumn() {
        this.queryColumns.add("min(sync_flag_id) min_sync_flag_id");
    }

    public void addAvgSyncFlagIdQueryColumn() {
        this.queryColumns.add(" avg(sync_flag_id) avg_sync_flag_id");
    }

    public void addCountSyncFlagIdQueryColumn() {
        this.queryColumns.add(" count(sync_flag_id) count_sync_flag_id");
    }

    public void addSumSyncFlagIdQueryColumn() {
        this.queryColumns.add(" sum(sync_flag_id) sum_sync_flag_id");
    }

    public void addEndTimeQueryColumn() {
        this.queryColumns.add("end_time");
    }

    public void addMaxEndTimeQueryColumn() {
        this.queryColumns.add("max(end_time) max_end_time");
    }

    public void addMinEndTimeQueryColumn() {
        this.queryColumns.add("min(end_time) min_end_time");
    }

    public void addAvgEndTimeQueryColumn() {
        this.queryColumns.add(" avg(end_time) avg_end_time");
    }

    public void addCountEndTimeQueryColumn() {
        this.queryColumns.add(" count(end_time) count_end_time");
    }

    public void addSumEndTimeQueryColumn() {
        this.queryColumns.add(" sum(end_time) sum_end_time");
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobDemoIsNull() {
            addCriterion("job_demo is null");
            return (Criteria) this;
        }

        public Criteria andJobDemoIsNotNull() {
            addCriterion("job_demo is not null");
            return (Criteria) this;
        }

        public Criteria andJobDemoEqualTo(String value) {
            addCriterion("job_demo =", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoNotEqualTo(String value) {
            addCriterion("job_demo <>", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoGreaterThan(String value) {
            addCriterion("job_demo >", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoGreaterThanOrEqualTo(String value) {
            addCriterion("job_demo >=", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoLessThan(String value) {
            addCriterion("job_demo <", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoLessThanOrEqualTo(String value) {
            addCriterion("job_demo <=", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoLike(String value) {
            addCriterion("job_demo like", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoNotLike(String value) {
            addCriterion("job_demo not like", value, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoIn(List<String> values) {
            addCriterion("job_demo in", values, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoNotIn(List<String> values) {
            addCriterion("job_demo not in", values, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoBetween(String value1, String value2) {
            addCriterion("job_demo between", value1, value2, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andJobDemoNotBetween(String value1, String value2) {
            addCriterion("job_demo not between", value1, value2, "jobDemo");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeIsNull() {
            addCriterion("end_sync_data_time is null");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeIsNotNull() {
            addCriterion("end_sync_data_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeEqualTo(Date value) {
            addCriterion("end_sync_data_time =", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeNotEqualTo(Date value) {
            addCriterion("end_sync_data_time <>", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeGreaterThan(Date value) {
            addCriterion("end_sync_data_time >", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_sync_data_time >=", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeLessThan(Date value) {
            addCriterion("end_sync_data_time <", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_sync_data_time <=", value, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeIn(List<Date> values) {
            addCriterion("end_sync_data_time in", values, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeNotIn(List<Date> values) {
            addCriterion("end_sync_data_time not in", values, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeBetween(Date value1, Date value2) {
            addCriterion("end_sync_data_time between", value1, value2, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andEndSyncDataTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_sync_data_time not between", value1, value2, "endSyncDataTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeIsNull() {
            addCriterion("sync_data_interval_time is null");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeIsNotNull() {
            addCriterion("sync_data_interval_time is not null");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeEqualTo(Integer value) {
            addCriterion("sync_data_interval_time =", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeNotEqualTo(Integer value) {
            addCriterion("sync_data_interval_time <>", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeGreaterThan(Integer value) {
            addCriterion("sync_data_interval_time >", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sync_data_interval_time >=", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeLessThan(Integer value) {
            addCriterion("sync_data_interval_time <", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sync_data_interval_time <=", value, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeIn(List<Integer> values) {
            addCriterion("sync_data_interval_time in", values, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeNotIn(List<Integer> values) {
            addCriterion("sync_data_interval_time not in", values, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeBetween(Integer value1, Integer value2) {
            addCriterion("sync_data_interval_time between", value1, value2, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncDataIntervalTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sync_data_interval_time not between", value1, value2, "syncDataIntervalTime");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdIsNull() {
            addCriterion("sync_flag_id is null");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdIsNotNull() {
            addCriterion("sync_flag_id is not null");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdEqualTo(String value) {
            addCriterion("sync_flag_id =", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdNotEqualTo(String value) {
            addCriterion("sync_flag_id <>", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdGreaterThan(String value) {
            addCriterion("sync_flag_id >", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdGreaterThanOrEqualTo(String value) {
            addCriterion("sync_flag_id >=", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdLessThan(String value) {
            addCriterion("sync_flag_id <", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdLessThanOrEqualTo(String value) {
            addCriterion("sync_flag_id <=", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdLike(String value) {
            addCriterion("sync_flag_id like", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdNotLike(String value) {
            addCriterion("sync_flag_id not like", value, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdIn(List<String> values) {
            addCriterion("sync_flag_id in", values, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdNotIn(List<String> values) {
            addCriterion("sync_flag_id not in", values, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdBetween(String value1, String value2) {
            addCriterion("sync_flag_id between", value1, value2, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andSyncFlagIdNotBetween(String value1, String value2) {
            addCriterion("sync_flag_id not between", value1, value2, "syncFlagId");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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