package com.shufensoft.crm.web.vo;

import com.shufensoft.crm.biz.domain.generation.permission.AdminUser;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * 　　　　　　　　　　</p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/30  
 */
@Data
public class AdminUserVO extends AdminUser {

    @NotBlank(message = "新密码不能为空!")
    private String newpasswd1;
    @NotBlank(message = "新密码确认不能为空!")
    private String newpasswd2;


}
