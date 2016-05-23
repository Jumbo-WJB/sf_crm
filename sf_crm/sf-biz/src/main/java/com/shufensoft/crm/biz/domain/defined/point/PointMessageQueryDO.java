package com.shufensoft.crm.biz.domain.defined.point;

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
public class PointMessageQueryDO {

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
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 手机号码
     */
    private String mobile;

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

