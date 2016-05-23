package com.shufensoft.crm.biz.domain.generation.receiver;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ReceiverTaoBao {
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
    private Long receiverIdTb;

    /** 关联user_taobao表user_id_tb */
    private Long userIdTb;

    /** 交易创建时间。 格式: yyyy -MM - dd HH: mm :ss */
    private Date created;

    /** 收货人姓名 */
    private String receiverName;

    /** 国家 */
    private String receiverCountry;

    /** 收货人的所在省份 */
    private String receiverState;

    /**  收货人城市 */
    private String receiverCity;

    /**  收货人地区 */
    private String receiverDistrict;

    /** 城镇 */
    private String receiverTown;

    /** 收货人的详细地址 */
    private String receiverAddress;

    /** 收货人邮编 */
    private String receiverZip;

    /** 收货人手机号码 */
    private String receiverMobile;

    /** 收货人电话 */
    private String receiverPhone;

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

    /** receiverIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdTbExpression;

    /** 与 max(receiverIdTb) 映射**/
    private Long maxReceiverIdTb;

    /** 与 min(receiverIdTb) 映射**/
    private Long minReceiverIdTb;

    /** 与 avg(receiverIdTb) 映射**/
    private Long avgReceiverIdTb;

    /** 与 count(receiverIdTb) 映射**/
    private Long countReceiverIdTb;

    /** 与 sum(receiverIdTb) 映射**/
    private Long sumReceiverIdTb;

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

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

    /** receiverCountry属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverCountryExpression;

    /** 与 max(receiverCountry) 映射**/
    private Long maxReceiverCountry;

    /** 与 min(receiverCountry) 映射**/
    private Long minReceiverCountry;

    /** 与 avg(receiverCountry) 映射**/
    private Long avgReceiverCountry;

    /** 与 count(receiverCountry) 映射**/
    private Long countReceiverCountry;

    /** 与 sum(receiverCountry) 映射**/
    private String sumReceiverCountry;

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

    /** receiverTown属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverTownExpression;

    /** 与 max(receiverTown) 映射**/
    private Long maxReceiverTown;

    /** 与 min(receiverTown) 映射**/
    private Long minReceiverTown;

    /** 与 avg(receiverTown) 映射**/
    private Long avgReceiverTown;

    /** 与 count(receiverTown) 映射**/
    private Long countReceiverTown;

    /** 与 sum(receiverTown) 映射**/
    private String sumReceiverTown;

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

    /** receiverPhone属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverPhoneExpression;

    /** 与 max(receiverPhone) 映射**/
    private Long maxReceiverPhone;

    /** 与 min(receiverPhone) 映射**/
    private Long minReceiverPhone;

    /** 与 avg(receiverPhone) 映射**/
    private Long avgReceiverPhone;

    /** 与 count(receiverPhone) 映射**/
    private Long countReceiverPhone;

    /** 与 sum(receiverPhone) 映射**/
    private String sumReceiverPhone;

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