package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserBound;
import com.shufensoft.crm.biz.domain.generation.user.UserBoundExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBoundMapper {
    int countByExample(UserBoundExample example);

    int deleteByExample(UserBoundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBound record);

    int insertSelective(UserBound record);

    List<UserBound> selectByExample(UserBoundExample example);

    UserBound selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBound record, @Param("example") UserBoundExample example);

    int updateByExample(@Param("record") UserBound record, @Param("example") UserBoundExample example);

    int updateByPrimaryKeySelective(@Param("record") UserBound record);

    int updateByPrimaryKey(UserBound record);
}