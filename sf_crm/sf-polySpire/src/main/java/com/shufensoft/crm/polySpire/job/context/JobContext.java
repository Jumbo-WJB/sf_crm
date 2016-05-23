package com.shufensoft.crm.polySpire.job.context;

import com.shufensoft.crm.biz.domain.generation.seller.SellerConfigInfo;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: <p>
 *                 job 上下文
 *                </p>
 *  @author litu  litu@shufensoft.com
 *  @date 2015/6/14  
 */
@Data
public class JobContext {


    public interface JobContextKey{

        public static final String START_DATE = "startDate";
        public static final String END_DATE = "endDate";
        public static final String INTERVAL_TIME = "intervalTime";
        public static final String SHOP_ID = "shopId";

    }

    private SellerConfigInfo sellerConfigInfo;

    private Map<String,Object> contextMap = new HashMap<String, Object>();

    public void put(String key, Object obj){
        contextMap.put(key,obj);
    }

    public Object get(String key){
        return contextMap.get(key);
    }

}
