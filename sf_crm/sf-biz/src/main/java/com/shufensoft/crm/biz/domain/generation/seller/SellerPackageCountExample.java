package com.shufensoft.crm.biz.domain.generation.seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerPackageCountExample {
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

    public SellerPackageCountExample() {
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

    public void addSellerPackageRemainQueryColumn() {
        this.queryColumns.add("seller_package_remain");
    }

    public void addMaxSellerPackageRemainQueryColumn() {
        this.queryColumns.add("max(seller_package_remain) max_seller_package_remain");
    }

    public void addMinSellerPackageRemainQueryColumn() {
        this.queryColumns.add("min(seller_package_remain) min_seller_package_remain");
    }

    public void addAvgSellerPackageRemainQueryColumn() {
        this.queryColumns.add(" avg(seller_package_remain) avg_seller_package_remain");
    }

    public void addCountSellerPackageRemainQueryColumn() {
        this.queryColumns.add(" count(seller_package_remain) count_seller_package_remain");
    }

    public void addSumSellerPackageRemainQueryColumn() {
        this.queryColumns.add(" sum(seller_package_remain) sum_seller_package_remain");
    }

    public void addSellerPackageTotalQueryColumn() {
        this.queryColumns.add("seller_package_total");
    }

    public void addMaxSellerPackageTotalQueryColumn() {
        this.queryColumns.add("max(seller_package_total) max_seller_package_total");
    }

    public void addMinSellerPackageTotalQueryColumn() {
        this.queryColumns.add("min(seller_package_total) min_seller_package_total");
    }

    public void addAvgSellerPackageTotalQueryColumn() {
        this.queryColumns.add(" avg(seller_package_total) avg_seller_package_total");
    }

    public void addCountSellerPackageTotalQueryColumn() {
        this.queryColumns.add(" count(seller_package_total) count_seller_package_total");
    }

    public void addSumSellerPackageTotalQueryColumn() {
        this.queryColumns.add(" sum(seller_package_total) sum_seller_package_total");
    }

    public void addSellerPackageUsedQueryColumn() {
        this.queryColumns.add("seller_package_used");
    }

    public void addMaxSellerPackageUsedQueryColumn() {
        this.queryColumns.add("max(seller_package_used) max_seller_package_used");
    }

    public void addMinSellerPackageUsedQueryColumn() {
        this.queryColumns.add("min(seller_package_used) min_seller_package_used");
    }

    public void addAvgSellerPackageUsedQueryColumn() {
        this.queryColumns.add(" avg(seller_package_used) avg_seller_package_used");
    }

    public void addCountSellerPackageUsedQueryColumn() {
        this.queryColumns.add(" count(seller_package_used) count_seller_package_used");
    }

    public void addSumSellerPackageUsedQueryColumn() {
        this.queryColumns.add(" sum(seller_package_used) sum_seller_package_used");
    }

    public void addSellerPackageExpiredQueryColumn() {
        this.queryColumns.add("seller_package_expired");
    }

    public void addMaxSellerPackageExpiredQueryColumn() {
        this.queryColumns.add("max(seller_package_expired) max_seller_package_expired");
    }

    public void addMinSellerPackageExpiredQueryColumn() {
        this.queryColumns.add("min(seller_package_expired) min_seller_package_expired");
    }

    public void addAvgSellerPackageExpiredQueryColumn() {
        this.queryColumns.add(" avg(seller_package_expired) avg_seller_package_expired");
    }

    public void addCountSellerPackageExpiredQueryColumn() {
        this.queryColumns.add(" count(seller_package_expired) count_seller_package_expired");
    }

    public void addSumSellerPackageExpiredQueryColumn() {
        this.queryColumns.add(" sum(seller_package_expired) sum_seller_package_expired");
    }

    public void addSellerPackageVersionQueryColumn() {
        this.queryColumns.add("seller_package_version");
    }

    public void addMaxSellerPackageVersionQueryColumn() {
        this.queryColumns.add("max(seller_package_version) max_seller_package_version");
    }

    public void addMinSellerPackageVersionQueryColumn() {
        this.queryColumns.add("min(seller_package_version) min_seller_package_version");
    }

    public void addAvgSellerPackageVersionQueryColumn() {
        this.queryColumns.add(" avg(seller_package_version) avg_seller_package_version");
    }

    public void addCountSellerPackageVersionQueryColumn() {
        this.queryColumns.add(" count(seller_package_version) count_seller_package_version");
    }

    public void addSumSellerPackageVersionQueryColumn() {
        this.queryColumns.add(" sum(seller_package_version) sum_seller_package_version");
    }

    public void addSellerPackageTypeQueryColumn() {
        this.queryColumns.add("seller_package_type");
    }

    public void addMaxSellerPackageTypeQueryColumn() {
        this.queryColumns.add("max(seller_package_type) max_seller_package_type");
    }

    public void addMinSellerPackageTypeQueryColumn() {
        this.queryColumns.add("min(seller_package_type) min_seller_package_type");
    }

    public void addAvgSellerPackageTypeQueryColumn() {
        this.queryColumns.add(" avg(seller_package_type) avg_seller_package_type");
    }

    public void addCountSellerPackageTypeQueryColumn() {
        this.queryColumns.add(" count(seller_package_type) count_seller_package_type");
    }

    public void addSumSellerPackageTypeQueryColumn() {
        this.queryColumns.add(" sum(seller_package_type) sum_seller_package_type");
    }

    public void addSendTimesQueryColumn() {
        this.queryColumns.add("send_times");
    }

    public void addMaxSendTimesQueryColumn() {
        this.queryColumns.add("max(send_times) max_send_times");
    }

    public void addMinSendTimesQueryColumn() {
        this.queryColumns.add("min(send_times) min_send_times");
    }

    public void addAvgSendTimesQueryColumn() {
        this.queryColumns.add(" avg(send_times) avg_send_times");
    }

    public void addCountSendTimesQueryColumn() {
        this.queryColumns.add(" count(send_times) count_send_times");
    }

    public void addSumSendTimesQueryColumn() {
        this.queryColumns.add(" sum(send_times) sum_send_times");
    }

    public void addSendSucRateQueryColumn() {
        this.queryColumns.add("send_suc_rate");
    }

    public void addMaxSendSucRateQueryColumn() {
        this.queryColumns.add("max(send_suc_rate) max_send_suc_rate");
    }

    public void addMinSendSucRateQueryColumn() {
        this.queryColumns.add("min(send_suc_rate) min_send_suc_rate");
    }

    public void addAvgSendSucRateQueryColumn() {
        this.queryColumns.add(" avg(send_suc_rate) avg_send_suc_rate");
    }

    public void addCountSendSucRateQueryColumn() {
        this.queryColumns.add(" count(send_suc_rate) count_send_suc_rate");
    }

    public void addSumSendSucRateQueryColumn() {
        this.queryColumns.add(" sum(send_suc_rate) sum_send_suc_rate");
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

        public Criteria andSellerPackageRemainIsNull() {
            addCriterion("seller_package_remain is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainIsNotNull() {
            addCriterion("seller_package_remain is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainEqualTo(Long value) {
            addCriterion("seller_package_remain =", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainNotEqualTo(Long value) {
            addCriterion("seller_package_remain <>", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainGreaterThan(Long value) {
            addCriterion("seller_package_remain >", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_package_remain >=", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainLessThan(Long value) {
            addCriterion("seller_package_remain <", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainLessThanOrEqualTo(Long value) {
            addCriterion("seller_package_remain <=", value, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainIn(List<Long> values) {
            addCriterion("seller_package_remain in", values, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainNotIn(List<Long> values) {
            addCriterion("seller_package_remain not in", values, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainBetween(Long value1, Long value2) {
            addCriterion("seller_package_remain between", value1, value2, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageRemainNotBetween(Long value1, Long value2) {
            addCriterion("seller_package_remain not between", value1, value2, "sellerPackageRemain");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalIsNull() {
            addCriterion("seller_package_total is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalIsNotNull() {
            addCriterion("seller_package_total is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalEqualTo(Long value) {
            addCriterion("seller_package_total =", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalNotEqualTo(Long value) {
            addCriterion("seller_package_total <>", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalGreaterThan(Long value) {
            addCriterion("seller_package_total >", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_package_total >=", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalLessThan(Long value) {
            addCriterion("seller_package_total <", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalLessThanOrEqualTo(Long value) {
            addCriterion("seller_package_total <=", value, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalIn(List<Long> values) {
            addCriterion("seller_package_total in", values, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalNotIn(List<Long> values) {
            addCriterion("seller_package_total not in", values, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalBetween(Long value1, Long value2) {
            addCriterion("seller_package_total between", value1, value2, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTotalNotBetween(Long value1, Long value2) {
            addCriterion("seller_package_total not between", value1, value2, "sellerPackageTotal");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedIsNull() {
            addCriterion("seller_package_used is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedIsNotNull() {
            addCriterion("seller_package_used is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedEqualTo(Long value) {
            addCriterion("seller_package_used =", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedNotEqualTo(Long value) {
            addCriterion("seller_package_used <>", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedGreaterThan(Long value) {
            addCriterion("seller_package_used >", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_package_used >=", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedLessThan(Long value) {
            addCriterion("seller_package_used <", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedLessThanOrEqualTo(Long value) {
            addCriterion("seller_package_used <=", value, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedIn(List<Long> values) {
            addCriterion("seller_package_used in", values, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedNotIn(List<Long> values) {
            addCriterion("seller_package_used not in", values, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedBetween(Long value1, Long value2) {
            addCriterion("seller_package_used between", value1, value2, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageUsedNotBetween(Long value1, Long value2) {
            addCriterion("seller_package_used not between", value1, value2, "sellerPackageUsed");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredIsNull() {
            addCriterion("seller_package_expired is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredIsNotNull() {
            addCriterion("seller_package_expired is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredEqualTo(Long value) {
            addCriterion("seller_package_expired =", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredNotEqualTo(Long value) {
            addCriterion("seller_package_expired <>", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredGreaterThan(Long value) {
            addCriterion("seller_package_expired >", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_package_expired >=", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredLessThan(Long value) {
            addCriterion("seller_package_expired <", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredLessThanOrEqualTo(Long value) {
            addCriterion("seller_package_expired <=", value, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredIn(List<Long> values) {
            addCriterion("seller_package_expired in", values, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredNotIn(List<Long> values) {
            addCriterion("seller_package_expired not in", values, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredBetween(Long value1, Long value2) {
            addCriterion("seller_package_expired between", value1, value2, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageExpiredNotBetween(Long value1, Long value2) {
            addCriterion("seller_package_expired not between", value1, value2, "sellerPackageExpired");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionIsNull() {
            addCriterion("seller_package_version is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionIsNotNull() {
            addCriterion("seller_package_version is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionEqualTo(Long value) {
            addCriterion("seller_package_version =", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionNotEqualTo(Long value) {
            addCriterion("seller_package_version <>", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionGreaterThan(Long value) {
            addCriterion("seller_package_version >", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("seller_package_version >=", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionLessThan(Long value) {
            addCriterion("seller_package_version <", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionLessThanOrEqualTo(Long value) {
            addCriterion("seller_package_version <=", value, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionIn(List<Long> values) {
            addCriterion("seller_package_version in", values, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionNotIn(List<Long> values) {
            addCriterion("seller_package_version not in", values, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionBetween(Long value1, Long value2) {
            addCriterion("seller_package_version between", value1, value2, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageVersionNotBetween(Long value1, Long value2) {
            addCriterion("seller_package_version not between", value1, value2, "sellerPackageVersion");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeIsNull() {
            addCriterion("seller_package_type is null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeIsNotNull() {
            addCriterion("seller_package_type is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeEqualTo(String value) {
            addCriterion("seller_package_type =", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeNotEqualTo(String value) {
            addCriterion("seller_package_type <>", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeGreaterThan(String value) {
            addCriterion("seller_package_type >", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("seller_package_type >=", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeLessThan(String value) {
            addCriterion("seller_package_type <", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeLessThanOrEqualTo(String value) {
            addCriterion("seller_package_type <=", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeLike(String value) {
            addCriterion("seller_package_type like", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeNotLike(String value) {
            addCriterion("seller_package_type not like", value, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeIn(List<String> values) {
            addCriterion("seller_package_type in", values, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeNotIn(List<String> values) {
            addCriterion("seller_package_type not in", values, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeBetween(String value1, String value2) {
            addCriterion("seller_package_type between", value1, value2, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSellerPackageTypeNotBetween(String value1, String value2) {
            addCriterion("seller_package_type not between", value1, value2, "sellerPackageType");
            return (Criteria) this;
        }

        public Criteria andSendTimesIsNull() {
            addCriterion("send_times is null");
            return (Criteria) this;
        }

        public Criteria andSendTimesIsNotNull() {
            addCriterion("send_times is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimesEqualTo(Integer value) {
            addCriterion("send_times =", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotEqualTo(Integer value) {
            addCriterion("send_times <>", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesGreaterThan(Integer value) {
            addCriterion("send_times >", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_times >=", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesLessThan(Integer value) {
            addCriterion("send_times <", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesLessThanOrEqualTo(Integer value) {
            addCriterion("send_times <=", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesIn(List<Integer> values) {
            addCriterion("send_times in", values, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotIn(List<Integer> values) {
            addCriterion("send_times not in", values, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesBetween(Integer value1, Integer value2) {
            addCriterion("send_times between", value1, value2, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("send_times not between", value1, value2, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendSucRateIsNull() {
            addCriterion("send_suc_rate is null");
            return (Criteria) this;
        }

        public Criteria andSendSucRateIsNotNull() {
            addCriterion("send_suc_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSendSucRateEqualTo(Integer value) {
            addCriterion("send_suc_rate =", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateNotEqualTo(Integer value) {
            addCriterion("send_suc_rate <>", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateGreaterThan(Integer value) {
            addCriterion("send_suc_rate >", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_suc_rate >=", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateLessThan(Integer value) {
            addCriterion("send_suc_rate <", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateLessThanOrEqualTo(Integer value) {
            addCriterion("send_suc_rate <=", value, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateIn(List<Integer> values) {
            addCriterion("send_suc_rate in", values, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateNotIn(List<Integer> values) {
            addCriterion("send_suc_rate not in", values, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateBetween(Integer value1, Integer value2) {
            addCriterion("send_suc_rate between", value1, value2, "sendSucRate");
            return (Criteria) this;
        }

        public Criteria andSendSucRateNotBetween(Integer value1, Integer value2) {
            addCriterion("send_suc_rate not between", value1, value2, "sendSucRate");
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