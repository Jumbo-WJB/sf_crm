package com.shufensoft.crm.biz.adapter.jsonObj;

import com.shufensoft.crm.biz.domain.generation.user.UserTagYZ;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/8  
 */
@Data
public class UserYZjsonObj {

    private Long user_id;

    private String weixin_openid;

    private String nick;

    private String avatar;

    private Date follow_time;

    private String sex;

    private String province;

    private String city;

    private List<UserTagYZ> tags;

}
