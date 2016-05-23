package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserInteractionStatistic {
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

    /** 用户id */
    private Long userId;

    /** 互动业务id */
    private Long bizId;

    /** user:用户维度;biz:业务维度（可以同时两个维度） */
    private String dimType;

    /**  第一次互动时间 */
    private Date firstInteractionTime;

    /** 最后一次互动时间 */
    private Date lastInteractionTime;

    /** 互动类型: EXCHANGE_GOODS:积分兑换商品,EXCHANGE_HONGBAO:积分兑换红包，SHIPPING_SEARCH:物流查询，GAME:游戏, DIAN_ZAN:点赞 */
    private String interactionType;

    /** 互动入口（主要针对微信）:LINK:链接;SHAKE:遥一遥;KEY_WORD：关键字 */
    private String interactionEntry;

    /** 互动的一些主体属性json格式 */
    private String interactionStat;

    /** 商家id */
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

    /** bizId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String bizIdExpression;

    /** 与 max(bizId) 映射**/
    private Long maxBizId;

    /** 与 min(bizId) 映射**/
    private Long minBizId;

    /** 与 avg(bizId) 映射**/
    private Long avgBizId;

    /** 与 count(bizId) 映射**/
    private Long countBizId;

    /** 与 sum(bizId) 映射**/
    private Long sumBizId;

    /** dimType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String dimTypeExpression;

    /** 与 max(dimType) 映射**/
    private Long maxDimType;

    /** 与 min(dimType) 映射**/
    private Long minDimType;

    /** 与 avg(dimType) 映射**/
    private Long avgDimType;

    /** 与 count(dimType) 映射**/
    private Long countDimType;

    /** 与 sum(dimType) 映射**/
    private String sumDimType;

    /** firstInteractionTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String firstInteractionTimeExpression;

    /** 与 max(firstInteractionTime) 映射**/
    private Long maxFirstInteractionTime;

    /** 与 min(firstInteractionTime) 映射**/
    private Long minFirstInteractionTime;

    /** 与 avg(firstInteractionTime) 映射**/
    private Long avgFirstInteractionTime;

    /** 与 count(firstInteractionTime) 映射**/
    private Long countFirstInteractionTime;

    /** 与 sum(firstInteractionTime) 映射**/
    private Date sumFirstInteractionTime;

    /** lastInteractionTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String lastInteractionTimeExpression;

    /** 与 max(lastInteractionTime) 映射**/
    private Long maxLastInteractionTime;

    /** 与 min(lastInteractionTime) 映射**/
    private Long minLastInteractionTime;

    /** 与 avg(lastInteractionTime) 映射**/
    private Long avgLastInteractionTime;

    /** 与 count(lastInteractionTime) 映射**/
    private Long countLastInteractionTime;

    /** 与 sum(lastInteractionTime) 映射**/
    private Date sumLastInteractionTime;

    /** interactionType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String interactionTypeExpression;

    /** 与 max(interactionType) 映射**/
    private Long maxInteractionType;

    /** 与 min(interactionType) 映射**/
    private Long minInteractionType;

    /** 与 avg(interactionType) 映射**/
    private Long avgInteractionType;

    /** 与 count(interactionType) 映射**/
    private Long countInteractionType;

    /** 与 sum(interactionType) 映射**/
    private String sumInteractionType;

    /** interactionEntry属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String interactionEntryExpression;

    /** 与 max(interactionEntry) 映射**/
    private Long maxInteractionEntry;

    /** 与 min(interactionEntry) 映射**/
    private Long minInteractionEntry;

    /** 与 avg(interactionEntry) 映射**/
    private Long avgInteractionEntry;

    /** 与 count(interactionEntry) 映射**/
    private Long countInteractionEntry;

    /** 与 sum(interactionEntry) 映射**/
    private String sumInteractionEntry;

    /** interactionStat属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String interactionStatExpression;

    /** 与 max(interactionStat) 映射**/
    private Long maxInteractionStat;

    /** 与 min(interactionStat) 映射**/
    private Long minInteractionStat;

    /** 与 avg(interactionStat) 映射**/
    private Long avgInteractionStat;

    /** 与 count(interactionStat) 映射**/
    private Long countInteractionStat;

    /** 与 sum(interactionStat) 映射**/
    private String sumInteractionStat;

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