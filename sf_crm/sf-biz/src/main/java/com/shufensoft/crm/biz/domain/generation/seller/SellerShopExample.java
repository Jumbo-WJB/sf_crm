package com.shufensoft.crm.biz.domain.generation.seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerShopExample {
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

    public SellerShopExample() {
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

    public void addShopNameQueryColumn() {
        this.queryColumns.add("shop_name");
    }

    public void addMaxShopNameQueryColumn() {
        this.queryColumns.add("max(shop_name) max_shop_name");
    }

    public void addMinShopNameQueryColumn() {
        this.queryColumns.add("min(shop_name) min_shop_name");
    }

    public void addAvgShopNameQueryColumn() {
        this.queryColumns.add(" avg(shop_name) avg_shop_name");
    }

    public void addCountShopNameQueryColumn() {
        this.queryColumns.add(" count(shop_name) count_shop_name");
    }

    public void addSumShopNameQueryColumn() {
        this.queryColumns.add(" sum(shop_name) sum_shop_name");
    }

    public void addShopTypeQueryColumn() {
        this.queryColumns.add("shop_type");
    }

    public void addMaxShopTypeQueryColumn() {
        this.queryColumns.add("max(shop_type) max_shop_type");
    }

    public void addMinShopTypeQueryColumn() {
        this.queryColumns.add("min(shop_type) min_shop_type");
    }

    public void addAvgShopTypeQueryColumn() {
        this.queryColumns.add(" avg(shop_type) avg_shop_type");
    }

    public void addCountShopTypeQueryColumn() {
        this.queryColumns.add(" count(shop_type) count_shop_type");
    }

    public void addSumShopTypeQueryColumn() {
        this.queryColumns.add(" sum(shop_type) sum_shop_type");
    }

    public void addAccessTypeQueryColumn() {
        this.queryColumns.add("access_type");
    }

    public void addMaxAccessTypeQueryColumn() {
        this.queryColumns.add("max(access_type) max_access_type");
    }

    public void addMinAccessTypeQueryColumn() {
        this.queryColumns.add("min(access_type) min_access_type");
    }

    public void addAvgAccessTypeQueryColumn() {
        this.queryColumns.add(" avg(access_type) avg_access_type");
    }

    public void addCountAccessTypeQueryColumn() {
        this.queryColumns.add(" count(access_type) count_access_type");
    }

    public void addSumAccessTypeQueryColumn() {
        this.queryColumns.add(" sum(access_type) sum_access_type");
    }

    public void addShopAppIdQueryColumn() {
        this.queryColumns.add("shop_app_id");
    }

    public void addMaxShopAppIdQueryColumn() {
        this.queryColumns.add("max(shop_app_id) max_shop_app_id");
    }

    public void addMinShopAppIdQueryColumn() {
        this.queryColumns.add("min(shop_app_id) min_shop_app_id");
    }

    public void addAvgShopAppIdQueryColumn() {
        this.queryColumns.add(" avg(shop_app_id) avg_shop_app_id");
    }

    public void addCountShopAppIdQueryColumn() {
        this.queryColumns.add(" count(shop_app_id) count_shop_app_id");
    }

    public void addSumShopAppIdQueryColumn() {
        this.queryColumns.add(" sum(shop_app_id) sum_shop_app_id");
    }

    public void addShopAppSecretQueryColumn() {
        this.queryColumns.add("shop_app_secret");
    }

    public void addMaxShopAppSecretQueryColumn() {
        this.queryColumns.add("max(shop_app_secret) max_shop_app_secret");
    }

    public void addMinShopAppSecretQueryColumn() {
        this.queryColumns.add("min(shop_app_secret) min_shop_app_secret");
    }

    public void addAvgShopAppSecretQueryColumn() {
        this.queryColumns.add(" avg(shop_app_secret) avg_shop_app_secret");
    }

    public void addCountShopAppSecretQueryColumn() {
        this.queryColumns.add(" count(shop_app_secret) count_shop_app_secret");
    }

    public void addSumShopAppSecretQueryColumn() {
        this.queryColumns.add(" sum(shop_app_secret) sum_shop_app_secret");
    }

    public void addShopAccessTokenQueryColumn() {
        this.queryColumns.add("shop_access_token");
    }

    public void addMaxShopAccessTokenQueryColumn() {
        this.queryColumns.add("max(shop_access_token) max_shop_access_token");
    }

    public void addMinShopAccessTokenQueryColumn() {
        this.queryColumns.add("min(shop_access_token) min_shop_access_token");
    }

    public void addAvgShopAccessTokenQueryColumn() {
        this.queryColumns.add(" avg(shop_access_token) avg_shop_access_token");
    }

    public void addCountShopAccessTokenQueryColumn() {
        this.queryColumns.add(" count(shop_access_token) count_shop_access_token");
    }

    public void addSumShopAccessTokenQueryColumn() {
        this.queryColumns.add(" sum(shop_access_token) sum_shop_access_token");
    }

    public void addShopRefreshTokenQueryColumn() {
        this.queryColumns.add("shop_refresh_token");
    }

    public void addMaxShopRefreshTokenQueryColumn() {
        this.queryColumns.add("max(shop_refresh_token) max_shop_refresh_token");
    }

    public void addMinShopRefreshTokenQueryColumn() {
        this.queryColumns.add("min(shop_refresh_token) min_shop_refresh_token");
    }

    public void addAvgShopRefreshTokenQueryColumn() {
        this.queryColumns.add(" avg(shop_refresh_token) avg_shop_refresh_token");
    }

    public void addCountShopRefreshTokenQueryColumn() {
        this.queryColumns.add(" count(shop_refresh_token) count_shop_refresh_token");
    }

    public void addSumShopRefreshTokenQueryColumn() {
        this.queryColumns.add(" sum(shop_refresh_token) sum_shop_refresh_token");
    }

    public void addShopTokenExpireQueryColumn() {
        this.queryColumns.add("shop_token_expire");
    }

    public void addMaxShopTokenExpireQueryColumn() {
        this.queryColumns.add("max(shop_token_expire) max_shop_token_expire");
    }

    public void addMinShopTokenExpireQueryColumn() {
        this.queryColumns.add("min(shop_token_expire) min_shop_token_expire");
    }

    public void addAvgShopTokenExpireQueryColumn() {
        this.queryColumns.add(" avg(shop_token_expire) avg_shop_token_expire");
    }

    public void addCountShopTokenExpireQueryColumn() {
        this.queryColumns.add(" count(shop_token_expire) count_shop_token_expire");
    }

    public void addSumShopTokenExpireQueryColumn() {
        this.queryColumns.add(" sum(shop_token_expire) sum_shop_token_expire");
    }

    public void addPolySpireUrlQueryColumn() {
        this.queryColumns.add("poly_spire_url");
    }

    public void addMaxPolySpireUrlQueryColumn() {
        this.queryColumns.add("max(poly_spire_url) max_poly_spire_url");
    }

    public void addMinPolySpireUrlQueryColumn() {
        this.queryColumns.add("min(poly_spire_url) min_poly_spire_url");
    }

    public void addAvgPolySpireUrlQueryColumn() {
        this.queryColumns.add(" avg(poly_spire_url) avg_poly_spire_url");
    }

    public void addCountPolySpireUrlQueryColumn() {
        this.queryColumns.add(" count(poly_spire_url) count_poly_spire_url");
    }

    public void addSumPolySpireUrlQueryColumn() {
        this.queryColumns.add(" sum(poly_spire_url) sum_poly_spire_url");
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(String value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(String value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(String value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(String value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(String value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLike(String value) {
            addCriterion("shop_type like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotLike(String value) {
            addCriterion("shop_type not like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<String> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<String> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(String value1, String value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(String value1, String value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNull() {
            addCriterion("access_type is null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNotNull() {
            addCriterion("access_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeEqualTo(String value) {
            addCriterion("access_type =", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotEqualTo(String value) {
            addCriterion("access_type <>", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThan(String value) {
            addCriterion("access_type >", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("access_type >=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThan(String value) {
            addCriterion("access_type <", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThanOrEqualTo(String value) {
            addCriterion("access_type <=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLike(String value) {
            addCriterion("access_type like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotLike(String value) {
            addCriterion("access_type not like", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIn(List<String> values) {
            addCriterion("access_type in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotIn(List<String> values) {
            addCriterion("access_type not in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeBetween(String value1, String value2) {
            addCriterion("access_type between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotBetween(String value1, String value2) {
            addCriterion("access_type not between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andShopAppIdIsNull() {
            addCriterion("shop_app_id is null");
            return (Criteria) this;
        }

        public Criteria andShopAppIdIsNotNull() {
            addCriterion("shop_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopAppIdEqualTo(String value) {
            addCriterion("shop_app_id =", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdNotEqualTo(String value) {
            addCriterion("shop_app_id <>", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdGreaterThan(String value) {
            addCriterion("shop_app_id >", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_app_id >=", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdLessThan(String value) {
            addCriterion("shop_app_id <", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdLessThanOrEqualTo(String value) {
            addCriterion("shop_app_id <=", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdLike(String value) {
            addCriterion("shop_app_id like", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdNotLike(String value) {
            addCriterion("shop_app_id not like", value, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdIn(List<String> values) {
            addCriterion("shop_app_id in", values, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdNotIn(List<String> values) {
            addCriterion("shop_app_id not in", values, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdBetween(String value1, String value2) {
            addCriterion("shop_app_id between", value1, value2, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppIdNotBetween(String value1, String value2) {
            addCriterion("shop_app_id not between", value1, value2, "shopAppId");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretIsNull() {
            addCriterion("shop_app_secret is null");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretIsNotNull() {
            addCriterion("shop_app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretEqualTo(String value) {
            addCriterion("shop_app_secret =", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretNotEqualTo(String value) {
            addCriterion("shop_app_secret <>", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretGreaterThan(String value) {
            addCriterion("shop_app_secret >", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("shop_app_secret >=", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretLessThan(String value) {
            addCriterion("shop_app_secret <", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretLessThanOrEqualTo(String value) {
            addCriterion("shop_app_secret <=", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretLike(String value) {
            addCriterion("shop_app_secret like", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretNotLike(String value) {
            addCriterion("shop_app_secret not like", value, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretIn(List<String> values) {
            addCriterion("shop_app_secret in", values, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretNotIn(List<String> values) {
            addCriterion("shop_app_secret not in", values, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretBetween(String value1, String value2) {
            addCriterion("shop_app_secret between", value1, value2, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAppSecretNotBetween(String value1, String value2) {
            addCriterion("shop_app_secret not between", value1, value2, "shopAppSecret");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenIsNull() {
            addCriterion("shop_access_token is null");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenIsNotNull() {
            addCriterion("shop_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenEqualTo(String value) {
            addCriterion("shop_access_token =", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenNotEqualTo(String value) {
            addCriterion("shop_access_token <>", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenGreaterThan(String value) {
            addCriterion("shop_access_token >", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("shop_access_token >=", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenLessThan(String value) {
            addCriterion("shop_access_token <", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("shop_access_token <=", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenLike(String value) {
            addCriterion("shop_access_token like", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenNotLike(String value) {
            addCriterion("shop_access_token not like", value, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenIn(List<String> values) {
            addCriterion("shop_access_token in", values, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenNotIn(List<String> values) {
            addCriterion("shop_access_token not in", values, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenBetween(String value1, String value2) {
            addCriterion("shop_access_token between", value1, value2, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopAccessTokenNotBetween(String value1, String value2) {
            addCriterion("shop_access_token not between", value1, value2, "shopAccessToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenIsNull() {
            addCriterion("shop_refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenIsNotNull() {
            addCriterion("shop_refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenEqualTo(String value) {
            addCriterion("shop_refresh_token =", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenNotEqualTo(String value) {
            addCriterion("shop_refresh_token <>", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenGreaterThan(String value) {
            addCriterion("shop_refresh_token >", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("shop_refresh_token >=", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenLessThan(String value) {
            addCriterion("shop_refresh_token <", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("shop_refresh_token <=", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenLike(String value) {
            addCriterion("shop_refresh_token like", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenNotLike(String value) {
            addCriterion("shop_refresh_token not like", value, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenIn(List<String> values) {
            addCriterion("shop_refresh_token in", values, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenNotIn(List<String> values) {
            addCriterion("shop_refresh_token not in", values, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenBetween(String value1, String value2) {
            addCriterion("shop_refresh_token between", value1, value2, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("shop_refresh_token not between", value1, value2, "shopRefreshToken");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireIsNull() {
            addCriterion("shop_token_expire is null");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireIsNotNull() {
            addCriterion("shop_token_expire is not null");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireEqualTo(Date value) {
            addCriterion("shop_token_expire =", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireNotEqualTo(Date value) {
            addCriterion("shop_token_expire <>", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireGreaterThan(Date value) {
            addCriterion("shop_token_expire >", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireGreaterThanOrEqualTo(Date value) {
            addCriterion("shop_token_expire >=", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireLessThan(Date value) {
            addCriterion("shop_token_expire <", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireLessThanOrEqualTo(Date value) {
            addCriterion("shop_token_expire <=", value, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireIn(List<Date> values) {
            addCriterion("shop_token_expire in", values, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireNotIn(List<Date> values) {
            addCriterion("shop_token_expire not in", values, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireBetween(Date value1, Date value2) {
            addCriterion("shop_token_expire between", value1, value2, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andShopTokenExpireNotBetween(Date value1, Date value2) {
            addCriterion("shop_token_expire not between", value1, value2, "shopTokenExpire");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlIsNull() {
            addCriterion("poly_spire_url is null");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlIsNotNull() {
            addCriterion("poly_spire_url is not null");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlEqualTo(String value) {
            addCriterion("poly_spire_url =", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlNotEqualTo(String value) {
            addCriterion("poly_spire_url <>", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlGreaterThan(String value) {
            addCriterion("poly_spire_url >", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlGreaterThanOrEqualTo(String value) {
            addCriterion("poly_spire_url >=", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlLessThan(String value) {
            addCriterion("poly_spire_url <", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlLessThanOrEqualTo(String value) {
            addCriterion("poly_spire_url <=", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlLike(String value) {
            addCriterion("poly_spire_url like", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlNotLike(String value) {
            addCriterion("poly_spire_url not like", value, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlIn(List<String> values) {
            addCriterion("poly_spire_url in", values, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlNotIn(List<String> values) {
            addCriterion("poly_spire_url not in", values, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlBetween(String value1, String value2) {
            addCriterion("poly_spire_url between", value1, value2, "polySpireUrl");
            return (Criteria) this;
        }

        public Criteria andPolySpireUrlNotBetween(String value1, String value2) {
            addCriterion("poly_spire_url not between", value1, value2, "polySpireUrl");
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