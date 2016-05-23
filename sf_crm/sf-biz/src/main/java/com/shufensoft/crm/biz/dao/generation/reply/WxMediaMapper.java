package com.shufensoft.crm.biz.dao.generation.reply;

import com.shufensoft.crm.biz.domain.generation.reply.WxMedia;
import com.shufensoft.crm.biz.domain.generation.reply.WxMediaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WxMediaMapper {
    int countByExample(WxMediaExample example);

    int deleteByExample(WxMediaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxMedia record);

    int insertSelective(WxMedia record);

    List<WxMedia> selectByExampleWithBLOBs(WxMediaExample example);

    List<WxMedia> selectByExample(WxMediaExample example);

    WxMedia selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxMedia record, @Param("example") WxMediaExample example);

    int updateByExampleWithBLOBs(@Param("record") WxMedia record, @Param("example") WxMediaExample example);

    int updateByExample(@Param("record") WxMedia record, @Param("example") WxMediaExample example);

    int updateByPrimaryKeySelective(@Param("record") WxMedia record);

    int updateByPrimaryKeyWithBLOBs(WxMedia record);

    int updateByPrimaryKey(WxMedia record);
}