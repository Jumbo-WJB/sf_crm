package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserTaoBao {
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

    /** 淘宝用户id,作为@BizId */
    @BizId
    private Long userIdTb;

    /** 商家Id */
    private Long sellerId;

    /** 店铺id */
    private Long shopId;

    /** 买家支付宝账号 */
    private String buyerAlipayNo;

    /** 买家支付宝Id */
    private Long alipayId;

    /** 买家昵称 */
    private String buyerNick;

    /** 买家邮件 */
    private String buyerEmail;

    /** 区域id，代表订单下单的区位码，区位码是通过省市区转换而来，通过区位码能精确到区内的划分，比如310012是杭州市西湖区华星路 */
    private String areaId;

    /** 买家下单地址 */
    private String buyerArea;

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

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 count(distinctuserIdTb) 映射**/
    private Long countDistinctUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

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

    /** buyerAlipayNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerAlipayNoExpression;

    /** 与 max(buyerAlipayNo) 映射**/
    private Long maxBuyerAlipayNo;

    /** 与 min(buyerAlipayNo) 映射**/
    private Long minBuyerAlipayNo;

    /** 与 avg(buyerAlipayNo) 映射**/
    private Long avgBuyerAlipayNo;

    /** 与 count(buyerAlipayNo) 映射**/
    private Long countBuyerAlipayNo;

    /** 与 count(distinctbuyerAlipayNo) 映射**/
    private Long countDistinctBuyerAlipayNo;

    /** 与 sum(buyerAlipayNo) 映射**/
    private String sumBuyerAlipayNo;

    /** alipayId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String alipayIdExpression;

    /** 与 max(alipayId) 映射**/
    private Long maxAlipayId;

    /** 与 min(alipayId) 映射**/
    private Long minAlipayId;

    /** 与 avg(alipayId) 映射**/
    private Long avgAlipayId;

    /** 与 count(alipayId) 映射**/
    private Long countAlipayId;

    /** 与 count(distinctalipayId) 映射**/
    private Long countDistinctAlipayId;

    /** 与 sum(alipayId) 映射**/
    private Long sumAlipayId;

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

    /** buyerEmail属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerEmailExpression;

    /** 与 max(buyerEmail) 映射**/
    private Long maxBuyerEmail;

    /** 与 min(buyerEmail) 映射**/
    private Long minBuyerEmail;

    /** 与 avg(buyerEmail) 映射**/
    private Long avgBuyerEmail;

    /** 与 count(buyerEmail) 映射**/
    private Long countBuyerEmail;

    /** 与 count(distinctbuyerEmail) 映射**/
    private Long countDistinctBuyerEmail;

    /** 与 sum(buyerEmail) 映射**/
    private String sumBuyerEmail;

    /** areaId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String areaIdExpression;

    /** 与 max(areaId) 映射**/
    private Long maxAreaId;

    /** 与 min(areaId) 映射**/
    private Long minAreaId;

    /** 与 avg(areaId) 映射**/
    private Long avgAreaId;

    /** 与 count(areaId) 映射**/
    private Long countAreaId;

    /** 与 count(distinctareaId) 映射**/
    private Long countDistinctAreaId;

    /** 与 sum(areaId) 映射**/
    private String sumAreaId;

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
}