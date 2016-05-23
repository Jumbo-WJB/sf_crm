package com.shufensoft.crm.biz.domain.generation.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmallRateTagExample {
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

    public TmallRateTagExample() {
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

    public void addGmtCreatedQueryColumn() {
        this.queryColumns.add("gmt_created");
    }

    public void addMaxGmtCreatedQueryColumn() {
        this.queryColumns.add("max(gmt_created) max_id");
    }

    public void addMinGmtCreatedQueryColumn() {
        this.queryColumns.add("min(gmt_created) min_id");
    }

    public void addAvgGmtCreatedQueryColumn() {
        this.queryColumns.add(" avg(gmt_created) avg_id");
    }

    public void addCountGmtCreatedQueryColumn() {
        this.queryColumns.add(" count(gmt_created) count_id");
    }

    public void addGmtModifiedQueryColumn() {
        this.queryColumns.add("gmt_modified");
    }

    public void addMaxGmtModifiedQueryColumn() {
        this.queryColumns.add("max(gmt_modified) max_id");
    }

    public void addMinGmtModifiedQueryColumn() {
        this.queryColumns.add("min(gmt_modified) min_id");
    }

    public void addAvgGmtModifiedQueryColumn() {
        this.queryColumns.add(" avg(gmt_modified) avg_id");
    }

    public void addCountGmtModifiedQueryColumn() {
        this.queryColumns.add(" count(gmt_modified) count_id");
    }

    public void addIsDeletedQueryColumn() {
        this.queryColumns.add("is_deleted");
    }

    public void addMaxIsDeletedQueryColumn() {
        this.queryColumns.add("max(is_deleted) max_id");
    }

    public void addMinIsDeletedQueryColumn() {
        this.queryColumns.add("min(is_deleted) min_id");
    }

    public void addAvgIsDeletedQueryColumn() {
        this.queryColumns.add(" avg(is_deleted) avg_id");
    }

    public void addCountIsDeletedQueryColumn() {
        this.queryColumns.add(" count(is_deleted) count_id");
    }

    public void addTagIdQueryColumn() {
        this.queryColumns.add("tag_id");
    }

    public void addMaxTagIdQueryColumn() {
        this.queryColumns.add("max(tag_id) max_id");
    }

    public void addMinTagIdQueryColumn() {
        this.queryColumns.add("min(tag_id) min_id");
    }

    public void addAvgTagIdQueryColumn() {
        this.queryColumns.add(" avg(tag_id) avg_id");
    }

    public void addCountTagIdQueryColumn() {
        this.queryColumns.add(" count(tag_id) count_id");
    }

    public void addCommentIdTbQueryColumn() {
        this.queryColumns.add("comment_id_tb");
    }

    public void addMaxCommentIdTbQueryColumn() {
        this.queryColumns.add("max(comment_id_tb) max_id");
    }

    public void addMinCommentIdTbQueryColumn() {
        this.queryColumns.add("min(comment_id_tb) min_id");
    }

    public void addAvgCommentIdTbQueryColumn() {
        this.queryColumns.add(" avg(comment_id_tb) avg_id");
    }

    public void addCountCommentIdTbQueryColumn() {
        this.queryColumns.add(" count(comment_id_tb) count_id");
    }

    public void addAppendTagsQueryColumn() {
        this.queryColumns.add("append_tags");
    }

    public void addMaxAppendTagsQueryColumn() {
        this.queryColumns.add("max(append_tags) max_id");
    }

    public void addMinAppendTagsQueryColumn() {
        this.queryColumns.add("min(append_tags) min_id");
    }

    public void addAvgAppendTagsQueryColumn() {
        this.queryColumns.add(" avg(append_tags) avg_id");
    }

    public void addCountAppendTagsQueryColumn() {
        this.queryColumns.add(" count(append_tags) count_id");
    }

    public void addTagNameQueryColumn() {
        this.queryColumns.add("tag_name");
    }

    public void addMaxTagNameQueryColumn() {
        this.queryColumns.add("max(tag_name) max_id");
    }

    public void addMinTagNameQueryColumn() {
        this.queryColumns.add("min(tag_name) min_id");
    }

    public void addAvgTagNameQueryColumn() {
        this.queryColumns.add(" avg(tag_name) avg_id");
    }

    public void addCountTagNameQueryColumn() {
        this.queryColumns.add(" count(tag_name) count_id");
    }

    public void addPosiQueryColumn() {
        this.queryColumns.add("posi");
    }

    public void addMaxPosiQueryColumn() {
        this.queryColumns.add("max(posi) max_id");
    }

    public void addMinPosiQueryColumn() {
        this.queryColumns.add("min(posi) min_id");
    }

    public void addAvgPosiQueryColumn() {
        this.queryColumns.add(" avg(posi) avg_id");
    }

    public void addCountPosiQueryColumn() {
        this.queryColumns.add(" count(posi) count_id");
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

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Long value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Long value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Long value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Long value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Long value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Long> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Long> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Long value1, Long value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Long value1, Long value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
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

        public Criteria andAppendTagsIsNull() {
            addCriterion("append_tags is null");
            return (Criteria) this;
        }

        public Criteria andAppendTagsIsNotNull() {
            addCriterion("append_tags is not null");
            return (Criteria) this;
        }

        public Criteria andAppendTagsEqualTo(Boolean value) {
            addCriterion("append_tags =", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsNotEqualTo(Boolean value) {
            addCriterion("append_tags <>", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsGreaterThan(Boolean value) {
            addCriterion("append_tags >", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("append_tags >=", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsLessThan(Boolean value) {
            addCriterion("append_tags <", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsLessThanOrEqualTo(Boolean value) {
            addCriterion("append_tags <=", value, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsIn(List<Boolean> values) {
            addCriterion("append_tags in", values, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsNotIn(List<Boolean> values) {
            addCriterion("append_tags not in", values, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsBetween(Boolean value1, Boolean value2) {
            addCriterion("append_tags between", value1, value2, "appendTags");
            return (Criteria) this;
        }

        public Criteria andAppendTagsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("append_tags not between", value1, value2, "appendTags");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andPosiIsNull() {
            addCriterion("posi is null");
            return (Criteria) this;
        }

        public Criteria andPosiIsNotNull() {
            addCriterion("posi is not null");
            return (Criteria) this;
        }

        public Criteria andPosiEqualTo(Boolean value) {
            addCriterion("posi =", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotEqualTo(Boolean value) {
            addCriterion("posi <>", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiGreaterThan(Boolean value) {
            addCriterion("posi >", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiGreaterThanOrEqualTo(Boolean value) {
            addCriterion("posi >=", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiLessThan(Boolean value) {
            addCriterion("posi <", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiLessThanOrEqualTo(Boolean value) {
            addCriterion("posi <=", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiIn(List<Boolean> values) {
            addCriterion("posi in", values, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotIn(List<Boolean> values) {
            addCriterion("posi not in", values, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiBetween(Boolean value1, Boolean value2) {
            addCriterion("posi between", value1, value2, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotBetween(Boolean value1, Boolean value2) {
            addCriterion("posi not between", value1, value2, "posi");
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