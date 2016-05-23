package com.shufensoft.crm.job.point;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.rock.RockService;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   
 *  @ProjectName: sf_crm  
 *  @Description: 摇一摇领取过期处理
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/6/8 9:53  
 */
public class ShakeExpireJob extends SyncJob {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(ShakeExpireJob.class);

    /**
     * 摇一摇服务
     */
    @Autowired
    private RockService rockService;


    @Override
    public String jobName() {

        return JobConstant.JobName.SHAKE_POINT_EXPIRE;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void execute(JobContext jobContext) {
        logger.info("ShakeExpireJob execute start.");

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        try {

            /**
             * 摇一摇领取过期处理
             */
            rockService.shakeExpired(sellerConfigInfo.getSellerId());

            logger.info("ShakeExpireJob successful.");
        } catch (Exception e) {

            logger.error("ShakeExpireJob failed.", e);
        }

        logger.info("ShakeExpireJob execute start.");
    }
}
