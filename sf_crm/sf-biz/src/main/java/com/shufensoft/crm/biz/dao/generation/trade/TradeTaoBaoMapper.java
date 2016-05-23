package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBaoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeTaoBaoMapper {
    int countByExample(TradeTaoBaoExample example);

    int deleteByExample(TradeTaoBaoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeTaoBao record);

    int insertSelective(TradeTaoBao record);

    List<TradeTaoBao> selectByExample(TradeTaoBaoExample example);

    TradeTaoBao selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTaoBao record, @Param("example") TradeTaoBaoExample example);

    int updateByExample(@Param("record") TradeTaoBao record, @Param("example") TradeTaoBaoExample example);

    int updateByPrimaryKeySelective(@Param("record") TradeTaoBao record);

    int updateByPrimaryKey(TradeTaoBao record);
}