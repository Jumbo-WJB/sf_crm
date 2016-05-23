package com.shufensoft.crm.openApi.client.youzan;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.biz.service.trade.impl.YouZanTradeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   有赞快递接口查询服务测试
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/22  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class YZExpressTest {
    @Test
    public void expressInfo() {
        YouZanTradeService youZanTradeService = new YouZanTradeServiceImpl();

        SellerShop sellerShop = SellerConfigCache.getSellerShop("1", "7783371206");//VB06417125455
        ExpressDetailVO expressDetailVO = youZanTradeService.queryYouZanLogisticsTrace(sellerShop,"E20150908120935023883702");
        System.out.println(expressDetailVO.getExpressCompany());

    }
}
