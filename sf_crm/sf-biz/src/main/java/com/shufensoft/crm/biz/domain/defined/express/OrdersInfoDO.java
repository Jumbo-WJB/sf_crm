package com.shufensoft.crm.biz.domain.defined.express;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/22  
 */
@Data
public class OrdersInfoDO {

    /*用户ID*/
    private Long userId;
    /*订单来源*/
    private String orderFrom;
    /*商品标题*/
    private String title;
    /*订单状态*/
    private String status;
    /*订单编号*/
    private Long orderNumber;

    /*交易编号*/
    private String tradeId;

    /*包裹的运单号*/
    private String invoiceNo;
    /*快递公司名称*/
    private String logisticsCompany;
    /**
     * 店铺Id
     */
    private Long shopId;

}
