package com.shufensoft.crm.web.controller.wechat.helper;

import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.wechat.OutputMessage;
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
public class TestMessageHelper {

    @Test
    public void isHongBaoObtained() throws IOException {
        DBContextHolder.setDataSourceKey("1");
        OutputMessage outputMessage = new OutputMessage();
        outputMessage.setFromUserName("litu");
        outputMessage.setToUserName("jinlaba");
        outputMessage.setMsgId("1");
        outputMessage.setCreateTime(System.currentTimeMillis() / 1000);
        outputMessage.setMsgType("text");

        System.out.println(MessageHelper.assemblyMessage(outputMessage));
    }
}
