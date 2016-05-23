package com.shufensoft.crm.biz.dao.generation.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.send.MailStatusReport;
import com.shufensoft.crm.biz.domain.generation.send.MailStatusReportExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface MailStatusReportMapper {
    int countByExample(MailStatusReportExample example);

    int deleteByExample(MailStatusReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MailStatusReport record);

    int insertSelective(MailStatusReport record);

    List<MailStatusReport> selectByExample(MailStatusReportExample example);

    MailStatusReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MailStatusReport record, @Param("example") MailStatusReportExample example);

    int updateByExample(@Param("record") MailStatusReport record, @Param("example") MailStatusReportExample example);

    int updateByPrimaryKeySelective(@Param("record") MailStatusReport record);

    int updateByPrimaryKey(MailStatusReport record);
}