package com.shufensoft.crm.biz.dao.generation.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.send.SendDetail;
import com.shufensoft.crm.biz.domain.generation.send.SendDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SendDetailMapper {
    int countByExample(SendDetailExample example);

    int deleteByExample(SendDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SendDetail record);

    int insertSelective(SendDetail record);

    List<SendDetail> selectByExample(SendDetailExample example);

    SendDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SendDetail record, @Param("example") SendDetailExample example);

    int updateByExample(@Param("record") SendDetail record, @Param("example") SendDetailExample example);

    int updateByPrimaryKeySelective(@Param("record") SendDetail record);

    int updateByPrimaryKey(SendDetail record);
}