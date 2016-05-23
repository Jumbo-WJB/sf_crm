package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     积分兑换实时的兑换信息，主要包括兑换时间与当前时间的间隔是多少
 * </p>
 *  @author: lin
 *  @date: 2015/7/4  
 */
@Data
public class PointExchangeRealTimeInfoDo {

    private Long sellerId;
    private Long userId;
    private String wxImgUrl;
    private String userName;
    private String wxNickName;
    /**
     * 兑换created时间离现在时间相隔的天数
     * 为0表示当天
     * */
    private Long dayInterval = 0L;
    /**
     * 间隔的秒数
     * */
    private Long secInterval = 0L;

    /**
     * 兑换的积分数量
     * */
    private Long amount;

}
