package com.shufensoft.crm.biz.dao.defined.marketActivity;

import com.shufensoft.crm.biz.domain.defined.marketActivity.MarketRecordsDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义dao层接口（营销活动）
 * Created by yuyuchi on 2015/6/15.
 */
@Repository
public interface MarketRecordsDAO {

    //联合查询营销活动
    public List<MarketRecordsDO> queryActivity(MarketRecordsDO records);

    /**
     * 查询本月商家群发微信消息的次数
     * @param sellerId
     * @return
     */
    public Integer countMonthWxMassTimes(Long sellerId);
}
