package com.shufensoft.crm.biz.dao.generation.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HBPoolMapper {
    int countByExample(HBPoolExample example);

    int deleteByExample(HBPoolExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HBPool record);

    int insertSelective(HBPool record);

    List<HBPool> selectByExample(HBPoolExample example);

    HBPool selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HBPool record, @Param("example") HBPoolExample example);

    int updateByExample(@Param("record") HBPool record, @Param("example") HBPoolExample example);

    int updateByPrimaryKeySelective(@Param("record") HBPool record);

    int updateByPrimaryKey(HBPool record);
}