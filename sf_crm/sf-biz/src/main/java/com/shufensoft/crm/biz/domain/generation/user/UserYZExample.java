package com.shufensoft.crm.biz.domain.generation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserYZExample {
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

    public UserYZExample() {
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

    public void addCountDistinctIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT id) count_distinct_id");
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

    public void addCountDistinctGmtCreatedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT gmt_created) count_distinct_gmt_created");
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

    public void addCountDistinctGmtModifiedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT gmt_modified) count_distinct_gmt_modified");
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

    public void addCountDistinctCreatedByQueryColumn() {
        this.queryColumns.add(" count( DISTINCT created_by) count_distinct_created_by");
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

    public void addCountDistinctModifiedByQueryColumn() {
        this.queryColumns.add(" count( DISTINCT modified_by) count_distinct_modified_by");
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

    public void addCountDistinctIsDeletedQueryColumn() {
        this.queryColumns.add(" count( DISTINCT is_deleted) count_distinct_is_deleted");
    }

    public void addSumIsDeletedQueryColumn() {
        this.queryColumns.add(" sum(is_deleted) sum_is_deleted");
    }

    public void addUserIdYzQueryColumn() {
        this.queryColumns.add("user_id_yz");
    }

    public void addMaxUserIdYzQueryColumn() {
        this.queryColumns.add("max(user_id_yz) max_user_id_yz");
    }

    public void addMinUserIdYzQueryColumn() {
        this.queryColumns.add("min(user_id_yz) min_user_id_yz");
    }

    public void addAvgUserIdYzQueryColumn() {
        this.queryColumns.add(" avg(user_id_yz) avg_user_id_yz");
    }

    public void addCountUserIdYzQueryColumn() {
        this.queryColumns.add(" count(user_id_yz) count_user_id_yz");
    }

    public void addCountDistinctUserIdYzQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_id_yz) count_distinct_user_id_yz");
    }

    public void addSumUserIdYzQueryColumn() {
        this.queryColumns.add(" sum(user_id_yz) sum_user_id_yz");
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

    public void addCountDistinctSellerIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT seller_id) count_distinct_seller_id");
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

    public void addCountDistinctShopIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT shop_id) count_distinct_shop_id");
    }

    public void addSumShopIdQueryColumn() {
        this.queryColumns.add(" sum(shop_id) sum_shop_id");
    }

    public void addWeixinUserIdQueryColumn() {
        this.queryColumns.add("weixin_user_id");
    }

    public void addMaxWeixinUserIdQueryColumn() {
        this.queryColumns.add("max(weixin_user_id) max_weixin_user_id");
    }

    public void addMinWeixinUserIdQueryColumn() {
        this.queryColumns.add("min(weixin_user_id) min_weixin_user_id");
    }

    public void addAvgWeixinUserIdQueryColumn() {
        this.queryColumns.add(" avg(weixin_user_id) avg_weixin_user_id");
    }

    public void addCountWeixinUserIdQueryColumn() {
        this.queryColumns.add(" count(weixin_user_id) count_weixin_user_id");
    }

    public void addCountDistinctWeixinUserIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT weixin_user_id) count_distinct_weixin_user_id");
    }

    public void addSumWeixinUserIdQueryColumn() {
        this.queryColumns.add(" sum(weixin_user_id) sum_weixin_user_id");
    }

    public void addBuyerAreaQueryColumn() {
        this.queryColumns.add("buyer_area");
    }

    public void addMaxBuyerAreaQueryColumn() {
        this.queryColumns.add("max(buyer_area) max_buyer_area");
    }

    public void addMinBuyerAreaQueryColumn() {
        this.queryColumns.add("min(buyer_area) min_buyer_area");
    }

    public void addAvgBuyerAreaQueryColumn() {
        this.queryColumns.add(" avg(buyer_area) avg_buyer_area");
    }

    public void addCountBuyerAreaQueryColumn() {
        this.queryColumns.add(" count(buyer_area) count_buyer_area");
    }

    public void addCountDistinctBuyerAreaQueryColumn() {
        this.queryColumns.add(" count( DISTINCT buyer_area) count_distinct_buyer_area");
    }

    public void addSumBuyerAreaQueryColumn() {
        this.queryColumns.add(" sum(buyer_area) sum_buyer_area");
    }

    public void addBuyerIdQueryColumn() {
        this.queryColumns.add("buyer_id");
    }

    public void addMaxBuyerIdQueryColumn() {
        this.queryColumns.add("max(buyer_id) max_buyer_id");
    }

    public void addMinBuyerIdQueryColumn() {
        this.queryColumns.add("min(buyer_id) min_buyer_id");
    }

    public void addAvgBuyerIdQueryColumn() {
        this.queryColumns.add(" avg(buyer_id) avg_buyer_id");
    }

    public void addCountBuyerIdQueryColumn() {
        this.queryColumns.add(" count(buyer_id) count_buyer_id");
    }

    public void addCountDistinctBuyerIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT buyer_id) count_distinct_buyer_id");
    }

    public void addSumBuyerIdQueryColumn() {
        this.queryColumns.add(" sum(buyer_id) sum_buyer_id");
    }

    public void addBuyerNickQueryColumn() {
        this.queryColumns.add("buyer_nick");
    }

    public void addMaxBuyerNickQueryColumn() {
        this.queryColumns.add("max(buyer_nick) max_buyer_nick");
    }

    public void addMinBuyerNickQueryColumn() {
        this.queryColumns.add("min(buyer_nick) min_buyer_nick");
    }

    public void addAvgBuyerNickQueryColumn() {
        this.queryColumns.add(" avg(buyer_nick) avg_buyer_nick");
    }

    public void addCountBuyerNickQueryColumn() {
        this.queryColumns.add(" count(buyer_nick) count_buyer_nick");
    }

    public void addCountDistinctBuyerNickQueryColumn() {
        this.queryColumns.add(" count( DISTINCT buyer_nick) count_distinct_buyer_nick");
    }

    public void addSumBuyerNickQueryColumn() {
        this.queryColumns.add(" sum(buyer_nick) sum_buyer_nick");
    }

    public void addOpenidQueryColumn() {
        this.queryColumns.add("openid");
    }

    public void addMaxOpenidQueryColumn() {
        this.queryColumns.add("max(openid) max_openid");
    }

    public void addMinOpenidQueryColumn() {
        this.queryColumns.add("min(openid) min_openid");
    }

    public void addAvgOpenidQueryColumn() {
        this.queryColumns.add(" avg(openid) avg_openid");
    }

    public void addCountOpenidQueryColumn() {
        this.queryColumns.add(" count(openid) count_openid");
    }

    public void addCountDistinctOpenidQueryColumn() {
        this.queryColumns.add(" count( DISTINCT openid) count_distinct_openid");
    }

    public void addSumOpenidQueryColumn() {
        this.queryColumns.add(" sum(openid) sum_openid");
    }

    public void addNickNameQueryColumn() {
        this.queryColumns.add("nick_name");
    }

    public void addMaxNickNameQueryColumn() {
        this.queryColumns.add("max(nick_name) max_nick_name");
    }

    public void addMinNickNameQueryColumn() {
        this.queryColumns.add("min(nick_name) min_nick_name");
    }

    public void addAvgNickNameQueryColumn() {
        this.queryColumns.add(" avg(nick_name) avg_nick_name");
    }

    public void addCountNickNameQueryColumn() {
        this.queryColumns.add(" count(nick_name) count_nick_name");
    }

    public void addCountDistinctNickNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT nick_name) count_distinct_nick_name");
    }

    public void addSumNickNameQueryColumn() {
        this.queryColumns.add(" sum(nick_name) sum_nick_name");
    }

    public void addSexQueryColumn() {
        this.queryColumns.add("sex");
    }

    public void addMaxSexQueryColumn() {
        this.queryColumns.add("max(sex) max_sex");
    }

    public void addMinSexQueryColumn() {
        this.queryColumns.add("min(sex) min_sex");
    }

    public void addAvgSexQueryColumn() {
        this.queryColumns.add(" avg(sex) avg_sex");
    }

    public void addCountSexQueryColumn() {
        this.queryColumns.add(" count(sex) count_sex");
    }

    public void addCountDistinctSexQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sex) count_distinct_sex");
    }

    public void addSumSexQueryColumn() {
        this.queryColumns.add(" sum(sex) sum_sex");
    }

    public void addCityQueryColumn() {
        this.queryColumns.add("city");
    }

    public void addMaxCityQueryColumn() {
        this.queryColumns.add("max(city) max_city");
    }

    public void addMinCityQueryColumn() {
        this.queryColumns.add("min(city) min_city");
    }

    public void addAvgCityQueryColumn() {
        this.queryColumns.add(" avg(city) avg_city");
    }

    public void addCountCityQueryColumn() {
        this.queryColumns.add(" count(city) count_city");
    }

    public void addCountDistinctCityQueryColumn() {
        this.queryColumns.add(" count( DISTINCT city) count_distinct_city");
    }

    public void addSumCityQueryColumn() {
        this.queryColumns.add(" sum(city) sum_city");
    }

    public void addProvinceQueryColumn() {
        this.queryColumns.add("province");
    }

    public void addMaxProvinceQueryColumn() {
        this.queryColumns.add("max(province) max_province");
    }

    public void addMinProvinceQueryColumn() {
        this.queryColumns.add("min(province) min_province");
    }

    public void addAvgProvinceQueryColumn() {
        this.queryColumns.add(" avg(province) avg_province");
    }

    public void addCountProvinceQueryColumn() {
        this.queryColumns.add(" count(province) count_province");
    }

    public void addCountDistinctProvinceQueryColumn() {
        this.queryColumns.add(" count( DISTINCT province) count_distinct_province");
    }

    public void addSumProvinceQueryColumn() {
        this.queryColumns.add(" sum(province) sum_province");
    }

    public void addHeadimgurlQueryColumn() {
        this.queryColumns.add("headimgurl");
    }

    public void addMaxHeadimgurlQueryColumn() {
        this.queryColumns.add("max(headimgurl) max_headimgurl");
    }

    public void addMinHeadimgurlQueryColumn() {
        this.queryColumns.add("min(headimgurl) min_headimgurl");
    }

    public void addAvgHeadimgurlQueryColumn() {
        this.queryColumns.add(" avg(headimgurl) avg_headimgurl");
    }

    public void addCountHeadimgurlQueryColumn() {
        this.queryColumns.add(" count(headimgurl) count_headimgurl");
    }

    public void addCountDistinctHeadimgurlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT headimgurl) count_distinct_headimgurl");
    }

    public void addSumHeadimgurlQueryColumn() {
        this.queryColumns.add(" sum(headimgurl) sum_headimgurl");
    }

    public void addSubscribeTimeQueryColumn() {
        this.queryColumns.add("subscribe_time");
    }

    public void addMaxSubscribeTimeQueryColumn() {
        this.queryColumns.add("max(subscribe_time) max_subscribe_time");
    }

    public void addMinSubscribeTimeQueryColumn() {
        this.queryColumns.add("min(subscribe_time) min_subscribe_time");
    }

    public void addAvgSubscribeTimeQueryColumn() {
        this.queryColumns.add(" avg(subscribe_time) avg_subscribe_time");
    }

    public void addCountSubscribeTimeQueryColumn() {
        this.queryColumns.add(" count(subscribe_time) count_subscribe_time");
    }

    public void addCountDistinctSubscribeTimeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT subscribe_time) count_distinct_subscribe_time");
    }

    public void addSumSubscribeTimeQueryColumn() {
        this.queryColumns.add(" sum(subscribe_time) sum_subscribe_time");
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

        public Criteria andUserIdYzIsNull() {
            addCriterion("user_id_yz is null");
            return (Criteria) this;
        }

        public Criteria andUserIdYzIsNotNull() {
            addCriterion("user_id_yz is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdYzEqualTo(Long value) {
            addCriterion("user_id_yz =", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotEqualTo(Long value) {
            addCriterion("user_id_yz <>", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzGreaterThan(Long value) {
            addCriterion("user_id_yz >", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_yz >=", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzLessThan(Long value) {
            addCriterion("user_id_yz <", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzLessThanOrEqualTo(Long value) {
            addCriterion("user_id_yz <=", value, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzIn(List<Long> values) {
            addCriterion("user_id_yz in", values, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotIn(List<Long> values) {
            addCriterion("user_id_yz not in", values, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzBetween(Long value1, Long value2) {
            addCriterion("user_id_yz between", value1, value2, "userIdYz");
            return (Criteria) this;
        }

        public Criteria andUserIdYzNotBetween(Long value1, Long value2) {
            addCriterion("user_id_yz not between", value1, value2, "userIdYz");
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

        public Criteria andWeixinUserIdIsNull() {
            addCriterion("weixin_user_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdIsNotNull() {
            addCriterion("weixin_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdEqualTo(Long value) {
            addCriterion("weixin_user_id =", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdNotEqualTo(Long value) {
            addCriterion("weixin_user_id <>", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdGreaterThan(Long value) {
            addCriterion("weixin_user_id >", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("weixin_user_id >=", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdLessThan(Long value) {
            addCriterion("weixin_user_id <", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdLessThanOrEqualTo(Long value) {
            addCriterion("weixin_user_id <=", value, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdIn(List<Long> values) {
            addCriterion("weixin_user_id in", values, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdNotIn(List<Long> values) {
            addCriterion("weixin_user_id not in", values, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdBetween(Long value1, Long value2) {
            addCriterion("weixin_user_id between", value1, value2, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andWeixinUserIdNotBetween(Long value1, Long value2) {
            addCriterion("weixin_user_id not between", value1, value2, "weixinUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaIsNull() {
            addCriterion("buyer_area is null");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaIsNotNull() {
            addCriterion("buyer_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaEqualTo(String value) {
            addCriterion("buyer_area =", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaNotEqualTo(String value) {
            addCriterion("buyer_area <>", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaGreaterThan(String value) {
            addCriterion("buyer_area >", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_area >=", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaLessThan(String value) {
            addCriterion("buyer_area <", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaLessThanOrEqualTo(String value) {
            addCriterion("buyer_area <=", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaLike(String value) {
            addCriterion("buyer_area like", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaNotLike(String value) {
            addCriterion("buyer_area not like", value, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaIn(List<String> values) {
            addCriterion("buyer_area in", values, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaNotIn(List<String> values) {
            addCriterion("buyer_area not in", values, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaBetween(String value1, String value2) {
            addCriterion("buyer_area between", value1, value2, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerAreaNotBetween(String value1, String value2) {
            addCriterion("buyer_area not between", value1, value2, "buyerArea");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Long value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNull() {
            addCriterion("buyer_nick is null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIsNotNull() {
            addCriterion("buyer_nick is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerNickEqualTo(String value) {
            addCriterion("buyer_nick =", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotEqualTo(String value) {
            addCriterion("buyer_nick <>", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThan(String value) {
            addCriterion("buyer_nick >", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_nick >=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThan(String value) {
            addCriterion("buyer_nick <", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("buyer_nick <=", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickLike(String value) {
            addCriterion("buyer_nick like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotLike(String value) {
            addCriterion("buyer_nick not like", value, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickIn(List<String> values) {
            addCriterion("buyer_nick in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotIn(List<String> values) {
            addCriterion("buyer_nick not in", values, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickBetween(String value1, String value2) {
            addCriterion("buyer_nick between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andBuyerNickNotBetween(String value1, String value2) {
            addCriterion("buyer_nick not between", value1, value2, "buyerNick");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNull() {
            addCriterion("headimgurl is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIsNotNull() {
            addCriterion("headimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlEqualTo(String value) {
            addCriterion("headimgurl =", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotEqualTo(String value) {
            addCriterion("headimgurl <>", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThan(String value) {
            addCriterion("headimgurl >", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("headimgurl >=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThan(String value) {
            addCriterion("headimgurl <", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("headimgurl <=", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlLike(String value) {
            addCriterion("headimgurl like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotLike(String value) {
            addCriterion("headimgurl not like", value, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlIn(List<String> values) {
            addCriterion("headimgurl in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotIn(List<String> values) {
            addCriterion("headimgurl not in", values, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlBetween(String value1, String value2) {
            addCriterion("headimgurl between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("headimgurl not between", value1, value2, "headimgurl");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeIsNull() {
            addCriterion("subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeIsNotNull() {
            addCriterion("subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeEqualTo(Date value) {
            addCriterion("subscribe_time =", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotEqualTo(Date value) {
            addCriterion("subscribe_time <>", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeGreaterThan(Date value) {
            addCriterion("subscribe_time >", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("subscribe_time >=", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeLessThan(Date value) {
            addCriterion("subscribe_time <", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeLessThanOrEqualTo(Date value) {
            addCriterion("subscribe_time <=", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeIn(List<Date> values) {
            addCriterion("subscribe_time in", values, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotIn(List<Date> values) {
            addCriterion("subscribe_time not in", values, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeBetween(Date value1, Date value2) {
            addCriterion("subscribe_time between", value1, value2, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotBetween(Date value1, Date value2) {
            addCriterion("subscribe_time not between", value1, value2, "subscribeTime");
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