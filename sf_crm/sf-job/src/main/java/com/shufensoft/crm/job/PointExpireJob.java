package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.point.PointObtainMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserAccountMapper;
import com.shufensoft.crm.biz.domain.generation.point.PointObtain;
import com.shufensoft.crm.biz.domain.generation.point.PointObtainExample;
import com.shufensoft.crm.biz.domain.generation.user.UserAccount;
import com.shufensoft.crm.biz.domain.generation.user.UserAccountExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.job.base.AsyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *  积分过期任务
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-22 18:39  
 */
public class PointExpireJob extends AsyncJob {

    private static final Logger logger = Logger.getLogger(PointExpireJob.class);

    @Autowired
    private PointObtainMapper pointObtainMapper;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public String jobName() {
        return "pointExpireJob";
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    public void execute(JobContext jobContext)  {

        long startTime = System.currentTimeMillis();
        if(logger.isInfoEnabled()) {
            logger.info("Point Expire Job starts");
        }

        // 获取已经过期的积分
        PointObtainExample pointObtainExample = new PointObtainExample();
        pointObtainExample.createCriteria().andGmtExpiredLessThan(new Date()).andStatusEqualTo(DaoConstant.Status.VALID);
        List<PointObtain> pointObtainList = pointObtainMapper.selectByExample(pointObtainExample);
        if(CollectionUtils.isEmpty(pointObtainList)) {
            logger.info("no expired pointmall found");
            return;
        }

        // 修改积分账户
        for(PointObtain pointObtain : pointObtainList) {
            if(logger.isInfoEnabled()) {
                logger.info("expired point process: " + pointObtain.getSellerId() + ", " + pointObtain.getUserId()
                        + ", " + pointObtain.getId());
            }

            handleExpire(pointObtain);
        }

        if(logger.isInfoEnabled()) {
            logger.info("Point Expire Job ends, timecost: " + (System.currentTimeMillis() - startTime));
        }
    }

    @Transactional
    public void handleExpire(PointObtain pointObtain) {
        if(pointObtain.getSellerId() <= 0 || pointObtain.getUserId() <= 0 || pointObtain.getAmount() <= 0
                || pointObtain.getId() <= 0) {
            logger.error("illegal argument: " + pointObtain.toString());
            return;
        }

        // update user_account set gmt_modified = now(), point_amount_expired += ?, point_amount -= ? where seller_id = ? and user_id = ?
        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andSellerIdEqualTo(pointObtain.getSellerId()).andUserIdEqualTo(pointObtain.getUserId());
        UserAccount userAccount = new UserAccount();
        userAccount.setPointAmountExpiredExpression("point_amount_expired + " + pointObtain.getAmount());
        userAccount.setPointAmountExpression("point_amount - " + pointObtain.getAmount());
        int updateResult = userAccountMapper.updateByExampleSelective(userAccount, userAccountExample);
        if(updateResult != 1) {
            logger.error("userAccount update fail: " + pointObtain.getSellerId() + ", " + pointObtain.getUserId());
            throw new ServiceException("userAccount update fail: " + pointObtain.getSellerId() + ", " + pointObtain.getUserId());
        }

        // update point_obtain set gmt_modified = now(), status = 'n' where id = ?
        PointObtainExample pointObtainExample = new PointObtainExample();
        pointObtainExample.createCriteria().andIdEqualTo(pointObtain.getId());
        PointObtain updatePointObtain = new PointObtain();
        updatePointObtain.setStatus(DaoConstant.Status.INVALID);
        updateResult = pointObtainMapper.updateByExampleSelective(updatePointObtain, pointObtainExample);
        if(updateResult != 1) {
            logger.error("pointObtain update fail: " + pointObtain.getSellerId() + ", " + pointObtain.getId());
            throw new ServiceException("pointObtain update fail: " + pointObtain.getSellerId() + ", " + pointObtain.getId());
        }
    }

}
