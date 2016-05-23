package com.shufensoft.crm.web.controller.mobile.shake;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetail;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtain;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.hongbao.HongBaoBizService;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.hongbao.helper.PointHelper;
import com.shufensoft.crm.biz.service.present.PresentService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.helper.UserVaidateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/10 下午8:03  
 */
@RequestMapping(value = "/mobile")
@Controller
public class ShakeController extends BaseController {


    public static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ShakeController.class);

    @Autowired
    private RockService rockService;


    @Autowired
    private UserService userService;


    @Autowired
    private PresentService presentService;

    @Autowired
    private WXService wXService;

    @Autowired
    private HongBaoBizService hongBaoBizService;


    public static ConcurrentControlHelper executePointConcurrentControlHelper = new ConcurrentControlHelper();

    public static String JOIN_POINT_CONCURRENT_THREAD_NUM_TYPE = "JOIN_POINT_CONCURRENT_THREAD_NUM";

    public static String JOIN_POINT_NAME = "JOIN_POINT";


    @RequestMapping("/doShake")
    @ResponseBody
    public ModelAndView rock(HttpServletRequest request, HttpServletResponse response, String userId, String sellerId, String rockId, String hbPoolId) {

        Map<String, Object> map = Maps.newHashMap();
        ShakeDetail rockDetail = rockService.queryShakeConfig(Long.valueOf(sellerId), rockId);
        String isShakeHb = "0";
        String isShakePoint = "0";
        String isShakeGift = "0";

        String isGetSharePoint = "0";
        String isGetShareGift = "0";


        if (StringUtils.isNotEmpty(rockDetail.getIsShakeHb())) {
            isShakeHb = rockDetail.getIsShakeHb();

        }
        if (StringUtils.isNotEmpty(rockDetail.getIsShakeGift())) {
            isShakeGift = rockDetail.getIsShakeGift();

        }

        if (StringUtils.isNotEmpty(rockDetail.getIsShakePoint())) {
            isShakePoint = rockDetail.getIsShakePoint();

        }

        if (StringUtils.isNotEmpty(rockDetail.getIsGetGiftShare())) {
            isGetShareGift = rockDetail.getIsGetGiftShare();
        }


        if (StringUtils.isNotEmpty(rockDetail.getIsGetPointShare())) {
            isGetSharePoint = rockDetail.getIsGetPointShare();
        }

        map.put("isShakeHb", isShakeHb);
        map.put("isShakePoint", isShakePoint);
        map.put("isShakeGift", isShakeGift);


        if ("1".equals(rockDetail.getIsShakeGift()) && "1".equals(rockDetail.getIsShakePoint())) {

            if ("1".equals(isGetShareGift) &&
                    "1".equals(isGetSharePoint)) {
                map.put("isShare", "1");
            } else {
                map.put("isShare", "0");
            }
        } else {

            if ("1".equals(isGetShareGift) || "1".equals(isGetSharePoint)) {
                map.put("isShare", "1");
            } else {
                map.put("isShare", "0");
            }

        }


        /**
         * 如果已关注显示红包，未关注隐藏功能，防止被认为诱导
         */
        if (userService.isSubscribeByUserId(Long.valueOf(userId), Long.valueOf(sellerId))) {
            map.put("isShowHb", "1");
        } else {
            map.put("isShowHb", "0");
        }

        // 默认20次
        Integer rockTimes = 20;

        if (rockDetail.getRockNum() != null) {
            rockTimes = rockDetail.getRockNum();
        }
        if (StringUtils.isNotEmpty(userId)) {

            map.put("userId", userId);
            map.put("rockId", rockId);
            map.put("hbPoolId", hbPoolId);
            map.put("sellerId", sellerId);
            map.put("rockTimes", rockTimes);
            map.put("shakeName", rockDetail.getRockTitle());

        }

        ResourceBundle bundle = PropertyResourceBundle.getBundle("config");

        try {

            String url = bundle.getString("crm.web.url") + request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wXService.getWxJsConfigIn(Long.valueOf(sellerId), url);
            map.put("wxJsConfig", datas);


            if ("1".equals(rockDetail.getIsVerify())) {
                User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));


                /**
                 * 用户认证处理
                 */
                if (UserVaidateHelper.isNeedValidate(request, Long.valueOf(sellerId)) && (StringUtils.isBlank(user.getIsVerify()) || "0".equals(user.getIsVerify()))) {

                    String redirectUrl = URLEncoder.encode(request.getContextPath() + request.getServletPath() + "?sellerId=" + sellerId + "&userId=" + user.getUserId() + "&rockId=" + rockId, "utf-8");
                    //request.getRequestDispatcher("/mobile/identify?sellerId=" + sellerId + "&userId=" + user.getUserId() + "&redirectUrl=" + redirectUrl).forward(request, response);
                    return new ModelAndView("redirect:/mobile/identify?sellerId=" + sellerId + "&userId=" + user.getUserId() + "&redirectUrl=" + redirectUrl);
                }
            }


        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return new ModelAndView("/mobile/shake/doShake", map);
    }

    @RequestMapping("/checkhb")
    @ResponseBody
    public ModelAndView checkHB(String sellerId) {
        Map<String, Object> map = Maps.newHashMap();
        return new ModelAndView("/mobile/shake/checkHB", map);
    }


    @RequestMapping(value = "/rock/doRock")
    public
    @ResponseBody
    Map<String, Object> doRock(String userId, String sellerId, String rockId, String rockType) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        if (StringUtils.isBlank(rockType)) {

            returnMap.put(ERROR_MESSAGE_KEY, "请选择摇一摇的类型。");
            return returnMap;
        }

        returnMap.put("sellerId", sellerId);
        returnMap.put("userId", userId);
        returnMap.put("rockType", rockType); // 返回摇一遥类型


        try {

            /**
             * 控制web允许放入的最大线程数，超出线程数，提示用户友好信息
             */
            Boolean joinConcurrentThreadLockFlag = executePointConcurrentControlHelper.getConcurrentThreadLock(JOIN_POINT_CONCURRENT_THREAD_NUM_TYPE, JOIN_POINT_NAME);

            if (!joinConcurrentThreadLockFlag) {

                returnMap.put(ERROR_MESSAGE_KEY, "抢的的人数过多，请稍后再试!");

                return returnMap;
            }


            ShakeDetail rockDetail = rockService.queryShakeConfig(Long.valueOf(sellerId), rockId);


            if (rockDetail.getStartDate() != null || rockDetail.getEndDate() != null) {

                if (rockDetail.getStartDate().getTime() > new Date().getTime()) {
                    returnMap.put(ERROR_MESSAGE_KEY, "对不起，活动还没有开始。");
                    return returnMap;
                }

                if (rockDetail.getEndDate().getTime() < new Date().getTime()) {

                    // 活动结束状态更新
                    rockService.shakeEnd(Long.valueOf(sellerId), rockId);

                    returnMap.put(ERROR_MESSAGE_KEY, "对不起，活动已结束。");
                    return returnMap;
                }
            }


            int code = CommonUtil.getRandomCode(1, 100);

            /**
             *  根据机率配置判断是否摇到并触发
             */
            if (code <= rockDetail.getRandomNum()) {


                if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(rockType)) {


                    if (!PointHelper.isPointObtained(Long.valueOf(sellerId), Long.valueOf(rockId))) {
                        returnMap.put(ERROR_MESSAGE_KEY, "今天的积分已抢完。");
                        return returnMap;
                    }


                    if (!rockService.isObtailPoint(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(rockId), Long.valueOf(rockDetail.getGetNum()))) {
                        returnMap.put(ERROR_MESSAGE_KEY, "您不能再领了,下次再来！。");
                        PointHelper.incrementPointNum(Long.valueOf(rockId));
                        return returnMap;
                    }

                    returnMap.put("isShare", rockDetail.getIsGetPointShare());

                    doPoint(sellerId, userId, DaoConstant.ShakeBizType.SHAKE_POINT, rockId, returnMap);

                } else if (DaoConstant.ShakeBizType.SHAKE_HB.equals(rockType)) {

                    if (hongBaoBizService.isHbObtainByUserIdAndObtainId(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(rockDetail.getRockId()))) {
                        returnMap.put(ERROR_MESSAGE_KEY, "您不能再领了,下次再来！。");
                        return returnMap;
                    }

                    // 返回进入抢红包业务
                    returnMap.put("isHB", "1");
                    returnMap.put("hbPoolId", rockDetail.getHbPoolId());
                    returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);


                    return returnMap;

                } else if (DaoConstant.ShakeBizType.SHAKE_GIFT.equals(rockType)) {


                    int giftCode = presentService.queryUserPresentCountByUserIdAndRockId(Long.valueOf(userId), Long.valueOf(rockId));

                    if (giftCode > rockDetail.getGetNum()) {

                        returnMap.put(ERROR_MESSAGE_KEY, "您不能再领了,下次再来！。");
                        return returnMap;
                    }

                    returnMap.put("isShare", rockDetail.getIsGetGiftShare());

                    //摇礼物
                    doGift(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(rockId), rockDetail.getGoodsId(), returnMap);

                } else {

                    returnMap.put(ERROR_MESSAGE_KEY, "您没有摇到任何东西。");
                    return returnMap;
                }

                User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));


                if (user != null) {

                    returnMap.put("headImgUrl", user.getWxHeadimgurl());
                    returnMap.put("nickName", user.getWxNickName());
                }


            } else {

                returnMap.put(ERROR_MESSAGE_KEY, "您什么都没有摇到，继续加油摇哦！");
            }
        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, "您没有摇到任何东西。");

            if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(rockType)) {
                PointHelper.incrementPointNum(Long.valueOf(rockId));
            }

            return returnMap;

        } finally {

            executePointConcurrentControlHelper.releaseBizConcurrentThreadLock();
        }

        return returnMap;
    }


    /**
     * 抢礼物
     *
     * @param userId
     * @param rockId
     * @param goodsUrl
     * @param returnMap
     */
    private void doGift(Long sellerId, Long userId, Long rockId, String goodsUrl, Map<String, Object> returnMap) {


        String[] strings = goodsUrl.split("&");

        int goodsIds = CommonUtil.getRandomCode(0, strings.length);

        Long goodsId = Long.valueOf(strings[goodsIds]);

        long goodsCode = presentService.doTakeUpGoods(Long.valueOf(userId), goodsId, Long.valueOf(rockId));

        if (goodsCode == -1) {

            returnMap.put(ERROR_MESSAGE_KEY, "您没有摇到任何东西。");
        } else {

            rockService.insertShakeObtain(sellerId, userId, DaoConstant.ShakeBizType.SHAKE_GIFT, rockId, goodsCode, DaoConstant.ShakeObtainStatus.TO_RECEIVE);
            returnMap.put("obtainId", goodsCode);
            returnMap.put("goodsId", goodsId);
            returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.SUCCESS);
        }
    }

    /**
     * 抢积分
     *
     * @param sellerID
     * @param userId
     * @param rockType
     * @param rockId
     * @param returnMap
     */
    public void doPoint(String sellerID, String userId, String rockType, String rockId, Map<String, Object> returnMap) {

        // 将用户与积分绑定，初始为待领取状态
        Long obtainId = rockService.doShake(Long.valueOf(sellerID),
                Long.valueOf(userId), rockType, Long.valueOf(rockId), DaoConstant.ShakeObtainStatus.TO_RECEIVE);

        if (-1 != obtainId) {

            returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.SUCCESS);
            returnMap.put("obtainId", obtainId); // 返回获取结果的ID

        }
    }


    /**
     * 拆积分
     *
     * @param sellerId
     * @param userId
     * @param obtainId
     * @param type
     * @param isSubscribe
     * @param returnMap
     */
    private void doTakePoint(Long sellerId, Long userId, Long obtainId, String type, String isSubscribe, Map<String, Object> returnMap) {


        if (DaoConstant.WxSubscribe.YES.equals(isSubscribe)) {

            Long obtainValue = rockService.doUserObtainShake(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(obtainId), type);

            if (-1 != obtainValue) {

                returnMap.put("obtainValue", obtainValue);
                returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            }
        } else {

            Long point = PointHelper.queryPointByObtainId(Long.valueOf(obtainId));

            if (point != -1) {

                returnMap.put("obtainValue", point);
            } else {

                // 异常显示值
                returnMap.put("obtainValue", "0");
            }
        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);

    }


    /**
     * 点击拆开积分、领取并显示结果。
     *
     * @param userId
     * @param sellerId
     * @return
     */
    @RequestMapping(value = "/rock/doTake")
    public
    @ResponseBody
    ModelAndView doTake(HttpServletRequest request, String sellerId, String userId, String obtainId, String type, String headImg, String isShare, String shakeName) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        returnMap.put("headImg", headImg);
        returnMap.put("shakeType", type);
        returnMap.put("isShare", isShare);
        returnMap.put("shakeName", shakeName);


        try {

            String isSubscribe = DaoConstant.WxSubscribe.NO;

            /**
             * 如果已关注，直接领取，如果未关注，只返回积分结果并返回待领取标识给页面。
             */

            if (userService.isSubscribeByUserId(Long.valueOf(userId), Long.valueOf(sellerId))) {

                isSubscribe = DaoConstant.WxSubscribe.YES;
            } else {

                SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);

                // 公众号二维码
                if (sellerConfigInfo != null) {

                    returnMap.put("wxQrcode", sellerConfigInfo.getWxQrcode());
                }


            }

            returnMap.put("isSubscribe", isSubscribe);

            if (!rockService.isObtainShakePoint(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(obtainId))) {


                if (DaoConstant.ShakeBizType.SHAKE_POINT.equals(type)) {

                    doTakePoint(Long.valueOf(sellerId), Long.valueOf(userId), Long.valueOf(obtainId), type, isSubscribe, returnMap);

                }

            } else {

                Long point = PointHelper.queryPointByObtainId(Long.valueOf(obtainId));

                if (point != -1) {

                    returnMap.put("obtainValue", point);
                } else {

                    // 异常显示值
                    returnMap.put("obtainValue", "0");
                }
            }


            UserAccount userAccount = userService.getUserPointCount(Long.valueOf(sellerId), Long.valueOf(userId));

            if (userAccount != null) {
                returnMap.put("pointTotal", userAccount.getPointAmountTotal());
                returnMap.put("pointRemain", userAccount.getPointAmount());

            } else {
                returnMap.put("pointTotal", "0");
                returnMap.put("pointRemain", "0");
            }

            ResourceBundle bundle = PropertyResourceBundle.getBundle("config");

            try {

                String url = bundle.getString("crm.web.url") + request.getServletPath() + "?" + request.getQueryString();
                Map<String, String> datas = wXService.getWxJsConfigIn(Long.valueOf(sellerId), url);
                returnMap.put("wxJsConfig", datas);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请稍后重试。");
        }


        return new ModelAndView("/mobile/shake/checkHB", returnMap);


    }


    @RequestMapping(value = "/shake")
    public ModelAndView getShakeList(long userId, String sellerId) {

        AssertsUtil.notNull(userId, "userId");


        User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), userId);


        AssertsUtil.notNull(user, "user");

        //默认取前50条记录
        ShakeObtain shakeObtain = new ShakeObtain();
        shakeObtain.setSellerId(Long.valueOf(sellerId));
        List<ShakeObtain> shakeObtains = rockService.getShakeObtainList(shakeObtain, 1, 50);

        List<ShakeDetail> shakeDetails = rockService.getShakeDetailList(Long.valueOf(sellerId), 1, 50);
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
        String sellerConfigName = sellerConfigInfo.getSellerName();

        Map<String, Object> map = Maps.newHashMap();
        map.put("shakeObtains", shakeObtains);
        map.put("shakeDetails", shakeDetails);
        map.put("sellerConfigName", sellerConfigName);
        map.put("sellerId", sellerId);
        map.put("user", user);

        return new ModelAndView("/mobile/shake/myShake", map);
    }


}
