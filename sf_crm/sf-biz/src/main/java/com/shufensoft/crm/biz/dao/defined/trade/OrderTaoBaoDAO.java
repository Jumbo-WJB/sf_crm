package com.shufensoft.crm.biz.dao.defined.trade;

import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTaoBaoDAO {
    /**
     * 通过评价相关信息获取淘宝订单数据
     * @param orderTaoBaoDO
     * @return
     */
    List<OrderTaoBaoDO> selectOrderTaoBaoWithComment(OrderTaoBaoDO orderTaoBaoDO);

    /**
     * 通过评价用户相关信息获取淘宝订单数据
     * @param orderTaoBaoDO
     * @return
     */
    List<OrderTaoBaoDO> selectOrderTaoBaoWithCommentAndUser(OrderTaoBaoDO orderTaoBaoDO);


    //根据user_id_tb 找到订单号(oid)
    List<OrderTaoBaoDO> selectOrderTaoBaoWithUserIdTaoBao(@Param("userIdTaoBao")Long userIdTaoBao);
}