package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/6  
 */
@Data
public class UserAccountStaticsDo {

    private Long sellerId;

    private Long userId;

    private String userName;      //用户姓名

    private String wxNickName;    //用户微信昵称

    private String headImgUrl;     //微信头像Url

    private Long pointTotal;      //总积分

    private Long pointExchangeTotal = 0L;     //总兑换积分

    private Long validPoint = 0L;            //剩余有效积分

    private Long invalidPoint = 0L;           //无效积分, 过期

    private Long hongbaoUsedPoints = 0L;       //红包消耗的积分

    private Long goodsUsedPoints = 0L;         //兑换商品消耗积分

    private Long ranking = 0L;                  //排名

    private String mobile;                     //电话


}
