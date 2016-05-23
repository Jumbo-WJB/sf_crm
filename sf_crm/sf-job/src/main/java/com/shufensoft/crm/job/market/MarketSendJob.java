package com.shufensoft.crm.job.market;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.service.market.MarketService;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 营销发送JOB
 *  @author zoujian  zoujian@shufensoft.com
 *  @date 2015/5/22 10:45  
 */
@Controller
public class MarketSendJob extends SyncJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(MarketSendJob.class);

    @Autowired
    private MarketService marketService;

    /**
     * 任务名称
     *
     * @return
     */
    @Override
    public String jobName() {
        return JobConstant.JobName.MARKET_SEND_JOB;
    }

    /**
     * 是否需要实现数据源切换，return false
     *
     * @return
     */
    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    /**
     * 实现业务逻辑，当作单个卖家处理即可，底层已封装，如果需要卖家信息可以从JobContext获取
     *
     * @param jobContext
     */
    public void execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        try {
            marketService.marketActivitySendSms(sellerConfigInfo.getSellerId());
        } catch (Exception e) {
            logger.error("MarketSendJob marketActivitySendSms error.");
        }


        try {
            marketService.marketActivitySendEmail(sellerConfigInfo.getSellerId());
        } catch (Exception e) {
            logger.error("MarketSendJob marketActivitySendEmail error.");
        }


    }
}
