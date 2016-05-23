package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.JdpTbTrade;
import com.shufensoft.crm.biz.domain.generation.trade.JdpTbTradeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdpTbTradeMapper {
    int countByExample(JdpTbTradeExample example);

    int deleteByExample(JdpTbTradeExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(JdpTbTrade record);

    int insertSelective(JdpTbTrade record);

    List<JdpTbTrade> selectByExampleWithBLOBs(JdpTbTradeExample example);

    List<JdpTbTrade> selectByExample(JdpTbTradeExample example);

    JdpTbTrade selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") JdpTbTrade record, @Param("example") JdpTbTradeExample example);

    int updateByExampleWithBLOBs(@Param("record") JdpTbTrade record, @Param("example") JdpTbTradeExample example);

    int updateByExample(@Param("record") JdpTbTrade record, @Param("example") JdpTbTradeExample example);

    int updateByPrimaryKeySelective(JdpTbTrade record);

    int updateByPrimaryKeyWithBLOBs(JdpTbTrade record);

    int updateByPrimaryKey(JdpTbTrade record);
}