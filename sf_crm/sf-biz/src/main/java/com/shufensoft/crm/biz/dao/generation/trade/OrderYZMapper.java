package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.OrderYZ;
import com.shufensoft.crm.biz.domain.generation.trade.OrderYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderYZMapper {
    int countByExample(OrderYZExample example);

    int deleteByExample(OrderYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderYZ record);

    int insertSelective(OrderYZ record);

    List<OrderYZ> selectByExample(OrderYZExample example);

    OrderYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderYZ record, @Param("example") OrderYZExample example);

    int updateByExample(@Param("record") OrderYZ record, @Param("example") OrderYZExample example);

    int updateByPrimaryKeySelective(@Param("record") OrderYZ record);

    int updateByPrimaryKey(OrderYZ record);
}