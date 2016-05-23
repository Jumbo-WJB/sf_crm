package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCountExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SellerPackageCountMapper {
    int countByExample(SellerPackageCountExample example);

    int deleteByExample(SellerPackageCountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerPackageCount record);

    int insertSelective(SellerPackageCount record);

    List<SellerPackageCount> selectByExample(SellerPackageCountExample example);

    SellerPackageCount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerPackageCount record, @Param("example") SellerPackageCountExample example);

    int updateByExample(@Param("record") SellerPackageCount record, @Param("example") SellerPackageCountExample example);

    int updateByPrimaryKeySelective(@Param("record") SellerPackageCount record);

    int updateByPrimaryKey(SellerPackageCount record);
}