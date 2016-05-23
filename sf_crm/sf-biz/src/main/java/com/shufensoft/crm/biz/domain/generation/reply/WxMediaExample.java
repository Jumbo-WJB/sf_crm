package com.shufensoft.crm.biz.domain.generation.reply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxMediaExample {
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

    public WxMediaExample() {
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

    public void addCountDistinctTitleQueryColumn() {
        this.queryColumns.add(" count( DISTINCT title) count_distinct_title");
    }

    public void addSumTitleQueryColumn() {
        this.queryColumns.add(" sum(title) sum_title");
    }

    public void addThumbMediaIdQueryColumn() {
        this.queryColumns.add("thumb_media_id");
    }

    public void addMaxThumbMediaIdQueryColumn() {
        this.queryColumns.add("max(thumb_media_id) max_thumb_media_id");
    }

    public void addMinThumbMediaIdQueryColumn() {
        this.queryColumns.add("min(thumb_media_id) min_thumb_media_id");
    }

    public void addAvgThumbMediaIdQueryColumn() {
        this.queryColumns.add(" avg(thumb_media_id) avg_thumb_media_id");
    }

    public void addCountThumbMediaIdQueryColumn() {
        this.queryColumns.add(" count(thumb_media_id) count_thumb_media_id");
    }

    public void addCountDistinctThumbMediaIdQueryColumn() {
        this.queryColumns.add(" count( DISTINCT thumb_media_id) count_distinct_thumb_media_id");
    }

    public void addSumThumbMediaIdQueryColumn() {
        this.queryColumns.add(" sum(thumb_media_id) sum_thumb_media_id");
    }

    public void addShowCoverPicQueryColumn() {
        this.queryColumns.add("show_cover_pic");
    }

    public void addMaxShowCoverPicQueryColumn() {
        this.queryColumns.add("max(show_cover_pic) max_show_cover_pic");
    }

    public void addMinShowCoverPicQueryColumn() {
        this.queryColumns.add("min(show_cover_pic) min_show_cover_pic");
    }

    public void addAvgShowCoverPicQueryColumn() {
        this.queryColumns.add(" avg(show_cover_pic) avg_show_cover_pic");
    }

    public void addCountShowCoverPicQueryColumn() {
        this.queryColumns.add(" count(show_cover_pic) count_show_cover_pic");
    }

    public void addCountDistinctShowCoverPicQueryColumn() {
        this.queryColumns.add(" count( DISTINCT show_cover_pic) count_distinct_show_cover_pic");
    }

    public void addSumShowCoverPicQueryColumn() {
        this.queryColumns.add(" sum(show_cover_pic) sum_show_cover_pic");
    }

    public void addAuthorQueryColumn() {
        this.queryColumns.add("author");
    }

    public void addMaxAuthorQueryColumn() {
        this.queryColumns.add("max(author) max_author");
    }

    public void addMinAuthorQueryColumn() {
        this.queryColumns.add("min(author) min_author");
    }

    public void addAvgAuthorQueryColumn() {
        this.queryColumns.add(" avg(author) avg_author");
    }

    public void addCountAuthorQueryColumn() {
        this.queryColumns.add(" count(author) count_author");
    }

    public void addCountDistinctAuthorQueryColumn() {
        this.queryColumns.add(" count( DISTINCT author) count_distinct_author");
    }

    public void addSumAuthorQueryColumn() {
        this.queryColumns.add(" sum(author) sum_author");
    }

    public void addDigestQueryColumn() {
        this.queryColumns.add("digest");
    }

    public void addMaxDigestQueryColumn() {
        this.queryColumns.add("max(digest) max_digest");
    }

    public void addMinDigestQueryColumn() {
        this.queryColumns.add("min(digest) min_digest");
    }

    public void addAvgDigestQueryColumn() {
        this.queryColumns.add(" avg(digest) avg_digest");
    }

    public void addCountDigestQueryColumn() {
        this.queryColumns.add(" count(digest) count_digest");
    }

    public void addCountDistinctDigestQueryColumn() {
        this.queryColumns.add(" count( DISTINCT digest) count_distinct_digest");
    }

    public void addSumDigestQueryColumn() {
        this.queryColumns.add(" sum(digest) sum_digest");
    }

    public void addUrlQueryColumn() {
        this.queryColumns.add("url");
    }

    public void addMaxUrlQueryColumn() {
        this.queryColumns.add("max(url) max_url");
    }

    public void addMinUrlQueryColumn() {
        this.queryColumns.add("min(url) min_url");
    }

    public void addAvgUrlQueryColumn() {
        this.queryColumns.add(" avg(url) avg_url");
    }

    public void addCountUrlQueryColumn() {
        this.queryColumns.add(" count(url) count_url");
    }

    public void addCountDistinctUrlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT url) count_distinct_url");
    }

    public void addSumUrlQueryColumn() {
        this.queryColumns.add(" sum(url) sum_url");
    }

    public void addContentSourceUrlQueryColumn() {
        this.queryColumns.add("content_source_url");
    }

    public void addMaxContentSourceUrlQueryColumn() {
        this.queryColumns.add("max(content_source_url) max_content_source_url");
    }

    public void addMinContentSourceUrlQueryColumn() {
        this.queryColumns.add("min(content_source_url) min_content_source_url");
    }

    public void addAvgContentSourceUrlQueryColumn() {
        this.queryColumns.add(" avg(content_source_url) avg_content_source_url");
    }

    public void addCountContentSourceUrlQueryColumn() {
        this.queryColumns.add(" count(content_source_url) count_content_source_url");
    }

    public void addCountDistinctContentSourceUrlQueryColumn() {
        this.queryColumns.add(" count( DISTINCT content_source_url) count_distinct_content_source_url");
    }

    public void addSumContentSourceUrlQueryColumn() {
        this.queryColumns.add(" sum(content_source_url) sum_content_source_url");
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

    public void addCountDistinctContentQueryColumn() {
        this.queryColumns.add(" count( DISTINCT content) count_distinct_content");
    }

    public void addSumContentQueryColumn() {
        this.queryColumns.add(" sum(content) sum_content");
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

        public Criteria andThumbMediaIdIsNull() {
            addCriterion("thumb_media_id is null");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdIsNotNull() {
            addCriterion("thumb_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdEqualTo(String value) {
            addCriterion("thumb_media_id =", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotEqualTo(String value) {
            addCriterion("thumb_media_id <>", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdGreaterThan(String value) {
            addCriterion("thumb_media_id >", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_media_id >=", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLessThan(String value) {
            addCriterion("thumb_media_id <", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLessThanOrEqualTo(String value) {
            addCriterion("thumb_media_id <=", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdLike(String value) {
            addCriterion("thumb_media_id like", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotLike(String value) {
            addCriterion("thumb_media_id not like", value, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdIn(List<String> values) {
            addCriterion("thumb_media_id in", values, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotIn(List<String> values) {
            addCriterion("thumb_media_id not in", values, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdBetween(String value1, String value2) {
            addCriterion("thumb_media_id between", value1, value2, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andThumbMediaIdNotBetween(String value1, String value2) {
            addCriterion("thumb_media_id not between", value1, value2, "thumbMediaId");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicIsNull() {
            addCriterion("show_cover_pic is null");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicIsNotNull() {
            addCriterion("show_cover_pic is not null");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicEqualTo(String value) {
            addCriterion("show_cover_pic =", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicNotEqualTo(String value) {
            addCriterion("show_cover_pic <>", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicGreaterThan(String value) {
            addCriterion("show_cover_pic >", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicGreaterThanOrEqualTo(String value) {
            addCriterion("show_cover_pic >=", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicLessThan(String value) {
            addCriterion("show_cover_pic <", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicLessThanOrEqualTo(String value) {
            addCriterion("show_cover_pic <=", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicLike(String value) {
            addCriterion("show_cover_pic like", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicNotLike(String value) {
            addCriterion("show_cover_pic not like", value, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicIn(List<String> values) {
            addCriterion("show_cover_pic in", values, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicNotIn(List<String> values) {
            addCriterion("show_cover_pic not in", values, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicBetween(String value1, String value2) {
            addCriterion("show_cover_pic between", value1, value2, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andShowCoverPicNotBetween(String value1, String value2) {
            addCriterion("show_cover_pic not between", value1, value2, "showCoverPic");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andDigestIsNull() {
            addCriterion("digest is null");
            return (Criteria) this;
        }

        public Criteria andDigestIsNotNull() {
            addCriterion("digest is not null");
            return (Criteria) this;
        }

        public Criteria andDigestEqualTo(String value) {
            addCriterion("digest =", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotEqualTo(String value) {
            addCriterion("digest <>", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThan(String value) {
            addCriterion("digest >", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestGreaterThanOrEqualTo(String value) {
            addCriterion("digest >=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThan(String value) {
            addCriterion("digest <", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLessThanOrEqualTo(String value) {
            addCriterion("digest <=", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestLike(String value) {
            addCriterion("digest like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotLike(String value) {
            addCriterion("digest not like", value, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestIn(List<String> values) {
            addCriterion("digest in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotIn(List<String> values) {
            addCriterion("digest not in", values, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestBetween(String value1, String value2) {
            addCriterion("digest between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andDigestNotBetween(String value1, String value2) {
            addCriterion("digest not between", value1, value2, "digest");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIsNull() {
            addCriterion("content_source_url is null");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIsNotNull() {
            addCriterion("content_source_url is not null");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlEqualTo(String value) {
            addCriterion("content_source_url =", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotEqualTo(String value) {
            addCriterion("content_source_url <>", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlGreaterThan(String value) {
            addCriterion("content_source_url >", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("content_source_url >=", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLessThan(String value) {
            addCriterion("content_source_url <", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("content_source_url <=", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlLike(String value) {
            addCriterion("content_source_url like", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotLike(String value) {
            addCriterion("content_source_url not like", value, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlIn(List<String> values) {
            addCriterion("content_source_url in", values, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotIn(List<String> values) {
            addCriterion("content_source_url not in", values, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlBetween(String value1, String value2) {
            addCriterion("content_source_url between", value1, value2, "contentSourceUrl");
            return (Criteria) this;
        }

        public Criteria andContentSourceUrlNotBetween(String value1, String value2) {
            addCriterion("content_source_url not between", value1, value2, "contentSourceUrl");
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