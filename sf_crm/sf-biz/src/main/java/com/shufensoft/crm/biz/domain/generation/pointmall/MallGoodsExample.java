package com.shufensoft.crm.biz.domain.generation.pointmall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallGoodsExample {
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

    public MallGoodsExample() {
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

    public void addCategoryIdQueryColumn() {
        this.queryColumns.add("category_id");
    }

    public void addMaxCategoryIdQueryColumn() {
        this.queryColumns.add("max(category_id) max_category_id");
    }

    public void addMinCategoryIdQueryColumn() {
        this.queryColumns.add("min(category_id) min_category_id");
    }

    public void addAvgCategoryIdQueryColumn() {
        this.queryColumns.add(" avg(category_id) avg_category_id");
    }

    public void addCountCategoryIdQueryColumn() {
        this.queryColumns.add(" count(category_id) count_category_id");
    }

    public void addSumCategoryIdQueryColumn() {
        this.queryColumns.add(" sum(category_id) sum_category_id");
    }

    public void addIsVirtualQueryColumn() {
        this.queryColumns.add("is_virtual");
    }

    public void addMaxIsVirtualQueryColumn() {
        this.queryColumns.add("max(is_virtual) max_is_virtual");
    }

    public void addMinIsVirtualQueryColumn() {
        this.queryColumns.add("min(is_virtual) min_is_virtual");
    }

    public void addAvgIsVirtualQueryColumn() {
        this.queryColumns.add(" avg(is_virtual) avg_is_virtual");
    }

    public void addCountIsVirtualQueryColumn() {
        this.queryColumns.add(" count(is_virtual) count_is_virtual");
    }

    public void addSumIsVirtualQueryColumn() {
        this.queryColumns.add(" sum(is_virtual) sum_is_virtual");
    }

    public void addListTimeQueryColumn() {
        this.queryColumns.add("list_time");
    }

    public void addMaxListTimeQueryColumn() {
        this.queryColumns.add("max(list_time) max_list_time");
    }

    public void addMinListTimeQueryColumn() {
        this.queryColumns.add("min(list_time) min_list_time");
    }

    public void addAvgListTimeQueryColumn() {
        this.queryColumns.add(" avg(list_time) avg_list_time");
    }

    public void addCountListTimeQueryColumn() {
        this.queryColumns.add(" count(list_time) count_list_time");
    }

    public void addSumListTimeQueryColumn() {
        this.queryColumns.add(" sum(list_time) sum_list_time");
    }

    public void addDelistTimeQueryColumn() {
        this.queryColumns.add("delist_time");
    }

    public void addMaxDelistTimeQueryColumn() {
        this.queryColumns.add("max(delist_time) max_delist_time");
    }

    public void addMinDelistTimeQueryColumn() {
        this.queryColumns.add("min(delist_time) min_delist_time");
    }

    public void addAvgDelistTimeQueryColumn() {
        this.queryColumns.add(" avg(delist_time) avg_delist_time");
    }

    public void addCountDelistTimeQueryColumn() {
        this.queryColumns.add(" count(delist_time) count_delist_time");
    }

    public void addSumDelistTimeQueryColumn() {
        this.queryColumns.add(" sum(delist_time) sum_delist_time");
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

    public void addQuantityQueryColumn() {
        this.queryColumns.add("quantity");
    }

    public void addMaxQuantityQueryColumn() {
        this.queryColumns.add("max(quantity) max_quantity");
    }

    public void addMinQuantityQueryColumn() {
        this.queryColumns.add("min(quantity) min_quantity");
    }

    public void addAvgQuantityQueryColumn() {
        this.queryColumns.add(" avg(quantity) avg_quantity");
    }

    public void addCountQuantityQueryColumn() {
        this.queryColumns.add(" count(quantity) count_quantity");
    }

    public void addSumQuantityQueryColumn() {
        this.queryColumns.add(" sum(quantity) sum_quantity");
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

    public void addPointQueryColumn() {
        this.queryColumns.add("point");
    }

    public void addMaxPointQueryColumn() {
        this.queryColumns.add("max(point) max_point");
    }

    public void addMinPointQueryColumn() {
        this.queryColumns.add("min(point) min_point");
    }

    public void addAvgPointQueryColumn() {
        this.queryColumns.add(" avg(point) avg_point");
    }

    public void addCountPointQueryColumn() {
        this.queryColumns.add(" count(point) count_point");
    }

    public void addSumPointQueryColumn() {
        this.queryColumns.add(" sum(point) sum_point");
    }

    public void addExchangeAmountQueryColumn() {
        this.queryColumns.add("exchange_amount");
    }

    public void addMaxExchangeAmountQueryColumn() {
        this.queryColumns.add("max(exchange_amount) max_exchange_amount");
    }

    public void addMinExchangeAmountQueryColumn() {
        this.queryColumns.add("min(exchange_amount) min_exchange_amount");
    }

    public void addAvgExchangeAmountQueryColumn() {
        this.queryColumns.add(" avg(exchange_amount) avg_exchange_amount");
    }

    public void addCountExchangeAmountQueryColumn() {
        this.queryColumns.add(" count(exchange_amount) count_exchange_amount");
    }

    public void addSumExchangeAmountQueryColumn() {
        this.queryColumns.add(" sum(exchange_amount) sum_exchange_amount");
    }

    public void addDetailUrlQueryColumn() {
        this.queryColumns.add("detail_url");
    }

    public void addMaxDetailUrlQueryColumn() {
        this.queryColumns.add("max(detail_url) max_detail_url");
    }

    public void addMinDetailUrlQueryColumn() {
        this.queryColumns.add("min(detail_url) min_detail_url");
    }

    public void addAvgDetailUrlQueryColumn() {
        this.queryColumns.add(" avg(detail_url) avg_detail_url");
    }

    public void addCountDetailUrlQueryColumn() {
        this.queryColumns.add(" count(detail_url) count_detail_url");
    }

    public void addSumDetailUrlQueryColumn() {
        this.queryColumns.add(" sum(detail_url) sum_detail_url");
    }

    public void addQrUrlQueryColumn() {
        this.queryColumns.add("qr_url");
    }

    public void addMaxQrUrlQueryColumn() {
        this.queryColumns.add("max(qr_url) max_qr_url");
    }

    public void addMinQrUrlQueryColumn() {
        this.queryColumns.add("min(qr_url) min_qr_url");
    }

    public void addAvgQrUrlQueryColumn() {
        this.queryColumns.add(" avg(qr_url) avg_qr_url");
    }

    public void addCountQrUrlQueryColumn() {
        this.queryColumns.add(" count(qr_url) count_qr_url");
    }

    public void addSumQrUrlQueryColumn() {
        this.queryColumns.add(" sum(qr_url) sum_qr_url");
    }

    public void addImgsUrlQueryColumn() {
        this.queryColumns.add("imgs_url");
    }

    public void addMaxImgsUrlQueryColumn() {
        this.queryColumns.add("max(imgs_url) max_imgs_url");
    }

    public void addMinImgsUrlQueryColumn() {
        this.queryColumns.add("min(imgs_url) min_imgs_url");
    }

    public void addAvgImgsUrlQueryColumn() {
        this.queryColumns.add(" avg(imgs_url) avg_imgs_url");
    }

    public void addCountImgsUrlQueryColumn() {
        this.queryColumns.add(" count(imgs_url) count_imgs_url");
    }

    public void addSumImgsUrlQueryColumn() {
        this.queryColumns.add(" sum(imgs_url) sum_imgs_url");
    }

    public void addThumbnailQueryColumn() {
        this.queryColumns.add("thumbnail");
    }

    public void addMaxThumbnailQueryColumn() {
        this.queryColumns.add("max(thumbnail) max_thumbnail");
    }

    public void addMinThumbnailQueryColumn() {
        this.queryColumns.add("min(thumbnail) min_thumbnail");
    }

    public void addAvgThumbnailQueryColumn() {
        this.queryColumns.add(" avg(thumbnail) avg_thumbnail");
    }

    public void addCountThumbnailQueryColumn() {
        this.queryColumns.add(" count(thumbnail) count_thumbnail");
    }

    public void addSumThumbnailQueryColumn() {
        this.queryColumns.add(" sum(thumbnail) sum_thumbnail");
    }

    public void addSkusQueryColumn() {
        this.queryColumns.add("skus");
    }

    public void addMaxSkusQueryColumn() {
        this.queryColumns.add("max(skus) max_skus");
    }

    public void addMinSkusQueryColumn() {
        this.queryColumns.add("min(skus) min_skus");
    }

    public void addAvgSkusQueryColumn() {
        this.queryColumns.add(" avg(skus) avg_skus");
    }

    public void addCountSkusQueryColumn() {
        this.queryColumns.add(" count(skus) count_skus");
    }

    public void addSumSkusQueryColumn() {
        this.queryColumns.add(" sum(skus) sum_skus");
    }

    public void addPropsQueryColumn() {
        this.queryColumns.add("props");
    }

    public void addMaxPropsQueryColumn() {
        this.queryColumns.add("max(props) max_props");
    }

    public void addMinPropsQueryColumn() {
        this.queryColumns.add("min(props) min_props");
    }

    public void addAvgPropsQueryColumn() {
        this.queryColumns.add(" avg(props) avg_props");
    }

    public void addCountPropsQueryColumn() {
        this.queryColumns.add(" count(props) count_props");
    }

    public void addSumPropsQueryColumn() {
        this.queryColumns.add(" sum(props) sum_props");
    }

    public void addPropsNameQueryColumn() {
        this.queryColumns.add("props_name");
    }

    public void addMaxPropsNameQueryColumn() {
        this.queryColumns.add("max(props_name) max_props_name");
    }

    public void addMinPropsNameQueryColumn() {
        this.queryColumns.add("min(props_name) min_props_name");
    }

    public void addAvgPropsNameQueryColumn() {
        this.queryColumns.add(" avg(props_name) avg_props_name");
    }

    public void addCountPropsNameQueryColumn() {
        this.queryColumns.add(" count(props_name) count_props_name");
    }

    public void addSumPropsNameQueryColumn() {
        this.queryColumns.add(" sum(props_name) sum_props_name");
    }

    public void addOuterIdQueryColumn() {
        this.queryColumns.add("outer_id");
    }

    public void addMaxOuterIdQueryColumn() {
        this.queryColumns.add("max(outer_id) max_outer_id");
    }

    public void addMinOuterIdQueryColumn() {
        this.queryColumns.add("min(outer_id) min_outer_id");
    }

    public void addAvgOuterIdQueryColumn() {
        this.queryColumns.add(" avg(outer_id) avg_outer_id");
    }

    public void addCountOuterIdQueryColumn() {
        this.queryColumns.add(" count(outer_id) count_outer_id");
    }

    public void addSumOuterIdQueryColumn() {
        this.queryColumns.add(" sum(outer_id) sum_outer_id");
    }

    public void addVersionQueryColumn() {
        this.queryColumns.add("version");
    }

    public void addMaxVersionQueryColumn() {
        this.queryColumns.add("max(version) max_version");
    }

    public void addMinVersionQueryColumn() {
        this.queryColumns.add("min(version) min_version");
    }

    public void addAvgVersionQueryColumn() {
        this.queryColumns.add(" avg(version) avg_version");
    }

    public void addCountVersionQueryColumn() {
        this.queryColumns.add(" count(version) count_version");
    }

    public void addSumVersionQueryColumn() {
        this.queryColumns.add(" sum(version) sum_version");
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andIsVirtualIsNull() {
            addCriterion("is_virtual is null");
            return (Criteria) this;
        }

        public Criteria andIsVirtualIsNotNull() {
            addCriterion("is_virtual is not null");
            return (Criteria) this;
        }

        public Criteria andIsVirtualEqualTo(String value) {
            addCriterion("is_virtual =", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualNotEqualTo(String value) {
            addCriterion("is_virtual <>", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualGreaterThan(String value) {
            addCriterion("is_virtual >", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualGreaterThanOrEqualTo(String value) {
            addCriterion("is_virtual >=", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualLessThan(String value) {
            addCriterion("is_virtual <", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualLessThanOrEqualTo(String value) {
            addCriterion("is_virtual <=", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualLike(String value) {
            addCriterion("is_virtual like", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualNotLike(String value) {
            addCriterion("is_virtual not like", value, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualIn(List<String> values) {
            addCriterion("is_virtual in", values, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualNotIn(List<String> values) {
            addCriterion("is_virtual not in", values, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualBetween(String value1, String value2) {
            addCriterion("is_virtual between", value1, value2, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andIsVirtualNotBetween(String value1, String value2) {
            addCriterion("is_virtual not between", value1, value2, "isVirtual");
            return (Criteria) this;
        }

        public Criteria andListTimeIsNull() {
            addCriterion("list_time is null");
            return (Criteria) this;
        }

        public Criteria andListTimeIsNotNull() {
            addCriterion("list_time is not null");
            return (Criteria) this;
        }

        public Criteria andListTimeEqualTo(Date value) {
            addCriterion("list_time =", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotEqualTo(Date value) {
            addCriterion("list_time <>", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThan(Date value) {
            addCriterion("list_time >", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("list_time >=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThan(Date value) {
            addCriterion("list_time <", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThanOrEqualTo(Date value) {
            addCriterion("list_time <=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeIn(List<Date> values) {
            addCriterion("list_time in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotIn(List<Date> values) {
            addCriterion("list_time not in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeBetween(Date value1, Date value2) {
            addCriterion("list_time between", value1, value2, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotBetween(Date value1, Date value2) {
            addCriterion("list_time not between", value1, value2, "listTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeIsNull() {
            addCriterion("delist_time is null");
            return (Criteria) this;
        }

        public Criteria andDelistTimeIsNotNull() {
            addCriterion("delist_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelistTimeEqualTo(Date value) {
            addCriterion("delist_time =", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeNotEqualTo(Date value) {
            addCriterion("delist_time <>", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeGreaterThan(Date value) {
            addCriterion("delist_time >", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delist_time >=", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeLessThan(Date value) {
            addCriterion("delist_time <", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            addCriterion("delist_time <=", value, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeIn(List<Date> values) {
            addCriterion("delist_time in", values, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeNotIn(List<Date> values) {
            addCriterion("delist_time not in", values, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeBetween(Date value1, Date value2) {
            addCriterion("delist_time between", value1, value2, "delistTime");
            return (Criteria) this;
        }

        public Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            addCriterion("delist_time not between", value1, value2, "delistTime");
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

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Long value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Long value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Long value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Long value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Long value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Long> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Long> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Long value1, Long value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Long value1, Long value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
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

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Long value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Long value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Long value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Long value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Long value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Long value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Long> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Long> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Long value1, Long value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Long value1, Long value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIsNull() {
            addCriterion("exchange_amount is null");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIsNotNull() {
            addCriterion("exchange_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountEqualTo(Long value) {
            addCriterion("exchange_amount =", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotEqualTo(Long value) {
            addCriterion("exchange_amount <>", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountGreaterThan(Long value) {
            addCriterion("exchange_amount >", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("exchange_amount >=", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountLessThan(Long value) {
            addCriterion("exchange_amount <", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountLessThanOrEqualTo(Long value) {
            addCriterion("exchange_amount <=", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIn(List<Long> values) {
            addCriterion("exchange_amount in", values, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotIn(List<Long> values) {
            addCriterion("exchange_amount not in", values, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountBetween(Long value1, Long value2) {
            addCriterion("exchange_amount between", value1, value2, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotBetween(Long value1, Long value2) {
            addCriterion("exchange_amount not between", value1, value2, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIsNull() {
            addCriterion("detail_url is null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIsNotNull() {
            addCriterion("detail_url is not null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlEqualTo(String value) {
            addCriterion("detail_url =", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotEqualTo(String value) {
            addCriterion("detail_url <>", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThan(String value) {
            addCriterion("detail_url >", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("detail_url >=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThan(String value) {
            addCriterion("detail_url <", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThanOrEqualTo(String value) {
            addCriterion("detail_url <=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLike(String value) {
            addCriterion("detail_url like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotLike(String value) {
            addCriterion("detail_url not like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIn(List<String> values) {
            addCriterion("detail_url in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotIn(List<String> values) {
            addCriterion("detail_url not in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlBetween(String value1, String value2) {
            addCriterion("detail_url between", value1, value2, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotBetween(String value1, String value2) {
            addCriterion("detail_url not between", value1, value2, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlIsNull() {
            addCriterion("qr_url is null");
            return (Criteria) this;
        }

        public Criteria andQrUrlIsNotNull() {
            addCriterion("qr_url is not null");
            return (Criteria) this;
        }

        public Criteria andQrUrlEqualTo(String value) {
            addCriterion("qr_url =", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlNotEqualTo(String value) {
            addCriterion("qr_url <>", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlGreaterThan(String value) {
            addCriterion("qr_url >", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlGreaterThanOrEqualTo(String value) {
            addCriterion("qr_url >=", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlLessThan(String value) {
            addCriterion("qr_url <", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlLessThanOrEqualTo(String value) {
            addCriterion("qr_url <=", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlLike(String value) {
            addCriterion("qr_url like", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlNotLike(String value) {
            addCriterion("qr_url not like", value, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlIn(List<String> values) {
            addCriterion("qr_url in", values, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlNotIn(List<String> values) {
            addCriterion("qr_url not in", values, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlBetween(String value1, String value2) {
            addCriterion("qr_url between", value1, value2, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andQrUrlNotBetween(String value1, String value2) {
            addCriterion("qr_url not between", value1, value2, "qrUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlIsNull() {
            addCriterion("imgs_url is null");
            return (Criteria) this;
        }

        public Criteria andImgsUrlIsNotNull() {
            addCriterion("imgs_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgsUrlEqualTo(String value) {
            addCriterion("imgs_url =", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlNotEqualTo(String value) {
            addCriterion("imgs_url <>", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlGreaterThan(String value) {
            addCriterion("imgs_url >", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("imgs_url >=", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlLessThan(String value) {
            addCriterion("imgs_url <", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlLessThanOrEqualTo(String value) {
            addCriterion("imgs_url <=", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlLike(String value) {
            addCriterion("imgs_url like", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlNotLike(String value) {
            addCriterion("imgs_url not like", value, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlIn(List<String> values) {
            addCriterion("imgs_url in", values, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlNotIn(List<String> values) {
            addCriterion("imgs_url not in", values, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlBetween(String value1, String value2) {
            addCriterion("imgs_url between", value1, value2, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andImgsUrlNotBetween(String value1, String value2) {
            addCriterion("imgs_url not between", value1, value2, "imgsUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailIsNull() {
            addCriterion("thumbnail is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailIsNotNull() {
            addCriterion("thumbnail is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailEqualTo(String value) {
            addCriterion("thumbnail =", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotEqualTo(String value) {
            addCriterion("thumbnail <>", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailGreaterThan(String value) {
            addCriterion("thumbnail >", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail >=", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLessThan(String value) {
            addCriterion("thumbnail <", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLessThanOrEqualTo(String value) {
            addCriterion("thumbnail <=", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailLike(String value) {
            addCriterion("thumbnail like", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotLike(String value) {
            addCriterion("thumbnail not like", value, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailIn(List<String> values) {
            addCriterion("thumbnail in", values, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotIn(List<String> values) {
            addCriterion("thumbnail not in", values, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailBetween(String value1, String value2) {
            addCriterion("thumbnail between", value1, value2, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andThumbnailNotBetween(String value1, String value2) {
            addCriterion("thumbnail not between", value1, value2, "thumbnail");
            return (Criteria) this;
        }

        public Criteria andSkusIsNull() {
            addCriterion("skus is null");
            return (Criteria) this;
        }

        public Criteria andSkusIsNotNull() {
            addCriterion("skus is not null");
            return (Criteria) this;
        }

        public Criteria andSkusEqualTo(String value) {
            addCriterion("skus =", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusNotEqualTo(String value) {
            addCriterion("skus <>", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusGreaterThan(String value) {
            addCriterion("skus >", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusGreaterThanOrEqualTo(String value) {
            addCriterion("skus >=", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusLessThan(String value) {
            addCriterion("skus <", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusLessThanOrEqualTo(String value) {
            addCriterion("skus <=", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusLike(String value) {
            addCriterion("skus like", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusNotLike(String value) {
            addCriterion("skus not like", value, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusIn(List<String> values) {
            addCriterion("skus in", values, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusNotIn(List<String> values) {
            addCriterion("skus not in", values, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusBetween(String value1, String value2) {
            addCriterion("skus between", value1, value2, "skus");
            return (Criteria) this;
        }

        public Criteria andSkusNotBetween(String value1, String value2) {
            addCriterion("skus not between", value1, value2, "skus");
            return (Criteria) this;
        }

        public Criteria andPropsIsNull() {
            addCriterion("props is null");
            return (Criteria) this;
        }

        public Criteria andPropsIsNotNull() {
            addCriterion("props is not null");
            return (Criteria) this;
        }

        public Criteria andPropsEqualTo(String value) {
            addCriterion("props =", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotEqualTo(String value) {
            addCriterion("props <>", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThan(String value) {
            addCriterion("props >", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsGreaterThanOrEqualTo(String value) {
            addCriterion("props >=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThan(String value) {
            addCriterion("props <", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLessThanOrEqualTo(String value) {
            addCriterion("props <=", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsLike(String value) {
            addCriterion("props like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotLike(String value) {
            addCriterion("props not like", value, "props");
            return (Criteria) this;
        }

        public Criteria andPropsIn(List<String> values) {
            addCriterion("props in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotIn(List<String> values) {
            addCriterion("props not in", values, "props");
            return (Criteria) this;
        }

        public Criteria andPropsBetween(String value1, String value2) {
            addCriterion("props between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNotBetween(String value1, String value2) {
            addCriterion("props not between", value1, value2, "props");
            return (Criteria) this;
        }

        public Criteria andPropsNameIsNull() {
            addCriterion("props_name is null");
            return (Criteria) this;
        }

        public Criteria andPropsNameIsNotNull() {
            addCriterion("props_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropsNameEqualTo(String value) {
            addCriterion("props_name =", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameNotEqualTo(String value) {
            addCriterion("props_name <>", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameGreaterThan(String value) {
            addCriterion("props_name >", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameGreaterThanOrEqualTo(String value) {
            addCriterion("props_name >=", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameLessThan(String value) {
            addCriterion("props_name <", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameLessThanOrEqualTo(String value) {
            addCriterion("props_name <=", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameLike(String value) {
            addCriterion("props_name like", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameNotLike(String value) {
            addCriterion("props_name not like", value, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameIn(List<String> values) {
            addCriterion("props_name in", values, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameNotIn(List<String> values) {
            addCriterion("props_name not in", values, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameBetween(String value1, String value2) {
            addCriterion("props_name between", value1, value2, "propsName");
            return (Criteria) this;
        }

        public Criteria andPropsNameNotBetween(String value1, String value2) {
            addCriterion("props_name not between", value1, value2, "propsName");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNull() {
            addCriterion("outer_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNotNull() {
            addCriterion("outer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterIdEqualTo(String value) {
            addCriterion("outer_id =", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotEqualTo(String value) {
            addCriterion("outer_id <>", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThan(String value) {
            addCriterion("outer_id >", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            addCriterion("outer_id >=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThan(String value) {
            addCriterion("outer_id <", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThanOrEqualTo(String value) {
            addCriterion("outer_id <=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLike(String value) {
            addCriterion("outer_id like", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotLike(String value) {
            addCriterion("outer_id not like", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdIn(List<String> values) {
            addCriterion("outer_id in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotIn(List<String> values) {
            addCriterion("outer_id not in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdBetween(String value1, String value2) {
            addCriterion("outer_id between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotBetween(String value1, String value2) {
            addCriterion("outer_id not between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
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