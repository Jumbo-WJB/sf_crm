package com.shufensoft.crm.common.sms.emay.client;


import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.email.MailSend;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.common.email.request.EmailRequest;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.coÍÍÍÍS
 *  @date 2015/5/9 17:19  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class TestSms {

    @Autowired
    SendSmsService smsSendService;

    @Test
    public void testSendSms() {

        smsSendService.sendSms("1");
    }

    @Test
    public void testSmsReport() {
        smsSendService.receiveSmsStatusReport("1", DaoConstant.SmsSend.SEND_NOTIFY);
    }

    @Test
    public void sendEmail() {
        MailSend mailSend = new MailSend();
        mailSend.setApi_key("sP5htJ7ObuCvpehT");
        mailSend.setApi_user("zoulao1_test_ySD27Q");
        mailSend.setSubject("来自SendCloud的第一封邮件！");
        mailSend.setHtml("你太棒了！你已成功的从SendCloud发送了一封测试邮件，接下来快登录前台去完善账户信息吧！");
        mailSend.setTo("348890836@qq.com;zoujian1233@126.com");
        mailSend.setFrom("zoujian@shufensoft.com");
        String requestParam = JSONUtils.toJSONStr(mailSend);


        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setApi("http://sendcloud.sohu.com/webapi/mail.send.json");
        emailRequest.setStringParames(requestParam);
        //EmailClient.post(emailRequest);
    }

}
