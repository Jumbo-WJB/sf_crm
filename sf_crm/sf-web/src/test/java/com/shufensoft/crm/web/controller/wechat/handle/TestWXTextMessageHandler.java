package com.shufensoft.crm.web.controller.wechat.handle;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.wechat.InputMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWXTextMessageHandler {

    /**
     * 处理接收的消息
     */
    @Test
    public void testHandle(){

        DBContextHolder.setDataSourceKey("1");
        InputMessage inputMessage = new InputMessage();
        inputMessage.setFromUserName("ouIwHuJkdo11btuh535veO1gNeYw");
        inputMessage.setToUserName("gh_d7a9446fd8c4");
        inputMessage.setMsgId("1");
        inputMessage.setContent("摇");
        inputMessage.setCreateTime(System.currentTimeMillis() / 1000);
        inputMessage.setMsgType("text");

        System.out.println(WXCommonMessageHandler.handle(inputMessage, 1l));

    }



}
