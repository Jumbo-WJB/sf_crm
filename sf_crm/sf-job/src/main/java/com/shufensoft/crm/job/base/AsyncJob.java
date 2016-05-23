package com.shufensoft.crm.job.base;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.common.threadPool.ThreadPoolExecutor;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                异步处理job（按卖家分线程）
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/14  
 */
public abstract class AsyncJob extends BaseJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(AsyncJob.class);

    public abstract void execute(JobContext jobContext);

    /**
     * job 工作
     */
    @Override
    public void run() {

        List<SellerConfigInfo> sellerConfigInfos = getSellerConfigInfos();

        if (CollectionUtils.isEmpty(sellerConfigInfos)) {
            logger.error("AsyncJob.work error, sellerConfigInfos is null");
            return;
        }
        ExecutorService executorService = new ThreadPoolExecutor();
        CompletionService<String> pool = new ExecutorCompletionService<String>(
                executorService);

        for (final SellerConfigInfo sellerConfigInfo : sellerConfigInfos) {

            /**
             * 异步执行业务操作
             */
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    execute(sellerConfigInfo);

                }
            });

            pool.submit(thread, "success");

        }

        executorService.shutdown();

        String result;

        for (int i=0 ; i<sellerConfigInfos.size(); i++) {

            try {

                result = pool.take().get();

                if (!StringUtils.equals(result, "success")) {
                    logger.error("AsyncJob.work error, errorMsg:" + result);
                }

            } catch (Exception e) {
                logger.error("AsyncJob.work error, errorMsg:" + e.getMessage(), e);
            }

        }



    }

}
