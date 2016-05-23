package com.shufensoft.crm.web.controller.mobile.identify;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.contactCustomer.MarketActivityService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.UserValidateService;
import com.shufensoft.crm.biz.vo.MarketActivityVO;
import com.shufensoft.crm.biz.vo.UserValidateVO;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/7/23  
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileIdentifyController extends BaseController{

    @Autowired
    private SendService sendService;

    @Autowired
    private UserValidateService userValidateService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarketActivityService marketActivityService;

    /**返回手机端客户验证页面*/
    @RequestMapping(value = "/identify")
    public ModelAndView goValidatePage(Long userId,String redirectUrl, ModelMap modelMap, String sellerId){

        /**
         * 根据userId查询用户信息
         */
        User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId),userId);

        if (user !=null){
            modelMap.put("wxHeadImgUrl",user.getWxHeadimgurl());
            modelMap.put("wxNickName",user.getWxNickName());
            modelMap.put("tbBuyerNick",user.getTbBuyerNick());
            modelMap.put("jdPin",user.getJdPin());
            /**
             * 判断该用户是否已经验证
             */
            if (user.getIsVerify() != null && user.getIsVerify().equals("1")){
                modelMap.put("isVerified",user.getIsVerify());
                modelMap.put("isMobile",user.getMobile());
                Date myBirth = user.getBirthday();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (myBirth != null){
                    modelMap.put("birthDay",format.format(myBirth));
                }
            }
        }

        modelMap.put("userId",userId);
        modelMap.put("redirectUrl",redirectUrl);
        return new ModelAndView("/mobile/identify/identify",modelMap);
    }

    /**
     * 手机端客户验证
     * @param userValidateVO 客户传入参数的封装
     * @return
     */
    @RequestMapping (value = "/validateUser")
    public @ResponseBody
    Map<String, Object> ouathWX(@Valid UserValidateVO userValidateVO,String sellerId){
        Map<String, Object> result = Maps.newHashMap();
        userValidateVO.setSellerId(sellerId);
        /**
         * 该用户已经验证，此时场景为用户添加生日
         */
        if ("1".equals(userValidateVO.getIsVerified())){
            User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), userValidateVO.getUserId());
            if (user.getBirthday() != null && userValidateVO.getBirthday() != null){
                if (StringUtils.isBlank(userValidateVO.getJdPin()) && StringUtils.isBlank(userValidateVO.getTbBuyerNick())
                        && StringUtils.isBlank(userValidateVO.getYzBuyerNick())){
                    result.put("errCode","-1");
                    result.put("errMsg","请填写其他认证信息！");
                    return result;
                }
            }
        }

        /**
         * 用户信息验证,并通过同人模型整合数据
         */
        try {
            result = userValidateService.userValidate(sellerId,userValidateVO);
        }catch (Exception e){
            result.put("errCode","0");
            result.put("errMsg","亲，系统出了点小异常，请重新尝试！");
            return result;
        }

        try {
            if (userValidateVO.getRedirectUrl() != null){
                result.put("redirectUrl", URLDecoder.decode(userValidateVO.getRedirectUrl(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            result.put("errCode","-1");
            result.put("errMsg","亲，系统有点小问题，请于商家联系哦，谢谢！");
        }

        return result;
    }

    /**
     * 发送手机验证码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getSecurityCode")
    public @ResponseBody Map<String, Object> getSecurityCode(String mobile,Long userId,String sellerId){
        Map<String, Object> map = Maps.newHashMap();

        if (StringUtils.isBlank(mobile)){
            map.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"手机号码为空");
            return map;
        }
        if (userId == null){
            map.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"用户userId为空");
            return map;
        }

        /**
         * 产生验证码，短信发送到用户的手机上，并保存到数据库
         */
        int code = CommonUtil.getRandomCode(100000, 999999);
        String securityCode = String.valueOf(code);
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
        String smsSendResult = sendService.sendSmsVerifyCode(String.valueOf(sellerConfigInfo.getSellerId()),mobile,"尊敬的客户，您的验证码为："+securityCode+",请尽快输入。");

        UserValidateVO userValidateVO = new UserValidateVO();
        userValidateVO.setSellerId(sellerId);
        userValidateVO.setUserId(userId);
        userValidateVO.setCode(securityCode);
        userValidateVO.setMobile(mobile);
        userValidateVO.setStatus("0");

        /**
         * 发送成功后将记录保存到验证记录表
         */
        if ("0".equals(smsSendResult)){
            userValidateService.insertOrUpdate(userValidateVO);
            map.put("securityCode",code);
            map.put("codeSend","0");
        }else {
            map.put("codeSend","-1");
        }

        return map;
    }
}
