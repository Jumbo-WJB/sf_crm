package com.shufensoft.crm.biz.domain.generation.hongbao;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class HBCash {
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

    /** 红包提现id,作为@BizId */
    @BizId
    private Long hongbaoCashId;

    /** 付款IP */
    private String spbillIp;

    /** 提现用户ID */
    private Long userId;

    /** 提现金额 分为单位 */
    private Long amount;

    /** openid */
    private String openId;

    /** 红包池ID */
    private Long poolId;

    /** 提现时间 */
    private Date obtainDate;

    /** y 有效  n无效 */
    private String status;

    /** 商户Id */
    private Long sellerId;

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

    /** hongbaoCashId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoCashIdExpression;

    /** 与 max(hongbaoCashId) 映射**/
    private Long maxHongbaoCashId;

    /** 与 min(hongbaoCashId) 映射**/
    private Long minHongbaoCashId;

    /** 与 avg(hongbaoCashId) 映射**/
    private Long avgHongbaoCashId;

    /** 与 count(hongbaoCashId) 映射**/
    private Long countHongbaoCashId;

    /** 与 sum(hongbaoCashId) 映射**/
    private Long sumHongbaoCashId;

    /** spbillIp属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String spbillIpExpression;

    /** 与 max(spbillIp) 映射**/
    private Long maxSpbillIp;

    /** 与 min(spbillIp) 映射**/
    private Long minSpbillIp;

    /** 与 avg(spbillIp) 映射**/
    private Long avgSpbillIp;

    /** 与 count(spbillIp) 映射**/
    private Long countSpbillIp;

    /** 与 sum(spbillIp) 映射**/
    private String sumSpbillIp;

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

    /** openId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String openIdExpression;

    /** 与 max(openId) 映射**/
    private Long maxOpenId;

    /** 与 min(openId) 映射**/
    private Long minOpenId;

    /** 与 avg(openId) 映射**/
    private Long avgOpenId;

    /** 与 count(openId) 映射**/
    private Long countOpenId;

    /** 与 sum(openId) 映射**/
    private String sumOpenId;

    /** poolId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String poolIdExpression;

    /** 与 max(poolId) 映射**/
    private Long maxPoolId;

    /** 与 min(poolId) 映射**/
    private Long minPoolId;

    /** 与 avg(poolId) 映射**/
    private Long avgPoolId;

    /** 与 count(poolId) 映射**/
    private Long countPoolId;

    /** 与 sum(poolId) 映射**/
    private Long sumPoolId;

    /** obtainDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainDateExpression;

    /** 与 max(obtainDate) 映射**/
    private Long maxObtainDate;

    /** 与 min(obtainDate) 映射**/
    private Long minObtainDate;

    /** 与 avg(obtainDate) 映射**/
    private Long avgObtainDate;

    /** 与 count(obtainDate) 映射**/
    private Long countObtainDate;

    /** 与 sum(obtainDate) 映射**/
    private Date sumObtainDate;

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
}