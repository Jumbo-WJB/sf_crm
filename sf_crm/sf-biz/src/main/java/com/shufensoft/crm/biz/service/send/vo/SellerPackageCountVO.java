package com.shufensoft.crm.biz.service.send.vo;


import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/30 下午5:04  
 */
@Data
public class SellerPackageCountVO {


    /**
     * 商户ID
     */
    private String sellerId;

    /**
     * 商户套餐余额
     */
    private Long sellerPackageRemain;

    /**
     * 商户套餐总数
     */
    private Long sellerPackageTotal;

    /**
     * 商户套餐已使用数
     */
    private Long sellerPackageUsed;

    /**
     * 商户套餐过期数
     */
    private Long sellerPackageExpired;

    /**
     * 版本号，用于乐观锁
     */
    private Long sellerPackageVersion;

    /**
     * 套餐类型，SMS:短信，MAIL：邮件
     */
    private String sellerPackageType;

    /**
     * 累积发送次数
     */
    private int sendTimes;

    /**
     * 成功率
     */
    private float sendSucRate;

    /**
     * 邮件打开率
     */
    private float emailOpenRate;




}
