package com.shufensoft.crm.biz.service.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.vo.UserVO;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/14  
 */
public interface HongBaoObtainService {

    /**
     * 绑定积分兑换红包
     *
     * @param userId
     * @param pointAmount
     */
    public boolean fixExchangeHongbao(Long userId, Long pointAmount, Long sellerId);

    /**
     * 绑定积分兑换红包, 调红包引擎实现
     */

    public boolean bindUserAndHongBao(Long sellerId, Long userId, Long pointAmount);


    /**
     * 绑定好评返红包
     *
     * @param hbPoolId
     */
    public void fixPraiseHongbao(UserVO userVO, Long hbPoolId, Long sellerId);

    /**
     * 红包领用表绑定用户
     */
    public int bindUser(HBObtain hbObtain, Long userId, Long sellerId);

    /**
     *
     * */
    public HBObtain findHBObtainByObtainId(Long obtainId, Long sellerId);







}
