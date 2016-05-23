package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/19 下午6:08  
 */
public class EmailSendJob extends SyncJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SmsSendJob.class);

    @Autowired
    private SendSmsService smsSendService;

    /**
     * 任务名称
     *
     * @return
     */
    @Override
    public String jobName() {
        return JobConstant.JobName.SMS_SEND_JOB;
    }

    /**
     * 是否需要实现数据源切换，短信不需要做数据源切换，return false
     *
     * @return
     */
    @Override
    public boolean isChangeDataSoure() {
        return false;
    }


    @Override
    public void execute(JobContext jobContext) {

        logger.info("EmailSendJob is start");
        try {
            SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
            smsSendService.sendEmail(String.valueOf(sellerConfigInfo.getSellerId()));
        } catch (Exception e) {
            logger.error("EmailSendJob is error.", e);
        }


        logger.info("EmailSendJob is end");


    }
}
