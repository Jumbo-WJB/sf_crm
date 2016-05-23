package com.shufensoft.crm.biz.dao.defined.signIn;

import com.shufensoft.crm.biz.domain.defined.sIgnIn.SignInDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/17 上午10:50  
 */
@Repository
public interface SignInDAO {

    /**
     * 查询用户签到排名位置
     * @param signInDO
     * @return
     */
    public List<SignInDO> selectMySignInRank(SignInDO signInDO);


    /**
     * 查询所有用户的排名情况
     * @param signInDO
     * @return
     */
    public List<SignInDO> selectUserSignInRanking(SignInDO signInDO);

    /**
     * 查询用户当天签到排名情况
     * @param signInDO
     * @return
     */
    public List<SignInDO> selectUserTodaySignInRanking(SignInDO signInDO);


    /**
     * 查询我的当天签到排名情况
     * @param signInDO
     * @return
     */
    public List<SignInDO> selectCurrentDayMySignInRank(SignInDO signInDO);


}
