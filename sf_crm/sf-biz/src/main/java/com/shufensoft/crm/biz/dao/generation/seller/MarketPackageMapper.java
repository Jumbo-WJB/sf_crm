package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.MarketPackage;
import com.shufensoft.crm.biz.domain.generation.seller.MarketPackageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface MarketPackageMapper {
    int countByExample(MarketPackageExample example);

    int deleteByExample(MarketPackageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarketPackage record);

    int insertSelective(MarketPackage record);

    List<MarketPackage> selectByExample(MarketPackageExample example);

    MarketPackage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketPackage record, @Param("example") MarketPackageExample example);

    int updateByExample(@Param("record") MarketPackage record, @Param("example") MarketPackageExample example);

    int updateByPrimaryKeySelective(@Param("record") MarketPackage record);

    int updateByPrimaryKey(MarketPackage record);
}