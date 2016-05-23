package com.shufensoft.crm.web.helper;

import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.service.seller.SellerMobileMenuService;
import com.shufensoft.crm.common.utils.SpringContextUtil;

import javax.servlet.http.HttpServletRequest;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                微信授权帮助类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/17  
 */
public class UserVaidateHelper {

    public static SellerMobileMenuService sellerMobileMenuService = (SellerMobileMenuService) SpringContextUtil.getBean("sellerMobileMenuService");

    /**
     * 判断url是否需要授权
     * @param request
     * @return
     */
    public static boolean isNeedValidate(HttpServletRequest request,Long sellerId) {

        String url = request.getServletPath();
        if(url.indexOf("/mobile/")==-1){
            return false;
        }

        SellerMobileMenu sellerMobileMenu = sellerMobileMenuService.getSellerMobileMenuByLink(url,sellerId);
        if (sellerMobileMenu != null && sellerMobileMenu.getValidate()) {
            return true;
        }

        return false;

    }
}
