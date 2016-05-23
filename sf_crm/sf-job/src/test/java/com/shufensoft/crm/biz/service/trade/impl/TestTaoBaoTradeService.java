package com.shufensoft.crm.biz.service.trade.impl;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.defined.user.UserAccountDAO;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.dao.generation.rule.RuleConfigMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.defined.order.OrderJDDO;
import com.shufensoft.crm.biz.domain.defined.trade.OrderTaoBaoDO;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfigExample;
import com.shufensoft.crm.biz.domain.generation.seller.SellerPackageCount;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.helper.DatasourceHelper;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.biz.service.job.inter.IAccessTokenService;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.biz.service.seller.SellerConfigInfoService;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.user.UserService;
import com.shufensoft.crm.biz.vo.UserVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.exception.JobException;
import com.shufensoft.crm.ruleEngine.HBRuleEngine;
import com.shufensoft.crm.ruleEngine.context.RuleContext;
import com.shufensoft.crm.ruleEngine.domain.Rule;
import com.shufensoft.crm.ruleEngine.domain.RuleExpression;
import com.shufensoft.crm.ruleEngine.enums.RuleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/19  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestTaoBaoTradeService {

    @Autowired
    TaoBaoTradeService taoBaoTradeService;

    @Autowired
    JdTradeService jdTradeService;

    @Autowired
    UserService userService;

    @Autowired
    private SendSmsService smsSendService;

    @Autowired
    private HBObtainMapper hbObtainMapper;

    @Autowired
    private HBPoolMapper hbPoolMapper;

    @Autowired
    private HongbaoService hongbaoService;


    @Autowired
    private SendSmsService sendService;

    @Autowired
    private SendService sendServiceTest;


    @Autowired
    private RockService rockService;

    @Autowired
    private RuleConfigMapper ruleConfigMapper;

    @Autowired
    private UserAccountDAO userAccountDAO;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private   IAccessTokenService iAccessTokenService;

    @Autowired
    private SellerConfigInfoService sellerConfigInfoService;

    @Test
    public void testSaveOrUpdateTrade(){
        DBContextHolder.setDataSourceKey("1");
        TradeTaoBao tradeTaoBao = taoBaoTradeService.selectTradeTaoBaoByTid(1152800981187040l);
        List<OrderTaoBao> orderTaoBaos = taoBaoTradeService.selectOrderTaoBaosByTid(1152800981187040l);
        tradeTaoBao.setOrders(orderTaoBaos);
        taoBaoTradeService.saveOrUpdateTrade(tradeTaoBao);
    }

    @Test
    public void test(){

        OrderTaoBaoDO orderTaoBaoDO = new OrderTaoBaoDO();
        orderTaoBaoDO.setStartDate(  DateUtil.getDateFromString("2015-08-25 12:26:36"));
        orderTaoBaoDO.setEndDate(   DateUtil.getDateFromString("2015-08-25 12:56:36"));
        orderTaoBaoDO.setResult("goods");
        orderTaoBaoDO.setGroupByClause("invoice_no");
        orderTaoBaoDO.setSellerId(Long.valueOf(1));
        List<OrderTaoBaoDO> orderTaoBaoDOs = taoBaoTradeService.selectOrderTaoBaoWithComment(orderTaoBaoDO);

        OrderJDDO orderJDDO = new OrderJDDO();
        orderJDDO.setStartDate( DateUtil.getDateFromString("2015-08-25 02:26:36"));
        orderJDDO.setEndDate(DateUtil.getDateFromString("2015-08-25 02:56:36"));
        orderJDDO.setScore(5);
        orderJDDO.setGroupByClause("waybill");
        orderJDDO.setSellerId(Long.valueOf(1));
        List<OrderJDDO> orderJDs = jdTradeService.selectOrderJDWithComment(orderJDDO);

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
            User user= userService.findUserBySellerIdAndUserId(Long.valueOf(1), userId);
            UserVO userVO = new UserVO();
            BeanCopierUtils.copyProperties(user, userVO);
            userVO.setStartDate(DateUtil.getDateFromString("2015-08-25 02:26:36"));
            userVO.setEndDate(DateUtil.getDateFromString("2015-08-25 02:56:36"));
            userVO.setTaoBaoGoodCommentCount("0");
            userVO.setJdGoodCommentCount("0");
            Long poolId=7121282943l;
            RuleContext ruleContext = new RuleContext(poolId, RuleType.HB_POOL.getCode(),"hbPraiseBound","",Long.valueOf(1));
            ruleContext.addFactObj(UserVO.class.getName(), userVO);
            HBRuleEngine hbRuleEngine=new  HBRuleEngine(ruleContext);
            hbRuleEngine.start();
        }
        System.out.println("aaaa");

    }


    @Test
    public void  hbReutrunJobTest(){

        Long  sellerId =  1l;
        HBObtainExample hbObtainExample=new HBObtainExample();
        hbObtainExample.createCriteria().andHongbaoTypeEqualTo(DaoConstant.HongBaoType.SHAKE).andStatusEqualTo(DaoConstant.HBStatus.TO_RECEIVE).andUserIdIsNotNull().andObtainDatatimeLessThanOrEqualTo(DateUtil.getExpiredMinute(-30)).andSellerIdEqualTo(sellerId);

        /**
         * 分页处理,将超过失效时间的红包领用未拆记录解除用户绑定
         */
        int start=1;
        while(true){

            try{
                PageHelper.startPage(start, 30);
                List<HBObtain> hbObtains= hbObtainMapper.selectByExample(hbObtainExample);

                if(CollectionUtils.isEmpty(hbObtains)){
                    break;
                }

//                for(HBObtain hbObtain:hbObtains){
//                    Long  hbPoolId=hbObtain.getPoolId();
//                        hbObtain.setUserId(null);
//                        hbObtain.setObtainDatatime(null);
//                        hongbaoService.updateHbObtainAndPool(sellerId,hbObtain);
//                }
                start++;
            }catch (Exception e){
                String messge = e.getMessage()==null?" Null Pointer Exception":e.getMessage();

            }

        }
    }

    @Test
    public void  EmailSendJobTest(){
        smsSendService.sendEmail(1+"");
     }

    @Test
    public void EmailReceiveJob(){

        Date startDate = DateUtil.getDateFromString("2015-08-25 02:26:36");
        Date endDate = DateUtil.getDateFromString("2015-09-25 02:56:36");
        sendService.receiveEmailReport(1l,startDate, endDate);

    }

    @Test
    public void  SmsSendJobTest(){
        smsSendService.sendSms(1+"");
    }

    @Test
    public void ShakeExpireJobTest(){
       rockService.shakeExpired(1l);
    }


    @Test
    public void  SmsReceiveJobTest(){

        try {
            smsSendService.receiveSmsStatusReport("1",DaoConstant.SmsSend.SEND_NOTIFY);
        } catch (Exception e) {

        }

        try {
            smsSendService.receiveSmsStatusReport("1",DaoConstant.SmsSend.SEND_SALE);
        } catch (Exception e) {
        }

        try {
            smsSendService.receiveSmsMo("1",DaoConstant.SmsSend.SEND_NOTIFY);
        } catch (Exception e) {
        }

        try {
            smsSendService.receiveSmsMo("1",DaoConstant.SmsSend.SEND_SALE);
        } catch (Exception e) {
        }
    }


    @Test
    public  void   smsCheckAccountTest(){
        smsSendService.smsCheckAccount("1");
    }


     @Test
    public  void   RefreshTokenJobTest(){

         String content = "亲,您的京东授权已经过期， 为不影响我们继续对您服务, 请重新授权一下, 有问题可以联系我们的客服人员, 谢谢啊s";
         sendServiceTest.sendSms(String.valueOf(1),DaoConstant.SmsSaleType.SMS_TOKEN_REFRESH,
                 DaoConstant.SmsSend.SEND_NOTIFY,"18768183733",content,DaoConstant.SmsFatigueFlag.IS_FATIGUE);

      //    iAccessTokenService.refreshTokenByShop(  sellerConfigInfoService.getSellerConfigInfoBySellerId(2L));
    }

    @Test
    public  void  HbCashJobTest(){

//        try{
//            SmsVO smsVO = new SmsVO();
//            smsVO.setContent("您的短信剩余数为" + 2 + "条,短信提醒需发送" + 2 + ",为了保证您的正常使用请及时续费");
//            List<String> strings = new ArrayList<String>();
//            smsVO.setSign("速牛科技");
//            strings.add("18768183733");
//            smsVO.setTargetNumberList(strings);
//            smsVO.setSendType("SMS");
//            smsVO.setSellerId(1+"");
//            smsVO.setSaleType(DaoConstant.SmsSaleType.HONGBAO_CASH);
//            smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
//            smsVO.setFatigue(DaoConstant.SmsFatigueFlag.IS_FATIGUE);
//            sendServiceTest.smsSend(smsVO);
//        }catch (Exception e){
//           e.printStackTrace();
//        }

        Long  sellerId=1l;
        /**
         * 从数据库获取红包提现的配置规则
         */
        RuleConfigExample ruleConfigExample=new RuleConfigExample();
        ruleConfigExample.createCriteria().andTypeEqualTo("HB_CASH").andSellerIdEqualTo(sellerId);
        List<RuleConfig> ruleConfigs= ruleConfigMapper.selectByExample(ruleConfigExample);

        if(!CollectionUtils.isEmpty(ruleConfigs)) {

            RuleConfig ruleConfig = ruleConfigs.get(0);
            String ruleExpression = ruleConfig.getValue();
            Rule rule = new Rule();

            try {
                rule = (Rule) JSONUtils.parseToObject(ruleExpression, Rule.class);
            } catch (Exception e) {
                throw new JobException("规则转换出错!");
            }

            int curYear = Calendar.getInstance().get(Calendar.YEAR);
            int curMon = Calendar.getInstance().get(Calendar.MONTH);
            int curDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int curHourfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int expectDayOfMonth = 0;
            String smsContent = "";
            String remindDate = "";

            for (RuleExpression ruleExpression1 : rule.getRuleExpressions()) {
                /**
                 * 获取短信期望发送日子
                 */
                if ("dayOfMonth".equals(ruleExpression1.getFact_attribute())) {
                    String expectation_value = ruleExpression1.getExpectation_value();
                    String[] strings = expectation_value.split(",");
                    String dayOfMonth = strings[0];
                    expectDayOfMonth = Integer.valueOf(dayOfMonth) - 1;
                }

                /**
                 * 获取短信发送内容和短信提醒日期
                 */
                if ("smsVerify".equals(ruleExpression1.getFact_attribute())) {
                    smsContent = ruleExpression1.getExpectation_value();
                    remindDate = ruleExpression1.getOperator();
                }

            }

            if (expectDayOfMonth != curDayOfMonth) {
                /**
                 * 获取红包账户余额大于0的用户作为发送对象
                 */
                UserAccountExample userAccountExample = new UserAccountExample();
                userAccountExample.createCriteria().andHongbaoAmountGreaterThan(Long.valueOf(0)).andSellerIdEqualTo(sellerId);
                int userCount = userAccountMapper.countByExample(userAccountExample);
                DatasourceHelper.setDatasource("1");
                SellerPackageCount sellerPackageCount = sendServiceTest.querySellerPackageCountBySellerID(sellerId.toString(),"sms");
                //获取短信剩余数量
                Long sellerPackageRemain = sellerPackageCount.getSellerPackageRemain();

                /**
                 * 当短信剩余不足,提醒商家充值
                 */
                if (sellerPackageRemain < userCount) {
                    SmsVO smsVO = new SmsVO();
                    smsVO.setContent("您的短信剩余数为" + sellerPackageRemain + "条,短信提醒需发送" + userCount + ",为了保证您的正常使用请及时续费");
                    List<String> strings = new ArrayList<String>();
                    strings.add("18768183733");
                    smsVO.setTargetNumberList(strings);
                    smsVO.setSendType("SMS");
                    smsVO.setSellerId(sellerId.toString());
                    smsVO.setSaleType(DaoConstant.SmsSaleType.HONGBAO_CASH);
                    smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
                    sendServiceTest.smsSend(smsVO);
                }

                UserAccountDO userAccountDO = new UserAccountDO();
                userAccountDO.setHongbaoAmount(Long.valueOf(0));
                userAccountDO.setSellerId(sellerId);

//                /**
//                 * 当期望提醒时间与当前时间相等时,给用户群发短信
//                 * 触发器每半小时触发一次，固判断当前时间段前半个小时是否满足预期时间条件
//                 * 设置预期时间30分钟后发,避免错误率
//                 */
//                if (curHourfDay == Long.valueOf(remindDate)) {
//
//                    SmsVO smsVO = new SmsVO();
//                    smsVO.setSign("速牛科技");
//                    smsVO.setContent(smsContent);
//                    smsVO.setSaleType(DaoConstant.SmsSaleType.HONGBAO_CASH);
//                    smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
//                    smsVO.setSendType("SMS");
//
//                    Calendar cal = Calendar.getInstance();
//                    cal.set(curYear, curMon, curDayOfMonth, curHourfDay, 0, 0);
//                    Date startTime = cal.getTime();
//
//                    Calendar cal1 = Calendar.getInstance();
//                    cal1.set(curYear, curMon, curDayOfMonth, curHourfDay, 30, 59);
//                    Date endTime = cal1.getTime();
//                    Date date = new Date();
//                    smsVO.setSellerId(sellerId.toString());
//
//                    if (date.compareTo(startTime) >= 0 && date.compareTo(endTime) <= 0) {
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.add(Calendar.MINUTE, 30);
//                        smsVO.setSendTime(calendar.getTime());
//
//                        /**
//                         * 分页处理发送请求
//                         */
//                        int start = 1;
//                        while (true) {
//
//                            try {
//                                PageHelper.startPage(start, 30);
//                                List<UserAccountDO> userAccountDOs = userAccountDAO.selectUserAccountWithUser(userAccountDO);
//
//                                if (CollectionUtils.isEmpty(userAccountDOs)) {
//                                    break;
//                                }
//
//                                List<String> strings = new ArrayList<String>();
//                                for (UserAccountDO userAccount : userAccountDOs) {
//                                    strings.add(userAccount.getMobile());
//                                }
//
//                                smsVO.setTargetNumberList(strings);
//                                sendServiceTest.smsSend(smsVO);
//
//                                start++;
//                            } catch (Exception e) {
//                            }
//
//                        }

//                    }

 //               }
            }
        }
    }


    public static void main(String[] args) {
        // 获取所有待发的用户手机号码
        List<String> targetNumberList = new ArrayList<String>();
        targetNumberList.add("12323");
        targetNumberList.add("12325");
        targetNumberList.add("12324");
        targetNumberList.add("12323");
        // 目标号码去重处理
        HashSet<String> targetNumberSet = new HashSet<String>(targetNumberList);
        for(String a:targetNumberSet){
            System.out.println(a);
        }
    }
}
