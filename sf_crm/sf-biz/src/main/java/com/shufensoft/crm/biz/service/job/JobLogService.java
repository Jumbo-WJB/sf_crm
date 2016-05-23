package com.shufensoft.crm.biz.service.job;

import com.shufensoft.crm.biz.dao.generation.job.JobLogMapper;
import com.shufensoft.crm.biz.domain.generation.job.JobLog;
import com.shufensoft.crm.biz.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/8  
 */
@Service
public class JobLogService {

    @Autowired
    private JobLogMapper jobLogMapper;

    public boolean saveJobLog(JobLog jobLog){

        if(jobLog == null){
            throw new ServiceException("JobLogService.saveJobLog","jobLog is null");
        }

        jobLogMapper.insert(jobLog);
        return true;

    }


}
