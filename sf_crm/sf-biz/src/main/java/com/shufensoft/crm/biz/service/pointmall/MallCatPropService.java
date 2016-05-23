package com.shufensoft.crm.biz.service.pointmall;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallCategoryMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallGoodsMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallPropertyMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallPropertyValueMapper;
import com.shufensoft.crm.biz.domain.generation.pointmall.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.pointmall.face.IMallCatPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  积分商城 类目属性处理
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-23 20:03  
 */
@Service(value="mallCategoryService")
public class MallCatPropService implements IMallCatPropService{

    @Autowired
    private MallCategoryMapper mallCategoryMapper;

    @Autowired
    private MallPropertyMapper mallPropertyMapper;

    @Autowired
    private MallPropertyValueMapper mallPropertyValueMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    /**
     * 获得一级类目列表
     *
     * @param sellerId
     * @return
     */
    @Override
    public List<MallCategory> getFirstCategory(Long sellerId) {
        MallCategoryExample mallCategoryExample = new MallCategoryExample();
        mallCategoryExample.createCriteria().andSellerIdEqualTo(sellerId).andParentCidEqualTo(0L).andStatusEqualTo(DaoConstant.Status.VALID);
        List<MallCategory> mallCategoryList = mallCategoryMapper.selectByExample(mallCategoryExample);
        return mallCategoryList;
    }

    /**
     * 获得指定类目的下级类目清单
     *
     * @param sellerId
     * @param cid
     * @return
     */
    @Override
    public List<MallCategory> getSubCategory(Long sellerId, Long cid) {
        if(sellerId <= 0 || cid <= 0) {
            throw new ServiceException("invalid parameter.");
        }

        MallCategoryExample mallCategoryExample = new MallCategoryExample();
        mallCategoryExample.createCriteria().andSellerIdEqualTo(sellerId).andParentCidEqualTo(cid).andStatusEqualTo(DaoConstant.Status.VALID);
        List<MallCategory> mallCategoryList = mallCategoryMapper.selectByExample(mallCategoryExample);

        return mallCategoryList;
    }

    /**
     * 获得销售属性，在上传商品时会需要用到
     *
     * @param sellerId
     * @param cid 叶子类目id
     * @return
     */
    @Override
    public List<MallProperty> getSaleProperties(Long sellerId, Long cid) {
        if(sellerId <= 0 || cid <= 0) {
            throw new ServiceException("invalid parameter.");
        }

        MallPropertyExample mallPropertyExample = new MallPropertyExample();
        mallPropertyExample.createCriteria().andSellerIdEqualTo(sellerId).andCidEqualTo(cid)
                .andStatusEqualTo(DaoConstant.Status.VALID).andIsSalePropEqualTo(DaoConstant.YN.YES);
        List<MallProperty> mallPropertyList = mallPropertyMapper.selectByExample(mallPropertyExample);

        return mallPropertyList;
    }

    @Override
    public List<MallPropertyValue> getPropertyValue(Long sellerId, List<Long> pidList) {
        if(sellerId <= 0 || pidList.size() <= 0) {
            throw new ServiceException("invalid parameter.");
        }

        MallPropertyValueExample mallPropertyValueExample = new MallPropertyValueExample();
        mallPropertyValueExample.createCriteria().andSellerIdEqualTo(sellerId).andPidIn(pidList)
                .andStatusEqualTo(DaoConstant.Status.VALID);
        List<MallPropertyValue> mallPropertyValueList = mallPropertyValueMapper.selectByExample(mallPropertyValueExample);

        return mallPropertyValueList;
    }

    /**
     * 获取某个商家所有类目, 目前最多支持三级类目
     * */
    @Override
     public List<MallCategory> getAllCatetoryBySellerId(Long sellerId) {
        if(sellerId < 0){
            throw new ServiceException("invalid parameter!");
        }
        MallCategoryExample example = new MallCategoryExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andStatusEqualTo(DaoConstant.Status.VALID);
        return mallCategoryMapper.selectByExample(example);
    }

    /**
     *  把所有类目重新整理， 父子归位， 最后返回一级类目的集合
     * */
    @Override
     public List<MallCategory> createCatgoryTree(Long sellerId) {
        if(sellerId < 0){
            throw new ServiceException("invalid parameter!");
        }
        List<MallCategory> mallCategories = getAllCatetoryBySellerId(sellerId);
        Map<Long, MallCategory> map = new HashMap<Long,MallCategory>();
        for(MallCategory mallCategory : mallCategories){
            map.put(mallCategory.getCid(),mallCategory);
        }
        List<MallCategory> rootCategory = new ArrayList<MallCategory>();
        for(MallCategory mallCategory : mallCategories){
            Long pcid = mallCategory.getParentCid();
            if(pcid != 0){
                MallCategory parent = map.get(pcid);
                List<MallCategory> childs = parent.getChilds();
                if(childs != null){
                    childs.add(mallCategory);
                }else{
                    childs = new ArrayList<MallCategory>();
                    childs.add(mallCategory);
                    parent.setChilds(childs);
                }
            }else{
                rootCategory.add(mallCategory);
            }
        }
        return rootCategory;
    }

    /**
     *  获取商户某个商品分类下的属性, 并填充属性值
     *  @param cid
     * */
    @Override
     public List<MallProperty> getSalePropertiesAndValues(Long sellerId , Long cid){
        if(sellerId < 0 || cid < 0){
            throw new ServiceException("invalid param!");
        }
        List<MallProperty> properties = this.getSaleProperties(sellerId,cid);
        List<Long> pids = new ArrayList<Long>();
        for(MallProperty property : properties){
            pids.clear();
            pids.add(property.getPid());
            List<MallPropertyValue> mallPropertyValues = this.getPropertyValue(sellerId,pids);
            if(!CollectionUtils.isEmpty(mallPropertyValues)){
                property.setPropertyValueList(mallPropertyValues);
            }
        }
        return properties;
    }

    /**
     *  获取商户某个商品下的属性, 并填充属性值
     *  @param goodsId
     * */
    @Override
     public List<MallProperty> getSalePropertiesAndValuesByGoodsId(Long sellerId , Long goodsId){
        if(sellerId < 0 || goodsId < 0){
            throw new ServiceException("invalid param!");
        }
        MallGoodsExample example = new MallGoodsExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        List<MallGoods> mallGoodsList =  mallGoodsMapper.selectByExample(example);
        List<MallProperty> properties = this.getSaleProperties(sellerId,mallGoodsList.get(0).getCategoryId());
        List<Long> pids = new ArrayList<Long>();
        for(MallProperty property : properties){
            pids.clear();
            pids.add(property.getPid());
            List<MallPropertyValue> mallPropertyValues = this.getPropertyValue(sellerId,pids);
            if(!CollectionUtils.isEmpty(mallPropertyValues)){
                property.setPropertyValueList(mallPropertyValues);
            }
        }
        return properties;
    }

    /**
     * 获取某个类目下属性个数
     *
     * @param categoryId
     */
    @Override
    public int getPropertyCountByCategoryId(Long sellerId, Long categoryId) {
        return this.getSaleProperties(sellerId,categoryId).size();
    }


}
