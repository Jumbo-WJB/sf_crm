package com.shufensoft.crm.polySpire.job.comment;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.polySpire.biz.service.comment.TaoBaoTradeRateService;
import com.shufensoft.crm.polySpire.job.base.SyncDataJob;
import com.shufensoft.crm.polySpire.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                评价信息同步
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/28  
 */
public class TaoBaoTradeRateSyncJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(SyncDataJob.class);

    private static String shopId = PropertyReader.getValue("shopId");

    private static TaoBaoTradeRateService taoBaoTradeRateService;

    static {

        taoBaoTradeRateService = (TaoBaoTradeRateService) SpringContextUtil.getBean("taoBaoTradeRateService");

    }

    @Override
    public boolean isChangeDataSoure() {
        return false;
    }

    @Override
    public String jobName() {
        return "TaoBaoTradeRateSyncJob";
    }

    @Override
    public void execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        AssertsUtil.notNull(sellerConfigInfo, "sellerConfigInfo");
        AssertsUtil.notNull(sellerConfigInfo.getSellerId(), "sellerConfigInfo.sellerId");

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        if(CollectionUtils.isEmpty(sellerShops)){

            return;

        }

        for(SellerShop sellerShop : sellerShops){

            if((DaoConstant.ShopType.TB.equals(sellerShop.getShopType())
                    || DaoConstant.ShopType.TMALL.equals(sellerShop.getShopType())
                    && DaoConstant.AccessType.SELF_DEVELOPMENT.equals(sellerShop.getAccessType()))
                    && shopId.equals(String.valueOf(sellerShop.getShopId()))){
                syncTaoBaoTrade(sellerShop);
            }

        }

    }

    /**
     * 同步淘宝交易
     */
    private void syncTaoBaoTrade(SellerShop sellerShop){

        if(StringUtils.isBlank(sellerShop.getShopAccessToken())){
            logger.error("seller[sellerId="+sellerShop.getSellerId()+",shopId="+sellerShop.getShopId()+"] need to auth taobao");
            return;
        }

        if(sellerShop.getShopTokenExpire() == null || new Date().after(sellerShop.getShopTokenExpire())){
            logger.error("seller[sellerId="+sellerShop.getSellerId()+",shopId="+sellerShop.getShopId()+"] taobao accessToken is expire");
            return;
        }

        /**
         * 1.获取评价拉取起始时间
         */
        Date startDate = getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
        Date endDate = getEndDate();

        /**
         * 2.从淘宝拉取评价信息（根据起始时间,分页处理）
         */

        long start = 1;

        try {

            taoBaoTradeRateService.pullTaoBaoTradeRates(sellerShop.getSellerId(),sellerShop.getShopId(), start, startDate, endDate);

        } catch (Exception e) {

            String messge = e.getMessage() == null ? e.toString() : e.getMessage();
            logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

            saveJobLog(messge);

        }

    }
}
