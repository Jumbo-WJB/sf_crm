package com.shufensoft.crm.biz.domain.generation.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataSourceConfigExample {
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

    public DataSourceConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
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
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("id");
    }

    public void addGmtCreatedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("gmt_created");
    }

    public void addGmtModifiedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("gmt_modified");
    }

    public void addCreatedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("created_by");
    }

    public void addModifiedByQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("modified_by");
    }

    public void addIsDeletedQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("is_deleted");
    }

    public void addSellerIdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("seller_id");
    }

    public void addDatasourceNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("datasource_name");
    }

    public void addDriverClassNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("driver_class_name");
    }

    public void addUrlQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("url");
    }

    public void addUserNameQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("user_name");
    }

    public void addPasswdQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("passwd");
    }

    public void addInitialPoolSizeQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("initial_pool_size");
    }

    public void addMaxActiveQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("max_active");
    }

    public void addMinIdleQueryColumn() {
        if(this.queryColumns == null || this.queryColumns.isEmpty()){
            throw new RuntimeException("Value for queryColumns cannot be null");
        }
        this.queryColumns.add("min_idle");
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

        public Criteria andDatasourceNameIsNull() {
            addCriterion("datasource_name is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameIsNotNull() {
            addCriterion("datasource_name is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameEqualTo(String value) {
            addCriterion("datasource_name =", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotEqualTo(String value) {
            addCriterion("datasource_name <>", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameGreaterThan(String value) {
            addCriterion("datasource_name >", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("datasource_name >=", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLessThan(String value) {
            addCriterion("datasource_name <", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLessThanOrEqualTo(String value) {
            addCriterion("datasource_name <=", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameLike(String value) {
            addCriterion("datasource_name like", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotLike(String value) {
            addCriterion("datasource_name not like", value, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameIn(List<String> values) {
            addCriterion("datasource_name in", values, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotIn(List<String> values) {
            addCriterion("datasource_name not in", values, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameBetween(String value1, String value2) {
            addCriterion("datasource_name between", value1, value2, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDatasourceNameNotBetween(String value1, String value2) {
            addCriterion("datasource_name not between", value1, value2, "datasourceName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIsNull() {
            addCriterion("driver_class_name is null");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIsNotNull() {
            addCriterion("driver_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameEqualTo(String value) {
            addCriterion("driver_class_name =", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotEqualTo(String value) {
            addCriterion("driver_class_name <>", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameGreaterThan(String value) {
            addCriterion("driver_class_name >", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("driver_class_name >=", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLessThan(String value) {
            addCriterion("driver_class_name <", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLessThanOrEqualTo(String value) {
            addCriterion("driver_class_name <=", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameLike(String value) {
            addCriterion("driver_class_name like", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotLike(String value) {
            addCriterion("driver_class_name not like", value, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameIn(List<String> values) {
            addCriterion("driver_class_name in", values, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotIn(List<String> values) {
            addCriterion("driver_class_name not in", values, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameBetween(String value1, String value2) {
            addCriterion("driver_class_name between", value1, value2, "driverClassName");
            return (Criteria) this;
        }

        public Criteria andDriverClassNameNotBetween(String value1, String value2) {
            addCriterion("driver_class_name not between", value1, value2, "driverClassName");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("passwd is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("passwd is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("passwd =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("passwd <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("passwd >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("passwd >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("passwd <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("passwd <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("passwd like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("passwd not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("passwd in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("passwd not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeIsNull() {
            addCriterion("initial_pool_size is null");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeIsNotNull() {
            addCriterion("initial_pool_size is not null");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeEqualTo(Integer value) {
            addCriterion("initial_pool_size =", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeNotEqualTo(Integer value) {
            addCriterion("initial_pool_size <>", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeGreaterThan(Integer value) {
            addCriterion("initial_pool_size >", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("initial_pool_size >=", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeLessThan(Integer value) {
            addCriterion("initial_pool_size <", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeLessThanOrEqualTo(Integer value) {
            addCriterion("initial_pool_size <=", value, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeIn(List<Integer> values) {
            addCriterion("initial_pool_size in", values, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeNotIn(List<Integer> values) {
            addCriterion("initial_pool_size not in", values, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeBetween(Integer value1, Integer value2) {
            addCriterion("initial_pool_size between", value1, value2, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andInitialPoolSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("initial_pool_size not between", value1, value2, "initialPoolSize");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIsNull() {
            addCriterion("max_active is null");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIsNotNull() {
            addCriterion("max_active is not null");
            return (Criteria) this;
        }

        public Criteria andMaxActiveEqualTo(Integer value) {
            addCriterion("max_active =", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotEqualTo(Integer value) {
            addCriterion("max_active <>", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveGreaterThan(Integer value) {
            addCriterion("max_active >", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_active >=", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveLessThan(Integer value) {
            addCriterion("max_active <", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveLessThanOrEqualTo(Integer value) {
            addCriterion("max_active <=", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIn(List<Integer> values) {
            addCriterion("max_active in", values, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotIn(List<Integer> values) {
            addCriterion("max_active not in", values, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveBetween(Integer value1, Integer value2) {
            addCriterion("max_active between", value1, value2, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("max_active not between", value1, value2, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNull() {
            addCriterion("min_idle is null");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNotNull() {
            addCriterion("min_idle is not null");
            return (Criteria) this;
        }

        public Criteria andMinIdleEqualTo(Integer value) {
            addCriterion("min_idle =", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotEqualTo(Integer value) {
            addCriterion("min_idle <>", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThan(Integer value) {
            addCriterion("min_idle >", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_idle >=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThan(Integer value) {
            addCriterion("min_idle <", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThanOrEqualTo(Integer value) {
            addCriterion("min_idle <=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleIn(List<Integer> values) {
            addCriterion("min_idle in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotIn(List<Integer> values) {
            addCriterion("min_idle not in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleBetween(Integer value1, Integer value2) {
            addCriterion("min_idle between", value1, value2, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotBetween(Integer value1, Integer value2) {
            addCriterion("min_idle not between", value1, value2, "minIdle");
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