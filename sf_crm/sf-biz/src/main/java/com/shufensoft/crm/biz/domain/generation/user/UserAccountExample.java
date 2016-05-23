package com.shufensoft.crm.biz.domain.generation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAccountExample {
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

    public UserAccountExample() {
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

    public void addAccountIdQueryColumn() {
        this.queryColumns.add("account_id");
    }

    public void addMaxAccountIdQueryColumn() {
        this.queryColumns.add("max(account_id) max_account_id");
    }

    public void addMinAccountIdQueryColumn() {
        this.queryColumns.add("min(account_id) min_account_id");
    }

    public void addAvgAccountIdQueryColumn() {
        this.queryColumns.add(" avg(account_id) avg_account_id");
    }

    public void addCountAccountIdQueryColumn() {
        this.queryColumns.add(" count(account_id) count_account_id");
    }

    public void addSumAccountIdQueryColumn() {
        this.queryColumns.add(" sum(account_id) sum_account_id");
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

    public void addSumUserIdQueryColumn() {
        this.queryColumns.add(" sum(user_id) sum_user_id");
    }

    public void addHongbaoAmountQueryColumn() {
        this.queryColumns.add("hongbao_amount");
    }

    public void addMaxHongbaoAmountQueryColumn() {
        this.queryColumns.add("max(hongbao_amount) max_hongbao_amount");
    }

    public void addMinHongbaoAmountQueryColumn() {
        this.queryColumns.add("min(hongbao_amount) min_hongbao_amount");
    }

    public void addAvgHongbaoAmountQueryColumn() {
        this.queryColumns.add(" avg(hongbao_amount) avg_hongbao_amount");
    }

    public void addCountHongbaoAmountQueryColumn() {
        this.queryColumns.add(" count(hongbao_amount) count_hongbao_amount");
    }

    public void addSumHongbaoAmountQueryColumn() {
        this.queryColumns.add(" sum(hongbao_amount) sum_hongbao_amount");
    }

    public void addHbtotalNumberQueryColumn() {
        this.queryColumns.add("hbtotal_number");
    }

    public void addMaxHbtotalNumberQueryColumn() {
        this.queryColumns.add("max(hbtotal_number) max_hbtotal_number");
    }

    public void addMinHbtotalNumberQueryColumn() {
        this.queryColumns.add("min(hbtotal_number) min_hbtotal_number");
    }

    public void addAvgHbtotalNumberQueryColumn() {
        this.queryColumns.add(" avg(hbtotal_number) avg_hbtotal_number");
    }

    public void addCountHbtotalNumberQueryColumn() {
        this.queryColumns.add(" count(hbtotal_number) count_hbtotal_number");
    }

    public void addSumHbtotalNumberQueryColumn() {
        this.queryColumns.add(" sum(hbtotal_number) sum_hbtotal_number");
    }

    public void addHbobtainAmountQueryColumn() {
        this.queryColumns.add("hbobtain_amount");
    }

    public void addMaxHbobtainAmountQueryColumn() {
        this.queryColumns.add("max(hbobtain_amount) max_hbobtain_amount");
    }

    public void addMinHbobtainAmountQueryColumn() {
        this.queryColumns.add("min(hbobtain_amount) min_hbobtain_amount");
    }

    public void addAvgHbobtainAmountQueryColumn() {
        this.queryColumns.add(" avg(hbobtain_amount) avg_hbobtain_amount");
    }

    public void addCountHbobtainAmountQueryColumn() {
        this.queryColumns.add(" count(hbobtain_amount) count_hbobtain_amount");
    }

    public void addSumHbobtainAmountQueryColumn() {
        this.queryColumns.add(" sum(hbobtain_amount) sum_hbobtain_amount");
    }

    public void addHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add("hongbao_praise_amount");
    }

    public void addMaxHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add("max(hongbao_praise_amount) max_hongbao_praise_amount");
    }

    public void addMinHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add("min(hongbao_praise_amount) min_hongbao_praise_amount");
    }

    public void addAvgHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add(" avg(hongbao_praise_amount) avg_hongbao_praise_amount");
    }

    public void addCountHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add(" count(hongbao_praise_amount) count_hongbao_praise_amount");
    }

    public void addSumHongbaoPraiseAmountQueryColumn() {
        this.queryColumns.add(" sum(hongbao_praise_amount) sum_hongbao_praise_amount");
    }

    public void addHongbaoShopAmountQueryColumn() {
        this.queryColumns.add("hongbao_shop_amount");
    }

    public void addMaxHongbaoShopAmountQueryColumn() {
        this.queryColumns.add("max(hongbao_shop_amount) max_hongbao_shop_amount");
    }

    public void addMinHongbaoShopAmountQueryColumn() {
        this.queryColumns.add("min(hongbao_shop_amount) min_hongbao_shop_amount");
    }

    public void addAvgHongbaoShopAmountQueryColumn() {
        this.queryColumns.add(" avg(hongbao_shop_amount) avg_hongbao_shop_amount");
    }

    public void addCountHongbaoShopAmountQueryColumn() {
        this.queryColumns.add(" count(hongbao_shop_amount) count_hongbao_shop_amount");
    }

    public void addSumHongbaoShopAmountQueryColumn() {
        this.queryColumns.add(" sum(hongbao_shop_amount) sum_hongbao_shop_amount");
    }

    public void addHbobtainDateQueryColumn() {
        this.queryColumns.add("hbobtain_date");
    }

    public void addMaxHbobtainDateQueryColumn() {
        this.queryColumns.add("max(hbobtain_date) max_hbobtain_date");
    }

    public void addMinHbobtainDateQueryColumn() {
        this.queryColumns.add("min(hbobtain_date) min_hbobtain_date");
    }

    public void addAvgHbobtainDateQueryColumn() {
        this.queryColumns.add(" avg(hbobtain_date) avg_hbobtain_date");
    }

    public void addCountHbobtainDateQueryColumn() {
        this.queryColumns.add(" count(hbobtain_date) count_hbobtain_date");
    }

    public void addSumHbobtainDateQueryColumn() {
        this.queryColumns.add(" sum(hbobtain_date) sum_hbobtain_date");
    }

    public void addHbcashAmountQueryColumn() {
        this.queryColumns.add("hbcash_amount");
    }

    public void addMaxHbcashAmountQueryColumn() {
        this.queryColumns.add("max(hbcash_amount) max_hbcash_amount");
    }

    public void addMinHbcashAmountQueryColumn() {
        this.queryColumns.add("min(hbcash_amount) min_hbcash_amount");
    }

    public void addAvgHbcashAmountQueryColumn() {
        this.queryColumns.add(" avg(hbcash_amount) avg_hbcash_amount");
    }

    public void addCountHbcashAmountQueryColumn() {
        this.queryColumns.add(" count(hbcash_amount) count_hbcash_amount");
    }

    public void addSumHbcashAmountQueryColumn() {
        this.queryColumns.add(" sum(hbcash_amount) sum_hbcash_amount");
    }

    public void addHbcashDateQueryColumn() {
        this.queryColumns.add("hbcash_date");
    }

    public void addMaxHbcashDateQueryColumn() {
        this.queryColumns.add("max(hbcash_date) max_hbcash_date");
    }

    public void addMinHbcashDateQueryColumn() {
        this.queryColumns.add("min(hbcash_date) min_hbcash_date");
    }

    public void addAvgHbcashDateQueryColumn() {
        this.queryColumns.add(" avg(hbcash_date) avg_hbcash_date");
    }

    public void addCountHbcashDateQueryColumn() {
        this.queryColumns.add(" count(hbcash_date) count_hbcash_date");
    }

    public void addSumHbcashDateQueryColumn() {
        this.queryColumns.add(" sum(hbcash_date) sum_hbcash_date");
    }

    public void addHbcashNumberQueryColumn() {
        this.queryColumns.add("hbcash_number");
    }

    public void addMaxHbcashNumberQueryColumn() {
        this.queryColumns.add("max(hbcash_number) max_hbcash_number");
    }

    public void addMinHbcashNumberQueryColumn() {
        this.queryColumns.add("min(hbcash_number) min_hbcash_number");
    }

    public void addAvgHbcashNumberQueryColumn() {
        this.queryColumns.add(" avg(hbcash_number) avg_hbcash_number");
    }

    public void addCountHbcashNumberQueryColumn() {
        this.queryColumns.add(" count(hbcash_number) count_hbcash_number");
    }

    public void addSumHbcashNumberQueryColumn() {
        this.queryColumns.add(" sum(hbcash_number) sum_hbcash_number");
    }

    public void addPointAmountQueryColumn() {
        this.queryColumns.add("point_amount");
    }

    public void addMaxPointAmountQueryColumn() {
        this.queryColumns.add("max(point_amount) max_point_amount");
    }

    public void addMinPointAmountQueryColumn() {
        this.queryColumns.add("min(point_amount) min_point_amount");
    }

    public void addAvgPointAmountQueryColumn() {
        this.queryColumns.add(" avg(point_amount) avg_point_amount");
    }

    public void addCountPointAmountQueryColumn() {
        this.queryColumns.add(" count(point_amount) count_point_amount");
    }

    public void addSumPointAmountQueryColumn() {
        this.queryColumns.add(" sum(point_amount) sum_point_amount");
    }

    public void addPointAmountTotalQueryColumn() {
        this.queryColumns.add("point_amount_total");
    }

    public void addMaxPointAmountTotalQueryColumn() {
        this.queryColumns.add("max(point_amount_total) max_point_amount_total");
    }

    public void addMinPointAmountTotalQueryColumn() {
        this.queryColumns.add("min(point_amount_total) min_point_amount_total");
    }

    public void addAvgPointAmountTotalQueryColumn() {
        this.queryColumns.add(" avg(point_amount_total) avg_point_amount_total");
    }

    public void addCountPointAmountTotalQueryColumn() {
        this.queryColumns.add(" count(point_amount_total) count_point_amount_total");
    }

    public void addSumPointAmountTotalQueryColumn() {
        this.queryColumns.add(" sum(point_amount_total) sum_point_amount_total");
    }

    public void addPointAmountExchangeQueryColumn() {
        this.queryColumns.add("point_amount_exchange");
    }

    public void addMaxPointAmountExchangeQueryColumn() {
        this.queryColumns.add("max(point_amount_exchange) max_point_amount_exchange");
    }

    public void addMinPointAmountExchangeQueryColumn() {
        this.queryColumns.add("min(point_amount_exchange) min_point_amount_exchange");
    }

    public void addAvgPointAmountExchangeQueryColumn() {
        this.queryColumns.add(" avg(point_amount_exchange) avg_point_amount_exchange");
    }

    public void addCountPointAmountExchangeQueryColumn() {
        this.queryColumns.add(" count(point_amount_exchange) count_point_amount_exchange");
    }

    public void addSumPointAmountExchangeQueryColumn() {
        this.queryColumns.add(" sum(point_amount_exchange) sum_point_amount_exchange");
    }

    public void addPointAmountExpiredQueryColumn() {
        this.queryColumns.add("point_amount_expired");
    }

    public void addMaxPointAmountExpiredQueryColumn() {
        this.queryColumns.add("max(point_amount_expired) max_point_amount_expired");
    }

    public void addMinPointAmountExpiredQueryColumn() {
        this.queryColumns.add("min(point_amount_expired) min_point_amount_expired");
    }

    public void addAvgPointAmountExpiredQueryColumn() {
        this.queryColumns.add(" avg(point_amount_expired) avg_point_amount_expired");
    }

    public void addCountPointAmountExpiredQueryColumn() {
        this.queryColumns.add(" count(point_amount_expired) count_point_amount_expired");
    }

    public void addSumPointAmountExpiredQueryColumn() {
        this.queryColumns.add(" sum(point_amount_expired) sum_point_amount_expired");
    }

    public void addPointAmountTransferredQueryColumn() {
        this.queryColumns.add("point_amount_transferred");
    }

    public void addMaxPointAmountTransferredQueryColumn() {
        this.queryColumns.add("max(point_amount_transferred) max_point_amount_transferred");
    }

    public void addMinPointAmountTransferredQueryColumn() {
        this.queryColumns.add("min(point_amount_transferred) min_point_amount_transferred");
    }

    public void addAvgPointAmountTransferredQueryColumn() {
        this.queryColumns.add(" avg(point_amount_transferred) avg_point_amount_transferred");
    }

    public void addCountPointAmountTransferredQueryColumn() {
        this.queryColumns.add(" count(point_amount_transferred) count_point_amount_transferred");
    }

    public void addSumPointAmountTransferredQueryColumn() {
        this.queryColumns.add(" sum(point_amount_transferred) sum_point_amount_transferred");
    }

    public void addUserAccountVersionQueryColumn() {
        this.queryColumns.add("user_account_version");
    }

    public void addMaxUserAccountVersionQueryColumn() {
        this.queryColumns.add("max(user_account_version) max_user_account_version");
    }

    public void addMinUserAccountVersionQueryColumn() {
        this.queryColumns.add("min(user_account_version) min_user_account_version");
    }

    public void addAvgUserAccountVersionQueryColumn() {
        this.queryColumns.add(" avg(user_account_version) avg_user_account_version");
    }

    public void addCountUserAccountVersionQueryColumn() {
        this.queryColumns.add(" count(user_account_version) count_user_account_version");
    }

    public void addSumUserAccountVersionQueryColumn() {
        this.queryColumns.add(" sum(user_account_version) sum_user_account_version");
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
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

        public Criteria andHongbaoAmountIsNull() {
            addCriterion("hongbao_amount is null");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountIsNotNull() {
            addCriterion("hongbao_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountEqualTo(Long value) {
            addCriterion("hongbao_amount =", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountNotEqualTo(Long value) {
            addCriterion("hongbao_amount <>", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountGreaterThan(Long value) {
            addCriterion("hongbao_amount >", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("hongbao_amount >=", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountLessThan(Long value) {
            addCriterion("hongbao_amount <", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountLessThanOrEqualTo(Long value) {
            addCriterion("hongbao_amount <=", value, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountIn(List<Long> values) {
            addCriterion("hongbao_amount in", values, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountNotIn(List<Long> values) {
            addCriterion("hongbao_amount not in", values, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountBetween(Long value1, Long value2) {
            addCriterion("hongbao_amount between", value1, value2, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoAmountNotBetween(Long value1, Long value2) {
            addCriterion("hongbao_amount not between", value1, value2, "hongbaoAmount");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberIsNull() {
            addCriterion("hbtotal_number is null");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberIsNotNull() {
            addCriterion("hbtotal_number is not null");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberEqualTo(Long value) {
            addCriterion("hbtotal_number =", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberNotEqualTo(Long value) {
            addCriterion("hbtotal_number <>", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberGreaterThan(Long value) {
            addCriterion("hbtotal_number >", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("hbtotal_number >=", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberLessThan(Long value) {
            addCriterion("hbtotal_number <", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberLessThanOrEqualTo(Long value) {
            addCriterion("hbtotal_number <=", value, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberIn(List<Long> values) {
            addCriterion("hbtotal_number in", values, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberNotIn(List<Long> values) {
            addCriterion("hbtotal_number not in", values, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberBetween(Long value1, Long value2) {
            addCriterion("hbtotal_number between", value1, value2, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbtotalNumberNotBetween(Long value1, Long value2) {
            addCriterion("hbtotal_number not between", value1, value2, "hbtotalNumber");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountIsNull() {
            addCriterion("hbobtain_amount is null");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountIsNotNull() {
            addCriterion("hbobtain_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountEqualTo(Long value) {
            addCriterion("hbobtain_amount =", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountNotEqualTo(Long value) {
            addCriterion("hbobtain_amount <>", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountGreaterThan(Long value) {
            addCriterion("hbobtain_amount >", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("hbobtain_amount >=", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountLessThan(Long value) {
            addCriterion("hbobtain_amount <", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountLessThanOrEqualTo(Long value) {
            addCriterion("hbobtain_amount <=", value, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountIn(List<Long> values) {
            addCriterion("hbobtain_amount in", values, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountNotIn(List<Long> values) {
            addCriterion("hbobtain_amount not in", values, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountBetween(Long value1, Long value2) {
            addCriterion("hbobtain_amount between", value1, value2, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainAmountNotBetween(Long value1, Long value2) {
            addCriterion("hbobtain_amount not between", value1, value2, "hbobtainAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountIsNull() {
            addCriterion("hongbao_praise_amount is null");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountIsNotNull() {
            addCriterion("hongbao_praise_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountEqualTo(Long value) {
            addCriterion("hongbao_praise_amount =", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountNotEqualTo(Long value) {
            addCriterion("hongbao_praise_amount <>", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountGreaterThan(Long value) {
            addCriterion("hongbao_praise_amount >", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("hongbao_praise_amount >=", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountLessThan(Long value) {
            addCriterion("hongbao_praise_amount <", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountLessThanOrEqualTo(Long value) {
            addCriterion("hongbao_praise_amount <=", value, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountIn(List<Long> values) {
            addCriterion("hongbao_praise_amount in", values, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountNotIn(List<Long> values) {
            addCriterion("hongbao_praise_amount not in", values, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountBetween(Long value1, Long value2) {
            addCriterion("hongbao_praise_amount between", value1, value2, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoPraiseAmountNotBetween(Long value1, Long value2) {
            addCriterion("hongbao_praise_amount not between", value1, value2, "hongbaoPraiseAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountIsNull() {
            addCriterion("hongbao_shop_amount is null");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountIsNotNull() {
            addCriterion("hongbao_shop_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountEqualTo(Long value) {
            addCriterion("hongbao_shop_amount =", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountNotEqualTo(Long value) {
            addCriterion("hongbao_shop_amount <>", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountGreaterThan(Long value) {
            addCriterion("hongbao_shop_amount >", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("hongbao_shop_amount >=", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountLessThan(Long value) {
            addCriterion("hongbao_shop_amount <", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountLessThanOrEqualTo(Long value) {
            addCriterion("hongbao_shop_amount <=", value, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountIn(List<Long> values) {
            addCriterion("hongbao_shop_amount in", values, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountNotIn(List<Long> values) {
            addCriterion("hongbao_shop_amount not in", values, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountBetween(Long value1, Long value2) {
            addCriterion("hongbao_shop_amount between", value1, value2, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHongbaoShopAmountNotBetween(Long value1, Long value2) {
            addCriterion("hongbao_shop_amount not between", value1, value2, "hongbaoShopAmount");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateIsNull() {
            addCriterion("hbobtain_date is null");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateIsNotNull() {
            addCriterion("hbobtain_date is not null");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateEqualTo(Date value) {
            addCriterion("hbobtain_date =", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateNotEqualTo(Date value) {
            addCriterion("hbobtain_date <>", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateGreaterThan(Date value) {
            addCriterion("hbobtain_date >", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("hbobtain_date >=", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateLessThan(Date value) {
            addCriterion("hbobtain_date <", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateLessThanOrEqualTo(Date value) {
            addCriterion("hbobtain_date <=", value, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateIn(List<Date> values) {
            addCriterion("hbobtain_date in", values, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateNotIn(List<Date> values) {
            addCriterion("hbobtain_date not in", values, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateBetween(Date value1, Date value2) {
            addCriterion("hbobtain_date between", value1, value2, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbobtainDateNotBetween(Date value1, Date value2) {
            addCriterion("hbobtain_date not between", value1, value2, "hbobtainDate");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIsNull() {
            addCriterion("hbcash_amount is null");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIsNotNull() {
            addCriterion("hbcash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountEqualTo(Long value) {
            addCriterion("hbcash_amount =", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotEqualTo(Long value) {
            addCriterion("hbcash_amount <>", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountGreaterThan(Long value) {
            addCriterion("hbcash_amount >", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("hbcash_amount >=", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountLessThan(Long value) {
            addCriterion("hbcash_amount <", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountLessThanOrEqualTo(Long value) {
            addCriterion("hbcash_amount <=", value, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountIn(List<Long> values) {
            addCriterion("hbcash_amount in", values, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotIn(List<Long> values) {
            addCriterion("hbcash_amount not in", values, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountBetween(Long value1, Long value2) {
            addCriterion("hbcash_amount between", value1, value2, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashAmountNotBetween(Long value1, Long value2) {
            addCriterion("hbcash_amount not between", value1, value2, "hbcashAmount");
            return (Criteria) this;
        }

        public Criteria andHbcashDateIsNull() {
            addCriterion("hbcash_date is null");
            return (Criteria) this;
        }

        public Criteria andHbcashDateIsNotNull() {
            addCriterion("hbcash_date is not null");
            return (Criteria) this;
        }

        public Criteria andHbcashDateEqualTo(Date value) {
            addCriterion("hbcash_date =", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateNotEqualTo(Date value) {
            addCriterion("hbcash_date <>", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateGreaterThan(Date value) {
            addCriterion("hbcash_date >", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateGreaterThanOrEqualTo(Date value) {
            addCriterion("hbcash_date >=", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateLessThan(Date value) {
            addCriterion("hbcash_date <", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateLessThanOrEqualTo(Date value) {
            addCriterion("hbcash_date <=", value, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateIn(List<Date> values) {
            addCriterion("hbcash_date in", values, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateNotIn(List<Date> values) {
            addCriterion("hbcash_date not in", values, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateBetween(Date value1, Date value2) {
            addCriterion("hbcash_date between", value1, value2, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashDateNotBetween(Date value1, Date value2) {
            addCriterion("hbcash_date not between", value1, value2, "hbcashDate");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberIsNull() {
            addCriterion("hbcash_number is null");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberIsNotNull() {
            addCriterion("hbcash_number is not null");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberEqualTo(Long value) {
            addCriterion("hbcash_number =", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberNotEqualTo(Long value) {
            addCriterion("hbcash_number <>", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberGreaterThan(Long value) {
            addCriterion("hbcash_number >", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("hbcash_number >=", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberLessThan(Long value) {
            addCriterion("hbcash_number <", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberLessThanOrEqualTo(Long value) {
            addCriterion("hbcash_number <=", value, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberIn(List<Long> values) {
            addCriterion("hbcash_number in", values, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberNotIn(List<Long> values) {
            addCriterion("hbcash_number not in", values, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberBetween(Long value1, Long value2) {
            addCriterion("hbcash_number between", value1, value2, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andHbcashNumberNotBetween(Long value1, Long value2) {
            addCriterion("hbcash_number not between", value1, value2, "hbcashNumber");
            return (Criteria) this;
        }

        public Criteria andPointAmountIsNull() {
            addCriterion("point_amount is null");
            return (Criteria) this;
        }

        public Criteria andPointAmountIsNotNull() {
            addCriterion("point_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPointAmountEqualTo(Long value) {
            addCriterion("point_amount =", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountNotEqualTo(Long value) {
            addCriterion("point_amount <>", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountGreaterThan(Long value) {
            addCriterion("point_amount >", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("point_amount >=", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountLessThan(Long value) {
            addCriterion("point_amount <", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountLessThanOrEqualTo(Long value) {
            addCriterion("point_amount <=", value, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountIn(List<Long> values) {
            addCriterion("point_amount in", values, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountNotIn(List<Long> values) {
            addCriterion("point_amount not in", values, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountBetween(Long value1, Long value2) {
            addCriterion("point_amount between", value1, value2, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountNotBetween(Long value1, Long value2) {
            addCriterion("point_amount not between", value1, value2, "pointAmount");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalIsNull() {
            addCriterion("point_amount_total is null");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalIsNotNull() {
            addCriterion("point_amount_total is not null");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalEqualTo(Long value) {
            addCriterion("point_amount_total =", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalNotEqualTo(Long value) {
            addCriterion("point_amount_total <>", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalGreaterThan(Long value) {
            addCriterion("point_amount_total >", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("point_amount_total >=", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalLessThan(Long value) {
            addCriterion("point_amount_total <", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalLessThanOrEqualTo(Long value) {
            addCriterion("point_amount_total <=", value, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalIn(List<Long> values) {
            addCriterion("point_amount_total in", values, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalNotIn(List<Long> values) {
            addCriterion("point_amount_total not in", values, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalBetween(Long value1, Long value2) {
            addCriterion("point_amount_total between", value1, value2, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountTotalNotBetween(Long value1, Long value2) {
            addCriterion("point_amount_total not between", value1, value2, "pointAmountTotal");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeIsNull() {
            addCriterion("point_amount_exchange is null");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeIsNotNull() {
            addCriterion("point_amount_exchange is not null");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeEqualTo(Long value) {
            addCriterion("point_amount_exchange =", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeNotEqualTo(Long value) {
            addCriterion("point_amount_exchange <>", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeGreaterThan(Long value) {
            addCriterion("point_amount_exchange >", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeGreaterThanOrEqualTo(Long value) {
            addCriterion("point_amount_exchange >=", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeLessThan(Long value) {
            addCriterion("point_amount_exchange <", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeLessThanOrEqualTo(Long value) {
            addCriterion("point_amount_exchange <=", value, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeIn(List<Long> values) {
            addCriterion("point_amount_exchange in", values, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeNotIn(List<Long> values) {
            addCriterion("point_amount_exchange not in", values, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeBetween(Long value1, Long value2) {
            addCriterion("point_amount_exchange between", value1, value2, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExchangeNotBetween(Long value1, Long value2) {
            addCriterion("point_amount_exchange not between", value1, value2, "pointAmountExchange");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredIsNull() {
            addCriterion("point_amount_expired is null");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredIsNotNull() {
            addCriterion("point_amount_expired is not null");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredEqualTo(Long value) {
            addCriterion("point_amount_expired =", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredNotEqualTo(Long value) {
            addCriterion("point_amount_expired <>", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredGreaterThan(Long value) {
            addCriterion("point_amount_expired >", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredGreaterThanOrEqualTo(Long value) {
            addCriterion("point_amount_expired >=", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredLessThan(Long value) {
            addCriterion("point_amount_expired <", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredLessThanOrEqualTo(Long value) {
            addCriterion("point_amount_expired <=", value, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredIn(List<Long> values) {
            addCriterion("point_amount_expired in", values, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredNotIn(List<Long> values) {
            addCriterion("point_amount_expired not in", values, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredBetween(Long value1, Long value2) {
            addCriterion("point_amount_expired between", value1, value2, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountExpiredNotBetween(Long value1, Long value2) {
            addCriterion("point_amount_expired not between", value1, value2, "pointAmountExpired");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredIsNull() {
            addCriterion("point_amount_transferred is null");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredIsNotNull() {
            addCriterion("point_amount_transferred is not null");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredEqualTo(Long value) {
            addCriterion("point_amount_transferred =", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredNotEqualTo(Long value) {
            addCriterion("point_amount_transferred <>", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredGreaterThan(Long value) {
            addCriterion("point_amount_transferred >", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredGreaterThanOrEqualTo(Long value) {
            addCriterion("point_amount_transferred >=", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredLessThan(Long value) {
            addCriterion("point_amount_transferred <", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredLessThanOrEqualTo(Long value) {
            addCriterion("point_amount_transferred <=", value, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredIn(List<Long> values) {
            addCriterion("point_amount_transferred in", values, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredNotIn(List<Long> values) {
            addCriterion("point_amount_transferred not in", values, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredBetween(Long value1, Long value2) {
            addCriterion("point_amount_transferred between", value1, value2, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andPointAmountTransferredNotBetween(Long value1, Long value2) {
            addCriterion("point_amount_transferred not between", value1, value2, "pointAmountTransferred");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionIsNull() {
            addCriterion("user_account_version is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionIsNotNull() {
            addCriterion("user_account_version is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionEqualTo(Long value) {
            addCriterion("user_account_version =", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionNotEqualTo(Long value) {
            addCriterion("user_account_version <>", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionGreaterThan(Long value) {
            addCriterion("user_account_version >", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("user_account_version >=", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionLessThan(Long value) {
            addCriterion("user_account_version <", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionLessThanOrEqualTo(Long value) {
            addCriterion("user_account_version <=", value, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionIn(List<Long> values) {
            addCriterion("user_account_version in", values, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionNotIn(List<Long> values) {
            addCriterion("user_account_version not in", values, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionBetween(Long value1, Long value2) {
            addCriterion("user_account_version between", value1, value2, "userAccountVersion");
            return (Criteria) this;
        }

        public Criteria andUserAccountVersionNotBetween(Long value1, Long value2) {
            addCriterion("user_account_version not between", value1, value2, "userAccountVersion");
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