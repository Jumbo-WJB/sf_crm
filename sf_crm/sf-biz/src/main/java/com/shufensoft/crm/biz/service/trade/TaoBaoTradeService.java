package com.shufensoft.crm.biz.service.trade;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import com.shufensoft.crm.biz.vo.OrderTaoBaoVO;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
public interface TaoBaoTradeService {

    /**
     * 保存或更新交易信息
     *
     * @param tradeTaoBao
     * @return
     */
    public boolean saveOrUpdateTrade(TradeTaoBao tradeTaoBao);

    /**
     * 保存或更新交易列表
     *
     * @param tradeTaoBaoList
     * @return
     */
    public boolean saveOrUpdateTradeList(Long sellerId, Long shopId, List<TradeTaoBao> tradeTaoBaoList);


    /**
     * 获取从聚石塔获取交易信息
     *
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     */
    public List<TradeTaoBao> getTradeFromPolySpireByDate(String polySpireUrl, Date startDate, Date endDate, int start, int pageSize);

    /**
     * 根据时间获取交易信息
     *
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     */
    public List<TradeTaoBao> findTradeByDate(Long sellerId, Long shopId, Date startDate, Date endDate, int start, int pageSize);


    /**
     * 通过评价相关信息获取淘宝订单数据
     *
     * @param orderTaoBaoDO
     * @return
     */
    public List<OrderTaoBaoDO> selectOrderTaoBaoWithComment(OrderTaoBaoDO orderTaoBaoDO);

    /**
     * 通过评价相关和用户信息获取淘宝订单数据
     *
     * @param orderTaoBaoDO
     * @return
     */
    public List<OrderTaoBaoDO> selectOrderTaoBaoWithCommentAndUser(OrderTaoBaoDO orderTaoBaoDO);


    /**
     * 通过oid获取淘宝订单数据
     *
     * @param oid
     * @return
     */
    public OrderTaoBao selectOrderTaoBaoByOid(Long oid);

    /**
     * 通过tid获取淘宝交易数据
     *
     * @param tid
     * @return
     */
    public TradeTaoBao selectTradeTaoBaoByTid(Long tid);

    /**
     * 通过tid获取淘宝订单数据
     *
     * @param tid
     * @return
     */
    public List<OrderTaoBao> selectOrderTaoBaosByTid(Long tid);

    /**
     * 根据查询条件获取淘宝订单条数
     *
     * @param orderTaoBaoVO
     * @return
     */
    public int countOrderTaoBao(OrderTaoBaoVO orderTaoBaoVO);

    /**
     * 根据查询条件获取淘宝评价条数
     *
     * @param commentTaoBaoVO
     * @return
     */
    public int countCommnetTaoBao(CommentTaoBaoVO commentTaoBaoVO);


    /**
     * 根据开始和结束时间查询状态完成的订单信息
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public PageInfo selectTaobaoTradeListByDate(Date startDate, Date endDate, Integer start, Integer pageSize);


    /**
     * 根据淘宝用户ID查询用户所有完成交易信息
     *
     * @param sellerId 商户ID
     * @param userIdTb 淘宝用户ID
     * @return
     */
    public List<TradeTaoBao> getTaobaoTradeListByUserTbId(Long sellerId, Long userIdTb);


    /**
     * 根据淘宝用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdTb 用户淘宝ID
     */
    public void createTaobaoBuyPointByUserIdTb(Long sellerId, Long userIdTb);
}
