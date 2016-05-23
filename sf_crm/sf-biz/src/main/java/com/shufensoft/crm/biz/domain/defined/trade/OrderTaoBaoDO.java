package com.shufensoft.crm.biz.domain.defined.trade;

import com.shufensoft.crm.biz.domain.generation.trade.OrderTaoBao;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>淘宝订单DO</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/6/20  
 */
@Data
public class OrderTaoBaoDO extends OrderTaoBao{

    /** 商户Id */
    private Long sellerId;

    /**
     * 是否分组
     */
    private  String  groupByClause;

    /**
     * 同个快递单号评价内容最大长度
     */
    private   long   contentLength;

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

    /**
     * 快递公司拼音码
     */
    private String sampleName;

    /**辅助进行技术数量的字段*/
    private Long count;

    /**评价类型*/
    private String  result;

    /**用户id*/
    private Long  userId;

    /**状态*/
    private String status;

    /**红包领用id*/
    private Long hbObainId;

}
