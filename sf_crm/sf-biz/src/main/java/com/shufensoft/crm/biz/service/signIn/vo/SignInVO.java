package com.shufensoft.crm.biz.service.signIn.vo;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/20 下午9:46  
 */
@Data
public class SignInVO {

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 签到次数
     */
    private String signInTimes;

    /**
     * 签到名次
     */
    private String signInRank;

    /**
     * 签到时间
     */
    private String signInDate;

    /**
     * 开始时间
     */
    private Date obtainStartDate;

    /**
     * 结束时间
     */
    private Date obtainEndDate;

    /**
     * 用户ID
     */
    private Long userId;


}