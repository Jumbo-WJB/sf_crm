package com.shufensoft.crm.web.controller.permission;

import com.shufensoft.crm.biz.service.Permission.AdminUserService;
import com.shufensoft.crm.common.utils.Md5Encrypt;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.interceptor.constant.LoginConstant;
import com.shufensoft.crm.web.vo.AdminUserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 用户登陆相关Controller
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/29  
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController extends BaseController {

    @Resource(name = "adminUserService")
    private AdminUserService adminUserService;
    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "permission/login";

    @RequestMapping("/login")
    public ModelAndView login(ModelMap modelMap) {
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping("/doLogin")
    public String loginAction(AdminUserVO adminUserVO, HttpSession session) {

        if (adminUserVO == null || StringUtils.isBlank(adminUserVO.getUserName())
                || StringUtils.isBlank(adminUserVO.getPassword())) {
            return "redirect:/admin/login";
        }

        AdminUserVO adminUser = adminUserService.findAdminUserByUserName(adminUserVO.getUserName());
        String password = Md5Encrypt.md5(adminUserVO.getPassword());
        if (adminUser != null && password.equals(adminUser.getPassword())) {
            session.setAttribute(LoginConstant.SESSION_KEY, adminUser);
            return "redirect:/";
        }
        return "redirect:/admin/login";

    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session,HttpServletRequest request) {

        session.setAttribute(LoginConstant.SESSION_KEY, null);

        return "redirect:/admin/login";

    }

    @RequestMapping("/passwd")
    public
    @ResponseBody
    Map<String, String> passwd(AdminUserVO adminUserVO, BindingResult result, HttpSession session) {

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        //单独校验用户名
        if (StringUtils.isBlank(adminUserVO.getUserName())) {
            returnMap.put(ERROR_MESSAGE_KEY, "缺少用户名!");
            return returnMap;
        }
        //单独校验原密码
        if (StringUtils.isBlank(adminUserVO.getPassword())) {
            returnMap.put(ERROR_MESSAGE_KEY, "原密码不能为空!");
            return returnMap;
        }
        //单独校验新密码
        if (StringUtils.isBlank(adminUserVO.getNewpasswd1()) || StringUtils.isBlank(adminUserVO.getNewpasswd2())) {
            returnMap.put(ERROR_MESSAGE_KEY, "新密码不能为空!");
            return returnMap;
        }

        if (!adminUserVO.getNewpasswd1().equals(adminUserVO.getNewpasswd2())) {
            returnMap.put(ERROR_MESSAGE_KEY, "两次输入密码不一致!");
            return returnMap;
        }

        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            returnMap.put(ERROR_MESSAGE_KEY, getError(result));
            return returnMap;
        }
        try {
            adminUserVO.setNewpasswd1(Md5Encrypt.md5(adminUserVO.getNewpasswd1()));
            adminUserVO.setModifiedBy(getUserName(session));
            boolean flag = adminUserService.updatePasswd(adminUserVO);
            if (!flag) {
                returnMap.put(ERROR_MESSAGE_KEY, "修改密码失败");
                return returnMap;
            }
        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }
        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "密码修改成功!");
        return returnMap;

    }
}
