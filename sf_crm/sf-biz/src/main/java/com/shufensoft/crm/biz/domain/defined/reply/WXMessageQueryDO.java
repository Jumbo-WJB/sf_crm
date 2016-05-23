package com.shufensoft.crm.biz.domain.defined.reply;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/29 下午10:57  
 */
@Data
public class WXMessageQueryDO {

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * msgId
     */
    private String msgId;

    /**
     * 淘宝买家昵称
     */
    private String tbBuyerNick;

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
     * 回复类型
     */
    private String replyType;

    /**
     * 查询时间
     */
    private Date createTime;

    /**
     * 回复时间
     */
    private Date replyCreateTime;

    /**
     * 查询次数
     */
    private String times;

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

    /**
     * 目标用户（OPENID）
     */
    private String toUserName;

}

