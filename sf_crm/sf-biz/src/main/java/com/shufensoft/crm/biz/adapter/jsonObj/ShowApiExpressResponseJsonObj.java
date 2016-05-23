package com.shufensoft.crm.biz.adapter.jsonObj;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/30  
 */
@Data
@ToString
public class ShowApiExpressResponseJsonObj {

    /**
     * 易源返回标志，0为成功，其他为失败
     */
    private String showapi_res_code;

    /**
     * 错误信息的展示
     */
    private String showapi_res_error;

    /**
     * 消息体的JSON封装，所有应用级的返回参数将嵌入此对象 。
     */
    private ShowapiResBodyJsonObj showapi_res_body;

}
