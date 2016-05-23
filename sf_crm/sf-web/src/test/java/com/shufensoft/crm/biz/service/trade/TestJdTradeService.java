package com.shufensoft.crm.biz.service.trade;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/23  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestJdTradeService {

    @Autowired
    private JdTradeService jdTradeService;

    @Test
    public void testQueryEtmsTrace(){

        SellerShop sellerShop = SellerConfigCache.getSellerShop("1","2");//VB06417125455
        ExpressDetailVO expressDetailVO = jdTradeService.queryEtmsTrace(sellerShop, "VB06267107372");
        System.out.print(expressDetailVO);
    }

}
