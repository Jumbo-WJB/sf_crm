package com.shufensoft.crm.biz.service.pointmall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/19  
 */
@Data
public class PointStatisticsVO {

    /**
     * 累计赠送积分
     */
    private Long totalPresentPoint;

    /**
     * 已兑换积分
     */
    private Long exchangedPoint;

    /**
     * 累计兑换红包金额
     */
    private BigDecimal totalExchangeHBAmount;

    /**
     * 未兑换积分
     */
    private Long nonExchangePoint;

    /**
     * 累计领取红包数量
     */
    private Long totalReceiveHBNum;

    /**
     * 累计兑换红包金额
     */
    private BigDecimal totalReceiveHBAmount;

    /**
     * 最大领取红包金额
     */
    private BigDecimal maxReceiveHBAmount;

    /**
     * 累计红包领取粉丝人数
     */
    private Long receiveHBFansNum;

}
