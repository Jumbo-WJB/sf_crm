package com.shufensoft.crm.biz.domain.generation.shake;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ShakeObtain {
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

    /** 摇一摇标题 */
    private String rockTitle;

    /** 摇一摇结果 */
    private String rockResult;

    /** 摇一摇类型 */
    private String rockType;

    /** 状态 */
    private String shakeStatus;

    /** 摇到时间 */
    private Date shakeDate;

    /**  */
    private Long rockId;

    /**  */
    private Long obtainId;

    /**  */
    private Date obtainDate;

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

    /** rockTitle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String rockTitleExpression;

    /** 与 max(rockTitle) 映射**/
    private Long maxRockTitle;

    /** 与 min(rockTitle) 映射**/
    private Long minRockTitle;

    /** 与 avg(rockTitle) 映射**/
    private Long avgRockTitle;

    /** 与 count(rockTitle) 映射**/
    private Long countRockTitle;

    /** 与 sum(rockTitle) 映射**/
    private String sumRockTitle;

    /** rockResult属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String rockResultExpression;

    /** 与 max(rockResult) 映射**/
    private Long maxRockResult;

    /** 与 min(rockResult) 映射**/
    private Long minRockResult;

    /** 与 avg(rockResult) 映射**/
    private Long avgRockResult;

    /** 与 count(rockResult) 映射**/
    private Long countRockResult;

    /** 与 sum(rockResult) 映射**/
    private String sumRockResult;

    /** rockType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String rockTypeExpression;

    /** 与 max(rockType) 映射**/
    private Long maxRockType;

    /** 与 min(rockType) 映射**/
    private Long minRockType;

    /** 与 avg(rockType) 映射**/
    private Long avgRockType;

    /** 与 count(rockType) 映射**/
    private Long countRockType;

    /** 与 sum(rockType) 映射**/
    private String sumRockType;

    /** shakeStatus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shakeStatusExpression;

    /** 与 max(shakeStatus) 映射**/
    private Long maxShakeStatus;

    /** 与 min(shakeStatus) 映射**/
    private Long minShakeStatus;

    /** 与 avg(shakeStatus) 映射**/
    private Long avgShakeStatus;

    /** 与 count(shakeStatus) 映射**/
    private Long countShakeStatus;

    /** 与 sum(shakeStatus) 映射**/
    private String sumShakeStatus;

    /** shakeDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shakeDateExpression;

    /** 与 max(shakeDate) 映射**/
    private Long maxShakeDate;

    /** 与 min(shakeDate) 映射**/
    private Long minShakeDate;

    /** 与 avg(shakeDate) 映射**/
    private Long avgShakeDate;

    /** 与 count(shakeDate) 映射**/
    private Long countShakeDate;

    /** 与 sum(shakeDate) 映射**/
    private Date sumShakeDate;

    /** rockId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String rockIdExpression;

    /** 与 max(rockId) 映射**/
    private Long maxRockId;

    /** 与 min(rockId) 映射**/
    private Long minRockId;

    /** 与 avg(rockId) 映射**/
    private Long avgRockId;

    /** 与 count(rockId) 映射**/
    private Long countRockId;

    /** 与 sum(rockId) 映射**/
    private Long sumRockId;

    /** obtainId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainIdExpression;

    /** 与 max(obtainId) 映射**/
    private Long maxObtainId;

    /** 与 min(obtainId) 映射**/
    private Long minObtainId;

    /** 与 avg(obtainId) 映射**/
    private Long avgObtainId;

    /** 与 count(obtainId) 映射**/
    private Long countObtainId;

    /** 与 sum(obtainId) 映射**/
    private Long sumObtainId;

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