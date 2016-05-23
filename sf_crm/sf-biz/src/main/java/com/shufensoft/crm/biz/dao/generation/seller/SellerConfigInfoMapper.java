package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DataSourceSwitch
public interface SellerConfigInfoMapper {
    int countByExample(SellerConfigInfoExample example);

    int deleteByExample(SellerConfigInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerConfigInfo record);

    int insertSelective(SellerConfigInfo record);

    List<SellerConfigInfo> selectByExample(SellerConfigInfoExample example);

    SellerConfigInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerConfigInfo record, @Param("example") SellerConfigInfoExample example);

    int updateByExample(@Param("record") SellerConfigInfo record, @Param("example") SellerConfigInfoExample example);

    int updateByPrimaryKeySelective(@Param("record") SellerConfigInfo record);

    int updateByPrimaryKey(SellerConfigInfo record);
}