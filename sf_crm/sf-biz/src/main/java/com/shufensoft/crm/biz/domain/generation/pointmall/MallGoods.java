package com.shufensoft.crm.biz.domain.generation.pointmall;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class MallGoods {
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

    /** 商品id,作为@BizId */
    @BizId
    private Long goodsId;

    /** 商品标题 */
    private String title;

    /** 叶子类目id */
    private Long categoryId;

    /** 是否虚拟商品 y是 n否 */
    private String isVirtual;

    /** 上架时间 */
    private Date listTime;

    /** 下架时间 */
    private Date delistTime;

    /** 状态  onsale：在售中 instock：在库中 */
    private String status;

    /** 数量 */
    private Long quantity;

    /** 价格 */
    private Long price;

    /** 	兑换所需积分 */
    private Long point;

    /** 已兑换数量 */
    private Long exchangeAmount;

    /**  详情页 */
    private String detailUrl;

    /**  二维码图片链接 */
    private String qrUrl;

    /**  图片列表 */
    private String imgsUrl;

    /** 商品小图,显示在首页和列表中的图片 */
    private String thumbnail;

    /**  以逗号分隔的skuId */
    private String skus;

    /** 	属性串pid:vid */
    private String props;

    /**  属性名串	pid:vid:pid_name:vid_name */
    private String propsName;

    /** 	外部编码 */
    private String outerId;

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

    /** 与 sum(goodsId) 映射**/
    private Long sumGoodsId;

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

    /** categoryId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String categoryIdExpression;

    /** 与 max(categoryId) 映射**/
    private Long maxCategoryId;

    /** 与 min(categoryId) 映射**/
    private Long minCategoryId;

    /** 与 avg(categoryId) 映射**/
    private Long avgCategoryId;

    /** 与 count(categoryId) 映射**/
    private Long countCategoryId;

    /** 与 sum(categoryId) 映射**/
    private Long sumCategoryId;

    /** isVirtual属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isVirtualExpression;

    /** 与 max(isVirtual) 映射**/
    private Long maxIsVirtual;

    /** 与 min(isVirtual) 映射**/
    private Long minIsVirtual;

    /** 与 avg(isVirtual) 映射**/
    private Long avgIsVirtual;

    /** 与 count(isVirtual) 映射**/
    private Long countIsVirtual;

    /** 与 sum(isVirtual) 映射**/
    private String sumIsVirtual;

    /** listTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String listTimeExpression;

    /** 与 max(listTime) 映射**/
    private Long maxListTime;

    /** 与 min(listTime) 映射**/
    private Long minListTime;

    /** 与 avg(listTime) 映射**/
    private Long avgListTime;

    /** 与 count(listTime) 映射**/
    private Long countListTime;

    /** 与 sum(listTime) 映射**/
    private Date sumListTime;

    /** delistTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String delistTimeExpression;

    /** 与 max(delistTime) 映射**/
    private Long maxDelistTime;

    /** 与 min(delistTime) 映射**/
    private Long minDelistTime;

    /** 与 avg(delistTime) 映射**/
    private Long avgDelistTime;

    /** 与 count(delistTime) 映射**/
    private Long countDelistTime;

    /** 与 sum(delistTime) 映射**/
    private Date sumDelistTime;

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

    /** 与 sum(quantity) 映射**/
    private Long sumQuantity;

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

    /** 与 sum(price) 映射**/
    private Long sumPrice;

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

    /** 与 sum(point) 映射**/
    private Long sumPoint;

    /** exchangeAmount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String exchangeAmountExpression;

    /** 与 max(exchangeAmount) 映射**/
    private Long maxExchangeAmount;

    /** 与 min(exchangeAmount) 映射**/
    private Long minExchangeAmount;

    /** 与 avg(exchangeAmount) 映射**/
    private Long avgExchangeAmount;

    /** 与 count(exchangeAmount) 映射**/
    private Long countExchangeAmount;

    /** 与 sum(exchangeAmount) 映射**/
    private Long sumExchangeAmount;

    /** detailUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String detailUrlExpression;

    /** 与 max(detailUrl) 映射**/
    private Long maxDetailUrl;

    /** 与 min(detailUrl) 映射**/
    private Long minDetailUrl;

    /** 与 avg(detailUrl) 映射**/
    private Long avgDetailUrl;

    /** 与 count(detailUrl) 映射**/
    private Long countDetailUrl;

    /** 与 sum(detailUrl) 映射**/
    private String sumDetailUrl;

    /** qrUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String qrUrlExpression;

    /** 与 max(qrUrl) 映射**/
    private Long maxQrUrl;

    /** 与 min(qrUrl) 映射**/
    private Long minQrUrl;

    /** 与 avg(qrUrl) 映射**/
    private Long avgQrUrl;

    /** 与 count(qrUrl) 映射**/
    private Long countQrUrl;

    /** 与 sum(qrUrl) 映射**/
    private String sumQrUrl;

    /** imgsUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String imgsUrlExpression;

    /** 与 max(imgsUrl) 映射**/
    private Long maxImgsUrl;

    /** 与 min(imgsUrl) 映射**/
    private Long minImgsUrl;

    /** 与 avg(imgsUrl) 映射**/
    private Long avgImgsUrl;

    /** 与 count(imgsUrl) 映射**/
    private Long countImgsUrl;

    /** 与 sum(imgsUrl) 映射**/
    private String sumImgsUrl;

    /** thumbnail属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String thumbnailExpression;

    /** 与 max(thumbnail) 映射**/
    private Long maxThumbnail;

    /** 与 min(thumbnail) 映射**/
    private Long minThumbnail;

    /** 与 avg(thumbnail) 映射**/
    private Long avgThumbnail;

    /** 与 count(thumbnail) 映射**/
    private Long countThumbnail;

    /** 与 sum(thumbnail) 映射**/
    private String sumThumbnail;

    /** skus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String skusExpression;

    /** 与 max(skus) 映射**/
    private Long maxSkus;

    /** 与 min(skus) 映射**/
    private Long minSkus;

    /** 与 avg(skus) 映射**/
    private Long avgSkus;

    /** 与 count(skus) 映射**/
    private Long countSkus;

    /** 与 sum(skus) 映射**/
    private String sumSkus;

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

    /** 与 sum(props) 映射**/
    private String sumProps;

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

    /** 与 sum(propsName) 映射**/
    private String sumPropsName;

    /** outerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String outerIdExpression;

    /** 与 max(outerId) 映射**/
    private Long maxOuterId;

    /** 与 min(outerId) 映射**/
    private Long minOuterId;

    /** 与 avg(outerId) 映射**/
    private Long avgOuterId;

    /** 与 count(outerId) 映射**/
    private Long countOuterId;

    /** 与 sum(outerId) 映射**/
    private String sumOuterId;

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

    /** 与 sum(version) 映射**/
    private Long sumVersion;

    /**
     * 详情页信息, 非数据库字段
     * */
    private String goodsDetail;

}