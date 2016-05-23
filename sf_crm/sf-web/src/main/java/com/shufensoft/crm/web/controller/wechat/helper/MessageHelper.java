package com.shufensoft.crm.web.controller.wechat.helper;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessage;
import com.shufensoft.crm.biz.service.interactive.WxMessageService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SHA1;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.common.utils.xmlUtil.SerializeXmlUtil;
import com.shufensoft.crm.wechat.InputMessage;
import com.shufensoft.crm.wechat.Item;
import com.shufensoft.crm.wechat.OutputMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/3  
 */
public class MessageHelper {

    private static final String TOKEN = "suniu";

    private static WxMessageService wxMessageService = (WxMessageService) SpringContextUtil.getBean("wxMessageService");

    /**
     * 验证token
     * @param request
     * @param response
     */
    public static String validateToken(HttpServletRequest request, HttpServletResponse response)throws IOException{

        if(isMessageFromWx(request)){
            String echostr = request.getParameter("echostr");//随机字符串
            return echostr;
        }

        return null;
    }


    public static boolean isMessageFromWx(HttpServletRequest request) {

        /**
         * 微信加密签名
         */
        String signature = request.getParameter("signature");

        /**
         * 时间戳
         */
        String timestamp = request.getParameter("timestamp");

        /**
         * 随机数
         */
        String nonce = request.getParameter("nonce");

        /**
         * SHA1加密
         */
        String[] str = {TOKEN, timestamp, nonce};
        Arrays.sort(str);
        String bigStr = str[0] + str[1] + str[2];
        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

        /**
         * 确认请求来至微信
         */
        return digest.equals(signature);
    }

    /**
     * 组装消息
     * @param inputMessage
     * @param keyWordReplyConfigVO
     * @return
     * @throws IOException
     */
    public static OutputMessage assemblyMessage(InputMessage inputMessage,KeyWordReplyConfigVO keyWordReplyConfigVO) throws IOException {

        OutputMessage outputMessage = new OutputMessage();
        outputMessage.setFromUserName(inputMessage.getToUserName());
        outputMessage.setToUserName(inputMessage.getFromUserName());
        outputMessage.setMsgId(inputMessage.getMsgId());
        outputMessage.setCreateTime(System.currentTimeMillis()/1000);
        outputMessage.setContent(keyWordReplyConfigVO.getSuccessReplyContent());

        if(StringUtils.isNotBlank(keyWordReplyConfigVO.getMsgType())){
            outputMessage.setMsgType(keyWordReplyConfigVO.getMsgType());
        }

        if(StringUtils.isNotBlank(keyWordReplyConfigVO.getUrl()) || StringUtils.isNotBlank(keyWordReplyConfigVO.getPicUrl())){
            List<Item> items = new ArrayList<Item>();
            Item item = new Item();
            item.setUrl("<![CDATA["+keyWordReplyConfigVO.getUrl()+"&iteraction_entry="
                    + DaoConstant.IteractionEntry.KEY_WORD+"]]>");
            item.setPicUrl("<![CDATA["+keyWordReplyConfigVO.getPicUrl()+"]]>");
            item.setTitle(keyWordReplyConfigVO.getTitle());
            item.setDescription(keyWordReplyConfigVO.getTitle());
            items.add(item);
            outputMessage.setArticleCount(items.size());
            outputMessage.setArticles(items);
        }

        outputMessage.setBizType(keyWordReplyConfigVO.getBizType());
        outputMessage.setTitle(keyWordReplyConfigVO.getTitle());

        return  outputMessage;

    }

    /**
     * 组装消息
     * @param outputMessage
     * @return
     * @throws IOException
     */
    public static String assemblyMessage(OutputMessage outputMessage) throws IOException {

        AssertsUtil.notNull(outputMessage,"outputMessage");
        outputMessage.setCreateTime(System.currentTimeMillis()/1000);

        return  SerializeXmlUtil.toXml(outputMessage, OutputMessage.class);

    }

    /**
     * 保存消息
     * @param inputMessage
     * @param userVO
     */
    public static void saveCustomMessageToDB(InputMessage inputMessage,UserVO userVO){

        AssertsUtil.notNull(inputMessage , "inputMessage");
        UserWxMessage userWxMessage = new UserWxMessage();
        userWxMessage.setTitle(inputMessage.getTitle());
        userWxMessage.setUrl(inputMessage.getURL());
        userWxMessage.setMsgId(String.valueOf(inputMessage.getMsgId()));
        userWxMessage.setMsgType(inputMessage.getMsgType());
        userWxMessage.setBizType(inputMessage.getBizType());
        userWxMessage.setWxOpenid(inputMessage.getFromUserName());
        userWxMessage.setFromUserName(inputMessage.getFromUserName());
        userWxMessage.setSendType(DaoConstant.UserWXMessageSendType.FROM_CUSTOM);
        userWxMessage.setToUserName(inputMessage.getToUserName());
        userWxMessage.setContent(inputMessage.getContent());
        userWxMessage.setCreateTime(new Date(inputMessage.getCreateTime()*1000l));
        userWxMessage.setMediaId(inputMessage.getMediaId());

        if(userVO!=null){
            userWxMessage.setUserId(userVO.getUserId());
            userWxMessage.setWxNickName(userVO.getWxNickName());
            userWxMessage.setMobile(userVO.getMobile());
            userWxMessage.setFirstSource(userVO.getFirstSource());
        }

        wxMessageService.saveOrUpdateWXMessage(userWxMessage);

    }

    /**
     * 保存消息
     * @param outputMessage
     * @param userVO
     */
    public static void saveSellerMessageToDB(OutputMessage outputMessage,UserVO userVO,Long keyWordConfigId){

        AssertsUtil.notNull(outputMessage , "outputMessage");
        UserWxMessage userWxMessage = new UserWxMessage();
        userWxMessage.setTitle(outputMessage.getTitle());
        List<Item> articles =  outputMessage.getArticles();
        userWxMessage.setContent(outputMessage.getContent());

        if(!CollectionUtils.isEmpty(articles)){
            userWxMessage.setUrl(articles.get(0).getUrl().replace("<![CDATA[","").replace("]]>",""));
            userWxMessage.setPicUrl(articles.get(0).getPicUrl().replace("<![CDATA[","").replace("]]>",""));
            userWxMessage.setDescription(articles.get(0).getDescription());
            userWxMessage.setTitle(articles.get(0).getTitle());
            userWxMessage.setContent(articles.get(0).getUrl().replace("<![CDATA[","").replace("]]>",""));
        }

        userWxMessage.setKeyWordConfigId(keyWordConfigId);
        userWxMessage.setReplyType(DaoConstant.ReplyType.INTELLIGENCE);
        userWxMessage.setMsgId(String.valueOf(outputMessage.getMsgId()));
        userWxMessage.setMsgType(outputMessage.getMsgType());
        userWxMessage.setBizType(outputMessage.getBizType());
        userWxMessage.setWxOpenid(outputMessage.getToUserName());
        userWxMessage.setFromUserName(outputMessage.getFromUserName());
        userWxMessage.setSendType(DaoConstant.UserWXMessageSendType.FROM_SELLER);
        userWxMessage.setToUserName(outputMessage.getToUserName());
        userWxMessage.setCreateTime(new Date(outputMessage.getCreateTime()*1000l));
        userWxMessage.setMediaId(outputMessage.getMediaId());
        userWxMessage.setContent(outputMessage.getContent());
        if(userVO!=null){
            userWxMessage.setUserId(userVO.getUserId());
            userWxMessage.setWxNickName(userVO.getWxNickName());
            userWxMessage.setMobile(userVO.getMobile());
            userWxMessage.setFirstSource(userVO.getFirstSource());
        }

        wxMessageService.saveOrUpdateWXMessage(userWxMessage);

    }

}
