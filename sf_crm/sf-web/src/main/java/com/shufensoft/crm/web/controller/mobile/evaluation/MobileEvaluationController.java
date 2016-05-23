package com.shufensoft.crm.web.controller.mobile.evaluation;

import com.google.common.collect.Maps;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.ruleConfig.RuleConfigService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserAccountService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.HBPoolVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import com.shufensoft.crm.web.controller.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
*   
*  @ProjectName: sf-crm 
*  @Description: <p>评价手机端</p>
*  @author chenyong  chenyong@suniusoft.com
*  @date 2015/7/9  
*/
@RequestMapping("/mobile")
@Controller
public class MobileEvaluationController extends BaseController {

   public  static  final Logger logger=Logger.getLogger(MobileEvaluationController.class);

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    @Autowired
    private JdTradeService jdTradeService;

    @Autowired
    private RuleConfigService ruleConfigService;

    @Autowired
    private HongbaoService hongbaoService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/evaluate")
    public ModelAndView getEvaluation(String userId,String sellerId) {

        AssertsUtil.notNull(userId,"userId");

        Map<String, Object> map = Maps.newHashMap();

        User user=userService.findUserBySellerIdAndUserId(Long.valueOf(sellerId), Long.valueOf(userId));

        /**
         * 获取好评排行信息
         */
        List<UserAccountDO>  userAccountDOs =new ArrayList<UserAccountDO>();
        UserAccountDO userAccountDO=new UserAccountDO();

        /**
         * 获取属于自己的记录
         */
        UserAccountDO userAccount=new UserAccountDO();
        userAccountDO.setUserId(Long.valueOf(userId));
        List<UserAccountDO>  userAccountDOs1=userAccountService.selectUserAccountInteraction(userAccountDO,1,1,Long.valueOf(sellerId));
        if(CollectionUtils.isNotEmpty(userAccountDOs1)){
            userAccount=   userAccountDOs1.get(0);
            userAccountDOs.add(userAccount);
        }

        userAccountDO.setUserId(null);
        userAccountDO.setExceptUserId(Long.valueOf(userId));
        userAccountDO.setOrderByClause(" hbpraise_amount_times asc ");
        List<UserAccountDO>  userAccountDOTemps=userAccountService.selectUserAccountInteraction(userAccountDO,1,49,Long.valueOf(sellerId));
        if(CollectionUtils.isNotEmpty(userAccountDOTemps)){
           userAccountDOs.addAll(userAccountDOTemps);
        }

        /**
         * 获取淘宝好评的订单记录
         */
        RuleConfig ruleConfigTemp=new RuleConfig();
        ruleConfigTemp.setType(RuleType.HB_PRAISE.getCode());
        RuleConfig ruleConfig=ruleConfigService.getRuleConfigByCondition(ruleConfigTemp,Long.valueOf(sellerId));

        AssertsUtil.notNull(ruleConfig,"ruleConfig");

        HBPoolVO hbPoolVO=new HBPoolVO();
        hbPoolVO.setType(DaoConstant.HongBaoType.PRAISE);
        hbPoolVO.setIsDeleted(DaoConstant.IsDeleted.FALSE);
        List<HBPool> hbPools= hongbaoService.getHbPoolLis(hbPoolVO,Long.valueOf(sellerId));

        if(CollectionUtils.isEmpty(hbPools)){
            map.put("rank",userAccountDOs);
            map.put("userAccount",userAccount);
            map.put("sellerId",sellerId);
            map.put("userId",userId);
            map.put("user",user);
            return new ModelAndView("/mobile/evaluation/suniu_evaluation",map);
        }

        Rule rule= RuleCache.get(hbPools.get(0).getPoolId()+"", RuleType.HB_PRAISE.getCode(),Long.valueOf(sellerId));

        AssertsUtil.notNull(rule,"rule");

        String  denomination="";
        String startDate="";

        for(RuleExpression expression:rule.getRuleExpressions()){
           if("denomination".equals(expression.getFact_attribute())){
            String   expectValue= expression.getExpectation_value();
             String[]  strArray= expectValue.split("/");
               denomination=strArray[0];
           }else if("currentTime".equals(expression.getFact_attribute())){
               String   date=expression.getExpectation_value();
               String[]  array=date.split(",");
               startDate= array[0];
           }
        }


        int  totalPraseOrders=0;
        long  totalPrase=0;
        List<OrderTaoBaoDO> orderTaoBaoDOs=new ArrayList<OrderTaoBaoDO>();
        List<OrderJDDO>  orderJDs=new ArrayList<OrderJDDO>();
        /**
         * 获取淘宝订单信息
         */
        if(userAccount.getUserIdTb()!=null){
            OrderTaoBaoDO orderTaoBaoDO=new OrderTaoBaoDO();
            orderTaoBaoDO.setStartDate(DateUtil.getDateFromString(startDate));
            orderTaoBaoDO.setResult("good");
            orderTaoBaoDO.setUserIdTb(userAccount.getUserIdTb());
            orderTaoBaoDO.setUserId(Long.valueOf(userId));
            orderTaoBaoDO.setSellerId(Long.valueOf(sellerId));
            orderTaoBaoDOs=taoBaoTradeService.selectOrderTaoBaoWithCommentAndUser(orderTaoBaoDO);
            orderTaoBaoDO.setGroupByClause("invoice_no");
            List<OrderTaoBaoDO> orderTaoBaoDOs1=taoBaoTradeService.selectOrderTaoBaoWithCommentAndUser(orderTaoBaoDO);
            totalPraseOrders+=orderTaoBaoDOs.size();
            totalPrase+=orderTaoBaoDOs1.size();
        }


        /**
         * 获取京东订单信息
         */
        if(userAccount.getUserIdJd()!=null){
            OrderJDDO orderJDDO=new OrderJDDO();
            orderJDDO.setStartDate(DateUtil.getDateFromString(startDate));
            orderJDDO.setScore(5);
            orderJDDO.setUserId(Long.valueOf(userId));
            orderJDDO.setUserIdJd(userAccount.getUserIdJd());
            orderJDDO.setSellerId(Long.valueOf(sellerId));
            orderJDs= jdTradeService.selectOrderJDWithCommentAndUser(orderJDDO);
            orderJDDO.setGroupByClause("waybill");
            List<OrderJDDO>  orderJDs1= jdTradeService.selectOrderJDWithCommentAndUser(orderJDDO);
            totalPraseOrders+=orderJDs.size();
            totalPrase+=orderJDs1.size();
        }

        long  totalPraseMoney=(totalPrase)*Long.valueOf(denomination);
        //获取累计参与人数
        int  totalPartakeCount=hongbaoService.getObtianHbPraseCount(Long.valueOf(sellerId));

        HBPool hbPool=  hongbaoService.getHbPoolSum(new HBPool(),Long.valueOf(sellerId));
        long  totalAmount=0;
        if(hbPool!=null){
            totalAmount= hbPool.getSumTotalAmount();
        };

        map.put("rank",userAccountDOs);
        map.put("userAccount",userAccount);
        map.put("totalPraseOrders",totalPraseOrders);
        map.put("totalPraseMoney",totalPraseMoney);
        map.put("totalPartakeCount",totalPartakeCount);
        map.put("totalAmount",totalAmount);
        map.put("orderTaoBaoDOs",orderTaoBaoDOs);
        map.put("orderJDs",orderJDs);
        map.put("denomination",Long.valueOf(denomination));
        map.put("sellerId",sellerId);
        map.put("userId",userId);
        map.put("user",user);

        return new ModelAndView("/mobile/evaluation/suniu_evaluation",map);
    }
}
