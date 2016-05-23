package com.shufensoft.crm.biz.service.activity;

import com.shufensoft.crm.biz.domain.generation.activity.Activity;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p></p>
 *  @author chenyong  chenyong@suniusoft.com
 *  @date 2015/10/9  
 */
public interface ActivityService {

    /**
     * 根据活动id获取活动详细信息
     * @param activityId
     * @return
     */
    public Activity getActivityByActivityId(Long sellerId,Long  activityId);

    /**
     * 获取活动列表
     * @param activity
     * @return
     */
    public List<Activity> getActivityList(Activity activity);
}
