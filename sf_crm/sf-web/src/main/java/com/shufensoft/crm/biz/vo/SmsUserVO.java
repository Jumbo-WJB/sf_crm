package com.shufensoft.crm.biz.vo;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/2 21:11  
 */
@Data
public class SmsUserVO {

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 短信订购ID
     */
    private String smsOrderID;
}
