package com.shufensoft.crm.biz.service.rock.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/7 上午12:33  
 */
@Data
public class RockConfigVO {

    /** 摇一摇ID */
    private String rockId;

    /** 商家Id */
    private Long sellerId;

    /** 摇一摇标题 */
    private String rockTitle;

    /** 摇一url */
    private String shareUrl;

    /** 微信公众号 */
    private String wxNumber;

    /** 是否需要验证 1:验证,0:不验证 */
    private String isVerify;

    /** 是否需要关注,1:关注,0:未关注 */
    private String isSubscribe;

    private Long id;

    /**
     * 摇中的机率
     */
    private Integer randomNum;

    /** 领取人数 */
    private Integer getNum;

    /** 类型，my,自己摇，帮摇 */
    private String type;

    /** 摇的次数 */
    private Integer rockNum;

    /** 生效配置 */
    private Integer startConfig;

    /** 创建时间 */
    private Date createTime;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /** 红包活动ID */
    private Long hbPoolId;

    /** 红包活动Name */
    private String hbPoolName;

    /** 领取红包人数 */
    private Integer getHbNum;

    /** 领取是否需要分享，1：分享，0不分享 */
    private String isGetHbShare;

    /** 领取礼物人数限制 */
    private Integer getGiftNum;

    /** 领取礼物后是否需要分享1：分享，0不分享 */
    private String isGetGiftShare;

    /** 商品1 */
    private String goodsId_1;

    /** 商品2 */
    private String goodsId_2;

    /** 商品3 */
    private String goodsId_3;

    /** 商品4 */
    private String goodsId_4;

    /** 商品5 */
    private String goodsId_5;

    /** 商品1 */
    private String goodsName_1;

    /** 商品2 */
    private String goodsName_2;

    /** 商品3 */
    private String goodsName_3;

    /** 商品4 */
    private String goodsName_4;

    /** 商品5 */
    private String goodsName_5;

    /** 商品ids */
    private String goodsId;


    /**  */
    private String isShakePoint;

    /**  */
    private String isShakeHb;

    /**  */
    private String isShakeGift;

    /**  */
    private String goodsName;

    /** 积分最小值 */
    private Integer pointIntervalMin;

    /** 积分最大值 */
    private Integer pointIntervalMax;

    /** 积分人数 */
    private Integer getPointNum;

    /** 领取积分后是否需要分享1：分享，0不分享 */
    private String isGetPointShare;

    /**
     * 状态 启用，暂停
     */
    private String status;

}
