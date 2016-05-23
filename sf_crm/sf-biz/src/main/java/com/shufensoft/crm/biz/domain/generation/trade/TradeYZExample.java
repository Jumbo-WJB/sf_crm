package com.shufensoft.crm.biz.domain.generation.trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeYZExample {
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

    public TradeYZExample() {
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

    public void addTidQueryColumn() {
        this.queryColumns.add("tid");
    }

    public void addMaxTidQueryColumn() {
        this.queryColumns.add("max(tid) max_tid");
    }

    public void addMinTidQueryColumn() {
        this.queryColumns.add("min(tid) min_tid");
    }

    public void addAvgTidQueryColumn() {
        this.queryColumns.add(" avg(tid) avg_tid");
    }

    public void addCountTidQueryColumn() {
        this.queryColumns.add(" count(tid) count_tid");
    }

    public void addSumTidQueryColumn() {
        this.queryColumns.add(" sum(tid) sum_tid");
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

    public void addSumUserIdYzQueryColumn() {
        this.queryColumns.add(" sum(user_id_yz) sum_user_id_yz");
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

    public void addSumReceiverIdYzQueryColumn() {
        this.queryColumns.add(" sum(receiver_id_yz) sum_receiver_id_yz");
    }

    public void addNumQueryColumn() {
        this.queryColumns.add("num");
    }

    public void addMaxNumQueryColumn() {
        this.queryColumns.add("max(num) max_num");
    }

    public void addMinNumQueryColumn() {
        this.queryColumns.add("min(num) min_num");
    }

    public void addAvgNumQueryColumn() {
        this.queryColumns.add(" avg(num) avg_num");
    }

    public void addCountNumQueryColumn() {
        this.queryColumns.add(" count(num) count_num");
    }

    public void addSumNumQueryColumn() {
        this.queryColumns.add(" sum(num) sum_num");
    }

    public void addNumIidQueryColumn() {
        this.queryColumns.add("num_iid");
    }

    public void addMaxNumIidQueryColumn() {
        this.queryColumns.add("max(num_iid) max_num_iid");
    }

    public void addMinNumIidQueryColumn() {
        this.queryColumns.add("min(num_iid) min_num_iid");
    }

    public void addAvgNumIidQueryColumn() {
        this.queryColumns.add(" avg(num_iid) avg_num_iid");
    }

    public void addCountNumIidQueryColumn() {
        this.queryColumns.add(" count(num_iid) count_num_iid");
    }

    public void addSumNumIidQueryColumn() {
        this.queryColumns.add(" sum(num_iid) sum_num_iid");
    }

    public void addPicThumbPathQueryColumn() {
        this.queryColumns.add("pic_thumb_path");
    }

    public void addMaxPicThumbPathQueryColumn() {
        this.queryColumns.add("max(pic_thumb_path) max_pic_thumb_path");
    }

    public void addMinPicThumbPathQueryColumn() {
        this.queryColumns.add("min(pic_thumb_path) min_pic_thumb_path");
    }

    public void addAvgPicThumbPathQueryColumn() {
        this.queryColumns.add(" avg(pic_thumb_path) avg_pic_thumb_path");
    }

    public void addCountPicThumbPathQueryColumn() {
        this.queryColumns.add(" count(pic_thumb_path) count_pic_thumb_path");
    }

    public void addSumPicThumbPathQueryColumn() {
        this.queryColumns.add(" sum(pic_thumb_path) sum_pic_thumb_path");
    }

    public void addPicPathQueryColumn() {
        this.queryColumns.add("pic_path");
    }

    public void addMaxPicPathQueryColumn() {
        this.queryColumns.add("max(pic_path) max_pic_path");
    }

    public void addMinPicPathQueryColumn() {
        this.queryColumns.add("min(pic_path) min_pic_path");
    }

    public void addAvgPicPathQueryColumn() {
        this.queryColumns.add(" avg(pic_path) avg_pic_path");
    }

    public void addCountPicPathQueryColumn() {
        this.queryColumns.add(" count(pic_path) count_pic_path");
    }

    public void addSumPicPathQueryColumn() {
        this.queryColumns.add(" sum(pic_path) sum_pic_path");
    }

    public void addPriceQueryColumn() {
        this.queryColumns.add("price");
    }

    public void addMaxPriceQueryColumn() {
        this.queryColumns.add("max(price) max_price");
    }

    public void addMinPriceQueryColumn() {
        this.queryColumns.add("min(price) min_price");
    }

    public void addAvgPriceQueryColumn() {
        this.queryColumns.add(" avg(price) avg_price");
    }

    public void addCountPriceQueryColumn() {
        this.queryColumns.add(" count(price) count_price");
    }

    public void addSumPriceQueryColumn() {
        this.queryColumns.add(" sum(price) sum_price");
    }

    public void addTitleQueryColumn() {
        this.queryColumns.add("title");
    }

    public void addMaxTitleQueryColumn() {
        this.queryColumns.add("max(title) max_title");
    }

    public void addMinTitleQueryColumn() {
        this.queryColumns.add("min(title) min_title");
    }

    public void addAvgTitleQueryColumn() {
        this.queryColumns.add(" avg(title) avg_title");
    }

    public void addCountTitleQueryColumn() {
        this.queryColumns.add(" count(title) count_title");
    }

    public void addSumTitleQueryColumn() {
        this.queryColumns.add(" sum(title) sum_title");
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

    public void addSumWeixinUserIdQueryColumn() {
        this.queryColumns.add(" sum(weixin_user_id) sum_weixin_user_id");
    }

    public void addBuyerTypeQueryColumn() {
        this.queryColumns.add("buyer_type");
    }

    public void addMaxBuyerTypeQueryColumn() {
        this.queryColumns.add("max(buyer_type) max_buyer_type");
    }

    public void addMinBuyerTypeQueryColumn() {
        this.queryColumns.add("min(buyer_type) min_buyer_type");
    }

    public void addAvgBuyerTypeQueryColumn() {
        this.queryColumns.add(" avg(buyer_type) avg_buyer_type");
    }

    public void addCountBuyerTypeQueryColumn() {
        this.queryColumns.add(" count(buyer_type) count_buyer_type");
    }

    public void addSumBuyerTypeQueryColumn() {
        this.queryColumns.add(" sum(buyer_type) sum_buyer_type");
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

    public void addSumBuyerNickQueryColumn() {
        this.queryColumns.add(" sum(buyer_nick) sum_buyer_nick");
    }

    public void addBuyerMessageQueryColumn() {
        this.queryColumns.add("buyer_message");
    }

    public void addMaxBuyerMessageQueryColumn() {
        this.queryColumns.add("max(buyer_message) max_buyer_message");
    }

    public void addMinBuyerMessageQueryColumn() {
        this.queryColumns.add("min(buyer_message) min_buyer_message");
    }

    public void addAvgBuyerMessageQueryColumn() {
        this.queryColumns.add(" avg(buyer_message) avg_buyer_message");
    }

    public void addCountBuyerMessageQueryColumn() {
        this.queryColumns.add(" count(buyer_message) count_buyer_message");
    }

    public void addSumBuyerMessageQueryColumn() {
        this.queryColumns.add(" sum(buyer_message) sum_buyer_message");
    }

    public void addSellerFlagQueryColumn() {
        this.queryColumns.add("seller_flag");
    }

    public void addMaxSellerFlagQueryColumn() {
        this.queryColumns.add("max(seller_flag) max_seller_flag");
    }

    public void addMinSellerFlagQueryColumn() {
        this.queryColumns.add("min(seller_flag) min_seller_flag");
    }

    public void addAvgSellerFlagQueryColumn() {
        this.queryColumns.add(" avg(seller_flag) avg_seller_flag");
    }

    public void addCountSellerFlagQueryColumn() {
        this.queryColumns.add(" count(seller_flag) count_seller_flag");
    }

    public void addSumSellerFlagQueryColumn() {
        this.queryColumns.add(" sum(seller_flag) sum_seller_flag");
    }

    public void addTradeMemoQueryColumn() {
        this.queryColumns.add("trade_memo");
    }

    public void addMaxTradeMemoQueryColumn() {
        this.queryColumns.add("max(trade_memo) max_trade_memo");
    }

    public void addMinTradeMemoQueryColumn() {
        this.queryColumns.add("min(trade_memo) min_trade_memo");
    }

    public void addAvgTradeMemoQueryColumn() {
        this.queryColumns.add(" avg(trade_memo) avg_trade_memo");
    }

    public void addCountTradeMemoQueryColumn() {
        this.queryColumns.add(" count(trade_memo) count_trade_memo");
    }

    public void addSumTradeMemoQueryColumn() {
        this.queryColumns.add(" sum(trade_memo) sum_trade_memo");
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

    public void addFeedbackQueryColumn() {
        this.queryColumns.add("feedback");
    }

    public void addMaxFeedbackQueryColumn() {
        this.queryColumns.add("max(feedback) max_feedback");
    }

    public void addMinFeedbackQueryColumn() {
        this.queryColumns.add("min(feedback) min_feedback");
    }

    public void addAvgFeedbackQueryColumn() {
        this.queryColumns.add(" avg(feedback) avg_feedback");
    }

    public void addCountFeedbackQueryColumn() {
        this.queryColumns.add(" count(feedback) count_feedback");
    }

    public void addSumFeedbackQueryColumn() {
        this.queryColumns.add(" sum(feedback) sum_feedback");
    }

    public void addOuterTidQueryColumn() {
        this.queryColumns.add("outer_tid");
    }

    public void addMaxOuterTidQueryColumn() {
        this.queryColumns.add("max(outer_tid) max_outer_tid");
    }

    public void addMinOuterTidQueryColumn() {
        this.queryColumns.add("min(outer_tid) min_outer_tid");
    }

    public void addAvgOuterTidQueryColumn() {
        this.queryColumns.add(" avg(outer_tid) avg_outer_tid");
    }

    public void addCountOuterTidQueryColumn() {
        this.queryColumns.add(" count(outer_tid) count_outer_tid");
    }

    public void addSumOuterTidQueryColumn() {
        this.queryColumns.add(" sum(outer_tid) sum_outer_tid");
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

    public void addShippingTypeQueryColumn() {
        this.queryColumns.add("shipping_type");
    }

    public void addMaxShippingTypeQueryColumn() {
        this.queryColumns.add("max(shipping_type) max_shipping_type");
    }

    public void addMinShippingTypeQueryColumn() {
        this.queryColumns.add("min(shipping_type) min_shipping_type");
    }

    public void addAvgShippingTypeQueryColumn() {
        this.queryColumns.add(" avg(shipping_type) avg_shipping_type");
    }

    public void addCountShippingTypeQueryColumn() {
        this.queryColumns.add(" count(shipping_type) count_shipping_type");
    }

    public void addSumShippingTypeQueryColumn() {
        this.queryColumns.add(" sum(shipping_type) sum_shipping_type");
    }

    public void addPostFeeQueryColumn() {
        this.queryColumns.add("post_fee");
    }

    public void addMaxPostFeeQueryColumn() {
        this.queryColumns.add("max(post_fee) max_post_fee");
    }

    public void addMinPostFeeQueryColumn() {
        this.queryColumns.add("min(post_fee) min_post_fee");
    }

    public void addAvgPostFeeQueryColumn() {
        this.queryColumns.add(" avg(post_fee) avg_post_fee");
    }

    public void addCountPostFeeQueryColumn() {
        this.queryColumns.add(" count(post_fee) count_post_fee");
    }

    public void addSumPostFeeQueryColumn() {
        this.queryColumns.add(" sum(post_fee) sum_post_fee");
    }

    public void addTotalFeeQueryColumn() {
        this.queryColumns.add("total_fee");
    }

    public void addMaxTotalFeeQueryColumn() {
        this.queryColumns.add("max(total_fee) max_total_fee");
    }

    public void addMinTotalFeeQueryColumn() {
        this.queryColumns.add("min(total_fee) min_total_fee");
    }

    public void addAvgTotalFeeQueryColumn() {
        this.queryColumns.add(" avg(total_fee) avg_total_fee");
    }

    public void addCountTotalFeeQueryColumn() {
        this.queryColumns.add(" count(total_fee) count_total_fee");
    }

    public void addSumTotalFeeQueryColumn() {
        this.queryColumns.add(" sum(total_fee) sum_total_fee");
    }

    public void addDiscountFeeQueryColumn() {
        this.queryColumns.add("discount_fee");
    }

    public void addMaxDiscountFeeQueryColumn() {
        this.queryColumns.add("max(discount_fee) max_discount_fee");
    }

    public void addMinDiscountFeeQueryColumn() {
        this.queryColumns.add("min(discount_fee) min_discount_fee");
    }

    public void addAvgDiscountFeeQueryColumn() {
        this.queryColumns.add(" avg(discount_fee) avg_discount_fee");
    }

    public void addCountDiscountFeeQueryColumn() {
        this.queryColumns.add(" count(discount_fee) count_discount_fee");
    }

    public void addSumDiscountFeeQueryColumn() {
        this.queryColumns.add(" sum(discount_fee) sum_discount_fee");
    }

    public void addAdjustFeeQueryColumn() {
        this.queryColumns.add("adjust_fee");
    }

    public void addMaxAdjustFeeQueryColumn() {
        this.queryColumns.add("max(adjust_fee) max_adjust_fee");
    }

    public void addMinAdjustFeeQueryColumn() {
        this.queryColumns.add("min(adjust_fee) min_adjust_fee");
    }

    public void addAvgAdjustFeeQueryColumn() {
        this.queryColumns.add(" avg(adjust_fee) avg_adjust_fee");
    }

    public void addCountAdjustFeeQueryColumn() {
        this.queryColumns.add(" count(adjust_fee) count_adjust_fee");
    }

    public void addSumAdjustFeeQueryColumn() {
        this.queryColumns.add(" sum(adjust_fee) sum_adjust_fee");
    }

    public void addPaymentQueryColumn() {
        this.queryColumns.add("payment");
    }

    public void addMaxPaymentQueryColumn() {
        this.queryColumns.add("max(payment) max_payment");
    }

    public void addMinPaymentQueryColumn() {
        this.queryColumns.add("min(payment) min_payment");
    }

    public void addAvgPaymentQueryColumn() {
        this.queryColumns.add(" avg(payment) avg_payment");
    }

    public void addCountPaymentQueryColumn() {
        this.queryColumns.add(" count(payment) count_payment");
    }

    public void addSumPaymentQueryColumn() {
        this.queryColumns.add(" sum(payment) sum_payment");
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

    public void addUpdateTimeQueryColumn() {
        this.queryColumns.add("update_time");
    }

    public void addMaxUpdateTimeQueryColumn() {
        this.queryColumns.add("max(update_time) max_update_time");
    }

    public void addMinUpdateTimeQueryColumn() {
        this.queryColumns.add("min(update_time) min_update_time");
    }

    public void addAvgUpdateTimeQueryColumn() {
        this.queryColumns.add(" avg(update_time) avg_update_time");
    }

    public void addCountUpdateTimeQueryColumn() {
        this.queryColumns.add(" count(update_time) count_update_time");
    }

    public void addSumUpdateTimeQueryColumn() {
        this.queryColumns.add(" sum(update_time) sum_update_time");
    }

    public void addPayTimeQueryColumn() {
        this.queryColumns.add("pay_time");
    }

    public void addMaxPayTimeQueryColumn() {
        this.queryColumns.add("max(pay_time) max_pay_time");
    }

    public void addMinPayTimeQueryColumn() {
        this.queryColumns.add("min(pay_time) min_pay_time");
    }

    public void addAvgPayTimeQueryColumn() {
        this.queryColumns.add(" avg(pay_time) avg_pay_time");
    }

    public void addCountPayTimeQueryColumn() {
        this.queryColumns.add(" count(pay_time) count_pay_time");
    }

    public void addSumPayTimeQueryColumn() {
        this.queryColumns.add(" sum(pay_time) sum_pay_time");
    }

    public void addPayTypeQueryColumn() {
        this.queryColumns.add("pay_type");
    }

    public void addMaxPayTypeQueryColumn() {
        this.queryColumns.add("max(pay_type) max_pay_type");
    }

    public void addMinPayTypeQueryColumn() {
        this.queryColumns.add("min(pay_type) min_pay_type");
    }

    public void addAvgPayTypeQueryColumn() {
        this.queryColumns.add(" avg(pay_type) avg_pay_type");
    }

    public void addCountPayTypeQueryColumn() {
        this.queryColumns.add(" count(pay_type) count_pay_type");
    }

    public void addSumPayTypeQueryColumn() {
        this.queryColumns.add(" sum(pay_type) sum_pay_type");
    }

    public void addConsignTimeQueryColumn() {
        this.queryColumns.add("consign_time");
    }

    public void addMaxConsignTimeQueryColumn() {
        this.queryColumns.add("max(consign_time) max_consign_time");
    }

    public void addMinConsignTimeQueryColumn() {
        this.queryColumns.add("min(consign_time) min_consign_time");
    }

    public void addAvgConsignTimeQueryColumn() {
        this.queryColumns.add(" avg(consign_time) avg_consign_time");
    }

    public void addCountConsignTimeQueryColumn() {
        this.queryColumns.add(" count(consign_time) count_consign_time");
    }

    public void addSumConsignTimeQueryColumn() {
        this.queryColumns.add(" sum(consign_time) sum_consign_time");
    }

    public void addSignTimeQueryColumn() {
        this.queryColumns.add("sign_time");
    }

    public void addMaxSignTimeQueryColumn() {
        this.queryColumns.add("max(sign_time) max_sign_time");
    }

    public void addMinSignTimeQueryColumn() {
        this.queryColumns.add("min(sign_time) min_sign_time");
    }

    public void addAvgSignTimeQueryColumn() {
        this.queryColumns.add(" avg(sign_time) avg_sign_time");
    }

    public void addCountSignTimeQueryColumn() {
        this.queryColumns.add(" count(sign_time) count_sign_time");
    }

    public void addSumSignTimeQueryColumn() {
        this.queryColumns.add(" sum(sign_time) sum_sign_time");
    }

    public void addParentTidQueryColumn() {
        this.queryColumns.add("parent_tid");
    }

    public void addMaxParentTidQueryColumn() {
        this.queryColumns.add("max(parent_tid) max_parent_tid");
    }

    public void addMinParentTidQueryColumn() {
        this.queryColumns.add("min(parent_tid) min_parent_tid");
    }

    public void addAvgParentTidQueryColumn() {
        this.queryColumns.add(" avg(parent_tid) avg_parent_tid");
    }

    public void addCountParentTidQueryColumn() {
        this.queryColumns.add(" count(parent_tid) count_parent_tid");
    }

    public void addSumParentTidQueryColumn() {
        this.queryColumns.add(" sum(parent_tid) sum_parent_tid");
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

    public void addSumBuyerAreaQueryColumn() {
        this.queryColumns.add(" sum(buyer_area) sum_buyer_area");
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
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

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNull() {
            addCriterion("num_iid is null");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNotNull() {
            addCriterion("num_iid is not null");
            return (Criteria) this;
        }

        public Criteria andNumIidEqualTo(String value) {
            addCriterion("num_iid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(String value) {
            addCriterion("num_iid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(String value) {
            addCriterion("num_iid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(String value) {
            addCriterion("num_iid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(String value) {
            addCriterion("num_iid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(String value) {
            addCriterion("num_iid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLike(String value) {
            addCriterion("num_iid like", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotLike(String value) {
            addCriterion("num_iid not like", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<String> values) {
            addCriterion("num_iid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<String> values) {
            addCriterion("num_iid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(String value1, String value2) {
            addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(String value1, String value2) {
            addCriterion("num_iid not between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathIsNull() {
            addCriterion("pic_thumb_path is null");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathIsNotNull() {
            addCriterion("pic_thumb_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathEqualTo(String value) {
            addCriterion("pic_thumb_path =", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathNotEqualTo(String value) {
            addCriterion("pic_thumb_path <>", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathGreaterThan(String value) {
            addCriterion("pic_thumb_path >", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_thumb_path >=", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathLessThan(String value) {
            addCriterion("pic_thumb_path <", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathLessThanOrEqualTo(String value) {
            addCriterion("pic_thumb_path <=", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathLike(String value) {
            addCriterion("pic_thumb_path like", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathNotLike(String value) {
            addCriterion("pic_thumb_path not like", value, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathIn(List<String> values) {
            addCriterion("pic_thumb_path in", values, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathNotIn(List<String> values) {
            addCriterion("pic_thumb_path not in", values, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathBetween(String value1, String value2) {
            addCriterion("pic_thumb_path between", value1, value2, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicThumbPathNotBetween(String value1, String value2) {
            addCriterion("pic_thumb_path not between", value1, value2, "picThumbPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("pic_path not between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andBuyerTypeIsNull() {
            addCriterion("buyer_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeIsNotNull() {
            addCriterion("buyer_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeEqualTo(Integer value) {
            addCriterion("buyer_type =", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotEqualTo(Integer value) {
            addCriterion("buyer_type <>", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeGreaterThan(Integer value) {
            addCriterion("buyer_type >", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_type >=", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeLessThan(Integer value) {
            addCriterion("buyer_type <", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_type <=", value, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeIn(List<Integer> values) {
            addCriterion("buyer_type in", values, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotIn(List<Integer> values) {
            addCriterion("buyer_type not in", values, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeBetween(Integer value1, Integer value2) {
            addCriterion("buyer_type between", value1, value2, "buyerType");
            return (Criteria) this;
        }

        public Criteria andBuyerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_type not between", value1, value2, "buyerType");
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

        public Criteria andBuyerMessageIsNull() {
            addCriterion("buyer_message is null");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageIsNotNull() {
            addCriterion("buyer_message is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageEqualTo(String value) {
            addCriterion("buyer_message =", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotEqualTo(String value) {
            addCriterion("buyer_message <>", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageGreaterThan(String value) {
            addCriterion("buyer_message >", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_message >=", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLessThan(String value) {
            addCriterion("buyer_message <", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLessThanOrEqualTo(String value) {
            addCriterion("buyer_message <=", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageLike(String value) {
            addCriterion("buyer_message like", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotLike(String value) {
            addCriterion("buyer_message not like", value, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageIn(List<String> values) {
            addCriterion("buyer_message in", values, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotIn(List<String> values) {
            addCriterion("buyer_message not in", values, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageBetween(String value1, String value2) {
            addCriterion("buyer_message between", value1, value2, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andBuyerMessageNotBetween(String value1, String value2) {
            addCriterion("buyer_message not between", value1, value2, "buyerMessage");
            return (Criteria) this;
        }

        public Criteria andSellerFlagIsNull() {
            addCriterion("seller_flag is null");
            return (Criteria) this;
        }

        public Criteria andSellerFlagIsNotNull() {
            addCriterion("seller_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSellerFlagEqualTo(Integer value) {
            addCriterion("seller_flag =", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagNotEqualTo(Integer value) {
            addCriterion("seller_flag <>", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagGreaterThan(Integer value) {
            addCriterion("seller_flag >", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("seller_flag >=", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagLessThan(Integer value) {
            addCriterion("seller_flag <", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagLessThanOrEqualTo(Integer value) {
            addCriterion("seller_flag <=", value, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagIn(List<Integer> values) {
            addCriterion("seller_flag in", values, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagNotIn(List<Integer> values) {
            addCriterion("seller_flag not in", values, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagBetween(Integer value1, Integer value2) {
            addCriterion("seller_flag between", value1, value2, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("seller_flag not between", value1, value2, "sellerFlag");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIsNull() {
            addCriterion("trade_memo is null");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIsNotNull() {
            addCriterion("trade_memo is not null");
            return (Criteria) this;
        }

        public Criteria andTradeMemoEqualTo(String value) {
            addCriterion("trade_memo =", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotEqualTo(String value) {
            addCriterion("trade_memo <>", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoGreaterThan(String value) {
            addCriterion("trade_memo >", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_memo >=", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLessThan(String value) {
            addCriterion("trade_memo <", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLessThanOrEqualTo(String value) {
            addCriterion("trade_memo <=", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoLike(String value) {
            addCriterion("trade_memo like", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotLike(String value) {
            addCriterion("trade_memo not like", value, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoIn(List<String> values) {
            addCriterion("trade_memo in", values, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotIn(List<String> values) {
            addCriterion("trade_memo not in", values, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoBetween(String value1, String value2) {
            addCriterion("trade_memo between", value1, value2, "tradeMemo");
            return (Criteria) this;
        }

        public Criteria andTradeMemoNotBetween(String value1, String value2) {
            addCriterion("trade_memo not between", value1, value2, "tradeMemo");
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

        public Criteria andFeedbackIsNull() {
            addCriterion("feedback is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("feedback is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(Integer value) {
            addCriterion("feedback =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(Integer value) {
            addCriterion("feedback <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(Integer value) {
            addCriterion("feedback >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(Integer value) {
            addCriterion("feedback <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(Integer value) {
            addCriterion("feedback <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<Integer> values) {
            addCriterion("feedback in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<Integer> values) {
            addCriterion("feedback not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(Integer value1, Integer value2) {
            addCriterion("feedback between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andOuterTidIsNull() {
            addCriterion("outer_tid is null");
            return (Criteria) this;
        }

        public Criteria andOuterTidIsNotNull() {
            addCriterion("outer_tid is not null");
            return (Criteria) this;
        }

        public Criteria andOuterTidEqualTo(String value) {
            addCriterion("outer_tid =", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidNotEqualTo(String value) {
            addCriterion("outer_tid <>", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidGreaterThan(String value) {
            addCriterion("outer_tid >", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidGreaterThanOrEqualTo(String value) {
            addCriterion("outer_tid >=", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidLessThan(String value) {
            addCriterion("outer_tid <", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidLessThanOrEqualTo(String value) {
            addCriterion("outer_tid <=", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidLike(String value) {
            addCriterion("outer_tid like", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidNotLike(String value) {
            addCriterion("outer_tid not like", value, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidIn(List<String> values) {
            addCriterion("outer_tid in", values, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidNotIn(List<String> values) {
            addCriterion("outer_tid not in", values, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidBetween(String value1, String value2) {
            addCriterion("outer_tid between", value1, value2, "outerTid");
            return (Criteria) this;
        }

        public Criteria andOuterTidNotBetween(String value1, String value2) {
            addCriterion("outer_tid not between", value1, value2, "outerTid");
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

        public Criteria andShippingTypeIsNull() {
            addCriterion("shipping_type is null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIsNotNull() {
            addCriterion("shipping_type is not null");
            return (Criteria) this;
        }

        public Criteria andShippingTypeEqualTo(String value) {
            addCriterion("shipping_type =", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotEqualTo(String value) {
            addCriterion("shipping_type <>", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThan(String value) {
            addCriterion("shipping_type >", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_type >=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThan(String value) {
            addCriterion("shipping_type <", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLessThanOrEqualTo(String value) {
            addCriterion("shipping_type <=", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeLike(String value) {
            addCriterion("shipping_type like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotLike(String value) {
            addCriterion("shipping_type not like", value, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeIn(List<String> values) {
            addCriterion("shipping_type in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotIn(List<String> values) {
            addCriterion("shipping_type not in", values, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeBetween(String value1, String value2) {
            addCriterion("shipping_type between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andShippingTypeNotBetween(String value1, String value2) {
            addCriterion("shipping_type not between", value1, value2, "shippingType");
            return (Criteria) this;
        }

        public Criteria andPostFeeIsNull() {
            addCriterion("post_fee is null");
            return (Criteria) this;
        }

        public Criteria andPostFeeIsNotNull() {
            addCriterion("post_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPostFeeEqualTo(BigDecimal value) {
            addCriterion("post_fee =", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotEqualTo(BigDecimal value) {
            addCriterion("post_fee <>", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeGreaterThan(BigDecimal value) {
            addCriterion("post_fee >", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("post_fee >=", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeLessThan(BigDecimal value) {
            addCriterion("post_fee <", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("post_fee <=", value, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeIn(List<BigDecimal> values) {
            addCriterion("post_fee in", values, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotIn(List<BigDecimal> values) {
            addCriterion("post_fee not in", values, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_fee between", value1, value2, "postFee");
            return (Criteria) this;
        }

        public Criteria andPostFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_fee not between", value1, value2, "postFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNull() {
            addCriterion("discount_fee is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNotNull() {
            addCriterion("discount_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeEqualTo(BigDecimal value) {
            addCriterion("discount_fee =", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotEqualTo(BigDecimal value) {
            addCriterion("discount_fee <>", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThan(BigDecimal value) {
            addCriterion("discount_fee >", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee >=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThan(BigDecimal value) {
            addCriterion("discount_fee <", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_fee <=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIn(List<BigDecimal> values) {
            addCriterion("discount_fee in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotIn(List<BigDecimal> values) {
            addCriterion("discount_fee not in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_fee not between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNull() {
            addCriterion("adjust_fee is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("adjust_fee is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(BigDecimal value) {
            addCriterion("adjust_fee =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(BigDecimal value) {
            addCriterion("adjust_fee <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(BigDecimal value) {
            addCriterion("adjust_fee >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_fee >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(BigDecimal value) {
            addCriterion("adjust_fee <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("adjust_fee <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<BigDecimal> values) {
            addCriterion("adjust_fee in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<BigDecimal> values) {
            addCriterion("adjust_fee not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_fee between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("adjust_fee not between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(BigDecimal value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(BigDecimal value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(BigDecimal value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(BigDecimal value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<BigDecimal> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<BigDecimal> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment not between", value1, value2, "payment");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIsNull() {
            addCriterion("consign_time is null");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIsNotNull() {
            addCriterion("consign_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsignTimeEqualTo(Date value) {
            addCriterion("consign_time =", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotEqualTo(Date value) {
            addCriterion("consign_time <>", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeGreaterThan(Date value) {
            addCriterion("consign_time >", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("consign_time >=", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeLessThan(Date value) {
            addCriterion("consign_time <", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeLessThanOrEqualTo(Date value) {
            addCriterion("consign_time <=", value, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeIn(List<Date> values) {
            addCriterion("consign_time in", values, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotIn(List<Date> values) {
            addCriterion("consign_time not in", values, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeBetween(Date value1, Date value2) {
            addCriterion("consign_time between", value1, value2, "consignTime");
            return (Criteria) this;
        }

        public Criteria andConsignTimeNotBetween(Date value1, Date value2) {
            addCriterion("consign_time not between", value1, value2, "consignTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNull() {
            addCriterion("sign_time is null");
            return (Criteria) this;
        }

        public Criteria andSignTimeIsNotNull() {
            addCriterion("sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimeEqualTo(Date value) {
            addCriterion("sign_time =", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotEqualTo(Date value) {
            addCriterion("sign_time <>", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThan(Date value) {
            addCriterion("sign_time >", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_time >=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThan(Date value) {
            addCriterion("sign_time <", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_time <=", value, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeIn(List<Date> values) {
            addCriterion("sign_time in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotIn(List<Date> values) {
            addCriterion("sign_time not in", values, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeBetween(Date value1, Date value2) {
            addCriterion("sign_time between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andSignTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_time not between", value1, value2, "signTime");
            return (Criteria) this;
        }

        public Criteria andParentTidIsNull() {
            addCriterion("parent_tid is null");
            return (Criteria) this;
        }

        public Criteria andParentTidIsNotNull() {
            addCriterion("parent_tid is not null");
            return (Criteria) this;
        }

        public Criteria andParentTidEqualTo(String value) {
            addCriterion("parent_tid =", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidNotEqualTo(String value) {
            addCriterion("parent_tid <>", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidGreaterThan(String value) {
            addCriterion("parent_tid >", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidGreaterThanOrEqualTo(String value) {
            addCriterion("parent_tid >=", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidLessThan(String value) {
            addCriterion("parent_tid <", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidLessThanOrEqualTo(String value) {
            addCriterion("parent_tid <=", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidLike(String value) {
            addCriterion("parent_tid like", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidNotLike(String value) {
            addCriterion("parent_tid not like", value, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidIn(List<String> values) {
            addCriterion("parent_tid in", values, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidNotIn(List<String> values) {
            addCriterion("parent_tid not in", values, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidBetween(String value1, String value2) {
            addCriterion("parent_tid between", value1, value2, "parentTid");
            return (Criteria) this;
        }

        public Criteria andParentTidNotBetween(String value1, String value2) {
            addCriterion("parent_tid not between", value1, value2, "parentTid");
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