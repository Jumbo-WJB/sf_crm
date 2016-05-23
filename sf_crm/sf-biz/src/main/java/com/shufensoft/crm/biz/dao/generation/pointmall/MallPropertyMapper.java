package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallProperty;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallPropertyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallPropertyMapper {
    int countByExample(MallPropertyExample example);

    int deleteByExample(MallPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallProperty record);

    int insertSelective(MallProperty record);

    List<MallProperty> selectByExample(MallPropertyExample example);

    MallProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallProperty record, @Param("example") MallPropertyExample example);

    int updateByExample(@Param("record") MallProperty record, @Param("example") MallPropertyExample example);

    int updateByPrimaryKeySelective(@Param("record") MallProperty record);

    int updateByPrimaryKey(MallProperty record);
}