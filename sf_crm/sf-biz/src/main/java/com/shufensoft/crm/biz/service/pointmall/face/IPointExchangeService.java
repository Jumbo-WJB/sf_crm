package com.shufensoft.crm.biz.service.pointmall.face;

import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeStaticsDo;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/29  
 */
public interface IPointExchangeService {

    /**
     *  @param userId
     *  @param exchangeId
     * */
    public int updateStatus(Long userId, Long exchangeId,String status,Long sellerId);

    /**
     *  统计用户积分兑换商品, 红包消耗的积分数
     * */
    public PointExchangeStaticsDo findPointExchangeStaticsDoByUserId(Long sellerId,Long userId);


}
