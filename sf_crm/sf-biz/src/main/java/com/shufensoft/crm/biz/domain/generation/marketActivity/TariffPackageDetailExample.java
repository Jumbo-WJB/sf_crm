package com.shufensoft.crm.biz.domain.generation.marketActivity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TariffPackageDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TariffPackageDetailExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("GMT_CREATED is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("GMT_CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("GMT_CREATED =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("GMT_CREATED <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("GMT_CREATED >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATED >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("GMT_CREATED <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATED <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("GMT_CREATED in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("GMT_CREATED not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATED between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATED not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("GMT_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("GMT_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("GMT_MODIFIED =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("GMT_MODIFIED >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("GMT_MODIFIED <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("GMT_MODIFIED in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("GMT_MODIFIED not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNull() {
            addCriterion("MODIFIED_BY is null");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNotNull() {
            addCriterion("MODIFIED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedByEqualTo(String value) {
            addCriterion("MODIFIED_BY =", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotEqualTo(String value) {
            addCriterion("MODIFIED_BY <>", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThan(String value) {
            addCriterion("MODIFIED_BY >", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIED_BY >=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThan(String value) {
            addCriterion("MODIFIED_BY <", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThanOrEqualTo(String value) {
            addCriterion("MODIFIED_BY <=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLike(String value) {
            addCriterion("MODIFIED_BY like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotLike(String value) {
            addCriterion("MODIFIED_BY not like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIn(List<String> values) {
            addCriterion("MODIFIED_BY in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotIn(List<String> values) {
            addCriterion("MODIFIED_BY not in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByBetween(String value1, String value2) {
            addCriterion("MODIFIED_BY between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotBetween(String value1, String value2) {
            addCriterion("MODIFIED_BY not between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("IS_DELETED like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("IS_DELETED not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andTariffTypeIsNull() {
            addCriterion("TARIFF_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTariffTypeIsNotNull() {
            addCriterion("TARIFF_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTariffTypeEqualTo(String value) {
            addCriterion("TARIFF_TYPE =", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeNotEqualTo(String value) {
            addCriterion("TARIFF_TYPE <>", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeGreaterThan(String value) {
            addCriterion("TARIFF_TYPE >", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TARIFF_TYPE >=", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeLessThan(String value) {
            addCriterion("TARIFF_TYPE <", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeLessThanOrEqualTo(String value) {
            addCriterion("TARIFF_TYPE <=", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeLike(String value) {
            addCriterion("TARIFF_TYPE like", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeNotLike(String value) {
            addCriterion("TARIFF_TYPE not like", value, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeIn(List<String> values) {
            addCriterion("TARIFF_TYPE in", values, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeNotIn(List<String> values) {
            addCriterion("TARIFF_TYPE not in", values, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeBetween(String value1, String value2) {
            addCriterion("TARIFF_TYPE between", value1, value2, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffTypeNotBetween(String value1, String value2) {
            addCriterion("TARIFF_TYPE not between", value1, value2, "tariffType");
            return (Criteria) this;
        }

        public Criteria andTariffNameIsNull() {
            addCriterion("TARIFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTariffNameIsNotNull() {
            addCriterion("TARIFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTariffNameEqualTo(String value) {
            addCriterion("TARIFF_NAME =", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameNotEqualTo(String value) {
            addCriterion("TARIFF_NAME <>", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameGreaterThan(String value) {
            addCriterion("TARIFF_NAME >", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameGreaterThanOrEqualTo(String value) {
            addCriterion("TARIFF_NAME >=", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameLessThan(String value) {
            addCriterion("TARIFF_NAME <", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameLessThanOrEqualTo(String value) {
            addCriterion("TARIFF_NAME <=", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameLike(String value) {
            addCriterion("TARIFF_NAME like", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameNotLike(String value) {
            addCriterion("TARIFF_NAME not like", value, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameIn(List<String> values) {
            addCriterion("TARIFF_NAME in", values, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameNotIn(List<String> values) {
            addCriterion("TARIFF_NAME not in", values, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameBetween(String value1, String value2) {
            addCriterion("TARIFF_NAME between", value1, value2, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffNameNotBetween(String value1, String value2) {
            addCriterion("TARIFF_NAME not between", value1, value2, "tariffName");
            return (Criteria) this;
        }

        public Criteria andTariffAmountIsNull() {
            addCriterion("TARIFF_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTariffAmountIsNotNull() {
            addCriterion("TARIFF_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTariffAmountEqualTo(Integer value) {
            addCriterion("TARIFF_AMOUNT =", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountNotEqualTo(Integer value) {
            addCriterion("TARIFF_AMOUNT <>", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountGreaterThan(Integer value) {
            addCriterion("TARIFF_AMOUNT >", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARIFF_AMOUNT >=", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountLessThan(Integer value) {
            addCriterion("TARIFF_AMOUNT <", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountLessThanOrEqualTo(Integer value) {
            addCriterion("TARIFF_AMOUNT <=", value, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountIn(List<Integer> values) {
            addCriterion("TARIFF_AMOUNT in", values, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountNotIn(List<Integer> values) {
            addCriterion("TARIFF_AMOUNT not in", values, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountBetween(Integer value1, Integer value2) {
            addCriterion("TARIFF_AMOUNT between", value1, value2, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("TARIFF_AMOUNT not between", value1, value2, "tariffAmount");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyIsNull() {
            addCriterion("TARIFF_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyIsNotNull() {
            addCriterion("TARIFF_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyEqualTo(BigDecimal value) {
            addCriterion("TARIFF_MONEY =", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TARIFF_MONEY <>", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyGreaterThan(BigDecimal value) {
            addCriterion("TARIFF_MONEY >", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TARIFF_MONEY >=", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyLessThan(BigDecimal value) {
            addCriterion("TARIFF_MONEY <", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TARIFF_MONEY <=", value, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyIn(List<BigDecimal> values) {
            addCriterion("TARIFF_MONEY in", values, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TARIFF_MONEY not in", values, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TARIFF_MONEY between", value1, value2, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TARIFF_MONEY not between", value1, value2, "tariffMoney");
            return (Criteria) this;
        }

        public Criteria andTariffFreeIsNull() {
            addCriterion("TARIFF_FREE is null");
            return (Criteria) this;
        }

        public Criteria andTariffFreeIsNotNull() {
            addCriterion("TARIFF_FREE is not null");
            return (Criteria) this;
        }

        public Criteria andTariffFreeEqualTo(Integer value) {
            addCriterion("TARIFF_FREE =", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeNotEqualTo(Integer value) {
            addCriterion("TARIFF_FREE <>", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeGreaterThan(Integer value) {
            addCriterion("TARIFF_FREE >", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TARIFF_FREE >=", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeLessThan(Integer value) {
            addCriterion("TARIFF_FREE <", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeLessThanOrEqualTo(Integer value) {
            addCriterion("TARIFF_FREE <=", value, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeIn(List<Integer> values) {
            addCriterion("TARIFF_FREE in", values, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeNotIn(List<Integer> values) {
            addCriterion("TARIFF_FREE not in", values, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeBetween(Integer value1, Integer value2) {
            addCriterion("TARIFF_FREE between", value1, value2, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("TARIFF_FREE not between", value1, value2, "tariffFree");
            return (Criteria) this;
        }

        public Criteria andTariffDescIsNull() {
            addCriterion("TARIFF_DESC is null");
            return (Criteria) this;
        }

        public Criteria andTariffDescIsNotNull() {
            addCriterion("TARIFF_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andTariffDescEqualTo(String value) {
            addCriterion("TARIFF_DESC =", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescNotEqualTo(String value) {
            addCriterion("TARIFF_DESC <>", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescGreaterThan(String value) {
            addCriterion("TARIFF_DESC >", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescGreaterThanOrEqualTo(String value) {
            addCriterion("TARIFF_DESC >=", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescLessThan(String value) {
            addCriterion("TARIFF_DESC <", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescLessThanOrEqualTo(String value) {
            addCriterion("TARIFF_DESC <=", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescLike(String value) {
            addCriterion("TARIFF_DESC like", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescNotLike(String value) {
            addCriterion("TARIFF_DESC not like", value, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescIn(List<String> values) {
            addCriterion("TARIFF_DESC in", values, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescNotIn(List<String> values) {
            addCriterion("TARIFF_DESC not in", values, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescBetween(String value1, String value2) {
            addCriterion("TARIFF_DESC between", value1, value2, "tariffDesc");
            return (Criteria) this;
        }

        public Criteria andTariffDescNotBetween(String value1, String value2) {
            addCriterion("TARIFF_DESC not between", value1, value2, "tariffDesc");
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