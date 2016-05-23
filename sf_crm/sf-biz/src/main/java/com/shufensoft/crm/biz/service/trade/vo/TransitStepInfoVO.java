package com.shufensoft.crm.biz.service.trade.vo;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                物流跟踪信息
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/22  
 */
@Data
public class TransitStepInfoVO {

    /**
     * 状态发生的时间
     */
    private Date statusTime;


    /**
     * 状态描述
     */
    private String statusDesc;
}
