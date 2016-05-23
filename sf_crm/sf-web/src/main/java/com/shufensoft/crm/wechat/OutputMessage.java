package com.shufensoft.crm.wechat;

import com.shufensoft.crm.common.utils.xmlUtil.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/22 11:10  
 */
@XStreamAlias("xml")
@Data
public class OutputMessage {

    @XStreamAlias("ToUserName")
    @XStreamCDATA
    private String ToUserName;

    @XStreamAlias("FromUserName")
    @XStreamCDATA
    private String FromUserName;

    @XStreamAlias("CreateTime")
    private Long CreateTime;

    @XStreamAlias("MsgType")
    @XStreamCDATA
    private String msgType = "text";

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("MsgId")
    private String msgId;

    private ImageMessage image;

    @XStreamAlias("ArticleCount")
    private Integer articleCount;

    @XStreamAlias("Content")
    @XStreamCDATA
    private String content;

    private String title;

    private String bizType;

    @XStreamAlias("Articles")
    private List<Item> articles;


}
