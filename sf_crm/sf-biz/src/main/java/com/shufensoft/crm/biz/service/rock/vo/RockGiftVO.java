package com.shufensoft.crm.biz.service.rock.vo;

import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/6 下午10:18  
 */
@Data
public class RockGiftVO {

    /**
     * 领取人数限制
     */
    private String getGiftnum;

    /**
     * 领到礼物后是否可分享
     */
    private String isGetGiftShare;

    /**
     * 积分商城商口链接
     */
    List<String> goodsUrl;
}
