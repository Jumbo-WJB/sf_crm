package com.shufensoft.crm.job.point;

import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant.JobName;
import com.shufensoft.crm.job.base.BaseJob;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 淘宝交易同步定时任务
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class BuyPointJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseJob.class);

    private static IPointService pointService;

    static {

        pointService = (IPointService) SpringContextUtil.getBean("pointService");

    }


    @Override
    public String jobName() {
        return JobName.BUY_POINT_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        createBuyPoint(jobContext.getSellerConfigInfo().getSellerId());

    }


    /**
     * 计算
     */
    private void createBuyPoint(Long sellrId) {

        /**
         * 1.获取积分计算的起始和结束时间
         */
        Date startDate = getStartDate();
        Date endDate = getEndDate();

        /**
         * 2.根据用户最近一次购买时间和购买次数算积分
         */

        try {

            //pointService.createBuyPoint(startDate, endDate, sellrId);

        } catch (Exception e) {

            String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
            logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

            saveJobLog(messge);
        }

    }

}
