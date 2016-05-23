package com.shufensoft.crm.biz.dao.defined.hongbao;

import com.shufensoft.crm.biz.domain.defined.hongbao.HBPoolDO;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/6/24  
 */
@Repository
public interface HBPoolDAO {
    /**
     * 更新红包活动(默认条件number>number_obtain)
     * @param record
     * @param example
     * @return
     */
    int updateByNumberExampleSelective(@Param("record") HBPool record, @Param("example") HBPoolExample example);

    /**
     *  查找某个商家在某个时间段没有领完的红包活动
     *  可以按照红包活动类型查询
     * */
    public List<HBPool> findValidHbPoolBySellerId(HBPoolDO hbPoolDO);


}
