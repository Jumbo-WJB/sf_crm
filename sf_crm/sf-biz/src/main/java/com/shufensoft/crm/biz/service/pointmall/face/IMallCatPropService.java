package com.shufensoft.crm.biz.service.pointmall.face;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallCategory;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallProperty;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallPropertyValue;

import java.util.List;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/11  
 */
public interface IMallCatPropService {

    public List<MallCategory> getFirstCategory(Long sellerId);

    public List<MallCategory> getSubCategory(Long sellerId, Long cid);

    public List<MallProperty> getSaleProperties(Long sellerId, Long cid);

    public List<MallPropertyValue> getPropertyValue(Long sellerId, List<Long> pidList);

    public List<MallCategory> getAllCatetoryBySellerId(Long sellerId);

    public List<MallCategory> createCatgoryTree(Long sellerId);

    public List<MallProperty> getSalePropertiesAndValues(Long sellerId , Long cid);

    public List<MallProperty> getSalePropertiesAndValuesByGoodsId(Long sellerId , Long goodsId);

    /**
     * 获取某个类目下属性个数
     * */
    public int getPropertyCountByCategoryId(Long sellerId,Long categoryId);

}
