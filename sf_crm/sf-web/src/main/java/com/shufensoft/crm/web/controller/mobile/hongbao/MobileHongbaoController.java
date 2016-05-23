package com.shufensoft.crm.web.controller.mobile.hongbao;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.helper.ConcurrentControlHelper;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.hongbao.helper.HongBaoHelper;
import com.shufensoft.crm.biz.service.ruleConfig.RuleConfigService;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.service.user.UserValidateService;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.biz.vo.HBObtainVO;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.enums.HBObtainStatus;
import com.shufensoft.crm.ruleEngine.HBCashEngine;
import com.shufensoft.crm.ruleEngine.HBRuleEngine;
import com.shufensoft.crm.ruleEngine.RuleEngine;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import com.shufensoft.crm.ruleEngine.exeception.RuleEngineException;
import com.shufensoft.crm.ruleEngine.result.EngineResult;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>红包手机端</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/3  
 */
@RequestMapping("/mobile")
@Controller
public class MobileHongbaoController extends BaseController {

    public static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MobileHongbaoController.class);

    public static   ResourceBundle bundle = PropertyResourceBundle.getBundle("config");

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserValidateService userValidateService;

    @Autowired
    private HongbaoService hongbaoService;

    @Autowired
    private UserService userService;

    @Autowired
    private RuleConfigService ruleConfigService;

    @Autowired
    private WXService wxService;

    public static ConcurrentControlHelper joinHongBaoConcurrentControlHelper = new ConcurrentControlHelper();

    public static String JOIN_HB_CONCURRENT_THREAD_NUM_TYPE = "JOIN_HB_CONCURRENT_THREAD_NUM";

    public static String JOIN_HB_NAME = "JOIN_HB";

    public static ConcurrentControlHelper executeHongBaoConcurrentControlHelper = new ConcurrentControlHelper();

    public static String HB_CONCURRENT_THREAD_NUM_TYPE = "HB_CONCURRENT_THREAD_NUM";

    public static String RECEIVE_HB_NAME = "RECEIVE_HB";


    @RequestMapping("/hongbao")
    public ModelAndView getHongbao(HttpServletRequest request,String userId, String sellerId) {

        AssertsUtil.notNull(userId, "userId");

        User user=userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

        /**
         * 获取用户账户信息
         */
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setUserId(Long.valueOf(userId));
        List<UserAccountDO> userAccountDOs = userAccountService.selectUserAccountInteraction(userAccountDO, 1, 1,Long.valueOf(sellerId));
        UserAccountDO userAccount = new UserAccountDO();

        if (!CollectionUtils.isEmpty(userAccountDOs)) {
            userAccount = userAccountDOs.get(0);
        }

        /**
         * 获取用户领用信息
         */
        HBObtainVO hbObtainVO = new HBObtainVO();
        hbObtainVO.setUserId(Long.valueOf(userId));
        hbObtainVO.setStatus(HBObtainStatus.RECEIVED.getCode());
        List<HBObtain> hbObtains = hongbaoService.queryHBObtainList(hbObtainVO,Long.valueOf(sellerId));
        Map<String, Object> map = Maps.newHashMap();
        HBPool hbPool = hongbaoService.getHbPoolSum(new HBPool(),Long.valueOf(sellerId));

        /**
         * 获取商户信息
         */
        SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);


        /**
         * 获取排行版信息
         */
        UserAccountDO userAccountTemp = new UserAccountDO();
        userAccountTemp.setUserId(Long.valueOf(userId));
        userAccountTemp.setInteractionEntry("hongbao_receive_rank");
        List<UserAccountDO> userAccountTemps = new ArrayList<UserAccountDO>();

        long  maxAmount=0;
        List<UserAccountDO> userAccountDOs1 = userAccountService.selectUserAccountInteraction(userAccountTemp, 1, 1,Long.valueOf(sellerId));

        if (CollectionUtils.isNotEmpty(userAccountDOs1)){
            userAccountTemps.addAll(userAccountDOs1);
            maxAmount=userAccountDOs.get(0).getHongbaoAmount();
        }

        UserAccountDO userAccountDO1 = new UserAccountDO();
        userAccountDO1.setInteractionEntry("hongbao_receive_rank");
        userAccountDO1.setExceptUserId(Long.valueOf(userId));
        userAccountDO1.setOrderByClause(" hbobtain_amount_times asc ");
        List<UserAccountDO> userAccountDOs2 = userAccountService.selectUserAccountInteraction(userAccountDO1, 1, 99,Long.valueOf(sellerId));
        if (CollectionUtils.isNotEmpty(userAccountDOs2)) {
            userAccountTemps.addAll(userAccountDOs2);
            if(userAccountDOs2.get(0).getHbobtainAmount()>=maxAmount){
                maxAmount=userAccountDOs2.get(0).getHbobtainAmount();
            }
        }

        map.put("maxAmount", maxAmount);
        map.put("userAccountDOs", userAccountTemps);
        map.put("userAccount", userAccount);
        map.put("hbObtains", hbObtains);
        map.put("hbPool", hbPool);
        map.put("sellerConfigInfo", sellerConfigInfo);
        map.put("sellerId", sellerId);
        map.put("userId", userId);
        map.put("user", user);

        try {
            String url = 			bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            map.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return new ModelAndView("/mobile/hongbao/suniu_hongbao", map);
    }


    /**
     * 跳转进入拆红包的界面
     *
     * @param userId   用户id
     * @param sellerId  商户id
     * @param hbObtainId  红包领用id
     * @param businessType  业务类型 如普通红包和好评红红包:other,生日红包:birthday,积分兑换红包:point_exchange
     * @return
     */
    @RequestMapping("/hongbao/goHongbaoObtain")
    public ModelAndView goHongbaoObtain(HttpServletRequest request,String userId, String sellerId, long hbObtainId,String businessType) {

        AssertsUtil.notNull(userId, "userId");

        User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hbObtainId", hbObtainId);
        map.put("businessType", businessType);
        map.put("sellerId", sellerId);
        map.put("userId", userId);
        map.put("user", user);

        try {
            String url =  bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            map.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_obtain", map);
    }

    /**
     * 红包领取或用户绑定统一入口
     *
     * @param hbPoolId 红包活动id
     * @param userId   用户id
     * @param businessType  业务类型 如other:普通红包和好评红红包,birthday:生日红包,point_exchange:积分兑换红包
     * @param actionValue   引擎执行值 例如红包金额,积分数量,不填默认为空
     * @param hbObtainId  红包领用id
     * @return
     */
    @RequestMapping("/hongbao/receiveOrUserBound")
    public ModelAndView receiveHongBao(HttpServletRequest request,String hbPoolId, String userId, String sellerId,String businessType,String hbObtainId,String actionValue) {

        Map<String, Object> returnMap = receiveHongBaoResult(request,hbPoolId,userId,sellerId,businessType,hbObtainId,actionValue);

        try {
            String url = bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            returnMap.put("wxJsConfig", datas);
        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请稍后重试。");
        }

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_obtain", returnMap);
    }


    /**
     * 获取红包领用返回结果
     * @param hbPoolId 红包活动id
     * @param userId   用户id
     * @param businessType  业务类型 如other:普通红包和好评红红包,birthday:生日红包,point:积分兑换红包
     * @param actionValue   引擎执行值 例如红包金额,积分数量,不填默认为空
     * @param hbObtainId  红包领用id
     * @return
     */
    @RequestMapping(value = "/hongbao/receive/result")
    public
    @ResponseBody
    Map<String, Object>  receiveHongBaoResult(HttpServletRequest request,String hbPoolId,String userId, String sellerId,String businessType,String hbObtainId,String actionValue){

        /**
         * 获取用户对象
         */
        AssertsUtil.notBlank("userId", userId);

        User user = userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        /**
         * 控制web允许放入的最大线程数，超出线程数，提示用户友好信息
         */
        Boolean joinConcurrentThreadLockFlag = joinHongBaoConcurrentControlHelper.getConcurrentThreadLock(JOIN_HB_CONCURRENT_THREAD_NUM_TYPE, JOIN_HB_NAME);

        if (!joinConcurrentThreadLockFlag) {

            returnMap.put(ERROR_MESSAGE_KEY, "红包领取的人过多，请稍后再试!");

            return returnMap;
        }
        try {
            /**
             * 判断红包领用情况
             */
            Boolean isHongBaoObtained = HongBaoHelper.isHongBaoObtained(Long.valueOf(hbPoolId),Long.valueOf(sellerId));

            if (!isHongBaoObtained) {

                returnMap.put(ERROR_MESSAGE_KEY, "亲,红包已经领完!");

                return returnMap;
            }

            /**
             * 创建引擎
             */
            RuleEngine hbRuleEngine = new HBRuleEngine(initRuleContext(hbPoolId, "HB_POOL",businessType, user,actionValue,Long.valueOf(sellerId)));

            /**
             * 红包领取
             */
            returnMap = hongBaoReceive(hbRuleEngine, hbObtainId, Long.valueOf(userId), Long.valueOf(hbPoolId), Long.valueOf(sellerId));

            if(returnMap.get(ERROR_CODE_KEY)==ErrorCode.ERROR) {
                HongBaoHelper.incrementHongBaoBum(Long.valueOf(hbPoolId));
            }

        } catch (Exception e) {
            /**
             * 执行引擎异常,缓存中红包数量加1
             */
            HongBaoHelper.incrementHongBaoBum(Long.valueOf(hbPoolId));
            returnMap.put(ERROR_MESSAGE_KEY,"系统繁忙，请与商家联系!");
            return returnMap;
        } finally {
            joinHongBaoConcurrentControlHelper.releaseBizConcurrentThreadLock();
        }

        returnMap.put("sellerId", sellerId);
        returnMap.put("userId", userId);
        returnMap.put("businessType", businessType);
        returnMap.put("user", user);

        return  returnMap;
    }


    /**
     * 初始化红包引擎上下文
     *
     * @param hbPoolId
     * @param ruleType
     * @return
     */
    private RuleContext initRuleContext(String hbPoolId, String ruleType,String  businessType, User user,String actionValue,Long sellerId) {

        HBPoolVO hbPoolVO = hongbaoService.getHBPoolVOByPoolId(Long.valueOf(hbPoolId),sellerId);
        RuleConfig ruleConfig = ruleConfigService.getRuleConfigVOById(hbPoolVO.getRuleConfigId());
        RuleContext ruleContext = new RuleContext(ruleConfig, Long.valueOf(hbPoolId), ruleType, businessType,actionValue,sellerId);

        /**
         * 将UserDO转化为UserVO和User
         */
        UserVO userVO = new UserVO();
        BeanCopierUtils.copyProperties(user, userVO);

        ruleContext.addFactObj(UserVO.class.getName(), userVO);
        ruleContext.addFactObj(User.class.getName(), user);

        return ruleContext;
    }


    private Map<String, Object> hongBaoReceive(RuleEngine hbRuleEngine,String hbObtainId,Long userId,Long hbPoolId,Long sellerId) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        /**
         * 控制数据库允许放入的最大线程数
         */
        Boolean concurrentThreadLockFlag = executeHongBaoConcurrentControlHelper.getConcurrentThreadLock(HB_CONCURRENT_THREAD_NUM_TYPE, RECEIVE_HB_NAME);

        EngineResult engineResult;

        try {

            if (!concurrentThreadLockFlag) {

                returnMap.put(ERROR_MESSAGE_KEY, "红包领取的人过多，请稍后再试!");

                return returnMap;
            }

            List<HBObtain> hbObtainList =new ArrayList<HBObtain>();
            if(StringUtils.isBlank(hbObtainId)){
                HBObtainVO hbObtainVO = new HBObtainVO();
                hbObtainVO.setUserId(userId);
                hbObtainVO.setPoolId(hbPoolId);
                hbObtainVO.setStatus(DaoConstant.HBStatus.TO_RECEIVE);
                hbObtainList = hongbaoService.queryHBObtainList(hbObtainVO, sellerId);
                hbObtainId=CollectionUtils.isEmpty(hbObtainList)?"":hbObtainList.get(0).getHongbaoObtainId()+"";
            }

            if(StringUtils.isBlank(hbObtainId)&&CollectionUtils.isEmpty(hbObtainList)){
                engineResult = hbRuleEngine.start();
            }else{
                engineResult = hbRuleEngine.operate();
            }

            if (EngineResult.ErrorCode.SUCCESS.equals(engineResult.getErrorCode())) {

                HongBaoHelper.incrementHongBaoBum(Long.valueOf(hbRuleEngine.getRuleContext().getRuleObjId()));

                returnMap.put("hbObtainId", StringUtils.isNotBlank(hbObtainId)?hbObtainId:Long.valueOf(engineResult.getResult() + ""));
                returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);
            }

            if (EngineResult.ErrorCode.SYS_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请与商家联系!");
            }

            if (EngineResult.ErrorCode.RULE_VERIFY_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, engineResult.getErrorMessage());
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            executeHongBaoConcurrentControlHelper.releaseBizConcurrentThreadLock();
        }

        return returnMap;
    }

    /**
     * 拆红包
     *
     * @param hbObtainId 红包领用id
     * @param userId    用户id
     * @return
     */
    @RequestMapping("/hongbao/dismantle")
    public ModelAndView dismantleHongBao(HttpServletRequest request,String hbObtainId,String userId, String sellerId,String  businessType) {

        AssertsUtil.notNull(hbObtainId, "hbObainId");
        AssertsUtil.notNull(userId, "userId");

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        HBObtainVO hbObtainVO=new HBObtainVO();
        hbObtainVO.setHongbaoObtainId(Long.valueOf(hbObtainId));
        hbObtainVO.setUserId(Long.valueOf(userId));
        List<HBObtain>  hbObtains=  hongbaoService.queryHBObtainList(hbObtainVO,Long.valueOf(sellerId));

        if(CollectionUtils.isEmpty(hbObtains)|| (CollectionUtils.isNotEmpty(hbObtains)&& DaoConstant.HBStatus.RECEIVED.equals(hbObtains.get(0).getStatus()))){

            returnMap.put(ERROR_MESSAGE_KEY, "您的红包已失效或已领取,请下次再试!");

            return new ModelAndView("/mobile/hongbao/suniu_hongbao_obtain", returnMap);
        }

        RuleContext ruleContext = new RuleContext(hbObtains.get(0).getPoolId() ,Long.valueOf(hbObtainId), RuleType.HB_POOL.getCode(), "dismantle",businessType,Long.valueOf(sellerId));

        /**
         * 设置用户实际对象
         */
        AssertsUtil.notBlank("userId", userId);

        User user= userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

        long ammmount = 0;

        AssertsUtil.notNull(user, "user");
        ruleContext.addFactObj(User.class.getName(), user);

        HBRuleEngine hbRuleEngine = new HBRuleEngine(ruleContext);


        /**
         * 控制数据库允许放入的最大线程数
         */
        Boolean concurrentThreadLockFlag = executeHongBaoConcurrentControlHelper.getConcurrentThreadLock(HB_CONCURRENT_THREAD_NUM_TYPE, RECEIVE_HB_NAME);

        if (!concurrentThreadLockFlag) {

            returnMap.put(ERROR_MESSAGE_KEY, "红包拆的人过多，请稍后再试!");

            return new ModelAndView("/mobile/hongbao/suniu_hongbao_obtain", returnMap);
        }
        try {
            EngineResult engineResult = hbRuleEngine.execute();

            executeHongBaoConcurrentControlHelper.releaseBizConcurrentThreadLock();

            if (EngineResult.ErrorCode.SYS_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请与商家联系!");
            }

            if (EngineResult.ErrorCode.RULE_VERIFY_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, engineResult.getErrorMessage());
            }

            ammmount = Long.valueOf(engineResult.getResult() + "");
        } catch (Exception e) {

            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());

        } finally {
            executeHongBaoConcurrentControlHelper.releaseBizConcurrentThreadLock();
        }

        try {
            String url =bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            returnMap.put("wxJsConfig", datas);
        } catch (Exception e) {
            returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请稍后重试。");
            return new ModelAndView("/mobile/hongbao/suniu_hongbao_result", returnMap);
        }

        returnMap.put(ERROR_CODE_KEY,ErrorCode.SUCCESS);

        returnMap.put("ammount", ammmount);
        returnMap.put("returnMap", returnMap);
        returnMap.put("sellerId", sellerId);
        returnMap.put("user", user);

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_result", returnMap);
    }


    /**
     * 获取红包排行版
     *
     * @param userId
     * @return
     */
    @RequestMapping("/hongbao/rank")
    public ModelAndView hongBaoRank(HttpServletRequest request,String userId, String sellerId) {

        AssertsUtil.notBlank("userId", userId);

        Map<String, Object> map = Maps.newHashMap();
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setUserId(Long.valueOf(userId));
        userAccountDO.setInteractionType("dian_zan");
        userAccountDO.setInteractionEntry("hongbao_receive_rank");
        List<UserAccountDO> userAccountDOs = new ArrayList<UserAccountDO>();

        long  maxAmount=0;
        //获取属于自己的记录
        List<UserAccountDO> userAccountDOs1 = userAccountService.selectUserAccountInteraction(userAccountDO, 1, 1,Long.valueOf(sellerId));
        if (CollectionUtils.isNotEmpty(userAccountDOs1))
            userAccountDOs.addAll(userAccountDOs1);
        maxAmount=userAccountDOs.get(0).getHongbaoAmount();

        UserAccountDO userAccountDO1 = new UserAccountDO();
        userAccountDO1.setInteractionType("dian_zan");
        userAccountDO1.setInteractionEntry("hongbao_receive_rank");
        userAccountDO1.setExceptUserId(Long.valueOf(userId));
        userAccountDO1.setOrderByClause(" hbobtain_amount_times asc ");
        List<UserAccountDO> userAccountDOs2 = userAccountService.selectUserAccountInteraction(userAccountDO1, 1, 99,Long.valueOf(sellerId));
        if (CollectionUtils.isNotEmpty(userAccountDOs2)) {
            userAccountDOs.addAll(userAccountDOs2);
            if(userAccountDOs2.get(0).getHbobtainAmount()>=maxAmount){
                maxAmount=userAccountDOs2.get(0).getHbobtainAmount();
            }
        }

        try {
            String url = bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            map.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        map.put("maxAmount", maxAmount);
        map.put("userAccountDOs", userAccountDOs);
        map.put("sellerId", sellerId);
        map.put("userId", userId);

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_rank", map);
    }


    /**
     * 获取红包提现信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/hongbao/getCash")
    public ModelAndView hongBaoGetCash(HttpServletRequest request,String userId, String sellerId) {

        AssertsUtil.notBlank("userId", userId);

        /**
         * 获取用户账户信息
         */
        UserAccountDO userAccount =new UserAccountDO();
        Map<String, Object> map = Maps.newHashMap();
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setUserId(Long.valueOf(userId));
        List<UserAccountDO> userAccountDOs = userAccountService.getUserAccountWithUser(userAccountDO,Long.valueOf(sellerId));

        if(CollectionUtils.isNotEmpty(userAccountDOs)){
            userAccount=userAccountDOs.get(0);
        }

        /**
         * 获取规则信息
         */
        RuleConfig ruleConfigTemp = new RuleConfig();
        ruleConfigTemp.setType(RuleType.HB_CASH.getCode());
        RuleConfig ruleConfig = ruleConfigService.getRuleConfigByCondition(ruleConfigTemp,Long.valueOf(sellerId));

        if(ruleConfig==null){
            return new ModelAndView("/mobile/hongbao/suniu_hongbao_cash", map);
        }

        String ruleExpressions = ruleConfig.getValue();
        Rule rule = new Rule();

        try {
            rule = (Rule) JSONUtils.parseToObject(ruleExpressions, Rule.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuleEngineException("规则转换出错");
        }

        String hbCurrentCashAmount = "";
        String dayOfMonth = "";

        if(rule!=null&&CollectionUtils.isNotEmpty(rule.getRuleExpressions())){
            for (RuleExpression ruleExpression1 : rule.getRuleExpressions()) {
                if ("hbCurrentCashAmount".equals(ruleExpression1.getFact_attribute())) {
                    hbCurrentCashAmount = ruleExpression1.getExpectation_value();
                    hbCurrentCashAmount = hbCurrentCashAmount.substring(hbCurrentCashAmount.indexOf(",") + 1, hbCurrentCashAmount.length());
                }
                if ("dayOfMonth".equals(ruleExpression1.getFact_attribute())) {
                    dayOfMonth = ruleExpression1.getExpectation_value();
                }
            }
        }
        try {
            String url =bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            map.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        map.put("userAccount", userAccount);
        map.put("hbCurrentCashAmount", hbCurrentCashAmount);
        map.put("dayOfMonth", dayOfMonth);
        map.put("sellerId", sellerId);
        map.put("userId", userId);

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_cash", map);
    }


    /**
     * 红包提现
     *
     * @param userId
     * @param actionType 操作类型 unLimit:不限制提现金额 limit:限制提现金额
     * @return
     */
    @RequestMapping("/hongbao/cash")
    public
    @ResponseBody
    Map<String, Object> hongBaoCash(String userId, String hongbaoCashAmount,String actionType,String sellerId ) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(ERROR_CODE_KEY, ErrorCode.ERROR);

        RuleConfig ruleConfigTemp = new RuleConfig();
        ruleConfigTemp.setType(RuleType.HB_CASH.getCode());
        RuleConfig ruleConfig = ruleConfigService.getRuleConfigByCondition(ruleConfigTemp,Long.valueOf(sellerId));

        AssertsUtil.notNull(ruleConfig, "ruleConfig");
        AssertsUtil.notBlank("hongbaoCashAmount", hongbaoCashAmount);

        RuleContext ruleContext = new RuleContext(ruleConfig, RuleType.HB_CASH.getCode(),actionType,hongbaoCashAmount,Long.valueOf(sellerId));

        /**
         * 设置用户实际对象
         */
        AssertsUtil.notBlank("userId", userId);

        String hongbaoAmmount = "";

        User user= userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));
        UserVO userVO = new UserVO();
        BeanCopierUtils.copyProperties(user, userVO);

        ruleContext.addFactObj(UserVO.class.getName(), userVO);
        ruleContext.addFactObj(User.class.getName(), user);
        HBCashEngine hbCashEngine = new HBCashEngine(ruleContext);

        /**
         * 控制数据库允许放入的最大线程数
         */
        Boolean concurrentThreadLockFlag = executeHongBaoConcurrentControlHelper.getConcurrentThreadLock(HB_CONCURRENT_THREAD_NUM_TYPE, RECEIVE_HB_NAME);

        if (!concurrentThreadLockFlag) {

            returnMap.put(ERROR_MESSAGE_KEY, "红包提现的人过多，请稍后再试!");

            return returnMap;
        }

        try {

            /**
             *当为不限制提现时直接走执行,否则走正常引擎流程
             */
            EngineResult  engineResult=new EngineResult();

            if("unLimit".equals(actionType)){
                engineResult= hbCashEngine.execute();
            }else
                engineResult= hbCashEngine.start();

            if (EngineResult.ErrorCode.SYS_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, "系统繁忙，请与商家联系!");
                return returnMap;
            }

            if (EngineResult.ErrorCode.RULE_VERIFY_ERROR.equals(engineResult.getErrorCode())) {
                returnMap.put(ERROR_MESSAGE_KEY, engineResult.getErrorMessage());
                return  returnMap;
            }

        } catch (Exception e) {

            logger.error(e.getMessage());
            returnMap.put(ERROR_MESSAGE_KEY, e.getMessage());
            return returnMap;
        }finally {
            executeHongBaoConcurrentControlHelper.releaseBizConcurrentThreadLock();
        }

        returnMap.put(ERROR_CODE_KEY, ErrorCode.SUCCESS);
        returnMap.put(INFO_KEY, "红包提现成功!");

        return returnMap;
    }

    /**
     * 拆红包页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/hongbao/obtainPage")
    public ModelAndView hbObtain(HttpServletRequest request,String sellerId,ModelMap modelMap) {

        try {
            String url = bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            modelMap.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_obtain", modelMap);
    }

    /**
     * 拆完红包结果页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/hongbao/resultPage")
    public ModelAndView hbRestult(HttpServletRequest request,String sellerId,ModelMap modelMap) {

        try {
            String url = bundle.getString("crm.web.url")+ request.getServletPath() + "?" + request.getQueryString();
            Map<String, String> datas = wxService.getWxJsConfigIn(Long.valueOf(sellerId),url);
            modelMap.put("wxJsConfig", datas);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return new ModelAndView("/mobile/hongbao/suniu_hongbao_result", modelMap);
    }

}
