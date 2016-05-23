package com.shufensoft.crm.biz.domain.generation.hongbao;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class HBPool {
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

    /** 红包活动id ,作为@BizId */
    @BizId
    private Long poolId;

    /** 开始时间 */
    private Date startDate;

    /** 结束时间 */
    private Date endDate;

    /** 配置规则id */
    private Long ruleConfigId;

    /** 红包活动名称 */
    private String name;

    /** 红包个数 */
    private Long number;

    /** 已领个数 */
    private Long numberObtain;

    /** 配置 regular：规则设置Irregular:不规则设置 */
    private String config;

    /** 状态 unBoundd:未关联unReceived:待领取，receiving：领取中done:结束 */
    private String states;

    /** 红包类别：yyy 摇一摇 jfth 积分兑换gjc 关键词领取 */
    private String type;

    /** 红包总金额 */
    private Long totalAmount;

    /** 红包领取金额 */
    private Long obtainAmount;

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

    /** startDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String startDateExpression;

    /** 与 max(startDate) 映射**/
    private Long maxStartDate;

    /** 与 min(startDate) 映射**/
    private Long minStartDate;

    /** 与 avg(startDate) 映射**/
    private Long avgStartDate;

    /** 与 count(startDate) 映射**/
    private Long countStartDate;

    /** 与 sum(startDate) 映射**/
    private Date sumStartDate;

    /** endDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endDateExpression;

    /** 与 max(endDate) 映射**/
    private Long maxEndDate;

    /** 与 min(endDate) 映射**/
    private Long minEndDate;

    /** 与 avg(endDate) 映射**/
    private Long avgEndDate;

    /** 与 count(endDate) 映射**/
    private Long countEndDate;

    /** 与 sum(endDate) 映射**/
    private Date sumEndDate;

    /** ruleConfigId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String ruleConfigIdExpression;

    /** 与 max(ruleConfigId) 映射**/
    private Long maxRuleConfigId;

    /** 与 min(ruleConfigId) 映射**/
    private Long minRuleConfigId;

    /** 与 avg(ruleConfigId) 映射**/
    private Long avgRuleConfigId;

    /** 与 count(ruleConfigId) 映射**/
    private Long countRuleConfigId;

    /** 与 sum(ruleConfigId) 映射**/
    private Long sumRuleConfigId;

    /** name属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nameExpression;

    /** 与 max(name) 映射**/
    private Long maxName;

    /** 与 min(name) 映射**/
    private Long minName;

    /** 与 avg(name) 映射**/
    private Long avgName;

    /** 与 count(name) 映射**/
    private Long countName;

    /** 与 sum(name) 映射**/
    private String sumName;

    /** number属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numberExpression;

    /** 与 max(number) 映射**/
    private Long maxNumber;

    /** 与 min(number) 映射**/
    private Long minNumber;

    /** 与 avg(number) 映射**/
    private Long avgNumber;

    /** 与 count(number) 映射**/
    private Long countNumber;

    /** 与 sum(number) 映射**/
    private Long sumNumber;

    /** numberObtain属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numberObtainExpression;

    /** 与 max(numberObtain) 映射**/
    private Long maxNumberObtain;

    /** 与 min(numberObtain) 映射**/
    private Long minNumberObtain;

    /** 与 avg(numberObtain) 映射**/
    private Long avgNumberObtain;

    /** 与 count(numberObtain) 映射**/
    private Long countNumberObtain;

    /** 与 sum(numberObtain) 映射**/
    private Long sumNumberObtain;

    /** config属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String configExpression;

    /** 与 max(config) 映射**/
    private Long maxConfig;

    /** 与 min(config) 映射**/
    private Long minConfig;

    /** 与 avg(config) 映射**/
    private Long avgConfig;

    /** 与 count(config) 映射**/
    private Long countConfig;

    /** 与 sum(config) 映射**/
    private String sumConfig;

    /** states属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statesExpression;

    /** 与 max(states) 映射**/
    private Long maxStates;

    /** 与 min(states) 映射**/
    private Long minStates;

    /** 与 avg(states) 映射**/
    private Long avgStates;

    /** 与 count(states) 映射**/
    private Long countStates;

    /** 与 sum(states) 映射**/
    private String sumStates;

    /** type属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String typeExpression;

    /** 与 max(type) 映射**/
    private Long maxType;

    /** 与 min(type) 映射**/
    private Long minType;

    /** 与 avg(type) 映射**/
    private Long avgType;

    /** 与 count(type) 映射**/
    private Long countType;

    /** 与 sum(type) 映射**/
    private String sumType;

    /** totalAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String totalAmountExpression;

    /** 与 max(totalAmount) 映射**/
    private Long maxTotalAmount;

    /** 与 min(totalAmount) 映射**/
    private Long minTotalAmount;

    /** 与 avg(totalAmount) 映射**/
    private Long avgTotalAmount;

    /** 与 count(totalAmount) 映射**/
    private Long countTotalAmount;

    /** 与 sum(totalAmount) 映射**/
    private Long sumTotalAmount;

    /** obtainAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainAmountExpression;

    /** 与 max(obtainAmount) 映射**/
    private Long maxObtainAmount;

    /** 与 min(obtainAmount) 映射**/
    private Long minObtainAmount;

    /** 与 avg(obtainAmount) 映射**/
    private Long avgObtainAmount;

    /** 与 count(obtainAmount) 映射**/
    private Long countObtainAmount;

    /** 与 sum(obtainAmount) 映射**/
    private Long sumObtainAmount;
}