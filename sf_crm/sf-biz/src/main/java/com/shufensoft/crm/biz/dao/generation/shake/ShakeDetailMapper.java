package com.shufensoft.crm.biz.dao.generation.shake;

import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetail;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShakeDetailMapper {
    int countByExample(ShakeDetailExample example);

    int deleteByExample(ShakeDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShakeDetail record);

    int insertSelective(ShakeDetail record);

    List<ShakeDetail> selectByExample(ShakeDetailExample example);

    ShakeDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShakeDetail record, @Param("example") ShakeDetailExample example);

    int updateByExample(@Param("record") ShakeDetail record, @Param("example") ShakeDetailExample example);

    int updateByPrimaryKeySelective(@Param("record") ShakeDetail record);

    int updateByPrimaryKey(ShakeDetail record);
}