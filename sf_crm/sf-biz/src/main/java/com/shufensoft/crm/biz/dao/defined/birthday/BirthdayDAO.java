package com.shufensoft.crm.biz.dao.defined.birthday;

import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayActivityDetailsDO;
import com.shufensoft.crm.biz.domain.defined.birthday.BirthdayDO;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */
@Repository
public interface BirthdayDAO {

    /**
     * 根据id查询出birthday_activity_id
     * @param id
     * @return
     */
    long selectBirthdayActivityId(@Param("id")Long id);


    //根据 birthdayIdg更新状态
//    int updateSatusByBirthdayId(@Param("birthdayId")Long birthdayId);

    /**
     * 更新所有过期的生日活动列表
     * @return
     */
    int updateAllExpired();

    /**
     * 查找最大的结束时间
     * @return
     */
    BirthdayDO selectMaxEndTime();

    /**
     * 查询生日活动领奖明细
     * @param birthdayActivityId
     * @return
     */
    List<BirthdayActivityDetailsDO> selectDetailsByBirthdayActivityId(@Param("sellerId")Long sellerId,
                                                                      @Param("birthdayActivityId")Long birthdayActivityId);

    /**
     * 根据birthdayActivityId查询生日配置信息
     * @param birthdayActivityId
     * @return
     */
    UserBirthdayConfig selectBirthdayActivityInfoByBirthdayActivityId(@Param("sellerId")Long sellerId,
                                                                      @Param("birthdayActivityId")Long birthdayActivityId);

    /**
     * 跟胡userId查找出这个用户参加的所有生日活动(包括生日活动历史活动)
     * @param userId
     * @return
     */
    List<BirthdayDO> selectFrontData(@Param("sellerId")Long sellerId, @Param("userId")Long userId);
    
}
