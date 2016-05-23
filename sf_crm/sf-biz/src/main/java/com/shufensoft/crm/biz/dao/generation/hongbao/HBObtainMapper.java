package com.shufensoft.crm.biz.dao.generation.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HBObtainMapper {
    int countByExample(HBObtainExample example);

    int deleteByExample(HBObtainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HBObtain record);

    int insertSelective(HBObtain record);

    List<HBObtain> selectByExample(HBObtainExample example);

    HBObtain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HBObtain record, @Param("example") HBObtainExample example);

    int updateByExample(@Param("record") HBObtain record, @Param("example") HBObtainExample example);

    int updateByPrimaryKeySelective(@Param("record") HBObtain record);

    int updateByPrimaryKey(HBObtain record);
}