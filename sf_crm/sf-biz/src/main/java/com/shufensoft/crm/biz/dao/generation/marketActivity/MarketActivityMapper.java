package com.shufensoft.crm.biz.dao.generation.marketActivity;

import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketActivityMapper {
    int countByExample(MarketActivityExample example);

    int deleteByExample(MarketActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketActivity record);

    int insertSelective(MarketActivity record);

    List<MarketActivity> selectByExample(MarketActivityExample example);

    MarketActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketActivity record, @Param("example") MarketActivityExample example);

    int updateByExample(@Param("record") MarketActivity record, @Param("example") MarketActivityExample example);

    int updateByPrimaryKeySelective(@Param("record") MarketActivity record);

    int updateByPrimaryKey(MarketActivity record);
}