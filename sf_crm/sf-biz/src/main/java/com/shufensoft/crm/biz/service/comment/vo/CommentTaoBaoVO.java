package com.shufensoft.crm.biz.service.comment.vo;


import com.shufensoft.crm.biz.domain.generation.comment.CommentTaoBao;
import lombok.Data;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 淘宝评价VO
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/25  
 */
@Data
public class CommentTaoBaoVO extends CommentTaoBao {

    /** 商户Id */
    private Long sellerId;


    /**
     * 开始时间
     */
      private Date startDate;

    /**
     * 结束时间
     */
     private Date endDate;



}
