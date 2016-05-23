package com.shufensoft.crm.biz.service.express.vo;

import lombok.Data;

import java.io.Serializable;

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
public class TransitStepVO implements Serializable{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -8098452976629871724L;

    /**
     * 状态发生的时间
     */
    private String statusTime;


    /**
     * 状态描述
     */
    private String statusDesc;
}
