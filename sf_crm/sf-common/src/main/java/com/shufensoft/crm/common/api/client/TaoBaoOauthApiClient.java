package com.shufensoft.crm.common.api.client;

import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.request.TaoBaoRequest;
import com.shufensoft.crm.common.api.response.TaoBaoResponse;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.taobao.api.internal.util.WebUtils;
import org.apache.log4j.Logger;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 淘宝授权客户端
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/18  
 */
public class TaoBaoOauthApiClient {

    public static int connectTimeout = 30000;

    public static int readTimeout = 30000;


    private static final Logger logger = Logger.getLogger(TaoBaoOauthApiClient.class);


    public TaoBaoResponse doPost(TaoBaoRequest taoBaoRequest){

        AssertsUtil.notNull(taoBaoRequest,"taoBaoRequest is null");

        AssertsUtil.notContainsBlank(taoBaoRequest.getApi(), "taoBaoRequest api is null");

        AssertsUtil.notContainsBlank(taoBaoRequest.getUrl(),"taoBaoRequest api base url is null");

        TaoBaoResponse taoBaoResponse = new TaoBaoResponse();
        taoBaoResponse.setErrorCode(ApiErrorEnums.SUCCESS.getCode());

        String resultJson = null;
        try {
            resultJson = WebUtils.doPost(taoBaoRequest.getUrl()+taoBaoRequest.getApi(), taoBaoRequest.getParames(), connectTimeout, readTimeout);
        } catch (Exception e) {
            logger.error("TaoBaoOauthClient [api:"+taoBaoRequest.getApi()+" execute error,errorMsg:"+e.getMessage(),e);
            taoBaoResponse.setErrorCode(ApiErrorEnums.ERROR.getCode());
            taoBaoResponse.setErrorMessage(e.getMessage());
            return taoBaoResponse;
        }

        taoBaoResponse.setResultJson(resultJson);
        return taoBaoResponse;

    }

}
