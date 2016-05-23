package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.MallOrderDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/29  
 */
@Repository
public interface MallOrderDao {

    /**
     * 查询商户所有订单,
     *
     * @param paramMap 包含sellerId 和 status
     * */
    public List<MallOrderDo> findMallOrders(Map<String,Object> paramMap);



}
