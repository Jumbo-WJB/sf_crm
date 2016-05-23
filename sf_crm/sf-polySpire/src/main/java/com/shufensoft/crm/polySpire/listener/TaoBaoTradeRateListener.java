package com.shufensoft.crm.polySpire.listener;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.polySpire.biz.service.comment.TaoBaoTradeRateService;
import com.shufensoft.crm.polySpire.listener.topic.TaoBaoTopic;
import com.taobao.api.internal.tmc.Message;
import com.taobao.api.internal.tmc.MessageHandler;
import com.taobao.api.internal.tmc.MessageStatus;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.top.link.LinkException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 淘宝评价消息监听
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/18  
 */
public class TaoBaoTradeRateListener {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(TaoBaoTradeRateListener.class);

    @Autowired
    private  TaoBaoTradeRateService taoBaoTradeRateService;

    private static String sellerId = PropertyReader.getValue("sellerId");

    private static String shopId = PropertyReader.getValue("shopId");

    public void onMessage() {

        SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerId,shopId);

        String appKey = sellerShop.getShopAppId();
        String appSecret = sellerShop.getShopAppSecret();
        /**
         * 关于default消息分组参见：消息分组介绍
         */
        TmcClient client = new TmcClient(appKey, appSecret, "default");

        /**
         * 设置业务处理Handler
         */
        client.setMessageHandler(new MessageHandler() {

            public void onMessage(Message message, MessageStatus status) {

                try {

                    /**
                     * 消息消费
                     */
                    taoBaoTradeRateMessageConsume(message);

                } catch (Exception e) {

                    logger.error("TaoBaoTradeRateListener.onMessages error", e);
                    /**
                     * 消息处理失败回滚，服务端需要重发
                     */
                    status.fail();

                }
            }

        });

        try {
            client.connect();
        } catch (LinkException e) {
            logger.error("TaoBaoTradeRateListener.onMessages TmcClient connect error", e);
        }

    }

    /**
     *  消息消费
     * @param message
     */
    public void taoBaoTradeRateMessageConsume(Message message) {

        if (!("taobao_trade_TradeRated".equals(message.getTopic())
                && "taobao_trade_TradeChanged".equals(message.getTopic()))) {

            return;
        }

        TaoBaoTopic taoBaoTopic = (TaoBaoTopic) JSONUtils.parseToObject(message.getContent(), TaoBaoTopic.class);

        if(taoBaoTopic == null){
            throw new RuntimeException("taoBaoTopic is null");
        }

        taoBaoTradeRateService.pullTaoBaoTradeRates(Long.valueOf(sellerId),Long.valueOf(shopId),taoBaoTopic.getOid());

    }

    public static void main(String[] args) {
        /**
         * 关于default消息分组参见：消息分组介绍
         */
        TmcClient client = new TmcClient("23173570", "782c387f686a04e6da69bf7d0074e020", "default");

        /**
         * 设置业务处理Handler
         */
        client.setMessageHandler(new MessageHandler() {

            public void onMessage(Message message, MessageStatus status) {

                try {

                    System.out.println(message.getContentMap());
                    System.out.println(status.getReason());

                } catch (Exception e) {

                    logger.error("TaoBaoTradeRateListener.onMessages error", e);
                    /**
                     * 消息处理失败回滚，服务端需要重发
                     */
                    status.fail();

                }
            }

        });

        try {
            client.connect();
        } catch (LinkException e) {
            logger.error("TaoBaoTradeRateListener.onMessages TmcClient connect error", e);
        }

    }

}
