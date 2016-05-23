package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInteractionDetailMapper {
    int countByExample(UserInteractionDetailExample example);

    int deleteByExample(UserInteractionDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInteractionDetail record);

    int insertSelective(UserInteractionDetail record);

    List<UserInteractionDetail> selectByExample(UserInteractionDetailExample example);

    UserInteractionDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInteractionDetail record, @Param("example") UserInteractionDetailExample example);

    int updateByExample(@Param("record") UserInteractionDetail record, @Param("example") UserInteractionDetailExample example);

    int updateByPrimaryKeySelective(@Param("record") UserInteractionDetail record);

    int updateByPrimaryKey(UserInteractionDetail record);
}