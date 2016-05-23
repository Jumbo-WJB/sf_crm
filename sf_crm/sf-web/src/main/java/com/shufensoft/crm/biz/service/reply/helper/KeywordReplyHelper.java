package com.shufensoft.crm.biz.service.reply.helper;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.defined.pointMall.UserAccountStaticsDo;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.service.pointmall.face.IClientService;
import com.shufensoft.crm.biz.service.signIn.SignInService;
import com.shufensoft.crm.biz.service.signIn.vo.SignInVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.wechat.constant.WXConstant;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 关键字回复帮助类
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/8/4  
 */
public class KeywordReplyHelper {

    private static SignInService signInService = (SignInService)SpringContextUtil.getBean("signInServiceImpl");

    private static UserService userService = (UserService)SpringContextUtil.getBean("userService");

    private static IClientService iClientService = (IClientService)SpringContextUtil.getBean("iClientService");

    private static String WEB_URL = PropertyReader.getValue("crm.web.url");

    private static String POINT_MALL_URL = "/mobile/pointmall";

    /**
     * 获取消息类型
     *
     * @param keywordVO
     * @return
     */
    public static String getMsgType(KeyWordReplyConfigVO keywordVO) {

        if (keywordVO == null) {
            return null;
        }

        if (DaoConstant.KeyWordBizType.SIGN_IN.equals(keywordVO.getBizType())) {
            return WXConstant.WXMeassgeType.TEXT;
        }

        if (DaoConstant.KeyWordBizType.POINT_QUERY.equals(keywordVO.getBizType())) {
            return WXConstant.WXMeassgeType.TEXT;
        }

        if (DaoConstant.KeyWordBizType.GUIDE.equals(keywordVO.getBizType())) {
            return WXConstant.WXMeassgeType.TEXT;
        }

        return WXConstant.WXMeassgeType.NEWS;

    }

    /**
     * 获取签到消息
     * @param keyWordReplyConfigVO
     * @param sellerId
     * @param userId
     * @return
     */
    public static String assembleSignInMessage(KeyWordReplyConfigVO keyWordReplyConfigVO, Long sellerId,Long userId){

        String message = keyWordReplyConfigVO.getSuccessReplyContent();

        /**
         *  签到
         */
        if (!signInService.isSignIn(Long.valueOf(userId))) {

            int code = signInService.doSignIn(Long.valueOf(sellerId), Long.valueOf(userId));
            message = message.replace("${signPointNum}",String.valueOf(code));
        }else{
            message = message.replace("签到成功，系统自动赠送您${signPointNum}个积分","今天您已签到");
        }

        /**
         * 查询我的总签到排名情况
         */
        SignInVO totalMySignInRank = signInService.queryTotalMySignInRank(userId);
        message = message.replace("${signRank}",totalMySignInRank==null?"":totalMySignInRank.getSignInRank());


        /**
         * 查询我当月的签到次数
         */
        SignInVO currentMonthMySignInRank = signInService.queryCurrentMonthMySignInRank(userId);
        message = message.replace("${signAmountTimes}",currentMonthMySignInRank==null?"0":currentMonthMySignInRank.getSignInTimes());


        /**
         * 查询我的积分
         */

        UserAccount userAccount = userService.getUserPointCount(sellerId,userId);

        Long pointAmountTotal = userAccount==null?0:(userAccount.getPointAmountTotal()==null?0:userAccount.getPointAmountTotal());
        message = message.replace("${pointAmountTotal}",pointAmountTotal==null?"0":String.valueOf(pointAmountTotal));
        Long pointAmountExchange = userAccount==null?0:(userAccount.getPointAmountExchange()==null?0:userAccount.getPointAmountExchange());
        message = message.replace("${pointAmountExchange}",pointAmountExchange==null?"0":String.valueOf(pointAmountExchange));

        Long pointOverplus = userAccount==null?0:(userAccount.getPointAmount()==null?0:userAccount.getPointAmount());

        message = message.replace("${pointOverplus}",String.valueOf(pointOverplus));

        message = message.replace("${mallPointHref}","<a href='"+WEB_URL+POINT_MALL_URL+"?sellerId="+sellerId+"'>积分商城</a>");

        return message;

    }

    /**
     * 获取积分查询消息
     * @param keyWordReplyConfigVO
     * @param sellerId
     * @param userId
     * @return
     */
    public static String assemblePointQuesryMessage(KeyWordReplyConfigVO keyWordReplyConfigVO, Long sellerId,Long userId){

        String message = keyWordReplyConfigVO.getSuccessReplyContent();

        /**
         * 获取积分排名
         */
        UserAccountStaticsDo userAccountRank = iClientService.findUserAccountDoRankByUserId(sellerId, userId);
        message = message.replace("${pointRank}",String.valueOf(userAccountRank.getRanking()));

        /**
         * 查询我的积分
         */

        UserAccount userAccount = userService.getUserPointCount(sellerId,userId);

        Long pointAmountTotal = userAccount==null?0:(userAccount.getPointAmountTotal()==null?0:userAccount.getPointAmountTotal());
        message = message.replace("${pointAmountTotal}",pointAmountTotal==null?"0":String.valueOf(pointAmountTotal));
        Long pointAmountExchange = userAccount==null?0:(userAccount.getPointAmountExchange()==null?0:userAccount.getPointAmountExchange());
        message = message.replace("${pointAmountExchange}",pointAmountExchange==null?"0":String.valueOf(pointAmountExchange));

        Long pointOverplus = userAccount==null?0:(userAccount.getPointAmount()==null?0:userAccount.getPointAmount());

        message = message.replace("${pointOverplus}",String.valueOf(pointOverplus));

        message = message.replace("${mallPointHref}","<a href='"+WEB_URL+POINT_MALL_URL+"?sellerId="+sellerId+"'>积分商城</a>");

        return message;

    }
}
