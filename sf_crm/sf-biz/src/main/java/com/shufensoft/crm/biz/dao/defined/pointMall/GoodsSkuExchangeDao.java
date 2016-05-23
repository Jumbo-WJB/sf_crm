package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.GoodsSkuExchangeInfoDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/5  
 */
@Repository
public interface GoodsSkuExchangeDao {

    /**
     *  按照 sku 查询被兑换的人数
     * */
    public List<GoodsSkuExchangeInfoDo> findGoodsSkuExchangeInfosBySellerId(Long sellerId);

    /**
     *  按照 goods 的维度统计被兑换的人数
     * */
    public List<GoodsSkuExchangeInfoDo> findGoodsExchangePersonNum(Long sellerId);

    /**
     * 根据sku查询 sku信息.
     * */
    public GoodsSkuExchangeInfoDo findGoodsSkuExchangeInfoDoBySkuId(Map<String,Object> params);


}
