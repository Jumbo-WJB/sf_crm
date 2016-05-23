package com.shufensoft.crm.biz.adapter.jsonObj;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/8  
 */
@Data
@ToString
public class BuyerMessage {

    /**
     * 留言的标题
     */
    private String title;

    /**
     * 留言的内容
     */
    private String content;
}
