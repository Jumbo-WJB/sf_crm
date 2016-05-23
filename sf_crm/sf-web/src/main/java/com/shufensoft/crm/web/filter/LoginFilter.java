package com.shufensoft.crm.web.filter;

import com.shufensoft.crm.biz.aspect.DaoContextHolder;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.web.helper.UserInteractionDetailHelper;
import com.shufensoft.crm.web.helper.WxOauthHelper;
import com.shufensoft.crm.web.interceptor.constant.LoginConstant;
import com.shufensoft.crm.web.interceptor.util.WhiteUrl;
import com.shufensoft.crm.web.vo.AdminUserVO;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description:  登录拦截器
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/16  
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String contextPath = request.getContextPath();

        /**
         * 验证请求白名单
         */
        if (WhiteUrl.isWhiteUrl(request)) {

            String sellerId = request.getParameter("sellerId");
            String userId = request.getParameter("userId");

            /**
             * 前台url入口
             */
            if(StringUtils.isNotBlank(sellerId)){

                /**
                 * 设置数据源
                 */
                DatasourceHelper.setDatasource(sellerId);

                /**
                 * 互动统计
                 */
                UserInteractionDetailHelper.recordUserInteractionDetail(request);

                Map<String,Object> map = new HashMap<String,Object>();
                map.put("sellerId",sellerId);
                map.put("userId",userId);
                map.put("source","foreground");
                DaoContextHolder.setLoginName(map);

                /**
                 * 授权
                 */
                if(WxOauthHelper.isNeedOauth(request,Long.valueOf(sellerId))){
                    WxOauthHelper.wxOauth(sellerId,request,response,filterChain);
                    return;
                }

            }

            filterChain.doFilter(request, response);

            return;

        }

        AdminUserVO user = (AdminUserVO) session.getAttribute(LoginConstant.SESSION_KEY);

        /**
         * user为空，表示未登陆，跳转到登陆页面
         */
        if (null == user) {
            response.sendRedirect(contextPath + "/admin/login");
            return;
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName",user.getUserName());
        map.put("userId",user.getAdminUserId());
        map.put("sellerId",user.getSellerId());
        map.put("source","background");
        DaoContextHolder.setLoginName(map);

        AssertsUtil.notNull(user.getSellerId(),"seller id");

        if(user.getSellerId()!=null){
            DatasourceHelper.setDatasource(String.valueOf(user.getSellerId()));
        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }


}
