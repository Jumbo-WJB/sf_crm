package com.shufensoft.crm.common.email.request;

import lombok.Data;

import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 请求基础类
 *  @author litu  litu@shufensoft.com
 *  @date 2015/4/16 18:44  
 */
@Data
public class BaseRequest {

    /**
     * api接口
     */
    private String api;



    /**
     * 页码
     */
    private Integer pageNo=1;

    /**
     * 每页大小
     */
    private Integer pageSize=40;

    /**
     * 其他参数
     */
    private Map<String, String> parames;

}
