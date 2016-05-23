package com.shufensoft.crm.biz.domain.defined.shoppingHongbao;

import com.shufensoft.crm.biz.annotation.BizId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/10/10  
 */
@Data
@ToString
public class ActivityGoodsDo implements Serializable{

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 商户Id */
    private Long sellerId;

    /** 活动Id */
    private Long activityId;

    /** 活动商品Id, @BizId */
    @BizId
    private Long activityGoodsId;

    /** 活动商品在购物平台的Id */
    private String goodsId;

    /** 活动商品名称 */
    private String goodsName;

    /** 活动商品图片地址 */
    private String goodsUrl;

    /** 活动商品在购物平台的详情链接 */
    private String goodsLink;

    /** 活动商品价格，用分表示 */
    private Integer goodsPrice;

    /** 活动商品数量 */
    private Integer goodsQuantity;

    /** 活动商品来源:  京东JD，天猫TMALL， 淘宝TAOBAO，有赞YOUZAN */
    private String goodsSource;

    /** 活动商品所在购物平台店铺名称 */
    private String shopName;

    /** 红包池ID */
    private String hbPoolId;

    /** 累计红包总金额，分为单位 */
    private Integer hbcashAmount;

    /** 红包使用范围：指定商品可用goods， 全店通用shop */
    private String applyRange;

    /** 限定多少小时内没有购物，红包自动释放 */
    private Integer releaseTime;

    //----------------------
    /** 活动名称 */
    private String activityName;

    /** 活动开始日期 */
    private Date beginDate;

    /** 活动结束日期 */
    private Date endDate;

    /** 活动状态：暂停(stop)，进行中(progressing )，已结束(end)，开启(start) */
    private String status;

    //--------------

    /** 购物成功的数量 */
    private Integer shoppingAmount;

    /** 购物红包领取数量*/
    private Integer hbObtainAmount;


}
