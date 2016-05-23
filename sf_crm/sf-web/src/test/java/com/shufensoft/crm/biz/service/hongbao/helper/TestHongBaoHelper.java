package com.shufensoft.crm.biz.service.hongbao.helper;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/28  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestHongBaoHelper {

    @Test
    public void isHongBaoObtained(){
        DBContextHolder.setDataSourceKey("1");
        boolean flag =  HongBaoHelper.isHongBaoObtained(32L,Long.valueOf(1));
        Assert.assertTrue(flag);
    }
}

