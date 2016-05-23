package com.shufensoft.crm.job.trade;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant.JobName;
import com.shufensoft.crm.job.base.BaseJob;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 有赞交易同步定时任务
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class YouZanTradeSyncJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseJob.class);

    private static YouZanTradeService youZanTradeService;

    static {

        youZanTradeService = (YouZanTradeService) SpringContextUtil.getBean("youZanTradeService");

    }

    @Override
    public String jobName() {
        return JobName.YOUZAN_TRADE_SYNC_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        if(CollectionUtils.isEmpty(sellerShops)){

            return;

        }

        for(SellerShop sellerShop : sellerShops){

            if(DaoConstant.ShopType.YZ.equals(sellerShop.getShopType())){

                syncYouZanTrade(sellerShop);

            }

        }


    }

    /**
     * 同步有赞交易
     */
    private void syncYouZanTrade(SellerShop sellerShop) {

        if(StringUtils.isBlank(sellerShop.getShopAppId())){
            logger.error("seller[sellerId="+sellerShop.getSellerId()+",shopId="+sellerShop.getShopId()+"] youzan AppId is blank ");
            return;
        }

        if(StringUtils.isBlank(sellerShop.getShopAppSecret())){
            logger.error("seller[sellerId="+sellerShop.getSellerId()+",shopId="+sellerShop.getShopId()+"] youzan AppSecret is blank");
            return;
        }

        /**
         * 1.获取订单拉取起始时间
         */
        Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
        Date endDate = this.getEndDate();

        /**
         * 2.从有赞获取订单,保存到本地数据库（根据起始时间,分页处理）
         */
        long start = 1;

        try {

            youZanTradeService.pullTradeFromYouZanByDate(sellerShop, start, startDate, endDate);

        } catch (Exception e) {

            String messge = e.getMessage() == null ? e.toString() : e.getMessage();
            logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

            saveJobLog(messge);

        }


    }

}
