package com.shufensoft.crm.biz.service.birthday.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 *  @date: 2015/7/10  
 */
@Data
public class BirthdayConfigVO extends UserBirthdayConfig{
    /**开始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    /**搜索框中的开始日期*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /**搜索框中的结束日期*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    /**赠送积分数*/

    private Long points;

    /**页面手动选择赠送对象的user_id字符串*/
    private String manualTarget;

    /**红包剩余数量*/
    private Long surplus;

    /**礼物商品数量*/
    private Long goodsNum;

    /**关系类型级别*/
    private String level;

}
