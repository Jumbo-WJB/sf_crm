package com.shufensoft.crm.ruleEngine.infoUnit.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 规则配置中用到的实际对象
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/21  
 */
public class RuleDate {

    private Date currentTime;

    private String  dayOfMonth;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getCurrentTime() {

        return simpleDateFormat.format(new Date());
    }
    public int  getDayOfMonth(){
     return  Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
}
