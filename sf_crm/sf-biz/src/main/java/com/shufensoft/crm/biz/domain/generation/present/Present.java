package com.shufensoft.crm.biz.domain.generation.present;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class Present {
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

    /** 内部礼物Id,作为@BizId */
    @BizId
    private Long presentId;

    /** 商家id */
    private Long sellerId;

    /** 用户id */
    private Long userId;

    /** 生日活动Id */
    private Long birthdayAcivityId;

    /** 礼物类型 */
    private String presentType;

    /** 礼物名字 */
    private String presentName;

    /** 礼物来源 */
    private String presentSource;

    /** 购物折扣 */
    private Double discount;

    /** 礼物暗号 */
    private String presentPassword;

    /** 对应积分商城的商品id */
    private Long goodsId;

    /** 对应红包池id */
    private Long hbPoolId;

    /** 赠送的红包金额或赠送的积分数量 */
    private Long amount;

    /** 是否已领取(1领取;0未领取) */
    private Boolean isReceive;

    /** 过期时间 */
    private Date expireDate;

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

    /** presentId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String presentIdExpression;

    /** 与 max(presentId) 映射**/
    private Long maxPresentId;

    /** 与 min(presentId) 映射**/
    private Long minPresentId;

    /** 与 avg(presentId) 映射**/
    private Long avgPresentId;

    /** 与 count(presentId) 映射**/
    private Long countPresentId;

    /** 与 sum(presentId) 映射**/
    private Long sumPresentId;

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

    /** birthdayAcivityId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String birthdayAcivityIdExpression;

    /** 与 max(birthdayAcivityId) 映射**/
    private Long maxBirthdayAcivityId;

    /** 与 min(birthdayAcivityId) 映射**/
    private Long minBirthdayAcivityId;

    /** 与 avg(birthdayAcivityId) 映射**/
    private Long avgBirthdayAcivityId;

    /** 与 count(birthdayAcivityId) 映射**/
    private Long countBirthdayAcivityId;

    /** 与 sum(birthdayAcivityId) 映射**/
    private Long sumBirthdayAcivityId;

    /** presentType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String presentTypeExpression;

    /** 与 max(presentType) 映射**/
    private Long maxPresentType;

    /** 与 min(presentType) 映射**/
    private Long minPresentType;

    /** 与 avg(presentType) 映射**/
    private Long avgPresentType;

    /** 与 count(presentType) 映射**/
    private Long countPresentType;

    /** 与 sum(presentType) 映射**/
    private String sumPresentType;

    /** presentName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String presentNameExpression;

    /** 与 max(presentName) 映射**/
    private Long maxPresentName;

    /** 与 min(presentName) 映射**/
    private Long minPresentName;

    /** 与 avg(presentName) 映射**/
    private Long avgPresentName;

    /** 与 count(presentName) 映射**/
    private Long countPresentName;

    /** 与 sum(presentName) 映射**/
    private String sumPresentName;

    /** presentSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String presentSourceExpression;

    /** 与 max(presentSource) 映射**/
    private Long maxPresentSource;

    /** 与 min(presentSource) 映射**/
    private Long minPresentSource;

    /** 与 avg(presentSource) 映射**/
    private Long avgPresentSource;

    /** 与 count(presentSource) 映射**/
    private Long countPresentSource;

    /** 与 sum(presentSource) 映射**/
    private String sumPresentSource;

    /** discount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String discountExpression;

    /** 与 max(discount) 映射**/
    private Long maxDiscount;

    /** 与 min(discount) 映射**/
    private Long minDiscount;

    /** 与 avg(discount) 映射**/
    private Long avgDiscount;

    /** 与 count(discount) 映射**/
    private Long countDiscount;

    /** 与 sum(discount) 映射**/
    private Double sumDiscount;

    /** presentPassword属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String presentPasswordExpression;

    /** 与 max(presentPassword) 映射**/
    private Long maxPresentPassword;

    /** 与 min(presentPassword) 映射**/
    private Long minPresentPassword;

    /** 与 avg(presentPassword) 映射**/
    private Long avgPresentPassword;

    /** 与 count(presentPassword) 映射**/
    private Long countPresentPassword;

    /** 与 sum(presentPassword) 映射**/
    private String sumPresentPassword;

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
    private Long sumGoodsId;

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

    /** amount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountExpression;

    /** 与 max(amount) 映射**/
    private Long maxAmount;

    /** 与 min(amount) 映射**/
    private Long minAmount;

    /** 与 avg(amount) 映射**/
    private Long avgAmount;

    /** 与 count(amount) 映射**/
    private Long countAmount;

    /** 与 sum(amount) 映射**/
    private Long sumAmount;

    /** isReceive属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isReceiveExpression;

    /** 与 max(isReceive) 映射**/
    private Long maxIsReceive;

    /** 与 min(isReceive) 映射**/
    private Long minIsReceive;

    /** 与 avg(isReceive) 映射**/
    private Long avgIsReceive;

    /** 与 count(isReceive) 映射**/
    private Long countIsReceive;

    /** 与 sum(isReceive) 映射**/
    private Boolean sumIsReceive;

    /** expireDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String expireDateExpression;

    /** 与 max(expireDate) 映射**/
    private Long maxExpireDate;

    /** 与 min(expireDate) 映射**/
    private Long minExpireDate;

    /** 与 avg(expireDate) 映射**/
    private Long avgExpireDate;

    /** 与 count(expireDate) 映射**/
    private Long countExpireDate;

    /** 与 sum(expireDate) 映射**/
    private Date sumExpireDate;
}