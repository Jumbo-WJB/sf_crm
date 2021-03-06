package com.shufensoft.crm.web.interceptor.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description:  白名单过滤
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/29  
 */
public class WhiteUrl {
    private static final Logger Log = LoggerFactory.getLogger(WhiteUrl.class);
    private static List<String> whiteUrl = new ArrayList<String>();

    private static List<String> nonAuthUrl = new ArrayList<String>();

    static {

        whiteUrl.add("/mobile/*");
        whiteUrl.add("/oauth/tb");
        whiteUrl.add("/admin/login");
        whiteUrl.add("/admin/doLogin");
        whiteUrl.add("/taobaoComment/add");
        whiteUrl.add("/wechat/*");
        whiteUrl.add("/api/oauth/jd");
        whiteUrl.add("/rock/rockCheck");
        whiteUrl.add("/static/*");
        whiteUrl.add("/officialWebsite/contact");
        whiteUrl.add("/createToken");


    }


    private static final String[] DEFAULT_RESOURCES = new String[1024];

    static {
        int index = 0;
        DEFAULT_RESOURCES[index++] = ".css";
        DEFAULT_RESOURCES[index++] = ".js";
        DEFAULT_RESOURCES[index++] = ".gif";
        DEFAULT_RESOURCES[index++] = ".png";
        DEFAULT_RESOURCES[index++] = ".jpg";
        DEFAULT_RESOURCES[index++] = ".jpeg";
        DEFAULT_RESOURCES[index++] = ".tiff";
        DEFAULT_RESOURCES[index++] = ".ico";
        DEFAULT_RESOURCES[index++] = ".xml";
        DEFAULT_RESOURCES[index++] = ".xsd";
        DEFAULT_RESOURCES[index++] = ".exe";
        DEFAULT_RESOURCES[index++] = ".zip";
        DEFAULT_RESOURCES[index++] = ".rar";
        DEFAULT_RESOURCES[index++] = ".ttf";
        DEFAULT_RESOURCES[index++] = ".otf";
    }

    /**
     * 验证是否白名单url
     *
     * @param request
     * @return
     */
    public static boolean isWhiteUrl(HttpServletRequest request) {

        final String url = request.getServletPath();

        //css  js 等要排除过滤的url信息
        if (filterSuffix(url)) return true;

        //白名单url
        if (filterWhiteUrl(url)) {
            return true;
        }
        return false;
    }

    /**
     * 过滤白名单url
     * @param url
     * @return
     */
    private static boolean filterWhiteUrl(String url) {

        for (String s : whiteUrl) {
            if (null == s) {
                return false;
            }
            if (s.endsWith("*") && s.startsWith("*")) {
                String fixStr = s.substring(1, s.length() - 2);
                if (url.indexOf(fixStr) != -1) {
                    return true;
                }

            }
            if (s.endsWith("*")) {
                String fixStr = s.substring(1, s.length() - 2);
                if (url.indexOf(fixStr) != -1) {
                    return true;
                }

            }

            if (url.equals(s)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 过滤后缀文件
     * @param url
     * @return
     */
    private static boolean filterSuffix(String url) {
        for (String s : DEFAULT_RESOURCES) {
            if (null == s) return false;
            if (url.endsWith(s)) return true;
        }
        return false;
    }

}
