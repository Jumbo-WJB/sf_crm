package com.shufensoft.crm.biz.service.send.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/17 下午3:06  
 */
@Data
public class EmailVO {

    /**
     * 商户ID
     */
    private String sellerId;

    /**
     * 短信订购ID
     */
    private String packageId;

    /**
     * 营销主题
     */
    private String saleTitle;

    /**
     * 营销类型
     */
    private String saleType;

    /**
     * 邮件签名
     */
    private String emailSign;

    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String emailContent;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 发件人邮件地址
     */
    private String from;

    /**
     * 发件人名称
     */
    private String fromName;

    /**
     * 用户邮箱地址
     */
    private List<String> emaiAddress;
}
