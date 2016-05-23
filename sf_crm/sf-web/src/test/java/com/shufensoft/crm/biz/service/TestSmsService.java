package com.shufensoft.crm.biz.service;

import com.reasonablespread.service.Campaign;
import com.reasonablespread.service.DoubleOptIn;
import com.reasonablespread.service.Subscriber;
import com.shufensoft.crm.biz.adapter.EmailAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.email.SubscribersReslutInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.common.sms.SMSClient;
import com.shufensoft.crm.common.sms.emay.cn.b2m.eucp.sdkhttp.Mo;
import com.shufensoft.crm.common.utils.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestSmsService {

    @Autowired
    SendService sendService;



    @Test
    public void sendSmsVerifyCode(){
        int code = CommonUtil.getRandomCode(100000,999999);
        String content ="你的验证码为"+code;
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get("1");
        //sendService.sendSmsVerifyCode("1","测试商家","18042402333",content);
    }

    @Test
    public void testQuery(){
        SellerPackageCount sellerPackageCount = sendService.querySellerPackageCountBySellerID("1","sms");
        System.out.print(sellerPackageCount.toString());

    }

    @Test
    public void testSms(){
        SmsVO smsVO = new SmsVO();
        smsVO.setSendTime(new Date());

        List<String> list = new ArrayList<String>();
        list.add("18042402333");




        smsVO.setSellerId("1");
        smsVO.setSaleType("导粉");
        smsVO.setContent("公司终于有名字了！32312hfdas888321234321jhda,在在一苛见在在的一要工在一在在有在工在一在在一在一在有}");
        smsVO.setSmsPriority("5");
        smsVO.setSendType("SMS");
        smsVO.setSign("速牛科技");
        smsVO.setSaleTitle("测试短信发送");
        smsVO.setTargetNumberList(list);
        sendService.smsSend(smsVO);
    }

    @Test
    public void sendEmail(){

        SmsVO smsVO = new SmsVO();
        smsVO.setSendTime(new Date());

        List<String> list = new ArrayList<String>();
        list.add("348890836@qq.com");
        list.add("791147201@qq.com");
        list.add("528460427@qq.com");
        list.add("541377207@qq.com");



        smsVO.setSellerId("1");
        smsVO.setSaleType("导粉");
        smsVO.setContent("你好，哈哈哈。第二封邮件");
        smsVO.setSubject("测试邮件");
        smsVO.setSendType("MAIL");
        smsVO.setSign("速牛科技");
        smsVO.setFrom("zoujian1233@126.com");
        smsVO.setFromName("速牛科技");
        smsVO.setSaleTitle("测试发送");
        smsVO.setTargetNumberList(list);
        sendService.smsSend(smsVO);

    }


    @Test
    public void getCampaignSents(){
        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1  = simpleDateFormat.parse("2015-06-16");
            date2  = simpleDateFormat.parse("2015-06-18");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            EmailAdapter.getCampaignSents(114190, date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  getCampaignBounces(){

    }


    public void testSendMail(){
        List<Subscriber> subscriberList = new ArrayList<Subscriber>();
        Subscriber subscriber1 = new Subscriber();
        subscriber1.setEmail("zoujin1233@126.com");
        subscriber1.setDate2(Calendar.getInstance());
        subscriber1.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber1);



        Subscriber subscriber2 = new Subscriber();
        subscriber2.setEmail("348890836@qq.com");
        subscriber2.setDate2(Calendar.getInstance());
        subscriber2.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber2);

        Subscriber subscriber3 = new Subscriber();
        subscriber3.setEmail("791147201@qq.com");
        subscriber3.setDate2(Calendar.getInstance());
        subscriber3.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber3);

        Subscriber subscriber4 = new Subscriber();
        subscriber4.setEmail("litu@suniusoft.com");
        subscriber4.setDate2(Calendar.getInstance());
        subscriber4.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber4);

        Subscriber subscriber5 = new Subscriber();
        subscriber5.setEmail("zoujian@suniusoft.com");
        subscriber5.setDate2(Calendar.getInstance());
        subscriber5.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber5);



        Subscriber subscriber6 = new Subscriber();
        subscriber6.setEmail("zoujianmsn@hotmail.com");
        subscriber6.setDate2(Calendar.getInstance());
        subscriber6.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber6);

        Subscriber subscriber7 = new Subscriber();
        subscriber7.setEmail("541377207@qq.com");
        subscriber7.setDate2(Calendar.getInstance());
        subscriber7.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber7);

        Subscriber subscriber8 = new Subscriber();
        subscriber8.setEmail("528460427@qq.com");
        subscriber8.setDate2(Calendar.getInstance());
        subscriber8.setDate1(Calendar.getInstance());
        subscriberList.add(subscriber8);






        SubscribersReslutInfo subscribersReslutInfo = EmailAdapter.addSubscribersByInfo(subscriberList, "002", DoubleOptIn.Off);
        subscribersReslutInfo.toString();

        Campaign campaign = new Campaign();

        campaign.setCampaignName("TEST007");
        campaign.setSubject("这是第一封测试邮件");
        campaign.setContent("这是邮件测试内容");
        campaign.setFrom("速牛科技");
        campaign.setFromEmail("zoujian1233@126.com");
        campaign.setSchedule(Calendar.getInstance());

        List<String> list = new ArrayList<String>();
        list.add("002");

        int code = EmailAdapter.createCampaign(campaign, list, -1);

        System.out.print(code);
    }



    @Test
    public void receive(){
        List<Mo> moList = SMSClient.getMO();
        for(Mo mo:moList){

        }
    }

    @Test
    public void lock(){
        ConcurrentControlHelper.releaseDistributedLock("POINT_NUM" + "_" + "2015072921520343" + "_LOCK");
    }





}

