package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeRealTimeInfoDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/4  
 */
@Repository
public interface PointExchangeRealTimeInfoDao {

    public List<PointExchangeRealTimeInfoDo> findPointExchangeRealTimeDoBySellerId(Long sellerId);

}