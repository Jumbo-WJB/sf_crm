package com.shufensoft.crm.biz.dao.generation.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.send.SendUserUnsubscribe;
import com.shufensoft.crm.biz.domain.generation.send.SendUserUnsubscribeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SendUserUnsubscribeMapper {
    int countByExample(SendUserUnsubscribeExample example);

    int deleteByExample(SendUserUnsubscribeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SendUserUnsubscribe record);

    int insertSelective(SendUserUnsubscribe record);

    List<SendUserUnsubscribe> selectByExample(SendUserUnsubscribeExample example);

    SendUserUnsubscribe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SendUserUnsubscribe record, @Param("example") SendUserUnsubscribeExample example);

    int updateByExample(@Param("record") SendUserUnsubscribe record, @Param("example") SendUserUnsubscribeExample example);

    int updateByPrimaryKeySelective(@Param("record") SendUserUnsubscribe record);

    int updateByPrimaryKey(SendUserUnsubscribe record);
}