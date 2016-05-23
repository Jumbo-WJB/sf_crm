package com.shufensoft.crm.biz.dao.generation.comment;

import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJDExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentJDMapper {
    int countByExample(CommentJDExample example);

    int deleteByExample(CommentJDExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentJD record);

    int insertSelective(CommentJD record);

    List<CommentJD> selectByExample(CommentJDExample example);

    CommentJD selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentJD record, @Param("example") CommentJDExample example);

    int updateByExample(@Param("record") CommentJD record, @Param("example") CommentJDExample example);

    int updateByPrimaryKeySelective(@Param("record") CommentJD record);

    int updateByPrimaryKey(CommentJD record);
}