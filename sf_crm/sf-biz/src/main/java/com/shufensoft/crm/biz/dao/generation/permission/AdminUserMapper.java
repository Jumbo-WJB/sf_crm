package com.shufensoft.crm.biz.dao.generation.permission;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface AdminUserMapper {
    int countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    AdminUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(@Param("record") AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}