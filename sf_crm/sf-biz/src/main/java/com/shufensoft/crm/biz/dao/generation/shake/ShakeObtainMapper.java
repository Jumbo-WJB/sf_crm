package com.shufensoft.crm.biz.dao.generation.shake;

import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtain;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtainExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShakeObtainMapper {
    int countByExample(ShakeObtainExample example);

    int deleteByExample(ShakeObtainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShakeObtain record);

    int insertSelective(ShakeObtain record);

    List<ShakeObtain> selectByExample(ShakeObtainExample example);

    ShakeObtain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShakeObtain record, @Param("example") ShakeObtainExample example);

    int updateByExample(@Param("record") ShakeObtain record, @Param("example") ShakeObtainExample example);

    int updateByPrimaryKeySelective(@Param("record") ShakeObtain record);

    int updateByPrimaryKey(ShakeObtain record);
}