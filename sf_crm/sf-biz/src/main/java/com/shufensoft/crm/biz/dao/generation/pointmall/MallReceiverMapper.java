package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiver;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiverExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallReceiverMapper {
    int countByExample(MallReceiverExample example);

    int deleteByExample(MallReceiverExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallReceiver record);

    int insertSelective(MallReceiver record);

    List<MallReceiver> selectByExample(MallReceiverExample example);

    MallReceiver selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallReceiver record, @Param("example") MallReceiverExample example);

    int updateByExample(@Param("record") MallReceiver record, @Param("example") MallReceiverExample example);

    int updateByPrimaryKeySelective(@Param("record") MallReceiver record);

    int updateByPrimaryKey(MallReceiver record);
}