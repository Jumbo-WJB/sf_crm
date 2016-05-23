package com.shufensoft.crm.biz.cache;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 商家配置缓存单元测试
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/23  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestSellerConfigCache {

    @Test
    public void get() {
        SellerConfigCache.reloadAll();
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get("2");
        System.out.print(sellerConfigInfo);
        Assert.assertNotNull(sellerConfigInfo);
    }

    @Test
    public void put() {
        DBContextHolder.setDataSourceKey("1");
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get("1");
        SellerConfigCache.put("1",sellerConfigInfo);
    }


}
