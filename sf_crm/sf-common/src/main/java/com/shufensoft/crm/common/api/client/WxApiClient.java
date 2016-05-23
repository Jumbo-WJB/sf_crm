package com.shufensoft.crm.common.api.client;

import com.shufensoft.crm.common.api.exception.WxApiException;
import com.shufensoft.crm.common.api.request.WxRequest;
import com.shufensoft.crm.common.api.response.ApiResponse;
import com.shufensoft.crm.common.api.response.WxResponse;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.HttpUtils;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/4/19 14:05  
 *  @modifier litu  litu@shufensoft.com 2015/5/22 14:05
 *  
 */

public class WxApiClient extends BaseApiClient {


    /**
     * 微信接口客户端GET调用
     *
     * @param wxRequest 接口get请求
     * @return 接口返回结果
     * @throws Exception
     */
    public  WxResponse doGet(WxRequest wxRequest) throws WxApiException {

        WxResponse wxResponse = new WxResponse();
        ApiResponse apiResponse = super.doGet(wxRequest);
        AssertsUtil.notNull(apiResponse,"apiResponse");
        AssertsUtil.notNull(apiResponse.getResultJson(),"apiResponse ResultJson");

        Map mapResult = (Map) JSONUtils.parseToObject(apiResponse.getResultJson(), Map.class);

        if(mapResult == null){
            throw  new WxApiException("result is null");
        }

        String errcode = String.valueOf(mapResult.get("errcode"));
        if (StringUtils.isNotBlank(errcode) && !"0".equals(errcode)&&"null"!=errcode) {
            String errmsg = String.valueOf(mapResult.get("errmsg"));
            wxResponse.setErrorCode(errcode);
            wxResponse.setErrorMessage(errmsg);
        } else {
            wxResponse.setErrorCode("0");
            wxResponse.setResultJson(apiResponse.getResultJson());
        }

        return wxResponse;
    }


    /**
     * 微信接口客户端POST调用
     *
     * @param wxRequest 请求参数
     * @return 接口返回结果
     * @throws Exception
     */
    public  WxResponse doPost(WxRequest wxRequest) throws WxApiException {

        WxResponse wxResponse = new WxResponse();

        String result = HttpUtils.doPost(wxRequest.getApi(), wxRequest.getStringParames(), "UTF-8", wxRequest.getSecrtePath(),wxRequest.getMchId());

        Map mapResult = (Map) JSONUtils.parseToObject(result, Map.class);

        if(mapResult == null){
            return wxResponse;
        }

        String errcode = String.valueOf(mapResult.get("errcode"));
        wxResponse.setErrorCode(errcode);

        if ("0".equals(errcode)) {
            String bizId = String.valueOf(mapResult.get("msgid"));
            if (StringUtils.isBlank(bizId)) {
                wxResponse.setReturnBizId(bizId);
            }
        } else {
            String errmsg = String.valueOf(mapResult.get("errmsg"));
            wxResponse.setErrorMessage(errmsg);
        }

        return wxResponse;
    }

    /**
     * 上传图文消息内的图片
     * @param wxRequest 请求参数
     * @param file 上传的图片文件
     * @return 接口返回结果
     * @throws WxApiException
     */
    public WxResponse doFormPost(WxRequest wxRequest,File file) throws WxApiException {

        WxResponse wxResponse = new WxResponse();

        String url = wxRequest.getUrl() + wxRequest.getApi();

        String result = HttpUtils.doFormPost(url, file, "UTF-8");

        Map mapResult = (Map) JSONUtils.parseToObject(result, Map.class);

        if(mapResult == null){
            return wxResponse;
        }

        if (mapResult.containsKey("thumb_media_id")){
            String mediaId = String.valueOf(mapResult.get("thumb_media_id"));
            wxResponse.setMediaId(mediaId);
        }else {
            String errcode = String.valueOf(mapResult.get("errcode"));
            wxResponse.setErrorCode(errcode);
            String errmsg = String.valueOf(mapResult.get("errmsg"));
            wxResponse.setErrorMessage(errmsg);
        }

        return wxResponse;
    }


    /**
     * 微信接口客户端POST调用
     *
     * @param wxRequest 请求参数
     * @return 接口返回结果
     * @throws Exception
     */
    public  WxResponse doJsonPost(WxRequest wxRequest) throws WxApiException {

        WxResponse wxResponse = new WxResponse();
        ApiResponse apiResponse = super.doJsonPost(wxRequest);
        AssertsUtil.notNull(apiResponse,"apiResponse");
        AssertsUtil.notNull(apiResponse.getResultJson(),"apiResponse ResultJson");

        Map mapResult = (Map) JSONUtils.parseToObject(apiResponse.getResultJson(), Map.class);

        if(mapResult == null){
            return wxResponse;
        }

        if (mapResult.containsKey("media_id")){
            wxResponse.setMediaId(String.valueOf(mapResult.get("media_id")));
        }

        String errcode = String.valueOf(mapResult.get("errcode"));
        wxResponse.setErrorCode(errcode);

        if ("0".equals(errcode)) {
            String bizId = String.valueOf(mapResult.get("msgid"));
            if (StringUtils.isBlank(bizId)) {
                wxResponse.setReturnBizId(bizId);
            }
        } else {
            String errmsg = String.valueOf(mapResult.get("errmsg"));
            wxResponse.setErrorMessage(errmsg);
        }

        return wxResponse;
    }


    /**
     * 微信企业转账接口客户端POST调用
     *
     * @param wxRequest 请求参数
     * @return 接口返回结果
     * @throws Exception
     */
    public  String doEnterpriseTransfersPost(WxRequest wxRequest) throws WxApiException {

        WxResponse wxResponse = new WxResponse();

        String result = HttpUtils.doPost(wxRequest.getApi(), wxRequest.getStringParames(), "UTF-8", wxRequest.getSecrtePath(),wxRequest.getMchId());

        if(!result.contains("SUCCESS")){
            throw new  WxApiException("企业转账失败");
        }

        return result;
    }

}
