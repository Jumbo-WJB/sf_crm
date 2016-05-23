package com.shufensoft.crm.biz.dao.generation.express;

import com.shufensoft.crm.biz.domain.generation.express.ExpressInfo;
import com.shufensoft.crm.biz.domain.generation.express.ExpressInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressInfoMapper {
    int countByExample(ExpressInfoExample example);

    int deleteByExample(ExpressInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpressInfo record);

    int insertSelective(ExpressInfo record);

    List<ExpressInfo> selectByExampleWithBLOBs(ExpressInfoExample example);

    List<ExpressInfo> selectByExample(ExpressInfoExample example);

    ExpressInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

    int updateByExample(@Param("record") ExpressInfo record, @Param("example") ExpressInfoExample example);

    int updateByPrimaryKeySelective(@Param("record") ExpressInfo record);

    int updateByPrimaryKeyWithBLOBs(ExpressInfo record);

    int updateByPrimaryKey(ExpressInfo record);
}