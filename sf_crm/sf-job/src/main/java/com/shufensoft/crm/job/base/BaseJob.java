package com.shufensoft.crm.job.base;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.dataSource.DBContextHolder;
import com.shufensoft.crm.biz.domain.generation.job.JobDetail;
import com.shufensoft.crm.biz.domain.generation.job.JobLog;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.job.JobDetailService;
import com.shufensoft.crm.biz.service.job.JobLogService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                job基础类
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/14  
 */
public abstract class BaseJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseJob.class);

    /**
     * job上下文threadLocal,多个线程可能会同时竞争，
     * 所以这里需要写一个线程安全的ThreadLocal来保存job上下文
     */
    protected static final ThreadLocal<JobContext> jobContextHolder = new ThreadLocal<JobContext>();

    /**
     * 默认分页为40条
     */
    protected int pageSize = 40;

    protected boolean changeDataSoure;

    protected String jobName;

    protected static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public abstract String jobName();

    public abstract boolean isChangeDataSoure();

    protected static JobDetailService jobDetailService;

    private static JobLogService jobLogService;

    static {
        jobDetailService = (JobDetailService) SpringContextUtil.getBean("jobDetailService");
        jobLogService = (JobLogService) SpringContextUtil.getBean("jobLogService");
    }

    public List<SellerConfigInfo> getSellerConfigInfos() {

        return SellerConfigCache.getAll();

    }


    private void init(){

        if(StringUtils.isBlank(jobName)){
            jobName = jobName();
        }

        if(!changeDataSoure){
            changeDataSoure = isChangeDataSoure();
        }

    }

    /**
     * job运行方法
     */
    public void start() {

        /**
         * 初始化操作
         */
        init();

        try {
            run();
        } catch (Exception e) {

            String messge = e.getMessage()==null?e.toString():e.getMessage();
            logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:"+messge,e);

            saveJobLog(messge);
            saveJobDetail();
        }

    }

    public abstract void execute(JobContext jobContext);

    public abstract void run();

    public  void execute(SellerConfigInfo sellerConfigInfo){

        Date startDate = new Date();
        if (logger.isInfoEnabled()) {
            logger.info(jobName == null ? "job" : jobName +"[sellerId="+sellerConfigInfo.getSellerId()+"] start at " + simpleDateFormat.format(startDate));
        }

        try {

            /**
             * 切换到指定卖家数据源
             */
            if (changeDataSoure) {
                DBContextHolder.setDataSourceKey(String.valueOf(sellerConfigInfo.getDatasourceId()));
            }
            /**
             * 设置卖家信息到job上下文
             */
            JobContext jobContext = new JobContext();
            jobContext.setSellerConfigInfo(sellerConfigInfo);
            jobContextHolder.set(jobContext);

            /**
             * 执行业务操作
             */
            execute(jobContext);

        } catch (Exception e) {
            logger.error("BaseJob.run error", e);
            saveJobLog(e.getMessage());

        }

        saveJobDetail();

        Date endDate = new Date();
        if (logger.isInfoEnabled()) {
            logger.info(jobName == null ? "job" : jobName +"[sellerId="+sellerConfigInfo.getSellerId()+"] end at " + simpleDateFormat.format(new Date()) + "; cost times:" + (endDate.getTime() - startDate.getTime()) + " ms");
        }

    }

    /**
     * 记录这次job结束时间到jobDetail
     *
     * @return
     */
    protected boolean saveJobDetail() {

        JobDetail jobDetail = new JobDetail();

        jobDetail.setEndTime(new Date());
        jobDetail.setJobName(jobName);
        JobContext jobContext = jobContextHolder.get();
        if(jobContext!=null){
            SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
            if(sellerConfigInfo!=null){
                jobDetail.setSellerId(sellerConfigInfo.getSellerId());
            }
        }

        return jobDetailService.saveOrUpdateJobDetail(jobDetail);

    }

    /**
     * 记录job错误信息
     * @return
     */
    protected boolean saveJobLog(String message) {

        JobLog jobLog = new JobLog();
        jobLog.setErrorMsg(message);
        jobLog.setJobName(jobName);
        jobLog.setStatus("-1");
        JobContext jobContext = jobContextHolder.get();

        if(jobContext!=null){

            SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
            if(sellerConfigInfo!=null){
                jobLog.setSellerId(sellerConfigInfo.getSellerId());
            }

            Long shopId = (Long)jobContext.get(JobContext.JobContextKey.SHOP_ID);
            if(shopId !=null){
                jobLog.setShopId((Long)jobContext.get(JobContext.JobContextKey.SHOP_ID));
            }

        }

        return jobLogService.saveJobLog(jobLog);

    }

}
