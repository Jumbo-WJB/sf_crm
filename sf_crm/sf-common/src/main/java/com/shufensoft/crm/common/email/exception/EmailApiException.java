package com.shufensoft.crm.common.email.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 邮件接口调用异常类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/26 13:42  
 */
public class EmailApiException extends RuntimeException{

    public EmailApiException() {
        super();
    }

    public EmailApiException(String message) {
        super(" sendCloud api execute error,errorMsg:"+message);
    }

    public EmailApiException(String message, String api, String errorCode) {

        super(" sendCloud api execute error,errorMsg:"+message+"[api:"+(api==null?"":api)+";errorCode:"
                +(errorCode==null?"":errorCode)+"]");
    }

    public EmailApiException(String message, Throwable cause) {

        super(" sendCloud execute error,errorMsg:"+message,cause);
    }

    public EmailApiException(String message, String api, String errorCode, Throwable cause) {

        super(" sendCloud api execute error,errorMsg:"+message+"[api:"+(api==null?"":api)+";errorCode:"
                +(errorCode==null?"":errorCode)+"]",cause);

    }


    public EmailApiException(Throwable cause) {
        super(cause);
    }
}
