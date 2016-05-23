package com.shufensoft.crm.biz.adapter.jsonObj;

import lombok.Data;

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
public class TransitStepInfoJsonObj {

    /**
     * 状态发生的时间
     */
    private String status_time;

    /**
     * 字符串形式的时间
     */
    private String time;

    /**
     * 状态描述
     */
    private String status_desc;
}
