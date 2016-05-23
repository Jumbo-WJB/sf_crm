package com.shufensoft.crm.biz.service.trade.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.adapter.YouZanAdapter;
import com.shufensoft.crm.biz.adapter.jsonObj.BuyerMessage;
import com.shufensoft.crm.biz.adapter.jsonObj.OrderYZJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.TradeYZJsonObj;
import com.shufensoft.crm.biz.adapter.jsonObj.UserYZjsonObj;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverYZMapper;
import com.shufensoft.crm.biz.dao.generation.trade.BuyerMessageYZMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderYZMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeYZMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTagYZMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserYZMapper;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverYZ;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverYZExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.UserTagYZ;
import com.shufensoft.crm.biz.domain.generation.user.UserTagYZExample;
import com.shufensoft.crm.biz.domain.generation.user.UserYZ;
import com.shufensoft.crm.biz.domain.generation.user.UserYZExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.common.api.client.JDClient;
import com.shufensoft.crm.common.api.response.YouZanRespone;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 有赞交易服务类
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
@Service(value = "youZanTradeService")
public class YouZanTradeServiceImpl implements YouZanTradeService {

    @Autowired
    private TradeYZMapper tradeYZMapper;

    @Autowired
    private OrderYZMapper orderYZMapper;

    @Autowired
    private BuyerMessageYZMapper buyerMessageYZMapper;


    @Autowired
    private UserYZMapper userYZMapper;

    @Autowired
    private UserTagYZMapper userTagYZMapper;

    @Autowired
    private ReceiverYZMapper receiverYZMapper;

    @Autowired
    private IPointService pointService;


    private static YouZanAdapter youZanAdapter = new YouZanAdapter();

    /**
     * 交易数据处理，保存
     *
     * @param tradeYZ
     * @return
     */
    @Transactional
    public boolean saveOrUpdateTrade(TradeYZ tradeYZ) {

        if (tradeYZ == null) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateTrade", "tradeTaoBao is null");
        }

        List<OrderYZ> orders = tradeYZ.getOrders();
        if (CollectionUtils.isEmpty(orders)) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateTrade", "orders is null");
        }

        try {
            /**
             * 1.从交易中挖掘用户数据
             */
            Long sellerId = tradeYZ.getSellerId();
            AssertsUtil.notNull(sellerId, "sellerId");

            SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId), String.valueOf(tradeYZ.getShopId()));

            UserYZ userYZ = queryYouZanUserByUserId(sellerShop, tradeYZ.getWeixinUserId());

            userYZ.setSellerId(Long.valueOf(sellerId));
            userYZ.setShopId(tradeYZ.getShopId());
            userYZ.setBuyerNick(tradeYZ.getBuyerNick());
            userYZ.setBuyerArea(tradeYZ.getBuyerArea());
            userYZ.setBuyerId(tradeYZ.getBuyerId());
            userYZ.setWeixinUserId(tradeYZ.getWeixinUserId());

            saveOrUpdateYZUser(userYZ);

            /**
             * 2.从交易中挖掘收件人信息
             */
            ReceiverYZ receiverYZ = new ReceiverYZ();
            receiverYZ.setReceiverName(tradeYZ.getReceiverName());
            receiverYZ.setReceiverCity(tradeYZ.getReceiverCity());
            receiverYZ.setReceiverDistrict(tradeYZ.getReceiverDistrict());
            receiverYZ.setReceiverAddress(tradeYZ.getReceiverAddress());
            receiverYZ.setReceiverMobile(tradeYZ.getReceiverMobile());
            receiverYZ.setReceiverState(tradeYZ.getReceiverState());
            receiverYZ.setReceiverZip(tradeYZ.getReceiverZip());
            receiverYZ.setUserIdYz(userYZ.getUserIdYz());
            receiverYZ.setCreated(tradeYZ.getCreated());
            saveOrUpdateYZReceiver(receiverYZ);

            /**
             * 3.保存或更新交易信息
             */
            tradeYZ.setUserIdYz(userYZ.getUserIdYz());
            tradeYZ.setReceiverIdYz(receiverYZ.getReceiverIdYz());
            String numIid = "";
            for (OrderYZ orderYZ : orders) {
                if (orderYZ.getNumIid() != null) {
                    numIid = numIid + orderYZ.getNumIid() + ",";
                }
            }

            if (StringUtils.isNotBlank(numIid) && numIid.endsWith(",")) {
                numIid = numIid.substring(0, numIid.length() - 2);
            }

            tradeYZ.setNumIid(numIid);
            String tid = tradeYZ.getTid();
            TradeYZExample tradeYZExample = new TradeYZExample();
            tradeYZExample.createCriteria().andTidEqualTo(tid);
            List<TradeYZ> tradeYZs = tradeYZMapper.selectByExample(tradeYZExample);
            if (CollectionUtils.isEmpty(tradeYZs)) {
                tradeYZMapper.insert(tradeYZ);
            } else {
                tradeYZMapper.updateByExampleSelective(tradeYZ, tradeYZExample);
            }

            saveOrUpdateOrder(tradeYZ);

        } catch (Exception e) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateTradeList", "[tradeId=" + tradeYZ.getId() + "];" + e.getMessage(), e);
        }

        return true;

    }

    @Override
    public boolean saveOrUpdateTradeList(List<TradeYZ> tradeYZList) {

        if (CollectionUtils.isEmpty(tradeYZList)) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateTradeList", "tradeYZList is null");
        }

        for (TradeYZ tradeYZ : tradeYZList) {
            saveOrUpdateTrade(tradeYZ);
        }

        return true;
    }


    /**
     * 拉取有赞订单信息
     *
     * @param sellerShop
     * @param pageNo
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public boolean pullTradeFromYouZanByDate(SellerShop sellerShop, Long pageNo, Long pageSize, Date startDate, Date endDate) {

        if (pageNo == null || pageNo == 0) {
            pageNo = 1L;
        }

        if (pageSize == null || pageSize == 0) {
            pageSize = 40L;
        }

        try {

            YouZanRespone youZanRespone;
            do {

                youZanRespone = youZanAdapter.pullYouZanTrade(sellerShop, pageNo, pageSize, startDate, endDate);

                if (StringUtils.isBlank(youZanRespone.getResultJson())) {

                    return true;

                }

                List<TradeYZJsonObj> tradeYZJsonObjs = (List<TradeYZJsonObj>) JSONUtils.parseToList(youZanRespone.getResultJson(), TradeYZJsonObj.class);

                if (!CollectionUtils.isEmpty(tradeYZJsonObjs)) {

                    List<TradeYZ> tradeYZs = new ArrayList<TradeYZ>();

                    for (TradeYZJsonObj tradeYZJsonObj : tradeYZJsonObjs) {

                        TradeYZ tradeYZ = (TradeYZ) BeanCopierUtils.copyHumpFieldProperties(tradeYZJsonObj, TradeYZ.class);

                        if (tradeYZ == null) {
                            continue;
                        }

                        tradeYZ.setSellerId(sellerShop.getSellerId());
                        tradeYZ.setShopId(sellerShop.getShopId());
                        tradeYZs.add(tradeYZ);

                        List<OrderYZJsonObj> orderYZJsonObjs = tradeYZJsonObj.getOrders();
                        if (CollectionUtils.isEmpty(orderYZJsonObjs)) {
                            continue;
                        }

                        List<OrderYZ> orderYZs = new ArrayList<OrderYZ>();

                        for (OrderYZJsonObj orderYZJsonObj : orderYZJsonObjs) {

                            OrderYZ orderYZ = (OrderYZ) BeanCopierUtils.copyHumpFieldProperties(orderYZJsonObj, OrderYZ.class);
                            orderYZ.setSellerId(sellerShop.getSellerId());
                            orderYZ.setShopId(sellerShop.getShopId());
                            orderYZs.add(orderYZ);

                            List<BuyerMessage> buyer_messages = orderYZJsonObj.getBuyer_messages();

                            if (CollectionUtils.isEmpty(buyer_messages)) {
                                continue;
                            }

                            List<BuyerMessageYZ> buyerMessageYZs = new ArrayList<BuyerMessageYZ>();

                            for (BuyerMessage buyerMessage : buyer_messages) {
                                BuyerMessageYZ buyerMessageYZ = new BuyerMessageYZ();
                                buyerMessageYZ.setOid(orderYZ.getOid());
                                buyerMessageYZ.setTitle(buyerMessage.getTitle());
                                buyerMessageYZ.setContent(buyerMessage.getContent());
                                buyerMessageYZs.add(buyerMessageYZ);
                                orderYZ.setBuyerMessages(buyerMessageYZs);
                            }
                        }

                        tradeYZ.setOrders(orderYZs);

                    }

                    saveOrUpdateTradeList(tradeYZs);

                }

                pageNo++;

            } while (youZanRespone != null && youZanRespone.getHashNext());

        } catch (Exception e) {
            throw new ServiceException("YouZanTradeServiceImpl.pullTradeFromYouZanByDate error", e);
        }

        return true;

    }

    @Override
    public boolean pullTradeFromYouZanByDate(SellerShop sellerShop, Long start, Date startDate, Date endDate) {
        return pullTradeFromYouZanByDate(sellerShop, start, 40l, startDate, endDate);
    }

    @Override
    public List<TradeYZ> findTradeFromByDate(SellerShop sellerShop, int start, int pageSize, Date startDate, Date endDate) {

        PageHelper.startPage(start, pageSize);

        TradeYZExample tradeYZExample = new TradeYZExample();
        tradeYZExample.createCriteria().andSellerIdEqualTo(sellerShop.getSellerId()).andShopIdEqualTo(sellerShop.getShopId())
                .andGmtModifiedBetween(startDate, endDate);

        return tradeYZMapper.selectByExample(tradeYZExample);

    }

    @Override
    public UserYZ queryYouZanUserByUserId(SellerShop sellerShop, Long weiXinUserId) {

        UserYZjsonObj userYZjsonObj = youZanAdapter.queryYouZanUser(sellerShop, weiXinUserId);

        if (userYZjsonObj != null) {

            try {

                UserYZ userYZ = (UserYZ) BeanCopierUtils.copyHumpFieldProperties(userYZjsonObj, UserYZ.class);

                userYZ.setOpenid(userYZjsonObj.getWeixin_openid());
                userYZ.setSubscribeTime(userYZjsonObj.getFollow_time());
                userYZ.setHeadimgurl(userYZjsonObj.getAvatar());
                userYZ.setNickName(userYZjsonObj.getNick());
                userYZ.setWeixinUserId(weiXinUserId);
                userYZ.setSex(userYZ.getSex().equals("m")?"1":"0");
                return userYZ;

            } catch (Exception e) {
                throw new ServiceException("YouZanTradeServiceImpl.queryYouZanUserByUserId", e);
            }

        }

        return null;
    }

    @Override
    public ExpressDetailVO queryYouZanLogisticsTrace(SellerShop sellerShop, String tid) {

        return youZanAdapter.queryYouZanLogisticsTrace(sellerShop, tid);

    }

    /**
     * 根据开始和结束时间查询状态完成的有赞订单信息
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    @Override
    public PageInfo selectYzTradeListByDate(Date startDate, Date endDate, Integer start, Integer pageSize) {
        AssertsUtil.notNull(startDate, "startDate");
        AssertsUtil.notNull(startDate, "endDate");

        TradeYZExample tradeYZExample = new TradeYZExample();
        TradeYZExample.Criteria criteria = tradeYZExample.createCriteria();
        criteria.andUpdateTimeBetween(startDate, endDate);
        criteria.andStatusEqualTo("FINISHED_L");

        PageHelper.startPage(start, pageSize);

        List<TradeYZ> tradeYZs = tradeYZMapper.selectByExample(tradeYZExample);

        return new PageInfo(tradeYZs);
    }

    /**
     * 保存或更新user
     *
     * @param userYZ
     */
    private void saveOrUpdateYZUser(UserYZ userYZ) {

        if (userYZ == null || userYZ.getWeixinUserId() == null) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateYZUser", "userYZ or weiXinUserId is null");
        }

        UserYZExample userYZExample = new UserYZExample();
        userYZExample.createCriteria().andSellerIdEqualTo(userYZ.getSellerId()).andShopIdEqualTo(userYZ.getShopId())
                .andWeixinUserIdEqualTo(userYZ.getWeixinUserId());
        List<UserYZ> userYZs = userYZMapper.selectByExample(userYZExample);

        if (CollectionUtils.isEmpty(userYZs)) {

            userYZMapper.insert(userYZ);

        } else {

            userYZ.setId(userYZs.get(0).getId());
            userYZMapper.updateByPrimaryKeySelective(userYZ);
            userYZ.setUserIdYz(userYZs.get(0).getUserIdYz());
            List<UserTagYZ> userTags = userYZ.getTags();
            if (!CollectionUtils.isEmpty(userTags)) {
                return;
            }

        }

        /**
         * 保存用户标签
         */
        List<UserTagYZ> userTags = userYZ.getTags();
        if (!CollectionUtils.isEmpty(userTags)) {
            return;
        }

        for (UserTagYZ userTag : userTags) {

            userTag.setUserIdYz(userYZ.getUserIdYz());
            UserTagYZExample userTagYZExample = new UserTagYZExample();
            userTagYZExample.createCriteria().andUserIdYzEqualTo(userTag.getUserIdYz()).andNameEqualTo(userTag.getName());
            List<UserTagYZ> tags = userTagYZMapper.selectByExample(userTagYZExample);
            if (CollectionUtils.isEmpty(tags)) {
                userTagYZMapper.insert(userTag);
            }

        }

    }

    /**
     * 保存或更新Receiver
     *
     * @param receiverYZ
     */
    private void saveOrUpdateYZReceiver(ReceiverYZ receiverYZ) {

        if (receiverYZ == null || StringUtils.isBlank(receiverYZ.getReceiverName())) {
            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateYouZanReceiver", "receiverYZ or receiverName is null");
        }

        String receiverName = receiverYZ.getReceiverName();
        ReceiverYZExample receiverYZExample = new ReceiverYZExample();
        ReceiverYZExample.Criteria criteria = receiverYZExample.createCriteria().andReceiverNameEqualTo(receiverName);

        String receiverMobile = receiverYZ.getReceiverMobile();
        if (StringUtils.isNotBlank(receiverMobile)) {
            criteria.andReceiverMobileEqualTo(receiverYZ.getReceiverMobile());
        }

        String receiverAddress = receiverYZ.getReceiverAddress();
        if (StringUtils.isNotBlank(receiverAddress)) {
            criteria.andReceiverAddressEqualTo(receiverYZ.getReceiverAddress());
        }


        List<ReceiverYZ> receiverYZs = receiverYZMapper.selectByExample(receiverYZExample);

        if (CollectionUtils.isEmpty(receiverYZs)) {
            receiverYZMapper.insert(receiverYZ);
        } else {
            receiverYZ.setId(receiverYZs.get(0).getId());
            receiverYZMapper.updateByPrimaryKeySelective(receiverYZ);
            receiverYZ.setReceiverIdYz(receiverYZs.get(0).getReceiverIdYz());
        }

    }

    /**
     * 更新或保存orders
     *
     * @param tradeYZ
     */
    public void saveOrUpdateOrder(TradeYZ tradeYZ) {

        if (tradeYZ == null || CollectionUtils.isEmpty(tradeYZ.getOrders())) {

            throw new ServiceException("YouZanTradeServiceImpl.saveOrUpdateOrder", "tradeYZ or orders is null");
        }

        for (OrderYZ order : tradeYZ.getOrders()) {
            order.setTid(tradeYZ.getTid());
            order.setUserIdYz(tradeYZ.getUserIdYz());
            OrderYZExample orderYZExample = new OrderYZExample();
            orderYZExample.createCriteria().andTidEqualTo(tradeYZ.getTid());
            orderYZExample.createCriteria().andOidEqualTo(order.getOid());
            List<OrderYZ> orderYZs = orderYZMapper.selectByExample(orderYZExample);
            if (CollectionUtils.isEmpty(orderYZs)) {
                orderYZMapper.insert(order);
            } else {
                order.setId(orderYZs.get(0).getId());
                orderYZMapper.updateByPrimaryKeySelective(order);
            }

            saveOrUpdateBuyerMessage(order);

        }
    }

    /**
     * 保存买家留言
     *
     * @param orderYz
     * @return
     */
    private boolean saveOrUpdateBuyerMessage(OrderYZ orderYz) {

        AssertsUtil.notNull(orderYz, "orderYz");

        if (!CollectionUtils.isEmpty(orderYz.getBuyerMessages())) {

            for (BuyerMessageYZ buyerMessage : orderYz.getBuyerMessages()) {

                buyerMessage.setOid(orderYz.getOid());
                BuyerMessageYZExample buyerMessageYZExample = new BuyerMessageYZExample();
                buyerMessageYZExample.createCriteria().andOidEqualTo(buyerMessage.getOid()).andTitleEqualTo(buyerMessage.getTitle());
                List<BuyerMessageYZ> buyerMessages = buyerMessageYZMapper.selectByExample(buyerMessageYZExample);
                if (CollectionUtils.isEmpty(buyerMessages)) {
                    buyerMessageYZMapper.insert(buyerMessage);
                } else {
                    buyerMessage.setId(buyerMessages.get(0).getId());
                    buyerMessageYZMapper.updateByPrimaryKeySelective(buyerMessage);
                }
            }

        }

        return true;
    }


    /**
     * 根据京东用户ID查询用户所有完成交易信息
     *
     * @param sellerId 商户ID
     * @param userIdYz 京东用户ID
     * @return
     */
    public List<TradeYZ> getYzTradeListByUserYzId(Long sellerId, Long userIdYz) {

        TradeYZExample tradeYZExample = new TradeYZExample();
        TradeYZExample.Criteria criteria = tradeYZExample.createCriteria();

        criteria.andUserIdYzEqualTo(userIdYz);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andStatusEqualTo(JDClient.finished_l);
        criteria.andUpdateTimeBetween(DateUtil.getExpiredDay(-365), new Date());

        List<TradeYZ> tradeYZList = tradeYZMapper.selectByExample(tradeYZExample);

        if (CollectionUtils.isEmpty(tradeYZList)) {
            return null;
        }

        return tradeYZList;

    }

    /**
     * 根据京东用户的ID将1年内的购物每笔金额转换成积分
     *
     * @param sellerId 商户ID
     * @param userIdYz 用户淘宝ID
     */
    @Override
    public void createYzdBuyPointByUserIdYz(Long sellerId, Long userIdYz) {

        List<TradeYZ> tradeYZList = getYzTradeListByUserYzId(sellerId, userIdYz);

        if (CollectionUtils.isEmpty(tradeYZList)) {
            return;
        }

        for (TradeYZ tradeYZ : tradeYZList) {

            pointService.tradeToCreateBuyPoint(sellerId, userIdYz, DaoConstant.UserSource.TB, tradeYZ.getPayment().longValue(), Long.valueOf(tradeYZ.getTid().substring(1, tradeYZ.getTid().length())));

        }
    }


}
