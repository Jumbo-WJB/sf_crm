package com.shufensoft.crm.biz.service.dataindex;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.comment.CommentJD;
import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.*;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.cvm.CvmService;
import com.shufensoft.crm.biz.service.dataindex.impl.*;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.common.utils.MathUtil;
import net.sourceforge.jeval.EvaluationException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-27 20:52  
 */
@Service
public class DataIndexService {

    private static final Logger logger = Logger.getLogger(DataIndexService.class);

    @Autowired
    private DataReadService dataReadService;

    @Autowired
    private CvmService cvmService;

    public UserPortraitVO calculate(User user) {

        if (user == null || MathUtil.isNotPositive(user.getUserId()) || MathUtil.isNotPositive(user.getSellerId())) {
            logger.error("illegal argument: " + user.toString());
            throw new ServiceException("illegal argument: " + user.toString());
        }

        long userId = user.getUserId();
        Long userIdTb = user.getUserIdTb();
        long sellerId = user.getSellerId();
        Long userIdJd = user.getUserIdJd();
        Long userIdYz = user.getUserIdYz();

        RawData rawData = new RawData();
        Long interactionsTimes = dataReadService.queryInteractionDetailCount(sellerId, userId);
        rawData.setUserInteractionDetailCount(interactionsTimes);

        if (userIdTb != null && userIdTb > 0) {
            List<CommentTaoBao> commentTaoBaoList = dataReadService.queryCommentTaoBao(userIdTb);
            List<TradeTaoBao> tradeTaoBaoList = dataReadService.queryTradeTaoBao(userIdTb);
            List<OrderTaoBao> orderTaoBaoList = dataReadService.queryOrderTaoBao(userIdTb);

            rawData.setTradeTaoBaoList(tradeTaoBaoList);
            rawData.setOrderTaoBaoList(orderTaoBaoList);
            rawData.setCommentTaoBaoList(commentTaoBaoList);
        }

        if (userIdJd != null && userIdJd > 0) {
            List<OrderJD> orderJDList = dataReadService.queryOrderJd(userIdJd);
            List<ItemInfoJD> itemInfoJDList = dataReadService.queryItemInfoJD(userIdJd);
            List<CommentJD> commentJDList = dataReadService.queryCommentJd(userIdJd);

            rawData.setOrderJdList(orderJDList);
            rawData.setItemInfoJDList(itemInfoJDList);
            rawData.setCommentJDList(commentJDList);
        }

        if (userIdYz != null && userIdYz > 0) {

            List<TradeYZ> tradeYZList = dataReadService.queryOrderYz(userIdYz);
            List<OrderYZ> orderYzList = dataReadService.queryOradeYZ(userIdYz);

            rawData.setTradeYZList(tradeYZList);
            rawData.setOrderYZList(orderYzList);

        }

        UserPortraitVO userPortraitVo = new UserPortraitVO();

        DiCommentGoodRate diCommentGoodRate = new DiCommentGoodRate();
        DataIndexResult dataIndexResult = diCommentGoodRate.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setGoodsRate(new BigDecimal((Double) dataIndexResult.getResult()));
        }

        DiFancy diFancy = new DiFancy();
        dataIndexResult = diFancy.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setFancy((String) dataIndexResult.getResult());
        }

        DiInteractionTotal diInteractionTotal = new DiInteractionTotal();
        dataIndexResult = diInteractionTotal.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setInteractionsTimes((Integer.parseInt(dataIndexResult.getResult().toString())));
        }

        DiLastPurchaseAmount diLastPurchaseAmount = new DiLastPurchaseAmount();
        dataIndexResult = diLastPurchaseAmount.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setLastPurchaseAmount((Long) dataIndexResult.getResult());
        }

        DiLastPurchaseDate diLastPurchaseDate = new DiLastPurchaseDate();
        dataIndexResult = diLastPurchaseDate.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setLastPurchaseDate((Date) dataIndexResult.getResult());
        }

        DiFirstPurchaseDate diFirstPurchaseDate = new DiFirstPurchaseDate();
        dataIndexResult = diFirstPurchaseDate.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setFirstPurchaseDate((Date) dataIndexResult.getResult());
        }

        DiLiveness diLiveness = new DiLiveness();
        dataIndexResult = diLiveness.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setLiveness((Integer) dataIndexResult.getResult());
        }

        DiMobilePurchaseRate diMobilePurchaseRate = new DiMobilePurchaseRate();
        dataIndexResult = diMobilePurchaseRate.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setMobilePurchaseRate(new BigDecimal((Double) dataIndexResult.getResult()));
        }

        DiPurchaseAverageAmount diPurchaseAverageAmount = new DiPurchaseAverageAmount();
        dataIndexResult = diPurchaseAverageAmount.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setPurchaseAverageAmount((Long) dataIndexResult.getResult());
        }

        DiPurchaseAverageCycle diPurchaseAverageCycle = new DiPurchaseAverageCycle();
        dataIndexResult = diPurchaseAverageCycle.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setPurchaseAverageCycle(new BigDecimal((Double) dataIndexResult.getResult()));
        }

        DiTotalPurchaseAmount diTotalPurchaseAmount = new DiTotalPurchaseAmount();
        dataIndexResult = diTotalPurchaseAmount.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setTotalPurchaseAmount((Long) dataIndexResult.getResult());
        }

        DiTotalPurchaseTimes diTotalPurchaseTimes = new DiTotalPurchaseTimes();
        dataIndexResult = diTotalPurchaseTimes.computeWithData(rawData);
        if (dataIndexResult.isSuccess()) {
            userPortraitVo.setTotalPurchaseTimes((Integer) dataIndexResult.getResult());
        }

        try {

            double cvmTb = 0, cvmJd = 0, cvmYZ = 0, cvmTmall = 0, cvmAll;
            SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(String.valueOf(sellerId));

            List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();
            if (CollectionUtils.isEmpty(sellerShops)) {
                return userPortraitVo;
            }

            for (SellerShop sellerShop : sellerShops) {

                if (userIdTb != null && userIdTb > 0
                        && (DaoConstant.UserSource.TMALL.equals(sellerShop.getShopType()))
                        || DaoConstant.UserSource.TB.equals(sellerShop.getShopType())){

                    double cvm = cvmService.calCvm4Tb(userIdTb, sellerId,sellerShop.getShopId());
                    if(DaoConstant.UserSource.TMALL.equals(sellerShop.getShopType())){
                        cvmTmall = cvm;
                        userPortraitVo.setContributionTmall(new BigDecimal(cvmTb));
                    }

                    if(DaoConstant.UserSource.TB.equals(sellerShop.getShopType())){
                        cvmTb = cvm;
                        userPortraitVo.setContributionTb(new BigDecimal(cvmTb));
                    }

                }

                if (userIdJd != null && userIdJd > 0 && DaoConstant.UserSource.JD.equals(sellerShop.getShopType())) {
                    cvmJd = cvmService.calCvm4Jd(userIdJd, sellerId,sellerShop.getShopId());
                    userPortraitVo.setContributionJd(new BigDecimal(cvmJd));
                }

                if (userIdYz != null && userIdYz > 0 && DaoConstant.UserSource.YZ.equals(sellerShop.getShopType())) {
                    cvmYZ = cvmService.calCvm4Yz(userIdJd, sellerId,sellerShop.getShopId());
                    userPortraitVo.setContributionYz(new BigDecimal(cvmJd));
                }

            }

            cvmAll = cvmTmall + (100-cvmTmall)/100 *cvmJd + (100-(cvmTmall + (100-cvmTmall)/100 *cvmJd))/100*cvmTb;

            userPortraitVo.setContribution(new BigDecimal(cvmAll));


        } catch (EvaluationException e) {

            throw new ServiceException(e);

        }

        return userPortraitVo;
    }


}
