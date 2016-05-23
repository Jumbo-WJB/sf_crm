package com.shufensoft.crm.biz.domain.generation.hongbao;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class HBObtain {
    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 领取ID,作为@BizId */
    @BizId
    private Long hongbaoObtainId;

    /** 用户ID */
    private Long userId;

    /** 金额 分为单位 */
    private Long amount;

    /** openid */
    private String openId;

    /** 红包类型：common 普通红包, praise 好评返红包, point_exchange 积分兑换红包,shake 摇一摇红包,birthday 生日红包 */
    private String hongbaoType;

    /** 红包池ID */
    private Long poolId;

    /** 红包池名称冗余字段 */
    private String poolName;

    /** 领取时间 */
    private Date obtainDatatime;

    /** 红包key便于查询 */
    private String amountRange;

    /** 红包领用快递单号 */
    private String obtainPostNumber;

    /** toReceive 待领取  received 已领取 */
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

    /** 与 count(distinctid) 映射**/
    private Long countDistinctId;

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

    /** 与 count(distinctgmtCreated) 映射**/
    private Long countDistinctGmtCreated;

    /** 与 sum(gmtCreated) 映射**/
    private Date sumGmtCreated;

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

    /** 与 count(distinctcreatedBy) 映射**/
    private Long countDistinctCreatedBy;

    /** 与 sum(createdBy) 映射**/
    private String sumCreatedBy;

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

    /** 与 count(distinctgmtModified) 映射**/
    private Long countDistinctGmtModified;

    /** 与 sum(gmtModified) 映射**/
    private Date sumGmtModified;

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

    /** 与 count(distinctmodifiedBy) 映射**/
    private Long countDistinctModifiedBy;

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

    /** 与 count(distinctisDeleted) 映射**/
    private Long countDistinctIsDeleted;

    /** 与 sum(isDeleted) 映射**/
    private String sumIsDeleted;

    /** hongbaoObtainId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoObtainIdExpression;

    /** 与 max(hongbaoObtainId) 映射**/
    private Long maxHongbaoObtainId;

    /** 与 min(hongbaoObtainId) 映射**/
    private Long minHongbaoObtainId;

    /** 与 avg(hongbaoObtainId) 映射**/
    private Long avgHongbaoObtainId;

    /** 与 count(hongbaoObtainId) 映射**/
    private Long countHongbaoObtainId;

    /** 与 count(distincthongbaoObtainId) 映射**/
    private Long countDistinctHongbaoObtainId;

    /** 与 sum(hongbaoObtainId) 映射**/
    private Long sumHongbaoObtainId;

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

    /** 与 count(distinctuserId) 映射**/
    private Long countDistinctUserId;

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

    /** 与 count(distinctamount) 映射**/
    private Long countDistinctAmount;

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

    /** 与 count(distinctopenId) 映射**/
    private Long countDistinctOpenId;

    /** 与 sum(openId) 映射**/
    private String sumOpenId;

    /** hongbaoType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoTypeExpression;

    /** 与 max(hongbaoType) 映射**/
    private Long maxHongbaoType;

    /** 与 min(hongbaoType) 映射**/
    private Long minHongbaoType;

    /** 与 avg(hongbaoType) 映射**/
    private Long avgHongbaoType;

    /** 与 count(hongbaoType) 映射**/
    private Long countHongbaoType;

    /** 与 count(distincthongbaoType) 映射**/
    private Long countDistinctHongbaoType;

    /** 与 sum(hongbaoType) 映射**/
    private String sumHongbaoType;

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

    /** 与 count(distinctpoolId) 映射**/
    private Long countDistinctPoolId;

    /** 与 sum(poolId) 映射**/
    private Long sumPoolId;

    /** poolName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String poolNameExpression;

    /** 与 max(poolName) 映射**/
    private Long maxPoolName;

    /** 与 min(poolName) 映射**/
    private Long minPoolName;

    /** 与 avg(poolName) 映射**/
    private Long avgPoolName;

    /** 与 count(poolName) 映射**/
    private Long countPoolName;

    /** 与 count(distinctpoolName) 映射**/
    private Long countDistinctPoolName;

    /** 与 sum(poolName) 映射**/
    private String sumPoolName;

    /** obtainDatatime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainDatatimeExpression;

    /** 与 max(obtainDatatime) 映射**/
    private Long maxObtainDatatime;

    /** 与 min(obtainDatatime) 映射**/
    private Long minObtainDatatime;

    /** 与 avg(obtainDatatime) 映射**/
    private Long avgObtainDatatime;

    /** 与 count(obtainDatatime) 映射**/
    private Long countObtainDatatime;

    /** 与 count(distinctobtainDatatime) 映射**/
    private Long countDistinctObtainDatatime;

    /** 与 sum(obtainDatatime) 映射**/
    private Date sumObtainDatatime;

    /** amountRange属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountRangeExpression;

    /** 与 max(amountRange) 映射**/
    private Long maxAmountRange;

    /** 与 min(amountRange) 映射**/
    private Long minAmountRange;

    /** 与 avg(amountRange) 映射**/
    private Long avgAmountRange;

    /** 与 count(amountRange) 映射**/
    private Long countAmountRange;

    /** 与 count(distinctamountRange) 映射**/
    private Long countDistinctAmountRange;

    /** 与 sum(amountRange) 映射**/
    private String sumAmountRange;

    /** obtainPostNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainPostNumberExpression;

    /** 与 max(obtainPostNumber) 映射**/
    private Long maxObtainPostNumber;

    /** 与 min(obtainPostNumber) 映射**/
    private Long minObtainPostNumber;

    /** 与 avg(obtainPostNumber) 映射**/
    private Long avgObtainPostNumber;

    /** 与 count(obtainPostNumber) 映射**/
    private Long countObtainPostNumber;

    /** 与 count(distinctobtainPostNumber) 映射**/
    private Long countDistinctObtainPostNumber;

    /** 与 sum(obtainPostNumber) 映射**/
    private String sumObtainPostNumber;

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

    /** 与 count(distinctstatus) 映射**/
    private Long countDistinctStatus;

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

    /** 与 count(distinctsellerId) 映射**/
    private Long countDistinctSellerId;

    /** 与 sum(sellerId) 映射**/
    private Long sumSellerId;
}