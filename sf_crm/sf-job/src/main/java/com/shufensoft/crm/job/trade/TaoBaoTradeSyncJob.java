package com.shufensoft.crm.job.trade;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
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
 *  @Description: 淘宝交易同步定时任务
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class TaoBaoTradeSyncJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseJob.class);

    private static TaoBaoTradeService taoBaoTradeService;

    static {

        taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");

    }

    @Override
    public String jobName() {
        return JobName.TAOBAO_TRADE_SYNC_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        for (SellerShop sellerShop : sellerShops) {

            if (DaoConstant.ShopType.TB.equals(sellerShop.getShopType())
                    || DaoConstant.ShopType.TMALL.equals(sellerShop.getShopType())
                    && DaoConstant.AccessType.SELF_DEVELOPMENT.equals(sellerShop.getAccessType())) {

                try {

                    syncTaoBaoTrade(sellerShop);

                } catch (Exception e) {

                    String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                    logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                    saveJobLog(messge);

                }

            }

        }

    }

    /**
     * 同步淘宝交易
     */
    private void syncTaoBaoTrade(SellerShop sellerShop) {

        if (StringUtils.isBlank(sellerShop.getPolySpireUrl())) {
            logger.error("seller[sellerId=" + sellerShop.getSellerId() + ",shopId=" + sellerShop.getShopId() + "] PolySpireUrl is null");
            return;
        }

        /**
         * 1.获取订单拉取起始时间
         */
        Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
        Date endDate = this.getEndDate();

        /**
         * 2.从聚石塔获取订单,保存到本地数据库（根据起始时间,分页处理）
         */
        int start = 1;

        while (true) {

            List<TradeTaoBao> tradeTaoBaoList = taoBaoTradeService.getTradeFromPolySpireByDate(sellerShop.getPolySpireUrl(), startDate, endDate, start, pageSize);
            if (CollectionUtils.isEmpty(tradeTaoBaoList)) {
                break;
            }

            taoBaoTradeService.saveOrUpdateTradeList(sellerShop.getSellerId(), sellerShop.getShopId(), tradeTaoBaoList);

            start++;

        }

    }

}
