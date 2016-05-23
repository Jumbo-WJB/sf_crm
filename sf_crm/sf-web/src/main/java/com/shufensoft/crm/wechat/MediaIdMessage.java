package com.shufensoft.crm.wechat;

import com.shufensoft.crm.common.utils.xmlUtil.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 多媒体实体类
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/22 11:12  
 */
public class MediaIdMessage {
    @XStreamAlias("MediaId")
    @XStreamCDATA
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
