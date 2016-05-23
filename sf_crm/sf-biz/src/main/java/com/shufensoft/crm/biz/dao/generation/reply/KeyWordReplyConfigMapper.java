package com.shufensoft.crm.biz.dao.generation.reply;

import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfig;
import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyWordReplyConfigMapper {
    int countByExample(KeyWordReplyConfigExample example);

    int deleteByExample(KeyWordReplyConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(KeyWordReplyConfig record);

    int insertSelective(KeyWordReplyConfig record);

    List<KeyWordReplyConfig> selectByExample(KeyWordReplyConfigExample example);

    KeyWordReplyConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") KeyWordReplyConfig record, @Param("example") KeyWordReplyConfigExample example);

    int updateByExample(@Param("record") KeyWordReplyConfig record, @Param("example") KeyWordReplyConfigExample example);

    int updateByPrimaryKeySelective(@Param("record") KeyWordReplyConfig record);

    int updateByPrimaryKey(KeyWordReplyConfig record);
}