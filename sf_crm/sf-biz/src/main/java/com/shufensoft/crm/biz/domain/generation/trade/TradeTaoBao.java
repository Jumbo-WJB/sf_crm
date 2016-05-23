package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Domain
@Data
@ToString
public class TradeTaoBao {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 交易编号 (父订单的交易编号) */
    private Long tid;

    /**  */
    private Long sellerId;

    /** 店铺Id */
    private Long shopId;

    /** 关联user_taobao表user_id_tb */
    private Long userIdTb;

    /** 收件人Id */
    private Long receiverIdTb;

    /** 卖家昵称 */
    private String sellerNick;

    /** 运送方式 */
    private String shippingType;

    /** 实付金额。精确到2位小数;单位: 元。如:200.07，表示:200元7分 */
    private BigDecimal payment;

    /** 卖家是否已评价 */
    private String sellerRate;

    /** 返点积分 */
    private Integer buyerObtainPointFee;

    /** 快递费用 */
    private BigDecimal postFee;

    /** 收货人的姓名 */
    private String receiverName;

    /** 国家 */
    private String receiverCountry;

    /**  收货人的所在省份 */
    private String receiverState;

    /** 城镇 */
    private String receiverTown;

    /** 收货人的详细地址 */
    private String receiverAddress;

    /** 收货人的邮编 */
    private String receiverZip;

    /** 收货人的手机号码 */
    private String receiverMobile;

    /**  收货人的电话号码 */
    private String receiverPhone;

    /** 卖家发货时间。 格式: yyyy -MM - dd HH: mm :ss */
    private Date consignTime;

    /** 卖家支付宝账号 */
    private String sellerAlipayNo;

    /** 卖家手机 */
    private String sellerMobile;

    /** 卖家电话 */
    private String sellerPhone;

    /** 卖家姓名 */
    private String sellerName;

    /** 卖家邮件地址 */
    private String sellerEmail;

    /** 交易中剩余的确认收货金额 */
    private BigDecimal availableConfirmFee;

    /** 卖家实际收到的支付宝打款金额 */
    private BigDecimal receivedPayment;

    /** 超时到期时间。 格式: yyyy -MM - dd HH: mm :ss。 */
    private Date timeoutActionTime;

    /** 是否是3D淘宝交易 */
    private String is3d;

    /** 交易促销详细信息 */
    private String promotion;

    /** 商家的预计发货时间 */
    private Date estConTime;

    /** 发票类型（1 电子发票 2 纸质发票） */
    private String invoiceKind;

    /** 商品种类数量 */
    private Integer goodsCategoryNum;

    /** 商品购买数量。 */
    private Integer num;

    /** 商品数字编号列表 */
    private String numIid;

    /** 交易状态。 */
    private String status;

    /** 交易标题，以店铺名作为此标题的值。 */
    private String title;

    /** 交易类型列表 */
    private String type;

    /** 商品价格。 */
    private BigDecimal price;

    /** 卖家货到付款服务费。 */
    private BigDecimal sellerCodFee;

    /** 系统优惠金额 */
    private BigDecimal discountFee;

    /** 买家使用积分 下单时生成，且一直不变。格式:100;单位: 个. */
    private Integer pointFee;

    /** 商品金额 */
    private BigDecimal totalFee;

    /** 表示是否是品牌特卖 */
    private String isBrandSale;

    /** 次日达订单送达时间 */
    private BigDecimal lgAging;

    /** 交易创建时间。 格式: yyyy -MM - dd HH: mm :ss */
    private Date created;

    /** 付款时间。 格式: yyyy -MM - dd HH: mm :ss */
    private Date payTime;

    /** 交易修改时间 */
    private Date modified;

    /** 交易结束时间。 */
    private Date endTime;

    /** 买家留言 */
    private String buyerMessage;

    /** 买家的支付宝id号 */
    private Long alipayId;

    /** 支付宝交易号，如：2009112081173831 */
    private String alipayNo;

    /** 买家支付宝账号 */
    private String buyerAlipayNo;

    /** 买家备注 */
    private String buyerMemo;

    /** 买家备注旗帜 */
    private Integer buyerFlag;

    /** 卖家备注 */
    private String sellerMemo;

    /** 卖家备注旗帜 */
    private Integer sellerFlag;

    /** 买家昵称 */
    private String buyerNick;

    /** 买家下单的地区 */
    private String buyerArea;

    /** 买家邮件地址 */
    private String buyerEmail;

    /** 判断订单是否有买家留言，有买家留言返回true，否则返回false */
    private String hasBuyerMessage;

    /** 区域id */
    private String areaId;

    /** 使用信用卡支付金额数 */
    private String creditCardFee;

    /** 卡易售垂直表信息，去除下单ip之后的结果 */
    private String nutFeature;

    /** 分阶段付款的订单状态 */
    private String stepTradeStatus;

    /**  分阶段付款的已付金额（万人团订单已付金额） */
    private String stepPaidFee;

    /** 订单出现异常问题的时候，给予用户的描述 没有异常的时候，此值为空 */
    private String markDesc;

    /** 订单将在此时间前发出，主要用于预售订单 */
    private String sendTime;

    /** 交易内部来源。 */
    private String tradeFrom;

    /** 淘宝下单成功了 但由于某种错误支付宝订单没有创建时返回的信息。trade.trade.add接口专用 */
    private String alipayWarnMsg;

    /** 货到付款物流状态。 */
    private String codStatus;

    /** 买家可以通过此字段查询是否当前交易可以评论，can_rate=true可以评价，false则不能评价。 */
    private String canRate;

    /** 交易佣金。 */
    private String commissionFee;

    /** 交易备注。 */
    private String tradeMemo;

    /** 买家是否已评价。 */
    private String buyerRate;

    /**  交易外部来源：ownshop(商家官网) */
    private String tradeSource;

    /** 是否是多次发货的订单 */
    private String isPartConsign;

    /** 买家实际使用积分 */
    private Integer realPointFee;

    /** 收货人的所在城市 */
    private String receiverCity;

    /** 收货人的所在地区 */
    private String receiverDistrict;

    /** 物流到货时效，单位天 */
    private Integer arriveInterval;

    /**  物流到货时效截单时间，格式 HH: mm */
    private String arriveCutTime;

    /**  物流发货时效，单位小时 */
    private Integer consignInterval;

    /** 同步到卖家库的时间，trade.trades.sold.incrementv.get接口返回此字段 */
    private Date asyncModified;

    /** 付款时使用的支付宝积分的额度 单位分，比如返回1，则为1分钱 */
    private Integer alipayPoint;

    /** 天猫点券卡实付款金额 单位分 */
    private Integer pccAf;

    /** 子订单是否是wt订单 */
    private String isWt;

    /** 是否是excel导入 */
    private String isExcelImport;

    /**  */
    private String tradeCloseReson;

    private List<OrderTaoBao> orders;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String idExpression;

    /** 与 max(id) 映射**/
    private Long maxId;

    /** 与 min(id) 映射**/
    private Long minId;

    /** 与 avg(id) 映射**/
    private Long avgId;

    /** 与 count(id) 映射**/
    private Long countId;

    /** 与 sum(id) 映射**/
    private Long sumId;

    /** gmtCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtCreatedExpression;

    /** 与 max(gmtCreated) 映射**/
    private Long maxGmtCreated;

    /** 与 min(gmtCreated) 映射**/
    private Long minGmtCreated;

    /** 与 avg(gmtCreated) 映射**/
    private Long avgGmtCreated;

    /** 与 count(gmtCreated) 映射**/
    private Long countGmtCreated;

    /** 与 sum(gmtCreated) 映射**/
    private Date sumGmtCreated;

    /** gmtModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtModifiedExpression;

    /** 与 max(gmtModified) 映射**/
    private Long maxGmtModified;

    /** 与 min(gmtModified) 映射**/
    private Long minGmtModified;

    /** 与 avg(gmtModified) 映射**/
    private Long avgGmtModified;

    /** 与 count(gmtModified) 映射**/
    private Long countGmtModified;

    /** 与 sum(gmtModified) 映射**/
    private Date sumGmtModified;

    /** isDeleted属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDeletedExpression;

    /** 与 max(isDeleted) 映射**/
    private Long maxIsDeleted;

    /** 与 min(isDeleted) 映射**/
    private Long minIsDeleted;

    /** 与 avg(isDeleted) 映射**/
    private Long avgIsDeleted;

    /** 与 count(isDeleted) 映射**/
    private Long countIsDeleted;

    /** 与 sum(isDeleted) 映射**/
    private String sumIsDeleted;

    /** tid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tidExpression;

    /** 与 max(tid) 映射**/
    private Long maxTid;

    /** 与 min(tid) 映射**/
    private Long minTid;

    /** 与 avg(tid) 映射**/
    private Long avgTid;

    /** 与 count(tid) 映射**/
    private Long countTid;

    /** 与 sum(tid) 映射**/
    private Long sumTid;

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** 与 max(sellerId) 映射**/
    private Long maxSellerId;

    /** 与 min(sellerId) 映射**/
    private Long minSellerId;

    /** 与 avg(sellerId) 映射**/
    private Long avgSellerId;

    /** 与 count(sellerId) 映射**/
    private Long countSellerId;

    /** 与 sum(sellerId) 映射**/
    private Long sumSellerId;

    /** shopId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shopIdExpression;

    /** 与 max(shopId) 映射**/
    private Long maxShopId;

    /** 与 min(shopId) 映射**/
    private Long minShopId;

    /** 与 avg(shopId) 映射**/
    private Long avgShopId;

    /** 与 count(shopId) 映射**/
    private Long countShopId;

    /** 与 sum(shopId) 映射**/
    private Long sumShopId;

    /** userIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdTbExpression;

    /** 与 max(userIdTb) 映射**/
    private Long maxUserIdTb;

    /** 与 min(userIdTb) 映射**/
    private Long minUserIdTb;

    /** 与 avg(userIdTb) 映射**/
    private Long avgUserIdTb;

    /** 与 count(userIdTb) 映射**/
    private Long countUserIdTb;

    /** 与 sum(userIdTb) 映射**/
    private Long sumUserIdTb;

    /** receiverIdTb属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverIdTbExpression;

    /** 与 max(receiverIdTb) 映射**/
    private Long maxReceiverIdTb;

    /** 与 min(receiverIdTb) 映射**/
    private Long minReceiverIdTb;

    /** 与 avg(receiverIdTb) 映射**/
    private Long avgReceiverIdTb;

    /** 与 count(receiverIdTb) 映射**/
    private Long countReceiverIdTb;

    /** 与 sum(receiverIdTb) 映射**/
    private Long sumReceiverIdTb;

    /** sellerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerNickExpression;

    /** 与 max(sellerNick) 映射**/
    private Long maxSellerNick;

    /** 与 min(sellerNick) 映射**/
    private Long minSellerNick;

    /** 与 avg(sellerNick) 映射**/
    private Long avgSellerNick;

    /** 与 count(sellerNick) 映射**/
    private Long countSellerNick;

    /** 与 sum(sellerNick) 映射**/
    private String sumSellerNick;

    /** shippingType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String shippingTypeExpression;

    /** 与 max(shippingType) 映射**/
    private Long maxShippingType;

    /** 与 min(shippingType) 映射**/
    private Long minShippingType;

    /** 与 avg(shippingType) 映射**/
    private Long avgShippingType;

    /** 与 count(shippingType) 映射**/
    private Long countShippingType;

    /** 与 sum(shippingType) 映射**/
    private String sumShippingType;

    /** payment属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String paymentExpression;

    /** 与 max(payment) 映射**/
    private Long maxPayment;

    /** 与 min(payment) 映射**/
    private Long minPayment;

    /** 与 avg(payment) 映射**/
    private Long avgPayment;

    /** 与 count(payment) 映射**/
    private Long countPayment;

    /** 与 sum(payment) 映射**/
    private BigDecimal sumPayment;

    /** sellerRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerRateExpression;

    /** 与 max(sellerRate) 映射**/
    private Long maxSellerRate;

    /** 与 min(sellerRate) 映射**/
    private Long minSellerRate;

    /** 与 avg(sellerRate) 映射**/
    private Long avgSellerRate;

    /** 与 count(sellerRate) 映射**/
    private Long countSellerRate;

    /** 与 sum(sellerRate) 映射**/
    private String sumSellerRate;

    /** buyerObtainPointFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerObtainPointFeeExpression;

    /** 与 max(buyerObtainPointFee) 映射**/
    private Long maxBuyerObtainPointFee;

    /** 与 min(buyerObtainPointFee) 映射**/
    private Long minBuyerObtainPointFee;

    /** 与 avg(buyerObtainPointFee) 映射**/
    private Long avgBuyerObtainPointFee;

    /** 与 count(buyerObtainPointFee) 映射**/
    private Long countBuyerObtainPointFee;

    /** 与 sum(buyerObtainPointFee) 映射**/
    private Integer sumBuyerObtainPointFee;

    /** postFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String postFeeExpression;

    /** 与 max(postFee) 映射**/
    private Long maxPostFee;

    /** 与 min(postFee) 映射**/
    private Long minPostFee;

    /** 与 avg(postFee) 映射**/
    private Long avgPostFee;

    /** 与 count(postFee) 映射**/
    private Long countPostFee;

    /** 与 sum(postFee) 映射**/
    private BigDecimal sumPostFee;

    /** receiverName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverNameExpression;

    /** 与 max(receiverName) 映射**/
    private Long maxReceiverName;

    /** 与 min(receiverName) 映射**/
    private Long minReceiverName;

    /** 与 avg(receiverName) 映射**/
    private Long avgReceiverName;

    /** 与 count(receiverName) 映射**/
    private Long countReceiverName;

    /** 与 sum(receiverName) 映射**/
    private String sumReceiverName;

    /** receiverCountry属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverCountryExpression;

    /** 与 max(receiverCountry) 映射**/
    private Long maxReceiverCountry;

    /** 与 min(receiverCountry) 映射**/
    private Long minReceiverCountry;

    /** 与 avg(receiverCountry) 映射**/
    private Long avgReceiverCountry;

    /** 与 count(receiverCountry) 映射**/
    private Long countReceiverCountry;

    /** 与 sum(receiverCountry) 映射**/
    private String sumReceiverCountry;

    /** receiverState属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverStateExpression;

    /** 与 max(receiverState) 映射**/
    private Long maxReceiverState;

    /** 与 min(receiverState) 映射**/
    private Long minReceiverState;

    /** 与 avg(receiverState) 映射**/
    private Long avgReceiverState;

    /** 与 count(receiverState) 映射**/
    private Long countReceiverState;

    /** 与 sum(receiverState) 映射**/
    private String sumReceiverState;

    /** receiverTown属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverTownExpression;

    /** 与 max(receiverTown) 映射**/
    private Long maxReceiverTown;

    /** 与 min(receiverTown) 映射**/
    private Long minReceiverTown;

    /** 与 avg(receiverTown) 映射**/
    private Long avgReceiverTown;

    /** 与 count(receiverTown) 映射**/
    private Long countReceiverTown;

    /** 与 sum(receiverTown) 映射**/
    private String sumReceiverTown;

    /** receiverAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverAddressExpression;

    /** 与 max(receiverAddress) 映射**/
    private Long maxReceiverAddress;

    /** 与 min(receiverAddress) 映射**/
    private Long minReceiverAddress;

    /** 与 avg(receiverAddress) 映射**/
    private Long avgReceiverAddress;

    /** 与 count(receiverAddress) 映射**/
    private Long countReceiverAddress;

    /** 与 sum(receiverAddress) 映射**/
    private String sumReceiverAddress;

    /** receiverZip属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverZipExpression;

    /** 与 max(receiverZip) 映射**/
    private Long maxReceiverZip;

    /** 与 min(receiverZip) 映射**/
    private Long minReceiverZip;

    /** 与 avg(receiverZip) 映射**/
    private Long avgReceiverZip;

    /** 与 count(receiverZip) 映射**/
    private Long countReceiverZip;

    /** 与 sum(receiverZip) 映射**/
    private String sumReceiverZip;

    /** receiverMobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverMobileExpression;

    /** 与 max(receiverMobile) 映射**/
    private Long maxReceiverMobile;

    /** 与 min(receiverMobile) 映射**/
    private Long minReceiverMobile;

    /** 与 avg(receiverMobile) 映射**/
    private Long avgReceiverMobile;

    /** 与 count(receiverMobile) 映射**/
    private Long countReceiverMobile;

    /** 与 sum(receiverMobile) 映射**/
    private String sumReceiverMobile;

    /** receiverPhone属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverPhoneExpression;

    /** 与 max(receiverPhone) 映射**/
    private Long maxReceiverPhone;

    /** 与 min(receiverPhone) 映射**/
    private Long minReceiverPhone;

    /** 与 avg(receiverPhone) 映射**/
    private Long avgReceiverPhone;

    /** 与 count(receiverPhone) 映射**/
    private Long countReceiverPhone;

    /** 与 sum(receiverPhone) 映射**/
    private String sumReceiverPhone;

    /** consignTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String consignTimeExpression;

    /** 与 max(consignTime) 映射**/
    private Long maxConsignTime;

    /** 与 min(consignTime) 映射**/
    private Long minConsignTime;

    /** 与 avg(consignTime) 映射**/
    private Long avgConsignTime;

    /** 与 count(consignTime) 映射**/
    private Long countConsignTime;

    /** 与 sum(consignTime) 映射**/
    private Date sumConsignTime;

    /** sellerAlipayNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerAlipayNoExpression;

    /** 与 max(sellerAlipayNo) 映射**/
    private Long maxSellerAlipayNo;

    /** 与 min(sellerAlipayNo) 映射**/
    private Long minSellerAlipayNo;

    /** 与 avg(sellerAlipayNo) 映射**/
    private Long avgSellerAlipayNo;

    /** 与 count(sellerAlipayNo) 映射**/
    private Long countSellerAlipayNo;

    /** 与 sum(sellerAlipayNo) 映射**/
    private String sumSellerAlipayNo;

    /** sellerMobile属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerMobileExpression;

    /** 与 max(sellerMobile) 映射**/
    private Long maxSellerMobile;

    /** 与 min(sellerMobile) 映射**/
    private Long minSellerMobile;

    /** 与 avg(sellerMobile) 映射**/
    private Long avgSellerMobile;

    /** 与 count(sellerMobile) 映射**/
    private Long countSellerMobile;

    /** 与 sum(sellerMobile) 映射**/
    private String sumSellerMobile;

    /** sellerPhone属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerPhoneExpression;

    /** 与 max(sellerPhone) 映射**/
    private Long maxSellerPhone;

    /** 与 min(sellerPhone) 映射**/
    private Long minSellerPhone;

    /** 与 avg(sellerPhone) 映射**/
    private Long avgSellerPhone;

    /** 与 count(sellerPhone) 映射**/
    private Long countSellerPhone;

    /** 与 sum(sellerPhone) 映射**/
    private String sumSellerPhone;

    /** sellerName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerNameExpression;

    /** 与 max(sellerName) 映射**/
    private Long maxSellerName;

    /** 与 min(sellerName) 映射**/
    private Long minSellerName;

    /** 与 avg(sellerName) 映射**/
    private Long avgSellerName;

    /** 与 count(sellerName) 映射**/
    private Long countSellerName;

    /** 与 sum(sellerName) 映射**/
    private String sumSellerName;

    /** sellerEmail属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerEmailExpression;

    /** 与 max(sellerEmail) 映射**/
    private Long maxSellerEmail;

    /** 与 min(sellerEmail) 映射**/
    private Long minSellerEmail;

    /** 与 avg(sellerEmail) 映射**/
    private Long avgSellerEmail;

    /** 与 count(sellerEmail) 映射**/
    private Long countSellerEmail;

    /** 与 sum(sellerEmail) 映射**/
    private String sumSellerEmail;

    /** availableConfirmFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String availableConfirmFeeExpression;

    /** 与 max(availableConfirmFee) 映射**/
    private Long maxAvailableConfirmFee;

    /** 与 min(availableConfirmFee) 映射**/
    private Long minAvailableConfirmFee;

    /** 与 avg(availableConfirmFee) 映射**/
    private Long avgAvailableConfirmFee;

    /** 与 count(availableConfirmFee) 映射**/
    private Long countAvailableConfirmFee;

    /** 与 sum(availableConfirmFee) 映射**/
    private BigDecimal sumAvailableConfirmFee;

    /** receivedPayment属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receivedPaymentExpression;

    /** 与 max(receivedPayment) 映射**/
    private Long maxReceivedPayment;

    /** 与 min(receivedPayment) 映射**/
    private Long minReceivedPayment;

    /** 与 avg(receivedPayment) 映射**/
    private Long avgReceivedPayment;

    /** 与 count(receivedPayment) 映射**/
    private Long countReceivedPayment;

    /** 与 sum(receivedPayment) 映射**/
    private BigDecimal sumReceivedPayment;

    /** timeoutActionTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String timeoutActionTimeExpression;

    /** 与 max(timeoutActionTime) 映射**/
    private Long maxTimeoutActionTime;

    /** 与 min(timeoutActionTime) 映射**/
    private Long minTimeoutActionTime;

    /** 与 avg(timeoutActionTime) 映射**/
    private Long avgTimeoutActionTime;

    /** 与 count(timeoutActionTime) 映射**/
    private Long countTimeoutActionTime;

    /** 与 sum(timeoutActionTime) 映射**/
    private Date sumTimeoutActionTime;

    /** is3d属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String is3dExpression;

    /** 与 max(is3d) 映射**/
    private Long maxIs3d;

    /** 与 min(is3d) 映射**/
    private Long minIs3d;

    /** 与 avg(is3d) 映射**/
    private Long avgIs3d;

    /** 与 count(is3d) 映射**/
    private Long countIs3d;

    /** 与 sum(is3d) 映射**/
    private String sumIs3d;

    /** promotion属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String promotionExpression;

    /** 与 max(promotion) 映射**/
    private Long maxPromotion;

    /** 与 min(promotion) 映射**/
    private Long minPromotion;

    /** 与 avg(promotion) 映射**/
    private Long avgPromotion;

    /** 与 count(promotion) 映射**/
    private Long countPromotion;

    /** 与 sum(promotion) 映射**/
    private String sumPromotion;

    /** estConTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String estConTimeExpression;

    /** 与 max(estConTime) 映射**/
    private Long maxEstConTime;

    /** 与 min(estConTime) 映射**/
    private Long minEstConTime;

    /** 与 avg(estConTime) 映射**/
    private Long avgEstConTime;

    /** 与 count(estConTime) 映射**/
    private Long countEstConTime;

    /** 与 sum(estConTime) 映射**/
    private Date sumEstConTime;

    /** invoiceKind属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String invoiceKindExpression;

    /** 与 max(invoiceKind) 映射**/
    private Long maxInvoiceKind;

    /** 与 min(invoiceKind) 映射**/
    private Long minInvoiceKind;

    /** 与 avg(invoiceKind) 映射**/
    private Long avgInvoiceKind;

    /** 与 count(invoiceKind) 映射**/
    private Long countInvoiceKind;

    /** 与 sum(invoiceKind) 映射**/
    private String sumInvoiceKind;

    /** goodsCategoryNum属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String goodsCategoryNumExpression;

    /** 与 max(goodsCategoryNum) 映射**/
    private Long maxGoodsCategoryNum;

    /** 与 min(goodsCategoryNum) 映射**/
    private Long minGoodsCategoryNum;

    /** 与 avg(goodsCategoryNum) 映射**/
    private Long avgGoodsCategoryNum;

    /** 与 count(goodsCategoryNum) 映射**/
    private Long countGoodsCategoryNum;

    /** 与 sum(goodsCategoryNum) 映射**/
    private Integer sumGoodsCategoryNum;

    /** num属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numExpression;

    /** 与 max(num) 映射**/
    private Long maxNum;

    /** 与 min(num) 映射**/
    private Long minNum;

    /** 与 avg(num) 映射**/
    private Long avgNum;

    /** 与 count(num) 映射**/
    private Long countNum;

    /** 与 sum(num) 映射**/
    private Integer sumNum;

    /** numIid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String numIidExpression;

    /** 与 max(numIid) 映射**/
    private Long maxNumIid;

    /** 与 min(numIid) 映射**/
    private Long minNumIid;

    /** 与 avg(numIid) 映射**/
    private Long avgNumIid;

    /** 与 count(numIid) 映射**/
    private Long countNumIid;

    /** 与 sum(numIid) 映射**/
    private String sumNumIid;

    /** status属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statusExpression;

    /** 与 max(status) 映射**/
    private Long maxStatus;

    /** 与 min(status) 映射**/
    private Long minStatus;

    /** 与 avg(status) 映射**/
    private Long avgStatus;

    /** 与 count(status) 映射**/
    private Long countStatus;

    /** 与 sum(status) 映射**/
    private String sumStatus;

    /** title属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String titleExpression;

    /** 与 max(title) 映射**/
    private Long maxTitle;

    /** 与 min(title) 映射**/
    private Long minTitle;

    /** 与 avg(title) 映射**/
    private Long avgTitle;

    /** 与 count(title) 映射**/
    private Long countTitle;

    /** 与 sum(title) 映射**/
    private String sumTitle;

    /** type属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String typeExpression;

    /** 与 max(type) 映射**/
    private Long maxType;

    /** 与 min(type) 映射**/
    private Long minType;

    /** 与 avg(type) 映射**/
    private Long avgType;

    /** 与 count(type) 映射**/
    private Long countType;

    /** 与 sum(type) 映射**/
    private String sumType;

    /** price属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String priceExpression;

    /** 与 max(price) 映射**/
    private Long maxPrice;

    /** 与 min(price) 映射**/
    private Long minPrice;

    /** 与 avg(price) 映射**/
    private Long avgPrice;

    /** 与 count(price) 映射**/
    private Long countPrice;

    /** 与 sum(price) 映射**/
    private BigDecimal sumPrice;

    /** sellerCodFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerCodFeeExpression;

    /** 与 max(sellerCodFee) 映射**/
    private Long maxSellerCodFee;

    /** 与 min(sellerCodFee) 映射**/
    private Long minSellerCodFee;

    /** 与 avg(sellerCodFee) 映射**/
    private Long avgSellerCodFee;

    /** 与 count(sellerCodFee) 映射**/
    private Long countSellerCodFee;

    /** 与 sum(sellerCodFee) 映射**/
    private BigDecimal sumSellerCodFee;

    /** discountFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String discountFeeExpression;

    /** 与 max(discountFee) 映射**/
    private Long maxDiscountFee;

    /** 与 min(discountFee) 映射**/
    private Long minDiscountFee;

    /** 与 avg(discountFee) 映射**/
    private Long avgDiscountFee;

    /** 与 count(discountFee) 映射**/
    private Long countDiscountFee;

    /** 与 sum(discountFee) 映射**/
    private BigDecimal sumDiscountFee;

    /** pointFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pointFeeExpression;

    /** 与 max(pointFee) 映射**/
    private Long maxPointFee;

    /** 与 min(pointFee) 映射**/
    private Long minPointFee;

    /** 与 avg(pointFee) 映射**/
    private Long avgPointFee;

    /** 与 count(pointFee) 映射**/
    private Long countPointFee;

    /** 与 sum(pointFee) 映射**/
    private Integer sumPointFee;

    /** totalFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String totalFeeExpression;

    /** 与 max(totalFee) 映射**/
    private Long maxTotalFee;

    /** 与 min(totalFee) 映射**/
    private Long minTotalFee;

    /** 与 avg(totalFee) 映射**/
    private Long avgTotalFee;

    /** 与 count(totalFee) 映射**/
    private Long countTotalFee;

    /** 与 sum(totalFee) 映射**/
    private BigDecimal sumTotalFee;

    /** isBrandSale属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isBrandSaleExpression;

    /** 与 max(isBrandSale) 映射**/
    private Long maxIsBrandSale;

    /** 与 min(isBrandSale) 映射**/
    private Long minIsBrandSale;

    /** 与 avg(isBrandSale) 映射**/
    private Long avgIsBrandSale;

    /** 与 count(isBrandSale) 映射**/
    private Long countIsBrandSale;

    /** 与 sum(isBrandSale) 映射**/
    private String sumIsBrandSale;

    /** lgAging属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String lgAgingExpression;

    /** 与 max(lgAging) 映射**/
    private Long maxLgAging;

    /** 与 min(lgAging) 映射**/
    private Long minLgAging;

    /** 与 avg(lgAging) 映射**/
    private Long avgLgAging;

    /** 与 count(lgAging) 映射**/
    private Long countLgAging;

    /** 与 sum(lgAging) 映射**/
    private BigDecimal sumLgAging;

    /** created属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdExpression;

    /** 与 max(created) 映射**/
    private Long maxCreated;

    /** 与 min(created) 映射**/
    private Long minCreated;

    /** 与 avg(created) 映射**/
    private Long avgCreated;

    /** 与 count(created) 映射**/
    private Long countCreated;

    /** 与 sum(created) 映射**/
    private Date sumCreated;

    /** payTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String payTimeExpression;

    /** 与 max(payTime) 映射**/
    private Long maxPayTime;

    /** 与 min(payTime) 映射**/
    private Long minPayTime;

    /** 与 avg(payTime) 映射**/
    private Long avgPayTime;

    /** 与 count(payTime) 映射**/
    private Long countPayTime;

    /** 与 sum(payTime) 映射**/
    private Date sumPayTime;

    /** modified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedExpression;

    /** 与 max(modified) 映射**/
    private Long maxModified;

    /** 与 min(modified) 映射**/
    private Long minModified;

    /** 与 avg(modified) 映射**/
    private Long avgModified;

    /** 与 count(modified) 映射**/
    private Long countModified;

    /** 与 sum(modified) 映射**/
    private Date sumModified;

    /** endTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String endTimeExpression;

    /** 与 max(endTime) 映射**/
    private Long maxEndTime;

    /** 与 min(endTime) 映射**/
    private Long minEndTime;

    /** 与 avg(endTime) 映射**/
    private Long avgEndTime;

    /** 与 count(endTime) 映射**/
    private Long countEndTime;

    /** 与 sum(endTime) 映射**/
    private Date sumEndTime;

    /** buyerMessage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerMessageExpression;

    /** 与 max(buyerMessage) 映射**/
    private Long maxBuyerMessage;

    /** 与 min(buyerMessage) 映射**/
    private Long minBuyerMessage;

    /** 与 avg(buyerMessage) 映射**/
    private Long avgBuyerMessage;

    /** 与 count(buyerMessage) 映射**/
    private Long countBuyerMessage;

    /** 与 sum(buyerMessage) 映射**/
    private String sumBuyerMessage;

    /** alipayId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String alipayIdExpression;

    /** 与 max(alipayId) 映射**/
    private Long maxAlipayId;

    /** 与 min(alipayId) 映射**/
    private Long minAlipayId;

    /** 与 avg(alipayId) 映射**/
    private Long avgAlipayId;

    /** 与 count(alipayId) 映射**/
    private Long countAlipayId;

    /** 与 sum(alipayId) 映射**/
    private Long sumAlipayId;

    /** alipayNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String alipayNoExpression;

    /** 与 max(alipayNo) 映射**/
    private Long maxAlipayNo;

    /** 与 min(alipayNo) 映射**/
    private Long minAlipayNo;

    /** 与 avg(alipayNo) 映射**/
    private Long avgAlipayNo;

    /** 与 count(alipayNo) 映射**/
    private Long countAlipayNo;

    /** 与 sum(alipayNo) 映射**/
    private String sumAlipayNo;

    /** buyerAlipayNo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerAlipayNoExpression;

    /** 与 max(buyerAlipayNo) 映射**/
    private Long maxBuyerAlipayNo;

    /** 与 min(buyerAlipayNo) 映射**/
    private Long minBuyerAlipayNo;

    /** 与 avg(buyerAlipayNo) 映射**/
    private Long avgBuyerAlipayNo;

    /** 与 count(buyerAlipayNo) 映射**/
    private Long countBuyerAlipayNo;

    /** 与 sum(buyerAlipayNo) 映射**/
    private String sumBuyerAlipayNo;

    /** buyerMemo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerMemoExpression;

    /** 与 max(buyerMemo) 映射**/
    private Long maxBuyerMemo;

    /** 与 min(buyerMemo) 映射**/
    private Long minBuyerMemo;

    /** 与 avg(buyerMemo) 映射**/
    private Long avgBuyerMemo;

    /** 与 count(buyerMemo) 映射**/
    private Long countBuyerMemo;

    /** 与 sum(buyerMemo) 映射**/
    private String sumBuyerMemo;

    /** buyerFlag属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerFlagExpression;

    /** 与 max(buyerFlag) 映射**/
    private Long maxBuyerFlag;

    /** 与 min(buyerFlag) 映射**/
    private Long minBuyerFlag;

    /** 与 avg(buyerFlag) 映射**/
    private Long avgBuyerFlag;

    /** 与 count(buyerFlag) 映射**/
    private Long countBuyerFlag;

    /** 与 sum(buyerFlag) 映射**/
    private Integer sumBuyerFlag;

    /** sellerMemo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerMemoExpression;

    /** 与 max(sellerMemo) 映射**/
    private Long maxSellerMemo;

    /** 与 min(sellerMemo) 映射**/
    private Long minSellerMemo;

    /** 与 avg(sellerMemo) 映射**/
    private Long avgSellerMemo;

    /** 与 count(sellerMemo) 映射**/
    private Long countSellerMemo;

    /** 与 sum(sellerMemo) 映射**/
    private String sumSellerMemo;

    /** sellerFlag属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerFlagExpression;

    /** 与 max(sellerFlag) 映射**/
    private Long maxSellerFlag;

    /** 与 min(sellerFlag) 映射**/
    private Long minSellerFlag;

    /** 与 avg(sellerFlag) 映射**/
    private Long avgSellerFlag;

    /** 与 count(sellerFlag) 映射**/
    private Long countSellerFlag;

    /** 与 sum(sellerFlag) 映射**/
    private Integer sumSellerFlag;

    /** buyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerNickExpression;

    /** 与 max(buyerNick) 映射**/
    private Long maxBuyerNick;

    /** 与 min(buyerNick) 映射**/
    private Long minBuyerNick;

    /** 与 avg(buyerNick) 映射**/
    private Long avgBuyerNick;

    /** 与 count(buyerNick) 映射**/
    private Long countBuyerNick;

    /** 与 sum(buyerNick) 映射**/
    private String sumBuyerNick;

    /** buyerArea属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerAreaExpression;

    /** 与 max(buyerArea) 映射**/
    private Long maxBuyerArea;

    /** 与 min(buyerArea) 映射**/
    private Long minBuyerArea;

    /** 与 avg(buyerArea) 映射**/
    private Long avgBuyerArea;

    /** 与 count(buyerArea) 映射**/
    private Long countBuyerArea;

    /** 与 sum(buyerArea) 映射**/
    private String sumBuyerArea;

    /** buyerEmail属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerEmailExpression;

    /** 与 max(buyerEmail) 映射**/
    private Long maxBuyerEmail;

    /** 与 min(buyerEmail) 映射**/
    private Long minBuyerEmail;

    /** 与 avg(buyerEmail) 映射**/
    private Long avgBuyerEmail;

    /** 与 count(buyerEmail) 映射**/
    private Long countBuyerEmail;

    /** 与 sum(buyerEmail) 映射**/
    private String sumBuyerEmail;

    /** hasBuyerMessage属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hasBuyerMessageExpression;

    /** 与 max(hasBuyerMessage) 映射**/
    private Long maxHasBuyerMessage;

    /** 与 min(hasBuyerMessage) 映射**/
    private Long minHasBuyerMessage;

    /** 与 avg(hasBuyerMessage) 映射**/
    private Long avgHasBuyerMessage;

    /** 与 count(hasBuyerMessage) 映射**/
    private Long countHasBuyerMessage;

    /** 与 sum(hasBuyerMessage) 映射**/
    private String sumHasBuyerMessage;

    /** areaId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String areaIdExpression;

    /** 与 max(areaId) 映射**/
    private Long maxAreaId;

    /** 与 min(areaId) 映射**/
    private Long minAreaId;

    /** 与 avg(areaId) 映射**/
    private Long avgAreaId;

    /** 与 count(areaId) 映射**/
    private Long countAreaId;

    /** 与 sum(areaId) 映射**/
    private String sumAreaId;

    /** creditCardFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String creditCardFeeExpression;

    /** 与 max(creditCardFee) 映射**/
    private Long maxCreditCardFee;

    /** 与 min(creditCardFee) 映射**/
    private Long minCreditCardFee;

    /** 与 avg(creditCardFee) 映射**/
    private Long avgCreditCardFee;

    /** 与 count(creditCardFee) 映射**/
    private Long countCreditCardFee;

    /** 与 sum(creditCardFee) 映射**/
    private String sumCreditCardFee;

    /** nutFeature属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String nutFeatureExpression;

    /** 与 max(nutFeature) 映射**/
    private Long maxNutFeature;

    /** 与 min(nutFeature) 映射**/
    private Long minNutFeature;

    /** 与 avg(nutFeature) 映射**/
    private Long avgNutFeature;

    /** 与 count(nutFeature) 映射**/
    private Long countNutFeature;

    /** 与 sum(nutFeature) 映射**/
    private String sumNutFeature;

    /** stepTradeStatus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String stepTradeStatusExpression;

    /** 与 max(stepTradeStatus) 映射**/
    private Long maxStepTradeStatus;

    /** 与 min(stepTradeStatus) 映射**/
    private Long minStepTradeStatus;

    /** 与 avg(stepTradeStatus) 映射**/
    private Long avgStepTradeStatus;

    /** 与 count(stepTradeStatus) 映射**/
    private Long countStepTradeStatus;

    /** 与 sum(stepTradeStatus) 映射**/
    private String sumStepTradeStatus;

    /** stepPaidFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String stepPaidFeeExpression;

    /** 与 max(stepPaidFee) 映射**/
    private Long maxStepPaidFee;

    /** 与 min(stepPaidFee) 映射**/
    private Long minStepPaidFee;

    /** 与 avg(stepPaidFee) 映射**/
    private Long avgStepPaidFee;

    /** 与 count(stepPaidFee) 映射**/
    private Long countStepPaidFee;

    /** 与 sum(stepPaidFee) 映射**/
    private String sumStepPaidFee;

    /** markDesc属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String markDescExpression;

    /** 与 max(markDesc) 映射**/
    private Long maxMarkDesc;

    /** 与 min(markDesc) 映射**/
    private Long minMarkDesc;

    /** 与 avg(markDesc) 映射**/
    private Long avgMarkDesc;

    /** 与 count(markDesc) 映射**/
    private Long countMarkDesc;

    /** 与 sum(markDesc) 映射**/
    private String sumMarkDesc;

    /** sendTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sendTimeExpression;

    /** 与 max(sendTime) 映射**/
    private Long maxSendTime;

    /** 与 min(sendTime) 映射**/
    private Long minSendTime;

    /** 与 avg(sendTime) 映射**/
    private Long avgSendTime;

    /** 与 count(sendTime) 映射**/
    private Long countSendTime;

    /** 与 sum(sendTime) 映射**/
    private String sumSendTime;

    /** tradeFrom属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tradeFromExpression;

    /** 与 max(tradeFrom) 映射**/
    private Long maxTradeFrom;

    /** 与 min(tradeFrom) 映射**/
    private Long minTradeFrom;

    /** 与 avg(tradeFrom) 映射**/
    private Long avgTradeFrom;

    /** 与 count(tradeFrom) 映射**/
    private Long countTradeFrom;

    /** 与 sum(tradeFrom) 映射**/
    private String sumTradeFrom;

    /** alipayWarnMsg属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String alipayWarnMsgExpression;

    /** 与 max(alipayWarnMsg) 映射**/
    private Long maxAlipayWarnMsg;

    /** 与 min(alipayWarnMsg) 映射**/
    private Long minAlipayWarnMsg;

    /** 与 avg(alipayWarnMsg) 映射**/
    private Long avgAlipayWarnMsg;

    /** 与 count(alipayWarnMsg) 映射**/
    private Long countAlipayWarnMsg;

    /** 与 sum(alipayWarnMsg) 映射**/
    private String sumAlipayWarnMsg;

    /** codStatus属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String codStatusExpression;

    /** 与 max(codStatus) 映射**/
    private Long maxCodStatus;

    /** 与 min(codStatus) 映射**/
    private Long minCodStatus;

    /** 与 avg(codStatus) 映射**/
    private Long avgCodStatus;

    /** 与 count(codStatus) 映射**/
    private Long countCodStatus;

    /** 与 sum(codStatus) 映射**/
    private String sumCodStatus;

    /** canRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String canRateExpression;

    /** 与 max(canRate) 映射**/
    private Long maxCanRate;

    /** 与 min(canRate) 映射**/
    private Long minCanRate;

    /** 与 avg(canRate) 映射**/
    private Long avgCanRate;

    /** 与 count(canRate) 映射**/
    private Long countCanRate;

    /** 与 sum(canRate) 映射**/
    private String sumCanRate;

    /** commissionFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String commissionFeeExpression;

    /** 与 max(commissionFee) 映射**/
    private Long maxCommissionFee;

    /** 与 min(commissionFee) 映射**/
    private Long minCommissionFee;

    /** 与 avg(commissionFee) 映射**/
    private Long avgCommissionFee;

    /** 与 count(commissionFee) 映射**/
    private Long countCommissionFee;

    /** 与 sum(commissionFee) 映射**/
    private String sumCommissionFee;

    /** tradeMemo属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tradeMemoExpression;

    /** 与 max(tradeMemo) 映射**/
    private Long maxTradeMemo;

    /** 与 min(tradeMemo) 映射**/
    private Long minTradeMemo;

    /** 与 avg(tradeMemo) 映射**/
    private Long avgTradeMemo;

    /** 与 count(tradeMemo) 映射**/
    private Long countTradeMemo;

    /** 与 sum(tradeMemo) 映射**/
    private String sumTradeMemo;

    /** buyerRate属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerRateExpression;

    /** 与 max(buyerRate) 映射**/
    private Long maxBuyerRate;

    /** 与 min(buyerRate) 映射**/
    private Long minBuyerRate;

    /** 与 avg(buyerRate) 映射**/
    private Long avgBuyerRate;

    /** 与 count(buyerRate) 映射**/
    private Long countBuyerRate;

    /** 与 sum(buyerRate) 映射**/
    private String sumBuyerRate;

    /** tradeSource属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tradeSourceExpression;

    /** 与 max(tradeSource) 映射**/
    private Long maxTradeSource;

    /** 与 min(tradeSource) 映射**/
    private Long minTradeSource;

    /** 与 avg(tradeSource) 映射**/
    private Long avgTradeSource;

    /** 与 count(tradeSource) 映射**/
    private Long countTradeSource;

    /** 与 sum(tradeSource) 映射**/
    private String sumTradeSource;

    /** isPartConsign属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isPartConsignExpression;

    /** 与 max(isPartConsign) 映射**/
    private Long maxIsPartConsign;

    /** 与 min(isPartConsign) 映射**/
    private Long minIsPartConsign;

    /** 与 avg(isPartConsign) 映射**/
    private Long avgIsPartConsign;

    /** 与 count(isPartConsign) 映射**/
    private Long countIsPartConsign;

    /** 与 sum(isPartConsign) 映射**/
    private String sumIsPartConsign;

    /** realPointFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String realPointFeeExpression;

    /** 与 max(realPointFee) 映射**/
    private Long maxRealPointFee;

    /** 与 min(realPointFee) 映射**/
    private Long minRealPointFee;

    /** 与 avg(realPointFee) 映射**/
    private Long avgRealPointFee;

    /** 与 count(realPointFee) 映射**/
    private Long countRealPointFee;

    /** 与 sum(realPointFee) 映射**/
    private Integer sumRealPointFee;

    /** receiverCity属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverCityExpression;

    /** 与 max(receiverCity) 映射**/
    private Long maxReceiverCity;

    /** 与 min(receiverCity) 映射**/
    private Long minReceiverCity;

    /** 与 avg(receiverCity) 映射**/
    private Long avgReceiverCity;

    /** 与 count(receiverCity) 映射**/
    private Long countReceiverCity;

    /** 与 sum(receiverCity) 映射**/
    private String sumReceiverCity;

    /** receiverDistrict属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String receiverDistrictExpression;

    /** 与 max(receiverDistrict) 映射**/
    private Long maxReceiverDistrict;

    /** 与 min(receiverDistrict) 映射**/
    private Long minReceiverDistrict;

    /** 与 avg(receiverDistrict) 映射**/
    private Long avgReceiverDistrict;

    /** 与 count(receiverDistrict) 映射**/
    private Long countReceiverDistrict;

    /** 与 sum(receiverDistrict) 映射**/
    private String sumReceiverDistrict;

    /** arriveInterval属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String arriveIntervalExpression;

    /** 与 max(arriveInterval) 映射**/
    private Long maxArriveInterval;

    /** 与 min(arriveInterval) 映射**/
    private Long minArriveInterval;

    /** 与 avg(arriveInterval) 映射**/
    private Long avgArriveInterval;

    /** 与 count(arriveInterval) 映射**/
    private Long countArriveInterval;

    /** 与 sum(arriveInterval) 映射**/
    private Integer sumArriveInterval;

    /** arriveCutTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String arriveCutTimeExpression;

    /** 与 max(arriveCutTime) 映射**/
    private Long maxArriveCutTime;

    /** 与 min(arriveCutTime) 映射**/
    private Long minArriveCutTime;

    /** 与 avg(arriveCutTime) 映射**/
    private Long avgArriveCutTime;

    /** 与 count(arriveCutTime) 映射**/
    private Long countArriveCutTime;

    /** 与 sum(arriveCutTime) 映射**/
    private String sumArriveCutTime;

    /** consignInterval属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String consignIntervalExpression;

    /** 与 max(consignInterval) 映射**/
    private Long maxConsignInterval;

    /** 与 min(consignInterval) 映射**/
    private Long minConsignInterval;

    /** 与 avg(consignInterval) 映射**/
    private Long avgConsignInterval;

    /** 与 count(consignInterval) 映射**/
    private Long countConsignInterval;

    /** 与 sum(consignInterval) 映射**/
    private Integer sumConsignInterval;

    /** asyncModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String asyncModifiedExpression;

    /** 与 max(asyncModified) 映射**/
    private Long maxAsyncModified;

    /** 与 min(asyncModified) 映射**/
    private Long minAsyncModified;

    /** 与 avg(asyncModified) 映射**/
    private Long avgAsyncModified;

    /** 与 count(asyncModified) 映射**/
    private Long countAsyncModified;

    /** 与 sum(asyncModified) 映射**/
    private Date sumAsyncModified;

    /** alipayPoint属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String alipayPointExpression;

    /** 与 max(alipayPoint) 映射**/
    private Long maxAlipayPoint;

    /** 与 min(alipayPoint) 映射**/
    private Long minAlipayPoint;

    /** 与 avg(alipayPoint) 映射**/
    private Long avgAlipayPoint;

    /** 与 count(alipayPoint) 映射**/
    private Long countAlipayPoint;

    /** 与 sum(alipayPoint) 映射**/
    private Integer sumAlipayPoint;

    /** pccAf属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String pccAfExpression;

    /** 与 max(pccAf) 映射**/
    private Long maxPccAf;

    /** 与 min(pccAf) 映射**/
    private Long minPccAf;

    /** 与 avg(pccAf) 映射**/
    private Long avgPccAf;

    /** 与 count(pccAf) 映射**/
    private Long countPccAf;

    /** 与 sum(pccAf) 映射**/
    private Integer sumPccAf;

    /** isWt属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isWtExpression;

    /** 与 max(isWt) 映射**/
    private Long maxIsWt;

    /** 与 min(isWt) 映射**/
    private Long minIsWt;

    /** 与 avg(isWt) 映射**/
    private Long avgIsWt;

    /** 与 count(isWt) 映射**/
    private Long countIsWt;

    /** 与 sum(isWt) 映射**/
    private String sumIsWt;

    /** isExcelImport属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isExcelImportExpression;

    /** 与 max(isExcelImport) 映射**/
    private Long maxIsExcelImport;

    /** 与 min(isExcelImport) 映射**/
    private Long minIsExcelImport;

    /** 与 avg(isExcelImport) 映射**/
    private Long avgIsExcelImport;

    /** 与 count(isExcelImport) 映射**/
    private Long countIsExcelImport;

    /** 与 sum(isExcelImport) 映射**/
    private String sumIsExcelImport;

    /** tradeCloseReson属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tradeCloseResonExpression;

    /** 与 max(tradeCloseReson) 映射**/
    private Long maxTradeCloseReson;

    /** 与 min(tradeCloseReson) 映射**/
    private Long minTradeCloseReson;

    /** 与 avg(tradeCloseReson) 映射**/
    private Long avgTradeCloseReson;

    /** 与 count(tradeCloseReson) 映射**/
    private Long countTradeCloseReson;

    /** 与 sum(tradeCloseReson) 映射**/
    private String sumTradeCloseReson;
}