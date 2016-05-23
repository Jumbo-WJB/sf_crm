package com.shufensoft.crm.biz.domain.generation.shake;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ShakeDetail {
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

    /** 摇一摇ID */
    private String rockId;

    /** 商家Id */
    private Long sellerId;

    /** 摇一摇标题 */
    private String rockTitle;

    /** 摇一url */
    private String shareUrl;

    /** 微信公众号 */
    private String wxNumber;

    /** 是否需要验证 1:验证,0:不验证 */
    private String isVerify;

    /** 是否需要关注,1:关注,0:未关注 */
    private String isSubscribe;

    /** 领取人数 */
    private Integer getNum;

    /** 机率值，1-100 */
    private Integer randomNum;

    /** 类型，my,自己摇，帮摇 */
    private String type;

    /** 摇的次数 */
    private Integer rockNum;

    /** 生效配置 */
    private Integer startConfig;

    /** 创建时间 */
    private Date createTime;

    /** 开始时间 */
    private Date startDate;

    /** 结束时间 */
    private Date endDate;

    /** 红包活动ID */
    private Long hbPoolId;

    /** 红包活动Name */
    private String hbPoolName;

    /** 领取红包人数 */
    private Integer getHbNum;

    /** 领取是否需要分享，1：分享，0不分享 */
    private String isGetHbShare;

    /** 领取礼物人数限制 */
    private Integer getGiftNum;

    /** 领取礼物后是否需要分享1：分享，0不分享 */
    private String isGetGiftShare;

    /** 商品地址 */
    private String goodsId;

    /** 积分最小值 */
    private Integer pointIntervalMin;

    /** 积分最大值 */
    private Integer pointIntervalMax;

    /** 积分人数 */
    private Integer getPointNum;

    /** 领取积分后是否需要分享1：分享，0不分享 */
    private String isGetPointShare;

    /**  */
    private String status;

    /**  */
    private String isShakePoint;

    /**  */
    private String isShakeHb;

    /**  */
    private String isShakeGift;

    /**  */
    private String goodsName;

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
    private String sumRockId;

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

    /** shareUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shareUrlExpression;

    /** 与 max(shareUrl) 映射**/
    private Long maxShareUrl;

    /** 与 min(shareUrl) 映射**/
    private Long minShareUrl;

    /** 与 avg(shareUrl) 映射**/
    private Long avgShareUrl;

    /** 与 count(shareUrl) 映射**/
    private Long countShareUrl;

    /** 与 sum(shareUrl) 映射**/
    private String sumShareUrl;

    /** wxNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxNumberExpression;

    /** 与 max(wxNumber) 映射**/
    private Long maxWxNumber;

    /** 与 min(wxNumber) 映射**/
    private Long minWxNumber;

    /** 与 avg(wxNumber) 映射**/
    private Long avgWxNumber;

    /** 与 count(wxNumber) 映射**/
    private Long countWxNumber;

    /** 与 sum(wxNumber) 映射**/
    private String sumWxNumber;

    /** isVerify属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isVerifyExpression;

    /** 与 max(isVerify) 映射**/
    private Long maxIsVerify;

    /** 与 min(isVerify) 映射**/
    private Long minIsVerify;

    /** 与 avg(isVerify) 映射**/
    private Long avgIsVerify;

    /** 与 count(isVerify) 映射**/
    private Long countIsVerify;

    /** 与 sum(isVerify) 映射**/
    private String sumIsVerify;

    /** isSubscribe属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isSubscribeExpression;

    /** 与 max(isSubscribe) 映射**/
    private Long maxIsSubscribe;

    /** 与 min(isSubscribe) 映射**/
    private Long minIsSubscribe;

    /** 与 avg(isSubscribe) 映射**/
    private Long avgIsSubscribe;

    /** 与 count(isSubscribe) 映射**/
    private Long countIsSubscribe;

    /** 与 sum(isSubscribe) 映射**/
    private String sumIsSubscribe;

    /** getNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String getNumExpression;

    /** 与 max(getNum) 映射**/
    private Long maxGetNum;

    /** 与 min(getNum) 映射**/
    private Long minGetNum;

    /** 与 avg(getNum) 映射**/
    private Long avgGetNum;

    /** 与 count(getNum) 映射**/
    private Long countGetNum;

    /** 与 sum(getNum) 映射**/
    private Integer sumGetNum;

    /** randomNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String randomNumExpression;

    /** 与 max(randomNum) 映射**/
    private Long maxRandomNum;

    /** 与 min(randomNum) 映射**/
    private Long minRandomNum;

    /** 与 avg(randomNum) 映射**/
    private Long avgRandomNum;

    /** 与 count(randomNum) 映射**/
    private Long countRandomNum;

    /** 与 sum(randomNum) 映射**/
    private Integer sumRandomNum;

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

    /** rockNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String rockNumExpression;

    /** 与 max(rockNum) 映射**/
    private Long maxRockNum;

    /** 与 min(rockNum) 映射**/
    private Long minRockNum;

    /** 与 avg(rockNum) 映射**/
    private Long avgRockNum;

    /** 与 count(rockNum) 映射**/
    private Long countRockNum;

    /** 与 sum(rockNum) 映射**/
    private Integer sumRockNum;

    /** startConfig属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String startConfigExpression;

    /** 与 max(startConfig) 映射**/
    private Long maxStartConfig;

    /** 与 min(startConfig) 映射**/
    private Long minStartConfig;

    /** 与 avg(startConfig) 映射**/
    private Long avgStartConfig;

    /** 与 count(startConfig) 映射**/
    private Long countStartConfig;

    /** 与 sum(startConfig) 映射**/
    private Integer sumStartConfig;

    /** createTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createTimeExpression;

    /** 与 max(createTime) 映射**/
    private Long maxCreateTime;

    /** 与 min(createTime) 映射**/
    private Long minCreateTime;

    /** 与 avg(createTime) 映射**/
    private Long avgCreateTime;

    /** 与 count(createTime) 映射**/
    private Long countCreateTime;

    /** 与 sum(createTime) 映射**/
    private Date sumCreateTime;

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

    /** hbPoolId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbPoolIdExpression;

    /** 与 max(hbPoolId) 映射**/
    private Long maxHbPoolId;

    /** 与 min(hbPoolId) 映射**/
    private Long minHbPoolId;

    /** 与 avg(hbPoolId) 映射**/
    private Long avgHbPoolId;

    /** 与 count(hbPoolId) 映射**/
    private Long countHbPoolId;

    /** 与 sum(hbPoolId) 映射**/
    private Long sumHbPoolId;

    /** hbPoolName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbPoolNameExpression;

    /** 与 max(hbPoolName) 映射**/
    private Long maxHbPoolName;

    /** 与 min(hbPoolName) 映射**/
    private Long minHbPoolName;

    /** 与 avg(hbPoolName) 映射**/
    private Long avgHbPoolName;

    /** 与 count(hbPoolName) 映射**/
    private Long countHbPoolName;

    /** 与 sum(hbPoolName) 映射**/
    private String sumHbPoolName;

    /** getHbNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String getHbNumExpression;

    /** 与 max(getHbNum) 映射**/
    private Long maxGetHbNum;

    /** 与 min(getHbNum) 映射**/
    private Long minGetHbNum;

    /** 与 avg(getHbNum) 映射**/
    private Long avgGetHbNum;

    /** 与 count(getHbNum) 映射**/
    private Long countGetHbNum;

    /** 与 sum(getHbNum) 映射**/
    private Integer sumGetHbNum;

    /** isGetHbShare属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isGetHbShareExpression;

    /** 与 max(isGetHbShare) 映射**/
    private Long maxIsGetHbShare;

    /** 与 min(isGetHbShare) 映射**/
    private Long minIsGetHbShare;

    /** 与 avg(isGetHbShare) 映射**/
    private Long avgIsGetHbShare;

    /** 与 count(isGetHbShare) 映射**/
    private Long countIsGetHbShare;

    /** 与 sum(isGetHbShare) 映射**/
    private String sumIsGetHbShare;

    /** getGiftNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String getGiftNumExpression;

    /** 与 max(getGiftNum) 映射**/
    private Long maxGetGiftNum;

    /** 与 min(getGiftNum) 映射**/
    private Long minGetGiftNum;

    /** 与 avg(getGiftNum) 映射**/
    private Long avgGetGiftNum;

    /** 与 count(getGiftNum) 映射**/
    private Long countGetGiftNum;

    /** 与 sum(getGiftNum) 映射**/
    private Integer sumGetGiftNum;

    /** isGetGiftShare属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isGetGiftShareExpression;

    /** 与 max(isGetGiftShare) 映射**/
    private Long maxIsGetGiftShare;

    /** 与 min(isGetGiftShare) 映射**/
    private Long minIsGetGiftShare;

    /** 与 avg(isGetGiftShare) 映射**/
    private Long avgIsGetGiftShare;

    /** 与 count(isGetGiftShare) 映射**/
    private Long countIsGetGiftShare;

    /** 与 sum(isGetGiftShare) 映射**/
    private String sumIsGetGiftShare;

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
    private String sumGoodsId;

    /** pointIntervalMin属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointIntervalMinExpression;

    /** 与 max(pointIntervalMin) 映射**/
    private Long maxPointIntervalMin;

    /** 与 min(pointIntervalMin) 映射**/
    private Long minPointIntervalMin;

    /** 与 avg(pointIntervalMin) 映射**/
    private Long avgPointIntervalMin;

    /** 与 count(pointIntervalMin) 映射**/
    private Long countPointIntervalMin;

    /** 与 sum(pointIntervalMin) 映射**/
    private Integer sumPointIntervalMin;

    /** pointIntervalMax属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointIntervalMaxExpression;

    /** 与 max(pointIntervalMax) 映射**/
    private Long maxPointIntervalMax;

    /** 与 min(pointIntervalMax) 映射**/
    private Long minPointIntervalMax;

    /** 与 avg(pointIntervalMax) 映射**/
    private Long avgPointIntervalMax;

    /** 与 count(pointIntervalMax) 映射**/
    private Long countPointIntervalMax;

    /** 与 sum(pointIntervalMax) 映射**/
    private Integer sumPointIntervalMax;

    /** getPointNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String getPointNumExpression;

    /** 与 max(getPointNum) 映射**/
    private Long maxGetPointNum;

    /** 与 min(getPointNum) 映射**/
    private Long minGetPointNum;

    /** 与 avg(getPointNum) 映射**/
    private Long avgGetPointNum;

    /** 与 count(getPointNum) 映射**/
    private Long countGetPointNum;

    /** 与 sum(getPointNum) 映射**/
    private Integer sumGetPointNum;

    /** isGetPointShare属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isGetPointShareExpression;

    /** 与 max(isGetPointShare) 映射**/
    private Long maxIsGetPointShare;

    /** 与 min(isGetPointShare) 映射**/
    private Long minIsGetPointShare;

    /** 与 avg(isGetPointShare) 映射**/
    private Long avgIsGetPointShare;

    /** 与 count(isGetPointShare) 映射**/
    private Long countIsGetPointShare;

    /** 与 sum(isGetPointShare) 映射**/
    private String sumIsGetPointShare;

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

    /** isShakePoint属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isShakePointExpression;

    /** 与 max(isShakePoint) 映射**/
    private Long maxIsShakePoint;

    /** 与 min(isShakePoint) 映射**/
    private Long minIsShakePoint;

    /** 与 avg(isShakePoint) 映射**/
    private Long avgIsShakePoint;

    /** 与 count(isShakePoint) 映射**/
    private Long countIsShakePoint;

    /** 与 sum(isShakePoint) 映射**/
    private String sumIsShakePoint;

    /** isShakeHb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isShakeHbExpression;

    /** 与 max(isShakeHb) 映射**/
    private Long maxIsShakeHb;

    /** 与 min(isShakeHb) 映射**/
    private Long minIsShakeHb;

    /** 与 avg(isShakeHb) 映射**/
    private Long avgIsShakeHb;

    /** 与 count(isShakeHb) 映射**/
    private Long countIsShakeHb;

    /** 与 sum(isShakeHb) 映射**/
    private String sumIsShakeHb;

    /** isShakeGift属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isShakeGiftExpression;

    /** 与 max(isShakeGift) 映射**/
    private Long maxIsShakeGift;

    /** 与 min(isShakeGift) 映射**/
    private Long minIsShakeGift;

    /** 与 avg(isShakeGift) 映射**/
    private Long avgIsShakeGift;

    /** 与 count(isShakeGift) 映射**/
    private Long countIsShakeGift;

    /** 与 sum(isShakeGift) 映射**/
    private String sumIsShakeGift;

    /** goodsName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsNameExpression;

    /** 与 max(goodsName) 映射**/
    private Long maxGoodsName;

    /** 与 min(goodsName) 映射**/
    private Long minGoodsName;

    /** 与 avg(goodsName) 映射**/
    private Long avgGoodsName;

    /** 与 count(goodsName) 映射**/
    private Long countGoodsName;

    /** 与 sum(goodsName) 映射**/
    private String sumGoodsName;
}