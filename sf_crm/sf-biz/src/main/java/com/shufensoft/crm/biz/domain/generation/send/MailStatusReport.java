package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MailStatusReport {
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

    /** 发送任务ID */
    private String seqId;

    /** 是否发送成功 */
    private String emailAddress;

    /** 是否发送成功 */
    private String isSuccess;

    /** 是否弹回 */
    private String isBack;

    /** 是否打开 */
    private String isOpen;

    /** 是否退订 */
    private String isUnsubscribe;

    /** 是否投诉 */
    private String isComplaints;

    /** 发送时间 */
    private Date submitData;

    /**  */
    private String status;

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

    /** emailAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailAddressExpression;

    /** 与 max(emailAddress) 映射**/
    private Long maxEmailAddress;

    /** 与 min(emailAddress) 映射**/
    private Long minEmailAddress;

    /** 与 avg(emailAddress) 映射**/
    private Long avgEmailAddress;

    /** 与 count(emailAddress) 映射**/
    private Long countEmailAddress;

    /** 与 sum(emailAddress) 映射**/
    private String sumEmailAddress;

    /** isSuccess属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isSuccessExpression;

    /** 与 max(isSuccess) 映射**/
    private Long maxIsSuccess;

    /** 与 min(isSuccess) 映射**/
    private Long minIsSuccess;

    /** 与 avg(isSuccess) 映射**/
    private Long avgIsSuccess;

    /** 与 count(isSuccess) 映射**/
    private Long countIsSuccess;

    /** 与 sum(isSuccess) 映射**/
    private String sumIsSuccess;

    /** isBack属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isBackExpression;

    /** 与 max(isBack) 映射**/
    private Long maxIsBack;

    /** 与 min(isBack) 映射**/
    private Long minIsBack;

    /** 与 avg(isBack) 映射**/
    private Long avgIsBack;

    /** 与 count(isBack) 映射**/
    private Long countIsBack;

    /** 与 sum(isBack) 映射**/
    private String sumIsBack;

    /** isOpen属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isOpenExpression;

    /** 与 max(isOpen) 映射**/
    private Long maxIsOpen;

    /** 与 min(isOpen) 映射**/
    private Long minIsOpen;

    /** 与 avg(isOpen) 映射**/
    private Long avgIsOpen;

    /** 与 count(isOpen) 映射**/
    private Long countIsOpen;

    /** 与 sum(isOpen) 映射**/
    private String sumIsOpen;

    /** isUnsubscribe属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isUnsubscribeExpression;

    /** 与 max(isUnsubscribe) 映射**/
    private Long maxIsUnsubscribe;

    /** 与 min(isUnsubscribe) 映射**/
    private Long minIsUnsubscribe;

    /** 与 avg(isUnsubscribe) 映射**/
    private Long avgIsUnsubscribe;

    /** 与 count(isUnsubscribe) 映射**/
    private Long countIsUnsubscribe;

    /** 与 sum(isUnsubscribe) 映射**/
    private String sumIsUnsubscribe;

    /** isComplaints属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isComplaintsExpression;

    /** 与 max(isComplaints) 映射**/
    private Long maxIsComplaints;

    /** 与 min(isComplaints) 映射**/
    private Long minIsComplaints;

    /** 与 avg(isComplaints) 映射**/
    private Long avgIsComplaints;

    /** 与 count(isComplaints) 映射**/
    private Long countIsComplaints;

    /** 与 sum(isComplaints) 映射**/
    private String sumIsComplaints;

    /** submitData属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String submitDataExpression;

    /** 与 max(submitData) 映射**/
    private Long maxSubmitData;

    /** 与 min(submitData) 映射**/
    private Long minSubmitData;

    /** 与 avg(submitData) 映射**/
    private Long avgSubmitData;

    /** 与 count(submitData) 映射**/
    private Long countSubmitData;

    /** 与 sum(submitData) 映射**/
    private Date sumSubmitData;

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