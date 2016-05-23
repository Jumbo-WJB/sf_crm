package com.shufensoft.crm.biz.domain.generation.email;

import lombok.Data;

/**
 *  接收邮件发送记录信息
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/18 下午8:41  
 */
@Data
public class CampaignSentstInfo {

    private String subscriber_email;

    private String isSuccess;

    private String sending_status_time;
}
