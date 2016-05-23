package com.shufensoft.crm.biz.adapter;

import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.common.api.client.PolySpireApiClient;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.enums.PolySpireApiEnums;
import com.shufensoft.crm.common.api.exception.PolySpireApiException;
import com.shufensoft.crm.common.api.request.PolySpireRequest;
import com.shufensoft.crm.common.api.response.PolySpireResponse;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                聚石塔adpter
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public class PolySpireAdapter {

    private static final Logger logger = Logger.getLogger(PolySpireAdapter.class);

    private static PolySpireApiClient polySpireApiClient =  new PolySpireApiClient();

    private static SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public  List<TradeTaoBao> syncTradeByDate(String  polySpireUrl , Date startDate, Date endDate, int start, int pageSize){

        PolySpireRequest polySpireRequest = new PolySpireRequest();
        polySpireRequest.setApi(PolySpireApiEnums.TRADES_FULLINFO_GET.getCode());

        polySpireRequest.setUrl(polySpireUrl);

        if(pageSize<=0){
            polySpireRequest.setPageSize(pageSize);
        }

        if(start<=0){
            polySpireRequest.setPageNo(start);
        }

        Map<String,String> params = new HashMap<String,String>();
        params.put("startDate",simpleDateFormat.format(startDate));
        params.put("endDate",simpleDateFormat.format(endDate));
        params.put("start",String.valueOf(start));
        params.put("pageSize",String.valueOf(pageSize));
        polySpireRequest.setParames(params);
        PolySpireResponse polySpireResponse = null;

        try {
            polySpireResponse = polySpireApiClient.doGet(polySpireRequest);
        }catch (Exception e){
            logger.error("execute "+polySpireRequest.getApi()+" error",e);
            throw new PolySpireApiException(polySpireRequest.getApi(),e.getMessage(),e);
        }

        if(polySpireResponse!=null){
            if(ApiErrorEnums.SUCCESS.getCode().equals(polySpireResponse.getErrorCode())){
                String resultJson = polySpireResponse.getResultJson();
                return  (List<TradeTaoBao>)JSONUtils.parseToList(resultJson,TradeTaoBao.class);
            }

            logger.error("execute "+polySpireRequest.getApi()+" error,errorMsg:"
                    +(polySpireResponse.getErrorMessage()==null?"":polySpireResponse.getErrorMessage()));

            throw new PolySpireApiException(polySpireRequest.getApi(),polySpireResponse.getErrorCode(),
                    polySpireResponse.getErrorMessage());
        }

        return null;

    }

}
