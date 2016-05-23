package com.shufensoft.crm.biz.domain.generation.comment;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class CommentTaoBao {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 商家id */
    private Long sellerId;

    /** 店铺id */
    private Long shopId;

    /** 关联user_taobao表user_id_tb */
    private Long userIdTb;

    /** 内部淘宝评价信息@BizId */
    @BizId
    private Long commentIdTb;

    /** 交易ID */
    private Long tid;

    /** 子订单ID */
    private Long oid;

    /** 评价者角色.可选值:seller(卖家)buyer(买家) */
    private String role;

    /** 评价者昵称 */
    private String nick;

    /** 评价结果可选值:good(好评)neutral(中评)bad(差评) */
    private String result;

    /** 评价创建时间格式:yyyy-MM-dd HH:mm:ss */
    private Date created;

    /** 被评价者昵称 */
    private String ratedNick;

    /** 商品标题 */
    private String itemTitle;

    /** 商品价格精确到2位小数;单位:元.如:200.07，表示:200元7分 */
    private String itemPrice;

    /** 评价内容最大长度:500个汉字 */
    private String content;

    /** 评价解释最大长度:500个汉字 */
    private String reply;

    /** 商品的数字ID */
    private Long numIid;

    /** 	评价信息是否用于记分， 可取值：true(参与记分)和false(不参与记分) */
    private Boolean validScore;

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

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

    /** commentIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String commentIdTbExpression;

    /** 与 max(commentIdTb) 映射**/
    private Long maxCommentIdTb;

    /** 与 min(commentIdTb) 映射**/
    private Long minCommentIdTb;

    /** 与 avg(commentIdTb) 映射**/
    private Long avgCommentIdTb;

    /** 与 count(commentIdTb) 映射**/
    private Long countCommentIdTb;

    /** 与 sum(commentIdTb) 映射**/
    private Long sumCommentIdTb;

    /** tid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tidExpression;

    /** 与 max(tid) 映射**/
    private Long maxTid;

    /** 与 min(tid) 映射**/
    private Long minTid;

    /** 与 avg(tid) 映射**/
    private Long avgTid;

    /** 与 count(tid) 映射**/
    private Long countTid;

    /** 与 sum(tid) 映射**/
    private Long sumTid;

    /** oid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String oidExpression;

    /** 与 max(oid) 映射**/
    private Long maxOid;

    /** 与 min(oid) 映射**/
    private Long minOid;

    /** 与 avg(oid) 映射**/
    private Long avgOid;

    /** 与 count(oid) 映射**/
    private Long countOid;

    /** 与 sum(oid) 映射**/
    private Long sumOid;

    /** role属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String roleExpression;

    /** 与 max(role) 映射**/
    private Long maxRole;

    /** 与 min(role) 映射**/
    private Long minRole;

    /** 与 avg(role) 映射**/
    private Long avgRole;

    /** 与 count(role) 映射**/
    private Long countRole;

    /** 与 sum(role) 映射**/
    private String sumRole;

    /** nick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nickExpression;

    /** 与 max(nick) 映射**/
    private Long maxNick;

    /** 与 min(nick) 映射**/
    private Long minNick;

    /** 与 avg(nick) 映射**/
    private Long avgNick;

    /** 与 count(nick) 映射**/
    private Long countNick;

    /** 与 sum(nick) 映射**/
    private String sumNick;

    /** result属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String resultExpression;

    /** 与 max(result) 映射**/
    private Long maxResult;

    /** 与 min(result) 映射**/
    private Long minResult;

    /** 与 avg(result) 映射**/
    private Long avgResult;

    /** 与 count(result) 映射**/
    private Long countResult;

    /** 与 sum(result) 映射**/
    private String sumResult;

    /** created属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdExpression;

    /** 与 max(created) 映射**/
    private Long maxCreated;

    /** 与 min(created) 映射**/
    private Long minCreated;

    /** 与 avg(created) 映射**/
    private Long avgCreated;

    /** 与 count(created) 映射**/
    private Long countCreated;

    /** 与 sum(created) 映射**/
    private Date sumCreated;

    /** ratedNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String ratedNickExpression;

    /** 与 max(ratedNick) 映射**/
    private Long maxRatedNick;

    /** 与 min(ratedNick) 映射**/
    private Long minRatedNick;

    /** 与 avg(ratedNick) 映射**/
    private Long avgRatedNick;

    /** 与 count(ratedNick) 映射**/
    private Long countRatedNick;

    /** 与 sum(ratedNick) 映射**/
    private String sumRatedNick;

    /** itemTitle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemTitleExpression;

    /** 与 max(itemTitle) 映射**/
    private Long maxItemTitle;

    /** 与 min(itemTitle) 映射**/
    private Long minItemTitle;

    /** 与 avg(itemTitle) 映射**/
    private Long avgItemTitle;

    /** 与 count(itemTitle) 映射**/
    private Long countItemTitle;

    /** 与 sum(itemTitle) 映射**/
    private String sumItemTitle;

    /** itemPrice属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String itemPriceExpression;

    /** 与 max(itemPrice) 映射**/
    private Long maxItemPrice;

    /** 与 min(itemPrice) 映射**/
    private Long minItemPrice;

    /** 与 avg(itemPrice) 映射**/
    private Long avgItemPrice;

    /** 与 count(itemPrice) 映射**/
    private Long countItemPrice;

    /** 与 sum(itemPrice) 映射**/
    private String sumItemPrice;

    /** content属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contentExpression;

    /** 与 max(content) 映射**/
    private Long maxContent;

    /** 与 min(content) 映射**/
    private Long minContent;

    /** 与 avg(content) 映射**/
    private Long avgContent;

    /** 与 count(content) 映射**/
    private Long countContent;

    /** 与 sum(content) 映射**/
    private String sumContent;

    /** reply属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String replyExpression;

    /** 与 max(reply) 映射**/
    private Long maxReply;

    /** 与 min(reply) 映射**/
    private Long minReply;

    /** 与 avg(reply) 映射**/
    private Long avgReply;

    /** 与 count(reply) 映射**/
    private Long countReply;

    /** 与 sum(reply) 映射**/
    private String sumReply;

    /** numIid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numIidExpression;

    /** 与 max(numIid) 映射**/
    private Long maxNumIid;

    /** 与 min(numIid) 映射**/
    private Long minNumIid;

    /** 与 avg(numIid) 映射**/
    private Long avgNumIid;

    /** 与 count(numIid) 映射**/
    private Long countNumIid;

    /** 与 sum(numIid) 映射**/
    private Long sumNumIid;

    /** validScore属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String validScoreExpression;

    /** 与 max(validScore) 映射**/
    private Long maxValidScore;

    /** 与 min(validScore) 映射**/
    private Long minValidScore;

    /** 与 avg(validScore) 映射**/
    private Long avgValidScore;

    /** 与 count(validScore) 映射**/
    private Long countValidScore;

    /** 与 sum(validScore) 映射**/
    private Boolean sumValidScore;
}