package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallGoodsMapper {
    int countByExample(MallGoodsExample example);

    int deleteByExample(MallGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    List<MallGoods> selectByExample(MallGoodsExample example);

    MallGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallGoods record, @Param("example") MallGoodsExample example);

    int updateByExample(@Param("record") MallGoods record, @Param("example") MallGoodsExample example);

    int updateByPrimaryKeySelective(@Param("record") MallGoods record);

    int updateByPrimaryKey(MallGoods record);
}