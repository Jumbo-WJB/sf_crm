package com.shufensoft.crm.web.controller.integral;


import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.integral.service.IntegralService;
import com.shufensoft.crm.biz.service.integral.vo.IntegralConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInPointConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInVO;
import com.shufensoft.crm.biz.service.interactive.WxMessageService;
import com.shufensoft.crm.biz.service.point.PointMultipleService;
import com.shufensoft.crm.biz.vo.PointDetailVO;
import com.shufensoft.crm.biz.vo.PointMultipleDetailVO;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/20 下午3:52  
 */
@Controller
public class IntegralController extends BaseController{

    @Autowired
    private IntegralService integralService;


    @Autowired
    private PointMultipleService pointService;

    @Autowired
    private WxMessageService wxMessageService;


//    /**
//     * to 创建积分页面
//     * */
//    @RequestMapping("/integral/integralConfig")
//    @ResponseBody
//    public ModelAndView createIntegral(){
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("/integral/integralConfig");
//        return mav;
//    }

    @RequestMapping("/integralConvert/list")
    @ResponseBody
    public ModelAndView getIntegralDetail(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/integral/integralConertDetail");
        return mav;
    }

    @RequestMapping("/integralQuery/list")
    @ResponseBody
    public ModelAndView getIntegralQueryDetail(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/integral/integralQueryDetail");
        return mav;
    }


    @RequestMapping("/integralSignIn/list")
    @ResponseBody
    public ModelAndView integralSingInConfig(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/integral/integralSignInConfig");
        return mav;
    }


    @RequestMapping(value="/integralConfig/save")
    public
    @ResponseBody
        Map<String, Object> saveIntegralConfig(IntegralConfigVO integralConfigVO,HttpSession session){

        Map<String,Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);

        Long sellerId = getSellerId(session);
        integralConfigVO.setSellerId(String.valueOf(sellerId));
        integralConfigVO.setConfigType("INTEGRAL_CONFIG");
//        int length =integralConfigVO.getBuyIntegralArgs().length();
//        String[] args = integralConfigVO.getBuyIntegralArgs().substring(1,length).split(",");
//
//        List<String> list = Arrays.asList(args);
//        integralConfigVO.setBuyIntegralList(list);

        try{
            integralService.saveIntegralConfig(integralConfigVO);
        }catch (Exception e){
            returnMap.put(ERROR_MESSAGE_KEY, "保存配置失败。");
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "保存配置规则成功!");
        return returnMap;
    }



    @RequestMapping(value="/signIntegralConfig/save")
    public
    @ResponseBody
    Map<String, Object> saveSignPointConfig(@RequestBody List<SignInVO> signInVOList,HttpSession session){
        Map<String,Object> returnMap = new HashMap<String, Object>();


        returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);
        if (signInVOList == null || signInVOList.isEmpty()){
            return returnMap;
        }

        Long sellerId =  getSellerId(session);
        SignInPointConfigVO signInPointConfigVO = new SignInPointConfigVO();
        signInPointConfigVO.setSellerId(Long.valueOf(sellerId));
        signInPointConfigVO.setSignInVOList(signInVOList);

        try{
            integralService.saveSignRule(signInPointConfigVO);
        }catch (Exception e){
            returnMap.put(ERROR_MESSAGE_KEY, "保存配置失败。");
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "保存配置规则成功!");
        return returnMap;
    }

    @RequestMapping(value="/integral/querySignIntegral")
    public
    @ResponseBody
    Map<String,Object> querySignIntegral(ModelMap modelMap,HttpSession session){

        Long sellerId = getSellerId(session);

        SignInPointConfigVO signInPointConfigVO = new SignInPointConfigVO();

        try{
            signInPointConfigVO = integralService.querySignInPointRule(Long.valueOf(sellerId));
        }catch (Exception e){
            e.printStackTrace();
        }
        modelMap.put("signInPointConfigVO",signInPointConfigVO);

        return modelMap;

    }

    @RequestMapping(value = "/integral/integralConfig")
    public
    Object queryIntegralConfig(HttpSession session,ModelMap modelMap,String configName) {

        Long sellerId = getSellerId(session);
        IntegralConfigVO integralConfigVO = null;
        try {

            integralConfigVO = integralService.queryIntegralConfig(String.valueOf(sellerId),configName);

        } catch (Exception e) {
            throw new RuleEngineException("积分规则载入错误！");
        }

        modelMap.put("integralConfigVO",integralConfigVO);

        return modelMap;
    }


    @RequestMapping("/integral/integralDetailList")
    public
    @ResponseBody
    Map<String, Object> queryPointMultipleDetail(HttpSession session,PointMultipleDetailVO pointMultipleDetailVO, Integer pageNum, Integer length) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId = getSellerId(session);
        pointMultipleDetailVO.setSellerId(sellerId);
        PageInfo pageInfo = pointService.queryPointMultipleDetail(pointMultipleDetailVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }


    @RequestMapping("/integral/integralObtainDetailList")
     public
     @ResponseBody
     Map<String, Object> queryPointObtainDetail(HttpSession session,PointDetailVO pointDetailVO, Integer pageNum, Integer length) {
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId = getSellerId(session);

        pointDetailVO.setSellerId(sellerId);

        PageInfo pageInfo = pointService.queryPointObtainDetail(pointDetailVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }


    @RequestMapping("/integral/integralExchangDetailList")
    public
    @ResponseBody
    Map<String, Object> queryPointExchangDetail(HttpSession session,PointDetailVO pointDetailVO, Integer pageNum, Integer length) {
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId = getSellerId(session);

        pointDetailVO.setSellerId(sellerId);
        PageInfo pageInfo = pointService.queryPointExchangenDetail(pointDetailVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }



    @RequestMapping("/integral/signIntegralDetailList")
    public
    @ResponseBody
    Map<String, Object> querySignPointDetailList(HttpSession session,String orderBy,Integer pageNum, Integer length){
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        Long sellerId = getSellerId(session);
        PageInfo pageInfo = pointService.querySignPointDetail(sellerId,orderBy, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }





}
