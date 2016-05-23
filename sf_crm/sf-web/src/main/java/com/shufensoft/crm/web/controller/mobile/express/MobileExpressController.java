package com.shufensoft.crm.web.controller.mobile.express;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.express.MobileExpressService;
import com.shufensoft.crm.biz.service.express.service.ExpressService;
import com.shufensoft.crm.biz.service.express.vo.ExpressDetailVO;
import com.shufensoft.crm.biz.service.express.vo.OrderVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/3  
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileExpressController extends BaseController{
    @Autowired
    private MobileExpressService mobileExpressService;
    @Autowired
    private ExpressService expressService;
    @Autowired
    private UserService userService;

    /**
     * 手机端我的快递查询
     * @param userId
     * @param sellerId
     * @param modelMap
     * @return
     */

    @RequestMapping(value = "/express")
    public ModelAndView showExpressView(Long sellerId, Long userId, ModelMap modelMap) {

        int start = 1;
        int pageNum = 50;

        PageInfo pageInfo = mobileExpressService.findOrderList(sellerId, userId,start,pageNum);

        Map<String, Object> map = mobileExpressService.findExpressHeadInfo(sellerId, userId);

        User user = userService.findUserBySellerIdAndUserId(sellerId, userId);

        modelMap.put("expressList", pageInfo == null ? null : pageInfo.getList());
        modelMap.put("expressMap", map);
        modelMap.put("user", user);
        return new ModelAndView("/mobile/express/suniu_express", modelMap);
    }


    /**
     * 显示快递详情
     * @param sellerId
     * @param userId
     * @param orderVO
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/expressDetail")
    public ModelAndView showExpressDetails(Long sellerId, Long userId, OrderVO orderVO, ModelMap modelMap){

        ExpressDetailVO  expressDetailVO = expressService.findCommentExpressInfo(sellerId, userId, orderVO);

        User user = userService.findUserBySellerIdAndUserId(sellerId, userId);
        
        modelMap.put("expressMap", expressDetailVO == null ? null : expressDetailVO);
        modelMap.put("user", user);
        modelMap.put("orderFrom", orderVO.getOrderFrom());
        modelMap.put("title", orderVO.getTitle());

        return new ModelAndView("/mobile/express/suniu_express_detail",modelMap);

    }


}
