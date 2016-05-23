package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 *     统计用户兑换红包, 商品消耗的积分
 * </p>
 *  @author: lin
 *  @date: 2015/7/31  
 */
@Data
@ToString
public class PointExchangeStaticsDo {

    private Long sellerId;

    private Long userId;

    /**
     * 成功兑换红包消耗的积分
     * */
    private Long hbPoint = 0L;

    /**
     * 成功兑换商品消耗的积分
     * */
    private Long goodsPoint = 0L;

}
