package com.shufensoft.crm.biz.dao.defined.point;

import com.shufensoft.crm.biz.domain.defined.point.PointMessageQueryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/6/30 上午7:25  
 */
@Repository
public interface PointMessageQueryDAO {

    /**
     * 查询用户积分查询记录
     * @param pointMessageQueryDO
     * @return
     */
    public List<PointMessageQueryDO> selectUserPointMessageQuery(PointMessageQueryDO pointMessageQueryDO);
}
