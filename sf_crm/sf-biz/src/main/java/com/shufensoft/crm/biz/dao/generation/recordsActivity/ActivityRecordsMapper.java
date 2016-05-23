package com.shufensoft.crm.biz.dao.generation.recordsActivity;

import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecords;
import com.shufensoft.crm.biz.domain.generation.recordsActivity.ActivityRecordsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRecordsMapper {
    int countByExample(ActivityRecordsExample example);

    int deleteByExample(ActivityRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityRecords record);

    int insertSelective(ActivityRecords record);

    List<ActivityRecords> selectByExample(ActivityRecordsExample example);

    ActivityRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityRecords record, @Param("example") ActivityRecordsExample example);

    int updateByExample(@Param("record") ActivityRecords record, @Param("example") ActivityRecordsExample example);

    int updateByPrimaryKeySelective(@Param("record") ActivityRecords record);

    int updateByPrimaryKey(ActivityRecords record);
}