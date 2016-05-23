package com.shufensoft.crm.biz.domain.defined.shake;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/17 上午10:42  
 */
@Data
public class ShakeQueryDO {

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
     * 用户id
     */
    private String userId;

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
     * 领取状态
     */
    private String shakeStatus;

    /**
     * 领取ID
     */
    private Long rockId;


}
