package com.shufensoft.crm.biz.adapter;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.reply.WxMedia;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.send.SendWxArticles;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.domain.generation.send.WxUploadNews;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.wx.vo.TicketVO;
import com.shufensoft.crm.biz.service.wx.vo.WXUserInfoVO;
import com.shufensoft.crm.biz.service.wx.vo.WXUserListVO;
import com.shufensoft.crm.biz.service.wx.vo.WxUserOuathVO;
import com.shufensoft.crm.biz.vo.AccessTokenVo;
import com.shufensoft.crm.common.api.client.WxApiClient;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.enums.WXApiEnums;
import com.shufensoft.crm.common.api.exception.WxApiException;
import com.shufensoft.crm.common.api.helper.WXHelper;
import com.shufensoft.crm.common.api.request.WxRequest;
import com.shufensoft.crm.common.api.response.WxResponse;
import com.shufensoft.crm.common.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 微信接口服务
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/4/18 16:27  
 *
 * @modifier litu  litu@shufensoft.com 2015/5/22 16:05
 */

public class WXAdapter {

    private static final Logger logger = Logger.getLogger(WXAdapter.class);

    private static Properties props = new Properties();

    private static WxApiClient wxApiClient = new WxApiClient();

    public static String WX_API_URI_KEY = "wx.api.url";

    public static String wxApiUri = PropertyReader.getValue(WX_API_URI_KEY);

    public static String WX_MCH_API_URI_KEY = "wx.mch.api.url";

    public static String wxMchApiUri = PropertyReader.getValue(WX_MCH_API_URI_KEY);

    /**
     * 获取微信access_token接口
     *
     * @param appId  参数
     * @param secret 参数
     * @return access_token
     * @modifier litu  litu@shufensoft.com 2015/5/22 14:05
     */
    public static AccessTokenVo getAccessToken(String appId, String secret) throws WxApiException {

        String result = null;
        AccessTokenVo accessTokenVo = null;
        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.ACCESS_TOKEN_URL.getCode());

        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", appId);
        params.put("secret", secret);

        wxRequest.setParames(params);
        WxResponse wxResponse = wxApiClient.doGet(wxRequest);

        if (ApiErrorEnums.SUCCESS.getCode().equals(wxResponse.getErrorCode())) {

            Map resultMap = (Map<String, Object>) JSONUtils.parseToObject(wxResponse.getResultJson(), Map.class);
            if (resultMap != null) {
                accessTokenVo = new AccessTokenVo();
                result = (String) resultMap.get("access_token");
                accessTokenVo.setAccessToken(result);
                accessTokenVo.setExpiresTime(Integer.parseInt(String.valueOf(resultMap.get("expires_in"))));
            }

        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }

        return accessTokenVo;
    }


    /**
     * 获取微信jsapi_ticket接口
     *
     * @param sellerId 参数
     * @return TicketVO
     * @modifier litu  litu@shufensoft.com 2015/5/22 14:05
     */
    public static TicketVO getTicketVO(Long sellerId) throws WxApiException {

        String accessToken = getAccessToken(sellerId);

        WxResponse wxResponse = null;
        TicketVO ticketVO = null;

        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.GET_API_TICKET.getCode());

        Map<String, String> userParams = new HashMap<String, String>();
        userParams.put("access_token", accessToken);
        userParams.put("type", "jsapi");
        wxRequest.setParames(userParams);

        try {
            wxResponse = wxApiClient.doGet(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);

        }

        if ("0".equals(wxResponse.getErrorCode())) {
            Map resultMap = (Map<String, Object>) JSONUtils.parseToObject(wxResponse.getResultJson(), Map.class);
            if (resultMap != null) {
                ticketVO = new TicketVO();
                ticketVO.setTicket((String) resultMap.get("ticket"));
                ticketVO.setExpiresTime(Integer.parseInt(String.valueOf(resultMap.get("expires_in"))));
            }
        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }

        return ticketVO;
    }


    /**
     * 获取关注者的用户列表
     *
     * @param params 参数
     * @return 用户列表
     */
    public static WXUserListVO getUserOpenIdList(Map<String, String> params) {

        WxResponse wxResponse = null;
        WxRequest wxRequest = null;
        try {
            wxRequest = new WxRequest();
            wxRequest.setUrl(wxApiUri);
            wxRequest.setApi(WXApiEnums.USER_GET.getCode());
            wxRequest.setParames(params);
            wxResponse = wxApiClient.doGet(wxRequest);
        } catch (Exception e) {
            logger.error("获取用户列表接口失败：" + e);
        }

        WXUserListVO userListVO = null;
        if ("0".equals(wxResponse.getErrorCode())) {
            String resultJson = wxResponse.getResultJson();
            if (StringUtils.isNotBlank(resultJson)) {
                JSONObject jsonObject = (JSONObject) JSONUtils.parseToObject(resultJson, JSONObject.class);
                userListVO = new WXUserListVO();
                userListVO.setTotal(jsonObject.getLongValue("total"));
                userListVO.setCount(jsonObject.getLongValue("count"));
                userListVO.setNext_openid(jsonObject.getString("next_openid"));
                JSONObject jsonData = jsonObject.getJSONObject("data");
                if (jsonData != null) {
                    JSONArray jsonArray = jsonData.getJSONArray("openid");
                    List<String> list = new ArrayList<String>();
                    if (jsonArray == null || jsonArray.size() <= 0) {
                        return userListVO;
                    }
                    for (int i = 0; i < jsonArray.size(); i++) {
                        list.add(String.valueOf(jsonArray.get(i)));
                    }
                    userListVO.setUserOpenIdList(list);
                }

            }

            return userListVO;
        }

        if (StringUtils.isNotBlank(wxResponse.getErrorMessage())) {
            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }

        return userListVO;
    }

    /**
     * 获取微信AccessToken
     *
     * @param sellerId
     * @return
     */
    public static String getAccessToken(Long sellerId) {

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));
        if (sellerConfigInfo != null) {

            String accessToken = sellerConfigInfo.getWxAccessToken();
            Date expiresDate = sellerConfigInfo.getWxTokenExpire();
            if (expiresDate != null) {
                expiresDate = DateUtils.addMinutes(expiresDate, -30);//提前30分钟比较
            }

            if (StringUtils.isBlank(accessToken) || expiresDate == null || new Date().after(expiresDate)) {
                AccessTokenVo accessTokenVo = getAccessToken(sellerConfigInfo.getWxAppId(), sellerConfigInfo.getWxAppSecret());
                accessToken = accessTokenVo.getAccessToken();
                sellerConfigInfo.setWxAccessToken(accessToken);
                expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, accessTokenVo.getExpiresTime());
                sellerConfigInfo.setWxTokenExpire(expiresDate);
                sellerConfigInfo.setWxRefreshToken(accessTokenVo.getRefreshToken());
                SellerConfigCache.put(String.valueOf(sellerId), sellerConfigInfo);
            }
            return accessToken;
        }

        return null;

    }

    /**
     * 获取微信AccessToken
     *
     * @param sellerConfigInfo
     * @return
     */
    public static String getAccessToken(SellerConfigInfo sellerConfigInfo) {
        AccessTokenVo accessTokenVo = getAccessToken(sellerConfigInfo.getWxAppId(), sellerConfigInfo.getWxAppSecret());
        if(accessTokenVo != null){
            sellerConfigInfo.setWxAccessToken(accessTokenVo.getAccessToken());
            Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, accessTokenVo.getExpiresTime());
            sellerConfigInfo.setWxTokenExpire(expiresDate);
            SellerConfigCache.put(String.valueOf(sellerConfigInfo.getSellerId()), sellerConfigInfo);
            return accessTokenVo.getAccessToken();
        }
        return null;

    }

    /**
     * @param code
     * @return 微信授权后返回的信息
     */
    public static WxUserOuathVO ouath(String wxAppId , String wxAppSecret , String code) {

        AssertsUtil.notBlank(code, "code");
        WxResponse wxResponse = null;
        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.WX_OUATH_API.getCode());

        Map<String, String> mapParames = new HashMap<String, String>();
        mapParames.put("appid", wxAppId);
        mapParames.put("secret", wxAppSecret);
        mapParames.put("grant_type", "authorization_code");
        mapParames.put("code", code);
        wxRequest.setParames(mapParames);
        try {
            wxResponse = wxApiClient.doGet(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);
        }

        if ("0".equals(wxResponse.getErrorCode())) {

            String resultJson = wxResponse.getResultJson();
            Map mapResult = (Map) JSONUtils.parseToObject(resultJson, Map.class);
            WxUserOuathVO wxUserOuathVO = new WxUserOuathVO();
            wxUserOuathVO.setAccessToken((String) mapResult.get("access_token"));
            wxUserOuathVO.setOpenid((String) mapResult.get("openid"));
            wxUserOuathVO.setScope((String) mapResult.get("scope"));

            return wxUserOuathVO;
        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }
    }

    /**
     * 向指定OPENID发送信息
     *
     * @param sendWxMessage
     */
    public static void sendUserMssage(SendWxMessage sendWxMessage) {

        WxResponse wxResponse = null;
        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        if ("mass".equals(sendWxMessage.getSendType())){
            wxRequest.setApi(WXApiEnums.MASS_SEND.getCode() + getAccessToken(sendWxMessage.getSellerId()));
        }else{
            wxRequest.setApi(WXApiEnums.SEND_MESSAGE_TO_USER.getCode() + getAccessToken(sendWxMessage.getSellerId()));
        }

        Map<String, String> params = new HashMap<String, String>();
        JSONObject object = new JSONObject();
        if ("mass".equals(sendWxMessage.getSendType())){
            object.put("touser", sendWxMessage.getToUserList());
        }else{
            object.put("touser", sendWxMessage.getTouser());
        }
        object.put("msgtype", sendWxMessage.getMsgtype());
        if ("image".equals(sendWxMessage.getMsgtype())) {
            params.put("media_id", sendWxMessage.getMediaId());
            object.put("image", params);
        } else if ("text".equals(sendWxMessage.getMsgtype())) {
            params.put("content", sendWxMessage.getContent());
            object.put("text", params);
        }else if ("mpnews".equals(sendWxMessage.getMsgtype())){
            params.put("media_id", sendWxMessage.getMediaId());
            object.put("mpnews", params);
        }else if ("news".equals(sendWxMessage.getMsgtype())){
            Map<String, List> mapList = new HashMap<String, List>();
            List<SendWxArticles> articlesList = sendWxMessage.getSendWxArticlesList();
            mapList.put("articles",articlesList);
            object.put("news",mapList);
        } else {
            throw new WxApiException("msgType参数不正确");
        }
        wxRequest.setJsonStrParam(object.toString());
        try {
            wxResponse = wxApiClient.doJsonPost(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);
        }

        if ("0".equals(wxResponse.getErrorCode())) {
            String resultJson = wxResponse.getResultJson();
            //userInfoVO = (WXUserInfoVO) JSONUtils.parseToObject(resultJson, WXUserInfoVO.class);
        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }

    }

    /**
     * 新增临时素材的media_id
     * @param sellerId
     * @param filePath
     * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @return
     */
    public static String getMediaInfo(Long sellerId, String filePath, String type){
        File file = new File(filePath);

        if (!file.exists()){
            return null;
        }

        WxResponse wxResponse = null;
        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.UPLOAD.getCode() + getAccessToken(sellerId) + "&type="+type);

        try {
            wxResponse = wxApiClient.doFormPost(wxRequest,file);
        }catch (Exception e){
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);
        }

        if (StringUtils.isBlank(wxResponse.getMediaId())){
            return null;
        }

        return wxResponse.getMediaId();
    }

    public static String uploadNews(WxUploadNews uploadNews){

        WxResponse wxResponse = null;
        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.UPLOAD_NEWS.getCode() + getAccessToken(uploadNews.getSellerId()));

        List<WxMedia> mediaList = uploadNews.getWxMediaList();
        List<Map> mapList = new ArrayList<Map>();
        for (WxMedia wxNews : mediaList){
            Map<String, String> params = new HashMap<String, String>();
            params.put("thumb_media_id", wxNews.getThumbMediaId());
            params.put("author", wxNews.getAuthor());
            params.put("title", wxNews.getTitle());
            params.put("content_source_url", wxNews.getContentSourceUrl());
            params.put("content", wxNews.getContent());
            params.put("digest", wxNews.getDigest());
            params.put("show_cover_pic", wxNews.getShowCoverPic());
            mapList.add(params);
        }

        JSONObject object = new JSONObject();
        object.put("articles", mapList);

        wxRequest.setJsonStrParam(object.toString());
        try {
            wxResponse = wxApiClient.doJsonPost(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);
        }

        if (StringUtils.isBlank(wxResponse.getMediaId())){
            return null;
        }

        return wxResponse.getMediaId();

    }

    /**
     * @param openId   用户openId
     * @param sellerId
     * @return 用户详细信息
     * @author litu  litu@shufensoft.com 2015/5/22 14:05
     * 获取关注用户详细信息
     */
    public WXUserInfoVO getUserInfo(Long sellerId, String openId) throws WxApiException {

        WxResponse wxResponse = null;
        WXUserInfoVO userInfoVO;

        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.GET_USER_INFO.getCode());

        Map<String, String> userParams = new HashMap<String, String>();
        userParams.put("access_token", getAccessToken(sellerId));
        userParams.put("openid", openId);
        userParams.put("lang", "zh_CN");
        wxRequest.setParames(userParams);

        try {
            wxResponse = wxApiClient.doGet(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);

        }

        if ("0".equals(wxResponse.getErrorCode())) {
            String resultJson = wxResponse.getResultJson();
            userInfoVO = (WXUserInfoVO) JSONUtils.parseToObject(resultJson, WXUserInfoVO.class);
        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }


        return userInfoVO;
    }


    /**
     * @param openId      用户openId
     * @param accessToken 授权得到的accessToken与基础支持的不同
     * @return 用户详细信息
     * @author zoujian  zujian@suniusoft.com 2015/7/14 14:05
     * 获取显性授权的用户详细信息
     */
    public static WXUserInfoVO getOuathUserInfo(String openId, String accessToken) throws WxApiException {

        WxResponse wxResponse = null;
        WXUserInfoVO userInfoVO = null;

        WxRequest wxRequest = new WxRequest();
        wxRequest.setUrl(wxApiUri);
        wxRequest.setApi(WXApiEnums.WX_OUATH_USER_INFO.getCode());

        Map<String, String> userParams = new HashMap<String, String>();
        userParams.put("access_token", accessToken);
        userParams.put("openid", openId);
        userParams.put("lang", "zh_CN");
        wxRequest.setParames(userParams);

        try {
            wxResponse = wxApiClient.doGet(wxRequest);
        } catch (Exception e) {
            logger.error(e.getMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]", e);

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), e.getMessage(), e);

        }

        if ("0".equals(wxResponse.getErrorCode())) {
            String resultJson = wxResponse.getResultJson();
            userInfoVO = (WXUserInfoVO) JSONUtils.parseToObject(resultJson, WXUserInfoVO.class);
        } else {
            logger.error(wxResponse.getErrorMessage() + "[api:" + wxRequest.getApi()
                    + "errorCode:" + wxResponse.getErrorCode() + "]");

            throw new WxApiException(wxRequest.getApi(), wxResponse.getErrorCode(), wxResponse.getErrorMessage());
        }


        return userInfoVO;
    }

    /**
     * 发送微信红包
     *
     * @param params 参数
     * @return 结果
     */
    public static String sendredpack(Map<String, String> params) {

        String paramsXml = XmlConverUtil.maptoXml(params);
        String result = null;
        try {
            WxRequest wxRequest = new WxRequest();

            // 暂写死，后续做配置
            wxRequest.setSecrtePath("D:\\sf_crm\\apiclient_cert.p12");
            wxRequest.setStringParames(paramsXml);
            wxRequest.setUrl(wxMchApiUri);
            wxRequest.setApi(WXApiEnums.SEND_REG_PACK.getCode());
            WxResponse wxResponse = wxApiClient.doPost(wxRequest);
            //result = wxResponse.getResult();
            result = new String(result.getBytes("gbk"));
        } catch (Exception e) {
            logger.error("发送红包接口失败:" + e.getMessage(), e);
        }
        logger.info("发送红包成功。");
        return result;
    }

    /**
     * 微信企业付款
     *
     * @param params
     * @return
     */
    public static String enterpriseTransfers(Map<String, String> params, String sellerId) {

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
        params.put("mch_appid", sellerConfigInfo.getWxAppId());
        params.put("mchid", sellerConfigInfo.getWxMchid());
        params.put("nonce_str", WXHelper.createNoncestrByLen(32));
        params.put("desc", "success");
        /** check_name 校验用户姓名选项
         * NO_CHECK：不校验真实姓名
         * FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
         * OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
         */
        params.put("check_name", "NO_CHECK");
        params.put("re_user_name", "test");
        params.put("spbill_create_ip", PropertyReader.getValue("wx.redirect.uri"));
        String stringSignTemp = WXHelper.getContent(params, sellerConfigInfo.getWxAppKey());
        String sign = Md5Encrypt.md5(stringSignTemp).toUpperCase();
        params.put("sign", sign);
        String paramsXml = XmlConverUtil.maptoXml(params);
        String result = null;

        try {
            WxRequest wxRequest = new WxRequest();
            wxRequest.setSecrtePath(PropertyReader.getValue("uploadPath")+sellerConfigInfo.getWxSecrteUrl());
            wxRequest.setStringParames(paramsXml);
            wxRequest.setUrl(wxMchApiUri + WXApiEnums.ENTERPRISE_TRANSFERS.getCode());
            wxRequest.setApi(wxMchApiUri + WXApiEnums.ENTERPRISE_TRANSFERS.getCode());
            wxRequest.setMchId(sellerConfigInfo.getWxMchid());

            result = wxApiClient.doEnterpriseTransfersPost(wxRequest);

        } catch (Exception e) {
            logger.error("企业付款接口失败:" + e.getMessage(), e);
            throw new ServiceException("企业付款接口失败");
        }

        logger.info("企业付款成功。");
        return result;
    }


    /**
     * 获取JSAPI调用凭证
     *
     * @param sellerId 商户ID
     * @return
     */
    public static String getTicket(Long sellerId) {

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));

        if (sellerConfigInfo != null) {

            String jsapiTicket = sellerConfigInfo.getWxJsapiTicket();
            Date ticketExpireDate = sellerConfigInfo.getWxTicketExpire();

            if (ticketExpireDate != null) {
                ticketExpireDate = DateUtils.addMinutes(ticketExpireDate, -30);//提前30分钟比较
            }

            if (StringUtils.isBlank(jsapiTicket) || ticketExpireDate == null || new Date().after(ticketExpireDate)) {

                TicketVO ticketVO = getTicketVO(sellerId);
                jsapiTicket = ticketVO.getTicket();
                sellerConfigInfo.setWxJsapiTicket(jsapiTicket);
                ticketExpireDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, ticketVO.getExpiresTime());
                sellerConfigInfo.setWxTicketExpire(ticketExpireDate);
                SellerConfigCache.put(String.valueOf(sellerId), sellerConfigInfo);
            }
            return jsapiTicket;

        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(WXHelper.createNoncestrByLen(32));
    }


}
