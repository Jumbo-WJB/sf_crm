package com.shufensoft.crm.biz.adapter;

import com.shufensoft.crm.biz.adapter.jsonObj.ShowApiDataJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.ShowApiExpressResponseJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.ShowapiResBodyJsonObj;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.TransitStepVO;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.api.express.ShowApiRequest;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.PropertyReader;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                易源
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/30  
 */
public class ShowApiAdapter {

    private static final String URL = PropertyReader.getValue("show.api.url");
    private static final String APPID = PropertyReader.getValue("show.api.appId");
    private static final String SECRET = PropertyReader.getValue("show.api.secret");

    /**
     * 易源快递查询
     * @param invoiceNo
     * @param companyCode
     * @return
     */
    public ExpressDetailVO expressQuery(String invoiceNo,String companyCode) {

        ShowApiRequest showApiClient = new ShowApiRequest(URL, APPID, SECRET);

        String jsonResult = showApiClient.addTextPara("nu", invoiceNo)
                .addTextPara("com", companyCode).post();

        ShowApiExpressResponseJsonObj showApiExpressResponseJsonObj = (ShowApiExpressResponseJsonObj)JSONUtils.
                parseToObject(jsonResult, ShowApiExpressResponseJsonObj.class);

        if(!ApiErrorEnums.SUCCESS.getCode().equals(showApiExpressResponseJsonObj.getShowapi_res_code())){

            String errorMsg = showApiExpressResponseJsonObj.getShowapi_res_error()==null?"":showApiExpressResponseJsonObj
                    .getShowapi_res_error();
            throw  new RuntimeException("ShowApiAdapter.expressQuery error;errorMsg:"+errorMsg);
        }

        return ShowApiDataToExpressDetail(showApiExpressResponseJsonObj);

    }

    /**
     * 外部对象转化成内部对象
     * @param showApiExpressResponseJsonObj
     * @return
     */
    private ExpressDetailVO ShowApiDataToExpressDetail(ShowApiExpressResponseJsonObj showApiExpressResponseJsonObj){

        ShowapiResBodyJsonObj showapiResBodyJsonObj = showApiExpressResponseJsonObj.getShowapi_res_body();

        if(showapiResBodyJsonObj == null){
            return null;
        }

        ExpressDetailVO expressDetailVO = new ExpressDetailVO();
        expressDetailVO.setExpressCompany(showapiResBodyJsonObj.getExpSpellName());
        expressDetailVO.setInvoiceNo(showapiResBodyJsonObj.getMailNo());
        expressDetailVO.setStatus(showapiResBodyJsonObj.getStatus());

        if(showapiResBodyJsonObj.getData() == null){
            return expressDetailVO;
        }

        List<TransitStepVO> transitStepVOList = new ArrayList<TransitStepVO>();
        for(ShowApiDataJsonObj showApiDataJsonObj :showapiResBodyJsonObj.getData()){
            TransitStepVO transitStepVO = new TransitStepVO();
            transitStepVO.setStatusTime(DateUtil.getDateToString(showApiDataJsonObj.getTime()));
            transitStepVO.setStatusDesc(showApiDataJsonObj.getContext());
            transitStepVOList.add(transitStepVO);

        }
        expressDetailVO.setTransitStepVOs(transitStepVOList);

        return expressDetailVO;
    }

}
