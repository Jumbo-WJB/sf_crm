package com.shufensoft.crm.biz.domain.defined.order;

import com.shufensoft.crm.biz.domain.generation.trade.OrderJD;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/5  
 */
@Data
public class OrderJDDO extends OrderJD {

    /** 商户Id */
    private Long sellerId;

    /**
     * 是否分组
     */
    private  String  groupByClause;

    /**
     * 同个快递单号评价内容最大长度
     */
    private  long  contentLength;

    /**
     * 活动开始时间
     */
    private Date startDate;

    /**
     * 活动结束时间
     */
    private Date endDate;

    /**
     *是否限制每个快递单号领取一次
     */
    private String  isLimitPostTime;

    /**评价等级*/
    private int  score;

    /**用户id*/
    private Long  userId;

    /**状态*/
    private String status;

    /**红包领用id*/
    private Long hbObainId;

}
