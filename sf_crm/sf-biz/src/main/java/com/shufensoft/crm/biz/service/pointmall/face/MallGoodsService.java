package com.shufensoft.crm.biz.service.pointmall.face;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.pointMall.GoodsSkuExchangeInfoDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallGoodsDo;
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
    public List<MallGoodsSku> queryGoodsSku(long sellerId, long goodsId);

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

    /**
     * 查询商户积分兑换商品, 满足条件, 1, 库存量要大于0; 2, 排除礼物类目,3, 在售, 4, 没有删除
     * */
     public PageInfo findExangeGoods(Long sellerId, Integer start, Integer length);
    /**
     * 根据goodsId查询一个商品, 并且查出包含的所有sku
     * */
    public GoodsVo findGoodsCascadeSkuByGoodsId(Long sellerId, Long goodsId);

    /**
     * 根据goodsId查询一个商品, 不包含sku
     * */
    public GoodsVo findGoodsByGoodsId(Long sellerId, Long goodsId);

    /**
     * 根据skuId查询一个sku
     * */
    public MallGoodsSku findMallGoodsSkuBySkuId(Long sellerId, Long goodsId, Long skuId);

    /**
     * 判断商品是否为礼物
     * */
    public boolean isGiftByGoodsId(Long sellerId, Long goodsId);

    /**
     *  通用的查询mallGoods方法
     *  目前mallGoodsDo可以set参数有
     *  sellerId
     *  isDeleted
     *  categoryName
     *  status    onsale, instock
     *  quantity  库存量
     *
     * */
    public PageInfo findMallGoodsByMallGoodsDoByPage(MallGoodsDo mallGoodsDo, Integer pageNum, Integer length);

    /**
     * 根据obtainId查询商户信息
     * @param sellerId 商户ID
     * @param obtainId 获取ID
     * @return
     */
    public MallGoods getMailGoodsByGoodsId(Long sellerId,Long obtainId);

}
