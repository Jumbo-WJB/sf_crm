package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserBound {
    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 商户Id */
    private Long sellerId;

    /** 绑定id,作为@BizId */
    @BizId
    private Long boundId;

    /** 用户id */
    private Long userId;

    /** user_taobao表user_id */
    private Long userIdTb;

    /** user_jd表user_id */
    private Long userIdJd;

    /** user_yz表user_id */
    private Long userIdYz;

    /** user_yz表user_id */
    private Long receiverIdTb;

    /** user_yz表user_id */
    private Long receiverIdJd;

    /** user_yz表user_id */
    private Long receiverIdYz;

    /** 用户手机号码 */
    private String mobile;

    /** 绑定的taobao id */
    private String tbId;

    /** 绑定的jd id */
    private String jdId;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String idExpression;

    /** 与 max(id) 映射**/
    private Long maxId;

    /** 与 min(id) 映射**/
    private Long minId;

    /** 与 avg(id) 映射**/
    private Long avgId;

    /** 与 count(id) 映射**/
    private Long countId;

    /** 与 sum(id) 映射**/
    private Long sumId;

    /** gmtCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtCreatedExpression;

    /** 与 max(gmtCreated) 映射**/
    private Long maxGmtCreated;

    /** 与 min(gmtCreated) 映射**/
    private Long minGmtCreated;

    /** 与 avg(gmtCreated) 映射**/
    private Long avgGmtCreated;

    /** 与 count(gmtCreated) 映射**/
    private Long countGmtCreated;

    /** 与 sum(gmtCreated) 映射**/
    private Date sumGmtCreated;

    /** gmtModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtModifiedExpression;

    /** 与 max(gmtModified) 映射**/
    private Long maxGmtModified;

    /** 与 min(gmtModified) 映射**/
    private Long minGmtModified;

    /** 与 avg(gmtModified) 映射**/
    private Long avgGmtModified;

    /** 与 count(gmtModified) 映射**/
    private Long countGmtModified;

    /** 与 sum(gmtModified) 映射**/
    private Date sumGmtModified;

    /** createdBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdByExpression;

    /** 与 max(createdBy) 映射**/
    private Long maxCreatedBy;

    /** 与 min(createdBy) 映射**/
    private Long minCreatedBy;

    /** 与 avg(createdBy) 映射**/
    private Long avgCreatedBy;

    /** 与 count(createdBy) 映射**/
    private Long countCreatedBy;

    /** 与 sum(createdBy) 映射**/
    private String sumCreatedBy;

    /** modifiedBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedByExpression;

    /** 与 max(modifiedBy) 映射**/
    private Long maxModifiedBy;

    /** 与 min(modifiedBy) 映射**/
    private Long minModifiedBy;

    /** 与 avg(modifiedBy) 映射**/
    private Long avgModifiedBy;

    /** 与 count(modifiedBy) 映射**/
    private Long countModifiedBy;

    /** 与 sum(modifiedBy) 映射**/
    private String sumModifiedBy;

    /** isDeleted属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDeletedExpression;

    /** 与 max(isDeleted) 映射**/
    private Long maxIsDeleted;

    /** 与 min(isDeleted) 映射**/
    private Long minIsDeleted;

    /** 与 avg(isDeleted) 映射**/
    private Long avgIsDeleted;

    /** 与 count(isDeleted) 映射**/
    private Long countIsDeleted;

    /** 与 sum(isDeleted) 映射**/
    private String sumIsDeleted;

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** 与 max(sellerId) 映射**/
    private Long maxSellerId;

    /** 与 min(sellerId) 映射**/
    private Long minSellerId;

    /** 与 avg(sellerId) 映射**/
    private Long avgSellerId;

    /** 与 count(sellerId) 映射**/
    private Long countSellerId;

    /** 与 sum(sellerId) 映射**/
    private Long sumSellerId;

    /** boundId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String boundIdExpression;

    /** 与 max(boundId) 映射**/
    private Long maxBoundId;

    /** 与 min(boundId) 映射**/
    private Long minBoundId;

    /** 与 avg(boundId) 映射**/
    private Long avgBoundId;

    /** 与 count(boundId) 映射**/
    private Long countBoundId;

    /** 与 sum(boundId) 映射**/
    private Long sumBoundId;

    /** userId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdExpression;

    /** 与 max(userId) 映射**/
    private Long maxUserId;

    /** 与 min(userId) 映射**/
    private Long minUserId;

    /** 与 avg(userId) 映射**/
    private Long avgUserId;

    /** 与 count(userId) 映射**/
    private Long countUserId;

    /** 与 sum(userId) 映射**/
    private Long sumUserId;

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

    /** userIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdJdExpression;

    /** 与 max(userIdJd) 映射**/
    private Long maxUserIdJd;

    /** 与 min(userIdJd) 映射**/
    private Long minUserIdJd;

    /** 与 avg(userIdJd) 映射**/
    private Long avgUserIdJd;

    /** 与 count(userIdJd) 映射**/
    private Long countUserIdJd;

    /** 与 sum(userIdJd) 映射**/
    private Long sumUserIdJd;

    /** userIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdYzExpression;

    /** 与 max(userIdYz) 映射**/
    private Long maxUserIdYz;

    /** 与 min(userIdYz) 映射**/
    private Long minUserIdYz;

    /** 与 avg(userIdYz) 映射**/
    private Long avgUserIdYz;

    /** 与 count(userIdYz) 映射**/
    private Long countUserIdYz;

    /** 与 sum(userIdYz) 映射**/
    private Long sumUserIdYz;

    /** receiverIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdTbExpression;

    /** 与 max(receiverIdTb) 映射**/
    private Long maxReceiverIdTb;

    /** 与 min(receiverIdTb) 映射**/
    private Long minReceiverIdTb;

    /** 与 avg(receiverIdTb) 映射**/
    private Long avgReceiverIdTb;

    /** 与 count(receiverIdTb) 映射**/
    private Long countReceiverIdTb;

    /** 与 sum(receiverIdTb) 映射**/
    private Long sumReceiverIdTb;

    /** receiverIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdJdExpression;

    /** 与 max(receiverIdJd) 映射**/
    private Long maxReceiverIdJd;

    /** 与 min(receiverIdJd) 映射**/
    private Long minReceiverIdJd;

    /** 与 avg(receiverIdJd) 映射**/
    private Long avgReceiverIdJd;

    /** 与 count(receiverIdJd) 映射**/
    private Long countReceiverIdJd;

    /** 与 sum(receiverIdJd) 映射**/
    private Long sumReceiverIdJd;

    /** receiverIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdYzExpression;

    /** 与 max(receiverIdYz) 映射**/
    private Long maxReceiverIdYz;

    /** 与 min(receiverIdYz) 映射**/
    private Long minReceiverIdYz;

    /** 与 avg(receiverIdYz) 映射**/
    private Long avgReceiverIdYz;

    /** 与 count(receiverIdYz) 映射**/
    private Long countReceiverIdYz;

    /** 与 sum(receiverIdYz) 映射**/
    private Long sumReceiverIdYz;

    /** mobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String mobileExpression;

    /** 与 max(mobile) 映射**/
    private Long maxMobile;

    /** 与 min(mobile) 映射**/
    private Long minMobile;

    /** 与 avg(mobile) 映射**/
    private Long avgMobile;

    /** 与 count(mobile) 映射**/
    private Long countMobile;

    /** 与 sum(mobile) 映射**/
    private String sumMobile;

    /** tbId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tbIdExpression;

    /** 与 max(tbId) 映射**/
    private Long maxTbId;

    /** 与 min(tbId) 映射**/
    private Long minTbId;

    /** 与 avg(tbId) 映射**/
    private Long avgTbId;

    /** 与 count(tbId) 映射**/
    private Long countTbId;

    /** 与 sum(tbId) 映射**/
    private String sumTbId;

    /** jdId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdIdExpression;

    /** 与 max(jdId) 映射**/
    private Long maxJdId;

    /** 与 min(jdId) 映射**/
    private Long minJdId;

    /** 与 avg(jdId) 映射**/
    private Long avgJdId;

    /** 与 count(jdId) 映射**/
    private Long countJdId;

    /** 与 sum(jdId) 映射**/
    private String sumJdId;
}