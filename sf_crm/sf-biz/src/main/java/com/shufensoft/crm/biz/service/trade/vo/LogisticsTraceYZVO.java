package com.shufensoft.crm.biz.service.trade.vo;

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
public class LogisticsTraceYZVO {

    /**
     * 快递单号（具体一个物流公司的真实快递单号）
     */
    private String outSid;

    /**
     * 物流公司名称
     */
    private String companyName;

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
    private List<TransitStepInfoVO> traceList;
}
