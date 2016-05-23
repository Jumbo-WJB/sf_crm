package com.shufensoft.crm.biz.vo;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/29 下午9:14  
 */
@Data
public class WXMessageQueryVO {

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 回复内容
     */
    private String replyContent;


    /**
     * 查询时间
     */
    private String createTime;

    /**
     * 回复时间
     */
    private Date replyCreateTime;

    /**
     * 查询次数
     */
    private String times;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 淘宝买家昵称
     */
    private String tbBuyerNick;

    /**
     * 查询类型
     */
    private String bizType;

    /**
     * 信息类型
     */
    private String msgType;

    /**
     * 用户来源
     */
    private String firstSource;

    /**
     * openid
     */
    private String wxOpenid;


    private String toSend;

    /**
     * 目标用户（OPENID）
     */
    private String toUserName;

}
