package com.shufensoft.crm.biz.domain.generation.send;

import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/29 下午5:09  
 */
@Data
public class SendWxMessage {

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 发送方式：群发接口(mass)和客服接口(custom)
     */
    private String sendType;

    /**
     * 单个用户openId
     */
    private String touser;

    /**
     * 群发多个用户openId
     */
    private List<String> toUserList;

    /**
     * 文本类型
     */
    private String text;

    /**
     * 类型
     */
    private String msgtype;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片类型
     */
    private String image;


    /**
     * 图片ID
     */
    private String mediaId;

    /**
     * 图文信息
     */
    List<SendWxArticles> sendWxArticlesList;


}
