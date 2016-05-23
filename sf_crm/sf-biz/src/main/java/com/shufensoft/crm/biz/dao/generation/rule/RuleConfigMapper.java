package com.shufensoft.crm.biz.dao.generation.rule;

import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleConfigMapper {
    int countByExample(RuleConfigExample example);

    int deleteByExample(RuleConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleConfig record);

    int insertSelective(RuleConfig record);

    List<RuleConfig> selectByExample(RuleConfigExample example);

    RuleConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleConfig record, @Param("example") RuleConfigExample example);

    int updateByExample(@Param("record") RuleConfig record, @Param("example") RuleConfigExample example);

    int updateByPrimaryKeySelective(@Param("record") RuleConfig record);

    int updateByPrimaryKey(RuleConfig record);
}