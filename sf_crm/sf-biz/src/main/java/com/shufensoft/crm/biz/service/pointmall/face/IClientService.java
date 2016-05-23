package com.shufensoft.crm.biz.service.pointmall.face;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.point.PointDetailDO;
import com.shufensoft.crm.biz.domain.defined.pointMall.*;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiver;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/3  
 */

public interface IClientService {

    public UserAccount findUserAccountBySellerIdAndUserId(Long sellerId,Long userId);

    public PageInfo findGoodsPointExchangeByPage(Long sellerId, Long userId, Integer start, Integer length);

    public List<PointExchange> getAllGoodsPointExchange(Long sellerId, Long userId);

    public List<PointExchangeRankDo> getPointExchangeRankDo(Map<String,Object> params);

    public PageInfo getPointExchangeRankDoByPage(Map<String,Object> params, Integer start, Integer length);

    public PageInfo getPointExchangeRealTimeInfo(Long sellerId, Integer start, Integer length);

    /**
     * sku的维度统计被兑换人数
     * */
    public List<GoodsSkuExchangeInfoDo> findAllGoodsSkuExchangeInfoDo(Long sellerId);

    public int dianzan(Long buid, Long uid,String interactionEntry);

    /**
     *  查找某个用户的积分兑换的明细, 包括商品和红包
     * */
    public List<PointExchangeDetailDo> findPointExchangeDetail(Long sellerId, Long userId);

    /**
     * 查找某个用户的积分账户信息, 包括积分兑换红包, 商品分别消耗的积分
     * */
    public UserAccountStaticsDo findUserAccountDoByUserIdAndSellerId(Long sellerId, Long userId);

    /**
     * 查找某个用户的积分排名
     * */
    public UserAccountStaticsDo findUserAccountDoRankByUserId(Long sellerId, Long userId);

    /**
     *  查找某个商家总发放积分, 和总参与人数
     * */
    public PointObtainStaticsDo findPointObtainStaticsBySellerId(Long sellerId);


    /**
     * 查询某个用户获取积分明细
     * */
    public List<PointDetailDO> findPointDetailDos(Long sellerId, Long userId);

    /**
     * 查找某个用户的默认收件人
     * */
    public MallReceiver findMallReceiverByUserId(Long sellerId, Long userId);

    /**
     * 积分兑换商品的处理
     * */
    public int handleExchange(Long sellerId, Long userId, Long goodsId, Long skuId, Long receiverId, Integer amount,String source) throws RuntimeException;

    /**
     * 查找某个用户的所有收件人信息
     * */
    public List<MallReceiver> findMallReceiversByUserId(Long sellerId, Long userId);

    /**
     * 处理新收件人信息的添加
     * */
    public Long handleAddAddress(Long sellerId, Long userId, MallReceiver mallReceiver);
    /**
     * goods维度统计被兑换人数
     * */
    public List<GoodsSkuExchangeInfoDo> findAllGoodsExchangeInfoDo(Long sellerId);

    /**
     * 积分兑换成功后更新userAccount表
     * @param payPoint 消耗的积分
     * */
    public int updateAfterExchangeSuccess(Long sellerId, Long userId, Long payPoint);

    /**
     * 积分兑换红包成功后的操作
     * 1. 更新pointExchange状态
     * 2. 更新userAccount
     * */
    public int updateAfterPointExchangeHongBaoSuccess(Long sellerId,Long userId, Long exchangeId, String status);



}
