package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.user.UserInteractionDetail;
import com.shufensoft.crm.biz.service.dataindex.*;
import com.shufensoft.crm.common.utils.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *  
 *
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 16:30  
 */
public class DiLiveness extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diLiveness";
        this.description = "活跃度";
        this.dataList = Arrays.asList(DataTypeEnum.INTERACTION);
        this.platformList = Arrays.asList(PlatformEnum.WX);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        List<UserInteractionDetail> userInteractionDetailList = rawData.getUserInteractionDetailList();
        if(userInteractionDetailList == null) {
            return new DataIndexResult("no valid data", true);
        }

        long livenessScore = 0L;
        for(UserInteractionDetail userInteractionDetail : userInteractionDetailList) {
            Date interactionTime = userInteractionDetail.getInteractionTime();
            int days = DateUtil.getBetweenDays(interactionTime);

            int score = 0;
            if(days < 10) {
                score = 100;
            } else if(days < 30) {
                score = 80;
            } else if(days < 60) {
                score = 60;
            } else if(days < 100) {
                score = 40;
            } else if(days < 180) {
                score = 20;
            } else {
                score = 10;
            }

            livenessScore += score;
        }

        // 活跃度指标分为无星，一星，二星，三星，按不同的得分，以区间区分
        int result = 0;
        if(livenessScore == 0) {
            result = 0;
        } else if(livenessScore < 20) {
            result = 1;
        } else if(livenessScore < 100) {
            result = 2;
        } else {
            result = 3;
        }

        return new DataIndexResult(result);
    }

}
