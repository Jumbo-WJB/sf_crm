package com.shufensoft.crm.polySpire.adapter;

import com.shufensoft.crm.biz.adapter.PolySpireAdapter;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.common.api.client.CrmApiClient;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.enums.CrmApiEnums;
import com.shufensoft.crm.common.api.exception.CrmApiException;
import com.shufensoft.crm.common.api.request.CrmRequest;
import com.shufensoft.crm.common.api.response.CrmResponse;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import org.apache.log4j.Logger;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                crm api 适配器
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
public class CrmAdapter {

    private static final Logger logger = Logger.getLogger(PolySpireAdapter.class);

    public static String CRM_WEB_URL_KEY = "crm.web.url";

    public static String crmWebUrl = PropertyReader.getValue(CRM_WEB_URL_KEY);

    public static CrmApiClient crmApiClient = new CrmApiClient();

    public boolean syncComment(Long sellerId, Long shopId , List<CommentTaoBao> commentTaoBaos) {

        AssertsUtil.notNull(sellerId,"sellerId");

        AssertsUtil.notNull(shopId,"shopId");

        CrmResponse crmResponse;
        CrmRequest crmRequest = new CrmRequest();

        try {
            crmRequest.setUrl(crmWebUrl);
            crmRequest.setApi(CrmApiEnums.CRM_TAOBAO_COMMENT_ADD.getCode());
            String commentTaoBaoJson = JSONUtils.toJSONStr(commentTaoBaos);
            String jsonStr = "{\"sellerId\":"+sellerId+"{\"shopId\":"+shopId+",\"commentTaoBaos\":"+commentTaoBaoJson+"}";
            crmRequest.setJsonStrParam(jsonStr);
            crmResponse = crmApiClient.doJsonPost(crmRequest);

        } catch (Exception e) {

            logger.error("execute " + crmRequest.getApi() + " error", e);

            throw new CrmApiException(e);

        }

        if (crmResponse != null) {

            if (ApiErrorEnums.SUCCESS.getCode().equals(crmResponse.getErrorCode())) {
                return true;
            }

            logger.error("execute " + crmRequest.getApi() + " error,errorMsg:"
                    + (crmResponse.getErrorMessage() == null ? "" : crmResponse.getErrorMessage()));

            throw new CrmApiException(crmRequest.getApi(), crmResponse.getErrorCode(),
                    crmResponse.getErrorMessage());

        }

        return false;
    }
}
