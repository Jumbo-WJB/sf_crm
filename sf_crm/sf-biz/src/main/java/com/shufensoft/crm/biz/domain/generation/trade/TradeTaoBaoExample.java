package com.shufensoft.crm.biz.domain.generation.trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeTaoBaoExample {
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

    public TradeTaoBaoExample() {
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

    public void addSellerNickQueryColumn() {
        this.queryColumns.add("seller_nick");
    }

    public void addMaxSellerNickQueryColumn() {
        this.queryColumns.add("max(seller_nick) max_seller_nick");
    }

    public void addMinSellerNickQueryColumn() {
        this.queryColumns.add("min(seller_nick) min_seller_nick");
    }

    public void addAvgSellerNickQueryColumn() {
        this.queryColumns.add(" avg(seller_nick) avg_seller_nick");
    }

    public void addCountSellerNickQueryColumn() {
        this.queryColumns.add(" count(seller_nick) count_seller_nick");
    }

    public void addSumSellerNickQueryColumn() {
        this.queryColumns.add(" sum(seller_nick) sum_seller_nick");
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

    public void addSellerRateQueryColumn() {
        this.queryColumns.add("seller_rate");
    }

    public void addMaxSellerRateQueryColumn() {
        this.queryColumns.add("max(seller_rate) max_seller_rate");
    }

    public void addMinSellerRateQueryColumn() {
        this.queryColumns.add("min(seller_rate) min_seller_rate");
    }

    public void addAvgSellerRateQueryColumn() {
        this.queryColumns.add(" avg(seller_rate) avg_seller_rate");
    }

    public void addCountSellerRateQueryColumn() {
        this.queryColumns.add(" count(seller_rate) count_seller_rate");
    }

    public void addSumSellerRateQueryColumn() {
        this.queryColumns.add(" sum(seller_rate) sum_seller_rate");
    }

    public void addBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add("buyer_obtain_point_fee");
    }

    public void addMaxBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add("max(buyer_obtain_point_fee) max_buyer_obtain_point_fee");
    }

    public void addMinBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add("min(buyer_obtain_point_fee) min_buyer_obtain_point_fee");
    }

    public void addAvgBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add(" avg(buyer_obtain_point_fee) avg_buyer_obtain_point_fee");
    }

    public void addCountBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add(" count(buyer_obtain_point_fee) count_buyer_obtain_point_fee");
    }

    public void addSumBuyerObtainPointFeeQueryColumn() {
        this.queryColumns.add(" sum(buyer_obtain_point_fee) sum_buyer_obtain_point_fee");
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

    public void addSellerAlipayNoQueryColumn() {
        this.queryColumns.add("seller_alipay_no");
    }

    public void addMaxSellerAlipayNoQueryColumn() {
        this.queryColumns.add("max(seller_alipay_no) max_seller_alipay_no");
    }

    public void addMinSellerAlipayNoQueryColumn() {
        this.queryColumns.add("min(seller_alipay_no) min_seller_alipay_no");
    }

    public void addAvgSellerAlipayNoQueryColumn() {
        this.queryColumns.add(" avg(seller_alipay_no) avg_seller_alipay_no");
    }

    public void addCountSellerAlipayNoQueryColumn() {
        this.queryColumns.add(" count(seller_alipay_no) count_seller_alipay_no");
    }

    public void addSumSellerAlipayNoQueryColumn() {
        this.queryColumns.add(" sum(seller_alipay_no) sum_seller_alipay_no");
    }

    public void addSellerMobileQueryColumn() {
        this.queryColumns.add("seller_mobile");
    }

    public void addMaxSellerMobileQueryColumn() {
        this.queryColumns.add("max(seller_mobile) max_seller_mobile");
    }

    public void addMinSellerMobileQueryColumn() {
        this.queryColumns.add("min(seller_mobile) min_seller_mobile");
    }

    public void addAvgSellerMobileQueryColumn() {
        this.queryColumns.add(" avg(seller_mobile) avg_seller_mobile");
    }

    public void addCountSellerMobileQueryColumn() {
        this.queryColumns.add(" count(seller_mobile) count_seller_mobile");
    }

    public void addSumSellerMobileQueryColumn() {
        this.queryColumns.add(" sum(seller_mobile) sum_seller_mobile");
    }

    public void addSellerPhoneQueryColumn() {
        this.queryColumns.add("seller_phone");
    }

    public void addMaxSellerPhoneQueryColumn() {
        this.queryColumns.add("max(seller_phone) max_seller_phone");
    }

    public void addMinSellerPhoneQueryColumn() {
        this.queryColumns.add("min(seller_phone) min_seller_phone");
    }

    public void addAvgSellerPhoneQueryColumn() {
        this.queryColumns.add(" avg(seller_phone) avg_seller_phone");
    }

    public void addCountSellerPhoneQueryColumn() {
        this.queryColumns.add(" count(seller_phone) count_seller_phone");
    }

    public void addSumSellerPhoneQueryColumn() {
        this.queryColumns.add(" sum(seller_phone) sum_seller_phone");
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

    public void addSumSellerNameQueryColumn() {
        this.queryColumns.add(" sum(seller_name) sum_seller_name");
    }

    public void addSellerEmailQueryColumn() {
        this.queryColumns.add("seller_email");
    }

    public void addMaxSellerEmailQueryColumn() {
        this.queryColumns.add("max(seller_email) max_seller_email");
    }

    public void addMinSellerEmailQueryColumn() {
        this.queryColumns.add("min(seller_email) min_seller_email");
    }

    public void addAvgSellerEmailQueryColumn() {
        this.queryColumns.add(" avg(seller_email) avg_seller_email");
    }

    public void addCountSellerEmailQueryColumn() {
        this.queryColumns.add(" count(seller_email) count_seller_email");
    }

    public void addSumSellerEmailQueryColumn() {
        this.queryColumns.add(" sum(seller_email) sum_seller_email");
    }

    public void addAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add("available_confirm_fee");
    }

    public void addMaxAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add("max(available_confirm_fee) max_available_confirm_fee");
    }

    public void addMinAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add("min(available_confirm_fee) min_available_confirm_fee");
    }

    public void addAvgAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add(" avg(available_confirm_fee) avg_available_confirm_fee");
    }

    public void addCountAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add(" count(available_confirm_fee) count_available_confirm_fee");
    }

    public void addSumAvailableConfirmFeeQueryColumn() {
        this.queryColumns.add(" sum(available_confirm_fee) sum_available_confirm_fee");
    }

    public void addReceivedPaymentQueryColumn() {
        this.queryColumns.add("received_payment");
    }

    public void addMaxReceivedPaymentQueryColumn() {
        this.queryColumns.add("max(received_payment) max_received_payment");
    }

    public void addMinReceivedPaymentQueryColumn() {
        this.queryColumns.add("min(received_payment) min_received_payment");
    }

    public void addAvgReceivedPaymentQueryColumn() {
        this.queryColumns.add(" avg(received_payment) avg_received_payment");
    }

    public void addCountReceivedPaymentQueryColumn() {
        this.queryColumns.add(" count(received_payment) count_received_payment");
    }

    public void addSumReceivedPaymentQueryColumn() {
        this.queryColumns.add(" sum(received_payment) sum_received_payment");
    }

    public void addTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("timeout_action_time");
    }

    public void addMaxTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("max(timeout_action_time) max_timeout_action_time");
    }

    public void addMinTimeoutActionTimeQueryColumn() {
        this.queryColumns.add("min(timeout_action_time) min_timeout_action_time");
    }

    public void addAvgTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" avg(timeout_action_time) avg_timeout_action_time");
    }

    public void addCountTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" count(timeout_action_time) count_timeout_action_time");
    }

    public void addSumTimeoutActionTimeQueryColumn() {
        this.queryColumns.add(" sum(timeout_action_time) sum_timeout_action_time");
    }

    public void addIs3dQueryColumn() {
        this.queryColumns.add("is_3d");
    }

    public void addMaxIs3dQueryColumn() {
        this.queryColumns.add("max(is_3d) max_is_3d");
    }

    public void addMinIs3dQueryColumn() {
        this.queryColumns.add("min(is_3d) min_is_3d");
    }

    public void addAvgIs3dQueryColumn() {
        this.queryColumns.add(" avg(is_3d) avg_is_3d");
    }

    public void addCountIs3dQueryColumn() {
        this.queryColumns.add(" count(is_3d) count_is_3d");
    }

    public void addSumIs3dQueryColumn() {
        this.queryColumns.add(" sum(is_3d) sum_is_3d");
    }

    public void addPromotionQueryColumn() {
        this.queryColumns.add("promotion");
    }

    public void addMaxPromotionQueryColumn() {
        this.queryColumns.add("max(promotion) max_promotion");
    }

    public void addMinPromotionQueryColumn() {
        this.queryColumns.add("min(promotion) min_promotion");
    }

    public void addAvgPromotionQueryColumn() {
        this.queryColumns.add(" avg(promotion) avg_promotion");
    }

    public void addCountPromotionQueryColumn() {
        this.queryColumns.add(" count(promotion) count_promotion");
    }

    public void addSumPromotionQueryColumn() {
        this.queryColumns.add(" sum(promotion) sum_promotion");
    }

    public void addEstConTimeQueryColumn() {
        this.queryColumns.add("est_con_time");
    }

    public void addMaxEstConTimeQueryColumn() {
        this.queryColumns.add("max(est_con_time) max_est_con_time");
    }

    public void addMinEstConTimeQueryColumn() {
        this.queryColumns.add("min(est_con_time) min_est_con_time");
    }

    public void addAvgEstConTimeQueryColumn() {
        this.queryColumns.add(" avg(est_con_time) avg_est_con_time");
    }

    public void addCountEstConTimeQueryColumn() {
        this.queryColumns.add(" count(est_con_time) count_est_con_time");
    }

    public void addSumEstConTimeQueryColumn() {
        this.queryColumns.add(" sum(est_con_time) sum_est_con_time");
    }

    public void addInvoiceKindQueryColumn() {
        this.queryColumns.add("invoice_kind");
    }

    public void addMaxInvoiceKindQueryColumn() {
        this.queryColumns.add("max(invoice_kind) max_invoice_kind");
    }

    public void addMinInvoiceKindQueryColumn() {
        this.queryColumns.add("min(invoice_kind) min_invoice_kind");
    }

    public void addAvgInvoiceKindQueryColumn() {
        this.queryColumns.add(" avg(invoice_kind) avg_invoice_kind");
    }

    public void addCountInvoiceKindQueryColumn() {
        this.queryColumns.add(" count(invoice_kind) count_invoice_kind");
    }

    public void addSumInvoiceKindQueryColumn() {
        this.queryColumns.add(" sum(invoice_kind) sum_invoice_kind");
    }

    public void addGoodsCategoryNumQueryColumn() {
        this.queryColumns.add("goods_category_num");
    }

    public void addMaxGoodsCategoryNumQueryColumn() {
        this.queryColumns.add("max(goods_category_num) max_goods_category_num");
    }

    public void addMinGoodsCategoryNumQueryColumn() {
        this.queryColumns.add("min(goods_category_num) min_goods_category_num");
    }

    public void addAvgGoodsCategoryNumQueryColumn() {
        this.queryColumns.add(" avg(goods_category_num) avg_goods_category_num");
    }

    public void addCountGoodsCategoryNumQueryColumn() {
        this.queryColumns.add(" count(goods_category_num) count_goods_category_num");
    }

    public void addSumGoodsCategoryNumQueryColumn() {
        this.queryColumns.add(" sum(goods_category_num) sum_goods_category_num");
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

    public void addSellerCodFeeQueryColumn() {
        this.queryColumns.add("seller_cod_fee");
    }

    public void addMaxSellerCodFeeQueryColumn() {
        this.queryColumns.add("max(seller_cod_fee) max_seller_cod_fee");
    }

    public void addMinSellerCodFeeQueryColumn() {
        this.queryColumns.add("min(seller_cod_fee) min_seller_cod_fee");
    }

    public void addAvgSellerCodFeeQueryColumn() {
        this.queryColumns.add(" avg(seller_cod_fee) avg_seller_cod_fee");
    }

    public void addCountSellerCodFeeQueryColumn() {
        this.queryColumns.add(" count(seller_cod_fee) count_seller_cod_fee");
    }

    public void addSumSellerCodFeeQueryColumn() {
        this.queryColumns.add(" sum(seller_cod_fee) sum_seller_cod_fee");
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

    public void addPointFeeQueryColumn() {
        this.queryColumns.add("point_fee");
    }

    public void addMaxPointFeeQueryColumn() {
        this.queryColumns.add("max(point_fee) max_point_fee");
    }

    public void addMinPointFeeQueryColumn() {
        this.queryColumns.add("min(point_fee) min_point_fee");
    }

    public void addAvgPointFeeQueryColumn() {
        this.queryColumns.add(" avg(point_fee) avg_point_fee");
    }

    public void addCountPointFeeQueryColumn() {
        this.queryColumns.add(" count(point_fee) count_point_fee");
    }

    public void addSumPointFeeQueryColumn() {
        this.queryColumns.add(" sum(point_fee) sum_point_fee");
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

    public void addIsBrandSaleQueryColumn() {
        this.queryColumns.add("is_brand_sale");
    }

    public void addMaxIsBrandSaleQueryColumn() {
        this.queryColumns.add("max(is_brand_sale) max_is_brand_sale");
    }

    public void addMinIsBrandSaleQueryColumn() {
        this.queryColumns.add("min(is_brand_sale) min_is_brand_sale");
    }

    public void addAvgIsBrandSaleQueryColumn() {
        this.queryColumns.add(" avg(is_brand_sale) avg_is_brand_sale");
    }

    public void addCountIsBrandSaleQueryColumn() {
        this.queryColumns.add(" count(is_brand_sale) count_is_brand_sale");
    }

    public void addSumIsBrandSaleQueryColumn() {
        this.queryColumns.add(" sum(is_brand_sale) sum_is_brand_sale");
    }

    public void addLgAgingQueryColumn() {
        this.queryColumns.add("lg_aging");
    }

    public void addMaxLgAgingQueryColumn() {
        this.queryColumns.add("max(lg_aging) max_lg_aging");
    }

    public void addMinLgAgingQueryColumn() {
        this.queryColumns.add("min(lg_aging) min_lg_aging");
    }

    public void addAvgLgAgingQueryColumn() {
        this.queryColumns.add(" avg(lg_aging) avg_lg_aging");
    }

    public void addCountLgAgingQueryColumn() {
        this.queryColumns.add(" count(lg_aging) count_lg_aging");
    }

    public void addSumLgAgingQueryColumn() {
        this.queryColumns.add(" sum(lg_aging) sum_lg_aging");
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

    public void addModifiedQueryColumn() {
        this.queryColumns.add("modified");
    }

    public void addMaxModifiedQueryColumn() {
        this.queryColumns.add("max(modified) max_modified");
    }

    public void addMinModifiedQueryColumn() {
        this.queryColumns.add("min(modified) min_modified");
    }

    public void addAvgModifiedQueryColumn() {
        this.queryColumns.add(" avg(modified) avg_modified");
    }

    public void addCountModifiedQueryColumn() {
        this.queryColumns.add(" count(modified) count_modified");
    }

    public void addSumModifiedQueryColumn() {
        this.queryColumns.add(" sum(modified) sum_modified");
    }

    public void addEndTimeQueryColumn() {
        this.queryColumns.add("end_time");
    }

    public void addMaxEndTimeQueryColumn() {
        this.queryColumns.add("max(end_time) max_end_time");
    }

    public void addMinEndTimeQueryColumn() {
        this.queryColumns.add("min(end_time) min_end_time");
    }

    public void addAvgEndTimeQueryColumn() {
        this.queryColumns.add(" avg(end_time) avg_end_time");
    }

    public void addCountEndTimeQueryColumn() {
        this.queryColumns.add(" count(end_time) count_end_time");
    }

    public void addSumEndTimeQueryColumn() {
        this.queryColumns.add(" sum(end_time) sum_end_time");
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

    public void addAlipayIdQueryColumn() {
        this.queryColumns.add("alipay_id");
    }

    public void addMaxAlipayIdQueryColumn() {
        this.queryColumns.add("max(alipay_id) max_alipay_id");
    }

    public void addMinAlipayIdQueryColumn() {
        this.queryColumns.add("min(alipay_id) min_alipay_id");
    }

    public void addAvgAlipayIdQueryColumn() {
        this.queryColumns.add(" avg(alipay_id) avg_alipay_id");
    }

    public void addCountAlipayIdQueryColumn() {
        this.queryColumns.add(" count(alipay_id) count_alipay_id");
    }

    public void addSumAlipayIdQueryColumn() {
        this.queryColumns.add(" sum(alipay_id) sum_alipay_id");
    }

    public void addAlipayNoQueryColumn() {
        this.queryColumns.add("alipay_no");
    }

    public void addMaxAlipayNoQueryColumn() {
        this.queryColumns.add("max(alipay_no) max_alipay_no");
    }

    public void addMinAlipayNoQueryColumn() {
        this.queryColumns.add("min(alipay_no) min_alipay_no");
    }

    public void addAvgAlipayNoQueryColumn() {
        this.queryColumns.add(" avg(alipay_no) avg_alipay_no");
    }

    public void addCountAlipayNoQueryColumn() {
        this.queryColumns.add(" count(alipay_no) count_alipay_no");
    }

    public void addSumAlipayNoQueryColumn() {
        this.queryColumns.add(" sum(alipay_no) sum_alipay_no");
    }

    public void addBuyerAlipayNoQueryColumn() {
        this.queryColumns.add("buyer_alipay_no");
    }

    public void addMaxBuyerAlipayNoQueryColumn() {
        this.queryColumns.add("max(buyer_alipay_no) max_buyer_alipay_no");
    }

    public void addMinBuyerAlipayNoQueryColumn() {
        this.queryColumns.add("min(buyer_alipay_no) min_buyer_alipay_no");
    }

    public void addAvgBuyerAlipayNoQueryColumn() {
        this.queryColumns.add(" avg(buyer_alipay_no) avg_buyer_alipay_no");
    }

    public void addCountBuyerAlipayNoQueryColumn() {
        this.queryColumns.add(" count(buyer_alipay_no) count_buyer_alipay_no");
    }

    public void addSumBuyerAlipayNoQueryColumn() {
        this.queryColumns.add(" sum(buyer_alipay_no) sum_buyer_alipay_no");
    }

    public void addBuyerMemoQueryColumn() {
        this.queryColumns.add("buyer_memo");
    }

    public void addMaxBuyerMemoQueryColumn() {
        this.queryColumns.add("max(buyer_memo) max_buyer_memo");
    }

    public void addMinBuyerMemoQueryColumn() {
        this.queryColumns.add("min(buyer_memo) min_buyer_memo");
    }

    public void addAvgBuyerMemoQueryColumn() {
        this.queryColumns.add(" avg(buyer_memo) avg_buyer_memo");
    }

    public void addCountBuyerMemoQueryColumn() {
        this.queryColumns.add(" count(buyer_memo) count_buyer_memo");
    }

    public void addSumBuyerMemoQueryColumn() {
        this.queryColumns.add(" sum(buyer_memo) sum_buyer_memo");
    }

    public void addBuyerFlagQueryColumn() {
        this.queryColumns.add("buyer_flag");
    }

    public void addMaxBuyerFlagQueryColumn() {
        this.queryColumns.add("max(buyer_flag) max_buyer_flag");
    }

    public void addMinBuyerFlagQueryColumn() {
        this.queryColumns.add("min(buyer_flag) min_buyer_flag");
    }

    public void addAvgBuyerFlagQueryColumn() {
        this.queryColumns.add(" avg(buyer_flag) avg_buyer_flag");
    }

    public void addCountBuyerFlagQueryColumn() {
        this.queryColumns.add(" count(buyer_flag) count_buyer_flag");
    }

    public void addSumBuyerFlagQueryColumn() {
        this.queryColumns.add(" sum(buyer_flag) sum_buyer_flag");
    }

    public void addSellerMemoQueryColumn() {
        this.queryColumns.add("seller_memo");
    }

    public void addMaxSellerMemoQueryColumn() {
        this.queryColumns.add("max(seller_memo) max_seller_memo");
    }

    public void addMinSellerMemoQueryColumn() {
        this.queryColumns.add("min(seller_memo) min_seller_memo");
    }

    public void addAvgSellerMemoQueryColumn() {
        this.queryColumns.add(" avg(seller_memo) avg_seller_memo");
    }

    public void addCountSellerMemoQueryColumn() {
        this.queryColumns.add(" count(seller_memo) count_seller_memo");
    }

    public void addSumSellerMemoQueryColumn() {
        this.queryColumns.add(" sum(seller_memo) sum_seller_memo");
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

    public void addBuyerEmailQueryColumn() {
        this.queryColumns.add("buyer_email");
    }

    public void addMaxBuyerEmailQueryColumn() {
        this.queryColumns.add("max(buyer_email) max_buyer_email");
    }

    public void addMinBuyerEmailQueryColumn() {
        this.queryColumns.add("min(buyer_email) min_buyer_email");
    }

    public void addAvgBuyerEmailQueryColumn() {
        this.queryColumns.add(" avg(buyer_email) avg_buyer_email");
    }

    public void addCountBuyerEmailQueryColumn() {
        this.queryColumns.add(" count(buyer_email) count_buyer_email");
    }

    public void addSumBuyerEmailQueryColumn() {
        this.queryColumns.add(" sum(buyer_email) sum_buyer_email");
    }

    public void addHasBuyerMessageQueryColumn() {
        this.queryColumns.add("has_buyer_message");
    }

    public void addMaxHasBuyerMessageQueryColumn() {
        this.queryColumns.add("max(has_buyer_message) max_has_buyer_message");
    }

    public void addMinHasBuyerMessageQueryColumn() {
        this.queryColumns.add("min(has_buyer_message) min_has_buyer_message");
    }

    public void addAvgHasBuyerMessageQueryColumn() {
        this.queryColumns.add(" avg(has_buyer_message) avg_has_buyer_message");
    }

    public void addCountHasBuyerMessageQueryColumn() {
        this.queryColumns.add(" count(has_buyer_message) count_has_buyer_message");
    }

    public void addSumHasBuyerMessageQueryColumn() {
        this.queryColumns.add(" sum(has_buyer_message) sum_has_buyer_message");
    }

    public void addAreaIdQueryColumn() {
        this.queryColumns.add("area_id");
    }

    public void addMaxAreaIdQueryColumn() {
        this.queryColumns.add("max(area_id) max_area_id");
    }

    public void addMinAreaIdQueryColumn() {
        this.queryColumns.add("min(area_id) min_area_id");
    }

    public void addAvgAreaIdQueryColumn() {
        this.queryColumns.add(" avg(area_id) avg_area_id");
    }

    public void addCountAreaIdQueryColumn() {
        this.queryColumns.add(" count(area_id) count_area_id");
    }

    public void addSumAreaIdQueryColumn() {
        this.queryColumns.add(" sum(area_id) sum_area_id");
    }

    public void addCreditCardFeeQueryColumn() {
        this.queryColumns.add("credit_card_fee");
    }

    public void addMaxCreditCardFeeQueryColumn() {
        this.queryColumns.add("max(credit_card_fee) max_credit_card_fee");
    }

    public void addMinCreditCardFeeQueryColumn() {
        this.queryColumns.add("min(credit_card_fee) min_credit_card_fee");
    }

    public void addAvgCreditCardFeeQueryColumn() {
        this.queryColumns.add(" avg(credit_card_fee) avg_credit_card_fee");
    }

    public void addCountCreditCardFeeQueryColumn() {
        this.queryColumns.add(" count(credit_card_fee) count_credit_card_fee");
    }

    public void addSumCreditCardFeeQueryColumn() {
        this.queryColumns.add(" sum(credit_card_fee) sum_credit_card_fee");
    }

    public void addNutFeatureQueryColumn() {
        this.queryColumns.add("nut_feature");
    }

    public void addMaxNutFeatureQueryColumn() {
        this.queryColumns.add("max(nut_feature) max_nut_feature");
    }

    public void addMinNutFeatureQueryColumn() {
        this.queryColumns.add("min(nut_feature) min_nut_feature");
    }

    public void addAvgNutFeatureQueryColumn() {
        this.queryColumns.add(" avg(nut_feature) avg_nut_feature");
    }

    public void addCountNutFeatureQueryColumn() {
        this.queryColumns.add(" count(nut_feature) count_nut_feature");
    }

    public void addSumNutFeatureQueryColumn() {
        this.queryColumns.add(" sum(nut_feature) sum_nut_feature");
    }

    public void addStepTradeStatusQueryColumn() {
        this.queryColumns.add("step_trade_status");
    }

    public void addMaxStepTradeStatusQueryColumn() {
        this.queryColumns.add("max(step_trade_status) max_step_trade_status");
    }

    public void addMinStepTradeStatusQueryColumn() {
        this.queryColumns.add("min(step_trade_status) min_step_trade_status");
    }

    public void addAvgStepTradeStatusQueryColumn() {
        this.queryColumns.add(" avg(step_trade_status) avg_step_trade_status");
    }

    public void addCountStepTradeStatusQueryColumn() {
        this.queryColumns.add(" count(step_trade_status) count_step_trade_status");
    }

    public void addSumStepTradeStatusQueryColumn() {
        this.queryColumns.add(" sum(step_trade_status) sum_step_trade_status");
    }

    public void addStepPaidFeeQueryColumn() {
        this.queryColumns.add("step_paid_fee");
    }

    public void addMaxStepPaidFeeQueryColumn() {
        this.queryColumns.add("max(step_paid_fee) max_step_paid_fee");
    }

    public void addMinStepPaidFeeQueryColumn() {
        this.queryColumns.add("min(step_paid_fee) min_step_paid_fee");
    }

    public void addAvgStepPaidFeeQueryColumn() {
        this.queryColumns.add(" avg(step_paid_fee) avg_step_paid_fee");
    }

    public void addCountStepPaidFeeQueryColumn() {
        this.queryColumns.add(" count(step_paid_fee) count_step_paid_fee");
    }

    public void addSumStepPaidFeeQueryColumn() {
        this.queryColumns.add(" sum(step_paid_fee) sum_step_paid_fee");
    }

    public void addMarkDescQueryColumn() {
        this.queryColumns.add("mark_desc");
    }

    public void addMaxMarkDescQueryColumn() {
        this.queryColumns.add("max(mark_desc) max_mark_desc");
    }

    public void addMinMarkDescQueryColumn() {
        this.queryColumns.add("min(mark_desc) min_mark_desc");
    }

    public void addAvgMarkDescQueryColumn() {
        this.queryColumns.add(" avg(mark_desc) avg_mark_desc");
    }

    public void addCountMarkDescQueryColumn() {
        this.queryColumns.add(" count(mark_desc) count_mark_desc");
    }

    public void addSumMarkDescQueryColumn() {
        this.queryColumns.add(" sum(mark_desc) sum_mark_desc");
    }

    public void addSendTimeQueryColumn() {
        this.queryColumns.add("send_time");
    }

    public void addMaxSendTimeQueryColumn() {
        this.queryColumns.add("max(send_time) max_send_time");
    }

    public void addMinSendTimeQueryColumn() {
        this.queryColumns.add("min(send_time) min_send_time");
    }

    public void addAvgSendTimeQueryColumn() {
        this.queryColumns.add(" avg(send_time) avg_send_time");
    }

    public void addCountSendTimeQueryColumn() {
        this.queryColumns.add(" count(send_time) count_send_time");
    }

    public void addSumSendTimeQueryColumn() {
        this.queryColumns.add(" sum(send_time) sum_send_time");
    }

    public void addTradeFromQueryColumn() {
        this.queryColumns.add("trade_from");
    }

    public void addMaxTradeFromQueryColumn() {
        this.queryColumns.add("max(trade_from) max_trade_from");
    }

    public void addMinTradeFromQueryColumn() {
        this.queryColumns.add("min(trade_from) min_trade_from");
    }

    public void addAvgTradeFromQueryColumn() {
        this.queryColumns.add(" avg(trade_from) avg_trade_from");
    }

    public void addCountTradeFromQueryColumn() {
        this.queryColumns.add(" count(trade_from) count_trade_from");
    }

    public void addSumTradeFromQueryColumn() {
        this.queryColumns.add(" sum(trade_from) sum_trade_from");
    }

    public void addAlipayWarnMsgQueryColumn() {
        this.queryColumns.add("alipay_warn_msg");
    }

    public void addMaxAlipayWarnMsgQueryColumn() {
        this.queryColumns.add("max(alipay_warn_msg) max_alipay_warn_msg");
    }

    public void addMinAlipayWarnMsgQueryColumn() {
        this.queryColumns.add("min(alipay_warn_msg) min_alipay_warn_msg");
    }

    public void addAvgAlipayWarnMsgQueryColumn() {
        this.queryColumns.add(" avg(alipay_warn_msg) avg_alipay_warn_msg");
    }

    public void addCountAlipayWarnMsgQueryColumn() {
        this.queryColumns.add(" count(alipay_warn_msg) count_alipay_warn_msg");
    }

    public void addSumAlipayWarnMsgQueryColumn() {
        this.queryColumns.add(" sum(alipay_warn_msg) sum_alipay_warn_msg");
    }

    public void addCodStatusQueryColumn() {
        this.queryColumns.add("cod_status");
    }

    public void addMaxCodStatusQueryColumn() {
        this.queryColumns.add("max(cod_status) max_cod_status");
    }

    public void addMinCodStatusQueryColumn() {
        this.queryColumns.add("min(cod_status) min_cod_status");
    }

    public void addAvgCodStatusQueryColumn() {
        this.queryColumns.add(" avg(cod_status) avg_cod_status");
    }

    public void addCountCodStatusQueryColumn() {
        this.queryColumns.add(" count(cod_status) count_cod_status");
    }

    public void addSumCodStatusQueryColumn() {
        this.queryColumns.add(" sum(cod_status) sum_cod_status");
    }

    public void addCanRateQueryColumn() {
        this.queryColumns.add("can_rate");
    }

    public void addMaxCanRateQueryColumn() {
        this.queryColumns.add("max(can_rate) max_can_rate");
    }

    public void addMinCanRateQueryColumn() {
        this.queryColumns.add("min(can_rate) min_can_rate");
    }

    public void addAvgCanRateQueryColumn() {
        this.queryColumns.add(" avg(can_rate) avg_can_rate");
    }

    public void addCountCanRateQueryColumn() {
        this.queryColumns.add(" count(can_rate) count_can_rate");
    }

    public void addSumCanRateQueryColumn() {
        this.queryColumns.add(" sum(can_rate) sum_can_rate");
    }

    public void addCommissionFeeQueryColumn() {
        this.queryColumns.add("commission_fee");
    }

    public void addMaxCommissionFeeQueryColumn() {
        this.queryColumns.add("max(commission_fee) max_commission_fee");
    }

    public void addMinCommissionFeeQueryColumn() {
        this.queryColumns.add("min(commission_fee) min_commission_fee");
    }

    public void addAvgCommissionFeeQueryColumn() {
        this.queryColumns.add(" avg(commission_fee) avg_commission_fee");
    }

    public void addCountCommissionFeeQueryColumn() {
        this.queryColumns.add(" count(commission_fee) count_commission_fee");
    }

    public void addSumCommissionFeeQueryColumn() {
        this.queryColumns.add(" sum(commission_fee) sum_commission_fee");
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

    public void addBuyerRateQueryColumn() {
        this.queryColumns.add("buyer_rate");
    }

    public void addMaxBuyerRateQueryColumn() {
        this.queryColumns.add("max(buyer_rate) max_buyer_rate");
    }

    public void addMinBuyerRateQueryColumn() {
        this.queryColumns.add("min(buyer_rate) min_buyer_rate");
    }

    public void addAvgBuyerRateQueryColumn() {
        this.queryColumns.add(" avg(buyer_rate) avg_buyer_rate");
    }

    public void addCountBuyerRateQueryColumn() {
        this.queryColumns.add(" count(buyer_rate) count_buyer_rate");
    }

    public void addSumBuyerRateQueryColumn() {
        this.queryColumns.add(" sum(buyer_rate) sum_buyer_rate");
    }

    public void addTradeSourceQueryColumn() {
        this.queryColumns.add("trade_source");
    }

    public void addMaxTradeSourceQueryColumn() {
        this.queryColumns.add("max(trade_source) max_trade_source");
    }

    public void addMinTradeSourceQueryColumn() {
        this.queryColumns.add("min(trade_source) min_trade_source");
    }

    public void addAvgTradeSourceQueryColumn() {
        this.queryColumns.add(" avg(trade_source) avg_trade_source");
    }

    public void addCountTradeSourceQueryColumn() {
        this.queryColumns.add(" count(trade_source) count_trade_source");
    }

    public void addSumTradeSourceQueryColumn() {
        this.queryColumns.add(" sum(trade_source) sum_trade_source");
    }

    public void addIsPartConsignQueryColumn() {
        this.queryColumns.add("is_part_consign");
    }

    public void addMaxIsPartConsignQueryColumn() {
        this.queryColumns.add("max(is_part_consign) max_is_part_consign");
    }

    public void addMinIsPartConsignQueryColumn() {
        this.queryColumns.add("min(is_part_consign) min_is_part_consign");
    }

    public void addAvgIsPartConsignQueryColumn() {
        this.queryColumns.add(" avg(is_part_consign) avg_is_part_consign");
    }

    public void addCountIsPartConsignQueryColumn() {
        this.queryColumns.add(" count(is_part_consign) count_is_part_consign");
    }

    public void addSumIsPartConsignQueryColumn() {
        this.queryColumns.add(" sum(is_part_consign) sum_is_part_consign");
    }

    public void addRealPointFeeQueryColumn() {
        this.queryColumns.add("real_point_fee");
    }

    public void addMaxRealPointFeeQueryColumn() {
        this.queryColumns.add("max(real_point_fee) max_real_point_fee");
    }

    public void addMinRealPointFeeQueryColumn() {
        this.queryColumns.add("min(real_point_fee) min_real_point_fee");
    }

    public void addAvgRealPointFeeQueryColumn() {
        this.queryColumns.add(" avg(real_point_fee) avg_real_point_fee");
    }

    public void addCountRealPointFeeQueryColumn() {
        this.queryColumns.add(" count(real_point_fee) count_real_point_fee");
    }

    public void addSumRealPointFeeQueryColumn() {
        this.queryColumns.add(" sum(real_point_fee) sum_real_point_fee");
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

    public void addArriveIntervalQueryColumn() {
        this.queryColumns.add("arrive_interval");
    }

    public void addMaxArriveIntervalQueryColumn() {
        this.queryColumns.add("max(arrive_interval) max_arrive_interval");
    }

    public void addMinArriveIntervalQueryColumn() {
        this.queryColumns.add("min(arrive_interval) min_arrive_interval");
    }

    public void addAvgArriveIntervalQueryColumn() {
        this.queryColumns.add(" avg(arrive_interval) avg_arrive_interval");
    }

    public void addCountArriveIntervalQueryColumn() {
        this.queryColumns.add(" count(arrive_interval) count_arrive_interval");
    }

    public void addSumArriveIntervalQueryColumn() {
        this.queryColumns.add(" sum(arrive_interval) sum_arrive_interval");
    }

    public void addArriveCutTimeQueryColumn() {
        this.queryColumns.add("arrive_cut_time");
    }

    public void addMaxArriveCutTimeQueryColumn() {
        this.queryColumns.add("max(arrive_cut_time) max_arrive_cut_time");
    }

    public void addMinArriveCutTimeQueryColumn() {
        this.queryColumns.add("min(arrive_cut_time) min_arrive_cut_time");
    }

    public void addAvgArriveCutTimeQueryColumn() {
        this.queryColumns.add(" avg(arrive_cut_time) avg_arrive_cut_time");
    }

    public void addCountArriveCutTimeQueryColumn() {
        this.queryColumns.add(" count(arrive_cut_time) count_arrive_cut_time");
    }

    public void addSumArriveCutTimeQueryColumn() {
        this.queryColumns.add(" sum(arrive_cut_time) sum_arrive_cut_time");
    }

    public void addConsignIntervalQueryColumn() {
        this.queryColumns.add("consign_interval");
    }

    public void addMaxConsignIntervalQueryColumn() {
        this.queryColumns.add("max(consign_interval) max_consign_interval");
    }

    public void addMinConsignIntervalQueryColumn() {
        this.queryColumns.add("min(consign_interval) min_consign_interval");
    }

    public void addAvgConsignIntervalQueryColumn() {
        this.queryColumns.add(" avg(consign_interval) avg_consign_interval");
    }

    public void addCountConsignIntervalQueryColumn() {
        this.queryColumns.add(" count(consign_interval) count_consign_interval");
    }

    public void addSumConsignIntervalQueryColumn() {
        this.queryColumns.add(" sum(consign_interval) sum_consign_interval");
    }

    public void addAsyncModifiedQueryColumn() {
        this.queryColumns.add("async_modified");
    }

    public void addMaxAsyncModifiedQueryColumn() {
        this.queryColumns.add("max(async_modified) max_async_modified");
    }

    public void addMinAsyncModifiedQueryColumn() {
        this.queryColumns.add("min(async_modified) min_async_modified");
    }

    public void addAvgAsyncModifiedQueryColumn() {
        this.queryColumns.add(" avg(async_modified) avg_async_modified");
    }

    public void addCountAsyncModifiedQueryColumn() {
        this.queryColumns.add(" count(async_modified) count_async_modified");
    }

    public void addSumAsyncModifiedQueryColumn() {
        this.queryColumns.add(" sum(async_modified) sum_async_modified");
    }

    public void addAlipayPointQueryColumn() {
        this.queryColumns.add("alipay_point");
    }

    public void addMaxAlipayPointQueryColumn() {
        this.queryColumns.add("max(alipay_point) max_alipay_point");
    }

    public void addMinAlipayPointQueryColumn() {
        this.queryColumns.add("min(alipay_point) min_alipay_point");
    }

    public void addAvgAlipayPointQueryColumn() {
        this.queryColumns.add(" avg(alipay_point) avg_alipay_point");
    }

    public void addCountAlipayPointQueryColumn() {
        this.queryColumns.add(" count(alipay_point) count_alipay_point");
    }

    public void addSumAlipayPointQueryColumn() {
        this.queryColumns.add(" sum(alipay_point) sum_alipay_point");
    }

    public void addPccAfQueryColumn() {
        this.queryColumns.add("pcc_af");
    }

    public void addMaxPccAfQueryColumn() {
        this.queryColumns.add("max(pcc_af) max_pcc_af");
    }

    public void addMinPccAfQueryColumn() {
        this.queryColumns.add("min(pcc_af) min_pcc_af");
    }

    public void addAvgPccAfQueryColumn() {
        this.queryColumns.add(" avg(pcc_af) avg_pcc_af");
    }

    public void addCountPccAfQueryColumn() {
        this.queryColumns.add(" count(pcc_af) count_pcc_af");
    }

    public void addSumPccAfQueryColumn() {
        this.queryColumns.add(" sum(pcc_af) sum_pcc_af");
    }

    public void addIsWtQueryColumn() {
        this.queryColumns.add("is_wt");
    }

    public void addMaxIsWtQueryColumn() {
        this.queryColumns.add("max(is_wt) max_is_wt");
    }

    public void addMinIsWtQueryColumn() {
        this.queryColumns.add("min(is_wt) min_is_wt");
    }

    public void addAvgIsWtQueryColumn() {
        this.queryColumns.add(" avg(is_wt) avg_is_wt");
    }

    public void addCountIsWtQueryColumn() {
        this.queryColumns.add(" count(is_wt) count_is_wt");
    }

    public void addSumIsWtQueryColumn() {
        this.queryColumns.add(" sum(is_wt) sum_is_wt");
    }

    public void addIsExcelImportQueryColumn() {
        this.queryColumns.add("is_excel_import");
    }

    public void addMaxIsExcelImportQueryColumn() {
        this.queryColumns.add("max(is_excel_import) max_is_excel_import");
    }

    public void addMinIsExcelImportQueryColumn() {
        this.queryColumns.add("min(is_excel_import) min_is_excel_import");
    }

    public void addAvgIsExcelImportQueryColumn() {
        this.queryColumns.add(" avg(is_excel_import) avg_is_excel_import");
    }

    public void addCountIsExcelImportQueryColumn() {
        this.queryColumns.add(" count(is_excel_import) count_is_excel_import");
    }

    public void addSumIsExcelImportQueryColumn() {
        this.queryColumns.add(" sum(is_excel_import) sum_is_excel_import");
    }

    public void addTradeCloseResonQueryColumn() {
        this.queryColumns.add("trade_close_reson");
    }

    public void addMaxTradeCloseResonQueryColumn() {
        this.queryColumns.add("max(trade_close_reson) max_trade_close_reson");
    }

    public void addMinTradeCloseResonQueryColumn() {
        this.queryColumns.add("min(trade_close_reson) min_trade_close_reson");
    }

    public void addAvgTradeCloseResonQueryColumn() {
        this.queryColumns.add(" avg(trade_close_reson) avg_trade_close_reson");
    }

    public void addCountTradeCloseResonQueryColumn() {
        this.queryColumns.add(" count(trade_close_reson) count_trade_close_reson");
    }

    public void addSumTradeCloseResonQueryColumn() {
        this.queryColumns.add(" sum(trade_close_reson) sum_trade_close_reson");
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

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
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

        public Criteria andSellerNickIsNull() {
            addCriterion("seller_nick is null");
            return (Criteria) this;
        }

        public Criteria andSellerNickIsNotNull() {
            addCriterion("seller_nick is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNickEqualTo(String value) {
            addCriterion("seller_nick =", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotEqualTo(String value) {
            addCriterion("seller_nick <>", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThan(String value) {
            addCriterion("seller_nick >", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickGreaterThanOrEqualTo(String value) {
            addCriterion("seller_nick >=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThan(String value) {
            addCriterion("seller_nick <", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLessThanOrEqualTo(String value) {
            addCriterion("seller_nick <=", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickLike(String value) {
            addCriterion("seller_nick like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotLike(String value) {
            addCriterion("seller_nick not like", value, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickIn(List<String> values) {
            addCriterion("seller_nick in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotIn(List<String> values) {
            addCriterion("seller_nick not in", values, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickBetween(String value1, String value2) {
            addCriterion("seller_nick between", value1, value2, "sellerNick");
            return (Criteria) this;
        }

        public Criteria andSellerNickNotBetween(String value1, String value2) {
            addCriterion("seller_nick not between", value1, value2, "sellerNick");
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

        public Criteria andSellerRateIsNull() {
            addCriterion("seller_rate is null");
            return (Criteria) this;
        }

        public Criteria andSellerRateIsNotNull() {
            addCriterion("seller_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSellerRateEqualTo(String value) {
            addCriterion("seller_rate =", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateNotEqualTo(String value) {
            addCriterion("seller_rate <>", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateGreaterThan(String value) {
            addCriterion("seller_rate >", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateGreaterThanOrEqualTo(String value) {
            addCriterion("seller_rate >=", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateLessThan(String value) {
            addCriterion("seller_rate <", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateLessThanOrEqualTo(String value) {
            addCriterion("seller_rate <=", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateLike(String value) {
            addCriterion("seller_rate like", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateNotLike(String value) {
            addCriterion("seller_rate not like", value, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateIn(List<String> values) {
            addCriterion("seller_rate in", values, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateNotIn(List<String> values) {
            addCriterion("seller_rate not in", values, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateBetween(String value1, String value2) {
            addCriterion("seller_rate between", value1, value2, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andSellerRateNotBetween(String value1, String value2) {
            addCriterion("seller_rate not between", value1, value2, "sellerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeIsNull() {
            addCriterion("buyer_obtain_point_fee is null");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeIsNotNull() {
            addCriterion("buyer_obtain_point_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeEqualTo(Integer value) {
            addCriterion("buyer_obtain_point_fee =", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeNotEqualTo(Integer value) {
            addCriterion("buyer_obtain_point_fee <>", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeGreaterThan(Integer value) {
            addCriterion("buyer_obtain_point_fee >", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_obtain_point_fee >=", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeLessThan(Integer value) {
            addCriterion("buyer_obtain_point_fee <", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_obtain_point_fee <=", value, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeIn(List<Integer> values) {
            addCriterion("buyer_obtain_point_fee in", values, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeNotIn(List<Integer> values) {
            addCriterion("buyer_obtain_point_fee not in", values, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeBetween(Integer value1, Integer value2) {
            addCriterion("buyer_obtain_point_fee between", value1, value2, "buyerObtainPointFee");
            return (Criteria) this;
        }

        public Criteria andBuyerObtainPointFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_obtain_point_fee not between", value1, value2, "buyerObtainPointFee");
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

        public Criteria andSellerAlipayNoIsNull() {
            addCriterion("seller_alipay_no is null");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoIsNotNull() {
            addCriterion("seller_alipay_no is not null");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoEqualTo(String value) {
            addCriterion("seller_alipay_no =", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoNotEqualTo(String value) {
            addCriterion("seller_alipay_no <>", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoGreaterThan(String value) {
            addCriterion("seller_alipay_no >", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoGreaterThanOrEqualTo(String value) {
            addCriterion("seller_alipay_no >=", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoLessThan(String value) {
            addCriterion("seller_alipay_no <", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoLessThanOrEqualTo(String value) {
            addCriterion("seller_alipay_no <=", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoLike(String value) {
            addCriterion("seller_alipay_no like", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoNotLike(String value) {
            addCriterion("seller_alipay_no not like", value, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoIn(List<String> values) {
            addCriterion("seller_alipay_no in", values, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoNotIn(List<String> values) {
            addCriterion("seller_alipay_no not in", values, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoBetween(String value1, String value2) {
            addCriterion("seller_alipay_no between", value1, value2, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerAlipayNoNotBetween(String value1, String value2) {
            addCriterion("seller_alipay_no not between", value1, value2, "sellerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andSellerMobileIsNull() {
            addCriterion("seller_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSellerMobileIsNotNull() {
            addCriterion("seller_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSellerMobileEqualTo(String value) {
            addCriterion("seller_mobile =", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileNotEqualTo(String value) {
            addCriterion("seller_mobile <>", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileGreaterThan(String value) {
            addCriterion("seller_mobile >", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("seller_mobile >=", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileLessThan(String value) {
            addCriterion("seller_mobile <", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileLessThanOrEqualTo(String value) {
            addCriterion("seller_mobile <=", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileLike(String value) {
            addCriterion("seller_mobile like", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileNotLike(String value) {
            addCriterion("seller_mobile not like", value, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileIn(List<String> values) {
            addCriterion("seller_mobile in", values, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileNotIn(List<String> values) {
            addCriterion("seller_mobile not in", values, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileBetween(String value1, String value2) {
            addCriterion("seller_mobile between", value1, value2, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerMobileNotBetween(String value1, String value2) {
            addCriterion("seller_mobile not between", value1, value2, "sellerMobile");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIsNull() {
            addCriterion("seller_phone is null");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIsNotNull() {
            addCriterion("seller_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneEqualTo(String value) {
            addCriterion("seller_phone =", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotEqualTo(String value) {
            addCriterion("seller_phone <>", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneGreaterThan(String value) {
            addCriterion("seller_phone >", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("seller_phone >=", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLessThan(String value) {
            addCriterion("seller_phone <", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLessThanOrEqualTo(String value) {
            addCriterion("seller_phone <=", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLike(String value) {
            addCriterion("seller_phone like", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotLike(String value) {
            addCriterion("seller_phone not like", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIn(List<String> values) {
            addCriterion("seller_phone in", values, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotIn(List<String> values) {
            addCriterion("seller_phone not in", values, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneBetween(String value1, String value2) {
            addCriterion("seller_phone between", value1, value2, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotBetween(String value1, String value2) {
            addCriterion("seller_phone not between", value1, value2, "sellerPhone");
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

        public Criteria andSellerEmailIsNull() {
            addCriterion("seller_email is null");
            return (Criteria) this;
        }

        public Criteria andSellerEmailIsNotNull() {
            addCriterion("seller_email is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEmailEqualTo(String value) {
            addCriterion("seller_email =", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotEqualTo(String value) {
            addCriterion("seller_email <>", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailGreaterThan(String value) {
            addCriterion("seller_email >", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("seller_email >=", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLessThan(String value) {
            addCriterion("seller_email <", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLessThanOrEqualTo(String value) {
            addCriterion("seller_email <=", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLike(String value) {
            addCriterion("seller_email like", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotLike(String value) {
            addCriterion("seller_email not like", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailIn(List<String> values) {
            addCriterion("seller_email in", values, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotIn(List<String> values) {
            addCriterion("seller_email not in", values, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailBetween(String value1, String value2) {
            addCriterion("seller_email between", value1, value2, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotBetween(String value1, String value2) {
            addCriterion("seller_email not between", value1, value2, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeIsNull() {
            addCriterion("available_confirm_fee is null");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeIsNotNull() {
            addCriterion("available_confirm_fee is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeEqualTo(BigDecimal value) {
            addCriterion("available_confirm_fee =", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeNotEqualTo(BigDecimal value) {
            addCriterion("available_confirm_fee <>", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeGreaterThan(BigDecimal value) {
            addCriterion("available_confirm_fee >", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available_confirm_fee >=", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeLessThan(BigDecimal value) {
            addCriterion("available_confirm_fee <", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available_confirm_fee <=", value, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeIn(List<BigDecimal> values) {
            addCriterion("available_confirm_fee in", values, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeNotIn(List<BigDecimal> values) {
            addCriterion("available_confirm_fee not in", values, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_confirm_fee between", value1, value2, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andAvailableConfirmFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_confirm_fee not between", value1, value2, "availableConfirmFee");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentIsNull() {
            addCriterion("received_payment is null");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentIsNotNull() {
            addCriterion("received_payment is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentEqualTo(BigDecimal value) {
            addCriterion("received_payment =", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentNotEqualTo(BigDecimal value) {
            addCriterion("received_payment <>", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentGreaterThan(BigDecimal value) {
            addCriterion("received_payment >", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("received_payment >=", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentLessThan(BigDecimal value) {
            addCriterion("received_payment <", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("received_payment <=", value, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentIn(List<BigDecimal> values) {
            addCriterion("received_payment in", values, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentNotIn(List<BigDecimal> values) {
            addCriterion("received_payment not in", values, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_payment between", value1, value2, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andReceivedPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_payment not between", value1, value2, "receivedPayment");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIsNull() {
            addCriterion("timeout_action_time is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIsNotNull() {
            addCriterion("timeout_action_time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeEqualTo(Date value) {
            addCriterion("timeout_action_time =", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotEqualTo(Date value) {
            addCriterion("timeout_action_time <>", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeGreaterThan(Date value) {
            addCriterion("timeout_action_time >", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("timeout_action_time >=", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeLessThan(Date value) {
            addCriterion("timeout_action_time <", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeLessThanOrEqualTo(Date value) {
            addCriterion("timeout_action_time <=", value, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeIn(List<Date> values) {
            addCriterion("timeout_action_time in", values, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotIn(List<Date> values) {
            addCriterion("timeout_action_time not in", values, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeBetween(Date value1, Date value2) {
            addCriterion("timeout_action_time between", value1, value2, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andTimeoutActionTimeNotBetween(Date value1, Date value2) {
            addCriterion("timeout_action_time not between", value1, value2, "timeoutActionTime");
            return (Criteria) this;
        }

        public Criteria andIs3dIsNull() {
            addCriterion("is_3d is null");
            return (Criteria) this;
        }

        public Criteria andIs3dIsNotNull() {
            addCriterion("is_3d is not null");
            return (Criteria) this;
        }

        public Criteria andIs3dEqualTo(String value) {
            addCriterion("is_3d =", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dNotEqualTo(String value) {
            addCriterion("is_3d <>", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dGreaterThan(String value) {
            addCriterion("is_3d >", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dGreaterThanOrEqualTo(String value) {
            addCriterion("is_3d >=", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dLessThan(String value) {
            addCriterion("is_3d <", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dLessThanOrEqualTo(String value) {
            addCriterion("is_3d <=", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dLike(String value) {
            addCriterion("is_3d like", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dNotLike(String value) {
            addCriterion("is_3d not like", value, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dIn(List<String> values) {
            addCriterion("is_3d in", values, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dNotIn(List<String> values) {
            addCriterion("is_3d not in", values, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dBetween(String value1, String value2) {
            addCriterion("is_3d between", value1, value2, "is3d");
            return (Criteria) this;
        }

        public Criteria andIs3dNotBetween(String value1, String value2) {
            addCriterion("is_3d not between", value1, value2, "is3d");
            return (Criteria) this;
        }

        public Criteria andPromotionIsNull() {
            addCriterion("promotion is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIsNotNull() {
            addCriterion("promotion is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionEqualTo(String value) {
            addCriterion("promotion =", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotEqualTo(String value) {
            addCriterion("promotion <>", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionGreaterThan(String value) {
            addCriterion("promotion >", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionGreaterThanOrEqualTo(String value) {
            addCriterion("promotion >=", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionLessThan(String value) {
            addCriterion("promotion <", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionLessThanOrEqualTo(String value) {
            addCriterion("promotion <=", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionLike(String value) {
            addCriterion("promotion like", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotLike(String value) {
            addCriterion("promotion not like", value, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionIn(List<String> values) {
            addCriterion("promotion in", values, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotIn(List<String> values) {
            addCriterion("promotion not in", values, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionBetween(String value1, String value2) {
            addCriterion("promotion between", value1, value2, "promotion");
            return (Criteria) this;
        }

        public Criteria andPromotionNotBetween(String value1, String value2) {
            addCriterion("promotion not between", value1, value2, "promotion");
            return (Criteria) this;
        }

        public Criteria andEstConTimeIsNull() {
            addCriterion("est_con_time is null");
            return (Criteria) this;
        }

        public Criteria andEstConTimeIsNotNull() {
            addCriterion("est_con_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstConTimeEqualTo(Date value) {
            addCriterion("est_con_time =", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeNotEqualTo(Date value) {
            addCriterion("est_con_time <>", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeGreaterThan(Date value) {
            addCriterion("est_con_time >", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("est_con_time >=", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeLessThan(Date value) {
            addCriterion("est_con_time <", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeLessThanOrEqualTo(Date value) {
            addCriterion("est_con_time <=", value, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeIn(List<Date> values) {
            addCriterion("est_con_time in", values, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeNotIn(List<Date> values) {
            addCriterion("est_con_time not in", values, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeBetween(Date value1, Date value2) {
            addCriterion("est_con_time between", value1, value2, "estConTime");
            return (Criteria) this;
        }

        public Criteria andEstConTimeNotBetween(Date value1, Date value2) {
            addCriterion("est_con_time not between", value1, value2, "estConTime");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIsNull() {
            addCriterion("invoice_kind is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIsNotNull() {
            addCriterion("invoice_kind is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindEqualTo(String value) {
            addCriterion("invoice_kind =", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotEqualTo(String value) {
            addCriterion("invoice_kind <>", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindGreaterThan(String value) {
            addCriterion("invoice_kind >", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_kind >=", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindLessThan(String value) {
            addCriterion("invoice_kind <", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindLessThanOrEqualTo(String value) {
            addCriterion("invoice_kind <=", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindLike(String value) {
            addCriterion("invoice_kind like", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotLike(String value) {
            addCriterion("invoice_kind not like", value, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindIn(List<String> values) {
            addCriterion("invoice_kind in", values, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotIn(List<String> values) {
            addCriterion("invoice_kind not in", values, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindBetween(String value1, String value2) {
            addCriterion("invoice_kind between", value1, value2, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andInvoiceKindNotBetween(String value1, String value2) {
            addCriterion("invoice_kind not between", value1, value2, "invoiceKind");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumIsNull() {
            addCriterion("goods_category_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumIsNotNull() {
            addCriterion("goods_category_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumEqualTo(Integer value) {
            addCriterion("goods_category_num =", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumNotEqualTo(Integer value) {
            addCriterion("goods_category_num <>", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumGreaterThan(Integer value) {
            addCriterion("goods_category_num >", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_category_num >=", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumLessThan(Integer value) {
            addCriterion("goods_category_num <", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_category_num <=", value, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumIn(List<Integer> values) {
            addCriterion("goods_category_num in", values, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumNotIn(List<Integer> values) {
            addCriterion("goods_category_num not in", values, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_num between", value1, value2, "goodsCategoryNum");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_num not between", value1, value2, "goodsCategoryNum");
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

        public Criteria andSellerCodFeeIsNull() {
            addCriterion("seller_cod_fee is null");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeIsNotNull() {
            addCriterion("seller_cod_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeEqualTo(BigDecimal value) {
            addCriterion("seller_cod_fee =", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeNotEqualTo(BigDecimal value) {
            addCriterion("seller_cod_fee <>", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeGreaterThan(BigDecimal value) {
            addCriterion("seller_cod_fee >", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seller_cod_fee >=", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeLessThan(BigDecimal value) {
            addCriterion("seller_cod_fee <", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seller_cod_fee <=", value, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeIn(List<BigDecimal> values) {
            addCriterion("seller_cod_fee in", values, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeNotIn(List<BigDecimal> values) {
            addCriterion("seller_cod_fee not in", values, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seller_cod_fee between", value1, value2, "sellerCodFee");
            return (Criteria) this;
        }

        public Criteria andSellerCodFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seller_cod_fee not between", value1, value2, "sellerCodFee");
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

        public Criteria andPointFeeIsNull() {
            addCriterion("point_fee is null");
            return (Criteria) this;
        }

        public Criteria andPointFeeIsNotNull() {
            addCriterion("point_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPointFeeEqualTo(Integer value) {
            addCriterion("point_fee =", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeNotEqualTo(Integer value) {
            addCriterion("point_fee <>", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeGreaterThan(Integer value) {
            addCriterion("point_fee >", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_fee >=", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeLessThan(Integer value) {
            addCriterion("point_fee <", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeLessThanOrEqualTo(Integer value) {
            addCriterion("point_fee <=", value, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeIn(List<Integer> values) {
            addCriterion("point_fee in", values, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeNotIn(List<Integer> values) {
            addCriterion("point_fee not in", values, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeBetween(Integer value1, Integer value2) {
            addCriterion("point_fee between", value1, value2, "pointFee");
            return (Criteria) this;
        }

        public Criteria andPointFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("point_fee not between", value1, value2, "pointFee");
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

        public Criteria andIsBrandSaleIsNull() {
            addCriterion("is_brand_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleIsNotNull() {
            addCriterion("is_brand_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleEqualTo(String value) {
            addCriterion("is_brand_sale =", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleNotEqualTo(String value) {
            addCriterion("is_brand_sale <>", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleGreaterThan(String value) {
            addCriterion("is_brand_sale >", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleGreaterThanOrEqualTo(String value) {
            addCriterion("is_brand_sale >=", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleLessThan(String value) {
            addCriterion("is_brand_sale <", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleLessThanOrEqualTo(String value) {
            addCriterion("is_brand_sale <=", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleLike(String value) {
            addCriterion("is_brand_sale like", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleNotLike(String value) {
            addCriterion("is_brand_sale not like", value, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleIn(List<String> values) {
            addCriterion("is_brand_sale in", values, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleNotIn(List<String> values) {
            addCriterion("is_brand_sale not in", values, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleBetween(String value1, String value2) {
            addCriterion("is_brand_sale between", value1, value2, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andIsBrandSaleNotBetween(String value1, String value2) {
            addCriterion("is_brand_sale not between", value1, value2, "isBrandSale");
            return (Criteria) this;
        }

        public Criteria andLgAgingIsNull() {
            addCriterion("lg_aging is null");
            return (Criteria) this;
        }

        public Criteria andLgAgingIsNotNull() {
            addCriterion("lg_aging is not null");
            return (Criteria) this;
        }

        public Criteria andLgAgingEqualTo(BigDecimal value) {
            addCriterion("lg_aging =", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingNotEqualTo(BigDecimal value) {
            addCriterion("lg_aging <>", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingGreaterThan(BigDecimal value) {
            addCriterion("lg_aging >", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lg_aging >=", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingLessThan(BigDecimal value) {
            addCriterion("lg_aging <", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lg_aging <=", value, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingIn(List<BigDecimal> values) {
            addCriterion("lg_aging in", values, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingNotIn(List<BigDecimal> values) {
            addCriterion("lg_aging not in", values, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lg_aging between", value1, value2, "lgAging");
            return (Criteria) this;
        }

        public Criteria andLgAgingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lg_aging not between", value1, value2, "lgAging");
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

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andAlipayIdIsNull() {
            addCriterion("alipay_id is null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIsNotNull() {
            addCriterion("alipay_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdEqualTo(Long value) {
            addCriterion("alipay_id =", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotEqualTo(Long value) {
            addCriterion("alipay_id <>", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThan(Long value) {
            addCriterion("alipay_id >", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("alipay_id >=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThan(Long value) {
            addCriterion("alipay_id <", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThanOrEqualTo(Long value) {
            addCriterion("alipay_id <=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIn(List<Long> values) {
            addCriterion("alipay_id in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotIn(List<Long> values) {
            addCriterion("alipay_id not in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdBetween(Long value1, Long value2) {
            addCriterion("alipay_id between", value1, value2, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotBetween(Long value1, Long value2) {
            addCriterion("alipay_id not between", value1, value2, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIsNull() {
            addCriterion("alipay_no is null");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIsNotNull() {
            addCriterion("alipay_no is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayNoEqualTo(String value) {
            addCriterion("alipay_no =", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotEqualTo(String value) {
            addCriterion("alipay_no <>", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoGreaterThan(String value) {
            addCriterion("alipay_no >", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_no >=", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLessThan(String value) {
            addCriterion("alipay_no <", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLessThanOrEqualTo(String value) {
            addCriterion("alipay_no <=", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoLike(String value) {
            addCriterion("alipay_no like", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotLike(String value) {
            addCriterion("alipay_no not like", value, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoIn(List<String> values) {
            addCriterion("alipay_no in", values, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotIn(List<String> values) {
            addCriterion("alipay_no not in", values, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoBetween(String value1, String value2) {
            addCriterion("alipay_no between", value1, value2, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andAlipayNoNotBetween(String value1, String value2) {
            addCriterion("alipay_no not between", value1, value2, "alipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoIsNull() {
            addCriterion("buyer_alipay_no is null");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoIsNotNull() {
            addCriterion("buyer_alipay_no is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoEqualTo(String value) {
            addCriterion("buyer_alipay_no =", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoNotEqualTo(String value) {
            addCriterion("buyer_alipay_no <>", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoGreaterThan(String value) {
            addCriterion("buyer_alipay_no >", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_alipay_no >=", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoLessThan(String value) {
            addCriterion("buyer_alipay_no <", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoLessThanOrEqualTo(String value) {
            addCriterion("buyer_alipay_no <=", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoLike(String value) {
            addCriterion("buyer_alipay_no like", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoNotLike(String value) {
            addCriterion("buyer_alipay_no not like", value, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoIn(List<String> values) {
            addCriterion("buyer_alipay_no in", values, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoNotIn(List<String> values) {
            addCriterion("buyer_alipay_no not in", values, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoBetween(String value1, String value2) {
            addCriterion("buyer_alipay_no between", value1, value2, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerAlipayNoNotBetween(String value1, String value2) {
            addCriterion("buyer_alipay_no not between", value1, value2, "buyerAlipayNo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoIsNull() {
            addCriterion("buyer_memo is null");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoIsNotNull() {
            addCriterion("buyer_memo is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoEqualTo(String value) {
            addCriterion("buyer_memo =", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoNotEqualTo(String value) {
            addCriterion("buyer_memo <>", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoGreaterThan(String value) {
            addCriterion("buyer_memo >", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_memo >=", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoLessThan(String value) {
            addCriterion("buyer_memo <", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoLessThanOrEqualTo(String value) {
            addCriterion("buyer_memo <=", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoLike(String value) {
            addCriterion("buyer_memo like", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoNotLike(String value) {
            addCriterion("buyer_memo not like", value, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoIn(List<String> values) {
            addCriterion("buyer_memo in", values, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoNotIn(List<String> values) {
            addCriterion("buyer_memo not in", values, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoBetween(String value1, String value2) {
            addCriterion("buyer_memo between", value1, value2, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerMemoNotBetween(String value1, String value2) {
            addCriterion("buyer_memo not between", value1, value2, "buyerMemo");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagIsNull() {
            addCriterion("buyer_flag is null");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagIsNotNull() {
            addCriterion("buyer_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagEqualTo(Integer value) {
            addCriterion("buyer_flag =", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagNotEqualTo(Integer value) {
            addCriterion("buyer_flag <>", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagGreaterThan(Integer value) {
            addCriterion("buyer_flag >", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_flag >=", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagLessThan(Integer value) {
            addCriterion("buyer_flag <", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_flag <=", value, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagIn(List<Integer> values) {
            addCriterion("buyer_flag in", values, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagNotIn(List<Integer> values) {
            addCriterion("buyer_flag not in", values, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagBetween(Integer value1, Integer value2) {
            addCriterion("buyer_flag between", value1, value2, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andBuyerFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_flag not between", value1, value2, "buyerFlag");
            return (Criteria) this;
        }

        public Criteria andSellerMemoIsNull() {
            addCriterion("seller_memo is null");
            return (Criteria) this;
        }

        public Criteria andSellerMemoIsNotNull() {
            addCriterion("seller_memo is not null");
            return (Criteria) this;
        }

        public Criteria andSellerMemoEqualTo(String value) {
            addCriterion("seller_memo =", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoNotEqualTo(String value) {
            addCriterion("seller_memo <>", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoGreaterThan(String value) {
            addCriterion("seller_memo >", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoGreaterThanOrEqualTo(String value) {
            addCriterion("seller_memo >=", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoLessThan(String value) {
            addCriterion("seller_memo <", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoLessThanOrEqualTo(String value) {
            addCriterion("seller_memo <=", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoLike(String value) {
            addCriterion("seller_memo like", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoNotLike(String value) {
            addCriterion("seller_memo not like", value, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoIn(List<String> values) {
            addCriterion("seller_memo in", values, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoNotIn(List<String> values) {
            addCriterion("seller_memo not in", values, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoBetween(String value1, String value2) {
            addCriterion("seller_memo between", value1, value2, "sellerMemo");
            return (Criteria) this;
        }

        public Criteria andSellerMemoNotBetween(String value1, String value2) {
            addCriterion("seller_memo not between", value1, value2, "sellerMemo");
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

        public Criteria andBuyerEmailIsNull() {
            addCriterion("buyer_email is null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailIsNotNull() {
            addCriterion("buyer_email is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailEqualTo(String value) {
            addCriterion("buyer_email =", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotEqualTo(String value) {
            addCriterion("buyer_email <>", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailGreaterThan(String value) {
            addCriterion("buyer_email >", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_email >=", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLessThan(String value) {
            addCriterion("buyer_email <", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLessThanOrEqualTo(String value) {
            addCriterion("buyer_email <=", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailLike(String value) {
            addCriterion("buyer_email like", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotLike(String value) {
            addCriterion("buyer_email not like", value, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailIn(List<String> values) {
            addCriterion("buyer_email in", values, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotIn(List<String> values) {
            addCriterion("buyer_email not in", values, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailBetween(String value1, String value2) {
            addCriterion("buyer_email between", value1, value2, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailNotBetween(String value1, String value2) {
            addCriterion("buyer_email not between", value1, value2, "buyerEmail");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageIsNull() {
            addCriterion("has_buyer_message is null");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageIsNotNull() {
            addCriterion("has_buyer_message is not null");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageEqualTo(String value) {
            addCriterion("has_buyer_message =", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageNotEqualTo(String value) {
            addCriterion("has_buyer_message <>", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageGreaterThan(String value) {
            addCriterion("has_buyer_message >", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageGreaterThanOrEqualTo(String value) {
            addCriterion("has_buyer_message >=", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageLessThan(String value) {
            addCriterion("has_buyer_message <", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageLessThanOrEqualTo(String value) {
            addCriterion("has_buyer_message <=", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageLike(String value) {
            addCriterion("has_buyer_message like", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageNotLike(String value) {
            addCriterion("has_buyer_message not like", value, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageIn(List<String> values) {
            addCriterion("has_buyer_message in", values, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageNotIn(List<String> values) {
            addCriterion("has_buyer_message not in", values, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageBetween(String value1, String value2) {
            addCriterion("has_buyer_message between", value1, value2, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andHasBuyerMessageNotBetween(String value1, String value2) {
            addCriterion("has_buyer_message not between", value1, value2, "hasBuyerMessage");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("area_id like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("area_id not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeIsNull() {
            addCriterion("credit_card_fee is null");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeIsNotNull() {
            addCriterion("credit_card_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeEqualTo(String value) {
            addCriterion("credit_card_fee =", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeNotEqualTo(String value) {
            addCriterion("credit_card_fee <>", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeGreaterThan(String value) {
            addCriterion("credit_card_fee >", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_card_fee >=", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeLessThan(String value) {
            addCriterion("credit_card_fee <", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeLessThanOrEqualTo(String value) {
            addCriterion("credit_card_fee <=", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeLike(String value) {
            addCriterion("credit_card_fee like", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeNotLike(String value) {
            addCriterion("credit_card_fee not like", value, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeIn(List<String> values) {
            addCriterion("credit_card_fee in", values, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeNotIn(List<String> values) {
            addCriterion("credit_card_fee not in", values, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeBetween(String value1, String value2) {
            addCriterion("credit_card_fee between", value1, value2, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andCreditCardFeeNotBetween(String value1, String value2) {
            addCriterion("credit_card_fee not between", value1, value2, "creditCardFee");
            return (Criteria) this;
        }

        public Criteria andNutFeatureIsNull() {
            addCriterion("nut_feature is null");
            return (Criteria) this;
        }

        public Criteria andNutFeatureIsNotNull() {
            addCriterion("nut_feature is not null");
            return (Criteria) this;
        }

        public Criteria andNutFeatureEqualTo(String value) {
            addCriterion("nut_feature =", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureNotEqualTo(String value) {
            addCriterion("nut_feature <>", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureGreaterThan(String value) {
            addCriterion("nut_feature >", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("nut_feature >=", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureLessThan(String value) {
            addCriterion("nut_feature <", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureLessThanOrEqualTo(String value) {
            addCriterion("nut_feature <=", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureLike(String value) {
            addCriterion("nut_feature like", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureNotLike(String value) {
            addCriterion("nut_feature not like", value, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureIn(List<String> values) {
            addCriterion("nut_feature in", values, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureNotIn(List<String> values) {
            addCriterion("nut_feature not in", values, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureBetween(String value1, String value2) {
            addCriterion("nut_feature between", value1, value2, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andNutFeatureNotBetween(String value1, String value2) {
            addCriterion("nut_feature not between", value1, value2, "nutFeature");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusIsNull() {
            addCriterion("step_trade_status is null");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusIsNotNull() {
            addCriterion("step_trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusEqualTo(String value) {
            addCriterion("step_trade_status =", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusNotEqualTo(String value) {
            addCriterion("step_trade_status <>", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusGreaterThan(String value) {
            addCriterion("step_trade_status >", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("step_trade_status >=", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusLessThan(String value) {
            addCriterion("step_trade_status <", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("step_trade_status <=", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusLike(String value) {
            addCriterion("step_trade_status like", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusNotLike(String value) {
            addCriterion("step_trade_status not like", value, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusIn(List<String> values) {
            addCriterion("step_trade_status in", values, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusNotIn(List<String> values) {
            addCriterion("step_trade_status not in", values, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusBetween(String value1, String value2) {
            addCriterion("step_trade_status between", value1, value2, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepTradeStatusNotBetween(String value1, String value2) {
            addCriterion("step_trade_status not between", value1, value2, "stepTradeStatus");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeIsNull() {
            addCriterion("step_paid_fee is null");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeIsNotNull() {
            addCriterion("step_paid_fee is not null");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeEqualTo(String value) {
            addCriterion("step_paid_fee =", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeNotEqualTo(String value) {
            addCriterion("step_paid_fee <>", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeGreaterThan(String value) {
            addCriterion("step_paid_fee >", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeGreaterThanOrEqualTo(String value) {
            addCriterion("step_paid_fee >=", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeLessThan(String value) {
            addCriterion("step_paid_fee <", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeLessThanOrEqualTo(String value) {
            addCriterion("step_paid_fee <=", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeLike(String value) {
            addCriterion("step_paid_fee like", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeNotLike(String value) {
            addCriterion("step_paid_fee not like", value, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeIn(List<String> values) {
            addCriterion("step_paid_fee in", values, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeNotIn(List<String> values) {
            addCriterion("step_paid_fee not in", values, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeBetween(String value1, String value2) {
            addCriterion("step_paid_fee between", value1, value2, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andStepPaidFeeNotBetween(String value1, String value2) {
            addCriterion("step_paid_fee not between", value1, value2, "stepPaidFee");
            return (Criteria) this;
        }

        public Criteria andMarkDescIsNull() {
            addCriterion("mark_desc is null");
            return (Criteria) this;
        }

        public Criteria andMarkDescIsNotNull() {
            addCriterion("mark_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMarkDescEqualTo(String value) {
            addCriterion("mark_desc =", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescNotEqualTo(String value) {
            addCriterion("mark_desc <>", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescGreaterThan(String value) {
            addCriterion("mark_desc >", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescGreaterThanOrEqualTo(String value) {
            addCriterion("mark_desc >=", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescLessThan(String value) {
            addCriterion("mark_desc <", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescLessThanOrEqualTo(String value) {
            addCriterion("mark_desc <=", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescLike(String value) {
            addCriterion("mark_desc like", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescNotLike(String value) {
            addCriterion("mark_desc not like", value, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescIn(List<String> values) {
            addCriterion("mark_desc in", values, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescNotIn(List<String> values) {
            addCriterion("mark_desc not in", values, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescBetween(String value1, String value2) {
            addCriterion("mark_desc between", value1, value2, "markDesc");
            return (Criteria) this;
        }

        public Criteria andMarkDescNotBetween(String value1, String value2) {
            addCriterion("mark_desc not between", value1, value2, "markDesc");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("send_time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("send_time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andTradeFromIsNull() {
            addCriterion("trade_from is null");
            return (Criteria) this;
        }

        public Criteria andTradeFromIsNotNull() {
            addCriterion("trade_from is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFromEqualTo(String value) {
            addCriterion("trade_from =", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotEqualTo(String value) {
            addCriterion("trade_from <>", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromGreaterThan(String value) {
            addCriterion("trade_from >", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromGreaterThanOrEqualTo(String value) {
            addCriterion("trade_from >=", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLessThan(String value) {
            addCriterion("trade_from <", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLessThanOrEqualTo(String value) {
            addCriterion("trade_from <=", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLike(String value) {
            addCriterion("trade_from like", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotLike(String value) {
            addCriterion("trade_from not like", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromIn(List<String> values) {
            addCriterion("trade_from in", values, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotIn(List<String> values) {
            addCriterion("trade_from not in", values, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromBetween(String value1, String value2) {
            addCriterion("trade_from between", value1, value2, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotBetween(String value1, String value2) {
            addCriterion("trade_from not between", value1, value2, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgIsNull() {
            addCriterion("alipay_warn_msg is null");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgIsNotNull() {
            addCriterion("alipay_warn_msg is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgEqualTo(String value) {
            addCriterion("alipay_warn_msg =", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgNotEqualTo(String value) {
            addCriterion("alipay_warn_msg <>", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgGreaterThan(String value) {
            addCriterion("alipay_warn_msg >", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_warn_msg >=", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgLessThan(String value) {
            addCriterion("alipay_warn_msg <", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgLessThanOrEqualTo(String value) {
            addCriterion("alipay_warn_msg <=", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgLike(String value) {
            addCriterion("alipay_warn_msg like", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgNotLike(String value) {
            addCriterion("alipay_warn_msg not like", value, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgIn(List<String> values) {
            addCriterion("alipay_warn_msg in", values, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgNotIn(List<String> values) {
            addCriterion("alipay_warn_msg not in", values, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgBetween(String value1, String value2) {
            addCriterion("alipay_warn_msg between", value1, value2, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andAlipayWarnMsgNotBetween(String value1, String value2) {
            addCriterion("alipay_warn_msg not between", value1, value2, "alipayWarnMsg");
            return (Criteria) this;
        }

        public Criteria andCodStatusIsNull() {
            addCriterion("cod_status is null");
            return (Criteria) this;
        }

        public Criteria andCodStatusIsNotNull() {
            addCriterion("cod_status is not null");
            return (Criteria) this;
        }

        public Criteria andCodStatusEqualTo(String value) {
            addCriterion("cod_status =", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusNotEqualTo(String value) {
            addCriterion("cod_status <>", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusGreaterThan(String value) {
            addCriterion("cod_status >", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusGreaterThanOrEqualTo(String value) {
            addCriterion("cod_status >=", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusLessThan(String value) {
            addCriterion("cod_status <", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusLessThanOrEqualTo(String value) {
            addCriterion("cod_status <=", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusLike(String value) {
            addCriterion("cod_status like", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusNotLike(String value) {
            addCriterion("cod_status not like", value, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusIn(List<String> values) {
            addCriterion("cod_status in", values, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusNotIn(List<String> values) {
            addCriterion("cod_status not in", values, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusBetween(String value1, String value2) {
            addCriterion("cod_status between", value1, value2, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCodStatusNotBetween(String value1, String value2) {
            addCriterion("cod_status not between", value1, value2, "codStatus");
            return (Criteria) this;
        }

        public Criteria andCanRateIsNull() {
            addCriterion("can_rate is null");
            return (Criteria) this;
        }

        public Criteria andCanRateIsNotNull() {
            addCriterion("can_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCanRateEqualTo(String value) {
            addCriterion("can_rate =", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateNotEqualTo(String value) {
            addCriterion("can_rate <>", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateGreaterThan(String value) {
            addCriterion("can_rate >", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateGreaterThanOrEqualTo(String value) {
            addCriterion("can_rate >=", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateLessThan(String value) {
            addCriterion("can_rate <", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateLessThanOrEqualTo(String value) {
            addCriterion("can_rate <=", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateLike(String value) {
            addCriterion("can_rate like", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateNotLike(String value) {
            addCriterion("can_rate not like", value, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateIn(List<String> values) {
            addCriterion("can_rate in", values, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateNotIn(List<String> values) {
            addCriterion("can_rate not in", values, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateBetween(String value1, String value2) {
            addCriterion("can_rate between", value1, value2, "canRate");
            return (Criteria) this;
        }

        public Criteria andCanRateNotBetween(String value1, String value2) {
            addCriterion("can_rate not between", value1, value2, "canRate");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIsNull() {
            addCriterion("commission_fee is null");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIsNotNull() {
            addCriterion("commission_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeEqualTo(String value) {
            addCriterion("commission_fee =", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotEqualTo(String value) {
            addCriterion("commission_fee <>", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeGreaterThan(String value) {
            addCriterion("commission_fee >", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeGreaterThanOrEqualTo(String value) {
            addCriterion("commission_fee >=", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeLessThan(String value) {
            addCriterion("commission_fee <", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeLessThanOrEqualTo(String value) {
            addCriterion("commission_fee <=", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeLike(String value) {
            addCriterion("commission_fee like", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotLike(String value) {
            addCriterion("commission_fee not like", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIn(List<String> values) {
            addCriterion("commission_fee in", values, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotIn(List<String> values) {
            addCriterion("commission_fee not in", values, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeBetween(String value1, String value2) {
            addCriterion("commission_fee between", value1, value2, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotBetween(String value1, String value2) {
            addCriterion("commission_fee not between", value1, value2, "commissionFee");
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

        public Criteria andBuyerRateIsNull() {
            addCriterion("buyer_rate is null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateIsNotNull() {
            addCriterion("buyer_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerRateEqualTo(String value) {
            addCriterion("buyer_rate =", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotEqualTo(String value) {
            addCriterion("buyer_rate <>", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateGreaterThan(String value) {
            addCriterion("buyer_rate >", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_rate >=", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLessThan(String value) {
            addCriterion("buyer_rate <", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLessThanOrEqualTo(String value) {
            addCriterion("buyer_rate <=", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateLike(String value) {
            addCriterion("buyer_rate like", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotLike(String value) {
            addCriterion("buyer_rate not like", value, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateIn(List<String> values) {
            addCriterion("buyer_rate in", values, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotIn(List<String> values) {
            addCriterion("buyer_rate not in", values, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateBetween(String value1, String value2) {
            addCriterion("buyer_rate between", value1, value2, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andBuyerRateNotBetween(String value1, String value2) {
            addCriterion("buyer_rate not between", value1, value2, "buyerRate");
            return (Criteria) this;
        }

        public Criteria andTradeSourceIsNull() {
            addCriterion("trade_source is null");
            return (Criteria) this;
        }

        public Criteria andTradeSourceIsNotNull() {
            addCriterion("trade_source is not null");
            return (Criteria) this;
        }

        public Criteria andTradeSourceEqualTo(String value) {
            addCriterion("trade_source =", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceNotEqualTo(String value) {
            addCriterion("trade_source <>", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceGreaterThan(String value) {
            addCriterion("trade_source >", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceGreaterThanOrEqualTo(String value) {
            addCriterion("trade_source >=", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceLessThan(String value) {
            addCriterion("trade_source <", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceLessThanOrEqualTo(String value) {
            addCriterion("trade_source <=", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceLike(String value) {
            addCriterion("trade_source like", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceNotLike(String value) {
            addCriterion("trade_source not like", value, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceIn(List<String> values) {
            addCriterion("trade_source in", values, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceNotIn(List<String> values) {
            addCriterion("trade_source not in", values, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceBetween(String value1, String value2) {
            addCriterion("trade_source between", value1, value2, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andTradeSourceNotBetween(String value1, String value2) {
            addCriterion("trade_source not between", value1, value2, "tradeSource");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignIsNull() {
            addCriterion("is_part_consign is null");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignIsNotNull() {
            addCriterion("is_part_consign is not null");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignEqualTo(String value) {
            addCriterion("is_part_consign =", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignNotEqualTo(String value) {
            addCriterion("is_part_consign <>", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignGreaterThan(String value) {
            addCriterion("is_part_consign >", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignGreaterThanOrEqualTo(String value) {
            addCriterion("is_part_consign >=", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignLessThan(String value) {
            addCriterion("is_part_consign <", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignLessThanOrEqualTo(String value) {
            addCriterion("is_part_consign <=", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignLike(String value) {
            addCriterion("is_part_consign like", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignNotLike(String value) {
            addCriterion("is_part_consign not like", value, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignIn(List<String> values) {
            addCriterion("is_part_consign in", values, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignNotIn(List<String> values) {
            addCriterion("is_part_consign not in", values, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignBetween(String value1, String value2) {
            addCriterion("is_part_consign between", value1, value2, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andIsPartConsignNotBetween(String value1, String value2) {
            addCriterion("is_part_consign not between", value1, value2, "isPartConsign");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeIsNull() {
            addCriterion("real_point_fee is null");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeIsNotNull() {
            addCriterion("real_point_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeEqualTo(Integer value) {
            addCriterion("real_point_fee =", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeNotEqualTo(Integer value) {
            addCriterion("real_point_fee <>", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeGreaterThan(Integer value) {
            addCriterion("real_point_fee >", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_point_fee >=", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeLessThan(Integer value) {
            addCriterion("real_point_fee <", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeLessThanOrEqualTo(Integer value) {
            addCriterion("real_point_fee <=", value, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeIn(List<Integer> values) {
            addCriterion("real_point_fee in", values, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeNotIn(List<Integer> values) {
            addCriterion("real_point_fee not in", values, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeBetween(Integer value1, Integer value2) {
            addCriterion("real_point_fee between", value1, value2, "realPointFee");
            return (Criteria) this;
        }

        public Criteria andRealPointFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("real_point_fee not between", value1, value2, "realPointFee");
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

        public Criteria andArriveIntervalIsNull() {
            addCriterion("arrive_interval is null");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalIsNotNull() {
            addCriterion("arrive_interval is not null");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalEqualTo(Integer value) {
            addCriterion("arrive_interval =", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalNotEqualTo(Integer value) {
            addCriterion("arrive_interval <>", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalGreaterThan(Integer value) {
            addCriterion("arrive_interval >", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("arrive_interval >=", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalLessThan(Integer value) {
            addCriterion("arrive_interval <", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("arrive_interval <=", value, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalIn(List<Integer> values) {
            addCriterion("arrive_interval in", values, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalNotIn(List<Integer> values) {
            addCriterion("arrive_interval not in", values, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalBetween(Integer value1, Integer value2) {
            addCriterion("arrive_interval between", value1, value2, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("arrive_interval not between", value1, value2, "arriveInterval");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeIsNull() {
            addCriterion("arrive_cut_time is null");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeIsNotNull() {
            addCriterion("arrive_cut_time is not null");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeEqualTo(String value) {
            addCriterion("arrive_cut_time =", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeNotEqualTo(String value) {
            addCriterion("arrive_cut_time <>", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeGreaterThan(String value) {
            addCriterion("arrive_cut_time >", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("arrive_cut_time >=", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeLessThan(String value) {
            addCriterion("arrive_cut_time <", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeLessThanOrEqualTo(String value) {
            addCriterion("arrive_cut_time <=", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeLike(String value) {
            addCriterion("arrive_cut_time like", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeNotLike(String value) {
            addCriterion("arrive_cut_time not like", value, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeIn(List<String> values) {
            addCriterion("arrive_cut_time in", values, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeNotIn(List<String> values) {
            addCriterion("arrive_cut_time not in", values, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeBetween(String value1, String value2) {
            addCriterion("arrive_cut_time between", value1, value2, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andArriveCutTimeNotBetween(String value1, String value2) {
            addCriterion("arrive_cut_time not between", value1, value2, "arriveCutTime");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalIsNull() {
            addCriterion("consign_interval is null");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalIsNotNull() {
            addCriterion("consign_interval is not null");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalEqualTo(Integer value) {
            addCriterion("consign_interval =", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalNotEqualTo(Integer value) {
            addCriterion("consign_interval <>", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalGreaterThan(Integer value) {
            addCriterion("consign_interval >", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("consign_interval >=", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalLessThan(Integer value) {
            addCriterion("consign_interval <", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("consign_interval <=", value, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalIn(List<Integer> values) {
            addCriterion("consign_interval in", values, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalNotIn(List<Integer> values) {
            addCriterion("consign_interval not in", values, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalBetween(Integer value1, Integer value2) {
            addCriterion("consign_interval between", value1, value2, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andConsignIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("consign_interval not between", value1, value2, "consignInterval");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedIsNull() {
            addCriterion("async_modified is null");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedIsNotNull() {
            addCriterion("async_modified is not null");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedEqualTo(Date value) {
            addCriterion("async_modified =", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedNotEqualTo(Date value) {
            addCriterion("async_modified <>", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedGreaterThan(Date value) {
            addCriterion("async_modified >", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("async_modified >=", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedLessThan(Date value) {
            addCriterion("async_modified <", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedLessThanOrEqualTo(Date value) {
            addCriterion("async_modified <=", value, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedIn(List<Date> values) {
            addCriterion("async_modified in", values, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedNotIn(List<Date> values) {
            addCriterion("async_modified not in", values, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedBetween(Date value1, Date value2) {
            addCriterion("async_modified between", value1, value2, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAsyncModifiedNotBetween(Date value1, Date value2) {
            addCriterion("async_modified not between", value1, value2, "asyncModified");
            return (Criteria) this;
        }

        public Criteria andAlipayPointIsNull() {
            addCriterion("alipay_point is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPointIsNotNull() {
            addCriterion("alipay_point is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPointEqualTo(Integer value) {
            addCriterion("alipay_point =", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointNotEqualTo(Integer value) {
            addCriterion("alipay_point <>", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointGreaterThan(Integer value) {
            addCriterion("alipay_point >", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("alipay_point >=", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointLessThan(Integer value) {
            addCriterion("alipay_point <", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointLessThanOrEqualTo(Integer value) {
            addCriterion("alipay_point <=", value, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointIn(List<Integer> values) {
            addCriterion("alipay_point in", values, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointNotIn(List<Integer> values) {
            addCriterion("alipay_point not in", values, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointBetween(Integer value1, Integer value2) {
            addCriterion("alipay_point between", value1, value2, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andAlipayPointNotBetween(Integer value1, Integer value2) {
            addCriterion("alipay_point not between", value1, value2, "alipayPoint");
            return (Criteria) this;
        }

        public Criteria andPccAfIsNull() {
            addCriterion("pcc_af is null");
            return (Criteria) this;
        }

        public Criteria andPccAfIsNotNull() {
            addCriterion("pcc_af is not null");
            return (Criteria) this;
        }

        public Criteria andPccAfEqualTo(Integer value) {
            addCriterion("pcc_af =", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfNotEqualTo(Integer value) {
            addCriterion("pcc_af <>", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfGreaterThan(Integer value) {
            addCriterion("pcc_af >", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcc_af >=", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfLessThan(Integer value) {
            addCriterion("pcc_af <", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfLessThanOrEqualTo(Integer value) {
            addCriterion("pcc_af <=", value, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfIn(List<Integer> values) {
            addCriterion("pcc_af in", values, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfNotIn(List<Integer> values) {
            addCriterion("pcc_af not in", values, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfBetween(Integer value1, Integer value2) {
            addCriterion("pcc_af between", value1, value2, "pccAf");
            return (Criteria) this;
        }

        public Criteria andPccAfNotBetween(Integer value1, Integer value2) {
            addCriterion("pcc_af not between", value1, value2, "pccAf");
            return (Criteria) this;
        }

        public Criteria andIsWtIsNull() {
            addCriterion("is_wt is null");
            return (Criteria) this;
        }

        public Criteria andIsWtIsNotNull() {
            addCriterion("is_wt is not null");
            return (Criteria) this;
        }

        public Criteria andIsWtEqualTo(String value) {
            addCriterion("is_wt =", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtNotEqualTo(String value) {
            addCriterion("is_wt <>", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtGreaterThan(String value) {
            addCriterion("is_wt >", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtGreaterThanOrEqualTo(String value) {
            addCriterion("is_wt >=", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtLessThan(String value) {
            addCriterion("is_wt <", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtLessThanOrEqualTo(String value) {
            addCriterion("is_wt <=", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtLike(String value) {
            addCriterion("is_wt like", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtNotLike(String value) {
            addCriterion("is_wt not like", value, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtIn(List<String> values) {
            addCriterion("is_wt in", values, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtNotIn(List<String> values) {
            addCriterion("is_wt not in", values, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtBetween(String value1, String value2) {
            addCriterion("is_wt between", value1, value2, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsWtNotBetween(String value1, String value2) {
            addCriterion("is_wt not between", value1, value2, "isWt");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIsNull() {
            addCriterion("is_excel_import is null");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIsNotNull() {
            addCriterion("is_excel_import is not null");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportEqualTo(String value) {
            addCriterion("is_excel_import =", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotEqualTo(String value) {
            addCriterion("is_excel_import <>", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportGreaterThan(String value) {
            addCriterion("is_excel_import >", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportGreaterThanOrEqualTo(String value) {
            addCriterion("is_excel_import >=", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLessThan(String value) {
            addCriterion("is_excel_import <", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLessThanOrEqualTo(String value) {
            addCriterion("is_excel_import <=", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportLike(String value) {
            addCriterion("is_excel_import like", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotLike(String value) {
            addCriterion("is_excel_import not like", value, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportIn(List<String> values) {
            addCriterion("is_excel_import in", values, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotIn(List<String> values) {
            addCriterion("is_excel_import not in", values, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportBetween(String value1, String value2) {
            addCriterion("is_excel_import between", value1, value2, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andIsExcelImportNotBetween(String value1, String value2) {
            addCriterion("is_excel_import not between", value1, value2, "isExcelImport");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonIsNull() {
            addCriterion("trade_close_reson is null");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonIsNotNull() {
            addCriterion("trade_close_reson is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonEqualTo(String value) {
            addCriterion("trade_close_reson =", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonNotEqualTo(String value) {
            addCriterion("trade_close_reson <>", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonGreaterThan(String value) {
            addCriterion("trade_close_reson >", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonGreaterThanOrEqualTo(String value) {
            addCriterion("trade_close_reson >=", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonLessThan(String value) {
            addCriterion("trade_close_reson <", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonLessThanOrEqualTo(String value) {
            addCriterion("trade_close_reson <=", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonLike(String value) {
            addCriterion("trade_close_reson like", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonNotLike(String value) {
            addCriterion("trade_close_reson not like", value, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonIn(List<String> values) {
            addCriterion("trade_close_reson in", values, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonNotIn(List<String> values) {
            addCriterion("trade_close_reson not in", values, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonBetween(String value1, String value2) {
            addCriterion("trade_close_reson between", value1, value2, "tradeCloseReson");
            return (Criteria) this;
        }

        public Criteria andTradeCloseResonNotBetween(String value1, String value2) {
            addCriterion("trade_close_reson not between", value1, value2, "tradeCloseReson");
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