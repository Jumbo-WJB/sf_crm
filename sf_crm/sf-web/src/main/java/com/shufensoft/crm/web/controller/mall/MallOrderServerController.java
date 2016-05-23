package com.shufensoft.crm.web.controller.mall;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallOrderDo;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallTradeDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallTrade;
import com.shufensoft.crm.biz.service.mall.MallProcess;
import com.shufensoft.crm.biz.service.pointmall.face.IMallTradeService;
import com.shufensoft.crm.biz.service.pointmall.vo.ShippingVo;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/28  
 */
@Controller
public class MallOrderServerController extends BaseController{

    private static IMallTradeService iMallTradeService;

    static{
        iMallTradeService = (IMallTradeService)SpringContextUtil.getBean("iMallTradeService");
    }
    /**
     * to 积分兑换商品订单页
     * */
    @RequestMapping("/mall/product/order")
    @ResponseBody
    public ModelAndView productOrder(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/mall/order/index");
        return mav;
    }

    /**
     * 返回所有订单数据
     * */
     @RequestMapping("/mall/order/list/all")
     @ResponseBody
     public Map<String,Object> getAllOrder(Integer pageNum, Integer length, HttpSession session){
        if(pageNum == null || pageNum == 0){
            pageNum = 1;
//            length = 10;
        }
        Long sellerId = getSellerId(session);
        PageInfo pageInfo = iMallTradeService.findMallOrderDaosByPage(sellerId, 0, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 返回按订单状态分类的订单数据
     * @param type  1待兑换订单, 2未发货订单, 3已发货订单,4已完成订单
     * */
    @RequestMapping("/mall/order/list/status/{type}")
    @ResponseBody
    public Map<String,Object> getAllOrder(Integer pageNum, Integer length,@PathVariable Integer type, HttpSession session){
        if(pageNum == null || pageNum == 0){
            pageNum = 1;
//            length = 10;
        }
        Long sellerId = getSellerId(session);
        PageInfo pageInfo = iMallTradeService.findMallOrderDaosByPage(sellerId, type, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * to 查看积分兑换订单详情页
     * */
    @RequestMapping("/mall/order/detail")
    @ResponseBody
    public ModelAndView orderDetail(Long tid){
        ModelAndView mav = new ModelAndView();
        MallTradeDo mallTradeDo = iMallTradeService.findMallTradeDoCasecadeGoods(tid);
        mav.getModel().put("tradeDo",mallTradeDo);
        mav.setViewName("/mall/order/orderDetail");
        return mav;
    }

    /***
     *  to 单个订单发货
     * */
    @RequestMapping("mall/order/toSigleReceTrade")
     public Map<String,Object> toSingleTradeRece(Long tid, HttpSession session){
        Map<String,Object> map = Maps.newHashMap();
        try {
            Long sellerId = getSellerId(session);
            MallTrade mt = iMallTradeService.findMallTradeByTid(sellerId, tid);
            if(mt != null){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"success");
                map.put("data",mt);
            }else{
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"exception");
        }
        return map;
    }

    /**
     * 处理单个订单的发货
     *
     * @param tradeId  不是tid, 是id
     * */
    @RequestMapping("mall/order/singleReceTrade")
      public Map<String,Object> handleSingleRece(Long tradeId, ShippingVo svo,HttpSession session){
        Long sellerId = getSellerId(session);
         Map<String,Object> map = Maps.newHashMap();
         if(StringUtils.isBlank(svo.getCompany()) || StringUtils.isBlank(svo.getId())){
             map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
             map.put(ERROR_MESSAGE_KEY,"发货失败, 快递公司名称或者快递单号为空");
             return map;
         }
         boolean isSuccess = iMallTradeService.handleSingleMallTradeReceive(tradeId,svo,sellerId);
         if(isSuccess){
             map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
             map.put(ERROR_MESSAGE_KEY,"success");
         } else {
             map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
             map.put(ERROR_MESSAGE_KEY,"fail");
         }
         return map;
     }

    /***
     *  to 多个订单发货
     * */
    @RequestMapping("mall/order/toMultiReceTrade")
    public Map<String,Object> toMultiReceTrade(String tids){
        Map<String,Object> map = Maps.newHashMap();
        try {
            List<MallTradeDo> mallTradeDos = new ArrayList<MallTradeDo>();
            MallTradeDo mallTradeDo = null;
            if(StringUtils.isNotBlank(tids)){
                List<String> idList = new ArrayList<String>();
                if(tids.indexOf(',') >=0){
                    String[] idArr = tids.split(",");
                    for(String s : idArr){
                        if(!idList.contains(s)){
                            idList.add(s);
                        }
                    }
                }else{
                    idList.add(tids);
                }    //去掉重复的tradeId
                if(!CollectionUtils.isEmpty(idList)){
                    for(String id : idList){
                        mallTradeDo = iMallTradeService.findMallTradeDoCasecadeGoods(Long.parseLong(id));
                        if(mallTradeDo != null){
                            mallTradeDos.add(mallTradeDo);
                        }
                    }
                }
            }
            if(!CollectionUtils.isEmpty(mallTradeDos)){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"success");
                map.put("data",mallTradeDos);
            }else{
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"exception");
        }
        return map;
    }

    /**
     * 处理多个订单的发货
     *
     * @param
     * */
    @RequestMapping("mall/order/multipReceTrade")
    public Map<String,Object> handleSingleRece(HttpServletRequest request){
        Map<String,Object> map = Maps.newHashMap();
        String tids = request.getParameter("mTradeIds");
        String company = request.getParameter("sendCompany");
        Map<Long, ShippingVo> paramMap = new HashMap<Long, ShippingVo>();
        ShippingVo sv = null;
        String shipId = "";
        if(StringUtils.isBlank(company)){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"请选择物流公司");
            return map;
        }
        if(tids.indexOf(',') >= 0){
            String[] arr = tids.split(",");
            for(String s : arr){
                shipId = request.getParameter("shipId_" + s);
                if(StringUtils.isBlank(shipId)){
                    map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                    map.put(ERROR_MESSAGE_KEY,"请填写运单号");
                    return map;
                }
                sv = new ShippingVo();
                sv.setCompany(company);
                sv.setId(shipId);
                paramMap.put(Long.parseLong(s), sv);
            }
        }else{
            shipId = request.getParameter("shipId_" + tids);
            sv = new ShippingVo();
            sv.setCompany(company);
            sv.setId(shipId);
            paramMap.put(Long.parseLong(tids), sv);
        }
        Long sellerId = getSellerId(request.getSession());
        boolean isSuccess = iMallTradeService.handleMultipleMallTradeReceive(paramMap,sellerId);
        if(isSuccess){
            map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            map.put(ERROR_MESSAGE_KEY,"success");
        } else {
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"fail");
        }
        return map;
    }

    /**
     * 导出粉丝列表数据
     * */
    @RequestMapping("/mall/orders/exportExcel/{type}")
    public String exportExcel(HttpServletResponse response, @PathVariable Integer type, HttpSession session){
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try{
            String title = "";
            String fileName = "";
            if(type == 0){
                title = "全部订单";
                fileName = "全部订单数据";
            }else if(type == 1){
                title = "待付款订单";
                fileName = "待付款订单数据";
            }else if(type == 2){
                title = "未发货订单";
                fileName = "未发货订单数据";
            }else if(type == 3){
                title = "已发货订单";
                fileName = "已发货订单数据";
            }else if(type == 4){
                title = "已完成订单";
                fileName = "已完成订单数据";
            }
            fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");      //此处 UTF-8 为 GBK 会有乱码
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");
            Long sellerId = getSellerId(session);
            List<MallOrderDo> datas = iMallTradeService.findMallOrderDaos(sellerId, type);

            byte[] excelData = MallProcess.formatMallOrdersDatas(datas,title);
            response.getOutputStream().write(excelData,0,excelData.length);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
