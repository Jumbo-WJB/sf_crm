package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJD;
import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJDExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemInfoJDMapper {
    int countByExample(ItemInfoJDExample example);

    int deleteByExample(ItemInfoJDExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemInfoJD record);

    int insertSelective(ItemInfoJD record);

    List<ItemInfoJD> selectByExample(ItemInfoJDExample example);

    ItemInfoJD selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemInfoJD record, @Param("example") ItemInfoJDExample example);

    int updateByExample(@Param("record") ItemInfoJD record, @Param("example") ItemInfoJDExample example);

    int updateByPrimaryKeySelective(@Param("record") ItemInfoJD record);

    int updateByPrimaryKey(ItemInfoJD record);
}