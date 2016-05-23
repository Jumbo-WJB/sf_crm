package com.shufensoft.crm.biz.dao.generation.present;

import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresentMapper {
    int countByExample(PresentExample example);

    int deleteByExample(PresentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Present record);

    int insertSelective(Present record);

    List<Present> selectByExample(PresentExample example);

    Present selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Present record, @Param("example") PresentExample example);

    int updateByExample(@Param("record") Present record, @Param("example") PresentExample example);

    int updateByPrimaryKeySelective(@Param("record") Present record);

    int updateByPrimaryKey(Present record);
}