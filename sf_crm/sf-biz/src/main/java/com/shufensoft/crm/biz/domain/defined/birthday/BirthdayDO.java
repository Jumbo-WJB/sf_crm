package com.shufensoft.crm.biz.domain.defined.birthday;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.shufensoft.crm.biz.annotation.Domain;
import com.shufensoft.crm.biz.domain.generation.birthday.UserBirthdayConfig;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */
@Data
@Domain
public class BirthdayDO extends UserBirthdayConfig{

    /**用户ID*/
    private Long userId;

    /**是否领取*/
    private String isReceive;

    /**礼物类型*/
    private String presentType;

    /**礼物来源*/
    private String presentSource;

    /**搜索框中开始日期*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**搜索框中结束日期*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
//    private Present present;
    /*private enum CareType {
        BIRTHDAY_HB, //生日红包
        BIRTHDAY_GIFTS,//生日礼物
        BIRTHDAY_POINTS,//生日积分
        BIRTHDAY_DISCOUNT//生日折扣
    }
    private enum SendTarget {
        THIS_WEEK_BIRTHDAY_FANS, //本周生日粉丝
        THIS_MONTH_BIRTHDAY_FANS, //本月生日粉丝
        HAND_OPERATION //手动选择
    }*/

}
