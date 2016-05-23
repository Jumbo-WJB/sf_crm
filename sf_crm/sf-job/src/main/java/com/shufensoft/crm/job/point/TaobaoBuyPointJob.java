package com.shufensoft.crm.job.point;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.service.pointmall.face.IPointService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.BaseJob;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 根据淘宝订单产生购物积分
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/9/8 上午10:29  
 */
public class TaobaoBuyPointJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseJob.class);

    private static TaoBaoTradeService taoBaoTradeService;

    private static IPointService pointService;


    static {

        taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");

        pointService = (IPointService) SpringContextUtil.getBean("pointService");

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

                    taoBaoTradeToCreateBuyPoint(sellerShop);

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
        return JobConstant.JobName.TAOBAO_TRADE_TO_BUYPOINT_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }


    /**
     * 同步淘宝交易生成购物积分
     */
    private void taoBaoTradeToCreateBuyPoint(SellerShop sellerShop) {


        /**
         * 1.获取订单拉取起始时间
         */
        Date startDate = this.getStartDate(sellerShop.getSellerId(), sellerShop.getShopId());
        startDate = DateUtils.addHours(startDate, -2);
        Date endDate = this.getEndDate(startDate);

        /**
         * 2.从trade_taobao中拉取数据并计算产生购物积分。
         */
        int start = 1;

        while (true) {

            PageInfo pageInfo = taoBaoTradeService.selectTaobaoTradeListByDate(startDate, endDate, start, pageSize);

            List<TradeTaoBao> tradeTaoBaoList = pageInfo.getList();

            if (CollectionUtils.isEmpty(tradeTaoBaoList)) {

                break;
            }

            for (TradeTaoBao tradeTaoBao : tradeTaoBaoList) {

                pointService.tradeToCreateBuyPoint(sellerShop.getSellerId(), tradeTaoBao.getUserIdTb(), DaoConstant.UserSource.TB, tradeTaoBao.getPayment().longValue(), tradeTaoBao.getTid());

            }

            start++;

        }

    }
}
