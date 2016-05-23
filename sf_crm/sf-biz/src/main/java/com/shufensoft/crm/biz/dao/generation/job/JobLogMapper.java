package com.shufensoft.crm.biz.dao.generation.job;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.job.JobLog;
import com.shufensoft.crm.biz.domain.generation.job.JobLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface JobLogMapper {
    int countByExample(JobLogExample example);

    int deleteByExample(JobLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JobLog record);

    int insertSelective(JobLog record);

    List<JobLog> selectByExample(JobLogExample example);

    JobLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByExample(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByPrimaryKeySelective(@Param("record") JobLog record);

    int updateByPrimaryKey(JobLog record);
}