package com.shufensoft.crm.biz.service.hongbao;

import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/9/21 下午11:54  
 */
public interface HongBaoBizService {

    /**
     * 根据红包池ID更新红包池状态
     *
     * @param sellerId 商户ID
     * @param hbPoolId 红包池ID
     * @return
     */
    public int updateHbObtainStatusByHbPollId(Long sellerId, Long hbPoolId, String status);

    /**
     * 用户是否已绑定红包池中的记录
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param hbObtainId 获取ID
     * @return
     */
    public boolean isHbObtainByUserIdAndObtainId(Long sellerId, Long userId, Long hbObtainId);

    /**
     * @param obtainId
     */
    public HBObtain findHBObtainByObtainId(Long obtainId,Long  sellerId);
}
