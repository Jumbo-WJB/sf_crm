package com.shufensoft.crm.polySpire.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/1  
 */
@Data
public class TaoBaoTradeVO {

    /** 交易编号 (父订单的交易编号) */
    private Long tid;

    /** 卖家昵称 */
    private String sellerNick;

    /** 实付金额。精确到2位小数;单位: 元。如:200.07，表示:200元7分 */
    private BigDecimal payment;

    /** 卖家是否已评价 */
    private String sellerRate;

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

    /** 返点积分 */
    private Integer buyerObtainPointFee;

    /** 运送方式 */
    private String shippingType;

    /** 商家的预计发货时间 */
    private Date estConTime;

    /** 发票类型（1 电子发票 2 纸质发票） */
    private String invoiceKind;

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

    private List<TaoBaoOrderVO> orders;
}
