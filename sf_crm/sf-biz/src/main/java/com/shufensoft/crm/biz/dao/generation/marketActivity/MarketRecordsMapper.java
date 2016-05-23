package com.shufensoft.crm.biz.dao.generation.marketActivity;

import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecordsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRecordsMapper {
    int countByExample(MarketRecordsExample example);

    int deleteByExample(MarketRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketRecords record);

    int insertSelective(MarketRecords record);

    List<MarketRecords> selectByExample(MarketRecordsExample example);

    MarketRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketRecords record, @Param("example") MarketRecordsExample example);

    int updateByExample(@Param("record") MarketRecords record, @Param("example") MarketRecordsExample example);

    int updateByPrimaryKeySelective(@Param("record") MarketRecords record);

    int updateByPrimaryKey(MarketRecords record);
}