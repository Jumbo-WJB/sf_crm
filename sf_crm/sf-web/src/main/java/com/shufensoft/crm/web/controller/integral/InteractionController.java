package com.shufensoft.crm.web.controller.integral;


import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.pointmall.vo.PointStatisticsVO;
import com.shufensoft.crm.biz.vo.PointExchangeVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>积分统计
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/7/6  
 */
@Controller
public class InteractionController extends BaseController{

    private static Logger logger = Logger.getLogger(InteractionController.class);

    @Autowired
    private IPointService pointService;

    @RequestMapping (value = "/interaction/index")
    public ModelAndView index(ModelMap modelMap){
        return new ModelAndView("/customerInteraction/index",modelMap);
    }

    /**
     * 积分统计
     */
    @RequestMapping(value = "/interaction/integralCount")
    public
    @ResponseBody
    Map<String, Object> getIntegrals(int days, HttpSession session){
        Map<String, Object> modelMap = Maps.newHashMap();
        if (days <= 0){
            modelMap.put(ERROR_MESSAGE_KEY,"请求参数为空");
        }

        Long sellerId = getSellerId(session);
        PointStatisticsVO datas;
        try{
            datas = pointService.getPointStatisticsInfo(sellerId,days);
        }catch (Exception e){
            logger.info("积分统计计算异常："+e);
            modelMap.put(ERROR_MESSAGE_KEY,"统计计算异常");
            throw new RuntimeException(e);
        }

        modelMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        modelMap.put("modal",datas);
        return modelMap;
    }

    /**
     *一段时间内的积分统计
     */
    @RequestMapping(value = "/interaction/integralCharts")
    public
    @ResponseBody
    Map<String, Object> getIntegralCharts(int lastDays, HttpSession session){
        Map<String, Object> modelMap = Maps.newHashMap();
        if (lastDays <= 0){
            modelMap.put(ERROR_MESSAGE_KEY,"请求参数为空");
        }

        Long sellerId = getSellerId(session);
        List<PointExchangeVO> list;
        try{
            list = pointService.queryPointExchaneStatistics(sellerId, lastDays);
        }catch (Exception e){
            logger.info("积分统计计算异常："+e);
            modelMap.put(ERROR_MESSAGE_KEY,"统计计算异常");
            throw new RuntimeException(e);
        }

        modelMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        modelMap.put("modal",list);
        return modelMap;
    }
}
