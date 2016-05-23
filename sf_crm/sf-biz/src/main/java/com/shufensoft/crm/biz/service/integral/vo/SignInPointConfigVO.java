package com.shufensoft.crm.biz.service.integral.vo;

import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/3 上午10:23  
 */
@Data
public class SignInPointConfigVO {

    /**
     * 商户ID
     */
    private Long sellerId;


    /**
     * 签到规则
     */
    private List<SignInVO> signInVOList;
}
