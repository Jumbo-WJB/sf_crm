package com.shufensoft.crm.biz.service.hongbao;

import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.domain.defined.hongbao.HBPoolDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.*;
import com.shufensoft.crm.biz.domain.generation.rule.RuleConfig;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.vo.*;

import java.util.List;


/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 红包服务类
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/4/15 23:15  
 */
public interface HongbaoService {


    /**
     * 分页查询红包活动列表
     *
     * @should @return
     */

    public PageInfo queryHBPools(HBPoolVO hbPoolVO, Integer pageNum, Integer length, String sortContent, Long sellerId);

    /**
     * 根据查询条件获取红包列表
     *
     * @param hbPoolVO
     * @return
     */
    public List<HBPool> getHbPoolLis(HBPoolVO hbPoolVO, Long sellerId);


    /**
     * 分页查询红包领取明细
     *
     * @return
     */
    public PageInfo queryHBObtains(HBObtainVO hbObtainVO, Integer pageNum, Integer length, Long sellerId);

    /**
     * 分页查询用户领用明细
     *
     * @param hbObtainVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo getHBObtainWithUser(HBObtainVO hbObtainVO, Integer pageNum, Integer length, String sortContent, Long sellerId);

    /**
     * 查询红包领取明细列表
     *
     * @return
     */
    public List<HBObtain> queryHBObtainList(HBObtainVO hbObtainVO, Long sellerId);

    /**
     * 查询红包提现明细列表
     *
     * @param hbCashVO
     * @return
     */
    public List<HBCash> queryHBCashList(HBCashVO hbCashVO, Long sellerId);


    /**
     * 分页查询红包账户明细
     *
     * @return
     */
    public PageInfo queryHBAccounts(UserAccountVO userAccountVO, Integer pageNum, Integer length, Long sellerId);


    /**
     * 根据id删除红包活动
     *
     * @param id
     */
    public void deleteHbPoolById(long id);

    /**
     * 根据id获取红包活动详细信息
     *
     * @param id
     */
    public HBPoolVO getHBPoolVOById(long id, Long sellerId);

    /**
     * 根据poolId获取红包活动详细信息
     *
     * @param poolId
     */
    public HBPoolVO getHBPoolVOByPoolId(long poolId, Long sellerId);

    /**
     * 创建红包活动
     *
     * @param hbPoolVO
     */
    public HBPoolVO createHBPool(HBPoolVO hbPoolVO);

    /**
     * 更新红包活动
     *
     * @param hbPoolVO
     */
    public HBPoolVO updateHBPool(HBPoolVO hbPoolVO, Long sellerId);

    /**
     * 根据选中条件更新红包活动
     *
     * @param hbPoolVO
     */
    public void updateHBPoolBySelective(HBPoolVO hbPoolVO);

    /**
     * 领取红包
     *
     * @param hbPoolId 红包活动id
     * @param userId   用户id
     * @param ammount  红包金额
     * @param businessType 业务类型 如普通红包和好评红红包:other,生日红包:birthday,积分兑换红包:point
     */

    public Long receiveHongBao(Long hbPoolId, Long userId,String ammount,Long  sellerId,String businessType);

    /**
     * 拆红包
     *
     * @param hbObtainId   红包领取记录id
     * @param userId       用户id
     * @param hbPoolId     红包活动id
     * @param businessType 业务类型 如普通红包和好评红红包:other,生日红包:birthday,积分兑换红包:point
     * @return
     */
    public Long dismantleOtherHongBao(Long hbObtainId, Long userId, Long hbPoolId, String businessType, Long sellerId);


    /**
     * 提现红包
     *
     * @param actionType 操作类型 unLimit:不限制提现金额 limit:限制提现金额
     */
    public void cashHongBao(User user, Long hbCurrentCashAmount, String actionType, Long sellerId);


    /**
     * 插入红包领用记录
     *
     * @param hbObtain
     * @return
     */
    public int insertObtain(HBObtain hbObtain);

    /**
     * 初始化红包活动规则结果
     *
     * @param hbPoolId
     * @param ruleConfig
     */
    public boolean initHBRuleResult(Long hbPoolId, RuleConfig ruleConfig, Long sellerId);

    /**
     * 更新红包活动规则结果
     *
     * @param hbPoolId
     * @param ruleConfig
     */
    public boolean updateHBRuleResult(Long hbPoolId, RuleConfig ruleConfig, Long sellerId);


    /**
     * 获取用户提现1块钱的次数
     *
     * @param userVO
     * @return
     */
    public Integer getCachCountOneAmmount(UserVO userVO, Long sellerId);

    /**
     * 获取红包活动统计情况
     *
     * @param hbPool
     * @return
     */
    public HBPool getHbPoolSum(HBPool hbPool, Long sellerId);

    /**
     * 获取红包活动统计情况
     *
     * @param hbPoolVO
     * @return
     */
    public HBPool getHbPoolSumByVO(HBPoolVO hbPoolVO, Long sellerId);


    /**
     * 获得好评返红包参与人次
     *
     * @return
     */
    public int getObtianHbPraseCount(Long sellerId);


    /**
     * 根据条件获取红包领用数量
     *
     * @return
     */
    public int countHongbaoObtain(HBObtainVO hbObtainVO, Long sellerId);

    /**
     * 根据条件获取红包提现数量
     *
     * @return
     */
    public int countHongbaoCash(HBCashVO hbCashVO, Long sellerId);

    /**
     * 查找商家有效红包活动
     * 1. 在有效期内
     * 2. 没有领完
     */
    public List<HBPool> findValidHbPoolBySellerId(HBPoolDO hbPoolDO, Long sellerId);


    /**
     * 更新红包领用、红包池表
     */
    public void updateHbObtainAndPool(Long sellerId, HBObtain hbObtain);




    /**
     * 根据用户和红包池ID查询红包占用记录信息
     *
     * @param sellerId 商户ID
     * @param hbPoolId 红包池ID
     * @return
     */
    public HBObtain getHbObtainByObtainId(Long sellerId, Long userId, Long hbPoolId);


}
