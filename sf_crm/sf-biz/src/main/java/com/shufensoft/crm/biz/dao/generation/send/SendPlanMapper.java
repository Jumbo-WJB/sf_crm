package com.shufensoft.crm.biz.dao.generation.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.send.SendPlan;
import com.shufensoft.crm.biz.domain.generation.send.SendPlanExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SendPlanMapper {
    int countByExample(SendPlanExample example);

    int deleteByExample(SendPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SendPlan record);

    int insertSelective(SendPlan record);

    List<SendPlan> selectByExample(SendPlanExample example);

    SendPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SendPlan record, @Param("example") SendPlanExample example);

    int updateByExample(@Param("record") SendPlan record, @Param("example") SendPlanExample example);

    int updateByPrimaryKeySelective(@Param("record") SendPlan record);

    int updateByPrimaryKey(SendPlan record);
}