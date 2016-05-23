package com.shufensoft.crm.common.api.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class PolySpireApiException extends ApiException{

    private static String client = "polySpire";

    public PolySpireApiException() {
        super();
    }

    public PolySpireApiException(String message) {
        super(client, message);
    }

    public PolySpireApiException(String api, String message) {
        super(client, api, message);
    }

    public PolySpireApiException( String api, String errorCode, String message) {
        super(client, api, errorCode, message);
    }

    public PolySpireApiException(String message, Throwable cause) {
        super(client, message, cause);
    }

    public PolySpireApiException( String api, String errorCode, String message, Throwable cause) {
        super(client, api, errorCode, message, cause);
    }

    public PolySpireApiException( String api, String message, Throwable cause) {
        super(client, api,  message, cause);
    }

    public PolySpireApiException(Throwable cause) {
        super(cause);
    }
}
