package com.shufensoft.crm.biz.comparator;

import com.shufensoft.crm.biz.vo.PointExchangeVO;

import java.util.Comparator;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 积分兑换对象比较（按day比较）
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/7/21  
 */
public class PointExchangeComparator implements Comparator<PointExchangeVO> {

    @Override
    public int compare(PointExchangeVO o1, PointExchangeVO o2) {
        String peDay1 = o1.getDay();
        String peDay2 = o2.getDay();
        return  peDay1.compareTo(peDay2);
    }
}
