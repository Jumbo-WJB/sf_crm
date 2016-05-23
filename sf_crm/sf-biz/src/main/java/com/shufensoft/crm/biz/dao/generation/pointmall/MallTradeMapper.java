package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallTrade;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallTradeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallTradeMapper {
    int countByExample(MallTradeExample example);

    int deleteByExample(MallTradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallTrade record);

    int insertSelective(MallTrade record);

    List<MallTrade> selectByExample(MallTradeExample example);

    MallTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallTrade record, @Param("example") MallTradeExample example);

    int updateByExample(@Param("record") MallTrade record, @Param("example") MallTradeExample example);

    int updateByPrimaryKeySelective(@Param("record") MallTrade record);

    int updateByPrimaryKey(MallTrade record);
}