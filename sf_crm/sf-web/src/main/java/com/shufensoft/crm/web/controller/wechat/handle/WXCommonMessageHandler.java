package com.shufensoft.crm.web.controller.wechat.handle;

import com.shufensoft.crm.biz.service.reply.KeyWordReplyService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.wechat.helper.MessageHelper;
import com.shufensoft.crm.wechat.InputMessage;
import com.shufensoft.crm.wechat.OutputMessage;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 普通消息回复处理
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
public class WXCommonMessageHandler {

    private static final Logger logger = Logger.getLogger(WXCommonMessageHandler.class);

    private static UserService userService = (UserService) SpringContextUtil.getBean("userService");

    private static KeyWordReplyService keyWordReplyService = (KeyWordReplyService) SpringContextUtil.getBean("keyWordReplyService");

    /**
     * 处理接收的消息
     * @param inputMessage
     */
    public static String handle(InputMessage inputMessage,Long sellerId){

        String text = inputMessage.getContent();

        UserVO userVO = userService.findUserByOpenId(sellerId, inputMessage.getFromUserName());

        AssertsUtil.notNull(userVO,"userVO");

        try {

            /**
             *  1.根据用户发送的关键字匹配相关回复的业务内容
             */
            KeyWordReplyConfigVO keyWordReplyConfigVO = keyWordReplyService.matchBizBykeyWord(text,sellerId,userVO.getUserId());
            if(keyWordReplyConfigVO == null){
                return "";
            }

            /**
             *  2.组装回复消息
             */
            inputMessage.setBizType(keyWordReplyConfigVO.getBizType());
            OutputMessage outputMessage = MessageHelper.assemblyMessage(inputMessage,keyWordReplyConfigVO);
            String message = MessageHelper.assemblyMessage(outputMessage);

            /**
             *  3.保存消息发送记录
             */
            MessageHelper.saveSellerMessageToDB(outputMessage,userVO,keyWordReplyConfigVO.getId());

            return message;

        } catch (IOException e) {
            logger.error("WXTextMessageHandler.handle",e);
        }

        return "";
    }






}
