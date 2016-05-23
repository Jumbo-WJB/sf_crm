package com.shufensoft.crm.job.hongbao;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.user.UserAccountDAO;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.exception.JobException;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 红包提现提醒定时任务
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/14 21:32  
 */
public class HbCashJob  extends SyncJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(HbCashJob.class);

    @Autowired
    private RuleConfigMapper ruleConfigMapper;

    @Autowired
    private UserAccountDAO   userAccountDAO;

    @Autowired
    private UserAccountMapper userAccountMapper;


    private static UserService userService;

    private static SendService sendService;


    static{
        sendService = (SendService) SpringContextUtil.getBean("sendService");
        userService=  (UserService) SpringContextUtil.getBean("userService");
    }


    @Override
    public String jobName() {
        return JobConstant.JobName.HBCASH_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void execute(JobContext jobContext) {

        Long  sellerId=jobContext.getSellerConfigInfo().getSellerId();

        /**
         * 从数据库获取红包提现的配置规则
         */
        RuleConfigExample  ruleConfigExample=new RuleConfigExample();
        ruleConfigExample.createCriteria().andTypeEqualTo("HB_CASH").andSellerIdEqualTo(sellerId);
        List<RuleConfig> ruleConfigs= ruleConfigMapper.selectByExample(ruleConfigExample);

           if(!CollectionUtils.isEmpty(ruleConfigs)){

                RuleConfig   ruleConfig=ruleConfigs.get(0);
                String  ruleExpression= ruleConfig.getValue();
                Rule rule=new Rule();

               try{
                   rule=(Rule)  JSONUtils.parseToObject(ruleExpression,Rule.class);
                  }catch (Exception e){
                   logger.error(e.getMessage());
                   throw  new JobException("规则转换出错!");
               }

            int  curYear=Calendar.getInstance().get(Calendar.YEAR);
            int  curMon=Calendar.getInstance().get(Calendar.MONTH);
            int  curDayOfMonth=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int  curHourfDay=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int  expectDayOfMonth = 0;
            String  smsContent="";
            String   remindDate="";

            for(RuleExpression ruleExpression1:rule.getRuleExpressions()){
                /**
                 * 获取短信期望发送日子
                 */
                if("dayOfMonth".equals(ruleExpression1.getFact_attribute())){
                    String expectation_value =  ruleExpression1.getExpectation_value();
                    String[] strings=expectation_value.split(",");
                    String   dayOfMonth= strings[0];
                    expectDayOfMonth=Integer.valueOf(dayOfMonth)-1;
                }

                /**
                 * 获取短信发送内容和短信提醒日期
                 */
                if("smsVerify".equals(ruleExpression1.getFact_attribute())){
                    smsContent=  ruleExpression1.getExpectation_value();
                    remindDate=ruleExpression1.getOperator();
                }

            }

            if(expectDayOfMonth==curDayOfMonth){
                /**
                 * 获取红包账户余额大于0的用户作为发送对象
                 */
                UserAccountExample userAccountExample=new UserAccountExample();
                userAccountExample.createCriteria().andHongbaoAmountGreaterThan(Long.valueOf(0)).andSellerIdEqualTo(sellerId);
                int  userCount=  userAccountMapper.countByExample(userAccountExample);
                SellerPackageCount sellerPackageCount= sendService.querySellerPackageCountBySellerID(sellerId.toString(),"sms");
                //获取短信剩余数量
                Long   sellerPackageRemain  = sellerPackageCount.getSellerPackageRemain();

                /**
                 * 当短信剩余不足,提醒商家充值
                 */
                if(sellerPackageRemain<userCount){
                    SmsVO  smsVO=new SmsVO();
                    smsVO.setContent("您的短信剩余数为" + sellerPackageRemain + "条,短信提醒需发送" + userCount + ",为了保证您的正常使用请及时续费");
                    List<String>  strings=new ArrayList<String>();
                    smsVO.setSign(jobContext.getSellerConfigInfo().getSellerName());
                    strings.add(jobContext.getSellerConfigInfo().getMobile());
                    smsVO.setTargetNumberList(strings);
                    smsVO.setSendType("SMS");
                    smsVO.setSellerId(sellerId.toString());
                    smsVO.setSaleType(DaoConstant.SmsSaleType.HONGBAO_CASH);
                    smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
                    smsVO.setFatigue(DaoConstant.SmsFatigueFlag.IS_FATIGUE);
                    sendService.smsSend(smsVO);
                    return;
                }

                UserAccountDO  userAccountDO=new UserAccountDO();
                userAccountDO.setHongbaoAmount(Long.valueOf(0));
                userAccountDO.setSellerId(sellerId);

                /**
                 * 当期望提醒时间与当前时间相等时,给用户群发短信
                 * 触发器每半小时触发一次，固判断当前时间段前半个小时是否满足预期时间条件
                 * 设置预期时间30分钟后发,避免错误率
                 */
                if(curHourfDay==Long.valueOf(remindDate)){

                    SmsVO  smsVO=new SmsVO();
                    smsVO.setSign(jobContext.getSellerConfigInfo().getSellerName());
                    smsVO.setContent(smsContent);
                    smsVO.setSaleType(DaoConstant.SmsSaleType.HONGBAO_CASH);
                    smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
                    smsVO.setFatigue(DaoConstant.SmsFatigueFlag.IS_FATIGUE);
                    smsVO.setSendType("SMS");

                    Calendar cal = Calendar.getInstance();
                    cal.set(curYear,curMon,curDayOfMonth,curHourfDay,0,0);
                    Date startTime=  cal.getTime();

                    Calendar cal1 = Calendar.getInstance();
                    cal1.set(curYear,curMon,curDayOfMonth,curHourfDay,30,59);
                    Date endTime=  cal1.getTime();
                    Date  date=new Date();
                    smsVO.setSellerId(sellerId.toString());

                    if(date.compareTo(startTime)>=0&&date.compareTo(endTime)<=0){
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.MINUTE, 30);
                        smsVO.setSendTime(calendar.getTime());

                        /**
                         * 分页处理发送请求
                         */
                        int start=1;
                        while(true){

                            try{
                                PageHelper.startPage(start, pageSize);
                                List<UserAccountDO>  userAccountDOs=userAccountDAO.selectUserAccountWithUser(userAccountDO);

                                if(CollectionUtils.isEmpty(userAccountDOs)){
                                    return;
                                }

                                List<String>  strings=new ArrayList<String>();
                                for(UserAccountDO  userAccount:userAccountDOs){
                                    strings.add(userAccount.getMobile());
                                }

                                smsVO.setTargetNumberList(strings);
                                sendService.smsSend(smsVO);

                                start++;
                            }catch (Exception e){
                                String messge = e.getMessage()==null?" Null Pointer Exception":e.getMessage();
                                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:"+messge,e);

                                saveJobLog(messge);

                            }

                    }

                    }

                }

            }
         }
    }

}
