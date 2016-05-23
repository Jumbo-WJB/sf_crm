package com.shufensoft.crm.biz.aspect;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description: insert切面
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/10 11:26  
 */
public class InsertAspect {

    public void before(JoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {

            if (arg != null) {

                Class<?> cla = arg.getClass();

                Map<String, Object> loginInfo = DaoContextHolder.getLoginInfo();

                String userId = "sys";

                if (loginInfo != null && loginInfo.get("userName") != null) {
                    userId = String.valueOf(loginInfo.get("userName"));
                }

                Long sellerId = null;

                if (loginInfo != null && loginInfo.get("sellerId") != null) {
                    sellerId = Long.parseLong(String.valueOf(loginInfo.get("sellerId")));
                }

                if (!cla.isAnnotationPresent(Domain.class)) {
                    throw new RuntimeException(joinPoint.toString() + "；参数"
                            + cla.getName() + "没有添加注解@Domain,请添加注解");
                }

                try {

                    MethodUtils.invokeMethod(arg, "setGmtCreated", new Date());
                    MethodUtils.invokeMethod(arg, "setGmtModified", new Date());
                    MethodUtils.invokeMethod(arg, "setIsDeleted", "0");

                    try {

                        if (MethodUtils.invokeMethod(arg, "getSellerId",
                                null) == null) {
                            MethodUtils.invokeMethod(arg, "setSellerId", sellerId);
                        }

                    } catch (Exception e) {

                    }

                } catch (Exception e) {
                    throw new RuntimeException(joinPoint.toString()
                            + "；参数"
                            + cla.getName()
                            + "没有setGmtCreated或setGmtModified方法");
                }

                try {
                    MethodUtils.invokeMethod(arg, "setCreatedBy",
                            StringUtils.isBlank(userId) ? "sys" : userId);
                    MethodUtils.invokeMethod(arg, "setModifiedBy",
                            StringUtils.isBlank(userId) ? "sys" : userId);
                } catch (Exception e) {
                    if (isNeedThrowExeception(cla.getSimpleName())) {
                        throw new RuntimeException(joinPoint.toString()
                                + "；参数"
                                + cla.getName()
                                + "没有setCreatedBy或setModifiedBy或setIsDeleted方法");
                    }

                }

                Field[] fields = cla.getDeclaredFields();

                for (Field field : fields) {
                    if (field.isAnnotationPresent(BizId.class)) {
                        String fieldName = field.getName();
                        String getFiledName = "get"
                                + StringUtils.capitalize(fieldName);
                        if (MethodUtils.invokeMethod(arg, getFiledName,
                                null) == null) {
                            String setFiledName = "set"
                                    + StringUtils.capitalize(fieldName);
                            MethodUtils.invokeMethod(arg, setFiledName,
                                    System.currentTimeMillis() - 1434000000000l);// 设置业务Id
                        }

                        break;
                    }
                }
            }
        }
    }


    private boolean isNeedThrowExeception(String className) {

        if (StringUtils.isBlank(className)) {
            return true;
        }

        if (className.indexOf("TaoBao") == -1 && className.indexOf("JD") == -1
                && className.indexOf("YZ") == -1) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() - 1434000000000l);
    }

}
