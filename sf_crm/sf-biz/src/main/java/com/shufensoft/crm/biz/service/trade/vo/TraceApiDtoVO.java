package com.shufensoft.crm.biz.service.trade.vo;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 快递流转记录
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/23  
 */
@ToString
@Data
public class TraceApiDtoVO {

    /**
     * 操作标题
     */
    private String opeTitle;

    /**
     * 操作详情
     */
    private String opeRemark;

    /**
     * 操作人姓名
     */
    private String opeName;

    /**
     * 操作时间
     */
    private String opeTime;

}
