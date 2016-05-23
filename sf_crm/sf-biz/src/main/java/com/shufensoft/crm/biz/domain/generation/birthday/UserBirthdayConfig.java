package com.shufensoft.crm.biz.domain.generation.birthday;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserBirthdayConfig {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 生日id@BizId */
    @BizId
    private Long birthdayActivityId;

    /** 商家id */
    private Long sellerId;

    /** 对应积分商城的商品 */
    private Long goodsId;

    /** 生日赠送积分 */
    private Long points;

    /** 关联红包活动pool_id */
    private Long poolId;

    /** 标题 */
    private String title;

    /** 关怀类别(HB-红包;gifts-礼物;points-积分;discount-生日折扣) */
    private String careType;

    /** 活动状态，unstart未开始, start开启状态;stop暂停;over结束 */
    private String status;

    /** 赠送对象(赠送对象(auto-自动选择;manual-手动选择)) */
    private String sendTarget;

    /** 限领次数 */
    private Integer getLimit;

    /** 购物折扣暗号 */
    private String secretPassword;

    /** 生日当天折扣 */
    private Double discount;

    /** 是否短信提醒(1-是;0-否) */
    private Integer remindShortMessage;

    /** 短信提醒内容 */
    private String shortMessageContent;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

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

    /** birthdayActivityId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String birthdayActivityIdExpression;

    /** 与 max(birthdayActivityId) 映射**/
    private Long maxBirthdayActivityId;

    /** 与 min(birthdayActivityId) 映射**/
    private Long minBirthdayActivityId;

    /** 与 avg(birthdayActivityId) 映射**/
    private Long avgBirthdayActivityId;

    /** 与 count(birthdayActivityId) 映射**/
    private Long countBirthdayActivityId;

    /** 与 sum(birthdayActivityId) 映射**/
    private Long sumBirthdayActivityId;

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

    /** goodsId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsIdExpression;

    /** 与 max(goodsId) 映射**/
    private Long maxGoodsId;

    /** 与 min(goodsId) 映射**/
    private Long minGoodsId;

    /** 与 avg(goodsId) 映射**/
    private Long avgGoodsId;

    /** 与 count(goodsId) 映射**/
    private Long countGoodsId;

    /** 与 sum(goodsId) 映射**/
    private Long sumGoodsId;

    /** points属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointsExpression;

    /** 与 max(points) 映射**/
    private Long maxPoints;

    /** 与 min(points) 映射**/
    private Long minPoints;

    /** 与 avg(points) 映射**/
    private Long avgPoints;

    /** 与 count(points) 映射**/
    private Long countPoints;

    /** 与 sum(points) 映射**/
    private Long sumPoints;

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

    /** title属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String titleExpression;

    /** 与 max(title) 映射**/
    private Long maxTitle;

    /** 与 min(title) 映射**/
    private Long minTitle;

    /** 与 avg(title) 映射**/
    private Long avgTitle;

    /** 与 count(title) 映射**/
    private Long countTitle;

    /** 与 sum(title) 映射**/
    private String sumTitle;

    /** careType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String careTypeExpression;

    /** 与 max(careType) 映射**/
    private Long maxCareType;

    /** 与 min(careType) 映射**/
    private Long minCareType;

    /** 与 avg(careType) 映射**/
    private Long avgCareType;

    /** 与 count(careType) 映射**/
    private Long countCareType;

    /** 与 sum(careType) 映射**/
    private String sumCareType;

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

    /** sendTarget属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTargetExpression;

    /** 与 max(sendTarget) 映射**/
    private Long maxSendTarget;

    /** 与 min(sendTarget) 映射**/
    private Long minSendTarget;

    /** 与 avg(sendTarget) 映射**/
    private Long avgSendTarget;

    /** 与 count(sendTarget) 映射**/
    private Long countSendTarget;

    /** 与 sum(sendTarget) 映射**/
    private String sumSendTarget;

    /** getLimit属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String getLimitExpression;

    /** 与 max(getLimit) 映射**/
    private Long maxGetLimit;

    /** 与 min(getLimit) 映射**/
    private Long minGetLimit;

    /** 与 avg(getLimit) 映射**/
    private Long avgGetLimit;

    /** 与 count(getLimit) 映射**/
    private Long countGetLimit;

    /** 与 sum(getLimit) 映射**/
    private Integer sumGetLimit;

    /** secretPassword属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String secretPasswordExpression;

    /** 与 max(secretPassword) 映射**/
    private Long maxSecretPassword;

    /** 与 min(secretPassword) 映射**/
    private Long minSecretPassword;

    /** 与 avg(secretPassword) 映射**/
    private Long avgSecretPassword;

    /** 与 count(secretPassword) 映射**/
    private Long countSecretPassword;

    /** 与 sum(secretPassword) 映射**/
    private String sumSecretPassword;

    /** discount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String discountExpression;

    /** 与 max(discount) 映射**/
    private Long maxDiscount;

    /** 与 min(discount) 映射**/
    private Long minDiscount;

    /** 与 avg(discount) 映射**/
    private Long avgDiscount;

    /** 与 count(discount) 映射**/
    private Long countDiscount;

    /** 与 sum(discount) 映射**/
    private Double sumDiscount;

    /** remindShortMessage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String remindShortMessageExpression;

    /** 与 max(remindShortMessage) 映射**/
    private Long maxRemindShortMessage;

    /** 与 min(remindShortMessage) 映射**/
    private Long minRemindShortMessage;

    /** 与 avg(remindShortMessage) 映射**/
    private Long avgRemindShortMessage;

    /** 与 count(remindShortMessage) 映射**/
    private Long countRemindShortMessage;

    /** 与 sum(remindShortMessage) 映射**/
    private Integer sumRemindShortMessage;

    /** shortMessageContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shortMessageContentExpression;

    /** 与 max(shortMessageContent) 映射**/
    private Long maxShortMessageContent;

    /** 与 min(shortMessageContent) 映射**/
    private Long minShortMessageContent;

    /** 与 avg(shortMessageContent) 映射**/
    private Long avgShortMessageContent;

    /** 与 count(shortMessageContent) 映射**/
    private Long countShortMessageContent;

    /** 与 sum(shortMessageContent) 映射**/
    private String sumShortMessageContent;

    /** startTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String startTimeExpression;

    /** 与 max(startTime) 映射**/
    private Long maxStartTime;

    /** 与 min(startTime) 映射**/
    private Long minStartTime;

    /** 与 avg(startTime) 映射**/
    private Long avgStartTime;

    /** 与 count(startTime) 映射**/
    private Long countStartTime;

    /** 与 sum(startTime) 映射**/
    private Date sumStartTime;

    /** endTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endTimeExpression;

    /** 与 max(endTime) 映射**/
    private Long maxEndTime;

    /** 与 min(endTime) 映射**/
    private Long minEndTime;

    /** 与 avg(endTime) 映射**/
    private Long avgEndTime;

    /** 与 count(endTime) 映射**/
    private Long countEndTime;

    /** 与 sum(endTime) 映射**/
    private Date sumEndTime;
}