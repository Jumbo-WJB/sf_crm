package com.shufensoft.crm.biz.domain.generation.birthday;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBirthdayConfigExample {
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

    public UserBirthdayConfigExample() {
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

    public void addBirthdayActivityIdQueryColumn() {
        this.queryColumns.add("birthday_activity_id");
    }

    public void addMaxBirthdayActivityIdQueryColumn() {
        this.queryColumns.add("max(birthday_activity_id) max_birthday_activity_id");
    }

    public void addMinBirthdayActivityIdQueryColumn() {
        this.queryColumns.add("min(birthday_activity_id) min_birthday_activity_id");
    }

    public void addAvgBirthdayActivityIdQueryColumn() {
        this.queryColumns.add(" avg(birthday_activity_id) avg_birthday_activity_id");
    }

    public void addCountBirthdayActivityIdQueryColumn() {
        this.queryColumns.add(" count(birthday_activity_id) count_birthday_activity_id");
    }

    public void addSumBirthdayActivityIdQueryColumn() {
        this.queryColumns.add(" sum(birthday_activity_id) sum_birthday_activity_id");
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

    public void addPointsQueryColumn() {
        this.queryColumns.add("points");
    }

    public void addMaxPointsQueryColumn() {
        this.queryColumns.add("max(points) max_points");
    }

    public void addMinPointsQueryColumn() {
        this.queryColumns.add("min(points) min_points");
    }

    public void addAvgPointsQueryColumn() {
        this.queryColumns.add(" avg(points) avg_points");
    }

    public void addCountPointsQueryColumn() {
        this.queryColumns.add(" count(points) count_points");
    }

    public void addSumPointsQueryColumn() {
        this.queryColumns.add(" sum(points) sum_points");
    }

    public void addPoolIdQueryColumn() {
        this.queryColumns.add("pool_id");
    }

    public void addMaxPoolIdQueryColumn() {
        this.queryColumns.add("max(pool_id) max_pool_id");
    }

    public void addMinPoolIdQueryColumn() {
        this.queryColumns.add("min(pool_id) min_pool_id");
    }

    public void addAvgPoolIdQueryColumn() {
        this.queryColumns.add(" avg(pool_id) avg_pool_id");
    }

    public void addCountPoolIdQueryColumn() {
        this.queryColumns.add(" count(pool_id) count_pool_id");
    }

    public void addSumPoolIdQueryColumn() {
        this.queryColumns.add(" sum(pool_id) sum_pool_id");
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

    public void addCareTypeQueryColumn() {
        this.queryColumns.add("care_type");
    }

    public void addMaxCareTypeQueryColumn() {
        this.queryColumns.add("max(care_type) max_care_type");
    }

    public void addMinCareTypeQueryColumn() {
        this.queryColumns.add("min(care_type) min_care_type");
    }

    public void addAvgCareTypeQueryColumn() {
        this.queryColumns.add(" avg(care_type) avg_care_type");
    }

    public void addCountCareTypeQueryColumn() {
        this.queryColumns.add(" count(care_type) count_care_type");
    }

    public void addSumCareTypeQueryColumn() {
        this.queryColumns.add(" sum(care_type) sum_care_type");
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

    public void addSendTargetQueryColumn() {
        this.queryColumns.add("send_target");
    }

    public void addMaxSendTargetQueryColumn() {
        this.queryColumns.add("max(send_target) max_send_target");
    }

    public void addMinSendTargetQueryColumn() {
        this.queryColumns.add("min(send_target) min_send_target");
    }

    public void addAvgSendTargetQueryColumn() {
        this.queryColumns.add(" avg(send_target) avg_send_target");
    }

    public void addCountSendTargetQueryColumn() {
        this.queryColumns.add(" count(send_target) count_send_target");
    }

    public void addSumSendTargetQueryColumn() {
        this.queryColumns.add(" sum(send_target) sum_send_target");
    }

    public void addGetLimitQueryColumn() {
        this.queryColumns.add("get_limit");
    }

    public void addMaxGetLimitQueryColumn() {
        this.queryColumns.add("max(get_limit) max_get_limit");
    }

    public void addMinGetLimitQueryColumn() {
        this.queryColumns.add("min(get_limit) min_get_limit");
    }

    public void addAvgGetLimitQueryColumn() {
        this.queryColumns.add(" avg(get_limit) avg_get_limit");
    }

    public void addCountGetLimitQueryColumn() {
        this.queryColumns.add(" count(get_limit) count_get_limit");
    }

    public void addSumGetLimitQueryColumn() {
        this.queryColumns.add(" sum(get_limit) sum_get_limit");
    }

    public void addSecretPasswordQueryColumn() {
        this.queryColumns.add("secret_password");
    }

    public void addMaxSecretPasswordQueryColumn() {
        this.queryColumns.add("max(secret_password) max_secret_password");
    }

    public void addMinSecretPasswordQueryColumn() {
        this.queryColumns.add("min(secret_password) min_secret_password");
    }

    public void addAvgSecretPasswordQueryColumn() {
        this.queryColumns.add(" avg(secret_password) avg_secret_password");
    }

    public void addCountSecretPasswordQueryColumn() {
        this.queryColumns.add(" count(secret_password) count_secret_password");
    }

    public void addSumSecretPasswordQueryColumn() {
        this.queryColumns.add(" sum(secret_password) sum_secret_password");
    }

    public void addDiscountQueryColumn() {
        this.queryColumns.add("discount");
    }

    public void addMaxDiscountQueryColumn() {
        this.queryColumns.add("max(discount) max_discount");
    }

    public void addMinDiscountQueryColumn() {
        this.queryColumns.add("min(discount) min_discount");
    }

    public void addAvgDiscountQueryColumn() {
        this.queryColumns.add(" avg(discount) avg_discount");
    }

    public void addCountDiscountQueryColumn() {
        this.queryColumns.add(" count(discount) count_discount");
    }

    public void addSumDiscountQueryColumn() {
        this.queryColumns.add(" sum(discount) sum_discount");
    }

    public void addRemindShortMessageQueryColumn() {
        this.queryColumns.add("remind_short_message");
    }

    public void addMaxRemindShortMessageQueryColumn() {
        this.queryColumns.add("max(remind_short_message) max_remind_short_message");
    }

    public void addMinRemindShortMessageQueryColumn() {
        this.queryColumns.add("min(remind_short_message) min_remind_short_message");
    }

    public void addAvgRemindShortMessageQueryColumn() {
        this.queryColumns.add(" avg(remind_short_message) avg_remind_short_message");
    }

    public void addCountRemindShortMessageQueryColumn() {
        this.queryColumns.add(" count(remind_short_message) count_remind_short_message");
    }

    public void addSumRemindShortMessageQueryColumn() {
        this.queryColumns.add(" sum(remind_short_message) sum_remind_short_message");
    }

    public void addShortMessageContentQueryColumn() {
        this.queryColumns.add("short_message_content");
    }

    public void addMaxShortMessageContentQueryColumn() {
        this.queryColumns.add("max(short_message_content) max_short_message_content");
    }

    public void addMinShortMessageContentQueryColumn() {
        this.queryColumns.add("min(short_message_content) min_short_message_content");
    }

    public void addAvgShortMessageContentQueryColumn() {
        this.queryColumns.add(" avg(short_message_content) avg_short_message_content");
    }

    public void addCountShortMessageContentQueryColumn() {
        this.queryColumns.add(" count(short_message_content) count_short_message_content");
    }

    public void addSumShortMessageContentQueryColumn() {
        this.queryColumns.add(" sum(short_message_content) sum_short_message_content");
    }

    public void addStartTimeQueryColumn() {
        this.queryColumns.add("start_time");
    }

    public void addMaxStartTimeQueryColumn() {
        this.queryColumns.add("max(start_time) max_start_time");
    }

    public void addMinStartTimeQueryColumn() {
        this.queryColumns.add("min(start_time) min_start_time");
    }

    public void addAvgStartTimeQueryColumn() {
        this.queryColumns.add(" avg(start_time) avg_start_time");
    }

    public void addCountStartTimeQueryColumn() {
        this.queryColumns.add(" count(start_time) count_start_time");
    }

    public void addSumStartTimeQueryColumn() {
        this.queryColumns.add(" sum(start_time) sum_start_time");
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

        public Criteria andBirthdayActivityIdIsNull() {
            addCriterion("birthday_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdIsNotNull() {
            addCriterion("birthday_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdEqualTo(Long value) {
            addCriterion("birthday_activity_id =", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdNotEqualTo(Long value) {
            addCriterion("birthday_activity_id <>", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdGreaterThan(Long value) {
            addCriterion("birthday_activity_id >", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("birthday_activity_id >=", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdLessThan(Long value) {
            addCriterion("birthday_activity_id <", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("birthday_activity_id <=", value, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdIn(List<Long> values) {
            addCriterion("birthday_activity_id in", values, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdNotIn(List<Long> values) {
            addCriterion("birthday_activity_id not in", values, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdBetween(Long value1, Long value2) {
            addCriterion("birthday_activity_id between", value1, value2, "birthdayActivityId");
            return (Criteria) this;
        }

        public Criteria andBirthdayActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("birthday_activity_id not between", value1, value2, "birthdayActivityId");
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

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Long value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Long value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Long value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Long value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Long value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Long value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Long> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Long> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Long value1, Long value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Long value1, Long value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPoolIdIsNull() {
            addCriterion("pool_id is null");
            return (Criteria) this;
        }

        public Criteria andPoolIdIsNotNull() {
            addCriterion("pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoolIdEqualTo(Long value) {
            addCriterion("pool_id =", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotEqualTo(Long value) {
            addCriterion("pool_id <>", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdGreaterThan(Long value) {
            addCriterion("pool_id >", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pool_id >=", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdLessThan(Long value) {
            addCriterion("pool_id <", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("pool_id <=", value, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdIn(List<Long> values) {
            addCriterion("pool_id in", values, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotIn(List<Long> values) {
            addCriterion("pool_id not in", values, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdBetween(Long value1, Long value2) {
            addCriterion("pool_id between", value1, value2, "poolId");
            return (Criteria) this;
        }

        public Criteria andPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("pool_id not between", value1, value2, "poolId");
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

        public Criteria andCareTypeIsNull() {
            addCriterion("care_type is null");
            return (Criteria) this;
        }

        public Criteria andCareTypeIsNotNull() {
            addCriterion("care_type is not null");
            return (Criteria) this;
        }

        public Criteria andCareTypeEqualTo(String value) {
            addCriterion("care_type =", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeNotEqualTo(String value) {
            addCriterion("care_type <>", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeGreaterThan(String value) {
            addCriterion("care_type >", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("care_type >=", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeLessThan(String value) {
            addCriterion("care_type <", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeLessThanOrEqualTo(String value) {
            addCriterion("care_type <=", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeLike(String value) {
            addCriterion("care_type like", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeNotLike(String value) {
            addCriterion("care_type not like", value, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeIn(List<String> values) {
            addCriterion("care_type in", values, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeNotIn(List<String> values) {
            addCriterion("care_type not in", values, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeBetween(String value1, String value2) {
            addCriterion("care_type between", value1, value2, "careType");
            return (Criteria) this;
        }

        public Criteria andCareTypeNotBetween(String value1, String value2) {
            addCriterion("care_type not between", value1, value2, "careType");
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

        public Criteria andSendTargetIsNull() {
            addCriterion("send_target is null");
            return (Criteria) this;
        }

        public Criteria andSendTargetIsNotNull() {
            addCriterion("send_target is not null");
            return (Criteria) this;
        }

        public Criteria andSendTargetEqualTo(String value) {
            addCriterion("send_target =", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetNotEqualTo(String value) {
            addCriterion("send_target <>", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetGreaterThan(String value) {
            addCriterion("send_target >", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetGreaterThanOrEqualTo(String value) {
            addCriterion("send_target >=", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetLessThan(String value) {
            addCriterion("send_target <", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetLessThanOrEqualTo(String value) {
            addCriterion("send_target <=", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetLike(String value) {
            addCriterion("send_target like", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetNotLike(String value) {
            addCriterion("send_target not like", value, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetIn(List<String> values) {
            addCriterion("send_target in", values, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetNotIn(List<String> values) {
            addCriterion("send_target not in", values, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetBetween(String value1, String value2) {
            addCriterion("send_target between", value1, value2, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andSendTargetNotBetween(String value1, String value2) {
            addCriterion("send_target not between", value1, value2, "sendTarget");
            return (Criteria) this;
        }

        public Criteria andGetLimitIsNull() {
            addCriterion("get_limit is null");
            return (Criteria) this;
        }

        public Criteria andGetLimitIsNotNull() {
            addCriterion("get_limit is not null");
            return (Criteria) this;
        }

        public Criteria andGetLimitEqualTo(Integer value) {
            addCriterion("get_limit =", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitNotEqualTo(Integer value) {
            addCriterion("get_limit <>", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitGreaterThan(Integer value) {
            addCriterion("get_limit >", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_limit >=", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitLessThan(Integer value) {
            addCriterion("get_limit <", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitLessThanOrEqualTo(Integer value) {
            addCriterion("get_limit <=", value, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitIn(List<Integer> values) {
            addCriterion("get_limit in", values, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitNotIn(List<Integer> values) {
            addCriterion("get_limit not in", values, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitBetween(Integer value1, Integer value2) {
            addCriterion("get_limit between", value1, value2, "getLimit");
            return (Criteria) this;
        }

        public Criteria andGetLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("get_limit not between", value1, value2, "getLimit");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordIsNull() {
            addCriterion("secret_password is null");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordIsNotNull() {
            addCriterion("secret_password is not null");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordEqualTo(String value) {
            addCriterion("secret_password =", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordNotEqualTo(String value) {
            addCriterion("secret_password <>", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordGreaterThan(String value) {
            addCriterion("secret_password >", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("secret_password >=", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordLessThan(String value) {
            addCriterion("secret_password <", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordLessThanOrEqualTo(String value) {
            addCriterion("secret_password <=", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordLike(String value) {
            addCriterion("secret_password like", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordNotLike(String value) {
            addCriterion("secret_password not like", value, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordIn(List<String> values) {
            addCriterion("secret_password in", values, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordNotIn(List<String> values) {
            addCriterion("secret_password not in", values, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordBetween(String value1, String value2) {
            addCriterion("secret_password between", value1, value2, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andSecretPasswordNotBetween(String value1, String value2) {
            addCriterion("secret_password not between", value1, value2, "secretPassword");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageIsNull() {
            addCriterion("remind_short_message is null");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageIsNotNull() {
            addCriterion("remind_short_message is not null");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageEqualTo(Integer value) {
            addCriterion("remind_short_message =", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageNotEqualTo(Integer value) {
            addCriterion("remind_short_message <>", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageGreaterThan(Integer value) {
            addCriterion("remind_short_message >", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind_short_message >=", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageLessThan(Integer value) {
            addCriterion("remind_short_message <", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageLessThanOrEqualTo(Integer value) {
            addCriterion("remind_short_message <=", value, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageIn(List<Integer> values) {
            addCriterion("remind_short_message in", values, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageNotIn(List<Integer> values) {
            addCriterion("remind_short_message not in", values, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageBetween(Integer value1, Integer value2) {
            addCriterion("remind_short_message between", value1, value2, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andRemindShortMessageNotBetween(Integer value1, Integer value2) {
            addCriterion("remind_short_message not between", value1, value2, "remindShortMessage");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentIsNull() {
            addCriterion("short_message_content is null");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentIsNotNull() {
            addCriterion("short_message_content is not null");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentEqualTo(String value) {
            addCriterion("short_message_content =", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentNotEqualTo(String value) {
            addCriterion("short_message_content <>", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentGreaterThan(String value) {
            addCriterion("short_message_content >", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("short_message_content >=", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentLessThan(String value) {
            addCriterion("short_message_content <", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentLessThanOrEqualTo(String value) {
            addCriterion("short_message_content <=", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentLike(String value) {
            addCriterion("short_message_content like", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentNotLike(String value) {
            addCriterion("short_message_content not like", value, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentIn(List<String> values) {
            addCriterion("short_message_content in", values, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentNotIn(List<String> values) {
            addCriterion("short_message_content not in", values, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentBetween(String value1, String value2) {
            addCriterion("short_message_content between", value1, value2, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andShortMessageContentNotBetween(String value1, String value2) {
            addCriterion("short_message_content not between", value1, value2, "shortMessageContent");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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