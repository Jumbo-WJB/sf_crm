package com.shufensoft.crm.biz.domain.generation.seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerMobileMenuExample {
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

    public SellerMobileMenuExample() {
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

    public void addFunctionTypeQueryColumn() {
        this.queryColumns.add("function_type");
    }

    public void addMaxFunctionTypeQueryColumn() {
        this.queryColumns.add("max(function_type) max_function_type");
    }

    public void addMinFunctionTypeQueryColumn() {
        this.queryColumns.add("min(function_type) min_function_type");
    }

    public void addAvgFunctionTypeQueryColumn() {
        this.queryColumns.add(" avg(function_type) avg_function_type");
    }

    public void addCountFunctionTypeQueryColumn() {
        this.queryColumns.add(" count(function_type) count_function_type");
    }

    public void addSumFunctionTypeQueryColumn() {
        this.queryColumns.add(" sum(function_type) sum_function_type");
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

    public void addNameQueryColumn() {
        this.queryColumns.add("name");
    }

    public void addMaxNameQueryColumn() {
        this.queryColumns.add("max(name) max_name");
    }

    public void addMinNameQueryColumn() {
        this.queryColumns.add("min(name) min_name");
    }

    public void addAvgNameQueryColumn() {
        this.queryColumns.add(" avg(name) avg_name");
    }

    public void addCountNameQueryColumn() {
        this.queryColumns.add(" count(name) count_name");
    }

    public void addSumNameQueryColumn() {
        this.queryColumns.add(" sum(name) sum_name");
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

    public void addLinkQueryColumn() {
        this.queryColumns.add("link");
    }

    public void addMaxLinkQueryColumn() {
        this.queryColumns.add("max(link) max_link");
    }

    public void addMinLinkQueryColumn() {
        this.queryColumns.add("min(link) min_link");
    }

    public void addAvgLinkQueryColumn() {
        this.queryColumns.add(" avg(link) avg_link");
    }

    public void addCountLinkQueryColumn() {
        this.queryColumns.add(" count(link) count_link");
    }

    public void addSumLinkQueryColumn() {
        this.queryColumns.add(" sum(link) sum_link");
    }

    public void addValidateQueryColumn() {
        this.queryColumns.add("validate");
    }

    public void addMaxValidateQueryColumn() {
        this.queryColumns.add("max(validate) max_validate");
    }

    public void addMinValidateQueryColumn() {
        this.queryColumns.add("min(validate) min_validate");
    }

    public void addAvgValidateQueryColumn() {
        this.queryColumns.add(" avg(validate) avg_validate");
    }

    public void addCountValidateQueryColumn() {
        this.queryColumns.add(" count(validate) count_validate");
    }

    public void addSumValidateQueryColumn() {
        this.queryColumns.add(" sum(validate) sum_validate");
    }

    public void addOauthQueryColumn() {
        this.queryColumns.add("oauth");
    }

    public void addMaxOauthQueryColumn() {
        this.queryColumns.add("max(oauth) max_oauth");
    }

    public void addMinOauthQueryColumn() {
        this.queryColumns.add("min(oauth) min_oauth");
    }

    public void addAvgOauthQueryColumn() {
        this.queryColumns.add(" avg(oauth) avg_oauth");
    }

    public void addCountOauthQueryColumn() {
        this.queryColumns.add(" count(oauth) count_oauth");
    }

    public void addSumOauthQueryColumn() {
        this.queryColumns.add(" sum(oauth) sum_oauth");
    }

    public void addPriorityQueryColumn() {
        this.queryColumns.add("priority");
    }

    public void addMaxPriorityQueryColumn() {
        this.queryColumns.add("max(priority) max_priority");
    }

    public void addMinPriorityQueryColumn() {
        this.queryColumns.add("min(priority) min_priority");
    }

    public void addAvgPriorityQueryColumn() {
        this.queryColumns.add(" avg(priority) avg_priority");
    }

    public void addCountPriorityQueryColumn() {
        this.queryColumns.add(" count(priority) count_priority");
    }

    public void addSumPriorityQueryColumn() {
        this.queryColumns.add(" sum(priority) sum_priority");
    }

    public void addDescriptionQueryColumn() {
        this.queryColumns.add("description");
    }

    public void addMaxDescriptionQueryColumn() {
        this.queryColumns.add("max(description) max_description");
    }

    public void addMinDescriptionQueryColumn() {
        this.queryColumns.add("min(description) min_description");
    }

    public void addAvgDescriptionQueryColumn() {
        this.queryColumns.add(" avg(description) avg_description");
    }

    public void addCountDescriptionQueryColumn() {
        this.queryColumns.add(" count(description) count_description");
    }

    public void addSumDescriptionQueryColumn() {
        this.queryColumns.add(" sum(description) sum_description");
    }

    public void addIsShowOtherQueryColumn() {
        this.queryColumns.add("is_show_other");
    }

    public void addMaxIsShowOtherQueryColumn() {
        this.queryColumns.add("max(is_show_other) max_is_show_other");
    }

    public void addMinIsShowOtherQueryColumn() {
        this.queryColumns.add("min(is_show_other) min_is_show_other");
    }

    public void addAvgIsShowOtherQueryColumn() {
        this.queryColumns.add(" avg(is_show_other) avg_is_show_other");
    }

    public void addCountIsShowOtherQueryColumn() {
        this.queryColumns.add(" count(is_show_other) count_is_show_other");
    }

    public void addSumIsShowOtherQueryColumn() {
        this.queryColumns.add(" sum(is_show_other) sum_is_show_other");
    }

    public void addIsSelectQueryColumn() {
        this.queryColumns.add("is_select");
    }

    public void addMaxIsSelectQueryColumn() {
        this.queryColumns.add("max(is_select) max_is_select");
    }

    public void addMinIsSelectQueryColumn() {
        this.queryColumns.add("min(is_select) min_is_select");
    }

    public void addAvgIsSelectQueryColumn() {
        this.queryColumns.add(" avg(is_select) avg_is_select");
    }

    public void addCountIsSelectQueryColumn() {
        this.queryColumns.add(" count(is_select) count_is_select");
    }

    public void addSumIsSelectQueryColumn() {
        this.queryColumns.add(" sum(is_select) sum_is_select");
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

        public Criteria andFunctionTypeIsNull() {
            addCriterion("function_type is null");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeIsNotNull() {
            addCriterion("function_type is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeEqualTo(String value) {
            addCriterion("function_type =", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotEqualTo(String value) {
            addCriterion("function_type <>", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeGreaterThan(String value) {
            addCriterion("function_type >", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("function_type >=", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeLessThan(String value) {
            addCriterion("function_type <", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeLessThanOrEqualTo(String value) {
            addCriterion("function_type <=", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeLike(String value) {
            addCriterion("function_type like", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotLike(String value) {
            addCriterion("function_type not like", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeIn(List<String> values) {
            addCriterion("function_type in", values, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotIn(List<String> values) {
            addCriterion("function_type not in", values, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeBetween(String value1, String value2) {
            addCriterion("function_type between", value1, value2, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotBetween(String value1, String value2) {
            addCriterion("function_type not between", value1, value2, "functionType");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andValidateIsNull() {
            addCriterion("validate is null");
            return (Criteria) this;
        }

        public Criteria andValidateIsNotNull() {
            addCriterion("validate is not null");
            return (Criteria) this;
        }

        public Criteria andValidateEqualTo(Boolean value) {
            addCriterion("validate =", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateNotEqualTo(Boolean value) {
            addCriterion("validate <>", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateGreaterThan(Boolean value) {
            addCriterion("validate >", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("validate >=", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateLessThan(Boolean value) {
            addCriterion("validate <", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateLessThanOrEqualTo(Boolean value) {
            addCriterion("validate <=", value, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateIn(List<Boolean> values) {
            addCriterion("validate in", values, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateNotIn(List<Boolean> values) {
            addCriterion("validate not in", values, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateBetween(Boolean value1, Boolean value2) {
            addCriterion("validate between", value1, value2, "validate");
            return (Criteria) this;
        }

        public Criteria andValidateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("validate not between", value1, value2, "validate");
            return (Criteria) this;
        }

        public Criteria andOauthIsNull() {
            addCriterion("oauth is null");
            return (Criteria) this;
        }

        public Criteria andOauthIsNotNull() {
            addCriterion("oauth is not null");
            return (Criteria) this;
        }

        public Criteria andOauthEqualTo(Boolean value) {
            addCriterion("oauth =", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthNotEqualTo(Boolean value) {
            addCriterion("oauth <>", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthGreaterThan(Boolean value) {
            addCriterion("oauth >", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthGreaterThanOrEqualTo(Boolean value) {
            addCriterion("oauth >=", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthLessThan(Boolean value) {
            addCriterion("oauth <", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthLessThanOrEqualTo(Boolean value) {
            addCriterion("oauth <=", value, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthIn(List<Boolean> values) {
            addCriterion("oauth in", values, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthNotIn(List<Boolean> values) {
            addCriterion("oauth not in", values, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthBetween(Boolean value1, Boolean value2) {
            addCriterion("oauth between", value1, value2, "oauth");
            return (Criteria) this;
        }

        public Criteria andOauthNotBetween(Boolean value1, Boolean value2) {
            addCriterion("oauth not between", value1, value2, "oauth");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherIsNull() {
            addCriterion("is_show_other is null");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherIsNotNull() {
            addCriterion("is_show_other is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherEqualTo(String value) {
            addCriterion("is_show_other =", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherNotEqualTo(String value) {
            addCriterion("is_show_other <>", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherGreaterThan(String value) {
            addCriterion("is_show_other >", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherGreaterThanOrEqualTo(String value) {
            addCriterion("is_show_other >=", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherLessThan(String value) {
            addCriterion("is_show_other <", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherLessThanOrEqualTo(String value) {
            addCriterion("is_show_other <=", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherLike(String value) {
            addCriterion("is_show_other like", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherNotLike(String value) {
            addCriterion("is_show_other not like", value, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherIn(List<String> values) {
            addCriterion("is_show_other in", values, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherNotIn(List<String> values) {
            addCriterion("is_show_other not in", values, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherBetween(String value1, String value2) {
            addCriterion("is_show_other between", value1, value2, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsShowOtherNotBetween(String value1, String value2) {
            addCriterion("is_show_other not between", value1, value2, "isShowOther");
            return (Criteria) this;
        }

        public Criteria andIsSelectIsNull() {
            addCriterion("is_select is null");
            return (Criteria) this;
        }

        public Criteria andIsSelectIsNotNull() {
            addCriterion("is_select is not null");
            return (Criteria) this;
        }

        public Criteria andIsSelectEqualTo(String value) {
            addCriterion("is_select =", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectNotEqualTo(String value) {
            addCriterion("is_select <>", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectGreaterThan(String value) {
            addCriterion("is_select >", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectGreaterThanOrEqualTo(String value) {
            addCriterion("is_select >=", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectLessThan(String value) {
            addCriterion("is_select <", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectLessThanOrEqualTo(String value) {
            addCriterion("is_select <=", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectLike(String value) {
            addCriterion("is_select like", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectNotLike(String value) {
            addCriterion("is_select not like", value, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectIn(List<String> values) {
            addCriterion("is_select in", values, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectNotIn(List<String> values) {
            addCriterion("is_select not in", values, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectBetween(String value1, String value2) {
            addCriterion("is_select between", value1, value2, "isSelect");
            return (Criteria) this;
        }

        public Criteria andIsSelectNotBetween(String value1, String value2) {
            addCriterion("is_select not between", value1, value2, "isSelect");
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