package com.shufensoft.crm.biz.domain.generation.email;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/8/18 下午4:25  
 */
@Data
public class CampaignOpens {

    /**
     * 打开的邮件
     */
    private String subscriber_email;

    /**
     * 打开的时间
     */
    private String email_opening_time;

}
