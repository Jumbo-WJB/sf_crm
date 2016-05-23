package com.shufensoft.crm.job.hongbao;

import com.github.pagehelper.PageHelper;
import com.shufensoft.crm.biz.constant.DaoConstant;
import com.shufensoft.crm.biz.dao.generation.hongbao.HBObtainMapper;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtain;
import com.shufensoft.crm.biz.domain.generation.hongbao.HBObtainExample;
import com.shufensoft.crm.biz.service.hongbao.HongbaoService;
import com.shufensoft.crm.common.utils.DateUtil;
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
 *  @Description: <p>将领用未拆的红包记录返回定时任务</p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/7/19  
 */
public class HbReturnJob extends SyncDataJob {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(HbReturnJob.class);

    /**
     * 设置失效时间,默认30分钟
     */
    private static final int INVALID_TIME = 30;

    @Autowired
    private HBObtainMapper hbObtainMapper;

    @Autowired
    private HongbaoService hongbaoService;

    @Override
    public String jobName() {
        return JobConstant.JobName.HBRETURN_JOB;
    }

    @Override
    public boolean isChangeDataSoure() {
        return true;
    }

    @Override
    public void _execute(JobContext jobContext) {

        syncHbReturn(jobContext);

    }

    public void syncHbReturn(JobContext jobContext) {

        Date startDate = this.getStartDate();
        Date endDate = this.getEndDate();
        Long sellerId = jobContext.getSellerConfigInfo().getSellerId();

        HBObtainExample hbObtainExample = new HBObtainExample();
        hbObtainExample.createCriteria().andHongbaoTypeEqualTo(DaoConstant.HongBaoType.SHAKE).andStatusEqualTo(DaoConstant.HBStatus.TO_RECEIVE).andUserIdIsNotNull().andGmtModifiedLessThanOrEqualTo(DateUtil.getExpiredMinute(-INVALID_TIME)).andSellerIdEqualTo(sellerId);

        /**
         * 分页处理,将超过失效时间的红包领用未拆记录解除用户绑定
         */
        int start = 1;
        while (true) {

            try {
                PageHelper.startPage(start, pageSize);
                List<HBObtain> hbObtains = hbObtainMapper.selectByExample(hbObtainExample);

                if (CollectionUtils.isEmpty(hbObtains)) {
                    return;
                }

                for (HBObtain hbObtain : hbObtains) {

                        hbObtain.setUserId(null);
                        hbObtain.setObtainDatatime(null);
                        hongbaoService.updateHbObtainAndPool(sellerId, hbObtain);

                }
                start++;
            } catch (Exception e) {
                String messge = e.getMessage() == null ? " Null Pointer Exception" : e.getMessage();
                logger.error(jobName == null ? "job" : jobName + " execute error,errorMag:" + messge, e);

                saveJobLog(messge);

            }

        }

    }


}



