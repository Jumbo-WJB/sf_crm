package com.shufensoft.crm.biz.service;

import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.biz.service.wx.vo.WXUserInfoVO;
import com.shufensoft.crm.biz.service.wx.vo.WXUserListVO;
import com.shufensoft.crm.common.api.helper.WXHelper;
import com.shufensoft.crm.common.utils.Md5Encrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 微信相关接口测试类
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/4/15 9:52  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWXService {

    //appid = wx3205b30b48d4e225 大喇叭
    //secret= c6bcff4953da9b23b38caa24cd2ebfa4
    public static final String APP_ID="wx3205b30b48d4e225";
    public static final String SECRET = "c6bcff4953da9b23b38caa24cd2ebfa4";
    public static final Long sellerId = 1l;



    @Autowired
    WXService wXService;

    @Autowired
    private IPointService pointService;

    private static WXAdapter wxAdapter = new WXAdapter();

    @Test
    public void getAccessToken(){

        String result = wXService.getAccessToken(sellerId);
    }

    @Test
    public void getUser(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("access_token","EVssugciezoIxbbxG7-U1M_towaW09zYlr_7AoAJ-61IpAqeM_HZ_3wiS6BEX-DptvwYM-u-sEAkDaDp8N3sAtZK86npqLytIZORIjrWbYQ");
        WXUserListVO userListVO = WXAdapter.getUserOpenIdList(params);
        userListVO.toString();
    }

    @Test
    public void getUserInfo(){
        String access_token="EVssugciezoIxbbxG7-U1M_towaW09zYlr_7AoAJ-61IpAqeM_HZ_3wiS6BEX-DptvwYM-u-sEAkDaDp8N3sAtZK86npqLytIZORIjrWbYQ";
        String openid = "oWVlNtxrGWwzC6Ozqb8tLN9ZamLk";
        WXUserInfoVO userInfoVO = wxAdapter.getUserInfo(sellerId, openid);
    }


    @Test
    public void sendRedPack (){
        Map<String,String>  paramsT = new HashMap<String, String>();
        paramsT.put("nonce_str", WXHelper.createNoncestr());
        paramsT.put("mch_billno","201504120104401");
        paramsT.put("mch_id","1233897602");
        //paramsT.put("wxappid","wxe086840f625d1358");
        paramsT.put("wxappid","wx3205b30b48d4e225"); //wxaf01ef98c95b722f
        paramsT.put("nick_name","11");
        paramsT.put("send_name","11");
        paramsT.put("re_openid","oRx0StzJiNd2u9pcxt6YIs2ST2xY");
        paramsT.put("total_amount","100");
        paramsT.put("min_value", "100");
        paramsT.put("max_value","100");
        paramsT.put("total_num","1");
        paramsT.put("wishing","11");   //祝福语
        paramsT.put("client_ip","127.0.0.1");
        paramsT.put("act_name","11");  //活动名称
        paramsT.put("remark","111");
        String stringSignTemp = WXHelper.getContent(paramsT, "tDFtRWKRD5yMOiQ1pjB6J24Xm0soVJ5y");
        String sign = Md5Encrypt.md5(stringSignTemp).toUpperCase();
        paramsT.put("sign",sign);
        WXAdapter.sendredpack(paramsT);
    }

    /**
     * 微信支付转账
     */
    @Test
    public   void  wxTransfers() {
//       Map<String,String>  paramsT= new HashMap<String, String>();
//       paramsT.put("mch_appid","wx3205b30b48d4e225");
//       paramsT.put("mchid","1233328002");
//       paramsT.put("nonce_str", WXHelper.createNoncestrByLen(16));
//       paramsT.put("partner_trade_no",WXHelper.createMchId("123123"));
//       paramsT.put("openid","oRx0St7NJAFfFlqYKkxUOg05DzxA");
//       paramsT.put("check_name","NO_CHECK");
//       paramsT.put("re_user_name","test");
//       paramsT.put("amount","5");
//       paramsT.put("desc","test");
//       paramsT.put("spbill_create_ip","127.0.0.1");
//       String stringSignTemp = WXHelper.getContent(paramsT, "22222222222222222222222222222222");
//       String sign = Md5Encrypt.md5(stringSignTemp).toUpperCase();
//       paramsT.put("sign",sign);
//       WXAdapter.enterpriseTransfers(paramsT,"1l");
//

        /**
         * 宝娜斯风情
         */
        Map<String, String> params = new HashMap<String, String>();
        params.put("partner_trade_no", WXHelper.createMchId("7785062841"));
        params.put("openid", "os4fXsgcgAabKYcsv9tbn9OvKyjo");
        params.put("amount", "100");

        try {
            WXAdapter.enterpriseTransfers(params, 2+"");
        }catch (Exception e){

        }

    }

    @Test
     public void pullUserInfo(){
        String access_token="EVssugciezoIxbbxG7-U1M_towaW09zYlr_7AoAJ-61IpAqeM_HZ_3wiS6BEX-DptvwYM-u-sEAkDaDp8N3sAtZK86npqLytIZORIjrWbYQ";
        wXService.pullWXUserInfo(sellerId,null);
    }

    @Test
    public void sendUserMessage(){
        SendWxMessage sendWxMessage = new SendWxMessage();
        sendWxMessage.setSellerId(Long.valueOf(1));
        sendWxMessage.setMsgtype("text");
        sendWxMessage.setTouser("oRx0StzJiNd2u9pcxt6YIs2ST2xY");
        sendWxMessage.setContent("sdfsdfsdfs");
        WXAdapter.sendUserMssage(sendWxMessage);
    }

    @Test
    public void getTicket(){
        String ticket = WXAdapter.getTicket(Long.valueOf(1));
        System.out.print(ticket);
    }

    @Test
    public void createPoint(){
        DBContextHolder.setDataSourceKey("1");
        pointService.createPoint(Long.valueOf(1),Long.valueOf(980522626),"QD",Long.valueOf(980522626),null);
    }
}
