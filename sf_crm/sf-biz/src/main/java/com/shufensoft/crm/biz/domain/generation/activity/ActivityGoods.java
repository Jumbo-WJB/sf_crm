package com.shufensoft.crm.biz.domain.generation.activity;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class ActivityGoods {
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

    /** 活动Id */
    private Long activityId;

    /** 活动商品Id, @BizId */
    @BizId
    private Long activityGoodsId;

    /** 活动商品在购物平台的Id */
    private String goodsId;

    /** 活动商品名称 */
    private String goodsName;

    /** 活动商品图片地址 */
    private String goodsUrl;

    /** 活动商品在购物平台的详情链接 */
    private String goodsLink;

    /** 活动商品价格，用分表示 */
    private Integer goodsPrice;

    /** 活动商品数量 */
    private Integer goodsQuantity;

    /** 活动商品来源:  京东JD，天猫TMALL， 淘宝TAOBAO，有赞YOUZAN */
    private String goodsSource;

    /** 活动商品所在购物平台店铺名称 */
    private String shopName;

    /** 返现方式：红包hongbao，现金crash， 优惠券等 */
    private String cashbackType;

    /** 红包池ID */
    private String hbPoolId;

    /** 累计红包总金额，分为单位 */
    private Integer hbcashAmount;

    /** 红包使用范围：指定商品可用goods， 全店通用shop */
    private String applyRange;

    /** 限定多少小时内没有购物，红包自动释放 */
    private Integer releaseTime;

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

    /** activityGoodsId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String activityGoodsIdExpression;

    /** 与 max(activityGoodsId) 映射**/
    private Long maxActivityGoodsId;

    /** 与 min(activityGoodsId) 映射**/
    private Long minActivityGoodsId;

    /** 与 avg(activityGoodsId) 映射**/
    private Long avgActivityGoodsId;

    /** 与 count(activityGoodsId) 映射**/
    private Long countActivityGoodsId;

    /** 与 count(distinctactivityGoodsId) 映射**/
    private Long countDistinctActivityGoodsId;

    /** 与 sum(activityGoodsId) 映射**/
    private Long sumActivityGoodsId;

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

    /** 与 count(distinctgoodsId) 映射**/
    private Long countDistinctGoodsId;

    /** 与 sum(goodsId) 映射**/
    private String sumGoodsId;

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

    /** 与 count(distinctgoodsName) 映射**/
    private Long countDistinctGoodsName;

    /** 与 sum(goodsName) 映射**/
    private String sumGoodsName;

    /** goodsUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsUrlExpression;

    /** 与 max(goodsUrl) 映射**/
    private Long maxGoodsUrl;

    /** 与 min(goodsUrl) 映射**/
    private Long minGoodsUrl;

    /** 与 avg(goodsUrl) 映射**/
    private Long avgGoodsUrl;

    /** 与 count(goodsUrl) 映射**/
    private Long countGoodsUrl;

    /** 与 count(distinctgoodsUrl) 映射**/
    private Long countDistinctGoodsUrl;

    /** 与 sum(goodsUrl) 映射**/
    private String sumGoodsUrl;

    /** goodsLink属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsLinkExpression;

    /** 与 max(goodsLink) 映射**/
    private Long maxGoodsLink;

    /** 与 min(goodsLink) 映射**/
    private Long minGoodsLink;

    /** 与 avg(goodsLink) 映射**/
    private Long avgGoodsLink;

    /** 与 count(goodsLink) 映射**/
    private Long countGoodsLink;

    /** 与 count(distinctgoodsLink) 映射**/
    private Long countDistinctGoodsLink;

    /** 与 sum(goodsLink) 映射**/
    private String sumGoodsLink;

    /** goodsPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsPriceExpression;

    /** 与 max(goodsPrice) 映射**/
    private Long maxGoodsPrice;

    /** 与 min(goodsPrice) 映射**/
    private Long minGoodsPrice;

    /** 与 avg(goodsPrice) 映射**/
    private Long avgGoodsPrice;

    /** 与 count(goodsPrice) 映射**/
    private Long countGoodsPrice;

    /** 与 count(distinctgoodsPrice) 映射**/
    private Long countDistinctGoodsPrice;

    /** 与 sum(goodsPrice) 映射**/
    private Integer sumGoodsPrice;

    /** goodsQuantity属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsQuantityExpression;

    /** 与 max(goodsQuantity) 映射**/
    private Long maxGoodsQuantity;

    /** 与 min(goodsQuantity) 映射**/
    private Long minGoodsQuantity;

    /** 与 avg(goodsQuantity) 映射**/
    private Long avgGoodsQuantity;

    /** 与 count(goodsQuantity) 映射**/
    private Long countGoodsQuantity;

    /** 与 count(distinctgoodsQuantity) 映射**/
    private Long countDistinctGoodsQuantity;

    /** 与 sum(goodsQuantity) 映射**/
    private Integer sumGoodsQuantity;

    /** goodsSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsSourceExpression;

    /** 与 max(goodsSource) 映射**/
    private Long maxGoodsSource;

    /** 与 min(goodsSource) 映射**/
    private Long minGoodsSource;

    /** 与 avg(goodsSource) 映射**/
    private Long avgGoodsSource;

    /** 与 count(goodsSource) 映射**/
    private Long countGoodsSource;

    /** 与 count(distinctgoodsSource) 映射**/
    private Long countDistinctGoodsSource;

    /** 与 sum(goodsSource) 映射**/
    private String sumGoodsSource;

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

    /** 与 count(distinctshopName) 映射**/
    private Long countDistinctShopName;

    /** 与 sum(shopName) 映射**/
    private String sumShopName;

    /** cashbackType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String cashbackTypeExpression;

    /** 与 max(cashbackType) 映射**/
    private Long maxCashbackType;

    /** 与 min(cashbackType) 映射**/
    private Long minCashbackType;

    /** 与 avg(cashbackType) 映射**/
    private Long avgCashbackType;

    /** 与 count(cashbackType) 映射**/
    private Long countCashbackType;

    /** 与 count(distinctcashbackType) 映射**/
    private Long countDistinctCashbackType;

    /** 与 sum(cashbackType) 映射**/
    private String sumCashbackType;

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

    /** 与 count(distincthbPoolId) 映射**/
    private Long countDistinctHbPoolId;

    /** 与 sum(hbPoolId) 映射**/
    private String sumHbPoolId;

    /** hbcashAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbcashAmountExpression;

    /** 与 max(hbcashAmount) 映射**/
    private Long maxHbcashAmount;

    /** 与 min(hbcashAmount) 映射**/
    private Long minHbcashAmount;

    /** 与 avg(hbcashAmount) 映射**/
    private Long avgHbcashAmount;

    /** 与 count(hbcashAmount) 映射**/
    private Long countHbcashAmount;

    /** 与 count(distincthbcashAmount) 映射**/
    private Long countDistinctHbcashAmount;

    /** 与 sum(hbcashAmount) 映射**/
    private Integer sumHbcashAmount;

    /** applyRange属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String applyRangeExpression;

    /** 与 max(applyRange) 映射**/
    private Long maxApplyRange;

    /** 与 min(applyRange) 映射**/
    private Long minApplyRange;

    /** 与 avg(applyRange) 映射**/
    private Long avgApplyRange;

    /** 与 count(applyRange) 映射**/
    private Long countApplyRange;

    /** 与 count(distinctapplyRange) 映射**/
    private Long countDistinctApplyRange;

    /** 与 sum(applyRange) 映射**/
    private String sumApplyRange;

    /** releaseTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String releaseTimeExpression;

    /** 与 max(releaseTime) 映射**/
    private Long maxReleaseTime;

    /** 与 min(releaseTime) 映射**/
    private Long minReleaseTime;

    /** 与 avg(releaseTime) 映射**/
    private Long avgReleaseTime;

    /** 与 count(releaseTime) 映射**/
    private Long countReleaseTime;

    /** 与 count(distinctreleaseTime) 映射**/
    private Long countDistinctReleaseTime;

    /** 与 sum(releaseTime) 映射**/
    private Integer sumReleaseTime;
}