package com.shufensoft.crm.biz.service.pointmall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.pointMall.MallFansDao;
import com.shufensoft.crm.biz.dao.defined.pointMall.MallOrderDao;
import com.shufensoft.crm.biz.dao.generation.point.PointExchangeMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.*;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallFansDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallGoodsSkuDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallOrderDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallTradeDo;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.point.PointExchangeExample;
import com.shufensoft.crm.biz.domain.generation.pointmall.*;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.pointmall.face.IMallTradeService;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.pointmall.vo.OrderVo;
import com.shufensoft.crm.biz.service.pointmall.vo.ShippingVo;
import com.shufensoft.crm.biz.service.pointmall.vo.TradeVo;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 *  积分商城 交易处理
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-23 20:02  
 */
@Service(value="iMallTradeService")
public class MallTradeService implements IMallTradeService {

    private static final Logger logger = Logger.getLogger(MallTradeService.class);

    @Autowired
    private MallTradeMapper mallTradeMapper;

    @Autowired
    private MallOrderMapper mallOrderMapper;

//    @Autowired
    private static IPointService iPointService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Autowired
    private MallGoodsSkuMapper mallGoodsSkuMapper;

    @Autowired
    private MallOrderDao mallOrderDao;

    @Autowired
    private MallFansDao mallFansDao;

    @Autowired
    private MallReceiverMapper mallReceiverMapper;

    @Autowired
    private PointExchangeMapper pointExchangeMapper;

    static{
        iPointService = (IPointService)SpringContextUtil.getBean("pointService");
    }

    /**
     * 交易创建
     *
     * @param tradeVo
     * @return
     */
    public boolean create(TradeVo tradeVo) {
        if(tradeVo.getSellerId() <= 0 || tradeVo.getUserId() <= 0 || StringUtils.isEmpty(tradeVo.getStatus())
                || tradeVo.getReceiverId() <= 0 || CollectionUtils.isEmpty(tradeVo.getOrderVoList())) {
            logger.error("illegal argument: " + tradeVo.toString());
            throw new ServiceException("illegal argument: " + tradeVo.toString());
        }

        MallTrade mallTrade = null;
        try {
            mallTrade = (MallTrade) BeanCopierUtils.copyProperties(tradeVo, MallTrade.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e);
        }

        mallTrade.setCreated(new Date());
        mallTrade.setModified(new Date());

        int insTradeResult = mallTradeMapper.insert(mallTrade);

        MallOrder mallOrder = null;
        OrderVo orderVo = tradeVo.getOrderVoList().get(0);
        if(orderVo.getSellerId() <= 0 || orderVo.getUserId() <= 0
                || orderVo.getGoodsId() <= 0 || orderVo.getQuantity() <= 0) {
            logger.error("illegal argument: " + orderVo.toString());
            throw new ServiceException("illegal argument: " + orderVo.toString());
        }

        try {
            mallOrder = (MallOrder) BeanCopierUtils.copyProperties(orderVo, MallOrder.class);
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e);
        }

        mallOrder.setTid(mallTrade.getTid());
        int insOrderResult = mallOrderMapper.insert(mallOrder);

        return insTradeResult > 0 && insOrderResult > 0;
    }

    public boolean update(MallTrade trade) {
        return false;
    }

    @Transactional
    public boolean pay(long sellerId, long userId, long tid) {
        if(sellerId <= 0 || userId <= 0 || tid <= 0) {
            logger.error("illegal argument: " + sellerId + ", " + userId + ", " + tid);
            return false;
        }

        MallTradeExample mallTradeExample = new MallTradeExample();
        mallTradeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andTidEqualTo(tid);
        List<MallTrade> mallTradeList = mallTradeMapper.selectByExample(mallTradeExample);
        if(CollectionUtils.isEmpty(mallTradeList) || mallTradeList.size() > 1) {
            logger.error("inconsistent data: " + userId + "," + tid);
            throw new ServiceException("inconsistent data: " + userId + "," + tid);
        }
        MallTrade mallTrade = mallTradeList.get(0);

        MallTrade updateMallTrade = new MallTrade();
        updateMallTrade.setModified(new Date());
        updateMallTrade.setStatus(MallConstants.TradeStatus.WAIT_SELLER_SEND_GOODS);
        updateMallTrade.setPayTime(new Date());
        updateMallTrade.setId(mallTrade.getId());
        int updateResult = mallTradeMapper.updateByPrimaryKeySelective(updateMallTrade);
        if(updateResult <= 0) {
            logger.error("update trade fail: " + userId + "," + tid);
            throw new ServiceException("update trade fail: " + userId + "," + tid);
        }

        // 目前只有一种交易方式，即积分付款，后期有其它类型交易，需要在这里修改
        boolean payResult = iPointService.exchange(sellerId, userId, mallTrade.getPaymentPoint(),
                MallConstants.ExchangeMethod.POINTMALL_BUY, tid,null);
        if(payResult) {
            logger.error("point pay fail: " + userId + "," + tid);
            throw new ServiceException("point pay fail: " + userId + "," + tid);
        }

        return false;
    }

    /**
     * 发货
     *
     * @param sellerId
     * @param userId
     * @param tid
     * @param shippingVo
     * @return
     */
    public boolean consign(long sellerId, long userId, long tid, ShippingVo shippingVo) {
        if(sellerId <= 0 || userId <= 0 || tid <= 0 || StringUtils.isEmpty(shippingVo.getCompany())
                || StringUtils.isEmpty(shippingVo.getId()) || StringUtils.isEmpty(shippingVo.getType())) {
            logger.error("illegal argument: " + sellerId + "," + userId + "," + tid + "," + shippingVo.toString());
            return false;
        }

        MallTrade updateMallTrade = new MallTrade();
        updateMallTrade.setModified(new Date());
        updateMallTrade.setStatus(MallConstants.TradeStatus.WAIT_BUYER_CONFIRM_GOODS);
        updateMallTrade.setConsignTime(new Date());
        updateMallTrade.setShippingCompany(shippingVo.getCompany());
        updateMallTrade.setShippingFee(shippingVo.getFee());
        updateMallTrade.setShippingType(shippingVo.getType());
        updateMallTrade.setShippingId(shippingVo.getId());

        MallTradeExample mallTradeExample = new MallTradeExample();
        mallTradeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andTidEqualTo(tid);
        int updateResult = mallTradeMapper.updateByExampleSelective(updateMallTrade, mallTradeExample);

        return updateResult == 1;
    }

    public boolean confirm(long sellerId, long userId, long tid) {
        if(sellerId <= 0 || userId <= 0 || tid <= 0) {
            logger.error("illegal argument: " + sellerId + ", " + userId + ", " + tid);
            return false;
        }

        MallTrade updateMallTrade = new MallTrade();
        updateMallTrade.setModified(new Date());
        updateMallTrade.setStatus(MallConstants.TradeStatus.TRADE_FINISHED);
        updateMallTrade.setEndTime(new Date());

        MallTradeExample mallTradeExample = new MallTradeExample();
        mallTradeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andTidEqualTo(tid);
        int updateResult = mallTradeMapper.updateByExampleSelective(updateMallTrade, mallTradeExample);

        return updateResult == 1;
    }

    /**
     * 分页获取订单
     *
     * @param sellerId
     * @param userId 为空时，是卖方获取，不为空时，是买方获取, userId为小于等于0的数表示不填
     * @param start
     * @param pageSize
     * @return
     */
    public List<TradeVo> query(Long sellerId, Long userId, int start, int pageSize) {
        if(sellerId <= 0 || start <= 0 || pageSize <= 0) {
            logger.error("illegal argument: " + sellerId + ", " + start + ", " + pageSize);
            return null;
        }

        List<TradeVo> tradeVoList = new ArrayList<TradeVo>();
        MallTradeExample mallTradeExample = new MallTradeExample();
        if(userId == null || userId <= 0) {
            mallTradeExample.createCriteria().andSellerIdEqualTo(sellerId);
        } else {
            mallTradeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        }
        PageHelper.startPage(start, pageSize);
        List<MallTrade> mallTradeList = mallTradeMapper.selectByExample(mallTradeExample);
        if(CollectionUtils.isEmpty(mallTradeList)) {
            return tradeVoList;
        }

        List<Long> tidList = new ArrayList<Long>();
        for(MallTrade mallTrade : mallTradeList) {
            tidList.add(mallTrade.getTid());
        }

        MallOrderExample mallOrderExample = new MallOrderExample();
        if(userId==null || userId <= 0) {
            mallOrderExample.createCriteria().andSellerIdEqualTo(sellerId).andTidIn(tidList);
        } else {
            mallOrderExample.createCriteria().andSellerIdEqualTo(sellerId).andTidIn(tidList).andUserIdEqualTo(userId);
        }
        List<MallOrder> mallOrderList = mallOrderMapper.selectByExample(mallOrderExample);

        for(MallTrade mallTrade : mallTradeList) {
            TradeVo tradeVo = null;
            try {
                tradeVo = (TradeVo) BeanCopierUtils.copyProperties(mallTrade, TradeVo.class);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new ServiceException(e);
            }

            long tid = tradeVo.getTid();
            List<MallOrder> specMallOrderList = new ArrayList<MallOrder>();
            for(MallOrder mallOrder : mallOrderList) {
                if(tid == mallOrder.getTid()) {
                    specMallOrderList.add(mallOrder);
                }
            }

            List<OrderVo> orderVoList = new ArrayList<OrderVo>();
            for(MallOrder mallOrder : specMallOrderList) {
                try {
                    OrderVo orderVo = (OrderVo) BeanCopierUtils.copyProperties(mallOrder, OrderVo.class);
                    orderVoList.add(orderVo);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    throw new ServiceException(e);
                }
            }

            tradeVo.setOrderVoList(orderVoList);
            tradeVoList.add(tradeVo);
        }

        return tradeVoList;
    }

    /**
     *  分页查询某个商户的所有的 MallTrade
     * */
    @Override
    public PageInfo findAllMallTradeByPage(Long sellerId, Integer start, Integer length) {
        PageHelper.startPage(start,length);
//        MallTradeExample example = new MallTradeExample();
//        example.createCriteria().andSellerIdEqualTo(sellerId);
//        example.setOrderByClause("created desc");
//        List<MallTrade> mallTrades  = mallTradeMapper.selectByExample(example);
        List<TradeVo> tradeVos = this.query(sellerId, null, start, length);
        return new PageInfo(tradeVos);
    }

    /**
     *  查询所有子订单(MallOrder), 并关联上父订单(MallTrade)
     *
     * */
    @Override
    public List<OrderVo> findAllMallOrderCasecadeMallTradeByPage(Long sellerId) {
        MallOrderExample example = new MallOrderExample();
        MallOrderExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("created_by desc");
        List<MallOrder> mallOrders = mallOrderMapper.selectByExample(example);
        List<OrderVo> orderVos = new ArrayList<OrderVo>();
        OrderVo orderVo = null;
        for(MallOrder mo : mallOrders){
            orderVo = new OrderVo();
            orderVo.setOid(mo.getOid());
            orderVo.setTid(mo.getTid());
            orderVo.setQuantity(mo.getQuantity());
            //填充 MallTrade
            MallTradeExample mtExample = new MallTradeExample();
            mtExample.createCriteria().andTidEqualTo(mo.getTid());
            List<MallTrade> mts = mallTradeMapper.selectByExample(mtExample);
            if(!CollectionUtils.isEmpty(mts)){
//                mo.setMallTrade(mts.get(0));
                orderVo.setTradeDate(mts.get(0).getCreated());
                orderVo.setStatus(mts.get(0).getStatus());
            }
            //填充 User 信息
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(mo.getUserId());
            List<User> users = userMapper.selectByExample(userExample);
            if(!CollectionUtils.isEmpty(users)){
//                mo.setUser(users.get(0));
                orderVo.setUserName(users.get(0).getName());
            }
            //填充MallGoodsSku
            MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
            mallGoodsSkuExample.createCriteria().andSkuIdEqualTo(mo.getSkuId());
            List<MallGoodsSku> mallGoodsSkuList = mallGoodsSkuMapper.selectByExample(mallGoodsSkuExample);
            if(!CollectionUtils.isEmpty(mallGoodsSkuList)){
//                mo.setMallGoodsSku(mallGoodsSkuList.get(0));
                orderVo.setPrice(mallGoodsSkuList.get(0).getPrice());
                orderVo.setPoint(mallGoodsSkuList.get(0).getPoint());
                orderVo.setProp(mallGoodsSkuList.get(0).getPropsName());
            }
            //填充MallGoods
            MallGoodsExample mallGoodsExample = new MallGoodsExample();
            mallGoodsExample.createCriteria().andGoodsIdEqualTo(mo.getGoodsId());
            List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
            if(!CollectionUtils.isEmpty(mallGoodsList)){
//                mo.setMallGoods(mallGoodsList.get(0));
                orderVo.setImgUrls(mallGoodsList.get(0).getImgsUrl());
                orderVo.setTitle(mallGoodsList.get(0).getTitle());
                Long price = orderVo.getPrice();
                if(price == null){
                    orderVo.setPrice(mallGoodsList.get(0).getPrice());
                }
            }
            if(orderVo != null){
                orderVos.add(orderVo);
            }
        }
        return orderVos;
    }

    /**
     *
     *  根据状态查询子订单(MallOrder), 并关联上父订单(MallTrade)
     *  @param type 1待兑换订单, 2未发货订单, 3已发货订单,4已完成订单
     *
     * */
    @Override
    public List<OrderVo> findMallOrderByStatus(Long sellerId, Integer type) {
        MallOrderExample example = new MallOrderExample();
        MallOrderExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        example.setOrderByClause("created_by desc");
        List<MallOrder> mallOrders = mallOrderMapper.selectByExample(example);
        List<OrderVo> orderVos = new ArrayList<OrderVo>();
        OrderVo orderVo = null;
        for(MallOrder mo : mallOrders){
            orderVo = new OrderVo();
            orderVo.setOid(mo.getOid());
            orderVo.setTid(mo.getTid());
            orderVo.setQuantity(mo.getQuantity());
            //填充 MallTrade
            MallTradeExample mtExample = new MallTradeExample();
            mtExample.createCriteria().andTidEqualTo(mo.getTid());
            List<MallTrade> mts = mallTradeMapper.selectByExample(mtExample);
            if(!CollectionUtils.isEmpty(mts)){
                MallTrade mt = mts.get(0);
                orderVo.setTradeDate(mt.getCreated());
                orderVo.setStatus(mt.getStatus());
                String status = mt.getStatus();
                if(type == 1 && MallConstants.TradeStatus.WAIT_BUYER_PAY.equals(status)){       //待付款,积分
//                    mo.setMallTrade(mt);
                    fillMallOrderByStatus(orderVos,mo,orderVo);
                }else if(type == 2 && MallConstants.TradeStatus.WAIT_SELLER_SEND_GOODS.equals(status)){           //待发货
//                    mo.setMallTrade(mt);
                    fillMallOrderByStatus(orderVos,mo,orderVo);
                }else if(type ==3 && MallConstants.TradeStatus.WAIT_BUYER_CONFIRM_GOODS.equals(status)){          //已发货
//                    mo.setMallTrade(mt);
                    fillMallOrderByStatus(orderVos,mo,orderVo);
                }else if(type == 4 && (MallConstants.TradeStatus.TRADE_FINISHED.equals(status) || MallConstants.TradeStatus.TRADE_CLOSED.equals(status) || MallConstants.TradeStatus.TRADE_CLOSED_BY_SELLER.equals(status))){  //已完成
//                    mo.setMallTrade(mt);
                    fillMallOrderByStatus(orderVos,mo,orderVo);
                }
            }
        }
        return orderVos;
    }

    private void fillMallOrderByStatus(List<OrderVo> orderVos, MallOrder mo, OrderVo orderVo){
        //填充 User 信息
        //填充 User 信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(mo.getUserId());
        List<User> users = userMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(users)){
            orderVo.setUserName(users.get(0).getName());
        }
        //填充MallGoodsSku
        MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
        mallGoodsSkuExample.createCriteria().andSkuIdEqualTo(mo.getSkuId());
        List<MallGoodsSku> mallGoodsSkuList = mallGoodsSkuMapper.selectByExample(mallGoodsSkuExample);
        if(!CollectionUtils.isEmpty(mallGoodsSkuList)){
            orderVo.setPrice(mallGoodsSkuList.get(0).getPrice());
            orderVo.setPoint(mallGoodsSkuList.get(0).getPoint());
            orderVo.setProp(mallGoodsSkuList.get(0).getPropsName());
        }
        //填充MallGoods
        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andGoodsIdEqualTo(mo.getGoodsId());
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        if(!CollectionUtils.isEmpty(mallGoodsList)){
            orderVo.setImgUrls(mallGoodsList.get(0).getImgsUrl());
            orderVo.setTitle(mallGoodsList.get(0).getTitle());
            Long price = orderVo.getPrice();
            if(price == null){
                orderVo.setPrice(mallGoodsList.get(0).getPrice());
            }
        }
        if(orderVo != null){
            orderVos.add(orderVo);
        }
    }

    @Override
    /**
     *
     * */
    public PageInfo findMallOrderDaosByPage(Long sellerId, Integer type, Integer pageNum, Integer length) {
        PageHelper.startPage(pageNum,length);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("statusType",type);
        List<MallOrderDo> list = mallOrderDao.findMallOrders(map);
        return new PageInfo(list);
    }

    @Override
    /**
     *
     * */
    public MallTradeDo findMallTradeDoCasecadeGoods(Long tid){
        if(tid == null){
            throw new ServiceException("param tid is null");
        }
        try {
            MallTradeExample example = new MallTradeExample();
            example.createCriteria().andTidEqualTo(tid);
            List<MallTrade> mallTrades = mallTradeMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(mallTrades)) {
                MallTrade mt = mallTrades.get(0);
                MallTradeDo mallTradeDo = (MallTradeDo) BeanCopierUtils.copyProperties(mt, MallTradeDo.class);
                if(mt.getReceiverId() != null) {
                    //收货人信息
                    MallReceiverExample mallReceiverExample = new MallReceiverExample();
                    mallReceiverExample.createCriteria().andReceiverIdEqualTo(mt.getReceiverId());
                    List<MallReceiver> mallReceivers = mallReceiverMapper.selectByExample(mallReceiverExample);
                    if (!CollectionUtils.isEmpty(mallReceivers)) {
                        MallReceiver mallRece = mallReceivers.get(0);
                        mallTradeDo.setName(mallRece.getName());
                        mallTradeDo.setAddress(mallRece.getAddress());
                        mallTradeDo.setCity(mallRece.getCity());
                        mallTradeDo.setDistrict(mallRece.getDistrict());
                        mallTradeDo.setMobile(mallRece.getMobile());
                        mallTradeDo.setProvince(mallRece.getProvince());
                        mallTradeDo.setZip(mallRece.getZip());
                    }
                }
//                }
                //子订单,
                MallOrderExample mallOrderExample = new MallOrderExample();
                mallOrderExample.createCriteria().andTidEqualTo(mt.getTid());
                List<MallGoodsSkuDo> mallGoodsSkuDos = new ArrayList<MallGoodsSkuDo>();
                //分有sku和没有sku两种情况, 都用 mallGoodsSkuDo 实例化对象
                MallGoodsSkuDo mallGoodsSkuDo = null;
                List<MallOrder> mallOrders = mallOrderMapper.selectByExample(mallOrderExample);
                String propName = "";          //商品SKU值
                for (MallOrder mo : mallOrders) {
                    MallGoodsExample mallGoodsExample = new MallGoodsExample();
                    mallGoodsExample.createCriteria().andGoodsIdEqualTo(mo.getGoodsId());
                    List<MallGoods> mallGoodses = mallGoodsMapper.selectByExample(mallGoodsExample);
                    MallGoods mallGoods = mallGoodses.get(0);

                    if(mo.getSkuId() != null) {

                        MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
                        mallGoodsSkuExample.createCriteria().andSkuIdEqualTo(mo.getSkuId());
                        List<MallGoodsSku> mallGoodsSkus = mallGoodsSkuMapper.selectByExample(mallGoodsSkuExample);

                        if (!CollectionUtils.isEmpty(mallGoodsSkus)) {
                            MallGoodsSku mallGoodsSku = mallGoodsSkus.get(0);
                            mallGoodsSkuDo = (MallGoodsSkuDo) BeanCopierUtils.copyProperties(mallGoodsSku, MallGoodsSkuDo.class);
                            propName = mallGoodsSkuDo.getPropsName();
                        }
                    }else{
                        mallGoodsSkuDo = new MallGoodsSkuDo();
                        propName = "";
                        mallGoodsSkuDo.setPrice(mallGoodses.get(0).getPrice());
                        mallGoodsSkuDo.setPoint(mallGoodses.get(0).getPoint());
                    }
                    String name = "";              //商品名
                    String url = "";              //商品图片urls
                    String imgsUrl = mallGoods.getThumbnail();
                    if (org.apache.commons.lang.StringUtils.isNotBlank(imgsUrl)) {
//                        if (imgsUrl.indexOf(',') > 0) {
//                            String[] urlArr = imgsUrl.split(",");
//                            url = urlArr[0];
//                        } else {
//                            url = imgsUrl;
//                        }
                        url = imgsUrl;
                    }
                    String prop = propName;
                    if(org.apache.commons.lang.StringUtils.isNotBlank(prop)) {
                        if (prop.endsWith(";")) {
                            prop = prop.substring(0, prop.length() - 1);
                        }
                        String[] parr = prop.split(";");
                        for (String pv : parr) {
                            String[] pvArr = pv.split(":");
                            name += pvArr[3];
                        }
                    }
                    mallGoodsSkuDo.setGoodsName(mallGoods.getTitle() + "  " + name);
                    mallGoodsSkuDo.setGoodsImgUrl(url);
                    mallGoodsSkuDo.setBuyAmount(mo.getQuantity());
                    mallGoodsSkuDos.add(mallGoodsSkuDo);
                }
                mallTradeDo.setMallGoodsSkuDoList(mallGoodsSkuDos);
                return mallTradeDo;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageInfo findMallFansDosByPage(Long sellerId, String status, String wxNickName,
                                    Date startDate, Date endDate, Integer start, Integer length) {
        PageHelper.startPage(start,length);
        List<MallFansDo> mallFansDos = this.findMallFansDos(sellerId,status,wxNickName,startDate,endDate);
        return new PageInfo(mallFansDos);
    }

    @Override
    public List<MallFansDo> findMallFansDos(Long sellerId, String status, String wxNickName, Date startDate, Date endDate) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("status",status);
        map.put("wxNickName",wxNickName);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<MallFansDo> mallFansDos = mallFansDao.findMallFansDoList(map);
        return mallFansDos;
    }

    @Override
    public MallTrade findMallTradeByTid(Long sellerId, Long tid) {
        MallTradeExample example = new MallTradeExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andTidEqualTo(tid);
        List<MallTrade> list = mallTradeMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    /**
     *
     * 处理单个订单
     * 1. 更新订单状态
     * 2. 更新point_exchange 状态
     * */
    @Override
    @Transactional
    public boolean handleSingleMallTradeReceive(Long id, ShippingVo svo, Long sellerId) {
        if(id == null){
            logger.error("illegal argument: " + id);
            return false;
        }
        try {
            MallTrade updateMallTrade = new MallTrade();
            updateMallTrade.setModified(new Date());
            updateMallTrade.setStatus(MallConstants.TradeStatus.WAIT_BUYER_CONFIRM_GOODS);         //实物商品发货后
            updateMallTrade.setConsignTime(new Date());
            updateMallTrade.setShippingCompany(svo.getCompany());
            updateMallTrade.setShippingId(svo.getId());
            updateMallTrade.setId(id);
            int updateResult = mallTradeMapper.updateByPrimaryKeySelective(updateMallTrade);
            //更新point_exchange 状态
            MallTrade mallTrade = mallTradeMapper.selectByPrimaryKey(id);
            MallOrderExample mallOrderExample = new MallOrderExample();
            mallOrderExample.createCriteria().andSellerIdEqualTo(sellerId).andTidEqualTo(mallTrade.getTid());
            List<MallOrder> list = mallOrderMapper.selectByExample(mallOrderExample);
            if(!CollectionUtils.isEmpty(list)){
                List<Long> oids = new ArrayList<Long>();
                for(MallOrder mo : list){
                    oids.add(mo.getOid());
                }
                PointExchange pointExchange = new PointExchange();
                pointExchange.setStatus(DaoConstant.PointExchangeStatus.SUCCESS);
                PointExchangeExample pointExchangeExample = new PointExchangeExample();
                pointExchangeExample.createCriteria().andSellerIdEqualTo(sellerId).andExchangeIdIn(oids);
                pointExchangeMapper.updateByExampleSelective(pointExchange, pointExchangeExample);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }
        return true;
    }


    @Override
    public boolean handleMultipleMallTradeReceive(Map<Long, ShippingVo> params, Long sellerId) {
        boolean flag = true;
        try{
            for(Map.Entry<Long,ShippingVo> entry : params.entrySet()){
                boolean f = handleSingleMallTradeReceive(entry.getKey(),entry.getValue(), sellerId);
                flag = flag && f;
            }
            return flag;
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public List<MallOrderDo> findMallOrderDaos(Long sellerId, Integer type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("statusType",type);
        List<MallOrderDo> list = mallOrderDao.findMallOrders(map);
        return list;
    }

}
