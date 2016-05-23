package com.shufensoft.crm.biz.dao.defined.user;

import com.shufensoft.crm.biz.domain.defined.user.UserDO;
import com.shufensoft.crm.biz.domain.generation.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDAO {

    List<UserDO> selectUserWithPortrait(UserDO record);

    int selectCount(UserDO userDO);

    /**
     * 获取这种关联的Id
     * @param userId 用户表业务id
     * @return
     */
    UserDO selectIds(@Param("sellerId")Long sellerId, @Param("userId") Long userId);

    /**
     * 查询7天内生日粉丝
     * @return
     */
    List<UserDO> selectBirthdayOfFansWeek();//30天内生日粉丝

    /**
     * 查询30天内生日粉丝
     * @return
     */
    List<UserDO> selectBirthdayOfFansMonth();

    /**
     * 查找所有在生日活动开始和结束时间之内的用户
     * @param startTime
     * @param endTime
     * @return
     */
    List<UserDO> selectBetweenStartAndEnd(@Param("sellerId")Long sellerId, @Param("startTime")Date startTime, @Param("endTime")Date endTime,
                                          @Param("level")String level, @Param("birthdayActivityId")Long birthdayActivityId);
    /**
     * 查找所有在生日活动开始和结束时间之内的用户id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<UserDO> selectUserIdsBetweenStartAndEnd(@Param("sellerId")Long sellerId, @Param("startTime")Date startTime,
                                                 @Param("endTime")Date endTime);

    /**
     * 计算生日时间在开始时间
     * 和结束时间内的用户数量
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    Long selectCountBetweenStartAndEnd(@Param("sellerId")Long sellerId, @Param("startTime")Date startTime,
                                       @Param("endTime")Date endTime);

    /**
     * 更新7天内粉丝
     * @param birthdayId 生日业务ID
     * @return
     */
    int updateWeekBirthdayOfFans(@Param("birthdayId")long birthdayId);

    /**
     * 更新30天内粉丝
     * @param birthdayId 生日业务ID
     * @return
     */
    int updateMonthBirthdayOfFans(@Param("birthdayId")long birthdayId);

    /**
     * 更新手动选择的粉丝
     * @param birthdayId 生日业务ID
     * @param userId
     * @return
     */
    int updateManualBirthdayOfFans(@Param("birthdayId")long birthdayId, @Param("userId")long userId);

    /**
     * 根据birthday_id 查询 user_id
     * @param birthdayId 生日业务ID
     * @return
     */
    List<User> selectUserIdByBirthdayId(@Param("birthdayId")long birthdayId);

    /**
     *
     * @return 查询粉丝的生日在生日活动期间的人
     */
    List<UserDO> selectAllFans();


}
