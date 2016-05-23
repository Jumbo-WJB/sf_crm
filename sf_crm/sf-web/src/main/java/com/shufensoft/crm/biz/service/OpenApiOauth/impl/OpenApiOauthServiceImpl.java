package com.shufensoft.crm.biz.service.OpenApiOauth.impl;

import com.shufensoft.crm.biz.dao.generation.seller.SellerConfigInfoMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfoExample;
import com.shufensoft.crm.biz.service.OpenApiOauth.OpenApiOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lin on 2015/6/12.
 */
@Service
public class OpenApiOauthServiceImpl implements OpenApiOauthService{

    @Autowired
    private SellerConfigInfoMapper sellerConfigInfoMapper;

    /**
     * 针对京东商家配置信息更新access_token和refresh_token
     *
     * @param sellerConfigInfo
     */
    @Override
    public int updateSellerConfigInfoByAppKey(SellerConfigInfo sellerConfigInfo) {
        return sellerConfigInfoMapper.updateByPrimaryKeySelective(sellerConfigInfo);
    }

    /**
     * @param sellerId
     */
    @Override
    public SellerConfigInfo getSellerConfigInfoBySellerId(long sellerId) {
        return sellerConfigInfoMapper.selectByPrimaryKey(sellerId);
    }

    /**
     * @param example
     */
    @Override
    public List<SellerConfigInfo> getSellerConfigInfoByExample(SellerConfigInfoExample example) {
        return sellerConfigInfoMapper.selectByExample(example);
    }
}
