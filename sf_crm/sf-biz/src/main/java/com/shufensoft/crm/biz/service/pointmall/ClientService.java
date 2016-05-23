package com.shufensoft.crm.biz.service.pointmall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.point.PointObtainDetailDAO;
import com.shufensoft.crm.biz.dao.defined.pointMall.*;
import com.shufensoft.crm.biz.dao.generation.point.PointExchangeMapper;
import com.shufensoft.crm.biz.dao.generation.pointmall.*;
import com.shufensoft.crm.biz.dao.generation.user.PraiseRecordsMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserInteractionDetailMapper;
import com.shufensoft.crm.biz.domain.defined.point.PointDetailDO;
import com.shufensoft.crm.biz.domain.defined.pointMall.*;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.point.PointExchangeExample;
import com.shufensoft.crm.biz.domain.generation.pointmall.*;
import com.shufensoft.crm.biz.domain.generation.user.PraiseRecords;
import com.shufensoft.crm.biz.domain.generation.user.PraiseRecordsExample;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.pointmall.face.IClientService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
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
@Service(value="iClientService")
public class ClientService implements IClientService{

    private static Logger logger = Logger.getLogger(ClientService.class);

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private PointExchangeMapper pointExchangeMapper;

    @Autowired
    private PointExchangeRankDao pointExchangeRankDao;

    @Autowired
    private PointExchangeRealTimeInfoDao pointExchangeRealTimeInfoDao;

    @Autowired
    private GoodsSkuExchangeDao goodsSkuExchangeDao;

    @Autowired
    private UserInteractionDetailMapper userInteractionDetailMapper;

    @Autowired
    private PointExchangeDetailDao pointExchangeDetailDao;

    @Autowired
    private UserAccountDao userAccountDao;

    @Autowired
    private PointObtainStaticsDao pointObtainStaticsDao;

    @Autowired
    private PointObtainDetailDAO pointObtainDetailDAO;

    @Autowired
    private MallReceiverMapper mallReceiverMapper;

    @Autowired
    private MallGoodsSkuMapper mallGoodsSkuMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Autowired
    private MallTradeMapper mallTradeMapper;

    @Autowired
    private MallOrderMapper mallOrderMapper;

    @Autowired
    private PraiseRecordsMapper praiseRecordsMapper;

//    private static DataSourceTransactionManager dataSourceTransactionManager;
//
//    static{
//        dataSourceTransactionManager = (DataSourceTransactionManager)SpringContextUtil.getBean("transactionManager");
//    }
    /**
     *
     * */
    @Override
    public UserAccount findUserAccountBySellerIdAndUserId(Long sellerId, Long userId) {
        if(sellerId == null || userId == null){
            throw new ServiceException("illegal param: sellerId=" + sellerId + " userId=" + userId);
        }
        UserAccountExample example = new UserAccountExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userAccountList)){
            return userAccountList.get(0);
        }
        return null;
    }

    @Override
    public PageInfo findGoodsPointExchangeByPage(Long sellerId, Long userId, Integer start, Integer length) {
        PageHelper.startPage(start,length);
        List<PointExchange> pointExchanges = this.getAllGoodsPointExchange(sellerId, userId);
        return new PageInfo(pointExchanges);
    }

    /**
     *  只查找兑换类型为 lw 的兑换信息
     */
    @Override
    public List<PointExchange> getAllGoodsPointExchange(Long sellerId, Long userId) {
        PointExchangeExample exchangeExample = new PointExchangeExample();
        exchangeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andExchangeMethodEqualTo(MallConstants.ExchangeType.LW);
        exchangeExample.setOrderByClause("created_by desc");
        List<PointExchange> pointExchangeList = pointExchangeMapper.selectByExample(exchangeExample);
        return pointExchangeList;
    }

    @Override
    public List<PointExchangeRankDo> getPointExchangeRankDo(Map<String,Object> params) {
        List<PointExchangeRankDo> list = pointExchangeRankDao.findPointExchangeRankDoBySeller(params);
        return list;
    }

    @Override
    public PageInfo getPointExchangeRankDoByPage(Map<String,Object> params, Integer start, Integer length) {
        PageHelper.startPage(start,length);
        List<PointExchangeRankDo> list = this.getPointExchangeRankDo(params);
        return new PageInfo(list);
    }

    @Override
    public PageInfo getPointExchangeRealTimeInfo(Long sellerId, Integer start, Integer length) {
        PageHelper.startPage(start,length);
        List<PointExchangeRealTimeInfoDo> list = pointExchangeRealTimeInfoDao.findPointExchangeRealTimeDoBySellerId(sellerId);
        return new PageInfo(list);
    }

    /**
     * 查找 sku 的被兑换次数
     * */
    @Override
    public List<GoodsSkuExchangeInfoDo> findAllGoodsSkuExchangeInfoDo(Long sellerId) {
        return goodsSkuExchangeDao.findGoodsSkuExchangeInfosBySellerId(sellerId);
    }

    @Override
    @Transactional
    public int dianzan(Long buid, Long uid,String interactionEntry) {
        PraiseRecordsExample praiseRecordsExample = new PraiseRecordsExample();
        praiseRecordsExample.createCriteria().andUserIdEqualTo(uid).andBUserIdEqualTo(buid).andPraiseEntryEqualTo(interactionEntry).
                andPraiseTimeGreaterThanOrEqualTo(DateUtil.getCurrentBeginDateTime("00:00:00")).
                andPraiseTimeLessThanOrEqualTo(DateUtil.getCurrentBeginDateTime("23:59:59"));
        List<PraiseRecords> praiseRecordses = praiseRecordsMapper.selectByExample(praiseRecordsExample);
        int result = 0;
        if(CollectionUtils.isEmpty(praiseRecordses)) {
            PraiseRecords praiseRecords = new PraiseRecords();
            praiseRecords.setUserId(uid);
            praiseRecords.setBUserId(buid);
            praiseRecords.setPraiseTime(new Date());
            praiseRecords.setPraiseEntry(interactionEntry);
            result = praiseRecordsMapper.insertSelective(praiseRecords);
        }
//        UserInteractionDetailExample example = new UserInteractionDetailExample();
//        //查找当天是否点赞
//        example.createCriteria().andUserIdEqualTo(uid).andBizIdEqualTo(buid).
//                andInteractionTypeEqualTo("dian_zan").andInteractionEntryEqualTo(interactionEntry).
//                andInteractionTimeGreaterThanOrEqualTo(DateUtil.getCurrentBeginDateTime("00:00:00")).
//                andInteractionTimeLessThanOrEqualTo(DateUtil.getCurrentBeginDateTime("23:59:59"));
//        List<UserInteractionDetail> userInteractionDetails = userInteractionDetailMapper.selectByExample(example);
//        int result = 0;
//        if(CollectionUtils.isEmpty(userInteractionDetails)) {
//            UserInteractionDetail detail = new UserInteractionDetail();
//            detail.setContent("点赞");
//            detail.setUserId(uid);
//            detail.setBizId(buid);
//            detail.setInteractionTime(new Date());
//            detail.setInteractionType("dian_zan");
//            detail.setInteractionEntry(interactionEntry);
//            result = userInteractionDetailMapper.insert(detail);
//        }
        return result;
    }

    /**
     * 查找某个用户的积分兑换的明细, 包括商品和红包
     *
     * @param sellerId
     * @param userId
     */
    @Override
    public List<PointExchangeDetailDo> findPointExchangeDetail(Long sellerId, Long userId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("userId",userId);
        List<PointExchangeDetailDo> list = pointExchangeDetailDao.findPointExchangeDetails(map);
        return list;
    }

    /**
     * 查找某个用户的积分账户信息, 包括积分兑换红包, 商品分别消耗的积分
     *
     * @param sellerId
     * @param userId
     */
    @Override
    public UserAccountStaticsDo findUserAccountDoByUserIdAndSellerId(Long sellerId, Long userId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("userId",userId);
        return userAccountDao.findUserAccountDo(map);
    }

    /**
     * 查找某个用户的积分排名
     *
     * @param sellerId
     * @param userId
     */
    @Override
    public UserAccountStaticsDo findUserAccountDoRankByUserId(Long sellerId, Long userId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("userId",userId);
        return userAccountDao.findUserAccountRanking(map);
    }

    /**
     * 查找某个商家总发放积分, 和总参与人数
     *
     * @param sellerId
     */
    @Override
    public PointObtainStaticsDo findPointObtainStaticsBySellerId(Long sellerId) {
        return pointObtainStaticsDao.findPointObtainStaticsDosBySellerId(sellerId);
    }

    /**
     * 查询某个用户获取积分明细
     *
     * @param sellerId
     * @param userId
     */
    @Override
    public List<PointDetailDO> findPointDetailDos(Long sellerId, Long userId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sellerId",sellerId);
        map.put("userId",userId);
        return pointObtainDetailDAO.findPointObtainDetails(map);
    }

    /**
     * 查找某个用户的默认收件人
     *
     * @param userId
     */
    @Override
    public MallReceiver findMallReceiverByUserId(Long sellerId, Long userId) {
        MallReceiverExample example = new MallReceiverExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andIsDefaultEqualTo("y");
        List<MallReceiver> mallReceivers = mallReceiverMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(mallReceivers)){
            return mallReceivers.get(0);
        }
        return null;
    }

    /**
     * 积分兑换商品的处理
     *
     * @param sellerId
     * @param userId
     * @param skuId
     */
    @Override
    @Transactional
    public int handleExchange(Long sellerId, Long userId, Long goodsId,Long skuId, Long receiverId, Integer amount,String source) throws RuntimeException{
        AssertsUtil.notNull(amount,"兑换数量不能为空");
        AssertsUtil.check(amount != 0, "兑换数量不能为0");

        int num = 0;
//        try{
            MallGoods mallGoods = null;
            MallGoodsSku mallGoodsSku = null;
            if(skuId != null){     //存在sku
                //sku库存减1
                MallGoodsSkuExample mallGoodsSkuExample = new MallGoodsSkuExample();
                mallGoodsSkuExample.createCriteria().andSellerIdEqualTo(sellerId).andSkuIdEqualTo(skuId);
                List<MallGoodsSku> list = mallGoodsSkuMapper.selectByExample(mallGoodsSkuExample);
                if(!CollectionUtils.isEmpty(list)){
                    mallGoodsSku = list.get(0);
                    MallGoodsSkuExample mallGoodsSkuExample1 = new MallGoodsSkuExample();
                    mallGoodsSkuExample1.createCriteria().andIdEqualTo(mallGoodsSku.getId()).andVersionEqualTo(mallGoodsSku.getVersion());
                    MallGoodsSku mallGoodsSkuUpdate = new MallGoodsSku();
                    mallGoodsSkuUpdate.setQuantityExpression("quantity - " + amount);
                    mallGoodsSkuUpdate.setVersionExpression("version + " + 1);
                    int result1 = mallGoodsSkuMapper.updateByExampleSelective(mallGoodsSkuUpdate,mallGoodsSkuExample1);
                    if(result1 == 0){
                        throw new ServiceException("mallGoodsSku库存数更新失败");
                    }
                    num += result1;
                    //mallGoods 数量减, 已兑换数量加
                    MallGoodsExample mallGoodsExample = new MallGoodsExample();
                    mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(mallGoodsSku.getGoodsId());
                    List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
                    if(!CollectionUtils.isEmpty(mallGoodsList)){
                        mallGoods = mallGoodsList.get(0);
                        MallGoodsExample mallGoodsExample1 = new MallGoodsExample();
                        mallGoodsExample1.createCriteria().andIdEqualTo(mallGoods.getId()).andVersionEqualTo(mallGoods.getVersion());
                        MallGoods mallGoodsUpdate = new MallGoods();
                        mallGoodsUpdate.setExchangeAmountExpression("exchange_amount + " + amount);
                        mallGoodsUpdate.setQuantityExpression("quantity - " + amount);
                        mallGoodsUpdate.setVersionExpression("version + " + 1);
                        int result2 = mallGoodsMapper.updateByExampleSelective(mallGoodsUpdate,mallGoodsExample1);
                        if(result2 == 0){
                            throw new ServiceException("mallGoods 数量和已兑换数量更新失败");
                        }
                        num += result2;
                    }

                }
            }else{
                //mallGoods 数量减, 已兑换数量加
                MallGoodsExample mallGoodsExample = new MallGoodsExample();
                mallGoodsExample.createCriteria().andSellerIdEqualTo(sellerId).andGoodsIdEqualTo(goodsId);
                List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
                if(!CollectionUtils.isEmpty(mallGoodsList)){
                    mallGoods = mallGoodsList.get(0);
                    MallGoodsExample mallGoodsExample1 = new MallGoodsExample();
                    mallGoodsExample1.createCriteria().andIdEqualTo(mallGoods.getId()).andVersionEqualTo(mallGoods.getVersion());
                    MallGoods mallGoodsUpdate = new MallGoods();
                    mallGoodsUpdate.setExchangeAmountExpression("exchange_amount + " + amount);
                    mallGoodsUpdate.setQuantityExpression("quantity - " + amount);
                    mallGoodsUpdate.setVersionExpression("version + " + 1);
                    int result3 = mallGoodsMapper.updateByExampleSelective(mallGoodsUpdate,mallGoodsExample1);
                    if(result3 == 0){
                        throw new ServiceException("mallGoods 数量和已兑换数量更新失败");
                    }
                    num += result3;
                }
            }
            if("n".equals(mallGoods.getIsVirtual())){
                AssertsUtil.notNull(receiverId,"收件人不能为空");
            }
            //更新userAccount 的当前有效积分, 累计兑换积分
            UserAccountExample userAccountExample = new UserAccountExample();
            userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
            List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);
            if(!CollectionUtils.isEmpty(userAccounts)){
                UserAccount userAccount = userAccounts.get(0);
                UserAccountExample userAccountExample1 = new UserAccountExample();
                userAccountExample1.createCriteria().andIdEqualTo(userAccount.getId()).andUserAccountVersionEqualTo(userAccount.getUserAccountVersion());

                UserAccount userAccountUpdate = new UserAccount();
                if(mallGoodsSku != null){
                    userAccountUpdate.setPointAmountExpression("point_amount -" + amount * mallGoodsSku.getPoint());
                    userAccountUpdate.setPointAmountExchangeExpression("point_amount_exchange +" + amount * mallGoodsSku.getPoint());
                }else{
                    userAccountUpdate.setPointAmountExpression("point_amount -" + amount * mallGoods.getPoint());
                    userAccountUpdate.setPointAmountExchangeExpression("point_amount_exchange +" + amount * mallGoods.getPoint());
                }
                userAccountUpdate.setUserAccountVersionExpression("user_account_version +" + 1);

                int result4 = userAccountMapper.updateByExampleSelective(userAccountUpdate,userAccountExample1);
                if(result4 == 0){
                    throw new ServiceException("userAccount 有效积分和已兑换积分更新失败");
                }
                num += result4;
            }

            //生成mall_trade, mall_order数据
            MallTrade mallTrade = new MallTrade();
            mallTrade.setSellerId(sellerId);
            mallTrade.setUserId(userId);
            if("y".equals(mallGoods.getIsVirtual())){
                mallTrade.setStatus(MallConstants.TradeStatus.TRADE_FINISHED);     //虚拟商品订单提交后 交易就完成
            }else if("n".equals(mallGoods.getIsVirtual())){
                mallTrade.setStatus(MallConstants.TradeStatus.WAIT_SELLER_SEND_GOODS);   //非虚拟商品订单提交后 等待卖家发货
            }
            mallTrade.setCreated(new Date());
            mallTrade.setReceiverId(receiverId);
            if(StringUtils.isNotBlank(source)){
                if(source.equals(DaoConstant.GiftSource.SHAKE)){     //摇一摇
                    mallTrade.setType(MallConstants.MallTradeType.SHAKE_FETCH);
                }else if(source.equals(DaoConstant.GiftSource.BIRTHDAY)){
                    mallTrade.setType(MallConstants.MallTradeType.BIRTHDAY_FETCH);
                }
            }else{
                mallTrade.setType(MallConstants.MallTradeType.DEFAULT_FETCH);
            }
            if(mallGoodsSku != null){
                mallTrade.setFee(mallGoodsSku.getPrice());
                mallTrade.setFeePoint(mallGoodsSku.getPoint());
                mallTrade.setPaymentPoint(amount * mallGoodsSku.getPoint());
            }else{
                mallTrade.setFee(mallGoods.getPrice());
                mallTrade.setFeePoint(mallGoods.getPoint());
                mallTrade.setPaymentPoint(amount * mallGoods.getPoint());
            }
            mallTrade.setPayment(0L);             //TODO 目前不支持付款
            mallTrade.setShippingType("free");
            mallTrade.setShippingFee(0L);
            mallTrade.setModified(new Date());
//            DataSource ds = dataSourceTransactionManager.getDataSource();
            mallTradeMapper.insertSelective(mallTrade);
            MallOrder mallOrder = new MallOrder();
            mallOrder.setSellerId(sellerId);
            mallOrder.setUserId(userId);
            mallOrder.setTid(mallTrade.getTid());
            if(mallGoodsSku != null) {
                mallOrder.setGoodsId(mallGoodsSku.getGoodsId());
                mallOrder.setSkuId(mallGoodsSku.getSkuId());
            }else{
                mallOrder.setGoodsId(mallGoods.getGoodsId());
                mallOrder.setSkuId(null);
            }
            mallOrder.setQuantity(amount);
            int result5 = mallOrderMapper.insertSelective(mallOrder);
            if(result5 == 0){
                throw new ServiceException("插入订单数据[mall_order]失败");
            }
            num += result5;
            //生成point_exchange数据
            if(StringUtils.isBlank(source)) {       //摇一摇礼物或者生日礼物兑换不写数据
                PointExchange pointExchange = new PointExchange();
                if (mallGoodsSku != null) {
                    pointExchange.setPointAmount(amount * mallGoodsSku.getPoint());
                } else {
                    pointExchange.setPointAmount(amount * mallGoods.getPoint());
                }
                pointExchange.setSellerId(sellerId);
                pointExchange.setUserId(userId);
                pointExchange.setExchangeId(mallOrder.getOid());
                pointExchange.setExchangeMethod("goods");
                pointExchange.setExchangePresentAmount(new Long(amount));   //商品记录数量， 红包记录金额
                pointExchange.setStatus("success");
                int result6 = pointExchangeMapper.insertSelective(pointExchange);
                if (result6 == 0) {
                    throw new ServiceException("插入积分兑换数据[point_exchange]失败");
                }
            }
//        }catch(RuntimeException e){
//            e.printStackTrace();
//            logger.error(e.getMessage(),e);
//            throw e;
//        }
        return num;
    }

    /**
     * 查找某个用户的所有收件人信息
     *
     * @param sellerId
     * @param userId
     */
    @Override
    public List<MallReceiver> findMallReceiversByUserId(Long sellerId, Long userId) {
        AssertsUtil.notNull(sellerId,"findMallReceiversByUserId( sellerId is null)");
        AssertsUtil.notNull(userId,"findMallReceiversByUserId( userId is null)");
        MallReceiverExample example = new MallReceiverExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        example.setOrderByClause("is_default desc");
        List<MallReceiver> mallReceivers = mallReceiverMapper.selectByExample(example);
        return mallReceivers;
    }

    /**
     *  处理新收件人信息的添加
     *
     * @param sellerId
     * @param userId
     * @param mallReceiver
     */
    @Override
    @Transactional
    public Long handleAddAddress(Long sellerId, Long userId, MallReceiver mallReceiver) {
        AssertsUtil.check(mallReceiver!=null, "mallReceiver is null");
        MallReceiverExample  example = new MallReceiverExample();
        example.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andIsDefaultEqualTo("y");
        MallReceiver mallReceiver1 = new MallReceiver();
        mallReceiver1.setIsDefault("n");
        mallReceiverMapper.updateByExampleSelective(mallReceiver1,example); //默认收件人重置
        mallReceiverMapper.insert(mallReceiver);               //增加新的默认收件人
        return mallReceiver.getReceiverId();
    }

    /**
     * goods维度统计被兑换人数
     *
     * @param sellerId
     */
    @Override
    public List<GoodsSkuExchangeInfoDo> findAllGoodsExchangeInfoDo(Long sellerId) {
        return goodsSkuExchangeDao.findGoodsExchangePersonNum(sellerId);
    }

    /**
     * 积分兑换成功后更新userAccount表
     *
     * @param sellerId
     * @param userId
     * @param payPoint 消耗的积分
     */
    @Override
    @Transactional
    public int updateAfterExchangeSuccess(Long sellerId, Long userId, Long payPoint) {
        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);
        if (!CollectionUtils.isEmpty(userAccounts)) {
            UserAccount userAccount = userAccounts.get(0);
            UserAccountExample userAccountExample1 = new UserAccountExample();
            userAccountExample1.createCriteria().andIdEqualTo(userAccount.getId()).andUserAccountVersionEqualTo(userAccount.getUserAccountVersion());

            UserAccount userAccountUpdate = new UserAccount();
            userAccountUpdate.setPointAmountExpression("point_amount -" + payPoint);
            userAccountUpdate.setPointAmountExchangeExpression("point_amount_exchange +" + payPoint);
            userAccountUpdate.setUserAccountVersionExpression("user_account_version +" + 1);

            int result = userAccountMapper.updateByExampleSelective(userAccountUpdate, userAccountExample1);
            if (result == 0) {
                throw new ServiceException("userAccount 有效积分和已兑换积分更新失败");
            }
            return result;
        }
        return 0;
    }

    /**
     * 积分兑换红包成功后的操作
     * 1. 更新pointExchange状态
     * 2. 更新userAccount
     * @param userId
     * @param exchangeId
     */
    @Override
    @Transactional
    public int updateAfterPointExchangeHongBaoSuccess(Long sellerId,Long userId, Long exchangeId, String status) {

        AssertsUtil.check(userId != null,"userId is null");
        AssertsUtil.check(exchangeId != null,"exchangeId is null");
        AssertsUtil.check(StringUtils.isNotBlank(status),"status is null");
        PointExchange pointExchange = new PointExchange();
        pointExchange.setStatus(status);

        PointExchangeExample pointExchangeExample = new PointExchangeExample();
        pointExchangeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andExchangeIdEqualTo(exchangeId);
        int result = pointExchangeMapper.updateByExampleSelective(pointExchange,pointExchangeExample);

        List<PointExchange> pointExchanges = pointExchangeMapper.selectByExample(pointExchangeExample);
        if(!CollectionUtils.isEmpty(pointExchanges)){
            PointExchange pe = pointExchanges.get(0);
            updateAfterExchangeSuccess(sellerId,userId, pe.getPointAmount());
        }
        return result;
    }

}

