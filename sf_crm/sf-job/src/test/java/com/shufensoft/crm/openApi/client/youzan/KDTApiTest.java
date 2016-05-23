package com.shufensoft.crm.openApi.client.youzan;


import com.shufensoft.crm.common.api.client.YouZanApiClient;
import com.shufensoft.crm.common.api.enums.KdtApiEnums;
import com.shufensoft.crm.common.api.request.YouZanRequest;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 口袋通接口测试
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/15 16:21  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class KDTApiTest {

    private static final String APP_ID = "5942aa80c6b71e5216"; //这里换成你的app_id
    private static final String APP_SECRET = "fe59d72ba6100bcce2ad9a3f59f18eed"; //这里换成你的app_secret

    /*
    * 测试获取交易信息
    */
    @Test
    public void getTrade() {
        String method = KdtApiEnums.TRADES_SOLD_GET.getCode();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("start_created", "2014-04-13 01:23:34");
        params.put("end_created", "2015-04-16 01:23:34");

        //KdtAdapter.getTrade(params);
        YouZanApiClient kdtApiClient;
        HttpResponse response;

        try {
            kdtApiClient = new YouZanApiClient(APP_ID, APP_SECRET);
            YouZanRequest kdtRequest = new YouZanRequest();
            kdtRequest.setParames(params);
            kdtRequest.setApi(method);
            //KdtRespone kdtRespone = kdtApiClient.get(kdtRequest);
           //System.out.println("Response Code : " + kdtRespone.getErrorCode());
            //System.out.println(kdtRespone.getResultInfo());
            //System.out.println(kdtRespone.getResultToList("trades", YZTrade.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 测试获取单个商品信息
     */
    @Test
    public void sendGet() {
        String method = "kdt.item.get";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("num_iid", "2651514");

        YouZanApiClient kdtApiClient;

        try {

            kdtApiClient = new YouZanApiClient(APP_ID, APP_SECRET);
            YouZanRequest kdtRequest = new YouZanRequest();
            kdtRequest.setParames(params);
            kdtRequest.setApi(method);
            //KdtRespone kdtRespone = kdtApiClient.get(kdtRequest);
            //System.out.println("Response Code : " + kdtRespone.getErrorCode());
            //System.out.println("Response ErrorMsg : " + kdtRespone.getErrorMessage());
            //System.out.println(kdtRespone.getResultInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 测试获取添加商品
     */
    @Test
    public void sendPost() {
        String method = "kdt.item.add";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("price", "999.01");
        params.put("title", "测试商品");
        params.put("desc", "这是一个号商铺");
        params.put("is_virtual", "0");
        params.put("post_fee", "10.01");
        params.put("sku_properties", "");
        params.put("sku_quantities", "");
        params.put("sku_prices", "");
        params.put("sku_outer_ids", "");
        String fileKey = "images[]";
        List<String> filePaths = new ArrayList<String>();
        filePaths.add("/Users/xuexiaozhe/Desktop/1.png");
        filePaths.add("/Users/xuexiaozhe/Desktop/2.png");

        YouZanApiClient kdtApiClient;
        HttpResponse response;
        YouZanRequest kdtRequest = new YouZanRequest();
        kdtRequest.setParames(params);
        kdtRequest.setApi(method);
        kdtRequest.setFileKey(fileKey);
        kdtRequest.setFilePaths(filePaths);

        try {
            kdtApiClient = new YouZanApiClient(APP_ID, APP_SECRET);
            //KdtRespone kdtRespone = kdtApiClient.post(kdtRequest);
            //System.out.println("Response Code : " + kdtRespone.getErrorCode());
            //System.out.println(kdtRespone.getResultInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
