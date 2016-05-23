package com.shufensoft.crm.biz.dao.defined.user;

import org.springframework.stereotype.Repository;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/7  
 */
@Repository
public interface UserPortraitDAO {
    //累计购物金额
    Long selectTotalPurchaseAmount(Long userPortraitId);
    //所有粉丝排名
    Long rank(Long userPortraitId);
}
