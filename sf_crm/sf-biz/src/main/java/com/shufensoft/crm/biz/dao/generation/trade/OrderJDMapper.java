package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJDExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderJDMapper {
    int countByExample(OrderJDExample example);

    int deleteByExample(OrderJDExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderJD record);

    int insertSelective(OrderJD record);

    List<OrderJD> selectByExample(OrderJDExample example);

    OrderJD selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderJD record, @Param("example") OrderJDExample example);

    int updateByExample(@Param("record") OrderJD record, @Param("example") OrderJDExample example);

    int updateByPrimaryKeySelective(@Param("record") OrderJD record);

    int updateByPrimaryKey(OrderJD record);
}