package com.shufensoft.crm.biz.domain.generation.receiver;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class ReceiverJD {
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
    private Long receiverIdJd;

    /** 交易创建时间 */
    private Date created;

    /** 对应user_jd表user_id_jd */
    private Long userIdJd;

    /** 姓名 */
    private String fullname;

    /** 固定电话 */
    private String telephone;

    /** 手机 */
    private String mobile;

    /** 地址 */
    private String fullAddress;

    /** 省（省、市、县分级返回结果以下单地址为准） */
    private String province;

    /** 市（省、市、县分级返回结果以下单地址为准） */
    private String city;

    /** 县（省、市、县分级返回结果以下单地址为准） */
    private String county;

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

    /** receiverIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdJdExpression;

    /** 与 max(receiverIdJd) 映射**/
    private Long maxReceiverIdJd;

    /** 与 min(receiverIdJd) 映射**/
    private Long minReceiverIdJd;

    /** 与 avg(receiverIdJd) 映射**/
    private Long avgReceiverIdJd;

    /** 与 count(receiverIdJd) 映射**/
    private Long countReceiverIdJd;

    /** 与 sum(receiverIdJd) 映射**/
    private Long sumReceiverIdJd;

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

    /** userIdJd属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdJdExpression;

    /** 与 max(userIdJd) 映射**/
    private Long maxUserIdJd;

    /** 与 min(userIdJd) 映射**/
    private Long minUserIdJd;

    /** 与 avg(userIdJd) 映射**/
    private Long avgUserIdJd;

    /** 与 count(userIdJd) 映射**/
    private Long countUserIdJd;

    /** 与 sum(userIdJd) 映射**/
    private Long sumUserIdJd;

    /** fullname属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String fullnameExpression;

    /** 与 max(fullname) 映射**/
    private Long maxFullname;

    /** 与 min(fullname) 映射**/
    private Long minFullname;

    /** 与 avg(fullname) 映射**/
    private Long avgFullname;

    /** 与 count(fullname) 映射**/
    private Long countFullname;

    /** 与 sum(fullname) 映射**/
    private String sumFullname;

    /** telephone属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String telephoneExpression;

    /** 与 max(telephone) 映射**/
    private Long maxTelephone;

    /** 与 min(telephone) 映射**/
    private Long minTelephone;

    /** 与 avg(telephone) 映射**/
    private Long avgTelephone;

    /** 与 count(telephone) 映射**/
    private Long countTelephone;

    /** 与 sum(telephone) 映射**/
    private String sumTelephone;

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

    /** fullAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String fullAddressExpression;

    /** 与 max(fullAddress) 映射**/
    private Long maxFullAddress;

    /** 与 min(fullAddress) 映射**/
    private Long minFullAddress;

    /** 与 avg(fullAddress) 映射**/
    private Long avgFullAddress;

    /** 与 count(fullAddress) 映射**/
    private Long countFullAddress;

    /** 与 sum(fullAddress) 映射**/
    private String sumFullAddress;

    /** province属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String provinceExpression;

    /** 与 max(province) 映射**/
    private Long maxProvince;

    /** 与 min(province) 映射**/
    private Long minProvince;

    /** 与 avg(province) 映射**/
    private Long avgProvince;

    /** 与 count(province) 映射**/
    private Long countProvince;

    /** 与 sum(province) 映射**/
    private String sumProvince;

    /** city属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String cityExpression;

    /** 与 max(city) 映射**/
    private Long maxCity;

    /** 与 min(city) 映射**/
    private Long minCity;

    /** 与 avg(city) 映射**/
    private Long avgCity;

    /** 与 count(city) 映射**/
    private Long countCity;

    /** 与 sum(city) 映射**/
    private String sumCity;

    /** county属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String countyExpression;

    /** 与 max(county) 映射**/
    private Long maxCounty;

    /** 与 min(county) 映射**/
    private Long minCounty;

    /** 与 avg(county) 映射**/
    private Long avgCounty;

    /** 与 count(county) 映射**/
    private Long countCounty;

    /** 与 sum(county) 映射**/
    private String sumCounty;

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