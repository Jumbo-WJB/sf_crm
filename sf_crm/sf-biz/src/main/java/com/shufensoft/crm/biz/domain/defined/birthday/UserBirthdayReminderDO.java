package com.shufensoft.crm.biz.domain.defined.birthday;

import lombok.Data;

/**
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                生日提醒DO
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/20  
 */
@Data
public class UserBirthdayReminderDO {

    /**
     * 生日活动Id
     */
    private Long birthdayActivityId;

    /**
     * 提醒内容
     */
    private String remindContent;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 活动标题
     */
    private String title;

}
