package com.shufensoft.crm.biz.dao.generation.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBCash;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBCashExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HBCashMapper {
    int countByExample(HBCashExample example);

    int deleteByExample(HBCashExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HBCash record);

    int insertSelective(HBCash record);

    List<HBCash> selectByExample(HBCashExample example);

    HBCash selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HBCash record, @Param("example") HBCashExample example);

    int updateByExample(@Param("record") HBCash record, @Param("example") HBCashExample example);

    int updateByPrimaryKeySelective(@Param("record") HBCash record);

    int updateByPrimaryKey(HBCash record);
}