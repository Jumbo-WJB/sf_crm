package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserYZ;
import com.shufensoft.crm.biz.domain.generation.user.UserYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserYZMapper {
    int countByExample(UserYZExample example);

    int deleteByExample(UserYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserYZ record);

    int insertSelective(UserYZ record);

    List<UserYZ> selectByExample(UserYZExample example);

    UserYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserYZ record, @Param("example") UserYZExample example);

    int updateByExample(@Param("record") UserYZ record, @Param("example") UserYZExample example);

    int updateByPrimaryKeySelective(@Param("record") UserYZ record);

    int updateByPrimaryKey(UserYZ record);
}