package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsSku;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsSkuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallGoodsSkuMapper {
    int countByExample(MallGoodsSkuExample example);

    int deleteByExample(MallGoodsSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallGoodsSku record);

    int insertSelective(MallGoodsSku record);

    List<MallGoodsSku> selectByExample(MallGoodsSkuExample example);

    MallGoodsSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallGoodsSku record, @Param("example") MallGoodsSkuExample example);

    int updateByExample(@Param("record") MallGoodsSku record, @Param("example") MallGoodsSkuExample example);

    int updateByPrimaryKeySelective(@Param("record") MallGoodsSku record);

    int updateByPrimaryKey(MallGoodsSku record);
}