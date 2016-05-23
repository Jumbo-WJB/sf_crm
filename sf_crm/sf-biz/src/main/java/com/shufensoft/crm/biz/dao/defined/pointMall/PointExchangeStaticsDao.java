package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeStaticsDo;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/31  
 */
@Repository
public interface PointExchangeStaticsDao {

    /**
     * @param params   sellerId, userId
     * */
    public PointExchangeStaticsDo findPointExchangeStaticsByUserId(Map<String,Object> params);
}
