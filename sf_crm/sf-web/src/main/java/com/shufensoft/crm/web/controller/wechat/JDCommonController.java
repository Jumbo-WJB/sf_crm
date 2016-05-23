package com.shufensoft.crm.web.controller.wechat;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lin on 2015/6/15.
 */
@Controller
public class JDCommonController extends BaseController{

    private static JdTradeService jdTradeService;
    private static Logger log = Logger.getLogger(JDCommonController.class);

    public final static String JD_OAUTH_URL_KEY = "jd.oauth.url";

    public static String jdOauthUrl = PropertyReader.getValue(JD_OAUTH_URL_KEY);

    public final static String JD_REDIRECT_URI_KEY = "jd.redirect.uri";

    public static String jdRedirectUri = PropertyReader.getValue(JD_REDIRECT_URI_KEY);

    static{
        jdTradeService = (JdTradeService)SpringContextUtil.getBean("jdTradeService");
    }

    /**
     * 导入京东订单数据入口地址
    0 * */
    @RequestMapping("/jd/toImport")
    @ResponseBody
    public ModelAndView jdOrderUpload(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/jd/upload");
        return mav;
    }

    /**
     *
     * */
    @RequestMapping("/oauth/getAccessToken")
     public String jdToken(Long shopId, HttpSession session){

        try {

            Long sellerId = getSellerId(session);

            AssertsUtil.notNull(sellerId, "sellerId");
            AssertsUtil.notNull(shopId, "shopId");

            SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId),String.valueOf(shopId));
            AssertsUtil.notNull(sellerShop, "sellerShop");
            AssertsUtil.check(!DaoConstant.ShopType.JD.equals(sellerShop), "店铺类型不对，不是京东店铺!");

            Date expire = sellerShop.getShopTokenExpire();

            if(StringUtils.isNotBlank(sellerShop.getShopAccessToken()) && expire!=null && expire.after(new Date())){
                return "已授权";
            }

            String clientId = sellerShop.getShopAppId();
            AssertsUtil.notBothSidesBlank(clientId, "clientId");

            AssertsUtil.notBothSidesBlank(jdOauthUrl, "jdOauthUrl");

            AssertsUtil.notBothSidesBlank(jdRedirectUri, "jdRedirectUri");

            return "redirect:" + jdOauthUrl + "/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + jdRedirectUri
                    + "&state=" + sellerId;

        } catch (Exception e) {

            String message = e.getMessage() == null ? "null point exception" : e.getMessage();
            log.error("jd oauth oauthTbShow error,errorMsg:" + message);
            return "jd oauth getAccessToken error,errorMsg:" + message;

        }
    }

}
