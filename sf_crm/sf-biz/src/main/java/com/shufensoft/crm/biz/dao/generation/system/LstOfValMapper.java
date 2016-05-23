package com.shufensoft.crm.biz.dao.generation.system;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.domain.generation.system.LstOfValExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface LstOfValMapper {
    int countByExample(LstOfValExample example);

    int deleteByExample(LstOfValExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LstOfVal record);

    int insertSelective(LstOfVal record);

    List<LstOfVal> selectByExample(LstOfValExample example);

    LstOfVal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LstOfVal record, @Param("example") LstOfValExample example);

    int updateByExample(@Param("record") LstOfVal record, @Param("example") LstOfValExample example);

    int updateByPrimaryKeySelective(@Param("record") LstOfVal record);

    int updateByPrimaryKey(LstOfVal record);
}