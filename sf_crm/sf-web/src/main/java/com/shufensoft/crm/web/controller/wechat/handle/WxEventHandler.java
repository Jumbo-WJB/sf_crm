package com.shufensoft.crm.web.controller.wechat.handle;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.reply.KeyWordReplyService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.wechat.constant.WXConstant;
import com.shufensoft.crm.web.controller.wechat.helper.MessageHelper;
import com.shufensoft.crm.wechat.InputMessage;
import com.shufensoft.crm.wechat.OutputMessage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 微信事件消息处理handler
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/4  
 */
public class WxEventHandler {

    private static final Logger logger = Logger.getLogger(WxEventHandler.class);

    private static WXService wXService = (WXService) SpringContextUtil.getBean("wXService");

    private static UserService userService = (UserService) SpringContextUtil.getBean("userService");

    private static IPointService pointService = (IPointService) SpringContextUtil.getBean("pointService");

    private static RockService rockService = (RockService) SpringContextUtil.getBean("rockService");

    private static KeyWordReplyService keyWordReplyService = (KeyWordReplyService) SpringContextUtil.getBean("keyWordReplyService");


    /**
     * 处理消息
     *
     * @param inputMessage
     */
    public static String handle(InputMessage inputMessage, Long sellerId) {

        String event = inputMessage.getEvent();

        if (WXConstant.WXEvent.SUBSCRIBE.equals(event)) {
            return handleSubscribe(inputMessage, sellerId);
        }

        if (WXConstant.WXEvent.UN_SUBSCRIBE.equals(event)) {
            return handleUnSubscribe(inputMessage, sellerId);
        }

        return "";

    }

    private static String handleSubscribe(InputMessage inputMessage, Long sellerId) {

        String fromUserName = inputMessage.getFromUserName();

        UserVO userVO = createUser(sellerId, fromUserName);

        AssertsUtil.notNull(userVO, "userVO");

        /**
         * 用户是否已领取过关注送积分
         */
        if (!pointService.isUserSubscribePoint(sellerId,userVO.getUserId())) {

            pointService.createSubscribePoint(sellerId, userVO.getUserId());
        }

        /**
         * 领取未领的摇一摇
         */
        int shakeCode = rockService.obtainShake(userVO.getSellerId(), userVO.getUserId());

        if (shakeCode != -1) {

            logger.info("userName:" + userVO.getWxNickName() + "已领取摇一摇奖品" + shakeCode + "个");
        } else {

            logger.info("userName:" + userVO.getWxNickName() + "领取摇一摇奖品失败或者已过期。");
        }

        OutputMessage outputMessage = new OutputMessage();
        outputMessage.setToUserName(userVO.getWxOpenid());
        outputMessage.setContent(getSubscribeMessage(sellerId));
        outputMessage.setFromUserName(inputMessage.getToUserName());
        outputMessage.setMsgType(WXConstant.WXMessageType.TEXT);
        outputMessage.setMsgId(inputMessage.getMsgId());
        outputMessage.setCreateTime(new Date().getTime()/1000);

        /**
         * 关注后的统一回复
         */
        try {

            String sendMessage =  MessageHelper.assemblyMessage(outputMessage);

            MessageHelper.saveSellerMessageToDB(outputMessage,userVO,null);

            return sendMessage;

        } catch (IOException e) {
            logger.error("关注回复失败。");
        }

        return "";
    }

    private static UserVO createUser(Long sellerId, String openId) {

        UserVO userVO = wXService.findUserByOpenIdFromWx(sellerId, openId);
        userVO.setFirstSource(DaoConstant.TradeSource.WX);
        userVO.setSource(DaoConstant.TradeSource.WX);
        userVO.setWxSubscribe(DaoConstant.WxSubscribe.YES);

        UserVO userVOTmp =userService.findUserByOpenId(sellerId, openId);

        if(userVOTmp == null || userVOTmp.getUserPortraitId() == null){
            UserPortraitVO userPortraitVO = new UserPortraitVO();
            userPortraitVO.setSellerId(sellerId);
            userVO.setUserPortraitVO(userPortraitVO);
        }

        /**
         * 保存用户信息
         */
        boolean result = userService.insertOrUpdateUserAndPortrait(userVO);

        if (!result) {
            logger.error("persistence fail: " + sellerId + ", " + userVO.getWxOpenid());
        }

        return userVO;

    }

    private static String getSubscribeMessage(Long sellerId){

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));

        StringBuilder message = new StringBuilder("亲,欢迎关注");
        message.append(sellerConfigInfo.getSellerName()).append("公众号,");

        List<KeyWordReplyConfigVO> keyWordReplyConfigVOs = keyWordReplyService.getAllKeyWordReplyConfig(sellerId);

        if(CollectionUtils.isEmpty(keyWordReplyConfigVOs)){
            return message.toString();
        }

        message.append("回复以下关键字可以获取相应的服务\r\n");

        for(KeyWordReplyConfigVO keyWordReplyConfigVO : keyWordReplyConfigVOs){

            if(!DaoConstant.KeyWordBizType.GUIDE.equals(keyWordReplyConfigVO.getBizType())){
                message.append(keyWordReplyConfigVO.getKeyWord()).append(": ")
                        .append(keyWordReplyConfigVO.getTitle()).append("\r\n");
            }

        }

        return message.toString();

    }


    private static String handleUnSubscribe(InputMessage inputMessage, Long sellerId) {

        String fromUserName = inputMessage.getFromUserName();

        UserVO userVO = new UserVO();
        userVO.setWxOpenid(fromUserName);
        userVO.setSellerId(sellerId);
        userVO.setWxSubscribe(DaoConstant.WxSubscribe.NO);
        boolean result = userService.insertOrUpdateUserAndPortrait(userVO);
        if (!result) {
            logger.error("persistence fail: " + sellerId + ", " + userVO.getWxOpenid());
        }

        return "";

    }
}
