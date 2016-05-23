package com.shufensoft.crm.biz.domain.defined.pointMall;

import com.shufensoft.crm.biz.annotation.BizId;
import lombok.ToString;

@ToString
public class MallGoodsSkuDo {
    /** 主键ID */
    private Long id;

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

    /**  商品名(title,规格) */
    private String goodsName;

    /**  商品图片,多张图片取第一张*/
    private String goodsImgUrl;

    /** 兑换数量 */
    private int buyAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getPropsName() {
        return propsName;
    }

    public void setPropsName(String propsName) {
        this.propsName = propsName;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }
}