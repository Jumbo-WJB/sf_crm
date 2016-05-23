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
 *  @Description: 零点JOB
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/6/8 9:53  
 */
public class ZeroTimeJob extends SyncJob {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(ZeroTimeJob.class);

    /**
     * 短信服务
     */
    @Autowired
    private SendSmsService smsSendService;


    @Override
    public String jobName() {
        return JobConstant.JobName.ZERO_TIME_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return false;
    }

    @Override
    public void execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        logger.info("ZeroTimeJob execute start.");
        try {
            // 过期套餐计费
            smsSendService.checkSmsExpired(String.valueOf(sellerConfigInfo.getSellerId()));
            logger.info("checkSmsExpired successful.");
        } catch (Exception e) {
            logger.error("checkSmsExpired failed.", e);
        }

        logger.info("ZeroTimeJob execute start.");
    }
}
