package com.shufensoft.crm.biz.domain.generation.seller;

import com.shufensoft.crm.biz.annotation.BizId;
import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SellerPackageDetail {
    /** 主键ID */
    private Long id;

    /** 系统创建时间 */
    private Date gmtCreated;

    /** 创建人 */
    private String createdBy;

    /** 系统修改时间 */
    private Date gmtModified;

    /** 修改人 */
    private String modifiedBy;

    /** 0	是否逻辑上被删除 */
    private String isDeleted;

    /** 套餐ID,作为bizid */
    @BizId
    private String packageId;

    /** 商户ID */
    private String sellerId;

    /** 套餐包名 */
    private String packageName;

    /** 套餐包数量总数 */
    private Integer packageCount;

    /** 过期时间 */
    private Date expiredTime;

    /** 过期标识 */
    private String expiredFlag;

    /** 剩余数量 */
    private Integer packageRemain;

    /** 套餐类型：SMS：短信；EMAIL:邮件 */
    private String packageType;

    /** 套餐费用 */
    private Integer packageFee;

    /** 购送数量 */
    private Integer packageFree;

    /** 套餐描述 */
    private String packageDesc;

    /** 短信版本号，用于乐观锁 */
    private Integer packageVersion;

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

    /** packageId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageIdExpression;

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** packageName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageNameExpression;

    /** packageCount属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageCountExpression;

    /** expiredTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String expiredTimeExpression;

    /** expiredFlag属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String expiredFlagExpression;

    /** packageRemain属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageRemainExpression;

    /** packageType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageTypeExpression;

    /** packageFee属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageFeeExpression;

    /** packageFree属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageFreeExpression;

    /** packageDesc属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageDescExpression;

    /** packageVersion属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String packageVersionExpression;
}