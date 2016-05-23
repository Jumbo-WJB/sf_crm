package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetail;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SellerPackageDetailMapper {
    int countByExample(SellerPackageDetailExample example);

    int deleteByExample(SellerPackageDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerPackageDetail record);

    int insertSelective(SellerPackageDetail record);

    List<SellerPackageDetail> selectByExample(SellerPackageDetailExample example);

    SellerPackageDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerPackageDetail record, @Param("example") SellerPackageDetailExample example);

    int updateByExample(@Param("record") SellerPackageDetail record, @Param("example") SellerPackageDetailExample example);

    int updateByPrimaryKeySelective(@Param("record") SellerPackageDetail record);

    int updateByPrimaryKey(SellerPackageDetail record);
}