package com.shufensoft.crm.web.controller.seller;

import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.service.seller.SellerMobileMenuService;
import com.shufensoft.crm.common.utils.FileUtils;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.enums.BizImgDirEnums;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>手机端菜单配置</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/3  
 */
@Controller
public class SellerMobileMenuController extends BaseController {
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SellerMobileMenuController.class);


    @Resource(name="sellerMobileMenuService")
    private SellerMobileMenuService sellerMobileMenuService;


    /**
     * 手机端菜单配置
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/sellerMobileMenu/get")
    @ResponseBody
    public ModelAndView getSellerMobileMenu(ModelMap modelMap) {
        return new ModelAndView("/seller/SellerMobileMenu", modelMap);
    }


    /**
     * 手机端广告配置
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/sellerMobileAdvertisement/get")
    @ResponseBody
    public ModelAndView getSellerMobileAdvertisement(ModelMap modelMap) {
        return new ModelAndView("/seller/SellerMobileAdvertisement", modelMap);
    }

    /**
     * 保存更新手机端菜单广告配置
     * @param multipartRequest
     * @return
     */
    @RequestMapping("/sellerMobileMenu/saveOrUpdate")
    //  @PreventDuplicateSubmission(needValidateToken = true)
    public
    @ResponseBody
   Map<String, Object> saveOrUpdate( MultipartHttpServletRequest multipartRequest,HttpSession httpSession) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY,ErrorCode.ERROR);
        Long sellerId=getSellerId(httpSession);
       String SellerMobileMenus=multipartRequest.getParameter("SellerMobileMenus");
        List<SellerMobileMenu>  SellerMobileMenuList=new ArrayList<SellerMobileMenu>();

        try {
             SellerMobileMenuList= ( List<SellerMobileMenu>) JSONUtils.parseToList(SellerMobileMenus,SellerMobileMenu.class);
        }catch (Exception e){
            returnMap.put(ERROR_MESSAGE_KEY,e.getMessage());
            return returnMap;
        }

         for(SellerMobileMenu sellerMobileMenu:SellerMobileMenuList){

           if("advertisement".equals(sellerMobileMenu.getFunctionType())){
               // 获得文件：
               MultipartFile file = multipartRequest.getFile(sellerMobileMenu.getName());

               if(file!=null){

                   try {
                    String shotPath = BizImgDirEnums.MEMBER_DIR.getValue() + sellerId + "/";
                     String url=  FileUtils.uploadFile(shotPath,file);
                       if(!StringUtils.isBlank(url))
                           sellerMobileMenu.setUrl(url);

                   } catch (Exception e){
                       returnMap.put(ERROR_MESSAGE_KEY,"文件上传失败");
                       e.printStackTrace();
                       return returnMap;
                   }

               }
          }
       }

        try{
            sellerMobileMenuService.saveOrUpdate(SellerMobileMenuList,sellerId);
        }catch (Exception e){
            returnMap.put(ERROR_MESSAGE_KEY,e.getMessage());
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY,"新建配置规则成功!");

        return returnMap;
    }


    /**
     * 获取商户菜单广告详细信息
     * @param functionType
     * @return
     */
    @RequestMapping(value = "/sellerMobileMenu/detail")
    public Object detail( String  functionType,HttpSession httpSession) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        Long sellerId=getSellerId(httpSession);
        List<SellerMobileMenu> list=new ArrayList<SellerMobileMenu>();
        SellerMobileMenu sellerMobileMenu=new SellerMobileMenu();
        sellerMobileMenu.setFunctionType(functionType);

        try{
              list=    sellerMobileMenuService.getSellerMobileMenus(sellerMobileMenu,sellerId);
        }catch (Exception e){
            returnMap.put(ERROR_MESSAGE_KEY,e.getMessage());
            return returnMap;
        }
        ModelMap modelMap=new ModelMap();
        modelMap.put("sellerMobileMenus", list);
        return modelMap;
    }

}
