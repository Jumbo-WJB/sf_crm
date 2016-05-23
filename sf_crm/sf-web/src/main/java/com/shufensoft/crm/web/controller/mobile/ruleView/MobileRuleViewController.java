package com.shufensoft.crm.web.controller.mobile.ruleView;

import com.shufensoft.crm.biz.service.reply.KeyWordReplyService;
import com.shufensoft.crm.biz.vo.KeyWordReplyConfigVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>规则查看controller</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/22  
 */
@RequestMapping("/mobile")
@Controller
public class MobileRuleViewController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MobileRuleViewController.class);

    @Autowired
    private KeyWordReplyService keyWordReplyService;

    /**
     * 积分红包规则查看
     * @param modelMap
     * @return
     */
    @RequestMapping("/hbPointRule")
    public ModelAndView hbPointRuleView(ModelMap modelMap ,String sellerId) {

        modelMap.put("sellerId",sellerId);

        return new ModelAndView("/mobile/rule/suniu_point_hb_rule", modelMap);
    }

    /**
     * 关键字回复规则查看
     * @param modelMap
     * @return
     */
    @RequestMapping("/replyRule")
    public ModelAndView dResponseRuleView(ModelMap modelMap,String sellerId) {

        modelMap.put("sellerId",sellerId);
        List<KeyWordReplyConfigVO> keyWordReplyConfigVOs= keyWordReplyService.queryKeyWordConfig();
        modelMap.put("keyWordReplyConfigVOs",keyWordReplyConfigVOs);

        return new ModelAndView("/mobile/rule/suniu_dynamic_response_rule", modelMap);
    }


}
