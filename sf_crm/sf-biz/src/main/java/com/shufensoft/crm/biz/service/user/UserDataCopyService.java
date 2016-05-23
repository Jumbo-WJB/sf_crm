package com.shufensoft.crm.biz.service.user;


import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeYZ;
import com.shufensoft.crm.biz.service.user.vo.UserDataVo;
import org.springframework.transaction.annotation.Transactional;


/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-23 15:20  
 */

public interface UserDataCopyService {


    public UserDataVo copyFromYz(long userIdYz);

    public UserDataVo copyFromTb(long userIdTb);

    public UserDataVo copyFromJd(long userIdJd);


    /**
     * 处理京东用户转成用户
     *
     * @param sellerShop 商户信息
     * @param userIdJd   京东用户ID
     * @param orderJD    京东订单
     * @throws Exception
     */
    @Transactional
    public void handleJdUser(SellerShop sellerShop, long userIdJd, OrderJD orderJD) throws Exception;

    /**
     * 处理淘宝用户转成用户
     *
     * @param sellerShop  商户信息
     * @param userIdTb    淘宝用户ID
     * @param tradeTaoBao 淘宝订单
     * @throws Exception
     */
    @Transactional
    public void handleTbUser(SellerShop sellerShop, long userIdTb, TradeTaoBao tradeTaoBao) throws Exception;


    /**
     * 有赞数据分析
     *
     * @param sellerShop 商铺信息
     * @param userIdYz   有赞用户ID
     * @param tradeYZ    有赞订单
     * @throws Exception
     */
    public void handleYZUser(SellerShop sellerShop, long userIdYz, TradeYZ tradeYZ) throws Exception;

}
