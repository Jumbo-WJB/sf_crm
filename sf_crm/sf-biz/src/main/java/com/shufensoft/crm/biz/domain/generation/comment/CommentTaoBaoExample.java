package com.shufensoft.crm.biz.domain.generation.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentTaoBaoExample {
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

    public CommentTaoBaoExample() {
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

    public void addCommentIdTbQueryColumn() {
        this.queryColumns.add("comment_id_tb");
    }

    public void addMaxCommentIdTbQueryColumn() {
        this.queryColumns.add("max(comment_id_tb) max_comment_id_tb");
    }

    public void addMinCommentIdTbQueryColumn() {
        this.queryColumns.add("min(comment_id_tb) min_comment_id_tb");
    }

    public void addAvgCommentIdTbQueryColumn() {
        this.queryColumns.add(" avg(comment_id_tb) avg_comment_id_tb");
    }

    public void addCountCommentIdTbQueryColumn() {
        this.queryColumns.add(" count(comment_id_tb) count_comment_id_tb");
    }

    public void addSumCommentIdTbQueryColumn() {
        this.queryColumns.add(" sum(comment_id_tb) sum_comment_id_tb");
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

    public void addOidQueryColumn() {
        this.queryColumns.add("oid");
    }

    public void addMaxOidQueryColumn() {
        this.queryColumns.add("max(oid) max_oid");
    }

    public void addMinOidQueryColumn() {
        this.queryColumns.add("min(oid) min_oid");
    }

    public void addAvgOidQueryColumn() {
        this.queryColumns.add(" avg(oid) avg_oid");
    }

    public void addCountOidQueryColumn() {
        this.queryColumns.add(" count(oid) count_oid");
    }

    public void addSumOidQueryColumn() {
        this.queryColumns.add(" sum(oid) sum_oid");
    }

    public void addRoleQueryColumn() {
        this.queryColumns.add("role");
    }

    public void addMaxRoleQueryColumn() {
        this.queryColumns.add("max(role) max_role");
    }

    public void addMinRoleQueryColumn() {
        this.queryColumns.add("min(role) min_role");
    }

    public void addAvgRoleQueryColumn() {
        this.queryColumns.add(" avg(role) avg_role");
    }

    public void addCountRoleQueryColumn() {
        this.queryColumns.add(" count(role) count_role");
    }

    public void addSumRoleQueryColumn() {
        this.queryColumns.add(" sum(role) sum_role");
    }

    public void addNickQueryColumn() {
        this.queryColumns.add("nick");
    }

    public void addMaxNickQueryColumn() {
        this.queryColumns.add("max(nick) max_nick");
    }

    public void addMinNickQueryColumn() {
        this.queryColumns.add("min(nick) min_nick");
    }

    public void addAvgNickQueryColumn() {
        this.queryColumns.add(" avg(nick) avg_nick");
    }

    public void addCountNickQueryColumn() {
        this.queryColumns.add(" count(nick) count_nick");
    }

    public void addSumNickQueryColumn() {
        this.queryColumns.add(" sum(nick) sum_nick");
    }

    public void addResultQueryColumn() {
        this.queryColumns.add("result");
    }

    public void addMaxResultQueryColumn() {
        this.queryColumns.add("max(result) max_result");
    }

    public void addMinResultQueryColumn() {
        this.queryColumns.add("min(result) min_result");
    }

    public void addAvgResultQueryColumn() {
        this.queryColumns.add(" avg(result) avg_result");
    }

    public void addCountResultQueryColumn() {
        this.queryColumns.add(" count(result) count_result");
    }

    public void addSumResultQueryColumn() {
        this.queryColumns.add(" sum(result) sum_result");
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

    public void addRatedNickQueryColumn() {
        this.queryColumns.add("rated_nick");
    }

    public void addMaxRatedNickQueryColumn() {
        this.queryColumns.add("max(rated_nick) max_rated_nick");
    }

    public void addMinRatedNickQueryColumn() {
        this.queryColumns.add("min(rated_nick) min_rated_nick");
    }

    public void addAvgRatedNickQueryColumn() {
        this.queryColumns.add(" avg(rated_nick) avg_rated_nick");
    }

    public void addCountRatedNickQueryColumn() {
        this.queryColumns.add(" count(rated_nick) count_rated_nick");
    }

    public void addSumRatedNickQueryColumn() {
        this.queryColumns.add(" sum(rated_nick) sum_rated_nick");
    }

    public void addItemTitleQueryColumn() {
        this.queryColumns.add("item_title");
    }

    public void addMaxItemTitleQueryColumn() {
        this.queryColumns.add("max(item_title) max_item_title");
    }

    public void addMinItemTitleQueryColumn() {
        this.queryColumns.add("min(item_title) min_item_title");
    }

    public void addAvgItemTitleQueryColumn() {
        this.queryColumns.add(" avg(item_title) avg_item_title");
    }

    public void addCountItemTitleQueryColumn() {
        this.queryColumns.add(" count(item_title) count_item_title");
    }

    public void addSumItemTitleQueryColumn() {
        this.queryColumns.add(" sum(item_title) sum_item_title");
    }

    public void addItemPriceQueryColumn() {
        this.queryColumns.add("item_price");
    }

    public void addMaxItemPriceQueryColumn() {
        this.queryColumns.add("max(item_price) max_item_price");
    }

    public void addMinItemPriceQueryColumn() {
        this.queryColumns.add("min(item_price) min_item_price");
    }

    public void addAvgItemPriceQueryColumn() {
        this.queryColumns.add(" avg(item_price) avg_item_price");
    }

    public void addCountItemPriceQueryColumn() {
        this.queryColumns.add(" count(item_price) count_item_price");
    }

    public void addSumItemPriceQueryColumn() {
        this.queryColumns.add(" sum(item_price) sum_item_price");
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

    public void addReplyQueryColumn() {
        this.queryColumns.add("reply");
    }

    public void addMaxReplyQueryColumn() {
        this.queryColumns.add("max(reply) max_reply");
    }

    public void addMinReplyQueryColumn() {
        this.queryColumns.add("min(reply) min_reply");
    }

    public void addAvgReplyQueryColumn() {
        this.queryColumns.add(" avg(reply) avg_reply");
    }

    public void addCountReplyQueryColumn() {
        this.queryColumns.add(" count(reply) count_reply");
    }

    public void addSumReplyQueryColumn() {
        this.queryColumns.add(" sum(reply) sum_reply");
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

    public void addValidScoreQueryColumn() {
        this.queryColumns.add("valid_score");
    }

    public void addMaxValidScoreQueryColumn() {
        this.queryColumns.add("max(valid_score) max_valid_score");
    }

    public void addMinValidScoreQueryColumn() {
        this.queryColumns.add("min(valid_score) min_valid_score");
    }

    public void addAvgValidScoreQueryColumn() {
        this.queryColumns.add(" avg(valid_score) avg_valid_score");
    }

    public void addCountValidScoreQueryColumn() {
        this.queryColumns.add(" count(valid_score) count_valid_score");
    }

    public void addSumValidScoreQueryColumn() {
        this.queryColumns.add(" sum(valid_score) sum_valid_score");
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

        public Criteria andCommentIdTbIsNull() {
            addCriterion("comment_id_tb is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbIsNotNull() {
            addCriterion("comment_id_tb is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbEqualTo(Long value) {
            addCriterion("comment_id_tb =", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbNotEqualTo(Long value) {
            addCriterion("comment_id_tb <>", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbGreaterThan(Long value) {
            addCriterion("comment_id_tb >", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id_tb >=", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbLessThan(Long value) {
            addCriterion("comment_id_tb <", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbLessThanOrEqualTo(Long value) {
            addCriterion("comment_id_tb <=", value, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbIn(List<Long> values) {
            addCriterion("comment_id_tb in", values, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbNotIn(List<Long> values) {
            addCriterion("comment_id_tb not in", values, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbBetween(Long value1, Long value2) {
            addCriterion("comment_id_tb between", value1, value2, "commentIdTb");
            return (Criteria) this;
        }

        public Criteria andCommentIdTbNotBetween(Long value1, Long value2) {
            addCriterion("comment_id_tb not between", value1, value2, "commentIdTb");
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andNickIsNull() {
            addCriterion("nick is null");
            return (Criteria) this;
        }

        public Criteria andNickIsNotNull() {
            addCriterion("nick is not null");
            return (Criteria) this;
        }

        public Criteria andNickEqualTo(String value) {
            addCriterion("nick =", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotEqualTo(String value) {
            addCriterion("nick <>", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThan(String value) {
            addCriterion("nick >", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            addCriterion("nick >=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThan(String value) {
            addCriterion("nick <", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            addCriterion("nick <=", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickLike(String value) {
            addCriterion("nick like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotLike(String value) {
            addCriterion("nick not like", value, "nick");
            return (Criteria) this;
        }

        public Criteria andNickIn(List<String> values) {
            addCriterion("nick in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotIn(List<String> values) {
            addCriterion("nick not in", values, "nick");
            return (Criteria) this;
        }

        public Criteria andNickBetween(String value1, String value2) {
            addCriterion("nick between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            addCriterion("nick not between", value1, value2, "nick");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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

        public Criteria andRatedNickIsNull() {
            addCriterion("rated_nick is null");
            return (Criteria) this;
        }

        public Criteria andRatedNickIsNotNull() {
            addCriterion("rated_nick is not null");
            return (Criteria) this;
        }

        public Criteria andRatedNickEqualTo(String value) {
            addCriterion("rated_nick =", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickNotEqualTo(String value) {
            addCriterion("rated_nick <>", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickGreaterThan(String value) {
            addCriterion("rated_nick >", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickGreaterThanOrEqualTo(String value) {
            addCriterion("rated_nick >=", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickLessThan(String value) {
            addCriterion("rated_nick <", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickLessThanOrEqualTo(String value) {
            addCriterion("rated_nick <=", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickLike(String value) {
            addCriterion("rated_nick like", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickNotLike(String value) {
            addCriterion("rated_nick not like", value, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickIn(List<String> values) {
            addCriterion("rated_nick in", values, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickNotIn(List<String> values) {
            addCriterion("rated_nick not in", values, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickBetween(String value1, String value2) {
            addCriterion("rated_nick between", value1, value2, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andRatedNickNotBetween(String value1, String value2) {
            addCriterion("rated_nick not between", value1, value2, "ratedNick");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNull() {
            addCriterion("item_title is null");
            return (Criteria) this;
        }

        public Criteria andItemTitleIsNotNull() {
            addCriterion("item_title is not null");
            return (Criteria) this;
        }

        public Criteria andItemTitleEqualTo(String value) {
            addCriterion("item_title =", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotEqualTo(String value) {
            addCriterion("item_title <>", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThan(String value) {
            addCriterion("item_title >", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleGreaterThanOrEqualTo(String value) {
            addCriterion("item_title >=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThan(String value) {
            addCriterion("item_title <", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLessThanOrEqualTo(String value) {
            addCriterion("item_title <=", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleLike(String value) {
            addCriterion("item_title like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotLike(String value) {
            addCriterion("item_title not like", value, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleIn(List<String> values) {
            addCriterion("item_title in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotIn(List<String> values) {
            addCriterion("item_title not in", values, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleBetween(String value1, String value2) {
            addCriterion("item_title between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemTitleNotBetween(String value1, String value2) {
            addCriterion("item_title not between", value1, value2, "itemTitle");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(String value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(String value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(String value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(String value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(String value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(String value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLike(String value) {
            addCriterion("item_price like", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotLike(String value) {
            addCriterion("item_price not like", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<String> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<String> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(String value1, String value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(String value1, String value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
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

        public Criteria andReplyIsNull() {
            addCriterion("reply is null");
            return (Criteria) this;
        }

        public Criteria andReplyIsNotNull() {
            addCriterion("reply is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEqualTo(String value) {
            addCriterion("reply =", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotEqualTo(String value) {
            addCriterion("reply <>", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThan(String value) {
            addCriterion("reply >", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThanOrEqualTo(String value) {
            addCriterion("reply >=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThan(String value) {
            addCriterion("reply <", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThanOrEqualTo(String value) {
            addCriterion("reply <=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLike(String value) {
            addCriterion("reply like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotLike(String value) {
            addCriterion("reply not like", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyIn(List<String> values) {
            addCriterion("reply in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotIn(List<String> values) {
            addCriterion("reply not in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyBetween(String value1, String value2) {
            addCriterion("reply between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotBetween(String value1, String value2) {
            addCriterion("reply not between", value1, value2, "reply");
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

        public Criteria andNumIidEqualTo(Long value) {
            addCriterion("num_iid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(Long value) {
            addCriterion("num_iid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(Long value) {
            addCriterion("num_iid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            addCriterion("num_iid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(Long value) {
            addCriterion("num_iid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(Long value) {
            addCriterion("num_iid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<Long> values) {
            addCriterion("num_iid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<Long> values) {
            addCriterion("num_iid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(Long value1, Long value2) {
            addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(Long value1, Long value2) {
            addCriterion("num_iid not between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andValidScoreIsNull() {
            addCriterion("valid_score is null");
            return (Criteria) this;
        }

        public Criteria andValidScoreIsNotNull() {
            addCriterion("valid_score is not null");
            return (Criteria) this;
        }

        public Criteria andValidScoreEqualTo(Boolean value) {
            addCriterion("valid_score =", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreNotEqualTo(Boolean value) {
            addCriterion("valid_score <>", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreGreaterThan(Boolean value) {
            addCriterion("valid_score >", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid_score >=", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreLessThan(Boolean value) {
            addCriterion("valid_score <", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreLessThanOrEqualTo(Boolean value) {
            addCriterion("valid_score <=", value, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreIn(List<Boolean> values) {
            addCriterion("valid_score in", values, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreNotIn(List<Boolean> values) {
            addCriterion("valid_score not in", values, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreBetween(Boolean value1, Boolean value2) {
            addCriterion("valid_score between", value1, value2, "validScore");
            return (Criteria) this;
        }

        public Criteria andValidScoreNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid_score not between", value1, value2, "validScore");
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