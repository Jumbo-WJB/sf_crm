package com.shufensoft.crm.biz.domain.defined.point;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 积分综合查询DO
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/25 下午8:21  
 */

@Data
public class PointMultipleDO {

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
     * 商家ID
     */
    private Long sellerId;

    /**
     * 用户画像ID
     */
    private Long userPortraitId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户互动次数
     */
    private Integer interactionsTimes;

    /**
     * 累计获得积分
     */
    private Long pointAmountTotal;

    /**
     * 累积过期的积分
     */
    private Long pointAmountExpired;

    /**
     * 当前有效积分
     */
    private Long pointAmount;

    /**
     * 累积兑换积分
     */
    private Long pointAmountExchange;

    /**
     * 买家姓名
     */
    private String name;

    /**
     * 微信买家昵称
     */
    private String wxNickName;

    /**
     * 是否是微信粉线
     */
    private String wxSubscribe;

    /**
     * 积分获取方式
     */
    private String obtainMethod;

    /**
     * 积分兑换方式
     */
    private String exchangMethod;

    /**
     * 获取积分开始时间
     */
    private Date obtainStartDate;

    /**
     * 获取积分结束时间
     */
    private Date obtainEndDate;


}
