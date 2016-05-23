package com.shufensoft.crm.biz.domain.generation.email;

import lombok.Data;

/**
 *  
 *  @ProjectName: sf-crm  
 *  @Description: 邮件添加收件人返回的错误信息
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/6/16 14:05  
 *  
 */

@Data
public class SubscribersErrorInfo {

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 邮件错误信息
     */
    private String error;
}
