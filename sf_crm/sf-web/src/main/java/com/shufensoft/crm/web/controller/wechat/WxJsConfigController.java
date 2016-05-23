package com.shufensoft.crm.web.controller.wechat;

import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/8/2 下午12:31  
 */
@Controller
public class WxJsConfigController extends BaseController {

    @Autowired
    private WXService wXService;

    @RequestMapping("/mobile/getWxJsConfig")
    public
    @ResponseBody
    Map<String, Object> createWxJSConfig(String sellerId, String url) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        try {
            Map<String, String> datas = wXService.getWxJsConfigIn(Long.valueOf(sellerId), url);

            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(INFO_KEY, datas);

        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY,"获取JS调用配置失败");
        }

        return returnMap;
    }


}
