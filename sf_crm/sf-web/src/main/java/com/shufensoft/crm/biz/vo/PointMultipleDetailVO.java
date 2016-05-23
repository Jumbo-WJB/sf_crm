package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/25 下午9:31  
 */
@Data
public class PointMultipleDetailVO {

    /**
     * 用户画像ID
     */
    private Integer userPortraitId;

    /**
     * 商家ID
     */
    private Long sellerId;

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
     * 最后领取时间
     */
    private String lastObtainStartDate;

    /**
     * 获取积分开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date obtainStartDate;

    /**
     * 获取积分结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date obtainEndDate;

    /**
     * 领取日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date gmtCreated;



}
