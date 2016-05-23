package com.shufensoft.crm.biz.dao.generation.activity;

import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoods;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityGoodsMapper {
    int countByExample(ActivityGoodsExample example);

    int deleteByExample(ActivityGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityGoods record);

    int insertSelective(ActivityGoods record);

    List<ActivityGoods> selectByExample(ActivityGoodsExample example);

    ActivityGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityGoods record, @Param("example") ActivityGoodsExample example);

    int updateByExample(@Param("record") ActivityGoods record, @Param("example") ActivityGoodsExample example);

    int updateByPrimaryKeySelective(@Param("record") ActivityGoods record);

    int updateByPrimaryKey(ActivityGoods record);
}