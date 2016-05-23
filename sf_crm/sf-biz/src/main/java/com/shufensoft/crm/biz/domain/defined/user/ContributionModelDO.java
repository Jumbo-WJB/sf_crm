package com.shufensoft.crm.biz.domain.defined.user;

import lombok.Getter;
import lombok.Setter;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                  用户价值模型
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/14  
 */
public class ContributionModelDO {

    /**
     * 人数
     */
    @Getter@Setter
    private Long userCount;

    /**
     * 成为粉丝的人数
     */
    @Getter@Setter
    private Long fansCount;

    /**
     * 第一次来源
     */
    @Getter@Setter
    private String source;

    /**
     * 该平台的总人数，比如淘宝等
     */
    @Getter@Setter
    private Long count;

    /**
     * 比例
     */
    @Setter
    private double userRate;

    public double getUserRate(){

        if(this.userRate==0.0 && userCount !=0l && count !=0l){
            this.userRate  = userCount*1.0/count;
        }
        return this.userRate;
    }


}
