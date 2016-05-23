package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserValidate;
import com.shufensoft.crm.biz.domain.generation.user.UserValidateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserValidateMapper {
    int countByExample(UserValidateExample example);

    int deleteByExample(UserValidateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserValidate record);

    int insertSelective(UserValidate record);

    List<UserValidate> selectByExample(UserValidateExample example);

    UserValidate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserValidate record, @Param("example") UserValidateExample example);

    int updateByExample(@Param("record") UserValidate record, @Param("example") UserValidateExample example);

    int updateByPrimaryKeySelective(@Param("record") UserValidate record);

    int updateByPrimaryKey(UserValidate record);
}