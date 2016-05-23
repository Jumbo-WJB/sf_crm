package com.shufensoft.crm.web.controller.wechat.handle;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.wechat.InputMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/19  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWxEventHandler {

    @Test
    public void testHandle() throws IOException {

        DBContextHolder.setDataSourceKey("1");
        InputMessage inputMessage = new InputMessage();
        inputMessage.setFromUserName("ouIwHuJkdo11btuh535veO1gNeYw");
        inputMessage.setToUserName("gh_d7a9446fd8c4");
        inputMessage.setEvent("subscribe");
        inputMessage.setCreateTime(System.currentTimeMillis() / 1000);
        inputMessage.setMsgType("event");

        System.out.println(WxEventHandler.handle(inputMessage,1l));

    }

}
