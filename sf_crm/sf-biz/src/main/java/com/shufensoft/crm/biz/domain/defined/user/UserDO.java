package com.shufensoft.crm.biz.domain.defined.user;

import com.shufensoft.crm.biz.domain.generation.user.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/14  
 */
@Data
public class UserDO extends User{

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 购买时间间隔
     */
    private String time;

    /**
     * 购买金额下限
     */
    private Long minPriceNum;

    /**
     * 购买金额上限
     */
    private Long maxPriceNum;

    /**
     * 购买数量下限
     */
    private Integer minQuantity;

    /**
     * 购买数量下限
     */
    private Integer maxQuantity;

    /**
     * 积分上限
     */
    private Integer minInteg;

    /**
     * 积分下限
     */
    private Integer maxInteg;

    /**
     * 互动次数下限
     */
    private Integer minInteractionsTimes;

    /**
     * 互动次数上限
     */
    private Integer maxInteractionsTimes;

    /**  用户活跃度，几颗星 */
    private Integer liveness;

    /** 用户贡献度，总分100 */
    private BigDecimal contribution;

    /** 开始用户贡献度，总分100 */
    private BigDecimal startContributionNum;

    /** 结束用户贡献度，总分100 */
    private BigDecimal endContributionNum;

    /** 累计购买金额 */
    private Long totalPurchaseAmount;

    /** 累计购买次数 */
    private Integer totalPurchaseTimes;

    /** 累计互动次数 */
    private Integer interactionsTimes;

    /** 最后一次购买时间 */
    private Date lastPurchaseDate;

    /** 最后一次购买金额 */
    private Long lastPurchaseAmount;

    /**
     * 签到次数
     */
    private Integer signInTimes;

    /**
     * 最后签到时间
     */
    private Date lastSignInDate;

    /** 手机购买率 例:0.5 */
    private BigDecimal mobilePurchaseRate;

    /** 平均购买周期 */
    private BigDecimal purchaseAverageCycle;

    /** 平均购买金额 */
    private Long purchaseAverageAmount;

    /** 微信购买均价 */
    private Long wxPurchaseAverageAmount;

    /** 短信接收次数 */
    private Integer smsAcceptNumber;

    /** 短信接收周期，单位：天 */
    private Integer smsAcceptCircle;

    /** 邮件接收次数 */
    private Integer emailAcceptNumber;

    /** 邮件接收周期，单位：天 */
    private Integer emailAcceptCircle;

    /** 喜好 */
    private String fancy;

    /** 好评率 例0.5 */
    private BigDecimal goodsRate;

    /** 买家账号信息 */
    private String jdPin;

    /** 买家昵称 */
    private String tbBuyerNick;

    /** 用户画像不为空*/
    private String withPortrait;

    /**邮箱类型*/
    private String emailType;

    /**邮箱*/
    private String Eqq;

    private String E163;

    private String Eyahoo;

    private String E126;

    /**排序条件*/
    private String orderClause;

    /**是否有手机号*/
    private String hasMobile;

    /**是否有邮箱*/
    private String hasEmail;

    /**成功购买的条件 1 :成功购买 */
    private String isSuccessCustom;

    /**生日活动的ID*/
    private Long birthdayActivityId;
}
