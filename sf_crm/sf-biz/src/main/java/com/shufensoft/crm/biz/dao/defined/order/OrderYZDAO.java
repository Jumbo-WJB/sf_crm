package com.shufensoft.crm.biz.dao.defined.order;

import com.shufensoft.crm.biz.domain.defined.order.OrderYZDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/5  
 */
@Repository
public interface OrderYZDAO {
    public List<OrderYZDO> findTidsByUserIdYz(Long userIdYz);
}
