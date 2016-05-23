package com.shufensoft.crm.biz.domain.generation.comment;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class CommentJD {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 对应user_jd表user_id_jd */
    private Long userIdJd;

    /** 京东评价信息ID */
    private String jdCommentId;

    /** 订单ID */
    private String orderId;

    /** skuid */
    private String skuid;

    /** 内容 */
    private String content;

    /** 创建时间 */
    private Date creationTime;

    /** sku图片 */
    private String skuImage;

    /** 	sku名称 */
    private String skuName;

    /** 	回复数 */
    private Integer replyCount;

    /** 评价等级 */
    private Integer score;

    /** 	有用数 */
    private Integer usefulCount;

    /** 商家是否回复 */
    private Boolean isVenderReply;

    /** 用户昵称 */
    private String nickName;

    /** 商家id */
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

    /** userIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdJdExpression;

    /** 与 max(userIdJd) 映射**/
    private Long maxUserIdJd;

    /** 与 min(userIdJd) 映射**/
    private Long minUserIdJd;

    /** 与 avg(userIdJd) 映射**/
    private Long avgUserIdJd;

    /** 与 count(userIdJd) 映射**/
    private Long countUserIdJd;

    /** 与 sum(userIdJd) 映射**/
    private Long sumUserIdJd;

    /** jdCommentId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdCommentIdExpression;

    /** 与 max(jdCommentId) 映射**/
    private Long maxJdCommentId;

    /** 与 min(jdCommentId) 映射**/
    private Long minJdCommentId;

    /** 与 avg(jdCommentId) 映射**/
    private Long avgJdCommentId;

    /** 与 count(jdCommentId) 映射**/
    private Long countJdCommentId;

    /** 与 sum(jdCommentId) 映射**/
    private String sumJdCommentId;

    /** orderId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String orderIdExpression;

    /** 与 max(orderId) 映射**/
    private Long maxOrderId;

    /** 与 min(orderId) 映射**/
    private Long minOrderId;

    /** 与 avg(orderId) 映射**/
    private Long avgOrderId;

    /** 与 count(orderId) 映射**/
    private Long countOrderId;

    /** 与 sum(orderId) 映射**/
    private String sumOrderId;

    /** skuid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuidExpression;

    /** 与 max(skuid) 映射**/
    private Long maxSkuid;

    /** 与 min(skuid) 映射**/
    private Long minSkuid;

    /** 与 avg(skuid) 映射**/
    private Long avgSkuid;

    /** 与 count(skuid) 映射**/
    private Long countSkuid;

    /** 与 sum(skuid) 映射**/
    private String sumSkuid;

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

    /** creationTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String creationTimeExpression;

    /** 与 max(creationTime) 映射**/
    private Long maxCreationTime;

    /** 与 min(creationTime) 映射**/
    private Long minCreationTime;

    /** 与 avg(creationTime) 映射**/
    private Long avgCreationTime;

    /** 与 count(creationTime) 映射**/
    private Long countCreationTime;

    /** 与 sum(creationTime) 映射**/
    private Date sumCreationTime;

    /** skuImage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuImageExpression;

    /** 与 max(skuImage) 映射**/
    private Long maxSkuImage;

    /** 与 min(skuImage) 映射**/
    private Long minSkuImage;

    /** 与 avg(skuImage) 映射**/
    private Long avgSkuImage;

    /** 与 count(skuImage) 映射**/
    private Long countSkuImage;

    /** 与 sum(skuImage) 映射**/
    private String sumSkuImage;

    /** skuName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuNameExpression;

    /** 与 max(skuName) 映射**/
    private Long maxSkuName;

    /** 与 min(skuName) 映射**/
    private Long minSkuName;

    /** 与 avg(skuName) 映射**/
    private Long avgSkuName;

    /** 与 count(skuName) 映射**/
    private Long countSkuName;

    /** 与 sum(skuName) 映射**/
    private String sumSkuName;

    /** replyCount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String replyCountExpression;

    /** 与 max(replyCount) 映射**/
    private Long maxReplyCount;

    /** 与 min(replyCount) 映射**/
    private Long minReplyCount;

    /** 与 avg(replyCount) 映射**/
    private Long avgReplyCount;

    /** 与 count(replyCount) 映射**/
    private Long countReplyCount;

    /** 与 sum(replyCount) 映射**/
    private Integer sumReplyCount;

    /** score属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String scoreExpression;

    /** 与 max(score) 映射**/
    private Long maxScore;

    /** 与 min(score) 映射**/
    private Long minScore;

    /** 与 avg(score) 映射**/
    private Long avgScore;

    /** 与 count(score) 映射**/
    private Long countScore;

    /** 与 sum(score) 映射**/
    private Integer sumScore;

    /** usefulCount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String usefulCountExpression;

    /** 与 max(usefulCount) 映射**/
    private Long maxUsefulCount;

    /** 与 min(usefulCount) 映射**/
    private Long minUsefulCount;

    /** 与 avg(usefulCount) 映射**/
    private Long avgUsefulCount;

    /** 与 count(usefulCount) 映射**/
    private Long countUsefulCount;

    /** 与 sum(usefulCount) 映射**/
    private Integer sumUsefulCount;

    /** isVenderReply属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isVenderReplyExpression;

    /** 与 max(isVenderReply) 映射**/
    private Long maxIsVenderReply;

    /** 与 min(isVenderReply) 映射**/
    private Long minIsVenderReply;

    /** 与 avg(isVenderReply) 映射**/
    private Long avgIsVenderReply;

    /** 与 count(isVenderReply) 映射**/
    private Long countIsVenderReply;

    /** 与 sum(isVenderReply) 映射**/
    private Boolean sumIsVenderReply;

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

    /** 与 sum(nickName) 映射**/
    private String sumNickName;

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