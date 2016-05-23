package com.shufensoft.crm.job.birthday;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.birthday.BirthdayService;
import com.shufensoft.crm.biz.service.birthday.vo.BirthdayConfigVO;
import com.shufensoft.crm.biz.service.birthday.vo.UserBirthdayReminderVO;
import com.shufensoft.crm.biz.service.send.SendService;
import com.shufensoft.crm.biz.service.send.vo.SmsVO;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.DateUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant.JobName;
import com.shufensoft.crm.job.base.AsyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 生日提醒
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class UserBirthdayRemindJob extends AsyncJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(UserBirthdayRemindJob.class);

    private static SendService sendService;

    private static BirthdayService birthdayService;

    static {

        sendService = (SendService) SpringContextUtil.getBean("sendService");
        birthdayService = (BirthdayService) SpringContextUtil.getBean("birthdayService");

    }

    @Override
    public String jobName() {
        return JobName.USER_BIRTHDAY_REMIND_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        birthdayRemind(sellerConfigInfo);

    }

    /**
     * 从活动开始执行，每天上午9点提醒第二天生日的用户
     */
    private void birthdayRemind(SellerConfigInfo sellerConfigInfo) {


        Date birthdayDate = DateUtil.getNDayStartTime(1);

        /**
         * 查出所有需要短信提醒的活动
         */
        List<BirthdayConfigVO> birthdayConfigVOs =  birthdayService.findAllBirthdayActivityConfigInfos();
        if(CollectionUtils.isEmpty(birthdayConfigVOs)){
            return;
        }

        for(BirthdayConfigVO birthdayConfigVO : birthdayConfigVOs){
            birthdayActivityRemind(birthdayDate, birthdayConfigVO.getBirthdayActivityId(), sellerConfigInfo);
        }


    }

    /**
     * 某个生日活动短信提醒
     * @param birthdayDate
     * @param birthdayActivityId
     * @param sellerConfigInfo
     */
    private void birthdayActivityRemind(Date birthdayDate, Long birthdayActivityId,SellerConfigInfo sellerConfigInfo){

        int start = 1;

        while (true) {

            try {

                /**
                 * 1.获取提醒用户
                 */
                pageSize = 100;
                List<UserBirthdayReminderVO> userBirthdayReminderVOs =
                                                        birthdayService.getBirthdayReminder(sellerConfigInfo.getSellerId(),
                                                                birthdayDate, birthdayActivityId, start, pageSize);


                if (CollectionUtils.isEmpty(userBirthdayReminderVOs)) {
                    break;
                }

                /**
                 * 2.发提醒短信
                 */
                sendRemindBirthdaySms(userBirthdayReminderVOs,sellerConfigInfo);


            } catch (Exception e) {

                String messge = e.getMessage() == null ? e.toString() : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                saveJobLog(messge);

            }
            start++;
        }
    }


    /**
     * 发送生日提醒短信
     * @param userBirthdayReminderVOs
     * @param sellerConfigInfo
     */
    private void sendRemindBirthdaySms(List<UserBirthdayReminderVO> userBirthdayReminderVOs,SellerConfigInfo sellerConfigInfo) {

        try {

            AssertsUtil.check(!CollectionUtils.isEmpty(userBirthdayReminderVOs),"userBirthdayReminderVOs");

            /**
             * 组装短信发送参数，发送短信
             */
            SmsVO smsVO = new SmsVO();
            smsVO.setSendTime(new Date());

            List<String> list = new ArrayList<String>();
            for(UserBirthdayReminderVO userBirthdayReminderVO :userBirthdayReminderVOs){
                list.add(userBirthdayReminderVO.getMobile());

            }

            smsVO.setSellerId(String.valueOf(sellerConfigInfo.getSellerId()));
            smsVO.setSaleType(DaoConstant.SmsSaleType.SMS_BIRTHDAY);
            smsVO.setContent(userBirthdayReminderVOs.get(0).getRemindContent());
            smsVO.setSendType("SMS");
            smsVO.setSign(sellerConfigInfo.getSmsNotifySign());
            smsVO.setSaleTitle(userBirthdayReminderVOs.get(0).getTitle());
            smsVO.setTargetNumberList(list);
            smsVO.setPassage(DaoConstant.SmsSend.SEND_NOTIFY);
            sendService.smsSend(smsVO);


        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
