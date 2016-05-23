package com.shufensoft.crm.biz.domain.generation.seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerPackageDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /** 在查询中增加for update 
     * 目前用来支持对查询记录加锁
     **/
    protected boolean forUpdate;

    public SellerPackageDetailExample() {
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
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
        return forUpdate;
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

        public Criteria andPackageIdIsNull() {
            addCriterion("package_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("package_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(String value) {
            addCriterion("package_id =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(String value) {
            addCriterion("package_id <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(String value) {
            addCriterion("package_id >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_id >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(String value) {
            addCriterion("package_id <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(String value) {
            addCriterion("package_id <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLike(String value) {
            addCriterion("package_id like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotLike(String value) {
            addCriterion("package_id not like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<String> values) {
            addCriterion("package_id in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<String> values) {
            addCriterion("package_id not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(String value1, String value2) {
            addCriterion("package_id between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(String value1, String value2) {
            addCriterion("package_id not between", value1, value2, "packageId");
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

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageCountIsNull() {
            addCriterion("package_count is null");
            return (Criteria) this;
        }

        public Criteria andPackageCountIsNotNull() {
            addCriterion("package_count is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCountEqualTo(Integer value) {
            addCriterion("package_count =", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountNotEqualTo(Integer value) {
            addCriterion("package_count <>", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountGreaterThan(Integer value) {
            addCriterion("package_count >", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_count >=", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountLessThan(Integer value) {
            addCriterion("package_count <", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountLessThanOrEqualTo(Integer value) {
            addCriterion("package_count <=", value, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountIn(List<Integer> values) {
            addCriterion("package_count in", values, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountNotIn(List<Integer> values) {
            addCriterion("package_count not in", values, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountBetween(Integer value1, Integer value2) {
            addCriterion("package_count between", value1, value2, "packageCount");
            return (Criteria) this;
        }

        public Criteria andPackageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("package_count not between", value1, value2, "packageCount");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(Date value) {
            addCriterion("expired_time =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(Date value) {
            addCriterion("expired_time <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(Date value) {
            addCriterion("expired_time >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expired_time >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(Date value) {
            addCriterion("expired_time <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("expired_time <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<Date> values) {
            addCriterion("expired_time in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<Date> values) {
            addCriterion("expired_time not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("expired_time between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("expired_time not between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagIsNull() {
            addCriterion("expired_flag is null");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagIsNotNull() {
            addCriterion("expired_flag is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagEqualTo(String value) {
            addCriterion("expired_flag =", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagNotEqualTo(String value) {
            addCriterion("expired_flag <>", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagGreaterThan(String value) {
            addCriterion("expired_flag >", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagGreaterThanOrEqualTo(String value) {
            addCriterion("expired_flag >=", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagLessThan(String value) {
            addCriterion("expired_flag <", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagLessThanOrEqualTo(String value) {
            addCriterion("expired_flag <=", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagLike(String value) {
            addCriterion("expired_flag like", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagNotLike(String value) {
            addCriterion("expired_flag not like", value, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagIn(List<String> values) {
            addCriterion("expired_flag in", values, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagNotIn(List<String> values) {
            addCriterion("expired_flag not in", values, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagBetween(String value1, String value2) {
            addCriterion("expired_flag between", value1, value2, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andExpiredFlagNotBetween(String value1, String value2) {
            addCriterion("expired_flag not between", value1, value2, "expiredFlag");
            return (Criteria) this;
        }

        public Criteria andPackageRemainIsNull() {
            addCriterion("package_remain is null");
            return (Criteria) this;
        }

        public Criteria andPackageRemainIsNotNull() {
            addCriterion("package_remain is not null");
            return (Criteria) this;
        }

        public Criteria andPackageRemainEqualTo(Integer value) {
            addCriterion("package_remain =", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainNotEqualTo(Integer value) {
            addCriterion("package_remain <>", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainGreaterThan(Integer value) {
            addCriterion("package_remain >", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_remain >=", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainLessThan(Integer value) {
            addCriterion("package_remain <", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainLessThanOrEqualTo(Integer value) {
            addCriterion("package_remain <=", value, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainIn(List<Integer> values) {
            addCriterion("package_remain in", values, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainNotIn(List<Integer> values) {
            addCriterion("package_remain not in", values, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainBetween(Integer value1, Integer value2) {
            addCriterion("package_remain between", value1, value2, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageRemainNotBetween(Integer value1, Integer value2) {
            addCriterion("package_remain not between", value1, value2, "packageRemain");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIsNull() {
            addCriterion("package_type is null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIsNotNull() {
            addCriterion("package_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeEqualTo(String value) {
            addCriterion("package_type =", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotEqualTo(String value) {
            addCriterion("package_type <>", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThan(String value) {
            addCriterion("package_type >", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("package_type >=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThan(String value) {
            addCriterion("package_type <", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThanOrEqualTo(String value) {
            addCriterion("package_type <=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLike(String value) {
            addCriterion("package_type like", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotLike(String value) {
            addCriterion("package_type not like", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIn(List<String> values) {
            addCriterion("package_type in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotIn(List<String> values) {
            addCriterion("package_type not in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeBetween(String value1, String value2) {
            addCriterion("package_type between", value1, value2, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotBetween(String value1, String value2) {
            addCriterion("package_type not between", value1, value2, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNull() {
            addCriterion("package_fee is null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIsNotNull() {
            addCriterion("package_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPackageFeeEqualTo(Integer value) {
            addCriterion("package_fee =", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotEqualTo(Integer value) {
            addCriterion("package_fee <>", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThan(Integer value) {
            addCriterion("package_fee >", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_fee >=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThan(Integer value) {
            addCriterion("package_fee <", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeLessThanOrEqualTo(Integer value) {
            addCriterion("package_fee <=", value, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeIn(List<Integer> values) {
            addCriterion("package_fee in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotIn(List<Integer> values) {
            addCriterion("package_fee not in", values, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeBetween(Integer value1, Integer value2) {
            addCriterion("package_fee between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("package_fee not between", value1, value2, "packageFee");
            return (Criteria) this;
        }

        public Criteria andPackageFreeIsNull() {
            addCriterion("package_free is null");
            return (Criteria) this;
        }

        public Criteria andPackageFreeIsNotNull() {
            addCriterion("package_free is not null");
            return (Criteria) this;
        }

        public Criteria andPackageFreeEqualTo(Integer value) {
            addCriterion("package_free =", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeNotEqualTo(Integer value) {
            addCriterion("package_free <>", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeGreaterThan(Integer value) {
            addCriterion("package_free >", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_free >=", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeLessThan(Integer value) {
            addCriterion("package_free <", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeLessThanOrEqualTo(Integer value) {
            addCriterion("package_free <=", value, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeIn(List<Integer> values) {
            addCriterion("package_free in", values, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeNotIn(List<Integer> values) {
            addCriterion("package_free not in", values, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeBetween(Integer value1, Integer value2) {
            addCriterion("package_free between", value1, value2, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("package_free not between", value1, value2, "packageFree");
            return (Criteria) this;
        }

        public Criteria andPackageDescIsNull() {
            addCriterion("package_desc is null");
            return (Criteria) this;
        }

        public Criteria andPackageDescIsNotNull() {
            addCriterion("package_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPackageDescEqualTo(String value) {
            addCriterion("package_desc =", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescNotEqualTo(String value) {
            addCriterion("package_desc <>", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescGreaterThan(String value) {
            addCriterion("package_desc >", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescGreaterThanOrEqualTo(String value) {
            addCriterion("package_desc >=", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescLessThan(String value) {
            addCriterion("package_desc <", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescLessThanOrEqualTo(String value) {
            addCriterion("package_desc <=", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescLike(String value) {
            addCriterion("package_desc like", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescNotLike(String value) {
            addCriterion("package_desc not like", value, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescIn(List<String> values) {
            addCriterion("package_desc in", values, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescNotIn(List<String> values) {
            addCriterion("package_desc not in", values, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescBetween(String value1, String value2) {
            addCriterion("package_desc between", value1, value2, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageDescNotBetween(String value1, String value2) {
            addCriterion("package_desc not between", value1, value2, "packageDesc");
            return (Criteria) this;
        }

        public Criteria andPackageVersionIsNull() {
            addCriterion("package_version is null");
            return (Criteria) this;
        }

        public Criteria andPackageVersionIsNotNull() {
            addCriterion("package_version is not null");
            return (Criteria) this;
        }

        public Criteria andPackageVersionEqualTo(Integer value) {
            addCriterion("package_version =", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionNotEqualTo(Integer value) {
            addCriterion("package_version <>", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionGreaterThan(Integer value) {
            addCriterion("package_version >", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_version >=", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionLessThan(Integer value) {
            addCriterion("package_version <", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionLessThanOrEqualTo(Integer value) {
            addCriterion("package_version <=", value, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionIn(List<Integer> values) {
            addCriterion("package_version in", values, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionNotIn(List<Integer> values) {
            addCriterion("package_version not in", values, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionBetween(Integer value1, Integer value2) {
            addCriterion("package_version between", value1, value2, "packageVersion");
            return (Criteria) this;
        }

        public Criteria andPackageVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("package_version not between", value1, value2, "packageVersion");
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