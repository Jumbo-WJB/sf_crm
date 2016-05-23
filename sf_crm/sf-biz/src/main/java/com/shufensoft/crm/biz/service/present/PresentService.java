package com.shufensoft.crm.biz.service.present;

import com.shufensoft.crm.biz.domain.generation.present.Present;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/24  
 */
public interface PresentService {

    public Present findPresentByUserIdAndGoodsId(Long sellerId, Long userId, Long goodsId);

    /**
     * 将用户插入礼物表中，进行商品详情页授权。
     * @param userId
     * @param goodsId
     * @param rockId
     * @return
     */
    public long doTakeUpGoods(Long userId,Long goodsId,Long rockId);

    /**
     * 查询用户礼物数量
     * @param userId
     * @param rockId
     * @return
     */
    public int queryUserPresentCountByUserIdAndRockId(Long userId,Long rockId);


    public boolean verifyDiscountSecret(Long userId, Long birthdayActivityId, String secret);

    /**
     *  根据生日活动Id 和 用户id 查询一个 present
     * */
    public Present findPresentByUserIdAndActivityId(Long sellerId, Long userId, Long birthdayActivityId);

    /**
     * 摇一摇礼物领取成功后更新present领取状态 is_receive 字段
     * */
    public void updateShakeGiftObtainStatus(Long presentId, Long userId);

    public Present findPresentByUserIdAndPresentId(Long sellerId,Long userId, Long presentId);

}
