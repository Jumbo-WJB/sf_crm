package com.shufensoft.crm.biz.domain.generation.activity;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class Activity {
    /** 主键id */
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

    /** 活动Id,@BizId */
    @BizId
    private Long activityId;

    /** 活动名称 */
    private String activityName;

    /** 活动图片地址 */
    private String activityPhotoUrl;

    /** 活动类型，如摇一摇活动(activity_shake)、生日活动(activity_birthday)、购物红包活动(activity_shopping_hongbao)等等 */
    private String activityType;

    /** 活动详细说明 */
    private String activityDesc;

    /** 活动开始日期 */
    private Date beginDate;

    /** 活动结束日期 */
    private Date endDate;

    /** 活动状态：暂停(stop)，进行中(progressing )，已结束(end)，开启(start) */
    private String status;

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

    /** activityId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityIdExpression;

    /** 与 max(activityId) 映射**/
    private Long maxActivityId;

    /** 与 min(activityId) 映射**/
    private Long minActivityId;

    /** 与 avg(activityId) 映射**/
    private Long avgActivityId;

    /** 与 count(activityId) 映射**/
    private Long countActivityId;

    /** 与 count(distinctactivityId) 映射**/
    private Long countDistinctActivityId;

    /** 与 sum(activityId) 映射**/
    private Long sumActivityId;

    /** activityName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityNameExpression;

    /** 与 max(activityName) 映射**/
    private Long maxActivityName;

    /** 与 min(activityName) 映射**/
    private Long minActivityName;

    /** 与 avg(activityName) 映射**/
    private Long avgActivityName;

    /** 与 count(activityName) 映射**/
    private Long countActivityName;

    /** 与 count(distinctactivityName) 映射**/
    private Long countDistinctActivityName;

    /** 与 sum(activityName) 映射**/
    private String sumActivityName;

    /** activityPhotoUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityPhotoUrlExpression;

    /** 与 max(activityPhotoUrl) 映射**/
    private Long maxActivityPhotoUrl;

    /** 与 min(activityPhotoUrl) 映射**/
    private Long minActivityPhotoUrl;

    /** 与 avg(activityPhotoUrl) 映射**/
    private Long avgActivityPhotoUrl;

    /** 与 count(activityPhotoUrl) 映射**/
    private Long countActivityPhotoUrl;

    /** 与 count(distinctactivityPhotoUrl) 映射**/
    private Long countDistinctActivityPhotoUrl;

    /** 与 sum(activityPhotoUrl) 映射**/
    private String sumActivityPhotoUrl;

    /** activityType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityTypeExpression;

    /** 与 max(activityType) 映射**/
    private Long maxActivityType;

    /** 与 min(activityType) 映射**/
    private Long minActivityType;

    /** 与 avg(activityType) 映射**/
    private Long avgActivityType;

    /** 与 count(activityType) 映射**/
    private Long countActivityType;

    /** 与 count(distinctactivityType) 映射**/
    private Long countDistinctActivityType;

    /** 与 sum(activityType) 映射**/
    private String sumActivityType;

    /** activityDesc属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityDescExpression;

    /** 与 max(activityDesc) 映射**/
    private Long maxActivityDesc;

    /** 与 min(activityDesc) 映射**/
    private Long minActivityDesc;

    /** 与 avg(activityDesc) 映射**/
    private Long avgActivityDesc;

    /** 与 count(activityDesc) 映射**/
    private Long countActivityDesc;

    /** 与 count(distinctactivityDesc) 映射**/
    private Long countDistinctActivityDesc;

    /** 与 sum(activityDesc) 映射**/
    private String sumActivityDesc;

    /** beginDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String beginDateExpression;

    /** 与 max(beginDate) 映射**/
    private Long maxBeginDate;

    /** 与 min(beginDate) 映射**/
    private Long minBeginDate;

    /** 与 avg(beginDate) 映射**/
    private Long avgBeginDate;

    /** 与 count(beginDate) 映射**/
    private Long countBeginDate;

    /** 与 count(distinctbeginDate) 映射**/
    private Long countDistinctBeginDate;

    /** 与 sum(beginDate) 映射**/
    private Date sumBeginDate;

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

    /** 与 count(distinctendDate) 映射**/
    private Long countDistinctEndDate;

    /** 与 sum(endDate) 映射**/
    private Date sumEndDate;

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
}