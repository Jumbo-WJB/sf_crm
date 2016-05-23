package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.biz.service.trade.YouZanTradeService;
import com.shufensoft.crm.biz.service.user.UserDataCopyService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *  
 *  @ProjectName: sf-parent  
 *  @Description: 各购物渠道用户数据计算：如淘宝、天猫、京东、有赞等
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-24 15:45  
 */
public class ChannelUserDataAnalysisJob extends SyncDataJob {

    private static final Logger logger = Logger.getLogger(ChannelUserDataAnalysisJob.class);

    @Autowired
    private TaoBaoTradeService taoBaoTradeService;

    @Autowired
    private JdTradeService jdTradeService;

    @Autowired
    private YouZanTradeService youZanTradeService;

    @Autowired
    private UserDataCopyService userDataCopyService;


    @Override
    public String jobName() {
        return JobConstant.JobName.CHANNEL_USER_DATA_ANALYSIS_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();

        for (SellerShop sellerShop : sellerShops) {

            try {

                Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
                startDate = DateUtils.addMinutes(startDate, -30);//每次提前30分钟，避开比订单同步时间快
                Date endDate = this.getEndDate();

                if (DaoConstant.ShopType.TB.equals(sellerShop.getShopType())
                        || DaoConstant.ShopType.TMALL.equals(sellerShop.getShopType())) {
                    /**
                     * 分页计算淘宝数据
                     */
                    pageProcessDataTb(sellerShop, startDate, endDate);
                }

                if (DaoConstant.ShopType.JD.equals(sellerShop.getShopType())) {
                    /**
                     * 分页计算京东数据
                     */
                    pageProcessDataJD(sellerShop, startDate, endDate);

                }

                if (DaoConstant.ShopType.YZ.equals(sellerShop.getShopType())) {
                    /**
                     * 分页计算有赞数据
                     */
                    pageProcessDataYZ(sellerShop, startDate, endDate);

                }

                saveJobDetail();


            } catch (Exception e) {

                String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                saveJobLog(messge);

            }

        }

    }



    /**
     * 分页计算京东用户价值
     *
     * @param sellerShop
     * @param startDate
     * @param endDate
     */
    private void pageProcessDataJD(SellerShop sellerShop, Date startDate, Date endDate) {
        int start = 1;

        while (true) {
            List<OrderJD> orderJDList = null;
            try {
                orderJDList = jdTradeService.findOrdersByDate(sellerShop.getSellerId(), sellerShop.getShopId(), startDate, endDate, start, pageSize);
                if (CollectionUtils.isEmpty(orderJDList)) {
                    break;
                }

                processDataJd(sellerShop, orderJDList);
            } catch (Exception e) {
                String messge = e.getMessage() == null ? e.toString() : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);
                saveJobLog(messge);
            }
            start++;
            if (logger.isInfoEnabled()) {
                logger.info("jd order deal with : " + orderJDList.size());
            }
        }
    }


    /**
     * 分页计算有赞用户价值
     *
     * @param sellerShop
     * @param startDate
     * @param endDate
     */
    private void pageProcessDataYZ(SellerShop sellerShop, Date startDate, Date endDate) {

        int start = 1;

        while (true) {
            List<TradeYZ> tradeYZs = null;
            try {
                tradeYZs = youZanTradeService.findTradeFromByDate(sellerShop,  start, pageSize, startDate, endDate);
                if (CollectionUtils.isEmpty(tradeYZs)) {
                    break;
                }

                processDataYZ(sellerShop, tradeYZs);

            } catch (Exception e) {
                String messge = e.getMessage() == null ? e.toString() : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);
                saveJobLog(messge);
            }
            start++;

            if (logger.isInfoEnabled()) {
                logger.info("yz trade deal with : " + tradeYZs.size());
            }

        }
    }

    /**
     * 分页计算淘宝用户价值
     *
     * @param sellerShop
     * @param startDate
     * @param endDate
     */
    private void pageProcessDataTb(SellerShop sellerShop, Date startDate, Date endDate) {

        int start = 1;

        while (true) {

            try {
                List<TradeTaoBao> tradeTaoBaoList = taoBaoTradeService.findTradeByDate(sellerShop.getSellerId(),
                        sellerShop.getShopId(), startDate, endDate, start, pageSize);
                if (CollectionUtils.isEmpty(tradeTaoBaoList)) {
                    break;
                }

                processDataTb(sellerShop, tradeTaoBaoList);
            } catch (Exception e) {
                String messge = e.getMessage() == null ? e.toString() : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);
                saveJobLog(messge);
            }

            start++;

        }
    }


    /**
     * 淘宝用户价值计算
     *
     * @param sellerShop
     * @param tradeTaoBaoList
     * @throws Exception
     */
    private void processDataTb(SellerShop sellerShop, List<TradeTaoBao> tradeTaoBaoList) throws Exception {

        AssertsUtil.check(!CollectionUtils.isEmpty(tradeTaoBaoList), "tradeTaoBaoList illegal");
        TradeTaoBao tradeTaoBao = tradeTaoBaoList.get(0);
        AssertsUtil.check(tradeTaoBao != null, "tradeTaoBao null");

        for (TradeTaoBao trade : tradeTaoBaoList) {
            userDataCopyService.handleTbUser(sellerShop, trade.getUserIdTb(), trade);
        }

    }

    private void processDataYZ(SellerShop sellerShop, List<TradeYZ> tradeYZs) throws Exception {

        AssertsUtil.check(!CollectionUtils.isEmpty(tradeYZs), "tradeYZs illegal");
        TradeYZ tradeYZ = tradeYZs.get(0);
        AssertsUtil.check(tradeYZ != null, "tradeYZ null");

        for (TradeYZ trade : tradeYZs) {
            userDataCopyService.handleYZUser(sellerShop, trade.getUserIdYz(), trade);
        }


    }

    private void processDataJd(SellerShop sellerShop, List<OrderJD> orderJDList) throws Exception {

        AssertsUtil.check(!CollectionUtils.isEmpty(orderJDList), "tradeTaoBaoList illegal");
        OrderJD orderJD = orderJDList.get(0);
        AssertsUtil.check(orderJD != null, "orderJD null");

        for (OrderJD trade : orderJDList) {

            userDataCopyService.handleJdUser(sellerShop, trade.getUserIdJd(), trade);

        }

    }



}
