package com.shufensoft.crm.biz.service.pointmall;


import com.shufensoft.crm.biz.comparator.PointExchangeComparator;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.constant.PointConstant;
import com.shufensoft.crm.biz.dao.defined.point.PointExchangeDAO;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.point.PointExchangeMapper;
import com.shufensoft.crm.biz.dao.generation.point.PointObtainMapper;
import com.shufensoft.crm.biz.dao.generation.point.PointTransferMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserPortraitMapper;
import com.shufensoft.crm.biz.domain.defined.point.PointExchangeDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import com.shufensoft.crm.biz.domain.generation.point.*;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.integral.service.IntegralService;
import com.shufensoft.crm.biz.service.integral.vo.IntegralConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInPointConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInVO;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.pointmall.vo.PointStatisticsVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.PointExchangeVO;
import com.shufensoft.crm.biz.vo.PointObtainVO;
import com.shufensoft.crm.common.utils.*;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 *  积分服务
 * <p/>
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-19 21:43  
 */
@Service(value = "pointService")
public class PointService implements IPointService {

    private static final Logger logger = Logger.getLogger(PointService.class);

    // 最大积分转账限制
    private static final long MAX_AMOUNT = 1000000;

    @Autowired
    private UserAccountMapper userAccountMapper;


    @Autowired
    private PointTransferMapper pointTransferMapper;

    @Autowired
    private PointObtainMapper pointObtainMapper;

    @Autowired
    private HBObtainMapper hBObtainMapper;

    @Autowired
    private PointExchangeMapper pointExchangeMapper;


    @Autowired
    private IntegralService integralService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointExchangeDAO pointExchangeDAO;

    @Autowired
    private UserPortraitMapper userPortraitMapper;

    @Autowired
    private UserService userService;


    public static Long DEFAULT_GET_LOCK_TIME_OUT = 10000L;

    public static String CONCURRENT_LOCK_TYPE = "CONCURRENT_LOCK";

    public static String GET_LOCK_TIME_OUT_NAME = "getLockTimeOut";

    /**
     * 积分转让，商户向用户的转让，转让id不可知情况下调用
     *
     * @param sellerId
     * @param toUserId
     * @param amount
     * @param method
     * @return
     */
    public boolean transfer(long sellerId, long toUserId, int amount, String method) {
        return transfer(sellerId, toUserId, amount, method, 0L);
    }

    /**
     * 积分转让，商户向用户的转让
     *
     * @param sellerId
     * @param toUserId
     * @param amount
     * @param method
     * @param methodId
     * @return
     */
    @Transactional
    public boolean transfer(long sellerId, long toUserId, long amount, String method, long methodId) throws ServiceException {
        if (sellerId <= 0 || toUserId <= 0 || amount <= 0 || amount > MAX_AMOUNT) {
            logger.error("illegal argument: " + sellerId + ", " + toUserId + ", " + amount);
            return false;
        }

        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(toUserId);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
        if (CollectionUtils.isEmpty(userAccountList) || userAccountList.size() > 1) {
            logger.error("user not found: " + sellerId + ", " + toUserId);
            return false;
        }

        // update user_account set gmt_modified = now(), point_amount += ?, point_amount_total += ? where seller_id = ? and user_id = ?
        UserAccount userAccount = new UserAccount();
        userAccount.setPointAmountExpression("point_amount + " + amount);
        userAccount.setPointAmountTotalExpression("point_amount_total + " + amount);
        int updateResult = userAccountMapper.updateByExampleSelective(userAccount, userAccountExample);
        if (updateResult != 1) {
            logger.error("userAccount update fail: " + sellerId + ", " + toUserId);
            throw new ServiceException("userAccount update fail: " + sellerId + ", " + toUserId);
        }

        insertPointTransfer(sellerId, 0L, toUserId, amount, method, methodId);

        insertPointObtain(sellerId, 0L, toUserId, amount, method, methodId);

        return true;
    }

    /**
     * 积分转让，用户与用户之间的转让，在转让id无法确定的情况下调用
     *
     * @param sellerId
     * @param fromUserId
     * @param toUserId
     * @param amount
     * @param method
     * @return
     */
    public boolean transfer(long sellerId, long fromUserId, long toUserId, long amount, String method) {
        return transfer(sellerId, fromUserId, toUserId, amount, method, 0L);
    }

    /**
     * 积分转让，用户与用户之间的转让
     *
     * @param sellerId
     * @param fromUserId 转让方
     * @param toUserId   受让方
     * @param amount     转让积分数量
     * @param method
     * @param methodId
     * @return
     */
    @Transactional
    public boolean transfer(long sellerId, long fromUserId, long toUserId, long amount, String method,
                            long methodId) throws ServiceException {
        if (sellerId <= 0 || fromUserId <= 0 || toUserId <= 0 || amount <= 0 || amount > MAX_AMOUNT) {
            logger.error("illegal argument: " + sellerId + ", " + fromUserId + ", " + toUserId + ", " + amount);
            return false;
        }

        UserAccountExample toUserAccountExample = new UserAccountExample();
        toUserAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(toUserId);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(toUserAccountExample);
        if (CollectionUtils.isEmpty(userAccountList) || userAccountList.size() > 1) {
            logger.error("toUser not found: " + sellerId + ", " + toUserId);
            return false;
        }

        UserAccountExample fromUserAccountExample = new UserAccountExample();
        fromUserAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(fromUserId);
        userAccountList = userAccountMapper.selectByExample(fromUserAccountExample);
        if (CollectionUtils.isEmpty(userAccountList) || userAccountList.size() > 1) {
            logger.error("fromUser not found: " + sellerId + ", " + fromUserId);
            return false;
        }

        UserAccount fromUserAccount = userAccountList.get(0);

        if (amount > fromUserAccount.getPointAmount()) {
            logger.error("fromUser account amount is not enough: " + sellerId + ", " + fromUserId);
            return false;
        }

        // 为避免死锁，用统一顺序加锁，包括所有积分相关的表与记录
        if (fromUserId < toUserId) {
            handleFromUser(sellerId, fromUserId, amount);
            handleToUser(sellerId, toUserId, amount);
        } else {
            handleToUser(sellerId, toUserId, amount);
            handleFromUser(sellerId, fromUserId, amount);
        }

        insertPointTransfer(sellerId, fromUserId, toUserId, amount, method, methodId);

        insertPointObtain(sellerId, fromUserId, toUserId, amount, method, methodId);

        return false;
    }

    private void insertPointTransfer(long sellerId, long fromUserId, long toUserId, long amount, String method, long methodId) {
        // insert into point_transfer
        // (id, gmt_created, gmt_modified, created_by, modified_by, is_deleted, seller_id, user_id, to_user_id, gmt_transfer, transfer_method, transfer_method_id)
        // values (...)
        PointTransfer pointTransfer = new PointTransfer();
        pointTransfer.setSellerId(sellerId);
        pointTransfer.setUserId(fromUserId);
        pointTransfer.setToUserId(toUserId);
        pointTransfer.setGmtTransfer(new Date());
        pointTransfer.setAmount(amount);
        pointTransfer.setTransferMethod(method);
        pointTransfer.setTransferMethodId(methodId);
        int insertResult = pointTransferMapper.insert(pointTransfer);
        if (insertResult != 1) {
            logger.error("pointTransfer insert fail: " + sellerId + ", " + toUserId);
            throw new ServiceException("pointTransfer insert fail: " + sellerId + ", " + toUserId);
        }
    }

    private void insertPointObtain(long sellerId, long fromUserId, long toUserId, long amount, String method, long methodId) {
        // insert into point_obtain
        // (id, gmt_created, gmt_modified, created_by, modified_by, is_deleted, seller_id, user_id, transferer_id, gmt_transfer, amount, amount_consumed, gmt_expired, status, obtain_mehtod, obtain_mehtod_id)
        // values(...)
        PointObtain pointObtain = new PointObtain();
        pointObtain.setSellerId(sellerId);
        pointObtain.setUserId(toUserId);
        pointObtain.setTransfererId(fromUserId);
        pointObtain.setGmtTransfer(new Date());
        pointObtain.setAmount(amount);
        pointObtain.setAmountConsumed(0L);
        pointObtain.setGmtExpired(DateUtil.getExpiredDay(365));
        pointObtain.setStatus(DaoConstant.Status.VALID);
        pointObtain.setObtainMethod(method);
        pointObtain.setObtainMethodId(methodId);
        int insertResult = pointObtainMapper.insert(pointObtain);
        if (insertResult != 1) {
            logger.error("pointObtain insert fail: " + sellerId + ", " + toUserId);
            throw new ServiceException("pointObtain insert fail: " + sellerId + ", " + toUserId);
        }
    }

    private void handleToUser(long sellerId, long toUserId, long amount) {
        // update user_account set gmt_modified = now(), point_amount += ?, point_amount_total += ? where seller_id = ? and user_id = ?
        // if updateResult != 1 rollback
        UserAccount userAccount = new UserAccount();
        userAccount.setPointAmountExpression("point_amount + " + amount);
        userAccount.setPointAmountTransferredExpression("point_amount_transferred + " + amount);
        UserAccountExample toUserAccountExample = new UserAccountExample();
        toUserAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(toUserId);
        int updateResult = userAccountMapper.updateByExampleSelective(userAccount, toUserAccountExample);
        if (updateResult != 1) {
            logger.error("userAccount update fail: " + sellerId + ", " + toUserId);
            throw new ServiceException("userAccount update fail: " + sellerId + ", " + toUserId);
        }
    }

    private void handleFromUser(long sellerId, long fromUserId, long amount) {
        // update user_account set gmt_modified = now(), point_amount -= ?, point_amount_transferred += ? where seller_id = ? and user_id = ? and point_amount >= ?
        // if updateResult != 1 rollback
        UserAccount userAccount = new UserAccount();
        userAccount.setPointAmountExpression("point_amount - " + amount);
        userAccount.setPointAmountTransferredExpression("point_amount_transferred + " + amount);
        UserAccountExample fromUserAccountExample = new UserAccountExample();
        fromUserAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(fromUserId).andPointAmountGreaterThan(amount);
        int updateResult = userAccountMapper.updateByExampleSelective(userAccount, fromUserAccountExample);
        if (updateResult != 1) {
            logger.error("userAccount update fail: " + sellerId + ", " + fromUserId);
            throw new ServiceException("userAccount update fail: " + sellerId + ", " + fromUserId);
        }
    }

    /**
     * 兑换积分，包括兑换红包，购物等所有的积分消耗
     *
     * @param sellerId
     * @param userId
     * @param amount
     * @param method   红包：hongbao 购物：trade
     * @param methodId
     * @return
     * @Param exchangeName 兑换名称
     */
    @Transactional
    public boolean exchange(long sellerId, long userId, long amount, String method, long methodId, String exchangeName) {

        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
        if (CollectionUtils.isEmpty(userAccountList) || userAccountList.size() > 1) {
            logger.error("inconsistent data: " + sellerId + "," + userId);
            throw new ServiceException("inconsistent data: " + sellerId + "," + userId);
        }
        UserAccount userAccount = userAccountList.get(0);
        if (userAccount.getPointAmount() < amount) {
            logger.error("insufficient point: " + sellerId + "," + userId);
            return false;
        }

        // update user_account set point_amount -= ? where seller_id = ? and user_id = ? and point_amount >= ?
        userAccount = new UserAccount();
        userAccount.setPointAmountExpression("point_amount - " + amount);
        userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andPointAmountGreaterThanOrEqualTo(amount);
        int updateResult = userAccountMapper.updateByExampleSelective(userAccount, userAccountExample);
        if (updateResult != 1) {
            logger.error("userAccount update fail: " + sellerId + ", " + userId);
            throw new ServiceException("userAccount update fail: " + sellerId + ", " + userId);
        }

        // insert into point_exchange
        PointExchange pointExchange = new PointExchange();
        pointExchange.setSellerId(sellerId);
        pointExchange.setUserId(userId);
        pointExchange.setPointAmount(amount);
        pointExchange.setExchangeId(methodId);
        pointExchange.setExchangeMethod(method);
        pointExchange.setStatus(DaoConstant.Status.VALID);
        int insResult = pointExchangeMapper.insert(pointExchange);
        if (insResult <= 0) {
            logger.error("pointExchange insert fail: " + sellerId + ", " + userId);
            throw new ServiceException("pointExchange insert fail: " + sellerId + ", " + userId);
        }

        return true;
    }


//    /**
//     * 创建购物积分
//     *
//     * @param startDate
//     * @param endDate
//     * @param sellerId
//     */
//    public void createBuyPoint(Date startDate, Date endDate, Long sellerId) {
//
//        // 购物得积分
//        IntegralConfigVO integralConfigVO = integralService.queryPointRule(sellerId);
//
//        UserPortraitExample userPortraitExample = new UserPortraitExample();
//        UserPortraitExample.Criteria criteria = userPortraitExample.createCriteria();
//
//        criteria.andLastPurchaseDateLessThan(endDate);
//        criteria.andLastPurchaseDateGreaterThanOrEqualTo(startDate);
//
//
//        List<UserPortrait> userPortraits = userPortraitMapper.selectByExample(userPortraitExample);
//        if (userPortraits != null && !userPortraits.isEmpty()) {
//            for (UserPortrait userPortrait : userPortraits) {
//
//                Long userId = getUserIdByUserPortraitsId(userPortrait.getUserPortraitId());
//                long amount = userPortrait.getTotalPurchaseAmount();
//                long convertMonry = Long.valueOf(integralConfigVO.getConertMoney());
//
//                Long point = CommonUtil.longMultiply(amount, convertMonry).longValue();
//
//                createOrUpdatePointObtain(sellerId, userId, point, DaoConstant.PointObtainMethod.SHOPPING, userId);
//            }
//
//        }
//
//    }


    /**
     * 从订单获取并创建购物积分
     *
     * @param sellerId    商户ID
     * @param orderUserId 订单ID
     * @param type        订单类型，JD、TB、YZ
     * @param buyMoney    购买金额
     * @param tradeId     订单ID
     */
    @Override
    @Transactional
    public void tradeToCreateBuyPoint(Long sellerId, Long orderUserId, String type, Long buyMoney, Long tradeId) {

        User user = null;

        try {
            if (DaoConstant.UserSource.JD.equals(type)) {
                user = userService.getUserByJdUserId(sellerId, orderUserId);
            } else if (DaoConstant.UserSource.TB.equals(type)) {
                user = userService.getUserByTbUserId(sellerId, orderUserId);
            } else if (DaoConstant.UserSource.YZ.equals(type)) {
                user = userService.getUserByYzUserId(sellerId, orderUserId);
            } else {
                throw new ServiceException("type is invalid.");
            }


            if (user != null) {

                if (DaoConstant.WxSubscribe.YES.equals(user.getWxSubscribe()) && "1".equals(user.getIsVerify())) {
                    createBuyPoint(sellerId, user.getUserId(), buyMoney, Long.valueOf(tradeId));
                }

            }

        } catch (Exception e) {
            throw new ServiceException("购物订单转积分出错。");
        }

    }

    /**
     * 创建购物积分
     *
     * @param sellerId       商户ID
     * @param userId         用户ID
     * @param buyMoney       购物金额，单位元
     * @param obtainMethodId 获取方式ID
     */
    @Override
    public void createBuyPoint(Long sellerId, Long userId, Long buyMoney, Long obtainMethodId) {

        try {
            IntegralConfigVO integralConfigVO = integralService.queryPointRule(sellerId);


            List<PointObtain> pointObtainList = getPointObtainByObtainMethodId(sellerId, userId, obtainMethodId);

            /**
             * 如果这个订单已换算过购物积分，则不需重复获得
             */
            if (pointObtainList != null && !pointObtainList.isEmpty()) {

                logger.info("pointService.createBuyPoint() 订单" + obtainMethodId + "购物积分已存在。");
                return;
            }

            long convertMonry = Long.valueOf(integralConfigVO.getConertMoney());

            Long point = CommonUtil.longMultiply(buyMoney, convertMonry).longValue();

            insertPointObtain(sellerId, userId, point, DaoConstant.PointObtainMethod.SHOPPING, obtainMethodId);

            logger.info("userId:" + userId + " create buyPoint is successful.");
        } catch (Exception e) {

            throw new ServiceException("pointService.createBuyPoint() is error.");
        }

    }


    /**
     * 创建关注送积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     */
    public void createSubscribePoint(Long sellerId, Long userId) {

        IntegralConfigVO integralConfigVO = integralService.queryPointRule(sellerId);

        long point = Long.valueOf(integralConfigVO.getAttentionIntegral());

        try {

            createPointObtain(sellerId, userId, point, DaoConstant.PointObtainMethod.SUBSCRIBE, userId);
        } catch (Exception e) {

            logger.error("userId:" + userId + "createSubscribePoint error", e);
        }


    }


    /**
     * 签到送积分
     *
     * @param sellerId
     * @param userId
     */
    @Transactional
    public int creteSignPoint(Long sellerId, Long userId) {

        int code = -1;

        SignInPointConfigVO signInPointConfigVO = integralService.querySignInPointRule(sellerId);

        if (signInPointConfigVO != null) {

            List<SignInVO> signInVOList = signInPointConfigVO.getSignInVOList();
            if (signInVOList != null && !signInVOList.isEmpty()) {

                Collections.reverse(signInVOList);

                for (SignInVO signInVO : signInVOList) {
                    PointObtainExample pointObtainExample = new PointObtainExample();
                    PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
                    criteria.andSellerIdEqualTo(sellerId);
                    criteria.andUserIdEqualTo(userId);
                    criteria.andObtainMethodEqualTo(DaoConstant.PointObtainMethod.SIGN_IN);
                    criteria.andGmtTransferBetween(DateUtil.getNDayStartTime(Integer.valueOf(signInVO.getSignInTimes()) - 1), DateUtil.getNDayEndTime(0));
                    List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);

                    if (pointObtainList != null && !pointObtainList.isEmpty()) {

                        if (pointObtainList.size() == Integer.valueOf(signInVO.getSignInTimes()) - 1) {

                            insertPointObtain(sellerId, userId, Long.valueOf(signInVO.getPoint()), DaoConstant.PointObtainMethod.SIGN_IN, userId);

                            // 更新用户画像表
                            int portraitCount = insertOrUpdateUserPortrait(sellerId, userId, 1);
                            if (portraitCount != 1) {
                                throw new ServiceException("用户画像表更新失败，回退。");
                            }

                            return Integer.valueOf(signInVO.getPoint());

                        } else {

                            continue;
                        }

                    } else {

                        if ("1".equals(signInVO.getSignInTimes())) {

                            insertPointObtain(sellerId, userId, Long.valueOf(signInVO.getPoint()), DaoConstant.PointObtainMethod.SIGN_IN, userId);

                            // 更新用户画像表
                            int portraitCount = insertOrUpdateUserPortrait(sellerId, userId, 1);

                            if (portraitCount != 1) {

                                throw new ServiceException("用户画像表更新失败，回退。");
                            }

                            return Integer.valueOf(signInVO.getPoint());

                        }
                        continue;

                    }
                }

            }
        }
        return code;
    }


    /**
     * 根据用户画像ID查询用户ID
     *
     * @param portraitsId 画像ID
     * @return
     */
    private Long getUserIdByUserPortraitsId(Long portraitsId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserPortraitIdEqualTo(portraitsId);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.isEmpty()) {
            return null;
        }
        return userList.get(0).getUserId();
    }


    /**
     * 今天是否已签到
     *
     * @param sellerId
     * @param userId
     * @return
     */
    private boolean isTodaySignIn(Long sellerId, Long userId) {

        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdEqualTo(userId);
        criteria.andGmtTransferBetween(DateUtil.getNDayStartTime(0), DateUtil.getNDayEndTime(0));
        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);
        if (pointObtainList != null && !pointObtainList.isEmpty()) {
            return true;
        }

        return false;

    }


    /**
     * 用户否领取过关注积分
     *
     * @param userId
     * @return
     */
    public boolean isUserSubscribePoint(Long sellerId, Long userId) {

        PointObtainExample pointObtainExample = new PointObtainExample();
        pointObtainExample.createCriteria().andUserIdEqualTo(userId).andObtainMethodEqualTo(DaoConstant.PointObtainMethod.SUBSCRIBE).andSellerIdEqualTo(sellerId);
        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);

        if (pointObtainList != null && !pointObtainList.isEmpty()) {
            return true;
        }

        return false;
    }

    @Override
    public List<PointExchangeVO> queryPointExchaneStatistics(Long sellerId, int lastDays) {

        AssertsUtil.check(lastDays > 0, "lastDays is less than zero");
        Date lastDate = DateUtils.addDays(new Date(), -lastDays);

        List<PointExchangeDO> pointExchangeDOs = pointExchangeDAO.queryPointExchaneStatistics(sellerId, lastDate);

        return fillDays(BeanCopierUtils.copyListProperties(pointExchangeDOs, PointExchangeVO.class), lastDays);

    }

    private List<PointExchangeVO> fillDays(List<PointExchangeVO> pointExchangeVOs, int lastDays) {

        if (CollectionUtils.isEmpty(pointExchangeVOs)) {
            pointExchangeVOs = new ArrayList<PointExchangeVO>();
        }

        Date startDate = DateUtil.getNDayStartTime(lastDays - 1);

        for (int i = 0; i < lastDays; i++) {
            String date = DateUtil.dateToShortStr(DateUtils.addDays(startDate, i));
            if (i > pointExchangeVOs.size() - 1 || isNotHasDay(pointExchangeVOs, date)) {
                PointExchangeVO pointExchangeVO = new PointExchangeVO();
                pointExchangeVO.setDay(date);
                pointExchangeVO.setTotalExchangePoint(0l);
                pointExchangeVO.setTotalExchangeCount(0l);
                pointExchangeVOs.add(pointExchangeVO);
            }
        }

        Collections.sort(pointExchangeVOs, new PointExchangeComparator());
        return pointExchangeVOs;
    }

    private boolean isNotHasDay(List<PointExchangeVO> pointExchangeVOs, String date) {

        AssertsUtil.check(!CollectionUtils.isEmpty(pointExchangeVOs), "pointExchangeVOs is empty");

        for (PointExchangeVO pointExchangeVO : pointExchangeVOs) {
            if (date.equals(pointExchangeVO.getDay())) {
                return false;
            }
        }

        return true;
    }


    /**
     * 获取提醒的生日时间
     *
     * @return
     */
    private Date getRemindBirthday(int lastDays) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE) - lastDays;
        return DateUtil.strToDate(year + "-" + month + "-" + day);

    }


//    public void createShoppingPoint(Long sellerId, Long userId,){
//        IntegralConfigVO integralConfigVO = integralService.queryPointRule(sellerId);
//    }

    /**
     * 增加积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param method   方式
     * @param methodId 方式ID
     */
    @Transactional
    public void createPoint(Long sellerId, Long userId, String method, Long methodId) {

        IntegralConfigVO integralConfigVO = integralService.queryPointRule(sellerId);


        if (integralConfigVO == null) {
            throw new ServiceException("未找到积分规则配置。");
        }


        if (PointConstant.POINT_OBTAIN_METHOD_QD.equals(method)) {

            creteSignPoint(sellerId, userId);

        } else if (DaoConstant.PointObtainMethod.SHOPPING.equals(method)) {


            if (StringUtils.isNotEmpty(integralConfigVO.getConertMoney())) {

                //insertPointObtain(sellerId, userId, , PointConstant.POINT_OBTAIN_METHOD_GW, methodId);

            }

        } else if (PointConstant.P0INT_OBTAIN_METHOD_FX.equals(method)) {

            // 分享得积分
            if (StringUtils.isNotEmpty(integralConfigVO.getSpreadIntegral())) {
                Long amount = Long.valueOf(integralConfigVO.getSpreadIntegral());
                insertPointObtain(sellerId, userId, amount, PointConstant.P0INT_OBTAIN_METHOD_FX, methodId);
            }
        } else if (PointConstant.POINT_OBTAIN_METHOD_GZ.equals(method)) {
            // 关注得积分
            if (StringUtils.isNotEmpty(integralConfigVO.getAttentionIntegral())) {
                Long amount = Long.valueOf(integralConfigVO.getAttentionIntegral());
                insertPointObtain(sellerId, userId, amount, PointConstant.POINT_OBTAIN_METHOD_GZ, methodId);
            }
        } else if (PointConstant.POINT_OBTAIN_METHOD_SQ.equals(method)) {
            // 首次加入社群
            if (StringUtils.isNotEmpty(integralConfigVO.getGroupIntegral())) {
                Long amount = Long.valueOf(integralConfigVO.getGroupIntegral());
                insertPointObtain(sellerId, userId, amount, PointConstant.POINT_OBTAIN_METHOD_SQ, methodId);


            }
        }
    }


//    /**
//     * 创建或更新积分明细表，用于购物积分
//     *
//     * @param sellerId
//     * @param userId
//     * @param amount
//     * @param method
//     * @param mehoId
//     */
//    public void createOrUpdatePointObtain(long sellerId, long userId, long amount, String method, long mehoId) {
//
//        PointObtainExample pointObtainExample = new PointObtainExample();
//        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
//        criteria.andUserIdEqualTo(userId);
//        criteria.andObtainMethodEqualTo(DaoConstant.PointObtainMethod.SHOPPING);
//        criteria.andSellerIdEqualTo(sellerId);
//        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);
//
//        if (pointObtainList != null && !pointObtainList.isEmpty()) {
//
//            PointObtain pointObtain = pointObtainList.get(0);
//            pointObtain.setAmount(amount);
//            pointObtain.setGmtTransfer(new Date());
//            pointObtainMapper.updateByPrimaryKey(pointObtain);
//
//            logger.info("更新用户购物积分成功。");
//
//        } else {
//
//            insertPointObtain(sellerId, userId, amount, method, mehoId);
//
//            logger.info("新增用户购物积分成功。");
//        }
//    }

    /**
     * 删除积分获取表初始化信息
     *
     * @param obtainMethodId
     */
    public void deletePointObtain(Long sellerId, Long obtainMethodId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        pointObtainExample.createCriteria().andObtainMethodIdEqualTo(obtainMethodId).andSellerIdEqualTo(sellerId);
        pointObtainMapper.deleteByExample(pointObtainExample);
    }

    /**
     * 创建积分，支持自定义过期时间
     *
     * @param sellerId   商户ID
     * @param userId     用户ID
     * @param amount     积分数
     * @param expiredDay 过期日期
     * @param method     方式
     * @param methodId   积分来源ID
     */
    public void createPointObtain(Long sellerId, Long userId, Long amount, Date expiredDay, String method, Long methodId) {

        AssertsUtil.notNull(sellerId, "sellerId");
        AssertsUtil.notNull(userId, "userId");
        AssertsUtil.notNull(amount, "amount");
        AssertsUtil.notNull(expiredDay, "expiredDay");
        AssertsUtil.notNull(method, "method");
        AssertsUtil.notNull(methodId, "methodId");


        PointObtain pointObtain = new PointObtain();
        pointObtain.setSellerId(sellerId);

        pointObtain.setUserId(userId);

        pointObtain.setAmount(amount);
        pointObtain.setObtainMethod(method);
        pointObtain.setObtainMethodId(methodId);
        pointObtain.setAmountConsumed(0L);
        pointObtain.setGmtExpired(expiredDay);
        pointObtain.setTransfererId(Long.valueOf(0));
        pointObtain.setGmtTransfer(new Date());
        if (DaoConstant.PointObtainMethod.SHAKE.equals(method)) {
            pointObtain.setStatus(DaoConstant.Status.INVALID);
        } else {
            pointObtain.setStatus(DaoConstant.Status.VALID);
        }

        try {
            pointObtainMapper.insertSelective(pointObtain);
        } catch (Exception e) {
            throw new ServiceException("增加积分明细异常，回退.");
        }

    }

    /**
     * 创建积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param amount   积分数
     * @param method   方式
     * @param methodId 方式ID
     */
    public void createPointObtain(Long sellerId, Long userId, Long amount, String method, Long methodId) {

        // 默认的积分过期时间为365天
        createPointObtain(sellerId, userId, amount, DateUtil.getExpiredDay(365), method, methodId);
    }


    /**
     * 增加积分，支持乐观锁，支持重试机制
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param amount   积分数量
     * @param method   获取方式
     * @param methodId 获取ID
     */
    @Transactional
    public void insertPointObtain(long sellerId, long userId, long amount, String method, long methodId) {

        createPointObtain(sellerId, userId, amount, method, methodId);

        // 更新用户帐户表积分
        int code = updateUserAccountPoint(sellerId, userId, amount, "OBTAIN");
        if (1 != code) {
            throw new ServiceException("更新用户帐户表失败，回退");
        }

    }


    public Map<String, Object> getUserAccountInfoByMobile(String mobile) {

        Map<String, Object> objectMap = null;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andMobileEqualTo(mobile);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && !userList.isEmpty()) {
            objectMap = new HashMap<String, Object>();
            User user = userList.get(0);
            UserAccountExample userAccountExample = new UserAccountExample();
            userAccountExample.createCriteria().andUserIdEqualTo(user.getUserId());
            List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
            if (userAccountList != null && !userAccountList.isEmpty()) {
                objectMap.put("userAccount", userAccountList.get(0));
                return objectMap;
            }
        }
        return objectMap;
    }

    @Override
    public void createPoint(Long sellerId, Long userId, String method, Long methodId, Integer times) {

    }


    /**
     * 根据商户和用户ID查询用户帐户表
     *
     * @param sellerId
     * @param userId
     * @return
     */
    public UserAccount getUserAccountInfo(long sellerId, long userId) {
        UserAccountExample userAccountExample = new UserAccountExample();
        UserAccountExample.Criteria criteria = userAccountExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andSellerIdEqualTo(sellerId);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(userAccountExample);
        if (userAccountList != null && !userAccountList.isEmpty()) {
            return userAccountList.get(0);
        }
        return null;
    }


    /**
     * 更新用户帐户积分，如果没有帐户进行创建新帐户，乐观锁，支持重试机制
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param count    积分数
     * @param doFlag   动作： 消费(减积分余额)：DEDUCT 、
     *                 积分获取(增加总额和余额)：OBTAIN 、
     *                 积分兑换(增加累积兑换、减积分余额):exchange
     * @return
     */
    public int updateUserAccountPoint(long sellerId, long userId, Long count, String doFlag) {

        int upNum = -1;  // 数据库更新返回数

        int reTryNum = 1;  // 重试次数
        int doNum = 0;  // 执行计数
        do {
            UserAccount userAccountQuery = getUserAccountInfo(sellerId, userId);

            if (userAccountQuery == null) {
                //throw new ServiceException("未找到相关用户信息");
                UserAccount userAccount = new UserAccount();
                userAccount.setUserId(userId);
                userAccount.setSellerId(sellerId);
                userAccount.setPointAmount(count);
                userAccount.setPointAmountTotal(count);
                return userAccountMapper.insertSelective(userAccount);

            } else {

                UserAccountExample userAccountExample = new UserAccountExample();

                UserAccountExample.Criteria criteria = userAccountExample.createCriteria();
                criteria.andSellerIdEqualTo(sellerId);
                criteria.andUserIdEqualTo(userId);
                criteria.andUserAccountVersionEqualTo(userAccountQuery.getUserAccountVersion());

                UserAccount userAccount = new UserAccount();

                if (DaoConstant.PointUpdateMethod.DEDUCT.equals(doFlag)) {

                    userAccount.setPointAmountExpression("point_amount -" + count);
                    userAccount.setUserAccountVersionExpression("user_account_version" + 1);
                } else if (DaoConstant.PointUpdateMethod.OBTAIN.equals(doFlag)) {

                    userAccount.setPointAmountTotalExpression("point_amount_total +" + count);
                    userAccount.setPointAmountExpression("point_amount +" + count);
                    userAccount.setUserAccountVersionExpression("user_account_version +" + 1);
                } else if (DaoConstant.PointUpdateMethod.EXCHANGE.equals(doFlag)) {

                    userAccount.setPointAmountExchangeExpression("point_amount_exchange +" + count);
                    userAccount.setPointAmountExpression("point_amount -" + count);
                    userAccount.setUserAccountVersionExpression("user_account_version" + 1);
                } else {
                    return -1;
                }

                upNum = userAccountMapper.updateByExampleSelective(userAccount, userAccountExample);
            }


            // 更新成功
            if (1 == upNum) {
                logger.info("用户ID：" + userId + ",更新成功。");

                if (0 < doNum) {
                    logger.info("用户ID：" + userId + "更新并发重试" + doNum + "次成功。");
                }
                break;
            }
            doNum++;
        } while (doNum <= reTryNum);

        return upNum;

    }

    /**
     * 根据userId,和摇一摇活动ID查询积分获取明细初始化数据
     *
     * @param rockId 摇一摇ID
     * @param userId 用户ID
     * @return
     */
    public List<PointObtain> getPointObtainByMethodId(Long sellerId, Long rockId, Long userId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andObtainMethodIdEqualTo(rockId);
        criteria.andUserIdEqualTo(Long.valueOf(0));
        return pointObtainMapper.selectByExample(pointObtainExample);
    }

    /**
     * 根据Id,查询积分获取明细
     *
     * @param pointObtainId 积分明细ID
     * @return
     */
    public List<PointObtain> getPointObtainById(Long pointObtainId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();

        criteria.andIdEqualTo(pointObtainId);
        return pointObtainMapper.selectByExample(pointObtainExample);
    }

    /**
     * 根据obtainId查询积分明细
     *
     * @param sellerId 商户ID
     * @param obtainId 积分明细ID
     * @return 积分信息
     */
    public PointObtain getPointObtainByObtainId(Long sellerId, Long obtainId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andIdEqualTo(obtainId);
        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);
        if (CollectionUtils.isEmpty(pointObtainList)) {
            return null;
        }

        return pointObtainList.get(0);

    }


    /**
     * 根据获取方式ID查询积分明细
     *
     * @param sellerId       商户ID
     * @param userId         用户ID
     * @param obtainMethodId 积分获取方式ID
     * @return
     */
    public List<PointObtain> getPointObtainByObtainMethodId(Long sellerId, Long userId, Long obtainMethodId) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        criteria.andObtainMethodIdEqualTo(obtainMethodId);
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdEqualTo(userId);

        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);

        if (pointObtainList != null && !pointObtainList.isEmpty()) {
            return pointObtainList;
        }
        return null;
    }


    /**
     * 更新积分明细,领积分
     *
     * @param pointObtainId 积分获取明细ID
     * @return 积分数
     */
    public Long updatePointObtain(Long sellerId, Long pointObtainId) {

        //LstOfVal lstOfVal = LstOfValCache.getLOV(CONCURRENT_LOCK_TYPE, GET_LOCK_TIME_OUT_NAME);

        long getLockTimeOut = 0;
        //if (lstOfVal == null || com.shufensoft.crm.common.utils.StringUtils.isBlank(lstOfVal.getValue()) || !NumberUtils.isNumber(lstOfVal.getValue())) {
        getLockTimeOut = DEFAULT_GET_LOCK_TIME_OUT;

        //}

        long start = System.currentTimeMillis();

        PointObtain pointObtain = null;

        int reCode = -1;  // 数据库更新返回数

        long endTime = 0l;

        do {
            List<PointObtain> pointObtainList = null;

            pointObtainList = getPointObtainById(pointObtainId);

            if (pointObtainList == null || pointObtainList.isEmpty()) {

                throw new ServiceException("未找到积分获取的初始化信息");
            }

            pointObtain = pointObtainList.get(0);

            PointObtainExample pointObtainExample = new PointObtainExample();
            PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
            criteria.andPointObtainVersionEqualTo(pointObtain.getPointObtainVersion());
            criteria.andIdEqualTo(pointObtain.getId());
            criteria.andSellerIdEqualTo(sellerId);

            PointObtain pointObtainUpDate = new PointObtain();
            pointObtainUpDate.setStatus("y");

            pointObtainUpDate.setPointObtainVersionExpression("point_obtain_version+1");

            reCode = pointObtainMapper.updateByExampleSelective(pointObtainUpDate, pointObtainExample);

            // 更新成功
            if (1 == reCode) {
                break;
            }
            endTime = System.currentTimeMillis();

        } while (endTime - start <= getLockTimeOut);

        if (reCode != 1) {

            throw new ServiceException("积分获取明细更新失败。");
        }


        return pointObtain.getAmount();
    }

    /**
     * 抢积分，更新积分明细表，支持乐观锁，支持重试。
     *
     * @param userId   用户ID
     * @param rockId   摇一摇活动ID
     * @param isObtain 是否领取 Y：领取，N：待领
     * @return 返回积分获积明细的ID
     */
    public Long updatePointObtain(Long sellerId, Long userId, Long rockId, String isObtain) {


        Map<String, Object> obtainMap = new HashMap<String, Object>();

//        LstOfVal lstOfVal = LstOfValCache.getLOV(CONCURRENT_LOCK_TYPE, GET_LOCK_TIME_OUT_NAME);
//
        long getLockTimeOut = 0;
//        if (lstOfVal == null || com.shufensoft.crm.common.utils.StringUtils.isBlank(lstOfVal.getValue()) || !NumberUtils.isNumber(lstOfVal.getValue())) {
        getLockTimeOut = DEFAULT_GET_LOCK_TIME_OUT;

        // }

        long start = System.currentTimeMillis();

        PointObtain pointObtain = null;

        Long rePointId = -1l;

        int reCode = -1;  // 数据库更新返回数

        long endTime = 0l;

        do {
            List<PointObtain> pointObtainList = null;

            pointObtainList = getPointObtainByMethodId(sellerId, rockId, null);

            if (pointObtainList == null || pointObtainList.isEmpty()) {

                throw new ServiceException("未找到积分获取的初始化信息");
            }

            pointObtain = pointObtainList.get(0);

            PointObtainExample pointObtainExample = new PointObtainExample();
            PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
            criteria.andObtainMethodIdEqualTo(rockId);
            criteria.andPointObtainVersionEqualTo(pointObtain.getPointObtainVersion());
            criteria.andIdEqualTo(pointObtain.getId());
            criteria.andSellerIdEqualTo(sellerId);

            PointObtain pointObtainUpDate = new PointObtain();
            pointObtainUpDate.setUserId(userId);

            if (DaoConstant.ShakeObtainStatus.TO_RECEIVE.equals(isObtain)) {

                pointObtainUpDate.setStatus("n");
            } else {

                pointObtainUpDate.setStatus("y");
            }

            pointObtainUpDate.setPointObtainVersionExpression("point_obtain_version+1");

            reCode = pointObtainMapper.updateByExampleSelective(pointObtainUpDate, pointObtainExample);

            // 更新成功
            if (1 == reCode) {
                break;
            }

            endTime = System.currentTimeMillis();

        } while (endTime - start <= getLockTimeOut);

        if (reCode != 1) {

            throw new ServiceException("积分获取明细更新失败。");
        }

        rePointId = pointObtain.getId();

        return rePointId;
    }

    @Override
    public long sumPointObtain(PointObtainVO pointObtainVO) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        if (pointObtainVO.getStartDate() != null) {
            criteria.andGmtTransferGreaterThanOrEqualTo(pointObtainVO.getStartDate());
        }
        if (pointObtainVO.getEndDate() != null) {
            criteria.andGmtTransferLessThanOrEqualTo(pointObtainVO.getEndDate());
        }
        if (pointObtainVO.getUserId() != null) {
            criteria.andUserIdEqualTo(pointObtainVO.getUserId());
        }
        pointObtainExample.setDefinedQueryColumns(true);
        pointObtainExample.addSumAmountQueryColumn();

        List<PointObtain> pointObtains = pointObtainMapper.selectByExample(pointObtainExample);

        if (CollectionUtils.isEmpty(pointObtains)) {
            return 0;
        }

        return pointObtains.get(0) == null ? 0 : pointObtains.get(0).getSumAmount();
    }

    @Override
    public long countPointObtain(PointObtainVO pointObtainVO) {
        PointObtainExample pointObtainExample = new PointObtainExample();
        PointObtainExample.Criteria criteria = pointObtainExample.createCriteria();
        if (pointObtainVO.getStartDate() != null) {
            criteria.andGmtTransferGreaterThanOrEqualTo(pointObtainVO.getStartDate());
        }
        if (pointObtainVO.getEndDate() != null) {
            criteria.andGmtTransferLessThanOrEqualTo(pointObtainVO.getEndDate());
        }
        if (pointObtainVO.getUserId() != null) {
            criteria.andUserIdEqualTo(pointObtainVO.getUserId());
        }
        if (!StringUtils.isBlank(pointObtainVO.getObtainMethod())) {
            criteria.andObtainMethodEqualTo(pointObtainVO.getObtainMethod());
        }
        return pointObtainMapper.countByExample(pointObtainExample);
    }

    @Override
    public long sumPointExchange(PointExchangeVO pointExchangeVO) {
        PointExchangeExample pointExchangeExample = new PointExchangeExample();
        PointExchangeExample.Criteria criteria = pointExchangeExample.createCriteria();
        if (pointExchangeVO.getStartDate() != null) {
            criteria.andGmtCreatedGreaterThanOrEqualTo(pointExchangeVO.getStartDate());
        }
        if (pointExchangeVO.getEndDate() != null) {
            criteria.andGmtCreatedLessThanOrEqualTo(pointExchangeVO.getEndDate());
        }
        if (pointExchangeVO.getUserId() != null) {
            criteria.andUserIdEqualTo(pointExchangeVO.getUserId());
        }
        if (!StringUtils.isBlank(pointExchangeVO.getExchangeMethod())) {
            criteria.andExchangeMethodEqualTo(pointExchangeVO.getExchangeMethod());
        }
        if (!StringUtils.isBlank(pointExchangeVO.getStatus())) {
            criteria.andStatusEqualTo(pointExchangeVO.getStatus());
        }
        if (pointExchangeVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(pointExchangeVO.getSellerId());
        }

        pointExchangeExample.setDefinedQueryColumns(true);
        pointExchangeExample.addSumPointAmountQueryColumn();
        List<PointExchange> pointExchanges = pointExchangeMapper.selectByExample(pointExchangeExample);

        if (CollectionUtils.isEmpty(pointExchanges)) {
            return 0;
        }

        return pointExchanges.get(0) == null ? 0 : pointExchanges.get(0).getSumPointAmount();
    }

    @Override
    public long countPointExchange(PointExchangeVO pointExchangeVO) {
        PointExchangeExample pointExchangeExample = new PointExchangeExample();
        PointExchangeExample.Criteria criteria = pointExchangeExample.createCriteria();
        if (pointExchangeVO.getStartDate() != null) {
            criteria.andGmtCreatedGreaterThanOrEqualTo(pointExchangeVO.getStartDate());
        }
        if (pointExchangeVO.getEndDate() != null) {
            criteria.andGmtCreatedLessThanOrEqualTo(pointExchangeVO.getEndDate());
        }
        if (pointExchangeVO.getUserId() != null) {
            criteria.andUserIdEqualTo(pointExchangeVO.getUserId());
        }
        if (!StringUtils.isBlank(pointExchangeVO.getExchangeMethod())) {
            criteria.andExchangeMethodEqualTo(pointExchangeVO.getExchangeMethod());
        }
        if (!StringUtils.isBlank(pointExchangeVO.getStatus())) {
            criteria.andStatusEqualTo(pointExchangeVO.getStatus());
        }
        if (pointExchangeVO.getSellerId() != null) {
            criteria.andSellerIdEqualTo(pointExchangeVO.getSellerId());
        }
        return pointExchangeMapper.countByExample(pointExchangeExample);
    }


    private int insertOrUpdateUserPortrait(Long sellerId, Long userId, Integer count) {
        int reCode = -1;
        try {

            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(userId).andSellerIdEqualTo(sellerId);
            List<User> userList = userMapper.selectByExample(userExample);
            if (userList != null && !userList.isEmpty()) {
                Long userPortaitID = userList.get(0).getUserPortraitId();

                List<UserPortrait> userPortraits = null;

                if (userPortaitID != null) {
                    userPortraits = userService.getUserPortraitByUserPortaitId(userPortaitID);
                }

                if (userPortaitID == null || userPortraits == null || userPortraits.isEmpty()) {
                    UserPortrait userPortrait = new UserPortrait();
                    userPortrait.setLastSignInDate(new Date());
                    userPortrait.setSignInTimes(count);
                    userPortraitMapper.insertSelective(userPortrait);

                    userList.get(0).setUserPortraitId(userPortrait.getUserPortraitId());

                    reCode = userMapper.updateByPrimaryKey(userList.get(0));
                } else {

                    if (userPortraits != null && !userPortraits.isEmpty()) {
                        UserPortrait userPortrait = userPortraits.get(0);
                        userPortrait.setSignInTimesExpression("sign_in_times +" + count);
                        userPortrait.setLastSignInDate(new Date());
                        reCode = userPortraitMapper.updateByPrimaryKeySelective(userPortrait);
                    }
                }


            }
        } catch (Exception e) {

            logger.error("PointService insertOrUpdateUserPortrait", e);
        }

        return reCode;
    }

    /**
     * 获取积分统计信息
     *
     * @param days
     * @return
     * @author litu  2015/07/16
     */
    @Override
    public PointStatisticsVO getPointStatisticsInfo(Long sellerId, int days) {

        Date lastDate = DateUtils.addDays(new Date(), -days);

        /**
         * 累计赠送积分
         */
        PointStatisticsVO pointStatisticsVO = new PointStatisticsVO();
        PointObtainExample pointObtainExample = new PointObtainExample();
        pointObtainExample.setDefinedQueryColumns(true);
        pointObtainExample.addSumAmountQueryColumn();
        pointObtainExample.createCriteria().andGmtCreatedGreaterThanOrEqualTo(lastDate)
                .andSellerIdEqualTo(sellerId).andStatusEqualTo(DaoConstant.Status.VALID);
        List<PointObtain> pointObtains = pointObtainMapper.selectByExample(pointObtainExample);

        if (!CollectionUtils.isEmpty(pointObtains) && pointObtains.get(0) != null) {
            pointStatisticsVO.setTotalPresentPoint(pointObtains.get(0).getSumAmount());
        } else {
            pointStatisticsVO.setTotalPresentPoint(0l);
        }

        /**
         * 已兑换积分
         */
        PointExchangeExample pointExchangeExample = new PointExchangeExample();
        PointExchangeExample.Criteria pointExchangeCriteria = pointExchangeExample.createCriteria().andGmtModifiedGreaterThan(lastDate)
                .andStatusEqualTo(DaoConstant.PointExchangeStatus.SUCCESS).andSellerIdEqualTo(sellerId)
                .andGmtModifiedGreaterThan(lastDate);
        pointExchangeExample.setDefinedQueryColumns(true);
        pointExchangeExample.addSumPointAmountQueryColumn();
        List<PointExchange> pointExchanges = pointExchangeMapper.selectByExample(pointExchangeExample);

        if (!CollectionUtils.isEmpty(pointExchanges) && pointExchanges.get(0) != null) {
            pointStatisticsVO.setExchangedPoint(pointExchanges.get(0).getSumPointAmount());
        } else {
            pointStatisticsVO.setExchangedPoint(0l);
        }

        /**
         * 累计兑换红包金额
         */
        pointExchangeCriteria.andExchangeMethodEqualTo(DaoConstant.PointExchangeMethod.HONGBAO);
        pointExchangeExample.addSumExchangePresentAmountQueryColumn();
        List<PointExchange> pointExchangeList = pointExchangeMapper.selectByExample(pointExchangeExample);

        if (!CollectionUtils.isEmpty(pointExchangeList) && pointExchangeList.get(0) != null) {
            pointStatisticsVO.setTotalExchangeHBAmount(new BigDecimal(pointExchangeList.get(0).getSumExchangePresentAmount() == null ? 0
                    : pointExchangeList.get(0).getSumExchangePresentAmount() * 1.0d / 100));
        } else {
            pointStatisticsVO.setTotalExchangeHBAmount(new BigDecimal(0));
        }

        /**
         * 未兑换积分
         */
        pointStatisticsVO.setNonExchangePoint(pointStatisticsVO.getTotalPresentPoint() - pointStatisticsVO.getExchangedPoint());

        /**
         * 红包领取相关统计
         */
        HBObtainExample _hbObtainExample = new HBObtainExample();
        _hbObtainExample.createCriteria().andUserIdGreaterThan(0l).andStatusEqualTo(DaoConstant.HBStatus.RECEIVED)
                .andObtainDatatimeGreaterThan(lastDate);
        _hbObtainExample.setDefinedQueryColumns(true);
        _hbObtainExample.addMaxAmountQueryColumn();
        _hbObtainExample.addSumAmountQueryColumn();
        _hbObtainExample.addCountIdQueryColumn();
        _hbObtainExample.addCountDistinctUserIdQueryColumn();
        List<HBObtain> hbObtains = hBObtainMapper.selectByExample(_hbObtainExample);

        if (!CollectionUtils.isEmpty(hbObtains) && pointExchanges.get(0) != null) {
            pointStatisticsVO.setMaxReceiveHBAmount(new BigDecimal(hbObtains.get(0).getMaxAmount() == null ? 0 : hbObtains.get(0).getMaxAmount() * 1.0d / 100));
            pointStatisticsVO.setTotalReceiveHBAmount(new BigDecimal(hbObtains.get(0).getSumAmount() == null ? 0 : hbObtains.get(0).getSumAmount() * 1.0d / 100));
            pointStatisticsVO.setTotalReceiveHBNum(hbObtains.get(0).getCountId());
            pointStatisticsVO.setReceiveHBFansNum(hbObtains.get(0).getCountDistinctUserId());
        } else {
            pointStatisticsVO.setMaxReceiveHBAmount(new BigDecimal(0));
            pointStatisticsVO.setTotalReceiveHBAmount(new BigDecimal(0));
            pointStatisticsVO.setTotalReceiveHBNum(0l);
            pointStatisticsVO.setReceiveHBFansNum(0l);
        }

        return pointStatisticsVO;
    }

}
