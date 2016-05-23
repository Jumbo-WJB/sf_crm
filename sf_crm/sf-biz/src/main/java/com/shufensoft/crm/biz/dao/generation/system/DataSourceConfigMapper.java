package com.shufensoft.crm.biz.dao.generation.system;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfig;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface DataSourceConfigMapper {
    int countByExample(DataSourceConfigExample example);

    int deleteByExample(DataSourceConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataSourceConfig record);

    int insertSelective(DataSourceConfig record);

    List<DataSourceConfig> selectByExample(DataSourceConfigExample example);

    DataSourceConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DataSourceConfig record, @Param("example") DataSourceConfigExample example);

    int updateByExample(@Param("record") DataSourceConfig record, @Param("example") DataSourceConfigExample example);

    int updateByPrimaryKeySelective(@Param("record") DataSourceConfig record);

    int updateByPrimaryKey(DataSourceConfig record);
}