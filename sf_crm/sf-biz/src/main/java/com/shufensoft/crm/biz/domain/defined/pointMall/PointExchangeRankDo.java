package com.shufensoft.crm.biz.domain.defined.pointMall;

import lombok.Data;
import lombok.ToString;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 *     积分兑换排行榜的实体Do, 包括用户微信图像,姓名, 累计兑换商品消耗积分,获得的赞总数
 * </p>
 *  @author: lin
 *  @date: 2015/7/4  
 */
@Data
@ToString
public class PointExchangeRankDo {

    private Long sellerId;

    private Long userId;

    private String wxImgUrl;

    /** 用户姓名 **/
    private String name;

    /** 用户微信昵称 **/
    private String wxNickName;

    /** 累计兑换商品消耗积分 */
    private int pointExchangeTotal;

    /** 累计获得的赞 */
    private int zanTotal = 0;

    /**
     *  排行名次
     * */
    private Long rank;

}
