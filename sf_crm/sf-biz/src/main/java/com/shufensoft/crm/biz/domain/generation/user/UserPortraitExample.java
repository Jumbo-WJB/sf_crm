package com.shufensoft.crm.biz.domain.generation.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPortraitExample {
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

    public UserPortraitExample() {
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

    public void addLivenessQueryColumn() {
        this.queryColumns.add("liveness");
    }

    public void addMaxLivenessQueryColumn() {
        this.queryColumns.add("max(liveness) max_liveness");
    }

    public void addMinLivenessQueryColumn() {
        this.queryColumns.add("min(liveness) min_liveness");
    }

    public void addAvgLivenessQueryColumn() {
        this.queryColumns.add(" avg(liveness) avg_liveness");
    }

    public void addCountLivenessQueryColumn() {
        this.queryColumns.add(" count(liveness) count_liveness");
    }

    public void addCountDistinctLivenessQueryColumn() {
        this.queryColumns.add(" count( DISTINCT liveness) count_distinct_liveness");
    }

    public void addSumLivenessQueryColumn() {
        this.queryColumns.add(" sum(liveness) sum_liveness");
    }

    public void addContributionQueryColumn() {
        this.queryColumns.add("contribution");
    }

    public void addMaxContributionQueryColumn() {
        this.queryColumns.add("max(contribution) max_contribution");
    }

    public void addMinContributionQueryColumn() {
        this.queryColumns.add("min(contribution) min_contribution");
    }

    public void addAvgContributionQueryColumn() {
        this.queryColumns.add(" avg(contribution) avg_contribution");
    }

    public void addCountContributionQueryColumn() {
        this.queryColumns.add(" count(contribution) count_contribution");
    }

    public void addCountDistinctContributionQueryColumn() {
        this.queryColumns.add(" count( DISTINCT contribution) count_distinct_contribution");
    }

    public void addSumContributionQueryColumn() {
        this.queryColumns.add(" sum(contribution) sum_contribution");
    }

    public void addTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add("total_purchase_amount");
    }

    public void addMaxTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add("max(total_purchase_amount) max_total_purchase_amount");
    }

    public void addMinTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add("min(total_purchase_amount) min_total_purchase_amount");
    }

    public void addAvgTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add(" avg(total_purchase_amount) avg_total_purchase_amount");
    }

    public void addCountTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add(" count(total_purchase_amount) count_total_purchase_amount");
    }

    public void addCountDistinctTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT total_purchase_amount) count_distinct_total_purchase_amount");
    }

    public void addSumTotalPurchaseAmountQueryColumn() {
        this.queryColumns.add(" sum(total_purchase_amount) sum_total_purchase_amount");
    }

    public void addTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add("total_purchase_times");
    }

    public void addMaxTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add("max(total_purchase_times) max_total_purchase_times");
    }

    public void addMinTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add("min(total_purchase_times) min_total_purchase_times");
    }

    public void addAvgTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add(" avg(total_purchase_times) avg_total_purchase_times");
    }

    public void addCountTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add(" count(total_purchase_times) count_total_purchase_times");
    }

    public void addCountDistinctTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add(" count( DISTINCT total_purchase_times) count_distinct_total_purchase_times");
    }

    public void addSumTotalPurchaseTimesQueryColumn() {
        this.queryColumns.add(" sum(total_purchase_times) sum_total_purchase_times");
    }

    public void addInteractionsTimesQueryColumn() {
        this.queryColumns.add("interactions_times");
    }

    public void addMaxInteractionsTimesQueryColumn() {
        this.queryColumns.add("max(interactions_times) max_interactions_times");
    }

    public void addMinInteractionsTimesQueryColumn() {
        this.queryColumns.add("min(interactions_times) min_interactions_times");
    }

    public void addAvgInteractionsTimesQueryColumn() {
        this.queryColumns.add(" avg(interactions_times) avg_interactions_times");
    }

    public void addCountInteractionsTimesQueryColumn() {
        this.queryColumns.add(" count(interactions_times) count_interactions_times");
    }

    public void addCountDistinctInteractionsTimesQueryColumn() {
        this.queryColumns.add(" count( DISTINCT interactions_times) count_distinct_interactions_times");
    }

    public void addSumInteractionsTimesQueryColumn() {
        this.queryColumns.add(" sum(interactions_times) sum_interactions_times");
    }

    public void addSignInTimesQueryColumn() {
        this.queryColumns.add("sign_in_times");
    }

    public void addMaxSignInTimesQueryColumn() {
        this.queryColumns.add("max(sign_in_times) max_sign_in_times");
    }

    public void addMinSignInTimesQueryColumn() {
        this.queryColumns.add("min(sign_in_times) min_sign_in_times");
    }

    public void addAvgSignInTimesQueryColumn() {
        this.queryColumns.add(" avg(sign_in_times) avg_sign_in_times");
    }

    public void addCountSignInTimesQueryColumn() {
        this.queryColumns.add(" count(sign_in_times) count_sign_in_times");
    }

    public void addCountDistinctSignInTimesQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sign_in_times) count_distinct_sign_in_times");
    }

    public void addSumSignInTimesQueryColumn() {
        this.queryColumns.add(" sum(sign_in_times) sum_sign_in_times");
    }

    public void addLastSignInDateQueryColumn() {
        this.queryColumns.add("last_sign_in_date");
    }

    public void addMaxLastSignInDateQueryColumn() {
        this.queryColumns.add("max(last_sign_in_date) max_last_sign_in_date");
    }

    public void addMinLastSignInDateQueryColumn() {
        this.queryColumns.add("min(last_sign_in_date) min_last_sign_in_date");
    }

    public void addAvgLastSignInDateQueryColumn() {
        this.queryColumns.add(" avg(last_sign_in_date) avg_last_sign_in_date");
    }

    public void addCountLastSignInDateQueryColumn() {
        this.queryColumns.add(" count(last_sign_in_date) count_last_sign_in_date");
    }

    public void addCountDistinctLastSignInDateQueryColumn() {
        this.queryColumns.add(" count( DISTINCT last_sign_in_date) count_distinct_last_sign_in_date");
    }

    public void addSumLastSignInDateQueryColumn() {
        this.queryColumns.add(" sum(last_sign_in_date) sum_last_sign_in_date");
    }

    public void addLastPurchaseDateQueryColumn() {
        this.queryColumns.add("last_purchase_date");
    }

    public void addMaxLastPurchaseDateQueryColumn() {
        this.queryColumns.add("max(last_purchase_date) max_last_purchase_date");
    }

    public void addMinLastPurchaseDateQueryColumn() {
        this.queryColumns.add("min(last_purchase_date) min_last_purchase_date");
    }

    public void addAvgLastPurchaseDateQueryColumn() {
        this.queryColumns.add(" avg(last_purchase_date) avg_last_purchase_date");
    }

    public void addCountLastPurchaseDateQueryColumn() {
        this.queryColumns.add(" count(last_purchase_date) count_last_purchase_date");
    }

    public void addCountDistinctLastPurchaseDateQueryColumn() {
        this.queryColumns.add(" count( DISTINCT last_purchase_date) count_distinct_last_purchase_date");
    }

    public void addSumLastPurchaseDateQueryColumn() {
        this.queryColumns.add(" sum(last_purchase_date) sum_last_purchase_date");
    }

    public void addFirstPurchaseDateQueryColumn() {
        this.queryColumns.add("first_purchase_date");
    }

    public void addMaxFirstPurchaseDateQueryColumn() {
        this.queryColumns.add("max(first_purchase_date) max_first_purchase_date");
    }

    public void addMinFirstPurchaseDateQueryColumn() {
        this.queryColumns.add("min(first_purchase_date) min_first_purchase_date");
    }

    public void addAvgFirstPurchaseDateQueryColumn() {
        this.queryColumns.add(" avg(first_purchase_date) avg_first_purchase_date");
    }

    public void addCountFirstPurchaseDateQueryColumn() {
        this.queryColumns.add(" count(first_purchase_date) count_first_purchase_date");
    }

    public void addCountDistinctFirstPurchaseDateQueryColumn() {
        this.queryColumns.add(" count( DISTINCT first_purchase_date) count_distinct_first_purchase_date");
    }

    public void addSumFirstPurchaseDateQueryColumn() {
        this.queryColumns.add(" sum(first_purchase_date) sum_first_purchase_date");
    }

    public void addLastPurchaseAmountQueryColumn() {
        this.queryColumns.add("last_purchase_amount");
    }

    public void addMaxLastPurchaseAmountQueryColumn() {
        this.queryColumns.add("max(last_purchase_amount) max_last_purchase_amount");
    }

    public void addMinLastPurchaseAmountQueryColumn() {
        this.queryColumns.add("min(last_purchase_amount) min_last_purchase_amount");
    }

    public void addAvgLastPurchaseAmountQueryColumn() {
        this.queryColumns.add(" avg(last_purchase_amount) avg_last_purchase_amount");
    }

    public void addCountLastPurchaseAmountQueryColumn() {
        this.queryColumns.add(" count(last_purchase_amount) count_last_purchase_amount");
    }

    public void addCountDistinctLastPurchaseAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT last_purchase_amount) count_distinct_last_purchase_amount");
    }

    public void addSumLastPurchaseAmountQueryColumn() {
        this.queryColumns.add(" sum(last_purchase_amount) sum_last_purchase_amount");
    }

    public void addMobilePurchaseRateQueryColumn() {
        this.queryColumns.add("mobile_purchase_rate");
    }

    public void addMaxMobilePurchaseRateQueryColumn() {
        this.queryColumns.add("max(mobile_purchase_rate) max_mobile_purchase_rate");
    }

    public void addMinMobilePurchaseRateQueryColumn() {
        this.queryColumns.add("min(mobile_purchase_rate) min_mobile_purchase_rate");
    }

    public void addAvgMobilePurchaseRateQueryColumn() {
        this.queryColumns.add(" avg(mobile_purchase_rate) avg_mobile_purchase_rate");
    }

    public void addCountMobilePurchaseRateQueryColumn() {
        this.queryColumns.add(" count(mobile_purchase_rate) count_mobile_purchase_rate");
    }

    public void addCountDistinctMobilePurchaseRateQueryColumn() {
        this.queryColumns.add(" count( DISTINCT mobile_purchase_rate) count_distinct_mobile_purchase_rate");
    }

    public void addSumMobilePurchaseRateQueryColumn() {
        this.queryColumns.add(" sum(mobile_purchase_rate) sum_mobile_purchase_rate");
    }

    public void addPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add("purchase_average_cycle");
    }

    public void addMaxPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add("max(purchase_average_cycle) max_purchase_average_cycle");
    }

    public void addMinPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add("min(purchase_average_cycle) min_purchase_average_cycle");
    }

    public void addAvgPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add(" avg(purchase_average_cycle) avg_purchase_average_cycle");
    }

    public void addCountPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add(" count(purchase_average_cycle) count_purchase_average_cycle");
    }

    public void addCountDistinctPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add(" count( DISTINCT purchase_average_cycle) count_distinct_purchase_average_cycle");
    }

    public void addSumPurchaseAverageCycleQueryColumn() {
        this.queryColumns.add(" sum(purchase_average_cycle) sum_purchase_average_cycle");
    }

    public void addPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("purchase_average_amount");
    }

    public void addMaxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("max(purchase_average_amount) max_purchase_average_amount");
    }

    public void addMinPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("min(purchase_average_amount) min_purchase_average_amount");
    }

    public void addAvgPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" avg(purchase_average_amount) avg_purchase_average_amount");
    }

    public void addCountPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" count(purchase_average_amount) count_purchase_average_amount");
    }

    public void addCountDistinctPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT purchase_average_amount) count_distinct_purchase_average_amount");
    }

    public void addSumPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" sum(purchase_average_amount) sum_purchase_average_amount");
    }

    public void addWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("wx_purchase_average_amount");
    }

    public void addMaxWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("max(wx_purchase_average_amount) max_wx_purchase_average_amount");
    }

    public void addMinWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add("min(wx_purchase_average_amount) min_wx_purchase_average_amount");
    }

    public void addAvgWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" avg(wx_purchase_average_amount) avg_wx_purchase_average_amount");
    }

    public void addCountWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" count(wx_purchase_average_amount) count_wx_purchase_average_amount");
    }

    public void addCountDistinctWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" count( DISTINCT wx_purchase_average_amount) count_distinct_wx_purchase_average_amount");
    }

    public void addSumWxPurchaseAverageAmountQueryColumn() {
        this.queryColumns.add(" sum(wx_purchase_average_amount) sum_wx_purchase_average_amount");
    }

    public void addSmsAcceptNumberQueryColumn() {
        this.queryColumns.add("sms_accept_number");
    }

    public void addMaxSmsAcceptNumberQueryColumn() {
        this.queryColumns.add("max(sms_accept_number) max_sms_accept_number");
    }

    public void addMinSmsAcceptNumberQueryColumn() {
        this.queryColumns.add("min(sms_accept_number) min_sms_accept_number");
    }

    public void addAvgSmsAcceptNumberQueryColumn() {
        this.queryColumns.add(" avg(sms_accept_number) avg_sms_accept_number");
    }

    public void addCountSmsAcceptNumberQueryColumn() {
        this.queryColumns.add(" count(sms_accept_number) count_sms_accept_number");
    }

    public void addCountDistinctSmsAcceptNumberQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sms_accept_number) count_distinct_sms_accept_number");
    }

    public void addSumSmsAcceptNumberQueryColumn() {
        this.queryColumns.add(" sum(sms_accept_number) sum_sms_accept_number");
    }

    public void addSmsAcceptCircleQueryColumn() {
        this.queryColumns.add("sms_accept_circle");
    }

    public void addMaxSmsAcceptCircleQueryColumn() {
        this.queryColumns.add("max(sms_accept_circle) max_sms_accept_circle");
    }

    public void addMinSmsAcceptCircleQueryColumn() {
        this.queryColumns.add("min(sms_accept_circle) min_sms_accept_circle");
    }

    public void addAvgSmsAcceptCircleQueryColumn() {
        this.queryColumns.add(" avg(sms_accept_circle) avg_sms_accept_circle");
    }

    public void addCountSmsAcceptCircleQueryColumn() {
        this.queryColumns.add(" count(sms_accept_circle) count_sms_accept_circle");
    }

    public void addCountDistinctSmsAcceptCircleQueryColumn() {
        this.queryColumns.add(" count( DISTINCT sms_accept_circle) count_distinct_sms_accept_circle");
    }

    public void addSumSmsAcceptCircleQueryColumn() {
        this.queryColumns.add(" sum(sms_accept_circle) sum_sms_accept_circle");
    }

    public void addEmailAcceptNumberQueryColumn() {
        this.queryColumns.add("email_accept_number");
    }

    public void addMaxEmailAcceptNumberQueryColumn() {
        this.queryColumns.add("max(email_accept_number) max_email_accept_number");
    }

    public void addMinEmailAcceptNumberQueryColumn() {
        this.queryColumns.add("min(email_accept_number) min_email_accept_number");
    }

    public void addAvgEmailAcceptNumberQueryColumn() {
        this.queryColumns.add(" avg(email_accept_number) avg_email_accept_number");
    }

    public void addCountEmailAcceptNumberQueryColumn() {
        this.queryColumns.add(" count(email_accept_number) count_email_accept_number");
    }

    public void addCountDistinctEmailAcceptNumberQueryColumn() {
        this.queryColumns.add(" count( DISTINCT email_accept_number) count_distinct_email_accept_number");
    }

    public void addSumEmailAcceptNumberQueryColumn() {
        this.queryColumns.add(" sum(email_accept_number) sum_email_accept_number");
    }

    public void addEmailAcceptCircleQueryColumn() {
        this.queryColumns.add("email_accept_circle");
    }

    public void addMaxEmailAcceptCircleQueryColumn() {
        this.queryColumns.add("max(email_accept_circle) max_email_accept_circle");
    }

    public void addMinEmailAcceptCircleQueryColumn() {
        this.queryColumns.add("min(email_accept_circle) min_email_accept_circle");
    }

    public void addAvgEmailAcceptCircleQueryColumn() {
        this.queryColumns.add(" avg(email_accept_circle) avg_email_accept_circle");
    }

    public void addCountEmailAcceptCircleQueryColumn() {
        this.queryColumns.add(" count(email_accept_circle) count_email_accept_circle");
    }

    public void addCountDistinctEmailAcceptCircleQueryColumn() {
        this.queryColumns.add(" count( DISTINCT email_accept_circle) count_distinct_email_accept_circle");
    }

    public void addSumEmailAcceptCircleQueryColumn() {
        this.queryColumns.add(" sum(email_accept_circle) sum_email_accept_circle");
    }

    public void addFancyQueryColumn() {
        this.queryColumns.add("fancy");
    }

    public void addMaxFancyQueryColumn() {
        this.queryColumns.add("max(fancy) max_fancy");
    }

    public void addMinFancyQueryColumn() {
        this.queryColumns.add("min(fancy) min_fancy");
    }

    public void addAvgFancyQueryColumn() {
        this.queryColumns.add(" avg(fancy) avg_fancy");
    }

    public void addCountFancyQueryColumn() {
        this.queryColumns.add(" count(fancy) count_fancy");
    }

    public void addCountDistinctFancyQueryColumn() {
        this.queryColumns.add(" count( DISTINCT fancy) count_distinct_fancy");
    }

    public void addSumFancyQueryColumn() {
        this.queryColumns.add(" sum(fancy) sum_fancy");
    }

    public void addGoodsRateQueryColumn() {
        this.queryColumns.add("goods_rate");
    }

    public void addMaxGoodsRateQueryColumn() {
        this.queryColumns.add("max(goods_rate) max_goods_rate");
    }

    public void addMinGoodsRateQueryColumn() {
        this.queryColumns.add("min(goods_rate) min_goods_rate");
    }

    public void addAvgGoodsRateQueryColumn() {
        this.queryColumns.add(" avg(goods_rate) avg_goods_rate");
    }

    public void addCountGoodsRateQueryColumn() {
        this.queryColumns.add(" count(goods_rate) count_goods_rate");
    }

    public void addCountDistinctGoodsRateQueryColumn() {
        this.queryColumns.add(" count( DISTINCT goods_rate) count_distinct_goods_rate");
    }

    public void addSumGoodsRateQueryColumn() {
        this.queryColumns.add(" sum(goods_rate) sum_goods_rate");
    }

    public void addContributionTmallQueryColumn() {
        this.queryColumns.add("contribution_tmall");
    }

    public void addMaxContributionTmallQueryColumn() {
        this.queryColumns.add("max(contribution_tmall) max_contribution_tmall");
    }

    public void addMinContributionTmallQueryColumn() {
        this.queryColumns.add("min(contribution_tmall) min_contribution_tmall");
    }

    public void addAvgContributionTmallQueryColumn() {
        this.queryColumns.add(" avg(contribution_tmall) avg_contribution_tmall");
    }

    public void addCountContributionTmallQueryColumn() {
        this.queryColumns.add(" count(contribution_tmall) count_contribution_tmall");
    }

    public void addCountDistinctContributionTmallQueryColumn() {
        this.queryColumns.add(" count( DISTINCT contribution_tmall) count_distinct_contribution_tmall");
    }

    public void addSumContributionTmallQueryColumn() {
        this.queryColumns.add(" sum(contribution_tmall) sum_contribution_tmall");
    }

    public void addContributionTbQueryColumn() {
        this.queryColumns.add("contribution_tb");
    }

    public void addMaxContributionTbQueryColumn() {
        this.queryColumns.add("max(contribution_tb) max_contribution_tb");
    }

    public void addMinContributionTbQueryColumn() {
        this.queryColumns.add("min(contribution_tb) min_contribution_tb");
    }

    public void addAvgContributionTbQueryColumn() {
        this.queryColumns.add(" avg(contribution_tb) avg_contribution_tb");
    }

    public void addCountContributionTbQueryColumn() {
        this.queryColumns.add(" count(contribution_tb) count_contribution_tb");
    }

    public void addCountDistinctContributionTbQueryColumn() {
        this.queryColumns.add(" count( DISTINCT contribution_tb) count_distinct_contribution_tb");
    }

    public void addSumContributionTbQueryColumn() {
        this.queryColumns.add(" sum(contribution_tb) sum_contribution_tb");
    }

    public void addContributionJdQueryColumn() {
        this.queryColumns.add("contribution_jd");
    }

    public void addMaxContributionJdQueryColumn() {
        this.queryColumns.add("max(contribution_jd) max_contribution_jd");
    }

    public void addMinContributionJdQueryColumn() {
        this.queryColumns.add("min(contribution_jd) min_contribution_jd");
    }

    public void addAvgContributionJdQueryColumn() {
        this.queryColumns.add(" avg(contribution_jd) avg_contribution_jd");
    }

    public void addCountContributionJdQueryColumn() {
        this.queryColumns.add(" count(contribution_jd) count_contribution_jd");
    }

    public void addCountDistinctContributionJdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT contribution_jd) count_distinct_contribution_jd");
    }

    public void addSumContributionJdQueryColumn() {
        this.queryColumns.add(" sum(contribution_jd) sum_contribution_jd");
    }

    public void addContributionYzQueryColumn() {
        this.queryColumns.add("contribution_yz");
    }

    public void addMaxContributionYzQueryColumn() {
        this.queryColumns.add("max(contribution_yz) max_contribution_yz");
    }

    public void addMinContributionYzQueryColumn() {
        this.queryColumns.add("min(contribution_yz) min_contribution_yz");
    }

    public void addAvgContributionYzQueryColumn() {
        this.queryColumns.add(" avg(contribution_yz) avg_contribution_yz");
    }

    public void addCountContributionYzQueryColumn() {
        this.queryColumns.add(" count(contribution_yz) count_contribution_yz");
    }

    public void addCountDistinctContributionYzQueryColumn() {
        this.queryColumns.add(" count( DISTINCT contribution_yz) count_distinct_contribution_yz");
    }

    public void addSumContributionYzQueryColumn() {
        this.queryColumns.add(" sum(contribution_yz) sum_contribution_yz");
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

        public Criteria andLivenessIsNull() {
            addCriterion("liveness is null");
            return (Criteria) this;
        }

        public Criteria andLivenessIsNotNull() {
            addCriterion("liveness is not null");
            return (Criteria) this;
        }

        public Criteria andLivenessEqualTo(Integer value) {
            addCriterion("liveness =", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessNotEqualTo(Integer value) {
            addCriterion("liveness <>", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessGreaterThan(Integer value) {
            addCriterion("liveness >", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessGreaterThanOrEqualTo(Integer value) {
            addCriterion("liveness >=", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessLessThan(Integer value) {
            addCriterion("liveness <", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessLessThanOrEqualTo(Integer value) {
            addCriterion("liveness <=", value, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessIn(List<Integer> values) {
            addCriterion("liveness in", values, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessNotIn(List<Integer> values) {
            addCriterion("liveness not in", values, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessBetween(Integer value1, Integer value2) {
            addCriterion("liveness between", value1, value2, "liveness");
            return (Criteria) this;
        }

        public Criteria andLivenessNotBetween(Integer value1, Integer value2) {
            addCriterion("liveness not between", value1, value2, "liveness");
            return (Criteria) this;
        }

        public Criteria andContributionIsNull() {
            addCriterion("contribution is null");
            return (Criteria) this;
        }

        public Criteria andContributionIsNotNull() {
            addCriterion("contribution is not null");
            return (Criteria) this;
        }

        public Criteria andContributionEqualTo(BigDecimal value) {
            addCriterion("contribution =", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionNotEqualTo(BigDecimal value) {
            addCriterion("contribution <>", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionGreaterThan(BigDecimal value) {
            addCriterion("contribution >", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution >=", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionLessThan(BigDecimal value) {
            addCriterion("contribution <", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution <=", value, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionIn(List<BigDecimal> values) {
            addCriterion("contribution in", values, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionNotIn(List<BigDecimal> values) {
            addCriterion("contribution not in", values, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution between", value1, value2, "contribution");
            return (Criteria) this;
        }

        public Criteria andContributionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution not between", value1, value2, "contribution");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountIsNull() {
            addCriterion("total_purchase_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountIsNotNull() {
            addCriterion("total_purchase_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountEqualTo(Long value) {
            addCriterion("total_purchase_amount =", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountNotEqualTo(Long value) {
            addCriterion("total_purchase_amount <>", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountGreaterThan(Long value) {
            addCriterion("total_purchase_amount >", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_purchase_amount >=", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountLessThan(Long value) {
            addCriterion("total_purchase_amount <", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_purchase_amount <=", value, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountIn(List<Long> values) {
            addCriterion("total_purchase_amount in", values, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountNotIn(List<Long> values) {
            addCriterion("total_purchase_amount not in", values, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountBetween(Long value1, Long value2) {
            addCriterion("total_purchase_amount between", value1, value2, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_purchase_amount not between", value1, value2, "totalPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesIsNull() {
            addCriterion("total_purchase_times is null");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesIsNotNull() {
            addCriterion("total_purchase_times is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesEqualTo(Integer value) {
            addCriterion("total_purchase_times =", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesNotEqualTo(Integer value) {
            addCriterion("total_purchase_times <>", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesGreaterThan(Integer value) {
            addCriterion("total_purchase_times >", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_purchase_times >=", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesLessThan(Integer value) {
            addCriterion("total_purchase_times <", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("total_purchase_times <=", value, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesIn(List<Integer> values) {
            addCriterion("total_purchase_times in", values, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesNotIn(List<Integer> values) {
            addCriterion("total_purchase_times not in", values, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesBetween(Integer value1, Integer value2) {
            addCriterion("total_purchase_times between", value1, value2, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andTotalPurchaseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("total_purchase_times not between", value1, value2, "totalPurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesIsNull() {
            addCriterion("interactions_times is null");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesIsNotNull() {
            addCriterion("interactions_times is not null");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesEqualTo(Integer value) {
            addCriterion("interactions_times =", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesNotEqualTo(Integer value) {
            addCriterion("interactions_times <>", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesGreaterThan(Integer value) {
            addCriterion("interactions_times >", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("interactions_times >=", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesLessThan(Integer value) {
            addCriterion("interactions_times <", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesLessThanOrEqualTo(Integer value) {
            addCriterion("interactions_times <=", value, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesIn(List<Integer> values) {
            addCriterion("interactions_times in", values, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesNotIn(List<Integer> values) {
            addCriterion("interactions_times not in", values, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesBetween(Integer value1, Integer value2) {
            addCriterion("interactions_times between", value1, value2, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andInteractionsTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("interactions_times not between", value1, value2, "interactionsTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesIsNull() {
            addCriterion("sign_in_times is null");
            return (Criteria) this;
        }

        public Criteria andSignInTimesIsNotNull() {
            addCriterion("sign_in_times is not null");
            return (Criteria) this;
        }

        public Criteria andSignInTimesEqualTo(Integer value) {
            addCriterion("sign_in_times =", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesNotEqualTo(Integer value) {
            addCriterion("sign_in_times <>", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesGreaterThan(Integer value) {
            addCriterion("sign_in_times >", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_in_times >=", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesLessThan(Integer value) {
            addCriterion("sign_in_times <", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesLessThanOrEqualTo(Integer value) {
            addCriterion("sign_in_times <=", value, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesIn(List<Integer> values) {
            addCriterion("sign_in_times in", values, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesNotIn(List<Integer> values) {
            addCriterion("sign_in_times not in", values, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesBetween(Integer value1, Integer value2) {
            addCriterion("sign_in_times between", value1, value2, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andSignInTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_in_times not between", value1, value2, "signInTimes");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateIsNull() {
            addCriterion("last_sign_in_date is null");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateIsNotNull() {
            addCriterion("last_sign_in_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateEqualTo(Date value) {
            addCriterion("last_sign_in_date =", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateNotEqualTo(Date value) {
            addCriterion("last_sign_in_date <>", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateGreaterThan(Date value) {
            addCriterion("last_sign_in_date >", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_sign_in_date >=", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateLessThan(Date value) {
            addCriterion("last_sign_in_date <", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateLessThanOrEqualTo(Date value) {
            addCriterion("last_sign_in_date <=", value, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateIn(List<Date> values) {
            addCriterion("last_sign_in_date in", values, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateNotIn(List<Date> values) {
            addCriterion("last_sign_in_date not in", values, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateBetween(Date value1, Date value2) {
            addCriterion("last_sign_in_date between", value1, value2, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastSignInDateNotBetween(Date value1, Date value2) {
            addCriterion("last_sign_in_date not between", value1, value2, "lastSignInDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateIsNull() {
            addCriterion("last_purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateIsNotNull() {
            addCriterion("last_purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateEqualTo(Date value) {
            addCriterion("last_purchase_date =", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateNotEqualTo(Date value) {
            addCriterion("last_purchase_date <>", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateGreaterThan(Date value) {
            addCriterion("last_purchase_date >", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_purchase_date >=", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateLessThan(Date value) {
            addCriterion("last_purchase_date <", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("last_purchase_date <=", value, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateIn(List<Date> values) {
            addCriterion("last_purchase_date in", values, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateNotIn(List<Date> values) {
            addCriterion("last_purchase_date not in", values, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateBetween(Date value1, Date value2) {
            addCriterion("last_purchase_date between", value1, value2, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("last_purchase_date not between", value1, value2, "lastPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateIsNull() {
            addCriterion("first_purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateIsNotNull() {
            addCriterion("first_purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateEqualTo(Date value) {
            addCriterion("first_purchase_date =", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateNotEqualTo(Date value) {
            addCriterion("first_purchase_date <>", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateGreaterThan(Date value) {
            addCriterion("first_purchase_date >", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("first_purchase_date >=", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateLessThan(Date value) {
            addCriterion("first_purchase_date <", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("first_purchase_date <=", value, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateIn(List<Date> values) {
            addCriterion("first_purchase_date in", values, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateNotIn(List<Date> values) {
            addCriterion("first_purchase_date not in", values, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateBetween(Date value1, Date value2) {
            addCriterion("first_purchase_date between", value1, value2, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andFirstPurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("first_purchase_date not between", value1, value2, "firstPurchaseDate");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountIsNull() {
            addCriterion("last_purchase_amount is null");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountIsNotNull() {
            addCriterion("last_purchase_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountEqualTo(Long value) {
            addCriterion("last_purchase_amount =", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountNotEqualTo(Long value) {
            addCriterion("last_purchase_amount <>", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountGreaterThan(Long value) {
            addCriterion("last_purchase_amount >", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("last_purchase_amount >=", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountLessThan(Long value) {
            addCriterion("last_purchase_amount <", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountLessThanOrEqualTo(Long value) {
            addCriterion("last_purchase_amount <=", value, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountIn(List<Long> values) {
            addCriterion("last_purchase_amount in", values, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountNotIn(List<Long> values) {
            addCriterion("last_purchase_amount not in", values, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountBetween(Long value1, Long value2) {
            addCriterion("last_purchase_amount between", value1, value2, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andLastPurchaseAmountNotBetween(Long value1, Long value2) {
            addCriterion("last_purchase_amount not between", value1, value2, "lastPurchaseAmount");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateIsNull() {
            addCriterion("mobile_purchase_rate is null");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateIsNotNull() {
            addCriterion("mobile_purchase_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateEqualTo(BigDecimal value) {
            addCriterion("mobile_purchase_rate =", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateNotEqualTo(BigDecimal value) {
            addCriterion("mobile_purchase_rate <>", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateGreaterThan(BigDecimal value) {
            addCriterion("mobile_purchase_rate >", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_purchase_rate >=", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateLessThan(BigDecimal value) {
            addCriterion("mobile_purchase_rate <", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_purchase_rate <=", value, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateIn(List<BigDecimal> values) {
            addCriterion("mobile_purchase_rate in", values, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateNotIn(List<BigDecimal> values) {
            addCriterion("mobile_purchase_rate not in", values, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_purchase_rate between", value1, value2, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andMobilePurchaseRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_purchase_rate not between", value1, value2, "mobilePurchaseRate");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleIsNull() {
            addCriterion("purchase_average_cycle is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleIsNotNull() {
            addCriterion("purchase_average_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleEqualTo(BigDecimal value) {
            addCriterion("purchase_average_cycle =", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleNotEqualTo(BigDecimal value) {
            addCriterion("purchase_average_cycle <>", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleGreaterThan(BigDecimal value) {
            addCriterion("purchase_average_cycle >", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_average_cycle >=", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleLessThan(BigDecimal value) {
            addCriterion("purchase_average_cycle <", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_average_cycle <=", value, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleIn(List<BigDecimal> values) {
            addCriterion("purchase_average_cycle in", values, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleNotIn(List<BigDecimal> values) {
            addCriterion("purchase_average_cycle not in", values, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_average_cycle between", value1, value2, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageCycleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_average_cycle not between", value1, value2, "purchaseAverageCycle");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountIsNull() {
            addCriterion("purchase_average_amount is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountIsNotNull() {
            addCriterion("purchase_average_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountEqualTo(Long value) {
            addCriterion("purchase_average_amount =", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountNotEqualTo(Long value) {
            addCriterion("purchase_average_amount <>", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountGreaterThan(Long value) {
            addCriterion("purchase_average_amount >", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_average_amount >=", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountLessThan(Long value) {
            addCriterion("purchase_average_amount <", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountLessThanOrEqualTo(Long value) {
            addCriterion("purchase_average_amount <=", value, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountIn(List<Long> values) {
            addCriterion("purchase_average_amount in", values, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountNotIn(List<Long> values) {
            addCriterion("purchase_average_amount not in", values, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountBetween(Long value1, Long value2) {
            addCriterion("purchase_average_amount between", value1, value2, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAverageAmountNotBetween(Long value1, Long value2) {
            addCriterion("purchase_average_amount not between", value1, value2, "purchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountIsNull() {
            addCriterion("wx_purchase_average_amount is null");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountIsNotNull() {
            addCriterion("wx_purchase_average_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountEqualTo(Long value) {
            addCriterion("wx_purchase_average_amount =", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountNotEqualTo(Long value) {
            addCriterion("wx_purchase_average_amount <>", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountGreaterThan(Long value) {
            addCriterion("wx_purchase_average_amount >", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("wx_purchase_average_amount >=", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountLessThan(Long value) {
            addCriterion("wx_purchase_average_amount <", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountLessThanOrEqualTo(Long value) {
            addCriterion("wx_purchase_average_amount <=", value, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountIn(List<Long> values) {
            addCriterion("wx_purchase_average_amount in", values, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountNotIn(List<Long> values) {
            addCriterion("wx_purchase_average_amount not in", values, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountBetween(Long value1, Long value2) {
            addCriterion("wx_purchase_average_amount between", value1, value2, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andWxPurchaseAverageAmountNotBetween(Long value1, Long value2) {
            addCriterion("wx_purchase_average_amount not between", value1, value2, "wxPurchaseAverageAmount");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberIsNull() {
            addCriterion("sms_accept_number is null");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberIsNotNull() {
            addCriterion("sms_accept_number is not null");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberEqualTo(Integer value) {
            addCriterion("sms_accept_number =", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberNotEqualTo(Integer value) {
            addCriterion("sms_accept_number <>", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberGreaterThan(Integer value) {
            addCriterion("sms_accept_number >", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_accept_number >=", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberLessThan(Integer value) {
            addCriterion("sms_accept_number <", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sms_accept_number <=", value, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberIn(List<Integer> values) {
            addCriterion("sms_accept_number in", values, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberNotIn(List<Integer> values) {
            addCriterion("sms_accept_number not in", values, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberBetween(Integer value1, Integer value2) {
            addCriterion("sms_accept_number between", value1, value2, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_accept_number not between", value1, value2, "smsAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleIsNull() {
            addCriterion("sms_accept_circle is null");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleIsNotNull() {
            addCriterion("sms_accept_circle is not null");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleEqualTo(Integer value) {
            addCriterion("sms_accept_circle =", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleNotEqualTo(Integer value) {
            addCriterion("sms_accept_circle <>", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleGreaterThan(Integer value) {
            addCriterion("sms_accept_circle >", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_accept_circle >=", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleLessThan(Integer value) {
            addCriterion("sms_accept_circle <", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleLessThanOrEqualTo(Integer value) {
            addCriterion("sms_accept_circle <=", value, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleIn(List<Integer> values) {
            addCriterion("sms_accept_circle in", values, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleNotIn(List<Integer> values) {
            addCriterion("sms_accept_circle not in", values, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleBetween(Integer value1, Integer value2) {
            addCriterion("sms_accept_circle between", value1, value2, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andSmsAcceptCircleNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_accept_circle not between", value1, value2, "smsAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberIsNull() {
            addCriterion("email_accept_number is null");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberIsNotNull() {
            addCriterion("email_accept_number is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberEqualTo(Integer value) {
            addCriterion("email_accept_number =", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberNotEqualTo(Integer value) {
            addCriterion("email_accept_number <>", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberGreaterThan(Integer value) {
            addCriterion("email_accept_number >", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_accept_number >=", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberLessThan(Integer value) {
            addCriterion("email_accept_number <", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberLessThanOrEqualTo(Integer value) {
            addCriterion("email_accept_number <=", value, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberIn(List<Integer> values) {
            addCriterion("email_accept_number in", values, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberNotIn(List<Integer> values) {
            addCriterion("email_accept_number not in", values, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberBetween(Integer value1, Integer value2) {
            addCriterion("email_accept_number between", value1, value2, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("email_accept_number not between", value1, value2, "emailAcceptNumber");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleIsNull() {
            addCriterion("email_accept_circle is null");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleIsNotNull() {
            addCriterion("email_accept_circle is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleEqualTo(Integer value) {
            addCriterion("email_accept_circle =", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleNotEqualTo(Integer value) {
            addCriterion("email_accept_circle <>", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleGreaterThan(Integer value) {
            addCriterion("email_accept_circle >", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_accept_circle >=", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleLessThan(Integer value) {
            addCriterion("email_accept_circle <", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleLessThanOrEqualTo(Integer value) {
            addCriterion("email_accept_circle <=", value, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleIn(List<Integer> values) {
            addCriterion("email_accept_circle in", values, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleNotIn(List<Integer> values) {
            addCriterion("email_accept_circle not in", values, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleBetween(Integer value1, Integer value2) {
            addCriterion("email_accept_circle between", value1, value2, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andEmailAcceptCircleNotBetween(Integer value1, Integer value2) {
            addCriterion("email_accept_circle not between", value1, value2, "emailAcceptCircle");
            return (Criteria) this;
        }

        public Criteria andFancyIsNull() {
            addCriterion("fancy is null");
            return (Criteria) this;
        }

        public Criteria andFancyIsNotNull() {
            addCriterion("fancy is not null");
            return (Criteria) this;
        }

        public Criteria andFancyEqualTo(String value) {
            addCriterion("fancy =", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyNotEqualTo(String value) {
            addCriterion("fancy <>", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyGreaterThan(String value) {
            addCriterion("fancy >", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyGreaterThanOrEqualTo(String value) {
            addCriterion("fancy >=", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyLessThan(String value) {
            addCriterion("fancy <", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyLessThanOrEqualTo(String value) {
            addCriterion("fancy <=", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyLike(String value) {
            addCriterion("fancy like", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyNotLike(String value) {
            addCriterion("fancy not like", value, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyIn(List<String> values) {
            addCriterion("fancy in", values, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyNotIn(List<String> values) {
            addCriterion("fancy not in", values, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyBetween(String value1, String value2) {
            addCriterion("fancy between", value1, value2, "fancy");
            return (Criteria) this;
        }

        public Criteria andFancyNotBetween(String value1, String value2) {
            addCriterion("fancy not between", value1, value2, "fancy");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIsNull() {
            addCriterion("goods_rate is null");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIsNotNull() {
            addCriterion("goods_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsRateEqualTo(BigDecimal value) {
            addCriterion("goods_rate =", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotEqualTo(BigDecimal value) {
            addCriterion("goods_rate <>", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateGreaterThan(BigDecimal value) {
            addCriterion("goods_rate >", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_rate >=", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateLessThan(BigDecimal value) {
            addCriterion("goods_rate <", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_rate <=", value, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateIn(List<BigDecimal> values) {
            addCriterion("goods_rate in", values, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotIn(List<BigDecimal> values) {
            addCriterion("goods_rate not in", values, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_rate between", value1, value2, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andGoodsRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_rate not between", value1, value2, "goodsRate");
            return (Criteria) this;
        }

        public Criteria andContributionTmallIsNull() {
            addCriterion("contribution_tmall is null");
            return (Criteria) this;
        }

        public Criteria andContributionTmallIsNotNull() {
            addCriterion("contribution_tmall is not null");
            return (Criteria) this;
        }

        public Criteria andContributionTmallEqualTo(BigDecimal value) {
            addCriterion("contribution_tmall =", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallNotEqualTo(BigDecimal value) {
            addCriterion("contribution_tmall <>", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallGreaterThan(BigDecimal value) {
            addCriterion("contribution_tmall >", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_tmall >=", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallLessThan(BigDecimal value) {
            addCriterion("contribution_tmall <", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_tmall <=", value, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallIn(List<BigDecimal> values) {
            addCriterion("contribution_tmall in", values, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallNotIn(List<BigDecimal> values) {
            addCriterion("contribution_tmall not in", values, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_tmall between", value1, value2, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTmallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_tmall not between", value1, value2, "contributionTmall");
            return (Criteria) this;
        }

        public Criteria andContributionTbIsNull() {
            addCriterion("contribution_tb is null");
            return (Criteria) this;
        }

        public Criteria andContributionTbIsNotNull() {
            addCriterion("contribution_tb is not null");
            return (Criteria) this;
        }

        public Criteria andContributionTbEqualTo(BigDecimal value) {
            addCriterion("contribution_tb =", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbNotEqualTo(BigDecimal value) {
            addCriterion("contribution_tb <>", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbGreaterThan(BigDecimal value) {
            addCriterion("contribution_tb >", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_tb >=", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbLessThan(BigDecimal value) {
            addCriterion("contribution_tb <", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_tb <=", value, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbIn(List<BigDecimal> values) {
            addCriterion("contribution_tb in", values, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbNotIn(List<BigDecimal> values) {
            addCriterion("contribution_tb not in", values, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_tb between", value1, value2, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionTbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_tb not between", value1, value2, "contributionTb");
            return (Criteria) this;
        }

        public Criteria andContributionJdIsNull() {
            addCriterion("contribution_jd is null");
            return (Criteria) this;
        }

        public Criteria andContributionJdIsNotNull() {
            addCriterion("contribution_jd is not null");
            return (Criteria) this;
        }

        public Criteria andContributionJdEqualTo(BigDecimal value) {
            addCriterion("contribution_jd =", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdNotEqualTo(BigDecimal value) {
            addCriterion("contribution_jd <>", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdGreaterThan(BigDecimal value) {
            addCriterion("contribution_jd >", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_jd >=", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdLessThan(BigDecimal value) {
            addCriterion("contribution_jd <", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_jd <=", value, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdIn(List<BigDecimal> values) {
            addCriterion("contribution_jd in", values, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdNotIn(List<BigDecimal> values) {
            addCriterion("contribution_jd not in", values, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_jd between", value1, value2, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionJdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_jd not between", value1, value2, "contributionJd");
            return (Criteria) this;
        }

        public Criteria andContributionYzIsNull() {
            addCriterion("contribution_yz is null");
            return (Criteria) this;
        }

        public Criteria andContributionYzIsNotNull() {
            addCriterion("contribution_yz is not null");
            return (Criteria) this;
        }

        public Criteria andContributionYzEqualTo(BigDecimal value) {
            addCriterion("contribution_yz =", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzNotEqualTo(BigDecimal value) {
            addCriterion("contribution_yz <>", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzGreaterThan(BigDecimal value) {
            addCriterion("contribution_yz >", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_yz >=", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzLessThan(BigDecimal value) {
            addCriterion("contribution_yz <", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contribution_yz <=", value, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzIn(List<BigDecimal> values) {
            addCriterion("contribution_yz in", values, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzNotIn(List<BigDecimal> values) {
            addCriterion("contribution_yz not in", values, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_yz between", value1, value2, "contributionYz");
            return (Criteria) this;
        }

        public Criteria andContributionYzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contribution_yz not between", value1, value2, "contributionYz");
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