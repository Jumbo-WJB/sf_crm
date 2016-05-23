package com.shufensoft.crm.common.api.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class TaoBaoOauthException extends ApiException{

    private static String client = "taoBaoOauth";

    public TaoBaoOauthException() {
        super();
    }

    public TaoBaoOauthException(String message) {
        super(client, message);
    }

    public TaoBaoOauthException(String api, String message) {
        super(client, api, message);
    }

    public TaoBaoOauthException(String api, String errorCode, String message) {
        super(client, api, errorCode, message);
    }

    public TaoBaoOauthException(String message, Throwable cause) {
        super(client, message, cause);
    }

    public TaoBaoOauthException(String api, String errorCode, String message, Throwable cause) {
        super(client, api, errorCode, message, cause);
    }

    public TaoBaoOauthException(String api, String message, Throwable cause) {
        super(client, api,  message, cause);
    }

    public TaoBaoOauthException(Throwable cause) {
        super(cause);
    }
}
