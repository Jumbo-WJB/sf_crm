package com.shufensoft.crm.biz.service.pointmall.vo;

import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-06 16:46  
 */
@ToString
public class TradeVo {

    private long sellerId;

    private long userId;

    private long tid;

    private String status;

    private Date payTime;

    private Date created;

    private Date modified;

    private Date consignTime;

    private Date endTime;

    private long receiverId;

    private String type;

    private long fee;

    private long feePoint;

    private long payment;

    private long paymentPoint;

    private String shippingCompany;

    private String shippingType;

    private String shippingId;

    private long shippingFee;

    private List<OrderVo> orderVoList;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
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

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public long getFeePoint() {
        return feePoint;
    }

    public void setFeePoint(long feePoint) {
        this.feePoint = feePoint;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public long getPaymentPoint() {
        return paymentPoint;
    }

    public void setPaymentPoint(long paymentPoint) {
        this.paymentPoint = paymentPoint;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
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

    public long getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(long shippingFee) {
        this.shippingFee = shippingFee;
    }

    public List<OrderVo> getOrderVoList() {
        return orderVoList;
    }

    public void setOrderVoList(List<OrderVo> orderVoList) {
        this.orderVoList = orderVoList;
    }
}
