/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.shufensoft.crm.biz.dataSource.interceptor;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;

/**
 *  
 *  @ProjectName: sf-crm  
 *  @Description: 数据源切换Interceptor
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/22  
 */
public class DataSourceSwitchInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Class<?> clazz =invocation.getMethod().getDeclaringClass();

        DataSourceSwitch annotation = clazz.getAnnotation(DataSourceSwitch.class);

        if(annotation!=null){

            String dataSourceKey = DBContextHolder.getDataSourceKey();
            String dataSourceId = annotation.dataSourceId();

            if(StringUtils.isNotBlank(dataSourceKey) && !"0".equals(dataSourceKey)
                    &&!dataSourceKey.equals(dataSourceId)){

                dataSourceKey = dataSourceId+","+dataSourceKey;

                DBContextHolder.setDataSourceKey(dataSourceKey);
            }else{
                DBContextHolder.setDataSourceKey(dataSourceId);
            }



        }

        return invocation.proceed();

    }


}
