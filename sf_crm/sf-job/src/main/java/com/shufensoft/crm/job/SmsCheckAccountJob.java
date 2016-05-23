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
 *  @ProjectName: sf_crm  
 *  @Description: 
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/24 15:49  
 */
public class SmsCheckAccountJob extends SyncJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SmsCheckAccountJob.class);

    @Autowired
    private SendSmsService smsSendService;


    @Override
    public String jobName() {
        return JobConstant.JobName.SMS_CHECK_ACCOUNT_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return false;
    }

    @Override
    public void execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        if (sellerConfigInfo == null) {
            logger.info("sellerConfigInfo is null.");
            return;
        }

        logger.info("SmsCheckAccountJob execute start.");

        try {

            smsSendService.smsCheckAccount(String.valueOf(sellerConfigInfo.getSellerId()));
            logger.info("SmsCheckAccountJob execute successful.");
        } catch (Exception e) {

            logger.error("SmsCheckAccountJob execute error.", e);
        }

        logger.info("SmsCheckAccountJob execute end.");
    }
}
