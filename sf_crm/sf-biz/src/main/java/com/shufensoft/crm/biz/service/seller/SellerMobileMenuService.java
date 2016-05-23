package com.shufensoft.crm.biz.service.seller;

import com.shufensoft.crm.biz.dao.generation.seller.SellerMobileMenuMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenuExample;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>商户菜单配置信息服务类</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/3  
 */
@Service
public class SellerMobileMenuService {
    @Autowired
    SellerMobileMenuMapper sellerMobileMenuMapper;

    /**
     * 保存更新菜单配置
     * @param list
     */
    public void saveOrUpdate(List<SellerMobileMenu>  list,Long  sellerId){
      if(!CollectionUtils.isEmpty(list)){
         for (SellerMobileMenu sellerMobileMenu:list){
             if(sellerMobileMenu.getId()==null){
                 sellerMobileMenu.setSellerId(sellerId);
                 sellerMobileMenuMapper.insert(sellerMobileMenu);
             }else
                sellerMobileMenuMapper.updateByPrimaryKeySelective(sellerMobileMenu);
         }
     }
    }

    /**
     * 获取商户菜单配置信息
     * @param sellerMobileMenu
     * @return
     */
    public List<SellerMobileMenu> getSellerMobileMenus(SellerMobileMenu sellerMobileMenu,Long  sellerId) {
        SellerMobileMenuExample sellerMobileMenuExample=new SellerMobileMenuExample();
        SellerMobileMenuExample.Criteria criteria=sellerMobileMenuExample.createCriteria();
        if(!StringUtils.isBlank(sellerMobileMenu.getType())){
            criteria.andTypeEqualTo(sellerMobileMenu.getType());
        }
        if(!StringUtils.isBlank(sellerMobileMenu.getFunctionType())){
            criteria.andFunctionTypeEqualTo(sellerMobileMenu.getFunctionType());
        }
        if(!StringUtils.isBlank(sellerMobileMenu.getIsSelect())){
            criteria.andIsSelectEqualTo(sellerMobileMenu.getIsSelect());
        }
        if(!StringUtils.isBlank(sellerMobileMenu.getUrl())){
            criteria.andUrlEqualTo(sellerMobileMenu.getUrl());
        }
        if(sellerId!=null){
            criteria.andSellerIdEqualTo(sellerId);
        }
        List<SellerMobileMenu> list= sellerMobileMenuMapper.selectByExample(sellerMobileMenuExample);
        return  list;
    }

    /**
     * 根据url获取商户菜单配置信息
     * @param link
     * @return
     */
    public SellerMobileMenu getSellerMobileMenuByLink(String link,Long  sellerId) {

        AssertsUtil.notNull(link,"link is null");

        SellerMobileMenuExample sellerMobileMenuExample=new SellerMobileMenuExample();
        SellerMobileMenuExample.Criteria criteria=sellerMobileMenuExample.createCriteria();

        if(!StringUtils.isBlank(link)){
            criteria.andLinkEqualTo(link);
        }
        if(sellerId!=null){
            criteria.andSellerIdEqualTo(sellerId);
        }
        List<SellerMobileMenu> list= sellerMobileMenuMapper.selectByExample(sellerMobileMenuExample);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }

        return  null;
    }

    /**
     * 根据functionType和type获取商户菜单配置信息
     * @param functionType
     * @param type
     * @return
     */
    public List<SellerMobileMenu> getSellerMobileMenuByLink(String functionType , String type,Long  sellerId) {

        AssertsUtil.notBlank(functionType,"functionType is null");

        AssertsUtil.notBlank(type,"type is null");

        SellerMobileMenuExample sellerMobileMenuExample=new SellerMobileMenuExample();
        SellerMobileMenuExample.Criteria criteria=sellerMobileMenuExample.createCriteria();
        criteria.andFunctionTypeEqualTo(functionType);
        criteria.andTypeEqualTo(type);
        criteria.andSellerIdEqualTo(sellerId);

        List<SellerMobileMenu> list= sellerMobileMenuMapper.selectByExample(sellerMobileMenuExample);

        return  list;

    }

}
