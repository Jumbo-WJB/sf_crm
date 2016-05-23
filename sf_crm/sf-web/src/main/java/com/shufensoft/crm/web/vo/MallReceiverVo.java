package com.shufensoft.crm.web.vo;

import com.shufensoft.crm.biz.annotation.BizId;
import lombok.Data;

import java.util.Date;

@Data
public class MallReceiverVo {
    /** 主键ID */
    private Long id;

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

    /** 商户号 */
    private Long sellerId;

    /** 用户id */
    private Long userId;

    /** 收件人id,作为@BizId */
    @BizId
    private Long receiverId;

    /** 	姓名 */
    private String name;

    /** 	手机 */
    private String mobile;

    /** 	省 */
    private String province;

    /** 	市 */
    private String city;

    /** 	区 */
    private String district;

    /** 	地址 */
    private String address;

    /** 邮编 */
    private String zip;

    /** y 是否默认收件人 */
    private String isDefault;


}