package com.shufensoft.crm.job.trade;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.service.seller.SellerConfigInfoService;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lin on 2015/6/10.
 *
 * @description 京东订单数据同步定时任务
 */
public class JdTradeSyncJob extends SyncDataJob {

    private static final Logger logger = Logger.getLogger(JdTradeSyncJob.class);

    private static JdTradeService jdTradeService;
    private static SellerConfigInfoService sellerConfigInfoService;

    static {
        jdTradeService = (JdTradeService) SpringContextUtil.getBean("jdTradeService");
        sellerConfigInfoService = (SellerConfigInfoService) SpringContextUtil.getBean("sellerConfigInfoService");
    }


    @Override
    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        AssertsUtil.notNull(sellerConfigInfo, "sellerConfigInfo");
        AssertsUtil.notNull(sellerConfigInfo.getSellerId(), "sellerConfigInfo.sellerId");


        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        if (CollectionUtils.isEmpty(sellerShops)) {

            return;

        }

        for (SellerShop sellerShop : sellerShops) {

            if (DaoConstant.ShopType.JD.equals(sellerShop.getShopType())) {

                try {
                    syncOrderJD(sellerShop);
                } catch (Exception e) {

                    String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                    logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                    saveJobLog(messge);

                }

            }

        }


    }

    @Override
    public String jobName() {
        return JobConstant.JobName.JD_ORDER_SYNC_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    public void syncOrderJD(SellerShop sellerShop) {

        if (StringUtils.isBlank(sellerShop.getShopAccessToken())) {
            logger.error("seller[sellerId=" + sellerShop.getSellerId() + ",shopId=" + sellerShop.getShopId() + "] need to auth JD");
            return;
        }

        if (sellerShop.getShopTokenExpire() == null || new Date().after(sellerShop.getShopTokenExpire())) {
            logger.error("seller[sellerId=" + sellerShop.getSellerId() + ",shopId=" + sellerShop.getShopId() + "] jd accessToken is expire");
            return;
        }

        Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
        Date endDate = this.getEndDate();

        int page = 1;

        while (true) {

            List<OrderJD> orderJDList = jdTradeService.getOrderJDByAppKeyAndDate(sellerShop.getShopAppId(), sellerShop.getShopAppSecret(), sellerShop.getShopAccessToken(), startDate, endDate, page, pageSize);
            if (CollectionUtils.isEmpty(orderJDList)) {
                break;
            }
            jdTradeService.saveOrUpdateTrades(sellerShop.getSellerId(), sellerShop.getShopId(), orderJDList);

            page++;

        }

    }


}
