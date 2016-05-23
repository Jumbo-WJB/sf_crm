package com.shufensoft.crm.biz.service.job.inter;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/22  
 */
public interface IAccessTokenService {

    /**
     * 微信accessToken 到期刷新
     * */
    public void wxAccessTokenRefresh(List<SellerConfigInfo> sellerConfigInfos);

    /**
     *
     * */
    public void jdAccessTokenRefresh(List<SellerConfigInfo> sellerConfigInfos);

    /**
     * 淘宝accessToken过期提醒
     * */
    public void tbAccessTokenExpiresWarn(List<SellerConfigInfo> sellerConfigInfos);


    /**
     *  refreshToken ALL
     * */
    public void refreshToken(List<SellerConfigInfo> sellerConfigInfos);


    public void refreshTokenByShop(SellerConfigInfo sellerConfigInfo);





}
