package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallPropertyValue;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallPropertyValueExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallPropertyValueMapper {
    int countByExample(MallPropertyValueExample example);

    int deleteByExample(MallPropertyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallPropertyValue record);

    int insertSelective(MallPropertyValue record);

    List<MallPropertyValue> selectByExample(MallPropertyValueExample example);

    MallPropertyValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallPropertyValue record, @Param("example") MallPropertyValueExample example);

    int updateByExample(@Param("record") MallPropertyValue record, @Param("example") MallPropertyValueExample example);

    int updateByPrimaryKeySelective(@Param("record") MallPropertyValue record);

    int updateByPrimaryKey(MallPropertyValue record);
}