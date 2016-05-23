package com.shufensoft.crm.biz.dao.generation.permission;

import com.shufensoft.crm.biz.domain.generation.permission.AdminUserRole;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserRoleMapper {
    int countByExample(AdminUserRoleExample example);

    int deleteByExample(AdminUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminUserRole record);

    int insertSelective(AdminUserRole record);

    List<AdminUserRole> selectByExample(AdminUserRoleExample example);

    AdminUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminUserRole record, @Param("example") AdminUserRoleExample example);

    int updateByExample(@Param("record") AdminUserRole record, @Param("example") AdminUserRoleExample example);

    int updateByPrimaryKeySelective(@Param("record") AdminUserRole record);

    int updateByPrimaryKey(AdminUserRole record);
}