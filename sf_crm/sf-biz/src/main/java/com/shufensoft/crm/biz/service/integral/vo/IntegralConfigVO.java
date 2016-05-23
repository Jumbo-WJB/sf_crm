package com.shufensoft.crm.biz.service.integral.vo;

import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 积分配置VO
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/22 下午2:32  
 */
@Data
public class IntegralConfigVO{


    /**
     * 商户ID
     */
    private String sellerId;

    /**
     * 类型，系统默认、自定义
     */
    private String configType;

    /**
     * 名称
     */
    private String configName;

    /**
     * 购物每1元兑换多少积分
     */
    private String conertMoney;

    /**
     * 首次关注公众号兑换积分数
     */
    private String attentionIntegral;

    /**
     * 首次加入社群兑换的积分数
     */
    private String groupIntegral;

    /**
     * 签到
     */
    private String loginIntegral;

    /**
     * 传播兑换积分数
     */
    private String spreadIntegral;

    /**
     *  N次购买兑换积分数
     */
    List<String> buyIntegralList;

    /**
     * N次购买次数JSON
     */
    private String buyIntegralArgs;
}
