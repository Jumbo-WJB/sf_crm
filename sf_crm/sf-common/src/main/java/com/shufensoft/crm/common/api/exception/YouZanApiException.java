package com.shufensoft.crm.common.api.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 口袋通接口调用异常类
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/18 13:42  
 */
public class YouZanApiException extends ApiException{

    private static String client = "youzan";

    public YouZanApiException() {
        super();
    }

    public YouZanApiException( String message) {
        super(client, message);
    }

    public YouZanApiException(String api, String message) {
        super(client, api, message);
    }

    public YouZanApiException(String api, String errorCode, String message) {
        super(client, api, errorCode, message);
    }

    public YouZanApiException(String message, Throwable cause) {
        super(client, message, cause);
    }

    public YouZanApiException( String api, String errorCode, String message, Throwable cause) {
        super(client, api, errorCode, message, cause);
    }

    public YouZanApiException( String api,  String message, Throwable cause) {
        super(client, api,message, cause);
    }
    public YouZanApiException(Throwable cause) {
        super(cause);
    }




}
