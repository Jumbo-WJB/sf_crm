package com.shufensoft.crm.biz.vo;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/17 上午11:37  
 */
@Data
public class ShakeQueryVO {

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 用户画像
     */
    private String userPortraitId;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 摇一摇标题
     */
    private String rockTitle;

    /**
     * 摇一摇结果
     */
    private String rockResult;

    /**
     * 摇到的时间
     */
    private Date shakeDate;

    /**
     * 领取时间
     */
    private Date obtainDate;

    /**
     * 时间段条件
     */
    private String nDay;

    /**
     * 领取状态
     */
    private String shakeStatus;

    /**
     * 领取ID
     */
    private String rockId;
}
