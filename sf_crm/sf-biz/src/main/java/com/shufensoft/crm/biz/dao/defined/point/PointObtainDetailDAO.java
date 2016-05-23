package com.shufensoft.crm.biz.dao.defined.point;

import com.shufensoft.crm.biz.domain.defined.point.PointDetailDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 积分DAO
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/25 下午8:35  
 */
@Repository
public interface PointObtainDetailDAO {



    /**
     * 积分获取明细查询
     * @param pointObtainDetailDO
     * @return
     */
    public List<PointDetailDO> selectPointObtainDetails(PointDetailDO pointObtainDetailDO);

    /**
     * 积分兑换明细查询
     * @param pointObtainDetailDO
     * @return
     */
    public List<PointDetailDO> selectPointExchangeDetails(PointDetailDO pointObtainDetailDO);

    /**
     *
     * */
    public List<PointDetailDO> findPointObtainDetails(Map<String,Object> params);


}
