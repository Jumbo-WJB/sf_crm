package com.shufensoft.crm.biz.dao.generation.pointmall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallCategory;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallCategoryMapper {
    int countByExample(MallCategoryExample example);

    int deleteByExample(MallCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallCategory record);

    int insertSelective(MallCategory record);

    List<MallCategory> selectByExample(MallCategoryExample example);

    MallCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByExample(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByPrimaryKeySelective(@Param("record") MallCategory record);

    int updateByPrimaryKey(MallCategory record);


}