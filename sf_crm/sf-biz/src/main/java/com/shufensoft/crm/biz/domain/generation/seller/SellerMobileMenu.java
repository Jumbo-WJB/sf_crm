package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SellerMobileMenu {
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

    /** 功能类型，advertisement:广告;module:模块 */
    private String functionType;

    /** 菜单类型，indexpage:前端首页;point:积分商城 */
    private String type;

    /** 菜单名称 */
    private String name;

    /** 菜单图片地址 */
    private String url;

    /** 菜单链接地址 */
    private String link;

    /** 是否客户认证 */
    private Boolean validate;

    /** 是否需要用户授权0:不需要；1:需要 */
    private Boolean oauth;

    /** 优先级 */
    private Integer priority;

    /** 描述 */
    private String description;

    /** 是否显示其他页面0:不是1:是 */
    private String isShowOther;

    /** 是否选中:0不是1:是 */
    private String isSelect;

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

    /** functionType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String functionTypeExpression;

    /** 与 max(functionType) 映射**/
    private Long maxFunctionType;

    /** 与 min(functionType) 映射**/
    private Long minFunctionType;

    /** 与 avg(functionType) 映射**/
    private Long avgFunctionType;

    /** 与 count(functionType) 映射**/
    private Long countFunctionType;

    /** 与 sum(functionType) 映射**/
    private String sumFunctionType;

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

    /** url属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String urlExpression;

    /** 与 max(url) 映射**/
    private Long maxUrl;

    /** 与 min(url) 映射**/
    private Long minUrl;

    /** 与 avg(url) 映射**/
    private Long avgUrl;

    /** 与 count(url) 映射**/
    private Long countUrl;

    /** 与 sum(url) 映射**/
    private String sumUrl;

    /** link属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String linkExpression;

    /** 与 max(link) 映射**/
    private Long maxLink;

    /** 与 min(link) 映射**/
    private Long minLink;

    /** 与 avg(link) 映射**/
    private Long avgLink;

    /** 与 count(link) 映射**/
    private Long countLink;

    /** 与 sum(link) 映射**/
    private String sumLink;

    /** validate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String validateExpression;

    /** 与 max(validate) 映射**/
    private Long maxValidate;

    /** 与 min(validate) 映射**/
    private Long minValidate;

    /** 与 avg(validate) 映射**/
    private Long avgValidate;

    /** 与 count(validate) 映射**/
    private Long countValidate;

    /** 与 sum(validate) 映射**/
    private Boolean sumValidate;

    /** oauth属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String oauthExpression;

    /** 与 max(oauth) 映射**/
    private Long maxOauth;

    /** 与 min(oauth) 映射**/
    private Long minOauth;

    /** 与 avg(oauth) 映射**/
    private Long avgOauth;

    /** 与 count(oauth) 映射**/
    private Long countOauth;

    /** 与 sum(oauth) 映射**/
    private Boolean sumOauth;

    /** priority属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String priorityExpression;

    /** 与 max(priority) 映射**/
    private Long maxPriority;

    /** 与 min(priority) 映射**/
    private Long minPriority;

    /** 与 avg(priority) 映射**/
    private Long avgPriority;

    /** 与 count(priority) 映射**/
    private Long countPriority;

    /** 与 sum(priority) 映射**/
    private Integer sumPriority;

    /** description属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String descriptionExpression;

    /** 与 max(description) 映射**/
    private Long maxDescription;

    /** 与 min(description) 映射**/
    private Long minDescription;

    /** 与 avg(description) 映射**/
    private Long avgDescription;

    /** 与 count(description) 映射**/
    private Long countDescription;

    /** 与 sum(description) 映射**/
    private String sumDescription;

    /** isShowOther属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isShowOtherExpression;

    /** 与 max(isShowOther) 映射**/
    private Long maxIsShowOther;

    /** 与 min(isShowOther) 映射**/
    private Long minIsShowOther;

    /** 与 avg(isShowOther) 映射**/
    private Long avgIsShowOther;

    /** 与 count(isShowOther) 映射**/
    private Long countIsShowOther;

    /** 与 sum(isShowOther) 映射**/
    private String sumIsShowOther;

    /** isSelect属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isSelectExpression;

    /** 与 max(isSelect) 映射**/
    private Long maxIsSelect;

    /** 与 min(isSelect) 映射**/
    private Long minIsSelect;

    /** 与 avg(isSelect) 映射**/
    private Long avgIsSelect;

    /** 与 count(isSelect) 映射**/
    private Long countIsSelect;

    /** 与 sum(isSelect) 映射**/
    private String sumIsSelect;

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