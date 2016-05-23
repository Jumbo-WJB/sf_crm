package com.shufensoft.crm.biz.domain.generation.point;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class PointObtain {
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

    /** 商户号 */
    private Long sellerId;

    /**  */
    private Long userId;

    /** 转让人，0为商家 */
    private Long transfererId;

    /** 转让时间 */
    private Date gmtTransfer;

    /** 获得的积分数量 */
    private Long amount;

    /** 消耗的积分 */
    private Long amountConsumed;

    /** 过期时间 */
    private Date gmtExpired;

    /** y可用n不可用 */
    private String status;

    /** 获得方式：sign_in 签到 give赠送 share分享 shake 摇一摇 birthday生日subscribe 关注shopping购物 */
    private String obtainMethod;

    /** 获取id */
    private Long obtainMethodId;

    /**  */
    private Long pointObtainVersion;

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

    /** transfererId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String transfererIdExpression;

    /** 与 max(transfererId) 映射**/
    private Long maxTransfererId;

    /** 与 min(transfererId) 映射**/
    private Long minTransfererId;

    /** 与 avg(transfererId) 映射**/
    private Long avgTransfererId;

    /** 与 count(transfererId) 映射**/
    private Long countTransfererId;

    /** 与 sum(transfererId) 映射**/
    private Long sumTransfererId;

    /** gmtTransfer属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtTransferExpression;

    /** 与 max(gmtTransfer) 映射**/
    private Long maxGmtTransfer;

    /** 与 min(gmtTransfer) 映射**/
    private Long minGmtTransfer;

    /** 与 avg(gmtTransfer) 映射**/
    private Long avgGmtTransfer;

    /** 与 count(gmtTransfer) 映射**/
    private Long countGmtTransfer;

    /** 与 sum(gmtTransfer) 映射**/
    private Date sumGmtTransfer;

    /** amount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountExpression;

    /** 与 max(amount) 映射**/
    private Long maxAmount;

    /** 与 min(amount) 映射**/
    private Long minAmount;

    /** 与 avg(amount) 映射**/
    private Long avgAmount;

    /** 与 count(amount) 映射**/
    private Long countAmount;

    /** 与 sum(amount) 映射**/
    private Long sumAmount;

    /** amountConsumed属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountConsumedExpression;

    /** 与 max(amountConsumed) 映射**/
    private Long maxAmountConsumed;

    /** 与 min(amountConsumed) 映射**/
    private Long minAmountConsumed;

    /** 与 avg(amountConsumed) 映射**/
    private Long avgAmountConsumed;

    /** 与 count(amountConsumed) 映射**/
    private Long countAmountConsumed;

    /** 与 sum(amountConsumed) 映射**/
    private Long sumAmountConsumed;

    /** gmtExpired属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtExpiredExpression;

    /** 与 max(gmtExpired) 映射**/
    private Long maxGmtExpired;

    /** 与 min(gmtExpired) 映射**/
    private Long minGmtExpired;

    /** 与 avg(gmtExpired) 映射**/
    private Long avgGmtExpired;

    /** 与 count(gmtExpired) 映射**/
    private Long countGmtExpired;

    /** 与 sum(gmtExpired) 映射**/
    private Date sumGmtExpired;

    /** status属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statusExpression;

    /** 与 max(status) 映射**/
    private Long maxStatus;

    /** 与 min(status) 映射**/
    private Long minStatus;

    /** 与 avg(status) 映射**/
    private Long avgStatus;

    /** 与 count(status) 映射**/
    private Long countStatus;

    /** 与 sum(status) 映射**/
    private String sumStatus;

    /** obtainMethod属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainMethodExpression;

    /** 与 max(obtainMethod) 映射**/
    private Long maxObtainMethod;

    /** 与 min(obtainMethod) 映射**/
    private Long minObtainMethod;

    /** 与 avg(obtainMethod) 映射**/
    private Long avgObtainMethod;

    /** 与 count(obtainMethod) 映射**/
    private Long countObtainMethod;

    /** 与 sum(obtainMethod) 映射**/
    private String sumObtainMethod;

    /** obtainMethodId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainMethodIdExpression;

    /** 与 max(obtainMethodId) 映射**/
    private Long maxObtainMethodId;

    /** 与 min(obtainMethodId) 映射**/
    private Long minObtainMethodId;

    /** 与 avg(obtainMethodId) 映射**/
    private Long avgObtainMethodId;

    /** 与 count(obtainMethodId) 映射**/
    private Long countObtainMethodId;

    /** 与 sum(obtainMethodId) 映射**/
    private Long sumObtainMethodId;

    /** pointObtainVersion属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointObtainVersionExpression;

    /** 与 max(pointObtainVersion) 映射**/
    private Long maxPointObtainVersion;

    /** 与 min(pointObtainVersion) 映射**/
    private Long minPointObtainVersion;

    /** 与 avg(pointObtainVersion) 映射**/
    private Long avgPointObtainVersion;

    /** 与 count(pointObtainVersion) 映射**/
    private Long countPointObtainVersion;

    /** 与 sum(pointObtainVersion) 映射**/
    private Long sumPointObtainVersion;
}