package com.shufensoft.crm.web.controller.shoppingHongbao;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.activity.Activity;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityGoods;
import com.shufensoft.crm.biz.service.activity.ActivityService;
import com.shufensoft.crm.biz.service.activity.ActivityShopHongBaoServcie;
import com.shufensoft.crm.biz.service.system.SysTokenService;
import com.shufensoft.crm.common.utils.CommonUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.FileUtils;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.biz.vo.ActivityGoodsVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/10/8  
 */
@Controller
@RequestMapping("/shophb")
public class ShoppingHongbaoController extends BaseController{

    private Logger logger = Logger.getLogger(ShoppingHongbaoController.class);

    @Autowired
    private SysTokenService sysTokenService;

    @Autowired
    private ActivityShopHongBaoServcie activityShopHongBaoServcie;

    @Autowired
    private ActivityService activityService;

    /**
     * to 创建购物红包活动页面
     * */
    @RequestMapping("/shophbAct")
    public ModelAndView toShoppingHongbaoActivity(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/shoppingHongbao/shophbAct");
        return mav;
    }

    /**
     * 创建购物红包活动
     * */
    @RequestMapping("/addOrUpdateAct")
    public Map<String,Object> addShoppingHongbaoActivity(HttpServletRequest request, HttpSession session){
        Map<String,Object> returnMap = Maps.newHashMap();
        String token = request.getParameter("token");
        if(!sysTokenService.validateToken(token)){
            returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"重复提交，无效");
            return returnMap;
        }
            Activity activity = null;
            ActivityGoods activityGoods = null;
        try{
            Long sellerId = getSellerId(session);
            DefaultMultipartHttpServletRequest multipartRequest = (DefaultMultipartHttpServletRequest) request;
            String goodsData = multipartRequest.getParameter("goodsData");
            Map<String,Object> resultMap = (Map<String,Object>) JSONUtils.parseToObject(goodsData, Map.class);
            if(!CollectionUtils.isEmpty(resultMap)){
                activity = new Activity();
                activityGoods = new ActivityGoods();
                activity.setActivityName((String)resultMap.get("activityName"));
                activity.setBeginDate(DateUtil.strToDate((String) resultMap.get("beginDate")));
                activity.setEndDate(DateUtil.strToDate((String)resultMap.get("endDate")));
                activity.setSellerId(sellerId);
                activity.setActivityType(DaoConstant.ActivityType.ACTIVITY_SHOPPING_HONGBAO);
                activity.setStatus(DaoConstant.ActivityStatus.ACTIVITY_START);
                activity.setActivityDesc(CommonUtil.unescape((String)resultMap.get("activityDesc")));
                String activityIdStr = String.valueOf(resultMap.get("activityId"));
                if(StringUtils.isNotBlank(activityIdStr) && !"null".equalsIgnoreCase(activityIdStr)){
                    Long activityId = Long.parseLong(activityIdStr);
                    activity.setActivityId(activityId);
                }

                activityGoods.setSellerId(sellerId);
                activityGoods.setGoodsName((String)resultMap.get("goodsName"));
                String link = (String)resultMap.get("goodsLink");
                activityGoods.setGoodsLink(link);
                String priceStr = (String)resultMap.get("goodsPrice");
                Double dPrice = Double.parseDouble(priceStr) * 100;
                activityGoods.setGoodsPrice(dPrice.intValue());
                String goodsSource = (String)resultMap.get("goodsSource");
                activityGoods.setGoodsSource(goodsSource);
                activityGoods.setShopName((String)resultMap.get("shopName"));
                activityGoods.setHbPoolId((String)resultMap.get("hbPoolId"));
                activityGoods.setGoodsQuantity(Integer.parseInt(String.valueOf(resultMap.get("goodsQuantity"))));
                activityGoods.setHbcashAmount(Integer.parseInt(String.valueOf(resultMap.get("hbcashAmount"))));
                activityGoods.setApplyRange((String)resultMap.get("applyRange"));
                activityGoods.setReleaseTime(Integer.parseInt(String.valueOf(resultMap.get("releaseTime"))));
                activityGoods.setCashbackType("hongbao");
                String activityGoodsIdStr = String.valueOf(resultMap.get("activityGoodsId"));
                if(StringUtils.isNotBlank(activityGoodsIdStr) && !"null".equalsIgnoreCase(activityGoodsIdStr)){
                    Long activityGoodsId = Long.parseLong(activityGoodsIdStr);
                    activityGoods.setActivityGoodsId(activityGoodsId);
                }

                //从商品链接中提取商品ID
                String goodsId = getGoodsIdFromLink(link, goodsSource);
                if(goodsId != null){
                    activityGoods.setGoodsId(goodsId);
                }else{
                    returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                    returnMap.put(ERROR_MESSAGE_KEY,"请提供京东, 天猫, 淘宝正确的商品详情链接");
                    return returnMap;
                }

                //处理活动图片
                String fileNames = String.valueOf(resultMap.get("fileNames"));
                if(StringUtils.isNotBlank(fileNames)){
                    String sp = "upload/photo";
                    String savePath = request.getSession().getServletContext().getRealPath(sp);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    String ymd = sdf.format(new Date());
                    String realSavePath = savePath + File.separator + ymd + File.separator + "activity" + File.separator + sellerId + File.separator;
                    String[] fileNameArr = fileNames.split("\\|");
                    for(String fileName : fileNameArr){
                        MultipartFile multipartFile = multipartRequest.getFile(fileName);
                        if(multipartFile != null){
                            long size = multipartFile.getSize();
                            if (size > 0) {
                                if (multipartFile.getContentType() != null && !multipartFile.getContentType().startsWith("image")) {
                                    returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                                    returnMap.put(ERROR_MESSAGE_KEY,"请选择图片类文件,支持jpg,jpeg,png,bmp,gif");
                                    return returnMap;
                                }
                                if (size > 1024 * 1024) {
                                    returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                                    returnMap.put(ERROR_MESSAGE_KEY,"图片不超过1M");
                                    return returnMap;
                                }
                                String url = FileUtils.saveFile(multipartFile, realSavePath);
                                if("goodsUrl".equals(fileName)){
                                    activityGoods.setGoodsUrl(sp + File.separator + ymd + File.separator + "activity" + File.separator + sellerId + File.separator + url);
                                }else if("activityPhoto".equals(fileName)){
                                    activity.setActivityPhotoUrl(sp + File.separator + ymd + File.separator + "activity" + File.separator + sellerId + File.separator + url);
                                }
                            }
                        }
                    }
                }
                activityShopHongBaoServcie.saveOrUpdateHongbaoActivity(activity, activityGoods);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY,"发生异常");
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.SUCCESS);
        if(activity.getActivityId() != null){
            returnMap.put(ERROR_MESSAGE_KEY, "修改成功");
        }else{
            returnMap.put(ERROR_MESSAGE_KEY, "创建成功");
        }
        return returnMap;
    }

    /**
     * 各平台商品详情链接如下:
     * 京东: http://item.jd.com/1856581.html
     * 淘宝: https://item.taobao.com/item.htm?spm=a230r.1.14.23.PGoWtJ&id=15014570578&ns=1&abbucket=8#detail
     * 天猫: https://detail.tmall.com/item.htm?id=38974637473&ali_refid=a3_430583_1006:1109351510:N:%E6%A3%89%E6%8B%96%E9%9E%8B:f901e151b12ab6628c44029ead9ba6c0&ali_trackid=1_f901e151b12ab6628c44029ead9ba6c0&spm=a230r.1.14.1.PGoWtJ
     *
     * */
    private String getGoodsIdFromLink(String link, String goodsSource){
        String id = null;
        if(DaoConstant.UserSource.JD.equals(goodsSource)){
            id = link.substring(link.lastIndexOf('/') + 1, link.lastIndexOf('.'));
        }else if(DaoConstant.UserSource.TMALL.equals(goodsSource)){
            String temp = link.substring(link.indexOf('?') + 1);
            String[] arr1 = temp.split("&");
            if(arr1!= null && arr1.length > 0){
                String temp1 = arr1[0];
                id = temp1.split("=")[1];
            }
        }else if(DaoConstant.UserSource.TB.equals(goodsSource)){
            String temp = link.substring(link.indexOf('?') + 1);
            String[] arr1 = temp.split("&");
            if(arr1!= null && arr1.length > 0){
                String temp1 = arr1[1];
                id = temp1.split("=")[1];
            }
        }
        return id;
    }

    /**
     * to 购物红包活动商品列表
     * */
    @RequestMapping("/shophbActList")
    public ModelAndView activityGoodsList(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/shoppingHongbao/activityGoodsList");
        return mav;
    }

    /**
     *  购物红包活动商品列表数据 加载
     * */
     @RequestMapping("/shophbActList/datas")
     public Map<String,Object> loadActivityGoodsData(ActivityGoodsVo activityGoodsVo, Integer start, Integer length, HttpSession session){
         if(start == null || start == 0){
             start = 1;
         }
         Long sellerId = getSellerId(session);
         activityGoodsVo.setSellerId(sellerId);
         PageInfo pageInfo = activityShopHongBaoServcie.queryActivityGoodsDatasByPage(activityGoodsVo, start, length);
         Map<String, Object> datas = Maps.newHashMap();
         if (pageInfo != null) {
             datas.put("recordsTotal", pageInfo.getTotal());
             datas.put("recordsFiltered", pageInfo.getTotal());
             datas.put("data", pageInfo.getList());
         }
         return datas;
    }

    /**
     *  to 编辑购物红包活动
     * */
     @RequestMapping("/toEditor")
     public ModelAndView toEidorShopHbAct(Long activityGoodsId, HttpSession session){
         ModelAndView mav = new ModelAndView();
         Long sellerId = getSellerId(session);
         ActivityGoods activityGoods = activityShopHongBaoServcie.getActivityGoodsByActivityId(sellerId,activityGoodsId);
         Activity activity = activityService.getActivityByActivityId(sellerId,activityGoods.getActivityId());
         mav.getModel().put("activity", activity);
         mav.getModel().put("activityGoods",activityGoods);
         mav.setViewName("/shoppingHongbao/editShophbAct");
         return mav;
    }

    /**
     *
     * */
    @RequestMapping("/delete")
     public Map<String,Object> delete(Long activityGoodsId, HttpSession session){
        Map<String, Object> map = new HashMap<String,Object>();
        Long sellerId = getSellerId(session);
        try {
            int deleteNum = activityShopHongBaoServcie.delete(sellerId, activityGoodsId);
            if(deleteNum > 0){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"删除成功");
            }else{
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"发生异常,删除失败");
        }
        return map;
    }




}