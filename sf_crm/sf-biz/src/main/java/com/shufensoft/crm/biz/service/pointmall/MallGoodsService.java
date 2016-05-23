package com.shufensoft.crm.biz.service.pointmall;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.pointMall.GoodsSkuExchangeInfoDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsSku;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsVo;

import java.util.List;

/**
 *  积分商城 商品处理
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-23 19:55  
 */
public interface MallGoodsService {


    /**
     * 新建商品（含多SKU的情况）
     *
     * @param sellerId
     * @param goodsVo
     * @return 插入的记录条数
     */
    public int create(Long sellerId, GoodsVo goodsVo);

    /**
     * 商品更新
     *
     * @param goodsVo
     * @return
     */
    public int updateGoods(GoodsVo goodsVo) ;

    public int updateGoodsSku(GoodsVo goodsVo) ;

    public int delete(long sellerId, long goodsId) ;

    /**
     * 分页查询商品
     *
     * @param sellerId
     * @param start
     * @param pageSize
     * @return
     */
    public List<MallGoods> queryGoods(long sellerId, int start, int pageSize) ;

    /**
     * 查询某商品的SKU
     *
     * @param sellerId
     * @param goodsId
     * @return
     */
    public List<MallGoodsSku> queryGoodsSku(long sellerId, long goodsId) ;

    /**
     * 商品上架
     *
     * @param sellerId
     * @param goodsId
     * @return 变更记录数
     */
    public int list(long sellerId, long goodsId) ;

    /**
     * 商品下架
     *
     * @param sellerId
     * @param goodsId
     * @return
     */
    public int delist(long sellerId, long goodsId) ;

    /**
     *  分页查询积分兑换商品 by sellerId
     * */
    public PageInfo findGoodsBySellerIdAndPage(Long sellerId, Integer start, Integer length);

    /**
     * 根据id查询一个商品
     * */
    public MallGoods getMallGoodsById(Long id);

    /**
     *  更新 goodsSku , 编辑商品的时候用到
     * */
    public String updateSku(GoodsVo goodsVo);

    /**
     * 根据skuId 查询一个商品,
     * */
    public GoodsSkuExchangeInfoDo findGoodsSkuExchangeInfoDoBySkuId(Long sellerId, Long skuId);

    public MallGoods findMallGoodsBySellerAndGoodsId(Long sellerId, Long goodsId);


}
