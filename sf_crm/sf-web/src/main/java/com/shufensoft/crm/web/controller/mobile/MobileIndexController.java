package com.shufensoft.crm.web.controller.mobile;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.service.pointmall.face.IClientService;
import com.shufensoft.crm.biz.service.seller.SellerMobileMenuService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>手机端主页</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/3  
 */
@RequestMapping("/mobile")
@Controller
public class MobileIndexController  extends BaseController{


    private static IClientService iClientService;

    @Resource(name="sellerMobileMenuService")
    private SellerMobileMenuService sellerMobileMenuService;

    static{
        iClientService = (IClientService)SpringContextUtil.getBean("iClientService");
    }


    /**
     * 获取首页内容方法
     * @param modelMap
     * @param sellerId
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(ModelMap modelMap,String sellerId) {

        SellerMobileMenu sellerMobileMenu=new SellerMobileMenu();
        sellerMobileMenu.setType("indexpage");
        sellerMobileMenu.setIsSelect("1");
        List<SellerMobileMenu > sellerMobileMenus=  sellerMobileMenuService.getSellerMobileMenus(sellerMobileMenu,Long.valueOf(sellerId));

        modelMap.put("sellerMobileMenus",sellerMobileMenus);
        modelMap.put("sellerId", sellerId);

        return new ModelAndView("/mobile/suniu_index", modelMap);
    }

    /**
     * 用户点赞
     * */
    @RequestMapping(value="/dianzan")
    public Map<String,Object> dianzan(Long buid, Long uid,String interactionEntry){
        Map<String,Object> map = Maps.newHashMap();
        if(buid == null || uid == null){
            map.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY, "userID is null");
            return map;
        }
        if(buid.equals(uid)){
            map.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY, "不能对本人点赞");
            return map;
        }
        int result = iClientService.dianzan(buid,uid,interactionEntry);
        if(result == 1){
            map.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            map.put(ERROR_MESSAGE_KEY, "点赞成功");
        }else{
            map.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY, "今天已点赞");
        }
        return map;
    }



}
