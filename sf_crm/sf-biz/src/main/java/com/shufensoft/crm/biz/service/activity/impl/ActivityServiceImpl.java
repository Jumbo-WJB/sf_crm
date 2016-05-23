package com.shufensoft.crm.biz.service.activity.impl;

import com.shufensoft.crm.biz.dao.generation.activity.ActivityMapper;
import com.shufensoft.crm.biz.domain.generation.activity.Activity;
import com.shufensoft.crm.biz.domain.generation.activity.ActivityExample;
import com.shufensoft.crm.biz.service.activity.ActivityService;
import com.shufensoft.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/10/9  
 */
@Service(value = "activityServcie")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Activity getActivityByActivityId(Long sellerId,Long activityId) {

        ActivityExample activityExample = new ActivityExample();
        activityExample.createCriteria().andActivityIdEqualTo(activityId).andSellerIdEqualTo(sellerId);
        List<Activity> activityList = activityMapper.selectByExample(activityExample);

        return activityList.isEmpty() ? new Activity() : activityList.get(0);
    }

    @Override
    public List<Activity> getActivityList(Activity activity) {

        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();

        if (activity.getActivityId() != null) {
            criteria.andActivityIdEqualTo(activity.getActivityId());
        }
        if(activity.getSellerId()!=null){
            criteria.andSellerIdEqualTo(activity.getSellerId());
        }
        if (StringUtils.isNotBlank(activity.getActivityType())) {
            criteria.andActivityTypeEqualTo(activity.getActivityType());
        }

        return activityMapper.selectByExample(activityExample);
    }

}
