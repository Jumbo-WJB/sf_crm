package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserPortrait;
import com.shufensoft.crm.biz.domain.generation.user.UserPortraitExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPortraitMapper {
    int countByExample(UserPortraitExample example);

    int deleteByExample(UserPortraitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPortrait record);

    int insertSelective(UserPortrait record);

    List<UserPortrait> selectByExample(UserPortraitExample example);

    UserPortrait selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPortrait record, @Param("example") UserPortraitExample example);

    int updateByExample(@Param("record") UserPortrait record, @Param("example") UserPortraitExample example);

    int updateByPrimaryKeySelective(@Param("record") UserPortrait record);

    int updateByPrimaryKey(UserPortrait record);
}