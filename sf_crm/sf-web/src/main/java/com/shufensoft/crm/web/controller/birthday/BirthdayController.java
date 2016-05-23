package com.shufensoft.crm.web.controller.birthday;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.birthday.BirthdayService;
import com.shufensoft.crm.biz.service.birthday.vo.BirthdayConfigVO;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.common.runner.BizRunner;
import com.shufensoft.crm.common.runner.executor.BizExecutor;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */
@Controller
@RequestMapping("/birthday")
public class BirthdayController extends BaseController {
    @Autowired
    private BirthdayService birthdayService;

    /**
     * 后台创建生日规则主页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/activity/config")
    public ModelAndView birthdayBackConfig(ModelMap modelMap, HttpSession session) {

        Long sellerId = getSellerId(session);

        String endTime = birthdayService.findMaxEndTime();
        modelMap.put("satrtTime", endTime);

        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));
        if (sellerConfigInfo != null) {
            modelMap.put("signName", sellerConfigInfo.getSmsSaleSign());
        }

        return new ModelAndView("/birthday/birthdayBack", modelMap);
    }

    /**
     * 跳转到生日活动列表页面
     *
     * @return
     */
    @RequestMapping(value = "/activity/tolist")
    public ModelAndView birthdayConfigList() {

        return new ModelAndView("/birthday/birthdayConfigList");

    }

    /**
     * 请求生日活动列表数据
     *
     * @param pageNum
     * @param length
     * @return
     */
    @RequestMapping(value = "/activity/list/info")
    @ResponseBody
    public Map<String, Object> getBirthdayConfigList(BirthdayDO birthdayDO, Integer pageNum,
                                                     Integer length, HttpSession session) {
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        /**
         * 更新过期的生日活动状态为"过期"状态
         */
        birthdayService.updateStatusOfExpired();

        /**
         * 因为生日活动的状态默认是unstart,
         * 所以今天的时间如果大于等于开始时间，
         * 小于等于结束时间，就把状态更改为start
         * 如果是stop状态的就不要更新了
         */
        Long sellerId = getSellerId(session);
        birthdayService.initStartStatus(sellerId);

        birthdayDO.setSellerId(sellerId);
        PageInfo pageInfo = birthdayService.findBirthdayList(birthdayDO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 跳转到编辑的页面
     * 编辑页面跟保存页面
     * 用同一个页面
     *
     * @return
     */
    @RequestMapping(value = "/activity/list/toedit")
    @ResponseBody
    public Map<String, Object> toEditBirthdayConfig(Long birthdayActivityId, HttpSession session) {

        Long sellerId = getSellerId(session);

        Map<String, Object> editMap = new HashMap<String, Object>();
        editMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));

        if (sellerConfigInfo != null) {
            editMap.put("signName", sellerConfigInfo.getSmsSaleSign());
        }

        try {
            UserBirthdayConfig ubc = birthdayService.editBirthdayConfigInfo(sellerId, birthdayActivityId);
            String startTime = formateDate(ubc.getStartTime());
            String endTime = formateDate(ubc.getEndTime());
            editMap.put("configInfo", ubc);
            editMap.put("startTimeInfo", startTime);
            editMap.put("endTimeInfo", endTime);
            editMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return editMap;
        }

        return editMap;
    }


    /**
     * 编辑页面 更新后保存
     * @param birthdayConfigVO
     * @param result
     * @return
     */
    @RequestMapping(value = "/edit/birthday/config/update")
    @ResponseBody
    @PreventDuplicateSubmission(needValidateToken = true)
    public Map<String, Object> editPageUpdate(@Valid BirthdayConfigVO birthdayConfigVO, BindingResult result, HttpSession session) {

        final Long sellerId = getSellerId(session);
        birthdayConfigVO.setSellerId(sellerId);

        Map<String, Object> birthdayMap = new HashMap<String, Object>();
        birthdayMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
        /**
         * 判断是不是生日红包,是红包的判断红包数量够不够送
         */
        if (DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO.equals(birthdayConfigVO.getCareType())) {

            /**
             * 校验前端传到后台的红包是否被用过
             */

            if(birthdayService.verifyIsRedPackageSelected(birthdayConfigVO)) {
                birthdayMap.put(INFO_KEY, "该红包已与其他生日活动绑定，请重新选择或新建一个生日红包");
                return birthdayMap;
            }

            /**
             * 先判断红包剩余数量是否大于过生日的用户
             */
            if (!birthdayService.verifysurplus(birthdayConfigVO)) {
                Long  redPackages = birthdayConfigVO.getSurplus();
                int  fans = birthdayService.activityPeoples(birthdayConfigVO);

                if(DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget())) {
                    fans = birthdayService.manualSelectPersons(birthdayConfigVO);
                    birthdayMap.put(INFO_KEY, "生日红包数量不足，粉丝人数:"+fans+"，红包数量:"+redPackages+"");
                    return birthdayMap;
                }

                birthdayMap.put(INFO_KEY, "生日红包数量不足，粉丝人数:"+fans+"，红包数量:"+redPackages+"");
                return birthdayMap;
            }

        }



        /**
         * 异步更新活动信息
         */
        final BirthdayConfigVO birthdayConfigVOTmp = birthdayConfigVO;

        new BizRunner(new BizExecutor() {

            @Override
            public Boolean execute() {

                SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(Long.toString(sellerId));

                DBContextHolder.setDataSourceKey(Long.toString(sellerConfigInfo.getDatasourceId()));

                try {
                    birthdayService.editPageUpdateInfo(birthdayConfigVOTmp);
                } catch(Exception e) {

                    return false;
                }
                return true;
            }
        }).start();

        /**
         * 保存设置的信息
         */
        birthdayMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        birthdayMap.put(INFO_KEY, "更新成功");

        return birthdayMap;

    }




    /**
     * 后台生日规则ajax保存请求
     *
     * @param birthdayConfigVO
     * @param result
     * @return
     */
    @RequestMapping("/save/info")
    @ResponseBody
    @PreventDuplicateSubmission(needValidateToken = true)
    public Map<String, Object> saveBirthdayConfigInfo(@Valid BirthdayConfigVO birthdayConfigVO, BindingResult result, HttpSession session) {

        final Long sellerId = getSellerId(session);
        birthdayConfigVO.setSellerId(sellerId);

        Map<String, Object> birthdayMap = new HashMap<String, Object>();
        birthdayMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        /**
         * 判断是不是生日红包,是红包的判断红包数量够不够送
         */
        if (DaoConstant.BirthdayConfig.BIRTHDAY_HONGBAO.equals(birthdayConfigVO.getCareType())) {

            /**
             * 校验前端传到后台的红包是否被用过
             */

            if(birthdayService.verifyIsRedPackageSelected(birthdayConfigVO)) {
                birthdayMap.put(INFO_KEY, "该红包已与其他生日活动绑定，请重新选择或新建一个生日红包");
                return birthdayMap;
            }


            /**
             * 先判断红包剩余数量是否大于过生日的用户
             */

            if (!birthdayService.verifysurplus(birthdayConfigVO)) {
                Long  redPackages = birthdayConfigVO.getSurplus();
                int  fans = birthdayService.activityPeoples(birthdayConfigVO);

                if(DaoConstant.BirthdayConfig.SEND_MANUAL.equals(birthdayConfigVO.getSendTarget())) {
                    fans = birthdayService.manualSelectPersons(birthdayConfigVO);
                    birthdayMap.put(INFO_KEY, "生日红包数量不足，粉丝人数:"+fans+"，红包数量:"+redPackages+"");
                    return birthdayMap;
                }

                birthdayMap.put(INFO_KEY, "生日红包数量不足，粉丝人数:" + fans + "，红包数量:" +redPackages+"");
                return birthdayMap;
            }

        }

        /**
         * 判断是不是生日礼物，是生日礼物判断生日礼物数量够不够
         */
        if(DaoConstant.BirthdayConfig.BIRTHDAY_GIFTS.equals(birthdayConfigVO.getCareType())) {
            Long fans = birthdayService.verifyGiftsGoodsNum(birthdayConfigVO);
            if(fans != 0L) {

                birthdayMap.put(INFO_KEY, "生日礼物数量不足，粉丝人数:" + fans + "，礼物数量:"
                        + birthdayConfigVO.getGoodsNum() + "");
                return birthdayMap;

            }
        }

        /**
         * 校验前端传过来的日期时间
         */
        String verifyStr = birthdayService.verifyFrontData(birthdayConfigVO);
        if(StringUtils.isNotBlank(verifyStr)) {
            birthdayMap.put(INFO_KEY, verifyStr);
            return birthdayMap;
        }




        /**
         * 异步初始化活动信息
         */
        final BirthdayConfigVO birthdayConfigVOTmp = birthdayConfigVO;

        new BizRunner(new BizExecutor() {

            @Override
            public Boolean execute() {

                SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(Long.toString(sellerId));

                DBContextHolder.setDataSourceKey(Long.toString(sellerConfigInfo.getDatasourceId()));

                try {
                    birthdayService.saveInfo(birthdayConfigVOTmp);

                } catch (Exception e) {

                    return false;

                }

                return true;
            }

        }).start();

        /**
         * 保存设置的信息
         */
        birthdayMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        birthdayMap.put(INFO_KEY, "新建生日活动成功");

        return birthdayMap;
    }


    /**
     * 生日编辑页面 赠送对象进行手动选择
     * 生日列表编辑页面 赠送对象手动选择
     * @param
     * @return
     */
    @RequestMapping(value = "/manual/operation")
    @ResponseBody
    public Map<String, Object> manualOperation(BirthdayConfigVO birthdayConfigVO, Integer pageNum,
                                               Integer length, HttpSession session) {
        Long sellerId = getSellerId(session);
        birthdayConfigVO.setSellerId(sellerId);

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        PageInfo pageInfo = birthdayService.findManualFans(birthdayConfigVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }

        return datas;
    }

    /**
     * 从积分商城的商品表里查询到能够作为
     * 生日礼物的商品
     *
     * @return
     */
    @RequestMapping(value = "/select/gifts")
    @ResponseBody
    public Map<String, Object> selectBirthdayGifts(BirthdayConfigVO birthdayConfigVO, Integer pageNum,
                                                                    Integer length, HttpSession session) {

        Long sellerId = getSellerId(session);
        birthdayConfigVO.setSellerId(sellerId);

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        PageInfo pageInfo = birthdayService.findBirthdayGifts(birthdayConfigVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    /**
     * 后台生日列表，活动改变状态
     *
     * @param birthdayId
     * @param status
     * @return
     */
    @RequestMapping(value = "/activity/change/status")
    @ResponseBody
    public Map<String, Object> clickPause(Long birthdayId, String status) {
        Map<String, Object> datas = Maps.newHashMap();
        datas.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
        try {
            String resultStatus = birthdayService.updateSatausByBirthdayId(birthdayId, status);
            datas.put(ERROR_CODE_KEY, BaseController.ErrorCode.SUCCESS);
            datas.put(INFO_KEY, "修改成功");
            datas.put("resultStatus", resultStatus);
        } catch (Exception e) {
            datas.put(INFO_KEY, "修改失败");
            datas.put("resultStatus", null);
        }

        return datas;
    }

    /**
     * 分页获取关于生日的红包活动列表
     *
     * @param hbPoolVO
     * @param pageNum     分页起始页
     * @param length      分页长度
     * @return
     */
    @RequestMapping("/hbPool/datas")
    @ResponseBody
    public Map<String, Object> datas(HBPoolVO hbPoolVO, Integer pageNum, Integer length, HttpSession session) {

        Long sellerId = getSellerId(session);
        hbPoolVO.setSellerId(sellerId);

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }

        PageInfo pageInfo = birthdayService.queryHBPoolsByType(hbPoolVO, pageNum, length);
        Map<String, Object> datas = Maps.newHashMap();

        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }

        return datas;
    }

    /**
     * 生日活动列表中明细
     *
     * @param birthdayId
     * @return
     */
    @RequestMapping(value = "/activity/details/list")
    @ResponseBody
    public Map<String, Object> birthdayActivityDetails(Long birthdayId, Integer pageNum, Integer length,HttpSession session) {

        Long sellerId = getSellerId(session);

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        Map<String, Object> datas = Maps.newHashMap();
        
        PageInfo pageInfo = birthdayService.findBirthdayDetails(sellerId, birthdayId, pageNum, length);
        if (pageInfo != null) {
            datas.put("recordsTotal", pageInfo.getTotal());
            datas.put("recordsFiltered", pageInfo.getTotal());
            datas.put("data", pageInfo.getList());
        }
        return datas;
    }

    //格式化时间
    private String formateDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}
