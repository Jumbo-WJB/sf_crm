package com.shufensoft.crm.biz.service.signIn;


import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.service.signIn.vo.SignInVO;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/18 下午6:17  
 */
public interface SignInService {

    /**
     * 今天是否已签到
     * @param userId 用户ID
     * @return true/false
     */
    public boolean isSignIn(Long userId);

    /**
     * 执行签到
     * @param sellerId
     * @param userId
     * @return
     */
    public int doSignIn(Long sellerId, Long userId);

    /**
     * 查询我的签到排名信息
     * @param userId 用户ID
     * @return
     */
    public SignInVO queryCurrentMonthMySignInRank(Long userId);


    /**
     * 查询我总的签到排名信息
     * @param userId 用户ID
     * @return
     */
    public SignInVO queryTotalMySignInRank(Long userId);

    /**
     * 查看当天我的排名情况
     * @param userId
     * @return
     */
    public SignInVO queryCurrentDayMySignInRank(Long userId);





    /**
     * 查询用户当月的排名情况
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryCurrentMonthUserSignInRanking(Integer start,Integer pageSize);

    /**
     * 分页查询当天的签到排名记录
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryCurrentDaySignInRanking(Integer start,Integer pageSize);

    /**
     * 查询用户总的的排名情况
     * @param start
     * @param pageSize
     * @return
     */
    public PageInfo queryTotalUserSignInRanking(Integer start,Integer pageSize);


}
