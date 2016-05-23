package com.shufensoft.crm.biz.service.user;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-14 10:22  
 */
public class UserBoundResponse {

    public static final int SUCCESS = 0;

    public static final int ILLEGAL_ARG = 1001;
    public static final int TBID_INEXIST = 1002;
    public static final int JDID_INEXIST = 1003;
    public static final int MOBILE_INEXIST = 1004;
    public static final int BOUND_ALREADY = 1005;

    public static final int INTERNAL = 7001;

    private int errorCode;

    public UserBoundResponse(int errorCode) {
        this.errorCode = errorCode;
    }

    private static Map<Integer, String> ERROR = new HashMap<Integer, String>(){{
        put(ILLEGAL_ARG, "illegal argument");
        put(TBID_INEXIST, "taobaoId not found");
        put(JDID_INEXIST, "jdId not found");
        put(MOBILE_INEXIST, "mobile not found");
        put(BOUND_ALREADY, "bound already");

        put(INTERNAL, "internal error");
    }};

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return ERROR.get(errorCode);
    }

    public boolean isSuccess() {
        return errorCode == SUCCESS;
    }

}
