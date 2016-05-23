package com.shufensoft.crm.biz.service.sellerConfig;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfig;
import com.shufensoft.crm.biz.vo.DataSourceConfigVO;
import com.shufensoft.crm.biz.vo.SellerConfigInfoVO;
import com.shufensoft.crm.biz.vo.SellerShopVO;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/22  
 */
public interface SellerConfigService {

    /**
     * 查询商家的店铺
     * @param sellerShopVO
     * @return
     */
    public List<SellerShop> queryShops(SellerShopVO sellerShopVO);

    /**
     * 根据sellerId查询商家的店铺
     * @param sellerId
     * @return
     */
    public List<SellerShop> queryShopsBySellerId(Long sellerId);

    /**
     * 保存或更新商家店铺配置
     * @param sellerShopVO
     * @return
     */
    public boolean saveOrUpdateShopConfig(SellerShopVO sellerShopVO);

    /**
     * 通过缓存查询商家店铺信息
     * @param sellerShopVO
     * @return
     */
    public List<SellerShop> showConfig(SellerShopVO sellerShopVO);

    /**
     * 删除店铺信息
     * @param sellerId
     * @param shopId
     * @return
     */
    public boolean deleteConfig(Long sellerId, Long shopId);

    /**
     * 查找商家配置信息
     * @param sellerConfigInfoVO
     * @return
     */
    public SellerConfigInfo queryConfigInfo(SellerConfigInfoVO sellerConfigInfoVO);

    /**
     * 保存或更新商家配置信息
     * @param sellerConfigInfoVO
     * @return
     */
    public boolean saveOrUpdateConfigInfo(SellerConfigInfoVO sellerConfigInfoVO);

    /**
     * 查找数据源
     * @param dataSourceConfigVO
     * @return
     */
    public DataSourceConfig queryDataSourceByName(DataSourceConfigVO dataSourceConfigVO);
}
