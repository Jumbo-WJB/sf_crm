package com.shufensoft.crm.biz.domain.generation.seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerConfigInfoExample {
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

    public SellerConfigInfoExample() {
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

    public void addSellerTypeQueryColumn() {
        this.queryColumns.add("seller_type");
    }

    public void addMaxSellerTypeQueryColumn() {
        this.queryColumns.add("max(seller_type) max_seller_type");
    }

    public void addMinSellerTypeQueryColumn() {
        this.queryColumns.add("min(seller_type) min_seller_type");
    }

    public void addAvgSellerTypeQueryColumn() {
        this.queryColumns.add(" avg(seller_type) avg_seller_type");
    }

    public void addCountSellerTypeQueryColumn() {
        this.queryColumns.add(" count(seller_type) count_seller_type");
    }

    public void addCountDistinctSellerTypeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT seller_type) count_distinct_seller_type");
    }

    public void addSumSellerTypeQueryColumn() {
        this.queryColumns.add(" sum(seller_type) sum_seller_type");
    }

    public void addSellerNameQueryColumn() {
        this.queryColumns.add("seller_name");
    }

    public void addMaxSellerNameQueryColumn() {
        this.queryColumns.add("max(seller_name) max_seller_name");
    }

    public void addMinSellerNameQueryColumn() {
        this.queryColumns.add("min(seller_name) min_seller_name");
    }

    public void addAvgSellerNameQueryColumn() {
        this.queryColumns.add(" avg(seller_name) avg_seller_name");
    }

    public void addCountSellerNameQueryColumn() {
        this.queryColumns.add(" count(seller_name) count_seller_name");
    }

    public void addCountDistinctSellerNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT seller_name) count_distinct_seller_name");
    }

    public void addSumSellerNameQueryColumn() {
        this.queryColumns.add(" sum(seller_name) sum_seller_name");
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

    public void addPhoneQueryColumn() {
        this.queryColumns.add("phone");
    }

    public void addMaxPhoneQueryColumn() {
        this.queryColumns.add("max(phone) max_phone");
    }

    public void addMinPhoneQueryColumn() {
        this.queryColumns.add("min(phone) min_phone");
    }

    public void addAvgPhoneQueryColumn() {
        this.queryColumns.add(" avg(phone) avg_phone");
    }

    public void addCountPhoneQueryColumn() {
        this.queryColumns.add(" count(phone) count_phone");
    }

    public void addCountDistinctPhoneQueryColumn() {
        this.queryColumns.add(" count( DISTINCT phone) count_distinct_phone");
    }

    public void addSumPhoneQueryColumn() {
        this.queryColumns.add(" sum(phone) sum_phone");
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

    public void addAddressQueryColumn() {
        this.queryColumns.add("address");
    }

    public void addMaxAddressQueryColumn() {
        this.queryColumns.add("max(address) max_address");
    }

    public void addMinAddressQueryColumn() {
        this.queryColumns.add("min(address) min_address");
    }

    public void addAvgAddressQueryColumn() {
        this.queryColumns.add(" avg(address) avg_address");
    }

    public void addCountAddressQueryColumn() {
        this.queryColumns.add(" count(address) count_address");
    }

    public void addCountDistinctAddressQueryColumn() {
        this.queryColumns.add(" count( DISTINCT address) count_distinct_address");
    }

    public void addSumAddressQueryColumn() {
        this.queryColumns.add(" sum(address) sum_address");
    }

    public void addWxNoQueryColumn() {
        this.queryColumns.add("wx_no");
    }

    public void addMaxWxNoQueryColumn() {
        this.queryColumns.add("max(wx_no) max_wx_no");
    }

    public void addMinWxNoQueryColumn() {
        this.queryColumns.add("min(wx_no) min_wx_no");
    }

    public void addAvgWxNoQueryColumn() {
        this.queryColumns.add(" avg(wx_no) avg_wx_no");
    }

    public void addCountWxNoQueryColumn() {
        this.queryColumns.add(" count(wx_no) count_wx_no");
    }

    public void addCountDistinctWxNoQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_no) count_distinct_wx_no");
    }

    public void addSumWxNoQueryColumn() {
        this.queryColumns.add(" sum(wx_no) sum_wx_no");
    }

    public void addWxAppIdQueryColumn() {
        this.queryColumns.add("wx_app_id");
    }

    public void addMaxWxAppIdQueryColumn() {
        this.queryColumns.add("max(wx_app_id) max_wx_app_id");
    }

    public void addMinWxAppIdQueryColumn() {
        this.queryColumns.add("min(wx_app_id) min_wx_app_id");
    }

    public void addAvgWxAppIdQueryColumn() {
        this.queryColumns.add(" avg(wx_app_id) avg_wx_app_id");
    }

    public void addCountWxAppIdQueryColumn() {
        this.queryColumns.add(" count(wx_app_id) count_wx_app_id");
    }

    public void addCountDistinctWxAppIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_app_id) count_distinct_wx_app_id");
    }

    public void addSumWxAppIdQueryColumn() {
        this.queryColumns.add(" sum(wx_app_id) sum_wx_app_id");
    }

    public void addWxAppSecretQueryColumn() {
        this.queryColumns.add("wx_app_secret");
    }

    public void addMaxWxAppSecretQueryColumn() {
        this.queryColumns.add("max(wx_app_secret) max_wx_app_secret");
    }

    public void addMinWxAppSecretQueryColumn() {
        this.queryColumns.add("min(wx_app_secret) min_wx_app_secret");
    }

    public void addAvgWxAppSecretQueryColumn() {
        this.queryColumns.add(" avg(wx_app_secret) avg_wx_app_secret");
    }

    public void addCountWxAppSecretQueryColumn() {
        this.queryColumns.add(" count(wx_app_secret) count_wx_app_secret");
    }

    public void addCountDistinctWxAppSecretQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_app_secret) count_distinct_wx_app_secret");
    }

    public void addSumWxAppSecretQueryColumn() {
        this.queryColumns.add(" sum(wx_app_secret) sum_wx_app_secret");
    }

    public void addWxAccessTokenQueryColumn() {
        this.queryColumns.add("wx_access_token");
    }

    public void addMaxWxAccessTokenQueryColumn() {
        this.queryColumns.add("max(wx_access_token) max_wx_access_token");
    }

    public void addMinWxAccessTokenQueryColumn() {
        this.queryColumns.add("min(wx_access_token) min_wx_access_token");
    }

    public void addAvgWxAccessTokenQueryColumn() {
        this.queryColumns.add(" avg(wx_access_token) avg_wx_access_token");
    }

    public void addCountWxAccessTokenQueryColumn() {
        this.queryColumns.add(" count(wx_access_token) count_wx_access_token");
    }

    public void addCountDistinctWxAccessTokenQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_access_token) count_distinct_wx_access_token");
    }

    public void addSumWxAccessTokenQueryColumn() {
        this.queryColumns.add(" sum(wx_access_token) sum_wx_access_token");
    }

    public void addWxRefreshTokenQueryColumn() {
        this.queryColumns.add("wx_refresh_token");
    }

    public void addMaxWxRefreshTokenQueryColumn() {
        this.queryColumns.add("max(wx_refresh_token) max_wx_refresh_token");
    }

    public void addMinWxRefreshTokenQueryColumn() {
        this.queryColumns.add("min(wx_refresh_token) min_wx_refresh_token");
    }

    public void addAvgWxRefreshTokenQueryColumn() {
        this.queryColumns.add(" avg(wx_refresh_token) avg_wx_refresh_token");
    }

    public void addCountWxRefreshTokenQueryColumn() {
        this.queryColumns.add(" count(wx_refresh_token) count_wx_refresh_token");
    }

    public void addCountDistinctWxRefreshTokenQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_refresh_token) count_distinct_wx_refresh_token");
    }

    public void addSumWxRefreshTokenQueryColumn() {
        this.queryColumns.add(" sum(wx_refresh_token) sum_wx_refresh_token");
    }

    public void addWxJsapiTicketQueryColumn() {
        this.queryColumns.add("wx_jsapi_ticket");
    }

    public void addMaxWxJsapiTicketQueryColumn() {
        this.queryColumns.add("max(wx_jsapi_ticket) max_wx_jsapi_ticket");
    }

    public void addMinWxJsapiTicketQueryColumn() {
        this.queryColumns.add("min(wx_jsapi_ticket) min_wx_jsapi_ticket");
    }

    public void addAvgWxJsapiTicketQueryColumn() {
        this.queryColumns.add(" avg(wx_jsapi_ticket) avg_wx_jsapi_ticket");
    }

    public void addCountWxJsapiTicketQueryColumn() {
        this.queryColumns.add(" count(wx_jsapi_ticket) count_wx_jsapi_ticket");
    }

    public void addCountDistinctWxJsapiTicketQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_jsapi_ticket) count_distinct_wx_jsapi_ticket");
    }

    public void addSumWxJsapiTicketQueryColumn() {
        this.queryColumns.add(" sum(wx_jsapi_ticket) sum_wx_jsapi_ticket");
    }

    public void addWxTokenExpireQueryColumn() {
        this.queryColumns.add("wx_token_expire");
    }

    public void addMaxWxTokenExpireQueryColumn() {
        this.queryColumns.add("max(wx_token_expire) max_wx_token_expire");
    }

    public void addMinWxTokenExpireQueryColumn() {
        this.queryColumns.add("min(wx_token_expire) min_wx_token_expire");
    }

    public void addAvgWxTokenExpireQueryColumn() {
        this.queryColumns.add(" avg(wx_token_expire) avg_wx_token_expire");
    }

    public void addCountWxTokenExpireQueryColumn() {
        this.queryColumns.add(" count(wx_token_expire) count_wx_token_expire");
    }

    public void addCountDistinctWxTokenExpireQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_token_expire) count_distinct_wx_token_expire");
    }

    public void addSumWxTokenExpireQueryColumn() {
        this.queryColumns.add(" sum(wx_token_expire) sum_wx_token_expire");
    }

    public void addAppIdQueryColumn() {
        this.queryColumns.add("app_id");
    }

    public void addMaxAppIdQueryColumn() {
        this.queryColumns.add("max(app_id) max_app_id");
    }

    public void addMinAppIdQueryColumn() {
        this.queryColumns.add("min(app_id) min_app_id");
    }

    public void addAvgAppIdQueryColumn() {
        this.queryColumns.add(" avg(app_id) avg_app_id");
    }

    public void addCountAppIdQueryColumn() {
        this.queryColumns.add(" count(app_id) count_app_id");
    }

    public void addCountDistinctAppIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT app_id) count_distinct_app_id");
    }

    public void addSumAppIdQueryColumn() {
        this.queryColumns.add(" sum(app_id) sum_app_id");
    }

    public void addAppSecretQueryColumn() {
        this.queryColumns.add("app_secret");
    }

    public void addMaxAppSecretQueryColumn() {
        this.queryColumns.add("max(app_secret) max_app_secret");
    }

    public void addMinAppSecretQueryColumn() {
        this.queryColumns.add("min(app_secret) min_app_secret");
    }

    public void addAvgAppSecretQueryColumn() {
        this.queryColumns.add(" avg(app_secret) avg_app_secret");
    }

    public void addCountAppSecretQueryColumn() {
        this.queryColumns.add(" count(app_secret) count_app_secret");
    }

    public void addCountDistinctAppSecretQueryColumn() {
        this.queryColumns.add(" count( DISTINCT app_secret) count_distinct_app_secret");
    }

    public void addSumAppSecretQueryColumn() {
        this.queryColumns.add(" sum(app_secret) sum_app_secret");
    }

    public void addAccessTokenQueryColumn() {
        this.queryColumns.add("access_token");
    }

    public void addMaxAccessTokenQueryColumn() {
        this.queryColumns.add("max(access_token) max_access_token");
    }

    public void addMinAccessTokenQueryColumn() {
        this.queryColumns.add("min(access_token) min_access_token");
    }

    public void addAvgAccessTokenQueryColumn() {
        this.queryColumns.add(" avg(access_token) avg_access_token");
    }

    public void addCountAccessTokenQueryColumn() {
        this.queryColumns.add(" count(access_token) count_access_token");
    }

    public void addCountDistinctAccessTokenQueryColumn() {
        this.queryColumns.add(" count( DISTINCT access_token) count_distinct_access_token");
    }

    public void addSumAccessTokenQueryColumn() {
        this.queryColumns.add(" sum(access_token) sum_access_token");
    }

    public void addRefreshTokenQueryColumn() {
        this.queryColumns.add("refresh_token");
    }

    public void addMaxRefreshTokenQueryColumn() {
        this.queryColumns.add("max(refresh_token) max_refresh_token");
    }

    public void addMinRefreshTokenQueryColumn() {
        this.queryColumns.add("min(refresh_token) min_refresh_token");
    }

    public void addAvgRefreshTokenQueryColumn() {
        this.queryColumns.add(" avg(refresh_token) avg_refresh_token");
    }

    public void addCountRefreshTokenQueryColumn() {
        this.queryColumns.add(" count(refresh_token) count_refresh_token");
    }

    public void addCountDistinctRefreshTokenQueryColumn() {
        this.queryColumns.add(" count( DISTINCT refresh_token) count_distinct_refresh_token");
    }

    public void addSumRefreshTokenQueryColumn() {
        this.queryColumns.add(" sum(refresh_token) sum_refresh_token");
    }

    public void addWxMchidQueryColumn() {
        this.queryColumns.add("wx_mchid");
    }

    public void addMaxWxMchidQueryColumn() {
        this.queryColumns.add("max(wx_mchid) max_wx_mchid");
    }

    public void addMinWxMchidQueryColumn() {
        this.queryColumns.add("min(wx_mchid) min_wx_mchid");
    }

    public void addAvgWxMchidQueryColumn() {
        this.queryColumns.add(" avg(wx_mchid) avg_wx_mchid");
    }

    public void addCountWxMchidQueryColumn() {
        this.queryColumns.add(" count(wx_mchid) count_wx_mchid");
    }

    public void addCountDistinctWxMchidQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_mchid) count_distinct_wx_mchid");
    }

    public void addSumWxMchidQueryColumn() {
        this.queryColumns.add(" sum(wx_mchid) sum_wx_mchid");
    }

    public void addWxSecrteUrlQueryColumn() {
        this.queryColumns.add("wx_secrte_url");
    }

    public void addMaxWxSecrteUrlQueryColumn() {
        this.queryColumns.add("max(wx_secrte_url) max_wx_secrte_url");
    }

    public void addMinWxSecrteUrlQueryColumn() {
        this.queryColumns.add("min(wx_secrte_url) min_wx_secrte_url");
    }

    public void addAvgWxSecrteUrlQueryColumn() {
        this.queryColumns.add(" avg(wx_secrte_url) avg_wx_secrte_url");
    }

    public void addCountWxSecrteUrlQueryColumn() {
        this.queryColumns.add(" count(wx_secrte_url) count_wx_secrte_url");
    }

    public void addCountDistinctWxSecrteUrlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_secrte_url) count_distinct_wx_secrte_url");
    }

    public void addSumWxSecrteUrlQueryColumn() {
        this.queryColumns.add(" sum(wx_secrte_url) sum_wx_secrte_url");
    }

    public void addWxTicketExpireQueryColumn() {
        this.queryColumns.add("wx_ticket_expire");
    }

    public void addMaxWxTicketExpireQueryColumn() {
        this.queryColumns.add("max(wx_ticket_expire) max_wx_ticket_expire");
    }

    public void addMinWxTicketExpireQueryColumn() {
        this.queryColumns.add("min(wx_ticket_expire) min_wx_ticket_expire");
    }

    public void addAvgWxTicketExpireQueryColumn() {
        this.queryColumns.add(" avg(wx_ticket_expire) avg_wx_ticket_expire");
    }

    public void addCountWxTicketExpireQueryColumn() {
        this.queryColumns.add(" count(wx_ticket_expire) count_wx_ticket_expire");
    }

    public void addCountDistinctWxTicketExpireQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_ticket_expire) count_distinct_wx_ticket_expire");
    }

    public void addSumWxTicketExpireQueryColumn() {
        this.queryColumns.add(" sum(wx_ticket_expire) sum_wx_ticket_expire");
    }

    public void addWxAppKeyQueryColumn() {
        this.queryColumns.add("wx_app_key");
    }

    public void addMaxWxAppKeyQueryColumn() {
        this.queryColumns.add("max(wx_app_key) max_wx_app_key");
    }

    public void addMinWxAppKeyQueryColumn() {
        this.queryColumns.add("min(wx_app_key) min_wx_app_key");
    }

    public void addAvgWxAppKeyQueryColumn() {
        this.queryColumns.add(" avg(wx_app_key) avg_wx_app_key");
    }

    public void addCountWxAppKeyQueryColumn() {
        this.queryColumns.add(" count(wx_app_key) count_wx_app_key");
    }

    public void addCountDistinctWxAppKeyQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_app_key) count_distinct_wx_app_key");
    }

    public void addSumWxAppKeyQueryColumn() {
        this.queryColumns.add(" sum(wx_app_key) sum_wx_app_key");
    }

    public void addWxImgUrlQueryColumn() {
        this.queryColumns.add("wx_img_url");
    }

    public void addMaxWxImgUrlQueryColumn() {
        this.queryColumns.add("max(wx_img_url) max_wx_img_url");
    }

    public void addMinWxImgUrlQueryColumn() {
        this.queryColumns.add("min(wx_img_url) min_wx_img_url");
    }

    public void addAvgWxImgUrlQueryColumn() {
        this.queryColumns.add(" avg(wx_img_url) avg_wx_img_url");
    }

    public void addCountWxImgUrlQueryColumn() {
        this.queryColumns.add(" count(wx_img_url) count_wx_img_url");
    }

    public void addCountDistinctWxImgUrlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_img_url) count_distinct_wx_img_url");
    }

    public void addSumWxImgUrlQueryColumn() {
        this.queryColumns.add(" sum(wx_img_url) sum_wx_img_url");
    }

    public void addWxQrcodeQueryColumn() {
        this.queryColumns.add("wx_qrcode");
    }

    public void addMaxWxQrcodeQueryColumn() {
        this.queryColumns.add("max(wx_qrcode) max_wx_qrcode");
    }

    public void addMinWxQrcodeQueryColumn() {
        this.queryColumns.add("min(wx_qrcode) min_wx_qrcode");
    }

    public void addAvgWxQrcodeQueryColumn() {
        this.queryColumns.add(" avg(wx_qrcode) avg_wx_qrcode");
    }

    public void addCountWxQrcodeQueryColumn() {
        this.queryColumns.add(" count(wx_qrcode) count_wx_qrcode");
    }

    public void addCountDistinctWxQrcodeQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_qrcode) count_distinct_wx_qrcode");
    }

    public void addSumWxQrcodeQueryColumn() {
        this.queryColumns.add(" sum(wx_qrcode) sum_wx_qrcode");
    }

    public void addSmsSerialQueryColumn() {
        this.queryColumns.add("sms_serial");
    }

    public void addMaxSmsSerialQueryColumn() {
        this.queryColumns.add("max(sms_serial) max_sms_serial");
    }

    public void addMinSmsSerialQueryColumn() {
        this.queryColumns.add("min(sms_serial) min_sms_serial");
    }

    public void addAvgSmsSerialQueryColumn() {
        this.queryColumns.add(" avg(sms_serial) avg_sms_serial");
    }

    public void addCountSmsSerialQueryColumn() {
        this.queryColumns.add(" count(sms_serial) count_sms_serial");
    }

    public void addCountDistinctSmsSerialQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sms_serial) count_distinct_sms_serial");
    }

    public void addSumSmsSerialQueryColumn() {
        this.queryColumns.add(" sum(sms_serial) sum_sms_serial");
    }

    public void addSmsNotifySignQueryColumn() {
        this.queryColumns.add("sms_notify_sign");
    }

    public void addMaxSmsNotifySignQueryColumn() {
        this.queryColumns.add("max(sms_notify_sign) max_sms_notify_sign");
    }

    public void addMinSmsNotifySignQueryColumn() {
        this.queryColumns.add("min(sms_notify_sign) min_sms_notify_sign");
    }

    public void addAvgSmsNotifySignQueryColumn() {
        this.queryColumns.add(" avg(sms_notify_sign) avg_sms_notify_sign");
    }

    public void addCountSmsNotifySignQueryColumn() {
        this.queryColumns.add(" count(sms_notify_sign) count_sms_notify_sign");
    }

    public void addCountDistinctSmsNotifySignQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sms_notify_sign) count_distinct_sms_notify_sign");
    }

    public void addSumSmsNotifySignQueryColumn() {
        this.queryColumns.add(" sum(sms_notify_sign) sum_sms_notify_sign");
    }

    public void addSmsSaleSignQueryColumn() {
        this.queryColumns.add("sms_sale_sign");
    }

    public void addMaxSmsSaleSignQueryColumn() {
        this.queryColumns.add("max(sms_sale_sign) max_sms_sale_sign");
    }

    public void addMinSmsSaleSignQueryColumn() {
        this.queryColumns.add("min(sms_sale_sign) min_sms_sale_sign");
    }

    public void addAvgSmsSaleSignQueryColumn() {
        this.queryColumns.add(" avg(sms_sale_sign) avg_sms_sale_sign");
    }

    public void addCountSmsSaleSignQueryColumn() {
        this.queryColumns.add(" count(sms_sale_sign) count_sms_sale_sign");
    }

    public void addCountDistinctSmsSaleSignQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sms_sale_sign) count_distinct_sms_sale_sign");
    }

    public void addSumSmsSaleSignQueryColumn() {
        this.queryColumns.add(" sum(sms_sale_sign) sum_sms_sale_sign");
    }

    public void addEmailSignQueryColumn() {
        this.queryColumns.add("email_sign");
    }

    public void addMaxEmailSignQueryColumn() {
        this.queryColumns.add("max(email_sign) max_email_sign");
    }

    public void addMinEmailSignQueryColumn() {
        this.queryColumns.add("min(email_sign) min_email_sign");
    }

    public void addAvgEmailSignQueryColumn() {
        this.queryColumns.add(" avg(email_sign) avg_email_sign");
    }

    public void addCountEmailSignQueryColumn() {
        this.queryColumns.add(" count(email_sign) count_email_sign");
    }

    public void addCountDistinctEmailSignQueryColumn() {
        this.queryColumns.add(" count( DISTINCT email_sign) count_distinct_email_sign");
    }

    public void addSumEmailSignQueryColumn() {
        this.queryColumns.add(" sum(email_sign) sum_email_sign");
    }

    public void addEmailFromNameQueryColumn() {
        this.queryColumns.add("email_from_name");
    }

    public void addMaxEmailFromNameQueryColumn() {
        this.queryColumns.add("max(email_from_name) max_email_from_name");
    }

    public void addMinEmailFromNameQueryColumn() {
        this.queryColumns.add("min(email_from_name) min_email_from_name");
    }

    public void addAvgEmailFromNameQueryColumn() {
        this.queryColumns.add(" avg(email_from_name) avg_email_from_name");
    }

    public void addCountEmailFromNameQueryColumn() {
        this.queryColumns.add(" count(email_from_name) count_email_from_name");
    }

    public void addCountDistinctEmailFromNameQueryColumn() {
        this.queryColumns.add(" count( DISTINCT email_from_name) count_distinct_email_from_name");
    }

    public void addSumEmailFromNameQueryColumn() {
        this.queryColumns.add(" sum(email_from_name) sum_email_from_name");
    }

    public void addDatasourceIdQueryColumn() {
        this.queryColumns.add("datasource_id");
    }

    public void addMaxDatasourceIdQueryColumn() {
        this.queryColumns.add("max(datasource_id) max_datasource_id");
    }

    public void addMinDatasourceIdQueryColumn() {
        this.queryColumns.add("min(datasource_id) min_datasource_id");
    }

    public void addAvgDatasourceIdQueryColumn() {
        this.queryColumns.add(" avg(datasource_id) avg_datasource_id");
    }

    public void addCountDatasourceIdQueryColumn() {
        this.queryColumns.add(" count(datasource_id) count_datasource_id");
    }

    public void addCountDistinctDatasourceIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT datasource_id) count_distinct_datasource_id");
    }

    public void addSumDatasourceIdQueryColumn() {
        this.queryColumns.add(" sum(datasource_id) sum_datasource_id");
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

        public Criteria andSellerTypeIsNull() {
            addCriterion("seller_type is null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIsNotNull() {
            addCriterion("seller_type is not null");
            return (Criteria) this;
        }

        public Criteria andSellerTypeEqualTo(String value) {
            addCriterion("seller_type =", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotEqualTo(String value) {
            addCriterion("seller_type <>", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThan(String value) {
            addCriterion("seller_type >", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("seller_type >=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThan(String value) {
            addCriterion("seller_type <", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLessThanOrEqualTo(String value) {
            addCriterion("seller_type <=", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeLike(String value) {
            addCriterion("seller_type like", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotLike(String value) {
            addCriterion("seller_type not like", value, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeIn(List<String> values) {
            addCriterion("seller_type in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotIn(List<String> values) {
            addCriterion("seller_type not in", values, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeBetween(String value1, String value2) {
            addCriterion("seller_type between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerTypeNotBetween(String value1, String value2) {
            addCriterion("seller_type not between", value1, value2, "sellerType");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNull() {
            addCriterion("seller_name is null");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNotNull() {
            addCriterion("seller_name is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNameEqualTo(String value) {
            addCriterion("seller_name =", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotEqualTo(String value) {
            addCriterion("seller_name <>", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThan(String value) {
            addCriterion("seller_name >", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            addCriterion("seller_name >=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThan(String value) {
            addCriterion("seller_name <", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThanOrEqualTo(String value) {
            addCriterion("seller_name <=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLike(String value) {
            addCriterion("seller_name like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotLike(String value) {
            addCriterion("seller_name not like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameIn(List<String> values) {
            addCriterion("seller_name in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotIn(List<String> values) {
            addCriterion("seller_name not in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameBetween(String value1, String value2) {
            addCriterion("seller_name between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotBetween(String value1, String value2) {
            addCriterion("seller_name not between", value1, value2, "sellerName");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andWxNoIsNull() {
            addCriterion("wx_no is null");
            return (Criteria) this;
        }

        public Criteria andWxNoIsNotNull() {
            addCriterion("wx_no is not null");
            return (Criteria) this;
        }

        public Criteria andWxNoEqualTo(String value) {
            addCriterion("wx_no =", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotEqualTo(String value) {
            addCriterion("wx_no <>", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoGreaterThan(String value) {
            addCriterion("wx_no >", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoGreaterThanOrEqualTo(String value) {
            addCriterion("wx_no >=", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLessThan(String value) {
            addCriterion("wx_no <", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLessThanOrEqualTo(String value) {
            addCriterion("wx_no <=", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLike(String value) {
            addCriterion("wx_no like", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotLike(String value) {
            addCriterion("wx_no not like", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoIn(List<String> values) {
            addCriterion("wx_no in", values, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotIn(List<String> values) {
            addCriterion("wx_no not in", values, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoBetween(String value1, String value2) {
            addCriterion("wx_no between", value1, value2, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotBetween(String value1, String value2) {
            addCriterion("wx_no not between", value1, value2, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxAppIdIsNull() {
            addCriterion("wx_app_id is null");
            return (Criteria) this;
        }

        public Criteria andWxAppIdIsNotNull() {
            addCriterion("wx_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxAppIdEqualTo(String value) {
            addCriterion("wx_app_id =", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdNotEqualTo(String value) {
            addCriterion("wx_app_id <>", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdGreaterThan(String value) {
            addCriterion("wx_app_id >", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_app_id >=", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdLessThan(String value) {
            addCriterion("wx_app_id <", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdLessThanOrEqualTo(String value) {
            addCriterion("wx_app_id <=", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdLike(String value) {
            addCriterion("wx_app_id like", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdNotLike(String value) {
            addCriterion("wx_app_id not like", value, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdIn(List<String> values) {
            addCriterion("wx_app_id in", values, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdNotIn(List<String> values) {
            addCriterion("wx_app_id not in", values, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdBetween(String value1, String value2) {
            addCriterion("wx_app_id between", value1, value2, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppIdNotBetween(String value1, String value2) {
            addCriterion("wx_app_id not between", value1, value2, "wxAppId");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretIsNull() {
            addCriterion("wx_app_secret is null");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretIsNotNull() {
            addCriterion("wx_app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretEqualTo(String value) {
            addCriterion("wx_app_secret =", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretNotEqualTo(String value) {
            addCriterion("wx_app_secret <>", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretGreaterThan(String value) {
            addCriterion("wx_app_secret >", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("wx_app_secret >=", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretLessThan(String value) {
            addCriterion("wx_app_secret <", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretLessThanOrEqualTo(String value) {
            addCriterion("wx_app_secret <=", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretLike(String value) {
            addCriterion("wx_app_secret like", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretNotLike(String value) {
            addCriterion("wx_app_secret not like", value, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretIn(List<String> values) {
            addCriterion("wx_app_secret in", values, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretNotIn(List<String> values) {
            addCriterion("wx_app_secret not in", values, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretBetween(String value1, String value2) {
            addCriterion("wx_app_secret between", value1, value2, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAppSecretNotBetween(String value1, String value2) {
            addCriterion("wx_app_secret not between", value1, value2, "wxAppSecret");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIsNull() {
            addCriterion("wx_access_token is null");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIsNotNull() {
            addCriterion("wx_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenEqualTo(String value) {
            addCriterion("wx_access_token =", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotEqualTo(String value) {
            addCriterion("wx_access_token <>", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenGreaterThan(String value) {
            addCriterion("wx_access_token >", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("wx_access_token >=", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLessThan(String value) {
            addCriterion("wx_access_token <", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("wx_access_token <=", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLike(String value) {
            addCriterion("wx_access_token like", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotLike(String value) {
            addCriterion("wx_access_token not like", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIn(List<String> values) {
            addCriterion("wx_access_token in", values, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotIn(List<String> values) {
            addCriterion("wx_access_token not in", values, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenBetween(String value1, String value2) {
            addCriterion("wx_access_token between", value1, value2, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotBetween(String value1, String value2) {
            addCriterion("wx_access_token not between", value1, value2, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenIsNull() {
            addCriterion("wx_refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenIsNotNull() {
            addCriterion("wx_refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenEqualTo(String value) {
            addCriterion("wx_refresh_token =", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenNotEqualTo(String value) {
            addCriterion("wx_refresh_token <>", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenGreaterThan(String value) {
            addCriterion("wx_refresh_token >", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("wx_refresh_token >=", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenLessThan(String value) {
            addCriterion("wx_refresh_token <", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("wx_refresh_token <=", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenLike(String value) {
            addCriterion("wx_refresh_token like", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenNotLike(String value) {
            addCriterion("wx_refresh_token not like", value, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenIn(List<String> values) {
            addCriterion("wx_refresh_token in", values, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenNotIn(List<String> values) {
            addCriterion("wx_refresh_token not in", values, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenBetween(String value1, String value2) {
            addCriterion("wx_refresh_token between", value1, value2, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("wx_refresh_token not between", value1, value2, "wxRefreshToken");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketIsNull() {
            addCriterion("wx_jsapi_ticket is null");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketIsNotNull() {
            addCriterion("wx_jsapi_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketEqualTo(String value) {
            addCriterion("wx_jsapi_ticket =", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketNotEqualTo(String value) {
            addCriterion("wx_jsapi_ticket <>", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketGreaterThan(String value) {
            addCriterion("wx_jsapi_ticket >", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketGreaterThanOrEqualTo(String value) {
            addCriterion("wx_jsapi_ticket >=", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketLessThan(String value) {
            addCriterion("wx_jsapi_ticket <", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketLessThanOrEqualTo(String value) {
            addCriterion("wx_jsapi_ticket <=", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketLike(String value) {
            addCriterion("wx_jsapi_ticket like", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketNotLike(String value) {
            addCriterion("wx_jsapi_ticket not like", value, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketIn(List<String> values) {
            addCriterion("wx_jsapi_ticket in", values, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketNotIn(List<String> values) {
            addCriterion("wx_jsapi_ticket not in", values, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketBetween(String value1, String value2) {
            addCriterion("wx_jsapi_ticket between", value1, value2, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxJsapiTicketNotBetween(String value1, String value2) {
            addCriterion("wx_jsapi_ticket not between", value1, value2, "wxJsapiTicket");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireIsNull() {
            addCriterion("wx_token_expire is null");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireIsNotNull() {
            addCriterion("wx_token_expire is not null");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireEqualTo(Date value) {
            addCriterion("wx_token_expire =", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireNotEqualTo(Date value) {
            addCriterion("wx_token_expire <>", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireGreaterThan(Date value) {
            addCriterion("wx_token_expire >", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_token_expire >=", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireLessThan(Date value) {
            addCriterion("wx_token_expire <", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireLessThanOrEqualTo(Date value) {
            addCriterion("wx_token_expire <=", value, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireIn(List<Date> values) {
            addCriterion("wx_token_expire in", values, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireNotIn(List<Date> values) {
            addCriterion("wx_token_expire not in", values, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireBetween(Date value1, Date value2) {
            addCriterion("wx_token_expire between", value1, value2, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andWxTokenExpireNotBetween(Date value1, Date value2) {
            addCriterion("wx_token_expire not between", value1, value2, "wxTokenExpire");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("app_secret is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("app_secret is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("app_secret =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("app_secret <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("app_secret >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("app_secret >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("app_secret <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("app_secret <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("app_secret like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("app_secret not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("app_secret in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("app_secret not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("app_secret between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("app_secret not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNull() {
            addCriterion("refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            addCriterion("refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLike(String value) {
            addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andWxMchidIsNull() {
            addCriterion("wx_mchid is null");
            return (Criteria) this;
        }

        public Criteria andWxMchidIsNotNull() {
            addCriterion("wx_mchid is not null");
            return (Criteria) this;
        }

        public Criteria andWxMchidEqualTo(String value) {
            addCriterion("wx_mchid =", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidNotEqualTo(String value) {
            addCriterion("wx_mchid <>", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidGreaterThan(String value) {
            addCriterion("wx_mchid >", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_mchid >=", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidLessThan(String value) {
            addCriterion("wx_mchid <", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidLessThanOrEqualTo(String value) {
            addCriterion("wx_mchid <=", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidLike(String value) {
            addCriterion("wx_mchid like", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidNotLike(String value) {
            addCriterion("wx_mchid not like", value, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidIn(List<String> values) {
            addCriterion("wx_mchid in", values, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidNotIn(List<String> values) {
            addCriterion("wx_mchid not in", values, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidBetween(String value1, String value2) {
            addCriterion("wx_mchid between", value1, value2, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxMchidNotBetween(String value1, String value2) {
            addCriterion("wx_mchid not between", value1, value2, "wxMchid");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlIsNull() {
            addCriterion("wx_secrte_url is null");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlIsNotNull() {
            addCriterion("wx_secrte_url is not null");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlEqualTo(String value) {
            addCriterion("wx_secrte_url =", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlNotEqualTo(String value) {
            addCriterion("wx_secrte_url <>", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlGreaterThan(String value) {
            addCriterion("wx_secrte_url >", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wx_secrte_url >=", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlLessThan(String value) {
            addCriterion("wx_secrte_url <", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlLessThanOrEqualTo(String value) {
            addCriterion("wx_secrte_url <=", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlLike(String value) {
            addCriterion("wx_secrte_url like", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlNotLike(String value) {
            addCriterion("wx_secrte_url not like", value, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlIn(List<String> values) {
            addCriterion("wx_secrte_url in", values, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlNotIn(List<String> values) {
            addCriterion("wx_secrte_url not in", values, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlBetween(String value1, String value2) {
            addCriterion("wx_secrte_url between", value1, value2, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxSecrteUrlNotBetween(String value1, String value2) {
            addCriterion("wx_secrte_url not between", value1, value2, "wxSecrteUrl");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireIsNull() {
            addCriterion("wx_ticket_expire is null");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireIsNotNull() {
            addCriterion("wx_ticket_expire is not null");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireEqualTo(Date value) {
            addCriterion("wx_ticket_expire =", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireNotEqualTo(Date value) {
            addCriterion("wx_ticket_expire <>", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireGreaterThan(Date value) {
            addCriterion("wx_ticket_expire >", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireGreaterThanOrEqualTo(Date value) {
            addCriterion("wx_ticket_expire >=", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireLessThan(Date value) {
            addCriterion("wx_ticket_expire <", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireLessThanOrEqualTo(Date value) {
            addCriterion("wx_ticket_expire <=", value, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireIn(List<Date> values) {
            addCriterion("wx_ticket_expire in", values, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireNotIn(List<Date> values) {
            addCriterion("wx_ticket_expire not in", values, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireBetween(Date value1, Date value2) {
            addCriterion("wx_ticket_expire between", value1, value2, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxTicketExpireNotBetween(Date value1, Date value2) {
            addCriterion("wx_ticket_expire not between", value1, value2, "wxTicketExpire");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyIsNull() {
            addCriterion("wx_app_key is null");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyIsNotNull() {
            addCriterion("wx_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyEqualTo(String value) {
            addCriterion("wx_app_key =", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyNotEqualTo(String value) {
            addCriterion("wx_app_key <>", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyGreaterThan(String value) {
            addCriterion("wx_app_key >", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("wx_app_key >=", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyLessThan(String value) {
            addCriterion("wx_app_key <", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyLessThanOrEqualTo(String value) {
            addCriterion("wx_app_key <=", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyLike(String value) {
            addCriterion("wx_app_key like", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyNotLike(String value) {
            addCriterion("wx_app_key not like", value, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyIn(List<String> values) {
            addCriterion("wx_app_key in", values, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyNotIn(List<String> values) {
            addCriterion("wx_app_key not in", values, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyBetween(String value1, String value2) {
            addCriterion("wx_app_key between", value1, value2, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxAppKeyNotBetween(String value1, String value2) {
            addCriterion("wx_app_key not between", value1, value2, "wxAppKey");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlIsNull() {
            addCriterion("wx_img_url is null");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlIsNotNull() {
            addCriterion("wx_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlEqualTo(String value) {
            addCriterion("wx_img_url =", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlNotEqualTo(String value) {
            addCriterion("wx_img_url <>", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlGreaterThan(String value) {
            addCriterion("wx_img_url >", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wx_img_url >=", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlLessThan(String value) {
            addCriterion("wx_img_url <", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlLessThanOrEqualTo(String value) {
            addCriterion("wx_img_url <=", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlLike(String value) {
            addCriterion("wx_img_url like", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlNotLike(String value) {
            addCriterion("wx_img_url not like", value, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlIn(List<String> values) {
            addCriterion("wx_img_url in", values, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlNotIn(List<String> values) {
            addCriterion("wx_img_url not in", values, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlBetween(String value1, String value2) {
            addCriterion("wx_img_url between", value1, value2, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxImgUrlNotBetween(String value1, String value2) {
            addCriterion("wx_img_url not between", value1, value2, "wxImgUrl");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIsNull() {
            addCriterion("wx_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIsNotNull() {
            addCriterion("wx_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeEqualTo(String value) {
            addCriterion("wx_qrcode =", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotEqualTo(String value) {
            addCriterion("wx_qrcode <>", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeGreaterThan(String value) {
            addCriterion("wx_qrcode >", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("wx_qrcode >=", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLessThan(String value) {
            addCriterion("wx_qrcode <", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLessThanOrEqualTo(String value) {
            addCriterion("wx_qrcode <=", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeLike(String value) {
            addCriterion("wx_qrcode like", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotLike(String value) {
            addCriterion("wx_qrcode not like", value, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeIn(List<String> values) {
            addCriterion("wx_qrcode in", values, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotIn(List<String> values) {
            addCriterion("wx_qrcode not in", values, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeBetween(String value1, String value2) {
            addCriterion("wx_qrcode between", value1, value2, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andWxQrcodeNotBetween(String value1, String value2) {
            addCriterion("wx_qrcode not between", value1, value2, "wxQrcode");
            return (Criteria) this;
        }

        public Criteria andSmsSerialIsNull() {
            addCriterion("sms_serial is null");
            return (Criteria) this;
        }

        public Criteria andSmsSerialIsNotNull() {
            addCriterion("sms_serial is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSerialEqualTo(String value) {
            addCriterion("sms_serial =", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialNotEqualTo(String value) {
            addCriterion("sms_serial <>", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialGreaterThan(String value) {
            addCriterion("sms_serial >", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialGreaterThanOrEqualTo(String value) {
            addCriterion("sms_serial >=", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialLessThan(String value) {
            addCriterion("sms_serial <", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialLessThanOrEqualTo(String value) {
            addCriterion("sms_serial <=", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialLike(String value) {
            addCriterion("sms_serial like", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialNotLike(String value) {
            addCriterion("sms_serial not like", value, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialIn(List<String> values) {
            addCriterion("sms_serial in", values, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialNotIn(List<String> values) {
            addCriterion("sms_serial not in", values, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialBetween(String value1, String value2) {
            addCriterion("sms_serial between", value1, value2, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsSerialNotBetween(String value1, String value2) {
            addCriterion("sms_serial not between", value1, value2, "smsSerial");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignIsNull() {
            addCriterion("sms_notify_sign is null");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignIsNotNull() {
            addCriterion("sms_notify_sign is not null");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignEqualTo(String value) {
            addCriterion("sms_notify_sign =", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignNotEqualTo(String value) {
            addCriterion("sms_notify_sign <>", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignGreaterThan(String value) {
            addCriterion("sms_notify_sign >", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignGreaterThanOrEqualTo(String value) {
            addCriterion("sms_notify_sign >=", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignLessThan(String value) {
            addCriterion("sms_notify_sign <", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignLessThanOrEqualTo(String value) {
            addCriterion("sms_notify_sign <=", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignLike(String value) {
            addCriterion("sms_notify_sign like", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignNotLike(String value) {
            addCriterion("sms_notify_sign not like", value, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignIn(List<String> values) {
            addCriterion("sms_notify_sign in", values, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignNotIn(List<String> values) {
            addCriterion("sms_notify_sign not in", values, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignBetween(String value1, String value2) {
            addCriterion("sms_notify_sign between", value1, value2, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsNotifySignNotBetween(String value1, String value2) {
            addCriterion("sms_notify_sign not between", value1, value2, "smsNotifySign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignIsNull() {
            addCriterion("sms_sale_sign is null");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignIsNotNull() {
            addCriterion("sms_sale_sign is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignEqualTo(String value) {
            addCriterion("sms_sale_sign =", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignNotEqualTo(String value) {
            addCriterion("sms_sale_sign <>", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignGreaterThan(String value) {
            addCriterion("sms_sale_sign >", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignGreaterThanOrEqualTo(String value) {
            addCriterion("sms_sale_sign >=", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignLessThan(String value) {
            addCriterion("sms_sale_sign <", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignLessThanOrEqualTo(String value) {
            addCriterion("sms_sale_sign <=", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignLike(String value) {
            addCriterion("sms_sale_sign like", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignNotLike(String value) {
            addCriterion("sms_sale_sign not like", value, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignIn(List<String> values) {
            addCriterion("sms_sale_sign in", values, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignNotIn(List<String> values) {
            addCriterion("sms_sale_sign not in", values, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignBetween(String value1, String value2) {
            addCriterion("sms_sale_sign between", value1, value2, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andSmsSaleSignNotBetween(String value1, String value2) {
            addCriterion("sms_sale_sign not between", value1, value2, "smsSaleSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignIsNull() {
            addCriterion("email_sign is null");
            return (Criteria) this;
        }

        public Criteria andEmailSignIsNotNull() {
            addCriterion("email_sign is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSignEqualTo(String value) {
            addCriterion("email_sign =", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignNotEqualTo(String value) {
            addCriterion("email_sign <>", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignGreaterThan(String value) {
            addCriterion("email_sign >", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignGreaterThanOrEqualTo(String value) {
            addCriterion("email_sign >=", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignLessThan(String value) {
            addCriterion("email_sign <", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignLessThanOrEqualTo(String value) {
            addCriterion("email_sign <=", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignLike(String value) {
            addCriterion("email_sign like", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignNotLike(String value) {
            addCriterion("email_sign not like", value, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignIn(List<String> values) {
            addCriterion("email_sign in", values, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignNotIn(List<String> values) {
            addCriterion("email_sign not in", values, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignBetween(String value1, String value2) {
            addCriterion("email_sign between", value1, value2, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailSignNotBetween(String value1, String value2) {
            addCriterion("email_sign not between", value1, value2, "emailSign");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameIsNull() {
            addCriterion("email_from_name is null");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameIsNotNull() {
            addCriterion("email_from_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameEqualTo(String value) {
            addCriterion("email_from_name =", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameNotEqualTo(String value) {
            addCriterion("email_from_name <>", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameGreaterThan(String value) {
            addCriterion("email_from_name >", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameGreaterThanOrEqualTo(String value) {
            addCriterion("email_from_name >=", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameLessThan(String value) {
            addCriterion("email_from_name <", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameLessThanOrEqualTo(String value) {
            addCriterion("email_from_name <=", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameLike(String value) {
            addCriterion("email_from_name like", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameNotLike(String value) {
            addCriterion("email_from_name not like", value, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameIn(List<String> values) {
            addCriterion("email_from_name in", values, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameNotIn(List<String> values) {
            addCriterion("email_from_name not in", values, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameBetween(String value1, String value2) {
            addCriterion("email_from_name between", value1, value2, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andEmailFromNameNotBetween(String value1, String value2) {
            addCriterion("email_from_name not between", value1, value2, "emailFromName");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdIsNull() {
            addCriterion("datasource_id is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdIsNotNull() {
            addCriterion("datasource_id is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdEqualTo(Long value) {
            addCriterion("datasource_id =", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdNotEqualTo(Long value) {
            addCriterion("datasource_id <>", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdGreaterThan(Long value) {
            addCriterion("datasource_id >", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("datasource_id >=", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdLessThan(Long value) {
            addCriterion("datasource_id <", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdLessThanOrEqualTo(Long value) {
            addCriterion("datasource_id <=", value, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdIn(List<Long> values) {
            addCriterion("datasource_id in", values, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdNotIn(List<Long> values) {
            addCriterion("datasource_id not in", values, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdBetween(Long value1, Long value2) {
            addCriterion("datasource_id between", value1, value2, "datasourceId");
            return (Criteria) this;
        }

        public Criteria andDatasourceIdNotBetween(Long value1, Long value2) {
            addCriterion("datasource_id not between", value1, value2, "datasourceId");
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