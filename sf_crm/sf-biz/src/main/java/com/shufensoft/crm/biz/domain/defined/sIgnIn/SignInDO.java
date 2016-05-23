package com.shufensoft.crm.biz.domain.defined.sIgnIn;

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
public class SignInDO {

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
     * 用户ID
     */
    private Long userId;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 签到名次
     */
    private String signInRank;

    /**
     * 签到次数
     */
    private String signInTimes;

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
}
