package com.shufensoft.crm.biz.service.trade;


import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.vo.CommentJDVO;
import com.shufensoft.crm.biz.vo.OrderJDVO;

import java.util.Date;
import java.util.List;

/**
 * Created by lin on 2015/6/10.
 */
public interface JdTradeService {

    /**
     * 插入或更新京东订单原始数据
     *
     * @param order
     */
    public boolean saveOrUpdateTrade(OrderJD order);

    /**
     * 保存或更新京东订单列表
     */
    public boolean saveOrUpdateTrades(Long sellerId, Long shopId, List<OrderJD> orders);

    /**
     * 获取京东订单数据
     */
    public List<OrderJD> getOrderJDByAppKeyAndDate(String appKey, String appSecret, String accessToken, Date startDate, Date endDate, int page, int pageSize);


    /**
     * 通过评价相关信息获取京东订单数据
     *
     * @param orderJdDO
     * @return
     */
    List<OrderJDDO> selectOrderJDWithComment(OrderJDDO orderJdDO);

    /**
     * 通过评价用户相关信息获取京东订单数据
     *
     * @param orderJdDO
     * @return
     */
    List<OrderJDDO> selectOrderJDWithCommentAndUser(OrderJDDO orderJdDO);

    /**
     * 根据查询条件获取京东订单条数
     *
     * @param orderJDVO
     * @return
     */
    public int countOrderJD(OrderJDVO orderJDVO);

    /**
     * 根据查询条件获取京东评价条数
     *
     * @param commentJDVO
     * @return
     */
    public int countCommnetJD(CommentJDVO commentJDVO);

    /**
     * 获取未评价订单
     *
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     * @author litu   litu@suniusoft.com
     * @date 2015/7/13
     */
    public List<OrderJD> queryUnCommentOrderJDs(Date startDate, Date endDate, int start, int pageSize);

    /**
     * 拉取批量评价信息并且处理
     *
     * @param orderJDs
     * @return
     * @author litu   litu@suniusoft.com
     * @date 2015/7/13
     */
    public boolean pullCommentJDAndHandle(SellerShop sellerShop, List<OrderJD> orderJDs);

    /**
     * 拉取批量评价信息并且处理
     *
     * @param sellerShop
     * @param waybillCode
     * @return
     * @author litu   litu@suniusoft.com
     * @date 2015/7/13
     */
    public ExpressDetailVO queryEtmsTrace(SellerShop sellerShop, String waybillCode);

    /**
     * 拉取单个评价信息并且处理
     *
     * @param orderJD
     * @return
     * @author litu   litu@suniusoft.com
     * @date 2015/7/13
     */
    public boolean pullCommentJDAndHandle(SellerShop sellerShop, OrderJD orderJD);

    /**
     * 查找根据时间订单
     *
     * @param sellerId
     * @param shopId
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     */
    public List<OrderJD> findOrdersByDate(Long sellerId, Long shopId, Date startDate, Date endDate, int start, int pageSize);


    /**
     * 根据开始和结束时间查询状态完成的订单信
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public PageInfo selectJdOrderListByDate(Date startDate, Date endDate, Integer start, Integer pageSize);

    /**
     * 根据京东用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdJd 用户淘宝ID
     */
    public void createJdBuyPointByUserIdTb(Long sellerId, Long userIdJd);
}
