package com.shufensoft.crm.biz.domain.generation.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentJDExample {
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

    public CommentJDExample() {
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

    public void addJdCommentIdQueryColumn() {
        this.queryColumns.add("jd_comment_id");
    }

    public void addMaxJdCommentIdQueryColumn() {
        this.queryColumns.add("max(jd_comment_id) max_jd_comment_id");
    }

    public void addMinJdCommentIdQueryColumn() {
        this.queryColumns.add("min(jd_comment_id) min_jd_comment_id");
    }

    public void addAvgJdCommentIdQueryColumn() {
        this.queryColumns.add(" avg(jd_comment_id) avg_jd_comment_id");
    }

    public void addCountJdCommentIdQueryColumn() {
        this.queryColumns.add(" count(jd_comment_id) count_jd_comment_id");
    }

    public void addSumJdCommentIdQueryColumn() {
        this.queryColumns.add(" sum(jd_comment_id) sum_jd_comment_id");
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

    public void addSkuidQueryColumn() {
        this.queryColumns.add("skuid");
    }

    public void addMaxSkuidQueryColumn() {
        this.queryColumns.add("max(skuid) max_skuid");
    }

    public void addMinSkuidQueryColumn() {
        this.queryColumns.add("min(skuid) min_skuid");
    }

    public void addAvgSkuidQueryColumn() {
        this.queryColumns.add(" avg(skuid) avg_skuid");
    }

    public void addCountSkuidQueryColumn() {
        this.queryColumns.add(" count(skuid) count_skuid");
    }

    public void addSumSkuidQueryColumn() {
        this.queryColumns.add(" sum(skuid) sum_skuid");
    }

    public void addContentQueryColumn() {
        this.queryColumns.add("content");
    }

    public void addMaxContentQueryColumn() {
        this.queryColumns.add("max(content) max_content");
    }

    public void addMinContentQueryColumn() {
        this.queryColumns.add("min(content) min_content");
    }

    public void addAvgContentQueryColumn() {
        this.queryColumns.add(" avg(content) avg_content");
    }

    public void addCountContentQueryColumn() {
        this.queryColumns.add(" count(content) count_content");
    }

    public void addSumContentQueryColumn() {
        this.queryColumns.add(" sum(content) sum_content");
    }

    public void addCreationTimeQueryColumn() {
        this.queryColumns.add("creation_time");
    }

    public void addMaxCreationTimeQueryColumn() {
        this.queryColumns.add("max(creation_time) max_creation_time");
    }

    public void addMinCreationTimeQueryColumn() {
        this.queryColumns.add("min(creation_time) min_creation_time");
    }

    public void addAvgCreationTimeQueryColumn() {
        this.queryColumns.add(" avg(creation_time) avg_creation_time");
    }

    public void addCountCreationTimeQueryColumn() {
        this.queryColumns.add(" count(creation_time) count_creation_time");
    }

    public void addSumCreationTimeQueryColumn() {
        this.queryColumns.add(" sum(creation_time) sum_creation_time");
    }

    public void addSkuImageQueryColumn() {
        this.queryColumns.add("sku_image");
    }

    public void addMaxSkuImageQueryColumn() {
        this.queryColumns.add("max(sku_image) max_sku_image");
    }

    public void addMinSkuImageQueryColumn() {
        this.queryColumns.add("min(sku_image) min_sku_image");
    }

    public void addAvgSkuImageQueryColumn() {
        this.queryColumns.add(" avg(sku_image) avg_sku_image");
    }

    public void addCountSkuImageQueryColumn() {
        this.queryColumns.add(" count(sku_image) count_sku_image");
    }

    public void addSumSkuImageQueryColumn() {
        this.queryColumns.add(" sum(sku_image) sum_sku_image");
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

    public void addReplyCountQueryColumn() {
        this.queryColumns.add("reply_count");
    }

    public void addMaxReplyCountQueryColumn() {
        this.queryColumns.add("max(reply_count) max_reply_count");
    }

    public void addMinReplyCountQueryColumn() {
        this.queryColumns.add("min(reply_count) min_reply_count");
    }

    public void addAvgReplyCountQueryColumn() {
        this.queryColumns.add(" avg(reply_count) avg_reply_count");
    }

    public void addCountReplyCountQueryColumn() {
        this.queryColumns.add(" count(reply_count) count_reply_count");
    }

    public void addSumReplyCountQueryColumn() {
        this.queryColumns.add(" sum(reply_count) sum_reply_count");
    }

    public void addScoreQueryColumn() {
        this.queryColumns.add("score");
    }

    public void addMaxScoreQueryColumn() {
        this.queryColumns.add("max(score) max_score");
    }

    public void addMinScoreQueryColumn() {
        this.queryColumns.add("min(score) min_score");
    }

    public void addAvgScoreQueryColumn() {
        this.queryColumns.add(" avg(score) avg_score");
    }

    public void addCountScoreQueryColumn() {
        this.queryColumns.add(" count(score) count_score");
    }

    public void addSumScoreQueryColumn() {
        this.queryColumns.add(" sum(score) sum_score");
    }

    public void addUsefulCountQueryColumn() {
        this.queryColumns.add("useful_count");
    }

    public void addMaxUsefulCountQueryColumn() {
        this.queryColumns.add("max(useful_count) max_useful_count");
    }

    public void addMinUsefulCountQueryColumn() {
        this.queryColumns.add("min(useful_count) min_useful_count");
    }

    public void addAvgUsefulCountQueryColumn() {
        this.queryColumns.add(" avg(useful_count) avg_useful_count");
    }

    public void addCountUsefulCountQueryColumn() {
        this.queryColumns.add(" count(useful_count) count_useful_count");
    }

    public void addSumUsefulCountQueryColumn() {
        this.queryColumns.add(" sum(useful_count) sum_useful_count");
    }

    public void addIsVenderReplyQueryColumn() {
        this.queryColumns.add("is_vender_reply");
    }

    public void addMaxIsVenderReplyQueryColumn() {
        this.queryColumns.add("max(is_vender_reply) max_is_vender_reply");
    }

    public void addMinIsVenderReplyQueryColumn() {
        this.queryColumns.add("min(is_vender_reply) min_is_vender_reply");
    }

    public void addAvgIsVenderReplyQueryColumn() {
        this.queryColumns.add(" avg(is_vender_reply) avg_is_vender_reply");
    }

    public void addCountIsVenderReplyQueryColumn() {
        this.queryColumns.add(" count(is_vender_reply) count_is_vender_reply");
    }

    public void addSumIsVenderReplyQueryColumn() {
        this.queryColumns.add(" sum(is_vender_reply) sum_is_vender_reply");
    }

    public void addNickNameQueryColumn() {
        this.queryColumns.add("nick_name");
    }

    public void addMaxNickNameQueryColumn() {
        this.queryColumns.add("max(nick_name) max_nick_name");
    }

    public void addMinNickNameQueryColumn() {
        this.queryColumns.add("min(nick_name) min_nick_name");
    }

    public void addAvgNickNameQueryColumn() {
        this.queryColumns.add(" avg(nick_name) avg_nick_name");
    }

    public void addCountNickNameQueryColumn() {
        this.queryColumns.add(" count(nick_name) count_nick_name");
    }

    public void addSumNickNameQueryColumn() {
        this.queryColumns.add(" sum(nick_name) sum_nick_name");
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

        public Criteria andJdCommentIdIsNull() {
            addCriterion("jd_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdIsNotNull() {
            addCriterion("jd_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdEqualTo(String value) {
            addCriterion("jd_comment_id =", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdNotEqualTo(String value) {
            addCriterion("jd_comment_id <>", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdGreaterThan(String value) {
            addCriterion("jd_comment_id >", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdGreaterThanOrEqualTo(String value) {
            addCriterion("jd_comment_id >=", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdLessThan(String value) {
            addCriterion("jd_comment_id <", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdLessThanOrEqualTo(String value) {
            addCriterion("jd_comment_id <=", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdLike(String value) {
            addCriterion("jd_comment_id like", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdNotLike(String value) {
            addCriterion("jd_comment_id not like", value, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdIn(List<String> values) {
            addCriterion("jd_comment_id in", values, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdNotIn(List<String> values) {
            addCriterion("jd_comment_id not in", values, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdBetween(String value1, String value2) {
            addCriterion("jd_comment_id between", value1, value2, "jdCommentId");
            return (Criteria) this;
        }

        public Criteria andJdCommentIdNotBetween(String value1, String value2) {
            addCriterion("jd_comment_id not between", value1, value2, "jdCommentId");
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

        public Criteria andSkuidIsNull() {
            addCriterion("skuid is null");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNotNull() {
            addCriterion("skuid is not null");
            return (Criteria) this;
        }

        public Criteria andSkuidEqualTo(String value) {
            addCriterion("skuid =", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotEqualTo(String value) {
            addCriterion("skuid <>", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThan(String value) {
            addCriterion("skuid >", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThanOrEqualTo(String value) {
            addCriterion("skuid >=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThan(String value) {
            addCriterion("skuid <", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThanOrEqualTo(String value) {
            addCriterion("skuid <=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLike(String value) {
            addCriterion("skuid like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotLike(String value) {
            addCriterion("skuid not like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidIn(List<String> values) {
            addCriterion("skuid in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotIn(List<String> values) {
            addCriterion("skuid not in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidBetween(String value1, String value2) {
            addCriterion("skuid between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotBetween(String value1, String value2) {
            addCriterion("skuid not between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andSkuImageIsNull() {
            addCriterion("sku_image is null");
            return (Criteria) this;
        }

        public Criteria andSkuImageIsNotNull() {
            addCriterion("sku_image is not null");
            return (Criteria) this;
        }

        public Criteria andSkuImageEqualTo(String value) {
            addCriterion("sku_image =", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageNotEqualTo(String value) {
            addCriterion("sku_image <>", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageGreaterThan(String value) {
            addCriterion("sku_image >", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageGreaterThanOrEqualTo(String value) {
            addCriterion("sku_image >=", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageLessThan(String value) {
            addCriterion("sku_image <", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageLessThanOrEqualTo(String value) {
            addCriterion("sku_image <=", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageLike(String value) {
            addCriterion("sku_image like", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageNotLike(String value) {
            addCriterion("sku_image not like", value, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageIn(List<String> values) {
            addCriterion("sku_image in", values, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageNotIn(List<String> values) {
            addCriterion("sku_image not in", values, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageBetween(String value1, String value2) {
            addCriterion("sku_image between", value1, value2, "skuImage");
            return (Criteria) this;
        }

        public Criteria andSkuImageNotBetween(String value1, String value2) {
            addCriterion("sku_image not between", value1, value2, "skuImage");
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

        public Criteria andReplyCountIsNull() {
            addCriterion("reply_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("reply_count =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("reply_count <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("reply_count >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_count >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("reply_count <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_count <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("reply_count in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("reply_count not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_count between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_count not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIsNull() {
            addCriterion("useful_count is null");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIsNotNull() {
            addCriterion("useful_count is not null");
            return (Criteria) this;
        }

        public Criteria andUsefulCountEqualTo(Integer value) {
            addCriterion("useful_count =", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotEqualTo(Integer value) {
            addCriterion("useful_count <>", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountGreaterThan(Integer value) {
            addCriterion("useful_count >", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("useful_count >=", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountLessThan(Integer value) {
            addCriterion("useful_count <", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountLessThanOrEqualTo(Integer value) {
            addCriterion("useful_count <=", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIn(List<Integer> values) {
            addCriterion("useful_count in", values, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotIn(List<Integer> values) {
            addCriterion("useful_count not in", values, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountBetween(Integer value1, Integer value2) {
            addCriterion("useful_count between", value1, value2, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotBetween(Integer value1, Integer value2) {
            addCriterion("useful_count not between", value1, value2, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyIsNull() {
            addCriterion("is_vender_reply is null");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyIsNotNull() {
            addCriterion("is_vender_reply is not null");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyEqualTo(Boolean value) {
            addCriterion("is_vender_reply =", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyNotEqualTo(Boolean value) {
            addCriterion("is_vender_reply <>", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyGreaterThan(Boolean value) {
            addCriterion("is_vender_reply >", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_vender_reply >=", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyLessThan(Boolean value) {
            addCriterion("is_vender_reply <", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_vender_reply <=", value, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyIn(List<Boolean> values) {
            addCriterion("is_vender_reply in", values, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyNotIn(List<Boolean> values) {
            addCriterion("is_vender_reply not in", values, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vender_reply between", value1, value2, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andIsVenderReplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vender_reply not between", value1, value2, "isVenderReply");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
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