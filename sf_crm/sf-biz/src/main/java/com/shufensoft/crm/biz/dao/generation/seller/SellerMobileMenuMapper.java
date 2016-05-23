package com.shufensoft.crm.biz.dao.generation.seller;

import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerMobileMenuMapper {
    int countByExample(SellerMobileMenuExample example);

    int deleteByExample(SellerMobileMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerMobileMenu record);

    int insertSelective(SellerMobileMenu record);

    List<SellerMobileMenu> selectByExample(SellerMobileMenuExample example);

    SellerMobileMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerMobileMenu record, @Param("example") SellerMobileMenuExample example);

    int updateByExample(@Param("record") SellerMobileMenu record, @Param("example") SellerMobileMenuExample example);

    int updateByPrimaryKeySelective(@Param("record") SellerMobileMenu record);

    int updateByPrimaryKey(SellerMobileMenu record);
}