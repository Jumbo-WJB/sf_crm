package com.shufensoft.crm.biz.dao.defined.pointMall;

import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeRankDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/4  
 */
@Repository
public interface PointExchangeRankDao {

    /**
     * 商家粉丝积分兑换排行榜, 包括被点赞的数量
     * @param params 包括参数: sellerId, exchangeMethod积分兑换的方式: goods, hongbao,
     *         userId具体到哪个用户, excludeUserId排行榜不包括哪个用户
     *         praiseEntry 点赞的入口： 红包领取排行榜：hongbao_receive_rank；积分兑换排行榜：point_exchange_rank
     * */
    public List<PointExchangeRankDo> findPointExchangeRankDoBySeller(Map<String,Object> params);

}
