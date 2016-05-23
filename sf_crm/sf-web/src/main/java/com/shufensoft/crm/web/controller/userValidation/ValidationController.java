package com.shufensoft.crm.web.controller.userValidation;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.user.UserValidateService;
import com.shufensoft.crm.biz.vo.UserValidateVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>客户验证控制层
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/6/28  
 */
@Controller
public class ValidationController extends BaseController{

    @Autowired
    private UserValidateService userValidateService;

    /**明细页面*/
    @RequestMapping(value = "/userValidate/validateDetail")
    public ModelAndView goValidateDetail(){
        return new ModelAndView("/userValidation/validateDetail");
    }

    /**明细查询*/
    @RequestMapping(value = "/userValidate/showValidate")
    public @ResponseBody Map<String, Object> showList(@Valid UserValidateVO userValidateVO, Integer pageNum, Integer length, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        userValidateVO.setSellerId(String.valueOf(sellerId));
        PageInfo pageInfo;
        try {
            pageInfo = userValidateService.getValidationList(userValidateVO,pageNum,length);
        }catch (Exception e){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"查询异常");
            return map;
        }

        if (pageInfo != null){
            map.put("recordsTotal", pageInfo.getTotal());
            map.put("recordsFiltered", pageInfo.getTotal());
            map.put("data", pageInfo.getList());
        }

        return map;
    }


}
