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
public class PointObtainStaticsDo {

    private Long sellerId;

    private Long userTotal;      //参与的用户总数

    private Long pointTotal;     //发放的积分总数

}
