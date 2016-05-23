package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SendPlan {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 0	是否逻辑上被删除 */
    private String isDeleted;

    /** 商户ID */
    private String sellerId;

    /** 短信任务ID,作为@BizId */
    @BizId
    private String seqId;

    /** 返回的邮件活动ID */
    private String campaignid;

    /** 营销类型 */
    private String saleType;

    /** 发送类型 */
    private String sendType;

    /** 状态 */
    private String status;

    /** 拉取标记 */
    private String flag;

    /** 发送时间 */
    private Date sendTime;

    /** 创建时间 */
    private Date createTime;

    /** 发送标题 */
    private String sendTitle;

    /** 发送内容 */
    private String sendContent;

    /** 发送者邮箱地址 */
    private String sendFrom;

    /** 发送者名称 */
    private String sendFromname;

    /** 短信级别 */
    private String sendPriority;

    /**  */
    private String smsPassage;

    /**  */
    private String activityId;

    /**  */
    private String fatigue;

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
    private String sumSellerId;

    /** seqId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String seqIdExpression;

    /** 与 max(seqId) 映射**/
    private Long maxSeqId;

    /** 与 min(seqId) 映射**/
    private Long minSeqId;

    /** 与 avg(seqId) 映射**/
    private Long avgSeqId;

    /** 与 count(seqId) 映射**/
    private Long countSeqId;

    /** 与 sum(seqId) 映射**/
    private String sumSeqId;

    /** campaignid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String campaignidExpression;

    /** 与 max(campaignid) 映射**/
    private Long maxCampaignid;

    /** 与 min(campaignid) 映射**/
    private Long minCampaignid;

    /** 与 avg(campaignid) 映射**/
    private Long avgCampaignid;

    /** 与 count(campaignid) 映射**/
    private Long countCampaignid;

    /** 与 sum(campaignid) 映射**/
    private String sumCampaignid;

    /** saleType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String saleTypeExpression;

    /** 与 max(saleType) 映射**/
    private Long maxSaleType;

    /** 与 min(saleType) 映射**/
    private Long minSaleType;

    /** 与 avg(saleType) 映射**/
    private Long avgSaleType;

    /** 与 count(saleType) 映射**/
    private Long countSaleType;

    /** 与 sum(saleType) 映射**/
    private String sumSaleType;

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

    /** flag属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String flagExpression;

    /** 与 max(flag) 映射**/
    private Long maxFlag;

    /** 与 min(flag) 映射**/
    private Long minFlag;

    /** 与 avg(flag) 映射**/
    private Long avgFlag;

    /** 与 count(flag) 映射**/
    private Long countFlag;

    /** 与 sum(flag) 映射**/
    private String sumFlag;

    /** sendTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTimeExpression;

    /** 与 max(sendTime) 映射**/
    private Long maxSendTime;

    /** 与 min(sendTime) 映射**/
    private Long minSendTime;

    /** 与 avg(sendTime) 映射**/
    private Long avgSendTime;

    /** 与 count(sendTime) 映射**/
    private Long countSendTime;

    /** 与 sum(sendTime) 映射**/
    private Date sumSendTime;

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

    /** sendTitle属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTitleExpression;

    /** 与 max(sendTitle) 映射**/
    private Long maxSendTitle;

    /** 与 min(sendTitle) 映射**/
    private Long minSendTitle;

    /** 与 avg(sendTitle) 映射**/
    private Long avgSendTitle;

    /** 与 count(sendTitle) 映射**/
    private Long countSendTitle;

    /** 与 sum(sendTitle) 映射**/
    private String sumSendTitle;

    /** sendContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendContentExpression;

    /** 与 max(sendContent) 映射**/
    private Long maxSendContent;

    /** 与 min(sendContent) 映射**/
    private Long minSendContent;

    /** 与 avg(sendContent) 映射**/
    private Long avgSendContent;

    /** 与 count(sendContent) 映射**/
    private Long countSendContent;

    /** 与 sum(sendContent) 映射**/
    private String sumSendContent;

    /** sendFrom属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendFromExpression;

    /** 与 max(sendFrom) 映射**/
    private Long maxSendFrom;

    /** 与 min(sendFrom) 映射**/
    private Long minSendFrom;

    /** 与 avg(sendFrom) 映射**/
    private Long avgSendFrom;

    /** 与 count(sendFrom) 映射**/
    private Long countSendFrom;

    /** 与 sum(sendFrom) 映射**/
    private String sumSendFrom;

    /** sendFromname属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendFromnameExpression;

    /** 与 max(sendFromname) 映射**/
    private Long maxSendFromname;

    /** 与 min(sendFromname) 映射**/
    private Long minSendFromname;

    /** 与 avg(sendFromname) 映射**/
    private Long avgSendFromname;

    /** 与 count(sendFromname) 映射**/
    private Long countSendFromname;

    /** 与 sum(sendFromname) 映射**/
    private String sumSendFromname;

    /** sendPriority属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendPriorityExpression;

    /** 与 max(sendPriority) 映射**/
    private Long maxSendPriority;

    /** 与 min(sendPriority) 映射**/
    private Long minSendPriority;

    /** 与 avg(sendPriority) 映射**/
    private Long avgSendPriority;

    /** 与 count(sendPriority) 映射**/
    private Long countSendPriority;

    /** 与 sum(sendPriority) 映射**/
    private String sumSendPriority;

    /** smsPassage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsPassageExpression;

    /** 与 max(smsPassage) 映射**/
    private Long maxSmsPassage;

    /** 与 min(smsPassage) 映射**/
    private Long minSmsPassage;

    /** 与 avg(smsPassage) 映射**/
    private Long avgSmsPassage;

    /** 与 count(smsPassage) 映射**/
    private Long countSmsPassage;

    /** 与 sum(smsPassage) 映射**/
    private String sumSmsPassage;

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
    private String sumActivityId;

    /** fatigue属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String fatigueExpression;

    /** 与 max(fatigue) 映射**/
    private Long maxFatigue;

    /** 与 min(fatigue) 映射**/
    private Long minFatigue;

    /** 与 avg(fatigue) 映射**/
    private Long avgFatigue;

    /** 与 count(fatigue) 映射**/
    private Long countFatigue;

    /** 与 sum(fatigue) 映射**/
    private String sumFatigue;
}