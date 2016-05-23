package com.shufensoft.crm.biz.dao.defined.point;

import com.shufensoft.crm.biz.domain.defined.point.PointExchangeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 积分兑换DAO
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/20  
 */
@Repository
public interface PointExchangeDAO {

    /**
     * 积分兑换统计(每天的统计信息)
     * @param lastDate
     * @return
     */
    public List<PointExchangeDO> queryPointExchaneStatistics(@Param("sellerId")Long sellerId, @Param("lastDate")Date lastDate);

}
