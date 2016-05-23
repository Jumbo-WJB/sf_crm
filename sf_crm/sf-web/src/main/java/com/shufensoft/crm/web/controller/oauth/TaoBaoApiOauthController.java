package com.shufensoft.crm.web.controller.oauth;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.oauth.TaoBaoOauthService;
import com.shufensoft.crm.biz.service.oauth.vo.TaoBaoAccessTokenVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description:  淘宝openapi授权
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
@Controller
public class TaoBaoApiOauthController extends BaseController {


    private Logger log = Logger.getLogger(TaoBaoApiOauthController.class);

    @Autowired
    private TaoBaoOauthService taoBaoOauthService;


    public static String TAOBAO_OAUTH_URL_KEY = "taobao.oauth.url";

    public static String taobaoOauthUrl = PropertyReader.getValue(TAOBAO_OAUTH_URL_KEY);

    public static String TAOBAO_REDIRECT_URI_KEY = "taobao.redirect.uri";

    public static String taobaoRedirectUri = PropertyReader.getValue(TAOBAO_REDIRECT_URI_KEY);



    @RequestMapping(value="/oauth/tb/flag")
    @ResponseBody
    public boolean isTaoBaoOauth(Long shopId , HttpSession httpSession) {

        Long sellerId = getSellerId(httpSession);

        SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId), String.valueOf(shopId));

        if(sellerShop!=null && StringUtils.isNotBlank(sellerShop.getShopAccessToken())){
            return true;
        }

        return false;
    }

    /**
     * 淘宝api授权跳转
     *
     * @return
     */
    @RequestMapping("/oauth/tb/show")
    public
    @ResponseBody
    String oauthTbShow(Long shopId , HttpSession httpSession) {

        try {

            Long sellerId = getSellerId(httpSession);

            AssertsUtil.notNull(sellerId, "sellerId");
            AssertsUtil.notNull(shopId, "shopId");

            SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId), String.valueOf(shopId));
            AssertsUtil.notNull(sellerShop, "sellerShop");

            AssertsUtil.check(!DaoConstant.ShopType.TB.equals(sellerShop) && !DaoConstant.ShopType.TMALL.equals(sellerShop), "店铺类型不对，不是淘宝或天猫店铺!");

            Date expire = sellerShop.getShopTokenExpire();

            if(StringUtils.isNotBlank(sellerShop.getShopAccessToken()) && expire!=null && expire.after(new Date())){
                return "已授权";
            }
            String clientId = sellerShop.getShopAppId();
            AssertsUtil.notBothSidesBlank(clientId, "clientId");

            AssertsUtil.notBothSidesBlank(taobaoOauthUrl, "taobaoOauthUrl");

            AssertsUtil.notBothSidesBlank(taobaoRedirectUri, "taobaoRedirectUri");

            String state = sellerId+"_"+shopId;

            return "redirect:" + taobaoOauthUrl + "/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + taobaoRedirectUri
                    + "&state=" + state + "&view=tmall";

        } catch (Exception e) {

            String message = e.getMessage() == null ? "null point exception" : e.getMessage();
            log.error("taobao oauth oauthTbShow error,errorMsg:" + message);
            return "taobao oauth oauthTbShow error,errorMsg:" + message;

        }

    }

    /**
     * 淘宝api授权
     *
     * @return
     */
    @RequestMapping("/oauth/tb")
    public
    @ResponseBody
    ModelAndView oauthTb(HttpServletRequest request) {

        Map<String, String> resultMap = new HashMap<String, String>();
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String error = request.getParameter("error");
        String error_description = request.getParameter("error_description");

        if (StringUtils.isNotBlank(error)) {

            try {
                error_description = (error_description == null ? "" : error_description);
            } catch (Exception e) {
                log.error("taobao oauth error", e);
            }

            log.error("taobao oauth error,errorMsg:" + error_description);
            resultMap.put(ERROR_MESSAGE_KEY, "授权失败,错误消息:" + error_description);
            return new ModelAndView("/taobao/result", resultMap);
        }

        TaoBaoAccessTokenVO taoBaoAccessTokenVO = null;

        String[] sellerInfo = state.split("_");
        SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerInfo[0],sellerInfo[1]);
        AssertsUtil.notNull(sellerShop, "sellerShop");

        try {

            taoBaoAccessTokenVO = taoBaoOauthService.getTokenAccess(code,sellerShop);
            log.info("############ taoBaoAccessTokenVO " + taoBaoAccessTokenVO);
            resultMap.put(ERROR_MESSAGE_KEY, "授权成功!,access_token:" + taoBaoAccessTokenVO.getAccess_token());

        } catch (Exception e) {
            log.error("taobao oauth error,errorMsg:" + e.getMessage(), e);
            resultMap.put(ERROR_MESSAGE_KEY, "授权失败,错误消息:" + e.getMessage());
        }

        return new ModelAndView("/taobao/result", resultMap);

    }

}
