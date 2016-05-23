package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author yuyuchi  yuyc@suniusoft.com
 *  @date 2015/6/29  
 */
@Data
public class UserValidateVO {
    /**微信昵称*/
    private String wxNickName;

    /** 验证手机号 */
    private String mobile;

    /** 手机验证码 */
    private String code;

    /**验证失效间隔*/
    private String time;

    /**验证结果*/
    private String result;

    /**重定向url*/
    private String redirectUrl;

    /**购物平台*/
    private String firstSource;

    /**出生日期*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**userId*/
    private Long userId;

    /**验证状态，未验证*/
    private String status;

    /**微信用户openid*/
    private String openId;

    /**淘宝账号 */
    private String tbBuyerNick;

    /**京东账号 */
    private String jdPin;

    /**有赞账号**/
    private String yzBuyerNick;

    /**商家id*/
    private String sellerId;

    private String isVerified;
}
