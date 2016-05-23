package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeDetailDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *
 *
 * </p>
 *  @author: lin
 *  @date: 2015/7/5  
 */
@Repository
public interface PointExchangeDetailDao {

    /**
     * 查询积分兑换明细, point_exchange
     * */
    public List<PointExchangeDetailDo> findPointExchangeDetails(Map<String, Object> params);
    
    /**
     * 查询未完成的积分兑换红包记录, point_exchange, 带上pool_id
     * @param params sellerId, userId
     * */
    public List<PointExchangeDetailDo> findNotFinishPointExchangeHongbao(Map<String,Object> params);
}
