package com.shufensoft.crm.biz.service.OpenApiOauth;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfoExample;

import java.util.List;

/**
 * Created by lin on 2015/6/12.
 */
public interface OpenApiOauthService {

    /**
     * 针对京东商家更新access_token和refresh_token
     * */
    public int updateSellerConfigInfoByAppKey(SellerConfigInfo sellerConfigInfo);

    /**
     *
     * */
    public SellerConfigInfo getSellerConfigInfoBySellerId(long sellerId);

    /**
     *
     * */
    public List<SellerConfigInfo> getSellerConfigInfoByExample(SellerConfigInfoExample example);



}
