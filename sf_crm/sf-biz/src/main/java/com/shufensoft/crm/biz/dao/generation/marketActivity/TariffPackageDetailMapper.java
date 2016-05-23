package com.shufensoft.crm.biz.dao.generation.marketActivity;

import com.shufensoft.crm.biz.domain.generation.marketActivity.TariffPackageDetail;
import com.shufensoft.crm.biz.domain.generation.marketActivity.TariffPackageDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TariffPackageDetailMapper {
    int countByExample(TariffPackageDetailExample example);

    int deleteByExample(TariffPackageDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TariffPackageDetail record);

    int insertSelective(TariffPackageDetail record);

    List<TariffPackageDetail> selectByExample(TariffPackageDetailExample example);

    TariffPackageDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TariffPackageDetail record, @Param("example") TariffPackageDetailExample example);

    int updateByExample(@Param("record") TariffPackageDetail record, @Param("example") TariffPackageDetailExample example);

    int updateByPrimaryKeySelective(TariffPackageDetail record);

    int updateByPrimaryKey(TariffPackageDetail record);
}