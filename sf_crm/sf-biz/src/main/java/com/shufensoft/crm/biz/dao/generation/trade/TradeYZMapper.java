package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeYZMapper {
    int countByExample(TradeYZExample example);

    int deleteByExample(TradeYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeYZ record);

    int insertSelective(TradeYZ record);

    List<TradeYZ> selectByExample(TradeYZExample example);

    TradeYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeYZ record, @Param("example") TradeYZExample example);

    int updateByExample(@Param("record") TradeYZ record, @Param("example") TradeYZExample example);

    int updateByPrimaryKeySelective(@Param("record") TradeYZ record);

    int updateByPrimaryKey(TradeYZ record);
}