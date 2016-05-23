package com.shufensoft.crm.biz.service.present.imple;

import com.shufensoft.crm.biz.dao.generation.present.PresentMapper;
import com.shufensoft.crm.biz.domain.generation.present.Present;
import com.shufensoft.crm.biz.domain.generation.present.PresentExample;
import com.shufensoft.crm.biz.service.present.PresentService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/24  
 */
@Service(value = "presentService")
public class PresentServiceImple implements PresentService {

    @Autowired
    private PresentMapper presentMapper;

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(PresentServiceImple.class);

    /**
     * 根据userId, goodsId获取礼物的绑定信息
     */
    @Override
    public Present findPresentByUserIdAndGoodsId(Long sellerId, Long userId, Long goodsId) {
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andGoodsIdEqualTo(goodsId).andIsReceiveEqualTo(false);
        List<Present> presents = presentMapper.selectByExample(presentExample);
        if (!CollectionUtils.isEmpty(presents)) {
            return presents.get(0);
        }
        return null;
    }

    /**
     * 查询用户礼物数量
     * @param userId
     * @param rockId
     * @return
     */
    public int queryUserPresentCountByUserIdAndRockId(Long userId,Long rockId){

        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andUserIdEqualTo(userId).andBirthdayAcivityIdEqualTo(rockId);
        List<Present> presents = presentMapper.selectByExample(presentExample);
        if (presents!=null && !presents.isEmpty()){
            return presents.size();
        }
        return 0;
    }



    /**
     * 将用户插入礼物表中，进行商品详情页授权。
     *
     * @param userId
     * @param goodsId
     * @param rockId
     * @return
     */
    @Override
    public long doTakeUpGoods(Long userId, Long goodsId, Long rockId) {

        long code = -1;

        try {
            Present present = new Present();

            present.setUserId(userId);
            present.setGoodsId(goodsId);
            present.setPresentName("摇一摇礼物");
            present.setBirthdayAcivityId(rockId);
            present.setPresentType("shake");
            present.setPresentSource("shake");
            present.setIsReceive(Boolean.FALSE);

            presentMapper.insert(present);

            code = present.getPresentId();

        } catch (Exception e) {
            logger.error("PresentService.doTakeUpGoods() is error", e);
        }

        return code;

    }


    /*
     * 校验生日折扣的暗号是否正确
     * @param userId
     * @param birthdayActivityId
     * @param secret
     * @return
     */
    @Override
    public boolean verifyDiscountSecret(Long userId, Long birthdayActivityId, String secret) {
        boolean flag = false;
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andUserIdEqualTo(userId)
                .andBirthdayAcivityIdEqualTo(birthdayActivityId);
        List<Present>  presentList = presentMapper.selectByExample(presentExample);
        if(presentList.size() > 0) {
            Present present = presentList.get(0);
            if(present.getPresentPassword().equals(secret)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 根据生日活动Id 和 用户id 查询一个 present
     *
     * @param userId
     * @param birthdayActivityId
     */
    @Override
    public Present findPresentByUserIdAndActivityId(Long sellerId, Long userId, Long birthdayActivityId) {
        AssertsUtil.check(userId != null, "userId is null");
        AssertsUtil.check(birthdayActivityId != null, "birthday activity id is null");
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andBirthdayAcivityIdEqualTo(birthdayActivityId);
        List<Present> presents = presentMapper.selectByExample(presentExample);
        if(!CollectionUtils.isEmpty(presents)){
            return presents.get(0);
        }
        return null;
    }

    /**
     * 摇一摇礼物领取成功后更新present领取状态 is_receive 字段
     *
     * @param presentId
     * @param userId
     */
    @Override
    @Transactional
    public void updateShakeGiftObtainStatus(Long presentId, Long userId) {
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andUserIdEqualTo(userId).andPresentIdEqualTo(presentId);

        Present present = new Present();
        present.setIsReceive(true);
        presentMapper.updateByExampleSelective(present,presentExample);
    }

    @Override
    public Present findPresentByUserIdAndPresentId(Long sellerId, Long userId, Long presentId) {
        PresentExample presentExample = new PresentExample();
        presentExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId).andPresentIdEqualTo(presentId);
        List<Present> presents = presentMapper.selectByExample(presentExample);
        if(!CollectionUtils.isEmpty(presents)){
            return presents.get(0);
        }
        return null;
    }

}
