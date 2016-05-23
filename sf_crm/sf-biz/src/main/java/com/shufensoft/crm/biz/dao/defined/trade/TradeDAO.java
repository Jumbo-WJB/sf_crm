package com.shufensoft.crm.biz.dao.defined.trade;

import com.shufensoft.crm.biz.domain.defined.trade.TradeDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeDAO {

    /**
     * 获取平台订单数据
     * @param tradeDO
     * @return
     */
    List<TradeDO> selectTradeFromAll(TradeDO tradeDO);

}