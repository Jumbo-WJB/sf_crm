package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.service.dataindex.*;

import java.util.Arrays;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 15:52  
 */
public class DiInteractionTotal extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diInteractionTotal";
        this.description = "累计互动次数";
        this.dataList = Arrays.asList(DataTypeEnum.INTERACTION);
        this.platformList = Arrays.asList(PlatformEnum.WX);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        Long userInteractionDetailCount = rawData.getUserInteractionDetailCount();
        if(userInteractionDetailCount == null) {
            return  new DataIndexResult("no valid data", true);
        }

        return new DataIndexResult(userInteractionDetailCount);
    }

}
