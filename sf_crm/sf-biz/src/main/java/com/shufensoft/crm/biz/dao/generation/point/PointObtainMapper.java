package com.shufensoft.crm.biz.dao.generation.point;

import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtainExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointObtainMapper {
    int countByExample(PointObtainExample example);

    int deleteByExample(PointObtainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointObtain record);

    int insertSelective(PointObtain record);

    List<PointObtain> selectByExample(PointObtainExample example);

    PointObtain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PointObtain record, @Param("example") PointObtainExample example);

    int updateByExample(@Param("record") PointObtain record, @Param("example") PointObtainExample example);

    int updateByPrimaryKeySelective(@Param("record") PointObtain record);

    int updateByPrimaryKey(PointObtain record);
}