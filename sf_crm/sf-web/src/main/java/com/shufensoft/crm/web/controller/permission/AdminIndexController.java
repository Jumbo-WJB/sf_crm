package com.shufensoft.crm.web.controller.permission;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.vo.ContributionModelVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/30  
 */
@Controller
public class AdminIndexController extends BaseController{

    public static final Logger logger = Logger.getLogger(AdminIndexController.class);

    @Autowired
    private UserService userService;

    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "index";

    @RequestMapping("/")
    public ModelAndView index(ModelMap modelMap,HttpSession session) {
        modelMap.put("indexFlag","1");
        modelMap.put("adminUser",getUser(session));

        Long sellerId = getSellerId(session);
        SellerConfigInfo configInfo = SellerConfigCache.get(String.valueOf(sellerId));
        if (configInfo != null && configInfo.getSellerShopList() != null){
            List<SellerShop> shopList = configInfo.getSellerShopList();
            if (!CollectionUtils.isEmpty(shopList)){
                modelMap.put("shopList",shopList);
            }
        }

        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    /**
     * 用户价值模型
     */
    @RequestMapping(value = "/index/getContributionModel")
    public
    @ResponseBody
    Map<String, Object> getModel(String source, BigDecimal startContribution, BigDecimal endContribution, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        ContributionModelVO data = null;
        try {
            data = userService.getUserContributionModelFromPlatform(source,startContribution,endContribution,getSellerId(session));
        }catch (Exception e){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"计算异常");
        }

        map.put("model",data);
        return map;
    }

}
