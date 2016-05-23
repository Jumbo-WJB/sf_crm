package com.shufensoft.crm.common.api.client;

import com.shufensoft.crm.common.api.exception.PolySpireApiException;
import com.shufensoft.crm.common.api.request.PolySpireRequest;
import com.shufensoft.crm.common.api.response.ApiResponse;
import com.shufensoft.crm.common.api.response.PolySpireResponse;
import com.shufensoft.crm.common.utils.BeanCopierUtils;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 聚石塔客户端
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */

public class PolySpireApiClient extends BaseApiClient {


    /**
     * @param polySpireRequest
     * @return 接口get请求
     * @throws Exception
     */
    public PolySpireResponse doGet(PolySpireRequest polySpireRequest) throws PolySpireApiException {

        try {

            ApiResponse apiResponse = super.doGet(polySpireRequest);

            if (apiResponse != null) {
                return (PolySpireResponse) BeanCopierUtils.copyProperties(apiResponse, PolySpireResponse.class);
            }

        } catch (Exception e) {

            throw new PolySpireApiException(e);

        }

        return null;

    }

}
