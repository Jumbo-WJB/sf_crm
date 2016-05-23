package com.shufensoft.crm.biz.service.trade.vo;

import com.shufensoft.crm.biz.domain.defined.trade.TradeDO;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 * </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/29  
 */
public class TradeVO extends TradeDO {

    private Integer lastDays;

    public void setLastDays(Integer lastDays){

        if(lastDays!=null){
            Date lastDate = DateUtils.addDays(new Date(),-lastDays);
            setCreated(lastDate);
        }
    }
}
