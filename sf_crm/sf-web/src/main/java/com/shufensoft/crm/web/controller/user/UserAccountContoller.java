package com.shufensoft.crm.web.controller.user;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.vo.UserAccountVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 用户账户
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/16 15:37  
 */
@Controller
public class UserAccountContoller  extends BaseController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(UserAccountContoller.class);

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/userAccount/list")
    @ResponseBody
    public ModelAndView hbAccountList(ModelMap modelMap) {
        return new ModelAndView("/user/userAccountList", modelMap);
    }


    /**
     * 分页获取账户明细列表
     *
     * @param userAccountVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping("/userAccount/datas")
    public
    @ResponseBody
    Map<String, Object> datas(UserAccountVO userAccountVO, Integer pageNum, Integer length,String sortContent,HttpSession httpSession) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 0;
        }

        Long sellerId=getSellerId(httpSession);

        PageInfo pageInfo = userAccountService.queryUserAccounts(userAccountVO, pageNum, length,sortContent,sellerId);
        Map<String, Object> datas = Maps.newHashMap();

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }

        return datas;
    }

}
