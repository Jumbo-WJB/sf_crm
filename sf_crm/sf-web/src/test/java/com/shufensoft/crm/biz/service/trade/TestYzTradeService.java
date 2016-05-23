package com.shufensoft.crm.biz.service.trade;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.express.service.ExpressService;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/27  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestYzTradeService {
    @Autowired
    private YouZanTradeService youZanTradeService;
    private ExpressService expressService;
    @Test
    public void testQueryYzTrace(){
        DBContextHolder.setDataSourceKey("1");
        SellerShop sellerShop = SellerConfigCache.getSellerShop("1", "7783371206");//VB06417125455
        ExpressDetailVO expressDetailVO = youZanTradeService.queryYouZanLogisticsTrace(sellerShop,"E20150908120935023883702");
        System.out.println("companyName:" + expressDetailVO.getExpressCompany());
        System.out.println(expressDetailVO.getTransitStepVOs());
    }

    @Test
    public void testDateUtil() {
        SimpleDateFormat  cstFormater = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = null;
        try {
//            String date = json.getAsJsonPrimitive().getAsString();
            Date gpsUTCDate = cstFormater.parse("Fri Jul 17 12:54:52 CST 2015");
            String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(gpsUTCDate);
            System.out.println("时间:" + formatStr2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testYzExpressDetailsInfo() {
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderFrom("YZ");
        orderVO.setTradeId("E20150904154759126277720");
        ExpressDetailVO  expressDetailVO = expressService.findCommentExpressInfo(1L, 4579578042L, orderVO);
    }
}
