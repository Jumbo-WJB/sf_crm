package com.shufensoft.crm.polySpire.exception;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 job异常类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/9  
 */
public class JobException extends RuntimeException{

    public JobException() {
        super();
    }

    public JobException(String message) {
        super(message);
    }

    public JobException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobException(Throwable cause) {
        super(cause);
    }

    protected JobException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
