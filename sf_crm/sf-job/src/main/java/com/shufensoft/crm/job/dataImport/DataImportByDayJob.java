package com.shufensoft.crm.job.dataImport;

import com.shufensoft.crm.biz.cache.SellerConfigCache;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.seller.SellerShop;
import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import com.shufensoft.crm.biz.domain.generation.trade.TradeTaoBao;
import com.shufensoft.crm.biz.service.trade.TaoBaoTradeService;
import com.shufensoft.crm.common.utils.CsvUtils;
import com.shufensoft.crm.common.utils.PropertyReader;
import com.shufensoft.crm.common.utils.SpringContextUtil;
import com.shufensoft.crm.common.utils.StringUtils;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.enums.TaoBaoOrderStatus;
import com.shufensoft.crm.enums.TaoBaoShippingTypeStatus;
import com.shufensoft.crm.job.base.AsyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/8/27  
 */
public class DataImportByDayJob extends AsyncJob {

    private Logger logger = Logger.getLogger(DataImportByDayJob.class);

    private static TaoBaoTradeService taoBaoTradeService = (TaoBaoTradeService) SpringContextUtil.getBean("taoBaoTradeService");

    private final static String BASE_URL = PropertyReader.getValue("tb.csv.data.path");

    private final static String CSV_FILE_PREFIX = "ExportOrderList_";

    private final static String CSV_FILE_SUBFIX = ".csv";

    public String jobName() {
        return JobConstant.JobName.DATA_IMPORT_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void execute(JobContext jobContext) {
        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();
        List<SellerShop> sellerShops = sellerConfigInfo.getSellerShopList();
        if (!CollectionUtils.isEmpty(sellerShops)) {
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMdd");
            String nowDayStr = simpleDateFormat1.format(new Date());
            String sellerId = String.valueOf(sellerConfigInfo.getSellerId());
            for (SellerShop sellerShop : sellerShops) {
                String shopId = String.valueOf(sellerShop.getShopId());
                String path = null;
                if (BASE_URL.endsWith("/")) {
                    path += (sellerId + "/" + shopId);
                } else {
                    path += ("/" + sellerId + "/" + shopId);
                }
                File file = new File(path, CSV_FILE_PREFIX + nowDayStr + CSV_FILE_SUBFIX);
                if (file.exists()) {
                    try {
                        List<TradeTaoBao> tradeTaoBaos = importTaoBaoTrade(sellerId, shopId, file);
                        taoBaoTradeService.saveOrUpdateTradeList(sellerConfigInfo.getSellerId(), sellerShop.getShopId(), tradeTaoBaos);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e.getMessage(), e);
                    }
                }

            }
        }

    }

    /**
     *
     * */
    public static List<TradeTaoBao> importTaoBaoTrade(String sellerId, String shopId, File csvFile) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InputStream is = new FileInputStream(csvFile);
        CSVParser parser = CsvUtils.getCSVParser(is);

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
                tradeTaoBao.setSellerNick(sellerConfigInfo.getSellerName());
                tradeTaoBao.setSellerMobile(sellerConfigInfo.getMobile());
                tradeTaoBao.setSellerEmail(sellerConfigInfo.getEmail());
                tradeTaoBao.setSellerPhone(sellerConfigInfo.getPhone());

                if (StringUtils.isNotBlank(record.get("修改后的收货地址"))) {
                    initReceiverAddressInfo(tradeTaoBao, record.get("修改后的收货地址"));
                }

                TaoBaoShippingTypeStatus taoBaoShippingTypeStatus = TaoBaoShippingTypeStatus.getEnumByValue(record.get("运送方式"));
                if (taoBaoShippingTypeStatus != null) {
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
        if (taoBaoShippingTypeStatus != null) {
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


}