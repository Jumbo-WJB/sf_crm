package com.shufensoft.crm.biz.domain.generation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
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

    public UserExample() {
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

    public void addCountDistinctUserIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_id) count_distinct_user_id");
    }

    public void addSumUserIdQueryColumn() {
        this.queryColumns.add(" sum(user_id) sum_user_id");
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

    public void addCountDistinctUserIdTbQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_id_tb) count_distinct_user_id_tb");
    }

    public void addSumUserIdTbQueryColumn() {
        this.queryColumns.add(" sum(user_id_tb) sum_user_id_tb");
    }

    public void addUserIdJdQueryColumn() {
        this.queryColumns.add("user_id_jd");
    }

    public void addMaxUserIdJdQueryColumn() {
        this.queryColumns.add("max(user_id_jd) max_user_id_jd");
    }

    public void addMinUserIdJdQueryColumn() {
        this.queryColumns.add("min(user_id_jd) min_user_id_jd");
    }

    public void addAvgUserIdJdQueryColumn() {
        this.queryColumns.add(" avg(user_id_jd) avg_user_id_jd");
    }

    public void addCountUserIdJdQueryColumn() {
        this.queryColumns.add(" count(user_id_jd) count_user_id_jd");
    }

    public void addCountDistinctUserIdJdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_id_jd) count_distinct_user_id_jd");
    }

    public void addSumUserIdJdQueryColumn() {
        this.queryColumns.add(" sum(user_id_jd) sum_user_id_jd");
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

    public void addFirstSourceQueryColumn() {
        this.queryColumns.add("first_source");
    }

    public void addMaxFirstSourceQueryColumn() {
        this.queryColumns.add("max(first_source) max_first_source");
    }

    public void addMinFirstSourceQueryColumn() {
        this.queryColumns.add("min(first_source) min_first_source");
    }

    public void addAvgFirstSourceQueryColumn() {
        this.queryColumns.add(" avg(first_source) avg_first_source");
    }

    public void addCountFirstSourceQueryColumn() {
        this.queryColumns.add(" count(first_source) count_first_source");
    }

    public void addCountDistinctFirstSourceQueryColumn() {
        this.queryColumns.add(" count( DISTINCT first_source) count_distinct_first_source");
    }

    public void addSumFirstSourceQueryColumn() {
        this.queryColumns.add(" sum(first_source) sum_first_source");
    }

    public void addSourceQueryColumn() {
        this.queryColumns.add("source");
    }

    public void addMaxSourceQueryColumn() {
        this.queryColumns.add("max(source) max_source");
    }

    public void addMinSourceQueryColumn() {
        this.queryColumns.add("min(source) min_source");
    }

    public void addAvgSourceQueryColumn() {
        this.queryColumns.add(" avg(source) avg_source");
    }

    public void addCountSourceQueryColumn() {
        this.queryColumns.add(" count(source) count_source");
    }

    public void addCountDistinctSourceQueryColumn() {
        this.queryColumns.add(" count( DISTINCT source) count_distinct_source");
    }

    public void addSumSourceQueryColumn() {
        this.queryColumns.add(" sum(source) sum_source");
    }

    public void addJdPinQueryColumn() {
        this.queryColumns.add("jd_pin");
    }

    public void addMaxJdPinQueryColumn() {
        this.queryColumns.add("max(jd_pin) max_jd_pin");
    }

    public void addMinJdPinQueryColumn() {
        this.queryColumns.add("min(jd_pin) min_jd_pin");
    }

    public void addAvgJdPinQueryColumn() {
        this.queryColumns.add(" avg(jd_pin) avg_jd_pin");
    }

    public void addCountJdPinQueryColumn() {
        this.queryColumns.add(" count(jd_pin) count_jd_pin");
    }

    public void addCountDistinctJdPinQueryColumn() {
        this.queryColumns.add(" count( DISTINCT jd_pin) count_distinct_jd_pin");
    }

    public void addSumJdPinQueryColumn() {
        this.queryColumns.add(" sum(jd_pin) sum_jd_pin");
    }

    public void addTbBuyerNickQueryColumn() {
        this.queryColumns.add("tb_buyer_nick");
    }

    public void addMaxTbBuyerNickQueryColumn() {
        this.queryColumns.add("max(tb_buyer_nick) max_tb_buyer_nick");
    }

    public void addMinTbBuyerNickQueryColumn() {
        this.queryColumns.add("min(tb_buyer_nick) min_tb_buyer_nick");
    }

    public void addAvgTbBuyerNickQueryColumn() {
        this.queryColumns.add(" avg(tb_buyer_nick) avg_tb_buyer_nick");
    }

    public void addCountTbBuyerNickQueryColumn() {
        this.queryColumns.add(" count(tb_buyer_nick) count_tb_buyer_nick");
    }

    public void addCountDistinctTbBuyerNickQueryColumn() {
        this.queryColumns.add(" count( DISTINCT tb_buyer_nick) count_distinct_tb_buyer_nick");
    }

    public void addSumTbBuyerNickQueryColumn() {
        this.queryColumns.add(" sum(tb_buyer_nick) sum_tb_buyer_nick");
    }

    public void addYzBuyerNickQueryColumn() {
        this.queryColumns.add("yz_buyer_nick");
    }

    public void addMaxYzBuyerNickQueryColumn() {
        this.queryColumns.add("max(yz_buyer_nick) max_yz_buyer_nick");
    }

    public void addMinYzBuyerNickQueryColumn() {
        this.queryColumns.add("min(yz_buyer_nick) min_yz_buyer_nick");
    }

    public void addAvgYzBuyerNickQueryColumn() {
        this.queryColumns.add(" avg(yz_buyer_nick) avg_yz_buyer_nick");
    }

    public void addCountYzBuyerNickQueryColumn() {
        this.queryColumns.add(" count(yz_buyer_nick) count_yz_buyer_nick");
    }

    public void addCountDistinctYzBuyerNickQueryColumn() {
        this.queryColumns.add(" count( DISTINCT yz_buyer_nick) count_distinct_yz_buyer_nick");
    }

    public void addSumYzBuyerNickQueryColumn() {
        this.queryColumns.add(" sum(yz_buyer_nick) sum_yz_buyer_nick");
    }

    public void addWxOpenidQueryColumn() {
        this.queryColumns.add("wx_openid");
    }

    public void addMaxWxOpenidQueryColumn() {
        this.queryColumns.add("max(wx_openid) max_wx_openid");
    }

    public void addMinWxOpenidQueryColumn() {
        this.queryColumns.add("min(wx_openid) min_wx_openid");
    }

    public void addAvgWxOpenidQueryColumn() {
        this.queryColumns.add(" avg(wx_openid) avg_wx_openid");
    }

    public void addCountWxOpenidQueryColumn() {
        this.queryColumns.add(" count(wx_openid) count_wx_openid");
    }

    public void addCountDistinctWxOpenidQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_openid) count_distinct_wx_openid");
    }

    public void addSumWxOpenidQueryColumn() {
        this.queryColumns.add(" sum(wx_openid) sum_wx_openid");
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

    public void addCountDistinctNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT name) count_distinct_name");
    }

    public void addSumNameQueryColumn() {
        this.queryColumns.add(" sum(name) sum_name");
    }

    public void addWxNickNameQueryColumn() {
        this.queryColumns.add("wx_nick_name");
    }

    public void addMaxWxNickNameQueryColumn() {
        this.queryColumns.add("max(wx_nick_name) max_wx_nick_name");
    }

    public void addMinWxNickNameQueryColumn() {
        this.queryColumns.add("min(wx_nick_name) min_wx_nick_name");
    }

    public void addAvgWxNickNameQueryColumn() {
        this.queryColumns.add(" avg(wx_nick_name) avg_wx_nick_name");
    }

    public void addCountWxNickNameQueryColumn() {
        this.queryColumns.add(" count(wx_nick_name) count_wx_nick_name");
    }

    public void addCountDistinctWxNickNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_nick_name) count_distinct_wx_nick_name");
    }

    public void addSumWxNickNameQueryColumn() {
        this.queryColumns.add(" sum(wx_nick_name) sum_wx_nick_name");
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

    public void addCountryQueryColumn() {
        this.queryColumns.add("country");
    }

    public void addMaxCountryQueryColumn() {
        this.queryColumns.add("max(country) max_country");
    }

    public void addMinCountryQueryColumn() {
        this.queryColumns.add("min(country) min_country");
    }

    public void addAvgCountryQueryColumn() {
        this.queryColumns.add(" avg(country) avg_country");
    }

    public void addCountCountryQueryColumn() {
        this.queryColumns.add(" count(country) count_country");
    }

    public void addCountDistinctCountryQueryColumn() {
        this.queryColumns.add(" count( DISTINCT country) count_distinct_country");
    }

    public void addSumCountryQueryColumn() {
        this.queryColumns.add(" sum(country) sum_country");
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

    public void addEmailQueryColumn() {
        this.queryColumns.add("email");
    }

    public void addMaxEmailQueryColumn() {
        this.queryColumns.add("max(email) max_email");
    }

    public void addMinEmailQueryColumn() {
        this.queryColumns.add("min(email) min_email");
    }

    public void addAvgEmailQueryColumn() {
        this.queryColumns.add(" avg(email) avg_email");
    }

    public void addCountEmailQueryColumn() {
        this.queryColumns.add(" count(email) count_email");
    }

    public void addCountDistinctEmailQueryColumn() {
        this.queryColumns.add(" count( DISTINCT email) count_distinct_email");
    }

    public void addSumEmailQueryColumn() {
        this.queryColumns.add(" sum(email) sum_email");
    }

    public void addMobileQueryColumn() {
        this.queryColumns.add("mobile");
    }

    public void addMaxMobileQueryColumn() {
        this.queryColumns.add("max(mobile) max_mobile");
    }

    public void addMinMobileQueryColumn() {
        this.queryColumns.add("min(mobile) min_mobile");
    }

    public void addAvgMobileQueryColumn() {
        this.queryColumns.add(" avg(mobile) avg_mobile");
    }

    public void addCountMobileQueryColumn() {
        this.queryColumns.add(" count(mobile) count_mobile");
    }

    public void addCountDistinctMobileQueryColumn() {
        this.queryColumns.add(" count( DISTINCT mobile) count_distinct_mobile");
    }

    public void addSumMobileQueryColumn() {
        this.queryColumns.add(" sum(mobile) sum_mobile");
    }

    public void addWxSubscribeQueryColumn() {
        this.queryColumns.add("wx_subscribe");
    }

    public void addMaxWxSubscribeQueryColumn() {
        this.queryColumns.add("max(wx_subscribe) max_wx_subscribe");
    }

    public void addMinWxSubscribeQueryColumn() {
        this.queryColumns.add("min(wx_subscribe) min_wx_subscribe");
    }

    public void addAvgWxSubscribeQueryColumn() {
        this.queryColumns.add(" avg(wx_subscribe) avg_wx_subscribe");
    }

    public void addCountWxSubscribeQueryColumn() {
        this.queryColumns.add(" count(wx_subscribe) count_wx_subscribe");
    }

    public void addCountDistinctWxSubscribeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_subscribe) count_distinct_wx_subscribe");
    }

    public void addSumWxSubscribeQueryColumn() {
        this.queryColumns.add(" sum(wx_subscribe) sum_wx_subscribe");
    }

    public void addWxHeadimgurlQueryColumn() {
        this.queryColumns.add("wx_headimgurl");
    }

    public void addMaxWxHeadimgurlQueryColumn() {
        this.queryColumns.add("max(wx_headimgurl) max_wx_headimgurl");
    }

    public void addMinWxHeadimgurlQueryColumn() {
        this.queryColumns.add("min(wx_headimgurl) min_wx_headimgurl");
    }

    public void addAvgWxHeadimgurlQueryColumn() {
        this.queryColumns.add(" avg(wx_headimgurl) avg_wx_headimgurl");
    }

    public void addCountWxHeadimgurlQueryColumn() {
        this.queryColumns.add(" count(wx_headimgurl) count_wx_headimgurl");
    }

    public void addCountDistinctWxHeadimgurlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_headimgurl) count_distinct_wx_headimgurl");
    }

    public void addSumWxHeadimgurlQueryColumn() {
        this.queryColumns.add(" sum(wx_headimgurl) sum_wx_headimgurl");
    }

    public void addWxSubscribeTimeQueryColumn() {
        this.queryColumns.add("wx_subscribe_time");
    }

    public void addMaxWxSubscribeTimeQueryColumn() {
        this.queryColumns.add("max(wx_subscribe_time) max_wx_subscribe_time");
    }

    public void addMinWxSubscribeTimeQueryColumn() {
        this.queryColumns.add("min(wx_subscribe_time) min_wx_subscribe_time");
    }

    public void addAvgWxSubscribeTimeQueryColumn() {
        this.queryColumns.add(" avg(wx_subscribe_time) avg_wx_subscribe_time");
    }

    public void addCountWxSubscribeTimeQueryColumn() {
        this.queryColumns.add(" count(wx_subscribe_time) count_wx_subscribe_time");
    }

    public void addCountDistinctWxSubscribeTimeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_subscribe_time) count_distinct_wx_subscribe_time");
    }

    public void addSumWxSubscribeTimeQueryColumn() {
        this.queryColumns.add(" sum(wx_subscribe_time) sum_wx_subscribe_time");
    }

    public void addIsOldUserQueryColumn() {
        this.queryColumns.add("is_old_user");
    }

    public void addMaxIsOldUserQueryColumn() {
        this.queryColumns.add("max(is_old_user) max_is_old_user");
    }

    public void addMinIsOldUserQueryColumn() {
        this.queryColumns.add("min(is_old_user) min_is_old_user");
    }

    public void addAvgIsOldUserQueryColumn() {
        this.queryColumns.add(" avg(is_old_user) avg_is_old_user");
    }

    public void addCountIsOldUserQueryColumn() {
        this.queryColumns.add(" count(is_old_user) count_is_old_user");
    }

    public void addCountDistinctIsOldUserQueryColumn() {
        this.queryColumns.add(" count( DISTINCT is_old_user) count_distinct_is_old_user");
    }

    public void addSumIsOldUserQueryColumn() {
        this.queryColumns.add(" sum(is_old_user) sum_is_old_user");
    }

    public void addIntegralQueryColumn() {
        this.queryColumns.add("integral");
    }

    public void addMaxIntegralQueryColumn() {
        this.queryColumns.add("max(integral) max_integral");
    }

    public void addMinIntegralQueryColumn() {
        this.queryColumns.add("min(integral) min_integral");
    }

    public void addAvgIntegralQueryColumn() {
        this.queryColumns.add(" avg(integral) avg_integral");
    }

    public void addCountIntegralQueryColumn() {
        this.queryColumns.add(" count(integral) count_integral");
    }

    public void addCountDistinctIntegralQueryColumn() {
        this.queryColumns.add(" count( DISTINCT integral) count_distinct_integral");
    }

    public void addSumIntegralQueryColumn() {
        this.queryColumns.add(" sum(integral) sum_integral");
    }

    public void addBrandFansQueryColumn() {
        this.queryColumns.add("brand_fans");
    }

    public void addMaxBrandFansQueryColumn() {
        this.queryColumns.add("max(brand_fans) max_brand_fans");
    }

    public void addMinBrandFansQueryColumn() {
        this.queryColumns.add("min(brand_fans) min_brand_fans");
    }

    public void addAvgBrandFansQueryColumn() {
        this.queryColumns.add(" avg(brand_fans) avg_brand_fans");
    }

    public void addCountBrandFansQueryColumn() {
        this.queryColumns.add(" count(brand_fans) count_brand_fans");
    }

    public void addCountDistinctBrandFansQueryColumn() {
        this.queryColumns.add(" count( DISTINCT brand_fans) count_distinct_brand_fans");
    }

    public void addSumBrandFansQueryColumn() {
        this.queryColumns.add(" sum(brand_fans) sum_brand_fans");
    }

    public void addIsVerifyQueryColumn() {
        this.queryColumns.add("is_verify");
    }

    public void addMaxIsVerifyQueryColumn() {
        this.queryColumns.add("max(is_verify) max_is_verify");
    }

    public void addMinIsVerifyQueryColumn() {
        this.queryColumns.add("min(is_verify) min_is_verify");
    }

    public void addAvgIsVerifyQueryColumn() {
        this.queryColumns.add(" avg(is_verify) avg_is_verify");
    }

    public void addCountIsVerifyQueryColumn() {
        this.queryColumns.add(" count(is_verify) count_is_verify");
    }

    public void addCountDistinctIsVerifyQueryColumn() {
        this.queryColumns.add(" count( DISTINCT is_verify) count_distinct_is_verify");
    }

    public void addSumIsVerifyQueryColumn() {
        this.queryColumns.add(" sum(is_verify) sum_is_verify");
    }

    public void addIsReceivedHbQueryColumn() {
        this.queryColumns.add("is_received_hb");
    }

    public void addMaxIsReceivedHbQueryColumn() {
        this.queryColumns.add("max(is_received_hb) max_is_received_hb");
    }

    public void addMinIsReceivedHbQueryColumn() {
        this.queryColumns.add("min(is_received_hb) min_is_received_hb");
    }

    public void addAvgIsReceivedHbQueryColumn() {
        this.queryColumns.add(" avg(is_received_hb) avg_is_received_hb");
    }

    public void addCountIsReceivedHbQueryColumn() {
        this.queryColumns.add(" count(is_received_hb) count_is_received_hb");
    }

    public void addCountDistinctIsReceivedHbQueryColumn() {
        this.queryColumns.add(" count( DISTINCT is_received_hb) count_distinct_is_received_hb");
    }

    public void addSumIsReceivedHbQueryColumn() {
        this.queryColumns.add(" sum(is_received_hb) sum_is_received_hb");
    }

    public void addUserPortraitIdQueryColumn() {
        this.queryColumns.add("user_portrait_id");
    }

    public void addMaxUserPortraitIdQueryColumn() {
        this.queryColumns.add("max(user_portrait_id) max_user_portrait_id");
    }

    public void addMinUserPortraitIdQueryColumn() {
        this.queryColumns.add("min(user_portrait_id) min_user_portrait_id");
    }

    public void addAvgUserPortraitIdQueryColumn() {
        this.queryColumns.add(" avg(user_portrait_id) avg_user_portrait_id");
    }

    public void addCountUserPortraitIdQueryColumn() {
        this.queryColumns.add(" count(user_portrait_id) count_user_portrait_id");
    }

    public void addCountDistinctUserPortraitIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT user_portrait_id) count_distinct_user_portrait_id");
    }

    public void addSumUserPortraitIdQueryColumn() {
        this.queryColumns.add(" sum(user_portrait_id) sum_user_portrait_id");
    }

    public void addBirthdayQueryColumn() {
        this.queryColumns.add("birthday");
    }

    public void addMaxBirthdayQueryColumn() {
        this.queryColumns.add("max(birthday) max_birthday");
    }

    public void addMinBirthdayQueryColumn() {
        this.queryColumns.add("min(birthday) min_birthday");
    }

    public void addAvgBirthdayQueryColumn() {
        this.queryColumns.add(" avg(birthday) avg_birthday");
    }

    public void addCountBirthdayQueryColumn() {
        this.queryColumns.add(" count(birthday) count_birthday");
    }

    public void addCountDistinctBirthdayQueryColumn() {
        this.queryColumns.add(" count( DISTINCT birthday) count_distinct_birthday");
    }

    public void addSumBirthdayQueryColumn() {
        this.queryColumns.add(" sum(birthday) sum_birthday");
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

    public void addCountDistinctReceiverIdTbQueryColumn() {
        this.queryColumns.add(" count( DISTINCT receiver_id_tb) count_distinct_receiver_id_tb");
    }

    public void addSumReceiverIdTbQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_tb) sum_receiver_id_tb");
    }

    public void addReceiverIdJdQueryColumn() {
        this.queryColumns.add("receiver_id_jd");
    }

    public void addMaxReceiverIdJdQueryColumn() {
        this.queryColumns.add("max(receiver_id_jd) max_receiver_id_jd");
    }

    public void addMinReceiverIdJdQueryColumn() {
        this.queryColumns.add("min(receiver_id_jd) min_receiver_id_jd");
    }

    public void addAvgReceiverIdJdQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_jd) avg_receiver_id_jd");
    }

    public void addCountReceiverIdJdQueryColumn() {
        this.queryColumns.add(" count(receiver_id_jd) count_receiver_id_jd");
    }

    public void addCountDistinctReceiverIdJdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT receiver_id_jd) count_distinct_receiver_id_jd");
    }

    public void addSumReceiverIdJdQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_jd) sum_receiver_id_jd");
    }

    public void addReceiverIdYzQueryColumn() {
        this.queryColumns.add("receiver_id_yz");
    }

    public void addMaxReceiverIdYzQueryColumn() {
        this.queryColumns.add("max(receiver_id_yz) max_receiver_id_yz");
    }

    public void addMinReceiverIdYzQueryColumn() {
        this.queryColumns.add("min(receiver_id_yz) min_receiver_id_yz");
    }

    public void addAvgReceiverIdYzQueryColumn() {
        this.queryColumns.add(" avg(receiver_id_yz) avg_receiver_id_yz");
    }

    public void addCountReceiverIdYzQueryColumn() {
        this.queryColumns.add(" count(receiver_id_yz) count_receiver_id_yz");
    }

    public void addCountDistinctReceiverIdYzQueryColumn() {
        this.queryColumns.add(" count( DISTINCT receiver_id_yz) count_distinct_receiver_id_yz");
    }

    public void addSumReceiverIdYzQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_yz) sum_receiver_id_yz");
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

        public Criteria andUserIdJdIsNull() {
            addCriterion("user_id_jd is null");
            return (Criteria) this;
        }

        public Criteria andUserIdJdIsNotNull() {
            addCriterion("user_id_jd is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdJdEqualTo(Long value) {
            addCriterion("user_id_jd =", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotEqualTo(Long value) {
            addCriterion("user_id_jd <>", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdGreaterThan(Long value) {
            addCriterion("user_id_jd >", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id_jd >=", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdLessThan(Long value) {
            addCriterion("user_id_jd <", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdLessThanOrEqualTo(Long value) {
            addCriterion("user_id_jd <=", value, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdIn(List<Long> values) {
            addCriterion("user_id_jd in", values, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotIn(List<Long> values) {
            addCriterion("user_id_jd not in", values, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdBetween(Long value1, Long value2) {
            addCriterion("user_id_jd between", value1, value2, "userIdJd");
            return (Criteria) this;
        }

        public Criteria andUserIdJdNotBetween(Long value1, Long value2) {
            addCriterion("user_id_jd not between", value1, value2, "userIdJd");
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

        public Criteria andFirstSourceIsNull() {
            addCriterion("first_source is null");
            return (Criteria) this;
        }

        public Criteria andFirstSourceIsNotNull() {
            addCriterion("first_source is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSourceEqualTo(String value) {
            addCriterion("first_source =", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceNotEqualTo(String value) {
            addCriterion("first_source <>", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceGreaterThan(String value) {
            addCriterion("first_source >", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceGreaterThanOrEqualTo(String value) {
            addCriterion("first_source >=", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceLessThan(String value) {
            addCriterion("first_source <", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceLessThanOrEqualTo(String value) {
            addCriterion("first_source <=", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceLike(String value) {
            addCriterion("first_source like", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceNotLike(String value) {
            addCriterion("first_source not like", value, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceIn(List<String> values) {
            addCriterion("first_source in", values, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceNotIn(List<String> values) {
            addCriterion("first_source not in", values, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceBetween(String value1, String value2) {
            addCriterion("first_source between", value1, value2, "firstSource");
            return (Criteria) this;
        }

        public Criteria andFirstSourceNotBetween(String value1, String value2) {
            addCriterion("first_source not between", value1, value2, "firstSource");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andJdPinIsNull() {
            addCriterion("jd_pin is null");
            return (Criteria) this;
        }

        public Criteria andJdPinIsNotNull() {
            addCriterion("jd_pin is not null");
            return (Criteria) this;
        }

        public Criteria andJdPinEqualTo(String value) {
            addCriterion("jd_pin =", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinNotEqualTo(String value) {
            addCriterion("jd_pin <>", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinGreaterThan(String value) {
            addCriterion("jd_pin >", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinGreaterThanOrEqualTo(String value) {
            addCriterion("jd_pin >=", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinLessThan(String value) {
            addCriterion("jd_pin <", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinLessThanOrEqualTo(String value) {
            addCriterion("jd_pin <=", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinLike(String value) {
            addCriterion("jd_pin like", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinNotLike(String value) {
            addCriterion("jd_pin not like", value, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinIn(List<String> values) {
            addCriterion("jd_pin in", values, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinNotIn(List<String> values) {
            addCriterion("jd_pin not in", values, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinBetween(String value1, String value2) {
            addCriterion("jd_pin between", value1, value2, "jdPin");
            return (Criteria) this;
        }

        public Criteria andJdPinNotBetween(String value1, String value2) {
            addCriterion("jd_pin not between", value1, value2, "jdPin");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickIsNull() {
            addCriterion("tb_buyer_nick is null");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickIsNotNull() {
            addCriterion("tb_buyer_nick is not null");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickEqualTo(String value) {
            addCriterion("tb_buyer_nick =", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickNotEqualTo(String value) {
            addCriterion("tb_buyer_nick <>", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickGreaterThan(String value) {
            addCriterion("tb_buyer_nick >", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("tb_buyer_nick >=", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickLessThan(String value) {
            addCriterion("tb_buyer_nick <", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("tb_buyer_nick <=", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickLike(String value) {
            addCriterion("tb_buyer_nick like", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickNotLike(String value) {
            addCriterion("tb_buyer_nick not like", value, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickIn(List<String> values) {
            addCriterion("tb_buyer_nick in", values, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickNotIn(List<String> values) {
            addCriterion("tb_buyer_nick not in", values, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickBetween(String value1, String value2) {
            addCriterion("tb_buyer_nick between", value1, value2, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andTbBuyerNickNotBetween(String value1, String value2) {
            addCriterion("tb_buyer_nick not between", value1, value2, "tbBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickIsNull() {
            addCriterion("yz_buyer_nick is null");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickIsNotNull() {
            addCriterion("yz_buyer_nick is not null");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickEqualTo(String value) {
            addCriterion("yz_buyer_nick =", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickNotEqualTo(String value) {
            addCriterion("yz_buyer_nick <>", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickGreaterThan(String value) {
            addCriterion("yz_buyer_nick >", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickGreaterThanOrEqualTo(String value) {
            addCriterion("yz_buyer_nick >=", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickLessThan(String value) {
            addCriterion("yz_buyer_nick <", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickLessThanOrEqualTo(String value) {
            addCriterion("yz_buyer_nick <=", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickLike(String value) {
            addCriterion("yz_buyer_nick like", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickNotLike(String value) {
            addCriterion("yz_buyer_nick not like", value, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickIn(List<String> values) {
            addCriterion("yz_buyer_nick in", values, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickNotIn(List<String> values) {
            addCriterion("yz_buyer_nick not in", values, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickBetween(String value1, String value2) {
            addCriterion("yz_buyer_nick between", value1, value2, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andYzBuyerNickNotBetween(String value1, String value2) {
            addCriterion("yz_buyer_nick not between", value1, value2, "yzBuyerNick");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
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

        public Criteria andWxNickNameIsNull() {
            addCriterion("wx_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameIsNotNull() {
            addCriterion("wx_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameEqualTo(String value) {
            addCriterion("wx_nick_name =", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotEqualTo(String value) {
            addCriterion("wx_nick_name <>", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameGreaterThan(String value) {
            addCriterion("wx_nick_name >", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("wx_nick_name >=", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLessThan(String value) {
            addCriterion("wx_nick_name <", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLessThanOrEqualTo(String value) {
            addCriterion("wx_nick_name <=", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLike(String value) {
            addCriterion("wx_nick_name like", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotLike(String value) {
            addCriterion("wx_nick_name not like", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameIn(List<String> values) {
            addCriterion("wx_nick_name in", values, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotIn(List<String> values) {
            addCriterion("wx_nick_name not in", values, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBetween(String value1, String value2) {
            addCriterion("wx_nick_name between", value1, value2, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotBetween(String value1, String value2) {
            addCriterion("wx_nick_name not between", value1, value2, "wxNickName");
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

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeIsNull() {
            addCriterion("wx_subscribe is null");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeIsNotNull() {
            addCriterion("wx_subscribe is not null");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeEqualTo(String value) {
            addCriterion("wx_subscribe =", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeNotEqualTo(String value) {
            addCriterion("wx_subscribe <>", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeGreaterThan(String value) {
            addCriterion("wx_subscribe >", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_subscribe >=", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeLessThan(String value) {
            addCriterion("wx_subscribe <", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeLessThanOrEqualTo(String value) {
            addCriterion("wx_subscribe <=", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeLike(String value) {
            addCriterion("wx_subscribe like", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeNotLike(String value) {
            addCriterion("wx_subscribe not like", value, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeIn(List<String> values) {
            addCriterion("wx_subscribe in", values, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeNotIn(List<String> values) {
            addCriterion("wx_subscribe not in", values, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeBetween(String value1, String value2) {
            addCriterion("wx_subscribe between", value1, value2, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeNotBetween(String value1, String value2) {
            addCriterion("wx_subscribe not between", value1, value2, "wxSubscribe");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlIsNull() {
            addCriterion("wx_headimgurl is null");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlIsNotNull() {
            addCriterion("wx_headimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlEqualTo(String value) {
            addCriterion("wx_headimgurl =", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlNotEqualTo(String value) {
            addCriterion("wx_headimgurl <>", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlGreaterThan(String value) {
            addCriterion("wx_headimgurl >", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("wx_headimgurl >=", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlLessThan(String value) {
            addCriterion("wx_headimgurl <", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlLessThanOrEqualTo(String value) {
            addCriterion("wx_headimgurl <=", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlLike(String value) {
            addCriterion("wx_headimgurl like", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlNotLike(String value) {
            addCriterion("wx_headimgurl not like", value, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlIn(List<String> values) {
            addCriterion("wx_headimgurl in", values, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlNotIn(List<String> values) {
            addCriterion("wx_headimgurl not in", values, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlBetween(String value1, String value2) {
            addCriterion("wx_headimgurl between", value1, value2, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxHeadimgurlNotBetween(String value1, String value2) {
            addCriterion("wx_headimgurl not between", value1, value2, "wxHeadimgurl");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeIsNull() {
            addCriterion("wx_subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeIsNotNull() {
            addCriterion("wx_subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeEqualTo(Date value) {
            addCriterion("wx_subscribe_time =", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeNotEqualTo(Date value) {
            addCriterion("wx_subscribe_time <>", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeGreaterThan(Date value) {
            addCriterion("wx_subscribe_time >", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_subscribe_time >=", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeLessThan(Date value) {
            addCriterion("wx_subscribe_time <", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeLessThanOrEqualTo(Date value) {
            addCriterion("wx_subscribe_time <=", value, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeIn(List<Date> values) {
            addCriterion("wx_subscribe_time in", values, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeNotIn(List<Date> values) {
            addCriterion("wx_subscribe_time not in", values, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeBetween(Date value1, Date value2) {
            addCriterion("wx_subscribe_time between", value1, value2, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andWxSubscribeTimeNotBetween(Date value1, Date value2) {
            addCriterion("wx_subscribe_time not between", value1, value2, "wxSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andIsOldUserIsNull() {
            addCriterion("is_old_user is null");
            return (Criteria) this;
        }

        public Criteria andIsOldUserIsNotNull() {
            addCriterion("is_old_user is not null");
            return (Criteria) this;
        }

        public Criteria andIsOldUserEqualTo(String value) {
            addCriterion("is_old_user =", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserNotEqualTo(String value) {
            addCriterion("is_old_user <>", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserGreaterThan(String value) {
            addCriterion("is_old_user >", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserGreaterThanOrEqualTo(String value) {
            addCriterion("is_old_user >=", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserLessThan(String value) {
            addCriterion("is_old_user <", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserLessThanOrEqualTo(String value) {
            addCriterion("is_old_user <=", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserLike(String value) {
            addCriterion("is_old_user like", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserNotLike(String value) {
            addCriterion("is_old_user not like", value, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserIn(List<String> values) {
            addCriterion("is_old_user in", values, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserNotIn(List<String> values) {
            addCriterion("is_old_user not in", values, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserBetween(String value1, String value2) {
            addCriterion("is_old_user between", value1, value2, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIsOldUserNotBetween(String value1, String value2) {
            addCriterion("is_old_user not between", value1, value2, "isOldUser");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Long value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Long value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Long value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Long value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Long value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Long> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Long> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Long value1, Long value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Long value1, Long value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andBrandFansIsNull() {
            addCriterion("brand_fans is null");
            return (Criteria) this;
        }

        public Criteria andBrandFansIsNotNull() {
            addCriterion("brand_fans is not null");
            return (Criteria) this;
        }

        public Criteria andBrandFansEqualTo(String value) {
            addCriterion("brand_fans =", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansNotEqualTo(String value) {
            addCriterion("brand_fans <>", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansGreaterThan(String value) {
            addCriterion("brand_fans >", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansGreaterThanOrEqualTo(String value) {
            addCriterion("brand_fans >=", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansLessThan(String value) {
            addCriterion("brand_fans <", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansLessThanOrEqualTo(String value) {
            addCriterion("brand_fans <=", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansLike(String value) {
            addCriterion("brand_fans like", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansNotLike(String value) {
            addCriterion("brand_fans not like", value, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansIn(List<String> values) {
            addCriterion("brand_fans in", values, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansNotIn(List<String> values) {
            addCriterion("brand_fans not in", values, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansBetween(String value1, String value2) {
            addCriterion("brand_fans between", value1, value2, "brandFans");
            return (Criteria) this;
        }

        public Criteria andBrandFansNotBetween(String value1, String value2) {
            addCriterion("brand_fans not between", value1, value2, "brandFans");
            return (Criteria) this;
        }

        public Criteria andIsVerifyIsNull() {
            addCriterion("is_verify is null");
            return (Criteria) this;
        }

        public Criteria andIsVerifyIsNotNull() {
            addCriterion("is_verify is not null");
            return (Criteria) this;
        }

        public Criteria andIsVerifyEqualTo(String value) {
            addCriterion("is_verify =", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyNotEqualTo(String value) {
            addCriterion("is_verify <>", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyGreaterThan(String value) {
            addCriterion("is_verify >", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyGreaterThanOrEqualTo(String value) {
            addCriterion("is_verify >=", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyLessThan(String value) {
            addCriterion("is_verify <", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyLessThanOrEqualTo(String value) {
            addCriterion("is_verify <=", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyLike(String value) {
            addCriterion("is_verify like", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyNotLike(String value) {
            addCriterion("is_verify not like", value, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyIn(List<String> values) {
            addCriterion("is_verify in", values, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyNotIn(List<String> values) {
            addCriterion("is_verify not in", values, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyBetween(String value1, String value2) {
            addCriterion("is_verify between", value1, value2, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsVerifyNotBetween(String value1, String value2) {
            addCriterion("is_verify not between", value1, value2, "isVerify");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbIsNull() {
            addCriterion("is_received_hb is null");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbIsNotNull() {
            addCriterion("is_received_hb is not null");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbEqualTo(String value) {
            addCriterion("is_received_hb =", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbNotEqualTo(String value) {
            addCriterion("is_received_hb <>", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbGreaterThan(String value) {
            addCriterion("is_received_hb >", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbGreaterThanOrEqualTo(String value) {
            addCriterion("is_received_hb >=", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbLessThan(String value) {
            addCriterion("is_received_hb <", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbLessThanOrEqualTo(String value) {
            addCriterion("is_received_hb <=", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbLike(String value) {
            addCriterion("is_received_hb like", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbNotLike(String value) {
            addCriterion("is_received_hb not like", value, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbIn(List<String> values) {
            addCriterion("is_received_hb in", values, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbNotIn(List<String> values) {
            addCriterion("is_received_hb not in", values, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbBetween(String value1, String value2) {
            addCriterion("is_received_hb between", value1, value2, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andIsReceivedHbNotBetween(String value1, String value2) {
            addCriterion("is_received_hb not between", value1, value2, "isReceivedHb");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdIsNull() {
            addCriterion("user_portrait_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdIsNotNull() {
            addCriterion("user_portrait_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdEqualTo(Long value) {
            addCriterion("user_portrait_id =", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdNotEqualTo(Long value) {
            addCriterion("user_portrait_id <>", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdGreaterThan(Long value) {
            addCriterion("user_portrait_id >", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_portrait_id >=", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdLessThan(Long value) {
            addCriterion("user_portrait_id <", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdLessThanOrEqualTo(Long value) {
            addCriterion("user_portrait_id <=", value, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdIn(List<Long> values) {
            addCriterion("user_portrait_id in", values, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdNotIn(List<Long> values) {
            addCriterion("user_portrait_id not in", values, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdBetween(Long value1, Long value2) {
            addCriterion("user_portrait_id between", value1, value2, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIdNotBetween(Long value1, Long value2) {
            addCriterion("user_portrait_id not between", value1, value2, "userPortraitId");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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

        public Criteria andReceiverIdJdIsNull() {
            addCriterion("receiver_id_jd is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdIsNotNull() {
            addCriterion("receiver_id_jd is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdEqualTo(Long value) {
            addCriterion("receiver_id_jd =", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotEqualTo(Long value) {
            addCriterion("receiver_id_jd <>", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdGreaterThan(Long value) {
            addCriterion("receiver_id_jd >", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_jd >=", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdLessThan(Long value) {
            addCriterion("receiver_id_jd <", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_jd <=", value, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdIn(List<Long> values) {
            addCriterion("receiver_id_jd in", values, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotIn(List<Long> values) {
            addCriterion("receiver_id_jd not in", values, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdBetween(Long value1, Long value2) {
            addCriterion("receiver_id_jd between", value1, value2, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdJdNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_jd not between", value1, value2, "receiverIdJd");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzIsNull() {
            addCriterion("receiver_id_yz is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzIsNotNull() {
            addCriterion("receiver_id_yz is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzEqualTo(Long value) {
            addCriterion("receiver_id_yz =", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotEqualTo(Long value) {
            addCriterion("receiver_id_yz <>", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzGreaterThan(Long value) {
            addCriterion("receiver_id_yz >", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id_yz >=", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzLessThan(Long value) {
            addCriterion("receiver_id_yz <", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id_yz <=", value, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzIn(List<Long> values) {
            addCriterion("receiver_id_yz in", values, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotIn(List<Long> values) {
            addCriterion("receiver_id_yz not in", values, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzBetween(Long value1, Long value2) {
            addCriterion("receiver_id_yz between", value1, value2, "receiverIdYz");
            return (Criteria) this;
        }

        public Criteria andReceiverIdYzNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id_yz not between", value1, value2, "receiverIdYz");
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