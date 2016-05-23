package com.shufensoft.crm.biz.domain.generation.send;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/29 下午8:09  
 */
@Data
public class SendWxArticles {

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 点击地址
     */
    private String url;

    /**
     * 图片地址
     */
    private String picurl;
}
