package com.shufensoft.crm.biz.service.pointmall;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.pointmall.vo.PointStatisticsVO;
import com.shufensoft.crm.biz.vo.PointExchangeVO;
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
 *  @date 2015/7/20  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestPointService {

    @Autowired
    IPointService pointService;

    @Test
    public void TestQueryPointExchaneStatistics(){
        DBContextHolder.setDataSourceKey("1");
        List<PointExchangeVO> pointExchangeVOList = pointService.queryPointExchaneStatistics(1l,30);
    }

    @Test
    public void TestGetPointStatisticsInfo(){
        DBContextHolder.setDataSourceKey("1");
        PointStatisticsVO pointStatisticsVO = pointService.getPointStatisticsInfo(1l,7);
        System.out.print(pointStatisticsVO);
    }

}
