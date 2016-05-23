package com.shufensoft.crm.biz.service.hongbao.impl;

import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBPoolMapper;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPool;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBPoolExample;
import com.shufensoft.crm.biz.service.hongbao.HongBaoBizService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author zoujian  zoujian@suniusoft.com
 *  @date 15/9/21 下午11:54  
 */
@Service
public class HongBaoBizServiceImpl implements HongBaoBizService {

    /**
     * logger
     */
    public static final Logger logger = Logger.getLogger(HongBaoBizServiceImpl.class);

    @Autowired
    private HBObtainMapper hBObtainMapper;

    @Autowired
    private HBPoolMapper hBPoolMapper;

    @Autowired
    private HBObtainMapper hbObtainMapper;

    /**
     * 用户是否已绑定红包池中的记录
     *
     * @param sellerId 商户ID
     * @param userId   用户ID
     * @param hbObtainId 获取ID
     * @return
     */
    public boolean isHbObtainByUserIdAndObtainId(Long sellerId, Long userId, Long hbObtainId) {
        HBObtainExample hbObtainExample = new HBObtainExample();
        HBObtainExample.Criteria criteria = hbObtainExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andUserIdEqualTo(userId);
        criteria.andHongbaoObtainIdEqualTo(hbObtainId);

        List<HBObtain> hbObtainList = hBObtainMapper.selectByExample(hbObtainExample);
        if (hbObtainList != null && !hbObtainList.isEmpty()) {
            return true;
        }

        return false;

    }

    /**
     * 根据红包池ID更新红包池状态
     *
     * @param sellerId 商户ID
     * @param hbPoolId 红包池ID
     * @return
     */
    public int updateHbObtainStatusByHbPollId(Long sellerId, Long hbPoolId, String status) {

        int code = -1;
        HBPoolExample hbPoolExample = new HBPoolExample();
        HBPoolExample.Criteria criteria = hbPoolExample.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andPoolIdEqualTo(hbPoolId);

        HBPool hbPool = new HBPool();

        hbPool.setStates(status);

        try {
            code = hBPoolMapper.updateByExampleSelective(hbPool, hbPoolExample);
        } catch (Exception e) {
            logger.error("updateHbObtainStatusByHbPollId is error.", e);
        }

        return code;

    }

    /**
     * @param obtainId
     */
    @Override
    public HBObtain findHBObtainByObtainId(Long obtainId, Long sellerId) {
        HBObtainExample example = new HBObtainExample();
        example.createCriteria().andHongbaoObtainIdEqualTo(obtainId).andSellerIdEqualTo(sellerId);
        List<HBObtain> hbObtains = hbObtainMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(hbObtains)) {
            return hbObtains.get(0);
        }
        return null;
    }
}
