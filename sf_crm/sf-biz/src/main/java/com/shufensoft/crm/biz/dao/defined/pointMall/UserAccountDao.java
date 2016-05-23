package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.UserAccountStaticsDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     用户账户的do, 包括兑换红包和商品消耗的积分
 * </p>
 *  @author: lin
 *  @date: 2015/7/6  
 */
@Repository
public interface UserAccountDao {


    public UserAccountStaticsDo findUserAccountDo(Map<String ,Object> params);

    /**
     * 查找某个用户排名
     * */
    public UserAccountStaticsDo findUserAccountRanking(Map<String ,Object> params);


    /**
     * 查找某个商家所有用户积分排名
     * */
    public List<UserAccountStaticsDo> findAllUserAccountsRanking(Long sellerId);
}
