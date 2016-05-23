package com.shufensoft.crm.biz.service.trade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shufensoft.crm.biz.dao.defined.trade.TradeDAO;
import com.shufensoft.crm.biz.domain.defined.trade.TradeDO;
import com.shufensoft.crm.biz.exception.ServiceException;
import com.shufensoft.crm.biz.service.trade.vo.TradeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 交易接口（整合所有平台的交易）
 *               </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/29  
 */
@Service
public class TradeService {


    @Autowired
    private TradeDAO tradeDAO;

    /**
     * 获取平台订单数据
     * @param tradeVO
     * @param pageNum
     * @param length
     * @return
     */
    public PageInfo selectTradeFromAll(TradeVO tradeVO, Integer pageNum, Integer length){

        if (tradeVO.getSellerId() == null){
            throw new ServiceException("sellerId Can't be null");
        }

        PageHelper.startPage(pageNum,length);

        List<TradeDO> tradeDOList =  tradeDAO.selectTradeFromAll(tradeVO);

        for (TradeDO trade : tradeDOList){
            trade.setShopName(null);
        }

        return new PageInfo(tradeDOList);

    }

}
