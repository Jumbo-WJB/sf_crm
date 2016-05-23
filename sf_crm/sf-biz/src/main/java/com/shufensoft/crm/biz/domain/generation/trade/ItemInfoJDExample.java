package com.shufensoft.crm.biz.domain.generation.trade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemInfoJDExample {
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

    public ItemInfoJDExample() {
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

    public void addSumUserIdJdQueryColumn() {
        this.queryColumns.add(" sum(user_id_jd) sum_user_id_jd");
    }

    public void addWareIdQueryColumn() {
        this.queryColumns.add("ware_id");
    }

    public void addMaxWareIdQueryColumn() {
        this.queryColumns.add("max(ware_id) max_ware_id");
    }

    public void addMinWareIdQueryColumn() {
        this.queryColumns.add("min(ware_id) min_ware_id");
    }

    public void addAvgWareIdQueryColumn() {
        this.queryColumns.add(" avg(ware_id) avg_ware_id");
    }

    public void addCountWareIdQueryColumn() {
        this.queryColumns.add(" count(ware_id) count_ware_id");
    }

    public void addSumWareIdQueryColumn() {
        this.queryColumns.add(" sum(ware_id) sum_ware_id");
    }

    public void addOrderIdQueryColumn() {
        this.queryColumns.add("order_id");
    }

    public void addMaxOrderIdQueryColumn() {
        this.queryColumns.add("max(order_id) max_order_id");
    }

    public void addMinOrderIdQueryColumn() {
        this.queryColumns.add("min(order_id) min_order_id");
    }

    public void addAvgOrderIdQueryColumn() {
        this.queryColumns.add(" avg(order_id) avg_order_id");
    }

    public void addCountOrderIdQueryColumn() {
        this.queryColumns.add(" count(order_id) count_order_id");
    }

    public void addSumOrderIdQueryColumn() {
        this.queryColumns.add(" sum(order_id) sum_order_id");
    }

    public void addSkuIdQueryColumn() {
        this.queryColumns.add("sku_id");
    }

    public void addMaxSkuIdQueryColumn() {
        this.queryColumns.add("max(sku_id) max_sku_id");
    }

    public void addMinSkuIdQueryColumn() {
        this.queryColumns.add("min(sku_id) min_sku_id");
    }

    public void addAvgSkuIdQueryColumn() {
        this.queryColumns.add(" avg(sku_id) avg_sku_id");
    }

    public void addCountSkuIdQueryColumn() {
        this.queryColumns.add(" count(sku_id) count_sku_id");
    }

    public void addSumSkuIdQueryColumn() {
        this.queryColumns.add(" sum(sku_id) sum_sku_id");
    }

    public void addOuterSkuIdQueryColumn() {
        this.queryColumns.add("outer_sku_id");
    }

    public void addMaxOuterSkuIdQueryColumn() {
        this.queryColumns.add("max(outer_sku_id) max_outer_sku_id");
    }

    public void addMinOuterSkuIdQueryColumn() {
        this.queryColumns.add("min(outer_sku_id) min_outer_sku_id");
    }

    public void addAvgOuterSkuIdQueryColumn() {
        this.queryColumns.add(" avg(outer_sku_id) avg_outer_sku_id");
    }

    public void addCountOuterSkuIdQueryColumn() {
        this.queryColumns.add(" count(outer_sku_id) count_outer_sku_id");
    }

    public void addSumOuterSkuIdQueryColumn() {
        this.queryColumns.add(" sum(outer_sku_id) sum_outer_sku_id");
    }

    public void addSkuNameQueryColumn() {
        this.queryColumns.add("sku_name");
    }

    public void addMaxSkuNameQueryColumn() {
        this.queryColumns.add("max(sku_name) max_sku_name");
    }

    public void addMinSkuNameQueryColumn() {
        this.queryColumns.add("min(sku_name) min_sku_name");
    }

    public void addAvgSkuNameQueryColumn() {
        this.queryColumns.add(" avg(sku_name) avg_sku_name");
    }

    public void addCountSkuNameQueryColumn() {
        this.queryColumns.add(" count(sku_name) count_sku_name");
    }

    public void addSumSkuNameQueryColumn() {
        this.queryColumns.add(" sum(sku_name) sum_sku_name");
    }

    public void addJdPriceQueryColumn() {
        this.queryColumns.add("jd_price");
    }

    public void addMaxJdPriceQueryColumn() {
        this.queryColumns.add("max(jd_price) max_jd_price");
    }

    public void addMinJdPriceQueryColumn() {
        this.queryColumns.add("min(jd_price) min_jd_price");
    }

    public void addAvgJdPriceQueryColumn() {
        this.queryColumns.add(" avg(jd_price) avg_jd_price");
    }

    public void addCountJdPriceQueryColumn() {
        this.queryColumns.add(" count(jd_price) count_jd_price");
    }

    public void addSumJdPriceQueryColumn() {
        this.queryColumns.add(" sum(jd_price) sum_jd_price");
    }

    public void addGiftPointQueryColumn() {
        this.queryColumns.add("gift_point");
    }

    public void addMaxGiftPointQueryColumn() {
        this.queryColumns.add("max(gift_point) max_gift_point");
    }

    public void addMinGiftPointQueryColumn() {
        this.queryColumns.add("min(gift_point) min_gift_point");
    }

    public void addAvgGiftPointQueryColumn() {
        this.queryColumns.add(" avg(gift_point) avg_gift_point");
    }

    public void addCountGiftPointQueryColumn() {
        this.queryColumns.add(" count(gift_point) count_gift_point");
    }

    public void addSumGiftPointQueryColumn() {
        this.queryColumns.add(" sum(gift_point) sum_gift_point");
    }

    public void addItemTotalQueryColumn() {
        this.queryColumns.add("item_total");
    }

    public void addMaxItemTotalQueryColumn() {
        this.queryColumns.add("max(item_total) max_item_total");
    }

    public void addMinItemTotalQueryColumn() {
        this.queryColumns.add("min(item_total) min_item_total");
    }

    public void addAvgItemTotalQueryColumn() {
        this.queryColumns.add(" avg(item_total) avg_item_total");
    }

    public void addCountItemTotalQueryColumn() {
        this.queryColumns.add(" count(item_total) count_item_total");
    }

    public void addSumItemTotalQueryColumn() {
        this.queryColumns.add(" sum(item_total) sum_item_total");
    }

    public void addProductNoQueryColumn() {
        this.queryColumns.add("product_no");
    }

    public void addMaxProductNoQueryColumn() {
        this.queryColumns.add("max(product_no) max_product_no");
    }

    public void addMinProductNoQueryColumn() {
        this.queryColumns.add("min(product_no) min_product_no");
    }

    public void addAvgProductNoQueryColumn() {
        this.queryColumns.add(" avg(product_no) avg_product_no");
    }

    public void addCountProductNoQueryColumn() {
        this.queryColumns.add(" count(product_no) count_product_no");
    }

    public void addSumProductNoQueryColumn() {
        this.queryColumns.add(" sum(product_no) sum_product_no");
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

        public Criteria andWareIdIsNull() {
            addCriterion("ware_id is null");
            return (Criteria) this;
        }

        public Criteria andWareIdIsNotNull() {
            addCriterion("ware_id is not null");
            return (Criteria) this;
        }

        public Criteria andWareIdEqualTo(String value) {
            addCriterion("ware_id =", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdNotEqualTo(String value) {
            addCriterion("ware_id <>", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdGreaterThan(String value) {
            addCriterion("ware_id >", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdGreaterThanOrEqualTo(String value) {
            addCriterion("ware_id >=", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdLessThan(String value) {
            addCriterion("ware_id <", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdLessThanOrEqualTo(String value) {
            addCriterion("ware_id <=", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdLike(String value) {
            addCriterion("ware_id like", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdNotLike(String value) {
            addCriterion("ware_id not like", value, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdIn(List<String> values) {
            addCriterion("ware_id in", values, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdNotIn(List<String> values) {
            addCriterion("ware_id not in", values, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdBetween(String value1, String value2) {
            addCriterion("ware_id between", value1, value2, "wareId");
            return (Criteria) this;
        }

        public Criteria andWareIdNotBetween(String value1, String value2) {
            addCriterion("ware_id not between", value1, value2, "wareId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("sku_id like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("sku_id not like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<String> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<String> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNull() {
            addCriterion("outer_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIsNotNull() {
            addCriterion("outer_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdEqualTo(String value) {
            addCriterion("outer_sku_id =", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotEqualTo(String value) {
            addCriterion("outer_sku_id <>", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThan(String value) {
            addCriterion("outer_sku_id >", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("outer_sku_id >=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThan(String value) {
            addCriterion("outer_sku_id <", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLessThanOrEqualTo(String value) {
            addCriterion("outer_sku_id <=", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdLike(String value) {
            addCriterion("outer_sku_id like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotLike(String value) {
            addCriterion("outer_sku_id not like", value, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdIn(List<String> values) {
            addCriterion("outer_sku_id in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotIn(List<String> values) {
            addCriterion("outer_sku_id not in", values, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdBetween(String value1, String value2) {
            addCriterion("outer_sku_id between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andOuterSkuIdNotBetween(String value1, String value2) {
            addCriterion("outer_sku_id not between", value1, value2, "outerSkuId");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNull() {
            addCriterion("sku_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNotNull() {
            addCriterion("sku_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualTo(String value) {
            addCriterion("sku_name =", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualTo(String value) {
            addCriterion("sku_name <>", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThan(String value) {
            addCriterion("sku_name >", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_name >=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThan(String value) {
            addCriterion("sku_name <", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualTo(String value) {
            addCriterion("sku_name <=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLike(String value) {
            addCriterion("sku_name like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotLike(String value) {
            addCriterion("sku_name not like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIn(List<String> values) {
            addCriterion("sku_name in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotIn(List<String> values) {
            addCriterion("sku_name not in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameBetween(String value1, String value2) {
            addCriterion("sku_name between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotBetween(String value1, String value2) {
            addCriterion("sku_name not between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andJdPriceIsNull() {
            addCriterion("jd_price is null");
            return (Criteria) this;
        }

        public Criteria andJdPriceIsNotNull() {
            addCriterion("jd_price is not null");
            return (Criteria) this;
        }

        public Criteria andJdPriceEqualTo(String value) {
            addCriterion("jd_price =", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceNotEqualTo(String value) {
            addCriterion("jd_price <>", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceGreaterThan(String value) {
            addCriterion("jd_price >", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceGreaterThanOrEqualTo(String value) {
            addCriterion("jd_price >=", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceLessThan(String value) {
            addCriterion("jd_price <", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceLessThanOrEqualTo(String value) {
            addCriterion("jd_price <=", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceLike(String value) {
            addCriterion("jd_price like", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceNotLike(String value) {
            addCriterion("jd_price not like", value, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceIn(List<String> values) {
            addCriterion("jd_price in", values, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceNotIn(List<String> values) {
            addCriterion("jd_price not in", values, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceBetween(String value1, String value2) {
            addCriterion("jd_price between", value1, value2, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andJdPriceNotBetween(String value1, String value2) {
            addCriterion("jd_price not between", value1, value2, "jdPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPointIsNull() {
            addCriterion("gift_point is null");
            return (Criteria) this;
        }

        public Criteria andGiftPointIsNotNull() {
            addCriterion("gift_point is not null");
            return (Criteria) this;
        }

        public Criteria andGiftPointEqualTo(Integer value) {
            addCriterion("gift_point =", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointNotEqualTo(Integer value) {
            addCriterion("gift_point <>", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointGreaterThan(Integer value) {
            addCriterion("gift_point >", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_point >=", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointLessThan(Integer value) {
            addCriterion("gift_point <", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointLessThanOrEqualTo(Integer value) {
            addCriterion("gift_point <=", value, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointIn(List<Integer> values) {
            addCriterion("gift_point in", values, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointNotIn(List<Integer> values) {
            addCriterion("gift_point not in", values, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointBetween(Integer value1, Integer value2) {
            addCriterion("gift_point between", value1, value2, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andGiftPointNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_point not between", value1, value2, "giftPoint");
            return (Criteria) this;
        }

        public Criteria andItemTotalIsNull() {
            addCriterion("item_total is null");
            return (Criteria) this;
        }

        public Criteria andItemTotalIsNotNull() {
            addCriterion("item_total is not null");
            return (Criteria) this;
        }

        public Criteria andItemTotalEqualTo(Integer value) {
            addCriterion("item_total =", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalNotEqualTo(Integer value) {
            addCriterion("item_total <>", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalGreaterThan(Integer value) {
            addCriterion("item_total >", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_total >=", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalLessThan(Integer value) {
            addCriterion("item_total <", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalLessThanOrEqualTo(Integer value) {
            addCriterion("item_total <=", value, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalIn(List<Integer> values) {
            addCriterion("item_total in", values, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalNotIn(List<Integer> values) {
            addCriterion("item_total not in", values, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalBetween(Integer value1, Integer value2) {
            addCriterion("item_total between", value1, value2, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andItemTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("item_total not between", value1, value2, "itemTotal");
            return (Criteria) this;
        }

        public Criteria andProductNoIsNull() {
            addCriterion("product_no is null");
            return (Criteria) this;
        }

        public Criteria andProductNoIsNotNull() {
            addCriterion("product_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductNoEqualTo(String value) {
            addCriterion("product_no =", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotEqualTo(String value) {
            addCriterion("product_no <>", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThan(String value) {
            addCriterion("product_no >", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThanOrEqualTo(String value) {
            addCriterion("product_no >=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThan(String value) {
            addCriterion("product_no <", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThanOrEqualTo(String value) {
            addCriterion("product_no <=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLike(String value) {
            addCriterion("product_no like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotLike(String value) {
            addCriterion("product_no not like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoIn(List<String> values) {
            addCriterion("product_no in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotIn(List<String> values) {
            addCriterion("product_no not in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoBetween(String value1, String value2) {
            addCriterion("product_no between", value1, value2, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotBetween(String value1, String value2) {
            addCriterion("product_no not between", value1, value2, "productNo");
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