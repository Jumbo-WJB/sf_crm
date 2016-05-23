package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Domain
@Data
@ToString
public class UserYZ {
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

    /** 有赞用户id,作为@BizId */
    @BizId
    private Long userIdYz;

    /** 商家Id */
    private Long sellerId;

    /** 店铺id */
    private Long shopId;

    /** 微信粉丝ID */
    private Long weixinUserId;

    /** 浙江省杭州市 */
    private String buyerArea;

    /** 买家Id */
    private Long buyerId;

    /** 买家昵称 */
    private String buyerNick;

    /** 微信openid */
    private String openid;

    /** 微信昵称 */
    private String nickName;

    /** 性别 */
    private String sex;

    /** 城市 */
    private String city;

    /** 用户所在省份 */
    private String province;

    /** 微信头像 */
    private String headimgurl;

    /** 关注时间 */
    private Date subscribeTime;

    private List<UserTagYZ> tags;

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

    /** userIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdYzExpression;

    /** 与 max(userIdYz) 映射**/
    private Long maxUserIdYz;

    /** 与 min(userIdYz) 映射**/
    private Long minUserIdYz;

    /** 与 avg(userIdYz) 映射**/
    private Long avgUserIdYz;

    /** 与 count(userIdYz) 映射**/
    private Long countUserIdYz;

    /** 与 count(distinctuserIdYz) 映射**/
    private Long countDistinctUserIdYz;

    /** 与 sum(userIdYz) 映射**/
    private Long sumUserIdYz;

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

    /** 与 count(distinctshopId) 映射**/
    private Long countDistinctShopId;

    /** 与 sum(shopId) 映射**/
    private Long sumShopId;

    /** weixinUserId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String weixinUserIdExpression;

    /** 与 max(weixinUserId) 映射**/
    private Long maxWeixinUserId;

    /** 与 min(weixinUserId) 映射**/
    private Long minWeixinUserId;

    /** 与 avg(weixinUserId) 映射**/
    private Long avgWeixinUserId;

    /** 与 count(weixinUserId) 映射**/
    private Long countWeixinUserId;

    /** 与 count(distinctweixinUserId) 映射**/
    private Long countDistinctWeixinUserId;

    /** 与 sum(weixinUserId) 映射**/
    private Long sumWeixinUserId;

    /** buyerArea属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerAreaExpression;

    /** 与 max(buyerArea) 映射**/
    private Long maxBuyerArea;

    /** 与 min(buyerArea) 映射**/
    private Long minBuyerArea;

    /** 与 avg(buyerArea) 映射**/
    private Long avgBuyerArea;

    /** 与 count(buyerArea) 映射**/
    private Long countBuyerArea;

    /** 与 count(distinctbuyerArea) 映射**/
    private Long countDistinctBuyerArea;

    /** 与 sum(buyerArea) 映射**/
    private String sumBuyerArea;

    /** buyerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerIdExpression;

    /** 与 max(buyerId) 映射**/
    private Long maxBuyerId;

    /** 与 min(buyerId) 映射**/
    private Long minBuyerId;

    /** 与 avg(buyerId) 映射**/
    private Long avgBuyerId;

    /** 与 count(buyerId) 映射**/
    private Long countBuyerId;

    /** 与 count(distinctbuyerId) 映射**/
    private Long countDistinctBuyerId;

    /** 与 sum(buyerId) 映射**/
    private Long sumBuyerId;

    /** buyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerNickExpression;

    /** 与 max(buyerNick) 映射**/
    private Long maxBuyerNick;

    /** 与 min(buyerNick) 映射**/
    private Long minBuyerNick;

    /** 与 avg(buyerNick) 映射**/
    private Long avgBuyerNick;

    /** 与 count(buyerNick) 映射**/
    private Long countBuyerNick;

    /** 与 count(distinctbuyerNick) 映射**/
    private Long countDistinctBuyerNick;

    /** 与 sum(buyerNick) 映射**/
    private String sumBuyerNick;

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

    /** 与 count(distinctopenid) 映射**/
    private Long countDistinctOpenid;

    /** 与 sum(openid) 映射**/
    private String sumOpenid;

    /** nickName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nickNameExpression;

    /** 与 max(nickName) 映射**/
    private Long maxNickName;

    /** 与 min(nickName) 映射**/
    private Long minNickName;

    /** 与 avg(nickName) 映射**/
    private Long avgNickName;

    /** 与 count(nickName) 映射**/
    private Long countNickName;

    /** 与 count(distinctnickName) 映射**/
    private Long countDistinctNickName;

    /** 与 sum(nickName) 映射**/
    private String sumNickName;

    /** sex属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sexExpression;

    /** 与 max(sex) 映射**/
    private Long maxSex;

    /** 与 min(sex) 映射**/
    private Long minSex;

    /** 与 avg(sex) 映射**/
    private Long avgSex;

    /** 与 count(sex) 映射**/
    private Long countSex;

    /** 与 count(distinctsex) 映射**/
    private Long countDistinctSex;

    /** 与 sum(sex) 映射**/
    private String sumSex;

    /** city属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String cityExpression;

    /** 与 max(city) 映射**/
    private Long maxCity;

    /** 与 min(city) 映射**/
    private Long minCity;

    /** 与 avg(city) 映射**/
    private Long avgCity;

    /** 与 count(city) 映射**/
    private Long countCity;

    /** 与 count(distinctcity) 映射**/
    private Long countDistinctCity;

    /** 与 sum(city) 映射**/
    private String sumCity;

    /** province属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String provinceExpression;

    /** 与 max(province) 映射**/
    private Long maxProvince;

    /** 与 min(province) 映射**/
    private Long minProvince;

    /** 与 avg(province) 映射**/
    private Long avgProvince;

    /** 与 count(province) 映射**/
    private Long countProvince;

    /** 与 count(distinctprovince) 映射**/
    private Long countDistinctProvince;

    /** 与 sum(province) 映射**/
    private String sumProvince;

    /** headimgurl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String headimgurlExpression;

    /** 与 max(headimgurl) 映射**/
    private Long maxHeadimgurl;

    /** 与 min(headimgurl) 映射**/
    private Long minHeadimgurl;

    /** 与 avg(headimgurl) 映射**/
    private Long avgHeadimgurl;

    /** 与 count(headimgurl) 映射**/
    private Long countHeadimgurl;

    /** 与 count(distinctheadimgurl) 映射**/
    private Long countDistinctHeadimgurl;

    /** 与 sum(headimgurl) 映射**/
    private String sumHeadimgurl;

    /** subscribeTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String subscribeTimeExpression;

    /** 与 max(subscribeTime) 映射**/
    private Long maxSubscribeTime;

    /** 与 min(subscribeTime) 映射**/
    private Long minSubscribeTime;

    /** 与 avg(subscribeTime) 映射**/
    private Long avgSubscribeTime;

    /** 与 count(subscribeTime) 映射**/
    private Long countSubscribeTime;

    /** 与 count(distinctsubscribeTime) 映射**/
    private Long countDistinctSubscribeTime;

    /** 与 sum(subscribeTime) 映射**/
    private Date sumSubscribeTime;
}