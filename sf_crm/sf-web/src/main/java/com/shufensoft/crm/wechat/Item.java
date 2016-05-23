package com.shufensoft.crm.wechat;

import com.shufensoft.crm.common.utils.xmlUtil.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/8/3  
 */
@XStreamAlias("item")
@Data
public class Item {

    @XStreamAlias("Title")
    @XStreamCDATA
    private String title;

    @XStreamAlias("Description")
    @XStreamCDATA
    private String description;

    @XStreamAlias("PicUrl")
    @XStreamCDATA
    private String picUrl;

    @XStreamAlias("Url")
    @XStreamCDATA
    private String url;

}