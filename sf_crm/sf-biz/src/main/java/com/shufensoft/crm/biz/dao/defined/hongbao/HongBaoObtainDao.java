package com.shufensoft.crm.biz.dao.defined.hongbao;

import com.shufensoft.crm.biz.domain.defined.hongbao.HBObtainDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/14  
 */
@Repository
public interface HongBaoObtainDao {

    /**
     *  @param params poolId
     *  用户积分能兑换的最大红包金额
     *  找出用户积分兑换的最大面额红包
     * */
    public List<HBObtain> findHBObtain(Map<String,Object> params);

    /**
     * 获取用户领用信息明细
     * @param hbObtainDO
     * @return
     */
    public List<HBObtainDO> getHBObtainWithUser(HBObtainDO hbObtainDO);


}
