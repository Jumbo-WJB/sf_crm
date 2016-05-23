package com.shufensoft.crm.biz.service.trade.jsonObj;

import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/22  
 */
@Data
public class LogisticsTraceYZJsonObj {

    /**
     * 快递单号（具体一个物流公司的真实快递单号）
     */
    private String out_sid;

    /**
     * 物流公司名称
     */
    private String company_name;

    /**
     * 交易编号
     */
    private String tid;

    /**
     * 订单的物流状态：
     */
    private String status;

    /**
     * 流转信息列表，按时间倒序排序
     */
    private List<TransitStepInfoJsonObj> trace_list;
}
