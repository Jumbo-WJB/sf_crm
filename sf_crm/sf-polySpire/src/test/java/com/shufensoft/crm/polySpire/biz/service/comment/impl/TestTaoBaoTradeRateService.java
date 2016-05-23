package com.shufensoft.crm.polySpire.biz.service.comment.impl;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.polySpire.biz.service.comment.TaoBaoTradeRateService;
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
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/19  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestTaoBaoTradeRateService {

    @Autowired
    TaoBaoTradeRateService taoBaoTradeRateService;

    @Test
    public void testPullTaoBaoTradeRates(){

        DBContextHolder.setDataSourceKey("0");
        taoBaoTradeRateService.pullTaoBaoTradeRates(2l, 2l, 1217284034629835l);

    }

}
