package com.shufensoft.crm.biz.service.rock;

import com.shufensoft.crm.biz.domain.generation.shake.ShakeDetail;
import com.shufensoft.crm.biz.domain.generation.shake.ShakeObtain;
import com.shufensoft.crm.biz.service.rock.vo.RockConfigVO;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/8 下午2:56  
 */
public interface RockService {

    /**
     * 保存或修改摇一摇配置
     * @param rockConfigVO
     */
    public void saveOrUpdateRockConfig(RockConfigVO rockConfigVO);


    /**
     * 根据类型和rockid查询摇一摇配置
     * @param sellerId
     * @param rockId
     * @return
     */
    public ShakeDetail queryShakeConfig(Long sellerId,String rockId);

    /**
     * 摇一摇动作
     *
     * @param sellerId 商户ID
     * @param userId   openid
     * @param type     摇一摇类型
     * @param rockId   摇一摇活动ID
     * @param isObtain 是否领取，Y:领取，N：待领取
     * @return
     */

    public Long doShake(Long sellerId, Long userId,String type, Long rockId,String isObtain);


    /**
     * 根据摇一摇ID，获取可抽取积分的人数
     * @param sellerId
     * @param rockId 摇一摇活动ID
     * @return 数量
     */
    public int queryPointCountByRockId(Long sellerId,Long rockId);


    /**
     * 查检是否还可以摇积分
     * @param sellerId
     * @param userId
     * @param rockId
     * @param getPointNum
     * @return
     */
    public boolean isObtailPoint(Long sellerId,Long userId,Long rockId, Long getPointNum);

    /**
     * 过期更新状诚
     * @param rockId 摇一摇ID
     */
    public void shakeEnd(Long sellerId,String rockId);


    /**
     * 是否已领取摇一摇积分
     *
     * @param userId
     * @param pointObtainid
     * @return
     */
    public boolean isObtainShakePoint(Long sellerId,Long userId, Long pointObtainid);

    /**
     * 领取摇一摇
     *
     * @param pointObtainId 积分获取ID
     * @return 返回积分数
     */
    public Long doUserObtainShake(Long sellerId, Long userId, Long pointObtainId, String type);


    /**
     * 分页获取摇一摇活动
     * @param pageNum
     * @param length
     * @return
     */
    public List<ShakeDetail> getShakeDetailList(Long sellerId, Integer pageNum, Integer length);

    /**
     * 分页获取摇一摇明细
     * @param shakeObtain
     * @param pageNum
     * @param length
     * @return
     */
    public List<ShakeObtain> getShakeObtainList(ShakeObtain shakeObtain, Integer pageNum, Integer length);

    /**
     * 插入摇一摇活动领取记录
     *
     * @param sellerId    商户ID
     * @param userId      用户ID
     * @param type        摇一摇类型， 积分：POINT,红包：HB，礼物：GIFT
     * @param rockId      摇一摇活动ID
     * @param obtainId 摇到的结果ID
     * @param isObtain    是否领取 Y，N
     */
    public void insertShakeObtain(Long sellerId,Long userId, String type, Long rockId, Long obtainId, String isObtain);


    /**
     * 领取摇一摇礼物，有效期30分钟之内的，过期不领取。
     * @param sellerId
     * @param userId
     * @return
     */
    public int obtainShake(Long sellerId, Long userId);


    /**
     * 根据获取明细ID更新摇一摇领出记录
     *
     * @param pointObtainId 获取明细ID，积分表ID、红包表ID、礼表ID
     * @param type POINT/HB/GIFT
     * @param resultValue 结果：如礼物名称、积分数、现金数
     * @return
     */
    public int updateShakeObtain(Long sellerId,Long pointObtainId, String type, String resultValue);


    /**
     * 摇一摇积分领取过期处理
     */
    public void shakeExpired(Long sellerId);

    /**
     * 根据红包池ID查询RockId
     *
     * @param sellerId 商户ID
     * @param hbPollId 红包池ID
     * @return
     */
    public String getRockIdByHbPollId(Long sellerId, Long hbPollId);
}
