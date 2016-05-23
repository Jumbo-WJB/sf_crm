package com.shufensoft.crm.biz.domain.generation.email;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf_crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/31 10:22  
 */
@Data
public class MailSend {
    /**
     * api用户名
     */
    private String api_user;

    /**
     * api key
     */
    private String api_key;

    /**
     * 发件人地址. from 和发信域名, 会影响是否显示代发
     */
    private String from;

    /**
     * 收件人地址
     */
    private String to;

    /**
     * 标题
     */
    private String subject;

    /**
     * 邮件的内容，可为文件或HTML格式
     */
    private String html;

    /**
     * 发件人名称,显示如: ifaxin客服支持 <support@ifaxin.com>
     */
    private String fromname;

    /**
     * 密送地址. 多个地址使用';'分隔
     */
    private String bcc;

    /**
     * 抄送地址. 多个地址使用';'分隔
     */
    private String cc;

    /**
     * 默认的回复邮件地址. 如果 replyto 没有或者为空, 则默认的回复邮件地址为 from
     */
    private String replyto;

    /**
     * 本次发送所使用的标签ID. 此标签需要事先创建
     */
    private int label;

    /**
     * 邮件头部信息. JSON 格式, 比如:{"header1": "value1", "header2": "value2"}
     */
    private String headers;

    /**
     * 邮件附件. 发送附件时, 必须使用 multipart/form-data 进行 post 提交 (表单提交)
     */
    private String files;

    /**
     * SMTP 扩展字段. 详见 X-SMTPAPI
     */
    private String x_smtpapi;

    /**
     * 参数 to 是否含有地址列表. 比如: to=ben@ifaxin.com;users@maillist.sendcloud.org
     */
    private String use_maillist;

    /**
     * 是否返回 emailId. 有多个收件人时, 会返回 emailId 的列表
     */
    private String resp_email_id;

    /**
     * 邮件内容是否使用gzip压缩. 默认不使用 gzip 压缩正文
     */
    private String gzip_compress;

}
