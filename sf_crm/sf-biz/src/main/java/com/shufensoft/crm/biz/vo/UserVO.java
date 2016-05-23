package com.shufensoft.crm.biz.vo;

import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserVO extends UserDO {

    /**
     * 客户类别
     */
    private String userType;

    private String purchasePrice;

    private String minPrice;

    private String maxPrice;

    private String startContribution;

    private String endContribution;

    /**
     * 购买次数区间
     */
    private String purchaseNum;

    /**
     * 是否领取过红包
     */
    private String isReceive;

    /**
     * 互动次数区间
     */
    private String actionTimes;

    /**
     * 红包领用数量
     */
    private int limitObtainTime;

    /**
     * 每月提现数量
     */
    private int cachCountPerMonth;

    /**
     * 当前提现红包金额
     */
    private Long hbCurrentCashAmount;

    private String integralString;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 购买时间间隔
     */
    private String time;

    /**
     * 购买数量下限
     */
    private Integer minQuantity;

    /**
     * 购买数量下限
     */
    private Integer maxQuantity;

    /**
     * 互动次数下限
     */
    private Integer minInteractionsTimes;

    /**
     * 互动次数上限
     */
    private Integer maxInteractionsTimes;

    private Integer interactionsTimes;

    private Long wxPurchaseAverageAmount;

    /**
     * 用户选择的用户数量
     */
    private Integer allSelectCount;

    /**
     * 排序条件
     */
    private String orderClause;

    /**
     * 邮件营销邮件类型	qq:QQ邮箱;163:163邮箱;126:126邮箱;yahoo:yahoo邮箱并且不同的邮箱类型之间用，分隔
     */
    private String emailType;

    /**
     * 是否有手机号
     */
    private String hasMobile;

    /**
     * 是否有邮箱
     */
    private String hasEmail;

    /**
     * 页面传入的选中的用户信息，如“id1：mobile1,id2:mobile2”
     */
    private String userParams;

    /**
     * 页面是否是选中所有用户，是：1，否：0
     */
    private String isSelectAll;

    /**
     * 是否是成功购买的客户 是：1*
     */
    private String isSuccessCustom;

    /**
     * 同个快递单号评价内容最大长度
     */
    private String maxContentLength;

    /**
     * 同个快递单号的领取次数
     */
    private String perPostTimeCount;

    /**
     * 淘宝天猫好评订单数
     */
    private String taoBaoGoodCommentCount;

    /**
     * 京东好评订单数
     */
    private String jdGoodCommentCount;

    /**
     * 淘宝或者京东好评订单数
     */
    private String taobaoOrJdCommentCount;

    /**
     * 当前积分是否可兑换红包
     */
    private String availablePointAmount;

    /**
     * 活动开始时间
     */
    private Date startDate;

    /**
     * 活动结束时间
     */
    private Date endDate;

    /**
     * 用户画像
     */
    private UserPortraitVO userPortraitVO;

}