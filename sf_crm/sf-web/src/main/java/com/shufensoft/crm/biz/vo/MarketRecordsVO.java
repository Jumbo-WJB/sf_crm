package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/15.
 */
@Data
public class MarketRecordsVO{
    /** 营销活动Id */
    private Long activityId;

    /** 用户Id */
    private Long userId;

    /** 营销方案主题 */
    private String activityTitle;

    /** 用户手机号码 */
    private String mobile;

    /** 用户的邮箱 */
    private String email;

    /** 是否发送成功，0:失败；1:成功 */
    private String isSuccess;

    /** 标示邮件是否打开：默认为0 */
    private String isOpen;

    /**  */
    private String type;

    /**  */
    private Date executeTime;

    /** 用户姓名 从收货人中提取 */
    private String name;

    /** 微信昵称 */
    private String wxNickName;

    /** 用户来源 JD TB YZ WX，可以多个渠道 */
    private String firstSource;

    /** 用户贡献度，总分100 */
    private BigDecimal contribution;

    /** 短信接收次数 */
    private Integer smsAcceptNumber;

    /** 短信接收周期，单位：天 */
    private Integer smsAcceptCircle;

    /** 邮件接收次数 */
    private Integer emailAcceptNumber;

    /** 邮件接收周期，单位：天 */
    private Integer emailAcceptCircle;

    /** 执行开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startTime;

    /** 执行开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date endTime;

    private Long sellerId;
}
