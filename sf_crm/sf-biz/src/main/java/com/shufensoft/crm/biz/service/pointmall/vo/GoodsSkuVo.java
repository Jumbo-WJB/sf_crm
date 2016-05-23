package com.shufensoft.crm.biz.service.pointmall.vo;


import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-02 19:53  
 */
public class GoodsSkuVo {

    private long sellerId;

    private long goodsId;

    private long skuId;

    private List<PropValue> propValueList;

    private List<PropValueName> propValueNameList;

    private long quantity;

    private long price;

    private long point;

    private String outerSkuId;

    /** 销售属性的组合，p1:v1; p2:v2; */
    private String props;

    /** P1:v1:p1_name:v1_name;p2:v2:p2_name:v2_name */
    private String propsName;

    public String getPropValueListString() {
        StringBuffer buf = new StringBuffer();
        for(PropValue propValue : propValueList) {
            buf.append(propValue.toString() + ";");
        }
        return buf.toString();
    }

    public String getPropValueNameListString() {
        StringBuffer buf = new StringBuffer();
        for(PropValueName propValueName : propValueNameList) {
            buf.append(propValueName.toString() + ";");
        }
        return buf.toString();
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public String getOuterSkuId() {
        return outerSkuId;
    }

    public void setOuterSkuId(String outerSkuId) {
        this.outerSkuId = outerSkuId;
    }

    public List<PropValue> getPropValueList() {
        return propValueList;
    }

    public void setPropValueList(List<PropValue> propValueList) {
        this.propValueList = propValueList;
    }

    public List<PropValueName> getPropValueNameList() {
        return propValueNameList;
    }

    public void setPropValueNameList(List<PropValueName> propValueNameList) {
        this.propValueNameList = propValueNameList;
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
}
