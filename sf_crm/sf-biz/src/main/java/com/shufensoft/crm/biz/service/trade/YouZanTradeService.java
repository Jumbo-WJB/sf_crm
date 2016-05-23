package com.shufensoft.crm.biz.service.trade;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.domain.generation.user.UserYZ;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 有赞服务类
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/6  
 */

public interface YouZanTradeService {

    /**
     * 保存或更新交易信息
     *
     * @param tradeYZ
     * @return
     */
    public boolean saveOrUpdateTrade(TradeYZ tradeYZ);

    /**
     * 保存或更新交易列表
     *
     * @param tradeYZList
     * @return
     */
    public boolean saveOrUpdateTradeList(List<TradeYZ> tradeYZList);

    /**
     * 根据weiXinUserId获取用户信息
     *
     * @param sellerShop
     * @param weiXinUserId
     * @return
     */
    public UserYZ queryYouZanUserByUserId(SellerShop sellerShop, Long weiXinUserId);


    /**
     * 快递查询
     *
     * @param sellerShop
     * @param tid
     * @return
     */
    public ExpressDetailVO queryYouZanLogisticsTrace(SellerShop sellerShop, String tid);


    /**
     * 获取从有赞获取交易信息
     *
     * @param sellerShop
     * @param pageNo
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTradeFromYouZanByDate(SellerShop sellerShop, Long pageNo, Date startDate, Date endDate);


    /**
     * 根据起始时间获取有赞交易
     *
     * @param sellerShop
     * @param start
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public List<TradeYZ> findTradeFromByDate(SellerShop sellerShop, int start, int pageSize, Date startDate, Date endDate);

    /**
     * 获取从有赞获取交易信息
     *
     * @param sellerShop
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean pullTradeFromYouZanByDate(SellerShop sellerShop, Long pageNo, Long pageSize, Date startDate, Date endDate);


    /**
     * 根据开始和结束时间查询状态完成的有赞订单信息
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public PageInfo selectYzTradeListByDate(Date startDate, Date endDate, Integer start, Integer pageSize);

    /**
     * 根据有赞用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdYz 用户有赞ID
     */
    public void createYzdBuyPointByUserIdYz(Long sellerId, Long userIdYz);
}
