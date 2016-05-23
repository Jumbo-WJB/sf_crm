package com.shufensoft.crm.polySpire.api.jsonObj.trade;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/1  
 */
@Data
public class TradeJsonObj {

    /**
     * 交易编号 (父订单的交易编号)
     */
    private Long tid;
    /**
     * 卖家昵称
     */
    private String seller_nick;
    /**
     * 支持金额
     */
    private BigDecimal payment;

    /**
     * 卖家是否已评价
     */
    private String seller_rate;

    /**
     * 快递费用
     */
    private BigDecimal post_fee;

    /**
     * 收货人的姓名
     */
    private String receiver_name;

    /**
     * 收货人的所在省份
     */
    private String receiver_state;

    /**
     * 收货人的所在城镇
     */
    private String receiver_town;

    /**
     * 收货人的所在国家
     */
    private String receiver_country;

    /**
     * 收货人的详细地址
     */
    private String receiver_address;

    /**
     * 收货人的邮编
     */
    private String receiver_zip;

    /**
     * 收货人的手机号码
     */
    private String receiver_mobile;

    /**
     * 收货人的电话号码
     */
    private String receiver_phone;

    /**
     * 卖家发货时间。 格式: yyyy -MM - dd HH: mm :ss
     */
    private Date consign_time;

    /**
     * 卖家支付宝账号
     */
    private String seller_alipay_no;

    /**
     * 卖家手机
     */
    private String seller_mobile;

    /**
     * 卖家电话
     */
    private String seller_phone;

    /**
     * 卖家姓名
     */
    private String seller_name;

    /**
     * 卖家邮件地址
     */
    private String seller_email;

    /**
     * 交易中剩余的确认收货金额
     */
    private BigDecimal available_confirm_fee;

    /**
     * 卖家实际收到的支付宝打款金额
     */
    private BigDecimal received_payment;

    /**
     * 超时到期时间。 格式: yyyy -MM - dd HH: mm :ss。
     */
    private Date timeout_action_time;

    /** 运送方式 */
    private String shipping_type;

    /** 返点积分 */
    private Integer buyer_obtain_point_fee;


    /**
     * 是否是3D淘宝交易
     */
    private String is_3d;

    /**
     * 交易促销详细信息
     */
    private String promotion;

    /**
     * 商家的预计发货时间
     */
    private Date est_con_time;

    /**
     * 发票类型（ 1 电子发票 2 纸质发票 ）
     */
    private String invoice_kind;

    /**
     * 商品购买数量
     */
    private Integer num;

    /**
     * 商品数字编号
     */
    private Long num_iid;

    /**
     * 交易状态。
     */
    private String status;

    /**
     * 交易标题，以店铺名作为此标题的值。。
     */
    private String title;

    /**
     * 交易类型列表。
     */
    private String type;

    /**
     * 商品价格。
     */
    private BigDecimal price;

    /**
     * 卖家货到付款服务费。
     */
    private BigDecimal seller_cod_fee;

    /**
     * 系统优惠金额。
     */
    private BigDecimal discount_fee;

    /**
     * 买家使用积分, 下单时生成，且一直不变。格式:100;单位: 个。
     */
    private BigDecimal point_fee;

    /**
     * 商品金额
     */
    private BigDecimal total_fee;


    /**
     * 表示是否是品牌特卖
     */
    private String is_brand_sale;

    /**
     * 次日达订单送达时间
     */
    private String lg_aging;

    /**
     * 交易创建时间。 格式: yyyy -MM - dd HH: mm :ss
     */
    private Date created;

    /**
     * 付款时间。 格式: yyyy -MM - dd HH: mm :ss
     */
    private Date pay_time;

    /**
     * 交易修改时间。
     */
    private Date modified;

    /**
     * 交易结束时间。
     */
    private Date end_time;

    /**
     * 买家留言。
     */
    private String buyer_message;

    /**
     * 买家的支付宝id号。
     */
    private Long alipay_id;

    /**
     * 支付宝交易号,如：2009112081173831
     */
    private String alipay_no;

    /**
     * 支付宝交易号,如：2009112081173831
     */
    private String buyer_memo;

    /**
     * 买家备注旗帜
     */
    private Integer buyer_flag;

    /**
     * 卖家备注
     */
    private String seller_memo;

    /**
     * 卖家备注旗帜
     */
    private Integer seller_flag;

    /**
     * 买家昵称
     */
    private String buyer_nick;

    /**
     * 买家支付宝账号
     */
    private String buyer_alipay_no;

    /**
     * 买家下单的地区
     */
    private String buyer_area;

    /**
     * 买家邮件地址
     */
    private String buyer_email;

    /**
     * 判断订单是否有买家留言，有买家留言返回true，否则返回false
     */
    private String has_buyer_message;

    /**
     * 区域id
     */
    private String area_id;

    /**
     * 使用信用卡支付金额数
     */
    private String credit_card_fee;

    /**
     * 分阶段付款的订单状态
     */
    private String nut_feature;

    /**
     * 分阶段付款的已付金额（万人团订单已付金额）
     */
    private String step_paid_fee;

    /**
     * 订单出现异常问题的时候，给予用户的描述, 没有异常的时候，此值为空
     */
    private String mark_desc;

    /**
     * 订单将在此时间前发出，主要用于预售订单
     */
    private String send_time;

    /**
     * 交易内部来源
     */
    private String trade_from;

    /**
     * 淘宝下单成功了, 但由于某种错误支付宝订单没有创建时返回的信息。trade.trade.add接口专用
     */
    private String alipay_warn_msg;

    /**
     * 货到付款物流状态
     */
    private String cod_status;

    /**
     * 买家可以通过此字段查询是否当前交易可以评论，can_rate=true可以评价，false则不能评价。
     */
    private String can_rate;

    /**
     * 交易佣金
     */
    private String commission_fee;

    /**
     * 交易备注
     */
    private String trade_memo;
    /**
     * 买家是否已评价
     */
    private String buyer_rate;

    /**
     * 交易外部来源：ownshop(商家官网)
     */
    private String trade_source;

    /**
     * 是否是多次发货的订单
     */
    private String is_part_consign;

    /**
     * 买家实际使用积分
     */
    private Integer real_point_fee;

    /**
     * 收货人的所在城市
     */
    private String receiver_city;

    /**
     * 收货人的所在地区
     */
    private String receiver_district;

    /**
     * 物流到货时效，单位天
     */
    private Integer arrive_interval;

    /**
     * 物流到货时效截单时间，格式 HH: mm
     */
    private String arrive_cut_time;

    /**
     * 物流发货时效，单位小时
     */
    private Integer consign_interval;

    /**
     * 同步到卖家库的时间，trade.trades.sold.incrementv.get接口返回此字段
     */
    private Date async_modified;

    /**
     * 付款时使用的支付宝积分的额度, 单位分，比如返回1，则为1分钱
     */
    private Integer alipay_point;

    /**
     * 天猫点券卡实付款金额, 单位分
     */
    private Integer pcc_af;


    /**
     * 子订单是否是wt订单
     */
    private String is_wt;


    /**
     * 子订单列表
     */
    private OrderJsonObjs orders;

}
