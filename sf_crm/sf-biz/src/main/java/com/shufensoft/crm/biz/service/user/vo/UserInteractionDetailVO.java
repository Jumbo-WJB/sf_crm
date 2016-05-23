package com.shufensoft.crm.biz.service.user.vo;

import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/14  
 */
@Data
public class UserInteractionDetailVO extends UserInteractionDetail {

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     *
     */
    private  Date endDate;
}
