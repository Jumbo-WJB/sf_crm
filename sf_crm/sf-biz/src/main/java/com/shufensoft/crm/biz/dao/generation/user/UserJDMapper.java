package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserJD;
import com.shufensoft.crm.biz.domain.generation.user.UserJDExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJDMapper {
    int countByExample(UserJDExample example);

    int deleteByExample(UserJDExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserJD record);

    int insertSelective(UserJD record);

    List<UserJD> selectByExample(UserJDExample example);

    UserJD selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserJD record, @Param("example") UserJDExample example);

    int updateByExample(@Param("record") UserJD record, @Param("example") UserJDExample example);

    int updateByPrimaryKeySelective(@Param("record") UserJD record);

    int updateByPrimaryKey(UserJD record);
}