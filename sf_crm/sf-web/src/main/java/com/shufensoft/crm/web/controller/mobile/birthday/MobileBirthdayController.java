package com.shufensoft.crm.web.controller.mobile.birthday;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.birthday.MobileBirthdayService;
import com.shufensoft.crm.biz.service.present.PresentService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/19  
 */
@Controller
@RequestMapping(value="/mobile")
public class MobileBirthdayController extends BaseController{
    @Autowired
    private MobileBirthdayService mobileBirthdayService;
    @Autowired
    private PresentService presentService;
    /**
     * 手机端 跳转到我的生日
     * @param userId
     * @param sellerId
     * @return
     */
    @RequestMapping(value="/birthday")
    public ModelAndView showBirthdayView(Long sellerId, Long userId) {

        ModelMap modelMap = new ModelMap();
        UserVO uv = mobileBirthdayService.findUserMess(sellerId, userId);
        modelMap.put("uv", uv);

        if(StringUtils.isNotEmpty(uv.getMobile()) && uv.getBirthday() != null) {

            List<BirthdayDO> allActivityList = mobileBirthdayService.findFrontBirthdayData(sellerId, userId);

            /**
             * 判断今天的时间大于生日活动结束时间的话，就把生日活动的状态更新为over
             */
            mobileBirthdayService.initOverStatus(allActivityList);

            /**
             * 因为生日活动的状态默认是unstart,
             * 所以今天的时间如果大于等于开始时间，
             * 小于等于结束时间，就把状态更改为start
             * 如果是stop的就不要更新状态
             */
            mobileBirthdayService.initStartStatus(allActivityList);


            /**
             *  判断今天(月日)是不是大于等于生日(月日),大于等于生日的话就显示出来
             *  过滤要显示的列表,筛选出今天时间(月日)大于等于生日时间(月日)
             *  上一步user_birthday_config的status状态更新了，所以再取一次把最新的状态取到
             */
            allActivityList = mobileBirthdayService.findFrontBirthdayData(sellerId, userId);
            List<BirthdayDO> result = mobileBirthdayService.screenActivityList(allActivityList);
            modelMap.put("result",result);

            SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId.toString());
            modelMap.put("seller_name", sellerConfigInfo.getSellerName());
            return new ModelAndView("/mobile/birthday/suniu_birthday", modelMap);

        } else {

            return new ModelAndView("/mobile/birthday/suniu_birthday_approve", modelMap);

        }

    }



    /**
     * 领生日送积分或者生日折扣的ajax请求
     * @param userId
     * @param birthdayActivityId
     * @return
     */
    @RequestMapping(value="/receive/prize")
    @ResponseBody
    public Map<String, Object> receivePrize(Long sellerId, Long userId, Long birthdayActivityId, String presentType) {
        Map<String, Object> receiveMap = new HashMap<String, Object>();
        receiveMap.put(ERROR_CODE_KEY, BaseController.ErrorCode.ERROR);
        try {

            if (DaoConstant.BirthdayConfig.BIRTHDAY_POINTS.equals(presentType)) {
                mobileBirthdayService.receivePointsPrize(sellerId, userId, birthdayActivityId);
                receiveMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                receiveMap.put(INFO_KEY, "领取奖品成功");
            }

            if (DaoConstant.BirthdayConfig.BIRTHDAY_DISCOUNT.equals(presentType)) {
                mobileBirthdayService.receiveDiscountPrize(sellerId, userId, birthdayActivityId);
                receiveMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                receiveMap.put(INFO_KEY, "领取奖品成功");
            }
        } catch (Exception e) {
            receiveMap.put(INFO_KEY, "领取奖品失败");
            return receiveMap;
        }
        return receiveMap;
    }


}
