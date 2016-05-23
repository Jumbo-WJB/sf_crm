package com.shufensoft.crm.web.controller.mobile.activity;

import com.shufensoft.crm.biz.domain.generation.activity.Activity;
import com.shufensoft.crm.biz.service.activity.ActivityService;
import com.shufensoft.crm.biz.service.activity.ActivityShopHongBaoServcie;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>活动controller</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/9/29  
 */
@Controller
@RequestMapping(value="/mobile")
public class mobileActivityController extends BaseController{

    @Autowired
    private ActivityService   activityService;

    @Autowired
    private ActivityShopHongBaoServcie   activityShopHongBaoServcie;

    @Autowired
    private HongBaoObtainService hongBaoObtainService;


    /**
     * 获取购物红包活动列表
     * @param modelMap
     * @param userId
     * @param sellerId
     * @return
     */
    @RequestMapping(value = "/activity/shoppingList")
    public ModelAndView getShoppingActivityList(ModelMap modelMap,String userId,String sellerId) {
        Activity  activity=new Activity();
        activity.setActivityType("hongbao_shopping");
        List<Activity> activityList= activityService.getActivityList(activity);

        modelMap.put("activityList",activityList);
        return new ModelAndView("/mobile/activity/suniu_shopping_activity_list", modelMap);
    }


    /**
     * 获取购物红包详细信息
     * @param modelMap
     * @param userId
     * @param sellerId
     * @return
     */
    @RequestMapping(value = "/activity/shoppingDetail")
    public ModelAndView getShoppingActivityDetail(ModelMap modelMap,String userId,String sellerId,String  activityId) {

        return new ModelAndView("/mobile/activity/suniu_shopping_activity_detail", modelMap);
    }



}
