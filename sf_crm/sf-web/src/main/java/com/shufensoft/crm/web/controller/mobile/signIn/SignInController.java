package com.shufensoft.crm.web.controller.mobile.signIn;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.service.signIn.SignInService;
import com.shufensoft.crm.biz.service.signIn.vo.SignInVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/7/16  
 */
@RequestMapping(value = "/mobile")
@Controller
public class SignInController extends BaseController {

    @Autowired
    private SignInService signInService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn")
    @PreventDuplicateSubmission(needCreateToken = true)
    public ModelAndView showIndex(ModelMap modelMap, String userId, HttpServletRequest httpRequest) {

        if (signInService.isSignIn(Long.valueOf(userId))) {

            modelMap.put("isSignIn", "1");
        }else{
            modelMap.put("isSignIn", "0");
        }


        /**
         * 查询前100名用户的当天的签到排名情况
         */
        PageInfo pageInfo = signInService.queryCurrentDaySignInRanking(1, 100);
        modelMap.put("currentDaySignInRank", pageInfo.getList());

        /**
         * 查询前100名用户当月的签到排名情况
         */
        PageInfo currentMonthSignInRank = signInService.queryCurrentMonthUserSignInRanking(1, 100);
        modelMap.put("currentMonthSignInRank", currentMonthSignInRank.getList());

        /**
         * 查询前100名用户总的签到排名情况
         */
        PageInfo totalSignInRank = signInService.queryTotalUserSignInRanking(1, 100);
        modelMap.put("totalSignInRank", totalSignInRank.getList());
        modelMap.put("userId", userId);
        modelMap.put("token", httpRequest.getAttribute("token"));

        return new ModelAndView("/mobile/signIn/sign", modelMap);
    }


    /**
     * 执行签到
     *
     * @param userId
     * @param sellerId
     * @return
     */
    @RequestMapping(value = "/signIn/doSignIn")
    @PreventDuplicateSubmission(needValidateToken = true)
    public
    @ResponseBody
    Map<String, Object> doSignIn(String userId, String sellerId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
        Map<String, Object> signInResultMap = new HashMap<String, Object>();

        //userId = "3208880542";
        if (signInService.isSignIn(Long.valueOf(userId))) {
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(INFO_KEY, "1");
            return returnMap;
        }

        int code = signInService.doSignIn(Long.valueOf(sellerId), Long.valueOf(userId));

        if (code != -1) {
            signInResultMap.put("point", code);

            returnMap.put(INFO_KEY, signInResultMap);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);

        }


        return returnMap;
    }


    @RequestMapping(value = "/signIn/querySignInInfo")
    public
    @ResponseBody
    Map<String, Object> querySignInInfo(String userId, String sellerId) {

        //userId = "3208880542";


        Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String, Object> signInResultMap = new HashMap<String, Object>();

        returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);

        try {


            /**
             * 根据userId查询用户信息
             */
            User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

            if (user != null) {
                signInResultMap.put("wxHeadImgUrl", user.getWxHeadimgurl());
                signInResultMap.put("wxNickName", user.getWxNickName());
            }

            /**
             * 查询我的累积签到次数
             */
            UserDO userDO = userService.getUserAndPortrait(user.getUserId(),Long.valueOf(sellerId));

            String signInTimes = "0";

            if (userDO != null) {
                if (userDO.getSignInTimes() != null) {

                    signInTimes = String.valueOf(userDO.getSignInTimes());
                }

            }
            signInResultMap.put("signInTimes", signInTimes);


            /**
             * 查询我的积分总数
             */
            UserAccount userAccount = userService.getUserPointCount(Long.valueOf(sellerId),user.getUserId());

            if (userAccount != null) {

                signInResultMap.put("totalPoint", userAccount.getPointAmountTotal());
            } else {
                signInResultMap.put("totalPoint", "0");
            }


            /**
             * 查询我当月的排名情况
             */
            SignInVO currentMonthMySignInRank = signInService.queryCurrentMonthMySignInRank(user.getUserId());

            if (currentMonthMySignInRank != null) {

                signInResultMap.put("currentMonthMySignInRank", currentMonthMySignInRank);
                signInResultMap.put("myMonthRankFlag", "1");
            } else {
                signInResultMap.put("myMonthRankFlag", "0");
            }

            /**
             * 查询我当天的排名情况
             */
            SignInVO currentDayMySignInRank = signInService.queryCurrentDayMySignInRank(user.getUserId());

            if (currentDayMySignInRank != null) {


                signInResultMap.put("myDayRankFlag", "1");
            } else {
                signInResultMap.put("myDayRankFlag", "0");
                currentDayMySignInRank = new SignInVO();
                currentDayMySignInRank.setSignInRank("0");
            }
            signInResultMap.put("currentDayMySignInRank", currentDayMySignInRank);


            /**
             * 查询我的总签到排名情况
             */
            SignInVO totalMySignInRank = signInService.queryTotalMySignInRank(user.getUserId());

            if (totalMySignInRank != null) {

                signInResultMap.put("totalMySignInRank", totalMySignInRank);
                signInResultMap.put("myTotalRankFlag", "1");
            } else {

                signInResultMap.put("myTotalRankFlag", "0");
            }

            /**
             * 查询前100名用户的当天的签到排名情况
             */
            PageInfo pageInfo = signInService.queryCurrentDaySignInRanking(1, 100);
            signInResultMap.put("currentDaySignInRank", pageInfo.getList());

            /**
             * 查询前100名用户当月的签到排名情况
             */
            PageInfo currentMonthSignInRank = signInService.queryCurrentMonthUserSignInRanking(1, 100);
            signInResultMap.put("currentMonthSignInRank", currentMonthSignInRank.getList());

            /**
             * 查询前100名用户总的签到排名情况
             */
            PageInfo totalSignInRank = signInService.queryTotalUserSignInRanking(1, 100);
            signInResultMap.put("totalSignInRank", totalSignInRank.getList());

            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(INFO_KEY, signInResultMap);
        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请稍后再试。");
        }

        return returnMap;

    }


}
