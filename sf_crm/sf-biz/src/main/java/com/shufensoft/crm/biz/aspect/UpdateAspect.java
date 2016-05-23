package com.shufensoft.crm.biz.aspect;

import com.shufensoft.crm.biz.annotation.Domain;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;

import java.util.Date;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: update切面
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/10 11:26  
 */
public class UpdateAspect {

	public void before(JoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if (arg != null) {
				Class<?> cla = arg.getClass();
                Map<String,Object> loginInfo = DaoContextHolder.getLoginInfo();

                String userId = "sys";

                if(loginInfo!=null && loginInfo.get("userName")!=null){
                    userId = String.valueOf(loginInfo.get("userName"));
                }

                if(StringUtils.isNotBlank(cla.getSimpleName())&&cla.getSimpleName().indexOf("Example")!=-1){
                    continue;
                }
				if (cla.isAnnotationPresent(Domain.class)) {

					try {
                        MethodUtils.invokeMethod(arg, "setGmtModified", new Date());
					} catch (Exception e) {
                        throw new RuntimeException(joinPoint.toString()+"；参数"+cla.getName()
                                +"没有setModifiedBy,setGmtModified方法");
					}

                    try {
                        MethodUtils.invokeMethod(arg, "setModifiedBy",
                                StringUtils.isBlank(userId) ? "sys" : userId);
                    } catch (Exception e) {
                        if(isNeedThrowExeception(cla.getSimpleName())){
                            throw new RuntimeException(joinPoint.toString()
                                    + "；参数"
                                    + cla.getName()
                                    + "没有setModifiedBy方法");
                        }

                    }

				} else {
					throw new RuntimeException(joinPoint.toString()+"；参数"
                            +cla.getName()+"没有添加注解@Domain,请添加注解");
				}
			}
		}
	}

    private boolean isNeedThrowExeception(String className){

        if(StringUtils.isBlank(className)){
            return true;
        }

        if(className.indexOf("TaoBao")==-1&&className.indexOf("JD")==-1
                &&className.indexOf("YZ")==-1){
            return true;
        }

        return false;

    }
}
