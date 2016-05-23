package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.PraiseRecords;
import com.shufensoft.crm.biz.domain.generation.user.PraiseRecordsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PraiseRecordsMapper {
    int countByExample(PraiseRecordsExample example);

    int deleteByExample(PraiseRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PraiseRecords record);

    int insertSelective(PraiseRecords record);

    List<PraiseRecords> selectByExample(PraiseRecordsExample example);

    PraiseRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PraiseRecords record, @Param("example") PraiseRecordsExample example);

    int updateByExample(@Param("record") PraiseRecords record, @Param("example") PraiseRecordsExample example);

    int updateByPrimaryKeySelective(@Param("record") PraiseRecords record);

    int updateByPrimaryKey(PraiseRecords record);
}