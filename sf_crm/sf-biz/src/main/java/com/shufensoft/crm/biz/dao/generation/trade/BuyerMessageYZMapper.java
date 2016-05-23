package com.shufensoft.crm.biz.dao.generation.trade;

import com.shufensoft.crm.biz.domain.generation.trade.BuyerMessageYZ;
import com.shufensoft.crm.biz.domain.generation.trade.BuyerMessageYZExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerMessageYZMapper {
    int countByExample(BuyerMessageYZExample example);

    int deleteByExample(BuyerMessageYZExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuyerMessageYZ record);

    int insertSelective(BuyerMessageYZ record);

    List<BuyerMessageYZ> selectByExample(BuyerMessageYZExample example);

    BuyerMessageYZ selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuyerMessageYZ record, @Param("example") BuyerMessageYZExample example);

    int updateByExample(@Param("record") BuyerMessageYZ record, @Param("example") BuyerMessageYZExample example);

    int updateByPrimaryKeySelective(@Param("record") BuyerMessageYZ record);

    int updateByPrimaryKey(BuyerMessageYZ record);
}