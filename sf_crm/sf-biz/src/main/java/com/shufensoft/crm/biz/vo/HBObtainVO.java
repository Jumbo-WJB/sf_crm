package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by chenyong on 2015/5/6.
 */
@Data
public class HBObtainVO {
    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 是否删除：1(删除) 0(未删除) */
    private String isDeleted;

    /** 领取ID,作为@BizId */
    private Long hongbaoObtainId;

    /** 用户ID */
    private Long userId;

    /** 金额 分为单位 */
    private Long amount;

    /** openid */
    private String openId;

    /** 获得方式：yyy 摇一摇 jfth 积分兑换gjc 关键词领取 */
    private String obtainMethod;

    /** 红包活动ID */
    private Long poolId;

    /** 红包活动名称冗余字段 */
    private String poolName;

    /** 领取时间 */
    private Date obtainDatatime;

    /** 红包key便于查询 */
    private String amountRange;

    /** toReceive 待领取  received 已领取 */
    private String status;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String idExpression;

    /** gmtCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtCreatedExpression;

    /** createdBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdByExpression;

    /** gmtModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String gmtModifiedExpression;

    /** modifiedBy属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedByExpression;

    /** isDeleted属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String isDeletedExpression;

    /** hongbaoObtainId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String hongbaoObtainIdExpression;

    /** userId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userIdExpression;

    /** amount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountExpression;

    /** openId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String openIdExpression;

    /** obtainMethod属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainMethodExpression;

    /** poolId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String poolIdExpression;

    /** poolName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String poolNameExpression;

    /** obtainDatatime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String obtainDatatimeExpression;

    /** amountRange属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String amountRangeExpression;

    /** status属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statusExpression;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

}
