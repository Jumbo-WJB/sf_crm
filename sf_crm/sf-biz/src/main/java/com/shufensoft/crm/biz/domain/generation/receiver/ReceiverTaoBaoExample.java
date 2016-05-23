package com.shufensoft.crm.biz.domain.generation.receiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiverTaoBaoExample {
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

    public ReceiverTaoBaoExample() {
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

    public void addReceiverIdTbQueryColumn() {
        this.queryColumns.add("receiver_id_tb");
    }

    public void addMaxReceiverIdTbQueryColumn() {
        this.queryColumns.add("max(receiver_id_tb) max_receiver_id_tb");
    }

    public void addMinReceiverIdTbQueryColumn() {
        this.queryColumns.add("min(receiver_id_tb) min_receiver_id_tb");
    }

    public void addAvgReceiverIdTbQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_tb) avg_receiver_id_tb");
    }

    public void addCountReceiverIdTbQueryColumn() {
        this.queryColumns.add(" count(receiver_id_tb) count_receiver_id_tb");
    }

    public void addSumReceiverIdTbQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_tb) sum_receiver_id_tb");
    }

    public void addUserIdTbQueryColumn() {
        this.queryColumns.add("user_id_tb");
    }

    public void addMaxUserIdTbQueryColumn() {
        this.queryColumns.add("max(user_id_tb) max_user_id_tb");
    }

    public void addMinUserIdTbQueryColumn() {
        this.queryColumns.add("min(user_id_tb) min_user_id_tb");
    }

    public void addAvgUserIdTbQueryColumn() {
        this.queryColumns.add(" avg(user_id_tb) avg_user_id_tb");
    }

    public void addCountUserIdTbQueryColumn() {
        this.queryColumns.add(" count(user_id_tb) count_user_id_tb");
    }

    public void addSumUserIdTbQueryColumn() {
        this.queryColumns.add(" sum(user_id_tb) sum_user_id_tb");
    }

    public void addCreatedQueryColumn() {
        this.queryColumns.add("created");
    }

    public void addMaxCreatedQueryColumn() {
        this.queryColumns.add("max(created) max_created");
    }

    public void addMinCreatedQueryColumn() {
        this.queryColumns.add("min(created) min_created");
    }

    public void addAvgCreatedQueryColumn() {
        this.queryColumns.add(" avg(created) avg_created");
    }

    public void addCountCreatedQueryColumn() {
        this.queryColumns.add(" count(created) count_created");
    }

    public void addSumCreatedQueryColumn() {
        this.queryColumns.add(" sum(created) sum_created");
    }

    public void addReceiverNameQueryColumn() {
        this.queryColumns.add("receiver_name");
    }

    public void addMaxReceiverNameQueryColumn() {
        this.queryColumns.add("max(receiver_name) max_receiver_name");
    }

    public void addMinReceiverNameQueryColumn() {
        this.queryColumns.add("min(receiver_name) min_receiver_name");
    }

    public void addAvgReceiverNameQueryColumn() {
        this.queryColumns.add(" avg(receiver_name) avg_receiver_name");
    }

    public void addCountReceiverNameQueryColumn() {
        this.queryColumns.add(" count(receiver_name) count_receiver_name");
    }

    public void addSumReceiverNameQueryColumn() {
        this.queryColumns.add(" sum(receiver_name) sum_receiver_name");
    }

    public void addReceiverCountryQueryColumn() {
        this.queryColumns.add("receiver_country");
    }

    public void addMaxReceiverCountryQueryColumn() {
        this.queryColumns.add("max(receiver_country) max_receiver_country");
    }

    public void addMinReceiverCountryQueryColumn() {
        this.queryColumns.add("min(receiver_country) min_receiver_country");
    }

    public void addAvgReceiverCountryQueryColumn() {
        this.queryColumns.add(" avg(receiver_country) avg_receiver_country");
    }

    public void addCountReceiverCountryQueryColumn() {
        this.queryColumns.add(" count(receiver_country) count_receiver_country");
    }

    public void addSumReceiverCountryQueryColumn() {
        this.queryColumns.add(" sum(receiver_country) sum_receiver_country");
    }

    public void addReceiverStateQueryColumn() {
        this.queryColumns.add("receiver_state");
    }

    public void addMaxReceiverStateQueryColumn() {
        this.queryColumns.add("max(receiver_state) max_receiver_state");
    }

    public void addMinReceiverStateQueryColumn() {
        this.queryColumns.add("min(receiver_state) min_receiver_state");
    }

    public void addAvgReceiverStateQueryColumn() {
        this.queryColumns.add(" avg(receiver_state) avg_receiver_state");
    }

    public void addCountReceiverStateQueryColumn() {
        this.queryColumns.add(" count(receiver_state) count_receiver_state");
    }

    public void addSumReceiverStateQueryColumn() {
        this.queryColumns.add(" sum(receiver_state) sum_receiver_state");
    }

    public void addReceiverCityQueryColumn() {
        this.queryColumns.add("receiver_city");
    }

    public void addMaxReceiverCityQueryColumn() {
        this.queryColumns.add("max(receiver_city) max_receiver_city");
    }

    public void addMinReceiverCityQueryColumn() {
        this.queryColumns.add("min(receiver_city) min_receiver_city");
    }

    public void addAvgReceiverCityQueryColumn() {
        this.queryColumns.add(" avg(receiver_city) avg_receiver_city");
    }

    public void addCountReceiverCityQueryColumn() {
        this.queryColumns.add(" count(receiver_city) count_receiver_city");
    }

    public void addSumReceiverCityQueryColumn() {
        this.queryColumns.add(" sum(receiver_city) sum_receiver_city");
    }

    public void addReceiverDistrictQueryColumn() {
        this.queryColumns.add("receiver_district");
    }

    public void addMaxReceiverDistrictQueryColumn() {
        this.queryColumns.add("max(receiver_district) max_receiver_district");
    }

    public void addMinReceiverDistrictQueryColumn() {
        this.queryColumns.add("min(receiver_district) min_receiver_district");
    }

    public void addAvgReceiverDistrictQueryColumn() {
        this.queryColumns.add(" avg(receiver_district) avg_receiver_district");
    }

    public void addCountReceiverDistrictQueryColumn() {
        this.queryColumns.add(" count(receiver_district) count_receiver_district");
    }

    public void addSumReceiverDistrictQueryColumn() {
        this.queryColumns.add(" sum(receiver_district) sum_receiver_district");
    }

    public void addReceiverTownQueryColumn() {
        this.queryColumns.add("receiver_town");
    }

    public void addMaxReceiverTownQueryColumn() {
        this.queryColumns.add("max(receiver_town) max_receiver_town");
    }

    public void addMinReceiverTownQueryColumn() {
        this.queryColumns.add("min(receiver_town) min_receiver_town");
    }

    public void addAvgReceiverTownQueryColumn() {
        this.queryColumns.add(" avg(receiver_town) avg_receiver_town");
    }

    public void addCountReceiverTownQueryColumn() {
        this.queryColumns.add(" count(receiver_town) count_receiver_town");
    }

    public void addSumReceiverTownQueryColumn() {
        this.queryColumns.add(" sum(receiver_town) sum_receiver_town");
    }

    public void addReceiverAddressQueryColumn() {
        this.queryColumns.add("receiver_address");
    }

    public void addMaxReceiverAddressQueryColumn() {
        this.queryColumns.add("max(receiver_address) max_receiver_address");
    }

    public void addMinReceiverAddressQueryColumn() {
        this.queryColumns.add("min(receiver_address) min_receiver_address");
    }

    public void addAvgReceiverAddressQueryColumn() {
        this.queryColumns.add(" avg(receiver_address) avg_receiver_address");
    }

    public void addCountReceiverAddressQueryColumn() {
        this.queryColumns.add(" count(receiver_address) count_receiver_address");
    }

    public void addSumReceiverAddressQueryColumn() {
        this.queryColumns.add(" sum(receiver_address) sum_receiver_address");
    }

    public void addReceiverZipQueryColumn() {
        this.queryColumns.add("receiver_zip");
    }

    public void addMaxReceiverZipQueryColumn() {
        this.queryColumns.add("max(receiver_zip) max_receiver_zip");
    }

    public void addMinReceiverZipQueryColumn() {
        this.queryColumns.add("min(receiver_zip) min_receiver_zip");
    }

    public void addAvgReceiverZipQueryColumn() {
        this.queryColumns.add(" avg(receiver_zip) avg_receiver_zip");
    }

    public void addCountReceiverZipQueryColumn() {
        this.queryColumns.add(" count(receiver_zip) count_receiver_zip");
    }

    public void addSumReceiverZipQueryColumn() {
        this.queryColumns.add(" sum(receiver_zip) sum_receiver_zip");
    }

    public void addReceiverMobileQueryColumn() {
        this.queryColumns.add("receiver_mobile");
    }

    public void addMaxReceiverMobileQueryColumn() {
        this.queryColumns.add("max(receiver_mobile) max_receiver_mobile");
    }

    public void addMinReceiverMobileQueryColumn() {
        this.queryColumns.add("min(receiver_mobile) min_receiver_mobile");
    }

    public void addAvgReceiverMobileQueryColumn() {
        this.queryColumns.add(" avg(receiver_mobile) avg_receiver_mobile");
    }

    public void addCountReceiverMobileQueryColumn() {
        this.queryColumns.add(" count(receiver_mobile) count_receiver_mobile");
    }

    public void addSumReceiverMobileQueryColumn() {
        this.queryColumns.add(" sum(receiver_mobile) sum_receiver_mobile");
    }

    public void addReceiverPhoneQueryColumn() {
        this.queryColumns.add("receiver_phone");
    }

    public void addMaxReceiverPhoneQueryColumn() {
        this.queryColumns.add("max(receiver_phone) max_receiver_phone");
    }

    public void addMinReceiverPhoneQueryColumn() {
        this.queryColumns.add("min(receiver_phone) min_receiver_phone");
    }

    public void addAvgReceiverPhoneQueryColumn() {
        this.queryColumns.add(" avg(receiver_phone) avg_receiver_phone");
    }

    public void addCountReceiverPhoneQueryColumn() {
        this.queryColumns.add(" count(receiver_phone) count_receiver_phone");
    }

    public void addSumReceiverPhoneQueryColumn() {
        this.queryColumns.add(" sum(receiver_phone) sum_receiver_phone");
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

        public Criteria andReceiverIdTbIsNull() {
            addCriterion("receiver_id_tb is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbIsNotNull() {
            addCriterion("receiver_id_tb is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbEqualTo(Long value) {
            addCriterion("receiver_id_tb =", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotEqualTo(Long value) {
            addCriterion("receiver_id_tb <>", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbGreaterThan(Long value) {
            addCriterion("receiver_id_tb >", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_tb >=", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbLessThan(Long value) {
            addCriterion("receiver_id_tb <", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_tb <=", value, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbIn(List<Long> values) {
            addCriterion("receiver_id_tb in", values, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotIn(List<Long> values) {
            addCriterion("receiver_id_tb not in", values, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbBetween(Long value1, Long value2) {
            addCriterion("receiver_id_tb between", value1, value2, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andReceiverIdTbNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_tb not between", value1, value2, "receiverIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbIsNull() {
            addCriterion("user_id_tb is null");
            return (Criteria) this;
        }

        public Criteria andUserIdTbIsNotNull() {
            addCriterion("user_id_tb is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdTbEqualTo(Long value) {
            addCriterion("user_id_tb =", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotEqualTo(Long value) {
            addCriterion("user_id_tb <>", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbGreaterThan(Long value) {
            addCriterion("user_id_tb >", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_tb >=", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbLessThan(Long value) {
            addCriterion("user_id_tb <", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbLessThanOrEqualTo(Long value) {
            addCriterion("user_id_tb <=", value, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbIn(List<Long> values) {
            addCriterion("user_id_tb in", values, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotIn(List<Long> values) {
            addCriterion("user_id_tb not in", values, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbBetween(Long value1, Long value2) {
            addCriterion("user_id_tb between", value1, value2, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andUserIdTbNotBetween(Long value1, Long value2) {
            addCriterion("user_id_tb not between", value1, value2, "userIdTb");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryIsNull() {
            addCriterion("receiver_country is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryIsNotNull() {
            addCriterion("receiver_country is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryEqualTo(String value) {
            addCriterion("receiver_country =", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryNotEqualTo(String value) {
            addCriterion("receiver_country <>", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryGreaterThan(String value) {
            addCriterion("receiver_country >", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_country >=", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryLessThan(String value) {
            addCriterion("receiver_country <", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryLessThanOrEqualTo(String value) {
            addCriterion("receiver_country <=", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryLike(String value) {
            addCriterion("receiver_country like", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryNotLike(String value) {
            addCriterion("receiver_country not like", value, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryIn(List<String> values) {
            addCriterion("receiver_country in", values, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryNotIn(List<String> values) {
            addCriterion("receiver_country not in", values, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryBetween(String value1, String value2) {
            addCriterion("receiver_country between", value1, value2, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverCountryNotBetween(String value1, String value2) {
            addCriterion("receiver_country not between", value1, value2, "receiverCountry");
            return (Criteria) this;
        }

        public Criteria andReceiverStateIsNull() {
            addCriterion("receiver_state is null");
            return (Criteria) this;
        }

        public Criteria andReceiverStateIsNotNull() {
            addCriterion("receiver_state is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverStateEqualTo(String value) {
            addCriterion("receiver_state =", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateNotEqualTo(String value) {
            addCriterion("receiver_state <>", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateGreaterThan(String value) {
            addCriterion("receiver_state >", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_state >=", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateLessThan(String value) {
            addCriterion("receiver_state <", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateLessThanOrEqualTo(String value) {
            addCriterion("receiver_state <=", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateLike(String value) {
            addCriterion("receiver_state like", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateNotLike(String value) {
            addCriterion("receiver_state not like", value, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateIn(List<String> values) {
            addCriterion("receiver_state in", values, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateNotIn(List<String> values) {
            addCriterion("receiver_state not in", values, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateBetween(String value1, String value2) {
            addCriterion("receiver_state between", value1, value2, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverStateNotBetween(String value1, String value2) {
            addCriterion("receiver_state not between", value1, value2, "receiverState");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNull() {
            addCriterion("receiver_city is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNotNull() {
            addCriterion("receiver_city is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityEqualTo(String value) {
            addCriterion("receiver_city =", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotEqualTo(String value) {
            addCriterion("receiver_city <>", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThan(String value) {
            addCriterion("receiver_city >", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_city >=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThan(String value) {
            addCriterion("receiver_city <", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThanOrEqualTo(String value) {
            addCriterion("receiver_city <=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLike(String value) {
            addCriterion("receiver_city like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotLike(String value) {
            addCriterion("receiver_city not like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIn(List<String> values) {
            addCriterion("receiver_city in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotIn(List<String> values) {
            addCriterion("receiver_city not in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityBetween(String value1, String value2) {
            addCriterion("receiver_city between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotBetween(String value1, String value2) {
            addCriterion("receiver_city not between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictIsNull() {
            addCriterion("receiver_district is null");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictIsNotNull() {
            addCriterion("receiver_district is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictEqualTo(String value) {
            addCriterion("receiver_district =", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictNotEqualTo(String value) {
            addCriterion("receiver_district <>", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictGreaterThan(String value) {
            addCriterion("receiver_district >", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_district >=", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictLessThan(String value) {
            addCriterion("receiver_district <", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictLessThanOrEqualTo(String value) {
            addCriterion("receiver_district <=", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictLike(String value) {
            addCriterion("receiver_district like", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictNotLike(String value) {
            addCriterion("receiver_district not like", value, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictIn(List<String> values) {
            addCriterion("receiver_district in", values, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictNotIn(List<String> values) {
            addCriterion("receiver_district not in", values, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictBetween(String value1, String value2) {
            addCriterion("receiver_district between", value1, value2, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverDistrictNotBetween(String value1, String value2) {
            addCriterion("receiver_district not between", value1, value2, "receiverDistrict");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIsNull() {
            addCriterion("receiver_town is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIsNotNull() {
            addCriterion("receiver_town is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTownEqualTo(String value) {
            addCriterion("receiver_town =", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotEqualTo(String value) {
            addCriterion("receiver_town <>", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownGreaterThan(String value) {
            addCriterion("receiver_town >", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_town >=", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLessThan(String value) {
            addCriterion("receiver_town <", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLessThanOrEqualTo(String value) {
            addCriterion("receiver_town <=", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLike(String value) {
            addCriterion("receiver_town like", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotLike(String value) {
            addCriterion("receiver_town not like", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIn(List<String> values) {
            addCriterion("receiver_town in", values, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotIn(List<String> values) {
            addCriterion("receiver_town not in", values, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownBetween(String value1, String value2) {
            addCriterion("receiver_town between", value1, value2, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotBetween(String value1, String value2) {
            addCriterion("receiver_town not between", value1, value2, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIsNull() {
            addCriterion("receiver_zip is null");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIsNotNull() {
            addCriterion("receiver_zip is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverZipEqualTo(String value) {
            addCriterion("receiver_zip =", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotEqualTo(String value) {
            addCriterion("receiver_zip <>", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipGreaterThan(String value) {
            addCriterion("receiver_zip >", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_zip >=", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipLessThan(String value) {
            addCriterion("receiver_zip <", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipLessThanOrEqualTo(String value) {
            addCriterion("receiver_zip <=", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipLike(String value) {
            addCriterion("receiver_zip like", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotLike(String value) {
            addCriterion("receiver_zip not like", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIn(List<String> values) {
            addCriterion("receiver_zip in", values, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotIn(List<String> values) {
            addCriterion("receiver_zip not in", values, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipBetween(String value1, String value2) {
            addCriterion("receiver_zip between", value1, value2, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotBetween(String value1, String value2) {
            addCriterion("receiver_zip not between", value1, value2, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
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