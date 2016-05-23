package com.shufensoft.crm.biz.dao.generation.birthday;

import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBirthdayConfigMapper {
    int countByExample(UserBirthdayConfigExample example);

    int deleteByExample(UserBirthdayConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBirthdayConfig record);

    int insertSelective(UserBirthdayConfig record);

    List<UserBirthdayConfig> selectByExample(UserBirthdayConfigExample example);

    UserBirthdayConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBirthdayConfig record, @Param("example") UserBirthdayConfigExample example);

    int updateByExample(@Param("record") UserBirthdayConfig record, @Param("example") UserBirthdayConfigExample example);

    int updateByPrimaryKeySelective(@Param("record") UserBirthdayConfig record);

    int updateByPrimaryKey(UserBirthdayConfig record);
}