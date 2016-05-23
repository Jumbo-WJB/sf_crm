package com.shufensoft.crm.biz.domain.generation.trade;

import com.shufensoft.crm.biz.annotation.Domain;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Domain
@Data
@ToString
public class JdpTbTrade {
    /**  */
    private Long tid;

    /**  */
    private String status;

    /**  */
    private String type;

    /**  */
    private String sellerNick;

    /**  */
    private String buyerNick;

    /**  */
    private Date created;

    /**  */
    private Date modified;

    /**  */
    private String jdpHashcode;

    /**  */
    private Date jdpCreated;

    /**  */
    private Date jdpModified;

    /**  */
    private String jdpResponse;

    /** tid属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String tidExpression;

    /** status属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String statusExpression;

    /** type属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String typeExpression;

    /** sellerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String sellerNickExpression;

    /** buyerNick属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String buyerNickExpression;

    /** created属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String createdExpression;

    /** modified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String modifiedExpression;

    /** jdpHashcode属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdpHashcodeExpression;

    /** jdpCreated属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdpCreatedExpression;

    /** jdpModified属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdpModifiedExpression;

    /** jdpResponse属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    private String jdpResponseExpression;
}