package com.shufensoft.crm.biz.service.trade.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.adapter.PolySpireAdapter;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.trade.OrderTaoBaoDAO;
import com.shufensoft.crm.biz.dao.generation.comment.CommentTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTaoBaoMapper;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBao;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBaoExample;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBao;
import com.shufensoft.crm.biz.domain.generation.user.UserTaoBaoExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.vo.OrderTaoBaoVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 淘宝交易服务类
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
@Service(value = "taoBaoTradeService")
public class TaoBaoTradeServiceImpl implements TaoBaoTradeService {

    @Autowired
    private TradeTaoBaoMapper tradeTaoBaoMapper;

    @Autowired
    private OrderTaoBaoMapper orderTaoBaoMapper;

    @Autowired
    private UserTaoBaoMapper userTaoBaoMapper;

    @Autowired
    private ReceiverTaoBaoMapper receiverTaoBaoMapper;

    @Autowired
    private OrderTaoBaoDAO orderTaoBaoDAO;

    @Autowired
    private CommentTaoBaoMapper commentTaoBaoMapper;

    @Autowired
    private IPointService pointService;

    private static PolySpireAdapter polySpireAdapter = new PolySpireAdapter();

    /**
     * 交易数据处理，保存
     *
     * @param tradeTaoBao
     * @return
     */
    @Override
    @Transactional
    public boolean saveOrUpdateTrade(TradeTaoBao tradeTaoBao) {

        if (tradeTaoBao == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTrade", "tradeTaoBao is null");
        }

        List<OrderTaoBao> orders = tradeTaoBao.getOrders();
        if (CollectionUtils.isEmpty(orders)) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTrade", "orders is null");
        }

        try {

            /**
             * 1.从交易中挖掘用户数据
             */
            UserTaoBao userTaoBao = new UserTaoBao();
            userTaoBao.setAlipayId(tradeTaoBao.getAlipayId());
            userTaoBao.setSellerId(tradeTaoBao.getSellerId());
            userTaoBao.setShopId(tradeTaoBao.getShopId());
            userTaoBao.setBuyerAlipayNo(tradeTaoBao.getBuyerAlipayNo());
            userTaoBao.setBuyerNick(tradeTaoBao.getBuyerNick());
            userTaoBao.setAreaId(tradeTaoBao.getAreaId());
            userTaoBao.setBuyerArea(tradeTaoBao.getBuyerArea());
            userTaoBao.setBuyerEmail(tradeTaoBao.getBuyerEmail());
            saveOrUpdateTaoBaoUser(userTaoBao);

            /**
             * 2.从交易中挖掘收件人信息
             */
            ReceiverTaoBao receiverTaoBao = new ReceiverTaoBao();
            receiverTaoBao.setSellerId(tradeTaoBao.getSellerId());
            receiverTaoBao.setReceiverName(tradeTaoBao.getReceiverName());
            receiverTaoBao.setReceiverCity(tradeTaoBao.getReceiverCity());
            receiverTaoBao.setReceiverDistrict(tradeTaoBao.getReceiverDistrict());
            receiverTaoBao.setReceiverAddress(tradeTaoBao.getReceiverAddress());
            receiverTaoBao.setReceiverMobile(tradeTaoBao.getReceiverMobile());
            receiverTaoBao.setReceiverPhone(tradeTaoBao.getReceiverPhone());
            receiverTaoBao.setReceiverState(tradeTaoBao.getReceiverState());
            receiverTaoBao.setReceiverZip(tradeTaoBao.getReceiverZip());
            receiverTaoBao.setUserIdTb(userTaoBao.getUserIdTb());
            receiverTaoBao.setCreated(tradeTaoBao.getCreated());
            saveOrUpdateTaoBaoReceiver(receiverTaoBao);

            /**
             * 3.保存或更新交易信息
             */
            tradeTaoBao.setUserIdTb(userTaoBao.getUserIdTb());
            tradeTaoBao.setReceiverIdTb(receiverTaoBao.getReceiverIdTb());
            String numIid = "";
            int num = 0;
            int categoryNum = 0;
            for (OrderTaoBao orderTaoBao : orders) {
                if (orderTaoBao.getNumIid() != null) {
                    numIid = numIid + orderTaoBao.getNumIid() + ",";
                    num = num + orderTaoBao.getNum();
                }

                categoryNum++;
            }
            if (StringUtils.isNotBlank(numIid) && numIid.endsWith(",")) {
                numIid = numIid.substring(0, numIid.length() - 2);
                tradeTaoBao.setNumIid(numIid);
                tradeTaoBao.setNum(num);
            }
            tradeTaoBao.setGoodsCategoryNum(categoryNum);
            if (StringUtils.isBlank(tradeTaoBao.getIsExcelImport())) {
                tradeTaoBao.setIsExcelImport("false");
            }

            Long tid = tradeTaoBao.getTid();
            TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
            tradeTaoBaoExample.createCriteria().andTidEqualTo(tid);
            List<TradeTaoBao> tradeTaoBaos = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);
            if (CollectionUtils.isEmpty(tradeTaoBaos)) {
                tradeTaoBaoMapper.insert(tradeTaoBao);
            } else {
                tradeTaoBaoMapper.updateByExampleSelective(tradeTaoBao, tradeTaoBaoExample);
            }

            saveOrUpdateOrder(tradeTaoBao.getSellerId(), tradeTaoBao.getShopId(), tradeTaoBao);

        } catch (Exception e) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTradeList", "[tradeId=" + tradeTaoBao.getId() + "];" + e.getMessage(), e);
        }

        return true;

    }

    @Override
    public boolean saveOrUpdateTradeList(Long sellerId, Long shopId, List<TradeTaoBao> tradeTaoBaoList) {

        if (CollectionUtils.isEmpty(tradeTaoBaoList)) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTradeList", "tradeTaoBaoList is null");
        }

        for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
            tradeTaoBao.setSellerId(sellerId);
            tradeTaoBao.setShopId(shopId);
            saveOrUpdateTrade(tradeTaoBao);
        }

        return true;
    }

    @Override
    public List<TradeTaoBao> getTradeFromPolySpireByDate(String polySpireUrl, Date startDate, Date endDate, int start, int pageSize) {
        return polySpireAdapter.syncTradeByDate(polySpireUrl, startDate, endDate, start, pageSize);
    }

    @Override
    public List<TradeTaoBao> findTradeByDate(Long sellerId, Long shopId, Date startDate, Date endDate, int start, int pageSize) {

        PageHelper.startPage(start, pageSize);
        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        tradeTaoBaoExample.createCriteria().andGmtModifiedBetween(startDate, endDate)
                .andSellerIdEqualTo(sellerId).andShopIdEqualTo(shopId);

        return tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

    }

    @Override
    public List<OrderTaoBaoDO> selectOrderTaoBaoWithComment(OrderTaoBaoDO orderTaoBaoDO) {
        if (orderTaoBaoDO == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.selectOrderTaoBaoWithComment", "orderTaoBaoDO or UserIdTb is null");
        }
        return orderTaoBaoDAO.selectOrderTaoBaoWithComment(orderTaoBaoDO);
    }

    @Override
    public List<OrderTaoBaoDO> selectOrderTaoBaoWithCommentAndUser(OrderTaoBaoDO orderTaoBaoDO) {
        if (orderTaoBaoDO == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.selectOrderTaoBaoWithCommentAndUser", "orderTaoBaoDO or UserIdTb is null");
        }
        return orderTaoBaoDAO.selectOrderTaoBaoWithCommentAndUser(orderTaoBaoDO);
    }

    /**
     * 保存或更新user
     *
     * @param userTaoBao
     */
    private void saveOrUpdateTaoBaoUser(UserTaoBao userTaoBao) {

        if (userTaoBao == null || StringUtils.isBlank(userTaoBao.getBuyerNick())) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTaoBaoUser", "userTaoBao or buyerNick is null");
        }
        String buyerNick = userTaoBao.getBuyerNick();
        UserTaoBaoExample userBaoExample = new UserTaoBaoExample();
        userBaoExample.createCriteria().andSellerIdEqualTo(userTaoBao.getSellerId()).andShopIdEqualTo(userTaoBao.getShopId())
                .andBuyerNickEqualTo(buyerNick);
        List<UserTaoBao> userTaoBaos = userTaoBaoMapper.selectByExample(userBaoExample);

        if (CollectionUtils.isEmpty(userTaoBaos)) {
            userTaoBaoMapper.insert(userTaoBao);
        } else {
            userTaoBao.setId(userTaoBaos.get(0).getId());
            userTaoBaoMapper.updateByPrimaryKeySelective(userTaoBao);
            userTaoBao.setUserIdTb(userTaoBaos.get(0).getUserIdTb());
        }

    }

    /**
     * 保存或更新Receiver
     *
     * @param receiverTaoBao
     */
    private void saveOrUpdateTaoBaoReceiver(ReceiverTaoBao receiverTaoBao) {

        if (receiverTaoBao == null || StringUtils.isBlank(receiverTaoBao.getReceiverName())) {
            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateTaoBaoReceiver",
                    "receiverTaoBao or receiverName is null");
        }

        String receiverName = receiverTaoBao.getReceiverName();
        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        ReceiverTaoBaoExample.Criteria criteria = receiverTaoBaoExample.createCriteria().andSellerIdEqualTo(receiverTaoBao.getSellerId())
                .andReceiverNameEqualTo(receiverName);


        Long userIdTb = receiverTaoBao.getUserIdTb();
        if (userIdTb != null && userIdTb != 0) {
            criteria.andUserIdTbEqualTo(userIdTb);
        }

        String receiverMobile = receiverTaoBao.getReceiverMobile();
        if (StringUtils.isNotBlank(receiverMobile)) {
            criteria.andReceiverMobileEqualTo(receiverTaoBao.getReceiverMobile());
        }

        String receiverPhone = receiverTaoBao.getReceiverPhone();
        if (StringUtils.isNotBlank(receiverPhone)) {
            criteria.andReceiverPhoneEqualTo(receiverTaoBao.getReceiverPhone());
        }

        String receiverAddress = receiverTaoBao.getReceiverAddress();
        if (StringUtils.isNotBlank(receiverAddress)) {
            criteria.andReceiverAddressEqualTo(receiverTaoBao.getReceiverAddress());
        }

        List<ReceiverTaoBao> receiverTaoBaos = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);

        if (CollectionUtils.isEmpty(receiverTaoBaos)) {
            receiverTaoBaoMapper.insert(receiverTaoBao);
        } else {
            receiverTaoBao.setId(receiverTaoBaos.get(0).getId());
            receiverTaoBaoMapper.updateByPrimaryKeySelective(receiverTaoBao);
            receiverTaoBao.setReceiverIdTb(receiverTaoBaos.get(0).getReceiverIdTb());
        }

    }

    /**
     * 更新或保存orders
     *
     * @param tradeTaoBao
     */
    public void saveOrUpdateOrder(Long sellerId, Long shopId, TradeTaoBao tradeTaoBao) {

        if (tradeTaoBao == null || CollectionUtils.isEmpty(tradeTaoBao.getOrders())) {

            throw new ServiceException("TaoBaoTradeServiceImpl.saveOrUpdateOrder", "tradeTaoBao or orders is null");
        }

        for (OrderTaoBao order : tradeTaoBao.getOrders()) {
            order.setBuyerNick(tradeTaoBao.getBuyerNick());
            order.setSellerNick(tradeTaoBao.getSellerNick());
            order.setTid(tradeTaoBao.getTid());
            order.setModified(tradeTaoBao.getModified());
            order.setUserIdTb(tradeTaoBao.getUserIdTb());
            order.setSellerId(sellerId);
            order.setShopId(shopId);
            OrderTaoBaoExample orderTaoBaoExample = new OrderTaoBaoExample();
            orderTaoBaoExample.createCriteria().andTidEqualTo(tradeTaoBao.getTid()).andOidEqualTo(order.getOid());
            List<OrderTaoBao> orderTaoBaos = orderTaoBaoMapper.selectByExample(orderTaoBaoExample);

            if (CollectionUtils.isEmpty(orderTaoBaos)) {

                orderTaoBaoMapper.insert(order);

            } else {

                order.setId(orderTaoBaos.get(0).getId());
                orderTaoBaoMapper.updateByPrimaryKeySelective(order);

            }

            /**
             * 更新userIdTb到commentTaoBao
             */
            CommentTaoBaoExample commentTaoBaoExample = new CommentTaoBaoExample();
            commentTaoBaoExample.createCriteria().andOidEqualTo(order.getOid()).andTidEqualTo(order.getTid());
            List<CommentTaoBao> commentTaoBaos = commentTaoBaoMapper.selectByExample(commentTaoBaoExample);
            if (!CollectionUtils.isEmpty(commentTaoBaos)) {
                CommentTaoBao commentTaoBao = new CommentTaoBao();
                commentTaoBao.setUserIdTb(order.getUserIdTb());
                commentTaoBao.setId(commentTaoBaos.get(0).getId());
                commentTaoBaoMapper.updateByPrimaryKeySelective(commentTaoBao);
            }

        }


    }

    /**
     * 根据开始和结束时间查询状态完成的订单信息
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    @Override
    public PageInfo selectTaobaoTradeListByDate(Date startDate, Date endDate, Integer start, Integer pageSize) {
        AssertsUtil.notNull(startDate, "startDate");
        AssertsUtil.notNull(startDate, "endDate");

        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        TradeTaoBaoExample.Criteria criteria = tradeTaoBaoExample.createCriteria();
        criteria.andModifiedBetween(startDate, endDate);
        criteria.andStatusEqualTo("TRADE_FINISHED");

        PageHelper.startPage(start, pageSize);

        List<TradeTaoBao> tradeTaoBaoList = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

        return new PageInfo(tradeTaoBaoList);
    }


    @Override
    public OrderTaoBao selectOrderTaoBaoByOid(Long oid) {

        if (oid == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.selectOrderTaoBaoByOid", "oid is null");
        }

        OrderTaoBaoExample orderTaoBaoExample = new OrderTaoBaoExample();
        orderTaoBaoExample.createCriteria().andOidEqualTo(oid);
        List<OrderTaoBao> orders = orderTaoBaoMapper.selectByExample(orderTaoBaoExample);

        if (CollectionUtils.isEmpty(orders)) {
            return null;
        }

        return orders.get(0);

    }

    @Override
    public TradeTaoBao selectTradeTaoBaoByTid(Long tid) {

        if (tid == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.selectTradeTaoBaoByTid", "tid is null");
        }

        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        tradeTaoBaoExample.createCriteria().andTidEqualTo(tid);
        List<TradeTaoBao> trades = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

        if (CollectionUtils.isEmpty(trades)) {
            return null;
        }

        return trades.get(0);
    }

    @Override
    public List<OrderTaoBao> selectOrderTaoBaosByTid(Long tid) {
        if (tid == null) {
            throw new ServiceException("TaoBaoTradeServiceImpl.selectOrderTaoBaosByTid", "tid is null");
        }

        OrderTaoBaoExample orderTaoBaoExample = new OrderTaoBaoExample();
        orderTaoBaoExample.createCriteria().andTidEqualTo(tid);
        List<OrderTaoBao> orders = orderTaoBaoMapper.selectByExample(orderTaoBaoExample);

        if (CollectionUtils.isEmpty(orders)) {
            return null;
        }

        return orders;
    }

    @Override
    public int countOrderTaoBao(OrderTaoBaoVO orderTaoBaoVO) {
        OrderTaoBaoExample orderTaoBaoExample = new OrderTaoBaoExample();
        OrderTaoBaoExample.Criteria criteria = orderTaoBaoExample.createCriteria();
        if (orderTaoBaoVO.getStartDate() != null) {
            criteria.andEndTimeGreaterThanOrEqualTo(orderTaoBaoVO.getStartDate());
        }
        if (orderTaoBaoVO.getEndDate() != null) {
            criteria.andEndTimeLessThanOrEqualTo(orderTaoBaoVO.getEndDate());
        }
        if (orderTaoBaoVO.getUserIdTb() != null) {
            criteria.andUserIdTbEqualTo(orderTaoBaoVO.getUserIdTb());
        }
        if (orderTaoBaoVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(orderTaoBaoVO.getSellerId());
        }
        return orderTaoBaoMapper.countByExample(orderTaoBaoExample);
    }

    @Override
    public int countCommnetTaoBao(CommentTaoBaoVO commentTaoBaoVO) {
        CommentTaoBaoExample commentTaoBaoExample = new CommentTaoBaoExample();
        CommentTaoBaoExample.Criteria criteria = commentTaoBaoExample.createCriteria();
        if (commentTaoBaoVO.getUserIdTb() != null) {
            criteria.andUserIdTbEqualTo(commentTaoBaoVO.getUserIdTb());
        }
        if (commentTaoBaoVO.getStartDate() != null) {
            criteria.andGmtModifiedGreaterThanOrEqualTo(commentTaoBaoVO.getStartDate());
        }
        if (commentTaoBaoVO.getEndDate() != null) {
            criteria.andGmtModifiedLessThanOrEqualTo(commentTaoBaoVO.getEndDate());
        }
        if (StringUtils.isNotBlank(commentTaoBaoVO.getResult())) {
            criteria.andResultEqualTo(commentTaoBaoVO.getResult());
        }
        if (commentTaoBaoVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(commentTaoBaoVO.getSellerId());
        }
        return commentTaoBaoMapper.countByExample(commentTaoBaoExample);
    }


    /**
     * 根据淘宝用户ID查询用户所有完成交易信息
     *
     * @param sellerId 商户ID
     * @param userIdTb 淘宝用户ID
     * @return
     */
    public List<TradeTaoBao> getTaobaoTradeListByUserTbId(Long sellerId, Long userIdTb) {

        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        TradeTaoBaoExample.Criteria criteria = tradeTaoBaoExample.createCriteria();

        criteria.andUserIdTbEqualTo(userIdTb);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andModifiedBetween(DateUtil.getExpiredDay(-365), new Date());
        criteria.andStatusEqualTo("TRADE_FINISHED");

        List<TradeTaoBao> tradeTaoBaoList = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

        if (CollectionUtils.isEmpty(tradeTaoBaoList)) {
            return null;
        }

        return tradeTaoBaoList;

    }

    /**
     * 根据淘宝用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdTb 用户淘宝ID
     */
    public void createTaobaoBuyPointByUserIdTb(Long sellerId, Long userIdTb) {

        List<TradeTaoBao> tradeTaoBaoList = getTaobaoTradeListByUserTbId(sellerId, userIdTb);

        if (CollectionUtils.isEmpty(tradeTaoBaoList)) {
            return;
        }

        for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {

            pointService.tradeToCreateBuyPoint(sellerId, userIdTb, DaoConstant.UserSource.TB, tradeTaoBao.getPayment().longValue(), tradeTaoBao.getTid());

        }
    }
}
