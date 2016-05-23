package com.shufensoft.crm.biz.dao.generation.comment;

import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBaoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentTaoBaoMapper {
    int countByExample(CommentTaoBaoExample example);

    int deleteByExample(CommentTaoBaoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentTaoBao record);

    int insertSelective(CommentTaoBao record);

    List<CommentTaoBao> selectByExample(CommentTaoBaoExample example);

    CommentTaoBao selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentTaoBao record, @Param("example") CommentTaoBaoExample example);

    int updateByExample(@Param("record") CommentTaoBao record, @Param("example") CommentTaoBaoExample example);

    int updateByPrimaryKeySelective(@Param("record") CommentTaoBao record);

    int updateByPrimaryKey(CommentTaoBao record);
}