package com.shufensoft.crm.biz.service.dataindex.impl;

import com.shufensoft.crm.biz.domain.generation.user.User;
import com.shufensoft.crm.biz.service.dataindex.*;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-31 15:10  
 */
public class DiIsBrandFan extends DataIndex {

    @Override
    public void setProperties() {
        this.name = "diIsBrandFan";
        this.description = "是否品牌粉丝";
        this.dataList = Arrays.asList(DataTypeEnum.USER);
        this.platformList = Arrays.asList(PlatformEnum.WX);
    }

    @Override
    public DataIndexResult compute(List<Long> userIdList, List<PlatformEnum> platformEnumList) {

        return  new DataIndexResult("no valid data", false);
    }

    @Override
    public DataIndexResult computeWithData(RawData rawData) {

        List<User> userList = rawData.getUserList();
        if(CollectionUtils.isEmpty(userList) || userList.size() > 1) {
            return  new DataIndexResult("no valid data", false);
        }

        User user = userList.get(0);

        Boolean isBrandFan = Boolean.FALSE;
        if("1".equals(user.getWxSubscribe())) {
            isBrandFan = Boolean.TRUE;
        }

        return new DataIndexResult(isBrandFan);
    }

}
