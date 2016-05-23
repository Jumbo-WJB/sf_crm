package com.shufensoft.crm.biz.domain.defined.birthday;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/17  
 */
@Data
public class BirthdayActivityDetailsDO {
    /**微信昵称*/
    private String wxNickName;
    /**礼物类型*/
    private String presentType;
    /**生日*/
    private Date birthday;
    /**领取日期*/
    private Date receiveDate;
    /**礼物名字*/
    private String presentName;

}
