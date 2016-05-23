package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MarketPackage {
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

    /** 套餐ID,作为@bizid */
    @BizId
    private String packageId;

    /** 套餐包名 */
    private String packageName;

    /** 套餐类型：SMS：短信；EMAIL:邮件 */
    private String packageType;

    /** 套餐包数量总数 */
    private Integer packageCount;

    /** 套餐费用(单位：分) */
    private Integer packageFee;

    /** 赠送数量 */
    private Integer packageFree;

    /** 套餐描述 */
    private String packageDesc;

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

    /** packageId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageIdExpression;

    /** 与 max(packageId) 映射**/
    private Long maxPackageId;

    /** 与 min(packageId) 映射**/
    private Long minPackageId;

    /** 与 avg(packageId) 映射**/
    private Long avgPackageId;

    /** 与 count(packageId) 映射**/
    private Long countPackageId;

    /** 与 sum(packageId) 映射**/
    private String sumPackageId;

    /** packageName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageNameExpression;

    /** 与 max(packageName) 映射**/
    private Long maxPackageName;

    /** 与 min(packageName) 映射**/
    private Long minPackageName;

    /** 与 avg(packageName) 映射**/
    private Long avgPackageName;

    /** 与 count(packageName) 映射**/
    private Long countPackageName;

    /** 与 sum(packageName) 映射**/
    private String sumPackageName;

    /** packageType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageTypeExpression;

    /** 与 max(packageType) 映射**/
    private Long maxPackageType;

    /** 与 min(packageType) 映射**/
    private Long minPackageType;

    /** 与 avg(packageType) 映射**/
    private Long avgPackageType;

    /** 与 count(packageType) 映射**/
    private Long countPackageType;

    /** 与 sum(packageType) 映射**/
    private String sumPackageType;

    /** packageCount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageCountExpression;

    /** 与 max(packageCount) 映射**/
    private Long maxPackageCount;

    /** 与 min(packageCount) 映射**/
    private Long minPackageCount;

    /** 与 avg(packageCount) 映射**/
    private Long avgPackageCount;

    /** 与 count(packageCount) 映射**/
    private Long countPackageCount;

    /** 与 sum(packageCount) 映射**/
    private Integer sumPackageCount;

    /** packageFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageFeeExpression;

    /** 与 max(packageFee) 映射**/
    private Long maxPackageFee;

    /** 与 min(packageFee) 映射**/
    private Long minPackageFee;

    /** 与 avg(packageFee) 映射**/
    private Long avgPackageFee;

    /** 与 count(packageFee) 映射**/
    private Long countPackageFee;

    /** 与 sum(packageFee) 映射**/
    private Integer sumPackageFee;

    /** packageFree属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageFreeExpression;

    /** 与 max(packageFree) 映射**/
    private Long maxPackageFree;

    /** 与 min(packageFree) 映射**/
    private Long minPackageFree;

    /** 与 avg(packageFree) 映射**/
    private Long avgPackageFree;

    /** 与 count(packageFree) 映射**/
    private Long countPackageFree;

    /** 与 sum(packageFree) 映射**/
    private Integer sumPackageFree;

    /** packageDesc属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageDescExpression;

    /** 与 max(packageDesc) 映射**/
    private Long maxPackageDesc;

    /** 与 min(packageDesc) 映射**/
    private Long minPackageDesc;

    /** 与 avg(packageDesc) 映射**/
    private Long avgPackageDesc;

    /** 与 count(packageDesc) 映射**/
    private Long countPackageDesc;

    /** 与 sum(packageDesc) 映射**/
    private String sumPackageDesc;
}