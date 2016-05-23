package com.shufensoft.crm.biz.domain.defined.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/22  
 */
@Data
public class HBObtainDO  extends HBObtain{


    /** 排序信息 */
    protected String orderByClause;


    /** 微信昵称 */
    private String wxNickName;

    /** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
    private String sex;

    /** 用户手机号码 */
    private String mobile;

    /** 老客户标识，1：老客户，0::新客户 */
    private String isOldUser;


    /** 是否验证，1：是，0::否 */
    private String isVerify;

    /**开始时间*/
    private Date startDate;


    /**结束s时间*/
    private Date endDate;

}
