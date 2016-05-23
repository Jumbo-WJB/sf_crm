package com.shufensoft.crm.common.email.request;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 邮件客户端请求对象
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/25 14:50  
 */
@Data
public class EmailRequest<T> extends BaseRequest {


    /**
     * 带请求头User-Agent
     */
    private String userAgent = "KdtApiSdk Client v0.1";

    /**
     * String参数
     */
    private String stringParames;




}
