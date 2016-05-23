package com.shufensoft.crm.biz.service.reply;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  关键字回复服务类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
@Service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestKeyWordReplyService {

    @Autowired
    private KeyWordReplyService keyWordReplyService;


    @Test
    public void testQueryKeyWordConfigByKeyWord(){
        DBContextHolder.setDataSourceKey("1");
        List<KeyWordReplyConfigVO>  keyWordReplyConfigVOs = keyWordReplyService.queryKeyWordConfigByKeyWord(1l,"guide");
    }

    @Test
    public void testMatchKeyWordReplyConfig(){
        DBContextHolder.setDataSourceKey("1");
        KeyWordReplyConfigVO  keyWordReplyConfigVO = keyWordReplyService.matchKeyWordReplyConfig(1l,"兑换");
        System.out.println(keyWordReplyConfigVO);
    }

}
