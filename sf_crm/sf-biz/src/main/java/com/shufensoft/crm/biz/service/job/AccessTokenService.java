package com.shufensoft.crm.biz.service.job;

import com.alibaba.fastjson.JSONObject;
import com.shufensoft.crm.biz.adapter.JDAdapter;
import com.shufensoft.crm.biz.adapter.WXAdapter;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.job.inter.IAccessTokenService;
import com.shufensoft.crm.biz.service.oauth.TaoBaoOauthService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.common.api.enums.ApiErrorEnums;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/22  
 */
@Service(value="accessTokenService")
public class AccessTokenService implements IAccessTokenService {

    @Autowired
    private SendService sendService;

    @Autowired
    private TaoBaoOauthService taoBaoOauthService;

    private static Logger logger = Logger.getLogger(AccessTokenService.class);


    /**
     * 微信accessToken刷新
     * */
    public void wxAccessTokenRefresh(List<SellerConfigInfo> sellerConfigInfos){
        if(!CollectionUtils.isEmpty(sellerConfigInfos)){
            return;
        }
        for(SellerConfigInfo sellerConfigInfo : sellerConfigInfos){
            Date expiresDate = sellerConfigInfo.getWxTokenExpire();
            if(expiresDate != null){
                //加10分钟之后的时间
                Date offDate = DateUtil.operateDate(expiresDate,0,0,0,0,10,0);
                if(offDate.after(new Date())){
                    WXAdapter.getAccessToken(sellerConfigInfo.getSellerId());       //重置accessToken
                }
            }
        }
    }

    /**
     * 京东accessToken刷新
     * */
    @Override
     public void jdAccessTokenRefresh(List<SellerConfigInfo> sellerConfigInfos){
        if(!CollectionUtils.isEmpty(sellerConfigInfos)){
            return;
        }
        for(SellerConfigInfo sellerConfigInfo : sellerConfigInfos){
//            //Date expiresDate = sellerConfigInfo.getJdTokenExpire();
//            if(expiresDate != null){
//                //加30天之后的时间
//                Date offDate = DateUtil.operateDate(expiresDate,0,0,30,0,0,0);
//                if(offDate.after(new Date())){
//                    AccessTokenVo accessTokenVo = JDAdapter.freshJDAccessToken(sellerConfigInfo.getSellerId());       //重置accessToken
//                    if(accessTokenVo == null){
//                        logger.error("sellerId:" + sellerConfigInfo.getSellerId() + " refresh token fail");
//                    }
//                }
//            }
        }
    }

    /**
     * 淘宝accessToken过期提醒
     *淘宝后台商家系统的token固定时长为1年, 不能刷新, 因此这里判断token快过期的时候发短信通知商家
     * @param sellerConfigInfos
     */
    @Override
    public void tbAccessTokenExpiresWarn(List<SellerConfigInfo> sellerConfigInfos) {
        if(!CollectionUtils.isEmpty(sellerConfigInfos)){
            return;
        }
//        for(SellerConfigInfo sellerConfigInfo : sellerConfigInfos){
//            Date expiresDate = sellerConfigInfo.getTbTokenExpire();
//            if(expiresDate != null){
//                //加30天之后的时间
//                Date offDate = DateUtil.operateDate(expiresDate,0,0,30,0,0,0);
//                if(offDate.after(new Date())){
//                    SmsVO smsVO = new SmsVO();
//                    smsVO.setSendTime(new Date());
//
//                    List<String> list = new ArrayList<String>();
//                    list.add(sellerConfigInfo.getMobile());
//                    smsVO.setSellerId(String.valueOf(sellerConfigInfo.getSellerId()));
//                    smsVO.setSaleType("淘宝accessToken过期提醒");
//                    smsVO.setContent("亲,您的淘宝授权快过期了哦, 为不影响我们继续对您服务, 请重新授权一下哦, 有问题可以联系我们的客服人员, 谢谢");
//                    smsVO.setSmsPriority("5");
//                    smsVO.setSendType("SMS");
//                    smsVO.setSign("速牛科技");
//                    smsVO.setSaleTitle("淘宝accessToken过期提醒");
//                    smsVO.setTargetNumberList(list);
//                    sendService.smsSend(smsVO);
//                }
//            }
//        }
    }

    /**
     * refreshToken ALL
     *
     * @param sellerConfigInfos
     */
    @Override
    public void refreshToken(List<SellerConfigInfo> sellerConfigInfos) {
        if(!CollectionUtils.isEmpty(sellerConfigInfos)){
            return;
        }
//        for(SellerConfigInfo sellerConfigInfo : sellerConfigInfos){
//            Date tbExpiresDate = sellerConfigInfo.getTbTokenExpire();
//            Date jdExpiresDate = sellerConfigInfo.getJdTokenExpire();
//            Date wxExpiresDate = sellerConfigInfo.getWxTokenExpire();
//            if(tbExpiresDate != null){
//                //减30天之后的时间
//                Date offDate = DateUtil.operateDate(tbExpiresDate,0,0,-30,0,0,0);
//                if(offDate.before(new Date())){
//                    SmsVO smsVO = new SmsVO();
//                    smsVO.setSendTime(new Date());
//
//                    List<String> list = new ArrayList<String>();
//                    list.add(sellerConfigInfo.getMobile());
//                    smsVO.setSellerId(String.valueOf(sellerConfigInfo.getSellerId()));
//                    smsVO.setSaleType("淘宝accessToken过期提醒");
//                    smsVO.setContent("亲,您的淘宝授权快过期了哦, 为不影响我们继续对您服务, 请重新授权一下哦, 有问题可以联系我们的客服人员, 谢谢");
//                    smsVO.setSmsPriority("5");
//                    smsVO.setSendType("SMS");
//                    smsVO.setSign("速牛科技");
//                    smsVO.setSaleTitle("淘宝accessToken过期提醒");
//                    smsVO.setTargetNumberList(list);
//                    sendService.smsSend(smsVO);
//                }
//            }
//            if(jdExpiresDate != null){
//                //减30天之后的时间
//                Date offDate = DateUtil.operateDate(jdExpiresDate,0,0,-30,0,0,0);
//                if(offDate.before(new Date())){
//                    AccessTokenVo accessTokenVo = JDAdapter.freshJDAccessToken(sellerConfigInfo.getSellerId());       //重置accessToken
//                    if(accessTokenVo == null){
//                        logger.error("sellerId:" + sellerConfigInfo.getSellerId() + " refresh token fail");
//                    }
//                }
//            }
//            if(wxExpiresDate != null){
//                //减去10分钟之后的时间
//                Date offDate = DateUtil.operateDate(wxExpiresDate,0,0,0,0,-10,0);
//                if(offDate.before(new Date())){
//                    WXAdapter.getAccessToken(sellerConfigInfo.getSellerId());       //重置accessToken
//                }
//            }
//        }
    }

    @Override
    public void refreshTokenByShop(SellerConfigInfo sellerConfigInfo) {
        if (sellerConfigInfo == null) {
            return;
        }

        Date wxExpireDate = sellerConfigInfo.getWxTokenExpire();
        if(wxExpireDate != null){
            //减去10分钟之后的时间
            int offset = Integer.parseInt(PropertyReader.getValue("wx.expire.time.offset"));
            Date offDate = DateUtil.operateDate(wxExpireDate,0,0,0,0,-offset,0);
            if(offDate.before(new Date())){
                WXAdapter.getAccessToken(sellerConfigInfo);       //重置accessToken
            }
        }

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();
        if (CollectionUtils.isEmpty(sellerShops)) {
            return;
        }

        for (SellerShop sellerShop : sellerShops) {
            Date expiresDate = sellerShop.getShopTokenExpire();
            String shopType = sellerShop.getShopType();
            if (DaoConstant.ShopType.TB.equals(shopType) || DaoConstant.ShopType.TMALL.equals(shopType)) {     //淘宝天猫
                //减30天之后的时间
                int offset = Integer.parseInt(PropertyReader.getValue("tb.expire.time.offset"));
                Date offDate = DateUtil.operateDate(expiresDate, 0, 0, -offset, 0, 0, 0);
                if (offDate.before(new Date())) {
                    JSONObject json = taoBaoOauthService.refreshAccessToken(sellerShop);
                    String resultCode = json.getString("resultCode");
                    if(ApiErrorEnums.ERROR.getCode().equals(resultCode)){
                        JSONObject info = json.getJSONObject("resultInfo");
                        if(info != null){
                            String error = info.getString("error");
                            String errorDescription = info.getString("error_description");
                            if(StringUtils.isNotBlank(error) && StringUtils.isNotBlank(errorDescription)){
                                if("invalid_client".equals(error) && "refresh token expired".equals(errorDescription)){
                                    String content = "亲,您的天猫或淘宝授权已经过期， 为不影响我们继续对您服务, 请重新授权, 有问题可以联系我们的客服人员, 谢谢";
                                    sendService.sendSms(String.valueOf(sellerShop.getSellerId()),DaoConstant.SmsSaleType.SMS_TOKEN_REFRESH,
                                            DaoConstant.SmsSend.SEND_NOTIFY,sellerConfigInfo.getMobile(),content,DaoConstant.SmsFatigueFlag.IS_FATIGUE);
                                }
                            }
                        }

                    }

                }
            }
            // 从JD服务市场订购来的店铺不用refreshToken
            if(DaoConstant.ShopType.JD.equals(shopType) && !DaoConstant.AccessType.GENERAL.equals(sellerShop.getAccessType())){
                //减30天之后的时间
                int offset = Integer.parseInt(PropertyReader.getValue("jd.expire.time.offset"));
                Date offDate = DateUtil.operateDate(expiresDate,0,0,-offset,0,0,0);
                if(offDate.before(new Date())){
                    JSONObject json = JDAdapter.freshJDAccessToken(sellerShop);       //重置accessToken
                    if(json != null){
                        String returnCode = json.getString("code");
                        if(!"0".equals(returnCode)){
                            if("406".equals(returnCode)){  //refresh_token过期， 不在有效期内通过refresh_token重新获得授权会返回406
                                if(sellerConfigInfo.getMobile() != null){
                                    String content = "亲,您的京东授权已经过期， 为不影响我们继续对您服务, 请重新授权, 有问题可以联系我们的客服人员, 谢谢";
                                    sendService.sendSms(String.valueOf(sellerShop.getSellerId()),DaoConstant.SmsSaleType.SMS_TOKEN_REFRESH,
                                            DaoConstant.SmsSend.SEND_NOTIFY,sellerConfigInfo.getMobile(),content,DaoConstant.SmsFatigueFlag.IS_FATIGUE);
                                }
                            }
                            logger.error("sellerId:" + sellerConfigInfo.getSellerId() + " refresh token fail,errorCode: " + returnCode + "   error_description: " + json.getString("error_description"));
                        }
                    }else{
                        logger.error("sellerId:" + sellerConfigInfo.getSellerId() + " refresh token fail");

                    }
                }
            }

        }
    }



}
