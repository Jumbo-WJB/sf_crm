package com.shufensoft.crm.job.base;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 同步处理job(即卖家之间同步执行)
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/14  
 */
public abstract class SyncJob extends BaseJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SyncJob.class);

    @Override
    public void run() {

        List<SellerConfigInfo> sellerConfigInfos = getSellerConfigInfos();

        if (CollectionUtils.isEmpty(sellerConfigInfos)) {
            logger.error("SyncJob.run error, sellerConfigInfos is null");
            return;
        }

        for (SellerConfigInfo sellerConfigInfo : sellerConfigInfos) {

            try {
                execute(sellerConfigInfo);
            }catch (Exception e){
                String messge = e.getMessage()==null?" Null Pointer Exception":e.getMessage();
                logger.error("SyncJob.run error,errorMsg:"+messge,e);
                saveJobLog(messge);
                saveJobDetail();
            }
        }

    }

    @Override
    public abstract void execute(JobContext jobContext);
}
