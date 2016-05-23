package com.shufensoft.crm.web.controller.contactCustomer;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketActivity;
import com.shufensoft.crm.biz.domain.generation.marketActivity.MarketRecords;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.contactCustomer.MarketActivityService;
import com.shufensoft.crm.biz.service.sellerConfig.SellerConfigService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SellerPackageCountVO;
import com.shufensoft.crm.biz.service.trade.TradeService;
import com.shufensoft.crm.biz.service.trade.vo.TradeVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.*;
import com.shufensoft.crm.common.utils.*;
import com.shufensoft.crm.constant.WebConstant;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author yuyuchi yuyc@suniusoft.com
 * @ProjectName: sf-crm 
 * @Description: 与客户联系
 * @date 2015/6/4
 */
@Controller
@RequestMapping(value = "/contactCustomer")
public class ContactCustomerController extends BaseController {

    private static final Logger logger = Logger.getLogger(ContactCustomerController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private SendService sendService;

    @Autowired
    private SendService smsService;

    @Autowired
    private MarketActivityService marketActivityService;

    @Autowired
    private SellerConfigService sellerConfigService;

    /**图文消息图片保存地址*/
    private static final String filepath = "seller/";

    /**
     * 短信营销活动页面
     *
     * @return
     */
    @RequestMapping(value = "/smsMarketing")
    @ResponseBody
    public ModelAndView smsMarketing(@Valid UserVO userVO, ModelMap modelMap, HttpSession session) {

        Long sellerId = getSellerId(session);
        UserVO tempVO = userVO;
        if ((StringUtils.isBlank(userVO.getIsSelectAll()) || userVO.getIsSelectAll().equals("0"))
                && StringUtils.isBlank(userVO.getUserParams())) {
            tempVO.setIsSuccessCustom("1");
            tempVO.setIsSelectAll("1");
            tempVO.setHasMobile("1");
        }

        Integer userCount;
        if (userVO != null && userVO.getAllSelectCount() != null) {
            userCount = userVO.getAllSelectCount();
        } else {
            userCount = userService.getUserCount("sms", sellerId);
        }

        //获取用户剩下的短信条数
        SellerPackageCount sellerPackageCount = smsService.querySellerPackageCountBySellerID(String.valueOf(sellerId),"sms");
        Long remainCount = 0L;
        if (sellerPackageCount != null) {
            remainCount = sellerPackageCount.getSellerPackageRemain();
        }
        if (remainCount <= 0L || remainCount == null) {
            remainCount = 0L;
        }

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));
        if (sellerConfigInfo != null) {
            modelMap.put("signName", sellerConfigInfo.getSmsSaleSign());
        }

        modelMap.put("userVO", tempVO);
        modelMap.put("remainCount", remainCount);
        modelMap.put("smsUserCount", userCount);
        return new ModelAndView("/contactCustomer/smsMarketing", modelMap);
    }

    /**
     * 邮件营销活动页面
     *
     * @return
     */
    @RequestMapping(value = "/emailMarketing")
    @ResponseBody
    public ModelAndView emailMarketing(@Valid UserVO userVO, ModelMap modelMap, HttpSession session) {

        Long sellerId = getSellerId(session);
        UserVO tempVO = userVO;
        if ((StringUtils.isBlank(userVO.getIsSelectAll()) || userVO.getIsSelectAll().equals("0"))
                && StringUtils.isBlank(userVO.getUserParams())) {
            tempVO.setIsSuccessCustom("1");
            tempVO.setIsSelectAll("1");
            tempVO.setHasEmail("1");
        }

        Integer userCount;
        if (userVO != null && userVO.getAllSelectCount() != null) {
            userCount = userVO.getAllSelectCount();
        } else {
            userCount = userService.getUserCount("email", sellerId);
        }

        //获取用户剩下的短信条数
        SellerPackageCount sellerPackageCount = smsService.querySellerPackageCountBySellerID(String.valueOf(sellerId),"mail");
        Long remainCount = 0L;
        if (sellerPackageCount != null) {
            remainCount = sellerPackageCount.getSellerPackageRemain();
        }
        if (remainCount <= 0L || remainCount == null) {
            remainCount = 0L;
        }

        modelMap.put("remainCount", remainCount);
        modelMap.put("userVO", tempVO);
        modelMap.put("emailUserCount", userCount);
        return new ModelAndView("/contactCustomer/emailMarketing", modelMap);
    }

    /**
     * 微信营销活动页面
     *
     * @return
     */
    @RequestMapping(value = "/wxMarketing")
    @ResponseBody
    public ModelAndView wxMarketing(HttpSession session, ModelMap modelMap) {

        Long sellerId = getSellerId(session);

        modelMap.put("monthWxMassTimes",marketActivityService.countMonthWxMassTimes(sellerId));
        modelMap.put("subsribeCount",userService.getSubsribeUserCount(sellerId));
        modelMap.put("interactCount",userService.getInteractiveUserCount(sellerId));

        return new ModelAndView("/contactCustomer/wxMarketing",modelMap);
    }

    /**
     * 发送微信营销活动
     * @param multipartRequest
     * @param session
     * @return
     */
    @RequestMapping(value = "/sendWxMarket")
    @PreventDuplicateSubmission(needValidateToken = true)
    @ResponseBody
    public Map<String, Object> sendWxMarket(MultipartHttpServletRequest multipartRequest, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();
        Long sellerId = getSellerId(session);

        String jsonStr = multipartRequest.getParameter("marketVO");
        MarketActivityVO marketActivityVO;
        try {
            marketActivityVO = (MarketActivityVO) JSONUtils.parseToObject(jsonStr,MarketActivityVO.class);
            marketActivityVO.setSellerId(sellerId);
        }catch (Exception e){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"json实体转换异常！");
            return map;
        }

        if (marketActivityVO == null){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"json实体转换失败！");
            return map;
        }

        /**
         * 获取图文消息的图片
         */
        MultipartFile wxImgFile = multipartRequest.getFile("wxImgUrl");
        String wxImgUrl = null;
        try {
            if (wxImgFile != null){
                String wxImgPath = filepath + sellerId + "/news/";
                wxImgUrl = FileUtils.uploadFile(null,wxImgPath, wxImgFile);
                if (StringUtils.isBlank(wxImgUrl)){
                    map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                    map.put(ERROR_MESSAGE_KEY,"图片上传失败！");
                    return map;
                }
            }
        }catch (Exception e){
            logger.error("微信图文图片上传异常");
        }

        /**
         * 根据发送方式的不同发送微信活动（群发接口和客服接口），
         * 具体参照微信公众平台开发文档
         */
        marketActivityVO.setWxMediaType(DaoConstant.WxMediaType.THUMB);
        if ("mass".equals(marketActivityVO.getWxSendType())){
            /**
             * 群发接口发送图文消息
             */
            try {
                String uploadPath = PropertyReader.getValue("uploadPath");
                marketActivityVO.setWxMediaPath(uploadPath+wxImgUrl);
                marketActivityService.sendWxMass(marketActivityVO);
            }catch (Exception e){
                logger.error("群发接口发送微信图文消息失败",e);
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"微信图文消息群发失败！");
                return map;
            }
        }else if ("custom".equals(marketActivityVO.getWxSendType())){
            /**
             * 客服接口发送图文消息
             */
            try {
                marketActivityVO.setWxMediaPath("/upload"+wxImgUrl);
                marketActivityService.sendWxCustom(marketActivityVO);
            }catch (Exception e){
                logger.error("客服接口发送图文消息失败",e);
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"微信图文消息群发失败！");
                return map;
            }
        }

        map.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        map.put(ERROR_MESSAGE_KEY, "微信图文消息已发送");
        return map;
    }

    /**
     * 发送营销活动
     *
     * @param marketActivityVO
     */
    @RequestMapping(value = "/sendActivity")
    @PreventDuplicateSubmission(needValidateToken = true)
    public
    @ResponseBody
    Map<String, Object> sendActivity(@Valid MarketActivityVO marketActivityVO, @Valid UserVO userVO, HttpSession session) {
        Map<String, Object> datas = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        marketActivityVO.setSellerId(sellerId);
        userVO.setSellerId(sellerId);
        try {
            if (marketActivityService.sendMarketing(userVO, marketActivityVO)) {
                datas.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            } else {
                datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            }
        } catch (Exception e) {
            datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        }
        return datas;
    }

    /**
     * 营销方案查询
     *
     * @return
     */
    @RequestMapping(value = "/marketList")
    @ResponseBody
    public ModelAndView marketList() {
        return new ModelAndView("/contactCustomer/marketActivityList");
    }

    /**
     * 营销方案列表
     *
     * @return
     */
    @RequestMapping(value = "/marketDetail")
    @ResponseBody
    public ModelAndView marketDetail(String activityId, String type, HttpSession session) {

        Map<String, Object> map = Maps.newHashMap();
        map.put("activityId", activityId);
        map.put("adminUser", getUser(session));
        map.put("type", type);
        return new ModelAndView("/contactCustomer/marketActivityDetail", map);
    }

    /**
     * 充值
     *
     * @return
     */
    @RequestMapping(value = "/recharge")
    @ResponseBody
    public ModelAndView recharge(ModelMap modelMap, HttpSession session) {

        String selleId = String.valueOf(getSellerId(session));
        SellerPackageCountVO smsAccount = sendService.querySellerSendCount(selleId, "SMS");
        if (smsAccount != null) {
            modelMap.put("smsAccount", smsAccount);
        }

        SellerPackageCountVO emailAccount = sendService.querySellerSendCount(selleId, "MAIL");
        if (emailAccount != null) {
            modelMap.put("emailAccount", emailAccount);
        }

        return new ModelAndView("/contactCustomer/recharge");
    }


    @RequestMapping(value = "/rechargeList")
    public
    @ResponseBody
    Map<String, Object> rechargeList(@Valid MarketPackageVO marketPackageVO, Integer pageNum, Integer length) {

        PageInfo pageInfo = marketActivityService.queryMarketPackage(marketPackageVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 获取营销用户信息
     *
     * @param userVO
     * @param pageNum
     * @param length
     * @param sortContent
     * @param customPurchaseType 客户购买类型
     * @return
     */
    @RequestMapping(value = "/concactUser")
    public
    @ResponseBody
    Map<String, Object> selectConcactClient(@Valid UserVO userVO, Integer pageNum,
                                            Integer length, String sortContent, String customPurchaseType, HttpSession session) {
        Map<String, Object> datas = Maps.newHashMap();

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        Long sellerId = getSellerId(session);
        userVO.setSellerId(sellerId);
        userVO.setOrderClause(sortContent);
        PageInfo pageInfo = null;

        if (WebConstant.CustomPurchaseType.SUCCESS_PURCHASE.equals(customPurchaseType)) {
            try {
                pageInfo = userService.queryUserWithPortrait(userVO, pageNum, length);
            } catch (Exception e) {
                datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                datas.put(ERROR_MESSAGE_KEY, "交易成功用户查找异常");
                return datas;
            }
        }

        if (WebConstant.CustomPurchaseType.POTENTIAL_PURCHASE.equals(customPurchaseType)) {
            TradeVO tradeVO = new TradeVO();
            tradeVO.setSellerId(sellerId);
            tradeVO.setKeyword(userVO.getKeyword());
            tradeVO.setReceiverName(userVO.getName());
            tradeVO.setTradeSource(userVO.getSource());
            tradeVO.setOrderClause(userVO.getOrderClause());
            tradeVO.setHasMobile(userVO.getHasMobile());
            tradeVO.setLastDays(StringUtils.isBlank(userVO.getTime()) ? null : Integer.valueOf(userVO.getTime()));
            if (StringUtils.isNotBlank(userVO.getMaxPrice())) {
                tradeVO.setMaxPrice(new BigDecimal(userVO.getMaxPrice()));
            }
            if (StringUtils.isNotBlank(userVO.getMinPrice())) {
                tradeVO.setMinPrice(new BigDecimal(userVO.getMinPrice()));
            }

            /**
             * 根据店铺类型和商家id获取店铺id列表
             */
            List<Long> shopIds = new ArrayList<Long>();
            SellerShopVO shopVO = new SellerShopVO();
            shopVO.setSellerId(sellerId);
            if (StringUtils.isNotBlank(userVO.getSource())) {
                shopVO.setShopType(userVO.getSource());
                List<SellerShop> shops = sellerConfigService.queryShops(shopVO);
                if (!CollectionUtils.isEmpty(shops)) {
                    for (SellerShop shop : shops) {
                        shopIds.add(shop.getShopId());
                    }
                    tradeVO.setShopIdList(shopIds);
                } else {
                    datas.put("recordsFiltered", 0);
                    datas.put("recordsTotal", 0);
                    datas.put("data", new PageInfo(null));
                    return datas;
                }
            }

            try {
                pageInfo = tradeService.selectTradeFromAll(tradeVO, pageNum, length);
            } catch (Exception e) {
                datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                datas.put(ERROR_MESSAGE_KEY, "潜在购买用户查找异常");
                return datas;
            }
        }

        if (pageInfo != null) {
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
            datas.put("userVO", userVO);
        }
        return datas;
    }

    /**
     * 查询营销活动，（短信，邮件）
     *
     * @param marketRecordsVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping(value = "/searchActivity")
    public
    @ResponseBody
    Map<String, Object> searchActivityDetail(@Valid MarketRecordsVO marketRecordsVO, Integer pageNum, Integer length, HttpSession session) {
        Map<String, Object> datas = Maps.newHashMap();

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        marketRecordsVO.setSellerId(getSellerId(session));
        PageInfo pageInfo;
        try {
            pageInfo = marketActivityService.queryMarketActivity(marketRecordsVO, pageNum, length);
        } catch (Exception e) {
            datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            datas.put(ERROR_MESSAGE_KEY, "营销活动查找异常");
            return datas;
        }

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    @RequestMapping(value = "/marketingList")
    public
    @ResponseBody
    Map<String, Object> showList(@Valid MarketActivityVO marketVO, Integer pageNum, Integer length, HttpSession session) {
        Map<String, Object> datas = Maps.newHashMap();

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        marketVO.setSellerId(getSellerId(session));
        PageInfo pageInfo;
        try {
            pageInfo = marketActivityService.queryMarketingList(marketVO, pageNum, length);
        } catch (Exception e) {
            datas.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            datas.put(ERROR_MESSAGE_KEY, "营销活动明细查找异常");
            return datas;
        }

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 编辑营销活动
     *
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/edit")
    public
    @ResponseBody
    Map<String, Object> edit(Long activityId, HttpSession session) {
        if (activityId == null) {
            return null;
        }

        Map<String, Object> map = Maps.newHashMap();
        Long sellerId = getSellerId(session);
        List<MarketActivity> list = marketActivityService.findActivity(activityId, sellerId);
        if (list.size() <= 0) {
            map.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY, "查找结果为空");
            return map;
        }
        MarketActivityVO result = (MarketActivityVO) BeanCopierUtils.copyProperties(list.get(0), MarketActivityVO.class);
        map.put("marketResult", result);
        return map;
    }

    /**
     * 保存营销编辑
     *
     * @param marketActivityVO
     * @return
     */
    @RequestMapping(value = "/save")
    public
    @ResponseBody
    Map<String, Object> save(MarketActivityVO marketActivityVO) {
        Map<String, Object> map = Maps.newHashMap();

        int result = marketActivityService.saveEdit(marketActivityVO);
        if (result == 1) {
            map.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        }
        return map;
    }

    @RequestMapping(value = "/emailSelect")
    public
    @ResponseBody
    Map<String, Object> emailSelect(String str, HttpSession session) {
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        int userCount = userService.findEmailUser(str, sellerId);
        map.put("userCount", userCount);
        return map;
    }

    @RequestMapping(value = "/deleteActivity")
    public
    @ResponseBody
    Map<String, Object> switchState(Long activityId, HttpSession session) {
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        if (marketActivityService.deleteActivity(activityId, sellerId)) {
            map.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        }

        return map;
    }

    /**
     * 短信测试
     *
     * @param mobile 测试手机号
     * @return
     */
    @RequestMapping(value = "/smsTest")
    public
    @ResponseBody
    Map<String, Object> smsTest(String mobile, String target,String title, String content, HttpSession session) {
        Map<String, Object> modelMap = Maps.newHashMap();

        if (mobile == null || StringUtils.isBlank(mobile)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "手机号为空");
            return modelMap;
        }

        /**
         * 给用户发送一条短信
         */
        Long sellerId = getSellerId(session);
        String smsSendResult = sendService.sendSms(String.valueOf(sellerId), DaoConstant.SmsSaleType.Test, DaoConstant.SmsSend.SEND_SALE, mobile, content, DaoConstant.SmsFatigueFlag.IS_NOT_FATIGUE);
        try{
            MarketActivityVO activityVO = new MarketActivityVO();
            activityVO.setSellerId(Long.valueOf(sellerId));
            activityVO.setTitle(title);
            if ("0".equals(smsSendResult)){
                activityVO.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);
                activityVO.setStatus(DaoConstant.MarketSendStatus.SUCCESS);
            }else{
                activityVO.setIsSuccess(DaoConstant.MarketSendStatus.FAILED);
                activityVO.setStatus(DaoConstant.MarketSendStatus.FAILED);
            }
            activityVO.setType("sms");
            activityVO.setTarget(DaoConstant.SmsSaleType.Test);
            activityVO.setMobile(mobile);
            activityVO.setContent(content);
            activityVO.setContentType("text");
            activityVO.setWxPersonCount(1);
            activityVO.setExecuteTime(new Date());
            activityVO.setExecuteType("0");

            MarketRecords record = new MarketRecords();
            record.setUserId(sellerId);
            record.setActivityTitle(title);
            record.setMobile(mobile);
            record.setIsSuccess(activityVO.getIsSuccess());
            record.setIsOpen(DaoConstant.MarketSendStatus.UNOPEND);
            record.setType(activityVO.getType());
            record.setExecuteTime(activityVO.getExecuteTime());
            record.setSellerId(sellerId);

            List<MarketRecords> recordList = new ArrayList<MarketRecords>();
            recordList.add(record);
            activityVO.setRecordsList(recordList);

            marketActivityService.saveOrUpdateActivity(activityVO);
        }catch (Exception e){
            logger.error("测试一下短信明细保存异常");
        }
        if ("0".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            modelMap.put(ERROR_MESSAGE_KEY, "测试短信发送成功。");
        } else if ("-1".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，测试短信发送失败。");
        } else if ("-2".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，您的余额不足，请先充值。");
        } else {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，测试短信发送失败，请稍后重试！");
        }
        return modelMap;
    }

    /**
     * 邮件测试
     *
     * @param email 测试邮箱
     * @return
     */
    @RequestMapping(value = "/emailTest")
    public
    @ResponseBody
    Map<String, Object> emailTest(String email, String target, String title, String content, HttpSession session) {
        Map<String, Object> modelMap = Maps.newHashMap();

        if (email == null || StringUtils.isBlank(email)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "邮箱地址为空");
            return modelMap;
        }

        /**
         * 给用户发送一封邮件
         */
        Long sellerId = getSellerId(session);
        String smsSendResult = sendService.sendEmail(String.valueOf(sellerId), DaoConstant.SmsSaleType.Test, title, content, email);
        try{
            MarketActivityVO activityVO = new MarketActivityVO();
            activityVO.setSellerId(Long.valueOf(sellerId));
            activityVO.setTitle(title);
            if ("0".equals(smsSendResult)){
                activityVO.setIsSuccess(DaoConstant.MarketSendStatus.SUCCESS);
                activityVO.setStatus(DaoConstant.MarketSendStatus.SUCCESS);
            }else{
                activityVO.setIsSuccess(DaoConstant.MarketSendStatus.FAILED);
                activityVO.setStatus(DaoConstant.MarketSendStatus.FAILED);
            }
            activityVO.setType("email");
            activityVO.setTarget(DaoConstant.SmsSaleType.Test);
            activityVO.setEmail(email);
            activityVO.setContent(content);
            activityVO.setContentType("text");
            activityVO.setWxPersonCount(1);
            activityVO.setExecuteTime(new Date());
            activityVO.setExecuteType("0");

            MarketRecords record = new MarketRecords();
            record.setUserId(sellerId);
            record.setActivityTitle(title);
            record.setEmail(email);
            record.setIsSuccess(activityVO.getIsSuccess());
            record.setIsOpen(DaoConstant.MarketSendStatus.UNOPEND);
            record.setType(activityVO.getType());
            record.setExecuteTime(activityVO.getExecuteTime());
            record.setSellerId(sellerId);

            List<MarketRecords> recordList = new ArrayList<MarketRecords>();
            recordList.add(record);
            activityVO.setRecordsList(recordList);

            marketActivityService.saveOrUpdateActivity(activityVO);
        }catch (Exception e){
            logger.error("测试一下短信明细保存异常");
        }
        if ("0".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            modelMap.put(ERROR_MESSAGE_KEY, "测试邮件发送成功");
        } else if ("-1".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，测试邮件发送失败");
        } else if ("-2".equals(smsSendResult)) {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，您的余额不足，请先充值。");
        } else {
            modelMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            modelMap.put(ERROR_MESSAGE_KEY, "对不起，测试短信发送失败，请稍后重试！");
        }
        return modelMap;
    }

}
