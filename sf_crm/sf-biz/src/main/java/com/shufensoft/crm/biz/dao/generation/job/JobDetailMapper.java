package com.shufensoft.crm.biz.dao.generation.job;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.job.JobDetail;
import com.shufensoft.crm.biz.domain.generation.job.JobDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface JobDetailMapper {
    int countByExample(JobDetailExample example);

    int deleteByExample(JobDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JobDetail record);

    int insertSelective(JobDetail record);

    List<JobDetail> selectByExample(JobDetailExample example);

    JobDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JobDetail record, @Param("example") JobDetailExample example);

    int updateByExample(@Param("record") JobDetail record, @Param("example") JobDetailExample example);

    int updateByPrimaryKeySelective(@Param("record") JobDetail record);

    int updateByPrimaryKey(JobDetail record);
}