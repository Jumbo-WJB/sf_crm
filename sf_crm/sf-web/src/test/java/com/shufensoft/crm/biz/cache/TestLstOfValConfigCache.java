package com.shufensoft.crm.biz.cache;

import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
public class TestLstOfValConfigCache {

    @Test
    public void getLOV() {
        LstOfVal lstOfVal = LstOfValCache.getLOV("INTEGRAL_CONFIG","SYS");
        Assert.assertNotNull(lstOfVal);
    }

    @Test
    public void getTypeList() {
        List<LstOfVal> lstOfVals = LstOfValCache.getTypeList("INTEGRAL_CONFIG");
        Assert.assertNotNull(CollectionUtils.isEmpty(lstOfVals));
    }


}
