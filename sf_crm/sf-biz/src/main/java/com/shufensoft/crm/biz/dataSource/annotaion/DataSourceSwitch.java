package com.shufensoft.crm.biz.dataSource.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                   数据源切换标注,作用于类上<br>
 *                   dao层Mapper上，设置@DataSourceSwitch(sellerId="")sellerId为商家Id,
 *                   默认基础数据源，此时拦截会在DBContextHolder中设置sellerId作为dataSourceKey
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/10 11:26  
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceSwitch {

    String dataSourceId() default "0";

}
