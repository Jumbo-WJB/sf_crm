package com.shufensoft.crm.biz.domain.generation.user;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class UserWxMessage {
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

    /** 消息id */
    private String msgId;

    /** 消息类型 */
    private String msgType;

    /** 关键字智能回复配置id */
    private Long keyWordConfigId;

    /** 业务类型 */
    private String bizType;

    /** 用户Id */
    private Long userId;

    /** 用户来源 */
    private String firstSource;

    /** 微信用户OPENID */
    private String wxOpenid;

    /** 微信昵称 */
    private String wxNickName;

    /** 用户手机号码 */
    private String mobile;

    /** 回复类型；intelligence：智能;artificial：人工 */
    private String replyType;

    /** from_custom:客户发送 from_seller:商家发送 */
    private String sendType;

    /** 商家公众号 */
    private String toUserName;

    /** 发送者帐号 */
    private String fromUserName;

    /** 消息发送时间 */
    private Date createTime;

    /** 消息文本内容 */
    private String content;

    /** 图片id */
    private String mediaId;

    /** 标题 */
    private String title;

    /** 描述 */
    private String description;

    /** 点击链接的地址 */
    private String url;

    /** 图片链接的地址 */
    private String picUrl;

    /**  */
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

    /** msgId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String msgIdExpression;

    /** 与 max(msgId) 映射**/
    private Long maxMsgId;

    /** 与 min(msgId) 映射**/
    private Long minMsgId;

    /** 与 avg(msgId) 映射**/
    private Long avgMsgId;

    /** 与 count(msgId) 映射**/
    private Long countMsgId;

    /** 与 sum(msgId) 映射**/
    private String sumMsgId;

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

    /** keyWordConfigId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String keyWordConfigIdExpression;

    /** 与 max(keyWordConfigId) 映射**/
    private Long maxKeyWordConfigId;

    /** 与 min(keyWordConfigId) 映射**/
    private Long minKeyWordConfigId;

    /** 与 avg(keyWordConfigId) 映射**/
    private Long avgKeyWordConfigId;

    /** 与 count(keyWordConfigId) 映射**/
    private Long countKeyWordConfigId;

    /** 与 sum(keyWordConfigId) 映射**/
    private Long sumKeyWordConfigId;

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

    /** firstSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String firstSourceExpression;

    /** 与 max(firstSource) 映射**/
    private Long maxFirstSource;

    /** 与 min(firstSource) 映射**/
    private Long minFirstSource;

    /** 与 avg(firstSource) 映射**/
    private Long avgFirstSource;

    /** 与 count(firstSource) 映射**/
    private Long countFirstSource;

    /** 与 sum(firstSource) 映射**/
    private String sumFirstSource;

    /** wxOpenid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxOpenidExpression;

    /** 与 max(wxOpenid) 映射**/
    private Long maxWxOpenid;

    /** 与 min(wxOpenid) 映射**/
    private Long minWxOpenid;

    /** 与 avg(wxOpenid) 映射**/
    private Long avgWxOpenid;

    /** 与 count(wxOpenid) 映射**/
    private Long countWxOpenid;

    /** 与 sum(wxOpenid) 映射**/
    private String sumWxOpenid;

    /** wxNickName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxNickNameExpression;

    /** 与 max(wxNickName) 映射**/
    private Long maxWxNickName;

    /** 与 min(wxNickName) 映射**/
    private Long minWxNickName;

    /** 与 avg(wxNickName) 映射**/
    private Long avgWxNickName;

    /** 与 count(wxNickName) 映射**/
    private Long countWxNickName;

    /** 与 sum(wxNickName) 映射**/
    private String sumWxNickName;

    /** mobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String mobileExpression;

    /** 与 max(mobile) 映射**/
    private Long maxMobile;

    /** 与 min(mobile) 映射**/
    private Long minMobile;

    /** 与 avg(mobile) 映射**/
    private Long avgMobile;

    /** 与 count(mobile) 映射**/
    private Long countMobile;

    /** 与 sum(mobile) 映射**/
    private String sumMobile;

    /** replyType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String replyTypeExpression;

    /** 与 max(replyType) 映射**/
    private Long maxReplyType;

    /** 与 min(replyType) 映射**/
    private Long minReplyType;

    /** 与 avg(replyType) 映射**/
    private Long avgReplyType;

    /** 与 count(replyType) 映射**/
    private Long countReplyType;

    /** 与 sum(replyType) 映射**/
    private String sumReplyType;

    /** sendType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTypeExpression;

    /** 与 max(sendType) 映射**/
    private Long maxSendType;

    /** 与 min(sendType) 映射**/
    private Long minSendType;

    /** 与 avg(sendType) 映射**/
    private Long avgSendType;

    /** 与 count(sendType) 映射**/
    private Long countSendType;

    /** 与 sum(sendType) 映射**/
    private String sumSendType;

    /** toUserName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String toUserNameExpression;

    /** 与 max(toUserName) 映射**/
    private Long maxToUserName;

    /** 与 min(toUserName) 映射**/
    private Long minToUserName;

    /** 与 avg(toUserName) 映射**/
    private Long avgToUserName;

    /** 与 count(toUserName) 映射**/
    private Long countToUserName;

    /** 与 sum(toUserName) 映射**/
    private String sumToUserName;

    /** fromUserName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String fromUserNameExpression;

    /** 与 max(fromUserName) 映射**/
    private Long maxFromUserName;

    /** 与 min(fromUserName) 映射**/
    private Long minFromUserName;

    /** 与 avg(fromUserName) 映射**/
    private Long avgFromUserName;

    /** 与 count(fromUserName) 映射**/
    private Long countFromUserName;

    /** 与 sum(fromUserName) 映射**/
    private String sumFromUserName;

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
    private String sumMediaId;

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

    /** url属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String urlExpression;

    /** 与 max(url) 映射**/
    private Long maxUrl;

    /** 与 min(url) 映射**/
    private Long minUrl;

    /** 与 avg(url) 映射**/
    private Long avgUrl;

    /** 与 count(url) 映射**/
    private Long countUrl;

    /** 与 sum(url) 映射**/
    private String sumUrl;

    /** picUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String picUrlExpression;

    /** 与 max(picUrl) 映射**/
    private Long maxPicUrl;

    /** 与 min(picUrl) 映射**/
    private Long minPicUrl;

    /** 与 avg(picUrl) 映射**/
    private Long avgPicUrl;

    /** 与 count(picUrl) 映射**/
    private Long countPicUrl;

    /** 与 sum(picUrl) 映射**/
    private String sumPicUrl;

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