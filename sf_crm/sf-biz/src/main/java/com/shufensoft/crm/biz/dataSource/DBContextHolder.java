package com.shufensoft.crm.biz.dataSource;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 多个商家可能需要同时切换数据源，所以这里需要写一个线程安全的ThreadLocal
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
public class DBContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    public static String getDataSourceKey() {
        return  contextHolder.get();
    }

    public static void clearDataSourceKey() {
        contextHolder.remove();
    }
}
