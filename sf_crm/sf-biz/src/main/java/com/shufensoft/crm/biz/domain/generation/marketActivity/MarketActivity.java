package com.shufensoft.crm.biz.domain.generation.marketActivity;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MarketActivity {
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

    /** 活动id,作为@BizId */
    @BizId
    private Long activityId;

    /** 营销主题 */
    private String title;

    /** 营销目的sale:销售；increase_fans：增粉；spread:传播；other：其他 */
    private String target;

    /** 类型	wx：微信；sms：短信；email：邮件；wp：微博 */
    private String type;

    /** 营销活动内容类型	Int	text:文本信息:single_image_text：单条图文；multi_image_text:多条图文；voice:语音 */
    private String contentType;

    /** 营销活动内容	存放html界面的路径地址或者是文本信息 */
    private String content;

    /** 活动外链接	VARCHAR(100)	活动外链接 */
    private String url;

    /** 邮件营销邮件类型	qq:QQ邮箱;163:163邮箱;126:126邮箱;yahoo:yahoo邮箱并且不同的邮箱类型之间用，分隔 */
    private String emailType;

    /**发送成功率**/
    private Float successRate;

    /**邮件打开率**/
    private Float openRate;

    /** 关联微信公众号素材管理对应的素材Id */
    private String wxMediaId;

    /** 素材类型	VARCHAR（50）	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图） */
    private String wxSourceType;

    /** 活动覆盖人群 */
    private Integer wxPersonCount;

    /** 反馈人群数量 */
    private Integer feedbackNumber;

    /** 活动状态start:开启;stop:暂停 */
    private String status;

    /** 执行时间 */
    private Date executeTime;

    /**  */
    private String executeType;

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

    /** 与 sum(activityId) 映射**/
    private Long sumActivityId;

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

    /** target属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String targetExpression;

    /** 与 max(target) 映射**/
    private Long maxTarget;

    /** 与 min(target) 映射**/
    private Long minTarget;

    /** 与 avg(target) 映射**/
    private Long avgTarget;

    /** 与 count(target) 映射**/
    private Long countTarget;

    /** 与 sum(target) 映射**/
    private String sumTarget;

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

    /** contentType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String contentTypeExpression;

    /** 与 max(contentType) 映射**/
    private Long maxContentType;

    /** 与 min(contentType) 映射**/
    private Long minContentType;

    /** 与 avg(contentType) 映射**/
    private Long avgContentType;

    /** 与 count(contentType) 映射**/
    private Long countContentType;

    /** 与 sum(contentType) 映射**/
    private String sumContentType;

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

    /** emailType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailTypeExpression;

    /** 与 max(emailType) 映射**/
    private Long maxEmailType;

    /** 与 min(emailType) 映射**/
    private Long minEmailType;

    /** 与 avg(emailType) 映射**/
    private Long avgEmailType;

    /** 与 count(emailType) 映射**/
    private Long countEmailType;

    /** 与 sum(emailType) 映射**/
    private String sumEmailType;

    /** wxMediaId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxMediaIdExpression;

    /** 与 max(wxMediaId) 映射**/
    private Long maxWxMediaId;

    /** 与 min(wxMediaId) 映射**/
    private Long minWxMediaId;

    /** 与 avg(wxMediaId) 映射**/
    private Long avgWxMediaId;

    /** 与 count(wxMediaId) 映射**/
    private Long countWxMediaId;

    /** 与 sum(wxMediaId) 映射**/
    private String sumWxMediaId;

    /** wxSourceType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxSourceTypeExpression;

    /** 与 max(wxSourceType) 映射**/
    private Long maxWxSourceType;

    /** 与 min(wxSourceType) 映射**/
    private Long minWxSourceType;

    /** 与 avg(wxSourceType) 映射**/
    private Long avgWxSourceType;

    /** 与 count(wxSourceType) 映射**/
    private Long countWxSourceType;

    /** 与 sum(wxSourceType) 映射**/
    private String sumWxSourceType;

    /** wxPersonCount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String wxPersonCountExpression;

    /** 与 max(wxPersonCount) 映射**/
    private Long maxWxPersonCount;

    /** 与 min(wxPersonCount) 映射**/
    private Long minWxPersonCount;

    /** 与 avg(wxPersonCount) 映射**/
    private Long avgWxPersonCount;

    /** 与 count(wxPersonCount) 映射**/
    private Long countWxPersonCount;

    /** 与 sum(wxPersonCount) 映射**/
    private Integer sumWxPersonCount;

    /** feedbackNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String feedbackNumberExpression;

    /** 与 max(feedbackNumber) 映射**/
    private Long maxFeedbackNumber;

    /** 与 min(feedbackNumber) 映射**/
    private Long minFeedbackNumber;

    /** 与 avg(feedbackNumber) 映射**/
    private Long avgFeedbackNumber;

    /** 与 count(feedbackNumber) 映射**/
    private Long countFeedbackNumber;

    /** 与 sum(feedbackNumber) 映射**/
    private Integer sumFeedbackNumber;

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

    /** executeTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String executeTimeExpression;

    /** 与 max(executeTime) 映射**/
    private Long maxExecuteTime;

    /** 与 min(executeTime) 映射**/
    private Long minExecuteTime;

    /** 与 avg(executeTime) 映射**/
    private Long avgExecuteTime;

    /** 与 count(executeTime) 映射**/
    private Long countExecuteTime;

    /** 与 sum(executeTime) 映射**/
    private Date sumExecuteTime;

    /** executeType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String executeTypeExpression;

    /** 与 max(executeType) 映射**/
    private Long maxExecuteType;

    /** 与 min(executeType) 映射**/
    private Long minExecuteType;

    /** 与 avg(executeType) 映射**/
    private Long avgExecuteType;

    /** 与 count(executeType) 映射**/
    private Long countExecuteType;

    /** 与 sum(executeType) 映射**/
    private String sumExecuteType;

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