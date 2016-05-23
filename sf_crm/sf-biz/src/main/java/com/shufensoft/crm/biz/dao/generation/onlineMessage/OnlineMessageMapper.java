package com.shufensoft.crm.biz.dao.generation.onlineMessage;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.onlineMessage.OnlineMessage;
import com.shufensoft.crm.biz.domain.generation.onlineMessage.OnlineMessageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface OnlineMessageMapper {
    int countByExample(OnlineMessageExample example);

    int deleteByExample(OnlineMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OnlineMessage record);

    int insertSelective(OnlineMessage record);

    List<OnlineMessage> selectByExampleWithBLOBs(OnlineMessageExample example);

    List<OnlineMessage> selectByExample(OnlineMessageExample example);

    OnlineMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OnlineMessage record, @Param("example") OnlineMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") OnlineMessage record, @Param("example") OnlineMessageExample example);

    int updateByExample(@Param("record") OnlineMessage record, @Param("example") OnlineMessageExample example);

    int updateByPrimaryKeySelective(@Param("record") OnlineMessage record);

    int updateByPrimaryKeyWithBLOBs(OnlineMessage record);

    int updateByPrimaryKey(OnlineMessage record);
}