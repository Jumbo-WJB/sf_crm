package com.shufensoft.crm.biz.domain.generation.send;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class SendUserUnsubscribe {
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

    /** 商户ID */
    private String sellerId;

    /** 用户手机号码 */
    private String userSendAddress;

    /** 退订类型（邮件） */
    private String unsubscribeType;

    /** 短信内容 */
    private String smsContent;

    /** 发送时间 */
    private String sentTime;

    /** 发送者扩展码 */
    private String addSerial;

    /** 接收扩展码 */
    private String addSerialRev;

    /** 服务号 */
    private String channelNumber;

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

    /** sellerId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerIdExpression;

    /** userSendAddress属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String userSendAddressExpression;

    /** unsubscribeType属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String unsubscribeTypeExpression;

    /** smsContent属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String smsContentExpression;

    /** sentTime属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sentTimeExpression;

    /** addSerial属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String addSerialExpression;

    /** addSerialRev属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String addSerialRevExpression;

    /** channelNumber属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String channelNumberExpression;
}