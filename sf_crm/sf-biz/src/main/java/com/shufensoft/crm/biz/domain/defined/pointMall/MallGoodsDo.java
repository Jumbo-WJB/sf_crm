package com.shufensoft.crm.biz.domain.defined.pointMall;

import com.shufensoft.crm.biz.domain.generation.pointmall.MallGoods;
import lombok.Data;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/9  
 */
@Data
public class MallGoodsDo extends MallGoods {

    private String categoryName;

    private String startDate;

    private String endDate;

}
