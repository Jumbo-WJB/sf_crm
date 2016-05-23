package com.shufensoft.crm.biz.dao.generation.comment;

import com.shufensoft.crm.biz.domain.generation.comment.TmallRateTag;
import com.shufensoft.crm.biz.domain.generation.comment.TmallRateTagExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmallRateTagMapper {
    int countByExample(TmallRateTagExample example);

    int deleteByExample(TmallRateTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TmallRateTag record);

    int insertSelective(TmallRateTag record);

    List<TmallRateTag> selectByExample(TmallRateTagExample example);

    TmallRateTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TmallRateTag record, @Param("example") TmallRateTagExample example);

    int updateByExample(@Param("record") TmallRateTag record, @Param("example") TmallRateTagExample example);

    int updateByPrimaryKeySelective(@Param("record") TmallRateTag record);

    int updateByPrimaryKey(TmallRateTag record);
}