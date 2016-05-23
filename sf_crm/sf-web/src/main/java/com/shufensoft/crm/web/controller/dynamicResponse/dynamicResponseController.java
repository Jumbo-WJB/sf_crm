package com.shufensoft.crm.web.controller.dynamicResponse;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.reply.KeyWordReplyConfig;
import com.shufensoft.crm.biz.domain.generation.send.SendWxMessage;
import com.shufensoft.crm.biz.domain.generation.user.UserWxMessage;
import com.shufensoft.crm.biz.service.interactive.WxMessageService;
import com.shufensoft.crm.biz.service.point.PointMultipleService;
import com.shufensoft.crm.biz.service.reply.KeyWordReplyService;
import com.shufensoft.crm.biz.service.reply.WxMessageReplyService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.biz.vo.WXMessageQueryVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/22 20:30  
 */
@Controller
public class dynamicResponseController extends BaseController {

    @Autowired
    private KeyWordReplyService keyWordReplyService;

    @Autowired
    private WxMessageReplyService wxMessageReplyService;

    @Autowired
    private PointMultipleService pointMultipleService;

    @Autowired
    private WxMessageService wxMessageService;

    @Autowired
    private UserService userService;

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(dynamicResponseController.class);

    @RequestMapping(value = "/dynamicResponse/keyWord")
    @ResponseBody
    public ModelAndView hbPoolList(ModelMap modelMap) {
        return new ModelAndView("/dynamicResponse/keyWord", modelMap);
    }

    @RequestMapping(value = "/dynamicResponse/responseDetail")
    public ModelAndView showDetail(ModelMap modelMap) {
        return new ModelAndView("/dynamicResponse/wxMessageQueryDetail", modelMap);
    }

    @RequestMapping(value = "/dynamicResponse/responseSearch")
    public ModelAndView showList(ModelMap modelMap) {
        return new ModelAndView("/dynamicResponse/responseSearch", modelMap);
    }

    /**
     * 动态回复查询
     *
     * @param keyWordReplyConfigVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping(value = "/dynamicResponse/responseList")
    public
    @ResponseBody
    Map<String, Object> showList(@Valid KeyWordReplyConfigVO keyWordReplyConfigVO, Integer pageNum, Integer length) {

        PageInfo pageInfo = keyWordReplyService.getKeyWordList(keyWordReplyConfigVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 场景回复明细
     *
     * @param wxMessageQueryVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping(value = "/dynamicResponse/sceneReplySearch")
    public
    @ResponseBody
    Map<String, Object> sceneReply(@Valid WXMessageQueryVO wxMessageQueryVO,HttpSession session, Integer pageNum, Integer length) {

        Long sellerId = getSellerId(session);
        wxMessageQueryVO.setSellerId(sellerId);
        PageInfo pageInfo = wxMessageReplyService.queryUserWXMessageQueryServiceDetail(wxMessageQueryVO, pageNum, length);

        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    @RequestMapping(value = "/integral/sendMessageToUser")
    public
    @ResponseBody
    Map<String, Object> sendMessageToUser(HttpSession session, String[] openId, String content) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);


        Long sellerId = getSellerId(session);

        List<String> list = new ArrayList<String>();

        try {

            for (String openIds : openId) {
                String[] openInfo = openIds.split("&");

                // 对opendId去重，防止对同一个用户进行多条同样信息回复
                if (list.contains(openInfo[0])) {
                    continue;
                }

                list.add(openInfo[0]);

                UserVO userVO = userService.findUserByOpenId(sellerId, openInfo[0]);

                SendWxMessage sendWxMessage = new SendWxMessage();

                sendWxMessage.setSellerId(sellerId);
                sendWxMessage.setContent(content);
                sendWxMessage.setMsgtype("text");
                sendWxMessage.setTouser(openInfo[0]);
                int code = pointMultipleService.sendWxMessageToUser(sendWxMessage);
                if (0 == code) {

                    UserWxMessage userWxMessage = new UserWxMessage();

                    if (userVO != null) {
                        userWxMessage.setFirstSource(userVO.getFirstSource());
                        userWxMessage.setUserId(userVO.getUserId());
                        userWxMessage.setWxNickName(userVO.getWxNickName());
                        userWxMessage.setMobile(userVO.getMobile());
                    }

                    userWxMessage.setContent(content);
                    userWxMessage.setSendType(DaoConstant.UserWXMessageSendType.FROM_SELLER);
                    userWxMessage.setMsgType("text");
                    userWxMessage.setReplyType("artificial");
                    userWxMessage.setMsgId(openInfo[1]);
                    userWxMessage.setToUserName(openInfo[0]);
                    userWxMessage.setCreateTime(new Date());
                    userWxMessage.setWxOpenid(openInfo[0]);

                    wxMessageService.saveOrUpdateWXMessage(userWxMessage);

                }

            }
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(INFO_KEY, "发送成功!");

        } catch (Exception e) {

            logger.error("sendMessageToUser error", e);
        }


        return returnMap;
    }

    /**
     * 保存关键字回复设置
     *
     * @param replyConfigVO
     * @return
     */
    @RequestMapping(value = "/dynamicResponse/saveConfig")
    public
    @ResponseBody
    Map<String, Object> save(@Valid KeyWordReplyConfigVO replyConfigVO, ModelMap modelMap, HttpSession session) {

        Long sellerId = getSellerId(session);
        replyConfigVO.setSellerId(sellerId);

        if (keyWordReplyService.saveKeyWord(replyConfigVO)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        } else {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        }

        return modelMap;

    }

    /**
     * 获取引导语
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/dynamicResponse/getIntroduce")
    public
    @ResponseBody
    Map<String, Object> getIntroduction(ModelMap modelMap,HttpSession httpSession) {

        Long sellerId = getSellerId(httpSession);

        KeyWordReplyConfigVO kewWordVO = keyWordReplyService.queryKeyWordReplyConfigByType(sellerId,"guide");


        if (kewWordVO == null) {
            return modelMap;
        }
        modelMap.put("introduceWord", kewWordVO.getSuccessReplyContent());
        modelMap.put("title", kewWordVO.getTitle());
        modelMap.put("id", kewWordVO.getId());
        return modelMap;
    }

    /**
     * 获取回复内容信息
     *
     * @param keywordType
     * @return
     */
    @RequestMapping(value = "/dynamicResponse/getContentByType")
    public
    @ResponseBody
    Map<String, Object> getSign(String keywordType, HttpSession httpSession) {

        Map<String, Object> modelMap = Maps.newHashMap();
        Long sellerId = getSellerId(httpSession);

        KeyWordReplyConfigVO kewWordVO = keyWordReplyService.queryKeyWordReplyConfigByType(sellerId,keywordType);

        if (kewWordVO == null) {
            return modelMap;
        }
        modelMap.put("content", kewWordVO.getSuccessReplyContent());
        modelMap.put("keyword", kewWordVO.getKeyWord());
        modelMap.put("title", kewWordVO.getTitle());
        modelMap.put("kewWordVO", kewWordVO);
        return modelMap;
    }

    @RequestMapping(value = "/dynamicResponse/viewConfig")
    public
    @ResponseBody
    Map<String, Object> getConfig(Long id) {
        Map<String, Object> map = Maps.newHashMap();
        if (id <= 0) {
            return null;
        }

        KeyWordReplyConfig config = keyWordReplyService.getConfigById(id);
        if (config != null) {
            map.put("config", config);
        }
        ;

        return map;
    }

    @RequestMapping(value = "/dynamicResponse/deleteConfig")
    public
    @ResponseBody
    Map<String, Object> deleteConfig(Long id,HttpSession httpSession) {

        Map<String, Object> map = Maps.newHashMap();
        if (id <= 0L) {
            return null;
        }

        Long sellerId = getSellerId(httpSession);

        if (keyWordReplyService.deleteConfigById(sellerId,id)) {

            map.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);

        } else {

            map.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        }

        return map;
    }
}
