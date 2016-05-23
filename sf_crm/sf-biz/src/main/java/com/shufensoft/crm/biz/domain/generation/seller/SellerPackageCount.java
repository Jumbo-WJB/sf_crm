package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SellerPackageCount {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 0	是否逻辑上被删除 */
    private String isDeleted;

    /** 商户ID */
    private String sellerId;

    /** 商户套餐余额 */
    private Long sellerPackageRemain;

    /** 商户套餐总数 */
    private Long sellerPackageTotal;

    /** 商户套餐已使用数 */
    private Long sellerPackageUsed;

    /** 商户套餐过期数 */
    private Long sellerPackageExpired;

    /** 版本号，用于乐观锁 */
    private Long sellerPackageVersion;

    /** 套餐类型，SMS:短信，MAIL：邮件 */
    private String sellerPackageType;

    /**  */
    private Integer sendTimes;

    /**  */
    private Integer sendSucRate;

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
    private String sumSellerId;

    /** sellerPackageRemain属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageRemainExpression;

    /** 与 max(sellerPackageRemain) 映射**/
    private Long maxSellerPackageRemain;

    /** 与 min(sellerPackageRemain) 映射**/
    private Long minSellerPackageRemain;

    /** 与 avg(sellerPackageRemain) 映射**/
    private Long avgSellerPackageRemain;

    /** 与 count(sellerPackageRemain) 映射**/
    private Long countSellerPackageRemain;

    /** 与 sum(sellerPackageRemain) 映射**/
    private Long sumSellerPackageRemain;

    /** sellerPackageTotal属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageTotalExpression;

    /** 与 max(sellerPackageTotal) 映射**/
    private Long maxSellerPackageTotal;

    /** 与 min(sellerPackageTotal) 映射**/
    private Long minSellerPackageTotal;

    /** 与 avg(sellerPackageTotal) 映射**/
    private Long avgSellerPackageTotal;

    /** 与 count(sellerPackageTotal) 映射**/
    private Long countSellerPackageTotal;

    /** 与 sum(sellerPackageTotal) 映射**/
    private Long sumSellerPackageTotal;

    /** sellerPackageUsed属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageUsedExpression;

    /** 与 max(sellerPackageUsed) 映射**/
    private Long maxSellerPackageUsed;

    /** 与 min(sellerPackageUsed) 映射**/
    private Long minSellerPackageUsed;

    /** 与 avg(sellerPackageUsed) 映射**/
    private Long avgSellerPackageUsed;

    /** 与 count(sellerPackageUsed) 映射**/
    private Long countSellerPackageUsed;

    /** 与 sum(sellerPackageUsed) 映射**/
    private Long sumSellerPackageUsed;

    /** sellerPackageExpired属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageExpiredExpression;

    /** 与 max(sellerPackageExpired) 映射**/
    private Long maxSellerPackageExpired;

    /** 与 min(sellerPackageExpired) 映射**/
    private Long minSellerPackageExpired;

    /** 与 avg(sellerPackageExpired) 映射**/
    private Long avgSellerPackageExpired;

    /** 与 count(sellerPackageExpired) 映射**/
    private Long countSellerPackageExpired;

    /** 与 sum(sellerPackageExpired) 映射**/
    private Long sumSellerPackageExpired;

    /** sellerPackageVersion属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageVersionExpression;

    /** 与 max(sellerPackageVersion) 映射**/
    private Long maxSellerPackageVersion;

    /** 与 min(sellerPackageVersion) 映射**/
    private Long minSellerPackageVersion;

    /** 与 avg(sellerPackageVersion) 映射**/
    private Long avgSellerPackageVersion;

    /** 与 count(sellerPackageVersion) 映射**/
    private Long countSellerPackageVersion;

    /** 与 sum(sellerPackageVersion) 映射**/
    private Long sumSellerPackageVersion;

    /** sellerPackageType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPackageTypeExpression;

    /** 与 max(sellerPackageType) 映射**/
    private Long maxSellerPackageType;

    /** 与 min(sellerPackageType) 映射**/
    private Long minSellerPackageType;

    /** 与 avg(sellerPackageType) 映射**/
    private Long avgSellerPackageType;

    /** 与 count(sellerPackageType) 映射**/
    private Long countSellerPackageType;

    /** 与 sum(sellerPackageType) 映射**/
    private String sumSellerPackageType;

    /** sendTimes属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTimesExpression;

    /** 与 max(sendTimes) 映射**/
    private Long maxSendTimes;

    /** 与 min(sendTimes) 映射**/
    private Long minSendTimes;

    /** 与 avg(sendTimes) 映射**/
    private Long avgSendTimes;

    /** 与 count(sendTimes) 映射**/
    private Long countSendTimes;

    /** 与 sum(sendTimes) 映射**/
    private Integer sumSendTimes;

    /** sendSucRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendSucRateExpression;

    /** 与 max(sendSucRate) 映射**/
    private Long maxSendSucRate;

    /** 与 min(sendSucRate) 映射**/
    private Long minSendSucRate;

    /** 与 avg(sendSucRate) 映射**/
    private Long avgSendSucRate;

    /** 与 count(sendSucRate) 映射**/
    private Long countSendSucRate;

    /** 与 sum(sendSucRate) 映射**/
    private Integer sumSendSucRate;
}