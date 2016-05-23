package com.shufensoft.crm.biz.service.wx;

import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.biz.service.wx.vo.WXUserInfoVO;
import com.shufensoft.crm.biz.service.wx.vo.WXUserListVO;
import com.shufensoft.crm.biz.service.wx.vo.WxUserOuathVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.WxJsSign;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 微信相关接口服务
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/4/12 21:01  
 *
 * @modifier litu  litu@shufensoft.com 2015/5/22 14:05
 */
@Service(value = "wXService")
public class WXService {

    @Autowired
    private UserService userService;

    private static WXAdapter wxAdapter = new WXAdapter();

    private static final Logger logger = Logger.getLogger(WXService.class);


    /**
     * 获取accessToken
     *
     * @param sellerId
     * @return
     * @modifier litu  litu@shufensoft.com 2015/5/22 14:05
     */
    public String getAccessToken(Long sellerId) {


        String accessToken = wxAdapter.getAccessToken(sellerId);

        return accessToken;
    }




    /**
     * 根据openId查询用户信息
     *
     * @param openId 用户公众号中的唯一ID
     * @return 用户信息
     */
    public UserVO findUserByOpenIdFromWx(Long sellerId,String openId) {

        try {

            WXUserInfoVO userInfoVO = wxAdapter.getUserInfo(sellerId, openId);
            return wxUserToCrmUser(userInfoVO,sellerId);

        } catch (Exception e) {
            logger.error("WXService.findUserByOpenIdFromWx error", e);
            throw new ServiceException("WXService.findUserByOpenIdFromWx", e);
        }

    }

    /**
     * 根据用户授权返回的信息获取用户的详细信息
     *
     * @param openId
     * @param accessToken
     * @return 微信用户信息
     * @author zoujian  zoujian@suniusoft.com 2015/7/14 14:05
     */
    public UserVO getOuathUserInfo(String openId, String accessToken, Long sellerId) {

        WXUserInfoVO wxUserInfoVO = null;

        try {
            wxUserInfoVO = WXAdapter.getOuathUserInfo(openId, accessToken);
        } catch (Exception e) {
            logger.error("WXService.getOuathUserInfo error", e);
        }

        return wxUserToCrmUser(wxUserInfoVO,sellerId);

    }


    /**
     * 根据授权码获取opendId
     *
     * @param code 授权码
     * @return openid
     */
    public WxUserOuathVO getWxUserOuath(String sellerId , String code) {

        SellerConfigInfo  sellerConfigInfo = SellerConfigCache.get(sellerId);

        WxUserOuathVO wxUserOuathVO = WXAdapter.ouath(sellerConfigInfo.getWxAppId() , sellerConfigInfo.getWxAppSecret() , code);

        return wxUserOuathVO;
    }

    /**
     * 微信用户对象转成内部用户对象
     *
     * @param userInfoVO
     * @return
     */
    public UserVO wxUserToCrmUser(WXUserInfoVO userInfoVO,Long sellerId) {

        UserVO user;
        try {
            /**
             * 相同字段名copy
             */
            user = (UserVO) BeanCopierUtils.copyProperties(userInfoVO, UserVO.class);

        } catch (Exception e) {
            logger.error("userInfoVO bean copy to user error", e);
            throw new ServiceException("WXService.wxUserToCrmUser",
                    "userInfoVO bean copy to user error", e);
        }

        /**
         * 不同字段名copy
         */
        user.setWxSubscribeTime(new Date(Long.valueOf(userInfoVO.getSubscribe_time())*1000l));
        user.setWxSubscribe(userInfoVO.getSubscribe());
        user.setWxHeadimgurl(userInfoVO.getHeadimgurl());
        user.setWxOpenid(userInfoVO.getOpenid());
        user.setWxNickName(userInfoVO.getNickname());
        user.setSellerId(sellerId);
        return user;
    }

    public String pullWXUserInfo(Long sellerId, String nextOpenId) {

        AssertsUtil.notNull(sellerId, "sellerId");

        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", getAccessToken(sellerId));
        if (StringUtils.isNotBlank(nextOpenId)) {
            params.put("next_openid", nextOpenId);
        }

        WXUserListVO wxUser = WXAdapter.getUserOpenIdList(params);

        List<String> userList = wxUser.getUserOpenIdList();
        if(CollectionUtils.isEmpty(userList)){
            return null ;
        }
        for (String openId : userList) {
            UserVO userVO = findUserByOpenIdFromWx(sellerId,openId);
            userVO.setSellerId(sellerId);
            userVO.setFirstSource("WX");
            userVO.setWxSubscribe(DaoConstant.WxSubscribe.YES);
            UserPortraitVO userPortraitVO = new UserPortraitVO();
            userPortraitVO.setUserPortraitId(userVO.getUserPortraitId());
            userPortraitVO.setSellerId(sellerId);
            userVO.setUserPortraitVO(userPortraitVO);
            userService.insertOrUpdateUserAndPortrait(userVO);
        }

        return wxUser.getNext_openid();

    }


    /**
     * 获取微信JS调用配置
     *
     * @param sellerId 商户ID
     * @param url
     * @return JS_API所需要的调用参数
     */
    public Map<String, String>
    getWxJsConfigIn(Long sellerId, String url) {

        String ticket = WXAdapter.getTicket(sellerId);

        if (StringUtils.isBlank(ticket)) {
            return null;
        }

        Map<String, String> wxJsConfig = WxJsSign.sign(ticket, url);
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));
        wxJsConfig.put("appId", sellerConfigInfo.getWxAppId());


        return wxJsConfig;
    }


}
