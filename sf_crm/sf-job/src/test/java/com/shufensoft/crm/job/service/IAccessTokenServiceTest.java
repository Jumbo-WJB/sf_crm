package com.shufensoft.crm.job.service;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.job.inter.IAccessTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/9/6  
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class IAccessTokenServiceTest {

    @Autowired
    IAccessTokenService iAccessTokenService;

    @Test
    public void testRefreshTokenJob(){

        List<SellerConfigInfo> list = SellerConfigCache.getAll();
        for(SellerConfigInfo sci : list){
            iAccessTokenService.refreshTokenByShop(sci);
        }


    }

}
