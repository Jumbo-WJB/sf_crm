package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SendDetail {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 0	是否逻辑上被删除 */
    private String isDeleted;

    /** 商户ID */
    private String sellerId;

    /** 短信任务ID */
    private String seqId;

    /** 套餐ID */
    private String packageId;

    /** 类型，SMS：短信，EMAIL:邮件 */
    private String saleType;

    /** 发送的号码或邮件地址 */
    private String userSendAddress;

    /** 状态 */
    private String status;

    /** 发送时间 */
    private Date sendTime;

    /**  */
    private String sendPriority;

    /**  */
    private String activityId;

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

    /** packageId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageIdExpression;

    /** 与 max(packageId) 映射**/
    private Long maxPackageId;

    /** 与 min(packageId) 映射**/
    private Long minPackageId;

    /** 与 avg(packageId) 映射**/
    private Long avgPackageId;

    /** 与 count(packageId) 映射**/
    private Long countPackageId;

    /** 与 sum(packageId) 映射**/
    private String sumPackageId;

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

    /** userSendAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userSendAddressExpression;

    /** 与 max(userSendAddress) 映射**/
    private Long maxUserSendAddress;

    /** 与 min(userSendAddress) 映射**/
    private Long minUserSendAddress;

    /** 与 avg(userSendAddress) 映射**/
    private Long avgUserSendAddress;

    /** 与 count(userSendAddress) 映射**/
    private Long countUserSendAddress;

    /** 与 sum(userSendAddress) 映射**/
    private String sumUserSendAddress;

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
}