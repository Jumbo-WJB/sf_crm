package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserTagYZ;
import com.shufensoft.crm.biz.domain.generation.user.UserTagYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTagYZMapper {
    int countByExample(UserTagYZExample example);

    int deleteByExample(UserTagYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTagYZ record);

    int insertSelective(UserTagYZ record);

    List<UserTagYZ> selectByExample(UserTagYZExample example);

    UserTagYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTagYZ record, @Param("example") UserTagYZExample example);

    int updateByExample(@Param("record") UserTagYZ record, @Param("example") UserTagYZExample example);

    int updateByPrimaryKeySelective(@Param("record") UserTagYZ record);

    int updateByPrimaryKey(UserTagYZ record);
}