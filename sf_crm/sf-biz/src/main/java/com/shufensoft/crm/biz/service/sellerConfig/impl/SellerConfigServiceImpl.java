package com.shufensoft.crm.biz.service.sellerConfig.impl;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dao.generation.seller.SellerConfigInfoMapper;
import com.shufensoft.crm.biz.dao.generation.seller.SellerShopMapper;
import com.shufensoft.crm.biz.dao.generation.system.DataSourceConfigMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfoExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShopExample;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfig;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfigExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.sellerConfig.SellerConfigService;
import com.shufensoft.crm.biz.vo.DataSourceConfigVO;
import com.shufensoft.crm.biz.vo.SellerConfigInfoVO;
import com.shufensoft.crm.biz.vo.SellerShopVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/22  
 */
@Service(value = "sellerConfigService")
public class SellerConfigServiceImpl implements SellerConfigService {

    @Autowired
    private SellerShopMapper sellerShopMapper;

    @Autowired
    private SellerConfigInfoMapper sellerConfigInfoMapper;

    @Autowired
    private DataSourceConfigMapper dataSourceConfigMapper;

    @Override
    public List<SellerShop> queryShops(SellerShopVO sellerShopVO) {

        SellerShopExample example = new SellerShopExample();
        SellerShopExample.Criteria criteria = example.createCriteria();

        if (sellerShopVO.getId() != null){
            criteria.andIdEqualTo(sellerShopVO.getId());
        }
        if (sellerShopVO.getShopId() != null){
            criteria.andShopIdEqualTo(sellerShopVO.getShopId());
        }
        if (sellerShopVO.getSellerId() != null){
            criteria.andSellerIdEqualTo(sellerShopVO.getSellerId());
        }
        if (StringUtils.isNotBlank(sellerShopVO.getShopType())){
            criteria.andShopTypeEqualTo(sellerShopVO.getShopType());
        }

        List<SellerShop> shopList = sellerShopMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(shopList)){
            return null;
        }

        return shopList;
    }

    @Override
    public List<SellerShop> queryShopsBySellerId(Long  sellerId) {
        AssertsUtil.notNull(sellerId,"sellerId");

        SellerShopExample example = new SellerShopExample();
        example.createCriteria().andSellerIdEqualTo(sellerId);

        List<SellerShop> shopList = sellerShopMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(shopList)){
            return null;
        }

        return shopList;
    }

    @Override
    public boolean saveOrUpdateShopConfig(SellerShopVO sellerShopVO) {

        AssertsUtil.notNull(sellerShopVO,"sellerShopVO");

        SellerShop sellerShop = (SellerShop)BeanCopierUtils.copyProperties(sellerShopVO,SellerShop.class);

        Long sellerId = sellerShop.getSellerId();
        SellerConfigCache.putSellerShop(String.valueOf(sellerId), sellerShop);

        return true;
    }

    @Override
    public List<SellerShop> showConfig(SellerShopVO sellerShopVO) {

        if (sellerShopVO.getSellerId() == null){
            throw new ServiceException("sellerId Can't be null");
        }

        /**
         * 根据sellerId从缓存获取商家店铺信息
         */
        SellerConfigInfo configInfo = SellerConfigCache.get(String.valueOf(sellerShopVO.getSellerId()));

        List<SellerShop> shopList = null;
        if (configInfo != null && configInfo.getSellerShopList() != null){
            shopList = configInfo.getSellerShopList();
            if (CollectionUtils.isEmpty(shopList)){
                return null;
            }
        }

        return shopList;
    }


    @Override
    public boolean deleteConfig(Long sellerId, Long shopId) {

        AssertsUtil.notNull(sellerId,"sellerId");
        AssertsUtil.notNull(shopId,"shopId");

        SellerConfigCache.removeSellerShop(String.valueOf(sellerId),String.valueOf(shopId));
        return true;
    }

    @Override
    public SellerConfigInfo queryConfigInfo(SellerConfigInfoVO sellerConfigInfoVO) {

        SellerConfigInfoExample example = new SellerConfigInfoExample();
        SellerConfigInfoExample.Criteria criteria = example.createCriteria();

        if (sellerConfigInfoVO.getSellerId() != null){
            criteria.andSellerIdEqualTo(sellerConfigInfoVO.getSellerId());
        }
        if (sellerConfigInfoVO.getId() != null){
            criteria.andIdEqualTo(sellerConfigInfoVO.getId());
        }

        List<SellerConfigInfo> configList = sellerConfigInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(configList)){
            return null;
        }

        return configList.get(0);
    }

    @Override
    public boolean saveOrUpdateConfigInfo(SellerConfigInfoVO sellerConfigInfoVO) {

        AssertsUtil.notNull(sellerConfigInfoVO,"sellerConfigInfoVO");
        if (sellerConfigInfoVO.getSellerId() == null){
            throw new ServiceException("sellerId Can't be null");
        }

        SellerConfigInfo configInfo = (SellerConfigInfo)BeanCopierUtils.copyProperties(sellerConfigInfoVO,SellerConfigInfo.class);

        Long sellerId = configInfo.getSellerId();
        SellerConfigCache.put(String.valueOf(sellerId),configInfo);

        return true;
    }

    @Override
    public DataSourceConfig queryDataSourceByName(DataSourceConfigVO dataSourceConfigVO) {
        DataSourceConfigExample example = new DataSourceConfigExample();
        DataSourceConfigExample.Criteria criteria = example.createCriteria();

        if (dataSourceConfigVO.getSellerId() != null){
            criteria.andSellerIdEqualTo(dataSourceConfigVO.getSellerId());
        }
        if (StringUtils.isNotBlank(dataSourceConfigVO.getDatasourceName())){
            criteria.andDatasourceNameEqualTo(dataSourceConfigVO.getDatasourceName());
        }

        List<DataSourceConfig> list = dataSourceConfigMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }

        return list.get(0);
    }
}
