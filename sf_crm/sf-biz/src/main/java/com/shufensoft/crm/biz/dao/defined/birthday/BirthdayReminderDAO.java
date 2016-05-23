package com.shufensoft.crm.biz.dao.defined.birthday;

import com.shufensoft.crm.biz.domain.defined.birthday.UserBirthdayReminderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/21  
 */
@Repository
public interface BirthdayReminderDAO {
    List<UserBirthdayReminderDO> selectRemindedUser(@Param("sellerId")Long sellerId, @Param("birthdayDate")Date birthdayDate,
                                                    @Param("birthdayActivityId")Long birthdayActivityId);
}
