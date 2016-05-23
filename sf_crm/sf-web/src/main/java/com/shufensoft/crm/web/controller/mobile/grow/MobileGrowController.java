package com.shufensoft.crm.web.controller.mobile.grow;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.service.user.UserInteractionDetailService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.vo.UserInteractionDetailVO;
import com.shufensoft.crm.biz.vo.*;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>我的成长手机端</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/13  
 */
@RequestMapping("/mobile")
@Controller
public class MobileGrowController extends BaseController {

    public static final Logger logger=Logger.getLogger(MobileGrowController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    @Autowired
    private JdTradeService jdTradeService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserInteractionDetailService userInteractionDetailService;

    @Autowired
    private IPointService pointService;

    @Autowired
    private HongbaoService hongbaoService;



    /**
     * 获取我的成长信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/grow")
    public ModelAndView getMyGrow(ModelMap modelMap,String  sellerId,String  userId) {
        modelMap.put("sellerId",sellerId);
        modelMap.put("userId",userId);
        return new ModelAndView("/mobile/grow/suniu_grow", modelMap);

    }

    /**
     * 获取我成长详细信息
     * @return
     */
    @RequestMapping("/getGrowJson")
    public  Object   getMyGrowJson(String sellerId,String userId,HttpServletRequest request){

        AssertsUtil.notNull(userId,"userId");

        User user=  userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));


        AssertsUtil.notNull(user,"user");

        SellerConfigInfo sellerConfigInfo=  SellerConfigCache.get(sellerId);
        String  sellerConfigName= sellerConfigInfo.getSellerName();
        String  wxQrcode=sellerConfigInfo.getWxQrcode();

        //设置开始时间
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(Calendar.YEAR, -1);
        Date startDate=ca.getTime();
        Date endDate=new Date();

        /**
         * 获取淘宝天猫订单数
         */
        int countOrderTaoBao=0;
        if(user.getUserIdTb()!=null){
            OrderTaoBaoVO orderTaoBaoVO=new OrderTaoBaoVO();
            orderTaoBaoVO.setStartDate(startDate);
            orderTaoBaoVO.setEndDate(endDate);
            orderTaoBaoVO.setUserIdTb(user.getUserIdTb());
            orderTaoBaoVO.setSellerId(Long.valueOf(sellerId));
            countOrderTaoBao=  taoBaoTradeService.countOrderTaoBao(orderTaoBaoVO);
        }

        /**
         * 获取淘宝天猫好评数
         */
        int  countCommentTaoBao=0;
        if(user.getUserIdTb()!=null){
            CommentTaoBaoVO commentTaoBaoVO=new CommentTaoBaoVO();
            commentTaoBaoVO.setStartDate(startDate);
            commentTaoBaoVO.setEndDate(endDate);
            commentTaoBaoVO.setUserIdTb(user.getUserIdTb());
            commentTaoBaoVO.setResult("good");
            commentTaoBaoVO.setSellerId(Long.valueOf(sellerId));
            countCommentTaoBao=taoBaoTradeService.countCommnetTaoBao(commentTaoBaoVO);
        }

        /**
         * 获取京东订单数
         */
        int  countOrderJD=0;
        if(user.getUserIdJd()!=null){
            OrderJDVO orderJDVO=new OrderJDVO();
            orderJDVO.setStartDate(startDate);
            orderJDVO.setEndDate(endDate);
            orderJDVO.setUserIdJd(user.getUserIdJd());
            orderJDVO.setSellerId(Long.valueOf(sellerId));
            countOrderJD=jdTradeService.countOrderJD(orderJDVO);
        }


        /**
         * 获取京东好评数量
         */
        int  countCommentJD=0;
        if(user.getUserIdJd()!=null){
            CommentJDVO commentJDVO=new CommentJDVO();
            commentJDVO.setStartDate(startDate);
            commentJDVO.setEndDate(endDate);
            commentJDVO.setUserIdJd(user.getUserIdJd());
            commentJDVO.setScore(5);
            commentJDVO.setSellerId(Long.valueOf(sellerId));
            countCommentJD=jdTradeService.countCommnetJD(commentJDVO);
        }

        /**
         * 获取一年累计互动次数
         */
        int countUserInteractionDetail = 0;
        UserInteractionDetailVO  userInteractionDetailVO=new UserInteractionDetailVO();
        userInteractionDetailVO.setUserId(Long.valueOf(userId));
        userInteractionDetailVO.setStartDate(startDate);
        userInteractionDetailVO.setEndDate(endDate);
        countUserInteractionDetail=userInteractionDetailService.countUserInteractionDetail(Long.valueOf(sellerId),userInteractionDetailVO);


        /**
         * 获取用户账户相关信息
         */
        BigDecimal hbAmount=BigDecimal.ZERO;
        String  pointRank="";
        UserAccountDO  userAccountDO=new UserAccountDO();
        userAccountDO.setUserId(Long.valueOf(userId));
        List<UserAccountDO>  userAccountDOs=  userAccountService.selectUserAccountInteraction(userAccountDO,1,1,Long.valueOf(sellerId));

        if(CollectionUtils.isNotEmpty(userAccountDOs)){
          UserAccountDO userAccount=userAccountDOs.get(0);
          hbAmount= CommonUtil.longDivide(userAccount.getHongbaoAmount(),Long.valueOf(100));
          pointRank= userAccount.getPointRank();
         }


        /**
         *获取红包领取数量
         */
        HBObtainVO hbObtainVO=new HBObtainVO();
        hbObtainVO.setStartDate(startDate);
        hbObtainVO.setEndDate(endDate);
        hbObtainVO.setUserId(Long.valueOf(userId));
        hbObtainVO.setStatus(DaoConstant.HBStatus.RECEIVED);
        int  countHongbaoObtain= hongbaoService.countHongbaoObtain(hbObtainVO,Long.valueOf(sellerId));

        /**
         * 获取红包提现数量
         */
        HBCashVO hbCashVO=new HBCashVO();
        hbCashVO.setStartDate(startDate);
        hbCashVO.setEndDate(endDate);
        hbCashVO.setUserId(Long.valueOf(userId));
        int countHongbaoCash= hongbaoService.countHongbaoCash(hbCashVO,Long.valueOf(sellerId));

        /**
         * 获取积分数量
         */
        PointObtainVO pointObtainVO=new PointObtainVO();
        pointObtainVO.setStartDate(startDate);
        pointObtainVO.setEndDate(endDate);
        pointObtainVO.setUserId(Long.valueOf(userId));
        long  sumPointObtain= pointService.sumPointObtain(pointObtainVO);

        /**
         * 获取签到次数
         */
        pointObtainVO.setObtainMethod(DaoConstant.PointObtainMethod.SIGN_IN);
        long  countPointObtainQd= pointService.countPointObtain(pointObtainVO);

        /**
         * 积分兑换红包次数和消耗积分
         */
        PointExchangeVO pointExchangeVO=new PointExchangeVO();
        pointExchangeVO.setStartDate(startDate);
        pointExchangeVO.setEndDate(endDate);
        pointExchangeVO.setUserId(Long.valueOf(userId));
        pointExchangeVO.setSellerId(Long.valueOf(sellerId));
        pointExchangeVO.setStatus(DaoConstant.PointExchangeStatus.SUCCESS);
        pointExchangeVO.setExchangeMethod(DaoConstant.PointExchangeMethod.HONGBAO);
        long countPointExchangeHb= pointService.countPointExchange(pointExchangeVO);
        long sumPointExchangeHb=  pointService.sumPointExchange(pointExchangeVO);

        /**
         * 积分兑换礼物次数和消耗积分
         */
        pointExchangeVO.setExchangeMethod(DaoConstant.PointExchangeMethod.GOODS);
        long countPointExchangeLw= pointService.countPointExchange(pointExchangeVO);
        long sumPointExchangeLw=  pointService.sumPointExchange(pointExchangeVO);

        String  jsonStr="{\"success\": true,\"code\": 200,\"msg\": \"操作成功\",\"obj\": {\"id\": 6134802,\"name\": \"\\u6211\\u7684\\u6210\\u957f\",\"createUser\": \"7\",\"type\": 101,\"pageMode\": 0,\"image\": {\"imgSrc\": \"pic/7/201507/55a3b62bcf9a3.gif\",\n" +
                "    \"lastPageId\":604961,\n" +
                "    \"hideEqAd\":1,\"isAdvancedUser\": 0,\"bgAudio\": {\"url\": \"syspic/mp3/f0699718e828312227f091162f447885.mp3\",\"type\": \"3\"}\n" +
                "},\n" +
                "    \"isTpl\": 0,\n" +
                "    \"isPromotion\": 0,\n" +
                "    \"status\": 1,\n" +
                "    \"openLimit\": 0,\n" +
                "    \"startDate\": null,\n" +
                "    \"endDate\": null,\n" +
                "    \"updateTime\": 1426045746000,\n" +
                "    \"createTime\": 1426572693000,\n" +
                "    \"publishTime\":1426572693000,\n" +
                "    \"applyTemplate\": 0,\n" +
                "    \"applyPromotion\": 0,\n" +
                "    \"sourceId\": null,\n" +
                "    \"code\": \"U6052058SE89\",\n" +
                "    \"description\": \"\\u6211\\u7684\\u6210\\u957f\\uff0c\\u6211\\u505a\\u4e3b!\",\n" +
                "    \"sort\": 0,\n" +
                "    \"pageCount\": 0,\n" +
                "    \"dataCount\": 0,\n" +
                "    \"showCount\": 69,\n" +
                "    \"eqcode\" :\"\",\n" +
                "    \"userLoginName\": null,\n" +
                "    \"userName\": null\n" +
                "},\n" +
                "    \"map\": null,\n" +
                "    \"list\": [{\"id\": 5238,\"sceneId\": 6134802,\"num\": 1,\n" +

                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":806,\"pageId\":\"5238\",\"sceneId\":\"6134802\",\"type\":\"4\",\"css\":{\"height\":30,\"zIndex\":\"1\",\"width\":290,\"left\":18,\"top\":218,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"lineHeight\":1,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\"},\"properties\":{\"anim\":{\"type\":1,\"direction\":0,\"duration\":\"0.4\",\"delay\":\"0.8\"},\"height\":30,\"imgStyle\":{\"width\":290,\"height\":75,\"marginTop\":\"-22.5px\",\"marginLeft\":\"0px\"},\"width\":290,\"src\":\"syspic\\/pageimg\\/c7b7cfbd885e3749687130be3b80add3.png\"}},{\"content\":\"<div style=\\\"text-align: center;\\\"><span style=\\\"line-height: inherit; background-color: initial;\\\"><font color=\\\"#ffffff\\\">\\u5f00\\u542f<\\/font><font color=\\\"#ff5400\\\">\\u6211\\u7684\\u6210\\u957f<\\/font><font color=\\\"#ffffff\\\">\\u8f68\\u8ff9<\\/font><\\/span><\\/div>\",\"css\":{\"top\":173,\"left\":0,\"zIndex\":\"2\",\"lineHeight\":\"1.0\",\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\",\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0},\"id\":130,\"num\":1,\"pageId\":\"5238\",\"properties\":[],\"sceneId\":\"6134802\",\"title\":null,\"type\":2},{\"id\":617,\"pageId\":\"5238\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"3\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<font size=\\\"4\\\" color=\\\"#ffffff\\\">\\u4e00\\u5e74\\u5185\\u6211\\u5728<\\/font><font color=\\\"#ff5400\\\" size=\\\"5\\\">"+sellerConfigName+"<\\/font><font size=\\\"4\\\" color=\\\"#ffffff\\\">\\u54c1\\u724c<\\/font><div><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp;\\u6dd8\\u5b9d\\u3001\\u5929\\u732b\\u6210\\u4ea4<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countOrderTaoBao+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u8ba2\\u5355\\uff0c\\u597d\\u8bc4\\u6570\\u8fbe\\u5230<\\/font><font color=\\\"#f4711f\\\"><font size=\\\"5\\\">"+countCommentTaoBao+"<\\/font><font size=\\\"4\\\" style=\\\"line-height: 23.3999996185303px;\\\">&nbsp;<\\/font><\\/font><\\/div><div><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp;\\u4eac\\u4e1c\\u6210\\u4ea4<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countOrderJD+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u8ba2\\u5355\\uff0c\\u597d\\u8bc4\\u6570\\u8fbe\\u5230<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countCommentJD+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp;&nbsp;<\\/font><\\/div><div><font size=\\\"5\\\" color=\\\"#ffffff\\\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<\\/font><\\/div><div><font size=\\\"5\\\" color=\\\"#ffffff\\\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\\u5241\\u624b\\u4e4b\\u8def~~<\\/font><\\/div>\",\"css\":{\"top\":252,\"left\":0,\"zIndex\":\"4\",\"lineHeight\":\"1.3\",\"width\":320,\"height\":196,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\",\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0},\"id\":215,\"num\":1,\"pageId\":\"5238\",\"properties\":{\"width\":320,\"height\":196,\"anim\":[{\"type\":1,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2},{\"content\":\"\",\"css\":{\"top\":25,\"left\":77,\"zIndex\":\"5\",\"width\":170,\"height\":132,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"lineHeight\":1,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\",\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0},\"id\":664,\"num\":1,\"pageId\":\"5238\",\"properties\":{\"width\":170,\"height\":132,\"src\":\"pic\\/7\\/201507\\/55a35ab5b29ec.gif\",\"imgStyle\":{\"width\":173,\"height\":132,\"marginTop\":\"0px\",\"marginLeft\":\"-1.5px\"}},\"sceneId\":\"6134802\",\"title\":null,\"type\":4}],\"scene\": null},{\"id\": 5239,\"sceneId\": 6134802,\"num\": 2,\n" +
                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":794,\"pageId\":\"5239\",\"sceneId\":\"6134802\",\"type\":\"4\",\"css\":{\"borderRadius\":\"0px\",\"borderStyle\":\"solid\",\"zIndex\":\"1\",\"borderColor\":\"rgba(255,255,255,1)\",\"paddingTop\":\"0px\",\"height\":138,\"backgroundColor\":\"\",\"color\":\"\",\"boxShadow\":\"0px 2px 3px rgba(0,0,0,0.3)\",\"borderWidth\":\"4px\",\"width\":157,\"left\":79,\"paddingBottom\":\"0px\",\"top\":45},\"properties\":{\"anim\":[{\"type\":1,\"direction\":1,\"duration\":1,\"delay\":0.6,\"countNum\":1}],\"height\":138,\"imgStyle\":{\"width\":149,\"height\":149,\"marginTop\":\"-9.5px\",\"marginLeft\":\"0px\"},\"width\":157,\"src\":\"pic\\/7\\/201507\\/55a33f417557b.png\"}},{\"id\":360,\"pageId\":\"5239\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"2\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<font size=\\\"5\\\"><font color=\\\"#333333\\\">&nbsp; &nbsp;<\\/font><font color=\\\"#ffffff\\\">\\u5728\\u4e00\\u5e74\\u65f6\\u95f4\\u5185\\u6211\\u7d2f\\u8ba1\\u4e92\\u52a8<\\/font><font color=\\\"#f4711f\\\">"+countUserInteractionDetail+"<\\/font><\\/font><font size=\\\"5\\\" color=\\\"#ffffff\\\">\\u6b21 \\u611f\\u89c9\\u81ea\\u5df1\\u68d2\\u68d2\\u54d2!<\\/font>\",\"css\":{\"top\":238,\"left\":0,\"zIndex\":\"3\",\"lineHeight\":\"1.8\",\"width\":320,\"height\":112,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\"},\"id\":770,\"num\":1,\"pageId\":\"5239\",\"properties\":{\"width\":320,\"height\":112,\"anim\":[{\"type\":5,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2}],\"scene\": null},{\"id\": 5637,\"sceneId\": 6134802,\"num\": 2,\n" +
                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":617,\"pageId\":\"5637\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"1\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<div style=\\\"text-align: center;\\\"><font color=\\\"#ffffff\\\" style=\\\"font-size: large;\\\">\\u5728\\u8fd1\\u4e00\\u5e74\\u5185\\u6211\\u5171\\u9886\\u53d6<\\/font><font color=\\\"#f4711f\\\" size=\\\"5\\\">"+countHongbaoObtain+"<\\/font><font style=\\\"font-size: large; color: rgb(255, 255, 255);\\\">\\u4e2a\\u7ea2\\u5305\\n<\\/font><\\/div><div><font size=\\\"4\\\" color=\\\"#ffffff\\\">\\n<\\/font><\\/div><div><font style=\\\"font-size: large; color: rgb(255, 255, 255);\\\">&nbsp; &nbsp; &nbsp; &nbsp; \\u7ea2\\u5305\\u4f59\\u989d\\u8fd8\\u5269<\\/font><font color=\\\"#f7951e\\\" size=\\\"5\\\">"+hbAmount+"<\\/font><font style=\\\"font-size: large; color: rgb(255, 255, 255);\\\">\\u5143\\n<\\/font><\\/div><div><font style=\\\"font-size: large; color: rgb(255, 255, 255);\\\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<\\/font><font style=\\\"font-size: large; color: rgb(255, 255, 255); background-color: initial;\\\">\\u7ea2\\u5305\\u63d0\\u73b0<\\/font><font style=\\\"line-height: inherit; background-color: initial;\\\" color=\\\"#f4711f\\\" size=\\\"5\\\">"+countHongbaoCash+"<\\/font><font style=\\\"font-size: large; color: rgb(255, 255, 255); background-color: initial;\\\">\\u6b21<\\/font><font style=\\\"color: rgb(255, 255, 255); font-size: x-large; background-color: initial;\\\"> <\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255); background-color: initial;\\\">&nbsp; <b>&nbsp;<\\/b><\\/font><\\/div>\",\"css\":{\"top\":224,\"left\":0,\"zIndex\":\"2\",\"lineHeight\":\"2.0\",\"width\":320,\"height\":180},\"id\":215,\"num\":1,\"pageId\":\"5637\",\"properties\":{\"width\":320,\"height\":180,\"anim\":[{\"type\":8,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2},{\"content\":\"\",\"css\":{\"top\":38,\"left\":80,\"zIndex\":\"3\",\"width\":159,\"height\":125},\"id\":664,\"num\":1,\"pageId\":\"5637\",\"properties\":{\"width\":159,\"height\":125,\"src\":\"pic\\/7\\/201507\\/55a36c63abc0a.gif\",\"imgStyle\":{\"width\":159,\"height\":152,\"marginTop\":\"-13px\",\"marginLeft\":\"0px\"}},\"sceneId\":\"6134802\",\"title\":null,\"type\":4}],\"scene\": null},{\"id\": 5638,\"sceneId\": 6134802,\"num\": 3,\n" +
                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":794,\"pageId\":\"5638\",\"sceneId\":\"6134802\",\"type\":\"4\",\"css\":{\"borderRadius\":\"0px\",\"borderStyle\":\"solid\",\"zIndex\":\"1\",\"borderColor\":\"rgba(255,255,255,1)\",\"paddingTop\":\"0px\",\"height\":127,\"backgroundColor\":\"\",\"color\":\"\",\"boxShadow\":\"0px 2px 3px rgba(0,0,0,0.3)\",\"borderWidth\":\"4px\",\"width\":176,\"left\":71,\"paddingBottom\":\"0px\",\"top\":61},\"properties\":{\"anim\":[{\"type\":1,\"direction\":1,\"duration\":1,\"delay\":0.6,\"countNum\":1}],\"height\":127,\"imgStyle\":{\"width\":199,\"height\":119,\"marginTop\":\"0px\",\"marginLeft\":\"0px\"},\"width\":176,\"src\":\"pic\\/7\\/201507\\/55a36c779591d.gif\"}},{\"id\":360,\"pageId\":\"5638\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"2\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u5728\\u8fd1\\u4e00\\u5e74\\u5185\\u6211\\u5171\\u9886\\u53d6<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+sumPointObtain+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u4e2a\\u79ef\\u5206\\n<\\/font><div><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp; &nbsp;当前积分在小伙伴中排名<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+pointRank+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u4f4d<\\/font><\\/div><div><font size=\\\"5\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp; &nbsp;<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u7d2f\\u8ba1\\u7b7e\\u5230\\u6b21\\u6570<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countPointObtainQd+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u6b21 &nbsp;<\\/font><\\/div>\",\"css\":{\"top\":240,\"left\":0,\"zIndex\":\"3\",\"lineHeight\":\"1.8\",\"width\":320,\"height\":165,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\"},\"id\":770,\"num\":1,\"pageId\":\"5638\",\"properties\":{\"width\":320,\"height\":165,\"anim\":[{\"type\":9,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2}],\"scene\": null},{\"id\": 5639,\"sceneId\": 6134802,\"num\": 4,\n" +
                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":794,\"pageId\":\"5639\",\"sceneId\":\"6134802\",\"type\":\"4\",\"css\":{\"borderRadius\":\"0px\",\"borderStyle\":\"solid\",\"zIndex\":\"1\",\"borderColor\":\"rgba(255,255,255,1)\",\"paddingTop\":0,\"height\":165,\"backgroundColor\":\"\",\"color\":\"#676767\",\"boxShadow\":\"0px 0px 3px rgba(0,0,0,0.3)\",\"borderWidth\":0,\"width\":167,\"left\":84,\"paddingBottom\":0,\"top\":33,\"opacity\":1,\"lineHeight\":1,\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\",\"boxShadowDirection\":0,\"boxShadowSize\":0},\"properties\":{\"anim\":[{\"type\":1,\"direction\":3,\"duration\":1,\"delay\":0.6,\"countNum\":1}],\"height\":165,\"imgStyle\":{\"width\":167,\"height\":167,\"marginTop\":\"-1px\",\"marginLeft\":\"0px\"},\"width\":167,\"src\":\"syspic\\/img\\/1319e7150709f1ac16fc3de1f6245857.png\"}},{\"id\":360,\"pageId\":\"5639\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"2\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<div><font color=\\\"#333333\\\" size=\\\"4\\\"><br><\\/font><\\/div><div><font color=\\\"#333333\\\" size=\\\"4\\\"><br><\\/font><\\/div><div><font color=\\\"#333333\\\" size=\\\"4\\\">&nbsp; &nbsp; &nbsp;<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\"> &nbsp;\\u5728\\u4e00\\u5e74\\u5185\\u79ef\\u5206\\u5151\\u6362\\u793c\\u7269<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countPointExchangeLw+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u6b21\\uff0c\\u7d2f\\u8ba1\\u6d88\\u8017\\u79ef\\u5206<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+sumPointExchangeLw+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u5206<\\/font><\\/div><div><font size=\\\"4\\\" color=\\\"#ffffff\\\"><\\/font><\\/div><div><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">&nbsp; &nbsp; &nbsp;\\u79ef\\u5206\\u5151\\u6362\\u7ea2\\u5305<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+countPointExchangeHb+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u6b21\\uff0c\\u7d2f\\u8ba1\\u6d88\\u8017\\u79ef\\u5206<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+sumPointExchangeHb+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u5206<\\/font>   <\\/div><div><font size=\\\"4\\\" color=\\\"#ffffff\\\">&nbsp; &nbsp; &nbsp; &nbsp;<\\/font><\\/div><div><font size=\\\"4\\\" color=\\\"#ffffff\\\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\\u592a\\u5389\\u5bb3\\u5566!<\\/font><\\/div><div><font color=\\\"#333333\\\" size=\\\"4\\\">&nbsp;&nbsp;<\\/font><\\/div>\",\"css\":{\"top\":204,\"left\":0,\"zIndex\":\"3\",\"lineHeight\":\"1.0\",\"width\":320,\"height\":282,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\"},\"id\":770,\"num\":1,\"pageId\":\"5639\",\"properties\":{\"width\":320,\"height\":282,\"anim\":[{\"type\":6,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2}],\"scene\": null},{\"id\": 5641,\"sceneId\": 6134802,\"num\": 5,\n" +
                "        \"name\": null,\"properties\":null,\"elements\": [{\"id\":794,\"pageId\":\"5641\",\"sceneId\":\"6134802\",\"type\":\"4\",\"css\":{\"borderRadius\":\"0px\",\"borderStyle\":\"solid\",\"zIndex\":\"1\",\"borderColor\":\"rgba(255,255,255,1)\",\"paddingTop\":\"0px\",\"height\":127,\"backgroundColor\":\"\",\"color\":\"\",\"boxShadow\":\"0px 2px 3px rgba(0,0,0,0.3)\",\"borderWidth\":\"4px\",\"width\":176,\"left\":71,\"paddingBottom\":\"0px\",\"top\":61},\"properties\":{\"anim\":[],\"height\":127,\"imgStyle\":{\"width\":176,\"height\":136,\"marginTop\":\"-4.5px\",\"marginLeft\":\"0px\"},\"width\":176,\"src\":\"pic\\/7\\/201507\\/55a33f4a05a53.gif\"}},{\"id\":360,\"pageId\":\"5641\",\"sceneId\":\"6134802\",\"type\":\"3\",\"css\":{\"zIndex\":\"2\"},\"properties\":{\"bgColor\":null,\"imgSrc\":\"pic\\/7\\/201507\\/55a398c39b365.jpg\"}},{\"content\":\"<div><font color=\\\"#333333\\\" size=\\\"4\\\">&nbsp; <\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u611f\\u8c22\\u4e0e<\\/font><font size=\\\"5\\\" color=\\\"#f4711f\\\">"+sellerConfigName+"<\\/font><font size=\\\"4\\\" style=\\\"color: rgb(255, 255, 255);\\\">\\u4e00\\u8d77\\u8d70\\u8fc7\\u7684\\u65e5\\u5b50\\uff0c<\\/font><font size=\\\"4\\\" color=\\\"#ffffff\\\">\\u4e0d\\u613f\\u79bb\\u5f00\\u4f60! &nbsp;<\\/font><\\/div>\",\"css\":{\"top\":240,\"left\":0,\"zIndex\":\"3\",\"lineHeight\":\"1.8\",\"width\":320,\"height\":99,\"backgroundColor\":\"\",\"opacity\":1,\"color\":\"#676767\",\"borderWidth\":0,\"borderStyle\":\"solid\",\"borderColor\":\"rgba(0,0,0,1)\",\"paddingBottom\":0,\"paddingTop\":0,\"borderRadius\":\"0px\",\"transform\":\"rotateZ(0deg)\",\"borderRadiusPerc\":0,\"boxShadow\":\"0px 0px 0px rgba(0,0,0,0.5)\",\"boxShadowDirection\":0,\"boxShadowSize\":0,\"borderBottomRightRadius\":\"0px\",\"borderBottomLeftRadius\":\"0px\",\"borderTopRightRadius\":\"0px\",\"borderTopLeftRadius\":\"0px\"},\"id\":770,\"num\":1,\"pageId\":\"5641\",\"properties\":{\"width\":320,\"height\":99,\"anim\":[{\"type\":3,\"direction\":0,\"duration\":2,\"delay\":0,\"countNum\":1,\"count\":null}]},\"sceneId\":\"6134802\",\"title\":null,\"type\":2},{\"content\":\"\",\"css\":{\"left\":103,\"top\":348,\"zIndex\":\"4\",\"width\":96,\"height\":98},\"id\":263,\"num\":1,\"pageId\":\"5641\",\"properties\":{\"width\":96,\"height\":98,\"src\":'"+ wxQrcode+"',\"imgStyle\":{\"width\":98,\"height\":98,\"marginTop\":\"0px\",\"marginLeft\":\"-1px\"}},\"sceneId\":\"6134802\",\"title\":null,\"type\":4}],\"scene\": null}]}";

        Object obj=   JSONUtils.parseToObject(jsonStr,Object.class);

        return  obj;
    }


}
