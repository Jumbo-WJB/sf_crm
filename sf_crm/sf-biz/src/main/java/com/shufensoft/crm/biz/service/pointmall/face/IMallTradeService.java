package com.shufensoft.crm.biz.service.pointmall.face;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallFansDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallOrderDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallTradeDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallTrade;
import com.shufensoft.crm.biz.service.pointmall.vo.OrderVo;
import com.shufensoft.crm.biz.service.pointmall.vo.ShippingVo;
import com.shufensoft.crm.biz.service.pointmall.vo.TradeVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-07 15:21  
 */
public interface IMallTradeService {

    public boolean pay(long sellerId, long userId, long tid);

    public boolean create(TradeVo tradeVo);

    public boolean update(MallTrade trade);

    public boolean consign(long sellerId, long userId, long tid, ShippingVo shippingVo);

    public boolean confirm(long sellerId, long userId, long tid);

    public List<TradeVo> query(Long sellerId, Long userId, int start, int pageSize);

    public PageInfo findAllMallTradeByPage(Long sellerId, Integer start, Integer length);

    public List<OrderVo> findAllMallOrderCasecadeMallTradeByPage(Long sellerId);

    public List<OrderVo> findMallOrderByStatus(Long sellerId, Integer type);

    public PageInfo findMallOrderDaosByPage(Long sellerId, Integer type, Integer pageNum, Integer length);

    public MallTradeDo findMallTradeDoCasecadeGoods(Long tid);

    public PageInfo findMallFansDosByPage(Long sellerId, String status, String wxNickName, Date startDate, Date endDate, Integer start, Integer length);

    public List<MallFansDo> findMallFansDos(Long sellerId, String status, String wxNickName, Date startDate, Date endDate);

    public MallTrade findMallTradeByTid(Long sellerId, Long tid);

    public boolean handleSingleMallTradeReceive(Long id, ShippingVo svo, Long sellerId);

    public boolean handleMultipleMallTradeReceive(Map<Long, ShippingVo> params, Long sellerId);

    public List<MallOrderDo> findMallOrderDaos(Long sellerId, Integer type);

}
