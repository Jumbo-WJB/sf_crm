package com.shufensoft.crm.biz.dao.generation.send;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.send.SmsStatusReport;
import com.shufensoft.crm.biz.domain.generation.send.SmsStatusReportExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SmsStatusReportMapper {
    int countByExample(SmsStatusReportExample example);

    int deleteByExample(SmsStatusReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsStatusReport record);

    int insertSelective(SmsStatusReport record);

    List<SmsStatusReport> selectByExample(SmsStatusReportExample example);

    SmsStatusReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsStatusReport record, @Param("example") SmsStatusReportExample example);

    int updateByExample(@Param("record") SmsStatusReport record, @Param("example") SmsStatusReportExample example);

    int updateByPrimaryKeySelective(@Param("record") SmsStatusReport record);

    int updateByPrimaryKey(SmsStatusReport record);
}