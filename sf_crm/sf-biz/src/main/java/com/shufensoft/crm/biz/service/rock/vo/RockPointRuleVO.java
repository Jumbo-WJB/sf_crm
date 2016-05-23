package com.shufensoft.crm.biz.service.rock.vo;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/6 下午8:36  
 */
@Data
public class RockPointRuleVO {

    /**
     * 积分区间最上值
     */
    private String pointIntervalMin;

    /**
     * 积分区间最大值
     */
    private String pointIntervalMax;

    /**
     * 人数限制
     */
    private String pointNum;

    /**
     * 领取积分后是否可分享
     */
    private String isGetPointShare;


}
