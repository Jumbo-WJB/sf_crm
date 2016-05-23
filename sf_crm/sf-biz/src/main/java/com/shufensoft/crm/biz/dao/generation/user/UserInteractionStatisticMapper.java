package com.shufensoft.crm.biz.dao.generation.user;

import com.shufensoft.crm.biz.domain.generation.user.UserInteractionStatistic;
import com.shufensoft.crm.biz.domain.generation.user.UserInteractionStatisticExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInteractionStatisticMapper {
    int countByExample(UserInteractionStatisticExample example);

    int deleteByExample(UserInteractionStatisticExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInteractionStatistic record);

    int insertSelective(UserInteractionStatistic record);

    List<UserInteractionStatistic> selectByExample(UserInteractionStatisticExample example);

    UserInteractionStatistic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInteractionStatistic record, @Param("example") UserInteractionStatisticExample example);

    int updateByExample(@Param("record") UserInteractionStatistic record, @Param("example") UserInteractionStatisticExample example);

    int updateByPrimaryKeySelective(@Param("record") UserInteractionStatistic record);

    int updateByPrimaryKey(UserInteractionStatistic record);
}