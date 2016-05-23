package com.shufensoft.crm.biz.service.hongbao.helper;

import com.shufensoft.crm.biz.cache.RedisCache;
import com.shufensoft.crm.biz.domain.defined.pointMall.GoodsSkuExchangeInfoDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.service.pointmall.face.MallGoodsService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.apache.http.util.Asserts;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     积分兑换商品
 * </p>
 *  @author: lin
 *  @date: 2015/7/7  
 */
public class PointExchangeGoodsHelper {

    public final static String  STOCK_SIZE  = "stockSize";     //库存数量KEY前缀

    private static MallGoodsService mallGoodsService;

    static{
        mallGoodsService = (MallGoodsService)SpringContextUtil.getBean("mallGoodsService");
    }

    /**
     * 根据SKU库存数量判断是否已经兑换完
     *  @return true 表示没有兑换完, false 已经兑换完
     * */

     public boolean isExchangedSku(Long sellerId, Long skuId){

         AssertsUtil.notNull(sellerId,"sellerId is null");
         Asserts.notNull(skuId, "skuId is null");

         String stockSizeStr = null;
         Object object = RedisCache.get(STOCK_SIZE + "_" + skuId);
         if(object == null){
             GoodsSkuExchangeInfoDo goodsSkuExchangeInfoDo = mallGoodsService.findGoodsSkuExchangeInfoDoBySkuId(sellerId,skuId);
             Long size = goodsSkuExchangeInfoDo.getStockSize();
             RedisCache.put(STOCK_SIZE + "_" + skuId, size);
             stockSizeStr = String.valueOf(RedisCache.get(STOCK_SIZE + "_" + skuId));
         }else{
             stockSizeStr = String.valueOf(object);
         }
         Long stockSize = Long.parseLong(stockSizeStr);
         if(stockSize > 0){
             RedisCache.put(STOCK_SIZE + "_" + skuId, stockSize - 1);
             return true;
         }
         return false;
    }


    /**
     * 根据Goods库存数量判断是否已经兑换完
     *  @return true 表示没有兑换完, false 已经兑换完
     * */

    public boolean isExchangedGoods(Long sellerId, Long goodsId){

        AssertsUtil.notNull(sellerId,"sellerId is null");
        Asserts.notNull(goodsId, "skuId is null");

        String stockSizeStr = null;
        Object object = RedisCache.get(STOCK_SIZE + "_" + goodsId);
        if(object == null){
            MallGoods mallGoods = mallGoodsService.findMallGoodsBySellerAndGoodsId(sellerId,goodsId);
            Long size = mallGoods.getQuantity();
            RedisCache.put(STOCK_SIZE + "_" + goodsId, size);
            stockSizeStr = String.valueOf(RedisCache.get(STOCK_SIZE + "_" + goodsId));
        }else{
            stockSizeStr = String.valueOf(object);
        }
        Long stockSize = Long.parseLong(stockSizeStr);
        if(stockSize > 0){
            RedisCache.put(STOCK_SIZE + "_" + goodsId, stockSize - 1);
            return true;
        }
        return false;
    }

}
