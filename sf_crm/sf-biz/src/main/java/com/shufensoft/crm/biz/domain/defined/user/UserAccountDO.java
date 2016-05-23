package com.shufensoft.crm.biz.domain.defined.user;

import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/6/16 15:47  
 */
@Data
public class UserAccountDO  extends UserAccount{

    /** 排序 */
    protected String orderByClause;


    /** 微信昵称 */
    private String  wxNickName;

    /**姓名*/
    private String  name;

    /** 性别 */
    private String sex;

    /** 手机号码 */
    private String mobile;

    /** 是否老客户 */
    private String isOldUser;


    /** 是否验证 */
    private String isVerify;


    private Date startDate;


    private Date endDate;

    /**红包排名**/
    private String  hongbaoRank;

    /**积分排名**/
    private  String  pointRank;

    /**好评返红包排名**/
    private  String  hbPraiseRank;

    /**微信openid**/
    private String  wxOpenId;

    /**微信头像url**/
    private String  wxHeadImgUrl;

    /**互动数量**/
    private  Long  interactionCount;

    /**互动类型**/
    private  String   interactionType;

    /**互动入口**/
    private String   interactionEntry;

    /**除了某个用户**/
    private Long   exceptUserId;

    /** user_taobao表user_id */
    private Long userIdTb;

    /** user_jd表user_id */
    private Long userIdJd;

}
