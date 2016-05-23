package com.shufensoft.crm.biz.domain.defined.point;

import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/20  
 */
@Data
public class PointExchangeDO extends PointExchange{

    private String day;

    private Long totalExchangePoint;

    private Long totalExchangeCount;

}
