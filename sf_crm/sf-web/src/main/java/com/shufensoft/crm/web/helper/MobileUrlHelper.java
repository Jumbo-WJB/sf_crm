package com.shufensoft.crm.web.helper;

import com.shufensoft.crm.common.utils.AssertsUtil;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 手机端url自动带sellerId
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/28  
 */
public class MobileUrlHelper {

    public static String handlUrl(String sellerId, String url) {

        AssertsUtil.notBlank(url, "url");

        if (url.indexOf("?") != -1) {
            return url + "&sellerId=" + sellerId;

        }

        return url + "?sellerId=" + sellerId;
    }


    public static void main(String args[]) {

        String conent = "<p>淘宝特卖 精品疯抢季 <a href=\"http://temai.taobao.com/event9776.htm?pid=mm_50752783_10696982_35182992&scm=20140618.1.02030003.12s7\" _src=\"http://temai.taobao.com/event9776.htm?pid=mm_50752783_10696982_35182992&scm=20140618.1.02030003.12s7\">http://temai.taobao.com/event9776.htm?pid=mm_50752783_10696982_35182992&amp;scm=20140618.1.02030003.12s7</a> </p><p><br/></p><p><img src=\"/sf-web/upload/ueditor/image/20150826/1440559016563020622.jpg\" title=\"1440559016563020622.jpg\" alt=\"BB9Z13TIF26C8)[K0LBRXB9.jpg\"/></p><a href=\"[UNSUBSCRIBE_URL]\">取消订阅</a>";
        ResourceBundle bundle = PropertyResourceBundle.getBundle("config");
        String webUrl = bundle.getString("crm.web.url");
        String url[] = webUrl.split("/");

        String name = "/"+url[3];


        String ss = conent.replaceAll(name,webUrl);
        System.out.print(ss);
    }

}
