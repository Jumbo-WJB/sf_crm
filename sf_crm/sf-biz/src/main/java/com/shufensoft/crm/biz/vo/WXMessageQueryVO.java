package com.shufensoft.crm.biz.vo;

import lombok.Data;

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
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户查询内容
     */
    private String receiveContent;

    /**
     * 商家回复内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private String replyTime;

    /**
     * 查询时间
     */
    private String createTime;

    /**
     * 查询次数
     */
    private String times;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 查询类型
     */
    private String bizType;

    /**
     * 用户来源
     */
    private String firstSource;

    /**
     * openid
     */
    private String wxOpenid;

}
