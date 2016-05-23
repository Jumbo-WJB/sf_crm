package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserAccount {
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

    /** 商户Id */
    private Long sellerId;

    /** 账户id,作为@BizId */
    @BizId
    private Long accountId;

    /** 用户id */
    private Long userId;

    /** 账户余额分为单位 */
    private Long hongbaoAmount;

    /** 累计领取红包个数 */
    private Long hbtotalNumber;

    /** 累计领取红包金额分为单位 */
    private Long hbobtainAmount;

    /** 累计领取好评返红包金额分为单位 */
    private Long hongbaoPraiseAmount;

    /** 累计领取购物红包金额分为单位 */
    private Long hongbaoShopAmount;

    /** 最近一次红包领取时间 */
    private Date hbobtainDate;

    /** 累计提现红包金额分为单位 */
    private Long hbcashAmount;

    /** 最近一次红包提现时间 */
    private Date hbcashDate;

    /** 累计红包提现个数 */
    private Long hbcashNumber;

    /** 当前有效积分 */
    private Long pointAmount;

    /** 累计获得积分 */
    private Long pointAmountTotal;

    /** 累计兑换积分 */
    private Long pointAmountExchange;

    /** 累计过期积分 */
    private Long pointAmountExpired;

    /** 累计转让积分 */
    private Long pointAmountTransferred;

    /** 用户账户版本号，用于乐观锁 */
    private Long userAccountVersion;

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

    /** accountId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String accountIdExpression;

    /** 与 max(accountId) 映射**/
    private Long maxAccountId;

    /** 与 min(accountId) 映射**/
    private Long minAccountId;

    /** 与 avg(accountId) 映射**/
    private Long avgAccountId;

    /** 与 count(accountId) 映射**/
    private Long countAccountId;

    /** 与 sum(accountId) 映射**/
    private Long sumAccountId;

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

    /** hongbaoAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoAmountExpression;

    /** 与 max(hongbaoAmount) 映射**/
    private Long maxHongbaoAmount;

    /** 与 min(hongbaoAmount) 映射**/
    private Long minHongbaoAmount;

    /** 与 avg(hongbaoAmount) 映射**/
    private Long avgHongbaoAmount;

    /** 与 count(hongbaoAmount) 映射**/
    private Long countHongbaoAmount;

    /** 与 sum(hongbaoAmount) 映射**/
    private Long sumHongbaoAmount;

    /** hbtotalNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbtotalNumberExpression;

    /** 与 max(hbtotalNumber) 映射**/
    private Long maxHbtotalNumber;

    /** 与 min(hbtotalNumber) 映射**/
    private Long minHbtotalNumber;

    /** 与 avg(hbtotalNumber) 映射**/
    private Long avgHbtotalNumber;

    /** 与 count(hbtotalNumber) 映射**/
    private Long countHbtotalNumber;

    /** 与 sum(hbtotalNumber) 映射**/
    private Long sumHbtotalNumber;

    /** hbobtainAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbobtainAmountExpression;

    /** 与 max(hbobtainAmount) 映射**/
    private Long maxHbobtainAmount;

    /** 与 min(hbobtainAmount) 映射**/
    private Long minHbobtainAmount;

    /** 与 avg(hbobtainAmount) 映射**/
    private Long avgHbobtainAmount;

    /** 与 count(hbobtainAmount) 映射**/
    private Long countHbobtainAmount;

    /** 与 sum(hbobtainAmount) 映射**/
    private Long sumHbobtainAmount;

    /** hongbaoPraiseAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoPraiseAmountExpression;

    /** 与 max(hongbaoPraiseAmount) 映射**/
    private Long maxHongbaoPraiseAmount;

    /** 与 min(hongbaoPraiseAmount) 映射**/
    private Long minHongbaoPraiseAmount;

    /** 与 avg(hongbaoPraiseAmount) 映射**/
    private Long avgHongbaoPraiseAmount;

    /** 与 count(hongbaoPraiseAmount) 映射**/
    private Long countHongbaoPraiseAmount;

    /** 与 sum(hongbaoPraiseAmount) 映射**/
    private Long sumHongbaoPraiseAmount;

    /** hongbaoShopAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoShopAmountExpression;

    /** 与 max(hongbaoShopAmount) 映射**/
    private Long maxHongbaoShopAmount;

    /** 与 min(hongbaoShopAmount) 映射**/
    private Long minHongbaoShopAmount;

    /** 与 avg(hongbaoShopAmount) 映射**/
    private Long avgHongbaoShopAmount;

    /** 与 count(hongbaoShopAmount) 映射**/
    private Long countHongbaoShopAmount;

    /** 与 sum(hongbaoShopAmount) 映射**/
    private Long sumHongbaoShopAmount;

    /** hbobtainDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbobtainDateExpression;

    /** 与 max(hbobtainDate) 映射**/
    private Long maxHbobtainDate;

    /** 与 min(hbobtainDate) 映射**/
    private Long minHbobtainDate;

    /** 与 avg(hbobtainDate) 映射**/
    private Long avgHbobtainDate;

    /** 与 count(hbobtainDate) 映射**/
    private Long countHbobtainDate;

    /** 与 sum(hbobtainDate) 映射**/
    private Date sumHbobtainDate;

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

    /** 与 sum(hbcashAmount) 映射**/
    private Long sumHbcashAmount;

    /** hbcashDate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbcashDateExpression;

    /** 与 max(hbcashDate) 映射**/
    private Long maxHbcashDate;

    /** 与 min(hbcashDate) 映射**/
    private Long minHbcashDate;

    /** 与 avg(hbcashDate) 映射**/
    private Long avgHbcashDate;

    /** 与 count(hbcashDate) 映射**/
    private Long countHbcashDate;

    /** 与 sum(hbcashDate) 映射**/
    private Date sumHbcashDate;

    /** hbcashNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hbcashNumberExpression;

    /** 与 max(hbcashNumber) 映射**/
    private Long maxHbcashNumber;

    /** 与 min(hbcashNumber) 映射**/
    private Long minHbcashNumber;

    /** 与 avg(hbcashNumber) 映射**/
    private Long avgHbcashNumber;

    /** 与 count(hbcashNumber) 映射**/
    private Long countHbcashNumber;

    /** 与 sum(hbcashNumber) 映射**/
    private Long sumHbcashNumber;

    /** pointAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointAmountExpression;

    /** 与 max(pointAmount) 映射**/
    private Long maxPointAmount;

    /** 与 min(pointAmount) 映射**/
    private Long minPointAmount;

    /** 与 avg(pointAmount) 映射**/
    private Long avgPointAmount;

    /** 与 count(pointAmount) 映射**/
    private Long countPointAmount;

    /** 与 sum(pointAmount) 映射**/
    private Long sumPointAmount;

    /** pointAmountTotal属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointAmountTotalExpression;

    /** 与 max(pointAmountTotal) 映射**/
    private Long maxPointAmountTotal;

    /** 与 min(pointAmountTotal) 映射**/
    private Long minPointAmountTotal;

    /** 与 avg(pointAmountTotal) 映射**/
    private Long avgPointAmountTotal;

    /** 与 count(pointAmountTotal) 映射**/
    private Long countPointAmountTotal;

    /** 与 sum(pointAmountTotal) 映射**/
    private Long sumPointAmountTotal;

    /** pointAmountExchange属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointAmountExchangeExpression;

    /** 与 max(pointAmountExchange) 映射**/
    private Long maxPointAmountExchange;

    /** 与 min(pointAmountExchange) 映射**/
    private Long minPointAmountExchange;

    /** 与 avg(pointAmountExchange) 映射**/
    private Long avgPointAmountExchange;

    /** 与 count(pointAmountExchange) 映射**/
    private Long countPointAmountExchange;

    /** 与 sum(pointAmountExchange) 映射**/
    private Long sumPointAmountExchange;

    /** pointAmountExpired属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointAmountExpiredExpression;

    /** 与 max(pointAmountExpired) 映射**/
    private Long maxPointAmountExpired;

    /** 与 min(pointAmountExpired) 映射**/
    private Long minPointAmountExpired;

    /** 与 avg(pointAmountExpired) 映射**/
    private Long avgPointAmountExpired;

    /** 与 count(pointAmountExpired) 映射**/
    private Long countPointAmountExpired;

    /** 与 sum(pointAmountExpired) 映射**/
    private Long sumPointAmountExpired;

    /** pointAmountTransferred属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointAmountTransferredExpression;

    /** 与 max(pointAmountTransferred) 映射**/
    private Long maxPointAmountTransferred;

    /** 与 min(pointAmountTransferred) 映射**/
    private Long minPointAmountTransferred;

    /** 与 avg(pointAmountTransferred) 映射**/
    private Long avgPointAmountTransferred;

    /** 与 count(pointAmountTransferred) 映射**/
    private Long countPointAmountTransferred;

    /** 与 sum(pointAmountTransferred) 映射**/
    private Long sumPointAmountTransferred;

    /** userAccountVersion属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userAccountVersionExpression;

    /** 与 max(userAccountVersion) 映射**/
    private Long maxUserAccountVersion;

    /** 与 min(userAccountVersion) 映射**/
    private Long minUserAccountVersion;

    /** 与 avg(userAccountVersion) 映射**/
    private Long avgUserAccountVersion;

    /** 与 count(userAccountVersion) 映射**/
    private Long countUserAccountVersion;

    /** 与 sum(userAccountVersion) 映射**/
    private Long sumUserAccountVersion;
}