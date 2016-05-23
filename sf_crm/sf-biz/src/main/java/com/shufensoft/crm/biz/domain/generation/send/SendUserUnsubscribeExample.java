package com.shufensoft.crm.biz.domain.generation.send;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendUserUnsubscribeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /** 在查询中增加for update 
     * 目前用来支持对查询记录加锁
     **/
    protected boolean forUpdate;

    public SendUserUnsubscribeExample() {
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
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
        return forUpdate;
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

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressIsNull() {
            addCriterion("user_send_address is null");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressIsNotNull() {
            addCriterion("user_send_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressEqualTo(String value) {
            addCriterion("user_send_address =", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressNotEqualTo(String value) {
            addCriterion("user_send_address <>", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressGreaterThan(String value) {
            addCriterion("user_send_address >", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_send_address >=", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressLessThan(String value) {
            addCriterion("user_send_address <", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressLessThanOrEqualTo(String value) {
            addCriterion("user_send_address <=", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressLike(String value) {
            addCriterion("user_send_address like", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressNotLike(String value) {
            addCriterion("user_send_address not like", value, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressIn(List<String> values) {
            addCriterion("user_send_address in", values, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressNotIn(List<String> values) {
            addCriterion("user_send_address not in", values, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressBetween(String value1, String value2) {
            addCriterion("user_send_address between", value1, value2, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUserSendAddressNotBetween(String value1, String value2) {
            addCriterion("user_send_address not between", value1, value2, "userSendAddress");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeIsNull() {
            addCriterion("unsubscribe_type is null");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeIsNotNull() {
            addCriterion("unsubscribe_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeEqualTo(String value) {
            addCriterion("unsubscribe_type =", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeNotEqualTo(String value) {
            addCriterion("unsubscribe_type <>", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeGreaterThan(String value) {
            addCriterion("unsubscribe_type >", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unsubscribe_type >=", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeLessThan(String value) {
            addCriterion("unsubscribe_type <", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeLessThanOrEqualTo(String value) {
            addCriterion("unsubscribe_type <=", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeLike(String value) {
            addCriterion("unsubscribe_type like", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeNotLike(String value) {
            addCriterion("unsubscribe_type not like", value, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeIn(List<String> values) {
            addCriterion("unsubscribe_type in", values, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeNotIn(List<String> values) {
            addCriterion("unsubscribe_type not in", values, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeBetween(String value1, String value2) {
            addCriterion("unsubscribe_type between", value1, value2, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andUnsubscribeTypeNotBetween(String value1, String value2) {
            addCriterion("unsubscribe_type not between", value1, value2, "unsubscribeType");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNull() {
            addCriterion("sms_content is null");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNotNull() {
            addCriterion("sms_content is not null");
            return (Criteria) this;
        }

        public Criteria andSmsContentEqualTo(String value) {
            addCriterion("sms_content =", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotEqualTo(String value) {
            addCriterion("sms_content <>", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThan(String value) {
            addCriterion("sms_content >", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThanOrEqualTo(String value) {
            addCriterion("sms_content >=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThan(String value) {
            addCriterion("sms_content <", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThanOrEqualTo(String value) {
            addCriterion("sms_content <=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLike(String value) {
            addCriterion("sms_content like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotLike(String value) {
            addCriterion("sms_content not like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentIn(List<String> values) {
            addCriterion("sms_content in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotIn(List<String> values) {
            addCriterion("sms_content not in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentBetween(String value1, String value2) {
            addCriterion("sms_content between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotBetween(String value1, String value2) {
            addCriterion("sms_content not between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNull() {
            addCriterion("sent_time is null");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNotNull() {
            addCriterion("sent_time is not null");
            return (Criteria) this;
        }

        public Criteria andSentTimeEqualTo(String value) {
            addCriterion("sent_time =", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotEqualTo(String value) {
            addCriterion("sent_time <>", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThan(String value) {
            addCriterion("sent_time >", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sent_time >=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThan(String value) {
            addCriterion("sent_time <", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThanOrEqualTo(String value) {
            addCriterion("sent_time <=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLike(String value) {
            addCriterion("sent_time like", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotLike(String value) {
            addCriterion("sent_time not like", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeIn(List<String> values) {
            addCriterion("sent_time in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotIn(List<String> values) {
            addCriterion("sent_time not in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeBetween(String value1, String value2) {
            addCriterion("sent_time between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotBetween(String value1, String value2) {
            addCriterion("sent_time not between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andAddSerialIsNull() {
            addCriterion("add_serial is null");
            return (Criteria) this;
        }

        public Criteria andAddSerialIsNotNull() {
            addCriterion("add_serial is not null");
            return (Criteria) this;
        }

        public Criteria andAddSerialEqualTo(String value) {
            addCriterion("add_serial =", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotEqualTo(String value) {
            addCriterion("add_serial <>", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialGreaterThan(String value) {
            addCriterion("add_serial >", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialGreaterThanOrEqualTo(String value) {
            addCriterion("add_serial >=", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLessThan(String value) {
            addCriterion("add_serial <", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLessThanOrEqualTo(String value) {
            addCriterion("add_serial <=", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLike(String value) {
            addCriterion("add_serial like", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotLike(String value) {
            addCriterion("add_serial not like", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialIn(List<String> values) {
            addCriterion("add_serial in", values, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotIn(List<String> values) {
            addCriterion("add_serial not in", values, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialBetween(String value1, String value2) {
            addCriterion("add_serial between", value1, value2, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotBetween(String value1, String value2) {
            addCriterion("add_serial not between", value1, value2, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevIsNull() {
            addCriterion("add_serial_rev is null");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevIsNotNull() {
            addCriterion("add_serial_rev is not null");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevEqualTo(String value) {
            addCriterion("add_serial_rev =", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevNotEqualTo(String value) {
            addCriterion("add_serial_rev <>", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevGreaterThan(String value) {
            addCriterion("add_serial_rev >", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevGreaterThanOrEqualTo(String value) {
            addCriterion("add_serial_rev >=", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevLessThan(String value) {
            addCriterion("add_serial_rev <", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevLessThanOrEqualTo(String value) {
            addCriterion("add_serial_rev <=", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevLike(String value) {
            addCriterion("add_serial_rev like", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevNotLike(String value) {
            addCriterion("add_serial_rev not like", value, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevIn(List<String> values) {
            addCriterion("add_serial_rev in", values, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevNotIn(List<String> values) {
            addCriterion("add_serial_rev not in", values, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevBetween(String value1, String value2) {
            addCriterion("add_serial_rev between", value1, value2, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andAddSerialRevNotBetween(String value1, String value2) {
            addCriterion("add_serial_rev not between", value1, value2, "addSerialRev");
            return (Criteria) this;
        }

        public Criteria andChannelNumberIsNull() {
            addCriterion("channel_number is null");
            return (Criteria) this;
        }

        public Criteria andChannelNumberIsNotNull() {
            addCriterion("channel_number is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNumberEqualTo(String value) {
            addCriterion("channel_number =", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberNotEqualTo(String value) {
            addCriterion("channel_number <>", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberGreaterThan(String value) {
            addCriterion("channel_number >", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberGreaterThanOrEqualTo(String value) {
            addCriterion("channel_number >=", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberLessThan(String value) {
            addCriterion("channel_number <", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberLessThanOrEqualTo(String value) {
            addCriterion("channel_number <=", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberLike(String value) {
            addCriterion("channel_number like", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberNotLike(String value) {
            addCriterion("channel_number not like", value, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberIn(List<String> values) {
            addCriterion("channel_number in", values, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberNotIn(List<String> values) {
            addCriterion("channel_number not in", values, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberBetween(String value1, String value2) {
            addCriterion("channel_number between", value1, value2, "channelNumber");
            return (Criteria) this;
        }

        public Criteria andChannelNumberNotBetween(String value1, String value2) {
            addCriterion("channel_number not between", value1, value2, "channelNumber");
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