package com.shufensoft.crm.polySpire.job.base;

import com.shufensoft.crm.biz.domain.generation.job.JobDetail;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.job.JobDetailService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.polySpire.exception.JobException;
import com.shufensoft.crm.polySpire.job.context.JobContext;
import com.shufensoft.crm.polySpire.job.context.JobContext.JobContextKey;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                数据同步相关的job
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/9  
 */
public abstract class SyncDataJob extends BaseJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SyncDataJob.class);

    private static JobDetailService jobDetailService;

    static {
        jobDetailService = (JobDetailService) SpringContextUtil.getBean("jobDetailService");
    }

    public void run() {

        try {

            SellerConfigInfo sellerConfigInfo = getSellerConfigInfo();

            AssertsUtil.notNull(sellerConfigInfo,"sellerConfigInfo");

            execute(sellerConfigInfo);

        } catch (Exception e) {
            logger.error("SyncDataJob.work error", e);
            throw new JobException("SyncDataJob.work error", e);

        }

    }

    /**
     * 获取同步数据开始时间
     *
     * @return
     */
    protected Date getStartDate() {

        JobContext jobContext = jobContextHolder.get();

        if (jobContext != null) {

            SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
            if (sellerConfigInfo != null) {
                return getStartDate(sellerConfigInfo.getSellerId(), null);
            }

        }

        return null;

    }


    /**
     * 获取同步数据开始时间
     *
     * @return
     */
    protected Date getStartDate(Long sellerId, Long shopId)  {

        JobDetail jobDetail = jobDetailService.findJobDetailByName(sellerId , shopId , jobName);
        JobContext jobContext = jobContextHolder.get();

        if(shopId !=null){
            jobContext.put(JobContextKey.SHOP_ID, shopId);
        }

        Date endTime = null;
        int intervalTime =0;

        if (jobDetail != null) {

            if (jobDetail.getEndSyncDataTime() != null) {

                endTime = jobDetail.getEndSyncDataTime();
            }

            if (jobDetail.getSyncDataIntervalTime() != null) {
                intervalTime = jobDetail.getSyncDataIntervalTime();
            }

        }

        /**
         * 将时间间隔保存到线程安全的ThreadLocal
         */
        jobContext.put(JobContextKey.INTERVAL_TIME, intervalTime==0?600:intervalTime);

        /**
         * 由于系统网络延迟等原因，可能会产生误差，故提前一分钟，防止数据同步遗漏
         */
        Date startDate;
        if(endTime!=null){
            startDate = DateUtils.addMinutes(endTime, -1);
        }else{
            Date date = new Date();
            startDate = DateUtils.addMinutes(date, -10);
        }

        jobContext.put(JobContextKey.START_DATE, startDate);

        return startDate;
    }

    /**
     * 获取同步数据结束时间
     *
     * @return
     */
    protected Date getEndDate() {

        JobContext jobContext = jobContextHolder.get();
        Date startDate = (Date) jobContext.get(JobContextKey.START_DATE);

        if (startDate == null) {
            return null;
        }

        int intervalTime = (Integer) jobContext.get(JobContextKey.INTERVAL_TIME);

        if (intervalTime == 0) {
            intervalTime = 600;
        }

        Date endDate;
        Date date = DateUtils.addSeconds(startDate, intervalTime);
        Date currentDate = new Date();
        if (date.after(currentDate)) {
            endDate = currentDate;
        } else {
            endDate = date;
        }

        jobContext.put(JobContextKey.END_DATE, endDate);
        return endDate;

    }

    /**
     * 记录这次同步时间到jobDetail，便于下次同步
     *
     * @return
     */
    @Override
    protected boolean saveJobDetail() {

        JobContext jobContext = jobContextHolder.get();
        Date endDate = null;

        JobDetail jobDetail = new JobDetail();
        jobDetail.setJobName(jobName);
        jobDetail.setEndTime(new Date());

        if (jobContext != null) {
            endDate = (Date) jobContext.get(JobContextKey.END_DATE);
            SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
            if (sellerConfigInfo != null) {
                jobDetail.setSellerId(sellerConfigInfo.getSellerId());
            }
            jobDetail.setSyncDataIntervalTime((Integer)jobContext.get(JobContextKey.INTERVAL_TIME));
            jobDetail.setShopId((Long)jobContext.get(JobContextKey.SHOP_ID));
        }

        jobDetail.setEndSyncDataTime(endDate);


        jobDetailService.saveOrUpdateJobDetail(jobDetail);

        return true;
    }

}
