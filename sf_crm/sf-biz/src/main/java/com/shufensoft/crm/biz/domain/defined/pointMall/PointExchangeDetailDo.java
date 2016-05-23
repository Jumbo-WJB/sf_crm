package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     积分兑换明细, 包括每次兑换的商品名, 还包括红包,  消耗积分, 状态
 *
 *
 * </p>
 *  @author: lin
 *  @date: 2015/7/5  
 */
@Data
public class PointExchangeDetailDo {

    private Long sellerId;

    private Long userId;

    private Long pointExchangeId;    // 对应 point_exchange表 id

    private String title;             //兑换商品,写商品名, 兑换红包, 就固定写"兑换红包"

    private Long point;               //消耗积分

    private String imgsUrl;           //如果是红包就固定红包的图片

    private String status;

    private String exchangeMethod;   //积分兑换的方式, 红包或者礼物

    private Long poolId;             //如果为积分兑换红包, hongbao_pool

    private Long hongbaoObtainId;    //如果为积分兑换红包, hongbao_obtain

    private Date startDate;          //针对积分兑换红包活动规则的起始时间和结束时间

    private Date endDate;

    private Long number = 0L;              //红包活动中配置的红包个数

    private Long obtainedNum = 0L;         //被领取的数量

    private Date gmtCreated;          //创建时间

    private Long hbMoney = 0L;       //红包金额

}
