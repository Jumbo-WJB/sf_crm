package com.shufensoft.crm.job.comment;

import com.shufensoft.crm.biz.cache.LstOfValCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.system.LstOfVal;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant.JobName;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: 京东评价同步定时任务
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/8 10:45  
 */
public class JDCommentSyncJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(JDCommentSyncJob.class);

    private static JdTradeService jdTradeService;

    public static int DEFAULT_COMMENT_JD_ORDER_DAYS = 30;


    public static String JD_CONFIG = "JD_CONFIG";

    public static String COMMENT_JD_ORDER_DAYS_NAME = "commentJDOrderDays";

    static {

        jdTradeService = (JdTradeService) SpringContextUtil.getBean("jdTradeService");

    }

    @Override
    public String jobName() {

        return JobName.JD_COMMENT_SYNC_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
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

                    syncJDComment(sellerShop);

                } catch (Exception e) {

                    String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                    logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                    saveJobLog(messge);

                }

            }

        }

    }

    /**
     * 同步京东评价
     */
    private void syncJDComment(SellerShop sellerShop) {


        if (StringUtils.isBlank(sellerShop.getShopAccessToken())) {
            logger.error("seller[sellerId=" + sellerShop.getSellerId() + ",shopId=" + sellerShop.getShopId() + "] need to auth JD");
            return;
        }

        if (sellerShop.getShopTokenExpire() == null || new Date().after(sellerShop.getShopTokenExpire())) {
            logger.error("seller[sellerId=" + sellerShop.getSellerId() + ",shopId=" + sellerShop.getShopId() + "] jd accessToken is expire");
            return;
        }

        /**
         * 1.获取订单拉取起始时间
         */
        Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());

        Date endDate = this.getEndDate();

        /**
         * 当数据同步时间节点到了当前时间,依然同步半年前订单在当前时间评价的数据
         */
        LstOfVal lstOfVal = LstOfValCache.getLOV(JD_CONFIG, COMMENT_JD_ORDER_DAYS_NAME);
        int days = DEFAULT_COMMENT_JD_ORDER_DAYS;
        if (lstOfVal != null && NumberUtils.isNumber(lstOfVal.getValue())) {
            days = Integer.parseInt(lstOfVal.getValue());
        }

        if (endDate.after(DateUtils.addMinutes(new Date(), -30))) {
            startDate = DateUtils.addDays(startDate, days * (-1));
        }

        /**
         * 2.从京东获取订单,保存到本地数据库（根据起始时间,分页处理）
         */

        int start = 1;

        while (true) {

            List<OrderJD> orderJDs = jdTradeService.queryUnCommentOrderJDs(startDate, endDate, start, pageSize);
            if (CollectionUtils.isEmpty(orderJDs)) {
                break;
            }

            for (OrderJD orderJD : orderJDs) {

                try {
                    jdTradeService.pullCommentJDAndHandle(sellerShop, orderJD);
                } catch (Exception e) {

                    String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                    logger.error(jobName == null ? "job" : jobName + " execute error[orderId=" + orderJD.getOrderId() + "],errorMag:" + messge, e);

                    saveJobLog("execute error[orderId=" + orderJD.getOrderId() + "],errorMag:" + messge);
                }

            }

            start++;
        }

    }

}
