package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserWxMessage;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWxMessageMapper {
    int countByExample(UserWxMessageExample example);

    int deleteByExample(UserWxMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserWxMessage record);

    int insertSelective(UserWxMessage record);

    List<UserWxMessage> selectByExample(UserWxMessageExample example);

    UserWxMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserWxMessage record, @Param("example") UserWxMessageExample example);

    int updateByExample(@Param("record") UserWxMessage record, @Param("example") UserWxMessageExample example);

    int updateByPrimaryKeySelective(@Param("record") UserWxMessage record);

    int updateByPrimaryKey(UserWxMessage record);
}