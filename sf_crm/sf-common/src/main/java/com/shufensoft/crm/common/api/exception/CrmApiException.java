package com.shufensoft.crm.common.api.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class CrmApiException extends ApiException{

    private static String client = "crm";

    public CrmApiException() {
        super();
    }

    public CrmApiException(String message) {
        super(client, message);
    }

    public CrmApiException(String api, String message) {
        super(client, api, message);
    }

    public CrmApiException(String api, String errorCode, String message) {
        super(client, api, errorCode, message);
    }

    public CrmApiException(String message, Throwable cause) {
        super(client, message, cause);
    }

    public CrmApiException(String api, String errorCode, String message, Throwable cause) {
        super(client, api, errorCode, message, cause);
    }

    public CrmApiException(String api, String message, Throwable cause) {
        super(client, api,  message, cause);
    }

    public CrmApiException(Throwable cause) {
        super(cause);
    }
}
