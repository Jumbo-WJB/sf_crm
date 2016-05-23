package com.shufensoft.crm.job;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.dao.generation.user.UserInteractionDetailMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserMapper;
import com.shufensoft.crm.biz.dao.generation.user.UserPortraitMapper;
import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import com.shufensoft.crm.biz.domain.generation.user.*;
import com.shufensoft.crm.biz.service.dataindex.DataIndexService;
import com.shufensoft.crm.biz.service.user.vo.UserPortraitVO;
import com.shufensoft.crm.common.utils.BeanCopierUtils;
import com.shufensoft.crm.constant.JobConstant;
import com.shufensoft.crm.job.base.SyncDataJob;
import com.shufensoft.crm.job.context.JobContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 微信用户价值计算
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/8/27  
 */
public class WxUserDataAnalysisJob extends SyncDataJob{

    private static final Logger logger = Logger.getLogger(WxUserDataAnalysisJob.class);

    @Autowired
    private UserPortraitMapper userPortraitMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInteractionDetailMapper userInteractionDetailMapper;

    @Autowired
    private DataIndexService dataIndexService;

    @Override
    public String jobName() {
        return JobConstant.JobName.WX_USER_DATA_ANALYSIS_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        SellerConfigInfo sellerConfigInfo = jobContext.getSellerConfigInfo();

        Date startDate = this.getStartDate();

        Date endDate = this.getEndDate();

        /**
         * 分页处理微信数据
         */
        pageProcessDataWx(sellerConfigInfo.getSellerId(), startDate, endDate);
    }

    /**
     * 分页计算微信用户价值
     *
     * @param sellerId
     * @param startDate
     * @param endDate
     */
    private void pageProcessDataWx(long sellerId, Date startDate, Date endDate) {

        int start = 1;

        while (true) {

            try {

                PageHelper.startPage(start, pageSize);
                UserInteractionDetailExample userInteractionDetailExample = new UserInteractionDetailExample();
                userInteractionDetailExample.createCriteria().andSellerIdEqualTo(sellerId).andGmtModifiedBetween(startDate, endDate);
                userInteractionDetailExample.setDefinedQueryColumns(true);
                userInteractionDetailExample.addUserIdQueryColumn();
                userInteractionDetailExample.setDistinct(true);
                List<UserInteractionDetail> userInteractionDetailList = userInteractionDetailMapper.selectByExample(userInteractionDetailExample);

                if (CollectionUtils.isEmpty(userInteractionDetailList) || userInteractionDetailList.get(0).getUserId() == null) {
                    break;
                }

                for(UserInteractionDetail userInteractionDetail : userInteractionDetailList){

                    User user = new User();
                    user.setSellerId(sellerId);
                    user.setUserId(userInteractionDetail.getUserId());
                    handleWxUser(user);

                }


            } catch (Exception e) {
                String messge = e.getMessage() == null ? e.toString() : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error, errorMag: " + messge, e);
                saveJobLog(messge);
            }

            start++;
        }
    }

    /**
     * 微信用户价值计算
     * @param user
     * @throws Exception
     */
    private void handleWxUser(User user) throws Exception {

        UserPortraitVO userPortraitVo = dataIndexService.calculate(user);

        Long userPortraitId;

        UserPortrait userPortrait = (UserPortrait) BeanCopierUtils.copyProperties(userPortraitVo, UserPortrait.class);
        if(userPortrait == null){
            userPortrait = new UserPortrait();
            userPortrait.setSellerId(user.getSellerId());
        }

        userPortraitId = user.getUserPortraitId();
        if (userPortraitId == null || userPortraitId <= 0) {
            userPortraitMapper.insertSelective(userPortrait);
            userPortraitId = userPortrait.getUserPortraitId();
        } else {
            UserPortraitExample userPortraitExample = new UserPortraitExample();
            userPortraitExample.createCriteria().andUserPortraitIdEqualTo(userPortraitId);
            userPortraitMapper.updateByExampleSelective(userPortrait, userPortraitExample);
        }

        if (user.getUserPortraitId() == null || user.getUserPortraitId() <= 0) {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(user.getUserId());

            User userUpdate = new User();
            userUpdate.setUserPortraitId(userPortraitId);
            int updateResult = userMapper.updateByExampleSelective(userUpdate, userExample);
            if (updateResult == 0) {
                logger.error("update userPortrait fail: " + user.toString());
            }
        }
    }


}
