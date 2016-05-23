package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 */
@Data
@ToString
public class MallFansDo {

    /** 修改时间 */
    private Date gmtModified;

    /** 商户号 */
    private Long sellerId;

    /** 用户Id */
    private Long userId;

    /** 兑换的积分数量 */
    private Long amount = 0L;

    /** 兑换id：如果为红包，那么是红包id，如果为礼物，那么是礼物订单id */
    private Long exchangeId;

    /** 兑换方式：hongbao 红包 lw 礼物 */
    private String exchangeMethod;

    /** 成功y 失败n 进行中i */
    private String status;

    /*** 用户微信昵称  */
    private String wxNickName;

    /** 客户姓名 */
    private String userName;

    /*** 累计兑换金额 */
    private Long paymentTotal = 0L;

    /**兑换次数*/
    private int exchageCount = 0;

    /** 累计获得积分 */
    private Long pointTotal = 0L;

    /** 已兑换积分 */
    private Long exchagePointTotal = 0L;

    /**最后一次兑换类型, 可能是商品, 也可能红包*/
    private String lastExchageType;

    /**
     * 是否粉丝
     * */
    private String isFans;

    /**是否老客户*/
    private String isOldUser;       // 1:老客户, 0:新客户

    /**
     * 累计互动次数
     * */
    private int interactionCount = 0;

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getExchangeMethod() {
        return exchangeMethod;
    }

    public void setExchangeMethod(String exchangeMethod) {
        this.exchangeMethod = exchangeMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Long paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public int getExchageCount() {
        return exchageCount;
    }

    public void setExchageCount(int exchageCount) {
        this.exchageCount = exchageCount;
    }

    public Long getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(Long pointTotal) {
        this.pointTotal = pointTotal;
    }

    public Long getExchagePointTotal() {
        return exchagePointTotal;
    }

    public void setExchagePointTotal(Long exchagePointTotal) {
        this.exchagePointTotal = exchagePointTotal;
    }

    public String getLastExchageType() {
        return lastExchageType;
    }

    public void setLastExchageType(String lastExchageType) {
        this.lastExchageType = lastExchageType;
    }

    public String getIsFans() {
        return isFans;
    }

    public void setIsFans(String isFans) {
        this.isFans = isFans;
    }

    public String getIsOldUser() {
        return isOldUser;
    }

    public void setIsOldUser(String isOldUser) {
        this.isOldUser = isOldUser;
    }

    public int getInteractionCount() {
        return interactionCount;
    }

    public void setInteractionCount(int interactionCount) {
        this.interactionCount = interactionCount;
    }

    private String startDate;

    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
