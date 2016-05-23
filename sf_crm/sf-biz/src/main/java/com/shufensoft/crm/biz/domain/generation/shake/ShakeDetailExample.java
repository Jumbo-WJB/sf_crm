package com.shufensoft.crm.biz.domain.generation.shake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShakeDetailExample {
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

    public ShakeDetailExample() {
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

    public void addShareUrlQueryColumn() {
        this.queryColumns.add("share_url");
    }

    public void addMaxShareUrlQueryColumn() {
        this.queryColumns.add("max(share_url) max_share_url");
    }

    public void addMinShareUrlQueryColumn() {
        this.queryColumns.add("min(share_url) min_share_url");
    }

    public void addAvgShareUrlQueryColumn() {
        this.queryColumns.add(" avg(share_url) avg_share_url");
    }

    public void addCountShareUrlQueryColumn() {
        this.queryColumns.add(" count(share_url) count_share_url");
    }

    public void addSumShareUrlQueryColumn() {
        this.queryColumns.add(" sum(share_url) sum_share_url");
    }

    public void addWxNumberQueryColumn() {
        this.queryColumns.add("wx_number");
    }

    public void addMaxWxNumberQueryColumn() {
        this.queryColumns.add("max(wx_number) max_wx_number");
    }

    public void addMinWxNumberQueryColumn() {
        this.queryColumns.add("min(wx_number) min_wx_number");
    }

    public void addAvgWxNumberQueryColumn() {
        this.queryColumns.add(" avg(wx_number) avg_wx_number");
    }

    public void addCountWxNumberQueryColumn() {
        this.queryColumns.add(" count(wx_number) count_wx_number");
    }

    public void addSumWxNumberQueryColumn() {
        this.queryColumns.add(" sum(wx_number) sum_wx_number");
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

    public void addSumIsVerifyQueryColumn() {
        this.queryColumns.add(" sum(is_verify) sum_is_verify");
    }

    public void addIsSubscribeQueryColumn() {
        this.queryColumns.add("is_subscribe");
    }

    public void addMaxIsSubscribeQueryColumn() {
        this.queryColumns.add("max(is_subscribe) max_is_subscribe");
    }

    public void addMinIsSubscribeQueryColumn() {
        this.queryColumns.add("min(is_subscribe) min_is_subscribe");
    }

    public void addAvgIsSubscribeQueryColumn() {
        this.queryColumns.add(" avg(is_subscribe) avg_is_subscribe");
    }

    public void addCountIsSubscribeQueryColumn() {
        this.queryColumns.add(" count(is_subscribe) count_is_subscribe");
    }

    public void addSumIsSubscribeQueryColumn() {
        this.queryColumns.add(" sum(is_subscribe) sum_is_subscribe");
    }

    public void addGetNumQueryColumn() {
        this.queryColumns.add("get_num");
    }

    public void addMaxGetNumQueryColumn() {
        this.queryColumns.add("max(get_num) max_get_num");
    }

    public void addMinGetNumQueryColumn() {
        this.queryColumns.add("min(get_num) min_get_num");
    }

    public void addAvgGetNumQueryColumn() {
        this.queryColumns.add(" avg(get_num) avg_get_num");
    }

    public void addCountGetNumQueryColumn() {
        this.queryColumns.add(" count(get_num) count_get_num");
    }

    public void addSumGetNumQueryColumn() {
        this.queryColumns.add(" sum(get_num) sum_get_num");
    }

    public void addRandomNumQueryColumn() {
        this.queryColumns.add("random_num");
    }

    public void addMaxRandomNumQueryColumn() {
        this.queryColumns.add("max(random_num) max_random_num");
    }

    public void addMinRandomNumQueryColumn() {
        this.queryColumns.add("min(random_num) min_random_num");
    }

    public void addAvgRandomNumQueryColumn() {
        this.queryColumns.add(" avg(random_num) avg_random_num");
    }

    public void addCountRandomNumQueryColumn() {
        this.queryColumns.add(" count(random_num) count_random_num");
    }

    public void addSumRandomNumQueryColumn() {
        this.queryColumns.add(" sum(random_num) sum_random_num");
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

    public void addRockNumQueryColumn() {
        this.queryColumns.add("rock_num");
    }

    public void addMaxRockNumQueryColumn() {
        this.queryColumns.add("max(rock_num) max_rock_num");
    }

    public void addMinRockNumQueryColumn() {
        this.queryColumns.add("min(rock_num) min_rock_num");
    }

    public void addAvgRockNumQueryColumn() {
        this.queryColumns.add(" avg(rock_num) avg_rock_num");
    }

    public void addCountRockNumQueryColumn() {
        this.queryColumns.add(" count(rock_num) count_rock_num");
    }

    public void addSumRockNumQueryColumn() {
        this.queryColumns.add(" sum(rock_num) sum_rock_num");
    }

    public void addStartConfigQueryColumn() {
        this.queryColumns.add("start_config");
    }

    public void addMaxStartConfigQueryColumn() {
        this.queryColumns.add("max(start_config) max_start_config");
    }

    public void addMinStartConfigQueryColumn() {
        this.queryColumns.add("min(start_config) min_start_config");
    }

    public void addAvgStartConfigQueryColumn() {
        this.queryColumns.add(" avg(start_config) avg_start_config");
    }

    public void addCountStartConfigQueryColumn() {
        this.queryColumns.add(" count(start_config) count_start_config");
    }

    public void addSumStartConfigQueryColumn() {
        this.queryColumns.add(" sum(start_config) sum_start_config");
    }

    public void addCreateTimeQueryColumn() {
        this.queryColumns.add("create_time");
    }

    public void addMaxCreateTimeQueryColumn() {
        this.queryColumns.add("max(create_time) max_create_time");
    }

    public void addMinCreateTimeQueryColumn() {
        this.queryColumns.add("min(create_time) min_create_time");
    }

    public void addAvgCreateTimeQueryColumn() {
        this.queryColumns.add(" avg(create_time) avg_create_time");
    }

    public void addCountCreateTimeQueryColumn() {
        this.queryColumns.add(" count(create_time) count_create_time");
    }

    public void addSumCreateTimeQueryColumn() {
        this.queryColumns.add(" sum(create_time) sum_create_time");
    }

    public void addStartDateQueryColumn() {
        this.queryColumns.add("start_date");
    }

    public void addMaxStartDateQueryColumn() {
        this.queryColumns.add("max(start_date) max_start_date");
    }

    public void addMinStartDateQueryColumn() {
        this.queryColumns.add("min(start_date) min_start_date");
    }

    public void addAvgStartDateQueryColumn() {
        this.queryColumns.add(" avg(start_date) avg_start_date");
    }

    public void addCountStartDateQueryColumn() {
        this.queryColumns.add(" count(start_date) count_start_date");
    }

    public void addSumStartDateQueryColumn() {
        this.queryColumns.add(" sum(start_date) sum_start_date");
    }

    public void addEndDateQueryColumn() {
        this.queryColumns.add("end_date");
    }

    public void addMaxEndDateQueryColumn() {
        this.queryColumns.add("max(end_date) max_end_date");
    }

    public void addMinEndDateQueryColumn() {
        this.queryColumns.add("min(end_date) min_end_date");
    }

    public void addAvgEndDateQueryColumn() {
        this.queryColumns.add(" avg(end_date) avg_end_date");
    }

    public void addCountEndDateQueryColumn() {
        this.queryColumns.add(" count(end_date) count_end_date");
    }

    public void addSumEndDateQueryColumn() {
        this.queryColumns.add(" sum(end_date) sum_end_date");
    }

    public void addHbPoolIdQueryColumn() {
        this.queryColumns.add("hb_pool_id");
    }

    public void addMaxHbPoolIdQueryColumn() {
        this.queryColumns.add("max(hb_pool_id) max_hb_pool_id");
    }

    public void addMinHbPoolIdQueryColumn() {
        this.queryColumns.add("min(hb_pool_id) min_hb_pool_id");
    }

    public void addAvgHbPoolIdQueryColumn() {
        this.queryColumns.add(" avg(hb_pool_id) avg_hb_pool_id");
    }

    public void addCountHbPoolIdQueryColumn() {
        this.queryColumns.add(" count(hb_pool_id) count_hb_pool_id");
    }

    public void addSumHbPoolIdQueryColumn() {
        this.queryColumns.add(" sum(hb_pool_id) sum_hb_pool_id");
    }

    public void addHbPoolNameQueryColumn() {
        this.queryColumns.add("hb_pool_name");
    }

    public void addMaxHbPoolNameQueryColumn() {
        this.queryColumns.add("max(hb_pool_name) max_hb_pool_name");
    }

    public void addMinHbPoolNameQueryColumn() {
        this.queryColumns.add("min(hb_pool_name) min_hb_pool_name");
    }

    public void addAvgHbPoolNameQueryColumn() {
        this.queryColumns.add(" avg(hb_pool_name) avg_hb_pool_name");
    }

    public void addCountHbPoolNameQueryColumn() {
        this.queryColumns.add(" count(hb_pool_name) count_hb_pool_name");
    }

    public void addSumHbPoolNameQueryColumn() {
        this.queryColumns.add(" sum(hb_pool_name) sum_hb_pool_name");
    }

    public void addGetHbNumQueryColumn() {
        this.queryColumns.add("get_hb_num");
    }

    public void addMaxGetHbNumQueryColumn() {
        this.queryColumns.add("max(get_hb_num) max_get_hb_num");
    }

    public void addMinGetHbNumQueryColumn() {
        this.queryColumns.add("min(get_hb_num) min_get_hb_num");
    }

    public void addAvgGetHbNumQueryColumn() {
        this.queryColumns.add(" avg(get_hb_num) avg_get_hb_num");
    }

    public void addCountGetHbNumQueryColumn() {
        this.queryColumns.add(" count(get_hb_num) count_get_hb_num");
    }

    public void addSumGetHbNumQueryColumn() {
        this.queryColumns.add(" sum(get_hb_num) sum_get_hb_num");
    }

    public void addIsGetHbShareQueryColumn() {
        this.queryColumns.add("is_get_hb_share");
    }

    public void addMaxIsGetHbShareQueryColumn() {
        this.queryColumns.add("max(is_get_hb_share) max_is_get_hb_share");
    }

    public void addMinIsGetHbShareQueryColumn() {
        this.queryColumns.add("min(is_get_hb_share) min_is_get_hb_share");
    }

    public void addAvgIsGetHbShareQueryColumn() {
        this.queryColumns.add(" avg(is_get_hb_share) avg_is_get_hb_share");
    }

    public void addCountIsGetHbShareQueryColumn() {
        this.queryColumns.add(" count(is_get_hb_share) count_is_get_hb_share");
    }

    public void addSumIsGetHbShareQueryColumn() {
        this.queryColumns.add(" sum(is_get_hb_share) sum_is_get_hb_share");
    }

    public void addGetGiftNumQueryColumn() {
        this.queryColumns.add("get_gift_num");
    }

    public void addMaxGetGiftNumQueryColumn() {
        this.queryColumns.add("max(get_gift_num) max_get_gift_num");
    }

    public void addMinGetGiftNumQueryColumn() {
        this.queryColumns.add("min(get_gift_num) min_get_gift_num");
    }

    public void addAvgGetGiftNumQueryColumn() {
        this.queryColumns.add(" avg(get_gift_num) avg_get_gift_num");
    }

    public void addCountGetGiftNumQueryColumn() {
        this.queryColumns.add(" count(get_gift_num) count_get_gift_num");
    }

    public void addSumGetGiftNumQueryColumn() {
        this.queryColumns.add(" sum(get_gift_num) sum_get_gift_num");
    }

    public void addIsGetGiftShareQueryColumn() {
        this.queryColumns.add("is_get_gift_share");
    }

    public void addMaxIsGetGiftShareQueryColumn() {
        this.queryColumns.add("max(is_get_gift_share) max_is_get_gift_share");
    }

    public void addMinIsGetGiftShareQueryColumn() {
        this.queryColumns.add("min(is_get_gift_share) min_is_get_gift_share");
    }

    public void addAvgIsGetGiftShareQueryColumn() {
        this.queryColumns.add(" avg(is_get_gift_share) avg_is_get_gift_share");
    }

    public void addCountIsGetGiftShareQueryColumn() {
        this.queryColumns.add(" count(is_get_gift_share) count_is_get_gift_share");
    }

    public void addSumIsGetGiftShareQueryColumn() {
        this.queryColumns.add(" sum(is_get_gift_share) sum_is_get_gift_share");
    }

    public void addGoodsIdQueryColumn() {
        this.queryColumns.add("goods_id");
    }

    public void addMaxGoodsIdQueryColumn() {
        this.queryColumns.add("max(goods_id) max_goods_id");
    }

    public void addMinGoodsIdQueryColumn() {
        this.queryColumns.add("min(goods_id) min_goods_id");
    }

    public void addAvgGoodsIdQueryColumn() {
        this.queryColumns.add(" avg(goods_id) avg_goods_id");
    }

    public void addCountGoodsIdQueryColumn() {
        this.queryColumns.add(" count(goods_id) count_goods_id");
    }

    public void addSumGoodsIdQueryColumn() {
        this.queryColumns.add(" sum(goods_id) sum_goods_id");
    }

    public void addPointIntervalMinQueryColumn() {
        this.queryColumns.add("point_interval_min");
    }

    public void addMaxPointIntervalMinQueryColumn() {
        this.queryColumns.add("max(point_interval_min) max_point_interval_min");
    }

    public void addMinPointIntervalMinQueryColumn() {
        this.queryColumns.add("min(point_interval_min) min_point_interval_min");
    }

    public void addAvgPointIntervalMinQueryColumn() {
        this.queryColumns.add(" avg(point_interval_min) avg_point_interval_min");
    }

    public void addCountPointIntervalMinQueryColumn() {
        this.queryColumns.add(" count(point_interval_min) count_point_interval_min");
    }

    public void addSumPointIntervalMinQueryColumn() {
        this.queryColumns.add(" sum(point_interval_min) sum_point_interval_min");
    }

    public void addPointIntervalMaxQueryColumn() {
        this.queryColumns.add("point_interval_max");
    }

    public void addMaxPointIntervalMaxQueryColumn() {
        this.queryColumns.add("max(point_interval_max) max_point_interval_max");
    }

    public void addMinPointIntervalMaxQueryColumn() {
        this.queryColumns.add("min(point_interval_max) min_point_interval_max");
    }

    public void addAvgPointIntervalMaxQueryColumn() {
        this.queryColumns.add(" avg(point_interval_max) avg_point_interval_max");
    }

    public void addCountPointIntervalMaxQueryColumn() {
        this.queryColumns.add(" count(point_interval_max) count_point_interval_max");
    }

    public void addSumPointIntervalMaxQueryColumn() {
        this.queryColumns.add(" sum(point_interval_max) sum_point_interval_max");
    }

    public void addGetPointNumQueryColumn() {
        this.queryColumns.add("get_point_num");
    }

    public void addMaxGetPointNumQueryColumn() {
        this.queryColumns.add("max(get_point_num) max_get_point_num");
    }

    public void addMinGetPointNumQueryColumn() {
        this.queryColumns.add("min(get_point_num) min_get_point_num");
    }

    public void addAvgGetPointNumQueryColumn() {
        this.queryColumns.add(" avg(get_point_num) avg_get_point_num");
    }

    public void addCountGetPointNumQueryColumn() {
        this.queryColumns.add(" count(get_point_num) count_get_point_num");
    }

    public void addSumGetPointNumQueryColumn() {
        this.queryColumns.add(" sum(get_point_num) sum_get_point_num");
    }

    public void addIsGetPointShareQueryColumn() {
        this.queryColumns.add("is_get_point_share");
    }

    public void addMaxIsGetPointShareQueryColumn() {
        this.queryColumns.add("max(is_get_point_share) max_is_get_point_share");
    }

    public void addMinIsGetPointShareQueryColumn() {
        this.queryColumns.add("min(is_get_point_share) min_is_get_point_share");
    }

    public void addAvgIsGetPointShareQueryColumn() {
        this.queryColumns.add(" avg(is_get_point_share) avg_is_get_point_share");
    }

    public void addCountIsGetPointShareQueryColumn() {
        this.queryColumns.add(" count(is_get_point_share) count_is_get_point_share");
    }

    public void addSumIsGetPointShareQueryColumn() {
        this.queryColumns.add(" sum(is_get_point_share) sum_is_get_point_share");
    }

    public void addStatusQueryColumn() {
        this.queryColumns.add("status");
    }

    public void addMaxStatusQueryColumn() {
        this.queryColumns.add("max(status) max_status");
    }

    public void addMinStatusQueryColumn() {
        this.queryColumns.add("min(status) min_status");
    }

    public void addAvgStatusQueryColumn() {
        this.queryColumns.add(" avg(status) avg_status");
    }

    public void addCountStatusQueryColumn() {
        this.queryColumns.add(" count(status) count_status");
    }

    public void addSumStatusQueryColumn() {
        this.queryColumns.add(" sum(status) sum_status");
    }

    public void addIsShakePointQueryColumn() {
        this.queryColumns.add("is_shake_point");
    }

    public void addMaxIsShakePointQueryColumn() {
        this.queryColumns.add("max(is_shake_point) max_is_shake_point");
    }

    public void addMinIsShakePointQueryColumn() {
        this.queryColumns.add("min(is_shake_point) min_is_shake_point");
    }

    public void addAvgIsShakePointQueryColumn() {
        this.queryColumns.add(" avg(is_shake_point) avg_is_shake_point");
    }

    public void addCountIsShakePointQueryColumn() {
        this.queryColumns.add(" count(is_shake_point) count_is_shake_point");
    }

    public void addSumIsShakePointQueryColumn() {
        this.queryColumns.add(" sum(is_shake_point) sum_is_shake_point");
    }

    public void addIsShakeHbQueryColumn() {
        this.queryColumns.add("is_shake_hb");
    }

    public void addMaxIsShakeHbQueryColumn() {
        this.queryColumns.add("max(is_shake_hb) max_is_shake_hb");
    }

    public void addMinIsShakeHbQueryColumn() {
        this.queryColumns.add("min(is_shake_hb) min_is_shake_hb");
    }

    public void addAvgIsShakeHbQueryColumn() {
        this.queryColumns.add(" avg(is_shake_hb) avg_is_shake_hb");
    }

    public void addCountIsShakeHbQueryColumn() {
        this.queryColumns.add(" count(is_shake_hb) count_is_shake_hb");
    }

    public void addSumIsShakeHbQueryColumn() {
        this.queryColumns.add(" sum(is_shake_hb) sum_is_shake_hb");
    }

    public void addIsShakeGiftQueryColumn() {
        this.queryColumns.add("is_shake_gift");
    }

    public void addMaxIsShakeGiftQueryColumn() {
        this.queryColumns.add("max(is_shake_gift) max_is_shake_gift");
    }

    public void addMinIsShakeGiftQueryColumn() {
        this.queryColumns.add("min(is_shake_gift) min_is_shake_gift");
    }

    public void addAvgIsShakeGiftQueryColumn() {
        this.queryColumns.add(" avg(is_shake_gift) avg_is_shake_gift");
    }

    public void addCountIsShakeGiftQueryColumn() {
        this.queryColumns.add(" count(is_shake_gift) count_is_shake_gift");
    }

    public void addSumIsShakeGiftQueryColumn() {
        this.queryColumns.add(" sum(is_shake_gift) sum_is_shake_gift");
    }

    public void addGoodsNameQueryColumn() {
        this.queryColumns.add("goods_name");
    }

    public void addMaxGoodsNameQueryColumn() {
        this.queryColumns.add("max(goods_name) max_goods_name");
    }

    public void addMinGoodsNameQueryColumn() {
        this.queryColumns.add("min(goods_name) min_goods_name");
    }

    public void addAvgGoodsNameQueryColumn() {
        this.queryColumns.add(" avg(goods_name) avg_goods_name");
    }

    public void addCountGoodsNameQueryColumn() {
        this.queryColumns.add(" count(goods_name) count_goods_name");
    }

    public void addSumGoodsNameQueryColumn() {
        this.queryColumns.add(" sum(goods_name) sum_goods_name");
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

        public Criteria andRockIdIsNull() {
            addCriterion("rock_id is null");
            return (Criteria) this;
        }

        public Criteria andRockIdIsNotNull() {
            addCriterion("rock_id is not null");
            return (Criteria) this;
        }

        public Criteria andRockIdEqualTo(String value) {
            addCriterion("rock_id =", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotEqualTo(String value) {
            addCriterion("rock_id <>", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdGreaterThan(String value) {
            addCriterion("rock_id >", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdGreaterThanOrEqualTo(String value) {
            addCriterion("rock_id >=", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdLessThan(String value) {
            addCriterion("rock_id <", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdLessThanOrEqualTo(String value) {
            addCriterion("rock_id <=", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdLike(String value) {
            addCriterion("rock_id like", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotLike(String value) {
            addCriterion("rock_id not like", value, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdIn(List<String> values) {
            addCriterion("rock_id in", values, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotIn(List<String> values) {
            addCriterion("rock_id not in", values, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdBetween(String value1, String value2) {
            addCriterion("rock_id between", value1, value2, "rockId");
            return (Criteria) this;
        }

        public Criteria andRockIdNotBetween(String value1, String value2) {
            addCriterion("rock_id not between", value1, value2, "rockId");
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

        public Criteria andShareUrlIsNull() {
            addCriterion("share_url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_url not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andWxNumberIsNull() {
            addCriterion("wx_number is null");
            return (Criteria) this;
        }

        public Criteria andWxNumberIsNotNull() {
            addCriterion("wx_number is not null");
            return (Criteria) this;
        }

        public Criteria andWxNumberEqualTo(String value) {
            addCriterion("wx_number =", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberNotEqualTo(String value) {
            addCriterion("wx_number <>", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberGreaterThan(String value) {
            addCriterion("wx_number >", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberGreaterThanOrEqualTo(String value) {
            addCriterion("wx_number >=", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberLessThan(String value) {
            addCriterion("wx_number <", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberLessThanOrEqualTo(String value) {
            addCriterion("wx_number <=", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberLike(String value) {
            addCriterion("wx_number like", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberNotLike(String value) {
            addCriterion("wx_number not like", value, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberIn(List<String> values) {
            addCriterion("wx_number in", values, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberNotIn(List<String> values) {
            addCriterion("wx_number not in", values, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberBetween(String value1, String value2) {
            addCriterion("wx_number between", value1, value2, "wxNumber");
            return (Criteria) this;
        }

        public Criteria andWxNumberNotBetween(String value1, String value2) {
            addCriterion("wx_number not between", value1, value2, "wxNumber");
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

        public Criteria andIsSubscribeIsNull() {
            addCriterion("is_subscribe is null");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeIsNotNull() {
            addCriterion("is_subscribe is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeEqualTo(String value) {
            addCriterion("is_subscribe =", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotEqualTo(String value) {
            addCriterion("is_subscribe <>", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeGreaterThan(String value) {
            addCriterion("is_subscribe >", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeGreaterThanOrEqualTo(String value) {
            addCriterion("is_subscribe >=", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLessThan(String value) {
            addCriterion("is_subscribe <", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLessThanOrEqualTo(String value) {
            addCriterion("is_subscribe <=", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeLike(String value) {
            addCriterion("is_subscribe like", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotLike(String value) {
            addCriterion("is_subscribe not like", value, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeIn(List<String> values) {
            addCriterion("is_subscribe in", values, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotIn(List<String> values) {
            addCriterion("is_subscribe not in", values, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeBetween(String value1, String value2) {
            addCriterion("is_subscribe between", value1, value2, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andIsSubscribeNotBetween(String value1, String value2) {
            addCriterion("is_subscribe not between", value1, value2, "isSubscribe");
            return (Criteria) this;
        }

        public Criteria andGetNumIsNull() {
            addCriterion("get_num is null");
            return (Criteria) this;
        }

        public Criteria andGetNumIsNotNull() {
            addCriterion("get_num is not null");
            return (Criteria) this;
        }

        public Criteria andGetNumEqualTo(Integer value) {
            addCriterion("get_num =", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumNotEqualTo(Integer value) {
            addCriterion("get_num <>", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumGreaterThan(Integer value) {
            addCriterion("get_num >", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_num >=", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumLessThan(Integer value) {
            addCriterion("get_num <", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumLessThanOrEqualTo(Integer value) {
            addCriterion("get_num <=", value, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumIn(List<Integer> values) {
            addCriterion("get_num in", values, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumNotIn(List<Integer> values) {
            addCriterion("get_num not in", values, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumBetween(Integer value1, Integer value2) {
            addCriterion("get_num between", value1, value2, "getNum");
            return (Criteria) this;
        }

        public Criteria andGetNumNotBetween(Integer value1, Integer value2) {
            addCriterion("get_num not between", value1, value2, "getNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumIsNull() {
            addCriterion("random_num is null");
            return (Criteria) this;
        }

        public Criteria andRandomNumIsNotNull() {
            addCriterion("random_num is not null");
            return (Criteria) this;
        }

        public Criteria andRandomNumEqualTo(Integer value) {
            addCriterion("random_num =", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumNotEqualTo(Integer value) {
            addCriterion("random_num <>", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumGreaterThan(Integer value) {
            addCriterion("random_num >", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("random_num >=", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumLessThan(Integer value) {
            addCriterion("random_num <", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumLessThanOrEqualTo(Integer value) {
            addCriterion("random_num <=", value, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumIn(List<Integer> values) {
            addCriterion("random_num in", values, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumNotIn(List<Integer> values) {
            addCriterion("random_num not in", values, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumBetween(Integer value1, Integer value2) {
            addCriterion("random_num between", value1, value2, "randomNum");
            return (Criteria) this;
        }

        public Criteria andRandomNumNotBetween(Integer value1, Integer value2) {
            addCriterion("random_num not between", value1, value2, "randomNum");
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

        public Criteria andRockNumIsNull() {
            addCriterion("rock_num is null");
            return (Criteria) this;
        }

        public Criteria andRockNumIsNotNull() {
            addCriterion("rock_num is not null");
            return (Criteria) this;
        }

        public Criteria andRockNumEqualTo(Integer value) {
            addCriterion("rock_num =", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumNotEqualTo(Integer value) {
            addCriterion("rock_num <>", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumGreaterThan(Integer value) {
            addCriterion("rock_num >", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rock_num >=", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumLessThan(Integer value) {
            addCriterion("rock_num <", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumLessThanOrEqualTo(Integer value) {
            addCriterion("rock_num <=", value, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumIn(List<Integer> values) {
            addCriterion("rock_num in", values, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumNotIn(List<Integer> values) {
            addCriterion("rock_num not in", values, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumBetween(Integer value1, Integer value2) {
            addCriterion("rock_num between", value1, value2, "rockNum");
            return (Criteria) this;
        }

        public Criteria andRockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("rock_num not between", value1, value2, "rockNum");
            return (Criteria) this;
        }

        public Criteria andStartConfigIsNull() {
            addCriterion("start_config is null");
            return (Criteria) this;
        }

        public Criteria andStartConfigIsNotNull() {
            addCriterion("start_config is not null");
            return (Criteria) this;
        }

        public Criteria andStartConfigEqualTo(Integer value) {
            addCriterion("start_config =", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigNotEqualTo(Integer value) {
            addCriterion("start_config <>", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigGreaterThan(Integer value) {
            addCriterion("start_config >", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_config >=", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigLessThan(Integer value) {
            addCriterion("start_config <", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigLessThanOrEqualTo(Integer value) {
            addCriterion("start_config <=", value, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigIn(List<Integer> values) {
            addCriterion("start_config in", values, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigNotIn(List<Integer> values) {
            addCriterion("start_config not in", values, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigBetween(Integer value1, Integer value2) {
            addCriterion("start_config between", value1, value2, "startConfig");
            return (Criteria) this;
        }

        public Criteria andStartConfigNotBetween(Integer value1, Integer value2) {
            addCriterion("start_config not between", value1, value2, "startConfig");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIsNull() {
            addCriterion("hb_pool_id is null");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIsNotNull() {
            addCriterion("hb_pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdEqualTo(Long value) {
            addCriterion("hb_pool_id =", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotEqualTo(Long value) {
            addCriterion("hb_pool_id <>", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThan(Long value) {
            addCriterion("hb_pool_id >", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hb_pool_id >=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThan(Long value) {
            addCriterion("hb_pool_id <", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("hb_pool_id <=", value, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdIn(List<Long> values) {
            addCriterion("hb_pool_id in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotIn(List<Long> values) {
            addCriterion("hb_pool_id not in", values, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdBetween(Long value1, Long value2) {
            addCriterion("hb_pool_id between", value1, value2, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("hb_pool_id not between", value1, value2, "hbPoolId");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameIsNull() {
            addCriterion("hb_pool_name is null");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameIsNotNull() {
            addCriterion("hb_pool_name is not null");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameEqualTo(String value) {
            addCriterion("hb_pool_name =", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameNotEqualTo(String value) {
            addCriterion("hb_pool_name <>", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameGreaterThan(String value) {
            addCriterion("hb_pool_name >", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("hb_pool_name >=", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameLessThan(String value) {
            addCriterion("hb_pool_name <", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameLessThanOrEqualTo(String value) {
            addCriterion("hb_pool_name <=", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameLike(String value) {
            addCriterion("hb_pool_name like", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameNotLike(String value) {
            addCriterion("hb_pool_name not like", value, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameIn(List<String> values) {
            addCriterion("hb_pool_name in", values, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameNotIn(List<String> values) {
            addCriterion("hb_pool_name not in", values, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameBetween(String value1, String value2) {
            addCriterion("hb_pool_name between", value1, value2, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andHbPoolNameNotBetween(String value1, String value2) {
            addCriterion("hb_pool_name not between", value1, value2, "hbPoolName");
            return (Criteria) this;
        }

        public Criteria andGetHbNumIsNull() {
            addCriterion("get_hb_num is null");
            return (Criteria) this;
        }

        public Criteria andGetHbNumIsNotNull() {
            addCriterion("get_hb_num is not null");
            return (Criteria) this;
        }

        public Criteria andGetHbNumEqualTo(Integer value) {
            addCriterion("get_hb_num =", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumNotEqualTo(Integer value) {
            addCriterion("get_hb_num <>", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumGreaterThan(Integer value) {
            addCriterion("get_hb_num >", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_hb_num >=", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumLessThan(Integer value) {
            addCriterion("get_hb_num <", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumLessThanOrEqualTo(Integer value) {
            addCriterion("get_hb_num <=", value, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumIn(List<Integer> values) {
            addCriterion("get_hb_num in", values, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumNotIn(List<Integer> values) {
            addCriterion("get_hb_num not in", values, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumBetween(Integer value1, Integer value2) {
            addCriterion("get_hb_num between", value1, value2, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andGetHbNumNotBetween(Integer value1, Integer value2) {
            addCriterion("get_hb_num not between", value1, value2, "getHbNum");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareIsNull() {
            addCriterion("is_get_hb_share is null");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareIsNotNull() {
            addCriterion("is_get_hb_share is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareEqualTo(String value) {
            addCriterion("is_get_hb_share =", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareNotEqualTo(String value) {
            addCriterion("is_get_hb_share <>", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareGreaterThan(String value) {
            addCriterion("is_get_hb_share >", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareGreaterThanOrEqualTo(String value) {
            addCriterion("is_get_hb_share >=", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareLessThan(String value) {
            addCriterion("is_get_hb_share <", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareLessThanOrEqualTo(String value) {
            addCriterion("is_get_hb_share <=", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareLike(String value) {
            addCriterion("is_get_hb_share like", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareNotLike(String value) {
            addCriterion("is_get_hb_share not like", value, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareIn(List<String> values) {
            addCriterion("is_get_hb_share in", values, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareNotIn(List<String> values) {
            addCriterion("is_get_hb_share not in", values, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareBetween(String value1, String value2) {
            addCriterion("is_get_hb_share between", value1, value2, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andIsGetHbShareNotBetween(String value1, String value2) {
            addCriterion("is_get_hb_share not between", value1, value2, "isGetHbShare");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumIsNull() {
            addCriterion("get_gift_num is null");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumIsNotNull() {
            addCriterion("get_gift_num is not null");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumEqualTo(Integer value) {
            addCriterion("get_gift_num =", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumNotEqualTo(Integer value) {
            addCriterion("get_gift_num <>", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumGreaterThan(Integer value) {
            addCriterion("get_gift_num >", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_gift_num >=", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumLessThan(Integer value) {
            addCriterion("get_gift_num <", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumLessThanOrEqualTo(Integer value) {
            addCriterion("get_gift_num <=", value, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumIn(List<Integer> values) {
            addCriterion("get_gift_num in", values, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumNotIn(List<Integer> values) {
            addCriterion("get_gift_num not in", values, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumBetween(Integer value1, Integer value2) {
            addCriterion("get_gift_num between", value1, value2, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andGetGiftNumNotBetween(Integer value1, Integer value2) {
            addCriterion("get_gift_num not between", value1, value2, "getGiftNum");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareIsNull() {
            addCriterion("is_get_gift_share is null");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareIsNotNull() {
            addCriterion("is_get_gift_share is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareEqualTo(String value) {
            addCriterion("is_get_gift_share =", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareNotEqualTo(String value) {
            addCriterion("is_get_gift_share <>", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareGreaterThan(String value) {
            addCriterion("is_get_gift_share >", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareGreaterThanOrEqualTo(String value) {
            addCriterion("is_get_gift_share >=", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareLessThan(String value) {
            addCriterion("is_get_gift_share <", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareLessThanOrEqualTo(String value) {
            addCriterion("is_get_gift_share <=", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareLike(String value) {
            addCriterion("is_get_gift_share like", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareNotLike(String value) {
            addCriterion("is_get_gift_share not like", value, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareIn(List<String> values) {
            addCriterion("is_get_gift_share in", values, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareNotIn(List<String> values) {
            addCriterion("is_get_gift_share not in", values, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareBetween(String value1, String value2) {
            addCriterion("is_get_gift_share between", value1, value2, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andIsGetGiftShareNotBetween(String value1, String value2) {
            addCriterion("is_get_gift_share not between", value1, value2, "isGetGiftShare");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinIsNull() {
            addCriterion("point_interval_min is null");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinIsNotNull() {
            addCriterion("point_interval_min is not null");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinEqualTo(Integer value) {
            addCriterion("point_interval_min =", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinNotEqualTo(Integer value) {
            addCriterion("point_interval_min <>", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinGreaterThan(Integer value) {
            addCriterion("point_interval_min >", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_interval_min >=", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinLessThan(Integer value) {
            addCriterion("point_interval_min <", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinLessThanOrEqualTo(Integer value) {
            addCriterion("point_interval_min <=", value, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinIn(List<Integer> values) {
            addCriterion("point_interval_min in", values, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinNotIn(List<Integer> values) {
            addCriterion("point_interval_min not in", values, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinBetween(Integer value1, Integer value2) {
            addCriterion("point_interval_min between", value1, value2, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMinNotBetween(Integer value1, Integer value2) {
            addCriterion("point_interval_min not between", value1, value2, "pointIntervalMin");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxIsNull() {
            addCriterion("point_interval_max is null");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxIsNotNull() {
            addCriterion("point_interval_max is not null");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxEqualTo(Integer value) {
            addCriterion("point_interval_max =", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxNotEqualTo(Integer value) {
            addCriterion("point_interval_max <>", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxGreaterThan(Integer value) {
            addCriterion("point_interval_max >", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_interval_max >=", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxLessThan(Integer value) {
            addCriterion("point_interval_max <", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxLessThanOrEqualTo(Integer value) {
            addCriterion("point_interval_max <=", value, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxIn(List<Integer> values) {
            addCriterion("point_interval_max in", values, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxNotIn(List<Integer> values) {
            addCriterion("point_interval_max not in", values, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxBetween(Integer value1, Integer value2) {
            addCriterion("point_interval_max between", value1, value2, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andPointIntervalMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("point_interval_max not between", value1, value2, "pointIntervalMax");
            return (Criteria) this;
        }

        public Criteria andGetPointNumIsNull() {
            addCriterion("get_point_num is null");
            return (Criteria) this;
        }

        public Criteria andGetPointNumIsNotNull() {
            addCriterion("get_point_num is not null");
            return (Criteria) this;
        }

        public Criteria andGetPointNumEqualTo(Integer value) {
            addCriterion("get_point_num =", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumNotEqualTo(Integer value) {
            addCriterion("get_point_num <>", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumGreaterThan(Integer value) {
            addCriterion("get_point_num >", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_point_num >=", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumLessThan(Integer value) {
            addCriterion("get_point_num <", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumLessThanOrEqualTo(Integer value) {
            addCriterion("get_point_num <=", value, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumIn(List<Integer> values) {
            addCriterion("get_point_num in", values, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumNotIn(List<Integer> values) {
            addCriterion("get_point_num not in", values, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumBetween(Integer value1, Integer value2) {
            addCriterion("get_point_num between", value1, value2, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andGetPointNumNotBetween(Integer value1, Integer value2) {
            addCriterion("get_point_num not between", value1, value2, "getPointNum");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareIsNull() {
            addCriterion("is_get_point_share is null");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareIsNotNull() {
            addCriterion("is_get_point_share is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareEqualTo(String value) {
            addCriterion("is_get_point_share =", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareNotEqualTo(String value) {
            addCriterion("is_get_point_share <>", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareGreaterThan(String value) {
            addCriterion("is_get_point_share >", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareGreaterThanOrEqualTo(String value) {
            addCriterion("is_get_point_share >=", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareLessThan(String value) {
            addCriterion("is_get_point_share <", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareLessThanOrEqualTo(String value) {
            addCriterion("is_get_point_share <=", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareLike(String value) {
            addCriterion("is_get_point_share like", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareNotLike(String value) {
            addCriterion("is_get_point_share not like", value, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareIn(List<String> values) {
            addCriterion("is_get_point_share in", values, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareNotIn(List<String> values) {
            addCriterion("is_get_point_share not in", values, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareBetween(String value1, String value2) {
            addCriterion("is_get_point_share between", value1, value2, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andIsGetPointShareNotBetween(String value1, String value2) {
            addCriterion("is_get_point_share not between", value1, value2, "isGetPointShare");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsShakePointIsNull() {
            addCriterion("is_shake_point is null");
            return (Criteria) this;
        }

        public Criteria andIsShakePointIsNotNull() {
            addCriterion("is_shake_point is not null");
            return (Criteria) this;
        }

        public Criteria andIsShakePointEqualTo(String value) {
            addCriterion("is_shake_point =", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointNotEqualTo(String value) {
            addCriterion("is_shake_point <>", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointGreaterThan(String value) {
            addCriterion("is_shake_point >", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointGreaterThanOrEqualTo(String value) {
            addCriterion("is_shake_point >=", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointLessThan(String value) {
            addCriterion("is_shake_point <", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointLessThanOrEqualTo(String value) {
            addCriterion("is_shake_point <=", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointLike(String value) {
            addCriterion("is_shake_point like", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointNotLike(String value) {
            addCriterion("is_shake_point not like", value, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointIn(List<String> values) {
            addCriterion("is_shake_point in", values, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointNotIn(List<String> values) {
            addCriterion("is_shake_point not in", values, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointBetween(String value1, String value2) {
            addCriterion("is_shake_point between", value1, value2, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakePointNotBetween(String value1, String value2) {
            addCriterion("is_shake_point not between", value1, value2, "isShakePoint");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbIsNull() {
            addCriterion("is_shake_hb is null");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbIsNotNull() {
            addCriterion("is_shake_hb is not null");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbEqualTo(String value) {
            addCriterion("is_shake_hb =", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbNotEqualTo(String value) {
            addCriterion("is_shake_hb <>", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbGreaterThan(String value) {
            addCriterion("is_shake_hb >", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbGreaterThanOrEqualTo(String value) {
            addCriterion("is_shake_hb >=", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbLessThan(String value) {
            addCriterion("is_shake_hb <", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbLessThanOrEqualTo(String value) {
            addCriterion("is_shake_hb <=", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbLike(String value) {
            addCriterion("is_shake_hb like", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbNotLike(String value) {
            addCriterion("is_shake_hb not like", value, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbIn(List<String> values) {
            addCriterion("is_shake_hb in", values, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbNotIn(List<String> values) {
            addCriterion("is_shake_hb not in", values, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbBetween(String value1, String value2) {
            addCriterion("is_shake_hb between", value1, value2, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeHbNotBetween(String value1, String value2) {
            addCriterion("is_shake_hb not between", value1, value2, "isShakeHb");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftIsNull() {
            addCriterion("is_shake_gift is null");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftIsNotNull() {
            addCriterion("is_shake_gift is not null");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftEqualTo(String value) {
            addCriterion("is_shake_gift =", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftNotEqualTo(String value) {
            addCriterion("is_shake_gift <>", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftGreaterThan(String value) {
            addCriterion("is_shake_gift >", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftGreaterThanOrEqualTo(String value) {
            addCriterion("is_shake_gift >=", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftLessThan(String value) {
            addCriterion("is_shake_gift <", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftLessThanOrEqualTo(String value) {
            addCriterion("is_shake_gift <=", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftLike(String value) {
            addCriterion("is_shake_gift like", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftNotLike(String value) {
            addCriterion("is_shake_gift not like", value, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftIn(List<String> values) {
            addCriterion("is_shake_gift in", values, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftNotIn(List<String> values) {
            addCriterion("is_shake_gift not in", values, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftBetween(String value1, String value2) {
            addCriterion("is_shake_gift between", value1, value2, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andIsShakeGiftNotBetween(String value1, String value2) {
            addCriterion("is_shake_gift not between", value1, value2, "isShakeGift");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
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