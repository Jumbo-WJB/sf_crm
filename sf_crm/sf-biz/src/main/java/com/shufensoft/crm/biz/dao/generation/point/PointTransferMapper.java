package com.shufensoft.crm.biz.dao.generation.point;

import com.shufensoft.crm.biz.domain.generation.point.PointTransfer;
import com.shufensoft.crm.biz.domain.generation.point.PointTransferExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointTransferMapper {
    int countByExample(PointTransferExample example);

    int deleteByExample(PointTransferExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PointTransfer record);

    int insertSelective(PointTransfer record);

    List<PointTransfer> selectByExample(PointTransferExample example);

    PointTransfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PointTransfer record, @Param("example") PointTransferExample example);

    int updateByExample(@Param("record") PointTransfer record, @Param("example") PointTransferExample example);

    int updateByPrimaryKeySelective(@Param("record") PointTransfer record);

    int updateByPrimaryKey(PointTransfer record);
}