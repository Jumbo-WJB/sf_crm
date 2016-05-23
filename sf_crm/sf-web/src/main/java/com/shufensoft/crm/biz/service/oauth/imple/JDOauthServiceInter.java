package com.shufensoft.crm.biz.service.oauth.imple;

import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/8/28  
 */
public interface JDOauthServiceInter {
    public AdminUser handleAuthorizeFromJDServiceMarket(String accessToken, String refreshToken, int expiresTime) throws Exception;
}
