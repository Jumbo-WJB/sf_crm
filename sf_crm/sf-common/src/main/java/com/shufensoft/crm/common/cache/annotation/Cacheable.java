package com.shufensoft.crm.common.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 缓存标注
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/26  
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {

    String fieldKey();

    /**
     * 失效时间默认0，永久保存,单位:ms
     * @return
     */
    int expireTime() default 0;
}
