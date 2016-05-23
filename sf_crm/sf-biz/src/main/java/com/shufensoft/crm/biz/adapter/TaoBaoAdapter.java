package com.shufensoft.crm.biz.adapter;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.oauth.vo.TaoBaoAccessTokenVO;
import com.shufensoft.crm.common.api.client.TaoBaoOauthApiClient;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.enums.TaoBaoApiEnums;
import com.shufensoft.crm.common.api.exception.TaoBaoOauthException;
import com.shufensoft.crm.common.api.request.TaoBaoRequest;
import com.shufensoft.crm.common.api.response.TaoBaoResponse;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                淘宝adpter
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class TaoBaoAdapter {

    private static final Logger logger = Logger.getLogger(TaoBaoAdapter.class);

    private static TaoBaoOauthApiClient taoBaoOauthClient = new TaoBaoOauthApiClient();

    public static String TAOBAO_OAUTH_URL_KEY = "taobao.oauth.url";

    public static String taobaoOauthUrl = PropertyReader.getValue(TAOBAO_OAUTH_URL_KEY);

    public static String TAOBAO_REDIRECT_URI_KEY = "taobao.redirect.uri";

    public static String taobaoRedirectUri = PropertyReader.getValue(TAOBAO_REDIRECT_URI_KEY);

    public TaoBaoAccessTokenVO getAccessToken(String source, String code, String appId, String appSecret) {

        TaoBaoRequest taoBaoRequest = new TaoBaoRequest();
        taoBaoRequest.setApi(TaoBaoApiEnums.TAOBAO_OAUTH_TOKEN_GET.getCode());
        taoBaoRequest.setUrl(taobaoOauthUrl);

        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_id", appId);
        params.put("client_secret", appSecret);
        params.put("redirect_uri", taobaoRedirectUri);

        if(DaoConstant.UserSource.TMALL.equals(source)){
            params.put("view", "tmall");
        }else{
            params.put("view", "web");
        }

        taoBaoRequest.setParames(params);

        TaoBaoResponse taoBaoResponse = null;
        try {
            taoBaoResponse = taoBaoOauthClient.doPost(taoBaoRequest);
        } catch (Exception e) {
            logger.error("execute " + taoBaoRequest.getApi() + " error", e);
            throw new TaoBaoOauthException(taoBaoRequest.getApi(), e.getMessage(), e);
        }

        if (taoBaoResponse != null) {
            if (ApiErrorEnums.SUCCESS.getCode().equals(taoBaoResponse.getErrorCode())) {
                String resultJson = taoBaoResponse.getResultJson();
                logger.info("execute " + taoBaoRequest.getApi() + " result:" + resultJson);
                return (TaoBaoAccessTokenVO) JSONUtils.parseToObject(resultJson, TaoBaoAccessTokenVO.class);
            }

            logger.error("execute " + taoBaoRequest.getApi() + " error,errorMsg:"
                    + (taoBaoResponse.getErrorMessage() == null ? "" : taoBaoResponse.getErrorMessage()));
            throw new TaoBaoOauthException(taoBaoRequest.getApi(), taoBaoResponse.getErrorCode(),
                    taoBaoResponse.getErrorMessage());

        }

        return null;

    }

    /**
     *
     * */
    public TaoBaoResponse getRefreshAccessToken(SellerShop sellerShop){

        TaoBaoRequest taoBaoRequest = new TaoBaoRequest();
        taoBaoRequest.setApi(TaoBaoApiEnums.TAOBAO_OAUTH_TOKEN_GET.getCode());
        taoBaoRequest.setUrl(taobaoOauthUrl);

        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "refresh_token");
        params.put("refresh_token",sellerShop.getShopRefreshToken());
        params.put("client_id",sellerShop.getShopAppId());
        params.put("client_secret",sellerShop.getShopAppSecret());
        taoBaoRequest.setParames(params);

        TaoBaoResponse taoBaoResponse = null;
        try {
            taoBaoResponse = taoBaoOauthClient.doPost(taoBaoRequest);
        } catch (Exception e) {
            logger.error("execute " + taoBaoRequest.getApi() + " error", e);
            throw new TaoBaoOauthException(taoBaoRequest.getApi(), e.getMessage(), e);
        }

//        if (taoBaoResponse != null) {
//            if (ApiErrorEnums.SUCCESS.getCode().equals(taoBaoResponse.getErrorCode())) {
//                String resultJson = taoBaoResponse.getResultJson();
//                logger.info("execute " + taoBaoRequest.getApi() + " result:" + resultJson);
//                return (TaoBaoAccessTokenVO) JSONUtils.parseToObject(resultJson, TaoBaoAccessTokenVO.class);
//            }
//
//            logger.error("execute " + taoBaoRequest.getApi() + " error,errorMsg:"
//                    + (taoBaoResponse.getErrorMessage() == null ? "" : taoBaoResponse.getErrorMessage()));
//            throw new TaoBaoOauthException(taoBaoRequest.getApi(), taoBaoResponse.getErrorCode(),
//                    taoBaoResponse.getErrorMessage());

//        }

        return taoBaoResponse;
    }


}
