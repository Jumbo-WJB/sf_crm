package com.shufensoft.crm.biz.service.pointmall;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.pointmall.MallReceiverMapper;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiver;
import com.shufensoft.crm.biz.domain.generation.pointmall.MallReceiverExample;
import com.shufensoft.crm.biz.service.pointmall.vo.ReceiverVo;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *   积分商城 收件人处理  
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-23 20:04  
 */
public class MallReceiverService {

    private static final Logger logger = Logger.getLogger(MallReceiverService.class);

    @Autowired
    private MallReceiverMapper mallReceiverMapper;

    /**
     * 创建收件人
     *
     * @param sellerId
     * @param userId
     * @param receiverVo
     * @return
     */
    public boolean create(long sellerId, long userId, ReceiverVo receiverVo) {
        MallReceiver mallReceiver = null;
        try {
            mallReceiver = (MallReceiver) BeanCopierUtils.copyProperties(receiverVo, MallReceiver.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }

        mallReceiver.setUserId(userId);
        mallReceiver.setSellerId(sellerId);
        if(receiverVo.getIsDefault()) {
            mallReceiver.setIsDefault(DaoConstant.YN.YES);
        } else {
            mallReceiver.setIsDefault(DaoConstant.YN.NO);
        }

        int id = mallReceiverMapper.insert(mallReceiver);
        if(id > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改收件人
     *
     * @param sellerId
     * @param userId
     * @param receiverVo
     * @return
     */
    public boolean update(long sellerId, long userId, ReceiverVo receiverVo) {
        MallReceiver mallReceiver = null;
        try {
            mallReceiver = (MallReceiver) BeanCopierUtils.copyProperties(receiverVo, MallReceiver.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }

        MallReceiverExample mallReceiverExample = new MallReceiverExample();
        mallReceiverExample.createCriteria().andSellerIdEqualTo(sellerId).andUserIdEqualTo(userId)
                .andReceiverIdEqualTo(receiverVo.getReceiverId());
        int result = mallReceiverMapper.updateByExampleSelective(mallReceiver, mallReceiverExample);

        return result > 0;
    }

    public List<MallReceiver> list(long sellerId) {
        MallReceiverExample mallReceiverExample = new MallReceiverExample();
        mallReceiverExample.createCriteria().andSellerIdEqualTo(sellerId);
        List<MallReceiver> mallReceiverList = mallReceiverMapper.selectByExample(mallReceiverExample);

        return mallReceiverList;
    }

}
