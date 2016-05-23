package com.shufensoft.crm.biz.service.user;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverJDMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverYZMapper;
import com.shufensoft.crm.biz.dao.generation.trade.OrderJDMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.trade.TradeYZMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserBoundMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTaoBaoMapper;
import com.shufensoft.crm.biz.domain.generation.receiver.*;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-13 15:35  
 */
@Service
public class UserBoundService {

    private static final Logger logger = Logger.getLogger(UserBoundService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBoundMapper userBoundMapper;

    @Autowired
    private OrderJDMapper orderJDMapper;

    @Autowired
    private UserTaoBaoMapper userTaoBaoMapper;

    @Autowired
    private TradeTaoBaoMapper tradeTaoBaoMapper;

    @Autowired
    private TradeYZMapper tradeYZMapper;

    @Autowired
    private ReceiverTaoBaoMapper receiverTaoBaoMapper;

    @Autowired
    private ReceiverJDMapper receiverJDMapper;

    @Autowired
    private ReceiverYZMapper receiverYZMapper;

    /**
     *  用户绑定
     * @param sellerId
     * @param wxUserId  微信用户对应那条记录的userId
     * @param mobile
     * @param tbBuyerNick
     * @param jdPin
     * @return
     */
    public UserBoundResponse bind(long sellerId, Long wxUserId, String mobile, String tbBuyerNick, String jdPin) {

        if(logger.isInfoEnabled()) {
            logger.info("bind user: " + sellerId + ", " + wxUserId + ", " + mobile + ", " + tbBuyerNick + ", " + jdPin);
        }

        if(sellerId <= 0 || wxUserId == null || StringUtils.isEmpty(mobile)) {
            logger.error("illegal argument");
            return new UserBoundResponse(UserBoundResponse.ILLEGAL_ARG);
        }

        UserExample wxUserExample = new UserExample();
        wxUserExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(wxUserId);
        List<User> userList = userMapper.selectByExample(wxUserExample);
        AssertsUtil.check(userList != null && userList.size() == 1, "valid wxUser not found: " + wxUserId);

        User wxUser = userList.get(0);
        UserBound userBound = new UserBound();
        userBound.setSellerId(sellerId);
        userBound.setUserId(wxUser.getUserId());
        userBound.setMobile(mobile);

        boolean isAlreadyBoundTb = false, isAlreadyBoundJd = false;
        // 若有tbId，查询交易记录，优先按照tbId绑定
        if(StringUtils.isNotEmpty(tbBuyerNick)) {
            UserTaoBaoExample userTaoBaoExample = new UserTaoBaoExample();
            userTaoBaoExample.createCriteria().andSellerIdEqualTo(sellerId).andBuyerNickEqualTo(tbBuyerNick);
            List<UserTaoBao> userTaoBaoList = userTaoBaoMapper.selectByExample(userTaoBaoExample);
            if(CollectionUtils.isEmpty(userTaoBaoList)) {
                // 如果没有淘宝账号，返回错误
                if(logger.isInfoEnabled()) {
                    logger.info("tb user not found: " + tbBuyerNick);
                }
                return new UserBoundResponse(UserBoundResponse.TBID_INEXIST);
            }

            Long userIdTb = userTaoBaoList.get(0).getUserIdTb();
            if(wxUser.getUserIdTb() == null || wxUser.getUserIdTb().longValue() != userIdTb.longValue()) {
                handleUserTb(sellerId, wxUser, mobile, userIdTb, null, tbBuyerNick, userBound);
            } else {
                isAlreadyBoundTb = true;
            }
        }

        // 若有jdId，查询交易记录，优先按照jdId绑定
        if(StringUtils.isNotEmpty(jdPin)) {
            OrderJDExample orderJDExample = new OrderJDExample();
            orderJDExample.createCriteria().andPinEqualTo(jdPin);
            List<OrderJD> orderJDList = orderJDMapper.selectByExample(orderJDExample);
            if(CollectionUtils.isEmpty(orderJDList)) {
                // 如果没有淘宝账号，返回错误
                if(logger.isInfoEnabled()) {
                    logger.info("jd user not found: " + jdPin);
                }
                return new UserBoundResponse(UserBoundResponse.JDID_INEXIST);
            }

            Long userIdJd = orderJDList.get(0).getUserIdJd();
            if(wxUser.getUserIdJd() == null || wxUser.getUserIdJd().longValue() != userIdJd.longValue()) {
                handleUserJd(sellerId, wxUser, mobile, userIdJd, null, jdPin, userBound);
            } else {
                isAlreadyBoundJd = true;
            }
        }

        if(StringUtils.isNotEmpty(tbBuyerNick) || StringUtils.isNotEmpty(jdPin)) {
            if(isAlreadyBoundTb && isAlreadyBoundJd) {
                return new UserBoundResponse(UserBoundResponse.BOUND_ALREADY);
            } else {
                userBoundMapper.insert(userBound);
                return new UserBoundResponse(UserBoundResponse.SUCCESS);
            }
        }

        // bound with tb account
        // check alipay account first, then calculate most related receiver
        UserTaoBaoExample userTaoBaoExample = new UserTaoBaoExample();
        userTaoBaoExample.createCriteria().andSellerIdEqualTo(sellerId).andBuyerAlipayNoEqualTo(mobile);
        List<UserTaoBao> userTaoBaoList = userTaoBaoMapper.selectByExample(userTaoBaoExample);

        boolean hasMobile = false;
        if(CollectionUtils.isEmpty(userTaoBaoList)) {
            ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
            receiverTaoBaoExample.createCriteria().andReceiverMobileEqualTo(mobile);
            List<ReceiverTaoBao> receiverTaoBaoList = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);

            if(!CollectionUtils.isEmpty(receiverTaoBaoList)) {
                hasMobile = true;

                ReceiverTaoBao receiverTaoBao = getMainReceiver4Tb(receiverTaoBaoList);
                Long userIdTb = receiverTaoBao.getUserIdTb();
                Long receiverIdTb = receiverTaoBao.getReceiverIdTb();

                if(userIdTb.equals(wxUser.getUserIdTb()) && receiverIdTb.equals(wxUser.getReceiverIdTb())) {
                    isAlreadyBoundTb = true;
                } else {
                    handleUserTb(sellerId, wxUser, mobile, userIdTb, receiverIdTb, null, userBound);
                }
            }
        } else {
            hasMobile = true;
            UserTaoBao userTaoBao = userTaoBaoList.get(0);
            Long userIdTb = userTaoBao.getUserIdTb();

            if(userIdTb != null && userIdTb.equals(wxUser.getUserIdTb())) {
                isAlreadyBoundTb = true;
            } else if(userIdTb != null) {
                handleUserTb(sellerId, wxUser, mobile, userIdTb, null, null, userBound);
            }
        }

        // bound with jd account
        // calculate most related receiver
        ReceiverJDExample receiverJDExample = new ReceiverJDExample();
        receiverJDExample.createCriteria().andSellerIdEqualTo(sellerId).andMobileEqualTo(mobile);
        List<ReceiverJD> receiverJDList = receiverJDMapper.selectByExample(receiverJDExample);
        if(!CollectionUtils.isEmpty(receiverJDList)) {
            hasMobile = true;

            ReceiverJD receiverJD = getMainReceiver4Jd(receiverJDList);
            Long userIdJd = receiverJD.getUserIdJd();
            Long receiverIdJd = receiverJD.getReceiverIdJd();

            if(userIdJd.equals(wxUser.getUserIdJd()) && receiverIdJd.equals(wxUser.getReceiverIdJd())) {
                isAlreadyBoundJd = true;
            } else {
                handleUserJd(sellerId, wxUser, mobile, userIdJd, receiverIdJd, null, userBound);
            }
        }


        ReceiverYZExample receiverYzExample = new ReceiverYZExample();
        receiverYzExample.createCriteria().andReceiverMobileEqualTo(mobile);
        List<ReceiverYZ> receiverYzList = receiverYZMapper.selectByExample(receiverYzExample);

        if(!CollectionUtils.isEmpty(receiverYzList)) {

            hasMobile = true;
            ReceiverYZ receiverYz = getMainReceiver4Yz(receiverYzList);
            Long receiverIdYz = receiverYz.getReceiverIdYz();

            User updateWxUser = new User();
            updateWxUser.setReceiverIdYz(receiverIdYz);
            int updateResult = userMapper.updateByExampleSelective(updateWxUser, wxUserExample);
            AssertsUtil.check(updateResult == 1, "update wxUser fail: " + wxUser.getUserId());

        }

        if(!hasMobile) {
            logger.error("mobile not found");
            return new UserBoundResponse(UserBoundResponse.MOBILE_INEXIST);
        }

        if(isAlreadyBoundTb && isAlreadyBoundJd) {
            return new UserBoundResponse(UserBoundResponse.BOUND_ALREADY);
        } else {
            userBoundMapper.insert(userBound);
            return new UserBoundResponse(UserBoundResponse.SUCCESS);
        }
    }

    /**
     * 获得淘宝频次最高的收件人
     *
     * @param receiverTaoBaoList
     * @return
     */
    private ReceiverTaoBao getMainReceiver4Tb(List<ReceiverTaoBao> receiverTaoBaoList) {
        if(receiverTaoBaoList.size() == 1) {
            return receiverTaoBaoList.get(0);
        }

        List<Long> receiverIdTbList = new ArrayList<Long>();
        for(ReceiverTaoBao receiverTaoBao : receiverTaoBaoList) {
            receiverIdTbList.add(receiverTaoBao.getReceiverIdTb());
        }

        TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();
        tradeTaoBaoExample.createCriteria().andReceiverIdTbIn(receiverIdTbList);
        tradeTaoBaoExample.setOrderByClause("receiver_id_tb desc");
        List<TradeTaoBao> tradeTaoBaoList = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);
        AssertsUtil.check(!CollectionUtils.isEmpty(tradeTaoBaoList), "trade not found");

        Long receiverIdTb = tradeTaoBaoList.get(0).getReceiverIdTb(), maxReceiverIdTb = -1L;
        int count = 0, maxCount = 0;
        for(TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
            count++;
            if(receiverIdTb != tradeTaoBao.getReceiverIdTb()) {
                if(maxCount == 0 || count - 1 > maxCount) {
                    maxCount = count - 1;
                    maxReceiverIdTb = receiverIdTb;
                }
                count = 1;
                receiverIdTb = tradeTaoBao.getReceiverIdTb();
            }
        }

        if(maxCount == 0 || count > maxCount) {
            maxReceiverIdTb = receiverIdTb;
        }

        for(ReceiverTaoBao receiverTaoBao : receiverTaoBaoList) {
            if(maxReceiverIdTb.equals(receiverTaoBao.getReceiverIdTb())) {
                return receiverTaoBao;
            }
        }

        return null;
    }

    /**
     * 获得京东频次最高的收件人
     *
     * @param receiverJDList
     * @return
     */
    private ReceiverJD getMainReceiver4Jd(List<ReceiverJD> receiverJDList) {
        if(receiverJDList.size() == 1) {
            return receiverJDList.get(0);
        }

        List<Long> receiverIdJdList = new ArrayList<Long>();
        for(ReceiverJD receiverJD : receiverJDList) {
            receiverIdJdList.add(receiverJD.getReceiverIdJd());
        }

        OrderJDExample orderJDExample = new OrderJDExample();
        orderJDExample.createCriteria().andReceiverIdJdIn(receiverIdJdList);
        orderJDExample.setOrderByClause("receiver_id_jd desc");
        List<OrderJD> orderJDList = orderJDMapper.selectByExample(orderJDExample);
        AssertsUtil.check(!CollectionUtils.isEmpty(orderJDList), "order jd data not found");

        Long receiverIdJd = orderJDList.get(0).getReceiverIdJd(), maxReceiverIdJd = -1L;
        int count = 0, maxCount = 0;
        for(OrderJD orderJD : orderJDList) {
            count++;
            if(receiverIdJd != orderJD.getReceiverIdJd()) {
                if(maxCount == 0 || count - 1 > maxCount) {
                    maxCount = count - 1;
                    maxReceiverIdJd = receiverIdJd;
                }
                count = 1;
                receiverIdJd = orderJD.getReceiverIdJd();
            }
        }

        if(maxCount == 0 || count > maxCount) {
            maxReceiverIdJd = receiverIdJd;
        }

        for(ReceiverJD receiverJD : receiverJDList) {
            if(maxReceiverIdJd.equals(receiverJD.getReceiverIdJd())) {
                return receiverJD;
            }
        }

        return null;
    }

    /**
     * 获得有赞频次最高的收件人
     * @param receiverYZList
     * @return
     */
    private ReceiverYZ getMainReceiver4Yz(List<ReceiverYZ> receiverYZList) {

        if(receiverYZList.size() == 1) {
            return receiverYZList.get(0);
        }

        List<Long> receiverIdYzList = new ArrayList<Long>();
        for(ReceiverYZ receiverYZ : receiverYZList) {
            receiverIdYzList.add(receiverYZ.getReceiverIdYz());
        }

        TradeYZExample tradeYZExample = new TradeYZExample();
        tradeYZExample.createCriteria().andReceiverIdYzIn(receiverIdYzList);
        tradeYZExample.setOrderByClause("receiver_id_yz desc");
        List<TradeYZ> tradeYZs = tradeYZMapper.selectByExample(tradeYZExample);
        AssertsUtil.check(!CollectionUtils.isEmpty(tradeYZs), "trade yz data not found");

        Long receiverIdYz = tradeYZs.get(0).getReceiverIdYz(), maxReceiverIdYz = -1L;

        int count = 0, maxCount = 0;
        for(TradeYZ tradeYZ : tradeYZs) {
            count++;
            if(receiverIdYz != tradeYZ.getReceiverIdYz()) {
                if(maxCount == 0 || count - 1 > maxCount) {
                    maxCount = count - 1;
                    maxReceiverIdYz = receiverIdYz;
                }
                count = 1;
                receiverIdYz = tradeYZ.getReceiverIdYz();
            }
        }

        if(maxCount == 0 || count > maxCount) {
            maxReceiverIdYz = receiverIdYz;
        }

        for(ReceiverYZ receiverYz : receiverYZList) {
            if(maxReceiverIdYz.equals(receiverYz.getReceiverIdYz())) {
                return receiverYz;
            }
        }

        return null;
    }

    /**
     * 处理京东用户的绑定
     *
     * @param sellerId
     * @param wxUser 微信用户对应那条记录
     * @param mobile
     * @param userIdJd
     * @param receiverIdJd
     * @param jdId
     * @param userBound
     */
    private void handleUserJd(long sellerId, User wxUser, String mobile, Long userIdJd,
              Long receiverIdJd, String jdId, UserBound userBound) {

        if(logger.isInfoEnabled()) {
            logger.info("handle jdUser: " + sellerId + ", " + wxUser.getUserId() + ", " + mobile + ", " + userIdJd
                    + ", " + receiverIdJd + ", " + jdId);
        }

        UserExample jdUserExample = new UserExample();
        jdUserExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdJdEqualTo(userIdJd);
        List<User> jdUserList = userMapper.selectByExample(jdUserExample);
        AssertsUtil.check(jdUserList != null && jdUserList.size() == 1,
                "valid jdUser not found: " + userIdJd);

        // delete jd user
        int deleteResult = userMapper.deleteByExample(jdUserExample);
        AssertsUtil.check(deleteResult == 1, "delete jdUser fail: " + userIdJd);

        User jdUser = jdUserList.get(0);

        // modify: wxUser.userIdTb, is_verify, copy: tbUser.user_portrait_id
        User updateWxUser = new User();
        updateWxUser.setIsVerify(DaoConstant.IsVerify.YES);
        updateWxUser.setUserIdJd(userIdJd);
        if(receiverIdJd != null && receiverIdJd > 0) {
            updateWxUser.setReceiverIdJd(receiverIdJd);
        }

        /**
         * 计算来源
         */
        calculateSource(wxUser, jdUser, updateWxUser);

        if(StringUtils.isNotEmpty(jdUser.getJdPin())) {
            updateWxUser.setJdPin(jdUser.getJdPin());
        }
        if(StringUtils.isNotEmpty(jdUser.getTbBuyerNick())) {
            updateWxUser.setTbBuyerNick(jdUser.getTbBuyerNick());
        }
        if(StringUtils.isNotEmpty(jdUser.getName())) {
            updateWxUser.setName(jdUser.getName());
        }
        if(StringUtils.isNotEmpty(jdUser.getEmail())) {
            updateWxUser.setEmail(jdUser.getEmail());
        }
        updateWxUser.setIsOldUser(DaoConstant.TfDigit.T);
        updateWxUser.setUserPortraitId(jdUser.getUserPortraitId());
        updateWxUser.setMobile(mobile);

        UserExample wxUserExample = new UserExample();
        wxUserExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(wxUser.getUserId());
        int updateResult = userMapper.updateByExampleSelective(updateWxUser, wxUserExample);
        AssertsUtil.check(updateResult == 1, "update wxUser fail: " + wxUser.getUserId());

        // set user_bound
        userBound.setUserIdJd(userIdJd);
        if(receiverIdJd != null && receiverIdJd > 0) {
            userBound.setReceiverIdJd(receiverIdJd);
        }

        if(StringUtils.isNotEmpty(jdId)) {
            userBound.setJdId(jdId);
        }

    }

    /**
     * 处理淘宝用户的绑定
     *
     * @param sellerId
     * @param wxUser 微信用户对应那条记录
     * @param mobile
     * @param userIdTb
     * @param receiverIdTb
     * @param tbId
     * @param userBound
     */
    private void handleUserTb(long sellerId, User wxUser, String mobile, Long userIdTb, Long receiverIdTb,
                              String tbId, UserBound userBound) {

        if(logger.isInfoEnabled()) {
            logger.info("handle tbUser: " + sellerId + ", " + wxUser.getUserId() + ", " + mobile + ", " + userIdTb
                    + ", " + receiverIdTb + ", " + userBound.toString());
        }

        UserExample tbUserExample = new UserExample();
        tbUserExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdTbEqualTo(userIdTb);
        List<User> tbUserList = userMapper.selectByExample(tbUserExample);
        AssertsUtil.check(tbUserList != null && tbUserList.size() == 1,
                "valid tbUser not found: " + userIdTb);

        // delete tb user
        int deleteResult = userMapper.deleteByExample(tbUserExample);
        AssertsUtil.check(deleteResult == 1, "delete fail: " + userIdTb);

        User tbUser = tbUserList.get(0);

        User updateWxUser = new User();
        updateWxUser.setIsVerify(DaoConstant.IsVerify.YES);
        updateWxUser.setUserIdTb(userIdTb);
        if(receiverIdTb != null && receiverIdTb > 0) {
            updateWxUser.setReceiverIdTb(receiverIdTb);
        }

        /**
         * 计算来源
         */
        calculateSource(wxUser, tbUser, updateWxUser);

        if(StringUtils.isNotBlank(tbUser.getJdPin())) {
            updateWxUser.setJdPin(tbUser.getJdPin());
        }
        if(StringUtils.isNotBlank(tbUser.getTbBuyerNick())) {
            updateWxUser.setTbBuyerNick(tbUser.getTbBuyerNick());
        }
        if(StringUtils.isNotBlank(tbUser.getName())) {
            updateWxUser.setName(tbUser.getName());
        }
        if(StringUtils.isNotBlank(tbUser.getEmail())) {
            updateWxUser.setEmail(tbUser.getEmail());
        }
        updateWxUser.setIsOldUser(DaoConstant.TfDigit.T);
        updateWxUser.setUserPortraitId(tbUser.getUserPortraitId());
        updateWxUser.setMobile(mobile);

        UserExample wxUserExample = new UserExample();
        wxUserExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(wxUser.getUserId());
        int updateResult = userMapper.updateByExampleSelective(updateWxUser, wxUserExample);
        AssertsUtil.check(updateResult == 1, "update wxUser fail: " + wxUser.getUserId());

        // set user_bound
        if(receiverIdTb != null && receiverIdTb > 0) {
            userBound.setReceiverIdTb(receiverIdTb);
        }

        if(StringUtils.isNotEmpty(tbId)) {
            userBound.setTbId(tbId);
        }

        userBound.setUserIdTb(userIdTb);

    }

    /**
     * 计算来源
     * @param wxUser
     * @param channelUser
     * @param updateWxUser
     */
    private void calculateSource(User wxUser, User channelUser, User updateWxUser){

        Date channelFirstTradeDate = findFirstTradeDate(channelUser,channelUser.getSource());

        /**
         * 计算第一次来源
         */

        if(DaoConstant.UserSource.WX.equals(wxUser.getFirstSource())){

            if(wxUser.getGmtCreated().after(channelFirstTradeDate)){
                updateWxUser.setFirstSource(channelUser.getFirstSource());
            }

        }else {

            Date firstTradeDate = findFirstTradeDate(channelUser, channelUser.getFirstSource());

            if(firstTradeDate.after(channelFirstTradeDate)){
                updateWxUser.setFirstSource(channelUser.getFirstSource());
            }

        }

        /**
         * 整合来源
         */
        if(wxUser.getSource().indexOf(channelUser.getSource())==-1){
            updateWxUser.setSource(wxUser.getSource() + "," + channelUser.getSource());
        }
    }

    /**
     * 查询第一次下单时间
     * @param channelUser
     * @param source
     * @return
     */
    private Date findFirstTradeDate(User channelUser, String source){

        if(DaoConstant.UserSource.TMALL.equals(source) || DaoConstant.UserSource.TB.equals(source)){

            TradeTaoBaoExample tradeTaoBaoExample = new TradeTaoBaoExample();

            tradeTaoBaoExample.createCriteria().andSellerIdEqualTo(channelUser.getSellerId())
                    .andUserIdTbEqualTo(channelUser.getUserIdTb());
            List<TradeTaoBao> tradeTaoBaos = tradeTaoBaoMapper.selectByExample(tradeTaoBaoExample);

            if(!CollectionUtils.isEmpty(tradeTaoBaos)){
                return tradeTaoBaos.get(0).getCreated();
            }

        }

        if(DaoConstant.UserSource.YZ.equals(source)){

            TradeYZExample tradeYZExample = new TradeYZExample();

            tradeYZExample.createCriteria().andSellerIdEqualTo(channelUser.getSellerId())
                    .andUserIdYzEqualTo(channelUser.getUserIdYz());
            List<TradeYZ> tradeYZs = tradeYZMapper.selectByExample(tradeYZExample);

            if(!CollectionUtils.isEmpty(tradeYZs)){
                return tradeYZs.get(0).getCreated();
            }
        }

        if(DaoConstant.UserSource.JD.equals(source)){

            OrderJDExample orderJDExample = new OrderJDExample();

            orderJDExample.createCriteria().andSellerIdEqualTo(channelUser.getSellerId())
                    .andUserIdJdEqualTo(channelUser.getUserIdJd());
            List<OrderJD> orderJDs = orderJDMapper.selectByExample(orderJDExample);

            if(!CollectionUtils.isEmpty(orderJDs)){
                return orderJDs.get(0).getOrderStartTime();
            }
        }

        return null;

    }



    public static void main(String[] args) {
        List<TradeTaoBao> tradeTaoBaoList = new ArrayList<TradeTaoBao>();
        TradeTaoBao tb = new TradeTaoBao();
        tb.setReceiverIdTb(11L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(11L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(22L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(22L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(22L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(33L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(44L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(44L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(44L);
        tradeTaoBaoList.add(tb);
        tb = new TradeTaoBao();
        tb.setReceiverIdTb(44L);
        tradeTaoBaoList.add(tb);

        Long receiverIdTb = tradeTaoBaoList.get(0).getReceiverIdTb(), maxReceiverIdTb = -1L;
        int count = 0, maxCount = 0;
        for(TradeTaoBao tradeTaoBao : tradeTaoBaoList) {
            count++;
            if(receiverIdTb != tradeTaoBao.getReceiverIdTb()) {
                if(maxCount == 0 || count - 1 > maxCount) {
                    maxCount = count - 1;
                    maxReceiverIdTb = receiverIdTb;
                }
                count = 1;
                receiverIdTb = tradeTaoBao.getReceiverIdTb();
            }
        }

        if(maxCount == 0 || count > maxCount) {
            maxReceiverIdTb = receiverIdTb;
        }
    }

}
