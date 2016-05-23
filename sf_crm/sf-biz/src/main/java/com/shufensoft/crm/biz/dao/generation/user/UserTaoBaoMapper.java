package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserTaoBao;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBaoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaoBaoMapper {
    int countByExample(UserTaoBaoExample example);

    int deleteByExample(UserTaoBaoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTaoBao record);

    int insertSelective(UserTaoBao record);

    List<UserTaoBao> selectByExample(UserTaoBaoExample example);

    UserTaoBao selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTaoBao record, @Param("example") UserTaoBaoExample example);

    int updateByExample(@Param("record") UserTaoBao record, @Param("example") UserTaoBaoExample example);

    int updateByPrimaryKeySelective(@Param("record") UserTaoBao record);

    int updateByPrimaryKey(UserTaoBao record);
}