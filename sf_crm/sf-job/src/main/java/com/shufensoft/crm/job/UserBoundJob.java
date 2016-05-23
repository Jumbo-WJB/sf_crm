package com.shufensoft.crm.job;

import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.user.UserBoundMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.domain.generation.user.UserBound;
import com.shufensoft.crm.biz.domain.generation.user.UserBoundExample;
import com.shufensoft.crm.biz.domain.generation.user.UserExample;
import com.shufensoft.crm.biz.service.user.UserBoundResponse;
import com.shufensoft.crm.biz.service.user.UserBoundService;
import com.shufensoft.crm.common.utils.AssertsUtil;
import com.shufensoft.crm.common.utils.MathUtil;
import com.shufensoft.crm.job.base.AsyncJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *   对于已经绑定好的用户，有新的交易数据进来，需要重新计算绑定
 *
 *  @ProjectName: sf-crm  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-07-15 17:50  
 */
public class UserBoundJob extends AsyncJob {

    private static final Logger logger = Logger.getLogger(UserBoundJob.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBoundMapper userBoundMapper;

    @Autowired
    private UserBoundService userBoundService;

    @Override
    public String jobName() {
        return "userBoundJob";
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void execute(JobContext jobContext) {

        long sellerId = jobContext.getSellerConfigInfo().getSellerId();
        long startTime = System.currentTimeMillis();
        if(logger.isInfoEnabled()) {
            logger.info("UserBoundJob starts.");
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsVerifyEqualTo(DaoConstant.IsVerify.YES);
        userExample.setDefinedQueryColumns(true);
        userExample.addMinIdQueryColumn();
        userExample.addMaxIdQueryColumn();
        List<User> userStatList = userMapper.selectByExample(userExample);
        AssertsUtil.check(userStatList != null && userStatList.size() > 0, "invalid user data");

        User userStat = userStatList.get(0);
        Long minId = userStat.getMinId();
        Long maxId = userStat.getMaxId();

        long startId = minId;
        long endId = minId + 1000;
        while(true) {
            userExample = new UserExample();
            userExample.createCriteria().andIsVerifyEqualTo(DaoConstant.IsVerify.YES).andIdGreaterThanOrEqualTo(startId)
                    .andIdLessThan(endId);
            List<User> userList = userMapper.selectByExample(userExample);

            for(User user : userList) {
                UserBoundExample userBoundExample = new UserBoundExample();
                userBoundExample.createCriteria().andUserIdEqualTo(user.getUserId());
                userBoundExample.setOrderByClause("gmt_created desc");
                List<UserBound> userBoundList = userBoundMapper.selectByExample(userBoundExample);
                if(CollectionUtils.isEmpty(userBoundList)) {
                    continue;
                }

                UserBound userBound = userBoundList.get(0);
                if(StringUtils.isNotEmpty(userBound.getTbId()) || StringUtils.isNotEmpty(userBound.getJdId())) {
                    continue;
                }

                if(MathUtil.isPositive(userBound.getUserIdTb()) || MathUtil.isPositive(userBound.getUserIdJd())) {
                    UserBoundResponse userBoundResponse = userBoundService.bind(sellerId, user.getUserId(),
                            userBound.getMobile(), null, null);
                    if(userBoundResponse.isSuccess()) {
                        if(logger.isInfoEnabled()) {
                            logger.info("user bound again: " + user.getUserId());
                        }
                    } else {
                        if(logger.isInfoEnabled()) {
                            logger.info("user bound ehcecked: " + user.getUserId());
                        }
                    }
                }
            }

            if(endId > maxId) {
                break;
            } else {
                startId = startId + 1000;
                endId = endId + 1000;
            }

            if(logger.isInfoEnabled()) {
                logger.info("completed percent: " + ((endId - minId) / ((maxId - minId) * 100d)) + "%");
            }
        }

        if(logger.isInfoEnabled()) {
            logger.info("UserBoundJob end, timecost: " + (System.currentTimeMillis() - startTime));
        }
    }
}

