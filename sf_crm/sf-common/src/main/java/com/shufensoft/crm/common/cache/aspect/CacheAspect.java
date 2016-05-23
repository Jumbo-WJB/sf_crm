package com.shufensoft.crm.common.cache.aspect;

import com.shufensoft.crm.common.cache.annotation.Cacheable;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 缓存aop
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/26  
 */

public class    CacheAspect {

    /**
     * 定义缓存逻辑
     */
    @Around("@annotation(com.shufensoft.crm.common.cache.annotation.Cacheable)")
    public Object aroundCache(ProceedingJoinPoint joinPoint) {

        Object result=null;

        Method method = getMethod(joinPoint);
        Cacheable cacheable = method.getAnnotation(Cacheable.class);

        String fieldKey =parseKey(cacheable.fieldKey(),method,joinPoint.getArgs());
        //TODO
        /**
         *   获取方法的返回类型,让缓存可以返回正确的类型
         */
        Class returnType=((MethodSignature)joinPoint.getSignature()).getReturnType();

        /**
         * 使用redis 的hash进行存取，易于管理
         */

        //result= RedisCacheUtils.hget(cacheable.key(), fieldKey, returnType);

        return result;
    }

    /**
     *  获取被拦截方法对象
     *
     *  getMethod() 获取的是顶层接口或者父类的方法对象
     *	而缓存的注解在实现类的方法上
     *  所以应该使用反射获取当前对象的方法对象
     */
    private Method getMethod(ProceedingJoinPoint joinPoint){

        /**
         * 获取参数的类型
         */
        Object [] args=joinPoint.getArgs();
        Class [] argTypes=new Class[joinPoint.getArgs().length];
        for(int i=0;i<args.length;i++){
            argTypes[i]=args[i].getClass();
        }

        Method method;

        try {
            method=joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(),argTypes);
        } catch (Exception e) {
           throw new RuntimeException("CacheAspect.getMethod",e);
        }

        return method;

    }

    /**
     *	获取缓存的Key
     * @param fieldKey
     * @return
     */
    private String parseKey(String fieldKey,Method method,Object [] args){

        AssertsUtil.notBothSidesBlank(fieldKey,"fieldKey");
        AssertsUtil.notNull(method, "method");

        if(args == null || args.length == 0){
            throw new RuntimeException("method "+method.getName() +" need define parameter when use cache");
        }

        String key = "";

        for(Object arg : args){

            Class<?> cla = arg.getClass();
            if(fieldKey.indexOf(StringUtils.uncapitalize(cla.getName()))!=-1){
                //TIDO 组装缓存key
                key = "";
            }
        }

        return key;

    }


}
