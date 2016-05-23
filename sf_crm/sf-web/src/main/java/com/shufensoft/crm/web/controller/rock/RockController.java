package com.shufensoft.crm.web.controller.rock;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.rock.vo.RockConfigVO;
import com.shufensoft.crm.biz.service.shake.ShakeMultipleService;
import com.shufensoft.crm.biz.vo.ShakeQueryVO;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/7 上午10:08  
 */

@Controller
public class RockController extends BaseController {

    @Autowired
    private RockService rockService;

    @Autowired
    private ShakeMultipleService shakeMultipleService;

    @RequestMapping("/rock/rockConfig")
    @ResponseBody
    public ModelAndView rockConfig(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Long sellerId = getSellerId(session);
        SellerConfigInfo sellerConfig = SellerConfigCache.get(String.valueOf(sellerId));

        //mav.setViewName("/rock/rockConfig");
        map.put("sellerName", sellerConfig.getSellerName());
        return new ModelAndView("/rock/rockConfig", map);
    }


//    @RequestMapping("/rock/rockDetailConfig")
//    @ResponseBody
//    public ModelAndView rockDetailConfig(String sellerId){
//        Map<String,Object> map =  new HashMap<String, Object>();
//
//        SellerConfigInfo sellerConfig = SellerConfigCache.get(sellerId);
//        map.put("sellerName",sellerConfig.getSellerName());
//
//        、、mav.setViewName("/rock/rockDetailConfig",map);
//        return new ModelAndView("/rock/rockDetailConfig",map);
//    }

    @RequestMapping(value = "/rock/saveRockConfig")
    public
    @ResponseBody
    Map<String, Object> saveRockConfig(RockConfigVO rockConfigVO, HttpSession session) {

        Long sellerId = getSellerId(session);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
        try {
            rockConfigVO.setSellerId(sellerId);
            rockService.saveOrUpdateRockConfig(rockConfigVO);

        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, "保存配置失败。");
            return returnMap;
        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "保存配置规则成功!");

        return returnMap;
    }

    /**
     * 返回摇一摇领取明细页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/rock/rockReceiveList")
    public ModelAndView showList(ModelMap modelMap) {


        return new ModelAndView("/rock/rockReceiveList", modelMap);
    }


    @RequestMapping("/rock/rockQueryDetail")
    public
    @ResponseBody
    Map<String, Object> queryShakeObtainDetail(HttpSession session,ShakeQueryVO shakeQueryVO, Integer pageNum, Integer length) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId = getSellerId(session);

        shakeQueryVO.setSellerId(sellerId);

        PageInfo pageInfo = shakeMultipleService.queryShakeObtain(shakeQueryVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }


    /**
     * 查询摇一摇配置
     *
     * @param rockConfigVO
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping("/rock/rockQueryConfig")
    public
    @ResponseBody
    Map<String, Object> queryShakeObtainDetail(RockConfigVO rockConfigVO, Integer pageNum, Integer length, HttpSession session) {

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        Long sellerId = getSellerId(session);
        rockConfigVO.setSellerId(sellerId);
        PageInfo pageInfo = shakeMultipleService.getShakeConfigQuery(rockConfigVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }


    /**
     * 返回摇一摇查询页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/rock/rockDetail")
    public ModelAndView showDetail(ModelMap modelMap) {
        return new ModelAndView("/rock/rockDetail", modelMap);
    }


    @RequestMapping(value = "/rock/viewDetail")
    public
    @ResponseBody
    Map<String, Object> getConfig(String id) {
        Map<String, Object> map = Maps.newHashMap();
        if (StringUtils.isEmpty(id)) {
            return null;
        }

        RockConfigVO rockConfigVO = shakeMultipleService.getRockConfigVOById(id);

        if (rockConfigVO != null) {
            map.put("rockConfigVO", rockConfigVO);
        }

        return map;
    }


    /**
     * 删除摇一摇
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/rock/delete")
    public
    @ResponseBody
    Map<String, Object> delete(String ids) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        try {
            if (!StringUtils.isNumeric(ids)) {
                returnMap.put(ERROR_MESSAGE_KEY, "后台用户id非法!");
                return returnMap;

            } else {

                shakeMultipleService.deleteRockConfig(Long.valueOf(ids));
                returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                returnMap.put(INFO_KEY, "删除成功!");
            }
        } catch (Exception e) {

        }




        return returnMap;
    }

}
