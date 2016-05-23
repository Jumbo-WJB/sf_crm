package com.shufensoft.crm.biz.service.birthday;

import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import com.shufensoft.crm.biz.vo.UserVO;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/19  
 */
public interface MobileBirthdayService {
    /**
     * 根据user_id查询出这个用户参加的所有生日活动，包括历史的活动
     * @param sellerId
     * @param userId
     * @return
     */
    public List<BirthdayDO> findFrontBirthdayData(Long sellerId, Long userId);

    /**
     * 判断今天的时间大于生日活动结束时间的话，
     * 就把生日活动的状态更新为over
     * @param allActivityList
     */
    public void initOverStatus(List<BirthdayDO> allActivityList);

    /**
     * 因为生日活动的状态默认是notstart,
     * 所以今天的时间如果大于等于开始时间，
     * 小于等于结束时间，就把状态更改为start
     * @param allActivityList
     */
    public void initStartStatus(List<BirthdayDO> allActivityList);

    public List<BirthdayDO> screenActivityList(List<BirthdayDO> allActivityList);

    public void receivePointsPrize(Long sellerId, Long userId, Long birthdayActivityId);

    /**
     * 查找用户信息
     * @param sellerId
     * @param userId
     * @return
     */
    public UserVO findUserMess(Long sellerId, Long userId);

    /**
     * 手机端领生日活动折扣
     * @param sellerId
     * @param userId
     * @param birthdayActivityId
     */
    public void receiveDiscountPrize(Long sellerId, Long userId, Long birthdayActivityId);

    public void receiveGiftsPrize(Long userId, Long birthdayActivityId);

//    public boolean verifyActivity(Long userId);

    public List<UserBirthdayConfig> findAllBirthActivity(Long userId);
}
