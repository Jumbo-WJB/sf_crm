package com.shufensoft.crm.biz.dao.defined.shake;

import com.shufensoft.crm.biz.domain.defined.shake.ShakeQueryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/7/17 上午10:50  
 */
@Repository
public interface ShakeQueryDAO {

    /**
     * 查询用户摇一摇明细
     * @param shakeQueryDO
     * @return
     */
    public List<ShakeQueryDO> selectUserShakeDetail(ShakeQueryDO shakeQueryDO);
}
