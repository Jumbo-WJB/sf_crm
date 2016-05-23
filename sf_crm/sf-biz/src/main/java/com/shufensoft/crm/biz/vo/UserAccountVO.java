package com.shufensoft.crm.biz.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shufensoft.crm.biz.domain.defined.user.UserAccountDO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenyong  chenyong@shufensoft.com
 *  @date 2015/5/21 11:47  
 */
@Data
public class UserAccountVO  extends UserAccountDO{

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    /**用户当前提现金额*/
    private Long hbCurrentCashAmount;

}
