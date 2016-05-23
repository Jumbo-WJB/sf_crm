package com.shufensoft.crm.biz.aspect;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 这里需要写一个线程安全的ThreadLocal,把登录的用户名保存
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
public class LoginContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setLoginName(String userName) {
        contextHolder.set(userName);
    }

    public static String getLoginName() {
        return  contextHolder.get();
    }

    public static void clearDataSourceKey() {
        contextHolder.remove();
    }
}
