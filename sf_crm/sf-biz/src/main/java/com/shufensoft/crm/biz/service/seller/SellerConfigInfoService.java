package com.shufensoft.crm.biz.service.seller;

import com.shufensoft.crm.biz.dao.generation.seller.SellerConfigInfoMapper;
import com.shufensoft.crm.biz.dao.generation.seller.SellerShopMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfoExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShopExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 商户信息服务类
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/19 22:33  
 */
@Service
public class SellerConfigInfoService {

    @Autowired
    SellerConfigInfoMapper sellerConfigInfoMapper;

    @Autowired
    SellerShopMapper sellerShopMapper;

    /**
     * logger
     */
    public static final Logger logger = Logger.getLogger(SellerConfigInfoService.class);


    /**
     * 根据id删除商户信息
     *
     * @param id
     */
    public void deleteSellerConfigInfoById(long id) {
        sellerConfigInfoMapper.deleteByPrimaryKey(id);
    }


    /**
     * 根据id删除商户店铺
     * @param sellerId
     * @param shopId
     */
    public void deleteSellerShop(Long sellerId, Long shopId) {

        SellerShopExample sellerShopExample = new SellerShopExample();
        sellerShopExample.createCriteria().andSellerIdEqualTo(sellerId).andShopIdEqualTo(shopId);

        sellerShopMapper.deleteByExample(sellerShopExample);

    }

    /**
     * 根据id获取商户信息
     *
     * @param id
     */
    public  SellerConfigInfo getSellerConfigInfoById(long id) {
        SellerConfigInfo sellerConfigInfo=sellerConfigInfoMapper.selectByPrimaryKey(id);
        return sellerConfigInfo;
    }

    /**
     * 通过商户条件获取商户商户信息
     * @param sellerConfigInfo
     * @return
     */
    public  SellerConfigInfo getSellerConfigInfoByCon(SellerConfigInfo   sellerConfigInfo) {

        SellerConfigInfoExample  sellerConfigInfoExample=new SellerConfigInfoExample();
        SellerConfigInfoExample.Criteria  criteria=sellerConfigInfoExample.createCriteria();
        if(!StringUtils.isBlank(sellerConfigInfo.getWxNo())){//若微信号不为空的时候
            criteria.andWxNoEqualTo(sellerConfigInfo.getWxNo());
        }
        if(!StringUtils.isBlank(sellerConfigInfo.getSellerName())){//当商户名称不为空的时候，模糊匹配
            criteria.andSellerNameLike("%"+sellerConfigInfo.getSellerName()+"%");
        }
        if(!StringUtils.isBlank(sellerConfigInfo.getMobile())){//当商户手机号码不为空的时候
            criteria.andMobileEqualTo(sellerConfigInfo.getMobile());
        }
        //根据查询条件获取商户信息
        List<SellerConfigInfo> list= sellerConfigInfoMapper.selectByExample(sellerConfigInfoExample);
        return CollectionUtils.isEmpty(list)?null:list.get(0);
    }

    /**
     * 通过商户ID获取商户信息
     * @param sellerId
     * @return
     */
    public  SellerConfigInfo getSellerConfigInfoBySellerId(Long sellerId) {

        if(sellerId == null){
            throw new ServiceException("SellerConfigInfoService.getSellerConfigInfoBySellerId","sellerId is null");
        }

        SellerConfigInfoExample  sellerConfigInfoExample=new SellerConfigInfoExample();
        sellerConfigInfoExample.createCriteria().andSellerIdEqualTo(sellerId);
        List<SellerConfigInfo> sellerConfigInfos = sellerConfigInfoMapper.selectByExample(sellerConfigInfoExample);

        SellerConfigInfo sellerConfigInfo = null;

        if(!CollectionUtils.isEmpty(sellerConfigInfos)){

            sellerConfigInfo = sellerConfigInfos.get(0);

            SellerShopExample  sellerShopExample = new SellerShopExample();
            sellerShopExample.createCriteria().andSellerIdEqualTo(sellerId);
            List<SellerShop> shops = sellerShopMapper.selectByExample(sellerShopExample);
            sellerConfigInfo.setSellerShopList(shops);

        }

        return sellerConfigInfo;

    }

    /**
     * 通过商户ID获取商户店铺
     * @param shopId
     * @return
     */
    public  SellerShop getSellerShopByShopId(Long sellerId , Long shopId) {

        AssertsUtil.notNull(sellerId , "sellerId");
        AssertsUtil.notNull(shopId , "shopId");

        SellerShopExample  sellerShopExample = new SellerShopExample();
        sellerShopExample.createCriteria().andSellerIdEqualTo(sellerId).andShopIdEqualTo(shopId);
        List<SellerShop> sellerShops = sellerShopMapper.selectByExample(sellerShopExample);

        SellerShop sellerShop = null;

        if(!CollectionUtils.isEmpty(sellerShops)){

            sellerShop = sellerShops.get(0);

        }

        return sellerShop;

    }

    /**
     * 查询全部商户信息
     * @return
     */
    public List<SellerConfigInfo> getAllSellerConfigInfoList(){

        SellerConfigInfoExample  sellerConfigInfoExample=new SellerConfigInfoExample();

        List<SellerConfigInfo> list = sellerConfigInfoMapper.selectByExample(sellerConfigInfoExample);

        if(CollectionUtils.isEmpty(list)){
            return null;
        }

        for(SellerConfigInfo sellerConfigInfo : list){

            SellerShopExample  sellerShopExample = new SellerShopExample();
            sellerShopExample.createCriteria().andSellerIdEqualTo(sellerConfigInfo.getSellerId());
            List<SellerShop> shops = sellerShopMapper.selectByExample(sellerShopExample);
            sellerConfigInfo.setSellerShopList(shops);

        }

        return list;
    }


    /**
     * 创建商户信息
     *
     * @param sellerConfigInfo
     */
    public void createSellerConfigInfo( SellerConfigInfo sellerConfigInfo) {
        sellerConfigInfoMapper.insert(sellerConfigInfo);
    }

    /**
     * 保存商户信息
     * @Author litu
     * @Date 2015/5/19 22:33
     * @param sellerConfigInfo
     * @return
     */
    public boolean save(SellerConfigInfo sellerConfigInfo) {

        AssertsUtil.notNull(sellerConfigInfo,"sellerConfigInfo");

        return sellerConfigInfoMapper.insert(sellerConfigInfo)>0;

    }

    /**
     * 更新商户信息
     * @Author litu
     * @Date 2015/5/19 22:33
     * @param sellerConfigInfo
     * @return
     */
    public boolean updateSellerBySellerId(SellerConfigInfo sellerConfigInfo) {

        AssertsUtil.notNull(sellerConfigInfo,"sellerConfigInfo");
        SellerConfigInfoExample sellerConfigInfoExample = new SellerConfigInfoExample();
        sellerConfigInfoExample.createCriteria().andSellerIdEqualTo(sellerConfigInfo.getSellerId());

        return sellerConfigInfoMapper.updateByExampleSelective(sellerConfigInfo,sellerConfigInfoExample)>0;

    }

    /**
     * 更新商户店铺信息
     * @Author litu
     * @Date 2015/5/19 22:33
     * @param sellerShop
     * @return
     */
    public boolean updateSellerShopByShopId(SellerShop sellerShop) {

        AssertsUtil.notNull(sellerShop,"sellerShop");
        AssertsUtil.notNull(sellerShop.getSellerId(),"sellerId");
        AssertsUtil.notNull(sellerShop.getShopId(),"shopId");

        SellerShopExample sellerShopExample = new SellerShopExample();

        sellerShopExample.createCriteria().andSellerIdEqualTo(sellerShop.getSellerId())
                .andShopIdEqualTo(sellerShop.getShopId());

        return sellerShopMapper.updateByExampleSelective(sellerShop,sellerShopExample)>0;

    }

    /**
     * 保存或更新商户信息
     * @Author litu
     * @Date 2015/5/19 22:33
     * @param sellerConfigInfo
     * @return
     */
    public boolean saveOrUpdate(SellerConfigInfo sellerConfigInfo) {

        AssertsUtil.notNull(sellerConfigInfo,"sellerConfigInfo");

        if(getSellerConfigInfoBySellerId(sellerConfigInfo.getSellerId())==null){
            save(sellerConfigInfo);
        }else{
            updateSellerBySellerId(sellerConfigInfo);
        }

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        if(!CollectionUtils.isEmpty(sellerShops)){

            for(SellerShop sellerShop : sellerShops){

                saveOrUpdateSellerShop(sellerShop);

            }

        }

        return true;

    }

    /**
     * 保存或更新商户店铺
     * @Author litu
     * @Date 2015/5/19 22:33
     * @param sellerShop
     * @return
     */
    public boolean saveOrUpdateSellerShop(SellerShop sellerShop) {

        AssertsUtil.notNull(sellerShop,"sellerShop");
        AssertsUtil.notNull(sellerShop.getSellerId(),"sellerId");

         SellerShop sellerShopTmp = null;
        if (sellerShop.getShopId() != null){
            sellerShopTmp = getSellerShopByShopId(sellerShop.getSellerId() , sellerShop.getShopId());
        }

        if(sellerShopTmp == null){
            sellerShopMapper.insert(sellerShop);
            return true;
        }

        return updateSellerShopByShopId(sellerShop);

    }
}
