package com.shufensoft.crm.biz.service.trade;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.defined.trade.TradeDO;
import com.shufensoft.crm.biz.service.trade.vo.TradeVO;
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
 *  @date 2015/7/30  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestTradeService {

    @Autowired
    private TradeService tradeService;

    @Test
    public void testSelectTradeFromAll(){

        DBContextHolder.setDataSourceKey("1");
        TradeVO tradeVO = new TradeVO();
        //tradeVO.setKeyword("");
        //tradeVO.setReceiverName("");
        //tradeVO.setTradeSource("TB");
        //tradeVO.setReceiverId();
        tradeVO.setLastDays(7);
        tradeVO.setHasMobile("1");
        tradeVO.setOrderClause("created asc");
        //tradeVO.setMaxPrice(new BigDecimal(userVO.getMaxPrice()));
        //tradeVO.setMinPrice(new BigDecimal(userVO.getMinPrice()));

        PageInfo pageInfo = tradeService.selectTradeFromAll(tradeVO,1,40);

        System.out.println((TradeDO)pageInfo.getList().get(0));

    }
}
