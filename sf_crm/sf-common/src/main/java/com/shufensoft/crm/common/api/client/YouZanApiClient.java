package com.shufensoft.crm.common.api.client;

import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.exception.YouZanApiException;
import com.shufensoft.crm.common.api.helper.KdtApiHelper;
import com.shufensoft.crm.common.api.request.YouZanRequest;
import com.shufensoft.crm.common.api.response.ApiResponse;
import com.shufensoft.crm.common.api.response.YouZanRespone;
import com.shufensoft.crm.common.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 口袋通api 客户端
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/14 17:29  
 */
public class YouZanApiClient extends BaseApiClient {

    private static final String Version = "1.0";

    private static final String YOUZAN_API_KEY = "youzan.api.url";

    private static final String apiEntry = PropertyReader.getValue(YOUZAN_API_KEY);

    private static final String format = "json";

    private static final String signMethod = "md5";

    private static final String DefaultUserAgent = "KdtApiSdk Client v0.1";

    private String appId;
    private String appSecret;

    public YouZanApiClient(String appId, String appSecret) throws YouZanApiException {

        if ("".equals(appId) || "".equals(appSecret)) {
            throw new YouZanApiException("appId 和 appSecret 不能为空");
        }

        this.appId = appId;
        this.appSecret = appSecret;
    }

    /**
     * @param youZanRequest
     * @return 接口get请求
     * @throws Exception
     */
    public YouZanRespone doGet(YouZanRequest youZanRequest) throws YouZanApiException {

        AssertsUtil.notNull(youZanRequest,"youZanRequest");
        youZanRequest.setUrl(apiEntry==null?null:apiEntry+"?");
        youZanRequest.setApi(getParamStr(buildCompleteParams(youZanRequest.getApi(), youZanRequest.getParames())));
        youZanRequest.setParames(null);
        YouZanRespone youZanRespone = null;

        ApiResponse  apiResponse;
        try {

            apiResponse = super.doGet(youZanRequest);
            AssertsUtil.notNull(apiResponse, "apiResponse");
            AssertsUtil.notNull(apiResponse.getResultJson(),"apiResponse ResultJson");

            if (apiResponse != null) {
                youZanRespone =  (YouZanRespone) BeanCopierUtils.copyProperties(apiResponse, YouZanRespone.class);
            }

            Map mapResult = (Map) JSONUtils.parseToObject(youZanRespone.getResultJson(), Map.class);
            Map responseResult = (Map)mapResult.get("response");
            Map errorResponseResult = (Map)mapResult.get("error_response");
            if(errorResponseResult!=null){
                youZanRespone.setErrorCode(String.valueOf(errorResponseResult.get("code")));
                youZanRespone.setErrorMessage(String.valueOf(errorResponseResult.get("msg")));
                return youZanRespone;
            }
            youZanRespone.setErrorCode(ApiErrorEnums.SUCCESS.getCode());
            youZanRespone.setHashNext(getHasNext(responseResult));
            youZanRespone.setTotalResults(getTotalResults(responseResult));


            if(responseResult.containsKey("trades")){
                List tradeList = (List)responseResult.get("trades");
                youZanRespone.setResultJson(JSONUtils.toJSONStr(tradeList));
            }else if(responseResult.containsKey("user")){
                Map userMap = (Map)responseResult.get("user");
                youZanRespone.setResultJson(JSONUtils.toJSONStr(userMap));
            }else{
                youZanRespone.setResultJson(JSONUtils.toJSONStr(responseResult));
            }


        } catch (Exception e) {
            youZanRespone.setErrorCode(ApiErrorEnums.ERROR.getCode());
            youZanRespone.setErrorMessage(e.getMessage()==null?e.toString():e.getMessage());
            return youZanRespone;
        }

        return youZanRespone;

    }


    /**
     * @param kdtRequest
     * @return 接口post请求
     * @throws Exception
     */
    public YouZanRespone doPost(YouZanRequest kdtRequest) throws YouZanApiException {

        String url = apiEntry + getParamStr(buildCompleteParams(kdtRequest.getApi(), kdtRequest.getParames()));

        HttpPost httppost = new HttpPost(url);

        Map<String,String> headerMap = kdtRequest.getHeaderMap();
        for(String key : headerMap.keySet()){
            httppost.setHeader(key,headerMap.get(key));
        }

        List<String> filePaths = kdtRequest.getFilePaths();
        String fileKey = kdtRequest.getFileKey();

        if (null != filePaths && filePaths.size() > 0 && null != fileKey && !"".equals(fileKey)) {
            MultipartEntity mpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            for (int i = 0; i < filePaths.size(); i++) {
                File file = new File(filePaths.get(i));
                ContentBody cbFile = new FileBody(file);
                mpEntity.addPart(fileKey, cbFile);
            }

            httppost.setEntity(mpEntity);
        }

        YouZanRespone kdtRespone = new YouZanRespone();
        kdtRespone.setErrorCode(ApiErrorEnums.ERROR.getCode());
        String response = null;
        try {
            response = HttpUtils.doPost(httppost);
        } catch (Exception e) {
            kdtRespone.setErrorMessage(e.getMessage());
            return kdtRespone;
        }

        return kdtRespone;

    }

    private Integer getTotalResults(Map<String, Object> result) {

        if (result != null) {
            String value = String.valueOf(result.get("total_results"));
            if (StringUtils.isNumeric(value)) {
                return Integer.parseInt(value);
            }

        }

        return null;
    }

    private Boolean getHasNext(Map<String, Object> result) {

        if (result != null) {
            return (Boolean)result.get("has_next");
        }

        return false;
    }

    private HashMap<String, String> buildCompleteParams(String method, Map<String, String> parames) throws YouZanApiException {
        HashMap<String, String> commonParams = getCommonParams(method);
        for (String key : parames.keySet()) {
            if (commonParams.containsKey(key)) {
                throw new YouZanApiException("参数名冲突");
            }

            commonParams.put(key, parames.get(key));
        }

        commonParams.put(KdtApiHelper.SIGN_KEY, KdtApiHelper.sign(appSecret, commonParams));
        return commonParams;
    }

    private HashMap<String, String> getCommonParams(String method) {
        HashMap<String, String> parames = new HashMap<String, String>();
        parames.put(KdtApiHelper.APP_ID_KEY, appId);
        parames.put(KdtApiHelper.METHOD_KEY, method);
        parames.put(KdtApiHelper.TIMESTAMP_KEY, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        parames.put(KdtApiHelper.FORMAT_KEY, format);
        parames.put(KdtApiHelper.SIGN_METHOD_KEY, signMethod);
        parames.put(KdtApiHelper.VERSION_KEY, Version);
        return parames;
    }
}

