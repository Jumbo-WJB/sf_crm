package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/18 15:35  
 */
@Data
public class HBAccountVO {

    /**  */
    private Long id;

    /**  */
    private Date gmtCreated;

    /**  */
    private Date gmtModified;

    /**  */
    private String createdBy;

    /**  */
    private String modifiedBy;

    /**  */
    private String isDeleted;

    /**  */
    private Long sellerId;

    /**  */
    private Long accountId;

    /**  */
    private Long userId;

    /**  */
    private BigDecimal accountAmount;

    /**  */
    private Long number;

    /**  */
    private BigDecimal obtainAmount;

    /**  */
    private Date obtainDate;

    /**  */
    private BigDecimal cashAmount;

    /**  */
    private Date cashDate;

    /**  */
    private Long cashNumber;

    /** 微信昵称 */
    private String  wxNickName;

    /** 性别 */
    private String sex;

    /** 累计互动次数 */
    private Long interactionsTimes;

    /** 手机号码 */
    private String mobile;

    /** 是否老客户 */
    private String isOldUser;


    /** 是否验证 */
    private String isVerify;


    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startDate;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date endDate;
}
