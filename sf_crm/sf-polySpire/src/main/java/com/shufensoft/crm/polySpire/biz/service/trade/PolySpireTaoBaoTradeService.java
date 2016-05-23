package com.shufensoft.crm.polySpire.biz.service.trade;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.dao.generation.trade.JdpTbTradeMapper;
import com.shufensoft.crm.biz.domain.generation.trade.JdpTbTrade;
import com.shufensoft.crm.biz.domain.generation.trade.JdpTbTradeExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.common.utils.JSONUtils;
import com.shufensoft.crm.polySpire.api.jsonObj.trade.OrderJsonObj;
import com.shufensoft.crm.polySpire.api.jsonObj.trade.TradeJsonObj;
import com.shufensoft.crm.polySpire.api.response.TradeFullinfoGetResponse;
import com.shufensoft.crm.polySpire.api.response.TradeResponse;
import com.shufensoft.crm.polySpire.api.vo.TaoBaoOrderVO;
import com.shufensoft.crm.polySpire.api.vo.TaoBaoTradeVO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 交易服务类
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/1  
 */
@Service
public class PolySpireTaoBaoTradeService {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(PolySpireTaoBaoTradeService.class);

    @Autowired
    private JdpTbTradeMapper jdpTbTradeMapper;

    /**
     * 根据系统修改时间的起始时间获取交易信息
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public  List<TaoBaoTradeVO> quaryTradeByDate(Date startDate, Date endDate, int start, int pageSize) {

        JdpTbTradeExample jdpTbTradeExample = new JdpTbTradeExample();
        jdpTbTradeExample.createCriteria().andJdpModifiedBetween(startDate, endDate);
        PageHelper.startPage(start, pageSize);

        List<JdpTbTrade> jdpTbTradeList = jdpTbTradeMapper.selectByExampleWithBLOBs(jdpTbTradeExample);
        if (CollectionUtils.isEmpty(jdpTbTradeList)) {
            return null;
        }

        List<TaoBaoTradeVO> taoBaoTradeVOs = new ArrayList<TaoBaoTradeVO>();

        for (JdpTbTrade jdpTbTrade : jdpTbTradeList) {

            /**
             * 解析交易数据格式
             */
            String tradeJson = jdpTbTrade.getJdpResponse();
            TaoBaoTradeVO taoBaoTradeVO = parseTradeJson(tradeJson);

            if (taoBaoTradeVO != null) {
                taoBaoTradeVOs.add(taoBaoTradeVO);
            }

        }

        return taoBaoTradeVOs;
    }

    /**
     * 解析交易数据格式
     * @param tradeJson
     * @return
     */
    private TaoBaoTradeVO parseTradeJson(String tradeJson){

        if (StringUtils.isBlank(tradeJson)) {
            return null;
        }

        TradeResponse tradeResponse = (TradeResponse) JSONUtils.parseToObject(tradeJson, TradeResponse.class);
        if (tradeResponse == null) {
            return null;
        }

        TradeFullinfoGetResponse tradeFullinfoGetResponse = tradeResponse.getTrade_fullinfo_get_response();
        if (tradeFullinfoGetResponse == null) {
            return null;
        }

        TradeJsonObj trade = tradeFullinfoGetResponse.getTrade();
        if (tradeFullinfoGetResponse == null) {
            return null;
        }

        TaoBaoTradeVO taoBaoTradeVO = null;
        try {
            taoBaoTradeVO = (TaoBaoTradeVO) BeanCopierUtils.copyHumpFieldProperties(trade, TaoBaoTradeVO.class);
        } catch (Exception e) {
            logger.error("TaoBaoTradeService.parseTradeJson error,errorMsg:'trade对象转化出错'", e);
            throw new ServiceException("TaoBaoTradeService.parseTradeJson", "trade对象转化出错", e);
        }

        if(trade.getOrders()==null || CollectionUtils.isEmpty(trade.getOrders().getOrder())){
            logger.error("TaoBaoTradeService.parseTradeJson error,errorMsg:订单数据为空");
            throw new ServiceException("TaoBaoTradeService.parseTradeJson", "订单数据为空");
        }

        List<TaoBaoOrderVO>  taoBaoOrderVOs = new ArrayList<TaoBaoOrderVO>();
        for(OrderJsonObj order : trade.getOrders().getOrder()){
            TaoBaoOrderVO taoBaoOrderVO = null;
            try {
                taoBaoOrderVO = (TaoBaoOrderVO) BeanCopierUtils.copyHumpFieldProperties(order, TaoBaoOrderVO.class);
            } catch (Exception e) {
                logger.error("TaoBaoTradeService.parseTradeJson error,errorMsg:order对象转化出错", e);
                throw new ServiceException("TaoBaoTradeService.parseTradeJson", "order对象转化出错", e);
            }
            if(null != taoBaoOrderVO){
                taoBaoOrderVOs.add(taoBaoOrderVO);
            }

        }
        taoBaoTradeVO.setOrders(taoBaoOrderVOs);

        return taoBaoTradeVO;
    }

    public static void main(String[] args) {
        String tradeJson = "{\"trade_fullinfo_get_response\":{\"trade\":{\"adjust_fee\":\"0.00\",\"alipay_id\":2088012006063406,\"alipay_no\":\"2014041711001001400057248827\",\"alipay_point\":0,\"available_confirm_fee\":\"0.00\",\"buyer_alipay_no\":\"nfjgq@163.com\",\"buyer_area\":\"??????\",\"buyer_cod_fee\":\"0.00\",\"buyer_email\":\"773781118@qq.com\",\"buyer_nick\":\"jgq502\",\"buyer_obtain_point_fee\":0,\"buyer_rate\":false,\"cod_fee\":\"0.00\",\"cod_status\":\"NEW_CREATED\",\"commission_fee\":\"0.00\",\"created\":\"2014-04-17 19:02:40\",\"credit_card_fee\":\"26.50\",\"discount_fee\":\"0.00\",\"end_time\":\"2014-04-18 18:13:54\",\"has_post_fee\":true,\"is_3D\":false,\"is_brand_sale\":false,\"is_daixiao\":false,\"is_force_wlb\":false,\"is_lgtype\":false,\"is_part_consign\":false,\"is_wt\":false,\"modified\":\"2015-05-25 17:21:08\",\"num\":5,\"num_iid\":9175056737,\"orders\":{\"order\":[{\"adjust_fee\":\"0.00\",\"buyer_rate\":false,\"cid\":50006846,\"discount_fee\":\"62.50\",\"end_time\":\"2014-04-18 18:13:54\",\"is_oversold\":false,\"num\":5,\"num_iid\":9175056737,\"oid\":619167151827364,\"order_from\":\"WAP\",\"outer_iid\":\"6310\",\"outer_sku_id\":\"6301B20\",\"part_mjz_discount\":\"0.00\",\"payment\":\"26.50\",\"pic_path\":\"http:\\/\\/img03.taobaocdn.com\\/bao\\/uploaded\\/i3\\/505753958\\/T2y85_Xu8XXXXXXXXX_!!505753958.jpg\",\"price\":\"17.80\",\"refund_id\":24408890966473,\"refund_status\":\"SUCCESS\",\"seller_rate\":false,\"seller_type\":\"B\",\"sku_id\":\"21314570069\",\"sku_properties_name\":\"????:??;??:???5.3?????????\",\"snapshot_url\":\"f:619167151827364_1\",\"status\":\"TRADE_CLOSED\",\"store_code\":\"IC\",\"title\":\"?? ????? ?? ??? ??????????? ????\",\"total_fee\":\"26.50\"}]},\"pay_time\":\"2014-04-18 09:09:36\",\"payment\":\"26.50\",\"pcc_af\":0,\"pic_path\":\"http:\\/\\/img03.taobaocdn.com\\/bao\\/uploaded\\/i3\\/505753958\\/T2y85_Xu8XXXXXXXXX_!!505753958.jpg\",\"point_fee\":0,\"post_fee\":\"0.00\",\"price\":\"17.80\",\"promotion_details\":{\"promotion_detail\":[{\"discount_fee\":\"0.00\",\"id\":619167151827364,\"promotion_desc\":\"????3???????:?0.00?\",\"promotion_id\":\"mjs1311924605-301422342_1850360278\",\"promotion_name\":\"????3???????\"},{\"discount_fee\":\"62.50\",\"id\":619167151827364,\"promotion_desc\":\"?????:?62.50?\",\"promotion_id\":\"Tmall$tmallItemPromotion-32438445_124078232\",\"promotion_name\":\"?????\"}]},\"real_point_fee\":0,\"received_payment\":\"0.00\",\"receiver_address\":\"????????\",\"receiver_city\":\"???\",\"receiver_district\":\"???\",\"receiver_mobile\":\"13979410356\",\"receiver_name\":\"??\",\"receiver_phone\":\"\",\"receiver_state\":\"???\",\"receiver_zip\":\"344500\",\"seller_alipay_no\":\"chinabnscom@163.com\",\"seller_can_rate\":false,\"seller_cod_fee\":\"0.00\",\"seller_email\":\"bns_hz@163.com\",\"seller_flag\":0,\"seller_mobile\":\"17767050207\",\"seller_name\":\"???????????\",\"seller_nick\":\"????????\",\"seller_phone\":\"0579-89980996\",\"seller_rate\":false,\"service_tags\":{},\"shipping_type\":\"express\",\"snapshot_url\":\"f:619167151827364_1\",\"status\":\"TRADE_CLOSED\",\"tid\":619167151827364,\"title\":\"????????\",\"total_fee\":\"89.00\",\"trade_from\":\"WAP\",\"type\":\"fixed\"}}}";
        TaoBaoTradeVO trade = new PolySpireTaoBaoTradeService().parseTradeJson(tradeJson);
        System.out.println(trade);
    }
}
