package com.shufensoft.crm.web.controller.wechat;

import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.xmlUtil.SerializeXmlUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.controller.wechat.constant.WXConstant;
import com.shufensoft.crm.web.controller.wechat.handle.WXCommonMessageHandler;
import com.shufensoft.crm.web.controller.wechat.handle.WxEventHandler;
import com.shufensoft.crm.web.controller.wechat.helper.MessageHelper;
import com.shufensoft.crm.wechat.InputMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 微信类
 *  @author litu  litu@suniusoft.com
 *  @date 2015/7/3 11:22  
 */
@Controller
public class WechatController extends BaseController {

    private static final Logger logger = Logger.getLogger(WechatController.class);

    @Autowired
    private  UserService userService;


    /**
     * 接收用户消息、事件等
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/wechat/api/sellerId/{sellerId}",produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String wechatGet(@PathVariable("sellerId") Long sellerId, HttpServletRequest request
            , HttpServletResponse response) throws IOException {

        InputMessage inputMessage;

        try {

            /**
             *  1.确认请求来之微信
             */
            if (!MessageHelper.isMessageFromWx(request)) {
                return ErrorCode.ERROR;
            }

            /**
             * 2.验证token
             */
            boolean isGet = request.getMethod().toLowerCase().equals("get");
            if (isGet) {
                return MessageHelper.validateToken(request, response);
            }

            /**
             *  3.设置数据源key
             */
            DatasourceHelper.setDatasource(String.valueOf(sellerId));

            /**
             *  4.解析请求参数
             */
            inputMessage = (InputMessage)SerializeXmlUtil.parseXml(request.getInputStream(),InputMessage.class);

            if (inputMessage == null) {
                return ErrorCode.ERROR;
            }

            /**
             *  5.记录用户消息
             */
            UserVO userVO = userService.findUserByOpenId(Long.valueOf(sellerId), inputMessage.getFromUserName());

            MessageHelper.saveCustomMessageToDB(inputMessage, userVO);

            /**
             *  6.处理事件类型请求
             */
            if (WXConstant.WXMessageType.EVENT.equals(inputMessage.getMsgType())) {
                return WxEventHandler.handle(inputMessage, sellerId);
            }

            /**
             *  7.处理文本消息请求
             */
            if (WXConstant.WXMessageType.TEXT.equals(inputMessage.getMsgType())) {
                return WXCommonMessageHandler.handle(inputMessage, sellerId);
            }

        }catch (Exception e){
            logger.error("WechatController.wechatGet",e);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;

    }

}
