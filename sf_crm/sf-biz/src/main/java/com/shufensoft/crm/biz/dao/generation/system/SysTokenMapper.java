package com.shufensoft.crm.biz.dao.generation.system;

import com.shufensoft.crm.biz.domain.generation.system.SysToken;
import com.shufensoft.crm.biz.domain.generation.system.SysTokenExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysTokenMapper {
    int countByExample(SysTokenExample example);

    int deleteByExample(SysTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysToken record);

    int insertSelective(SysToken record);

    List<SysToken> selectByExample(SysTokenExample example);

    SysToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysToken record, @Param("example") SysTokenExample example);

    int updateByExample(@Param("record") SysToken record, @Param("example") SysTokenExample example);

    int updateByPrimaryKeySelective(@Param("record") SysToken record);

    int updateByPrimaryKey(SysToken record);
}