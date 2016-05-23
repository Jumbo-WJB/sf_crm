package com.shufensoft.crm.biz.dao.generation.receiver;

import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBaoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiverTaoBaoMapper {
    int countByExample(ReceiverTaoBaoExample example);

    int deleteByExample(ReceiverTaoBaoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiverTaoBao record);

    int insertSelective(ReceiverTaoBao record);

    List<ReceiverTaoBao> selectByExample(ReceiverTaoBaoExample example);

    ReceiverTaoBao selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiverTaoBao record, @Param("example") ReceiverTaoBaoExample example);

    int updateByExample(@Param("record") ReceiverTaoBao record, @Param("example") ReceiverTaoBaoExample example);

    int updateByPrimaryKeySelective(@Param("record") ReceiverTaoBao record);

    int updateByPrimaryKey(ReceiverTaoBao record);
}