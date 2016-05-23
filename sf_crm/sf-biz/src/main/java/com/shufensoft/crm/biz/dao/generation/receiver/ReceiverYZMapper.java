package com.shufensoft.crm.biz.dao.generation.receiver;

import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverYZ;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiverYZMapper {
    int countByExample(ReceiverYZExample example);

    int deleteByExample(ReceiverYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiverYZ record);

    int insertSelective(ReceiverYZ record);

    List<ReceiverYZ> selectByExample(ReceiverYZExample example);

    ReceiverYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiverYZ record, @Param("example") ReceiverYZExample example);

    int updateByExample(@Param("record") ReceiverYZ record, @Param("example") ReceiverYZExample example);

    int updateByPrimaryKeySelective(@Param("record") ReceiverYZ record);

    int updateByPrimaryKey(ReceiverYZ record);
}