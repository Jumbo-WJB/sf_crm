package com.shufensoft.crm.biz.domain.defined.user;

import lombok.Data;

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
public class UserValidateDO {
    /** 自增主键 */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否逻辑上被删除0:未删除1:删除 */
    private String isDeleted;

    /** 验证手机号 */
    private String mobile;

    /** 手机验证码 */
    private String code;

    /** 验证时间 */
    private Date validateDate;

    /** 是否验证成功0:失败1:成功 */
    private String result;

    /** 验证成功返回的user_id */
    private Long userId;

    /**微信昵称*/
    private String wxNickName;

    /** 用户画像Id */
    private Long userPortraitId;

    /** 验证人姓名 */
    private String name;

    /** 累计购买次数 */
    private Integer totalPurchaseTimes;

    private Long sellerId;
}
