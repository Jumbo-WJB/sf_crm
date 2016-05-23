package com.shufensoft.crm.common.email.response;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 邮件客户端响应对象
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/25 17:09  
 */
@Data
public class EmailResponse extends BaseResponse {

    private String returnBizId;
}
