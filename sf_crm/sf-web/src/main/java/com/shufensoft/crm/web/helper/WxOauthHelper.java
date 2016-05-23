package com.shufensoft.crm.web.helper;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.service.seller.SellerMobileMenuService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.biz.service.wx.vo.WxUserOuathVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.WebConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 微信授权帮助类
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/17  
 */
public class WxOauthHelper {

    private static final Logger logger = Logger.getLogger(WxOauthHelper.class);

    public static SellerMobileMenuService sellerMobileMenuService = (SellerMobileMenuService) SpringContextUtil.getBean("sellerMobileMenuService");

    public static WXService wXService = (WXService) SpringContextUtil.getBean("wXService");

    public static UserService userService = (UserService) SpringContextUtil.getBean("userService");

    public static String WX_OPEN_API_URI_KEY = "wx.open.api.url";

    public static String wxOpenApiUri = PropertyReader.getValue(WX_OPEN_API_URI_KEY);

    public static String CRM_WEB_URI_KEY = "crm.web.url";

    public static String crmWebUri = PropertyReader.getValue(CRM_WEB_URI_KEY);


    /**
     * 判断url是否需要授权
     * @param request
     * @return
     */
    public static boolean isNeedOauth(HttpServletRequest request,Long  sellerId) {

        String url = request.getServletPath();
        if(url.indexOf("/mobile/")==-1){
            return false;
        }

        SellerMobileMenu sellerMobileMenu = sellerMobileMenuService.getSellerMobileMenuByLink(url,sellerId);
        if (sellerMobileMenu != null && sellerMobileMenu.getOauth()) {
            return true;
        }

        return false;

    }


    /**
     * 拼接授权url
     * @param url
     * @param scope snsapi_base:隐性授权，
     *              snsapi_userinfo:显性授权
     */
    public static String getOauthUrl(String sellerId, String url, String scope) throws UnsupportedEncodingException {


        AssertsUtil.notBlank(url, "url");

        AssertsUtil.notBlank(scope, "scope");

        /**
         * 微信相关配置信息
         */
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
        AssertsUtil.notNull(sellerConfigInfo, "sellerConfigInfo");
        AssertsUtil.notBlank(sellerConfigInfo.getWxAppId(), "WxAppId");
        AssertsUtil.notBlank(sellerConfigInfo.getWxAppSecret(), "WxAppSecret");
        url = URLEncoder.encode(url, "utf-8");
        return  wxOpenApiUri + "/connect/oauth2/authorize?appid=" + sellerConfigInfo.getWxAppId()
                + "&redirect_uri=" + crmWebUri + url +
                "&response_type=code&scope=" + scope + "&state=" + scope + "#wechat_redirect";
    }


    /**
     * 用户授权
     * @param request
     * @param response
     * @return
     */
    public static void wxOauth(String sellerId, HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException {

        String url = request.getServletPath();
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String userId = request.getParameter("userId");
        String codeFlag = request.getParameter("codeFlag");
        String contextPath = request.getContextPath();
        if(StringUtils.isNotBlank(userId)){
            filterChain.doFilter(request,response);
            return;
        }
        Map<String, String> paramMap = request.getParameterMap();

        /**
         * 隐性授权
         */
        if (StringUtils.isBlank(code) && !"1".equals(codeFlag)) {

            String param = buildParamStr(paramMap,request);
            if(StringUtils.isNotBlank(param)){
                url = url + "?" +param+"&codeFlag=1";
            }else{
                url = url + "?" +"&codeFlag=1";
            }

            response.sendRedirect(getOauthUrl(sellerId,url, WebConstant.scope.SNSAPI_BASE));
            return;
        }

        /**
         * 如果返回code，获取openid，并且新粉丝需要显性授权
         */
        WxUserOuathVO wxUserOuathVO = wXService.getWxUserOuath(sellerId , code);

        /**
         * 隐性授权处理
         */
        if (WebConstant.scope.SNSAPI_BASE.equals(state)) {

            String openId = wxUserOuathVO.getOpenid();
            UserVO userVO = userService.findUserByOpenId(Long.valueOf(sellerId),openId);

            if (userVO == null) {

                String param = buildParamStr(paramMap,request);
                if(StringUtils.isNotBlank(param)){
                    url = url + "?" +param+"&codeFlag=1";
                }else{
                    url = url + "?codeFlag=1";
                }

                response.sendRedirect(getOauthUrl(sellerId,url, WebConstant.scope.SNSAPI_USERINFO));
                return;
            }

            /**
             * 用户认证处理
             */
            if(UserVaidateHelper.isNeedValidate(request,Long.valueOf(sellerId))&&(StringUtils.isBlank(userVO.getIsVerify())||"0".equals(userVO.getIsVerify()))){

                String redirectUrl = URLEncoder.encode(contextPath+url+"?sellerId="+sellerId+"&userId="+userVO.getUserId(),"utf-8");
                request.getRequestDispatcher("/mobile/identify?sellerId="+sellerId+"&userId="+userVO.getUserId()+"&redirectUrl="+redirectUrl).forward(request,response);
                return;
            }

            request.getRequestDispatcher(url+"?userId="+userVO.getUserId()).forward(request,response);
            return;

        }


        /**
         * 显性授权处理
         */
        if (WebConstant.scope.SNSAPI_USERINFO.equals(state)) {

            UserVO userVO = userService.createAndReturnWXUserToUser(sellerId, wxUserOuathVO.getOpenid(), wxUserOuathVO.getAccessToken());

            /**
             * 用户认证处理
             */
            if(userVO!=null){

                if(UserVaidateHelper.isNeedValidate(request,Long.valueOf(sellerId))&&(StringUtils.isBlank(userVO.getIsVerify())||"0".equals(userVO.getIsVerify()))){

                    String redirectUrl = URLEncoder.encode(contextPath+url+"?sellerId="+sellerId+"&userId="+userVO.getUserId(),"utf-8");
                    request.getRequestDispatcher("/mobile/identify?sellerId="+sellerId+"&userId="+userVO.getUserId()+"&redirectUrl="+redirectUrl).forward(request,response);
                    return;
                }
                request.getRequestDispatcher(url+"?userId="+userVO.getUserId()).forward(request,response);
                return;
            }

        }

        filterChain.doFilter(request,response);

    }

    /**
     * 组装参数
     *
     * @param param
     * @return
     */
    private static String buildParamStr(Map<String, String> param,HttpServletRequest request) {
        String paramStr = "";
        Object[] keyArray = param.keySet().toArray();
        for (int i = 0; i < keyArray.length; i++) {

            String key = (String) keyArray[i];
            if("code".equals(key) || "state".equals(key)){
                continue;
            }
            if (0 == i) {
                paramStr += (key + "=" + (request.getParameter(key)==null?"":request.getParameter(key)));
            } else {
                paramStr += ("&" + key + "=" + (request.getParameter(key)==null?"":request.getParameter(key)));
            }

        }

        return paramStr;
    }

}
