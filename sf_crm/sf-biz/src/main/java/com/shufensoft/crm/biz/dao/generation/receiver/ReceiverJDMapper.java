package com.shufensoft.crm.biz.dao.generation.receiver;

import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJDExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiverJDMapper {
    int countByExample(ReceiverJDExample example);

    int deleteByExample(ReceiverJDExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiverJD record);

    int insertSelective(ReceiverJD record);

    List<ReceiverJD> selectByExample(ReceiverJDExample example);

    ReceiverJD selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiverJD record, @Param("example") ReceiverJDExample example);

    int updateByExample(@Param("record") ReceiverJD record, @Param("example") ReceiverJDExample example);

    int updateByPrimaryKeySelective(@Param("record") ReceiverJD record);

    int updateByPrimaryKey(ReceiverJD record);
}