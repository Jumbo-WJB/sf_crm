package com.shufensoft.crm.biz.domain.defined.marketActivity;


import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuyuchi on 2015/6/15.
 */
@Data
public class MarketRecordsDO extends MarketRecords{

    /** 营销方案主题 */
    private String activityTitle;

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

    private Date startTime;

    private Date endTime;
}
