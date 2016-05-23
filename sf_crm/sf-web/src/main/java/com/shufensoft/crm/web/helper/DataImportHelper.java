package com.shufensoft.crm.web.helper;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.receiver.ReceiverJD;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.ItemInfoJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.service.trade.JdTradeService;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.common.utils.*;
import com.shufensoft.crm.enums.JdOrderStatus;
import com.shufensoft.crm.enums.TaoBaoOrderStatus;
import com.shufensoft.crm.enums.TaoBaoShippingTypeStatus;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                   数据导入helper
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/24  
 */
public class DataImportHelper {


    private static TaoBaoTradeService taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");

    private static JdTradeService jdTradeService = (JdTradeService) SpringContextUtil.getBean("jdTradeService");

    public static boolean importTrade(String sellerId,String shopId,MultipartFile file) throws Exception {

        SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerId,shopId);

        if (DaoConstant.ShopType.TB.equals(sellerShop.getShopType()) || DaoConstant.ShopType.TMALL.equals(sellerShop.getShopType())) {

            return taoBaoTradeService.saveOrUpdateTradeList(Long.valueOf(sellerId), Long.valueOf(shopId),
                    importTaoBaoTrade(sellerId,shopId,file));

        }

        if (DaoConstant.ShopType.JD.equals(sellerShop.getShopType())) {

            return jdTradeService.saveOrUpdateTrades(Long.valueOf(sellerId), Long.valueOf(shopId),
                    importJDOrder(sellerId,shopId,file));

        }

        return true;
    }

    /**
     * 淘宝订单导入
     * @param file
     * @return
     * @throws Exception
     */
    public static List<TradeTaoBao> importTaoBaoTrade(String sellerId,String shopId,MultipartFile file) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        CSVParser parser = CsvUtils.getCSVParser(file.getInputStream());

        List<TradeTaoBao> taoBaoList = new ArrayList<TradeTaoBao>();

        for (CSVRecord record : parser) {
            TradeTaoBao tradeTaoBao = null;
            try {
                tradeTaoBao = new TradeTaoBao();
                tradeTaoBao.setSellerId(Long.valueOf(sellerId));
                tradeTaoBao.setShopId(Long.valueOf(shopId));
                String tidStr = record.get("订单编号");
                if (StringUtils.isNotBlank(tidStr)) {
                    String[] tidSplit = tidStr.split("\"");
                    tradeTaoBao.setTid(Long.valueOf(tidSplit.length == 2 ? tidSplit[1] : tidStr));
                }

                tradeTaoBao.setBuyerNick(record.get("买家会员名"));
                tradeTaoBao.setBuyerAlipayNo(record.get("买家支付宝账号"));
                tradeTaoBao.setPrice(new BigDecimal(record.get("买家应付货款")));
                tradeTaoBao.setPostFee(new BigDecimal(record.get("买家应付邮费")));
                tradeTaoBao.setPointFee(Integer.valueOf(record.get("买家支付积分")));
                tradeTaoBao.setTotalFee(new BigDecimal(record.get("总金额")));
                tradeTaoBao.setBuyerObtainPointFee(Integer.valueOf(record.get("返点积分")));
                tradeTaoBao.setPayment(new BigDecimal(record.get("买家应付货款")));
                tradeTaoBao.setRealPointFee(Integer.valueOf(record.get("买家实际支付积分")));
                tradeTaoBao.setStatus(getTaoBaoTradeStatus(record.get("订单状态")));
                tradeTaoBao.setBuyerMessage(record.get("买家留言"));
                tradeTaoBao.setReceiverName(record.get("收货人姓名"));
                initReceiverAddressInfo(tradeTaoBao, record.get("收货地址 "));

                SellerConfigInfo sellerConfigInfo = SellerConfigCache.get(sellerId);
                SellerShop sellerShop = SellerConfigCache.getSellerShop(sellerId, shopId);
                tradeTaoBao.setSellerName(sellerConfigInfo.getSellerName());
                tradeTaoBao.setSellerNick(sellerShop.getShopName());
                tradeTaoBao.setSellerMobile(sellerConfigInfo.getMobile());
                tradeTaoBao.setSellerEmail(sellerConfigInfo.getEmail());
                tradeTaoBao.setSellerPhone(sellerConfigInfo.getPhone());

                if (StringUtils.isNotBlank(record.get("修改后的收货地址"))) {
                    initReceiverAddressInfo(tradeTaoBao, record.get("修改后的收货地址"));
                }

                TaoBaoShippingTypeStatus taoBaoShippingTypeStatus = TaoBaoShippingTypeStatus.getEnumByValue(record.get("运送方式"));
                if(taoBaoShippingTypeStatus!=null){
                    tradeTaoBao.setShippingType(taoBaoShippingTypeStatus.getCode());
                }
                tradeTaoBao.setReceiverPhone(StringUtils.isBlank(record.get("联系电话 ")) ? null : record.get("联系电话 ").substring(1));
                tradeTaoBao.setReceiverMobile(StringUtils.isBlank(record.get("联系手机")) ? null : record.get("联系手机").substring(1));

                String createDate = record.get("订单创建时间");
                tradeTaoBao.setCreated(StringUtils.isBlank(createDate) ? null : simpleDateFormat.parse(createDate));

                String payTimeStr = record.get("订单付款时间 ");
                Date payTime = StringUtils.isBlank(payTimeStr) ? null : simpleDateFormat.parse(payTimeStr);
                tradeTaoBao.setPayTime(payTime);
                if (payTime != null) {
                    tradeTaoBao.setModified(payTime);
                } else {
                    tradeTaoBao.setModified(StringUtils.isBlank(createDate) ? null : simpleDateFormat.parse(createDate));
                }

                tradeTaoBao.setTradeMemo(record.get("订单备注"));
                tradeTaoBao.setNum(Integer.valueOf(record.get("宝贝总数量")));
                tradeTaoBao.setGoodsCategoryNum(Integer.valueOf(record.get("宝贝种类 ")));
                tradeTaoBao.setTradeCloseReson(record.get("订单关闭原因"));
                tradeTaoBao.setTradeCloseReson("手机订单".equals(record.get("是否手机订单")) ? "WAP" : "TAOBAO");
                tradeTaoBao.setMarkDesc(record.get("异常信息"));
                tradeTaoBao.setPccAf(StringUtils.isBlank(record.get("天猫卡券抵扣")) ? 0 : Integer.valueOf(record.get("天猫卡券抵扣").trim()));
                tradeTaoBao.setAlipayPoint(StringUtils.isBlank(record.get("集分宝抵扣")) ? 0 : Integer.valueOf(record.get("集分宝抵扣").trim()));
                String[] steps = getTaoBaoStepTradeInfo(record.get("分阶段订单信息"));
                tradeTaoBao.setStepTradeStatus(steps != null && steps.length == 2 ? steps[0] : null);
                tradeTaoBao.setStepPaidFee(steps != null && steps.length == 2 ? steps[1] : null);
                String title = record.get("宝贝标题 ");
                tradeTaoBao.setTitle(record.get("宝贝标题 "));

                String[] titles = null;
                if (StringUtils.isNotBlank(title)) {

                    titles = title.split("，");
                }
                List<OrderTaoBao> orders = new ArrayList<OrderTaoBao>();
                tradeTaoBao.setIsExcelImport(DaoConstant.TrueOrFalse.TRUE);
                if (titles == null) {
                    OrderTaoBao orderTaoBao = new OrderTaoBao();
                    orderTaoBao.setSellerId(Long.valueOf(sellerId));
                    orderTaoBao.setShopId(Long.valueOf(shopId));
                    orderTaoBao.setPrice(tradeTaoBao.getPrice());
                    orderTaoBao.setNum(tradeTaoBao.getNum());
                    orderTaoBao.setTotalFee(tradeTaoBao.getPrice());
                    orderTaoBao.setPayment(tradeTaoBao.getPayment());
                    initOrderTaoBaoTrade(record, orderTaoBao, tradeTaoBao, null);
                    orders.add(orderTaoBao);
                    tradeTaoBao.setOrders(orders);
                    taoBaoList.add(tradeTaoBao);
                    continue;
                }

                for (String titl : titles) {

                    OrderTaoBao orderTaoBao = new OrderTaoBao();
                    if (titles.length == 1) {
                        orderTaoBao.setSellerId(Long.valueOf(sellerId));
                        orderTaoBao.setShopId(Long.valueOf(shopId));
                        orderTaoBao.setPrice(tradeTaoBao.getPrice());
                        orderTaoBao.setNum(tradeTaoBao.getNum());
                        orderTaoBao.setTotalFee(tradeTaoBao.getPrice());
                        orderTaoBao.setPayment(tradeTaoBao.getPayment());
                    }
                    initOrderTaoBaoTrade(record, orderTaoBao, tradeTaoBao, titl);
                    orders.add(orderTaoBao);

                }

                tradeTaoBao.setOrders(orders);
                taoBaoList.add(tradeTaoBao);

            } catch (Exception e) {
                throw new RuntimeException("importTaoBaoTrade error [tid=" + tradeTaoBao.getTid() + "];errorMsg:"
                        + e.getMessage() == null ? e.toString() : e.getMessage(), e);
            }
        }

        return taoBaoList;
    }

    private static OrderTaoBao initOrderTaoBaoTrade(CSVRecord record, OrderTaoBao orderTaoBao, TradeTaoBao tradeTaoBao, String titl) {

        orderTaoBao.setTitle(titl);
        orderTaoBao.setOid(0l);
        orderTaoBao.setSellerNick(tradeTaoBao.getSellerNick());
        orderTaoBao.setTid(tradeTaoBao.getTid());
        orderTaoBao.setBuyerNick(tradeTaoBao.getBuyerNick());
        orderTaoBao.setStatus(tradeTaoBao.getStatus());

        orderTaoBao.setModified(tradeTaoBao.getModified());
        String invoiceNoStr = record.get("物流单号 ");
        if (StringUtils.isNotBlank(invoiceNoStr)) {
            orderTaoBao.setInvoiceNo(invoiceNoStr.substring(3));
        }

        TaoBaoShippingTypeStatus taoBaoShippingTypeStatus = TaoBaoShippingTypeStatus.getEnumByValue(record.get("运送方式"));
        if(taoBaoShippingTypeStatus!=null){
            orderTaoBao.setShippingType(taoBaoShippingTypeStatus.getCode());
        }

        orderTaoBao.setOrderFrom("手机订单".equals(record.get("是否手机订单")) ? "wap" : "trade");
        String modifySku = record.get("修改后的sku");
        if (StringUtils.isNotBlank(modifySku)) {
            orderTaoBao.setSkuId(modifySku);
        }

        orderTaoBao.setLogisticsCompany(record.get("物流公司"));

        return orderTaoBao;
    }

    private static void initReceiverAddressInfo(TradeTaoBao tradeTaoBao, String receiverAddress) {

        if (StringUtils.isBlank(receiverAddress)) {
            return;
        }

        String[] address = receiverAddress.split(" ");
        if (address == null || address.length == 0) {
            return;
        }

        if (address.length < 4) {
            return;
        }

        tradeTaoBao.setReceiverState(address[0]);
        tradeTaoBao.setReceiverCity(address[1]);
        tradeTaoBao.setReceiverDistrict(address[2]);

        String addressStr = null;
        if (address.length == 4) {
            addressStr = address[3];
        }

        if (address.length == 5) {
            addressStr = address[3] + address[4];
        }

        if (address.length > 5) {

            addressStr = address[3];
            for (int i = 3; i < address.length; i++) {
                if (StringUtils.isNotBlank(address[i].trim())) {
                    addressStr = addressStr + address[i];
                }
            }

        }

        if (StringUtils.isNotBlank(addressStr)) {
            String[] addressArr = addressStr.split("\\(");
            if (addressArr != null && addressArr.length > 1) {
                tradeTaoBao.setReceiverAddress(addressArr[0]);
                tradeTaoBao.setReceiverZip(addressArr[1].substring(0, addressArr[1].length() - 1));
            }
        }


    }

    /**
     * 获取分阶段订单信息
     *
     * @param step
     * @return
     */
    private static String[] getTaoBaoStepTradeInfo(String step) {

        if (StringUtils.isBlank(step)) {
            return null;
        }

        String[] steps = step.split(";");
        String[] strings = new String[2];
        for (String str : steps) {

            if (StringUtils.isBlank(str)) {
                continue;
            }

            String[] statusStrs = str.split("，");

            if (statusStrs != null && statusStrs.length == 3) {
                strings[0] = statusStrs[2];
                String[] prices = statusStrs[1].split("：");
                strings[1] = prices != null && prices.length == 2 ? prices[1] : "null";
            }

        }

        return strings;

    }

    /**
     * 获取订单状态
     *
     * @param status
     * @return
     */
    private static String getTaoBaoTradeStatus(String status) {

        if (StringUtils.isBlank(status)) {
            return null;
        }

        TaoBaoOrderStatus taoBaoOrderStatus = TaoBaoOrderStatus.getEnumByValue(status);
        if (taoBaoOrderStatus != null) {
            return taoBaoOrderStatus.getCode();
        }

        return null;

    }

    /**
     * 处理从CSV文件导入的京东订单数据
     *
     * @param file
     * @return
     */
    public static List<OrderJD> importJDOrder(String sellerId,String shopId,MultipartFile file) throws Exception {

        CSVParser parser = CsvUtils.getCSVParser(file.getInputStream());

        OrderJD obj;
        ItemInfoJD item;
        ReceiverJD recJd;
        List<ItemInfoJD> items;
        List<OrderJD> list = new ArrayList<OrderJD>();

        for (CSVRecord record : parser) {

            obj = new OrderJD();
            obj.setSellerId(Long.valueOf(sellerId));
            obj.setShopId(Long.valueOf(shopId));
            String orderId = record.get("订单号");
            obj.setOrderId(orderId);

            item = new ItemInfoJD();
            item.setWareId(record.get("商品ID"));
            item.setOrderId(orderId);
            item.setSkuName(record.get("商品名称"));
            String total = record.get("订购数量");
            if (CommonUtil.validateInteger(total)) {
                item.setItemTotal(Integer.parseInt(total));
            }
            item.setProductNo(record.get("货号"));

            obj.setPayType(record.get("支付方式"));
            obj.setOrderStartTime(DateUtil.getDateFromStr(record.get("下单时间")));
            item.setJdPrice(record.get("京东价"));
            String orderTotalPrice = record.get("订单金额");
            if (CommonUtil.validateDouble(orderTotalPrice)) {
                obj.setOrderTotalPrice(CommonUtil.getDecimalFromString(orderTotalPrice));
            }
            String orderPayment = record.get("应付金额");
            if (CommonUtil.validateDouble(orderPayment)) {
                obj.setOrderPayment(CommonUtil.getDecimalFromString(orderPayment));
            }
            String orderSellerProce = record.get("结算金额");
            if (CommonUtil.validateDouble(orderSellerProce)) {
                obj.setOrderSellerPrice(CommonUtil.getDecimalFromString(orderSellerProce));
            }
            String balanceUsed = record.get("余额支付");
            if (CommonUtil.validateDouble(balanceUsed)) {
                obj.setBalanceUsed(CommonUtil.getDecimalFromString(balanceUsed));
            }
            String orderStatus = JdOrderStatus.getKeyFromValue(record.get("订单状态"));
            obj.setOrderState(orderStatus);
            obj.setOrderType(record.get("订单类型"));
            obj.setPin(record.get(13));
            recJd = new ReceiverJD();
            recJd.setFullname(record.get(14));
            recJd.setFullAddress(record.get(15));
            recJd.setMobile(record.get(16));
            recJd.setCreated(obj.getOrderStartTime());
            obj.setInvoiceInfo(record.get("发票类型"));
            obj.setVenderRemark(record.get("商家备注"));
            String freightPrice = record.get("运费金额");
            if (CommonUtil.validateDouble(freightPrice)) {
                obj.setFreightPrice(CommonUtil.getDecimalFromString(freightPrice));
            }
            obj.setPaymentConfirmTime(DateUtil.getDateFromStr(record.get("付款确认时间")));
            obj.setOrderSource(record.get("订单来源"));
            obj.setReceiverJD(recJd);
            items = new ArrayList<ItemInfoJD>();
            items.add(item);
            obj.setItemInfoJDList(items);
            obj.setIsExcelImport(DaoConstant.TrueOrFalse.TRUE);
            list.add(obj);
        }

        return list;

    }

}
