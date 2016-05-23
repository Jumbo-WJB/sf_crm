package com.shufensoft.crm.biz.domain.generation.reply;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class KeyWordReplyConfig {
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

    /**  */
    private Long sellerId;

    /** 内容名称 */
    private String title;

    /** 关键字描述 */
    private String description;

    /** 相关业务ID,比如红包领取对应红包池id */
    private Long bizId;

    /** 关键字 */
    private String keyWord;

    /** 图文素材Id */
    private Long mediaId;

    /** 业务类型point_exchange:积分换礼;express_query:快递查询;receive_hb:红包领取 */
    private String bizType;

    /** 匹配类型0:模糊匹配1:精确匹配 */
    private String matchType;

    /** 成功回复内容 */
    private String successReplyContent;

    /** 回复消息类型text:文本;image:图文 */
    private String msgType;

    /** 失败回复 */
    private String failReplyContent;

    /** 重复操作回复内容 */
    private String repeatOperateReplyContent;

    /** 相关业务名称,比如红包领取对应红包池名称,冗余字段便于查询 */
    private String bizName;

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

    /** title属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String titleExpression;

    /** 与 max(title) 映射**/
    private Long maxTitle;

    /** 与 min(title) 映射**/
    private Long minTitle;

    /** 与 avg(title) 映射**/
    private Long avgTitle;

    /** 与 count(title) 映射**/
    private Long countTitle;

    /** 与 sum(title) 映射**/
    private String sumTitle;

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

    /** bizId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String bizIdExpression;

    /** 与 max(bizId) 映射**/
    private Long maxBizId;

    /** 与 min(bizId) 映射**/
    private Long minBizId;

    /** 与 avg(bizId) 映射**/
    private Long avgBizId;

    /** 与 count(bizId) 映射**/
    private Long countBizId;

    /** 与 sum(bizId) 映射**/
    private Long sumBizId;

    /** keyWord属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String keyWordExpression;

    /** 与 max(keyWord) 映射**/
    private Long maxKeyWord;

    /** 与 min(keyWord) 映射**/
    private Long minKeyWord;

    /** 与 avg(keyWord) 映射**/
    private Long avgKeyWord;

    /** 与 count(keyWord) 映射**/
    private Long countKeyWord;

    /** 与 sum(keyWord) 映射**/
    private String sumKeyWord;

    /** mediaId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String mediaIdExpression;

    /** 与 max(mediaId) 映射**/
    private Long maxMediaId;

    /** 与 min(mediaId) 映射**/
    private Long minMediaId;

    /** 与 avg(mediaId) 映射**/
    private Long avgMediaId;

    /** 与 count(mediaId) 映射**/
    private Long countMediaId;

    /** 与 sum(mediaId) 映射**/
    private Long sumMediaId;

    /** bizType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String bizTypeExpression;

    /** 与 max(bizType) 映射**/
    private Long maxBizType;

    /** 与 min(bizType) 映射**/
    private Long minBizType;

    /** 与 avg(bizType) 映射**/
    private Long avgBizType;

    /** 与 count(bizType) 映射**/
    private Long countBizType;

    /** 与 sum(bizType) 映射**/
    private String sumBizType;

    /** matchType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String matchTypeExpression;

    /** 与 max(matchType) 映射**/
    private Long maxMatchType;

    /** 与 min(matchType) 映射**/
    private Long minMatchType;

    /** 与 avg(matchType) 映射**/
    private Long avgMatchType;

    /** 与 count(matchType) 映射**/
    private Long countMatchType;

    /** 与 sum(matchType) 映射**/
    private String sumMatchType;

    /** successReplyContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String successReplyContentExpression;

    /** 与 max(successReplyContent) 映射**/
    private Long maxSuccessReplyContent;

    /** 与 min(successReplyContent) 映射**/
    private Long minSuccessReplyContent;

    /** 与 avg(successReplyContent) 映射**/
    private Long avgSuccessReplyContent;

    /** 与 count(successReplyContent) 映射**/
    private Long countSuccessReplyContent;

    /** 与 sum(successReplyContent) 映射**/
    private String sumSuccessReplyContent;

    /** msgType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String msgTypeExpression;

    /** 与 max(msgType) 映射**/
    private Long maxMsgType;

    /** 与 min(msgType) 映射**/
    private Long minMsgType;

    /** 与 avg(msgType) 映射**/
    private Long avgMsgType;

    /** 与 count(msgType) 映射**/
    private Long countMsgType;

    /** 与 sum(msgType) 映射**/
    private String sumMsgType;

    /** failReplyContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String failReplyContentExpression;

    /** 与 max(failReplyContent) 映射**/
    private Long maxFailReplyContent;

    /** 与 min(failReplyContent) 映射**/
    private Long minFailReplyContent;

    /** 与 avg(failReplyContent) 映射**/
    private Long avgFailReplyContent;

    /** 与 count(failReplyContent) 映射**/
    private Long countFailReplyContent;

    /** 与 sum(failReplyContent) 映射**/
    private String sumFailReplyContent;

    /** repeatOperateReplyContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String repeatOperateReplyContentExpression;

    /** 与 max(repeatOperateReplyContent) 映射**/
    private Long maxRepeatOperateReplyContent;

    /** 与 min(repeatOperateReplyContent) 映射**/
    private Long minRepeatOperateReplyContent;

    /** 与 avg(repeatOperateReplyContent) 映射**/
    private Long avgRepeatOperateReplyContent;

    /** 与 count(repeatOperateReplyContent) 映射**/
    private Long countRepeatOperateReplyContent;

    /** 与 sum(repeatOperateReplyContent) 映射**/
    private String sumRepeatOperateReplyContent;

    /** bizName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String bizNameExpression;

    /** 与 max(bizName) 映射**/
    private Long maxBizName;

    /** 与 min(bizName) 映射**/
    private Long minBizName;

    /** 与 avg(bizName) 映射**/
    private Long avgBizName;

    /** 与 count(bizName) 映射**/
    private Long countBizName;

    /** 与 sum(bizName) 映射**/
    private String sumBizName;
}