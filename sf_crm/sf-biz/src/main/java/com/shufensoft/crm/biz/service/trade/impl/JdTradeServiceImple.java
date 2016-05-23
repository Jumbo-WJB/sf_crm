package com.shufensoft.crm.biz.service.trade.impl;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.adapter.JDAdapter;
import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.order.OrderJDDAO;
import com.shufensoft.crm.biz.dao.generation.comment.CommentJDMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverJDMapper;
import com.shufensoft.crm.biz.dao.generation.trade.ItemInfoJDMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderJDMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserJDMapper;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJDExample;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJDExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJD;
import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJDExample;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJDExample;
import com.shufensoft.crm.biz.domain.generation.user.UserJD;
import com.shufensoft.crm.biz.domain.generation.user.UserJDExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.TransitStepVO;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.vo.TraceApiDtoVO;
import com.shufensoft.crm.biz.vo.CommentJDVO;
import com.shufensoft.crm.biz.vo.OrderJDVO;
import com.shufensoft.crm.common.api.client.JDClient;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author lin  liulin@shufensoft.com
 *  @date 2015/6/8
 *
 * @modifer litu  litu@shufensoft.com  
 */
@Service(value = "jdTradeService")
public class JdTradeServiceImple implements JdTradeService {

    @Autowired
    private OrderJDMapper orderJDMapper;
    @Autowired
    private OrderJDDAO orderJDDAO;
    @Autowired
    private ReceiverJDMapper receiverJDMapper;
    @Autowired
    private ItemInfoJDMapper itemInfoJDMapper;
    @Autowired
    private UserJDMapper userJDMapper;

    @Autowired
    private CommentJDMapper commentJDMapper;

    @Autowired
    private IPointService pointService;


    private static JDAdapter jdAdapter = new JDAdapter();

    /**
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     * @modifer litu  litu@shufensoft.com  2015/7/10
     * 查找根据时间订单
     */
    @Override
    public List<OrderJD> findOrdersByDate(Long sellerId, Long shopId, Date startDate, Date endDate, int start, int pageSize) {

        PageHelper.startPage(start, pageSize);
        OrderJDExample orderJDExample = new OrderJDExample();
        orderJDExample.createCriteria().andGmtCreatedBetween(startDate, endDate)
                .andSellerIdEqualTo(sellerId).andShopIdEqualTo(shopId);
        return orderJDMapper.selectByExample(orderJDExample);
    }


    /**
     * 保存或更新京东订单原始数据
     *
     * @param order
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    @Override
    @Transactional
    public boolean saveOrUpdateTrade(OrderJD order) {

        if (order == null) {
            throw new ServiceException("JdTradeServiceImple.saveOrUpdateTrade", "orderJD is null");
        }

        if (order.getSellerId() == null) {
            throw new ServiceException("JdTradeServiceImple.saveOrUpdateTrade", "sellerId is null");
        }

        /**
         * 1. 从订单中挖掘用户信息
         * */
        UserJD userJD = new UserJD();
        userJD.setSellerId(order.getSellerId());
        userJD.setShopId(order.getShopId());
        userJD.setPin(order.getPin());
        saveOrUpdateUserJD(userJD); //更新或保存userJD
        /**
         * 2. 从订单中挖掘收件人信息
         * */
        ReceiverJD consigneeInfo = order.getReceiverJD();
        if (consigneeInfo != null) {
            consigneeInfo.setUserIdJd(userJD.getUserIdJd());
            consigneeInfo.setCreated(order.getOrderStartTime());
            consigneeInfo.setSellerId(order.getSellerId());
            saveOrUpdateReceiverJD(consigneeInfo);     //更新或保存receiveJD
            order.setReceiverIdJd(consigneeInfo.getReceiverIdJd());
        }

        order.setUserIdJd(userJD.getUserIdJd());
        order.setLogisticsName(getExpress(order.getLogisticsId()));
        String orderId = order.getOrderId();
        if (StringUtils.isBlank(order.getIsExcelImport())) {
            order.setIsExcelImport(DaoConstant.TrueOrFalse.FALSE);
        }
        OrderJDExample example = new OrderJDExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderJD> list = orderJDMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            order.setPullComment(false);
            orderJDMapper.insert(order);
        } else {
            order.setId(list.get(0).getId());
            orderJDMapper.updateByPrimaryKeySelective(order);
        }
        List<ItemInfoJD> items = order.getItemInfoJDList();
        saveOrUpdateItemInfoJDList(items, order);

        return true;
    }

    /**
     * 获取快递公司名称
     *
     * @param value
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    public String getExpress(String value) {

        if (StringUtils.isBlank(value)) {
            return null;
        }
        List<LstOfVal> lstOfVals = LstOfValCache.getTypeList("EXPRESS");
        if (CollectionUtils.isEmpty(lstOfVals)) {
            return null;
        }
        for (LstOfVal lstOfVal : lstOfVals) {
            if (value.equals(lstOfVal.getValue01())) {
                return lstOfVal.getName();
            }
        }
        return null;
    }

    /**
     * 保存或更新京东订单列表
     *
     * @param sellerId
     * @param shopId
     * @param orders
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    @Override
    @Transactional
    public boolean saveOrUpdateTrades(Long sellerId, Long shopId, List<OrderJD> orders) {

        for (OrderJD ojd : orders) {
            ojd.setSellerId(sellerId);
            ojd.setShopId(shopId);
            saveOrUpdateTrade(ojd);
        }
        return true;

    }

    /**
     * 获取京东订单数据
     *
     * @param appKey
     * @param startDate
     * @param endDate
     * @param page
     * @param pageSize
     */
    @Override
    public List<OrderJD> getOrderJDByAppKeyAndDate(String appKey, String appSecret, String accessToken, Date startDate, Date endDate, int page, int pageSize) {
        return jdAdapter.syncOrderByDateAndAppKey(appKey, appSecret, accessToken, startDate, endDate, page, pageSize);
    }


    /**
     * 获取未评价订单信息
     *
     * @param startDate
     * @param endDate
     * @param start
     * @param pageSize
     * @return
     * @author litu   litu@suniusoft.com
     * @date 2015/7/13
     */
    @Override
    public List<OrderJD> queryUnCommentOrderJDs(Date startDate, Date endDate, int start, int pageSize) {

        PageHelper.startPage(start, pageSize);
        OrderJDExample orderJDExample = new OrderJDExample();
        OrderJDExample.Criteria criteria = orderJDExample.createCriteria();
        criteria.andGmtModifiedBetween(startDate, endDate);
        criteria.andPullCommentEqualTo(false);
        List<OrderJD> orderJDs = orderJDMapper.selectByExample(orderJDExample);

        return orderJDs;
    }

    @Override
    public boolean pullCommentJDAndHandle(SellerShop sellerShop, List<OrderJD> orderJDs) {

        AssertsUtil.check(!CollectionUtils.isEmpty(orderJDs), "orderJDs is null");

        for (OrderJD orderJD : orderJDs) {

            try {
                pullCommentJDAndHandle(sellerShop, orderJD);
            } catch (Exception e) {
                throw new ServiceException("pullCommentJDAndHandle error[orderId=" + orderJD.getOrderId() + "]", e);
            }

        }

        return true;

    }

    @Override
    public ExpressDetailVO queryEtmsTrace(SellerShop sellerShop, String waybillCode) {

        List<TraceApiDtoVO> traceApiDtoVOs = jdAdapter.queryEtmsTrace(sellerShop, waybillCode);

        ExpressDetailVO expressDetailVO = new ExpressDetailVO();
        expressDetailVO.setInvoiceNo(waybillCode);

        if (CollectionUtils.isEmpty(traceApiDtoVOs)) {
            return expressDetailVO;
        }

        List<TransitStepVO> transitStepVOs = new ArrayList<TransitStepVO>();
        for (TraceApiDtoVO traceApiDtoVO : traceApiDtoVOs) {

            TransitStepVO transitStepVO = new TransitStepVO();
            if (StringUtils.isNotBlank(traceApiDtoVO.getOpeTime())) {
                transitStepVO.setStatusTime(traceApiDtoVO.getOpeTime());
            }

            String statusDesc = "";
            if (StringUtils.isNotBlank(traceApiDtoVO.getOpeRemark())) {
                statusDesc = statusDesc + traceApiDtoVO.getOpeRemark() + ",";
            }
            if (StringUtils.isNotBlank(traceApiDtoVO.getOpeRemark())) {
                statusDesc = statusDesc + traceApiDtoVO.getOpeName();
            }
            if (StringUtils.isNotBlank(traceApiDtoVO.getOpeRemark())) {
                statusDesc = statusDesc + traceApiDtoVO.getOpeTitle();
            }
            transitStepVO.setStatusDesc(statusDesc);

        }

        expressDetailVO.setTransitStepVOs(transitStepVOs);

        return expressDetailVO;
    }

    @Override
    public boolean pullCommentJDAndHandle(SellerShop sellerShop, OrderJD orderJD) {

        List<CommentJD> commentJDs = jdAdapter.syncCommentJDByOrderId(sellerShop, orderJD.getOrderId());


        if (!CollectionUtils.isEmpty(commentJDs)) {

            boolean pullCommentFlag = true;
            for (CommentJD commentJD : commentJDs) {
                commentJD.setOrderId(orderJD.getOrderId());
                commentJD.setUserIdJd(orderJD.getUserIdJd());
                if (saveOrUpdateCommentJD(commentJD) == false) {
                    pullCommentFlag = false;
                }
            }
            OrderJD orderJD1 = new OrderJD();
            orderJD1.setId(orderJD.getId());
            orderJD1.setPullComment(pullCommentFlag);
            orderJDMapper.updateByPrimaryKeySelective(orderJD1);
        }

        return true;

    }

    /**
     * 更新或保存京东评价数据
     *
     * @param commentJD
     * @author litu  litu@shufensoft.com  2015/7/10
     */
    public boolean saveOrUpdateCommentJD(CommentJD commentJD) {

        if (commentJD == null) {
            return false;
        }

        CommentJDExample example = new CommentJDExample();
        example.createCriteria().andJdCommentIdEqualTo(commentJD.getJdCommentId());
        List<CommentJD> list = commentJDMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return commentJDMapper.insert(commentJD) > 0;
        } else {
            commentJD.setId(list.get(0).getId());
            return commentJDMapper.updateByPrimaryKeySelective(commentJD) > 0;
        }

    }


    /**
     * 更新或保存京东用户数据
     *
     * @param userJD
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    public void saveOrUpdateUserJD(UserJD userJD) {
        if (userJD == null) {
            return;
        }
        String pin = userJD.getPin();
        UserJDExample example = new UserJDExample();
        example.createCriteria().andSellerIdEqualTo(userJD.getSellerId()).andShopIdEqualTo(userJD.getShopId()).andPinEqualTo(pin);
        List<UserJD> list = userJDMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            userJDMapper.insert(userJD);
        } else {
            userJD.setUserIdJd(list.get(0).getUserIdJd());
            userJD.setId(list.get(0).getId());
            userJDMapper.updateByPrimaryKeySelective(userJD);
        }
    }

    /**
     * 更新或保存京东收件人数据
     *
     * @param receiverJD
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    public void saveOrUpdateReceiverJD(ReceiverJD receiverJD) {

        if (receiverJD == null) {
            return;
        }
        ReceiverJDExample example = new ReceiverJDExample();
        ReceiverJDExample.Criteria criteria = example.createCriteria();
        example.createCriteria().andFullnameEqualTo(receiverJD.getFullname());
        example.createCriteria().andUserIdJdEqualTo(receiverJD.getUserIdJd());

        String receiverMobile = receiverJD.getMobile();
        if (StringUtils.isNotBlank(receiverMobile)) {
            criteria.andMobileEqualTo(receiverMobile);
        }

        String telephone = receiverJD.getTelephone();
        if (StringUtils.isNotBlank(telephone)) {
            criteria.andTelephoneEqualTo(telephone);
        }

        String fullAddress = receiverJD.getFullAddress();
        if (StringUtils.isNotBlank(fullAddress)) {
            criteria.andFullAddressEqualTo(fullAddress);
        }


        List<ReceiverJD> list = receiverJDMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            receiverJDMapper.insert(receiverJD);
        } else {
            receiverJD.setReceiverIdJd(list.get(0).getReceiverIdJd());
            receiverJD.setId(list.get(0).getId());
            receiverJDMapper.updateByPrimaryKeySelective(receiverJD);
        }

    }

    public void saveOrUpdateItemInfoJDList(List<ItemInfoJD> items, OrderJD order) {

        AssertsUtil.check(!CollectionUtils.isEmpty(items), "ItemInfoJD is null");

        for (ItemInfoJD item : items) {
            item.setOrderId(order.getOrderId());
            item.setUserIdJd(order.getUserIdJd());
            item.setSellerId(order.getSellerId());
            item.setShopId(order.getShopId());
            saveOrUpdateItemInfoJd(item);
        }

    }


    /**
     * 通过评价相关信息获取京东订单数据
     *
     * @param orderJdDO
     * @return
     */
    @Override
    public List<OrderJDDO> selectOrderJDWithComment(OrderJDDO orderJdDO) {

        if (orderJdDO == null) {
            throw new ServiceException("jdTradeServiceImpl.selectOrderJDWithComment", "orderJdDO or UserIdJd is null");
        }
        return orderJDDAO.selectOrderJDWithComment(orderJdDO);

    }

    /**
     * 通过评价用户相关信息获取京东订单数据
     *
     * @param orderJdDO
     * @return
     */
    @Override
    public List<OrderJDDO> selectOrderJDWithCommentAndUser(OrderJDDO orderJdDO) {

        if (orderJdDO == null) {
            throw new ServiceException("jdTradeServiceImpl.selectOrderJDWithCommentAndUser", "orderJdDO or UserIdJd is null");
        }
        return orderJDDAO.selectOrderJDWithCommentAndUser(orderJdDO);

    }

    @Override
    public int countOrderJD(OrderJDVO orderJDVO) {
        OrderJDExample orderJDExample = new OrderJDExample();
        OrderJDExample.Criteria criteria = orderJDExample.createCriteria();
        if (orderJDVO.getStartDate() != null) {
            criteria.andOrderStartTimeGreaterThanOrEqualTo(orderJDVO.getStartDate());
        }
        if (orderJDVO.getEndDate() != null) {
            criteria.andOrderStartTimeLessThanOrEqualTo(orderJDVO.getEndDate());
        }
        if (orderJDVO.getUserIdJd() != null) {
            criteria.andUserIdJdEqualTo(orderJDVO.getUserIdJd());
        }
        if (orderJDVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(orderJDVO.getSellerId());
        }
        return orderJDMapper.countByExample(orderJDExample);
    }

    @Override
    public int countCommnetJD(CommentJDVO commentJDVO) {
        CommentJDExample commentJDExample = new CommentJDExample();
        CommentJDExample.Criteria criteria = commentJDExample.createCriteria();
        if (commentJDVO.getStartDate() != null) {
            criteria.andGmtModifiedGreaterThanOrEqualTo(commentJDVO.getStartDate());
        }
        if (commentJDVO.getEndDate() != null) {
            criteria.andGmtModifiedLessThanOrEqualTo(commentJDVO.getEndDate());
        }
        if (commentJDVO.getUserIdJd() != null) {
            criteria.andUserIdJdEqualTo(commentJDVO.getUserIdJd());
        }
        if (commentJDVO.getScore() != null) {
            criteria.andScoreEqualTo(commentJDVO.getScore());
        }
        if (commentJDVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(commentJDVO.getSellerId());
        }
        return commentJDMapper.countByExample(commentJDExample);
    }

    /**
     * 更新或者保存 ItemInfoJD 数据
     *
     * @param item
     * @modifer litu  litu@shufensoft.com  2015/7/10
     */
    public void saveOrUpdateItemInfoJd(ItemInfoJD item) {

        if (item == null) {
            return;
        }
        ItemInfoJDExample example = new ItemInfoJDExample();
        example.createCriteria().andOrderIdEqualTo(item.getOrderId());
        example.createCriteria().andSkuIdEqualTo(item.getWareId());

        List<ItemInfoJD> list = itemInfoJDMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            itemInfoJDMapper.insert(item);
        } else {
            item.setId(list.get(0).getId());
            itemInfoJDMapper.updateByPrimaryKeySelective(item);
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
    public com.github.pagehelper.PageInfo selectJdOrderListByDate(Date startDate, Date endDate, Integer start, Integer pageSize) {
        AssertsUtil.notNull(startDate, "startDate");
        AssertsUtil.notNull(startDate, "endDate");

        OrderJDExample orderJDExample = new OrderJDExample();
        OrderJDExample.Criteria criteria = orderJDExample.createCriteria();

        criteria.andModifiedBetween(startDate, endDate);
        criteria.andOrderStateEqualTo(JDClient.finished_l);


        PageHelper.startPage(start, pageSize);

        List<OrderJD> orderJDList = orderJDMapper.selectByExample(orderJDExample);

        return new com.github.pagehelper.PageInfo(orderJDList);
    }


    /**
     * 根据京东用户ID查询用户所有完成交易信息
     *
     * @param sellerId 商户ID
     * @param userIdJd 京东用户ID
     * @return
     */
    public List<OrderJD> getJdOrderListByUserTbId(Long sellerId, Long userIdJd) {

        OrderJDExample orderJDExample = new OrderJDExample();
        OrderJDExample.Criteria criteria = orderJDExample.createCriteria();

        criteria.andUserIdJdEqualTo(userIdJd);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andOrderStateEqualTo(JDClient.finished_l);
        criteria.andModifiedBetween(DateUtil.getExpiredDay(-365), new Date());

        List<OrderJD> orderJDList = orderJDMapper.selectByExample(orderJDExample);

        if (CollectionUtils.isEmpty(orderJDList)) {
            return null;
        }

        return orderJDList;

    }

    /**
     * 根据京东用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdJd 用户淘宝ID
     */
    @Override
    public void createJdBuyPointByUserIdTb(Long sellerId, Long userIdJd) {

        List<OrderJD> orderJDList = getJdOrderListByUserTbId(sellerId, userIdJd);

        if (CollectionUtils.isEmpty(orderJDList)) {
            return;
        }

        for (OrderJD orderJD : orderJDList) {

            pointService.tradeToCreateBuyPoint(sellerId, userIdJd, DaoConstant.UserSource.TB, orderJD.getOrderPayment().longValue(), Long.valueOf(orderJD.getOrderId()));

        }
    }

}
