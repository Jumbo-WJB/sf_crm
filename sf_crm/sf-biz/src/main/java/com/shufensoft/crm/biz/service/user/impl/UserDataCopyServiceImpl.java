package com.shufensoft.crm.biz.service.user.impl;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverJDMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.receiver.ReceiverYZMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserPortraitMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserTaoBaoMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserYZMapper;
import com.shufensoft.crm.biz.domain.generation.receiver.*;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.dataindex.DataIndexService;
import com.shufensoft.crm.biz.service.user.UserDataCopyService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.vo.UserDataVo;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.biz.vo.ReceiverDistinctVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-23 15:20  
 */
@Service
public class UserDataCopyServiceImpl implements UserDataCopyService {

    private static final Logger logger = Logger.getLogger(UserDataCopyServiceImpl.class);

    @Autowired
    private UserTaoBaoMapper userTaoBaoMapper;

    @Autowired
    private ReceiverTaoBaoMapper receiverTaoBaoMapper;

    @Autowired
    private ReceiverYZMapper receiverYZMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ReceiverJDMapper receiverJDMapper;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserYZMapper userYZMapper;


    @Autowired
    private DataIndexService dataIndexService;

    @Autowired
    private UserPortraitMapper userPortraitMapper;

    @Override
    public UserDataVo copyFromYz(long userIdYz) {

        UserDataVo userDataVo = new UserDataVo();

        ReceiverYZExample receiverYZExample = new ReceiverYZExample();
        receiverYZExample.createCriteria().andUserIdYzEqualTo(userIdYz);
        List<ReceiverYZ> receiverYZList = receiverYZMapper.selectByExample(receiverYZExample);

        if(!CollectionUtils.isEmpty(receiverYZList)) {
            ReceiverDistinctVO receiverDistinctVO = userService.calMainReceiver4YZ(receiverYZList);

            if(StringUtils.isEmpty(userDataVo.getMobile())
                    && StringUtils.isNotEmpty(receiverDistinctVO.getReceiverMobile())) {
                userDataVo.setMobile(receiverDistinctVO.getReceiverMobile());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCountry())) {
                userDataVo.setCountry(receiverDistinctVO.getReceiverCountry());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverState())) {
                userDataVo.setProvince(receiverDistinctVO.getReceiverState());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCity())) {
                userDataVo.setCity(receiverDistinctVO.getReceiverCity());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverName())) {
                userDataVo.setName(receiverDistinctVO.getReceiverName());
            }
        }

        return userDataVo;
    }

    @Override
    public UserDataVo copyFromTb(long userIdTb) {

        UserTaoBaoExample userTaoBaoExample = new UserTaoBaoExample();
        userTaoBaoExample.createCriteria().andUserIdTbEqualTo(userIdTb);
        List<UserTaoBao> userTaoBaoList = userTaoBaoMapper.selectByExample(userTaoBaoExample);

        if(CollectionUtils.isEmpty(userTaoBaoList)) {
            logger.info("userTaoBao not found: " + userIdTb);
            return null;
        }

        UserTaoBao userTaoBao = userTaoBaoList.get(0);

        UserDataVo userDataVo = new UserDataVo();
        if(StringUtils.isNotEmpty(userTaoBao.getBuyerEmail())) {
            userDataVo.setEmail(userTaoBao.getBuyerEmail());
        }
        if(StringUtils.isNotEmpty(userTaoBao.getBuyerAlipayNo())
                && StringUtils.isEmail(userTaoBao.getBuyerAlipayNo())) {
            userDataVo.setEmail(userTaoBao.getBuyerAlipayNo());
        }
        if(StringUtils.isNotEmpty(userTaoBao.getBuyerAlipayNo())
                && StringUtils.isMobile(userTaoBao.getBuyerAlipayNo())) {
            userDataVo.setMobile(userTaoBao.getBuyerAlipayNo());
        }

        ReceiverTaoBaoExample receiverTaoBaoExample = new ReceiverTaoBaoExample();
        receiverTaoBaoExample.createCriteria().andUserIdTbEqualTo(userIdTb);
        List<ReceiverTaoBao> receiverTaoBaoList = receiverTaoBaoMapper.selectByExample(receiverTaoBaoExample);
        if(!CollectionUtils.isEmpty(receiverTaoBaoList)) {
            ReceiverDistinctVO receiverDistinctVO = userService.calMainReceiver4Tb(receiverTaoBaoList);

            if(StringUtils.isEmpty(userDataVo.getMobile())
                    && StringUtils.isNotEmpty(receiverDistinctVO.getReceiverMobile())) {
                userDataVo.setMobile(receiverDistinctVO.getReceiverMobile());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCountry())) {
                userDataVo.setCountry(receiverDistinctVO.getReceiverCountry());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverState())) {
                userDataVo.setProvince(receiverDistinctVO.getReceiverState());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCity())) {
                userDataVo.setCity(receiverDistinctVO.getReceiverCity());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverName())) {
                userDataVo.setName(receiverDistinctVO.getReceiverName());
            }
        }

        return userDataVo;
    }

    @Override
    public UserDataVo copyFromJd(long userIdJd) {

        UserDataVo userDataVo = new UserDataVo();
        ReceiverJDExample receiverJDExample = new ReceiverJDExample();
        receiverJDExample.createCriteria().andUserIdJdEqualTo(userIdJd);
        List<ReceiverJD> receiverJDList = receiverJDMapper.selectByExample(receiverJDExample);
        if(!CollectionUtils.isEmpty(receiverJDList)) {
            ReceiverDistinctVO receiverDistinctVO = userService.calMainReceiver4Jd(receiverJDList);

            if(StringUtils.isEmpty(userDataVo.getMobile())
                    && StringUtils.isNotEmpty(receiverDistinctVO.getReceiverMobile())) {
                userDataVo.setMobile(receiverDistinctVO.getReceiverMobile());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCountry())) {
                userDataVo.setCountry(receiverDistinctVO.getReceiverCountry());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverState())) {
                userDataVo.setProvince(receiverDistinctVO.getReceiverState());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverCity())) {
                userDataVo.setCity(receiverDistinctVO.getReceiverCity());
            }
            if(StringUtils.isNotEmpty(receiverDistinctVO.getReceiverName())) {
                userDataVo.setName(receiverDistinctVO.getReceiverName());
            }
        }

        return userDataVo;
    }



    /**
     * 处理京东用户转成用户
     *
     * @param sellerShop 商户信息
     * @param userIdJd   京东用户ID
     * @param orderJD    京东订单
     * @throws Exception
     */
    @Transactional
    @Override
    public void handleJdUser(SellerShop sellerShop, long userIdJd, OrderJD orderJD) throws Exception {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdJdEqualTo(userIdJd).andSellerIdEqualTo(sellerShop.getSellerId());
        List<User> userList = userMapper.selectByExample(userExample);

        User user;
        if (CollectionUtils.isEmpty(userList)) {
            UserDataVo userDataVo = copyFromJd(userIdJd);
            user = (User) BeanCopierUtils.copyProperties(userDataVo, User.class);
            user.setSellerId(sellerShop.getSellerId());
            user.setUserIdJd(userIdJd);
            user.setJdPin(orderJD.getPin());
            user.setFirstSource(sellerShop.getShopType());
            user.setSource(sellerShop.getShopType());
            user.setWxSubscribe(DaoConstant.WxSubscribe.NO);
            user.setIsOldUser(DaoConstant.TfDigit.T);
            user.setIsVerify(DaoConstant.TfDigit.F);
            user.setIsReceivedHb(DaoConstant.TfDigit.F);

            int insResult = userMapper.insert(user);
            if (insResult > 0) {
                logger.info("user insert success: " + user.getUserId());
            } else {
                logger.error("user insert fail: " + user.getJdPin());
                throw new ServiceException("user insert fail: " + user.getJdPin());
            }
        } else {
            user = userList.get(0);
        }

        UserPortraitVO userPortraitVo = dataIndexService.calculate(user);

        Long userPortraitId = -1L;

        UserPortrait userPortrait = (UserPortrait) BeanCopierUtils.copyProperties(userPortraitVo, UserPortrait.class);
        if (userPortrait == null) {
            userPortrait = new UserPortrait();

        }
        userPortraitId = user.getUserPortraitId();
        if (userPortraitId == null || userPortraitId <= 0) {
            userPortrait.setSellerId(sellerShop.getSellerId());
            if(userPortrait.getContributionJd() == null){
                userPortrait.setContributionJd(new BigDecimal(0));
            }
            userPortraitMapper.insertSelective(userPortrait);
            userPortraitId = userPortrait.getUserPortraitId();
        } else {
            UserPortraitExample userPortraitExample = new UserPortraitExample();
            userPortraitExample.createCriteria().andUserPortraitIdEqualTo(userPortraitId);
            userPortraitMapper.updateByExampleSelective(userPortrait, userPortraitExample);
        }

        if (user.getUserPortraitId() == null || user.getUserPortraitId() <= 0) {
            user = new User();
            user.setUserPortraitId(userPortraitId);
            int updateResult = userMapper.updateByExampleSelective(user, userExample);
            if (updateResult == 0) {
                logger.error("update userPortrait fail: " + user.toString());
                throw new ServiceException("user userPortrait fail: " + user.toString());
            }
        }
    }

    /**
     * 处理淘宝用户转成用户
     * @param sellerShop 商户信息
     * @param userIdTb 淘宝用户ID
     * @param tradeTaoBao 淘宝订单
     * @throws Exception
     */
    @Transactional
    @Override
    public void handleTbUser(SellerShop sellerShop, long userIdTb, TradeTaoBao tradeTaoBao) throws Exception {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdTbEqualTo(userIdTb).andSellerIdEqualTo(sellerShop.getSellerId());
        List<User> userList = userMapper.selectByExample(userExample);

        User user;
        if (CollectionUtils.isEmpty(userList)) {
            UserDataVo userDataVo = copyFromTb(userIdTb);
            user = (User) BeanCopierUtils.copyProperties(userDataVo, User.class);
            user.setSellerId(sellerShop.getSellerId());
            user.setUserIdTb(userIdTb);
            user.setTbBuyerNick(tradeTaoBao.getBuyerNick());
            user.setFirstSource(sellerShop.getShopType());
            user.setSource(sellerShop.getShopType());
            user.setWxSubscribe(DaoConstant.WxSubscribe.NO);
            user.setIsOldUser(DaoConstant.TfDigit.T);
            user.setIsVerify(DaoConstant.TfDigit.F);
            user.setIsReceivedHb(DaoConstant.TfDigit.F);


            int insResult = userMapper.insert(user);
            if (insResult > 0) {
                logger.info("user insert success: " + user.getUserId());
            } else {
                logger.error("user insert fail: " + user.getTbBuyerNick());
                throw new ServiceException("user insert fail: " + user.getTbBuyerNick());
            }
        } else {
            user = userList.get(0);
        }

        UserPortraitVO userPortraitVo = dataIndexService.calculate(user);

        Long userPortraitId = -1L;

        UserPortrait userPortrait = (UserPortrait) BeanCopierUtils.copyProperties(userPortraitVo, UserPortrait.class);
        if(userPortrait == null){
            userPortrait = new UserPortrait();

        }
        userPortraitId = user.getUserPortraitId();
        if (userPortraitId == null || userPortraitId <= 0) {

            userPortrait.setSellerId(sellerShop.getSellerId());
            if(DaoConstant.UserSource.TMALL.equals(sellerShop.getShopType())){
                if(userPortrait.getContributionTmall() == null){
                   userPortrait.setContributionTmall(new BigDecimal(0));
                }
            }

            if(DaoConstant.UserSource.TB.equals(sellerShop.getShopType())){
                if(userPortrait.getContributionTb() == null){
                    userPortrait.setContributionTb(new BigDecimal(0));
                }
            }

            userPortraitMapper.insertSelective(userPortrait);
            userPortraitId = userPortrait.getUserPortraitId();
        } else {
            UserPortraitExample userPortraitExample = new UserPortraitExample();
            userPortraitExample.createCriteria().andUserPortraitIdEqualTo(userPortraitId);
            userPortraitMapper.updateByExampleSelective(userPortrait, userPortraitExample);
        }

        if (user.getUserPortraitId() == null || user.getUserPortraitId() <= 0) {
            user = new User();
            user.setUserPortraitId(userPortraitId);
            int updateResult = userMapper.updateByExampleSelective(user, userExample);
            if (updateResult == 0) {
                logger.error("update userPortrait fail: " + user.toString());
                throw new ServiceException("update userPortrait fail: " + user.toString());
            }
        }
    }




    /**
     * 有赞数据分析
     * @param sellerShop 商铺信息
     * @param userIdYz 有赞用户ID
     * @param tradeYZ 有赞订单
     * @throws Exception
     */
    @Override
    @Transactional
    public void handleYZUser(SellerShop sellerShop, long userIdYz, TradeYZ tradeYZ) throws Exception {

        UserYZExample userYzExample = new UserYZExample();
        userYzExample.createCriteria().andUserIdYzEqualTo(userIdYz).andSellerIdEqualTo(sellerShop.getSellerId())
                .andShopIdEqualTo(sellerShop.getShopId());

        List<UserYZ> userYZList = userYZMapper.selectByExample(userYzExample);

        if(CollectionUtils.isEmpty(userYZList)){
            return;
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andWxOpenidEqualTo(userYZList.get(0).getOpenid()).andSellerIdEqualTo(sellerShop.getSellerId());
        List<User> userList = userMapper.selectByExample(userExample);

        User user;
        if (CollectionUtils.isEmpty(userList)) {

            UserDataVo userDataVo = copyFromYz(userIdYz);
            user = (User) BeanCopierUtils.copyProperties(userDataVo, User.class);
            user.setSellerId(sellerShop.getSellerId());
            user.setUserIdYz(userIdYz);
            user.setYzBuyerNick(tradeYZ.getBuyerNick());
            user.setSource(sellerShop.getShopType());
            user.setFirstSource(sellerShop.getShopType());
            user.setWxSubscribe(DaoConstant.WxSubscribe.YES);
            user.setIsOldUser(DaoConstant.TfDigit.T);
            user.setIsVerify(DaoConstant.TfDigit.F);
            user.setIsReceivedHb(DaoConstant.TfDigit.F);
            user.setWxNickName(userYZList.get(0).getNickName());
            user.setSex(userYZList.get(0).getSex());
            user.setCity(userYZList.get(0).getCity());
            user.setProvince(userYZList.get(0).getProvince());
            user.setWxHeadimgurl(userYZList.get(0).getHeadimgurl());
            user.setWxSubscribeTime(userYZList.get(0).getSubscribeTime());

            int insResult = userMapper.insert(user);
            if (insResult > 0) {
                logger.info("user insert success: " + user.getUserId());
            } else {
                logger.error("user insert fail: " + user.getTbBuyerNick());
                return;
            }
        } else {
            user = userList.get(0);
            user.setUserIdYz(userYZList.get(0).getUserIdYz());
            user.setYzBuyerNick(userYZList.get(0).getBuyerNick());
            user.setIsOldUser(DaoConstant.TfDigit.T);
            int updateResult = userMapper.updateByExampleSelective(user, userExample);
            if (updateResult == 0) {
                logger.error("update user fail: " + user.toString());
            }
        }

        UserPortraitVO userPortraitVo = dataIndexService.calculate(user);

        Long userPortraitId = -1L;

        UserPortrait userPortrait = (UserPortrait) BeanCopierUtils.copyProperties(userPortraitVo, UserPortrait.class);
        if(userPortrait == null){
            userPortrait = new UserPortrait();

        }

        userPortraitId = user.getUserPortraitId();
        if (userPortraitId == null || userPortraitId <= 0) {
            userPortrait.setSellerId(sellerShop.getSellerId());
            if(userPortrait.getContributionYz() == null){
                userPortrait.setContributionYz(new BigDecimal(0));
            }
            userPortraitMapper.insertSelective(userPortrait);
            userPortraitId = userPortrait.getUserPortraitId();
        } else {
            UserPortraitExample userPortraitExample = new UserPortraitExample();
            userPortraitExample.createCriteria().andUserPortraitIdEqualTo(userPortraitId);
            userPortraitMapper.updateByExampleSelective(userPortrait, userPortraitExample);
        }

        if (user.getUserPortraitId() == null || user.getUserPortraitId() <= 0) {
            user = new User();
            user.setUserPortraitId(userPortraitId);
            int updateResult = userMapper.updateByExampleSelective(user, userExample);
            if (updateResult == 0) {
                logger.error("update userPortrait fail: " + user.toString());
            }
        }
    }

}
