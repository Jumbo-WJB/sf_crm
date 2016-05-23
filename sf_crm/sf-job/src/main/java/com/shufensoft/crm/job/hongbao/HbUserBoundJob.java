package com.shufensoft.crm.job.hongbao;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import com.shufensoft.crm.biz.domain.generation.job.JobDetail;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.job.JobDetailService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import com.shufensoft.crm.ruleEngine.HBRuleEngine;
import com.shufensoft.crm.ruleEngine.cache.RuleCache;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>红包用户绑定定时任务</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/19  
 */
public class HbUserBoundJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(HbUserBoundJob.class);


    private static TaoBaoTradeService taoBaoTradeService;

    private static JdTradeService jdTradeService;


    private static UserService userService;


    @Autowired
    private RuleConfigMapper ruleConfigMapper;

    @Autowired
    private HBObtainMapper hbObtainMapper;


    @Autowired
    private HBPoolMapper hbPoolMapper;

    private static JobDetailService jobDetailService;


    static {
        taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");
        jdTradeService = (JdTradeService) SpringContextUtil.getBean("jdTradeService");
        userService = (UserService) SpringContextUtil.getBean("userService");
        jobDetailService = (JobDetailService) SpringContextUtil.getBean("jobDetailService");

    }


    @Override
    public String jobName() {
        return JobConstant.JobName.HBUSERBOUND_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {
        syncHbUserBound(jobContext);
    }


    public void syncHbUserBound(JobContext jobContext) {

        Long  sellerId=jobContext.getSellerConfigInfo().getSellerId();
        /**
         * 获取好评返红包规则
         */
        HBPoolExample hbPoolExample = new HBPoolExample();
        hbPoolExample.createCriteria().andTypeEqualTo("praise").andSellerIdEqualTo(sellerId);
        List<HBPool> hbPools = hbPoolMapper.selectByExample(hbPoolExample);

        AssertsUtil.check(CollectionUtils.isNotEmpty(hbPools), " HbUserBoundJob excuete hbPools is null ");

        long hbPoolId = hbPools.get(0).getPoolId();

        Rule rule = RuleCache.get(hbPoolId + "", RuleType.HB_POOL.getCode(),sellerId);
        AssertsUtil.notNull(rule, "rule");
        List<RuleExpression> ruleExpressions = rule.getRuleExpressions();

        /**
         * 获取好评红包活动开始结束时间
         */
        String beginDate = "";
        String stopDate = "";
        String   taoBaoGoodCommentCount="";
        String   jdGoodCommentCount="";

        for (RuleExpression ruleExpression : ruleExpressions) {
            if ("currentTime".equals(ruleExpression.getFact_attribute())) {
                String date = ruleExpression.getExpectation_value();
                String[] array = date.split(",");
                beginDate = array[0];
                stopDate = array[1];
            }else if("taoBaoGoodCommentCount".equals(ruleExpression.getFact_attribute())){
                taoBaoGoodCommentCount=ruleExpression.getExpectation_value();
            }else if("jdGoodCommentCount".equals(ruleExpression.getFact_attribute())){
                jdGoodCommentCount=ruleExpression.getExpectation_value();
            }
        }

        Date  startDate = this.getStartDate();
        Date  endDate = null;

        if(new Date().after(DateUtil.getDateFromString(stopDate))){
            return;
        }

        JobDetail jobDetail=jobDetailService.findJobDetailByName(sellerId,null,jobName);

        if(jobDetail==null){
            startDate = DateUtil.getDateFromString(beginDate);
        }

        endDate = this.getEndDate(startDate);


        /**
         * 分页处理
         */
        int start = 1;
        while (true) {

            try {

                PageHelper.startPage(start, pageSize);

                List<OrderTaoBaoDO> orderTaoBaoDOs=new ArrayList<OrderTaoBaoDO>();
                List<OrderJDDO> orderJDs=new ArrayList<OrderJDDO>();

                if(StringUtils.isNotBlank(taoBaoGoodCommentCount)){
                    OrderTaoBaoDO orderTaoBaoDO = new OrderTaoBaoDO();
                    orderTaoBaoDO.setStartDate(startDate);
                    orderTaoBaoDO.setEndDate(endDate);
                    orderTaoBaoDO.setResult("good");
                    orderTaoBaoDO.setGroupByClause("invoice_no");
                    orderTaoBaoDO.setSellerId(sellerId);
                    orderTaoBaoDOs = taoBaoTradeService.selectOrderTaoBaoWithComment(orderTaoBaoDO);
                }

              if(StringUtils.isNotBlank(jdGoodCommentCount)){
                  OrderJDDO orderJDDO = new OrderJDDO();
                  orderJDDO.setStartDate(startDate);
                  orderJDDO.setEndDate(endDate);
                  orderJDDO.setScore(5);
                  orderJDDO.setGroupByClause("waybill");
                  orderJDDO.setSellerId(sellerId);
                  orderJDs = jdTradeService.selectOrderJDWithComment(orderJDDO);
              }

                if (CollectionUtils.isEmpty(orderTaoBaoDOs)&&CollectionUtils.isEmpty(orderJDs)) {
                    return;
                }

                List<Long>  userIds=new ArrayList<Long>();

                for (OrderTaoBaoDO orderTaoBao : orderTaoBaoDOs) {

                    long userId = orderTaoBao.getUserId();
                    userIds.add(userId);

                }

                for(OrderJDDO orderJD:orderJDs){

                    long userId=orderJD.getUserId();
                    if(!userIds.contains(userId)){
                        userIds.add(userId);
                    }

                }

                for(long userId:userIds){

                    User user= userService.findUserBySellerIdAndUserId(jobContext.getSellerConfigInfo().getSellerId(), userId);
                    UserVO userVO = new UserVO();
                    BeanCopierUtils.copyProperties(user, userVO);
                    userVO.setStartDate(startDate);
                    userVO.setEndDate(endDate);
                    userVO.setTaoBaoGoodCommentCount(taoBaoGoodCommentCount);
                    userVO.setJdGoodCommentCount(jdGoodCommentCount);
                    RuleContext ruleContext = new RuleContext(Long.valueOf(hbPoolId),RuleType.HB_POOL.getCode(),"hbPraiseBound","",sellerId);
                    ruleContext.addFactObj(UserVO.class.getName(), userVO);
                    HBRuleEngine   hbRuleEngine=new  HBRuleEngine(ruleContext);
                    hbRuleEngine.start();

                }

                start++;
            } catch (Exception e) {
                String messge = e.getMessage()==null?" Null Pointer Exception":e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:"+messge,e);

                saveJobLog(messge);
            }
        }

    }

}


