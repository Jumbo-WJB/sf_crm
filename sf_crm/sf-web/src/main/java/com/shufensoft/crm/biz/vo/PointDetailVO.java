package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/26 下午9:08  
 */
@Data
public class PointDetailVO {


    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 用户ID
     */
    private String userId;

    /** 获得的积分 */
    private Long amount;

    /**
     * 获取的方式
     */

    private String obtainMethod;

    /**
     * 兑换方式
     */
    private String exchangMethod;

    /**
     * 获取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private String obtainDate;

    /**
     * 领取日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date gmtCreated;


}
