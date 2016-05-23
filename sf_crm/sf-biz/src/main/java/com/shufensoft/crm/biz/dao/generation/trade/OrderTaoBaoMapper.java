package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBaoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTaoBaoMapper {
    int countByExample(OrderTaoBaoExample example);

    int deleteByExample(OrderTaoBaoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTaoBao record);

    int insertSelective(OrderTaoBao record);

    List<OrderTaoBao> selectByExample(OrderTaoBaoExample example);

    OrderTaoBao selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTaoBao record, @Param("example") OrderTaoBaoExample example);

    int updateByExample(@Param("record") OrderTaoBao record, @Param("example") OrderTaoBaoExample example);

    int updateByPrimaryKeySelective(@Param("record") OrderTaoBao record);

    int updateByPrimaryKey(OrderTaoBao record);
}