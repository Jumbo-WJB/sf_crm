/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.shufensoft.crm.interceptor;

/**
 * @author wylitu
 * @version v 0.1 2015/1/23 6:48 Exp $$
 */
public interface LoggerNames {

    /**
     * 系统DAO层操作日志
     * <p/>
     * Level : INFO
     * <p/>
     * 输出 : dal-digest.log
     */
    String CRM_DAL_DIGEST = "CRM_DAL_DIGEST";

    /**
     * 系统SERVICE层操作日志
     * <p/>
     * Level : INFO
     * <p/>
     * 输出 : biz-digest.log
     */
    String CRM_BIZ_DIGEST = "CRM_BIZ_DIGEST";

    /**
     * 系统CONTROLLER层操作日志
     * <p/>
     * Level : INFO
     * <p/>
     * 输出 : api-digest.log
     */
    String CRM_CONTROLLER_DIGEST = "CRM_CONTROLLER_DIGEST";

    /**
     * 系统其他层操作日志
     * <p/>
     * Level : INFO
     * <p/>
     * 输出 : other-digest.log
     */
    String CRM_OTHER_DIGEST = "CRM_OTHER_DIGEST";

}
