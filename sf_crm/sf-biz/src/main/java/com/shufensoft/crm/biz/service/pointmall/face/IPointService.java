package com.shufensoft.crm.biz.service.pointmall.face;

import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.pointmall.vo.PointStatisticsVO;
import com.shufensoft.crm.biz.vo.PointExchangeVO;
import com.shufensoft.crm.biz.vo.PointObtainVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-06-04 21:02  
 */

public interface IPointService {

    public boolean exchange(long sellerId, long userId, long amount, String method, long methodId,String exchangeName);

    public boolean transfer(long sellerId, long fromUserId, long toUserId, long amount, String method,
            long methodId) throws ServiceException;

    public boolean transfer(long sellerId, long toUserId, long amount, String method, long methodId) throws ServiceException;



    public Map<String,Object> getUserAccountInfoByMobile(String mobile);

    /**
     * 增加积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param method   方式
     * @param methodId 方式ID
     */
    @Transactional
    public void createPoint(Long sellerId, Long userId, String method, Long methodId, Integer times);

    /**
     * 增加积分，支持乐观锁，支持重试机制
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param amount   积分数量
     * @param method   获取方式
     * @param methodId 获取ID
     */
    @Transactional
    public void insertPointObtain(long sellerId, long userId, long amount, String method, long methodId);

    /**
     * 创建关注送积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     */
    public void createSubscribePoint(Long sellerId, Long userId);

    /**
     * 创建签到送积分
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     */
    public int creteSignPoint(Long sellerId, Long userId);


    /**
     * 创建购物积分
     * @param sellerId 商户ID
     * @param userId 用户ID
     * @param buyMoney 购物金额，单位元
     * @param obtainMethodId 获取方式ID
     */
    public void createBuyPoint(Long sellerId, Long userId, Long buyMoney, Long obtainMethodId);

    /**
     * 从订单获取并创建购物积分
     * @param sellerId 商户ID
     * @param orderUserId 订单ID
     * @param type 订单类型，JD、TB、YZ
     * @param buyMoney 购买金额
     * @param tradeId 订单ID
     */
    public void tradeToCreateBuyPoint(Long sellerId, Long orderUserId, String type, Long buyMoney, Long tradeId);


    /**
     * 更新用户帐户积分，如果没有帐户进行创建新帐户，乐观锁，支持重试机制
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param count    积分数
     * @param doFlag   动作： 消费(减积分余额)：DEDUCT 、
     *                 积分获取(增加总额和余额)：OBTAIN 、
     *                 积分兑换(增加累积兑换、减积分余额):exchange
     * @return
     */
    public int updateUserAccountPoint(long sellerId, long userId, Long count, String doFlag);

    /**
     * 添加积分获取记录
     * @param sellerId 商户ID
     * @param userId 用户ID
     * @param amount 积分数
     * @param method 方式
     * @param methodId 方式ID
     */
    public void createPointObtain(Long sellerId, Long userId, Long amount, String method, Long methodId);


    /**
     * 创建积分，支持自定义过期时间
     *
     * @param sellerId   商户ID
     * @param userId     用户ID
     * @param amount     积分数
     * @param expiredDay 过期日期
     * @param method     方式
     * @param methodId   积分来源ID
     */
    public void createPointObtain(Long sellerId, Long userId, Long amount, Date expiredDay, String method, Long methodId);


    /**
     * 抢积分，更新积分明细表，支持乐观锁，支持重试。
     * @param userId 用户ID
     * @param rockId 摇一摇活动ID
     * @param isObtain 是否领取 Y：领取，N：待领
     * @return 返回积分获积明细的ID
     */
    public Long updatePointObtain(Long sellerId,Long userId,Long rockId,String isObtain);

    /**
     * 更新积分明细,领积分
     * @param pointObtainId 积分获取明细ID
     * @return 积分数
     */

    public Long updatePointObtain(Long sellerId,Long pointObtainId);

    /**
     * 根据obtainId查询积分明细
     *
     * @param sellerId 商户ID
     * @param obtainId 积分明细ID
     * @return 积分信息
     */
    public PointObtain getPointObtainByObtainId(Long sellerId, Long obtainId);

    /**
     * 获取积分领用数量
     * @param pointObtainVO
     * @return
     */
    public long sumPointObtain(PointObtainVO pointObtainVO);

    /**
     * 获取积分互动数量
     * @param pointObtainVO
     * @return
     */
    public long countPointObtain(PointObtainVO pointObtainVO);

    /**
     * 获取积分兑换数量
     * @param pointExchangeVO
     * @return
     */
    public long sumPointExchange(PointExchangeVO pointExchangeVO);

    /**
     * 获取积分兑换次数
     * @param pointExchangeVO
     * @return
     */
    public long countPointExchange(PointExchangeVO pointExchangeVO);
;

    /**
     * 用户否领取过关注积分
     * @param userId
     * @return
     */
    public boolean isUserSubscribePoint(Long sellerId,Long userId);

    /**
     * 最近几天积分兑换统计(按天分组)
     * @author litu  2015/07/16
     * @param lastDays 最近几天
     * @return
     */
    public List<PointExchangeVO> queryPointExchaneStatistics(Long sellerId, int lastDays);

    /**
     * 获取积分统计信息
     * @author litu  2015/07/16
     * @param days
     * @return
     */
    public PointStatisticsVO getPointStatisticsInfo(Long sellerId,int days);


    /**
     * 删除积分获取表初始化信息
     * @param obtainMethodId
     */
    public void deletePointObtain(Long sellerId,Long obtainMethodId);

}
