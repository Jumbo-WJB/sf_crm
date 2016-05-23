package com.shufensoft.crm.biz.service.integral.service;

import com.shufensoft.crm.biz.service.integral.vo.IntegralConfigVO;
import com.shufensoft.crm.biz.service.integral.vo.SignInPointConfigVO;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/22 下午3:05  
 */
public interface IntegralService {

    /**
     * 保存积分配置
     */
    public void saveIntegralConfig(IntegralConfigVO integralConfigVO);

    public IntegralConfigVO queryIntegralConfig(String sellerID,String name);

    /**
     * 查询商户的积分规则
     * @param sellerId 商户ID
     * @return
     */
    public IntegralConfigVO queryPointRule(Long sellerId);


    public void saveSignRule(SignInPointConfigVO signInPointConfigVO);


    public SignInPointConfigVO querySignInPointRule(Long sellerId);


}
