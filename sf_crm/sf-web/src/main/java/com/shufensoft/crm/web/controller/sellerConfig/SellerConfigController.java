package com.shufensoft.crm.web.controller.sellerConfig;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.sellerConfig.SellerConfigService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.vo.SellerConfigInfoVO;
import com.shufensoft.crm.biz.vo.SellerShopVO;
import com.shufensoft.crm.common.utils.*;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>商家配置信息控制层
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/8/22  
 */
@Controller
public class SellerConfigController extends BaseController {

    private static final Logger logger = Logger.getLogger(SellerConfigController.class);

    @Autowired
    private SellerConfigService sellerConfigService;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    private static final String filepath = "seller/";

    private static final String Wx_Secrte_Url = "wxSecrteUrl";

    private static final String Wx_Img_Url = "wxImgUrl";

    private static final String Wx_Qrcode = "wxQrcode";

    /**
     * 商家店铺配置页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/sellerConfig/shop")
    @ResponseBody
    public ModelAndView index(ModelMap modelMap, HttpSession session){
        String tbRedirectUri = PropertyReader.getValue("taobao.redirect.uri");
        String jdRedirectUri = PropertyReader.getValue("jd.redirect.uri");
        String tbOauthUrl = PropertyReader.getValue("taobao.oauth.url");
        String jdOauthUrl = PropertyReader.getValue("jd.oauth.url");

        String jdAppKey = PropertyReader.getValue("crm.jd.app.key");
        String jdAppSecret = PropertyReader.getValue("crm.jd.app.secret");

        modelMap.put("tbRedirectUri",tbRedirectUri);
        modelMap.put("jdRedirectUri",jdRedirectUri);

        modelMap.put("tbOauthUrl",tbOauthUrl);
        modelMap.put("jdOauthUrl",jdOauthUrl);

        modelMap.put("jdAppKey",jdAppKey);
        modelMap.put("jdAppSecret",jdAppSecret);

        Long sellerId = getSellerId(session);
        SellerShopVO sellerShopVO = new SellerShopVO();
        sellerShopVO.setSellerId(sellerId);
        List<SellerShop> shopList = null;
        try {
            shopList = sellerConfigService.showConfig(sellerShopVO);
        }catch (Exception e){
            logger.info("配置查询异常");
        }
        modelMap.put("shopList",shopList);

        return new ModelAndView("/sellerConfig/sellerShop",modelMap);
    }

    /**
     * 保存商家店铺配置信息
     * @param sellerShopVO
     * @param session
     * @return
     */
    @RequestMapping(value = "/sellerConfig/saveShopConfig")
    @PreventDuplicateSubmission(needValidateToken = true)
    @ResponseBody
    public Map<String, Object> saveShop(@Valid SellerShopVO sellerShopVO, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        sellerShopVO.setSellerId(sellerId);

        try {
            if (sellerShopVO.getShopId() == null){
                List<SellerShop> shopList = sellerConfigService.queryShopsBySellerId(sellerId);
                if (shopList != null && shopList.size() >= 4){
                    map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                    map.put(ERROR_MESSAGE_KEY,"对不起，一个商家的店铺数不能超过4个！");
                    return map;
                }

                if (shopList != null){
                    for (SellerShop shop : shopList){
                        if (shop.getShopType().equals(sellerShopVO.getShopType())){
                            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                            map.put(ERROR_MESSAGE_KEY,"对不起！该平台已存在店铺，一个平台只能新建一个店铺！");
                            return map;
                        }
                    }
                }
            }

            if (sellerConfigService.saveOrUpdateShopConfig(sellerShopVO)){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"店铺信息设置成功！");
            }else{
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"对不起，您的店铺信息保存失败！");
            }
        }catch (Exception e){
            logger.info("商家配置保存异常"+e);
        }

        return map;
    }

    /**
     * sellerShop处理
     * @param shopList
     * @return
     */
    private List<SellerShopVO> sellerShopHandle(List<SellerShop> shopList){

        ArrayList<SellerShopVO> sellerShopVOs = new ArrayList<SellerShopVO>();

        try {

            BeanCopierUtils.copyListProperties(shopList , sellerShopVOs , SellerShopVO.class);

        }catch (Exception e){
            logger.error("SellerConfigController.sellerShopHandle",e);
            return null;
        }

        if(CollectionUtils.isEmpty(sellerShopVOs)){

            return null;

        }

        for(SellerShop sellerShop : sellerShopVOs){

            if(DaoConstant.ShopType.JD.equals(sellerShop.getShopType())){

            }

            if(DaoConstant.ShopType.TMALL.equals(sellerShop.getShopType())){

            }

            if(DaoConstant.ShopType.TB.equals(sellerShop.getShopType())){

            }

        }

        return sellerShopVOs;
    }

    /**
     * 删除对应的店铺信息
     * @param shopId
     * @param session
     * @return
     */
    @RequestMapping(value = "/sellerConfig/deleteConfig")
    @ResponseBody
    public Map<String, Object> deleteConfig(Long shopId, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);
        try {
            if (sellerConfigService.deleteConfig(sellerId,shopId)){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"删除成功！");
            }
        }catch (Exception e){
            logger.error("删除店铺配置异常！");
        }

        return map;
    }

    /**
     * 根据店铺id查询对应的店铺信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/sellerConfig/findConfig")
    @ResponseBody
    public Map<String, Object> findConfigById(Long id){
        if (id == null){
            return null;
        }

        Map<String, Object> map = Maps.newHashMap();
        SellerShopVO sellerShopVO = new SellerShopVO();
        sellerShopVO.setId(id);
        List<SellerShop> shopList = sellerConfigService.queryShops(sellerShopVO);

        if (shopList.size() > 0){
            map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            map.put("shopConfig",shopList.get(0));
        }

        return map;
    }

    /**
     * 商家信息配置页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/sellerConfig/sellerInfo")
    @ResponseBody
    public ModelAndView sellerIndex(ModelMap modelMap, HttpSession session){

        Long sellerId = getSellerId(session);
        SellerConfigInfoVO configInfoVO = new SellerConfigInfoVO();
        configInfoVO.setSellerId(sellerId);
        SellerConfigInfo configInfo = sellerConfigService.queryConfigInfo(configInfoVO);
        if (configInfo != null){
            modelMap.put("sellerConfig",configInfo);
        }

        return new ModelAndView("/sellerConfig/sellerConfigInfo",modelMap);
    }

    /**
     * 保存或更新商家配置信息
     * @param multipartRequest
     * @return
     */
    @RequestMapping(value = "/sellerConfig/saveSellerConfig")
    @PreventDuplicateSubmission(needValidateToken = true)
    @ResponseBody
    public Map<String, Object> saveConfigInfo(MultipartHttpServletRequest multipartRequest, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        Long sellerId = getSellerId(session);

        String sellerConfig = multipartRequest.getParameter("sellerConifg");
        SellerConfigInfoVO configInfoVO;
        try {
            configInfoVO = (SellerConfigInfoVO)JSONUtils.parseToObject(sellerConfig,SellerConfigInfoVO.class);
            configInfoVO.setSellerId(sellerId);
        }catch (Exception e){
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"json实体转换异常！");
            return map;
        }

        /**
         * 上传微信证书
         */
        MultipartFile wxSecrteFile = multipartRequest.getFile(Wx_Secrte_Url);
        try {
            if (wxSecrteFile != null){
                String wxSecrtePath = filepath + sellerId + "/apicert/";
                String wxSecrteUrl = FileUtils.uploadFile(null,wxSecrtePath,wxSecrteFile);
                if (StringUtils.isNotBlank(wxSecrteUrl)){
                    configInfoVO.setWxSecrteUrl(wxSecrteUrl);
                }
            }
        }catch (Exception e){
            logger.error("微信证书上传异常");
        }

        /**
         * 上传公众号头像
         */
        MultipartFile wxImgFile = multipartRequest.getFile(Wx_Img_Url);
        try {
            if (wxImgFile != null){
                String wxImgPath = filepath + sellerId + "/";
                String wxImgUrl = FileUtils.uploadFile(wxImgPath,wxImgFile);
                if (StringUtils.isNotBlank(wxImgUrl)){
                    configInfoVO.setWxImgUrl(wxImgUrl);
                }
            }
        }catch (Exception e){
            logger.error("公众号头像上传异常");
        }

        /**
         * 上传微信二维码
         */
        MultipartFile wxQrcodeFile = multipartRequest.getFile(Wx_Qrcode);
        try {
            if (wxQrcodeFile != null){
                String wxQrcodePath = filepath + sellerId + "/";
                String wxQrcode = FileUtils.uploadFile(wxQrcodePath,wxQrcodeFile);
                if (StringUtils.isNotBlank(wxQrcode)){
                    configInfoVO.setWxQrcode(wxQrcode);
                }
            }
        }catch (Exception e){
            logger.error("微信二维码上传异常");
        }

        /**
         * 保存商家相关配置
         */
        try {
            if (sellerConfigService.saveOrUpdateConfigInfo(configInfoVO)){
                map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
                map.put(ERROR_MESSAGE_KEY,"商家配置信息保存成功！");
            }else{
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"对不起，商家配置信息保存失败！");
            }
        }catch (Exception e){
            logger.error("商家配置信息保存异常"+e);
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"商家配置信息保存异常！");
        }

        return map;
    }

    @RequestMapping(value = "/sellerConfig/urlVerify")
    @ResponseBody
    public Map<String, Object> verifyPolySpireUrl(String url){
        Map<String, Object> map = Maps.newHashMap();

        try {
            taoBaoTradeService.getTradeFromPolySpireByDate(url, DateUtils.addDays(new Date(),-7),new Date(),1,20);
            map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            map.put(ERROR_MESSAGE_KEY,"测试成功，该聚石塔url有效");
        }catch (Exception e){
            logger.error("聚石塔url填写错误，调用失败："+e);
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"对不起，您填写的聚石塔url有误，请您重新填写");
        }
        return map;
    }

}
