package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.dataSource.annotaion.DataSourceSwitch;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShopExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceSwitch
public interface SellerShopMapper {
    int countByExample(SellerShopExample example);

    int deleteByExample(SellerShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerShop record);

    int insertSelective(SellerShop record);

    List<SellerShop> selectByExample(SellerShopExample example);

    SellerShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerShop record, @Param("example") SellerShopExample example);

    int updateByExample(@Param("record") SellerShop record, @Param("example") SellerShopExample example);

    int updateByPrimaryKeySelective(@Param("record") SellerShop record);

    int updateByPrimaryKey(SellerShop record);
}