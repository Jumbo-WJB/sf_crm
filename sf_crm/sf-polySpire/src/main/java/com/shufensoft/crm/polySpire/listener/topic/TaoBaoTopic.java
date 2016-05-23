package com.shufensoft.crm.polySpire.listener.topic;

import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 淘宝TOPIC
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/27  
 */
@Data
public class TaoBaoTopic {

    private String topic;

    private String buyer_nick;

    private String payment;

    private Long oid;

    private Long tid;

    private String type;

    private String seller_nick;


}
