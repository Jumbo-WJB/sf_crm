package com.shufensoft.crm.biz.service.job;

import com.shufensoft.crm.biz.dao.generation.job.JobDetailMapper;
import com.shufensoft.crm.biz.domain.generation.job.JobDetail;
import com.shufensoft.crm.biz.domain.generation.job.JobDetailExample;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.common.utils.AssertsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
@Service
public class JobDetailService {

    @Autowired
    private JobDetailMapper jobDetailMapper;

    public JobDetail findJobDetailByName(Long sellerId, Long shopId, String jobName){

        AssertsUtil.notNull(jobName,"jobName");

        JobDetailExample jobDetailExample = new JobDetailExample();
        JobDetailExample.Criteria criteria = jobDetailExample.createCriteria().andJobNameEqualTo(jobName);

        if(sellerId != null){
            criteria.andSellerIdEqualTo(sellerId);
        }

        if(shopId != null){
            criteria.andShopIdEqualTo(shopId);
        }

        List<JobDetail> jobDetailList = jobDetailMapper.selectByExample(jobDetailExample);
        if(!CollectionUtils.isEmpty(jobDetailList)){
            return jobDetailList.get(0);

        }

        return null;
    }

    /**
     * 保存或更新交易信息
     * @param jobDetail
     * @return
     */
    public boolean saveOrUpdateJobDetail(JobDetail jobDetail){

        if(jobDetail == null){
            throw new ServiceException("JobDetailService.saveOrUpdateJobDetail", "jobDetail is null");
        }

        JobDetailExample jobDetailExample = new JobDetailExample();
        JobDetailExample.Criteria criteria = jobDetailExample.createCriteria().andJobNameEqualTo(jobDetail.getJobName());

        if(jobDetail.getShopId() != null){
            criteria.andShopIdEqualTo(jobDetail.getShopId());
        }

        if(jobDetail.getSellerId() != null){
            criteria.andSellerIdEqualTo(jobDetail.getSellerId());
        }

        List<JobDetail> jobDetails = jobDetailMapper.selectByExample(jobDetailExample);
        if(CollectionUtils.isEmpty(jobDetails)){
            jobDetailMapper.insert(jobDetail);
        }else{
            jobDetail.setId(jobDetails.get(0).getId());
            return jobDetailMapper.updateByPrimaryKeySelective(jobDetail)>0;
        }

        return true;

    }


}
