package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm 
 *  @Description: 营销活动值对象VO
 *  @author yuyuchi yuyc@shufensoft.com
 *  @date 2015/6/11 11:28
 */
@Data
public class MarketActivityVO extends MarketActivity {

    /**
     * 执行方式，立即执行和定时执行
     */
    private String exeTimeType;
    /**
     * 短信签名
     */
    private String smsSign;

    /**
     * 是否发送成功，0:失败；1:成功
     */
    private String isSuccess;

    /**
     * 标示邮件是否打开：默认为0
     */
    private String isOpen;

    /**
     * 执行时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date executeTime;

    /**发送成功率**/
    private Float successRate;

    /**邮件打开率**/
    private Float openRate;

    private String mobile;

    private String email;

    /**上传微信多媒体文件的位置**/
    private String wxMediaPath;

    /**微信发送方式，群发接口和客服接口**/
    private String wxSendType;

    /**上传微信多媒体文件的类型**/
    private String wxMediaType;

    /**填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个**/
    private List<String> toUser;

    private List<MarketRecords> recordsList;
}