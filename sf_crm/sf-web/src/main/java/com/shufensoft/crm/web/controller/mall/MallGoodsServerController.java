package com.shufensoft.crm.web.controller.mall;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.defined.pointMall.MallGoodsDo;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallCategory;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsSku;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallProperty;
import com.shufensoft.crm.biz.service.mall.MallProcess;
import com.shufensoft.crm.biz.service.pointmall.face.IMallCatPropService;
import com.shufensoft.crm.biz.service.pointmall.face.MallGoodsService;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsVo;
import com.shufensoft.crm.biz.service.system.SysTokenService;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lin on 2015/6/16.
 */

@Controller
public class MallGoodsServerController extends BaseController{

    private static Logger log = Logger.getLogger(MallGoodsServerController.class);

    @Resource(name="mallCategoryService")
    private IMallCatPropService mallCatPropService;

    @Resource(name="mallGoodsService")
    private MallGoodsService mallGoodsService;

    @Autowired
    private SysTokenService sysTokenService;


    /**
     * to 创建积分兑换商品页
     * */
    @RequestMapping("/mall/setProduct")
    @ResponseBody
    public ModelAndView toCreateMallProduct(HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long sellerId = getSellerId(session);
        List<MallCategory> mallCategoryList = mallCatPropService.createCatgoryTree(sellerId);
        mav.setViewName("/mall/goods/setMallProduct");
        mav.getModel().put("categoryList",mallCategoryList);
        return mav;
    }

    /**
     * to 积分兑换商品列表页
     * */
    @RequestMapping("/mall/product/list")
    @ResponseBody
    public ModelAndView productList(HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long sellerId = getSellerId(session);
        List<MallCategory> mallCategoryList = mallCatPropService.createCatgoryTree(sellerId);
        mav.setViewName("/mall/goods/productList");
        mav.getModel().put("categoryList",mallCategoryList);
        return mav;
    }

    /**
     * 根据选择的商品分类 变换属性设置页面内容
     *
     * */
    @RequestMapping("/mall/getPropertyTable")
    @ResponseBody
     public ModelAndView propertyByCategory(String cid, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long sellerId = getSellerId(session);
//        System.out.println(cid);
        if(StringUtils.isBlank(cid)){
            return null;
        }
        List<MallProperty> mallProperties = mallCatPropService.getSalePropertiesAndValues(sellerId, Long.parseLong(cid));
        mav.getModel().put("properties",mallProperties);
        mav.setViewName("/mall/goods/propertyTable");
        return mav;
     }

    /**
     * to 商品创建提交后的提示页
     * */
     @RequestMapping("/mall/prompt")
     @ResponseBody
     public ModelAndView prompt(String code, String msg, String toUrl){
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("code",code);
        mav.getModel().put("msg",msg);
        mav.getModel().put("toUrl",toUrl);
        mav.setViewName("/mall/prompt");
        mav.getModel().put("code",code);
        return mav;
    }

    /**
     *  分页获取积分兑换商品列表    供ajax调用
     * */
    @RequestMapping("/mall/goods/list")
    @ResponseBody
    public Map<String, Object> getGoodsList(MallGoodsDo mallGoodsDo, Integer pageNum, Integer length,HttpSession session){
        if(pageNum == null || pageNum == 0){
            pageNum = 1;
//            length = 10;
        }
        Long sellerId = getSellerId(session);
        mallGoodsDo.setSellerId(sellerId);
        if(StringUtils.isNotBlank(mallGoodsDo.getTitle())){
            mallGoodsDo.setTitle("%" + mallGoodsDo.getTitle() + "%");
        }
        if(StringUtils.isNotBlank(mallGoodsDo.getEndDate())){
            mallGoodsDo.setEndDate(mallGoodsDo.getEndDate() + " 23:59:59");
        }
        PageInfo pageInfo = mallGoodsService.findMallGoodsByMallGoodsDoByPage(mallGoodsDo,pageNum,length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * to 编辑积分兑换商品页面
     * */
    @RequestMapping("/mall/goods/toEidt")
    public ModelAndView toEditGoods(Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MallGoods mallGoods = mallGoodsService.getMallGoodsById(id);
        String detailUrl = mallGoods.getDetailUrl();
        String goodsDetail = MallProcess.parseHtml(detailUrl, request);                   //根据路径获取商品详情页的内容信息
        mallGoods.setGoodsDetail(goodsDetail);
//        List<MallGoodsSku> mallGoodsSkus = mallGoodsService.queryGoodsSku(mallGoods.getSellerId(),mallGoods.getGoodsId());
//        List<SkuPropValue> skuPropValues = MallProcess.getSkuPropValues(mallGoodsSkus);
//        mallGoods.setSkuPropValues(skuPropValues);

        List<MallCategory> mallCategoryList = mallCatPropService.createCatgoryTree(mallGoods.getSellerId());
        mav.getModel().put("categoryList",mallCategoryList);
        mav.setViewName("/mall/goods/toEditGoods");
        mav.getModel().put("mallGoods",mallGoods);
        mav.getModel().put("sellerId", mallGoods.getSellerId());
        return mav;
    }

    /**
     *  根据mallGoodsId 回填 sku 的属性页面
     * */
    @RequestMapping("mall/fillProperty")
    @ResponseBody
    public ModelAndView fillProperty(Long gid,HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long sellerId = getSellerId(session);
        List<MallProperty> mallProperties = mallCatPropService.getSalePropertiesAndValuesByGoodsId(sellerId, gid);
        List<MallGoodsSku> skus = mallGoodsService.queryGoodsSku(sellerId, gid);
        mav.getModel().put("skus",skus);
        mav.getModel().put("properties",mallProperties);
//        mav.setViewName("/mall/propertyTable");
        mav.setViewName("/mall/goods/fillProperty");
        return mav;
    }

    /**
     * to 商品编辑提交后的提示页
     * */
    @RequestMapping("/mall/goods/prompt_edit")
    @ResponseBody
    public ModelAndView promptForEdit(String code, String msg, String toUrl){
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("code",code);
        mav.getModel().put("msg",msg);
        mav.getModel().put("toUrl",toUrl);
        mav.setViewName("/mall/goods/prompt_edit");
        return mav;
    }

    /**
     *  删除一个商品
     * */
     @RequestMapping("/mall/goods/delete")
     public Map<String, Object> delGoods(Long goodsId, HttpSession session){
        Map<String, Object> map = new HashMap<String,Object>();
         Long sellerId = getSellerId(session);
         try {
             int deleteNum = mallGoodsService.delete(sellerId, goodsId);
             if(deleteNum > 0){
                 map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                 map.put(ERROR_MESSAGE_KEY,"删除成功");
             }else{
                 map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                 map.put(ERROR_MESSAGE_KEY,"删除失败");
             }
         }catch(Exception e){
             e.printStackTrace();
             log.error(e.getMessage(),e);
             map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
             map.put(ERROR_MESSAGE_KEY,"发生异常,删除失败");
         }
        return map;
    }

    /**
     *  上下架一个商品
     *
     * */
     @RequestMapping("/mall/goods/upOrDownGoods")
     public Map<String,Object> upOrDownGoods(Long goodsId, int status, HttpSession session){
         Map<String, Object> map = new HashMap<String,Object>();
         Long sellerId = getSellerId(session);
         try {
             int updateNum = 0;
             if(status == 0){    //下架
                 updateNum = mallGoodsService.delist(sellerId, goodsId);
             }else if(status == 1){      //上架
                 updateNum = mallGoodsService.list(sellerId, goodsId);
             }
             if(updateNum > 0){
                 map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                 map.put(ERROR_MESSAGE_KEY,"操作成功");
             }else{
                 map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                 map.put(ERROR_MESSAGE_KEY,"操作失败");
             }
         }catch(Exception e){
             e.printStackTrace();
             log.error(e.getMessage(),e);
             map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
             map.put(ERROR_MESSAGE_KEY,"发生异常,操作失败");
         }
         return map;
    }

    @RequestMapping("/mall/test")
    public ModelAndView test(){

        ModelAndView mav = new ModelAndView();

        mav.setViewName("/mall/test");
        return mav;
    }


    /**
     * 处理创建积分兑换商品的提交, 适应直接表单提交
     * */
    @RequestMapping(value="/mall/createGoods", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView handleCreateGoods(HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long sellerId = getSellerId(session);
        Map<Boolean,Object> resultMap = MallProcess.parseMallGoods1(request,sellerId);
        Object result = resultMap.get(true);
        if(result != null){
            GoodsVo goodsVo = (GoodsVo)result;
        }else{
            result = resultMap.get(false);
        }
        System.out.println("result==" + result);
        List<MallCategory> mallCategoryList = mallCatPropService.createCatgoryTree(sellerId);
        mav.setViewName("/mall/goods/setMallProduct");
        mav.getModel().put("categoryList", mallCategoryList);
        return mav;
    }





    /**
     * 处理商品图片的上传, 对应 zyUpload 插件的图片上传
     * */
    @RequestMapping("/mall/goods/uploadGoodsImgs")
    public Map<String,Object> uploadGoodsImgs(HttpServletRequest request){
        Map<String,Object> returnMap = Maps.newHashMap();
        Map<Boolean,String> resultMap = MallProcess.handleGoodsImg(request);     //上传图片的处理
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String key = "goodsImg_" + sessionId;
        Object obj = session.getAttribute(key);
        String url = resultMap.get(true);
        if(url != null){
            if(obj == null){
                session.setAttribute(key, url);
            }else{
                String preUrl = (String)obj;
                url += ("," + preUrl);
                session.removeAttribute(key);
                session.setAttribute(key, url);
            }
            returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"操作成功");
        }else{
            returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY,resultMap.get(false));
        }
        return returnMap;
    }

    /**
     * 处理创建积分兑换商品的提交, 适应ajaxFileUpload 插件的提交
     * */
    @RequestMapping(value="/mall/goods/ajaxCreateGoods")
    @ResponseBody
    public Map<String,Object> handleAjaxCreateGoods(HttpServletRequest request, HttpSession session){
        Map<String,Object> returnMap = Maps.newHashMap();
        String token = request.getParameter("token");
        if(!sysTokenService.validateToken(token)){
            returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"重复提交，无效");
            return returnMap;
        }
        Map<Boolean,Object> resultMap = MallProcess.parseGoodsForAjax(request, "create", getSellerId(session));
        Long sellerId = getSellerId(session);
        Object result = resultMap.get(true);
        if(result != null){
            GoodsVo goodsVo = (GoodsVo)result;
            if(goodsVo != null){
                mallGoodsService.create(sellerId,goodsVo);
            }
            returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"商品创建成功");
            return returnMap;
        }else{
            result = resultMap.get(false);
            returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, result);
            return returnMap;
        }

    }

    /**
     * 处理编辑积分兑换商品的提交, 适应ajaxFileUpload 插件的提交
     * */
    @RequestMapping(value="/mall/goods/ajaxEditorGoods")
    @ResponseBody
    public Map<String,Object> handleAjaxEditorGoods(HttpServletRequest request){
        Map<String,Object> returnMap = Maps.newHashMap();
        if(!sysTokenService.validateToken(request.getParameter("token"))){
            returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"重复提交，无效");
            return returnMap;
        }
        Long sellerId = getSellerId(request.getSession());
        Map<Boolean,Object> resultMap = MallProcess.parseGoodsForAjax(request, "editor", sellerId);
        Object result = resultMap.get(true);
        if(result != null){
            GoodsVo goodsVo = (GoodsVo)result;
            if(goodsVo != null){
                mallGoodsService.updateGoods(goodsVo);
            }
            returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY,"商品编辑成功");
            return returnMap;
        }else{
            result = resultMap.get(false);
            returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, result);
            return returnMap;
        }

    }



}