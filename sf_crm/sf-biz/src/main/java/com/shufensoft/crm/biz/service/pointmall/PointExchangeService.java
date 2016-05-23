package com.shufensoft.crm.biz.service.pointmall;

import com.shufensoft.crm.biz.dao.defined.pointMall.PointExchangeStaticsDao;
import com.shufensoft.crm.biz.dao.generation.point.PointExchangeMapper;
import com.shufensoft.crm.biz.domain.defined.pointMall.PointExchangeStaticsDo;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointExchange;
import com.shufensoft.crm.biz.domain.generation.point.PointExchangeExample;
import com.shufensoft.crm.biz.service.hongbao.HongBaoObtainService;
import com.shufensoft.crm.biz.service.pointmall.face.IPointExchangeService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/29  
 */

@Service(value = "pointExchangeService")
    public class PointExchangeService implements IPointExchangeService{

    @Autowired
    private PointExchangeMapper pointExchangeMapper;

    @Autowired
    private PointExchangeStaticsDao pointExchangeStaticsDao;

    @Resource(name="hongBaoObtainService")
    private HongBaoObtainService hongBaoObtainService;
    /**
     * @param userId
     * @param exchangeId  兑换红包就是HBObtainId, 兑换商品就是mallOrderId
     * @param status   成功success,失败fail,过期expire(积分兑换红包过期) 兑换完over(积分兑换红包),待兑换 wait_exchange(积分兑换红包)
     */
    @Override
    @Transactional
    public int updateStatus(Long userId, Long exchangeId, String status,Long sellerId) {

        AssertsUtil.check(userId != null,"userId is null");
        AssertsUtil.check(exchangeId != null,"exchangeId is null");
        AssertsUtil.check(StringUtils.isNotBlank(status),"status is null");
        HBObtain hbObtain = hongBaoObtainService.findHBObtainByObtainId(exchangeId,sellerId);
        PointExchange pointExchange = new PointExchange();
        pointExchange.setStatus(status);
        if(hbObtain != null) {
            pointExchange.setExchangePresentAmount(hbObtain.getAmount());
        }
        PointExchangeExample pointExchangeExample = new PointExchangeExample();
        pointExchangeExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andExchangeIdEqualTo(exchangeId);
        int result = pointExchangeMapper.updateByExampleSelective(pointExchange,pointExchangeExample);
        return result;
    }

    /**
     * 统计用户积分兑换商品, 红包消耗的积分数
     *
     * @param userId
     * @param sellerId
     */
    @Override
    public PointExchangeStaticsDo findPointExchangeStaticsDoByUserId(Long sellerId, Long userId) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("sellerId", sellerId);
        params.put("userId", userId);
        return pointExchangeStaticsDao.findPointExchangeStaticsByUserId(params);
    }

}
