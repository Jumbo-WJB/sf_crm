package com.shufensoft.crm.biz.cache;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.seller.SellerConfigInfoService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  商家配置缓存
 *                 </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/18  
 */
public class SellerConfigCache {


    private static SellerConfigInfoService sellerConfigInfoService;

    public static String SELLER_SHOP_CONFIG = "SELLER_SHOP_CONFIG";

    public static String SELLER_CONFIG = "SELLER_CONFIG";

    static {
        sellerConfigInfoService = (SellerConfigInfoService) SpringContextUtil.getBean("sellerConfigInfoService");
    }

    /**
     * 保存商家配置到缓存和数据库
     * @param sellerId
     * @param sellerConfigInfo
     */
    public  static void  put(String sellerId,SellerConfigInfo sellerConfigInfo) {

        AssertsUtil.notBlank(sellerId,"sellerId");
        sellerConfigInfoService.saveOrUpdate(sellerConfigInfo);
        reload(sellerId);

    }

    /**
     * 删除商家店铺到缓存和数据库
     * @param sellerId
     * @param shopId
     */
    public  static void  removeSellerShop(String sellerId, String shopId) {

        AssertsUtil.notBlank(sellerId,"sellerId");
        AssertsUtil.notBlank(shopId,"shopId");

        sellerConfigInfoService.deleteSellerShop(Long.valueOf(sellerId), Long.valueOf(shopId));
        RedisCache.delete(SELLER_SHOP_CONFIG + "_" + sellerId + "_" + shopId);
        reloadSellerConfig(sellerId);
        reloadAllSellerConfigInfo();

    }

    /**
     * 保存商家店铺配置到缓存和数据库
     * @param sellerId
     * @param sellerShop
     */
    public  static void putSellerShop(String sellerId , SellerShop sellerShop) {

        AssertsUtil.notNull(sellerShop,"sellerShop");
        AssertsUtil.notBlank(sellerId,"sellerId");

        sellerShop.setSellerId(Long.valueOf(sellerId));
        sellerConfigInfoService.saveOrUpdateSellerShop(sellerShop);

        reloadSellerShop(sellerId,String.valueOf(sellerShop.getShopId()));

    }

    public  static SellerConfigInfo get(String sellerId) {

       AssertsUtil.notBlank(sellerId,"sellerId");

       SellerConfigInfo sellerConfigInfo = (SellerConfigInfo)RedisCache.get(SELLER_CONFIG+"_"+sellerId);
       if(sellerConfigInfo == null){
           sellerConfigInfo = reload(sellerId);
       }

       return sellerConfigInfo;
    }

    /**
     * 获取商家店铺缓存
     * @param sellerId
     * @param shopId
     * @return
     */
    public  static SellerShop getSellerShop(String sellerId,String shopId) {

        AssertsUtil.notBlank(sellerId,"sellerId");
        AssertsUtil.notBlank(shopId,"shopId");

        SellerShop sellerShop = (SellerShop)RedisCache.get(SELLER_SHOP_CONFIG+"_"+sellerId+"_"+shopId);

        if(sellerShop == null){
            sellerShop = reloadSellerShop(sellerId , shopId);
        }

        return sellerShop;

    }

    /**
     * 获取所有商家配置
     * @return
     */
    public  static List<SellerConfigInfo> getAll() {

        List<SellerConfigInfo> sellerConfigInfos = (List<SellerConfigInfo>)RedisCache.get(SELLER_CONFIG);
        if(CollectionUtils.isEmpty(sellerConfigInfos)){
            sellerConfigInfos = sellerConfigInfoService.getAllSellerConfigInfoList();
            AssertsUtil.check(!CollectionUtils.isEmpty(sellerConfigInfos), "sellerConfigInfos");
            RedisCache.put(SELLER_CONFIG,(ArrayList<SellerConfigInfo>)sellerConfigInfos);
        }

        return sellerConfigInfos;
    }

    /**
     * 刷单个商家配置缓存
     * @param sellerId
     */
    public static SellerConfigInfo reload(String sellerId){

        AssertsUtil.notBlank(sellerId,"sellerId");
        SellerConfigInfo sellerConfigInfo = sellerConfigInfoService.getSellerConfigInfoBySellerId(Long.valueOf(sellerId));
        AssertsUtil.notNull(sellerConfigInfo, "sellerConfigInfo");

        reloadAllSellerConfigInfo();

        return reload(sellerConfigInfo);

    }

    /**
     * 刷单个商家店铺配置缓存
     * @param sellerId
     * @param shopId
     */
    public static SellerShop reloadSellerShop(String sellerId , String shopId){

        AssertsUtil.notBlank(sellerId,"sellerId");
        AssertsUtil.notBlank(shopId,"shopId");

        SellerShop sellerShop = sellerConfigInfoService.getSellerShopByShopId(Long.valueOf(sellerId) , Long.valueOf(shopId));
        AssertsUtil.notNull(sellerShop, "sellerShop");

        RedisCache.put(SELLER_SHOP_CONFIG + "_" + sellerId + "_" + sellerShop.getShopId(),sellerShop);

        reloadAllSellerConfigInfo();

        reloadSellerConfig(sellerId);

        return sellerShop;

    }

    /**
     * 刷所有商家配置缓存
     */
    public static void reloadAll(){

        List<SellerConfigInfo> sellerConfigInfoList = reloadAllSellerConfigInfo();
        AssertsUtil.check(!CollectionUtils.isEmpty(sellerConfigInfoList), "sellerConfigInfoList");
        for(SellerConfigInfo sellerConfigInfo : sellerConfigInfoList){
            reload(sellerConfigInfo);
        }

    }

    /**
     * 刷key为SELLER_CONFIG的缓存
     */
    private static List<SellerConfigInfo> reloadAllSellerConfigInfo(){

        List<SellerConfigInfo> sellerConfigInfoList = sellerConfigInfoService.getAllSellerConfigInfoList();
        AssertsUtil.check(!CollectionUtils.isEmpty(sellerConfigInfoList), "sellerConfigInfoList");

        RedisCache.put(SELLER_CONFIG,(ArrayList<SellerConfigInfo>)sellerConfigInfoList);

        return sellerConfigInfoList;
    }

    /**
     * 刷单个商家配置缓存
     * @param sellerConfigInfo
     */
    private static SellerConfigInfo reload(SellerConfigInfo sellerConfigInfo){

        AssertsUtil.notNull(sellerConfigInfo,"sellerConfigInfo");

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        if(!CollectionUtils.isEmpty(sellerShops)){

            for(SellerShop sellerShop : sellerShops){

                RedisCache.put(SELLER_SHOP_CONFIG + "_" + sellerShop.getSellerId() + "_" + sellerShop.getShopId(), sellerShop);

            }

        }

        RedisCache.put(SELLER_CONFIG + "_" + sellerConfigInfo.getSellerId() , sellerConfigInfo);

        return sellerConfigInfo;

    }

    /**
     * 刷key为'SELLER_CONFIG_sellerId'的缓存
     * @param sellerId
     */
    private static SellerConfigInfo reloadSellerConfig(String sellerId){

        AssertsUtil.notBlank(sellerId,"sellerId");

        SellerConfigInfo sellerConfigInfo = sellerConfigInfoService.getSellerConfigInfoBySellerId(Long.valueOf(sellerId));
        AssertsUtil.notNull(sellerConfigInfo, "sellerConfigInfo");

        RedisCache.put(SELLER_CONFIG + "_" + sellerConfigInfo.getSellerId() , sellerConfigInfo);

        return sellerConfigInfo;

    }


}
