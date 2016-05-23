package com.shufensoft.crm.biz.dao.generation.crmShare;

import com.shufensoft.crm.biz.domain.generation.crmShare.CrmShare;
import com.shufensoft.crm.biz.domain.generation.crmShare.CrmShareExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrmShareMapper {
    int countByExample(CrmShareExample example);

    int deleteByExample(CrmShareExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CrmShare record);

    int insertSelective(CrmShare record);

    List<CrmShare> selectByExample(CrmShareExample example);

    CrmShare selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CrmShare record, @Param("example") CrmShareExample example);

    int updateByExample(@Param("record") CrmShare record, @Param("example") CrmShareExample example);

    int updateByPrimaryKeySelective(@Param("record") CrmShare record);

    int updateByPrimaryKey(CrmShare record);
}