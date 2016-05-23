package com.shufensoft.crm.biz.adapter.jsonObj;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/8  
 */
@Data
@ToString
public class TradeYZJsonObj {

    /** 订单ID */
    private String tid;

    /** 有赞用户id（内部系统定义） */
    private Long user_id_yz;

    /** 收件人Id */
    private Long receiver_id_yz;

    /** 商品购买数量 */
    private Integer num;

    /** 商品编号 */
    private Long num_iid;

    /** 商品主图片缩略图地址 */
    private String pic_thumb_path;

    /** 商品主图片地址 */
    private String pic_path;

    /** 商品价格 */
    private BigDecimal price;

    /** 订单标题 */
    private String title;

    /** 交易类型交易类型。取值范围：FIXED （一口价）GIFT （送礼）PRESENT （赠品领取）COD （货到付款）QRCODE（扫码商家二维码直接支付的交易） */
    private String type;

    /** 微信粉丝ID */
    private Long weixin_user_id;

    /** 买家类型，取值范围：0 为未知，1 为微信粉丝，2 为微博粉丝 */
    private Integer buyer_type;

    /**  买家ID */
    private Long buyer_id;

    /** 买家昵称 */
    private String buyer_nick;

    /**  买家购买附言 */
    private String buyer_message;

    /**  卖家备注星标，取值范围 1、2、3、4、5；如果为0，表示没有备注星标 */
    private Integer seller_flag;

    /**  卖家对该交易的备注 */
    private String trade_memo;

    /**  收货人的所在城市 */
    private String receiver_city;

    /**  收货人的所在地区 */
    private String receiver_district;

    /**  收货姓名 */
    private String receiver_name;

    /**  收货人所在省 */
    private String receiver_state;

    /** 收货人的详细地址 */
    private String receiver_address;

    /** 收货人邮编 */
    private String receiver_zip;

    /** 收货人手机 */
    private String receiver_mobile;

    /** 交易维持状态 */
    private Integer feedback;

    /** 外部交易编号。比如，如果支付方式是微信支付，就是财付通的交易单号 */
    private String outer_tid;

    /** 交易状态 */
    private String status;

    /** 创建交易时的物流方式。取值范围：express（快递），fetch（到店自提） */
    private String shipping_type;

    /** 运费。单位：元，精确到分 */
    private BigDecimal post_fee;

    /** 商品应付金额（商品价格乘以数量的总金额）。单位：元，精确到分 */
    private BigDecimal total_fee;

    /** 交易优惠金额（不包含交易明细中的优惠金额）。单位：元，精确到分 */
    private BigDecimal discount_fee;

    /** 卖家手工调整订单金额 */
    private BigDecimal adjust_fee;

    /** 实付金额。单位：元，精确到分 */
    private BigDecimal payment;

    /** 交易创建时间 */
    private Date created;

    /** 交易更新时间 */
    private Date update_time;

    /** 买家付款时间 */
    private Date pay_time;

    /** 支付类型 */
    private String pay_type;

    /** 发货时间 */
    private Date consign_time;

    /** 买家签收时间 */
    private Date sign_time;

    /** 父交易ID */
    private String parent_tid;

    /** 下单区域 */
    private String buyer_area;

    private List<OrderYZJsonObj> orders;
}
