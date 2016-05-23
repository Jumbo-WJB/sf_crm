package com.shufensoft.crm.biz.dao.defined.order;

import com.shufensoft.crm.biz.domain.defined.express.OrdersInfoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/7  
 */
@Repository
public interface OrderDAO {

    /**
     * 根据userId分组获得用户使用快递公司的数量
     * @param userIdTb
     * @return List 快递公司集合
     */
    List selectLogisticesGroup(@Param("userIdTb")Long userIdTb);

    /**
     * 通过userId来查询所有订单信息
     * @param userId
     * @return List 订单集合
     */
    List<OrdersInfoDO> selectOrdersByUserId(@Param("sellerId")Long sellerId, @Param("userId") Long userId);

    /**
     * 获取淘宝的订单数量
     * @param userId
     * @return Long 淘宝的订单数量
     */
    Long selectTbOrderNum(@Param("sellerId")Long sellerId, @Param("userId")Long userId);


    /**
     * //获取京东的订单数量
     * @param userId
     * @return Long  京东订单数量
     */
    Long selectJdOrderNum(@Param("sellerId")Long sellerId, @Param("userId")Long userId);

    /**
     * 获取正在发货的快递数量
     * @param userId
     * @return Long 有赞订单数量
     */
    Long selectYzOrderNum(@Param("sellerId")Long sellerId, @Param("userId")Long userId);

    /**
     *
     * @param userId
     * @return Long 在路上的订单
     */
    Long onTheRoadOrderNum(@Param("userId") Long userId);

    


}
