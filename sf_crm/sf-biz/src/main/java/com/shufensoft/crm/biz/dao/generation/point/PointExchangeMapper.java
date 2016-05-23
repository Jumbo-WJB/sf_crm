package com.shufensoft.crm.biz.dao.generation.point;

import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.point.PointExchangeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointExchangeMapper {
    int countByExample(PointExchangeExample example);

    int deleteByExample(PointExchangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointExchange record);

    int insertSelective(PointExchange record);

    List<PointExchange> selectByExample(PointExchangeExample example);

    PointExchange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PointExchange record, @Param("example") PointExchangeExample example);

    int updateByExample(@Param("record") PointExchange record, @Param("example") PointExchangeExample example);

    int updateByPrimaryKeySelective(@Param("record") PointExchange record);

    int updateByPrimaryKey(PointExchange record);
}