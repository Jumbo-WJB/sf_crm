package com.shufensoft.crm.common.api.client;

import com.shufensoft.crm.common.api.exception.CrmApiException;
import com.shufensoft.crm.common.api.request.CrmRequest;
import com.shufensoft.crm.common.api.response.ApiResponse;
import com.shufensoft.crm.common.api.response.CrmResponse;
import com.shufensoft.crm.common.utils.BeanCopierUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                crm api 客户端（目前聚石塔需要调crm,保存评价信息）
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
public class CrmApiClient extends BaseApiClient{


    /**
     * @param crmRequest
     * @return 接口get请求
     * @throws CrmApiException
     */
    public CrmResponse doGet(CrmRequest crmRequest) throws CrmApiException {

        try {

            ApiResponse apiResponse = super.doGet(crmRequest);

            if (apiResponse != null) {
                return (CrmResponse) BeanCopierUtils.copyProperties(apiResponse, CrmResponse.class);
            }

        } catch (Exception e) {

            throw new CrmApiException(e);

        }

        return null;

    }

    /**
     * @param crmRequest
     * @return 接口post请求
     * @throws CrmApiException
     */
    public CrmResponse doPost(CrmRequest crmRequest) throws CrmApiException {

        try {

            ApiResponse apiResponse = super.doPost(crmRequest);

            if (apiResponse != null) {
                return (CrmResponse) BeanCopierUtils.copyProperties(apiResponse, CrmResponse.class);
            }

        } catch (Exception e) {

            throw new CrmApiException(e);

        }

        return null;

    }

    /**
     * @param crmRequest
     * @return 接口json post请求
     * @throws CrmApiException
     */
    public CrmResponse doJsonPost(CrmRequest crmRequest) throws CrmApiException {

        try {

            ApiResponse apiResponse = super.doJsonPost(crmRequest);

            if (apiResponse != null) {
                return (CrmResponse) BeanCopierUtils.copyProperties(apiResponse, CrmResponse.class);
            }

        } catch (Exception e) {

            throw new CrmApiException(e);

        }

        return null;

    }
}
