package com.shufensoft.crm.biz.domain.defined.pointMall;

import com.shufensoft.crm.biz.annotation.BizId;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class MallTradeDo {
    /** 主键ID */
    private Long id;

    /** 商户号 */
    private Long sellerId;

    /** 用户id */
    private Long userId;

    /**  交易id,作为@BizId */
    @BizId
    private Long tid;

    /** 交易状态：WAIT_BUYER_PAY WAIT_SELLER_SEND_GOODS WAIT_BUYER_CONFIRM_GOODS TRADE_FINISHED TRADE_CLOSED TRADE_CLOSED_BY_TAOBAO */
    private String status;

    /** 		付款时间 */
    private Date payTime;

    /** 		创建时间 */
    private Date created;

    /** 		修改时间 */
    private Date modified;

    /** 		发货时间 */
    private Date consignTime;

    /** 		结束时间 */
    private Date endTime;

    /** 		收件人id */
    private Long receiverId;

    /** 	订单类型 */
    private String type;

    /** 		应付款（以分为单位） */
    private Long fee;

    /** 		应付积分 */
    private Long feePoint;

    /** 		实付款（以分为单位） */
    private Long payment;

    /** 		实付积分 */
    private Long paymentPoint;

    /**  快递方式：free(卖家包邮) post(平邮) express(快递) ems(EMS) virtual(虚拟发货) */
    private String shippingType;

    /**  运单号 */
    private String shippingId;

    /**  快递公司 */
    private String shippingCompany;

    /**  快递费 */
    private Long shippingFee;

    /**
     *  包含的商品SKU信息
     * */
    private List<MallGoodsSkuDo> mallGoodsSkuDoList;

    /** 	姓名 */
    private String name;

    /** 	手机 */
    private String mobile;

    /** 	省 */
    private String province;

    /** 	市 */
    private String city;

    /** 	区 */
    private String district;

    /** 	地址 */
    private String address;

    /** 邮编 */
    private String zip;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Long getFeePoint() {
        return feePoint;
    }

    public void setFeePoint(Long feePoint) {
        this.feePoint = feePoint;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public Long getPaymentPoint() {
        return paymentPoint;
    }

    public void setPaymentPoint(Long paymentPoint) {
        this.paymentPoint = paymentPoint;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public Long getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Long shippingFee) {
        this.shippingFee = shippingFee;
    }

    public List<MallGoodsSkuDo> getMallGoodsSkuDoList() {
        return mallGoodsSkuDoList;
    }

    public void setMallGoodsSkuDoList(List<MallGoodsSkuDo> mallGoodsSkuDoList) {
        this.mallGoodsSkuDoList = mallGoodsSkuDoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}