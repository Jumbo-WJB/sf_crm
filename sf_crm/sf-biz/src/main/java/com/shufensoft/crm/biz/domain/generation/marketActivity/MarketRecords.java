package com.shufensoft.crm.biz.domain.generation.marketActivity;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MarketRecords {
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

    /** 营销活动Id */
    private Long activityId;

    /** 用户Id */
    private Long userId;

    /** 营销方案主题 */
    private String activityTitle;

    /** 用户手机号码 */
    private String mobile;

    /** 用户的邮箱 */
    private String email;

    /** 是否发送成功，0:失败；1:成功 */
    private String isSuccess;

    /** 标示邮件是否打开：默认为0 */
    private String isOpen;

    /**  */
    private String type;

    /**  */
    private Date executeTime;

    /**  */
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

    /** 与 sum(activityId) 映射**/
    private Long sumActivityId;

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

    /** activityTitle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityTitleExpression;

    /** 与 max(activityTitle) 映射**/
    private Long maxActivityTitle;

    /** 与 min(activityTitle) 映射**/
    private Long minActivityTitle;

    /** 与 avg(activityTitle) 映射**/
    private Long avgActivityTitle;

    /** 与 count(activityTitle) 映射**/
    private Long countActivityTitle;

    /** 与 sum(activityTitle) 映射**/
    private String sumActivityTitle;

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

    /** email属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailExpression;

    /** 与 max(email) 映射**/
    private Long maxEmail;

    /** 与 min(email) 映射**/
    private Long minEmail;

    /** 与 avg(email) 映射**/
    private Long avgEmail;

    /** 与 count(email) 映射**/
    private Long countEmail;

    /** 与 sum(email) 映射**/
    private String sumEmail;

    /** isSuccess属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isSuccessExpression;

    /** 与 max(isSuccess) 映射**/
    private Long maxIsSuccess;

    /** 与 min(isSuccess) 映射**/
    private Long minIsSuccess;

    /** 与 avg(isSuccess) 映射**/
    private Long avgIsSuccess;

    /** 与 count(isSuccess) 映射**/
    private Long countIsSuccess;

    /** 与 sum(isSuccess) 映射**/
    private String sumIsSuccess;

    /** isOpen属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isOpenExpression;

    /** 与 max(isOpen) 映射**/
    private Long maxIsOpen;

    /** 与 min(isOpen) 映射**/
    private Long minIsOpen;

    /** 与 avg(isOpen) 映射**/
    private Long avgIsOpen;

    /** 与 count(isOpen) 映射**/
    private Long countIsOpen;

    /** 与 sum(isOpen) 映射**/
    private String sumIsOpen;

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

    /** executeTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String executeTimeExpression;

    /** 与 max(executeTime) 映射**/
    private Long maxExecuteTime;

    /** 与 min(executeTime) 映射**/
    private Long minExecuteTime;

    /** 与 avg(executeTime) 映射**/
    private Long avgExecuteTime;

    /** 与 count(executeTime) 映射**/
    private Long countExecuteTime;

    /** 与 sum(executeTime) 映射**/
    private Date sumExecuteTime;

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