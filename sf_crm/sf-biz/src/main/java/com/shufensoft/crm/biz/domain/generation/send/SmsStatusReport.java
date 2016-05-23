package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SmsStatusReport {
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

    /** 短信任务ID */
    private String seqId;

    /** 备注 */
    private String memo;

    /** 返回的错误码 */
    private String errorCode;

    /** -手机号码 */
    private String mobile;

    /** 接收时间 */
    private Date receiveData;

    /** 报告状态 */
    private String reportStatus;

    /** 短信下行服务码 */
    private String serviceCodeAdd;

    /** 发送时间 */
    private Date submitData;

    /** 状态 */
    private String status;

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

    /** 与 count(distinctid) 映射**/
    private Long countDistinctId;

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

    /** 与 count(distinctgmtCreated) 映射**/
    private Long countDistinctGmtCreated;

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

    /** 与 count(distinctgmtModified) 映射**/
    private Long countDistinctGmtModified;

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

    /** 与 count(distinctcreatedBy) 映射**/
    private Long countDistinctCreatedBy;

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

    /** 与 count(distinctmodifiedBy) 映射**/
    private Long countDistinctModifiedBy;

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

    /** 与 count(distinctisDeleted) 映射**/
    private Long countDistinctIsDeleted;

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

    /** 与 count(distinctseqId) 映射**/
    private Long countDistinctSeqId;

    /** 与 sum(seqId) 映射**/
    private String sumSeqId;

    /** memo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String memoExpression;

    /** 与 max(memo) 映射**/
    private Long maxMemo;

    /** 与 min(memo) 映射**/
    private Long minMemo;

    /** 与 avg(memo) 映射**/
    private Long avgMemo;

    /** 与 count(memo) 映射**/
    private Long countMemo;

    /** 与 count(distinctmemo) 映射**/
    private Long countDistinctMemo;

    /** 与 sum(memo) 映射**/
    private String sumMemo;

    /** errorCode属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String errorCodeExpression;

    /** 与 max(errorCode) 映射**/
    private Long maxErrorCode;

    /** 与 min(errorCode) 映射**/
    private Long minErrorCode;

    /** 与 avg(errorCode) 映射**/
    private Long avgErrorCode;

    /** 与 count(errorCode) 映射**/
    private Long countErrorCode;

    /** 与 count(distincterrorCode) 映射**/
    private Long countDistinctErrorCode;

    /** 与 sum(errorCode) 映射**/
    private String sumErrorCode;

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

    /** 与 count(distinctmobile) 映射**/
    private Long countDistinctMobile;

    /** 与 sum(mobile) 映射**/
    private String sumMobile;

    /** receiveData属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiveDataExpression;

    /** 与 max(receiveData) 映射**/
    private Long maxReceiveData;

    /** 与 min(receiveData) 映射**/
    private Long minReceiveData;

    /** 与 avg(receiveData) 映射**/
    private Long avgReceiveData;

    /** 与 count(receiveData) 映射**/
    private Long countReceiveData;

    /** 与 count(distinctreceiveData) 映射**/
    private Long countDistinctReceiveData;

    /** 与 sum(receiveData) 映射**/
    private Date sumReceiveData;

    /** reportStatus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String reportStatusExpression;

    /** 与 max(reportStatus) 映射**/
    private Long maxReportStatus;

    /** 与 min(reportStatus) 映射**/
    private Long minReportStatus;

    /** 与 avg(reportStatus) 映射**/
    private Long avgReportStatus;

    /** 与 count(reportStatus) 映射**/
    private Long countReportStatus;

    /** 与 count(distinctreportStatus) 映射**/
    private Long countDistinctReportStatus;

    /** 与 sum(reportStatus) 映射**/
    private String sumReportStatus;

    /** serviceCodeAdd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String serviceCodeAddExpression;

    /** 与 max(serviceCodeAdd) 映射**/
    private Long maxServiceCodeAdd;

    /** 与 min(serviceCodeAdd) 映射**/
    private Long minServiceCodeAdd;

    /** 与 avg(serviceCodeAdd) 映射**/
    private Long avgServiceCodeAdd;

    /** 与 count(serviceCodeAdd) 映射**/
    private Long countServiceCodeAdd;

    /** 与 count(distinctserviceCodeAdd) 映射**/
    private Long countDistinctServiceCodeAdd;

    /** 与 sum(serviceCodeAdd) 映射**/
    private String sumServiceCodeAdd;

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

    /** 与 count(distinctsubmitData) 映射**/
    private Long countDistinctSubmitData;

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

    /** 与 count(distinctstatus) 映射**/
    private Long countDistinctStatus;

    /** 与 sum(status) 映射**/
    private String sumStatus;
}