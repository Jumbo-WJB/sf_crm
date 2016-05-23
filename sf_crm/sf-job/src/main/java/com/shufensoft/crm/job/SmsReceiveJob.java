package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 短信接收JOB
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/22 10:45  
 */
@Controller
public class SmsReceiveJob extends SyncJob {
    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SmsReceiveJob.class);

    @Autowired
    private SendSmsService smsSendService;


    @Override
    public String jobName() {
        return JobConstant.JobName.SMS_RECEIVE_JOB;
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

        logger.info("SmsReceiveJob execute start.");

        try {
            smsSendService.receiveSmsStatusReport(String.valueOf(sellerConfigInfo.getSellerId()), DaoConstant.SmsSend.SEND_NOTIFY);
            logger.info("receiveSmsStatusReport notify execute successful.");
        } catch (Exception e) {
            logger.error("receiveSmsStatusReport notify execute failed.", e);
        }

        try {
            smsSendService.receiveSmsStatusReport(String.valueOf(sellerConfigInfo.getSellerId()), DaoConstant.SmsSend.SEND_SALE);
            logger.info("receiveSmsStatusReport sale execute successful.");
        } catch (Exception e) {
            logger.error("receiveSmsStatusReport sale execute failed.", e);
        }


        logger.info("ReceiveSmsMo execute start.");

        try {
            smsSendService.receiveSmsMo(String.valueOf(sellerConfigInfo.getSellerId()), DaoConstant.SmsSend.SEND_NOTIFY);
            logger.info("ReceiveSmsMo notify execute successful.");
        } catch (Exception e) {
            logger.error("ReceiveSmsMo notify execute failed.", e);
        }

        try {
            smsSendService.receiveSmsMo(String.valueOf(sellerConfigInfo.getSellerId()), DaoConstant.SmsSend.SEND_SALE);
            logger.info("ReceiveSmsMo sale execute successful.");
        } catch (Exception e) {
            logger.error("ReceiveSmsMo sale execute failed.", e);
        }
        logger.info("SmsReceiveJob execute end.");
    }
}
