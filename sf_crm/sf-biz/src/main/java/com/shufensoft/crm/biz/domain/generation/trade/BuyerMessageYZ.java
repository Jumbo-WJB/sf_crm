package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class BuyerMessageYZ {
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

    /** 订单ID */
    private Long oid;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

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
}