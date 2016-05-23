package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Domain
@Data
@ToString
public class SellerShop implements Serializable{

    private static final long serialVersionUID = -8078452976629871709L;

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

    /** 商家Id */
    private Long sellerId;

    /** 店铺Id,作为@BizId */
    @BizId
    private Long shopId;

    /** 店铺名称 */
    private String shopName;

    /** 店铺类型 TB淘宝、JD京东、YZ有赞 */
    private String shopType;

    /** 接入方式general:通用;self_development:卖家自研 */
    private String accessType;

    /** 店铺app_id */
    private String shopAppId;

    /** 店铺app_secret */
    private String shopAppSecret;

    /** 店铺access_token */
    private String shopAccessToken;

    /** 淘宝 refresh_token */
    private String shopRefreshToken;

    /** token过期时间 */
    private Date shopTokenExpire;

    /** 聚石塔url */
    private String polySpireUrl;

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

    /** shopId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopIdExpression;

    /** 与 max(shopId) 映射**/
    private Long maxShopId;

    /** 与 min(shopId) 映射**/
    private Long minShopId;

    /** 与 avg(shopId) 映射**/
    private Long avgShopId;

    /** 与 count(shopId) 映射**/
    private Long countShopId;

    /** 与 sum(shopId) 映射**/
    private Long sumShopId;

    /** shopName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopNameExpression;

    /** 与 max(shopName) 映射**/
    private Long maxShopName;

    /** 与 min(shopName) 映射**/
    private Long minShopName;

    /** 与 avg(shopName) 映射**/
    private Long avgShopName;

    /** 与 count(shopName) 映射**/
    private Long countShopName;

    /** 与 sum(shopName) 映射**/
    private String sumShopName;

    /** shopType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopTypeExpression;

    /** 与 max(shopType) 映射**/
    private Long maxShopType;

    /** 与 min(shopType) 映射**/
    private Long minShopType;

    /** 与 avg(shopType) 映射**/
    private Long avgShopType;

    /** 与 count(shopType) 映射**/
    private Long countShopType;

    /** 与 sum(shopType) 映射**/
    private String sumShopType;

    /** accessType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String accessTypeExpression;

    /** 与 max(accessType) 映射**/
    private Long maxAccessType;

    /** 与 min(accessType) 映射**/
    private Long minAccessType;

    /** 与 avg(accessType) 映射**/
    private Long avgAccessType;

    /** 与 count(accessType) 映射**/
    private Long countAccessType;

    /** 与 sum(accessType) 映射**/
    private String sumAccessType;

    /** shopAppId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopAppIdExpression;

    /** 与 max(shopAppId) 映射**/
    private Long maxShopAppId;

    /** 与 min(shopAppId) 映射**/
    private Long minShopAppId;

    /** 与 avg(shopAppId) 映射**/
    private Long avgShopAppId;

    /** 与 count(shopAppId) 映射**/
    private Long countShopAppId;

    /** 与 sum(shopAppId) 映射**/
    private String sumShopAppId;

    /** shopAppSecret属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopAppSecretExpression;

    /** 与 max(shopAppSecret) 映射**/
    private Long maxShopAppSecret;

    /** 与 min(shopAppSecret) 映射**/
    private Long minShopAppSecret;

    /** 与 avg(shopAppSecret) 映射**/
    private Long avgShopAppSecret;

    /** 与 count(shopAppSecret) 映射**/
    private Long countShopAppSecret;

    /** 与 sum(shopAppSecret) 映射**/
    private String sumShopAppSecret;

    /** shopAccessToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopAccessTokenExpression;

    /** 与 max(shopAccessToken) 映射**/
    private Long maxShopAccessToken;

    /** 与 min(shopAccessToken) 映射**/
    private Long minShopAccessToken;

    /** 与 avg(shopAccessToken) 映射**/
    private Long avgShopAccessToken;

    /** 与 count(shopAccessToken) 映射**/
    private Long countShopAccessToken;

    /** 与 sum(shopAccessToken) 映射**/
    private String sumShopAccessToken;

    /** shopRefreshToken属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopRefreshTokenExpression;

    /** 与 max(shopRefreshToken) 映射**/
    private Long maxShopRefreshToken;

    /** 与 min(shopRefreshToken) 映射**/
    private Long minShopRefreshToken;

    /** 与 avg(shopRefreshToken) 映射**/
    private Long avgShopRefreshToken;

    /** 与 count(shopRefreshToken) 映射**/
    private Long countShopRefreshToken;

    /** 与 sum(shopRefreshToken) 映射**/
    private String sumShopRefreshToken;

    /** shopTokenExpire属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopTokenExpireExpression;

    /** 与 max(shopTokenExpire) 映射**/
    private Long maxShopTokenExpire;

    /** 与 min(shopTokenExpire) 映射**/
    private Long minShopTokenExpire;

    /** 与 avg(shopTokenExpire) 映射**/
    private Long avgShopTokenExpire;

    /** 与 count(shopTokenExpire) 映射**/
    private Long countShopTokenExpire;

    /** 与 sum(shopTokenExpire) 映射**/
    private Date sumShopTokenExpire;

    /** polySpireUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String polySpireUrlExpression;

    /** 与 max(polySpireUrl) 映射**/
    private Long maxPolySpireUrl;

    /** 与 min(polySpireUrl) 映射**/
    private Long minPolySpireUrl;

    /** 与 avg(polySpireUrl) 映射**/
    private Long avgPolySpireUrl;

    /** 与 count(polySpireUrl) 映射**/
    private Long countPolySpireUrl;

    /** 与 sum(polySpireUrl) 映射**/
    private String sumPolySpireUrl;
}