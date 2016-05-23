package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserValidate {
    /** 自增主键 */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否逻辑上被删除0:未删除1:删除 */
    private String isDeleted;

    /** 微信openid */
    private String openid;

    /** 验证手机号 */
    private String mobile;

    /** 手机验证码 */
    private String code;

    /** 验证时间 */
    private Date validateDate;

    /** 是否验证成功0:失败1:成功 */
    private String result;

    /** 验证成功返回的user_id */
    private Long userId;

    /** 是否验证 0:未验证 1：已验证 */
    private String status;

    /** 验证码失效时间 */
    private Integer invalidTime;

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

    /** openid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String openidExpression;

    /** 与 max(openid) 映射**/
    private Long maxOpenid;

    /** 与 min(openid) 映射**/
    private Long minOpenid;

    /** 与 avg(openid) 映射**/
    private Long avgOpenid;

    /** 与 count(openid) 映射**/
    private Long countOpenid;

    /** 与 sum(openid) 映射**/
    private String sumOpenid;

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

    /** code属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String codeExpression;

    /** 与 max(code) 映射**/
    private Long maxCode;

    /** 与 min(code) 映射**/
    private Long minCode;

    /** 与 avg(code) 映射**/
    private Long avgCode;

    /** 与 count(code) 映射**/
    private Long countCode;

    /** 与 sum(code) 映射**/
    private String sumCode;

    /** validateDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String validateDateExpression;

    /** 与 max(validateDate) 映射**/
    private Long maxValidateDate;

    /** 与 min(validateDate) 映射**/
    private Long minValidateDate;

    /** 与 avg(validateDate) 映射**/
    private Long avgValidateDate;

    /** 与 count(validateDate) 映射**/
    private Long countValidateDate;

    /** 与 sum(validateDate) 映射**/
    private Date sumValidateDate;

    /** result属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String resultExpression;

    /** 与 max(result) 映射**/
    private Long maxResult;

    /** 与 min(result) 映射**/
    private Long minResult;

    /** 与 avg(result) 映射**/
    private Long avgResult;

    /** 与 count(result) 映射**/
    private Long countResult;

    /** 与 sum(result) 映射**/
    private String sumResult;

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

    /** invalidTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String invalidTimeExpression;

    /** 与 max(invalidTime) 映射**/
    private Long maxInvalidTime;

    /** 与 min(invalidTime) 映射**/
    private Long minInvalidTime;

    /** 与 avg(invalidTime) 映射**/
    private Long avgInvalidTime;

    /** 与 count(invalidTime) 映射**/
    private Long countInvalidTime;

    /** 与 sum(invalidTime) 映射**/
    private Integer sumInvalidTime;

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