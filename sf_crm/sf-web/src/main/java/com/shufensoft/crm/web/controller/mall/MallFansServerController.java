package com.shufensoft.crm.web.controller.mall;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallFansDo;
import com.shufensoft.crm.biz.service.mall.MallProcess;
import com.shufensoft.crm.biz.service.pointmall.face.IMallTradeService;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/30  
 */
@Controller
public class MallFansServerController extends BaseController{

    private static IMallTradeService iMallTradeService;

    static{
        iMallTradeService = (IMallTradeService)SpringContextUtil.getBean("iMallTradeService");
    }
    /**
     * to 积分兑换商品粉丝列表页
     * */
    @RequestMapping("/mall/fans/list")
    @ResponseBody
    public ModelAndView fansList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/mall/fans/fansList");
        return mav;
    }

    /**
     *  获取积分商城 粉丝兑换数据
     * */
    @RequestMapping("/mall/fans/datas")
    @ResponseBody
    public Map<String,Object> getFansDatas(MallFansDo mallFansDo, Integer start, Integer length, HttpSession session){
        if(start == null || start == 0){
            start = 1;
//            length = 10;
        }
        Long sellerId = getSellerId(session);
        Date bd = null;
        if(StringUtils.isNotBlank(mallFansDo.getStartDate())){
            bd = DateUtil.getDateFromString(mallFansDo.getStartDate());
        }
        Date ed = null;
        if(StringUtils.isNotBlank(mallFansDo.getEndDate())){
            ed = DateUtil.getDateFromString(mallFansDo.getEndDate());
        }
        if(StringUtils.isNotBlank(mallFansDo.getWxNickName())){
//                String temp = new String(mallFansDo.getWxNickName().getBytes("iso-8859-1"),"utf-8");
//                mallFansDo.setWxNickName("%" + temp + "%");
                mallFansDo.setWxNickName("%" + mallFansDo.getWxNickName() + "%");
        }
        PageInfo pageInfo = iMallTradeService.findMallFansDosByPage(sellerId, mallFansDo.getStatus(), mallFansDo.getWxNickName(), bd, ed, start, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 导出粉丝列表数据
     * */
     @RequestMapping("/mall/fans/exportExcel")
     public String exportExcel(HttpServletResponse response, String wxName, String status, String startDate, String endDate, HttpSession session){
         response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try{
            String fileName = new String("积分兑换粉丝数据表".getBytes("utf-8"),"iso-8859-1");      //此处 UTF-8 为 GBK 会有乱码
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");
            Long sellerId = getSellerId(session);
            Date bd = null;
            Date ed = null;
            if(StringUtils.isNotBlank(startDate)){
                bd = DateUtil.getDateFromString(startDate);
            }
            if(StringUtils.isNotBlank(endDate)){
                ed = DateUtil.getDateFromString(endDate);
            }
            if(StringUtils.isBlank(wxName)){
                wxName = null;
            }else{
                wxName = "%" + wxName + "%";
            }
            if(StringUtils.isBlank(status)){
                status = null;
            }
            List<MallFansDo> datas = iMallTradeService.findMallFansDos(sellerId,status,wxName,bd,ed);
            byte[] excelData = MallProcess.formatMallFansDatas(datas);
            response.getOutputStream().write(excelData,0,excelData.length);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
