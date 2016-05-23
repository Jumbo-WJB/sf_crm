package com.shufensoft.crm.biz.domain.generation.onlineMessage;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class OnlineMessage {
    /** 主键id */
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

    /** 客户姓名 */
    private String name;

    /** 客户手机或座机号码 */
    private String mobile;

    /** 客户qq号码 */
    private String qq;

    /** 客户邮箱地址 */
    private String email;

    /** 公司名称 */
    private String companyName;

    /** 地址 */
    private String address;

    /** 备注信息 */
    private String remark;

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

    /** name属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nameExpression;

    /** 与 max(name) 映射**/
    private Long maxName;

    /** 与 min(name) 映射**/
    private Long minName;

    /** 与 avg(name) 映射**/
    private Long avgName;

    /** 与 count(name) 映射**/
    private Long countName;

    /** 与 sum(name) 映射**/
    private String sumName;

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

    /** qq属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String qqExpression;

    /** 与 max(qq) 映射**/
    private Long maxQq;

    /** 与 min(qq) 映射**/
    private Long minQq;

    /** 与 avg(qq) 映射**/
    private Long avgQq;

    /** 与 count(qq) 映射**/
    private Long countQq;

    /** 与 sum(qq) 映射**/
    private String sumQq;

    /** email属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String emailExpression;

    /** 与 max(email) 映射**/
    private Long maxEmail;

    /** 与 min(email) 映射**/
    private Long minEmail;

    /** 与 avg(email) 映射**/
    private Long avgEmail;

    /** 与 count(email) 映射**/
    private Long countEmail;

    /** 与 sum(email) 映射**/
    private String sumEmail;

    /** companyName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String companyNameExpression;

    /** 与 max(companyName) 映射**/
    private Long maxCompanyName;

    /** 与 min(companyName) 映射**/
    private Long minCompanyName;

    /** 与 avg(companyName) 映射**/
    private Long avgCompanyName;

    /** 与 count(companyName) 映射**/
    private Long countCompanyName;

    /** 与 sum(companyName) 映射**/
    private String sumCompanyName;

    /** address属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String addressExpression;

    /** 与 max(address) 映射**/
    private Long maxAddress;

    /** 与 min(address) 映射**/
    private Long minAddress;

    /** 与 avg(address) 映射**/
    private Long avgAddress;

    /** 与 count(address) 映射**/
    private Long countAddress;

    /** 与 sum(address) 映射**/
    private String sumAddress;

    /** remark属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String remarkExpression;

    /** 与 max(remark) 映射**/
    private Long maxRemark;

    /** 与 min(remark) 映射**/
    private Long minRemark;

    /** 与 avg(remark) 映射**/
    private Long avgRemark;

    /** 与 count(remark) 映射**/
    private Long countRemark;

    /** 与 sum(remark) 映射**/
    private String sumRemark;
}