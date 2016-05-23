package com.shufensoft.crm.web.vo;

import com.shufensoft.crm.biz.service.comment.vo.CommentTaoBaoVO;
import lombok.Data;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  聚石塔评价信息VO
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/2  
 */
@Data
public class PolySpireCommentTaoBaoVO {

    private Long sellerId;

    private List<CommentTaoBaoVO> commentTaoBaos;
}
