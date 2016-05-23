package com.shufensoft.crm.biz.dao.generation.permission;

import com.shufensoft.crm.biz.domain.generation.permission.AdminResource;
import com.shufensoft.crm.biz.domain.generation.permission.AdminResourceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminResourceMapper {
    int countByExample(AdminResourceExample example);

    int deleteByExample(AdminResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminResource record);

    int insertSelective(AdminResource record);

    List<AdminResource> selectByExample(AdminResourceExample example);

    AdminResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByExample(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByPrimaryKeySelective(@Param("record") AdminResource record);

    int updateByPrimaryKey(AdminResource record);
}