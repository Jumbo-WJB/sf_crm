package com.shufensoft.crm.biz.domain.generation.pointmall;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MallGoodsSku {
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

    /**  商品id */
    private Long goodsId;

    /**  sku id,作为@BizId */
    @BizId
    private Long skuId;

    /** 库存数量 */
    private Long quantity;

    /** 	价格，以分为单位 */
    private Long price;

    /** 	兑换所需积分 */
    private Long point;

    /** 销售属性的组合，p1:v1; p2:v2; */
    private String props;

    /** P1:v1:p1_name:v1_name;p2:v2:p2_name:v2_name */
    private String propsName;

    /** 	外部编码 */
    private String outerSkuId;

    /** 版本号 */
    private Long version = 0L;

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

    /** goodsId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsIdExpression;

    /** 与 max(goodsId) 映射**/
    private Long maxGoodsId;

    /** 与 min(goodsId) 映射**/
    private Long minGoodsId;

    /** 与 avg(goodsId) 映射**/
    private Long avgGoodsId;

    /** 与 count(goodsId) 映射**/
    private Long countGoodsId;

    /** skuId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skuIdExpression;

    /** 与 max(skuId) 映射**/
    private Long maxSkuId;

    /** 与 min(skuId) 映射**/
    private Long minSkuId;

    /** 与 avg(skuId) 映射**/
    private Long avgSkuId;

    /** 与 count(skuId) 映射**/
    private Long countSkuId;

    /** quantity属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String quantityExpression;

    /** 与 max(quantity) 映射**/
    private Long maxQuantity;

    /** 与 min(quantity) 映射**/
    private Long minQuantity;

    /** 与 avg(quantity) 映射**/
    private Long avgQuantity;

    /** 与 count(quantity) 映射**/
    private Long countQuantity;

    /** price属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String priceExpression;

    /** 与 max(price) 映射**/
    private Long maxPrice;

    /** 与 min(price) 映射**/
    private Long minPrice;

    /** 与 avg(price) 映射**/
    private Long avgPrice;

    /** 与 count(price) 映射**/
    private Long countPrice;

    /** point属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointExpression;

    /** 与 max(point) 映射**/
    private Long maxPoint;

    /** 与 min(point) 映射**/
    private Long minPoint;

    /** 与 avg(point) 映射**/
    private Long avgPoint;

    /** 与 count(point) 映射**/
    private Long countPoint;

    /** props属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String propsExpression;

    /** 与 max(props) 映射**/
    private Long maxProps;

    /** 与 min(props) 映射**/
    private Long minProps;

    /** 与 avg(props) 映射**/
    private Long avgProps;

    /** 与 count(props) 映射**/
    private Long countProps;

    /** propsName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String propsNameExpression;

    /** 与 max(propsName) 映射**/
    private Long maxPropsName;

    /** 与 min(propsName) 映射**/
    private Long minPropsName;

    /** 与 avg(propsName) 映射**/
    private Long avgPropsName;

    /** 与 count(propsName) 映射**/
    private Long countPropsName;

    /** outerSkuId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerSkuIdExpression;

    /** 与 max(outerSkuId) 映射**/
    private Long maxOuterSkuId;

    /** 与 min(outerSkuId) 映射**/
    private Long minOuterSkuId;

    /** 与 avg(outerSkuId) 映射**/
    private Long avgOuterSkuId;

    /** 与 count(outerSkuId) 映射**/
    private Long countOuterSkuId;

    /** version属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String versionExpression;

    /** 与 max(version) 映射**/
    private Long maxVersion;

    /** 与 min(version) 映射**/
    private Long minVersion;

    /** 与 avg(version) 映射**/
    private Long avgVersion;

    /** 与 count(version) 映射**/
    private Long countVersion;
}