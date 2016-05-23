package com.shufensoft.crm.biz.domain.defined.point;

import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/26 下午9:26  
 */
@Data
public class PointDetailDO {

    /** 创建时间 */
    private Date gmtCreated;

    /** 修改时间 */
    private Date gmtModified;

    /** 创建人 */
    private String createdBy;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /**
     * 商户ID
     */
    private Long sellerId;

    /**
     * 微信昵称
     */
    private String wxNickName;

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
    private String obtainDate;

    /**
     * 兑换时间
     */
    private String exchangDate;



    /**
     * 状态
     * */
    private String status;

}
