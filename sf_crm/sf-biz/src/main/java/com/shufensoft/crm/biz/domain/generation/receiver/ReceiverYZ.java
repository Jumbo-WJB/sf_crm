package com.shufensoft.crm.biz.domain.generation.receiver;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ReceiverYZ {
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

    /** 收货人id,作为@BizId */
    @BizId
    private Long receiverIdYz;

    /** 对应user_yz表user_id_yz */
    private Long userIdYz;

    /** 交易创建时间 */
    private Date created;

    /** 收货人的所在城市。 */
    private String receiverCity;

    /** 收货人的所在地区 */
    private String receiverDistrict;

    /** 收货人的姓名 */
    private String receiverName;

    /** 收货人的详细地址 */
    private String receiverAddress;

    /** 收货人的邮编 */
    private String receiverZip;

    /** 收货人的手机号码 */
    private String receiverMobile;

    /** 收货人的所在省份 */
    private String receiverState;

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

    /** receiverIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdYzExpression;

    /** 与 max(receiverIdYz) 映射**/
    private Long maxReceiverIdYz;

    /** 与 min(receiverIdYz) 映射**/
    private Long minReceiverIdYz;

    /** 与 avg(receiverIdYz) 映射**/
    private Long avgReceiverIdYz;

    /** 与 count(receiverIdYz) 映射**/
    private Long countReceiverIdYz;

    /** 与 sum(receiverIdYz) 映射**/
    private Long sumReceiverIdYz;

    /** userIdYz属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdYzExpression;

    /** 与 max(userIdYz) 映射**/
    private Long maxUserIdYz;

    /** 与 min(userIdYz) 映射**/
    private Long minUserIdYz;

    /** 与 avg(userIdYz) 映射**/
    private Long avgUserIdYz;

    /** 与 count(userIdYz) 映射**/
    private Long countUserIdYz;

    /** 与 sum(userIdYz) 映射**/
    private Long sumUserIdYz;

    /** created属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdExpression;

    /** 与 max(created) 映射**/
    private Long maxCreated;

    /** 与 min(created) 映射**/
    private Long minCreated;

    /** 与 avg(created) 映射**/
    private Long avgCreated;

    /** 与 count(created) 映射**/
    private Long countCreated;

    /** 与 sum(created) 映射**/
    private Date sumCreated;

    /** receiverCity属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverCityExpression;

    /** 与 max(receiverCity) 映射**/
    private Long maxReceiverCity;

    /** 与 min(receiverCity) 映射**/
    private Long minReceiverCity;

    /** 与 avg(receiverCity) 映射**/
    private Long avgReceiverCity;

    /** 与 count(receiverCity) 映射**/
    private Long countReceiverCity;

    /** 与 sum(receiverCity) 映射**/
    private String sumReceiverCity;

    /** receiverDistrict属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverDistrictExpression;

    /** 与 max(receiverDistrict) 映射**/
    private Long maxReceiverDistrict;

    /** 与 min(receiverDistrict) 映射**/
    private Long minReceiverDistrict;

    /** 与 avg(receiverDistrict) 映射**/
    private Long avgReceiverDistrict;

    /** 与 count(receiverDistrict) 映射**/
    private Long countReceiverDistrict;

    /** 与 sum(receiverDistrict) 映射**/
    private String sumReceiverDistrict;

    /** receiverName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverNameExpression;

    /** 与 max(receiverName) 映射**/
    private Long maxReceiverName;

    /** 与 min(receiverName) 映射**/
    private Long minReceiverName;

    /** 与 avg(receiverName) 映射**/
    private Long avgReceiverName;

    /** 与 count(receiverName) 映射**/
    private Long countReceiverName;

    /** 与 sum(receiverName) 映射**/
    private String sumReceiverName;

    /** receiverAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverAddressExpression;

    /** 与 max(receiverAddress) 映射**/
    private Long maxReceiverAddress;

    /** 与 min(receiverAddress) 映射**/
    private Long minReceiverAddress;

    /** 与 avg(receiverAddress) 映射**/
    private Long avgReceiverAddress;

    /** 与 count(receiverAddress) 映射**/
    private Long countReceiverAddress;

    /** 与 sum(receiverAddress) 映射**/
    private String sumReceiverAddress;

    /** receiverZip属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverZipExpression;

    /** 与 max(receiverZip) 映射**/
    private Long maxReceiverZip;

    /** 与 min(receiverZip) 映射**/
    private Long minReceiverZip;

    /** 与 avg(receiverZip) 映射**/
    private Long avgReceiverZip;

    /** 与 count(receiverZip) 映射**/
    private Long countReceiverZip;

    /** 与 sum(receiverZip) 映射**/
    private String sumReceiverZip;

    /** receiverMobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverMobileExpression;

    /** 与 max(receiverMobile) 映射**/
    private Long maxReceiverMobile;

    /** 与 min(receiverMobile) 映射**/
    private Long minReceiverMobile;

    /** 与 avg(receiverMobile) 映射**/
    private Long avgReceiverMobile;

    /** 与 count(receiverMobile) 映射**/
    private Long countReceiverMobile;

    /** 与 sum(receiverMobile) 映射**/
    private String sumReceiverMobile;

    /** receiverState属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverStateExpression;

    /** 与 max(receiverState) 映射**/
    private Long maxReceiverState;

    /** 与 min(receiverState) 映射**/
    private Long minReceiverState;

    /** 与 avg(receiverState) 映射**/
    private Long avgReceiverState;

    /** 与 count(receiverState) 映射**/
    private Long countReceiverState;

    /** 与 sum(receiverState) 映射**/
    private String sumReceiverState;
}