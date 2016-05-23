package com.shufensoft.crm.web.controller.mobile.pointMall;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallGoodsMapper;
import com.shufensoft.crm.biz.dao.generation.present.PresentMapper;
import com.shufensoft.crm.biz.domain.defined.point.PointDetailDO;
import com.shufensoft.crm.biz.domain.defined.pointMall.*;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsExample;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoodsSku;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiver;
import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerMobileMenu;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.birthday.BirthdayService;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.biz.service.hongbao.helper.PointExchangeGoodsHelper;
import com.shufensoft.crm.biz.service.pointmall.face.IClientService;
import com.shufensoft.crm.biz.service.pointmall.face.IMallTradeService;
import com.shufensoft.crm.biz.service.pointmall.face.IPointExchangeService;
import com.shufensoft.crm.biz.service.pointmall.face.MallGoodsService;
import com.shufensoft.crm.biz.service.pointmall.vo.GoodsVo;
import com.shufensoft.crm.biz.service.present.PresentService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.seller.SellerMobileMenuService;
import com.shufensoft.crm.biz.service.system.SysTokenService;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.web.annotation.PreventDuplicateSubmission;
import com.shufensoft.crm.web.controller.base.BaseController;
import com.shufensoft.crm.web.vo.MallReceiverVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/20  
 */
@Controller
public class MallClientController extends BaseController {

    private static Logger logger = Logger.getLogger(MallClientController.class);

    @Resource(name = "iClientService")
    private IClientService iClientService;

    @Resource(name = "iMallTradeService")
    private IMallTradeService iMallTradeService;

    @Resource(name = "mallGoodsService")
    private MallGoodsService mallGoodsService;

    @Resource(name = "hongBaoObtainService")
    private HongBaoObtainService hongBaoObtainService;

    @Resource(name = "sellerMobileMenuService")
    private SellerMobileMenuService sellerMobileMenuService;

    @Resource(name = "presentService")
    private PresentService presentService;


    @Resource(name = "rockService")
    private RockService rockService;

    @Resource(name = "birthdayService")
    private BirthdayService birthdayService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAccountService userAccountService;

    @Resource(name = "pointExchangeService")
    private IPointExchangeService iPointExchangeService;

    @Autowired
    private WXService wxService;

    @Autowired
    private SysTokenService sysTokenService;

    private ConcurrentControlHelper concurrentControlHelper = new ConcurrentControlHelper();

    private static final String ENTRY_MY_POINT_TYPE = "entry_my_point";      //积分兑换红包线程数  type

    private static final String ENTRY_MY_POINT_MAX_THREAD_NUM = "entry_my_point_max_thread_num";      //积分兑换红包线程数 name

    private static final String EXCHANGE_THREAD_NUM_TYPE = "exchange_thread_num";      //积分兑换商品线程数  type

    private static final String EXCHANGE_THREAD_NAME = "point_exchange";      //积分兑换商品线程数 name

    /**
     * to 积分商城首页
     * 地址后面要跟上sellerId 和 userId
     */
    @RequestMapping("/mobile/pointmall")
    @ResponseBody
    public ModelAndView index(Long sellerId, Long userId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        if (userId == null || sellerId == null) {
            return null;
        }
        //用户积分账户信息
//        UserAccountStaticsDo userAccountDo = iClientService.findUserAccountDoByUserIdAndSellerId(Long.parseLong(sellerId),userId);
        User user = userService.findUserBySellerIdAndUserId(sellerId, userId);
        UserAccount userAccount = userAccountService.findUserAccountByUserId(sellerId, userId);
        //商户积分兑换商品表, 1, 库存量要大于0, 2, 排除礼物类目, 3, 在售
        PageInfo mallGoodsPageInfo = mallGoodsService.findExangeGoods(sellerId, 1, 6);
        //积分实时兑换商品信息表 (这里不包括红包的兑换)
        PageInfo pointExchangePageInfo = iClientService.getPointExchangeRealTimeInfo(sellerId, 1, 50);
        //积分兑换商品排行榜 (包括兑换商品和红包, 点赞的入口也包括积分兑换排行和红包领取排行)
        Map<String, Object> params = Maps.newHashMap();
        params.put("sellerId", sellerId);
        PointExchangeRankDo myRank = null;
        List<PointExchangeRankDo> otherRanks = new ArrayList<PointExchangeRankDo>();
        PageInfo allExchangeRank = iClientService.getPointExchangeRankDoByPage(params, 1, 10);
        if (allExchangeRank != null && !CollectionUtils.isEmpty(allExchangeRank.getList())) {
            for (int i = 0; i < allExchangeRank.getList().size(); i++) {
                PointExchangeRankDo rank = (PointExchangeRankDo) allExchangeRank.getList().get(i);
                if (rank.getUserId() != null) {
                    rank.setRank(new Long(i + 1));
                    if (rank.getUserId().equals(userId)) {
                        myRank = rank;
                    } else {
                        otherRanks.add(rank);
                    }
                }
            }
        }
        //确定排行第一位的兑换积分数
        Integer maxExchangePoint = getMaxExchangePointTotal(myRank, otherRanks);

        //商城首页广告位图片
        SellerMobileMenu sellerMobileMenu = new SellerMobileMenu();
        sellerMobileMenu.setType("point");
        sellerMobileMenu.setIsSelect("1");

        List<SellerMobileMenu> sellerMobileMenus = sellerMobileMenuService.getSellerMobileMenus(sellerMobileMenu, Long.valueOf(sellerId));

        ResourceBundle bundle = PropertyResourceBundle.getBundle("config");
        String wxUrl = bundle.getString("crm.web.url") + request.getServletPath() + "?" + request.getQueryString();
        Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId), wxUrl);
        logger.info("############# wxUrl =========          " + wxUrl);
        mav.getModel().put("user", user);
        mav.getModel().put("userAccount", userAccount);
        mav.getModel().put("products", mallGoodsPageInfo.getList());
        mav.getModel().put("exchangeInfo", pointExchangePageInfo.getList());
        mav.getModel().put("exchangeRankInfo", otherRanks);
        mav.getModel().put("myRank", myRank);
        mav.getModel().put("userId", userId);
        mav.getModel().put("sellerId", sellerId);
        mav.getModel().put("sellerMobileMenus", sellerMobileMenus);
        mav.getModel().put("maxExchangePoint", maxExchangePoint);
        mav.getModel().put("wxJsConfig", datas);
        mav.setViewName("/mobile/mall/index");
        return mav;
    }

    /**
     * 更多商品
     */
    @RequestMapping("/mobile/mall/goods/list")
    @ResponseBody
    public ModelAndView moreGoods(Long sellerId, Long userId) {
        ModelAndView mav = new ModelAndView();
        List<GoodsSkuExchangeInfoDo> goodsExchangeInfoDoList = iClientService.findAllGoodsExchangeInfoDo(sellerId);
        mav.getModel().put("goodsExchangeInfoDoList", goodsExchangeInfoDoList);
        mav.getModel().put("userId", userId);
        mav.getModel().put("sellerId", sellerId);
        mav.setViewName("mobile/mall/goodsList");
        return mav;
    }

    /**
     * to 更多积分兑换排行榜
     */
    @RequestMapping("/mobile/mall/pr/list")
    @ResponseBody
    public ModelAndView pointRank(Long sellerId, Long userId) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> params = Maps.newHashMap();
        params.put("sellerId", sellerId);
        PointExchangeRankDo myRank = null;
        List<PointExchangeRankDo> otherRanks = new ArrayList<PointExchangeRankDo>();
        PageInfo allExchangeRank = iClientService.getPointExchangeRankDoByPage(params, 1, 100);
        if (allExchangeRank != null && !CollectionUtils.isEmpty(allExchangeRank.getList())) {
            for (int i = 0; i < allExchangeRank.getList().size(); i++) {
                PointExchangeRankDo rank = (PointExchangeRankDo) allExchangeRank.getList().get(i);
                if (rank.getUserId() != null) {
                    rank.setRank(new Long(i + 1));
                    if (rank.getUserId().equals(userId)) {
                        myRank = rank;
                    } else {
                        otherRanks.add(rank);
                    }
                }
            }
        }
        //确定排行第一位的兑换积分数
        Integer maxExchangePoint = getMaxExchangePointTotal(myRank, otherRanks);
        mav.setViewName("/mobile/mall/pointRankList");
        mav.getModel().put("pointRankList", otherRanks);
        mav.getModel().put("myRank", myRank);
        mav.getModel().put("userId", userId);
        mav.getModel().put("sellerId", sellerId);
        mav.getModel().put("maxExchangePoint", maxExchangePoint);
        return mav;
    }

    /**
     * to 积分兑换排行榜, ajax调用
     * 只有用积分兑换了商品或者礼物才会出现在排行榜, 包括红包
     */
    @RequestMapping("/mobile/mall/pr/ajax/list")
    @ResponseBody
    public Map<String, Object> pointRankForAjax(Long userId, Long sellerId) {
        Map<String, Object> returnMap = Maps.newHashMap();
        try {
            Map<String, Object> params = Maps.newHashMap();
            params.put("sellerId", sellerId);
            PointExchangeRankDo myRank = null;
            List<PointExchangeRankDo> otherRanks = new ArrayList<PointExchangeRankDo>();
            PageInfo allExchangeRank = iClientService.getPointExchangeRankDoByPage(params, 1, 100);
            if (allExchangeRank != null && !CollectionUtils.isEmpty(allExchangeRank.getList())) {
                for (int i = 0; i < allExchangeRank.getList().size(); i++) {
                    PointExchangeRankDo rank = (PointExchangeRankDo) allExchangeRank.getList().get(i);
                    if (rank.getUserId() != null) {
                        rank.setRank(new Long(i + 1));
                        if (rank.getUserId().equals(userId)) {
                            myRank = rank;
                        } else {
                            otherRanks.add(rank);
                        }
                    }
                }
            }
            //确定排行第一位的兑换积分数
            Integer maxExchangePoint = getMaxExchangePointTotal(myRank, otherRanks);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY, "");
            returnMap.put("myRank", myRank);
            returnMap.put("allRank", otherRanks);
            returnMap.put("maxExchangePoint", maxExchangePoint);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, "发生异常");
        }
        return returnMap;
    }

    /**
     * to 积分兑换, ajax调用
     */
    @RequestMapping("/mobile/mall/pr/ajax/point/exchange")
    @ResponseBody
    public Map<String, Object> pointExchangeForAjax(Long sellerId, Long userId) {
        Map<String, Object> returnMap = Maps.newHashMap();
        try {
            boolean flag = concurrentControlHelper.getConcurrentThreadLock(ENTRY_MY_POINT_TYPE, ENTRY_MY_POINT_MAX_THREAD_NUM);
            AssertsUtil.check(flag, "当前兑换红包的人太多，请稍后再试!");
            //获取用户账户信息
//            UserAccountStaticsDo userAccountDo = iClientService.findUserAccountDoByUserIdAndSellerId(Long.parseLong(sellerId),userId);
            UserAccount userAccount = userAccountService.findUserAccountByUserId(sellerId, userId);
            Long usefulPoint = 0L;
            if (userAccount != null) {
                usefulPoint = userAccount.getPointAmount();
            }
//            hongBaoObtainService.fixExchangeHongbao(userId, usefulPoint);

            hongBaoObtainService.bindUserAndHongBao(sellerId, userId, usefulPoint);
            List<PointExchangeDetailDo> pointExchangeDetailDos = iClientService.findPointExchangeDetail(sellerId, userId);

            if (pointExchangeDetailDos != null) {
                returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                returnMap.put(ERROR_MESSAGE_KEY, "");
                returnMap.put("data", pointExchangeDetailDos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, "发生异常");
        } finally {
            concurrentControlHelper.releaseBizConcurrentThreadLock();
        }
        return returnMap;
    }

    /**
     * to 积分获取, ajax调用
     */
    @RequestMapping("/mobile/mall/pr/ajax/point/obtain")
    @ResponseBody
    public Map<String, Object> pointObtainForAjax(Long sellerId, Long userId) {
        Map<String, Object> returnMap = Maps.newHashMap();
        try {

            List<PointDetailDO> pointDetailDOs = iClientService.findPointDetailDos(sellerId, userId);
            if (pointDetailDOs != null) {
                returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                returnMap.put(ERROR_MESSAGE_KEY, "");
                returnMap.put("data", pointDetailDOs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, "发生异常");
        }
        return returnMap;
    }

    /**
     * 我的积分, 兑换明细,
     */
    @RequestMapping("/mobile/point")
    @ResponseBody
    public ModelAndView myPointExchange(Long sellerId, Long userId, String type) {
        ModelAndView mav = new ModelAndView();
        boolean flag = concurrentControlHelper.getConcurrentThreadLock(ENTRY_MY_POINT_TYPE, ENTRY_MY_POINT_MAX_THREAD_NUM);
        AssertsUtil.check(flag, "当前兑换红包的人太多，请稍后再试!");
        try {

            /**
             *  获取用户账户信息, 总积分, 总兑换积分, 剩余有效积分, 兑换商品消耗积分, 兑换红包消耗积分
             */
//            UserAccountStaticsDo userAccountDo = iClientService.findUserAccountDoByUserIdAndSellerId(Long.parseLong(sellerId),userId);
            User user = userService.findUserBySellerIdAndUserId(sellerId, userId);
            UserAccount userAccount = userAccountService.findUserAccountByUserId(sellerId, userId);
            PointExchangeStaticsDo pointExchangeStaticsDo = iPointExchangeService.findPointExchangeStaticsDoByUserId(sellerId, userId);

            //查找某个用户排名
            UserAccountStaticsDo userAccountRank = iClientService.findUserAccountDoRankByUserId(sellerId, userId);
            //查找某个商家积分兑换的所有人数和发放的金额
            PointObtainStaticsDo pointObtainStaticsDo = iClientService.findPointObtainStaticsBySellerId(sellerId);
            //
//            hongBaoObtainService.fixExchangeHongbao(Long.parseLong(sellerId),userId,userAccountDo.getValidPoint());
            mav.getModel().put("user", user);
            mav.getModel().put("userAccount", userAccount);
            mav.getModel().put("pointExchangeStatics", pointExchangeStaticsDo);
            mav.getModel().put("userAccountRank", userAccountRank);
            mav.getModel().put("pointObtainStaticsDo", pointObtainStaticsDo);
            mav.setViewName("/mobile/mall/myPoint");
            mav.getModel().put("userId", userId);
            mav.getModel().put("sellerId", sellerId);
            mav.getModel().put("type", type);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            concurrentControlHelper.releaseBizConcurrentThreadLock();
        }
        return mav;
    }

    /**
     * to 单个商品详情页, 首页兑换按钮点击触发
     *
     * @param obtainId 摇一摇礼物, 生日礼物最终要更新的数据业务ID, 这里统一用obtainId.
     */
    @RequestMapping("/mobile/mall/goods/detail")
    @ResponseBody
    public ModelAndView goodsDetail(Long sellerId, Long gid, Long userId, Long obtainId) {
        ModelAndView mav = new ModelAndView();
        //针对摇一摇和生日礼物过来的礼物商品, 要查询与用户的绑定信息
        boolean isGift = mallGoodsService.isGiftByGoodsId(sellerId, gid);
        if (isGift) {
            Present present = presentService.findPresentByUserIdAndGoodsId(sellerId, userId, gid);
            if (present == null) {              //礼物与用户不匹配, 非法领取
                mav.getModel().put("failMessage", "领取失败, 请关注摇一摇领取礼物或者生日送礼物活动, 谢谢");
                mav.getModel().put("userId", userId);
                mav.getModel().put("sellerId", sellerId);
                mav.setViewName("/mobile/mall/illegalExchange");     //兑换失败
                return mav;
            } else {
                mav.getModel().put("giftSource", present.getPresentSource().toLowerCase());               //表示是礼物的兑换, 并标明来源
                mav.getModel().put("obtainId", obtainId);        //摇礼物成功后需要更新的领取表的obtainId
            }
        }
        GoodsVo goodsVo = mallGoodsService.findGoodsByGoodsId(sellerId, gid);
        mav.getModel().put("mallGoods", goodsVo);
        mav.getModel().put("userId", userId);
        mav.getModel().put("sellerId", sellerId);
        mav.getModel().put("goodsId", gid);
        mav.setViewName("/mobile/mall/goodsDetail");
        return mav;
    }

    /**
     * 查询商品的 sku for ajax
     */
    @RequestMapping("/mobile/mall/sku/detail")
    @ResponseBody
    public Map<String, Object> goodsSkuDetail(Long sellerId, Long gid) {
        Map<String, Object> returnMap = Maps.newHashMap();
        try {
            List<MallGoodsSku> mallGoodsSkus = mallGoodsService.queryGoodsSku(sellerId, gid);
            Map<String, List<String>> propMap = Maps.newHashMap();       //属性名 和 属性值
            List<String> values = null;
            if (!CollectionUtils.isEmpty(mallGoodsSkus)) {
                for (MallGoodsSku sku : mallGoodsSkus) {
                    String propNameValue = sku.getPropsName();
                    String[] pnvs = propNameValue.split(";");
                    for (String pnv : pnvs) {
                        String[] pvs = pnv.split(":");
                        String pName = pvs[2];
                        String pValue = pvs[3];
                        if (propMap.containsKey(pName)) {
                            values = propMap.get(pName);
                            if (!values.contains(pValue)) {
                                values.add(pValue);
                            }
                        } else {
                            values = new ArrayList<String>();
                            values.add(pValue);
                            propMap.put(pName, values);
                        }
                    }

                }
            }
            MallGoods mallGoods = mallGoodsService.findMallGoodsBySellerAndGoodsId(sellerId, gid);
            returnMap.put("mallGoods", mallGoods);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
            returnMap.put(ERROR_MESSAGE_KEY, "success");
            returnMap.put("skuData", mallGoodsSkus);
            returnMap.put("skuPropData", propMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, "exception");
        }
        return returnMap;
    }


    /**
     * 确定兑换
     * 注意: 商品可能没有sku的情况
     *
     * @param amount     商品数量
     * @param obtainId   摇一摇礼物的时候领取表的obtainId,  生日礼物的业务ID也用这个
     * @param giftSource 礼物来源, 目前有两种, 一是shake摇一摇礼物, 二是birthday生日礼物
     */
    @RequestMapping("/mobile/mall/exchange")
    @ResponseBody
    @PreventDuplicateSubmission(needCreateToken = true)
    public ModelAndView exchange(Long sellerId, Long userId, Long goodsId, @RequestParam(value = "skuId") Long skuId, Integer amount, @RequestParam(value = "obtainId") Long obtainId, String giftSource, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        //用户账户信息
        UserAccount userAccount = iClientService.findUserAccountBySellerIdAndUserId(sellerId, userId);
        String isVirtual = "";
        if (skuId != null) {      //有sku
            //获取商品信息
            GoodsSkuExchangeInfoDo goodsSkuExchangeInfoDo = mallGoodsService.findGoodsSkuExchangeInfoDoBySkuId(sellerId, skuId);
            if (goodsSkuExchangeInfoDo != null) {
                if (goodsSkuExchangeInfoDo.getStockSize() <= 0) {
                    mav.getModel().put("failMessage", "抱歉！该商品已经领取完");
                    mav.getModel().put("userId", userId);
                    mav.getModel().put("sellerId", sellerId);
                    mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                    return mav;
                }
                mav.getModel().put("goodsSkuExchangeInfoDo", goodsSkuExchangeInfoDo);
                mav.getModel().put("stockTotal", goodsSkuExchangeInfoDo.getStockSize());      //商品库存数
                isVirtual = goodsSkuExchangeInfoDo.getIsVirtual();
            }
        } else {
            MallGoods mallGoods = mallGoodsService.findMallGoodsBySellerAndGoodsId(sellerId, goodsId);
            if (mallGoods != null) {
                if (mallGoods.getQuantity() <= 0) {
                    mav.getModel().put("failMessage", "抱歉！该商品已经领取完");
                    mav.getModel().put("userId", userId);
                    mav.getModel().put("sellerId", sellerId);
                    mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                    return mav;
                }
                mav.getModel().put("mallGoods", mallGoods);
                mav.getModel().put("stockTotal", mallGoods.getQuantity());
                isVirtual = mallGoods.getIsVirtual();
            }
        }
        if ("n".equals(isVirtual)) {
            //查找默认收件人信息
            MallReceiver defaultReceiver = iClientService.findMallReceiverByUserId(sellerId, userId);
//            List<MallReceiver> mallReceivers = iClientService.findMallReceiversByUserId(Long.parseLong(sellerId),userId);
            if (defaultReceiver != null) {
                mav.getModel().put("defaultReceiver", defaultReceiver);
//                mav.getModel().put("mallReceivers",mallReceivers);
            }
        }
        mav.getModel().put("userAccount", userAccount);
        mav.getModel().put("userId", userId);
        mav.getModel().put("sellerId", sellerId);
        mav.getModel().put("goodsId", goodsId);
        mav.getModel().put("skuId", skuId);
        mav.getModel().put("amount", amount);
        mav.getModel().put("obtainId", obtainId);
        mav.getModel().put("giftSource", StringUtils.isNotBlank(giftSource) == true ? giftSource : null);
        mav.getModel().put("token", request.getAttribute("token"));
        mav.setViewName("/mobile/mall/exchange");
        return mav;
    }

    /**
     * 确定兑换的下一步
     * 此过程会判断兑换成功与否
     * 1. 兑换不成功, 积分不够, 库存为0, 返回提示页面
     * 2. 兑换成功,
     * a. sku库存减1
     * b. 生成mall_trade, mall_order数据
     * c. 生成point_exchange数据
     * d. 更新user_account剩余积分数, 兑换积分数, 有效积分数
     * e. mall_goods 的数量减1, 已兑换的数量加1
     *
     * @param amount     客户选择的兑换数量
     * @param giftSource 礼物来源, 目前有两种, 一是shake摇一摇礼物, 二是birthday生日礼物
     *                   *
     */
    @RequestMapping("/mobile/mall/exchangeNext")
    @ResponseBody
    @PreventDuplicateSubmission(needValidateToken = true)
    public ModelAndView exchangeNext(Long sellerId, Long userId, Long goodsId, Long skuId, Long receiverId, Integer amount, Long obtainId, String giftSource) {

        ModelAndView mav = new ModelAndView();
        try {
            Boolean concurrentThreadLockFlag = concurrentControlHelper.getConcurrentThreadLock(EXCHANGE_THREAD_NAME, EXCHANGE_THREAD_NUM_TYPE);
            AssertsUtil.check(concurrentThreadLockFlag, "兑换的人太多，请稍后再试!");

            if (StringUtils.isNotBlank(giftSource)) {
                if ("birthday".equals(giftSource)) {    //生日礼物的领取
                    Present present = presentService.findPresentByUserIdAndActivityId(sellerId, userId, obtainId);
                    if (present.getIsReceive()) {     //已经领了
                        mav.getModel().put("failMessage", "抱歉！领取失败，您已经领取了该礼物");
                        mav.getModel().put("userId", userId);
                        mav.getModel().put("sellerId", sellerId);
                        mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                        return mav;
                    }
                } else if ("shake".equals(giftSource)) {    //摇一摇礼物的领取
                    Present present = presentService.findPresentByUserIdAndPresentId(sellerId, userId, obtainId);
                    if (present.getIsReceive()) {         //已经领了
                        mav.getModel().put("failMessage", "抱歉！领取失败，您已经领取了该礼物");
                        mav.getModel().put("userId", userId);
                        mav.getModel().put("sellerId", sellerId);
                        mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                        return mav;
                    }
                }
            }

            //用户账户信息
            UserAccount userAccount = iClientService.findUserAccountBySellerIdAndUserId(sellerId, userId);
            Long validPointTotal = 0L;      //用户有效积分数
            if (userAccount != null) {
                validPointTotal = userAccount.getPointAmount();
            }
            Long mustPoint = 0L;     //兑换需要的积分
            String goodsName = "";
            //获取商品信息
            if (skuId != null) {
                GoodsSkuExchangeInfoDo goodsSkuExchangeInfoDo = mallGoodsService.findGoodsSkuExchangeInfoDoBySkuId(sellerId, skuId);
                mustPoint = amount * goodsSkuExchangeInfoDo.getPoint();
                goodsName = goodsSkuExchangeInfoDo.getTitle();
            } else {
                MallGoods mallGoods = mallGoodsService.findMallGoodsBySellerAndGoodsId(sellerId, goodsId);
                mustPoint = amount * mallGoods.getPoint();
                goodsName = mallGoods.getTitle();
            }
            //比较用户剩余积分与兑换商品需要的积分

            if (validPointTotal < mustPoint) {
                mav.getModel().put("failMessage", "抱歉！兑换失败，您的积分不足兑换本商品！请兑换其他商品。");
                mav.getModel().put("userId", userId);
                mav.getModel().put("sellerId", sellerId);
                mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                return mav;
            }
            if (skuId != null) {
                PointExchangeGoodsHelper pointExchangeGoodsHelper = new PointExchangeGoodsHelper();
                if (!pointExchangeGoodsHelper.isExchangedSku(sellerId, skuId)) {
                    mav.getModel().put("failMessage", "抱歉！兑换失败，该商品已经兑换完, 请选择其它商品。");
                    mav.getModel().put("userId", userId);
                    mav.getModel().put("sellerId", sellerId);
                    mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                    return mav;
                }
            } else if (goodsId != null) {
                PointExchangeGoodsHelper pointExchangeGoodsHelper = new PointExchangeGoodsHelper();
                if (!pointExchangeGoodsHelper.isExchangedGoods(sellerId, goodsId)) {
                    mav.getModel().put("failMessage", "该商品已经兑换完, 请选择其它商品,谢谢");
                    mav.getModel().put("userId", userId);
                    mav.getModel().put("sellerId", sellerId);
                    mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
                    return mav;
                }
            }
            iClientService.handleExchange(sellerId, userId, goodsId, skuId, receiverId, amount, giftSource);
            //领取礼物的处理
            if (StringUtils.isNotBlank(giftSource) && obtainId != null) {
                if (giftSource.equals(DaoConstant.GiftSource.SHAKE)) {     //摇一摇
                    rockService.updateShakeObtain(sellerId, obtainId, "gift", goodsName);
                    presentService.updateShakeGiftObtainStatus(obtainId, userId);
                } else if (giftSource.equals(DaoConstant.GiftSource.BIRTHDAY)) {
                    birthdayService.updateBirthdayAboutState(userId, obtainId);       //
                }
            }
            mav.getModel().put("payPointTotal", mustPoint);    //消耗积分
            mav.getModel().put("remainPointTotal", validPointTotal - mustPoint);    //剩余积分
            mav.getModel().put("sellerId", sellerId);
            mav.setViewName("/mobile/mall/exchangeSuccess");          //兑换成功
            return mav;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            mav.getModel().put("failMessage", "兑换失败");
            mav.getModel().put("userId", userId);
            mav.getModel().put("sellerId", sellerId);
            mav.setViewName("/mobile/mall/exchangeFail");     //兑换失败
            return mav;
        } finally {
            concurrentControlHelper.releaseBizConcurrentThreadLock();
        }

    }


//    /**
//     * to 跳转到更改收货人地址页面
//     * */
//     @RequestMapping("/mobile/mall/address")
//     public ModelAndView showAddress(Long userId){
//        ModelAndView mav = new ModelAndView();
//        List<MallReceiver> mallReceivers = iClientService.findMallReceiversByUserId(Long.parseLong(sellerId), userId);
//
//        mav.setViewName("/mobile/mall/address");
//        return mav;
//    }
//
//    /**
//     *  to 跳转到添加收货人地址页面
//     * */
//     @RequestMapping("/mobile/mall/toAddAddress")
//     public ModelAndView toAddAddress(Long userId){
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("/mobile/mall/toAddAddress");
//        return mav;
//    }

    /**
     * 处理新收件人的添加
     * 新添加的收货人设置为默认收件人
     */
    @RequestMapping("/mobile/mall/addAddress")
    @ResponseBody
    public Map<String, Object> addAddress(Long sellerId, Long userId, MallReceiverVo mallReceiverVo) {
        Map<String, Object> returnMap = Maps.newHashMap();
        try {
            MallReceiver mallReceiver = new MallReceiver();
            mallReceiver.setSellerId(sellerId);
            mallReceiver.setUserId(userId);
            mallReceiver.setAddress(mallReceiverVo.getAddress());
            mallReceiver.setName(mallReceiverVo.getName());
            mallReceiver.setMobile(mallReceiverVo.getMobile());
            mallReceiver.setProvince(mallReceiverVo.getProvince());
            mallReceiver.setCity(mallReceiverVo.getCity());
            mallReceiver.setDistrict(mallReceiverVo.getDistrict());
            mallReceiver.setZip(mallReceiverVo.getZip());
            mallReceiver.setIsDefault("y");
            Long receId = iClientService.handleAddAddress(sellerId, userId, mallReceiver);
            if (receId == null) {
                returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
                returnMap.put(ERROR_MESSAGE_KEY, "添加收件人失败:");
            } else {
                returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
                returnMap.put(ERROR_MESSAGE_KEY, "");
                returnMap.put("data", receId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);
            returnMap.put(ERROR_MESSAGE_KEY, "添加收件人失败:" + e.getMessage());
        }
        return returnMap;
    }

    /**
     * 填充收件人信息
     */
    @RequestMapping("/mobile/mall/getReceivers")
    @ResponseBody
    public Map<String, Object> fillAllReceiver(Long sellerId, Long userId) {
        Map<String, Object> returnMap = Maps.newHashMap();
        List<MallReceiver> mallReceivers = iClientService.findMallReceiversByUserId(sellerId, userId);
        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put("data", mallReceivers);
        return returnMap;
    }

    /**
     * @param myRank     本人积分兑换排行
     * @param otherRanks
     */
    private Integer getMaxExchangePointTotal(PointExchangeRankDo myRank, List<PointExchangeRankDo> otherRanks) {
        Integer max = 0;
        Integer p1 = 0;
        Integer p2 = 0;
        if (myRank != null) {
            p1 = myRank.getPointExchangeTotal();
        }
        if (!CollectionUtils.isEmpty(otherRanks)) {
            PointExchangeRankDo temp = otherRanks.get(0);
            p2 = temp.getPointExchangeTotal();
        }
        if (max < p1) {
            max = p1;
        }
        if (max < p2) {
            max = p2;
        }
        return max;
    }


}
