package com.shufensoft.crm.web.controller.oauth;

import com.alibaba.fastjson.JSONObject;
import com.shufensoft.crm.biz.adapter.JDAdapter;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.oauth.imple.JDOauthServiceInter;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.interceptor.constant.LoginConstant;
import com.shufensoft.crm.web.vo.AdminUserVO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *  @ProjectName: sf-crm  
 *  @Description:  openapi授权
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
@Controller
public class JdApiOauthController extends BaseController {


    private Logger log = Logger.getLogger(JdApiOauthController.class);

    @Autowired
    private JDOauthServiceInter jdOauthService;


    @RequestMapping(value="/oauth/jd/flag")
    @ResponseBody
    public boolean isJDOauth(Long shopId , HttpSession httpSession) {

        Long sellerId = getSellerId(httpSession);

        SellerShop sellerShop = SellerConfigCache.getSellerShop(String.valueOf(sellerId), String.valueOf(shopId));

        if(sellerShop!=null && StringUtils.isNotBlank(sellerShop.getShopAccessToken())){
            return true;
        }

        return false;
    }

    /**
     * 该接口是配置给获取京东code和access_token的回调url
     * 客户授权成功通过浏览器回调到这里，如：http://shufen.duapp.com/test?state=0902110513&code=YbMFbX
     * code参数是京东返回的，state是由我们填的任意值，京东会原封不动地返回，这里建议填写商户的sellerId
     * 接下去就是获取access_token, 把获取的access_token 和 refresh_token 写入数据库中
     */
    @RequestMapping(value="/api/oauth/jd", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String oauthJD(HttpServletRequest req) {
        String code = req.getParameter("code");
        String state = req.getParameter("state");
        if("null".equals(state)){
            state = null;
        }
        log.info("code==  :" + code + "  state==   :" + state);
        JSONObject json;
        try {
            json = JDAdapter.getJdAccessToken(code,state);
            log.info("##### json #####:  " + json.toString());
            String returnCode = json.getString("code");
            if ("0".equals(returnCode)) {
                String accessToken = json.getString("access_token");
                String refreshToken = json.getString("refresh_token");
                int expiresTime = Integer.parseInt(json.getString("expires_in"));

                if (!StringUtils.isEmpty(state)) {
                    String[] sellerInfo = state.split("_");
                    SellerShop updateSellerShop = new SellerShop();
                    updateSellerShop.setShopAccessToken(accessToken);
                    updateSellerShop.setShopRefreshToken(refreshToken);
                    Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, expiresTime);
                    updateSellerShop.setShopTokenExpire(expiresDate);
                    updateSellerShop.setSellerId(Long.parseLong(sellerInfo[0]));
                    updateSellerShop.setShopId(Long.parseLong(sellerInfo[1]));
                    SellerConfigCache.putSellerShop(sellerInfo[0], updateSellerShop);
//                SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerInfo[0],sellerInfo[1]);
//                AssertsUtil.notNull(sellerShop, "sellerShop");
//
//                appKey = sellerShop.getShopAppId();
//                appSecret = sellerShop.getShopAppSecret();
//                String url = "https://oauth.jd.com/oauth/token?grant_type=authorization_code&client_id=" + appKey
//                        + "&client_secret=" + appSecret
//                        + "&scope=read&redirect_uri=" + redirectUri
//                        + "&code=" + code
//                        + "&state=" + state;
//                while (count < 3 && accessToken == null) {                             //如果没有获取到token, 最多允许尝试3次
//                    URL uri = new URL(url);
//                    HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
//                    conn.setRequestProperty("Accept-Charset", "utf-8");
//                    conn.setRequestMethod("POST");
//                    InputStream is = conn.getInputStream();
//                    jsonStr = CommonUtil.inputStream2String(is, "utf-8");
//                    log.info(jsonStr);
//                    is.close();
//                    JSONObject json = JSONObject.parseObject(jsonStr);
//                    String returnCode = json.getString("code");
//                    if ("0".equals(returnCode)) {
//                        accessToken = json.getString("access_token");
//                        String refreshToken = json.getString("refresh_token");
//                        int expiresTime = Integer.parseInt(json.getString("expires_in"));
//                        if (accessToken != null) {
//                            SellerShop updateSellerShop = new SellerShop();
//                            updateSellerShop.setShopAccessToken(accessToken);
//                            updateSellerShop.setShopRefreshToken(refreshToken);
//                            Date expiresDate = DateUtil.operateDate(new Date(), 0, 0, 0, 0, 0, expiresTime);
//                            updateSellerShop.setShopTokenExpire(expiresDate);
//                            updateSellerShop.setSellerId(sellerShop.getSellerId());
//                            updateSellerShop.setShopId(sellerShop.getShopId());
//                            SellerConfigCache.putSellerShop(sellerInfo[0], updateSellerShop);
//                        }
//                        break;
//                    }
//                    count++;
//                    log.info("######access_token#######" + appKey + " : " + accessToken);
//                }
//                if (count >= 3) {
//                    return "get access_token fail:    " + jsonStr;
//                }
                } else {            //从京东服务市场订购的服务, state为null
                   AdminUser adminUser = jdOauthService.handleAuthorizeFromJDServiceMarket(accessToken,refreshToken,expiresTime);
                   log.info("adminUser : " + adminUser);
                   if(adminUser != null){
                        AdminUserVO adminUserVo = (AdminUserVO)BeanCopierUtils.copyProperties(adminUser, AdminUserVO.class);
                       req.getSession().setAttribute(LoginConstant.SESSION_KEY, adminUserVo);
                       return "redirect:/";
                   }
                   return "授权失败, 请检查是否京东商家账户登录";
                }
            }else{
                String str = "授权失败 : " + json.toString();
//                log.info(str);
//                String str1 = new String(str.getBytes(),"ISO-8859-1");
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return "授权失败, 发生异常";
        }
        return "授权成功   " + code + "    " + state + "   " + json.toString();
    }


}
