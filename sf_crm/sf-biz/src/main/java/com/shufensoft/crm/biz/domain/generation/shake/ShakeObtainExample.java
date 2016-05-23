package com.shufensoft.crm.biz.domain.generation.shake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShakeObtainExample {
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

    public ShakeObtainExample() {
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

    public void addRockTitleQueryColumn() {
        this.queryColumns.add("rock_title");
    }

    public void addMaxRockTitleQueryColumn() {
        this.queryColumns.add("max(rock_title) max_rock_title");
    }

    public void addMinRockTitleQueryColumn() {
        this.queryColumns.add("min(rock_title) min_rock_title");
    }

    public void addAvgRockTitleQueryColumn() {
        this.queryColumns.add(" avg(rock_title) avg_rock_title");
    }

    public void addCountRockTitleQueryColumn() {
        this.queryColumns.add(" count(rock_title) count_rock_title");
    }

    public void addSumRockTitleQueryColumn() {
        this.queryColumns.add(" sum(rock_title) sum_rock_title");
    }

    public void addRockResultQueryColumn() {
        this.queryColumns.add("rock_result");
    }

    public void addMaxRockResultQueryColumn() {
        this.queryColumns.add("max(rock_result) max_rock_result");
    }

    public void addMinRockResultQueryColumn() {
        this.queryColumns.add("min(rock_result) min_rock_result");
    }

    public void addAvgRockResultQueryColumn() {
        this.queryColumns.add(" avg(rock_result) avg_rock_result");
    }

    public void addCountRockResultQueryColumn() {
        this.queryColumns.add(" count(rock_result) count_rock_result");
    }

    public void addSumRockResultQueryColumn() {
        this.queryColumns.add(" sum(rock_result) sum_rock_result");
    }

    public void addRockTypeQueryColumn() {
        this.queryColumns.add("rock_type");
    }

    public void addMaxRockTypeQueryColumn() {
        this.queryColumns.add("max(rock_type) max_rock_type");
    }

    public void addMinRockTypeQueryColumn() {
        this.queryColumns.add("min(rock_type) min_rock_type");
    }

    public void addAvgRockTypeQueryColumn() {
        this.queryColumns.add(" avg(rock_type) avg_rock_type");
    }

    public void addCountRockTypeQueryColumn() {
        this.queryColumns.add(" count(rock_type) count_rock_type");
    }

    public void addSumRockTypeQueryColumn() {
        this.queryColumns.add(" sum(rock_type) sum_rock_type");
    }

    public void addShakeStatusQueryColumn() {
        this.queryColumns.add("shake_status");
    }

    public void addMaxShakeStatusQueryColumn() {
        this.queryColumns.add("max(shake_status) max_shake_status");
    }

    public void addMinShakeStatusQueryColumn() {
        this.queryColumns.add("min(shake_status) min_shake_status");
    }

    public void addAvgShakeStatusQueryColumn() {
        this.queryColumns.add(" avg(shake_status) avg_shake_status");
    }

    public void addCountShakeStatusQueryColumn() {
        this.queryColumns.add(" count(shake_status) count_shake_status");
    }

    public void addSumShakeStatusQueryColumn() {
        this.queryColumns.add(" sum(shake_status) sum_shake_status");
    }

    public void addShakeDateQueryColumn() {
        this.queryColumns.add("shake_date");
    }

    public void addMaxShakeDateQueryColumn() {
        this.queryColumns.add("max(shake_date) max_shake_date");
    }

    public void addMinShakeDateQueryColumn() {
        this.queryColumns.add("min(shake_date) min_shake_date");
    }

    public void addAvgShakeDateQueryColumn() {
        this.queryColumns.add(" avg(shake_date) avg_shake_date");
    }

    public void addCountShakeDateQueryColumn() {
        this.queryColumns.add(" count(shake_date) count_shake_date");
    }

    public void addSumShakeDateQueryColumn() {
        this.queryColumns.add(" sum(shake_date) sum_shake_date");
    }

    public void addRockIdQueryColumn() {
        this.queryColumns.add("rock_id");
    }

    public void addMaxRockIdQueryColumn() {
        this.queryColumns.add("max(rock_id) max_rock_id");
    }

    public void addMinRockIdQueryColumn() {
        this.queryColumns.add("min(rock_id) min_rock_id");
    }

    public void addAvgRockIdQueryColumn() {
        this.queryColumns.add(" avg(rock_id) avg_rock_id");
    }

    public void addCountRockIdQueryColumn() {
        this.queryColumns.add(" count(rock_id) count_rock_id");
    }

    public void addSumRockIdQueryColumn() {
        this.queryColumns.add(" sum(rock_id) sum_rock_id");
    }

    public void addObtainIdQueryColumn() {
        this.queryColumns.add("obtain_id");
    }

    public void addMaxObtainIdQueryColumn() {
        this.queryColumns.add("max(obtain_id) max_obtain_id");
    }

    public void addMinObtainIdQueryColumn() {
        this.queryColumns.add("min(obtain_id) min_obtain_id");
    }

    public void addAvgObtainIdQueryColumn() {
        this.queryColumns.add(" avg(obtain_id) avg_obtain_id");
    }

    public void addCountObtainIdQueryColumn() {
        this.queryColumns.add(" count(obtain_id) count_obtain_id");
    }

    public void addSumObtainIdQueryColumn() {
        this.queryColumns.add(" sum(obtain_id) sum_obtain_id");
    }

    public void addObtainDateQueryColumn() {
        this.queryColumns.add("obtain_date");
    }

    public void addMaxObtainDateQueryColumn() {
        this.queryColumns.add("max(obtain_date) max_obtain_date");
    }

    public void addMinObtainDateQueryColumn() {
        this.queryColumns.add("min(obtain_date) min_obtain_date");
    }

    public void addAvgObtainDateQueryColumn() {
        this.queryColumns.add(" avg(obtain_date) avg_obtain_date");
    }

    public void addCountObtainDateQueryColumn() {
        this.queryColumns.add(" count(obtain_date) count_obtain_date");
    }

    public void addSumObtainDateQueryColumn() {
        this.queryColumns.add(" sum(obtain_date) sum_obtain_date");
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

        public Criteria andRockTitleIsNull() {
            addCriterion("rock_title is null");
            return (Criteria) this;
        }

        public Criteria andRockTitleIsNotNull() {
            addCriterion("rock_title is not null");
            return (Criteria) this;
        }

        public Criteria andRockTitleEqualTo(String value) {
            addCriterion("rock_title =", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleNotEqualTo(String value) {
            addCriterion("rock_title <>", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleGreaterThan(String value) {
            addCriterion("rock_title >", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleGreaterThanOrEqualTo(String value) {
            addCriterion("rock_title >=", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleLessThan(String value) {
            addCriterion("rock_title <", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleLessThanOrEqualTo(String value) {
            addCriterion("rock_title <=", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleLike(String value) {
            addCriterion("rock_title like", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleNotLike(String value) {
            addCriterion("rock_title not like", value, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleIn(List<String> values) {
            addCriterion("rock_title in", values, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleNotIn(List<String> values) {
            addCriterion("rock_title not in", values, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleBetween(String value1, String value2) {
            addCriterion("rock_title between", value1, value2, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockTitleNotBetween(String value1, String value2) {
            addCriterion("rock_title not between", value1, value2, "rockTitle");
            return (Criteria) this;
        }

        public Criteria andRockResultIsNull() {
            addCriterion("rock_result is null");
            return (Criteria) this;
        }

        public Criteria andRockResultIsNotNull() {
            addCriterion("rock_result is not null");
            return (Criteria) this;
        }

        public Criteria andRockResultEqualTo(String value) {
            addCriterion("rock_result =", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultNotEqualTo(String value) {
            addCriterion("rock_result <>", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultGreaterThan(String value) {
            addCriterion("rock_result >", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultGreaterThanOrEqualTo(String value) {
            addCriterion("rock_result >=", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultLessThan(String value) {
            addCriterion("rock_result <", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultLessThanOrEqualTo(String value) {
            addCriterion("rock_result <=", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultLike(String value) {
            addCriterion("rock_result like", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultNotLike(String value) {
            addCriterion("rock_result not like", value, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultIn(List<String> values) {
            addCriterion("rock_result in", values, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultNotIn(List<String> values) {
            addCriterion("rock_result not in", values, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultBetween(String value1, String value2) {
            addCriterion("rock_result between", value1, value2, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockResultNotBetween(String value1, String value2) {
            addCriterion("rock_result not between", value1, value2, "rockResult");
            return (Criteria) this;
        }

        public Criteria andRockTypeIsNull() {
            addCriterion("rock_type is null");
            return (Criteria) this;
        }

        public Criteria andRockTypeIsNotNull() {
            addCriterion("rock_type is not null");
            return (Criteria) this;
        }

        public Criteria andRockTypeEqualTo(String value) {
            addCriterion("rock_type =", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeNotEqualTo(String value) {
            addCriterion("rock_type <>", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeGreaterThan(String value) {
            addCriterion("rock_type >", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rock_type >=", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeLessThan(String value) {
            addCriterion("rock_type <", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeLessThanOrEqualTo(String value) {
            addCriterion("rock_type <=", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeLike(String value) {
            addCriterion("rock_type like", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeNotLike(String value) {
            addCriterion("rock_type not like", value, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeIn(List<String> values) {
            addCriterion("rock_type in", values, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeNotIn(List<String> values) {
            addCriterion("rock_type not in", values, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeBetween(String value1, String value2) {
            addCriterion("rock_type between", value1, value2, "rockType");
            return (Criteria) this;
        }

        public Criteria andRockTypeNotBetween(String value1, String value2) {
            addCriterion("rock_type not between", value1, value2, "rockType");
            return (Criteria) this;
        }

        public Criteria andShakeStatusIsNull() {
            addCriterion("shake_status is null");
            return (Criteria) this;
        }

        public Criteria andShakeStatusIsNotNull() {
            addCriterion("shake_status is not null");
            return (Criteria) this;
        }

        public Criteria andShakeStatusEqualTo(String value) {
            addCriterion("shake_status =", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusNotEqualTo(String value) {
            addCriterion("shake_status <>", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusGreaterThan(String value) {
            addCriterion("shake_status >", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("shake_status >=", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusLessThan(String value) {
            addCriterion("shake_status <", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusLessThanOrEqualTo(String value) {
            addCriterion("shake_status <=", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusLike(String value) {
            addCriterion("shake_status like", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusNotLike(String value) {
            addCriterion("shake_status not like", value, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusIn(List<String> values) {
            addCriterion("shake_status in", values, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusNotIn(List<String> values) {
            addCriterion("shake_status not in", values, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusBetween(String value1, String value2) {
            addCriterion("shake_status between", value1, value2, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeStatusNotBetween(String value1, String value2) {
            addCriterion("shake_status not between", value1, value2, "shakeStatus");
            return (Criteria) this;
        }

        public Criteria andShakeDateIsNull() {
            addCriterion("shake_date is null");
            return (Criteria) this;
        }

        public Criteria andShakeDateIsNotNull() {
            addCriterion("shake_date is not null");
            return (Criteria) this;
        }

        public Criteria andShakeDateEqualTo(Date value) {
            addCriterion("shake_date =", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateNotEqualTo(Date value) {
            addCriterion("shake_date <>", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateGreaterThan(Date value) {
            addCriterion("shake_date >", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("shake_date >=", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateLessThan(Date value) {
            addCriterion("shake_date <", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateLessThanOrEqualTo(Date value) {
            addCriterion("shake_date <=", value, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateIn(List<Date> values) {
            addCriterion("shake_date in", values, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateNotIn(List<Date> values) {
            addCriterion("shake_date not in", values, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateBetween(Date value1, Date value2) {
            addCriterion("shake_date between", value1, value2, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andShakeDateNotBetween(Date value1, Date value2) {
            addCriterion("shake_date not between", value1, value2, "shakeDate");
            return (Criteria) this;
        }

        public Criteria andRockIdIsNull() {
            addCriterion("rock_id is null");
            return (Criteria) this;
        }

        public Criteria andRockIdIsNotNull() {
            addCriterion("rock_id is not null");
            return (Criteria) this;
        }

        public Criteria andRockIdEqualTo(Long value) {
            addCriterion("rock_id =", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotEqualTo(Long value) {
            addCriterion("rock_id <>", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdGreaterThan(Long value) {
            addCriterion("rock_id >", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rock_id >=", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdLessThan(Long value) {
            addCriterion("rock_id <", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdLessThanOrEqualTo(Long value) {
            addCriterion("rock_id <=", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdIn(List<Long> values) {
            addCriterion("rock_id in", values, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotIn(List<Long> values) {
            addCriterion("rock_id not in", values, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdBetween(Long value1, Long value2) {
            addCriterion("rock_id between", value1, value2, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotBetween(Long value1, Long value2) {
            addCriterion("rock_id not between", value1, value2, "rockId");
            return (Criteria) this;
        }

        public Criteria andObtainIdIsNull() {
            addCriterion("obtain_id is null");
            return (Criteria) this;
        }

        public Criteria andObtainIdIsNotNull() {
            addCriterion("obtain_id is not null");
            return (Criteria) this;
        }

        public Criteria andObtainIdEqualTo(Long value) {
            addCriterion("obtain_id =", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdNotEqualTo(Long value) {
            addCriterion("obtain_id <>", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdGreaterThan(Long value) {
            addCriterion("obtain_id >", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("obtain_id >=", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdLessThan(Long value) {
            addCriterion("obtain_id <", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdLessThanOrEqualTo(Long value) {
            addCriterion("obtain_id <=", value, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdIn(List<Long> values) {
            addCriterion("obtain_id in", values, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdNotIn(List<Long> values) {
            addCriterion("obtain_id not in", values, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdBetween(Long value1, Long value2) {
            addCriterion("obtain_id between", value1, value2, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainIdNotBetween(Long value1, Long value2) {
            addCriterion("obtain_id not between", value1, value2, "obtainId");
            return (Criteria) this;
        }

        public Criteria andObtainDateIsNull() {
            addCriterion("obtain_date is null");
            return (Criteria) this;
        }

        public Criteria andObtainDateIsNotNull() {
            addCriterion("obtain_date is not null");
            return (Criteria) this;
        }

        public Criteria andObtainDateEqualTo(Date value) {
            addCriterion("obtain_date =", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateNotEqualTo(Date value) {
            addCriterion("obtain_date <>", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateGreaterThan(Date value) {
            addCriterion("obtain_date >", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("obtain_date >=", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateLessThan(Date value) {
            addCriterion("obtain_date <", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateLessThanOrEqualTo(Date value) {
            addCriterion("obtain_date <=", value, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateIn(List<Date> values) {
            addCriterion("obtain_date in", values, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateNotIn(List<Date> values) {
            addCriterion("obtain_date not in", values, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateBetween(Date value1, Date value2) {
            addCriterion("obtain_date between", value1, value2, "obtainDate");
            return (Criteria) this;
        }

        public Criteria andObtainDateNotBetween(Date value1, Date value2) {
            addCriterion("obtain_date not between", value1, value2, "obtainDate");
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