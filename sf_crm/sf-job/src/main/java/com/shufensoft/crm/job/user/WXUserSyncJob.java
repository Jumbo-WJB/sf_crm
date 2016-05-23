package com.shufensoft.crm.job.user;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.wx.WXService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant.JobName;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 微信用户同步定时任务
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class WXUserSyncJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(WXUserSyncJob.class);

    @Autowired
    private static WXService wXService;

    static {

        wXService = (WXService) SpringContextUtil.getBean("wXService");

    }

    @Override
    public String jobName() {
        return JobName.WX_USER_SYNC_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        syncWxUser(sellerConfigInfo);

    }

    /**
     * 同步淘宝交易
     */
    private void syncWxUser(SellerConfigInfo sellerConfigInfo) {

        /**
         * 1.获取用户同步下一个openid
         */
        String syncFlagId = getSyncFlagId();

        /**
         * 2.同步微信用户
         */
        try {

            String openId = wXService.pullWXUserInfo(sellerConfigInfo.getSellerId(),syncFlagId);
            setSyncFlagId(openId);
        } catch (Exception e) {

            String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
            logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

            saveJobLog(messge);

        }


    }

}
