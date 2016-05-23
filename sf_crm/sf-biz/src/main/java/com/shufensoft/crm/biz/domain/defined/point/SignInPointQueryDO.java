package com.shufensoft.crm.biz.domain.defined.point;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/4 下午3:18  
 */
@Data
public class SignInPointQueryDO {

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 名称
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 是否是老用户
     */
    private String isOldUser;

    /**
     * 累积积分
     */
    private String pointAmountTotal;

    /**
     * 累积购买次数
     */
    private String totalPurchaseTimes;

    /**
     * 签到次数
     */
    private String signInTimes;

    /**
     * 最后一次签到时间
     */
    private String lastSignInDate;

    /**
     * 排序关键字
     */
    private String orderBy;

    /**
     * 累积签到的积分
     */
    private String amount;
}
