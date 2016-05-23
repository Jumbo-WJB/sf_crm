package com.shufensoft.crm.web.controller.knowCustomer;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.sellerConfig.SellerConfigService;
import com.shufensoft.crm.biz.service.trade.TradeService;
import com.shufensoft.crm.biz.service.trade.vo.TradeVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.SellerShopVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.constant.WebConstant;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 *                 认识客户
 *                </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/6/19  
 */
@Controller
@RequestMapping(value = "/knowCustomer")
public class KnowCustomerController extends BaseController{

    public static final Logger logger = Logger.getLogger(KnowCustomerController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private SellerConfigService sellerConfigService;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/userList")
    public ModelAndView showUser(String source, String startContribution, String endContribution,ModelMap modelMap){
        modelMap.put("source",source);
        modelMap.put("startContribution",startContribution);
        modelMap.put("endContribution",endContribution);
        return new ModelAndView("/knowCustomer/userList",modelMap);
    }

    /**
     * 用户计算
     * @return
     */
    @RequestMapping(value = "/userAnalyze")
    public ModelAndView userAnalyze(){
        //查询用户资料
        return new ModelAndView("/knowCustomer/userAnalyze");
    }

    @RequestMapping(value = "/contributeModel")
    public ModelAndView showContributeModel(){
        return new ModelAndView("/knowCustomer/contributionModel");
    }

    /**
     * 用户画像
     * @return
     */
    @RequestMapping(value = "/userPortrait")
    @ResponseBody
    public ModelAndView userPortrait(String userId,HttpSession session){
        Map<String,Object> map = Maps.newHashMap();
        Long sellerId = getSellerId(session);

        //查询对应用户的画像
        if (StringUtils.isNotBlank(userId)){
            UserDO userDO = userService.getUserAndPortrait(Long.parseLong(userId),sellerId);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (userDO !=null && userDO.getLastPurchaseDate() != null) {
                userDO.setTime(format.format(userDO.getLastPurchaseDate()));
            }
            map.put("user",userDO);
        }

        return new ModelAndView("/knowCustomer/userPortrait",map);
    }

    /**
     *
     * @param userVO
     * @param pageNum
     * @param length
     * @param sortContent
     * @param customPurchaseType 客户购买类型
     * @return
     */
    @RequestMapping(value = "/customerList")
    public @ResponseBody Map<String, Object> showList(@Valid UserVO userVO, Integer pageNum, Integer length,String sortContent,String customPurchaseType, HttpSession session){
        Map<String, Object> map = Maps.newHashMap();

        userVO.setOrderClause(sortContent);
        Long sellerId = getSellerId(session);
        userVO.setSellerId(sellerId);
        PageInfo pageInfo = null;

        if(WebConstant.CustomPurchaseType.SUCCESS_PURCHASE.equals(customPurchaseType)){
            try {
                pageInfo = userService.queryUserWithPortrait(userVO,pageNum,length);
            }catch (Exception e){
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"交易成功用户查找异常");
                return map;
            }
        }

        if(WebConstant.CustomPurchaseType.POTENTIAL_PURCHASE.equals(customPurchaseType)){

            TradeVO tradeVO = new TradeVO();
            tradeVO.setSellerId(sellerId);
            tradeVO.setKeyword(userVO.getKeyword());
            tradeVO.setReceiverName(userVO.getName());
            tradeVO.setTradeSource(userVO.getSource());
            tradeVO.setOrderClause(userVO.getOrderClause());
            tradeVO.setHasMobile(userVO.getHasMobile());
            tradeVO.setLastDays(StringUtils.isBlank(userVO.getTime())?null:Integer.valueOf(userVO.getTime()));
            if(StringUtils.isNotBlank(userVO.getMaxPrice())){
                tradeVO.setMaxPrice(new BigDecimal(userVO.getMaxPrice()));
            }

            if(StringUtils.isNotBlank(userVO.getMinPrice())){
                tradeVO.setMinPrice(new BigDecimal(userVO.getMinPrice()));
            }

            /**
             * 根据店铺类型和商家id获取店铺id列表
             */
            List<Long> shopIds = new ArrayList<Long>();
            SellerShopVO shopVO = new SellerShopVO();
            shopVO.setSellerId(sellerId);
            if (StringUtils.isNotBlank(userVO.getSource())){
                shopVO.setShopType(userVO.getSource());
                List<SellerShop> shops = sellerConfigService.queryShops(shopVO);
                if (!CollectionUtils.isEmpty(shops)){
                    for (SellerShop shop : shops){
                        shopIds.add(shop.getShopId());
                    }
                    tradeVO.setShopIdList(shopIds);
                }else{
                    map.put("recordsFiltered", 0);
                    map.put("recordsTotal", 0);
                    map.put("data", new PageInfo(null));
                    return map;
                }
            }

            try {
                pageInfo = tradeService.selectTradeFromAll(tradeVO,pageNum,length);
            }catch (Exception e){
                map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
                map.put(ERROR_MESSAGE_KEY,"潜在购买用户查找异常");
                return map;
            }
        }

        if (pageInfo != null) {
            map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            map.put("recordsFiltered", pageInfo.getTotal());
            map.put("recordsTotal", pageInfo.getTotal());
            map.put("data", pageInfo.getList());
        }else{
            map.put(ERROR_CODE_KEY,ErrorCode.ERROR);
            map.put(ERROR_MESSAGE_KEY,"用户查找为空");
        }
        return map;
    }

    /**查看某个客户是否有客户画像name */
    @RequestMapping(value = "/withPortrait")
    public @ResponseBody Map<String, Object> findPortrait(Long userId, HttpSession session){
        Map<String,Object> map = Maps.newHashMap();
        Long sellerId = getSellerId(session);

        int count = userService.findPortrait(userId,sellerId);
        map.put("count",count);
        return map;
    }

    /**查看某个客户是否有客户画像name */
    @RequestMapping(value = "/withPortraitById")
    public @ResponseBody Map<String, Object> findPortraitById(Long portraitId, HttpSession session){
        Map<String,Object> map = Maps.newHashMap();
        Long sellerId = getSellerId(session);

        if(userService.findPortraitById(portraitId,sellerId) != null){
            map.put("portrait",userService.findPortraitById(portraitId,sellerId));
            map.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
        }
        return map;
    }
}
