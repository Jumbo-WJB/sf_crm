package com.shufensoft.crm.biz.dao.defined.order;

import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: chenyong  lisen@suniusoft.com
 *  @date: 2015/7/5  
 */
@Repository
public interface OrderJDDAO {
    /**
     * 通过评价相关信息获取京东订单数据
     * @param orderJdDO
     * @return
     */
    List<OrderJDDO> selectOrderJDWithComment(OrderJDDO orderJdDO);

    /**
     * 通过评价用户相关信息获取京东订单数据
     * @param orderJdDO
     * @return
     */
    List<OrderJDDO> selectOrderJDWithCommentAndUser(OrderJDDO orderJdDO);

}
