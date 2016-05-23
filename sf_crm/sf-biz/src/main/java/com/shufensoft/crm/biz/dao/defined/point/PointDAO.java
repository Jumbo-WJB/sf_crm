package com.shufensoft.crm.biz.dao.defined.point;

import com.shufensoft.crm.biz.domain.defined.point.PointMultipleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 积分DAO
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/25 下午8:35  
 */
@Repository
public interface PointDAO {


    /**
     * 积分明细查询
     * @param pointMultipleDO
     * @return
     */
    public List<PointMultipleDO> selectUserPointDetails(PointMultipleDO pointMultipleDO);



}
