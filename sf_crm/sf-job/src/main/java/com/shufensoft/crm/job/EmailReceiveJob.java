package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.send.SendSmsService;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/19 下午9:52  
 */
public class EmailReceiveJob extends SyncDataJob {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(EmailReceiveJob.class);


    @Autowired
    private SendSmsService sendService;

    @Override
    public String jobName() {
        return JobConstant.JobName.EMAIL_RECEIVE_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        syncEmailReport(jobContext);

    }

    /**
     * 接收email报告
     */
    private void syncEmailReport(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        /**
         * 1.获取起始时间
         */
        Date startDate = getStartDate();
        Date endDate = getEndDate();

        try {
            sendService.receiveEmailReport(sellerConfigInfo.getSellerId(), startDate, endDate);
        } catch (Exception e) {
            logger.error("EmailReceiveJob.syncEmailReport() is error.", e);
        }


    }
}
