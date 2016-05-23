package com.shufensoft.crm.biz.domain.generation.job;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class JobDetail {
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

    /** 商户号 */
    private Long sellerId;

    /** 店铺Id */
    private Long shopId;

    /** job名称 */
    private String jobName;

    /** 描述 */
    private String jobDemo;

    /** 数据同步结束时间 */
    private Date endSyncDataTime;

    /** 数据同步时间间隔:单位s */
    private Integer syncDataIntervalTime;

    /** 数据处理节点id表示 */
    private String syncFlagId;

    /** 任务结束时间 */
    private Date endTime;

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

    /** jobName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jobNameExpression;

    /** 与 max(jobName) 映射**/
    private Long maxJobName;

    /** 与 min(jobName) 映射**/
    private Long minJobName;

    /** 与 avg(jobName) 映射**/
    private Long avgJobName;

    /** 与 count(jobName) 映射**/
    private Long countJobName;

    /** 与 sum(jobName) 映射**/
    private String sumJobName;

    /** jobDemo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jobDemoExpression;

    /** 与 max(jobDemo) 映射**/
    private Long maxJobDemo;

    /** 与 min(jobDemo) 映射**/
    private Long minJobDemo;

    /** 与 avg(jobDemo) 映射**/
    private Long avgJobDemo;

    /** 与 count(jobDemo) 映射**/
    private Long countJobDemo;

    /** 与 sum(jobDemo) 映射**/
    private String sumJobDemo;

    /** endSyncDataTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endSyncDataTimeExpression;

    /** 与 max(endSyncDataTime) 映射**/
    private Long maxEndSyncDataTime;

    /** 与 min(endSyncDataTime) 映射**/
    private Long minEndSyncDataTime;

    /** 与 avg(endSyncDataTime) 映射**/
    private Long avgEndSyncDataTime;

    /** 与 count(endSyncDataTime) 映射**/
    private Long countEndSyncDataTime;

    /** 与 sum(endSyncDataTime) 映射**/
    private Date sumEndSyncDataTime;

    /** syncDataIntervalTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String syncDataIntervalTimeExpression;

    /** 与 max(syncDataIntervalTime) 映射**/
    private Long maxSyncDataIntervalTime;

    /** 与 min(syncDataIntervalTime) 映射**/
    private Long minSyncDataIntervalTime;

    /** 与 avg(syncDataIntervalTime) 映射**/
    private Long avgSyncDataIntervalTime;

    /** 与 count(syncDataIntervalTime) 映射**/
    private Long countSyncDataIntervalTime;

    /** 与 sum(syncDataIntervalTime) 映射**/
    private Integer sumSyncDataIntervalTime;

    /** syncFlagId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String syncFlagIdExpression;

    /** 与 max(syncFlagId) 映射**/
    private Long maxSyncFlagId;

    /** 与 min(syncFlagId) 映射**/
    private Long minSyncFlagId;

    /** 与 avg(syncFlagId) 映射**/
    private Long avgSyncFlagId;

    /** 与 count(syncFlagId) 映射**/
    private Long countSyncFlagId;

    /** 与 sum(syncFlagId) 映射**/
    private String sumSyncFlagId;

    /** endTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endTimeExpression;

    /** 与 max(endTime) 映射**/
    private Long maxEndTime;

    /** 与 min(endTime) 映射**/
    private Long minEndTime;

    /** 与 avg(endTime) 映射**/
    private Long avgEndTime;

    /** 与 count(endTime) 映射**/
    private Long countEndTime;

    /** 与 sum(endTime) 映射**/
    private Date sumEndTime;
}